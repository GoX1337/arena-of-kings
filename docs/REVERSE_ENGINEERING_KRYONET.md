# Reverse Engineering Complète - KryoNet Arena of Kings

## 📋 Table des Matières
1. [Architecture Globale](#architecture-globale)
2. [Composants Clés](#composants-clés)
3. [Système d'Événements KryoNet](#système-dévénements-kryonet)
4. [Types de Paquets](#types-de-paquets)
5. [Flux Réseau](#flux-réseau)
6. [Système de Latence](#système-de-latence)
7. [Configuration Kryo](#configuration-kryo)

---

## Architecture Globale

### 🏗️ Composants Principaux

```
┌─────────────────────────────────────────────────────────────┐
│                    CLIENT GAME ENGINE                       │
├─────────────────────────────────────────────────────────────┤
│                                                               │
│  ┌──────────────────────────────────────────────────────┐   │
│  │ ag (GameClient) - Main Network Handler               │   │
│  │ ├─ Client (KryoNet): 524KB write buffer, 65535 MTU   │   │
│  │ ├─ LinkedBlockingQueue<PublicPacket>: Queue paquets │   │
│  │ ├─ ae (Listener): Event handler                      │   │
│  │ └─ ab (LatencyManager): Ping/RTT calculator          │   │
│  └──────────────────────────────────────────────────────┘   │
│                          ▼                                    │
│  ┌──────────────────────────────────────────────────────┐   │
│  │ ae (NetworkListener) - KryoNet Listener              │   │
│  │ ├─ connected(Connection)      - Auth token send      │   │
│  │ ├─ disconnected(Connection)   - Game cleanup         │   │
│  │ └─ received(Connection, obj)  - Packet processing    │   │
│  └──────────────────────────────────────────────────────┘   │
│                          ▼                                    │
│  ┌──────────────────────────────────────────────────────┐   │
│  │ af (Kryo Registry) - Serialization Configuration    │   │
│  │ └─ 100+ registered packet types                      │   │
│  └──────────────────────────────────────────────────────┘   │
│                                                               │
└─────────────────────────────────────────────────────────────┘
```

### 📊 Hiérarchie des Classes

```
ag (GameClient)
 ├─ extends y (Connection Base)
 │   └─ holds: Client (KryoNet)
 │
 ├─ ae (Listener)
 │   ├─ connected()
 │   ├─ disconnected()
 │   └─ received()
 │
 ├─ ab (LatencyManager)
 │   ├─ Ping/RTT calculation
 │   └─ Region detection (US/EU)
 │
 └─ LinkedBlockingQueue<PublicPacket>
     └─ Thread-safe packet queue
```

---

## Composants Clés

### 1. **ag.java** - GameClient (Main Handler)

**Responsabilités:**
- Initialisation du client KryoNet
- Gestion de la file d'attente des paquets
- Configuration des filtres de paquets
- Dispatch des paquets aux handlers

**Configuration du Client:**
```java
this.a = new Client(524280, 65535);
// Buffer TCP: 524280 bytes (512 KB)
// Buffer UDP: 65535 bytes (MTU standard)
```

**Filtrage des Paquets Supportés:**
```java
Map<Class, Boolean> packetTypeMap = new HashMap<>();
packetTypeMap.put(MOVE_REQUEST_NORTH.class, false);      // Disabled initially
packetTypeMap.put(MOVE_REQUEST_SOUTH.class, false);
packetTypeMap.put(MOVE_REQUEST_EAST.class, false);
packetTypeMap.put(MOVE_REQUEST_WEST.class, false);
packetTypeMap.put(MOVE_SPELL_REQUEST.class, false);
packetTypeMap.put(SPELL_REQUEST.class, false);
packetTypeMap.put(DIRECTION_CHANGE_REQUEST.class, false);
packetTypeMap.put(PUB_GAME_PING.class, false);
// ... 14+ mouvement types au total
```

**États de Connexion:**
```java
public ag(Engine engine) {
    this.a = new ab(this, this.a);  // Latency manager
    this.a = new Client(524280, 65535);
    af.a(this.a.getKryo());  // Enregistrer les types Kryo
    this.a = new ae(this, ...);  // Listener
    this.a.addListener(this.a);
}
```

**Connexion au Serveur:**
```java
public void b() {
    // Thread séparé pour la connexion
    Thread thread = new Thread(new ah(this));
    thread.start();
}
// Dans ah.java (thread worker):
// ((Client)client).connect(timeout, hostname, tcpPort, udpPort)
```

**Processing des Paquets Reçus:**
```java
public void c() {
    // Synchronisé sur la queue
    synchronized (this.a) {  // LinkedBlockingQueue
        this.a = new ArrayList(this.a);
        this.a.clear();
    }
    
    // Iterate et dispatch
    while (iterator.hasNext()) {
        PublicPacket packet = iterator.next();
        packet.handle(this.a);  // Polymorphic dispatch
    }
}
```

### 2. **ae.java** - NetworkListener (Événements)

**Implémente com.esotericsoftware.kryonet.Listener**

#### **Événement 1: connected(Connection)**
```java
@Override
public void connected(Connection connection) {
    // 1. Log connexion
    Engine.a("[NETWORK-GS] Connection opened. onOpen()");
    
    // 2. Authentification token
    PUB_MISC_PLAYER_TOKEN token = new PUB_MISC_PLAYER_TOKEN();
    token.setToken(ay.a().a().a());      // Récupère le token stocké
    token.setGameID(this.b);
    this.a.a.a.b(token);  // Envoie via TCP
    
    // 3. Notification d'état
    this.a.a(true);  // Set connected = true
}
```

**Flux d'Authentification:**
```
Client connects (TCP)
    ↓
Server: "Hey you're connected!"
    ↓
ae.connected() fires
    ↓
Send PUB_MISC_PLAYER_TOKEN with player auth
    ↓
Server validates token
    ↓
Server sends PUB_GAME_INIT with game state
```

#### **Événement 2: disconnected(Connection)**
```java
@Override
public void disconnected(Connection connection) {
    Engine.a("[NETWORK-GS] Connection closed.");
    
    // 1. Cleanup queues
    this.a.d();
    this.a.a(false);  // Set connected = false
    
    // 2. Send game end status
    if (ay.a() != null && ay.a().a() != null && ay.a().a().b()) {
        PUB_GAME_STATUS_UPDATE update = new PUB_GAME_STATUS_UPDATE();
        update.setGameStatus(GameStatus.ENDED);
        update.handle(this.a);
    }
    
    // 3. Handle reconnection logic
    if (this.a.a.a.a()) {
        // Relog required
        return;
    }
}
```

#### **Événement 3: received(Connection, Object)**

C'est le cœur du système d'événements réseau !

```java
@Override
public void received(Connection connection, Object object) {
    long receiveTime = System.nanoTime();
    
    if (object == null) return;
    
    // Ignorer les messages framework KryoNet
    if (object instanceof FrameworkMessage) return;
    
    // Log détail
    this.a.a.a.a("[NETWORK-GS] IN: " + 
                  object.getClass().getSimpleName());
    
    // ✅ TRAITEMENT SPÉCIAL: Ping Response
    if (object instanceof PUB_GAME_PING_RESPONSE) {
        // Calcul RTT
        this.a.a().a(receiveTime);
        return;
    }
    
    // ✅ TRAITEMENT SPÉCIAL: Game Init
    if (object instanceof PUB_GAME_INIT) {
        this.a.a = (PUB_GAME_INIT)object;
        // Stocké pour traitement synchronisé ultérieur
        return;
    }
    
    // ✅ TRAITEMENT STANDARD: Queuer pour dispatch
    // Tous les autres paquets vont à la LinkedBlockingQueue
    ((AbstractQueue<PublicPacket>)this.a.a).add((PublicPacket)object);
}
```

**Diagramme du received():**
```
Network Packet arrives
    ↓
KryoNet deserializes (Kryo registry af.a())
    ↓
ae.received(connection, deserializedObject)
    ├─ null check
    ├─ FrameworkMessage? → IGNORE
    ├─ PUB_GAME_PING_RESPONSE? → Update latency
    ├─ PUB_GAME_INIT? → Store & sync
    └─ Other PublicPacket? → Add to LinkedBlockingQueue
         ↓
      Main game thread polls queue in ag.c()
         ↓
      packet.handle(gameClient)  [polymorphic dispatch]
```

### 3. **ab.java** - LatencyManager (Ping/RTT)

**Gestion de la Latence:**

```java
public class ab {
    private volatile long startTime;         // Ping sent
    private volatile long endTime = 25000L;  // Pong received
    private volatile int currentPing;        // Latest ping
    private volatile int averagePing = 0;    // 10-sample average
    private List<Integer> pingHistory;       // Rolling buffer
    private final int HISTORY_SIZE = 10;
}
```

**Calcul RTT:**
```java
public void a(long receiveTime) {
    this.endTime = receiveTime;
    
    // RTT en millisecondes (précision nanoseconde)
    this.currentPing = (int)Math.floor(
        TimeUnit.NANOSECONDS.toMillis(this.endTime - this.startTime)
    );
    
    // Initialiser le buffer si vide
    if (this.pingHistory.isEmpty()) {
        for (int i = 0; i < 10; i++) {
            this.pingHistory.add(this.currentPing);
        }
    }
    
    // Circular buffer - remplacer plus ancien
    this.pingHistory.set(this.f++, this.currentPing);
    if (this.f == this.pingHistory.size()) {
        this.f = 0;  // Wrap around
    }
    
    // Moyenne mobile
    this.averagePing = 0;
    for (Integer ping : this.pingHistory) {
        this.averagePing += ping;
    }
    this.averagePing /= this.pingHistory.size();
}
```

**Envoi de Ping:**
```java
public void a() {
    if (this.a != null && this.a.a != null && 
        this.a.b() && this.a.a().isConnected()) {
        
        this.a.a(new PUB_GAME_PING());  // Send ping packet
        this.startTime = System.nanoTime();
        this.a.c();  // Reset timer
    }
}
```

**Détection de Région:**
```java
public void a(Engine engine) {
    // Runs every 5 minutes
    if (this.c == null) {
        this.c = new azv(300000L, true);  // 5 min timer
        this.g = (int)this.a("3.80.0.0");  // US_EAST latency
        this.h = (int)this.a("3.64.0.0");  // EU_WEST latency
    }
}

private long a(String ipAddress) {
    // ICMP ping (latence vers régions)
    try {
        long start = System.currentTimeMillis();
        InetAddress.getByName(ipAddress).isReachable(5000);
        return System.currentTimeMillis() - start;
    } catch (IOException e) {
        // Handle error
    }
}
```

### 4. **af.java** - Kryo Registry (Sérialisation)

**Registre de Types Kryo:**

Tous les paquets et structures de données doivent être enregistrés pour que Kryo puisse les sérialiser/désérialiser.

```java
public static void a(Kryo kryo) {
    ((DefaultInstantiatorStrategy)kryo.getInstantiatorStrategy())
        .setFallbackInstantiatorStrategy(new StdInstantiatorStrategy());
    
    // Collections
    kryo.register(List.class);
    kryo.register(ArrayList.class);
    kryo.register(Array.class);  // libGDX Array
    kryo.register(Object[].class);
    
    // Enums & Types de Base
    kryo.register(CharacterClass.class);
    kryo.register(GameStatus.class);
    kryo.register(Direction.class);
    kryo.register(SpellName.class);
    kryo.register(ArenaName.class);
    kryo.register(GameType.class);
    kryo.register(Privilege.class);
    kryo.register(PlayerStatus.class);
    // ... and 80+ more
}
```

---

## Système d'Événements KryoNet

### Lifecycle Complet

```
┌──────────────────────────────────────────────────────────────┐
│ 1. CONNECTION INITIATION                                     │
└──────────────────────────────────────────────────────────────┘

app calls: ag.a(hostname, port_tcp, port_udp)
    ↓
New Thread(ah.java) starts
    ↓
Client.connect(timeout, hostname, tcpPort, udpPort)
    ├─ Performs 3-way TCP handshake
    └─ Establishes Connection object


┌──────────────────────────────────────────────────────────────┐
│ 2. CONNECTION ESTABLISHED - ae.connected() fires             │
└──────────────────────────────────────────────────────────────┘

KryoNet calls: ae.connected(connection)
    ↓
① Set connected = true
② Create PUB_MISC_PLAYER_TOKEN
   └─ Player auth token
   └─ GameID
③ Send token via: connection.sendTCP(token)
    └─ Gets serialized by Kryo registry
    └─ Sent over TCP socket
④ Log message: "[NETWORK-GS] Connection opened"


┌──────────────────────────────────────────────────────────────┐
│ 3. BIDIRECTIONAL COMMUNICATION                               │
└──────────────────────────────────────────────────────────────┘

SERVER → CLIENT (Inbound):
    ↓
Network packet arrives on socket
    ↓
Client.update() (KryoNet I/O thread) deserializes with Kryo
    ↓
For each listener (just ae in this case):
    ├─ If FrameworkMessage → ignore
    ├─ If PUB_GAME_PING_RESPONSE → ab.a(time) [latency update]
    ├─ If PUB_GAME_INIT → cache for sync processing
    └─ Else → Add to LinkedBlockingQueue
    ↓
Main game thread calls ag.c()
    ↓
Drain queue + dispatch: packet.handle(gameClient)

CLIENT → SERVER (Outbound):
    ↓
Game input detected (movement, spell, etc.)
    ↓
App creates packet: new MOVE_REQUEST_NORTH()
    ↓
Check if type enabled in packetTypeMap
    ↓
Send via: connection.sendTCP(packet)
    ├─ Serialized by Kryo
    └─ Sent over TCP socket


┌──────────────────────────────────────────────────────────────┐
│ 4. CONNECTION LOST - ae.disconnected() fires                 │
└──────────────────────────────────────────────────────────────┘

Network socket closed
    ↓
KryoNet calls: ae.disconnected(connection)
    ↓
① Set connected = false
② Cleanup queues
③ Create PUB_GAME_STATUS_UPDATE(GameStatus.ENDED)
④ Dispatch to handlers
⑤ Log: "[NETWORK-GS] Connection closed"
```

---

## Types de Paquets

### 🔒 Paquets d'Authentification
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `PUB_MISC_PLAYER_TOKEN` | CLIENT → SERVER | Token auth + GameID |

### 🎮 Paquets de Contrôle de Jeu
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `PUB_GAME_INIT` | SERVER → CLIENT | État initial du jeu |
| `PUB_GAME_STATUS_UPDATE` | SERVER → CLIENT | GameStatus (IN_PROGRESS, ENDED, etc.) |
| `PUB_GAME_SNAPSHOT` | SERVER → CLIENT | Snapshot complet du monde |
| `PUB_GAME_MESSAGE` | SERVER → CLIENT | Chat/Messages |
| `PUB_PLAY_READY` | CLIENT → SERVER | Joueur prêt |
| `PUB_GAME_CONNECTION_ESTABLISHED` | SERVER → CLIENT | Confirmation connexion |

### 📡 Paquets de Latence
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `PUB_GAME_PING` | CLIENT → SERVER | Ping request (empty) |
| `PUB_GAME_PING_RESPONSE` | SERVER → CLIENT | Ping response (empty) |

### 🧭 Paquets de Mouvement
```
MOVE_REQUEST_* (CLIENT → SERVER)
  ├─ MOVE_REQUEST_NORTH
  ├─ MOVE_REQUEST_SOUTH
  ├─ MOVE_REQUEST_EAST
  ├─ MOVE_REQUEST_WEST
  ├─ MOVE_REQUEST_NORTH_EAST
  ├─ MOVE_REQUEST_NORTH_WEST
  ├─ MOVE_REQUEST_SOUTH_EAST
  └─ MOVE_REQUEST_SOUTH_WEST

MOVE_RELEASE_* (CLIENT → SERVER)
  ├─ MOVE_RELEASE_NORTH
  ├─ MOVE_RELEASE_SOUTH
  ├─ MOVE_RELEASE_EAST
  ├─ MOVE_RELEASE_WEST
  ├─ MOVE_RELEASE_NORTH_EAST
  ├─ MOVE_RELEASE_NORTH_WEST
  ├─ MOVE_RELEASE_SOUTH_EAST
  └─ MOVE_RELEASE_SOUTH_WEST
```

### 🪄 Paquets de Combat
| Packet | Direction | Notes |
|--------|-----------|-------|
| `SPELL_REQUEST` | CLIENT → SERVER | Cast sort |
| `MOVE_SPELL_REQUEST` | CLIENT → SERVER | Sort + mouvement |
| `DIRECTION_CHANGE_REQUEST` | CLIENT → SERVER | Rotation joueur |
| `TargetRequest` | CLIENT → SERVER | Changer cible |
| `TargetOfTargetRequest` | CLIENT → SERVER | Cible de cible |
| `TRINKET_REQUEST_0` | CLIENT → SERVER | Utiliser trinket |

### 👥 Paquets de Joueur
```
PlayerUpdate* (SERVER → CLIENT, multiples variantes)
  ├─ PlayerCoordinateUpdate
  ├─ PlayerDirectionChange
  ├─ PlayerDeathUpdate
  ├─ PlayerHealthManaUpdate
  ├─ PlayerMaxHealthUpdate
  ├─ PlayerEffectAdd / Remove / Update
  ├─ PlayerMovementPressNorth/South/East/West/Update
  ├─ PlayerComboPointUpdate
  ├─ PlayerTargetUpdate
  ├─ PlayerInterrupted / SelfInterrupt
  ├─ PlayerGCDReset
  ├─ PlayerSnapshot
  └─ ... (40+ variantes)
```

### 🎯 Paquets de Spells
```
Spell Casting Packets (SERVER → CLIENT)
  ├─ PlayerSpellCastStart
  ├─ PlayerSpellUpdate
  ├─ PlayerSpellDestroyedUpdate
  └─ SpellUpdate Types:
      ├─ DynamicPlayerSpellStart
      ├─ DynamicPlayerSpellFinish
      ├─ DynamicCoordinateSpellFinish
      ├─ FixedPlayerSpellStart
      ├─ FixedPlayerSpellFinish
      ├─ FixedCoordinateSpellStart
      ├─ FixedCoordinateSpellFinish
      ├─ TargetedProjectileSpellStart
      └─ TargetedProjectileSpellFinish
```

### 💫 Paquets d'Effets
| Packet | Type | Notes |
|--------|------|-------|
| `PlayerEffectAdd` | Buff/Debuff | Ajout effet |
| `PlayerEffectRemove` | Buff/Debuff | Retrait effet |
| `PlayerEffectUpdate` | Buff/Debuff | Modification |
| `EffectList` | Collection | Liste d'effets |

### 🏆 Paquets de Score
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `PUB_GAME_SCOREBOARD_UPDATE` | SERVER → CLIENT | Mise à jour scoreboard |
| `ScoreboardUpdate` | Structure | Items + changements |
| `ScoreboardItem` | Structure | Données joueur |

### 💎 Paquets d'Items
```
Item System Packets
  ├─ ItemData (Structure)
  ├─ ItemLocation (Enum)
  ├─ ItemSlot (Enum)
  ├─ ItemArmorType (Enum)
  ├─ ItemModData (Structure)
  ├─ ItemRequirement (Abstract)
  │   ├─ ArmorRequirement
  │   ├─ ClassRequirement
  │   ├─ LevelRequirement
  │   └─ EquippableRequirement
  ├─ PlayerItemDropData
  ├─ ItemPickupRequest (CLIENT → SERVER)
  ├─ ItemRemove (CLIENT → SERVER)
  └─ Trinket:
      ├─ TrinketUseRequest
      └─ TrinketUseUpdate
```

### 🎪 Paquets de Contrôle
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `PUB_GAME_FOG_UPDATE` | SERVER → CLIENT | Fog of war/vision |
| `CollisionEvent` | SERVER → CLIENT | Événement collision |
| `PlayerSnapshot` | SERVER → CLIENT | État joueur |
| `UpdatePacket` | Structure wrapper | Conteneur updates |

### 📣 Paquets de Feedback Visuel
| Packet | Direction | Contenu |
|--------|-----------|---------|
| `SCT_Event` | SERVER → CLIENT | Floating text event |
| `SCT_FloatingFeedbackText` | SERVER → CLIENT | Texte flottant |
| `SCT_PlayerHealthChange` | SERVER → CLIENT | Changement santé |
| `SCT_PlayerManaChange` | SERVER → CLIENT | Changement mana |

### 👥 Paquets Multijoueur
```
Player Data Structures
  ├─ FriendlyPlayerData
  ├─ EnemyPlayerData
  ├─ ArenaTeamMemberData
  ├─ ArenaTeamData
  └─ Player Metadata:
      ├─ CharacterClass
      ├─ PlayerStatus
      ├─ Privilege
      ├─ ArenaName
      ├─ GameType
      ├─ Location (coords)
      ├─ Target (cible)
      ├─ HitCircle (collision)
      └─ PlayerAction
```

---

## Flux Réseau

### Séquence: Connexion + Authentification

```sequence
Client          KryoNet         Listener(ae)    Queue       Server
  │               │                │             │            │
  ├──connect()──→ │                │             │            │
  │               │────TCP──────────────────────────────────→ │
  │               │ ←────3-way handshake─────────────────────│
  │               │                │             │            │
  │               │──connected()──→ │             │            │
  │               │                 │             │            │
  │               │                 ├──auth token─────────────→│
  │               │                 │             │            │
  │               │                 │             │    Server  │
  │               │                 │             │    validates
  │               │ ←──PUB_GAME_INIT──────────────────────────│
  │               │                 │             │            │
  │               │──received()────→ │             │            │
  │               │  (PUB_GAME_INIT) │             │            │
  │               │                 ├─cache────→  │            │
  │               │                 │             │            │
  │               │                 │  (polling   │            │
  │               │                 │   in main   │            │
  │               │                 │   thread)   │            │
  └───────────────┴────────────────┴─────────────┴────────────┘
```

### Séquence: Ping/Latency Check

```
Main Game Loop:
    ├─ if (timeSincePing > 5000ms):
    │       └─ ab.a()  // Send ping
    │           ├─ Create PUB_GAME_PING()
    │           ├─ startTime = nanoTime()
    │           └─ connection.sendTCP(ping)
    │
    ├─ Server receives, immediately responds
    │
    ├─ Client receives PUB_GAME_PING_RESPONSE
    │   ├─ KryoNet deserializes
    │   ├─ ae.received(connection, response)
    │   ├─ if (response instanceof PUB_GAME_PING_RESPONSE):
    │   │     └─ ab.a(currentNanoTime)  // RTT calc
    │   │
    │   └─ RTT = floor(toMillis(endTime - startTime))
    │
    └─ Update average ping with rolling buffer
```

### Séquence: Input Handling

```
Player Input Detected
    ↓
Game Logic Layer Processes
    ↓
Create Movement Request Packet:
    if (inputEnabled && packetTypeMap[MOVE_REQUEST_EAST] == true):
        packet = new MOVE_REQUEST_EAST()
    ↓
Send Packet:
    connection.sendTCP(packet)
    ├─ Kryo serializes using af.a()
    ├─ TcpConnection queues bytes
    └─ Sent over TCP socket
    ↓
Server receives
    ↓
Server physics engine processes
    ↓
Server sends back PlayerCoordinateUpdate
    ├─ Contains new position
    └─ Sent to all players in arena
    ↓
Client receives PlayerCoordinateUpdate
    ├─ KryoNet deserializes
    ├─ ae.received() → added to queue
    ├─ Main thread polls queue
    ├─ packet.handle(gameClient)
    └─ Visually update player position
```

### Séquence: Disconnection

```
Network Lost / Server Closes Connection
    ↓
KryoNet detects EOF or exception
    ↓
For each Listener (just ae):
    ├─ ae.disconnected(connection)
    │   ├─ Set connected = false
    │   ├─ Log: "[NETWORK-GS] Connection closed"
    │   ├─ d() - cleanup
    │   └─ Send GameStatus.ENDED
    │
    └─ Game state cleanup
        ├─ Exit arena
        ├─ Return to menu
        └─ Optionally: prompt reconnect
```

---

## Système de Latence

### Implémentation Complète (ab.java)

**Configuration:**
```java
private final int TIMEOUT = 5000;              // ms
private final int MAX_LATENCY = 25000;         // ms before disconnect
private final int HISTORY_SIZE = 10;           // samples for average
private final int REGION_CHECK_INTERVAL = 300000;  // 5 minutes
```

**Rolling Buffer Ping History:**
```
Initialized with 10 identical samples on first ping
Example after 10 pings:
    ┌──────────────────────┐
    │ [45, 48, 46, 47,    │
    │  45, 46, 48, 49,    │
    │  47, 46]             │
    │ Average: 46.7ms     │
    └──────────────────────┘

New ping arrives: 50ms
    ↓ Set position: f % size = circular index
    ├─ f=0: [50, 48, 46, 47, 45, 46, 48, 49, 47, 46]
    ├─ f=1: [50, 50, 46, 47, 45, 46, 48, 49, 47, 46]
    ├─ f=2: [50, 50, 50, 47, 45, 46, 48, 49, 47, 46]
    └─ New Average: 47.8ms
```

**Détection de Région:**
```java
// Ping deux serveurs régionaux toutes les 5 minutes
int us_east_latency = icmp_ping("3.80.0.0");    // AWS US-EAST
int eu_west_latency = icmp_ping("3.64.0.0");    // AWS EU-WEST

// Sélection région automatique:
Region selectedRegion = us_east_latency < eu_west_latency 
    ? Region.US_EAST 
    : Region.EU_WEST;
```

**Timestamps Nanoseconde:**
```
startTime = System.nanoTime()           // When ping sent
    ↓ (network delay)
endTime = System.nanoTime()             // When pong received
    ↓
RTT_ms = floor(toMillis(endTime - startTime))
```

---

## Configuration Kryo

### Registre Complet (100+ types)

**Collections & Arrays:**
```java
kryo.register(List.class);
kryo.register(ArrayList.class);
kryo.register(Array.class);              // libGDX Array
kryo.register(Object[].class);
```

**Enumerations:**
```java
kryo.register(CharacterClass.class);     // Warrior, Mage, etc.
kryo.register(GameStatus.class);         // IN_PROGRESS, ENDED
kryo.register(Direction.class);          // N,S,E,W
kryo.register(GameType.class);           // Arena types
kryo.register(ItemSlot.class);           // Equipment slots
kryo.register(ItemLocation.class);       // Where item can be
kryo.register(ItemArmorType.class);      // Armor types
kryo.register(ItemDBState.class);        // Item database state
kryo.register(Privilege.class);          // User roles
kryo.register(PlayerStatus.class);       // AFK, DEAD, etc.
kryo.register(LocationType.class);       // Coordinate system type
```

**Paquets Réseau (Authentication):**
```java
kryo.register(PublicPacket.class);       // Base class
kryo.register(PUB_MISC_PLAYER_TOKEN.class);
kryo.register(PUB_PLAY_READY.class);
```

**Paquets Réseau (Game Control):**
```java
kryo.register(PUB_GAME_CONNECTION_ESTABLISHED.class);
kryo.register(PUB_GAME_INIT.class);
kryo.register(PUB_GAME_STATUS_UPDATE.class);
kryo.register(PUB_GAME_SNAPSHOT.class);
kryo.register(PUB_GAME_MESSAGE.class);
kryo.register(PUB_GAME_FOG_UPDATE.class);
kryo.register(PUB_GAME_PING.class);
kryo.register(PUB_GAME_PING_RESPONSE.class);
kryo.register(PUB_GAME_SCOREBOARD_UPDATE.class);
```

**Paquets Réseau (Input/Requests):**
```java
// Movement
kryo.register(MOVE_REQUEST_NORTH.class);
kryo.register(MOVE_REQUEST_SOUTH.class);
kryo.register(MOVE_REQUEST_EAST.class);
kryo.register(MOVE_REQUEST_WEST.class);
kryo.register(MOVE_REQUEST_NORTH_EAST.class);
kryo.register(MOVE_REQUEST_NORTH_WEST.class);
kryo.register(MOVE_REQUEST_SOUTH_EAST.class);
kryo.register(MOVE_REQUEST_SOUTH_WEST.class);
kryo.register(MOVE_RELEASE_NORTH.class);
// ... (8 more RELEASE variants)

// Combat
kryo.register(SPELL_REQUEST.class);
kryo.register(SpellRequest.class);
kryo.register(MOVE_SPELL_REQUEST.class);
kryo.register(TargetRequest.class);
kryo.register(TargetOfTargetRequest.class);
kryo.register(DIRECTION_CHANGE_REQUEST.class);
kryo.register(TRINKET_REQUEST_0.class);
kryo.register(ItemPickupRequest.class);
kryo.register(ItemRemove.class);
kryo.register(MOVE_FORCE_POSITION_REQUEST.class);
kryo.register(JAVA_16_GFX_CL$61892.class);
```

**Updates Joueur (40+ variantes):**
```java
kryo.register(PlayerUpdate.class);           // Base
kryo.register(PlayerCoordinateUpdate.class); // Position
kryo.register(PlayerDirectionChange.class);  // Rotation
kryo.register(PlayerDeathUpdate.class);      // Death
kryo.register(PlayerHealthManaUpdate.class); // Vitals
kryo.register(PlayerMaxHealthUpdate.class);  // Health cap
kryo.register(PlayerMovementActionUpdate.class);
kryo.register(PlayerMovementPressNorthUpdate.class);
kryo.register(PlayerMovementPressSouthUpdate.class);
kryo.register(PlayerMovementPressEastUpdate.class);
kryo.register(PlayerMovementPressWestUpdate.class);
kryo.register(PlayerMovementReleaseNorthUpdate.class);
// ... (more movement variants)
kryo.register(PlayerEffectAdd.class);
kryo.register(PlayerEffectRemove.class);
kryo.register(PlayerEffectUpdate.class);
kryo.register(PlayerComboPointUpdate.class);
kryo.register(PlayerTargetUpdate.class);
kryo.register(PlayerInterrupted.class);
kryo.register(PlayerSelfInterrupt.class);
kryo.register(PlayerGCDReset.class);
kryo.register(PlayerSpellDestroyedUpdate.class);
kryo.register(PlayerSnapshot.class);
kryo.register(PlayerUpdateList.class);
```

**Spells & Effects:**
```java
kryo.register(PlayerSpellCastStart.class);
kryo.register(PlayerSpellUpdate.class);
kryo.register(SpellClassification.class);
kryo.register(DynamicCoordinateSpellFinish.class);
kryo.register(DynamicPlayerSpellFinish.class);
kryo.register(DynamicPlayerSpellStart.class);
kryo.register(FixedCoordinateSpellFinish.class);
kryo.register(FixedCoordinateSpellStart.class);
kryo.register(FixedPlayerSpellFinish.class);
kryo.register(FixedPlayerSpellStart.class);
kryo.register(TargetedProjectileSpellFinish.class);
kryo.register(TargetedProjectileSpellStart.class);
```

**Events & Feedback:**
```java
kryo.register(CollisionEvent.class);
kryo.register(SCT_Event.class);
kryo.register(SCT_FloatingFeedbackText.class);
kryo.register(SCT_PlayerHealthChange.class);
kryo.register(SCT_PlayerManaChange.class);
```

**Données Structurelles:**
```java
kryo.register(Location.class);
kryo.register(Target.class);
kryo.register(HitCircle.class);
kryo.register(EffectList.class);
kryo.register(Conveyorable.class);
kryo.register(PlayerActionUpdate.class);
kryo.register(PlayerPositionUpdate.class);
kryo.register(UpdatePacket.class);
kryo.register(Snapshot.class);
kryo.register(PlayerUpdateBundle.class);
kryo.register(SpellName.class);
kryo.register(SpellBarState.class);
kryo.register(PlayerAction.class);
kryo.register(ScoreboardItem.class);
kryo.register(ScoreboardUpdate.class);
```

**Items & Equipment:**
```java
kryo.register(ItemData.class);
kryo.register(ItemModData.class);
kryo.register(ItemRequirement.class);
kryo.register(ArmorRequirement.class);
kryo.register(ClassRequirement.class);
kryo.register(LevelRequirement.class);
kryo.register(EquippableRequirement.class);
kryo.register(PlayerItemDropData.class);
kryo.register(TrinketUseRequest.class);
kryo.register(TrinketUseUpdate.class);
```

**Données Multijoueur:**
```java
kryo.register(FriendlyPlayerData.class);
kryo.register(EnemyPlayerData.class);
kryo.register(ArenaTeamMemberData.class);
kryo.register(ArenaTeamData.class);
```

**Instanciator Strategy:**
```java
((DefaultInstantiatorStrategy)kryo.getInstantiatorStrategy())
    .setFallbackInstantiatorStrategy(
        new StdInstantiatorStrategy()  // Objenesis
    );
```

---

## 🔍 Insights Techniques

### 1. **Thread-Safety Design**
- Paquets reçus → `LinkedBlockingQueue` (thread-safe)
- Main game thread polls queue sans bloquer
- KryoNet I/O thread indépendant

### 2. **Buffer Sizes**
- TCP Write Buffer: **512 KB** (524280 bytes)
- UDP Buffer: **65535 bytes** (standard MTU)
- Pour jeux temps réel avec haute fréquence d'updates

### 3. **Timing Precision**
- Ping calculation: **nanoseconde precision**
- RTT converted to milliseconds
- Rolling 10-sample average for stability

### 4. **Event Dispatch Pattern**
- Polymorphic: `packet.handle(gameClient)`
- Visitor pattern alternative to massive switch statements
- Each packet type knows how to update game state

### 5. **Latency Handling**
- Automatic region detection (US/EU)
- 5-minute ping check interval
- Threshold: 25 seconds before disconnect

### 6. **Connection State Machine**
```
DISCONNECTED
    ↓
  CONNECTING (ag.b())
    ↓
  CONNECTED (ae.connected())
    ↓
  PLAYING (main game loop)
    ↓
  DISCONNECTING (network lost)
    ↓
DISCONNECTED (ae.disconnected())
```

### 7. **Packet Filtering**
- Map de types `Map<Class, Boolean>`
- Permet d'activer/désactiver types de paquets
- Protéger contre l'envoi de paquets invalides

### 8. **Framework Messages Ignored**
- `FrameworkMessage` instances → skip
- Utilisés par KryoNet pour keepalive/heartbeat
- Pas envoyés à la file d'attente du jeu

---

## 📊 Résumé Architecture

```
┌─────────────────────────────────────────────────────────┐
│ ARENA OF KINGS - KryoNet Network Architecture           │
├─────────────────────────────────────────────────────────┤
│                                                           │
│ Input Layer:          Movement keys → ag.sendTCP()      │
│ Serialization:        Kryo registry (af.a)              │
│ Transport:            TCP/UDP with KryoNet Client       │
│ Listen Events:        ae (Listener interface)           │
│ Deserialization:      Kryo registry (af.a)              │
│ Queue:                LinkedBlockingQueue               │
│ Dispatch:             packet.handle(gameClient)         │
│ Latency Mgmt:         ab (RTT + region detect)          │
│                                                           │
└─────────────────────────────────────────────────────────┘
```

---

## 📚 Fichiers Décompilés Clés

| Classe | Fichier | Rôle |
|--------|---------|------|
| GameClient | [ag.java](ag.java) | Main connection handler |
| NetworkListener | [ae.java](ae.java) | KryoNet event callbacks |
| LatencyManager | [ab.java](ab.java) | Ping/RTT calculation |
| KryoRegistry | [af.java](af.java) | Packet type registration |
| ConnectionBase | [y.java](y.java) | Abstract connection |

---

## 🎯 Conclusion

Le système réseau d'Arena of Kings utilise **KryoNet** pour la communication client-serveur avec:
- **100+ types de paquets** sérialisés
- **Architecture d'événements** via Listener interface
- **Queue thread-safe** pour dispatch asynchrone
- **Gestion de latence** avec détection région automatique
- **Sérialisation rapide** avec Kryo + Objenesis

Le flux: Input → Serialize (Kryo) → Send (KryoNet) → Network → Deserialize → Event Dispatch → Handle → Update Game State
