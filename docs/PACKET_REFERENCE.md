# Arena of Kings - Complete Packet & Data Structure Reference

## 📚 Table des Contenus
1. [Authentification](#authentification)
2. [Contrôle du Jeu](#contrôle-du-jeu)
3. [Latence/Ping](#latenceping)
4. [Mouvement](#mouvement)
5. [Combat](#combat)
6. [Mises à Jour Joueur](#mises-à-jour-joueur)
7. [Spells & Effets](#spells--effets)
8. [Scoreboard](#scoreboard)
9. [Items & Équipement](#items--équipement)
10. [Structures Communes](#structures-communes)
11. [Énumérations](#énumérations)

---

## Authentification

### PUB_MISC_PLAYER_TOKEN
**Direction:** CLIENT → SERVER  
**Envoyé lors:** Connexion établie  
**Contenu:**
```java
public class PUB_MISC_PLAYER_TOKEN extends PublicPacket {
    private String token;        // JWT ou session token
    private int gameID;          // ID de la partie
    
    // Setters
    void setToken(String)
    void setGameID(int)
    
    // Getters
    String getToken()
    int getGameID()
}
```

**Timing:**
- Envoyé immédiatement après `ae.connected()`
- Avant d'autres paquets
- Server répond avec `PUB_GAME_INIT`

**Sécurité:**
⚠️ Authentification basée sur token unique  
⚠️ Risque: Vol de token → Usurpation identité  
⚠️ Solution: TTL sur token, IP binding, encryption TLS

---

### PUB_PLAY_READY
**Direction:** CLIENT → SERVER  
**Envoyé lors:** Joueur prêt à jouer  
**Contenu:**
```java
public class PUB_PLAY_READY extends PublicPacket {
    // Empty - just a signal
}
```

**Usage:** Handshake pour démarrage de match

---

## Contrôle du Jeu

### PUB_GAME_INIT
**Direction:** SERVER → CLIENT  
**Reçu lors:** Connection établie (après token validation)  
**Taille:** 5-50 KB  
**Contenu:**
```java
public class PUB_GAME_INIT extends PublicPacket {
    // Game world initialization data
    private Arena arena;
    private List<Player> players;
    private List<Obstacle> obstacles;
    private Map<Integer, ItemDropData> itemDrops;
    private GameRules rules;
    private long gameStartTime;
    // ... many more fields
    
    // Typically contains:
    // - All player data
    // - Map/arena layout
    // - Current game state
    // - Rules configuration
    // - Time synchronization
}
```

**Processing:**
- Cached in `ae.a = (PUB_GAME_INIT)object`
- NOT added to queue
- Processed synchronously later in `ag.c()`
- Trigger initialization of game scene

**Critical:** Contains full game state

---

### PUB_GAME_STATUS_UPDATE
**Direction:** SERVER → CLIENT  
**Sent when:** Game state changes  
**Contenu:**
```java
public class PUB_GAME_STATUS_UPDATE extends PublicPacket {
    private GameStatus status;
    // enum GameStatus {
    //    IN_PROGRESS,
    //    WAITING,
    //    ENDED,
    //    PAUSED,
    //    RECONNECTING
    // }
}
```

**Triggers:**
- Match starts → `IN_PROGRESS`
- Waiting for players → `WAITING`
- Match ends → `ENDED`
- Server maintenance → `PAUSED`
- Player DC → `RECONNECTING`

---

### PUB_GAME_SNAPSHOT
**Direction:** SERVER → CLIENT  
**Frequency:** ~1-10 per second (variable server rate)  
**Taille:** 50-500 KB (depends on player count)  
**Contenu:**
```java
public class PUB_GAME_SNAPSHOT extends PublicPacket {
    private Snapshot snapshot;
    // Contains:
    // - All player updates (position, health, effects, etc.)
    // - Environment changes
    // - Projectiles/effects in world
    // - Dynamic object states
    
    // Structured as:
    List<PlayerSnapshot> players;
    List<UpdatePacket> updates;        // Incremental changes
    List<EnvironmentalUpdate> envUpdates;
}
```

**Processing:** Added to queue, dispatched in main thread

**Optimization:** Only sends changed data, not full state

---

### PUB_GAME_MESSAGE
**Direction:** SERVER ↔ CLIENT  
**Sent when:** Chat/system message  
**Contenu:**
```java
public class PUB_GAME_MESSAGE extends PublicPacket {
    private int senderID;
    private String senderName;
    private String messageContent;
    private MessageType type;  // CHAT, SYSTEM, NOTICE, etc.
    private long timestamp;
}
```

---

### PUB_GAME_FOG_UPDATE
**Direction:** SERVER → CLIENT  
**Sent when:** Vision/fog of war changes  
**Contenu:**
```java
public class PUB_GAME_FOG_UPDATE extends PublicPacket {
    private int playerID;
    private List<Location> visibleArea;  // Viewable positions
    private List<Location> fogArea;      // Hidden positions
}
```

**Usage:** Prevent client from seeing enemy positions

---

### PUB_GAME_CONNECTION_ESTABLISHED
**Direction:** SERVER → CLIENT  
**Sent when:** After token validation  
**Contenu:**
```java
public class PUB_GAME_CONNECTION_ESTABLISHED extends PublicPacket {
    private int playerID;
    private String gameName;
    private int maxPlayers;
    // Confirmation that connection is valid
}
```

---

### PUB_GAME_SCOREBOARD_UPDATE
**Direction:** SERVER → CLIENT  
**Frequency:** Every 2-5 seconds  
**Contenu:**
```java
public class PUB_GAME_SCOREBOARD_UPDATE extends PublicPacket {
    private ScoreboardUpdate update;
    // Contains score changes for ranking display
}
```

---

## Latence/Ping

### PUB_GAME_PING
**Direction:** CLIENT → SERVER  
**Sent:** Every 5 seconds (from ab.a())  
**Contenu:**
```java
public class PUB_GAME_PING extends PublicPacket {
    // Empty - just a timestamp on wire
    // Client records nanoTime() when sending
}
```

**Timing:**
```
Client.nanoTime() = T0
    ↓
Send PUB_GAME_PING to server
    ↓ (~network delay~)
Server receives (T1)
Server immediately responds
    ↓ (~network delay~)
Client receives PUB_GAME_PING_RESPONSE (T2)

RTT_ms = floor((T2 - T0) / 1_000_000)
```

---

### PUB_GAME_PING_RESPONSE
**Direction:** SERVER → CLIENT  
**Sent:** Immediately after receiving ping  
**Contenu:**
```java
public class PUB_GAME_PING_RESPONSE extends PublicPacket {
    // Empty - server just echoes back
}
```

**Processing (in ae.received()):**
```java
if (object instanceof PUB_GAME_PING_RESPONSE) {
    this.a.a().a(System.nanoTime());  // ab.a(nanoTime)
    return;  // ← NOT queued, processed immediately
}
```

**Latency Calculation (ab.java):**
```
Incoming ping response time = nanoTime()
RTT = floor(toMillis(end - start))
→ Add to rolling 10-sample buffer
→ Update average ping
```

**Region Detection:**
```java
// Every 5 minutes:
us_ping = icmp_ping("3.80.0.0");   // AWS US-EAST
eu_ping = icmp_ping("3.64.0.0");   // AWS EU-WEST
selectedRegion = us_ping < eu_ping ? US_EAST : EU_WEST;
```

---

## Mouvement

### MOVE_REQUEST_* (8 directions)

**Packets:**
- `MOVE_REQUEST_NORTH`
- `MOVE_REQUEST_SOUTH`
- `MOVE_REQUEST_EAST`
- `MOVE_REQUEST_WEST`
- `MOVE_REQUEST_NORTH_EAST`
- `MOVE_REQUEST_NORTH_WEST`
- `MOVE_REQUEST_SOUTH_EAST`
- `MOVE_REQUEST_SOUTH_WEST`

**Direction:** CLIENT → SERVER  
**Frequency:** 5-10 per second (input driven)  
**Contenu:**
```java
public class MOVE_REQUEST_NORTH extends PublicPacket {
    // Direction encoded in class name
    // Usually just a signal, position calculated server-side
}
```

**Processing:**
1. Player presses movement key
2. Game sends `MOVE_REQUEST_NORTH`
3. Server receives → updates player velocity
4. Server broadcasts `PlayerMovementPressNorthUpdate`
5. All clients update display

---

### MOVE_RELEASE_* (8 directions)

**Packets:**
- `MOVE_RELEASE_NORTH`
- `MOVE_RELEASE_SOUTH`
- `MOVE_RELEASE_EAST`
- `MOVE_RELEASE_WEST`
- `MOVE_RELEASE_NORTH_EAST`
- `MOVE_RELEASE_NORTH_WEST`
- `MOVE_RELEASE_SOUTH_EAST`
- `MOVE_RELEASE_SOUTH_WEST`

**Direction:** CLIENT → SERVER  
**Frequency:** When player releases key  
**Contenu:**
```java
public class MOVE_RELEASE_NORTH extends PublicPacket {
    // Signals to stop moving in this direction
}
```

**Processing:**
1. Player releases key
2. Game sends `MOVE_RELEASE_NORTH`
3. Server updates player velocity to 0
4. Server broadcasts `PlayerMovementReleaseNorthUpdate`

---

### MOVE_FORCE_POSITION_REQUEST
**Direction:** CLIENT ← SERVER (actually CLIENT → SERVER for validation)  
**Usage:** Server corrects position if client desyncs  
**Contenu:**
```java
public class MOVE_FORCE_POSITION_REQUEST extends PublicPacket {
    private Location targetPosition;
}
```

**Scenario:**
- Client says it's at X=100, Y=50
- Server calculates it should be at X=95, Y=48
- Difference > threshold
- Server sends MOVE_FORCE_POSITION_REQUEST(X=95, Y=48)
- Client snaps to server position

---

### MOVEMENT_UPDATE
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class MOVEMENT_UPDATE extends PublicPacket {
    private int playerID;
    private Location newPosition;
    private Vector2 velocity;
}
```

---

## Combat

### SPELL_REQUEST
**Direction:** CLIENT → SERVER  
**Frequency:** 1-2 per spell cast  
**Contenu:**
```java
public class SPELL_REQUEST extends PublicPacket {
    private SpellName spellID;
    private int targetPlayerID;        // -1 if untargeted
    private Location targetLocation;   // For ground-targeted spells
    private int skillLevel;
}
```

**Timing:**
1. Player clicks spell icon
2. Client validates: cooldown, mana, range
3. Send SPELL_REQUEST
4. Server validates again
5. If valid: apply spell, broadcast updates
6. If invalid: send error response

---

### SpellRequest
**Direction:** CLIENT → SERVER  
**Contenu:**
```java
public class SpellRequest extends PublicPacket {
    private Spell spell;  // Full spell object
    private Player target;
    private Location targetLocation;
}
```

---

### MOVE_SPELL_REQUEST
**Direction:** CLIENT → SERVER  
**Contenu:**
```java
public class MOVE_SPELL_REQUEST extends PublicPacket {
    private SpellName spellID;
    private Direction moveDirection;
    private Location targetLocation;
}
```

**Usage:** Cast spell while moving (skillshot)

---

### DIRECTION_CHANGE_REQUEST
**Direction:** CLIENT → SERVER  
**Frequency:** 1-5 per second (look direction)  
**Contenu:**
```java
public class DIRECTION_CHANGE_REQUEST extends PublicPacket {
    private Direction newDirection;  // N, NE, E, SE, S, SW, W, NW
}
```

**Enum Direction:**
```java
public enum Direction {
    NORTH(0),
    NORTH_EAST(45),
    EAST(90),
    SOUTH_EAST(135),
    SOUTH(180),
    SOUTH_WEST(225),
    WEST(270),
    NORTH_WEST(315);
}
```

---

### TargetRequest
**Direction:** CLIENT → SERVER  
**Sent when:** Player changes target  
**Contenu:**
```java
public class TargetRequest extends PublicPacket {
    private int targetPlayerID;
}
```

---

### TargetOfTargetRequest
**Direction:** CLIENT → SERVER  
**Sent when:** Player targets enemy's target  
**Contenu:**
```java
public class TargetOfTargetRequest extends PublicPacket {
    // Request to target the target of current target
}
```

---

### TRINKET_REQUEST_0
**Direction:** CLIENT → SERVER  
**Sent when:** Player uses trinket slot 0  
**Contenu:**
```java
public class TRINKET_REQUEST_0 extends PublicPacket {
    private int trinketItemID;
    private int targetPlayerID;  // If applicable
}
```

---

### ItemPickupRequest
**Direction:** CLIENT → SERVER  
**Sent when:** Player clicks on ground loot  
**Contenu:**
```java
public class ItemPickupRequest extends PublicPacket {
    private int itemDropID;
}
```

---

### ItemRemove
**Direction:** CLIENT → SERVER  
**Sent when:** Player drops item from inventory  
**Contenu:**
```java
public class ItemRemove extends PublicPacket {
    private int itemID;
    private Location dropLocation;
}
```

---

## Mises à Jour Joueur

### PlayerCoordinateUpdate
**Direction:** SERVER → CLIENT  
**Frequency:** ~10-20 per second  
**Contenu:**
```java
public class PlayerCoordinateUpdate extends PlayerUpdate {
    private int playerID;
    private Location position;
    private Vector2 velocity;
}
```

---

### PlayerDirectionChange
**Direction:** SERVER → CLIENT  
**Frequency:** 1-5 per second  
**Contenu:**
```java
public class PlayerDirectionChange extends PlayerUpdate {
    private int playerID;
    private Direction facingDirection;
}
```

---

### PlayerDeathUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Player dies  
**Contenu:**
```java
public class PlayerDeathUpdate extends PlayerUpdate {
    private int playerID;
    private int killerID;
    private Location deathLocation;
    private long respawnTime;  // Milliseconds until respawn
}
```

---

### PlayerHealthManaUpdate
**Direction:** SERVER → CLIENT  
**Frequency:** 5 per second (when values change)  
**Contenu:**
```java
public class PlayerHealthManaUpdate extends PlayerUpdate {
    private int playerID;
    private int currentHealth;
    private int currentMana;
    private int damageDealt;   // If this update caused damage
    private String damageSource;
}
```

---

### PlayerMaxHealthUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Max health changes (buffs, level up, etc.)  
**Contenu:**
```java
public class PlayerMaxHealthUpdate extends PlayerUpdate {
    private int playerID;
    private int newMaxHealth;
}
```

---

### PlayerMovementPressNorthUpdate
**Direction:** SERVER → CLIENT  
**Broadcast after:** Receiving MOVE_REQUEST_NORTH  
**Contenu:**
```java
public class PlayerMovementPressNorthUpdate extends PlayerUpdate {
    private int playerID;
    private Vector2 velocity;  // Updated velocity
}
```

**Similar classes:** (Release versions & other directions)
- `PlayerMovementPressSouthUpdate`
- `PlayerMovementPressEastUpdate`
- `PlayerMovementPressWestUpdate`
- `PlayerMovementReleaseNorthUpdate`
- `PlayerMovementReleaseEastUpdate`
- `PlayerMovementReleaseSouthUpdate`
- `PlayerMovementReleaseWestUpdate`

---

### PlayerMovementActionUpdate
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class PlayerMovementActionUpdate extends PlayerUpdate {
    private int playerID;
    private PlayerAction action;  // What player is doing
    // enum PlayerAction { IDLE, MOVING, ATTACKING, CASTING, etc. }
}
```

---

### PlayerEffectAdd
**Direction:** SERVER → CLIENT  
**Sent when:** Buff/debuff applied  
**Contenu:**
```java
public class PlayerEffectAdd extends PlayerUpdate {
    private int playerID;
    private Effect effect;
    private long duration;  // Milliseconds
    private int stackCount;
}
```

---

### PlayerEffectRemove
**Direction:** SERVER → CLIENT  
**Sent when:** Buff/debuff expires or is cleansed  
**Contenu:**
```java
public class PlayerEffectRemove extends PlayerUpdate {
    private int playerID;
    private String effectID;
    private RemovalReason reason;  // EXPIRED, CLEANSED, etc.
}
```

---

### PlayerEffectUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Effect state changes (damage tick, stack update, etc.)  
**Contenu:**
```java
public class PlayerEffectUpdate extends PlayerUpdate {
    private int playerID;
    private String effectID;
    private int newStackCount;
    private long timeRemaining;
}
```

---

### PlayerComboPointUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Combo points change (class-dependent)  
**Contenu:**
```java
public class PlayerComboPointUpdate extends PlayerUpdate {
    private int playerID;
    private int comboPoints;  // 0-5 typically
    private int maxComboPoints;
}
```

---

### PlayerTargetUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Player's target changes  
**Contenu:**
```java
public class PlayerTargetUpdate extends PlayerUpdate {
    private int playerID;
    private int targetID;  // -1 if no target
}
```

---

### PlayerInterrupted
**Direction:** SERVER → CLIENT  
**Sent when:** Player's spell is interrupted  
**Contenu:**
```java
public class PlayerInterrupted extends PlayerUpdate {
    private int playerID;
    private int interrupterID;
    private String reason;  // CC, low health, etc.
}
```

---

### PlayerSelfInterrupt
**Direction:** SERVER → CLIENT  
**Sent when:** Player cancels own spell  
**Contenu:**
```java
public class PlayerSelfInterrupt extends PlayerUpdate {
    private int playerID;
}
```

---

### PlayerGCDReset
**Direction:** SERVER → CLIENT  
**Sent when:** Global cooldown resets (spell just cast)  
**Contenu:**
```java
public class PlayerGCDReset extends PlayerUpdate {
    private int playerID;
    private long gcdDuration;
}
```

---

### PlayerSpellDestroyedUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Spell projectile/area destroyed  
**Contenu:**
```java
public class PlayerSpellDestroyedUpdate extends PlayerUpdate {
    private int playerID;
    private int spellInstanceID;
    private DestroyReason reason;  // HIT_ENEMY, EXPIRED, CANCELLED, etc.
}
```

---

### PlayerSnapshot
**Direction:** SERVER → CLIENT  
**Frequency:** Once per PUB_GAME_SNAPSHOT  
**Contenu:**
```java
public class PlayerSnapshot extends PlayerUpdate {
    private int playerID;
    // Complete player state snapshot:
    private Location position;
    private Direction facing;
    private int health;
    private int mana;
    private List<Effect> activeEffects;
    private Equipment equipment;
    private int level;
    private int experience;
    // ... complete state dump
}
```

---

### PlayerUpdateList
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class PlayerUpdateList extends PublicPacket {
    private List<PlayerUpdate> updates;
    // Batch of player updates
}
```

---

### PlayerUpdate (Base Class)
**Direction:** SERVER → CLIENT  
**Abstract base for all player update types**
```java
public abstract class PlayerUpdate extends PublicPacket {
    protected int playerID;
    protected long timestamp;
    
    abstract void handle(GameClient client);
}
```

---

### PlayerUpdateBundle
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class PlayerUpdateBundle extends PublicPacket {
    private List<PlayerUpdate> updates;  // Multiple update types bundled
    private long timestamp;
}
```

---

### Snapshot
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class Snapshot extends PublicPacket {
    private long snapshotID;
    private long timestamp;
    private List<PlayerSnapshot> players;
    private List<EnvironmentalObject> objects;
}
```

---

## Spells & Effets

### PlayerSpellCastStart
**Direction:** SERVER → CLIENT  
**Sent when:** Player begins casting  
**Contenu:**
```java
public class PlayerSpellCastStart extends PlayerUpdate {
    private int playerID;
    private SpellName spellID;
    private int castTime;  // Milliseconds
    private int targetID;  // If applicable
    private Location targetLocation;
}
```

---

### PlayerSpellUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Spell state changes  
**Contenu:**
```java
public class PlayerSpellUpdate extends PlayerUpdate {
    private int playerID;
    private int spellInstanceID;
    private SpellState state;  // CASTING, RESOLVED, HIT, MISS, etc.
    private Location spellLocation;
}
```

---

### SpellClassification
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class SpellClassification extends PublicPacket {
    private SpellName spellID;
    private SpellType type;  // PROJECTILE, INSTANT, CHANNEL, etc.
    private SpellTargetType targetType;  // SINGLE, AOE, LINE, etc.
    private int baseDamage;
    private int castTime;
    private int cooldown;
}
```

---

### Spell Cast Types

**DynamicPlayerSpellStart**
- Cast on moving target (lead calculation)

**DynamicPlayerSpellFinish**
- Dynamic spell resolution

**DynamicCoordinateSpellFinish**
- Spell at calculated coordinate

**FixedPlayerSpellStart**
- Instant cast on fixed target

**FixedPlayerSpellFinish**
- Fixed spell effect

**FixedCoordinateSpellStart**
- Cast at fixed location

**FixedCoordinateSpellFinish**
- Effect at fixed coordinate

**TargetedProjectileSpellStart**
- Projectile spell begins (target tracking)

**TargetedProjectileSpellFinish**
- Projectile resolves on target

---

### Effect Events

**SCT_Event** (Floating Combat Text)
```java
public class SCT_Event extends PublicPacket {
    private int playerID;
    private String eventText;
    private Location displayLocation;
    private Color eventColor;  // Red=damage, Green=heal, etc.
    private long displayDuration;
}
```

**SCT_FloatingFeedbackText**
```java
public class SCT_FloatingFeedbackText extends PublicPacket {
    private String text;
    private Location position;
    private Color color;
    private int fontSize;
}
```

**SCT_PlayerHealthChange**
```java
public class SCT_PlayerHealthChange extends PublicPacket {
    private int playerID;
    private int healthDelta;  // Positive=heal, Negative=damage
    private int newHealth;
    private int maxHealth;
    private DamageType damageType;  // Physical, Magical, etc.
}
```

**SCT_PlayerManaChange**
```java
public class SCT_PlayerManaChange extends PublicPacket {
    private int playerID;
    private int manaDelta;
    private int newMana;
    private int maxMana;
}
```

---

## Scoreboard

### ScoreboardUpdate
**Direction:** SERVER → CLIENT  
**Frequency:** Every 2-5 seconds  
**Contenu:**
```java
public class ScoreboardUpdate extends PublicPacket {
    private List<ScoreboardItem> items;  // Team 1 items
    private List<ScoreboardItem> items2; // Team 2 items
    private List<ScoreboardChange> changes;  // Delta updates
}
```

---

### ScoreboardItem
**Direction:** Part of ScoreboardUpdate  
**Contenu:**
```java
public class ScoreboardItem extends PublicPacket {
    private int playerID;
    private String playerName;
    private int kills;
    private int deaths;
    private int assists;
    private int damage;
    private int healing;
    private int gold;
    private int level;
    private CharacterClass class;
}
```

---

## Items & Équipement

### ItemData
**Direction:** SERVER → CLIENT  
**Contenu:**
```java
public class ItemData extends PublicPacket {
    private int itemID;
    private String itemName;
    private String description;
    private int rarity;  // Common, Rare, Epic, Legendary
    private int level;
    private ItemArmorType armorType;  // Armor, Weapon, etc.
    private int baseDamage;
    private int armor;
    private int health;
    private List<ItemRequirement> requirements;
    private List<ItemModData> mods;
}
```

---

### ItemModData
**Direction:** Part of ItemData  
**Contenu:**
```java
public class ItemModData extends PublicPacket {
    private String modID;
    private String modName;
    private int modifier1;  // Attack power, Defense, etc.
    private int modifier2;
}
```

---

### ItemRequirement (Abstract)
```java
public abstract class ItemRequirement {
    abstract boolean isMet(Player player);
}
```

**Implementations:**
- `LevelRequirement`: Minimum level
- `ClassRequirement`: Specific class only
- `ArmorRequirement`: Armor type check
- `EquippableRequirement`: Equipment slot check

---

### ItemLocation
**Direction:** Server → Client  
**Enum:**
```java
public enum ItemLocation {
    INVENTORY,       // Backpack
    EQUIPPED,        // Wearing
    GROUND,          // On ground (loot)
    STASH,           // Storage
    VENDOR,          // NPC shop
    AUCTION,         // Player shop
    TRASH            // Deleted
}
```

---

### ItemSlot
**Direction:** Server → Client  
**Enum:**
```java
public enum ItemSlot {
    HEAD,
    NECK,
    CHEST,
    BACK,
    WRIST,
    HANDS,
    WAIST,
    LEGS,
    FEET,
    FINGER1,
    FINGER2,
    TRINKET1,
    TRINKET2,
    MAIN_HAND,
    OFF_HAND
}
```

---

### PlayerItemDropData
**Direction:** SERVER → CLIENT  
**Sent when:** Item drops on ground  
**Contenu:**
```java
public class PlayerItemDropData extends PublicPacket {
    private int dropID;
    private ItemData item;
    private Location dropLocation;
    private int droppedByPlayerID;
    private long expirationTime;  // When loot despawns
    private boolean isReservedToPlayer;  // If reserved, only this player can pick up
    private int reservedPlayerID;
}
```

---

### TrinketUseRequest
**Direction:** CLIENT → SERVER  
**Sent when:** Player uses trinket  
**Contenu:**
```java
public class TrinketUseRequest extends PublicPacket {
    private int trinketItemID;
    private int targetPlayerID;  // If applicable
    private Location targetLocation;
}
```

---

### TrinketUseUpdate
**Direction:** SERVER → CLIENT  
**Sent when:** Trinket effect resolves  
**Contenu:**
```java
public class TrinketUseUpdate extends PublicPacket {
    private int playerID;
    private int trinketItemID;
    private String effectApplied;
    private long effectDuration;
}
```

---

## Structures Communes

### Location
**Direction:** Utilisé partout (structure imbriquée)  
**Contenu:**
```java
public class Location {
    public float x;
    public float y;
    public float z;  // Height/elevation
    
    // Methods
    double distance(Location other)
    boolean isInRange(Location other, float range)
}
```

---

### Vector2
**Direction:** Utilisé pour velocité/direction  
**Contenu:**
```java
public class Vector2 {
    public float x;
    public float y;
    
    // Methods
    float length()
    Vector2 normalize()
    float dot(Vector2 other)
}
```

---

### Target
**Direction:** Cible utilisée dans combat  
**Contenu:**
```java
public class Target {
    private int targetID;
    private Location targetLocation;
    private TargetType type;  // PLAYER, OBJECT, LOCATION
}
```

---

### HitCircle
**Direction:** Collision/hitbox  
**Contenu:**
```java
public class HitCircle {
    private Location center;
    private float radius;
    
    boolean intersects(HitCircle other)
    boolean contains(Location point)
}
```

---

### EffectList
**Direction:** Collection d'effets  
**Contenu:**
```java
public class EffectList extends ArrayList<Effect> {
    // List of active effects on entity
}
```

---

### PlayerAction
**Direction:** Enum action actuelle du joueur  
**Enum:**
```java
public enum PlayerAction {
    IDLE,
    MOVING,
    ATTACKING,
    CASTING_SPELL,
    CHANNELING,
    STUNNED,
    DEAD,
    REVIVING
}
```

---

### Conveyorable
**Direction:** Interface pour objets transmissibles  
**Contenu:**
```java
public interface Conveyorable {
    byte[] serialize();
    void deserialize(byte[] data);
}
```

---

### PlayerActionUpdate
**Direction:** Structure mise à jour action  
**Contenu:**
```java
public class PlayerActionUpdate {
    private PlayerAction action;
    private long timestamp;
    private int targetID;
}
```

---

### PlayerPositionUpdate
**Direction:** Structure mise à jour position  
**Contenu:**
```java
public class PlayerPositionUpdate {
    private Location position;
    private Vector2 velocity;
    private Direction facing;
    private long timestamp;
}
```

---

### UpdatePacket (Wrapper)
**Direction:** Conteneur générique  
**Contenu:**
```java
public class UpdatePacket {
    private Object updateData;
    private UpdateType type;
    private long timestamp;
}
```

---

### CollisionEvent
**Direction:** SERVER → CLIENT  
**Sent when:** Collision occurs  
**Contenu:**
```java
public class CollisionEvent extends PublicPacket {
    private int player1ID;
    private int player2ID;
    private Location collisionPoint;
    private float impactForce;
}
```

---

## Énumérations

### GameStatus
```java
public enum GameStatus {
    WAITING,        // Waiting for players
    STARTING,       // Countdown
    IN_PROGRESS,    // Match active
    PAUSED,         // Server pause
    ENDED,          // Match finished
    CANCELLED,      // Match aborted
    RECONNECTING    // Disconnected player reconnecting
}
```

---

### CharacterClass
```java
public enum CharacterClass {
    WARRIOR,
    MAGE,
    ROGUE,
    PRIEST,
    PALADIN,
    DRUID,
    MONK,
    HUNTER,
    WARLOCK,
    DEATH_KNIGHT,
    DEMON_HUNTER,
    EVOKER
}
```

---

### GameType
```java
public enum GameType {
    ARENA_1V1,
    ARENA_2V2,
    ARENA_3V3,
    BATTLEGROUND_10V10,
    BATTLEGROUND_20V20,
    DEATHMATCH,
    CAPTURE_THE_FLAG,
    DOMINATION,
    TEAM_DEATHMATCH
}
```

---

### Privilege
```java
public enum Privilege {
    PLAYER,
    MODERATOR,
    ADMIN,
    DEVELOPER,
    BANNED,
    MUTED
}
```

---

### PlayerStatus
```java
public enum PlayerStatus {
    ONLINE,
    OFFLINE,
    AWAY,
    IDLE,
    IN_GAME,
    IN_ARENA,
    DEAD,
    RESPAWNING,
    AFAR_AWAY,
    HIDDEN
}
```

---

### Direction
```java
public enum Direction {
    NORTH(0),
    NORTH_EAST(45),
    EAST(90),
    SOUTH_EAST(135),
    SOUTH(180),
    SOUTH_WEST(225),
    WEST(270),
    NORTH_WEST(315);
}
```

---

### SpellName
```java
public enum SpellName {
    // Class-specific spells here
    // WARRIOR: Charge, Whirlwind, Shield Bash, etc.
    // MAGE: Fireball, Frostbolt, Ice Storm, etc.
    // etc...
}
```

---

### LocationType
```java
public enum LocationType {
    ABSOLUTE,       // World coordinates
    RELATIVE,       // Relative to player
    VIEWPORT,       // Screen coordinates
    TERRAIN_RELATIVE
}
```

---

### ItemArmorType
```java
public enum ItemArmorType {
    CLOTH,
    LEATHER,
    CHAINMAIL,
    PLATE,
    SHIELD,
    WEAPON,
    TRINKET,
    ACCESSORY
}
```

---

### ItemDBState
```java
public enum ItemDBState {
    ACTIVE,
    INACTIVE,
    DELETED,
    ARCHIVED,
    SUSPENDED
}
```

---

### ArenaName
```java
public enum ArenaName {
    ARENA_RUINS,
    ARENA_ICE_TEMPLE,
    ARENA_INFERNO,
    ARENA_STORM,
    ARENA_FORGOTTEN_CRYPT,
    ARENA_DRAGON_ROOST,
    ARENA_GOLDEN_CITY
}
```

---

### Region
```java
public enum Region {
    US_EAST("3.80.0.0"),
    US_WEST("3.80.0.1"),
    EU_WEST("3.64.0.0"),
    EU_CENTRAL("3.64.0.1"),
    ASIA_PACIFIC("3.79.0.0"),
    SOUTH_AMERICA("3.82.0.0")
}
```

---

### DamageType
```java
public enum DamageType {
    PHYSICAL,
    MAGICAL,
    FIRE,
    FROST,
    NATURE,
    ARCANE,
    SHADOW,
    HOLY,
    CHAOS
}
```

---

### SpellTargetType
```java
public enum SpellTargetType {
    SINGLE_TARGET,
    AOE_CIRCLE,
    AOE_RECTANGLE,
    CONE,
    LINE,
    SELF,
    GROUND_TARGETED,
    CHANNELED
}
```

---

## 📊 Statistics Résumé

### Total Packet Types Registered in Kryo: **100+**

**Breakdown:**
- Authentication: 2
- Game Control: 7
- Ping/Latency: 2
- Movement: 18 (8 MOVE_REQUEST + 8 MOVE_RELEASE + 2 special)
- Combat: 9
- Player Updates: 40+
- Spells & Effects: 15+
- Scoreboard: 3
- Items: 10+
- Structures & Enums: 20+

**By Direction:**
- Client → Server: ~35 packets
- Server → Client: ~65 packets
- Bidirectional: 1-2 packets

---

This reference guide covers all documented packet types and data structures used in the Arena of Kings KryoNet protocol.
