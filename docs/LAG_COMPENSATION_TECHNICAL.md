# Technical Implementation Reference: Lag Compensation
## Decompiled Code Analysis & Interpolation Mechanics

---

## 1. PlayerPositionUpdate Implementation

### Source Code Analysis

**Location**: `com/arenaofkings/packets/gameserver/data/updates/conveyed/PlayerPositionUpdate.java`

```java
public class PlayerPositionUpdate extends PlayerSnapshot {
    private float x;
    private float y;

    public PlayerPositionUpdate() {
    }

    public PlayerPositionUpdate(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        // 1. LOG PRE-UPDATE STATE
        Engine.a("Player username: " + string + 
                  " PRE x: " + ay.a().a(string).a().getActive_character_entity().a().getX() + 
                  " y: " + ay.a().a(string).a().getActive_character_entity().a().getY() + 
                  " isMoving: " + ay.a().a(string).a().getActive_character_entity().a().b());
        
        // 2. GET PLAYER ENTITY
        br br2 = ay.a().a(string);
        
        if (br2 != null) {
            // 3. TRIGGER CAMERA UPDATE IF NEEDED
            if (t.a(agd.class, engine)) {
                ((agd)engine.a()).b();  // Refresh camera
            }
            
            // 4. CALCULATE POSITION DELTA
            float f2 = this.x - br2.a().getActive_character_entity().a().getX();  // xDiff
            float f3 = this.y - br2.a().getActive_character_entity().a().getY();  // yDiff
            
            // 5. STORE OFFSETS (VELOCITY COMPONENTS)
            br2.a().getActive_character_entity().a().b(f2);  // setXOffset(xDiff)
            br2.a().getActive_character_entity().a().c(f3);  // setYOffset(yDiff)
            
            // 6. CONDITIONAL POSITION UPDATE
            if (!br2.a().getActive_character_entity().a().b()) {
                // Not moving: SNAP to exact position
                Engine.a("xDiff = " + f2 + " yDiff = " + f3);
                br2.a().getActive_character_entity().a().a(this.x, this.y);  // setPosition()
                br2.a().getActive_character_entity().a().b(0.0f);  // clearXOffset()
                br2.a().getActive_character_entity().a().c(0.0f);  // clearYOffset()
            }
            // Else: Leave offsets in place for frame-by-frame interpolation
            
            // 7. LOG POST-UPDATE STATE
            Engine.a("Player username: " + string + 
                      " POST x: " + br2.a().getActive_character_entity().a().getX() + 
                      " y: " + br2.a().getActive_character_entity().a().getY() + 
                      " isMoving: " + br2.a().getActive_character_entity().a().b() + 
                      " offset: " + br2.a().getActive_character_entity().a().a() + "," + 
                      br2.a().getActive_character_entity().a().b());
        }
    }
}
```

### Decompilation Notes

**Method Naming Pattern**:
- `.a()` = Primary accessor (get) or position setter
- `.b()` = Secondary method (movement state check or offset setter)
- `.c()` = Tertiary method (offset setter)
- `.a(string)` = Get player by username

**Offset Application Pattern**:
1. Calculate delta: `delta = server_pos - client_pos`
2. Store delta: `.b(delta)` and `.c(delta)`
3. Check moving state: `.b()` returns boolean
4. If NOT moving: snap position and clear offsets
5. If moving: keep offsets for interpolation

---

## 2. PlayerForcedPositionUpdate Implementation

**Location**: `com/arenaofkings/packets/gameserver/data/updates/PlayerForcedPositionUpdate.java`

```java
public class PlayerForcedPositionUpdate extends PlayerSnapshot {
    private float x;
    private float y;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("forced update received ");
        
        // 1. CHECK IF TARGET IS SELF OR PLAYER
        if (string == null || ay.a().a(string) == ay.a()) {
            // Self: Local player
            ay.a().a().getActive_character_entity().a().a().a();  // clearAnimation()
            ay.a().a().getActive_character_entity().a().b(false);  // setMoving(false)
            ay.a().a().getActive_character_entity().a().a(this.x, this.y);  // setPosition()
            ay.a().a().getActive_character_entity().a().b(0.0f);  // clearXOffset()
            ay.a().a().getActive_character_entity().a().c(0.0f);  // clearYOffset()
            
            Engine.a("Forced position update for ME  x: " + this.x + " y: " + this.y);
        } else {
            // Other player
            br br2 = ay.a().a(string);
            
            if (br2 != null) {
                br2.a().getActive_character_entity().a().a().a();  // clearAnimation()
                br2.a().getActive_character_entity().a().a(this.x, this.y);  // setPosition()
                br2.a().getActive_character_entity().a().b(0.0f);  // clearXOffset()
                br2.a().getActive_character_entity().a().c(0.0f);  // clearYOffset()
                
                Engine.a("Forced position update for username: " + string + " x: " + this.x + " y: " + this.y);
            }
        }
        
        Engine.a("forced update out");
    }
}
```

### Forced Update Characteristics

**Immediate Actions**:
1. Stop animation playback
2. Set moving state to false
3. **Directly set position** (no interpolation)
4. **Clear all offsets** (no velocity applied)
5. Reset Y velocity if applicable

**Purpose**: Anti-cheat enforcement
- Used when position validation fails
- Hard snap required (no smooth transition)
- Prevents exploitation of prediction window

---

## 3. Entity Position Storage & Access

### Position Tracker (ef.java)

```java
public class ef {
    private int a;                                      // playerId?
    private int b = 0;                                  // updateCount?
    private List<PlayerPositionUpdate> a;               // history list (1000 capacity)
    private Map<Integer, PlayerPositionUpdate> a = 
        (int)new HashMap();                             // player_id -> latest update
    
    public ef() {
        for (int i2 = 0; i2 < 1000; ++i2) {
            this.a.add(null);
        }
    }
}
```

**Purpose**:
- Maintains circular buffer of position updates (1000 entries)
- Maps player IDs to their latest PlayerPositionUpdate
- Allows position history queries
- Supports lag compensation calculations

---

## 4. Rendering & Position Application

### Game Screen Render Loop (agd.java - line 539+)

```java
@Override
public void render(float f2) {  // f2 = deltaTime in seconds
    // Called each frame
    // deltaTime varies: typically 0.016s @ 60 FPS
    
    // During render:
    // 1. Poll input
    // 2. Update physics
    // 3. Update entity positions (apply offsets)
    // 4. Update animations
    // 5. Render sprites
    // 6. Update camera
}
```

### Continuous Rendering

**From aes.java (Display settings)**:
```java
public void render(float f2) {
    // FPS monitoring
    if (Gdx.graphics.getFramesPerSecond() >= 70) {
        // Display "FPS: [GREEN]70[]"
    } else if (Gdx.graphics.getFramesPerSecond() >= 50) {
        // Display "FPS: [LIME]50[]"
    } else if (Gdx.graphics.getFramesPerSecond() >= 40) {
        // Display "FPS: [ORANGE]40[]"
    } else {
        // Display "FPS: [RED]30 UNPLAYABLE![]"
    }
}
```

**Characteristics**:
- Continuous rendering (not fixed tick)
- FPS varies based on load
- Typical: 60 Hz (but can be lower)
- Adaptive frame time handling

---

## 5. Network Update Batching

### PUB_GAME_SNAPSHOT Packet

**Structure** (inferred from code):
```
PUB_GAME_SNAPSHOT
├─ PlayerUpdateBundle
│  ├─ PlayerPositionUpdate (Player 1)
│  ├─ PlayerPositionUpdate (Player 2)
│  ├─ PlayerSpellUpdate (Player 1)
│  ├─ PlayerStatusUpdate (Player 2)
│  └─ ... (more updates)
├─ WorldStateUpdate
└─ ...
```

**From PACKET_REFERENCE.md**:
- Size: 50-500 KB
- Frequency: Configurable (typically 10-20 Hz)
- Contains: Batched player updates
- Update interval: 50-100 ms typical

### Batching Impact on Latency

```
Timeline with 50ms server tick:
T+0ms:    Server calculates all player positions
T+5ms:    Server batches updates
T+50ms:   Server sends PUB_GAME_SNAPSHOT
T+100ms:  Client receives (typical network latency)
T+101ms:  Client processes and applies offsets
T+101ms to +150ms: Client interpolates over 50ms window
```

**Result**: Effective latency visible in game = Network RTT + Batching Delay

---

## 6. Latency Measurement (ab.java)

### Ping Mechanism

```java
public class ab {  // LatencyManager
    
    // Ping every 5 seconds
    long l2 = System.currentTimeMillis();
    
    if (condition) {
        l2 = System.currentTimeMillis() - l2;  // Measure elapsed
        // Send PING packet
    }
    
    // On PING_RESPONSE:
    long elapsed = System.currentTimeMillis() - pingTime;
    
    // Store in rolling average (10 samples)
    // Calculate RTT
}
```

### RTT Calculation

**Measured in nanoseconds**:
```
RTT = System.nanoTime() - pingStartTime (nanoseconds)
RTT_ms = RTT / 1,000,000
```

**Rolling Average** (10 samples):
```
avgRTT = (RTT[n] + RTT[n-1] + ... + RTT[n-9]) / 10
```

**Precision**: Nanosecond-level (vulnerable to spoofing)

---

## 7. Movement Input Processing

### MOVE_REQUEST Packets

**8-Direction Movement System**:
```java
MOVE_REQUEST_NORTH         (direction: 0°)
MOVE_REQUEST_NORTHEAST     (direction: 45°)
MOVE_REQUEST_EAST          (direction: 90°)
MOVE_REQUEST_SOUTHEAST     (direction: 135°)
MOVE_REQUEST_SOUTH         (direction: 180°)
MOVE_REQUEST_SOUTHWEST     (direction: 225°)
MOVE_REQUEST_WEST          (direction: 270°)
MOVE_REQUEST_NORTHWEST     (direction: 315°)
```

**MOVE_RELEASE Packets**:
```
Same 8 directions for release
Sent when key is released
```

**Flow**:
```
Key Press Event
  ↓
Create MOVE_REQUEST_NORTH
  ↓
Send via TCP
  ↓
Server receives
  ↓
Server validates reachability
  ↓
Server sends PlayerPositionUpdate
  ↓
Client applies offset
  ↓
Position interpolates over frames
```

---

## 8. Offset Application During Rendering

### Pseudo-Implementation (Inferred)

```java
class Entity {
    private float x, y;              // Current position
    private float offsetX, offsetY;  // Velocity from network update
    private float movementSpeed;     // Units per second
    
    public void updatePosition(float deltaTime) {
        // Apply offsets to position
        if (offsetX != 0.0f || offsetY != 0.0f) {
            // Linear interpolation over network update interval
            float interpolationFactor = (time - lastUpdateTime) / updateInterval;
            
            if (interpolationFactor > 1.0f) {
                // Converged: set final position
                x += offsetX;
                y += offsetY;
                offsetX = 0.0f;
                offsetY = 0.0f;
            } else {
                // Interpolating: partial application
                x += offsetX * interpolationFactor;
                y += offsetY * interpolationFactor;
            }
        }
    }
    
    public void render(float deltaTime) {
        updatePosition(deltaTime);
        // Render sprite at (x, y)
    }
}
```

---

## 9. Dead Reckoning Mechanics

### Position Prediction

**Without network update**, client continues:
```java
// Last known data from server
float lastServerX = 150.0f;
float lastServerY = 200.0f;
float offsetX = 5.0f;
float offsetY = 5.0f;

// Time since update (ms)
float timeSinceUpdate = 150.0f;

// Predicted position
float predictedX = lastServerX + (offsetX * timeSinceUpdate / updateInterval);
float predictedY = lastServerY + (offsetY * timeSinceUpdate / updateInterval);
```

**Example**:
```
Update Interval: 50ms
Time Elapsed: 150ms (3 network updates worth)
Offset: (5, 5) units

Frame 1 (0ms): (150, 200)
Frame 2 (50ms): (152.5, 202.5)  [after 1st offset application]
Frame 3 (100ms): (155, 205)     [after 2nd offset application]
Frame 4 (150ms): (157.5, 207.5) [after 3rd offset application]
...continues until next network update
```

---

## 10. Speed & Distance Validation

### Server-Side Anti-Cheat

**Validation checks** (inferred):
```
1. Calculate distance traveled:
   dist = sqrt((new_x - last_x)² + (new_y - last_y)²)

2. Check against max speed:
   max_allowed = speed_per_second * time_elapsed
   if dist > max_allowed:
       CHEAT DETECTED → Send PlayerForcedPositionUpdate

3. Check collision:
   if position_in_wall:
       CHEAT DETECTED → Send PlayerForcedPositionUpdate

4. Check against last valid position:
   if distance > reachable_bounds:
       CHEAT DETECTED → Send PlayerForcedPositionUpdate
```

---

## 11. No Lerp/Interpolation Library Usage

### Search Results

**Classes searched for but NOT found**:
- `Interpolation` (no easing functions)
- `Tweens` (no animation tweens)
- `Lerp` utility methods
- `Interpolator` interface
- `Motion` library

**Only simple linear math used**:
```java
// Position = Start + (Delta × Time / Interval)
// No acceleration/deceleration
// No smoothing curves
// No easing functions
```

---

## 12. Frame Desynchronization Pattern

### Network Update (50ms) vs Render Frame (16.67ms)

```
Network Tick: 0ms    50ms    100ms    150ms    200ms
Render Ticks: 0  16  33  50  66  83  100  116  133  150  166  183  200
              |   |   |   |   |   |    |    |    |    |    |    |    |
              •———•———•———•———•———•————•————•————•————•————•————•————•

At 50ms update:
  - Apply offset to position
  - Position increments over next 3 render frames
  - Next update at 100ms (3 more render frames)

Interpolation over 3 frames:
  Frame 1: position += offset * 1/3
  Frame 2: position += offset * 1/3
  Frame 3: position += offset * 1/3
  Frame 4 onwards: position stable (waiting for next update)
```

---

## 13. Key Code Locations

| Component | File | Method | Purpose |
|-----------|------|--------|---------|
| Position Update | PlayerPositionUpdate.java | handle() | Apply offset-based interpolation |
| Forced Update | PlayerForcedPositionUpdate.java | handle() | Server correction (snap) |
| Position History | ef.java | - | Track position updates |
| Render Loop | agd.java | render() | Apply offsets each frame |
| Latency Manager | ab.java | - | Measure RTT |
| Game Client | ag.java | - | Queue packets |
| Listener | ae.java | received() | Process network packets |

---

## 14. Vulnerability Points

### Exploitable Weaknesses

1. **Offset-based Prediction**
   - Predictable linear trajectory
   - Can be precalculated by cheater
   - No randomization

2. **Latency Window**
   - 100-200ms position prediction
   - Attacks within window undetected
   - Depends on network latency

3. **No Anti-Replay**
   - Packets can be resent
   - Position update replayed
   - No sequence numbers

4. **Client-Controlled Timing**
   - Client calculates RTT
   - Client timing can be altered
   - Server trusts client latency

---

## 15. Summary: Lag Compensation Architecture

**Mechanism**: Velocity-based offset interpolation
**Interpolation Type**: Linear (no easing)
**Authority Model**: Server-authoritative with client prediction
**Update Frequency**: 10-20 Hz (50-100ms)
**Render Frequency**: Adaptive (typically 60 Hz)
**Prediction Window**: 100-200ms
**Correction Method**: Forced position updates (hard snap)

**Strengths**:
✅ Server authoritative
✅ Smooth movement between updates
✅ Anti-cheat correction available
✅ Batched updates reduce overhead

**Weaknesses**:
❌ Predictable linear extrapolation
❌ Exploitable prediction window
❌ No packet sequence numbers
❌ Client timing control
❌ No rate limiting per player

---

**Document Version**: 1.0
**Generated**: 2026-05-25
**Status**: Complete Technical Reference
