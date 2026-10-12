# Arena of Kings — minimal libGDX game

Screen-centered wizard (follow camera), **ZQSD** movement, **mouse** aiming
with the 8 directions from `full.atlas`. Left click = attack, right click = spell.

## Prerequisites

- Java 17
- Maven 3.9+
- Skins live in `assets/models/` (loaded via the classpath).

## Run

```powershell
mvn compile exec:java
```

## Controls

| Key | Action |
|---|---|
| Z / W / Up | Up |
| S / Down | Down |
| Q / A / Left | Left |
| D / Right | Right |
| Mouse | Character facing (8 directions) |
| Left click | Attack (`attack` toward the mouse) |
| Right click | Cast a spell (`cast` toward the mouse) |
| Esc | Quit |

Both ZQSD **and** WASD + arrows are accepted to cover AZERTY and QWERTY
(on AZERTY the `Z` key often arrives as `W`, hence the dual binding).

## Characters (`assets/models/`)

10 characters (`assassin`, `champion`, `elder`, `lich`, `mystic`, `nihilist`, `paladin`,
`ranger`, `scholar`, `wizard`), each with 2+ outfits (`outfit_1`, ...) in
`dark`/`light` variants (+ animal forms for `elder`, `outfit_3` for `lich`/`scholar`).

The game shows 3 dropdown lists at the top left: **Character / Outfit / Shade**.
On change it loads the skin: new atlas `assets/models/<character>/<outfit>/<shade>/full.atlas` +
rebuild of the 8 directions.
**Left click = `attack` / `attack_run`, right click = `cast` / `cast_run`**
(animals only have `idle`/`run`: clicks do nothing for them).

The skin list comes from `assets/skins.list` (one line = one `full.atlas` folder).
After adding models, regenerate with:
```powershell
Get-ChildItem assets/models -Recurse -Filter full.atlas | ForEach-Object { $_.DirectoryName.Replace($PWD.Path + '\assets\models\','').Replace('\','/') } | Sort-Object | Set-Content assets/skins.list -Encoding UTF8
```

## Net server (KryoNet, movement only)

Authoritative movement server: clients send input intents, the server integrates
positions at 20 Hz and broadcasts snapshots. No client-side prediction.

```powershell
# Terminal 1: server (TCP+UDP 54555)
mvn compile exec:java "-Dexec.mainClass=com.arenaofkings.server.GameServer"
# Terminal 2: game (connects to 127.0.0.1, falls back to local mode if unreachable)
mvn compile exec:java
# ...ou contre un VPS : variable d'environnement (prioritaire) ou propriété :
$env:AOK_HOST = "ton-vps-ou-ip"                    # Windows PowerShell
AOK_HOST=ton-vps-ou-ip mvn compile exec:java       # Linux/macOS
mvn compile exec:java "-Dserver.host=ton-vps-ou-ip"
```

Protocol (`src/main/java/com/arenaofkings/net/Net.java`): `Hello{version,skin}`,
`Welcome(id,x,y)`, `Input(x,y,dir,seq)`, `Snapshot(tick,serverTime,ids,xs,ys,skins,dirs,acks)`,
`Skin{skin}`, `Bye(id)` — registered in the same order both sides.
Realtime traffic (inputs, snapshots) goes over **UDP** (latest-wins, no
head-of-line blocking); handshake, skins and leaves go over **TCP**. Each input
carries a monotonic sequence the server uses to drop stale/duplicates, and each
snapshot carries the server timestamp plus per-player acks. Input magnitude is
clamped server-side, positions never come from clients.
Other players render with their real skins (idle/run + facing, broadcast by the
server; orange ring + `P<id>` fallback when unknown), HUD shows `net=P<id>/n=<count>`.

## Direction mapping (derived from the atlases)

`index = direction * 10000 + frame`:

| dir | Facing |
|---|---|
| 0 | South (facing camera) |
| 1 | South-East |
| 2 | East |
| 3 | North-East |
| 4 | North (back) |
| 5 | North-West |
| 6 | West |
| 7 | South-West |

Formula: `dir = (round(angleDeg / 45) + 2) % 8` with `angleDeg = atan2(dy, dx)` in world space (Y up).
See `ArenaOfKingsGame.computeDir()` (`src/main/java/com/arenaofkings/ArenaOfKingsGame.java`).

Note: `idle` has no direction 0 in `full.atlas` → automatic fallback to the
closest non-empty direction (`applyFallback`).

Technical note: many frames are packed with `rotate: true` in the atlas.
Rendering uses `TextureAtlas.AtlasSprite` (not `batch.draw(TextureRegion)`)
because only `AtlasSprite` compensates the 90-degree rotation — otherwise the character appears sideways.

## Tuning (`ArenaOfKingsGame.java`)

- `ZOOM = 2` — camera zoom-out (1 = no zoom).
- Animation speeds: `idle` 20 fps, `run` 40 fps, `attack`/`cast` 50 fps.
- `SPEED = 500` — move speed (world units/s).
- `SCALE = 2.5` — sprite size (original canvas 252x238).

## Windows build (.exe)

```powershell
mvn package -DskipTests
jpackage --type app-image --input target --dest dist --name ArenaOfKings `
  --main-jar arena-of-kings-1.0-SNAPSHOT.jar --main-class com.arenaofkings.DesktopLauncher `
  --app-version 1.0 --vendor ArenaOfKings --description "Arena of Kings ZQSD mouse"
```

Launch via `dist/ArenaOfKings/ArenaOfKings.exe`.

## Files

- `pom.xml` — libGDX 1.12.1 dependencies (lwjgl3)
- `src/main/java/com/arenaofkings/ArenaOfKingsGame.java` — game (movement, camera, idle/run/attack/cast animations)
- `src/main/java/com/arenaofkings/DesktopLauncher.java` — desktop launcher 1280x720
- `assets/` — `skins.list` + `models/<character>/<outfit>/<shade>/full.atlas` + PNGs (copied to the classpath at build time)
- `AGENTS.md` — instructions for AI coding agents
