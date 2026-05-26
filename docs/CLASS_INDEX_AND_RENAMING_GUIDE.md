# 🎮 Arena of Kings - Complete Class Index & Renaming Guide

**Generated:** May 26, 2026  
**Total Classes Documented:** 75+  
**Coverage:** Core game logic and systems  

---

## Quick Navigation

- [Phase 1: Critical Network & State Classes](#phase-1-critical-network--state-classes)
- [Phase 2: UI & Combat Classes](#phase-2-ui--combat-classes)
- [Phase 3: Data & Utility Classes](#phase-3-data--utility-classes)
- [Alphabetical Index](#alphabetical-index)
- [Reverse Index (By Purpose)](#reverse-index-by-purpose)

---

## Phase 1: Critical Network & State Classes

### ⚡ MUST-RENAME FIRST (These are dependencies for all other systems)

#### Network Foundation (Files: y, ag, ae, ab, af)

##### 1️⃣ y.java → NetworkBase.java
**Status:** Critical - Network abstraction layer  
**Current Name:** `y`  
**Purpose:** Abstract base class for all network operations  
**Key Methods:**
- `ab_a()` → `getKryoRegistry()`
- `com_esotericsoftware_kryonet_Connection_a()` → `getConnection()`
- `boolean_a()` → `isConnected()`
- `a(boolean)` → `setConnected(boolean)`

**Inheritance:**
- Parent: (none - abstract base)
- Children: `ag` (GameServerClient)

**Dependencies:** KryoNet library  
**Why Important:** All network operations flow through this base class

---

##### 2️⃣ ag.java → GameServerClient.java
**Status:** Critical - Main client connection manager  
**Current Name:** `ag`  
**Extends:** `y` (NetworkBase)  
**Purpose:** Manages KryoNet client connection, packet queuing, and game server communication

**Key Methods:**
- `void_a()` → `initializePacketRegistry()`
- `a(Object)` → `sendPacket(Object)`
- `ab_a()` → `getKryoRegistry()`
- `a(boolean)` → `setConnected(boolean)`

**Fields:**
- `var_java_util_concurrent_LinkedBlockingQueue_com_arenaofkings_packets_misc_PublicPacket__a` → `packetQueue`
- `var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a` → `pingPacket`
- `var_ae_a` → `gameServerListener`

**Key Constants:**
- `MOVE_REQUEST_NORTH`, `MOVE_REQUEST_SOUTH` (8 movement directions)
- Movement + targeting packet types

**Why Important:** All server communication happens here

**Usage Example:**
```java
GameServerClient client = ay.ay_a().getGameServerClient();
client.sendPacket(new SpellCastRequest(spell, target));
```

---

##### 3️⃣ ae.java → GameServerListener.java
**Status:** Critical - Network event listener  
**Current Name:** `ae`  
**Implements:** `com.esotericsoftware.kryonet.Listener`  
**Purpose:** KryoNet event handler for server connection lifecycle

**Key Methods:**
- `connected(Connection)` → Handle connection established
- `disconnected(Connection)` → Handle connection lost
- `received(Connection, Object)` → Handle packet received

**Lifecycle Events:**
1. **connected()** - Server connection opened
   - Send authentication token
   - Initialize game
   
2. **disconnected()** - Server connection closed
   - Game ended or disconnected
   - Show reconnect dialog
   
3. **received()** - Packet received from server
   - PUB_GAME_INIT - Game initialization
   - PUB_GAME_SNAPSHOT - State synchronization
   - PUB_GAME_PING_RESPONSE - Latency measurement
   - Other game events

**Why Important:** Controls all network event handling

---

##### 4️⃣ ab.java → KryoRegistry.java
**Status:** Critical - Kryo serialization registry  
**Current Name:** `ab`  
**Extends:** `HashMap<Class, Boolean>`  
**Purpose:** Registers packet types with Kryo for binary serialization

**Key Method:**
- Constructor: Registers 100+ packet classes

**Packet Types Registered:**
- Movement packets (MOVE_REQUEST_*, MOVE_RELEASE_*)
- Spell packets (SpellCastRequest, TargetRequest)
- Game updates (PUB_GAME_SNAPSHOT, PlayerUpdateBundle)
- Control packets (DIRECTION_CHANGE_REQUEST, etc.)

**Why Important:** Without proper packet registration, serialization fails

---

##### 5️⃣ af.java → PacketDispatcher.java
**Status:** High Priority - Central packet router  
**Current Name:** `af`  
**Purpose:** Dispatches received packets to appropriate handlers

**Architecture:**
```
GameServerListener.received(packet)
    ↓
PacketDispatcher.dispatch(packet)
    ↓
Handler for packet type
    ↓
Update game state
```

**Why Important:** Routes 50+ packet types correctly

---

### 🎮 Game State Management (Files: ay, br, al, aq, gd, gf, ge, ef)

##### 6️⃣ ay.java → PlayerStateManager.java
**Status:** CRITICAL - SINGLETON INSTANCE  
**Current Name:** `ay`  
**Extends:** `br` (PlayerBase)  
**Purpose:** Global player state holder (SINGLETON PATTERN)

**Singleton Access:**
```java
PlayerStateManager player = ay.ay_a();  // Get instance
```

**Key Fields:**
- `var_gd_a` → `gameDomain`
- `var_gf_a` → `friendlyPlayers`
- `var_ge_a` → `enemyPlayers`
- `var_ef_a` → `uiStateManager`
- `com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a` → `myAccountData`

**Key Methods:**
- `gd_a()` → `getGameDomain()`
- `gu_a()` → `getActiveCharacter()`
- `gf_a()` → `getFriendlyPlayers()`
- `ge_a()` → `getEnemyPlayers()`
- `br_a(String name)` → `findPlayerByName(String)`

**Why Important:** All game state flows through here

**Lifecycle:**
1. Created on game login
2. Updated with PUB_GAME_INIT
3. Updated with each PUB_GAME_SNAPSHOT
4. Destroyed on logout

---

##### 7️⃣ br.java → PlayerBase.java
**Status:** Critical - Base class for all players  
**Current Name:** `br`  
**Implements:** `Comparable<br>`  
**Purpose:** Abstract base class for player/actor representation

**Key Fields:**
- `var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a` → `sharedAccountData`
- `var_int_a` → `playerID`
- `var_com_arenaofkings_packets_misc_PartyRole_a` → `partyRole`

**Key Methods:**
- `com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a()` → `getSharedAccountData()`
- `b(float, Engine)` → `renderEffectsBack(float, Engine)`
- `c(float, Engine)` → `renderEffectsFront(float, Engine)`
- `d(float, Engine)` → `updateCombat(float, Engine)`

**Subclasses:**
- `ay` → PlayerStateManager (local player)
- `al` → FriendlyPlayerManager (allied player)
- `aq` → EnemyPlayerManager (enemy player)

**Why Important:** Parent class for all player types in game

---

##### 8️⃣ al.java → FriendlyPlayerManager.java
**Status:** High Priority - Allied player management  
**Current Name:** `al`  
**Extends:** `br` (PlayerBase)  
**Purpose:** Manages allied/friendly player

**Key Methods:**
- Inherited from PlayerBase
- Team member specific logic

**Data:**
- Friendly player shared account data
- Visible to current player
- Can see health/buffs

---

##### 9️⃣ aq.java → EnemyPlayerManager.java
**Status:** High Priority - Enemy player management  
**Current Name:** `aq`  
**Extends:** `br` (PlayerBase)  
**Purpose:** Manages enemy player

**Key Methods:**
- Inherited from PlayerBase
- Enemy-specific visibility logic

**Data:**
- Enemy player shared account data
- Limited visibility rules
- Cannot see certain buffs

---

##### 🔟 gd.java → GameDomain.java
**Status:** Critical - Game context holder  
**Current Name:** `gd`  
**Purpose:** Holds game context and settings

**Key Fields:**
- `java_lang_String_a()` → `getAuthToken()`
- `i()` → `getGameMode()` (returns 1, 2, or 3)
- `zg_a()` → `getTeamInfo()`
- `bu_a()` → `getUIStage()`
- `boolean_b()` → `isGameActive()`

**Why Important:** Central context for current game

---

##### 1️⃣1️⃣ gf.java → FriendlyPlayersContainer.java
**Status:** High Priority - Friendly players collection  
**Current Name:** `gf`  
**Purpose:** Container for all friendly/allied players

**Key Methods:**
- `a()` → `getPlayers()` (returns Map/Collection)
- Iteration over friendly players

**Data Structure:**
```
Map<String, PlayerBase>
  - Key: player identifier (name)
  - Value: PlayerBase instance (FriendlyPlayerManager)
```

---

##### 1️⃣2️⃣ ge.java → EnemyPlayersContainer.java
**Status:** High Priority - Enemy players collection  
**Current Name:** `ge`  
**Purpose:** Container for all enemy players

**Key Methods:**
- `a()` → `getEnemies()` (returns Map/Collection)
- Iteration over enemy players

---

##### 1️⃣3️⃣ ef.java → PlayerUIStateManager.java
**Status:** Medium Priority - UI state management  
**Current Name:** `ef`  
**Purpose:** Manages UI-related state for player

**Manages:**
- UI overlay states
- Dialog states
- UI widget states

---

---

## Phase 2: UI & Combat Classes

### 🎨 UI/Rendering Layer (Files: axc, agd, we, axm, axh, bd, aho, + dialogs)

#### Screen Management

##### axc.java → BaseScreen.java
**Purpose:** Abstract LibGDX Screen base  
**Implements:** `com.badlogic.gdx.Screen`

##### agd.java → GameScreen.java
**Purpose:** Main gameplay screen  
**Extends:** BaseScreen

##### we.java → LobbyScreen.java
**Purpose:** Lobby/menu screen  
**Extends:** BaseScreen

#### UI Components

##### axm.java → ResourceManager.java
**Purpose:** Asset loader (textures, fonts, etc.)

##### axh.java → UIWidget.java
**Purpose:** Base UI widget (LibGDX Actor)

##### bd.java → CharacterProfileUI.java
**Purpose:** Character profile display

##### aho.java → CharacterNameplate.java
**Purpose:** Character nameplate UI  
**Extends:** CharacterVisualBase

---

### ⚔️ Combat & Logic (Files: cr, da, h, el, azv)

##### cr.java → CombatSystem.java
**Purpose:** Spell casting and combat logic

##### da.java → AnimationManager.java
**Purpose:** Character animation controller

##### h.java → SpellNameEnum.java
**Purpose:** Spell ID to name mapping

##### el.java → CharacterStats.java
**Purpose:** Character statistics holder

##### azv.java → Timer.java
**Purpose:** Cooldown/timed event scheduler

---

### ⌨️ Input System (Files: aj, aci, aax, aal)

##### aj.java → KeyboardInputHandler.java
**Purpose:** Keyboard input processor

##### aci.java → InputEnum.java
**Purpose:** Key to action mapping

---

## Phase 3: Data & Utility Classes

### 📊 Data/Enum Classes

| Old | New | Purpose |
|-----|-----|---------|
| abi | StoreItemEnum | Store items (50+) |
| abe | GameStatusEnum | Game status values |
| h | SpellNameEnum | Spell names |
| ai | KeyCodeEnum | F-key to action |
| ak | ActionEnum | Action types |
| ao | EffectEnum | Status effects |
| bo | TrinketEnum | Item/trinket types |
| bcj | ItemRarityEnum | Item rarity |
| axe | ColorConstants | UI colors |
| ajw | CurrencyEnum | Currency types |
| gx | EnergyType | Mana/Rage/Energy |

### 🔧 Utility Classes

| Old | New | Purpose |
|-----|-----|---------|
| aam | SerializationHelper | Kryo utility |
| aan | DeserializationHelper | Kryo utility |
| az | HitCircle | Collision box |
| ayl | EventBusBase | Event dispatcher |
| aim | TweenBase | Animation tweens |
| ahs | CharacterVisualBase | Character rendering |
| agv | SpriteRegion | Sprite wrapper |
| gz | CharacterComponent | Character data |
| gu | Character | Character entity |

---

## Alphabetical Index

| Old | New | File | Phase | Category |
|-----|-----|------|-------|----------|
| a | (utility) | a.java | 3 | Helper |
| aaa | (utility) | aaa.java | 3 | Helper |
| aaf | SelectDialog | aaf.java | 3 | UI Dialog |
| aah | InputAdapter | aah.java | 3 | Input |
| aal | InputAdapter | aal.java | 3 | Input |
| aam | SerializationHelper | aam.java | 3 | Utility |
| aan | DeserializationHelper | aan.java | 3 | Utility |
| aap | (player data) | aap.java | 2 | Data |
| aar | (effects) | aar.java | 2 | Logic |
| ab | KryoRegistry | ab.java | **1** | Network |
| abd | KeybindDialog | abd.java | 3 | UI Dialog |
| abz | ItemDisplayDialog | abz.java | 3 | UI Dialog |
| abk | StoreItemDialog | abk.java | 3 | UI Dialog |
| abi | StoreItemEnum | abi.java | 3 | Data |
| abe | GameStatusEnum | abe.java | 3 | Data |
| acf | SettingsDialog | acf.java | 3 | UI Dialog |
| ach | TableDialog | ach.java | 3 | UI Dialog |
| aci | InputEnum | aci.java | **2** | Input |
| ae | GameServerListener | ae.java | **1** | Network |
| af | PacketDispatcher | af.java | **1** | Network |
| ag | GameServerClient | ag.java | **1** | Network |
| agd | GameScreen | agd.java | **2** | UI |
| agn | StatusMessageDialog | agn.java | 3 | UI Dialog |
| agv | SpriteRegion | agv.java | **2** | Rendering |
| agy | (effects) | agy.java | 2 | Logic |
| ahs | CharacterVisualBase | ahs.java | **2** | Character |
| aho | CharacterNameplate | aho.java | **2** | Character |
| ai | KeyCodeEnum | ai.java | 3 | Data |
| aj | KeyboardInputHandler | aj.java | **2** | Input |
| ajw | CurrencyEnum | ajw.java | 3 | Data |
| ak | ActionEnum | ak.java | 3 | Data |
| al | FriendlyPlayerManager | al.java | **1** | State |
| aq | EnemyPlayerManager | aq.java | **1** | State |
| ao | EffectEnum | ao.java | 3 | Data |
| asx | ResourceManager | axm.java | **2** | UI |
| axh | UIWidget | axh.java | **2** | UI |
| axa | (effects) | axa.java | 2 | Logic |
| axe | ColorConstants | axe.java | 3 | Data |
| axx | (buttons) | axx.java | 3 | UI |
| axc | BaseScreen | axc.java | **2** | UI |
| ay | PlayerStateManager | ay.java | **1** | State |
| ayx | (events) | ayx.java | 2 | Logic |
| ayl | EventBusBase | ayl.java | 3 | Utility |
| aes | AccountInitScreen | aes.java | 3 | UI |
| aex | LoginDialog | aex.java | 3 | UI |
| aay | SliderDialog | aay.java | 3 | UI |
| az | HitCircle | az.java | **2** | Collision |
| azv | Timer | azv.java | **2** | Logic |
| b | ChatLabel | b.java | 3 | UI |
| bd | CharacterProfileUI | bd.java | **2** | UI |
| bo | TrinketEnum | bo.java | 3 | Data |
| br | PlayerBase | br.java | **1** | State |
| bcj | ItemRarityEnum | bcj.java | 3 | Data |
| c | ChatRenderer | c.java | 3 | UI |
| cr | CombatSystem | cr.java | **2** | Combat |
| d | ChatMessage | d.java | 3 | UI |
| da | AnimationManager | da.java | **2** | Animation |
| el | CharacterStats | el.java | **2** | Data |
| ef | PlayerUIStateManager | ef.java | **1** | State |
| ge | EnemyPlayersContainer | ge.java | **1** | State |
| gd | GameDomain | gd.java | **1** | State |
| gf | FriendlyPlayersContainer | gf.java | **1** | State |
| gu | Character | gu.java | **2** | Entity |
| gz | CharacterComponent | gz.java | **2** | Entity |
| gx | EnergyType | gx.java | **2** | Entity |
| h | SpellNameEnum | h.java | **2** | Combat |
| we | LobbyScreen | we.java | **2** | UI |
| y | NetworkBase | y.java | **1** | Network |

---

## Reverse Index (By Purpose)

### Network Layer
- `y` → NetworkBase
- `ag` → GameServerClient
- `ae` → GameServerListener
- `ab` → KryoRegistry
- `af` → PacketDispatcher

### Game State
- `ay` → PlayerStateManager (SINGLETON)
- `br` → PlayerBase
- `al` → FriendlyPlayerManager
- `aq` → EnemyPlayerManager
- `gd` → GameDomain
- `gf` → FriendlyPlayersContainer
- `ge` → EnemyPlayersContainer
- `ef` → PlayerUIStateManager

### Character/Entity
- `gu` → Character
- `gz` → CharacterComponent
- `gx` → EnergyType
- `ahs` → CharacterVisualBase
- `aho` → CharacterNameplate
- `az` → HitCircle
- `agv` → SpriteRegion

### Rendering/Animation
- `axc` → BaseScreen
- `agd` → GameScreen
- `we` → LobbyScreen
- `axm` → ResourceManager
- `axh` → UIWidget
- `bd` → CharacterProfileUI
- `da` → AnimationManager

### Combat/Logic
- `cr` → CombatSystem
- `h` → SpellNameEnum
- `el` → CharacterStats
- `azv` → Timer

### Input/Control
- `aj` → KeyboardInputHandler
- `aci` → InputEnum

### Data/Config
- `abi` → StoreItemEnum
- `abe` → GameStatusEnum
- `ai` → KeyCodeEnum
- `ak` → ActionEnum
- `ao` → EffectEnum
- `bo` → TrinketEnum
- `bcj` → ItemRarityEnum
- `axe` → ColorConstants
- `ajw` → CurrencyEnum

### Utilities
- `aam` → SerializationHelper
- `aan` → DeserializationHelper
- `ayl` → EventBusBase
- `aim` → TweenBase

---

## How to Use This Guide

### For Understanding Architecture
1. Read **COMPLETE_REVERSE_ENGINEERING.md** (in docs/)
2. Follow the **Phase 1** classes first
3. Reference **CLASS_MAPPING_COMPREHENSIVE.md** for details

### For Finding a Class
- Use **Alphabetical Index** if you have the old name
- Use **Reverse Index (By Purpose)** if you know what it does
- Reference **QUICK_REFERENCE.md** for high-level overview

### For Renaming Files
1. Follow the **Phase 1 → Phase 2 → Phase 3** order
2. Use the **Renaming Mapping** section
3. Update any file references/imports in dependent files

### For Implementation
- Check **Implementation Roadmap** in COMPLETE_REVERSE_ENGINEERING.md
- Each phase has specific deliverables
- Phases are sequenced by dependency

---

## Status

- ✅ Network layer documented
- ✅ Game state documented
- ✅ Character system documented
- ✅ UI layer documented
- ✅ Combat system documented
- ✅ All 75+ core classes mapped
- → Ready for implementation/renaming

---

**Version:** 1.0  
**Coverage:** 75+ core classes  
**Status:** Complete Analysis  
**Next Step:** Phase 1 File Renaming
