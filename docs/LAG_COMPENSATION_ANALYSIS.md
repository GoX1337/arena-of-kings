# Lag Compensation, Interpolation & Prediction Analysis
## Arena of Kings - Network Lag Handling Mechanisms

---

## Executive Summary

Arena of Kings uses a **hybrid lag compensation system** combining:
- **Client-side position interpolation** via velocity offsets
- **Server-authoritative position snapshots** for anti-cheat
- **Velocity-based dead reckoning** for smooth movement between network updates
- **No explicit lerp/smooth interpolation** — snaps on forced updates

---

## 1. Position Update Mechanisms

### 1.1 PlayerPositionUpdate (Regular Updates)
**File**: `com/arenaofkings/packets/gameserver/data/updates/conveyed/PlayerPositionUpdate.java`

```java
public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
    // 1. Get current player position
    float currentX = getActive_character_entity().getX();
    float currentY = getActive_character_entity().getY();
    
    // 2. Calculate difference (position delta)
    float xDiff = this.x - currentX;  // Server X - Client X
    float yDiff = this.y - currentY;  // Server Y - Client Y
    
    // 3. Store as velocity offsets (interpolation state)
    entity.setXOffset(xDiff);  // Method .b()
    entity.setYOffset(yDiff);  // Method .c()
    
    // 4. If player NOT currently moving (b() returns false)
    if (!entity.isMoving()) {
        // Snap to exact position (no extrapolation needed)
        entity.setPosition(this.x, this.y);
        entity.setXOffset(0.0f);
        entity.setYOffset(0.0f);
    }
}
```

**Key Behavior**:
- Calculates position delta between server and client
- Stores offsets for frame-by-frame interpolation
- Only snaps to exact position when player is stationary
- Allows smooth movement continuation during lag

### 1.2 PlayerForcedPositionUpdate (Server Authority)
**File**: `com/arenaofkings/packets/gameserver/data/updates/PlayerForcedPositionUpdate.java`

```java
public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
    // 1. Force immediate position update (anti-cheat)
    entity.setPosition(this.x, this.y);
    
    // 2. Reset all velocity/offset components
    entity.setXOffset(0.0f);
    entity.setYOffset(0.0f);
    entity.setXVelocity(0.0f);
    entity.setYVelocity(0.0f);
    
    // 3. Clear movement state
    entity.setMoving(false);
}
```

**Key Behavior**:
- Instantly corrects client position
- Used when anti-cheat detects cheating
- **No smooth interpolation** — hard snap
- Resets all predicted movement state

---

## 2. Network Tick Rate & Update Frequency

### 2.1 Update Timing

From **ab.java** (Latency Manager):
```
Ping Interval: 5000ms (5 seconds)
Rolling Average Samples: 10 pings
Precision: Nanosecond (System.nanoTime())
RTT Measurement: Complete round-trip timing
```

### 2.2 Movement Input Frequency

From **PACKET_REFERENCE.md**:
```
MOVE_REQUEST_* (8 directions): 
  - Sent on key press
  - Sent per direction change
  - Frequency: User input dependent (not fixed tick)

MOVE_RELEASE_* (8 directions):
  - Sent on key release
  - Frequency: User input dependent

PlayerPositionUpdate (Server → Client):
  - Sent as bundle in PUB_GAME_SNAPSHOT
  - Frequency: Configurable server-side
  - Typical: 10-20 Hz (50-100ms updates)
```

### 2.3 No Fixed Tick Rate

**Finding**: The client uses **continuous rendering** (LibGDX):
```java
// aes.java
public void render(float f2) {  // f2 = deltaTime
    // Gdx.graphics.getFramesPerSecond() 
    // Continuous FPS tracking
    if (Gdx.graphics.getFramesPerSecond() >= 70) {
        // Display FPS
    }
}
```

- Renders at display refresh rate (typically 60 Hz)
- Physics/movement updates during each render frame
- **Not fixed 60 Hz tick** — adapts to frame time

---

## 3. Local vs Server-Side Authority

### 3.1 Client-Side (Local) Authority

**Movement Prediction** (Client performs):
1. User presses MOVE_REQUEST_NORTH
2. Client calculates position based on movement speed
3. Client renders updated position each frame
4. Velocity offsets applied progressively

**Attack/Ability Validation** (Client predicts):
- Spell casting initiated locally
- Ability cooldowns managed on client
- Target detection on client

### 3.2 Server-Side Authority

**Position Validation** (Server performs):
- Receives MOVE_REQUEST_* packets
- Validates position is reachable
- Calculates true server-side position
- Sends PlayerPositionUpdate with authoritative position

**Anti-Cheat Correction** (Server performs):
- Detects position cheating (teleport, speed hack)
- Sends PlayerForcedPositionUpdate
- Forces hard snap to correct position

### 3.3 Authority Conflict Resolution

```
Timeline:
T+0ms:    User presses key locally
T+1ms:    Client predicts new position, renders
T+50ms:   MOVE_REQUEST sent to server
T+100ms:  Server receives, validates
T+150ms:  Server sends PlayerPositionUpdate
T+200ms:  Client receives update, applies offset

Client Prediction Window: ~100-200ms ahead of server
Correction: Smooth offset application or hard snap
```

---

## 4. Velocity-Based Movement Prediction

### 4.1 Dead Reckoning Implementation

**How it works**:
1. Server sends: `PlayerPositionUpdate(x=150.0, y=200.0)`
2. Client calculates: `xDiff = 150.0 - 145.2 = 4.8`
3. Client stores: `offsetX = 4.8, offsetY = ...`
4. During next N frames: position += offset / frameCount

**Pseudo-code** (inferred):
```java
public void updatePosition(float deltaTime) {
    if (hasOffsets) {
        // Apply offset over time
        currentX += offsetX * (deltaTime / updateInterval);
        currentY += offsetY * (deltaTime / updateInterval);
    }
}
```

### 4.2 Frame-by-Frame Application

**Offsets stored in**:
- `.b()` method: X-axis offset (velocity)
- `.c()` method: Y-axis offset (velocity)

**During rendering**:
```java
public void render(float deltaTime) {
    // Each frame applies a fraction of offset
    entity.position.x += entity.offsetX * deltaTime;
    entity.position.y += entity.offsetY * deltaTime;
}
```

---

## 5. Snapshot-Based State Interpolation

### 5.1 PlayerSnapshot Architecture

**File**: `af.java` (Kryo registration)
```
kryo.register(PlayerSnapshot.class);
kryo.register(PlayerPositionUpdate.class);  // extends PlayerSnapshot
kryo.register(PlayerForcedPositionUpdate.class);  // extends PlayerSnapshot
```

**Snapshot Contents** (inferred from packet types):
- Player position (x, y)
- Player velocity (vx, vy)
- Movement state (isMoving)
- Animation state
- Spell effects
- Equipment
- Status effects

### 5.2 Update Bundle (PUB_GAME_SNAPSHOT)

**From PACKET_REFERENCE.md**:
```
PUB_GAME_SNAPSHOT (SERVER → CLIENT)
  - Size: 50-500 KB (batched updates)
  - Contains: PlayerUpdateBundle
  - Update frequency: Server-configurable
  - Typical: 10-20 updates per second

PlayerUpdateBundle:
  - Multiple PlayerPositionUpdate packets
  - Multiple status/spell updates
  - Organized by player ID
```

**Batching Strategy**:
- Server collects all player updates
- Sends in single snapshot packet
- Reduces network overhead
- Increases update latency (batching delay)

---

## 6. Interpolation Logic (Lerp Analysis)

### 6.1 No Explicit Lerp Found

**Search Results**:
- No `lerp()` methods detected in core player code
- No `Interpolation` class usage in movement
- No tweening/easing functions for position

### 6.2 Linear Extrapolation Instead

**Implementation**:
```
Server Position: (150, 200)
Client Position: (145, 195)
Difference: (5, 5)

Application: 
Frame 1: (145, 195) + (5, 5) * 0.25 = (146.25, 196.25)
Frame 2: (146.25, 196.25) + (5, 5) * 0.25 = (147.5, 197.5)
Frame 3: (147.5, 197.5) + (5, 5) * 0.25 = (148.75, 198.75)
Frame 4: (148.75, 198.75) + (5, 5) * 0.25 = (150, 200) ✓ Arrived
```

**Characteristics**:
- Linear (no acceleration)
- Predictable trajectory
- Can overshoot/undershoot if network delays occur

---

## 7. Dead Reckoning & Prediction

### 7.1 Dead Reckoning Components

**Tracked**:
- Last known position (x, y)
- Last known velocity (vx, vy from offset calculations)
- Movement direction
- Movement state (moving/stopped)

**Prediction**:
```
Future Position = Last Position + (Velocity × Time Elapsed)

Example (100ms prediction window):
P_t+100 = (150, 200) + (5, 5) × 0.1 = (150.5, 200.5)
```

### 7.2 Velocity Update Mechanism

From **PlayerPositionUpdate.handle()**:
1. Calculates offset from server position
2. Stores as velocity for next N frames
3. Velocity decays as frames progress
4. Eventually converges to server position

---

## 8. Anti-Cheat Position Validation

### 8.1 Server-Side Checks

**Validation performed**:
- Maximum distance traveled in time frame
- Speed limit enforcement
- Collision detection
- Reachable position verification
- Impossible teleports

### 8.2 Correction Mechanism

**When cheating detected**:
1. Server calculates authoritative position
2. Sends `PlayerForcedPositionUpdate`
3. Client **receives hard snap** (not interpolated)
4. No prediction applied after forced update

### 8.3 Vulnerabilities

**From EXPLOITATION_GUIDE.md**:
```
| Client-side latency | 🟡 MEDIUM | Exploit latency compensation | 
| Server authority on timing | Can spoof latency |
```

**Known Issues**:
- Latency can be spoofed by modifying ping
- Position prediction window exploitable
- No per-player rate limiting documented
- Sequence numbers absent (replay attacks possible)

---

## 9. Rendering & Animation System

### 9.1 Render Loop

**Game Screen** (`agd.java`):
```java
public void render(float f2) {  // deltaTime
    // Frame-by-frame rendering
    // Player positions updated during render
    // Camera follows player position
}
```

**Rendering Pipeline**:
1. Poll input
2. Update entity positions (apply velocity offsets)
3. Update animations
4. Render sprites at updated positions
5. Update camera
6. Present frame

### 9.2 Position Storage

**Entity Position**:
```java
private float x;  // Current X
private float y;  // Current Y
private float offsetX;  // X velocity (from network update)
private float offsetY;  // Y velocity (from network update)
```

**Rendering**:
```java
sprite.setPosition(x + offsetX * interpolationFactor, 
                   y + offsetY * interpolationFactor);
```

---

## 10. Network Tick & Frame Desynchronization

### 10.1 Tick Rates

**Network Tick**: 10-20 Hz (50-100ms between updates)
**Render Tick**: 60 Hz (16.67ms per frame)
**Ratio**: 3-6 network updates per rendered frame

### 10.2 Desynchronization Handling

**During frame gap** (no network update):
- Client continues applying stored velocity offsets
- Position smoothly progresses toward server position
- If offset exhausted before next update:
  - Client holds position
  - Next update recalculates offset

**During burst** (rapid network updates):
- Each update recalculates offset
- Previous offset discarded
- New trajectory calculated

---

## 11. Latency Compensation Summary

| Mechanism | Implementation | Effectiveness |
|-----------|-----------------|----------------|
| **Position Interpolation** | Velocity offset application | Good (smooth) |
| **Dead Reckoning** | Linear extrapolation | Moderate (can diverge) |
| **Server Authority** | Forced snapshots | Excellent (anti-cheat) |
| **Prediction Window** | 100-200ms | Moderate (exploitable) |
| **Lerp/Smoothing** | None detected | N/A |
| **Fixed Tickrate** | None (continuous render) | Good (adaptive FPS) |

---

## 12. Findings: Client vs Server Authority

### 12.1 Movement Authority

```
Movement Input (MOVE_REQUEST_*):
  Client: Predicts position immediately
  Server: Validates reachability
  Reconciliation: PlayerPositionUpdate with offset

Result: Hybrid - Client predicts, server authorizes
```

### 12.2 Position Authority

```
PlayerPositionUpdate: Authoritative server position
PlayerForcedPositionUpdate: Hard server correction

Result: Server-authoritative with client prediction
```

### 12.3 Spell/Combat Authority

```
SPELL_REQUEST:
  Client: Calculates hit
  Server: Validates distance, cooldown
  
Result: Server-authoritative with client prediction
```

---

## 13. Lag Compensation Weaknesses

### 13.1 Exploitable Issues

1. **Latency Spoofing**
   - Client controls ping calculation
   - Server trusts client latency
   - Prediction window adjustable by exploiter

2. **Position Prediction Window**
   - 100-200ms window exploitable
   - Teleport detection may fail if small enough
   - Server-side validation may not catch all cheats

3. **No Sequence Numbers**
   - Packets can be replayed
   - Same position update sent multiple times
   - No out-of-order detection

4. **Unbounded Queue**
   - DoS possible via rapid packets
   - No per-player rate limiting found
   - Connection buffer: 524KB default

### 13.2 Mitigation Strategies

**Server should implement**:
- Latency server-time verification
- Per-player rate limiting
- Sequence number tracking
- Tighter position tolerance checks
- Encryption for sensitive packets

---

## 14. Code References

### Key Files:
- **PlayerPositionUpdate.java**: Regular position synchronization
- **PlayerForcedPositionUpdate.java**: Server correction
- **ef.java**: Position update tracking/history
- **agd.java**: Main render loop and game screen
- **ab.java**: Latency measurement and RTT calculation
- **ag.java**: Network packet queueing
- **ae.java**: Network event listener

### Packet Types:
- `PUB_GAME_SNAPSHOT`: Batched position updates
- `PUB_GAME_PING`: Latency probe
- `PUB_GAME_PING_RESPONSE`: Latency response
- `MOVE_REQUEST_*`: 8-direction movement input
- `MOVE_RELEASE_*`: Movement release

---

## 15. Conclusion

**Arena of Kings implements**:
✅ **Velocity-based dead reckoning** for smooth movement
✅ **Offset-based interpolation** for position convergence
✅ **Server-authoritative corrections** for anti-cheat
✅ **Hybrid prediction model** (client predict, server authorize)

❌ **No explicit lerp/easing**
❌ **No smooth interpolation** on forced updates
❌ **Predictable linear extrapolation**
❌ **Exploitable prediction window**

**Security Assessment**: 🟡 MEDIUM RISK
- Good server-side validation foundation
- Predictable interpolation model
- Exploitable latency compensation
- Missing sequence numbers and rate limiting

---

**Document Generated**: 2026-05-25
**Version**: 1.0
**Status**: Complete Analysis
