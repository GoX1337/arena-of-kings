# Lag Compensation - Arena of Kings

## 📌 Vue d'Ensemble

Arena of Kings utilise une **velocity-offset interpolation** pour compenser la latence réseau et maintenir un gameplay fluide malgré les délais de ~100ms.

---

## 🎮 Le Problème

Sans compensation de lag:
```
T0:    Serveur: joueur à X=100
T50ms: Réseau
T100ms: Client affiche position → 100ms DE RETARD
       Joueur voit sa position "dans le passé"
       Gameplay saccadé, non-fluide
```

---

## ✅ La Solution: 4 Étapes

### **Étape 1: Prédiction Client**
```
Client presse UP → MOVE_REQUEST_NORTH immédiatement envoyé
Client calcule: Pos_prédite = Pos_actuelle + Vitesse × deltaTime
Affiche joueur qui se déplace SANS ATTENDRE le serveur
```

### **Étape 2: Validation Serveur**
```
Serveur reçoit MOVE_REQUEST_NORTH (+50ms latence)
Vérifie: position reachable? pas de cooldown? cheating?
Calcule Pos_serveur = (100, 55)
Compare avec Pos_client = (100, 65) [prédiction client]
Calcule delta = (0, -10)
```

### **Étape 3: Correction Client**
```
Client reçoit PlayerCoordinateUpdate avec offset_y = -10
Stocke cet offset
```

### **Étape 4: Convergence Progressive**
```
À chaque frame (60Hz = 16.67ms):

Frame 1: Pos = (100, 65) + (-10) × (16.67/50) = (100, 61.7)
Frame 2: Pos = (100, 61.7) + (-10) × (16.67/50) = (100, 58.4)
Frame 3: Pos = (100, 58.4) + (-10) × (16.67/50) = (100, 55.1) ✅

→ Position converge en ~50ms (imperceptible)
```

---

## 📊 Timeline Complète (100ms latence)

```
T=0ms     | Client: MOVE_NORTH
          | Pos_display = (100, 60) [prédite]
          |
T=33ms    | Frame 2 rendering
          | Pos_display = (100, 60)
          |
T=50ms    | Serveur reçoit + calcule
          | offset_y = -5
          | Envoie PlayerCoordinateUpdate
          |
T=66ms    | Client reçoit offset
          | Frame 4: Pos = (100, 60) + (-5 × 0.167/0.05) = (100, 58.3)
          |
T=83ms    | Frame 5: Pos = (100, 56.6)
          |
T=100ms   | Frame 6: Pos = (100, 55) ✅ CONVERGED
          |
```

---

## 🔄 Les Deux Types de Corrections

### Type A: Smooth Offset Interpolation (Normal)
```java
PlayerCoordinateUpdate {
    x: 100,
    y: 55,
    velocity_x: 0,
    velocity_y: 5
}
```
✅ Appliqué progressivement (50ms)
✅ Mouvement fluide
✅ Utilisé pour mouvements normaux

---

### Type B: Forced Position Snap (Anti-Cheat)
```java
PlayerForcedPositionUpdate {
    x: 50,
    y: 50   // Complètement différent!
}
```
❌ Appliqué IMMÉDIATEMENT (pas d'interpolation)
❌ Snap brutal
❌ Activé quand: position impossible, téléportation, cheating détecté

```
Frame N:   Pos = (200, 200)  [avant snap]
Frame N+1: Pos = (50, 50)    [après snap]
           → Teleport visible = anti-cheat signature
```

---

## 💾 Architecture Code

**Main Classes:**

| Classe | Rôle |
|--------|------|
| `PlayerCoordinateUpdate` | Update lisse avec offset |
| `PlayerForcedPositionUpdate` | Snap correction anti-cheat |
| `PlayerPositionUpdate` | Structure base position |
| `ef.java` | Historique positions |
| `agd.java` | Render loop (applique offsets) |
| `ab.java` | Latency manager (mesure RTT) |

**Flow:**
```
PlayerCoordinateUpdate.handle()
  ├─ Calculate delta = server_pos - client_pos
  ├─ Store offsets in .b() / .c()
  └─ For each frame:
      position += offset × (deltaTime / updateInterval)
```

---

## 🔧 Formule Mathématique

```
Position_Rendue_N = Position_Reçue + Offset × (TempsÉcoulé / IntervalleUpdate)

Exemple:
  Position_Reçue = (100, 55)
  Offset = (0, -10)
  TempsÉcoulé = 16.67ms (Frame 1)
  IntervalleUpdate = 50ms
  
  Pos_Frame1 = (100, 55) + (0, -10) × (16.67/50)
             = (100, 55) + (0, -10) × 0.3334
             = (100, 55) + (0, -3.334)
             = (100, 51.666) ✅
```

---

## 📈 Configuration Arena of Kings

| Paramètre | Valeur | Impact |
|-----------|--------|--------|
| Network Tick Rate | 10-20 Hz | 50-100ms entre updates |
| Render Frame Rate | 60 Hz | 16.67ms par frame |
| Interpolation Duration | ~50ms | Temps convergence |
| Prediction Window | 100-200ms | Fenêtre exploitable |
| Latency Tolerance | < 200ms | Acceptable |
| TCP Buffer | 524 KB | ~5,000 packets |
| UDP Buffer | 65 KB | ~100 packets |

---

## 🎯 Cas d'Usage Concrets

### Cas 1: Mouvement Normal
```
Joueur1 se déplace NORD
├─ T0: Envoie MOVE_REQUEST_NORTH
├─ T50: Serveur valide
├─ T100: Client reçoit correction (offset petit)
└─ T150: Position converge avec offset
Résultat: Mouvement fluide, imperceptible
```

### Cas 2: Cheating Détecté
```
Joueur2 hack "teleport to target"
├─ T0: Envoie position (500, 500) [impossible]
├─ T50: Serveur vérifie distance/time = teleport détecté
├─ T100: Envoie PlayerForcedPositionUpdate(100, 100)
└─ T116: Client snaps brutalement à (100, 100)
Résultat: Teleport visible, anti-cheat trigger
```

### Cas 3: Lag Spike (500ms)
```
Joueur3 lag spike
├─ T0: Pos = (100, 50), moving NORD
├─ T500: Network recovers
├─ T550: Serveur: Pos devrait être (100, 75)
├─ T600: Client reçoit offset_y = 25
└─ T650: Starts convergence (takes 50ms)
Résultat: Rubber-banding effect (~50ms)
```

---

## 🚨 Vulnérabilités & Exploits

### Vulnérabilité 1: Prédiction Linéaire

**Le problème:**
```
Serveur envoie: offset = (10, 0)
→ Client sait que joueur avance en ligne droite de 10 units

Exploit:
  Interception du packet
  → Calculate trajectory
  → Aim AHEAD of predicted position
  → "Pre-aim" sur position future
  → Hit avant que joueur soit vraiment là
```

**Gravité:** 🟡 MEDIUM - Exploitable en PvP

---

### Vulnérabilité 2: Fenêtre d'Exploitation 150ms

**Le problème:**
```
Latence = 100ms
Interpolation = 50ms
Total window = 150ms

Pendant ces 150ms:
  - Position "vraie" (serveur) ≠ Position "affichée" (client)
  - Différence peut être 3-5 mètres
  - Hitbox mismatch exploitable
  - Skill shots non-visibles: client voit A, serveur validé B
```

**Gravité:** 🟡 MEDIUM - Desync sur hitbox

---

### Vulnérabilité 3: Snap Correction Détectable

**Le problème:**
```
PlayerForcedPositionUpdate(teleport) → Snap brutal
Frame N:   Pos = (200, 200)
Frame N+1: Pos = (50, 50)
Visible teleport = Anti-cheat trigger obvious
```

**Exploit:**
```
Hacker sait quand il trigger anti-cheat
→ Peut ajuster exploit threshold
→ Optimize cheating strategy based on detections
```

**Gravité:** 🟡 MEDIUM - Cat & mouse game

---

### Vulnérabilité 4: Pas de Sequence Numbers

**Le problème:**
```
Sans numéro de séquence:
  Packet1: offset = (5, 0)  [old]
  Packet2: offset = (1, 1)  [new]
  
Si Packet2 arrive d'abord:
  → Applique (1, 1)
  → Puis applique (5, 0) [ancien!]
  → Position converge à mauvais endroit
  
Ou: Packet replay attack
  Envoie vieux offset multiples fois
  → Joueur drifts en mauvaise direction
```

**Gravité:** 🟡 MEDIUM - Packet reordering/replay

---

### Vulnérabilité 5: Unbounded Queue DoS

**Le problème:**
```
LinkedBlockingQueue<PublicPacket> a;  // Pas de limite!

Attaque:
  Flood 10,000 PlayerCoordinateUpdate packets
  → Queue grows unbounded
  → Memory exhaustion
  → Client crash

Ou: Lag le main thread
  Main thread stuck processing queue
  → Render frame drops
  → Game unplayable
```

**Gravité:** 🟠 HIGH - DoS possible

---

## 🛡️ Mitigations

### Fix 1: Add Sequence Numbers
```java
public class PlayerCoordinateUpdate {
    private int sequenceNumber;  // NEW
    private int expectedSequence = 0;  // In handler
    
    if (update.sequenceNumber != expectedSequence) {
        Log.warn("Out of order!");
        return;  // Drop
    }
    expectedSequence++;
}
```

### Fix 2: Bounded Queue
```java
// OLD: new LinkedBlockingQueue<>()  // Unbounded
// NEW:
LinkedBlockingQueue<PublicPacket> queue = 
    new LinkedBlockingQueue<>(1000);  // Max 1000 packets

if (!queue.offer(packet, 100, TimeUnit.MILLISECONDS)) {
    Log.warn("Queue full - possible DoS");
    connection.close();
}
```

### Fix 3: Rate Limiting
```java
private RateLimiter rateLimiter = 
    RateLimiter.create(100.0);  // 100 packets/sec max

if (!rateLimiter.tryAcquire()) {
    Log.warn("Rate limit exceeded");
    connection.close();
}
```

### Fix 4: Smooth Snap Correction
```java
// OLD: Instant snap
// NEW: Progressive snap over 100ms
if (forced_update) {
    // Instead of setPosition(x, y)
    // Add smooth interpolation
    startSmoothInterpolation(target_x, target_y, 100ms);
}
```

### Fix 5: Anti-Replay with Timestamps
```java
private long lastUpdateTime = 0;

if (packet.timestamp <= lastUpdateTime) {
    Log.warn("Replay attack detected");
    return;
}
lastUpdateTime = packet.timestamp;
```

---

## 📊 Performance Impact

| Métrique | Avec Compensation | Sans Compensation |
|----------|-------------------|-------------------|
| Latence Perçue | ~50ms | ~100-200ms |
| Smoothness | Excellent | Saccadé |
| Desync Risk | Medium | High |
| CPU Usage | +5% | -5% |
| Memory | ~2MB queue | Variable |
| Cheat Difficulty | Medium | Easy |

---

## 🎓 Résumé Exécutif

**Mécanisme:** Velocity-offset interpolation (NOT Lerp)
- Client prédit mouvement immédiatement
- Serveur valide et envoie corrections
- Client applique corrections progressivement (50ms)

**Autorité:** Server-authoritative avec validation post-facto
- Client décide rapidement (UX fluide)
- Serveur valide/corrige (intégrité)
- Forced updates override predictions (anti-cheat)

**Fenêtre d'Exploitation:** 100-200ms
- Prédiction linéaire exploitable
- Hitbox desync possible
- Multiple attack vectors

**Sécurité Actuelle:** 🟡 MEDIUM RISK
- Pas de sequence numbers
- Queue unbounded
- Prédiction previsible
- Snap corrections detectables

**Recommandation:** Implémenter les 5 fixes ci-dessus

---

**Generated:** May 25, 2026
**Status:** Complete Analysis
