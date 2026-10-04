# Arena of Kings — jeu minimaliste libGDX

Sorcier centré à l'écran (caméra suiveuse), déplacement **ZQSD**, orientation **vers la souris**
avec les 8 directions de `full.atlas`. Clic gauche = sort (`cast`).

## Prérequis

- Java 17
- Maven 3.9+
- Les skins sont dans `assets/models/` (chargés via le classpath).

## Lancer

```powershell
mvn compile exec:java
```

## Contrôles

| Touche | Action |
|---|---|
| Z / W / ↑ | Haut |
| S / ↓ | Bas |
| Q / A / ← | Gauche |
| D / → | Droite |
| Souris | Orientation du personnage (8 directions) |
| Clic gauche | Lancer un sort (`cast` vers la souris) |
| Échap | Quitter |

On accepte ZQSD **et** WASD + flèches pour couvrir AZERTY et QWERTY
(sur AZERTY, la touche `Z` arrive souvent comme code `W`, d'où la double écoute).

## Personnages (`assets/models/`)

10 personnages (`assassin`, `champion`, `elder`, `lich`, `mystic`, `nihilist`, `paladin`,
`ranger`, `scholar`, `wizard`), chacun avec 2+ tenues (`outfit_1`, ...) en variantes
`dark`/`light` (+ formes animales pour `elder`, `outfit_3` pour `lich`/`scholar`).

Le jeu affiche 3 listes déroulantes en haut à gauche : **Perso / Tenue / Teinte**.
Au clic, le skin charge : nouvel atlas `assets/models/<perso>/<tenue>/<teinte>/full.atlas` +
reconstruction des 8 directions.
**Clic gauche = `attack` / `attack_run`, clic droit = `cast` / `cast_run`**
(les animaux n'ont que `idle`/`run` : les clics ne font rien chez eux).

La liste des skins vient de `assets/skins.list` (une ligne = dossier de `full.atlas`).
Après ajout de modèles, régénérer avec :
```powershell
Get-ChildItem assets/models -Recurse -Filter full.atlas | ForEach-Object { $_.DirectoryName.Replace($PWD.Path + '\assets\models\','').Replace('\','/') } | Sort-Object | Set-Content assets/skins.list -Encoding UTF8
```

## Mapping des directions (déduit des atlas)

`index = direction * 10000 + frame` :

| dir | Orientation |
|---|---|
| 0 | Sud (face caméra) |
| 1 | Sud-Est |
| 2 | Est |
| 3 | Nord-Est |
| 4 | Nord (dos) |
| 5 | Nord-Ouest |
| 6 | Ouest |
| 7 | Sud-Ouest |

Formule : `dir = (round(angleDeg / 45) + 2) % 8` avec `angleDeg = atan2(dy, dx)` en monde (Y vers le haut).
Voir `ArenaOfKingsGame.computeDir()` (`src/main/java/com/arenaofkings/ArenaOfKingsGame.java`).

Note : `idle` n'a pas de direction 0 dans `full.atlas` → repli automatique sur la direction
non vide la plus proche (`applyFallback`).

Note technique : beaucoup de frames sont packées avec `rotate: true` dans l'atlas.
Le rendu utilise `TextureAtlas.AtlasSprite` (et non `batch.draw(TextureRegion)`)
car seul `AtlasSprite` compense la rotation de 90° — sinon le personnage apparaît renversé.

## Réglages (`ArenaOfKingsGame.java`)

- `ZOOM = 2` — dézoom de la caméra (1 = pas de zoom).
- Vitesses d'animation : `idle` 20 img/s, `run` 40 img/s, `cast` 50 img/s.
- `SPEED = 500` — vitesse de déplacement (unités monde/s).
- `SCALE = 2.5` — taille du sprite (canvas d'origine 252×238).

## Build Windows (.exe)

```powershell
mvn package -DskipTests
jpackage --type app-image --input target --dest dist --name ArenaOfKings `
  --main-jar arena-of-kings-1.0-SNAPSHOT.jar --main-class com.arenaofkings.DesktopLauncher `
  --app-version 1.0 --vendor ArenaOfKings --description "Arena of Kings ZQSD souris"
```

Lançable via `dist/ArenaOfKings/ArenaOfKings.exe`.

## Fichiers

- `pom.xml` — dépendances libGDX 1.12.1 (lwjgl3)
- `src/main/java/com/arenaofkings/ArenaOfKingsGame.java` — jeu (déplacement, caméra, animations idle/run/cast)
- `src/main/java/com/arenaofkings/DesktopLauncher.java` — lanceur desktop 1280×720
- `assets/` — `skins.list` + `models/<perso>/<tenue>/<teinte>/full.atlas` + PNG (copiés sur le classpath au build)
