# Multijoueur — synthèse et revue de code

> **Plain-English walkthrough** (what each multiplayer feature is *for* — no
> jargon). The reversed game's multiplayer, feature by feature:
>
> - **Connect + token (bouncer with a ticket).** On launch the client connects
>   and sends an auth token + game ID; the server validates, then sends the
>   initial match state. On disconnect the game cleans up and leaves the arena.
>   *Purpose: keep strangers out of matches and know which match you're in.*
> - **Kryo registry (speaking fast).** Client and server share 100+ registered
>   types, so packets carry tiny numeric IDs instead of class names.
>   *Purpose: packets small enough to fly 20 times a second.*
> - **The mailbox (never block the game).** The network thread drops packets
>   into a thread-safe queue; the render thread picks them up at its own pace.
>   *Purpose: a 200 ms network stall never freezes your frame — the game
>   catches up afterwards.*
> - **Bundled packets (one parcel per tick).** Health + position + mana +
>   effects go out as a single `PlayerUpdateBundle`/snapshot.
>   *Purpose: fewer round trips, everything arrives coherent — never a player
>   at their new position with their old health.*
> - **Say "I'm pressing", not "I'm here".** The client only sends events
>   (press/release per direction, turn, cast) — never positions.
>   *Purpose: the foundation of anti-cheat. A cheater can't send "I'm across
>   the map" because the server computes positions itself from inputs.*
> - **Play instantly (prediction).** While the answer travels (50-150 ms),
>   your client moves you immediately.
>   *Purpose: zero-lag feel despite latency.*
> - **The teacher who corrects (gently or firmly).** The server compares your
>   predicted position with its own: close → it sends the small offset, melted
>   invisibly over a few frames (`PlayerPositionUpdate`); far off (or
>   cheating) → instant teleport to the true position
>   (`PlayerForcedPositionUpdate`); standing still → instant too (no ghost
>   sliding). *Purpose: the server is always right, but you only feel it when
>   it matters.*
> - **Guessing the path (numbered waypoints).** The server sends waypoints
>   10-20×/s (position + direction + action, each **numbered**); the client
>   slides the character in a straight line between them.
>   *Purpose: 60 smooth frames from ~15 updates; numbers reorder late packets
>   (the old docs wrongly claim there are none).*
> - **The metronome (ping + region).** Ping every 5 s (10-sample rolling
>   average), region check vs US/EU servers every 5 min, 25 s watchdog for
>   dead connections. *Purpose: honest ping display, nearest continent, no
>   lingering ghosts.*
> - **Everyone sees the same move.** The server says "player 3: attack south"
>   (`PlayerAction`); each client translates it into its atlas animation.
>   *Purpose: both players see the exact same swing at the same time.*
> - **The single pipe (TCP).** Everything goes over reliable, ordered TCP
>   (512 KB buffer); UDP is allocated but **never used** — leftover from an
>   older build. *Purpose: simplicity over UDP's regularity.*
> - **Clean exits.** Disconnect → goodbye packet, player removed everywhere.
>   *Purpose: no frozen corpses lying around (our `Bye` does the same).*
>
> In one sentence: **you describe your intents, the server computes the
> world, corrects you gently or firmly, and everyone watches the same movie
> rebuilt at 60 frames from ~15 snapshots a second.**

Comment marche le multijoueur : (A) celui du jeu d'origine, reconstruit depuis
`client/Client.jar` + `docs/`, et (B) le prototype implémenté dans ce dépôt.
Chaque mécanisme est expliqué avec son utilité et ses références exactes.

> Convention : `client/...` = jeu d'origine décompilé (lecture seule),
> `src/...` = notre code. Les affirmations non vérifiables côté client sont
> marquées [DOC] (issues des docs existantes, sans preuve dans le jar).

---

## A. Le multijoueur du jeu d'origine

### A.1 Transport : KryoNet sur TCP uniquement (vérifié)

- `client/broken-sources/ag.java:89` : `new Client(524280, 65535)` — buffer
  d'écriture TCP ~512 Ko, buffer UDP 64 Ko **alloué mais jamais utilisé** :
  `sendUDP` n'apparaît dans **aucun** fichier client. En pratique, tout le
  trafic jeu passe en TCP. L'UDP réservé est du poids mort (probablement un
  reste d'une époque où positions et snapshots passaient en UDP).
- **Utilité** : TCP = ordre + fiabilité garantis sans code applicatif
  (pas de réordonnancement à gérer), au prix d'une latence moins régulière
  qu'UDP. Le gros buffer 512 Ko absorbe les snapshots groupés.

### A.2 Sérialisation : registre Kryo ordonné (vérifié)

- `client/src/main/java/PublicSerializer.java` (`af`) : 100+ types enregistrés
  (paquets, enums `CharacterClass`/`Direction`/`SpellName`/`PlayerAction`,
  structures `Location`/`HitCircle`/`Target`, collections). Stratégie
  d'instanciation Objenesis en repli.
- **Utilité** : IDs numériques compacts au lieu des noms de classes, et
  désérialisation sans constructeur — indispensable vu l'obfuscation
  (noms de classes d'une lettre).

### A.3 File d'entrée + dispatch polymorphique (vérifié)

- `ae.received()` (listener KryoNet, thread I/O) : fast-path pour
  `PUB_GAME_PING_RESPONSE` (latence) et `PUB_GAME_INIT` (mis en cache),
  sinon ajout à une `LinkedBlockingQueue`. Le thread principal draine dans
  `ag.c()` et appelle `packet.handle(...)` (dispatch polymorphique, pas de
  switch géant).
- `PUB_GAME_SNAPSHOT` est explicitement exclu des logs réseau : preuve
  indirecte de sa haute fréquence.
- **Utilité** : le thread réseau ne touche jamais à l'état du jeu (pas de
  race), tout est appliqué sur le thread de rendu.

### A.4 Envois groupés + gate par type (vérifié)

- `ag.a(Object)` met en file de sortie (avec gate `Map<Class, Boolean>` :
  `MOVE_REQUEST_*` désactivés tant que la partie n'a pas commencé).
- `ag.h()` flush en **un seul `PlayerUpdateBundle` en TCP** ; `ag.b(Object)`
  = envoi forcé immédiat (réservé : token, ping…).
- **Utilité** : un seul segment TCP par tick au lieu de N petits paquets
  (input + sorts + visée), moins d'overhead et atomicité par tick.

### A.5 Session, auth, ping, région (vérifié)

- Connexion → envoi `PUB_MISC_PLAYER_TOKEN` (token + gameID), réponse
  `PUB_GAME_INIT` (état initial). Déconnexion → nettoyage + statut ENDED.
- `ab.java` : ping toutes les **5 s** (`azv(5000)`), watchdog 25 s, moyenne
  glissante sur 10 échantillons, RTT en nanosecondes ; détection de région
  par ICMP vers AWS (`3.80.0.0` US-EAST, `3.64.0.0` EU-WEST) toutes les
  5 min, **uniquement sur login/lobby** (`ab.java:41`).
- **Utilité** : RTT pour l'affichage et (côté serveur) le choix de région ;
  le watchdog détecte les connexions mortes que TCP mettrait trop
  longtemps à signaler.

### A.6 Intentions de mouvement (vérifié)

- Le client envoie des **événements**, pas des positions :
  `MOVE_REQUEST_*` / `MOVE_RELEASE_*` (8 directions), `DIRECTION_CHANGE_REQUEST`,
  requêtes de sorts/ciblage/trinkets.
- En local, `az` (MovementManager, `az.java:180-243`) suit les directions
  pressées → `Direction` + `isMoving` ; `bb` (MyMovementManager) construit
  les 8 vecteurs de glisse (`bt` = Vector2 + Direction, `bb.java:1149-1156`).
  Le client **prédit** : il bouge tout de suite, sans attendre le serveur.
- **Utilité** : réactivité totale malgré 50-150 ms de RTT ; le serveur garde
  le dernier mot (voir A.7).

### A.7 Autorité serveur : offsets vs snaps (vérifié, cœur du système)

- `PlayerPositionUpdate.handle`
  (`.../updates/conveyed/PlayerPositionUpdate.java:44-53`) :
  `offset = serveur − client`, stocké (`b()`/`c()`) si l'entité **bouge**
  (l'offset est résorbé sur les frames suivantes), **snap direct + offsets à
  zéro si immobile**. → Les corrections en mouvement sont invisibles, les
  corrections à l'arrêt sont instantanées (pas de glissade fantôme).
- `PlayerForcedPositionUpdate.handle` (`.../PlayerForcedPositionUpdate.java:10-28`) :
  snap + zéro offsets **toujours** = correction anti-cheat / resync.
- **Utilité** : le meilleur des deux mondes — fluidité quand la prédiction
  est proche, vérité immédiate quand elle diverge ou triche.

### A.8 Interpolation par waypoints + séquences (vérifié)

- `ar` (InterpolationManager) bufferise des waypoints
  `JAVA_16_GFX_CL$61892` = `{seq, x, y, Direction, PlayerAction}`
  (`.../requests/input/JAVA_16_GFX_CL$61892.java:9-15,82-84`) et remplit
  **linéairement** entre deux waypoints (`ar.java:57-83`), en propageant
  direction et action aux points intermédiaires.
- `bp` (ReconciliationManager) indexe par numéro de séquence (`IntMap`).
- **Utilité** : trajectoires droites sans à-coups entre snapshots (10-20 Hz
  supposés), avec rejeu/ordonnancement par seq. **Correction aux docs
  existantes** : elles affirment « pas de numéros de séquence » —
  **faux** sur ce chemin (`setSEQUENCE_NUMBER` + `bp`) ; le risque de
  replay y est donc à nuancer.

### A.9 Animation pilotée par le serveur (vérifié)

- Le serveur envoie `PlayerAction` (`ATTACK_*` / `CAST_*` / `_RUN`, 8 dirs).
- `LegalPlayerAction` (`client/src/main/java/LegalPlayerAction.java:15`) :
  `a`=ATTACK→`attack`, `b`=CAST→`cast`, `f`/`g`=variants `_run`, etc.
- `cr.java:132-168` sélectionne l'animation d'atlas selon l'action reçue
  (avec cas spéciaux loup/ours). **Le client ne choisit jamais lui-même.**
- Champ `uk` (« spellType », `hf.java:193`) par sort : `a` = arme (28 sorts :
  dagues, mêlées, toutes les flèches, Whirlwind…), `d` = magie (96),
  `b`/`c` = passifs/auras — dont le client d'origine **masque même la ligne
  coût/cast/cooldown** du tooltip (`hd.java:119`).
- **Utilité** : une seule source de vérité visuelle ; pas de désync
  d'animation entre joueurs.

### A.10 Limites de ce qu'on peut prouver (honnêteté)

- **Pas de code serveur dans le jar** : tick exact, seuils de validation,
  rate limiting, vérification des seq → [DOC] uniquement (10-20 Hz plausibles
  vu `PUB_GAME_SNAPSHOT`).
- Erreurs relevées dans `docs/LAG_COMPENSATION*.md` : « pas de seq » (faux,
  voir A.8), « 3-6 updates par frame » (inversé : ~3 frames par update à
  60 img/s), snapshots « 50-500 Ko » invérifiables (douteux à 20 Hz).

---

## B. Notre prototype (`src/`, serveur d'autorité, mouvements)

Même schéma simplifié : intentions → autorité serveur → snapshots →
convergence. Différences assumées listées en B.6.

### B.1 Protocole `net/Net.java` — utilité de chaque paquet

| Paquet | Sens | Contenu | Utilité |
|---|---|---|---|
| `Hello{version, skin}` | C→S | version + dossier skin (`wizard/outfit_1/dark`) | handshake + annonce du skin pour le rendu distant |
| `Welcome{id, x, y}` | S→C | id assigné + spawn | identité sans laquelle le client ne sait pas quel point est « moi » |
| `Input{x, y, dir}` | C→S | vecteur normalisé + facing 0-7 | **seule** chose que le client envoie : jamais de position → autorité structurelle |
| `Snapshot{tick, ids[], xs[], ys[], skins[], dirs[]}` | S→tous | monde complet à 20 Hz | une seule source de vérité ; tableaux alignés |
| `Skin{skin}` | C→S | changement de perso | met à jour le rendu distant sans reconnecter |
| `Bye{id}` | S→tous | départ | nettoyage (sinon fantômes) |

- `register()` **unique et ordonné** (dont `int[]/float[]/String[]` explicites —
  KryoNet l'exige ; le smoke test l'a prouvé en cassant sans) : client et
  serveur partagent les mêmes IDs de classes. `Skin` ajouté **en fin** pour
  ne pas renuméroter les existants.
- Vitesse commune `SPEED = 500`, tick 20 Hz, clamp arène ±4000.

### B.2 Serveur `server/GameServer.java` — où s'exerce l'autorité

- Boucle à **pas fixe** (`1e9/20` ns, écrêtage anti-spirale) : intègre
  `pos += input × SPEED × dt`, clamp arène, diffuse **un** snapshot/tick.
- **Garde-fous** : magnitude d'input normalisée (`len > 1` → clampé ; testé :
  input `(100,0)` → +250 unités/0,5 s au lieu de +25 000), `dir` clampé 0-7,
  spawn décalé par id, logs `/join/leave/skin` + état toutes les 5 s.
- `ConcurrentHashMap` connexion→joueur (thread réseau vs thread tick),
  `AtomicInteger` pour les ids, `stop()` + shutdown hook.
- **Utilité** : triche de position impossible par construction (le client ne
  peut qu'orienter un vecteur ≤ 1) ; rejeu/crash d'un client n'affecte pas
  les autres.

### B.3 Client `net/NetClient.java` — zéro dépendance graphique

- Listener KryoNet (thread réseau) → champs `volatile` (`latest`, `selfId`,
  `open`) + file `ConcurrentLinkedQueue` pour les `Bye`. La boucle de rendu
  **poll** (`snapshot()`, `pollLeft()`), jamais de callback : même pattern
  que `ag`/`ae` d'origine, testable headless (voir B.7).
- `connect()` bloquant avec timeout → `false` = mode local. Envoi sur
  changement (input, facing) + heartbeat 500 ms (détecte aussi un client
  figé côté serveur).

### B.4 Jeu `ArenaOfKingsGame.java` — rendu des snapshots

- En mode `net` : **aucune intégration locale** (`updateNet`) ; la caméra
  suit la position serveur lissée du joueur.
- Lissage **exponentiel** (`lerp` à `dt×10`) vers la cible — plus simple que
  les offsets linéaires d'origine, sans dette de convergence.
- `run`/`idle` **depuis le déplacement dessiné** (60 img/s), pas depuis les
  deltas de snapshots (20 Hz) — sinon le perso distant clignotait idle/run
  entre deux snapshots (bug réel, corrigé).
- `facing` **diffusé** (`Input.dir` = visée souris → `Snapshot.dirs`) :
  le distant pivote sur place, comme dans l'original.
- Skins distants : atlas chargé à la demande et **caché par dossier**
  (`RemoteSkin` : idle/run 8 dirs + `applyFallback` + canvas), directions
  inconnues → anneau orange + `P<id>` (repli), échecs mémorisés (pas de
  spam de logs), changement live via paquet `Skin`, tout `dispose()`.
- Repli local : serveur injoignable (ou perte en cours) → ancien code
  local, HUD `local` vs `net=P<id>/n=<count>`.

### B.5 Matrice d'autorité (qui décide quoi)

| Fonction | Client | Serveur |
|---|---|---|
| Intentions (touches, visée) | ✅ produit | — |
| Positions | ❌ jamais intégrées ni envoyées | ✅ seul intégrateur (`step`) |
| Vitesse max | ❌ | ✅ clamp magnitude + arène |
| Facing | ✅ visée locale envoyée | ✅ rediffusé (clampé 0-7) |
| Correction | ✅ converge (lerp) | ✅ snapshots (pas de snap forcé — écart B.6) |
| Skins distants | ✅ annonce le sien | ✅ relaye |

### B.6 Écarts assumés vs l'original (et pourquoi)

1. `Input` vectoriel + facing au lieu de press/release × 8 dirs : 1 paquet
   au lieu de 2 événements par touche ; le serveur d'origine gère des
   pressions, le nôtre un état (plus simple, heartbeat inclus).
2. Lerp exponentiel au lieu d'offsets linéaires + snap si immobile : pas de
   dette d'interpolation à solder, pas de `ForcedUpdate` (pas d'anti-cheat
   nécessaire : pas de positions clientes à corriger).
3. `uk.a→attack / uk.d→cast` pour l'anim locale des sorts : l'original
   reçoit l'action du serveur ; `uk` est le meilleur proxy côté client.
4. TCP uniquement des deux côtés (comme l'original en pratique), pas
   d'auth/token/lobby/ping/région : hors scope « mouvements ».
5. Pas de prédiction locale : sur localhost c'est invisible ; en WAN il
   faudrait réintroduire prédiction + réconciliation (modèle A.6/A.7).

### B.7 Lancer et tester

```powershell
# Terminal 1 : serveur (TCP 54555, logs d'état/5 s)
mvn compile exec:java "-Dexec.mainClass=com.arenaofkings.server.GameServer"
# Terminal 2 (+3...) : jeu — passe en net si le serveur répond, sinon local
mvn compile exec:java
```

(`pom.xml` : `exec.mainClass` en `${...}` pour que `-D` surcharge le
`DesktopLauncher` par défaut ; KryoNet `2.22.0-RC1` + Kryo `5.6.2` forcé —
l'ASM du Kryo d'origine ne lit pas les classes Java 17.)

- Smoke test headless (`C:\Users\gox\AppData\Local\Temp\opencode\Smoke.java`,
  hors dépôt) : serveur in-process + 2 clients — déplacement ≈ `SPEED×t`
  (680 = 80 spawn + 600), input `(100,0)` clampé (Δ250, pas 25 000), 2 ids
  au snapshot, `Bye` au départ, skin + facing diffusés → `SMOKE PASS`.
- En jeu : `net=P<id>/n=2`, l'autre joueur en vrai skin (anneau si skin
  inconnu), pivot sur place à la souris, changement de perso visible
  en face.

### Références croisées (fichiers du dépôt)

- `src/main/java/com/arenaofkings/net/Net.java` — protocole + registre.
- `src/main/java/com/arenaofkings/net/NetClient.java` — endpoint polling.
- `src/main/java/com/arenaofkings/server/GameServer.java` — sim autoritaire.
- `src/main/java/com/arenaofkings/ArenaOfKingsGame.java` — `updateNet`,
  `sendNetInput`, `drawNet`, `loadRemoteSkin`, `isWeaponSpell`, repli local.
- Preuves d'origine citées : `client/broken-sources/{ag,ab,ae,ar,bp,az,bb,cr,gw,hf,hd,ui}.java`,
  `.../updates/{conveyed/PlayerPositionUpdate,PlayerForcedPositionUpdate}.java`,
  `.../requests/input/JAVA_16_GFX_CL$61892.java`,
  `client/src/main/java/{PublicSerializer,LegalPlayerAction}.java`.
