# Arena of Kings - Quick Reference: Class Families

## At a Glance

### 🌐 Network Layer (5 classes)
| Old | New | Role |
|-----|-----|------|
| `y` | NetworkBase | Abstract KryoNet base |
| `ag` | GameServerClient | Main client/connection mgr |
| `ae` | GameServerListener | Packet received handler |
| `ab` | KryoRegistry | Kryo serialization registry |
| `af` | PacketDispatcher | Routes 50+ packet types |

### 🎮 Game State (8 classes)
| Old | New | Role |
|-----|-----|------|
| `ay` | PlayerStateManager | **Singleton** - current player |
| `br` | PlayerBase | Abstract base (all players) |
| `al` | FriendlyPlayerManager | Allied player (extends br) |
| `aq` | EnemyPlayerManager | Enemy player (extends br) |
| `gd` | GameDomain | Game context/settings |
| `gf` | FriendlyPlayersContainer | Friendly players array |
| `ge` | EnemyPlayersContainer | Enemy players array |
| `ef` | PlayerUIStateManager | UI overlay state |

### 👤 Character/Entity (9 classes)
| Old | New | Role |
|-----|-----|------|
| `gu` | Character | Character entity |
| `gz` | CharacterComponent | Character properties |
| `gx` | EnergyType | Enum: Mana/Rage/Energy |
| `ahs` | CharacterVisualBase | Abstract rendering |
| `aho` | CharacterNameplate | Nameplate renderer |
| `agv` | SpriteRegion | Texture wrapper |
| `az` | HitCircleBase | Collision detection |
| `cr` | CombatSystem | Spellcasting/combat |
| `da` | AnimationManager | Animation controller |

### 🎨 UI/Screen (25+ classes)
**Screen Management:**
| Old | New | Role |
|-----|-----|------|
| `axc` | BaseScreen | Abstract screen base |
| `agd` | GameScreen | Gameplay screen |
| `we` | LobbyScreen | Main menu |
| `axm` | ResourceManager | Asset loader |
| `axh` | UIWidget | Base UI component |

**Dialogs:**
| Old | New |
|-----|-----|
| `aex` | LoginDialog |
| `aes` | AccountInitScreen |
| `aaf` | SelectDialog |
| `abz` | ItemDisplayDialog |
| `abk` | StoreItemDialog |
| `abd` | KeybindDialog |
| `acf` | SettingsDialog |
| `aay` | SliderDialog |
| `agn` | StatusMessageDialog |
| `ach` | TableDialog |
| *(+15 more)* |

### ⌨️ Input/Control (4 classes)
| Old | New | Role |
|-----|-----|------|
| `aj` | KeyboardInputHandler | Keyboard processor |
| `aci` | InputEnum | Key→Action mapping |
| `aax` | InputIdentifier | Action ID wrapper |
| `aal` | InputAdapter | LibGDX base adapter |

### ⚔️ Combat/Logic (7 classes)
| Old | New | Role |
|-----|-----|------|
| `cr` | CombatSystem | Spell/combat logic |
| `h` | SpellNameEnum | Spell ID→Name map |
| `el` | CharacterStats | Character stats/HP |
| `azv` | Timer | Cooldown scheduler |
| `abe` | GameStatusEnum | Game state enum |
| `ak` | ActionEnum | Action types |
| `bo` | TrinketEnum | Active item types |

### 📊 Data/Config (11 classes)
| Old | New | Role |
|-----|-----|------|
| `abi` | StoreItemEnum | 50+ shop items |
| `abe` | GameStatusEnum | Game states |
| `h` | SpellNameEnum | Spell names |
| `ai` | KeyCodeEnum | F-key bindings |
| `ak` | ActionEnum | Action types |
| `ao` | EffectEnum | Status effects |
| `bo` | TrinketEnum | Item types |
| `bcj` | ItemRarityEnum | Rarity levels |
| `axd` | ColorEnum | UI colors |
| `axn` | FontStyleEnum | Text styles |
| `ajw` | CurrencyEnum | Currency types |

### 🔧 Utilities (6 classes)
| Old | New | Role |
|-----|-----|------|
| `aam` | SerializationHelper | Kryo utility |
| `aan` | DeserializationHelper | Kryo utility |
| `axm` | ResourceManager | Asset manager |
| `az` | HitCircleBase | Collision base |
| `ayl` | EventBusBase | Event dispatcher |
| `aim` | TweenBase | Animation tweens |

---

## 🎯 Quick Rename Phases

### Phase 1: Core (15 classes) - CRITICAL
```
Network foundation: y, ag, ae, ab
State management: ay, br, gd, gf, ge
Character system: gu, gz, gx, ahs, aho
```

### Phase 2: Main Features (15 classes) - HIGH PRIORITY
```
UI: axc, agd, we, axh, axm
Combat: af, cr, h, el, azv
Input: aj, aci, aal
```

### Phase 3: Support (45+ classes) - MEDIUM PRIORITY
```
UI dialogs (15+): aex, aes, aaf, abz, abk, abd, acf...
Data/Config (11): abi, abe, ai, ak, ao, bo, bcj, axd, axn, ajw
Utilities (6): aam, aan, axm, az, ayl, aim
```

---

## 🔍 Pattern Recognition

### How to identify class purpose:

**Enum Class?**
```java
public final class XXX
extends Enum<XXX>
→ Store item/constant definition
```

**Network Handler?**
```java
import com.esotericsoftware.kryonet.*
import com.arenaofkings.packets.*
→ Network or packet processing
```

**UI Component?**
```java
import com.badlogic.gdx.scenes.scene2d.*
import com.badlogic.gdx.graphics.g2d.*
→ UI or rendering
```

**Singleton?**
```java
private static final ClassName instance;
public static ClassName ClassName_a() { return instance; }
→ Singleton pattern (ay is best example)
```

---

## 📌 Key Relationships

```
Network Flow:
ag (Client) → ae (Listener) → af (Dispatcher) → ay (State)

Rendering Flow:
ay (State) → gf/ge (Containers) → br (Player) → gu (Character)
                                                    ↓
                                          ahs (Visual) → aho (Nameplate)

Combat Flow:
aj (Input) → ag (Send Request) → [Server] → af (Receive Update)
                                               ↓
                                          cr (Combat) → el (Stats)
                                               ↓
                                          br/gu (Character Update)
```

---

## ✅ Usage

1. **For Understanding:** Read this quick reference for overview
2. **For Details:** See CLASS_MAPPING_COMPREHENSIVE.md for deep dive
3. **For Implementation:** Use Phase 1-3 batch rename commands
4. **For Verification:** Check inheritance chains and relationships

---

**Last Updated:** May 26, 2026  
**Coverage:** 75+ core classes, 8 families, 100+ renames ready
