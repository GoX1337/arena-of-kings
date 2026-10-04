# Arena of Kings reverse-engineering notes

Date: 2026-05-31

## Scope

This pass ignores `docs/` as requested.

The decompiled tree contains three different categories:

- Real Arena of Kings packet/API classes under `decompiled/com/arenaofkings/...` (261 Java files). These are mostly readable and already named.
- Obfuscated client/game classes at `decompiled/*.java`. These are the main reverse-engineering target.
- Third-party libraries included as source by the decompiler (`com/badlogic`, `com/esotericsoftware`, `org/lwjgl`, Jackson-like classes in root names such as `bba`, `bcq`, `bgf`, etc.). These should not be renamed as game classes.

`app/Client.jar` was used as bytecode ground truth. `javap` shows the original `Compiled from` source filenames, which are much more reliable than CFR's invalid Java output. Important discovery: the obfuscated game classes really are in the default package in the original bytecode, while `Engine` and `DesktopLauncher` are in named packages. That bytecode shape cannot be represented as normal Java source, because Java source in a named package cannot legally reference default-package classes.

## High-level architecture

`com.arenaofkings.client.desktop.DesktopLauncher` is the desktop entry point. It reads settings via `aj`, configures LWJGL3, then launches `new Engine(aj2)`.

`com.arenaofkings.client.core.Engine` is the central LibGDX game object. It extends obfuscated `l`, which is a thin wrapper around `com.badlogic.gdx.Game`. `Engine` owns:

- screen transitions and asset loading/unloading;
- the global `AssetManager`;
- the main render batch and shape renderer wrappers;
- fonts, colors, cursors, and UI skin;
- `z`, the login-server websocket client;
- `ag`, the game-server Kryonet client;
- audio via `baa`;
- options/user settings via `aj`.

The screen flow visible in `Engine.g()` and `axc` is:

- `afx` -> loading/preparation screen, transitions to `aes`.
- `aes` -> login/register/front screen.
- `xw` -> lobby loading screen, transitions to `we`.
- `we` -> main lobby screen.
- `vh` -> server status/loading screen, transitions to `um`.
- `um` -> server status/account entry style screen.
- `ajo` -> play loading screen.
- `agd` -> in-match/play screen.

`axc` is the abstract screen base. It selects an `axm` asset dependency set depending on the concrete screen type:

- `aew`: login/front dependencies.
- `uo`: server status dependencies.
- `vk`: another screen dependency set, likely character/selection or transitional UI.
- `wf`: lobby dependencies.
- `agl`: play/game dependencies.

Original source names confirmed from bytecode:

| Class | Original source | Role |
| --- | --- | --- |
| `l` | `AoKGame.java` | Thin LibGDX `Game` subclass. |
| `u` | `AoKAssetManager.java` | Custom asset manager. |
| `axc` | `AbstractScreen.java` | LibGDX screen base. |
| `axb` | `AbstractLoadingScreen.java` | Base for loading screens. |
| `axm` | `AssetDependencies.java` | Asset dependency holder. |
| `ajw` | `ScreenDependency.java` | Asset/dependency enum/catalog. |
| `afx` | `LoginLoadingScreen.java` | Login asset loading screen. |
| `aes` | `Login.java` | Login screen. |
| `aew` | `LoginAssetDependencies.java` | Login asset set. |
| `aex` | `LoginGUIManager.java` | Login UI manager. |
| `afw` | `LoginWorld.java` | Login background/world renderer. |
| `afz` | `LoginOptionalData.java` | Login transition payload. |
| `xw` | `LobbyLoadingScreen.java` | Lobby loading screen. |
| `we` | `Lobby.java` | Main lobby screen. |
| `wf` | `LobbyAssetDependencies.java` | Lobby asset set. |
| `wh` | `LobbyGUIManager.java` | Main lobby UI manager. |
| `vh` | `AccountCreationLoadingScreen.java` | Account creation loading screen. |
| `um` | `AccountCreation.java` | Account creation/status screen. |
| `uo` | `AccountCreationAssetDependencies.java` | Account creation asset set. |
| `up` | `AccountCreationGUIManager.java` | Account creation UI manager. |
| `vg` | `AccountCreationWorld.java` | Account creation world/background. |
| `vj` | `CharacterCreation.java` | Character creation screen. |
| `vk` | `CharacterCreationAssetDependencies.java` | Character creation asset set. |
| `vl` | `CharacterCreationGUIManagerNEW.java` | Character creation UI manager. |
| `wb` | `CharacterCreationLoadingScreen.java` | Character creation loading screen. |
| `wc` | `CharacterCreationLoadingScreenGUIManager.java` | Character creation loading UI. |
| `wd` | `CharacterCreationScreenData.java` | Character creation transition payload. |
| `wa` | `CharacterCreationWorld.java` | Character creation world/background. |
| `ajo` | `PlayLoadingScreen.java` | Play loading screen. |
| `agd` | `Play.java` | In-match/play screen. |
| `agl` | `PlayAssetDependencies.java` | Play asset set. |
| `agn` | `PlayGUIManager.java` | Play UI manager. |
| `agp` | `PlayScreenData.java` | Play transition payload. |
| `agq` | `PlaySounds.java` | Play sound catalog/helper. |
| `agr` | `PlayWorld.java` | Arena world renderer. |

## Networking

`z` is the login-server client.

- Extends `ad`, an abstract network sender/holder.
- Uses `org.java_websocket.client.WebSocketClient`.
- Serializes/deserializes packets with LibGDX `Json`.
- Connects to `wss://live-us-east-ls1.arenaofkings.com/websocket/loginserver/` for live, or PTR URL when `Engine.var_azm_a` is PTR.
- Queues incoming `PublicPacket` instances and handles them on the client thread.

`aa` is very likely the concrete login websocket callback/client class because `z.void_b()` constructs `new aa(this, new URI(string))`.

`ac` is the websocket ping manager (`SteamWSPingManager.java`). It is constructed by `z` from a serialized `PUB_GAME_PING`.

`ag` is the Kryonet game-server client.

- Owns a Kryonet `Client`.
- Registers packets through `af.a(kryo)`.
- Batches outgoing input packets into `PlayerUpdateBundle`.
- Deduplicates high-frequency movement/direction requests before sending.
- Processes queued server `PublicPacket` objects only while the play screen (`agd`) is active, with special handling for `PUB_GAME_INIT` while in lobby/loading screens.

`ae` is the Kryonet listener for `ag`.

- On connect: sends `PUB_MISC_PLAYER_TOKEN` with token and game id.
- On receive: stores `PUB_GAME_INIT`, handles ping responses, queues all other game `PublicPacket`s.
- On disconnect: clears game state and emits `PUB_GAME_STATUS_UPDATE(ENDED)` unless relog logic applies.

`af` is the Kryo registration table. It registers core game packets, update packets, input requests, player data, scoreboard data, resources, spell events, and item data.

Original network source names confirmed from bytecode:

| Class | Original source | Role |
| --- | --- | --- |
| `ad` | `SteamWebsocketFramework.java` | Base websocket framework. |
| `z` | `SteamLoginClient.java` | Login websocket client. |
| `aa` | `SteamLoginClient.java` | Concrete `WebSocketClient` callback class. |
| `ac` | `SteamWSPingManager.java` | Websocket ping manager. |
| `y` | `SteamConnectionFramework.java` | Base Kryonet connection framework. |
| `ag` | `SteamGameClientKryonet.java` | Game-server Kryonet client. |
| `ah` | `SteamGameClientKryonet.java` | Connect-thread runnable for `ag`. |
| `ab` | `SteamPingManager.java` | Kryonet/game ping manager. |
| `ae` | `PublicNetworkListener.java` | Kryonet listener. |
| `af` | `PublicSerializer.java` | Kryo packet registration. |
| `v` | `ConnectionProtocol.java` | Connection protocol enum. |
| `w` | `ConnectionStatus.java` | Connection status enum. |
| `axn` | `AuthenticationStatus.java` | Login/auth status enum. |

## Player and match model

`ay` is the local player singleton.

- Extends `br`.
- Holds `MyAccountData`, game/session data (`gd`), friendly players (`gf`), enemy players (`ge`), and another local collection (`ef`).
- Resolves players by character name across self, friendly, and enemy lists.
- Sends target-clearing requests when the selected target becomes invalid.

`br` is the abstract player wrapper.

- Holds `SharedAccountData`, party role, display order, timers, stealth/reveal state, and render helpers.
- Renders player effects, target rings, nameplates, and character sprites.
- Compares/sorts players and exposes character position/team-related helpers.

`gf` is likely friendly-party/player collection.

`ge` is likely enemy-player collection.

`gd` is likely game/session/account-state container. It provides game id/token-like fields, `GameType`, inventory, party/lobby state, spectator flag, and UI state used by lobby/play.

`aq` constructs friendly players. Its strings include `new FriendlyPlayer(...)`.

`bd` appears to initialize/account-profile state. Strings include membership/profile load messages.

Original player/session source names confirmed from bytecode:

| Class | Original source | Role |
| --- | --- | --- |
| `ay` | `Me.java` | Local player singleton. |
| `br` | `SharedPlayer.java` | Base player wrapper/render state. |
| `aq` | `FriendlyPlayer.java` | Friendly player wrapper. |
| `al` | `EnemyPlayer.java` | Enemy player wrapper. |
| `gk` | `SharedParty.java` | Base party/player collection. |
| `gf` | `MyFriendlyParty.java` | Friendly party collection. |
| `ge` | `MyEnemyParty.java` | Enemy party collection. |
| `gd` | `MyPrivateData.java` | Local private account/session state. |
| `zg` | `ArenaTeam.java` | Arena team model. |
| `ao` | `FameLevel.java` | Fame/rating level enum. |
| `axd` | `AccountPrivilege.java` | Account privilege enum. |
| `axz` | `StatusMessage.java` | Status/message state. |

## Gameplay/rendering classes

`agd` is the main play screen.

- Loads players, arena map, UI, input processors, tutorial dialogs, scoreboard, target highlights, and player animations.
- Uses `GameType` to switch arena/tutorial/bot/dark boss behavior.
- Sends `PUB_PLAY_READY`.
- Renders world, entities, nameplates, UI, FPS/debug overlays, scoreboard, and tutorial prompts.

`agr` is the arena world/map renderer.

- Uses strings like `PLAY WORLD ARENA`, `dark1`, `dark2`, `bottom_fence`.
- Depends on tiled map assets and arena-specific visual layers.

`agt` appears to be the in-game bottom bar / party unit frame manager.

- Uses strings like `bottom_bar_dark`, `bottom_chunk_dark`, and logs for adding party players.

`ajt` is the scoreboard panel.

- Uses `scoreboard_panel`, `victory_label`, `defeat_label`.

`aju` is the scoreboard row/rating-change renderer.

- Uses `scoreboard_row_ally`, `scoreboard_row_enemy`, and rating-change text.

`agc` is keybind/input mapping.

- Loads keybinds, maps input identifiers, and is used by nameplate labels (`TARGET_ALLY_2`, `TARGET_ENEMY_1`, etc.).

`aik`, `ain`, `air`, and related `ai*` classes are input processors/actions.

- `aik`: dispatches keybind requests.
- `air`: move-to-cursor input logic.
- `ain`: click/target input region logic.
- `aip`: movement north handler or command object.

`az` is abstract movement controller.

- Contains movement legality checks, position correction, and action selection.

`bb` is the local/player movement controller.

- Extends `az`.
- Sends `MOVE_REQUEST_*`, `MOVE_RELEASE_*`, and direction/update packets.
- Does collision checks against map polygon layers.

`cr` is the character animation manager.

- Loads class/outfit animations from `packed/models/<class>/outfit_<n>/<skin>/...`.
- Tracks current `PlayerAction`, `Direction`, shapeshift/form state (`cv`), and current `da` animation.

`cy` is likely animation atlas cache by `PlayerAction` and form.

`cw` is likely action-category enum/helper.

`cv` is likely character form enum/default form.

`da` is sprite-sheet animation/renderable.

- Wraps `Animation<Sprite>`.
- Loads frames from `TextureAtlas`.
- Tracks hover/click state and draw offsets.
- Implements `axr`, so it participates in generic update/render loops.

`axr` is the generic render/update interface with `a(float, Engine)` and `b(float, Engine)` style methods.

`azi` is a custom `SpriteBatch` wrapper or render batch.

- It has helpers to iterate and render arrays of `axr`.

`axf` is a shape renderer wrapper.

`axe` is a color/style constants holder.

`axy` is a bitmap-font wrapper.

`azv` is a timer/cooldown helper.

`axp` is math/rating utility.

- Used for distance calculations and printed rating conversions.

Original gameplay/rendering source names confirmed from bytecode:

| Class | Original source | Role |
| --- | --- | --- |
| `axr` | `DrawableObject.java` | Generic drawable/update interface. |
| `azi` | `Renderer.java` | Custom `SpriteBatch` renderer. |
| `axf` | `AoKShapeRenderer.java` | Custom shape renderer. |
| `axe` | `AoKColors.java` | Shared color constants. |
| `axy` | `FontHolder.java` | Bitmap font wrapper. |
| `axp` | `Calc.java` | Math/rating calculations. |
| `azv` | `Timer.java` | Timer/cooldown helper. |
| `az` | `MovementManager.java` | Base movement manager. |
| `bb` | `MyMovementManager.java` | Local movement manager. |
| `cr` | `AnimationManager.java` | Character animation manager. |
| `cy` | `PlayerSheetAnimations.java` | Player animation sheet maps. |
| `cw` | `LegalPlayerAction.java` | Player action legality/category enum. |
| `cv` | `CharacterForm.java` | Character form enum. |
| `ct` | `CharacterCreationSheetAnimations.java` | Character creation animation sheets. |
| `da` | `SpriteSheetAnimation.java` | Sprite-sheet animation wrapper. |
| `aga` | `ItemGroundManager.java` | Ground item manager. |
| `agt` | `BottomPanel.java` | In-game bottom HUD panel. |
| `ahn` | `TopPanel.java` | In-game top HUD panel. |
| `agv` | `DynamicValueBar.java` | Dynamic value bar. |
| `agw` | `HybridValueBar.java` | Hybrid value bar. |
| `agx` | `ModernAllyPortrait.java` | Ally portrait widget. |
| `aha` | `ModernEnemyPortrait.java` | Enemy portrait widget. |
| `ahd` | `MyHudEnergyBar.java` | Local player energy HUD. |
| `ahe` | `MyHudHealthBar.java` | Local player health HUD. |
| `ahf` | `MyHudManaBar.java` | Local player mana HUD. |
| `ahg` | `MyHudRageBar.java` | Local player rage HUD. |
| `ahs` | `NameplateFrame.java` | Base nameplate frame. |
| `aho` | `NameplateAllyFrame.java` | Ally nameplate. |
| `ahq` | `NameplateEnemyFrame.java` | Enemy nameplate. |
| `ahu` | `TopFrameMe.java` | Top frame for local player. |
| `ahx` | `TopFrameTarget.java` | Top target frame. |
| `ahi` | `TabFrame.java` | Tab frame widget. |
| `ahl` | `TargetPortrait.java` | Target portrait widget. |
| `ajt` | `PlayScoreboard.java` | In-game scoreboard. |
| `ajr` | `HoverableScoreboardItem.java` | Scoreboard hover region item. |
| `ajs` | `HoveredScoreboardItem.java` | Comparable hovered scoreboard item. |
| `aju` | `ScoreboardRow.java` | Scoreboard row renderer. |

## Spells and effects

`ui` is the base spell class (`Spell.java`). It implements `DrawableObject` and stores caster/target player references, hit/location data, animation state, and rendering helpers.

`ue`, `ug`, and `ul` are concrete spell base categories:

- `ue`: `DynamicPlayerSpell.java`
- `ug`: `FixedPlayerSpell.java`
- `ul`: `TargetedProjectileSpell.java`

`uh` is `LegalTargets.java`, an enum/helper for legal target categories.

Effects use a parallel hierarchy:

- `oo`: `ApplicableEffect.java`, base drawable effect.
- `rc`: `Enchantment.java`, positive/buff-like effect.
- `pe`: `Curse.java`, negative/debuff-like effect.
- `ou`: `Aura.java`, aura effect.
- `op`: `EffectIcon.java`, UI icon for active effects.
- `or`: `EffectStore.java`, factory/store mapping `EffectList` values to effect renderers.
- `oq`: `EffectPriority.java`, effect sorting/priority.
- `ot`: `EffectType.java`, effect type enum.

Confirmed class-specific spell sources include:

- Assassin: `hr` `ASSASSIN_Annihilate`, `hs` `ASSASSIN_Bandage`, `ht` `ASSASSIN_Basic`, `hu` `ASSASSIN_Dash`, `hv` `ASSASSIN_Daze`, `hw` `ASSASSIN_DisappearingAct`, `hx` `ASSASSIN_Envenom`, `hy` `ASSASSIN_MurderousInstincts`, `hz` `ASSASSIN_PoisonedBlades`, `ia` `ASSASSIN_Puncture`, `ib` `ASSASSIN_ShadowWalk`, `ic` `ASSASSIN_Shroud`, `id` `ASSASSIN_Slap`, `ie` `ASSASSIN_Slash`, `if` `ASSASSIN_Stealth`, `ig` `ASSASSIN_TempleStrike`, `ih` `ASSASSIN_WhirlingKnives`.
- Elder examples: `ja` `ELDER_Basic`, `jb` `ELDER_Bear`, `jc` `ELDER_Bear_Charge`, `jd` `ELDER_Bear_Ironhide`, `je` `ELDER_Bear_Smash`, `jf` `ELDER_CorrosiveAsp`, `jg` `ELDER_GraspingVines`, `jh` `ELDER_Inspiration`, `ji` `ELDER_MendingSpirit`, `jj` `ELDER_Remedy`, `jk` `ELDER_Revitalize`, `jl` `ELDER_Ritual`, `jm` `ELDER_SeedOfLife`.
- Common: `hp` `COMMON_Meditate`.

Confirmed effect/enchantment sources include examples such as `sf` `AegisEnchantment`, `rd` `BandageEnchantment`, `rs` `BearEnchantment`, `ox` `DarkInoculationEnchantment`, `re` `DashEnchantment`, `rf` `DustCloudEnchantment`, plus curse classes such as `qp` `AetherShotCurse`, `qe` `AmnesiaCurse`, `pn` `ArmorBreakCurse`, `po` `ChargeCurse`, `qx` `CombustCurse`, `pp` `CripplingSlashCurse`, `pi` `DazeCurse`, and `pu` `DeathsGraspCurse`.

## UI and asset classes

`aj` is settings persistence.

- Reads/writes `options.json` and `user.json`.
- Stores option keys from `ai` and user keys from `ak`.

`ai` is the options enum/defaults.

`ak` is the user settings enum/defaults.

`ajw` is the asset dependency enum/catalog.

- Entries map to atlas/audio/map/font paths such as `packed/screens/register/register_ui_core-v2.atlas`, lobby atlases, play atlases, sounds, and maps.

`axm` is abstract asset dependency holder.

- Concrete subclasses fill dependency arrays and expose loaded atlases.

`baa` is the sound manager.

- Plays sounds by `ajw`, including positional audio volume/distance.

`aaa` is tournament bracket overlay interaction.

- Renders `TournamentMatchData`, handles bracket panning/clicks, and sends `/spectate <captain>` chat commands.

`aab` is tournament bracket data/controller.

`aaf` is tournament bracket screen/widget assembly.

`aay`, `aem`, `azw`, `axj`, `acq`, and related store-prefixed classes are store/MTX widgets.

`abr`, `as`, `ada`, `adb`, and inventory/stash strings are inventory/item UI.

`aax`, `abd`, and `aao` are keybind/hotkey UI.

`ayh` is image/sprite UI component.

`ayf` is hover/click rectangular region.

`ayg` is hoverable region data.

`aya` is a Scene2D stage/screen UI base.

`ayl` is optional screen data / transition payload base.

`azk` and `azl` are scroll/list containers.

### Reconstructed settings slice

A clean, compilable reconstruction has been started under `reconstructed/`.

Current readable classes:

| Reconstructed class | Original source | Obfuscated class | Status |
| --- | --- | --- | --- |
| `OptionName` | `OptionName.java` | `ai` | Compiles; readable enum names inferred from call sites; original persisted symbols retained. |
| `UserName` | `UserName.java` | `ak` | Compiles; readable names inferred from login remembered-username call site. |
| `OptionsStore` | `Options.java` | `aj` | Compiles; functional load/save replacement for `options.json` and `user.json`. |
| `DesktopLaunchConfig` | extracted from `DesktopLauncher.java` | `DesktopLauncher` logic | Compiles; isolates fullscreen/vsync/FPS decisions. |
| `Timer` | `Timer.java` | `azv` | Compiles; autonomous replacement for Apache `StopWatch`-backed timer behavior. |
| `ConnectionProtocol` | `ConnectionProtocol.java` | `v` | Compiles; constants confirmed by bytecode. |
| `ConnectionStatus` | `ConnectionStatus.java` | `w` | Compiles; constants confirmed by bytecode. |
| `AuthenticationStatus` | `AuthenticationStatus.java` | `axn` | Compiles; constants confirmed by bytecode. |
| `SteamWebsocketFramework` | `SteamWebsocketFramework.java` | `ad` | Compiles; dependency-light abstraction of websocket base state. |
| `SteamConnectionFramework` | `SteamConnectionFramework.java` | `y` | Compiles; dependency-light abstraction of Kryonet base state. |
| `SteamLoginClient` | `SteamLoginClient.java` | `z` | Compiles as skeleton; captures login URL selection, status transitions, send gate, and incoming queue. |
| `SteamGameClientKryonet` | `SteamGameClientKryonet.java` | `ag` | Compiles as skeleton; captures endpoint setup, incoming queue, deferred game init, force-send, and outgoing dedupe/batch behavior. |
| `PublicNetworkListener` | `PublicNetworkListener.java` | `ae` | Compiles; captures connect token send, ping response, deferred game init, packet queueing, and disconnect status handling. |
| `PublicSerializerCatalog` | `PublicSerializer.java` | `af` | Compiles; preserves Kryo registration order as class-name catalog. |
| `PlayerUpdateBundle` | `PlayerUpdateBundle.java` | named packet class | Compiles; typed bundle for outgoing input/update packets. |
| `SteamPingManager` | `SteamPingManager.java` | `ab` | Compiles; game ping timer, rolling average, and region probe behavior. |
| `SteamWSPingManager` | `SteamWSPingManager.java` | `ac` | Compiles; websocket login ping timer behavior. |

Important compatibility decision: the original client persists enum keys using the obfuscated enum constant names (`a`, `b`, `S`, etc.). The reconstructed enums use readable Java constants, but each constant carries `originalSymbol()`. `OptionsStore` can load either readable names or original symbols, and writes original symbols by default.

Currently inferred `OptionName` roles:

| Original symbol | Reconstructed name | Default | Evidence |
| --- | --- | --- | --- |
| `a` | `IDLE_FPS` | `REFRESH_RATE` | `DesktopLauncher` uses this for `setIdleFPS`. |
| `b` | `FOREGROUND_FPS` | `REFRESH_RATE` | `DesktopLauncher` uses this for `setForegroundFPS`. |
| `c` | `VSYNC` | `false` | `DesktopLauncher` enables vsync in fullscreen path. |
| `d` | `FULLSCREEN` | `false` | `DesktopLauncher` chooses fullscreen/windowed path. |
| `e` | `REGION_US_EAST` | `true` | `OptionsPanel`/`aba` toggles US region and sends `PUB_MISC_REGION_CHANGE`. |
| `f` | `REGION_EU_WEST` | `true` | `OptionsPanel`/`abb` toggles EU region and sends `PUB_MISC_REGION_CHANGE`. |
| `g` | `ENABLE_TARGET_CURSOR` | `true` | `InputRequest_ClickTargetable` gates cursor target hover logic. |
| `h` | `KEEP_TARGET_WHEN_CLICKING_EMPTY_GROUND` | `true` | `InputRequest_ClickTargetable` gates target clearing on empty click. |
| `i` | `SHOW_PARTY_TAB_FRAMES` | `true` | `BottomPanel` adds `TabFrame` widgets when enabled. |
| `j` | `SHIFT_CLICK_PREVENTS_ENEMY_TARGETING` | `true` | Click target logic checks Shift keys 59/60 before enemy targeting. |
| `k` | `CTRL_CLICK_PREVENTS_ALLY_TARGETING` | `true` | Click target logic checks Ctrl keys 129/130 before ally targeting. |
| `l` | `SHOW_NAMEPLATES_IN_PRACTICE` | `true` | `NameplateFrame` uses it while not in spectator/practice-like state. |
| `S` | `MASTER_VOLUME` | `75` | `OptionsPanel` slider initializes and saves volume. |
| `Q` | `SHOW_BOTTOM_ALLY_PANEL` | `true` | `BottomPanel` gates ally bottom panel rendering. |
| `R` | `SHOW_BOTTOM_ENEMY_PANEL` | `true` | `BottomPanel` gates enemy bottom panel rendering. |
| `U` | `ENABLE_SPELL_VISUAL` | `true` | Class `i` skips rendering/behavior when disabled. |

Portrait/layout options are partly inferred:

- `w`, `z`, `C` hide ally portraits 1-3.
- `H`, `K`, `N` hide enemy portraits 1-3.
- `x/y`, `A/B`, `D/E` are ally portrait offsets or positions.
- `I/J`, `L/M`, `O/P` are enemy portrait offsets or positions.
- `F` gates target ring / target indicator rendering in `SharedPlayer`.

Some old boolean flags remain deliberately named `RESERVED_*` until their behavior is confirmed by more call sites.

### Reconstructed timer slice

`azv` is confirmed as original source `Timer.java`. It wraps Apache Commons `StopWatch` in the shipped client. The reconstructed version in `com.arenaofkings.reconstruct.util.Timer` removes that dependency and preserves the observed behavior:

- constructors with duration and optional immediate start;
- `start`, `stop`, `restart`, `restartFor`, and `reset`;
- elapsed time by `TimeUnit`;
- progress as elapsed / active duration;
- normal expiry, one-shot override duration expiry, and `NEVER_EXPIRES`;
- remaining seconds/milliseconds;
- forced-expired flag.

This class is heavily used by ping managers, screen transitions, input throttling, effects, spell timers, and play-screen state transitions, so it is a good anchor for later network and gameplay reconstruction.

### Reconstructed network slice

The network reconstruction deliberately introduces `PacketTransport` and `PacketHandler` boundaries. This avoids depending on Java-WebSocket and Kryonet while preserving client behavior in compilable, testable Java.

`SteamLoginClient` preserves:

- live/PTR login-server URL selection;
- status transitions between `READY`, `CONNECTING`, `CONNECTED`, and `REJECTED`;
- `Online`/`Offline`/`Unknown` connection status;
- send gating equivalent to the original `b` flag plus websocket open check;
- incoming packet queue snapshotting before handling.

`SteamGameClientKryonet` preserves:

- endpoint configuration (`host`, TCP port, UDP port);
- connect-request flag;
- incoming packet queue processing only when the play screen is active;
- deferred `PUB_GAME_INIT`-style handling while lobby/loading screens are active;
- force-send path;
- pending update batching;
- last-one-wins deduplication by packet class for high-frequency input packets.

Current limitation: the reconstructed network clients send a copied `List<Object>` as the batch transport payload. The original sends a `PlayerUpdateBundle`. A later slice should reconstruct a typed `PlayerUpdateBundle` wrapper and movement request marker types so the API mirrors the shipped client more closely.

Update: `SteamGameClientKryonet` now sends reconstructed `PlayerUpdateBundle` objects. The bundle currently stores `GamePacket` instances, and readable movement packet stand-ins (`MoveRequestPacket`, `MoveReleasePacket`, `DirectionChangeRequestPacket`) have been introduced. The next refinement is to split the grouped movement stand-ins into exact original request class names if source compatibility with packet names becomes necessary.

`PublicNetworkListener` behavior reconstructed from `ae`:

- `connected`: marks the game client authenticated and force-sends `PUB_MISC_PLAYER_TOKEN` equivalent with token and game id.
- `received`: ignores framework messages, routes ping responses to ping timing, stores game-init packets separately, and enqueues other packets.
- `disconnected`: clears deferred game init, marks unauthenticated, and emits `GameStatus.ENDED` unless login-client relog is required.

`PublicSerializerCatalog` currently contains 128 registrations, including the duplicate `PlayerItemDropData` registration present in the original source.

### Reconstructed ping slice

`SteamPingManager` (`ab`) behavior:

- sends a `PUB_GAME_PING` equivalent every 5000 ms while connected;
- restarts a 25000 ms timeout timer after sending;
- records ping responses from `System.nanoTime()` deltas;
- seeds a 10-sample rolling buffer with the first ping and maintains an average;
- probes `3.80.0.0` and `3.64.0.0` as US/EU latency hosts;
- chooses `US_EAST` when US ping is lower, otherwise `EU_WEST`.

`SteamWSPingManager` (`ac`) behavior:

- sends `PUB_LOGIN_PING` equivalent every 5000 ms while websocket transport is open;
- sends the serialized game ping string through the raw transport as the websocket ping stand-in;
- restarts a 25000 ms timeout timer.

Original UI/input/store/item source names confirmed from bytecode:

| Class | Original source | Role |
| --- | --- | --- |
| `aj` | `Options.java` | Options persistence. |
| `ai` | `OptionName.java` | Option enum/defaults. |
| `ak` | `UserName.java` | User settings enum/defaults. |
| `agc` | `Keybinds.java` | Keybind mapping/store. |
| `agb` | `Keybind.java` | Keybind interface. |
| `aik` | `PlayInputAdapter.java` | Play input adapter. |
| `ail` | `PlayInputRequest.java` | Base play keyboard request. |
| `aim` | `PlayMouseRequest.java` | Base play mouse request. |
| `aii` | `InputRequest_ClearTarget.java` | Clear target input. |
| `aij` | `InputRequest_TargetNearestEnemy.java` | Target nearest enemy input. |
| `ain` | `InputRequest_ClickTargetable.java` | Click target input. |
| `aio` | `InputRequest_MoveEast.java` | Move east input. |
| `aip` | `InputRequest_MoveNorth.java` | Move north input. |
| `aiq` | `InputRequest_MoveSouth.java` | Move south input. |
| `air` | `InputRequest_MoveToCursor.java` | Move-to-cursor input. |
| `ait` | `InputRequest_MoveWest.java` | Move west input. |
| `aiu`-`ajb` | `InputRequest_PerformAbility1..8.java` | Ability hotkey inputs. |
| `ajc` | `InputRequest_PerformBasicAbility.java` | Basic attack/ability input. |
| `ajd` | `InputRequest_TabTarget.java` | Tab targeting input. |
| `aje`-`ajf` | `InputRequest_TargetAlly2..3.java` | Ally targeting inputs. |
| `ajg`-`aji` | `InputRequest_TargetEnemy1..3.java` | Enemy targeting inputs. |
| `ajj` | `InputRequest_TargetSelf.java` | Self-target input. |
| `ajk` | `InputRequest_UseTrinket1.java` | Trinket input. |
| `ajl` | `PlayCloseChat.java` | Close chat input. |
| `ajm` | `PlayMeditate.java` | Meditate input. |
| `ajn` | `PlayToggleChat.java` | Toggle play chat input. |
| `aal` | `LobbyInputAdapter.java` | Lobby input adapter. |
| `aam` | `LobbyInputRequest.java` | Base lobby keyboard request. |
| `aan` | `LobbyMouseRequest.java` | Base lobby mouse request. |
| `aao` | `LobbyToggleChat.java` | Toggle lobby chat input. |
| `aap` | `LobbyToggleInventory.java` | Toggle inventory input. |
| `aaq` | `LobbyToggleVendor.java` | Toggle vendor/store input. |
| `aar` | `ScrollChat.java` | Chat scroll input. |
| `aas` | `ScrollFriendsList.java` | Friends list scroll input. |
| `aat` | `ScrollProfileBackgrounds.java` | Profile backgrounds scroll input. |
| `aau` | `ScrollProfileEffects.java` | Profile effects scroll input. |
| `aav` | `ScrollSpellBook.java` | Spell book scroll input. |
| `aaw` | `ScrollStorePanel.java` | Store scroll input. |
| `aya` | `GUIManager.java` | Base UI manager. |
| `ayh` | `ImageGFX.java` | Image/sprite widget. |
| `ayf` | `HoverableComponent.java` | Hover/click component. |
| `ayg` | `HoverableRegion.java` | Hover region data. |
| `ayl` | `OptionalScreenData.java` | Screen transition payload. |
| `yf` | `LobbyPanel.java` | Lobby panel base. |
| `ze` | `SubPanel.java` | Store/subpanel base. |
| `zm` | `ESportsSubPanel.java` | Esports/tournament subpanel base. |
| `aay` | `OptionsPanel.java` | Options panel. |
| `abc` | `OptionsSubPanel.java` | Base options subpanel. |
| `abd` | `Options_KeybindsSubPanel.java` | Keybind options subpanel. |
| `aax` | `KeybindElement.java` | Keybind UI element. |
| `abg` | `StoreItem.java` | Store item base. |
| `abi` | `StoreUnlockableItem.java` | Store unlockable enum/content. |
| `abk` | `Store_CheckoutVCSubPanel.java` | Villain Coins checkout subpanel. |
| `abr` | `Store_ClassSkinsSubPanel.java` | Class skins store subpanel. |
| `abs` | `Store_FeaturedSubPanel.java` | Featured store subpanel. |
| `abz` | `Store_MembershipSubPanel.java` | Membership store subpanel. |
| `acf` | `Store_MiscellaneousSubPanel.java` | Misc store subpanel. |
| `acg` | `Store_ProfileBackgroundsSubPanel.java` | Profile background store subpanel. |
| `ach` | `Store_ProfileEffectsSubPanel.java` | Profile effect store subpanel. |
| `aci` | `Store_SpellSkinsSubPanel.java` | Spell skins store subpanel. |
| `acq` | `PurchaseClassSkin.java` | Purchase class skin item. |
| `acz` | `PurchaseConsumableItem.java` | Purchase consumable item. |
| `ads` | `PurchaseProfileBackground.java` | Purchase profile background. |
| `aek` | `PurchaseProfileEffect.java` | Purchase profile effect. |
| `ael`-`aeq` | `PurchaseVC*.java` | Villain Coin purchase items. |
| `fm` | `Item.java` | Base item view/model wrapper. |
| `fh` | `EquippableItem.java` | Equipment item. |
| `fv` | `Armor.java` | Armor item. |
| `fx` | `Consumable.java` | Consumable item. |
| `am` | `EquippableSlot.java` | Equipment slot UI. |
| `as` | `Inventory.java` | Inventory UI/model. |
| `ya` | `CharacterPanel.java` | Character panel. |
| `yg` | `MatchmakingPanel.java` | Matchmaking panel. |
| `fe` | `ChannelsTable.java` | Chat/channel table. |
| `b` | `Chat.java` | Chat dialog. |
| `d` | `ChatLabel.java` | Chat label. |
| `g` | `ChatMessage.java` | Chat message wrapper. |

## Visual effect classes

The following classes are small visual effect/profile skin definitions. Bytecode confirms they are profile effect source files:

- `adt`: `ProfileEffect0.java` / BlackSmoke
- `adu`: `ProfileEffect1.java` / Clouds
- `adv`: `ProfileEffect10.java` / Lightning2
- `adw`: `ProfileEffect11.java` / Stars
- `adx`: `ProfileEffect12.java` / Clouds2
- `ady`: `ProfileEffect13.java` / Tornado
- `adz`: `ProfileEffect14.java` / WhiteSmoke
- `aea`: `ProfileEffect15.java` / PhoenixRed
- `aeb`: `ProfileEffect2.java` / PhoenixRed
- `aec`: `ProfileEffect3.java` / Hearts
- `aed`: `ProfileEffect4.java` / Bubbles
- `aee`: `ProfileEffect5.java` / Rain
- `aef`: `ProfileEffect6.java` / Snow
- `aeg`: `ProfileEffect7.java` / Lightning
- `aeh`: `ProfileEffect8.java` / Wisps
- `aei`: `ProfileEffect9.java` / Rainbow
- `aej`: `ProfileEffectNone.java`

Profile backgrounds and purchasable image data:

- `adc`: `ImageGFXData.java`
- `add`-`adr`: `ProfileBackground*.java`
- `acv`: `CharacterSlot.java`
- `acw`-`acy`: `MembershipScroll1..3.java`
- `ada`: `StashTab.java`
- `adb`: `StashTabBundle.java`
- `aer`: `SkinData.java`
- `acj`-`acu`: class outfit skin data (`AssassinOutfit2`, `ChampionOutfit2`, etc.)

## Proposed rename map

No source files have been renamed in this pass. The current tree does not compile, and mass-renaming before repairing package/decompiler damage would make the failure harder to isolate.

Suggested first rename batch once compile structure is fixed:

| Current | Proposed name | Confidence | Reason |
| --- | --- | --- | --- |
| `l` | `AoKGame` | Confirmed | Original source `AoKGame.java`. |
| `Engine` | `Engine` | Certain | Already named central LibGDX game class. |
| `aj` | `Options` | Confirmed | Original source `Options.java`. |
| `ai` | `OptionName` | Confirmed | Original source `OptionName.java`. |
| `ak` | `UserName` | Confirmed | Original source `UserName.java`. |
| `z` | `SteamLoginClient` | Confirmed | Original source `SteamLoginClient.java`. |
| `aa` | `SteamLoginClientSocket` | Confirmed partial | Same source as `SteamLoginClient`; concrete websocket callback class. |
| `ac` | `SteamWSPingManager` | Confirmed | Original source `SteamWSPingManager.java`. |
| `ad` | `SteamWebsocketFramework` | Confirmed | Original source `SteamWebsocketFramework.java`. |
| `y` | `SteamConnectionFramework` | Confirmed | Original source `SteamConnectionFramework.java`. |
| `ag` | `SteamGameClientKryonet` | Confirmed | Original source `SteamGameClientKryonet.java`. |
| `ae` | `PublicNetworkListener` | Confirmed | Original source `PublicNetworkListener.java`. |
| `af` | `PublicSerializer` | Confirmed | Original source `PublicSerializer.java`. |
| `axc` | `AbstractScreen` | Confirmed | Original source `AbstractScreen.java`. |
| `axb` | `AbstractLoadingScreen` | Confirmed | Original source `AbstractLoadingScreen.java`. |
| `axm` | `AssetDependencies` | Confirmed | Original source `AssetDependencies.java`. |
| `ajw` | `ScreenDependency` | Confirmed | Original source `ScreenDependency.java`. |
| `axr` | `DrawableObject` | Confirmed | Original source `DrawableObject.java`. |
| `azi` | `Renderer` | Confirmed | Original source `Renderer.java`. |
| `axf` | `AoKShapeRenderer` | Confirmed | Original source `AoKShapeRenderer.java`. |
| `axe` | `AoKColors` | Confirmed | Original source `AoKColors.java`. |
| `axy` | `FontHolder` | Confirmed | Original source `FontHolder.java`. |
| `azv` | `Timer` | Confirmed | Original source `Timer.java`. |
| `afx` | `LoginLoadingScreen` | Confirmed | Original source `LoginLoadingScreen.java`. |
| `aes` | `Login` | Confirmed | Original source `Login.java`. |
| `xw` | `LobbyLoadingScreen` | Confirmed | Original source `LobbyLoadingScreen.java`. |
| `we` | `Lobby` | Confirmed | Original source `Lobby.java`. |
| `vh` | `AccountCreationLoadingScreen` | Confirmed | Original source `AccountCreationLoadingScreen.java`. |
| `um` | `AccountCreation` | Confirmed | Original source `AccountCreation.java`. |
| `ajo` | `PlayLoadingScreen` | Confirmed | Original source `PlayLoadingScreen.java`. |
| `agd` | `Play` | Confirmed | Original source `Play.java`. |
| `agl` | `PlayAssetDependencies` | Confirmed | Original source `PlayAssetDependencies.java`. |
| `agr` | `PlayWorld` | Confirmed | Original source `PlayWorld.java`. |
| `agt` | `BottomPanel` | Confirmed | Original source `BottomPanel.java`. |
| `ajt` | `PlayScoreboard` | Confirmed | Original source `PlayScoreboard.java`. |
| `aju` | `ScoreboardRow` | Confirmed | Original source `ScoreboardRow.java`. |
| `ay` | `Me` | Confirmed | Original source `Me.java`. |
| `br` | `SharedPlayer` | Confirmed | Original source `SharedPlayer.java`. |
| `gf` | `MyFriendlyParty` | Confirmed | Original source `MyFriendlyParty.java`. |
| `ge` | `MyEnemyParty` | Confirmed | Original source `MyEnemyParty.java`. |
| `gd` | `MyPrivateData` | Confirmed | Original source `MyPrivateData.java`. |
| `aq` | `FriendlyPlayer` | Confirmed | Original source `FriendlyPlayer.java`. |
| `al` | `EnemyPlayer` | Confirmed | Original source `EnemyPlayer.java`. |
| `az` | `MovementManager` | Confirmed | Original source `MovementManager.java`. |
| `bb` | `MyMovementManager` | Confirmed | Original source `MyMovementManager.java`. |
| `cr` | `AnimationManager` | Confirmed | Original source `AnimationManager.java`. |
| `cy` | `PlayerSheetAnimations` | Confirmed | Original source `PlayerSheetAnimations.java`. |
| `cw` | `LegalPlayerAction` | Confirmed | Original source `LegalPlayerAction.java`. |
| `cv` | `CharacterForm` | Confirmed | Original source `CharacterForm.java`. |
| `da` | `SpriteSheetAnimation` | Confirmed | Original source `SpriteSheetAnimation.java`. |
| `aaa` | `TournamentBracket` | Confirmed | Original source `TournamentBracket.java`. |
| `aab` | `TournamentEntry` | Confirmed | Original source `TournamentEntry.java`. |
| `aaf` | `TournamentsSubPanel` | Confirmed | Original source `TournamentsSubPanel.java`. |
| `baa` | `SoundManager` | Confirmed | Original source `SoundManager.java`. |
| `aax` | `KeybindElement` | Confirmed | Original source `KeybindElement.java`. |
| `abd` | `Options_KeybindsSubPanel` | Confirmed | Original source `Options_KeybindsSubPanel.java`. |
| `aao` | `LobbyToggleChat` | Confirmed | Original source `LobbyToggleChat.java`. |
| `ayh` | `ImageGFX` | Confirmed | Original source `ImageGFX.java`. |
| `ayf` | `HoverableComponent` | Confirmed | Original source `HoverableComponent.java`. |
| `ayg` | `HoverableRegion` | Confirmed | Original source `HoverableRegion.java`. |
| `aya` | `GUIManager` | Confirmed | Original source `GUIManager.java`. |
| `ayl` | `OptionalScreenData` | Confirmed | Original source `OptionalScreenData.java`. |

## Compile blockers found

The current source tree is not directly buildable.

Observed with:

```powershell
javac -cp decompiled -d build_tmp decompiled\com\arenaofkings\client\desktop\DesktopLauncher.java
```

First-order blockers:

- Named package classes such as `DesktopLauncher` and `Engine` reference root/default-package classes (`aj`, `l`, `azm`, `z`, `ag`, `axc`, etc.). `javap` confirms this is the real bytecode layout (`DesktopLauncher` directly instantiates class `aj`). Java source cannot express this from a named package, so a source rebuild requires moving those classes into packages and rewriting references, or using bytecode-level tooling.
- Decompiled third-party sources are invalid and should not be compiled from `decompiled/`. Examples: `com.badlogic.gdx.utils.Json`, `JsonReader`, and `Table` contain CFR artifacts such as `void i3;` and `** GOTO`.
- LWJGL decompiled sources require `javax.annotation.Nullable`, which is missing if compiling from source with JDK 20.
- CFR produced corrupted local/field types in game classes. Examples include fields declared as `Engine` but assigned `new ArrayList()`, `new Client(...)`, or `false`. This is not source-level Java and must be repaired by redecompiling with better settings or reconstructing types manually from bytecode.

Recommended compile strategy:

1. Do not compile bundled third-party decompiled sources. Use original JAR dependencies from `app/Client.jar` or extracted library jars if available.
2. Re-decompile only game classes with a second decompiler (Vineflower/Quiltflower/Procyon) and compare output against CFR.
3. Restore packages for obfuscated game classes before renaming. This is required for source-level Java, even though it changes the original bytecode package layout.
4. Repair obvious CFR type corruption before attempting large renames.
5. Rename classes in small batches, keeping a mapping file and running compile after each batch.
