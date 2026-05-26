# Arena of Kings - Code Pattern Evidence

## Real Code Examples from Analysis

This document shows **actual decompiled code patterns** that support the class-to-purpose mapping.

---

## Network Layer - Code Evidence

### Pattern: KryoNet Listener Implementation

**File: ae.java (GameServerListener)**
```java
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.Listener;

public class ae
implements Listener {
    private ag var_ag_a;
    private final String var_java_lang_String_a;
    private final int var_int_a;
    private int b;

    public ae(ag ag2, String string, int n2, int n3) {
        this.var_ag_a = ag2;
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
        this.b = n3;
    }

    @Override
    public void connected(Connection connection) {
        Engine.a("[NETWORK-GS] Connection opened. onOpen()");
        this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] onOpen");
        this.var_ag_a.ab_a().azv_a().void_c();
        this.var_ag_a.a(true);
        
        PUB_MISC_PLAYER_TOKEN pUB_MISC_PLAYER_TOKEN = new PUB_MISC_PLAYER_TOKEN();
        pUB_MISC_PLAYER_TOKEN.setToken(ay.ay_a().gd_a().java_lang_String_a());
        pUB_MISC_PLAYER_TOKEN.setGameID(this.b);
        this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_ag_a.b(pUB_MISC_PLAYER_TOKEN);
    }

    @Override
    public void disconnected(Connection connection) {
        Engine.a("[NETWORK-GS] Connection closed.");
        // ...
    }
}
```

**Analysis:**
- ✅ Implements `Listener` from KryoNet
- ✅ Contains `connected()` and `disconnected()` callbacks
- ✅ Accesses singleton `ay.ay_a()` for player state
- ✅ Handles packet creation and token management
- ✅ Clear network event handler pattern

---

### Pattern: Network Client Manager

**File: ag.java (GameServerClient)**
```java
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.arenaofkings.packets.gameserver.PUB_GAME_INIT;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING;
import com.arenaofkings.packets.gameserver.PUB_GAME_SNAPSHOT;
// ... 25+ more packet imports

public class ag
extends y {
    final Engine var_com_arenaofkings_client_core_Engine_a = new ArrayList();
    int var_int_a = 0;
    int var_int_b = 0;
    public boolean var_boolean_b = false;
    
    LinkedBlockingQueue<PublicPacket> var_java_util_concurrent_LinkedBlockingQueue_com_arenaofkings_packets_misc_PublicPacket__a;
    private List<PublicPacket> var_java_util_List_com_arenaofkings_packets_misc_PublicPacket__a;
    private PlayerUpdateBundle var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a;
    
    private azv var_azv_a = new azv(20L, true);
    private ae var_ae_a;

    public ag(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = new HashMap();
        this.var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a = new PUB_GAME_PING();
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.void_a();
    }
}
```

**Analysis:**
- ✅ Extends base class `y` (NetworkBase)
- ✅ Uses `LinkedBlockingQueue` for thread-safe packet handling
- ✅ Contains references to 25+ packet types
- ✅ Creates `azv` (Timer) for heartbeat/ping management
- ✅ Creates `ae` (Listener) for connection handling
- ✅ Clear packet queue and management pattern

---

## Game State - Code Evidence

### Pattern: Singleton Player Manager

**File: ay.java (PlayerStateManager)**
```java
public class ay
extends br {
    private static final ay var_ay_a;
    private gd var_gd_a;
    private gf var_gf_a = new gf();
    private ge var_ge_a = new ge();
    private ef var_ef_a = new ef();

    private ay() {
    }

    public static ay ay_a() {
        return var_ay_a;
    }

    public gd gd_a() {
        return this.var_gd_a;
    }

    @Override
    public MyAccountData com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() {
        return (MyAccountData)((Object)this.var_ay_a);
    }

    public gu gu_a() {
        return (gu)((SharedAccountData)((Object)this.var_ay_a)).getActive_character_entity().gz_a();
    }

    public gf gf_a() {
        return this.var_gf_a;
    }

    public ge ge_a() {
        return this.var_ge_a;
    }

    public void a(Engine engine, gd gd2, MyAccountData myAccountData) {
        this.var_gd_a = gd2;
        this.var_ay_a = myAccountData;
        if (!this.com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().isEmpty()) {
            this.var_gf_a.a(this);
        }
    }
}
```

**Analysis:**
- ✅ Classic singleton pattern: `private static final ay var_ay_a`
- ✅ Instance accessor: `public static ay ay_a()`
- ✅ Manages `MyAccountData` (current player)
- ✅ Contains `gf` (FriendlyPlayersContainer) and `ge` (EnemyPlayersContainer)
- ✅ Manages `gd` (GameDomain - context)
- ✅ Accesses current character: `gu gu_a()` → `Character`
- ✅ Clear game state singleton pattern

---

## Entity/Character - Code Evidence

### Pattern: Character Visual Component

**File: aho.java (CharacterNameplate)**
```java
public class aho
extends ahs {
    public aho(Engine engine, TextureAtlas textureAtlas, TextureAtlas textureAtlas2, 
               br br2, gz gz2, EffectManager effectManager, HitCircle hitCircle, 
               boolean bl2, gx gx2, CharacterClass characterClass, int n2) {
        super(engine, textureAtlas, textureAtlas2, br2, gz2, effectManager, hitCircle, bl2, gx2, characterClass, n2);
        
        Engine.a("loading nameplate resource");
        
        // Switch on energy type to load appropriate bar texture
        switch (gx2) {
            case c: {
                this.b = new agv(textureAtlas, "v3_nameplate_mana_bar");
                break;
            }
            case e: {
                this.b = new agv(textureAtlas, "v3_nameplate_rage_bar");
                break;
            }
            case d: {
                this.b = new agv(textureAtlas, "v3_nameplate_energy_bar");
            }
        }
        this.b = true;
        Engine.a("nameplate completely done");
    }
}
```

**Analysis:**
- ✅ Extends `ahs` (CharacterVisualBase)
- ✅ Takes `gx` parameter (EnergyType: Mana/Rage/Energy)
- ✅ Loads TextureAtlas resources for rendering
- ✅ Selects different nameplate bar based on energy type
- ✅ Uses `agv` (SpriteRegion) for texture management
- ✅ Clear character rendering/visual component pattern

---

### Pattern: Base Player Class

**File: br.java (PlayerBase)**
```java
public abstract class br
implements Comparable<br> {
    public boolean var_boolean_a = false;
    protected SharedAccountData var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a;
    protected int var_int_a;
    protected PartyRole var_com_arenaofkings_packets_misc_PartyRole_a;
    protected azv var_azv_a;
    protected azv var_azv_b = new azv(1500L, false);
    private boolean c = false;
    boolean var_boolean_b = false;

    public SharedAccountData com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() {
        return this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a;
    }

    public void void_b() {
        if (this != ay.ay_a()) {
            this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().az_a().ar_a().void_b();
        }
        this.void_c();
        this.var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a.getActive_character_entity().cr_a().void_a();
    }

    public void b(float f2, Engine engine, ayh ayh2, ayh ayh3) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == this) {
            if (ay.ay_a().boolean_a(this) && engine.var_aj_a.boolean_a(ai.F)) {
                ayh2.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(...);
                ayh2.b(f2, engine);
            }
        }
    }
}
```

**Analysis:**
- ✅ Abstract class with abstract methods
- ✅ Stores `SharedAccountData` (player data from network)
- ✅ Contains timer references (`azv`) for cooldowns
- ✅ Implements `Comparable<br>` for sorting
- ✅ Accesses combat system (`cr_a()`) and character entity
- ✅ Rendering method `b(float f2, Engine engine, ...)` 
- ✅ Clear abstract player/actor base class pattern

---

## Enum Classes - Code Evidence

### Pattern: Store Item Enumeration

**File: abi.java (StoreItemEnum)**
```java
import com.arenaofkings.packets.misc.Currency;
import com.arenaofkings.packets.misc.StoreItemContent;

public final class abi
extends Enum<abi>
implements StoreItemContent {
    public static final /* enum */ abi var_abi_a;
    public static final /* enum */ abi b;
    public static final /* enum */ abi c;
    public static final /* enum */ abi d;
    // ... 50+ more items
    public static final /* enum */ abi Y;
    
    private abi() {
    }

    static {
        // ... initialization
    }
}
```

**Analysis:**
- ✅ Extends `Enum<abi>` pattern
- ✅ Implements `StoreItemContent` interface
- ✅ Contains 50+ public static final enum members
- ✅ Clear enumeration pattern for game constants
- ✅ Used for store item types

---

### Pattern: Game Status Enumeration

**File: abe.java (GameStatusEnum)**
```java
public final class abe
extends Enum<abe> {
    public static final /* enum */ abe IN_GAME;
    public static final /* enum */ abe LOBBY;
    public static final /* enum */ abe LOADING;
    public static final /* enum */ abe READY_UP;
    // ... more states
}
```

**Analysis:**
- ✅ Extends `Enum<abe>` pattern
- ✅ Represents game state values
- ✅ Static enum members for each state
- ✅ Clear constant definition pattern

---

## UI System - Code Evidence

### Pattern: LibGDX Scene2D Components

**Files: aaf.java, aay.java, abk.java, abd.java, aex.java**
```java
// Example: aaf.java (SelectDialog)
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;

public class aaf {
    // Dialog/SelectBox implementation
}

// Example: aay.java (SliderDialog)
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class aay {
    // Slider wrapper
}

// Example: axh.java (UIWidget base)
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class axh {
    // Base UI widget
}
```

**Analysis:**
- ✅ All import from `com.badlogic.gdx.scenes.scene2d.*`
- ✅ Use LibGDX Actor, Stage, Dialog, Widget classes
- ✅ Implement UI components (Dialog, SelectBox, Slider, Button, Label, TextField)
- ✅ Clear UI/rendering component pattern
- ✅ 25+ total UI classes identified

---

## Packet Dispatcher - Code Evidence

**File: af.java (PacketDispatcher)**
```java
import com.arenaofkings.packets.gameserver.PUB_GAME_CONNECTION_ESTABLISHED;
import com.arenaofkings.packets.gameserver.PUB_GAME_FOG_UPDATE;
import com.arenaofkings.packets.gameserver.PUB_GAME_INIT;
import com.arenaofkings.packets.gameserver.PUB_GAME_MESSAGE;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING_RESPONSE;
import com.arenaofkings.packets.gameserver.PUB_GAME_SCOREBOARD_UPDATE;
import com.arenaofkings.packets.gameserver.PUB_GAME_SNAPSHOT;
import com.arenaofkings.packets.gameserver.PUB_GAME_STATUS_UPDATE;
// ... 30+ more packet types

import com.arenaofkings.packets.gameserver.data.updates.CollisionEvent;
import com.arenaofkings.packets.gameserver.data.updates.PlayerComboPointUpdate;
import com.arenaofkings.packets.gameserver.data.updates.PlayerCoordinateUpdate;
import com.arenaofkings.packets.gameserver.data.updates.PlayerDeathUpdate;
import com.arenaofkings.packets.gameserver.data.updates.PlayerDirectionChange;
import com.arenaofkings.packets.gameserver.data.updates.PlayerEffectAdd;
import com.arenaofkings.packets.gameserver.data.updates.PlayerEffectRemove;
// ... 30+ more update types

public class af {
    // Central packet routing
}
```

**Analysis:**
- ✅ Imports 50+ packet types from `com.arenaofkings.packets.*`
- ✅ Clear packet handling/dispatch pattern
- ✅ Contains methods to route each packet type
- ✅ Handles game init, status updates, player updates, effects, etc.

---

## Pattern Summary Table

| Pattern | File(s) | Indicators | Rename |
|---------|---------|-----------|--------|
| **Listener** | ae | `implements Listener` | GameServerListener |
| **Network Client** | ag | Extends y, KryoNet imports, queues | GameServerClient |
| **Singleton** | ay | `static final instance`, `ClassName_a()` | PlayerStateManager |
| **Abstract Base** | br, ahs, axc | `public abstract class` | PlayerBase, CharacterVisualBase, BaseScreen |
| **Enum** | abi, abe, h, ai, ak, bo | `extends Enum<T>` | StoreItemEnum, GameStatusEnum, etc |
| **UI Component** | aaf, aay, abd, aex | LibGDX imports | SelectDialog, SliderDialog, etc |
| **Packet Dispatcher** | af | 50+ packet imports | PacketDispatcher |
| **Rendering** | aho, agv, da | TextureAtlas, Animation, Color | CharacterNameplate, SpriteRegion, AnimationManager |

---

## Code Variable Naming Pattern

### Full Type Names Encoded in Variable Names

**Example from br.java:**
```java
protected SharedAccountData var_com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a;
```

Decodes to:
- Type: `com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData`
- Variable name: `a` (first variable of this type in the class)

**This pattern reveals:**
- ✅ Actual class structure
- ✅ Package hierarchy
- ✅ Import structure
- ✅ Purpose through type information

---

## Obfuscation Pattern: Method Naming

### Pattern: Single Letter Methods = Numbered Implementation Order

```java
public void a() { /* first method implementation */ }
public void b() { /* second method implementation */ }
public void c() { /* third method implementation */ }
public void d() { /* fourth method implementation */ }
```

### Singleton Pattern Special Case
```java
public static ClassName ClassName_a() { return instance; }
```

Maps to: `public static ClassName getInstance() { return instance; }`

---

**Evidence Collection Complete** ✓

These real code samples demonstrate that class purposes can be reliably determined through:
1. Interface implementations
2. Package imports
3. Method signatures
4. Variable type encoding
5. Inheritance patterns
6. Library usage patterns

