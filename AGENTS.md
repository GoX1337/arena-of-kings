# AGENTS.md — Arena of Kings (Java + libGDX)

> Instructions for AI coding agents working on this repository.
> You are an expert video-game developer specializing in Java, libGDX, 2D action games,
> game feel, animation systems, cameras, input handling, and asset pipelines.

## 1. Project overview

Top-down 2D arena prototype built with libGDX (LWJGL3 desktop backend).

Core fantasy: a centered hero (follow camera), move with **ZQSD / WASD / arrows**,
aim with the **mouse** (8 directions), **left-click = attack**, **right-click = cast**.

Key files:

- `pom.xml` — Java 17, libGDX `1.12.1`, `lwjgl3` backend, shade + exec plugins.
- `src/main/java/com/arenaofkings/DesktopLauncher.java` — desktop entry point, 1280x720, vsync, 60 FPS.
- `src/main/java/com/arenaofkings/ArenaOfKingsGame.java` — entire game: loop, input, camera, animation, HUD, skin selector UI.
- `assets/skins.list` — manifest, one skin folder per line, e.g. `wizard/outfit_1/dark`.
- `assets/models/<character>/<outfit>/<variant>/full.atlas` + PNGs — packed sprites.
- `README.md` — controls, direction mapping, tuning constants, Windows build.

No ECS, no Box2D, no networking, no tests. Single-screen prototype. Keep it that way
unless explicitly asked to add a system.

## 2. Tech stack and commands

- Java 17 (required), Maven 3.9+, libGDX 1.12.1, LWJGL3 desktop only.
- Assets in `assets/` are copied to the classpath at build time via `pom.xml` `<resources>`.
- RTK obligatoire : préfixer toute commande shell par `rtk` (`rtk git status`, `rtk mvn ...`, `rtk read/grep/find/ls`). Voir skill `rtk` + hook `.opencode/plugins/rtk-enforce.ts`.

```powershell
# Run the game (dev loop)
mvn compile exec:java

# Fast compile check
mvn -q -DskipTests compile

# Full packaged jar (shaded, ~379 MB, includes all natives)
mvn package -DskipTests

# Windows app-image (.exe)
jpackage --type app-image --input target --dest dist --name ArenaOfKings `
  --main-jar arena-of-kings-1.0-SNAPSHOT.jar --main-class com.arenaofkings.DesktopLauncher `
  --app-version 1.0 --vendor ArenaOfKings --description "Arena of Kings ZQSD souris"
# Launch: dist/ArenaOfKings/ArenaOfKings.exe
```

Notes:

- `target/` contains both `arena-of-kings-1.0-SNAPSHOT.jar` (shaded, use this) and
  `original-*.jar` (pre-shade, do NOT ship; exclude it from `jpackage --input` to save ~365 MB).
- `jpackage` requires a full JDK (17+) with `jpackage` on PATH.
- Do not upgrade libGDX / Java version without asking. LWJGL natives are version-sensitive.

## 3. Architecture (read this before editing)

`ArenaOfKingsGame extends ApplicationAdapter` — everything lives here:

1. `create()` — `SpriteBatch`, `ShapeRenderer`, `OrthographicCamera` (zoomed), `Stage` + Scene2D skin-selector UI, then `loadSkin(DEFAULT_SKIN)`.
2. `render()` — fixed order, do not reorder without reason:
   a. `dt = min(delta, 1/20)` (spike clamp),
   b. movement input → normalize diagonal → `player += dir * SPEED * dt`,
   c. `cam.unproject(mouse)` → `mouseWorld` → `dir = computeDir(...)`,
   d. clicks (ignored if over UI) → trigger `acting` with `actTime = 0`,
   e. camera lock `cam.position = player`, `cam.update()`,
   f. `drawGrid()` (ShapeRenderer) → `drawPlayer()` (SpriteBatch) → `drawHud()` (SpriteBatch),
   g. `stage.act(dt); stage.draw();`
3. `resize()` — update camera viewport + `stage.getViewport().update(w, h, true)`.
4. `dispose()` — dispose `batch`, `shapes`, `font`, `uiFont`, `uiTextures`, `stage`, `atlas`. Every new `Texture`/`Atlas`/`Skin` must be disposed.

Game feel constants (top of `ArenaOfKingsGame.java`):

- `SPEED = 500` world units/s, `SCALE = 2.5`, `ZOOM = 2` (camera zoom out).
- `IDLE_FPS = 1/20`, `RUN_FPS = 1/40`, `HIT_FPS = 1/50` (attack/cast).
- Canvas reference `252x238` (max `orig` size in atlas); recomputed per skin from `originalWidth/Height`.

## 4. Critical: animation / atlas system (most bugs come from here)

Atlas packing convention (do NOT break):

- Region `name` = action: `idle`, `run`, `attack`, `attack_run`, `cast`, `cast_run`.
  Animals (e.g. some `elder` forms) only have `idle`/`run` — clicks are no-ops for them by design.
- Region `index = direction * 10000 + frame`. Direction mapping:
  `0=S, 1=SE, 2=E, 3=NE, 4=N, 5=NO, 6=O, 7=SO`.
- `computeDir(dx, dy)`: `ang = atan2(dy, dx)` in degrees (0=E), then `(round(ang/45)+2) % 8`.
- Many frames are packed with `rotate: true`.
  **MUST use `TextureAtlas.AtlasSprite` + `sprite.setBounds(...); sprite.draw(batch);`**
  Never use `batch.draw(TextureRegion)` directly — the character will render rotated 90 degrees.
- `buildAnim(name, dir, frameDuration, playMode)` filters by `r.index / 10000 == dir`, sorts by `r.index % 10000`, wraps in `AtlasSprite`.
- `applyFallback()` replaces any null direction with the nearest non-null direction (circular scan). `idle` dir 0 is commonly missing — fallback covers it. Do not remove.
- `attack`/`cast` use `PlayMode.NORMAL` (one-shot); `idle`/`run` use `LOOP`.
- While `acting`, if `moving` and `actRunAnims[dir]` exists, prefer the `_run` variant. `acting` ends when `isAnimationFinished(actTime)`.
- `canvasW/H` = max `originalWidth/Height` over all regions; sprite bounds = `player - (canvasW*SCALE/2)`, size `canvasW*SCALE x canvasH*SCALE`. This keeps AtlasSprite offsets stable — do not center on frame size.

When adding a new action:

1. Respect `index = dir*10000 + frame` in the packer.
2. Add `Animation[]` arrays + `buildAnim` calls in `loadSkin()` + `applyFallback()`.
3. Wire trigger in `render()` and selection in `drawPlayer()`.

## 5. Input rules

- Move: accept **both** ZQSD and WASD + arrows (AZERTY/QWERTY coverage). On AZERTY, `Z` often arrives as `W` — that is why both `Keys.W` and `Keys.Z` mean "up", and both `Keys.A` and `Keys.Q` mean "left". Never "simplify" to WASD-only.
- Aim: always mouse → world via `cam.unproject`. Never use screen coords for gameplay.
- Left = attack (`attack`/`attack_run`), Right = cast (`cast`/`cast_run`).
- Clicks over Scene2D UI must be ignored: `stage.hit(stageCoords) != null → skip`. Keep this guard.
- `ESC` = `Gdx.app.exit()`.
- Use `isKeyPressed` for movement, `isKeyJustPressed` for toggles, `isButtonJustPressed` for attacks. Clamp `dt`.

## 6. Camera and rendering rules

- Follow camera: `cam.position.set(player.x, player.y, 0)` every frame, `cam.zoom = ZOOM` (reapplied in `resize()`).
- `drawGrid()` uses `ShapeRenderer` with `cam.combined`; grid step `128`; visible rect = `viewport * zoom` centered on player. Begin/end `ShapeRenderer` strictly around shapes — never interleave with `SpriteBatch`.
- `drawPlayer()` and `drawHud()` use `SpriteBatch` with `cam.combined`. HUD is world-anchored (bottom-left of view), font scaled by `ZOOM`. Do not switch to screen coords without updating all three draw methods.
- One `batch.begin()/end()` per draw method. Do not hold `batch` open across methods. Do not allocate in `render()` (no `new Color`/`new Vector` per frame except existing patterns — prefer static colors).

## 7. Skins / assets pipeline

- Skin folder: `assets/models/<character>/<outfit>/<variant>/full.atlas` + PNGs.
- Manifest `assets/skins.list`: one relative folder per line, sorted, UTF-8 **without BOM** (code strips BOM, but do not reintroduce it).
- After adding models, regenerate:
  ```powershell
  Get-ChildItem assets/models -Recurse -Filter full.atlas | ForEach-Object { $_.DirectoryName.Replace($PWD.Path + '\assets\models\','').Replace('\','/') } | Sort-Object | Set-Content assets/skins.list -Encoding UTF8
  ```
- `loadSkinManifest()` builds `character -> outfit -> variants` map (`"-"` = no variant). `loadSkin(relDir)` disposes the old atlas, loads the new one, rebuilds all 8-dir animations, resets `acting`.
- UI: three `SelectBox<String>` (Perso/Tenue/Teinte) top-left. Changing character refreshes outfit+variant boxes, then reloads skin. `updatingBoxes` flag prevents recursive events — keep it.
- Programmatic UI skin is built in code (`boxDrawable`, `Pixmap 1x1 → Texture`). Every generated `Texture` is tracked in `uiTextures` and disposed. Follow the same pattern for new UI textures.
- `Gdx.files.internal(SKIN_DIR + relDir + "/full.atlas")` — paths use `/`, case-sensitive on some platforms. Verify atlas filename is exactly `full.atlas`.

## 8. UI (Scene2D) rules

- `Stage(ScreenViewport)` + `Table` top-left, `pad(10)`. `Gdx.input.setInputProcessor(stage)` — there is a single input processor; if you add custom `InputProcessor` handling, use `InputMultiplexer(stage, yours)` and keep UI hit-test priority.
- Styles are code-built (no `uiskin.json`). Reuse `boxDrawable()` for backgrounds/selections.
- All UI text is currently French. Keep French for player-facing strings unless asked otherwise; code comments may be French or English but stay consistent per file.

## 9. Code style and conventions

- Java 17, Maven compiler `source/target 17`. 2-space indent (matches existing files).
- Keep the single-class game structure. Extract a new class only for a self-contained system (e.g. `SkinLoader`, `AnimationSet`) and wire it minimally.
- Prefer `TreeMap`/`ArrayList` + explicit sorting for deterministic UI order (skins list is sorted).
- Null-safety: animation slots may be null before fallback; every `anim.getKeyFrame` call site must have a non-null guarantee (fallback or explicit null check as in click handlers).
- No logging frameworks; use `Gdx.app.log("ArenaOfKings", msg)`.
- French identifiers/comments exist historically — do not mass-rename. New code: English identifiers, concise comments.
- Commit messages: English only. Imperative mood (`Add`, `Fix`, `Remove` — never `Added`/`Fixes`), subject line ≤ 72 chars, no trailing period. Optional scope prefix (`anim:`, `ui:`, `assets:`, `build:`), e.g. `anim: Add dash action with 8-dir fallback`.

## 10. Performance and memory

- `assets/` is ~350 MB with many PNGs. Avoid duplicating atlases. Do not commit `target/`, `dist/`, `.idea/` (see `.gitignore`).
- Shaded jar is huge because it bundles all LWJGL natives (Windows/Linux/macOS, x64/arm). For dev, prefer `mvn exec:java`. For Windows-only distribution, consider stripping non-Windows natives as a follow-up (ask first).
- Dispose everything you create: `TextureAtlas`, `Texture`, `Pixmap` (after upload), `SpriteBatch`, `ShapeRenderer`, `BitmapFont`, `Stage`, `Skin`.
- Avoid per-frame allocation in `render()`, `drawGrid()`, `drawPlayer()`. Reuse `Vector2/3`, static `Color`s.

## 11. Common tasks (recipes)

Add a playable character/outfit/variant:

1. Drop `full.atlas` + PNGs under `assets/models/<char>/<outfit>/<variant>/`.
2. Regenerate `assets/skins.list` (command in §7).
3. Run, select via Perso/Tenue/Teinte boxes, verify all 8 dirs for `idle`/`run`/`attack`/`cast`.
4. Animals with only `idle`/`run` need no code change.

Tune game feel: edit `SPEED`, `SCALE`, `ZOOM`, `IDLE/RUN/HIT_FPS` at top of `ArenaOfKingsGame.java`, run and playtest. Mention old vs new values in your summary.

Add a new action (e.g. `dash`):

1. Pack frames with `index = dir*10000+frame`, `name = dash`.
2. Add `dashAnims[]` + build + fallback in `loadSkin()`.
3. Add trigger (key/mouse) in `render()` mirroring attack/cast, add branch in `drawPlayer()`, update HUD label.

Change window: edit `DesktopLauncher` (`setTitle`, `setWindowedMode`, `useVsync`, `setForegroundFPS`). Keep 60 FPS foreground unless asked.

## 12. Debugging

- Black/invisible character → atlas path wrong, `full.atlas` missing, or PNGs not on classpath. Check `Gdx.files.internal` path and `assets/` resource copying.
- Character rotated 90 degrees → you used `TextureRegion` instead of `AtlasSprite`. Fix per §4.
- Jitter/flicker → you centered on frame size instead of canvas size, or mixed `batch`/`shapes` without proper begin/end. Use `canvasW/H * SCALE` bounds.
- Missing direction snaps oddly → expected: `applyFallback` picks nearest non-null dir. Inspect atlas for missing `dir*10000` block.
- UI clicks trigger attacks → `overUi` guard broken or new input processor bypasses `stage.hit`. Restore guard.
- First skin entry duplicated → BOM in `skins.list`. Save UTF-8 without BOM.
- Desktop-only: if it runs via `mvn exec:java` but not as `jpackage` image, check `--main-jar`/`--main-class` and that `assets/` were packaged inside the jar (`jar tf target/*.jar | grep skins.list`).

## 13. Do NOT

- Do not replace `AtlasSprite` rendering with raw `TextureRegion` draws.
- Do not change `index = dir*10000 + frame` convention or `computeDir()` formula without updating all atlases + docs.
- Do not drop ZQSD support (keep ZQSD + WASD + arrows).
- Do not add `target/`, `dist/`, IDE files, or large binaries to git.
- Do not introduce a game engine, ECS library, physics engine, or networking without explicit approval.
- Do not refactor the whole class for style alone; keep diffs focused and playable.

## 14. Definition of done

- `mvn -q -DskipTests compile` passes with no errors.
- Game launches (`mvn compile exec:java`), hero renders upright, moves (ZQSD/WASD/arrows), faces mouse in 8 dirs, attacks/casts play once and return to `idle`/`run`, camera stays centered, UI selectors switch skins without crash, ESC quits.
- New assets appear in `skins.list` and load in-game.
- `git status` shows only intended files; no `target/`, `dist/`, `.idea/` artifacts.
- Summarize: what changed, how to playtest (keys/clicks/skins), tuning constants touched, known limitations.
