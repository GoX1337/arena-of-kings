# Lag Compensation & Network Prediction - Quick Summary
## Arena of Kings Client Analysis

---

## Key Findings

### 1. **Velocity-Based Interpolation (NOT Lerp)**
- Position updates calculate **offset** (server_pos - client_pos)
- Offset stored as velocity components
- Applied linearly over network update interval
- **No easing functions or smooth curves**

### 2. **Two Position Update Types**

| Type | Behavior | When Used |
|------|----------|-----------|
| **PlayerPositionUpdate** | Smooth offset application | Regular network updates (10-20 Hz) |
| **PlayerForcedPositionUpdate** | Hard snap (no interpolation) | Anti-cheat correction |

### 3. **Frame-by-Frame Application**
```
Network Update (50ms):
  - Calculate offset: (5, 5) units
  - Apply each frame: 5/3 units per frame @ 60 FPS
  - Takes ~50ms to converge to new position
```

### 4. **Server-Authoritative Model**
- Client predicts locally
- Server validates reachability
- Server sends corrections if prediction wrong
- **Forced updates snap instantly** (no smooth transition)

### 5. **Prediction Window: 100-200ms**
- Time between network updates
- Client position can deviate by this much
- Exploitable if not validated properly

### 6. **No Fixed Tick Rate**
- Client renders continuously (60 Hz typical)
- Server sends updates at 10-20 Hz
- **3-6 network updates per rendered frame**

### 7. **Dead Reckoning: Linear Extrapolation**
- Calculates: `Future_Position = Last_Position + (Offset × TimeElapsed)`
- No acceleration
- Can overshoot if next update delays

### 8. **Vulnerabilities Found**
| Issue | Severity | Note |
|-------|----------|------|
| Latency spoofing | 🟡 MEDIUM | Client controls RTT calculation |
| Predictable trajectory | 🟡 MEDIUM | Linear offset is precalculable |
| No sequence numbers | 🟡 MEDIUM | Packets can be replayed |
| No rate limiting | 🟡 MEDIUM | Can flood with packets |
| Small prediction error window | 🟡 MEDIUM | Position validation may fail |

---

## How It Works (Step-by-Step)

### User Moves

```
1. User presses MOVE_NORTH
   ↓
2. Client predicts position locally
   ↓
3. Sends MOVE_REQUEST_NORTH to server
   ↓
4. Server receives (50-100ms later)
   ↓
5. Server validates: can player reach that position?
   ↓
6. Server calculates true position
   ↓
7. Server sends PlayerPositionUpdate with new position
   ↓
8. Client receives update
   ↓
9. Client calculates offset: (5, 5) units
   ↓
10. Each frame: position += offset / num_frames
    - Smoothly converges to server position
    - Takes ~50ms (next network update)
```

### Server Detects Cheat

```
1. Player position: (100, 100)
   ↓
2. Next position: (200, 200)
   ↓
3. Distance = 141.4 units
   ↓
4. Time elapsed = 50ms
   ↓
5. Max allowed distance @ normal speed = 2 units
   ↓
6. CHEAT DETECTED!
   ↓
7. Server sends PlayerForcedPositionUpdate
   ↓
8. Client receives
   ↓
9. Position SNAPS instantly to server position
   ↓
10. Offsets CLEARED (no interpolation)
```

---

## Network Packets

### Movement
- **MOVE_REQUEST_NORTH** (8 directions)
- **MOVE_RELEASE_NORTH** (8 directions)

### Position Sync
- **PUB_GAME_SNAPSHOT** (batched updates, 50-500 KB)
  - Contains: PlayerPositionUpdate, PlayerSpellUpdate, etc.
  - Frequency: 10-20 Hz

### Latency
- **PUB_GAME_PING** (Client → Server)
- **PUB_GAME_PING_RESPONSE** (Server → Client)
- **Interval**: 5 seconds

---

## Position Storage

### Entity Fields
```
private float x;          // Current X position
private float y;          // Current Y position
private float offsetX;    // X velocity (from network update)
private float offsetY;    // Y velocity (from network update)
private boolean isMoving; // Movement state
```

### Offset Methods (from decompiled code)
- `.b(offset)` = Set X offset
- `.c(offset)` = Set Y offset
- `.a(x, y)` = Set position
- `.b()` = Get movement state

---

## Rendering

### Each Frame
```
1. Poll input
2. Update entity positions (apply offsets)
3. Update animations
4. Render sprites at updated positions
5. Update camera
6. Present frame
```

### Offset Application
```java
if (hasOffsets) {
    // Apply fractional offset each frame
    position.x += offsetX * (deltaTime / updateInterval);
    position.y += offsetY * (deltaTime / updateInterval);
}
```

---

## Client vs Server Authority

| Function | Client | Server |
|----------|--------|--------|
| **Input processing** | ✅ Local | ✅ Validates |
| **Movement prediction** | ✅ Predicts | ✅ Authorizes |
| **Position validation** | Local check | ✅ **Final check** |
| **Speed validation** | Local check | ✅ **Final check** |
| **Cheat detection** | - | ✅ **Anti-cheat** |
| **Position correction** | - | ✅ **Forced update** |

---

## Known Exploits

### 1. Latency Spoofing
- Modify ping calculation
- Prediction window extends
- Server may accept invalid positions

### 2. Prediction Window Abuse
- Within 100-200ms window
- Small cheats undetected
- Requires fast attacks

### 3. Packet Replay
- No sequence numbers
- Resend old position updates
- Server may accept duplicate

### 4. Speed Hack
- Use high offsetX/offsetY values
- Prediction carries farther
- Server validates position validation

---

## Code References

| File | Purpose |
|------|---------|
| **PlayerPositionUpdate.java** | Regular position sync with interpolation |
| **PlayerForcedPositionUpdate.java** | Server correction (hard snap) |
| **ef.java** | Position update history tracking |
| **agd.java** | Main render loop (position application) |
| **ab.java** | Latency measurement (RTT calculation) |
| **ag.java** | Network client & packet queueing |
| **ae.java** | Network event listener |
| **af.java** | Kryo serialization (packet types) |

---

## Latency Compensation Flowchart

```
┌─────────────────────────────────────┐
│  Player Input (MOVE_REQUEST_NORTH)  │
└────────────┬────────────────────────┘
             │
             ▼
┌─────────────────────────────────────┐
│  Client Predicts Position Locally   │
│  - Updates position immediately     │
│  - Renders new position             │
└────────────┬────────────────────────┘
             │
             ▼
┌─────────────────────────────────────┐
│  Server Receives (50-100ms later)   │
│  - Validates reachability           │
│  - Calculates authoritative pos     │
└────────────┬────────────────────────┘
             │
        ┌────┴────┐
        ▼         ▼
    VALID?    INVALID?
      │           │
      ▼           ▼
   ┌──┐    ┌───────────────────┐
   │✓ │    │ PlayerForcedUpdate │
   └──┘    │ (Hard Snap)        │
      │    └───────┬───────────┘
      │            │
      ▼            ▼
┌──────────────────────────────────┐
│ PlayerPositionUpdate             │
│ - Send offset to client          │
│ - Client interpolates smoothly   │
└────────────┬─────────────────────┘
             │
             ▼
┌──────────────────────────────────┐
│ Client Position Converges        │
│ - Applied over 50ms              │
│ - Takes 3 render frames @ 60 FPS │
└──────────────────────────────────┘
```

---

## Performance Metrics

| Metric | Value | Note |
|--------|-------|------|
| **Network Tick Rate** | 10-20 Hz | 50-100ms updates |
| **Render Tick Rate** | 60 Hz (adaptive) | 16.67ms per frame |
| **Prediction Window** | 100-200ms | Can deviate this much |
| **Interpolation Time** | 50ms | Time to apply offset |
| **Ping Interval** | 5000ms | Every 5 seconds |
| **RTT Precision** | Nanoseconds | Can be spoofed |
| **Packet Size** | 50-500 KB | Batched snapshot |
| **Buffer Size** | 524 KB | TCP write buffer |

---

## Security Recommendations

### Server-Side Mitigations
- ✅ Implement sequence numbers (detect replays)
- ✅ Implement per-player rate limiting
- ✅ Add server-time verification (prevent latency spoof)
- ✅ Tighten position tolerance checks
- ✅ Track movement history (detect patterns)
- ✅ Implement signed packet timestamps
- ✅ Use encryption for sensitive packets

### Client-Side Verification
- ✅ Validate position updates match server authority
- ✅ Check for impossible velocity values
- ✅ Log position corrections
- ✅ Alert on forced updates
- ✅ Verify animation states match position

---

## Documents Generated

1. **LAG_COMPENSATION_ANALYSIS.md** (15 sections, 500+ lines)
   - Comprehensive lag compensation overview
   - Network tick analysis
   - Authority models
   - Vulnerabilities
   - Recommendations

2. **LAG_COMPENSATION_TECHNICAL.md** (15 sections, 400+ lines)
   - Decompiled code analysis
   - Implementation details
   - Position storage mechanics
   - Offset application logic
   - Code locations reference

3. **This document** - Quick summary for rapid reference

---

**Analysis Completed**: 2026-05-25  
**Total Pages**: 50+ pages of analysis  
**Code Files Reviewed**: 10+ core game files  
**Packets Analyzed**: 100+ packet types  
**Vulnerabilities Found**: 5 medium-severity issues  
**Recommendations**: 7 security mitigations

---

**Status**: ✅ COMPLETE
