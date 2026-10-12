# Multiplayer implementation — AI-agent reproduction guide

Exact recipe of the authoritative-movement multiplayer in this repo
(`src/main/java/com/arenaofkings/{net,server}` + wiring in the game).
Follow top to bottom to rebuild it identically.

Stack: Java 17, libGDX 1.12.1, KryoNet 2.22.0-RC1, Kryo 5.6.2, TCP+UDP 54555.

---

## 1. Dependencies (`pom.xml`)

```xml
<dependency>
  <groupId>com.esotericsoftware</groupId>
  <artifactId>kryonet</artifactId>
  <version>2.22.0-RC1</version>
</dependency>
<!-- Newer Kryo than KryoNet's default: its bundled ASM can't read Java 17 classes. -->
<dependency>
  <groupId>com.esotericsoftware</groupId>
  <artifactId>kryo</artifactId>
  <version>5.6.2</version>
</dependency>
```

Direct `kryo` dependency wins over KryoNet's transitive one (Maven nearest-wins).
Without it: `ReflectASM`/`ASM` from the old Kryo RC chokes on v61 class files.

`exec-maven-plugin` must use a property so the server can be launched:

```xml
<properties>
  <exec.mainClass>com.arenaofkings.DesktopLauncher</exec.mainClass>
</properties>
<configuration>
  <mainClass>${exec.mainClass}</mainClass>
</configuration>
```

A hardcoded `<mainClass>` in plugin config **silently ignores**
`-Dexec.mainClass=...` (real bug hit during this work).
PowerShell splits `-Dexec.mainClass=X` → always quote it:
`mvn compile exec:java "-Dexec.mainClass=com.arenaofkings.server.GameServer"`.

---

## 2. Protocol (`net/Net.java`) — the contract

Constants: `TCP_PORT = UDP_PORT = 54555` (same number, two protocols — legal),
`TICK_HZ = 20`, `SPEED = 500` (mirrors the game), `ARENA_HALF = 4000`.

| Class | Direction | Transport | Fields | Role |
|---|---|---|---|---|
| `Hello{version, skin}` | C→S | TCP | — | handshake + skin announce |
| `Welcome{id, x, y}` | S→C | TCP | — | identity + spawn; without it the client doesn't know which entity is "me" |
| `Input{x, y, dir, seq}` | C→S | **UDP** | normalized intent + facing 0-7 + monotonic seq | the ONLY client→server gameplay data; never positions |
| `Snapshot{tick, serverTime, ids[], xs[], ys[], skins[], dirs[], acks[]}` | S→all | **UDP** | parallel arrays, same length | single source of truth @20 Hz |
| `Skin{skin}` | C→S | TCP | — | mid-game character change without reconnect |
| `Bye{id}` | S→all | TCP | — | cleanup (no ghosts) |

Registration (`register(Kryo)`), **same order both sides** (Kryo IDs are
positional). KryoNet **requires explicit array registration** — missing
`int[].class` fails at runtime with `Class is not registered: int[]`
(caught by the smoke test, not the compiler):

```java
kryo.register(Hello.class);
kryo.register(Welcome.class);
kryo.register(Input.class);
kryo.register(Snapshot.class);
kryo.register(Bye.class);
kryo.register(Skin.class);      // appended LAST: never renumber existing IDs
kryo.register(int[].class);
kryo.register(float[].class);
kryo.register(String[].class);
```

Rules when evolving: **append** new packet classes at the end; adding
*fields* to existing classes is fine **only if server and clients redeploy
together** (old server + new client = Kryo stream mismatch → restart the
server on every protocol change).

---

## 3. Server (`server/GameServer.java`) — where authority lives

- `Server(1<<20, 1<<20)`, `bind(TCP_PORT, UDP_PORT)`, one Listener:
  - `connected` → assign `id` (AtomicInteger), spawn `(id%5)*80, 0`, store
    `Player{id,x,y,ix,iy,dir,lastSeq,skin}`, reply `Welcome` over TCP.
  - `received Hello/Skin` → store skin. `received Input` → **drop if
    `seq <= lastSeq`** (UDP duplicates/reorders), else store clamped
    magnitude (`len>1` → normalize) and clamped `dir` 0-7.
  - `disconnected` → remove + broadcast `Bye` over TCP.
- Fixed-timestep loop (`1e9/20` ns accumulator, backlog shed, never spiral):
  `pos += input × SPEED × dt`, clamp arena, build snapshot
  (`serverTime = System.nanoTime()`), **`sendToAllUDP`**.
- Logs joins/leaves/skin changes + full state every 5 s (invaluable for
  headless debugging). `stop()` + shutdown hook. `main()` = start + loop.
- Authority summary: a hacked client can only orient a ≤1 vector; speed,
  bounds, facing range and positions are all server-side.

---

## 4. Client (`net/NetClient.java`) — polling, no callbacks, no libGDX

Same pattern as the original (`ag`/`ae`): KryoNet listener runs on its own
thread and only writes `volatile` fields (`latest`, `selfId`, `open`) plus a
`ConcurrentLinkedQueue` for `Bye`. The render loop **polls**
(`snapshot()`, `pollLeft()`), never receives callbacks — therefore usable
headless in tests.

- `connect(host, timeoutMs, skin)`: blocking connect TCP+UDP, sends `Hello`,
  `false` on failure (game falls back to local mode).
- `sendInput(x, y, dir)` → assigns `++seq`, sends **UDP**, returns seq
  (game logs it in the prediction history) or -1 when offline.
- `sendSkin()`, `close()`, `isConnected()`.

---

## 5. Game wiring (`ArenaOfKingsGame.java`)

- Startup: `net.connect(host, 2000, currentSelection())` with
  `host = env AOK_HOST → -Dserver.host → 127.0.0.1`. Offline → old local
  movement untouched. Skin selector calls `net.sendSkin(...)` on change.
- Sending (`sendNetInput`, after mouse aim is computed): on input/facing
  change + 500 ms heartbeat; records `{seq → (ix,iy,sendMs)}` in
  `netHist` (TreeMap, capped 300) for replay.
- `updateNet(dt)` per frame:
  1. Drain `Bye` queue → drop all per-id state (render/dir/moving/skin).
  2. `pushSnapshot`: buffer with **local receipt time**, drop outdated/
     duplicate ticks, keep ~600 ms (cap 10). Gaps >100 ms are logged.
  3. `reconcileSelf` (latest snapshot): `err` vs server pos → prune
     `seq <= ack` → if `err > 40`: snap + **replay** pending inputs in order
     (each for its own duration, Java-int semantics, arena clamp);
     else melt 15 % toward truth. `err/maxErr` on HUD.
  4. `renderRemotes`: render at `now − 100 ms`, linear interp between the two
     bracketing snapshots (alpha clamped); run/idle from **drawn**
     displacement (snapshot deltas flicker at 20 Hz vs 60 fps — real bug
     fixed this way); facing from `dirs[]`; joiners shown immediately.
     <2 buffered snapshots → direct latest + light lerp.
- `RemoteSkin` cache (one atlas per skin folder, idle/run 8-dir + existing
  `applyFallback`, canvas bounds, `dispose()` on quit; failures remembered
  to avoid log spam). Unknown skin → orange ring + `P<id>` fallback.
- HUD: `net=P<id>/n=<count>/err=<cur>/<max>/buf=<n>` vs `local`.

---

## 6. Why these tunings (proven by logs, not guessed)

- Reconcile threshold **40**, melt **15 %**: threshold 8 sat exactly on the
  structural lead (~1 frame @500 u/s = 8.3u, beating 8.3/16.6 with tick
  phase) → snap **every snapshot** (20 Hz judder, visible in `netdbg`
  logs). 40 = above the beat; melt handles the rest; true divergence
  (spawn, hitches, teleports) still snaps + replays.
- Interpolation **100 ms** ≈ 2 snapshots @20 Hz: constant delay, zero judder
  under jitter; starvation only if a >100 ms gap (logged, absorbed).
- Heartbeat 500 ms: keeps server input fresh + acks advancing even when idle.

## 7. Runbook

```powershell
# Server (leave running; restart on ANY protocol change: Kryo mismatch)
mvn compile exec:java "-Dexec.mainClass=com.arenaofkings.server.GameServer"
# Games (each own window; ESC quits). Remote host:
$env:AOK_HOST = "vps-ip"; mvn compile exec:java
```

- `BindException: Address already in use` → stale server holds 54555:
  `netstat -ano | findstr 54555` → `taskkill /F /PID <n>`.
- VPS: JRE 17 headless, firewall TCP+UDP 54555, systemd unit, no display needed.
- Headless smoke test (kept out of repo, `Temp\opencode\Smoke.java`):
  in-process server + scripted clients asserting displacement ≈ `SPEED×t`,
  magnitude clamp (100,0 → Δ≈250 not 25000), stale-seq replay dropped,
  2 ids listed, `Bye` observed, skin/facing/timestamp/acks present →
  `SMOKE PASS`. Needs `target/classes` + dependency jars on the classpath.

## 8. Deliberate gaps (next phases)

No client auth/token, no rate limiting, no forced corrections for cheaters
(impossible to cheat positions by construction, but cooldowns/costs aren't
validated — spells aren't networked yet), no ping/region, no TCP fallback if
UDP is filtered, `Hello.version` never enforced (add a MIN check server-side
before any protocol bump), `NET_DEBUG` logs + HUD telemetry are temporary.
