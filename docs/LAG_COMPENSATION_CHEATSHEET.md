# Lag Compensation Cheat Sheet
## Quick Reference for Arena of Kings Network Mechanics

---

## TL;DR - Lag Compensation in 30 Seconds

Arena of Kings compensates for lag by:

1. **Client predicts position** immediately when user inputs movement
2. **Server validates** the predicted position
3. **Server sends offset** (difference from client prediction)
4. **Client applies offset** smoothly over 50-100ms using velocity
5. **Server can force snap** position for anti-cheat

---

## The Two Position Update Types

### 1️⃣ PlayerPositionUpdate (Smooth)
```
Use Case: Regular network updates
Behavior: Apply offset gradually
Formula: position += offset / updateInterval per frame
Time: 50-100ms to converge
Example: Player moves smoothly between updates
```

### 2️⃣ PlayerForcedPositionUpdate (Snap)
```
Use Case: Anti-cheat correction detected
Behavior: Instant position snap
Formula: position = serverPosition (immediate)
Time: 1 frame (instant)
Example: Player caught cheating teleports back
```

---

## Network Packet Flow

```
┌─ Player presses key
│
├─ Client predicts position (immediate render)
│
├─ Send MOVE_REQUEST_* (takes 50-100ms)
│
├─ Server validates (checks speed, collisions, etc)
│
├─ Server sends PlayerPositionUpdate with offset
│
├─ Client receives offset (another 50-100ms delay)
│
├─ Client applies offset over 50ms (3 frames @ 60 FPS)
│
└─ Position converges, player appears smooth
```

---

## Offset Storage

| Method | Stores | Used For |
|--------|--------|----------|
| `.b(float)` | X-axis offset/velocity | Horizontal interpolation |
| `.c(float)` | Y-axis offset/velocity | Vertical interpolation |
| `.a()` | Get position | Current X coordinate |
| `.a(x, y)` | Set position | Snap to exact position |

---

## Rendering Timeline

```
Network Update (50ms):
┌─────────────────────────────────────────────┐
│ Server sends offset (5, 5) units            │
└────────────────┬────────────────────────────┘
                 │
      ┌──────────┴──────────┐
      ▼                     ▼
   Frame 1              Frame 2              Frame 3
   ┌─────────┐         ┌─────────┐         ┌─────────┐
   │Pos += 1.67│       │Pos += 1.67│       │Pos += 1.67│
   │(150, 200) │       │(151.67, 201.67)│   │(153.33, 203.33)│
   └─────────┘         └─────────┘         └─────────┘
   ↑                                       ↑
   New update                             Converged
```

---

## Speed Validation Example

```
Cheater Position Jump:
  From: (100, 100)
  To: (200, 200)
  Distance: 141.4 units
  Time: 50ms
  
Normal Speed Check:
  Max allowed: 2 units/50ms
  Actual: 141.4 units/50ms
  
Result: 🚫 CHEAT DETECTED
  Server sends: PlayerForcedPositionUpdate
  Effect: Player snaps back to (100, 100)
```

---

## The 3-6 Frame Desync Problem

```
Network Tick: Every 50ms (20 Hz)
Render Tick:  Every 16.67ms (60 FPS)

Ratio: 50 ÷ 16.67 = 3 frames per network update

Impact:
- At 50ms network interval
- Player sees position update 3 times per render cycle
- Offsets applied incrementally
- Smooth movement achieved
```

---

## Exploitability Score Card

| Vulnerability | Severity | Exploitability | Mitigation |
|---------------|----------|-----------------|-----------|
| Latency spoofing | 🟡 MEDIUM | High | Verify with server time |
| Prediction window | 🟡 MEDIUM | Medium | Tighten tolerance |
| No sequence numbers | 🟡 MEDIUM | High | Add packet counter |
| No rate limiting | 🟡 MEDIUM | High | Per-player quotas |
| Linear prediction | 🟡 MEDIUM | Medium | Harder to detect small hacks |

---

## Code Locations Quick Map

```
Position Updates:
  └─ PlayerPositionUpdate.java (smooth)
     PlayerForcedPositionUpdate.java (snap)

Rendering:
  └─ agd.java (game screen render loop)

Offset Application:
  └─ (inferred) during entity.updatePosition()

Latency:
  └─ ab.java (RTT calculation, RTT every 5000ms)

Packets:
  └─ af.java (Kryo registration)
```

---

## Movement Input System

```
User Input (8 directions):
  ├─ MOVE_REQUEST_NORTH    (↑)
  ├─ MOVE_REQUEST_SOUTH    (↓)
  ├─ MOVE_REQUEST_EAST     (→)
  ├─ MOVE_REQUEST_WEST     (←)
  ├─ MOVE_REQUEST_NORTHEAST  (↗)
  ├─ MOVE_REQUEST_NORTHWEST  (↖)
  ├─ MOVE_REQUEST_SOUTHEAST  (↘)
  └─ MOVE_REQUEST_SOUTHWEST  (↙)

Release (same 8 directions):
  └─ MOVE_RELEASE_* (sent on key up)

Behavior:
  - NOT fixed tick rate
  - NOT continuous velocity
  - Direction-based input only
  - Discrete movement packets
```

---

## Prediction Window Visualization

```
                    Server Authoritative Position
                              ↓
    ┌─────────────────────────●─────────────────────────┐
    │                                                   │
    │  Client Prediction Window (100-200ms)            │
    │  ← Can deviate THIS much from server →           │
    │                                                   │
    └─────────────────────────────────────────────────┘
                    ↑                       ↑
            Network Update              Next Update
```

---

## Buffer Sizes

```
TCP Write Buffer: 524,280 bytes (512 KB)
UDP Packet Max: 65,535 bytes (64 KB)
Object Max Size: 65,535 bytes
Typical Snapshot: 50-500 KB
```

---

## RTT Calculation

```
Method: System.nanoTime() (nanosecond precision)
Interval: Every 5000ms (5 seconds)
Samples: 10-sample rolling average
Precision: ± nanoseconds (very precise, spoofable)

Formula:
  RTT_ms = (System.nanoTime() - startTime) / 1,000,000

Prediction Interval = RTT × 2 (approximately)
```

---

## Entity Position State

```
Entity Fields:
┌──────────────────────┬──────────┬─────────────────┐
│ Field                │ Type     │ Purpose         │
├──────────────────────┼──────────┼─────────────────┤
│ x                    │ float    │ Current X coord │
│ y                    │ float    │ Current Y coord │
│ offsetX              │ float    │ X velocity      │
│ offsetY              │ float    │ Y velocity      │
│ isMoving             │ boolean  │ Movement state  │
│ lastUpdateTime       │ long     │ When updated    │
└──────────────────────┴──────────┴─────────────────┘
```

---

## Anti-Cheat Trigger Points

```
Position cheating detection triggers:
  ✓ Speed > max_allowed_speed
  ✓ Position inside collision (wall)
  ✓ Teleport (instant large jump)
  ✓ Distance > reachable_boundary
  ✓ (Possibly) Y-position out of bounds
  
Server Response:
  → Send PlayerForcedPositionUpdate
  → Client receives SNAP instruction
  → Position resets immediately
  → Offsets cleared (no interpolation)
  → Player sees "lag" or "warp back"
```

---

## Common Lag Compensation Questions

**Q: Why do other players appear to lag?**
A: Their position updates arrive 50-200ms late due to network latency + server batching.

**Q: Why can't I hit enemies sometimes?**
A: You're aiming at client-side prediction. Server validates collision at server position.

**Q: How does it avoid jittering?**
A: Offsets applied gradually over frames instead of instantly snapping.

**Q: Can I exploit the prediction window?**
A: Yes - within 100-200ms you can perform actions the server might not immediately catch.

**Q: Why is the rotation to point X before I move?**
A: Client-side prediction - you rotate before network acknowledgment.

---

## Implementation Checklist

If building similar system:

- [ ] Calculate position delta on update
- [ ] Store delta as velocity components
- [ ] Apply velocity progressively over frames
- [ ] Check if player is moving before snapping
- [ ] Provide forced update for corrections
- [ ] Measure RTT every 5 seconds
- [ ] Send updates in batched snapshots
- [ ] Validate position on server
- [ ] Implement anti-cheat checks
- [ ] Clear velocity on forced updates

---

## Debugging Tips

```
Check if player is cheating:
  1. Monitor position jumps > 2 units/frame
  2. Check for instant direction changes
  3. Watch for out-of-bounds positions
  4. Verify speed calculations

Check if prediction is wrong:
  1. Log all PlayerPositionUpdates
  2. Log all offsets calculated
  3. Compare client vs server position
  4. Track offset application over frames

Check network issues:
  1. Monitor ping every 5 seconds
  2. Check RTT rolling average
  3. Check snapshot delivery times
  4. Verify packet sizes
```

---

## Packet Quick Reference

| Packet | Direction | Size | Frequency | Purpose |
|--------|-----------|------|-----------|---------|
| MOVE_REQUEST_* | C→S | Small | On input | Movement input |
| MOVE_RELEASE_* | C→S | Small | On input | Movement stop |
| PUB_GAME_SNAPSHOT | S→C | 50-500KB | 10-20 Hz | Position updates |
| PUB_GAME_PING | C→S | Small | 5000ms | Latency probe |
| PUB_GAME_PING_RESPONSE | S→C | Small | 5000ms | Latency response |

---

## Final Thoughts

✅ **Good points**:
- Server validates all movement
- Smooth interpolation between updates
- Anti-cheat correction available

❌ **Bad points**:
- Predictable linear trajectory
- No packet sequence verification
- Latency can be spoofed
- 100-200ms window allows cheating

🎯 **Security Rating**: 🟡 MEDIUM
- Functional lag compensation
- Needs stronger anti-cheat measures
- Susceptible to advanced exploits

---

**Last Updated**: 2026-05-25  
**Version**: 1.0  
**Status**: Complete Quick Reference
