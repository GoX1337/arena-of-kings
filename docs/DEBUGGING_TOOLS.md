# KryoNet Protocol Debugging & Interception Techniques

## 📡 Méthodes d'Interception

### Méthode 1: Java Agent (Bytecode Instrumentation)

**Installer un agent pour logger tous les paquets:**

```java
// PacketLoggerAgent.java
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import javassist.*;

public class PacketLoggerAgent {
    public static void premain(String args, Instrumentation inst) {
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                    Class<?> classBeingRedefined, ProtectionDomain pd,
                    byte[] classFileBuffer) throws IllegalClassFormatException {
                
                if (className.equals("ae")) {  // NetworkListener
                    try {
                        ClassPool pool = ClassPool.getDefault();
                        CtClass clazz = pool.get(className);
                        
                        // Hook received() method
                        CtMethod received = clazz.getDeclaredMethod("received");
                        received.insertBefore(
                            "System.out.println(\"[PACKET] Received: \" + " +
                            "$2.getClass().getSimpleName() + \" -> \" + $2);"
                        );
                        
                        return clazz.toBytecode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return classFileBuffer;
            }
        });
    }
}
```

**Manifest pour JAR agent:**
```
Manifest-Version: 1.0
Premain-Class: PacketLoggerAgent
Can-Redefine-Classes: true
Can-Retransform-Classes: true
```

**Lancer le jeu avec agent:**
```bash
java -javaagent:PacketLoggerAgent.jar -cp game.jar Main
```

**Output:**
```
[PACKET] Received: PUB_GAME_INIT -> PUB_GAME_INIT@abcd1234
[PACKET] Received: PUB_GAME_SNAPSHOT -> PUB_GAME_SNAPSHOT@abcd5678
[PACKET] Received: PlayerCoordinateUpdate -> PlayerCoordinateUpdate@abcd9012
```

---

### Méthode 2: Proxy Reseau (Network Packet Capture)

**Utiliser Charles Proxy ou mitmproxy:**

```bash
# Configurer Charles
Tools → SSL Proxying → Enable SSL Proxying
Proxying Settings → Proxy Tabs → HTTP Proxy Port 8888

# Lancer le jeu avec proxy system
java -Dhttp.proxyHost=127.0.0.1 -Dhttp.proxyPort=8888 -cp game.jar Main
```

**Extraire paquets dans Wireshark:**

```bash
# Capturer trafic TCP port 7777
sudo tclshark -i eth0 -f "tcp port 7777" -w arena.pcap

# Exporter en format lisible
tshark -r arena.pcap -O tcp -V > arena_packets.txt
```

---

### Méthode 3: Debugger JVM (Runtime Breakpoints)

**Attacher debugger à process en cours d'exécution:**

```bash
# Option 1: Lancer jeu en debug mode
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
     -cp game.jar Main

# Option 2: Attacher à process existant
jdb -attach localhost:5005

# Dans jdb:
> stop in ae.received(com.esotericsoftware.kryonet.Connection, java.lang.Object)
> resume
> print object.getClass().getName()
> print object
```

**Breakpoint dans ae.connected():**
```
stop in ae.connected(com.esotericsoftware.kryonet.Connection)
  → Inspect PUB_MISC_PLAYER_TOKEN
  → Read token value
  → Check connection object properties
```

---

### Méthode 4: Reflection Runtime Inspection

**Accéder aux champs privés au runtime:**

```java
public class NetworkInspector {
    public static void inspectNetworkState(ag gameClient) {
        try {
            // Access private fields of ag
            Field queueField = ag.class.getDeclaredField("a");
            queueField.setAccessible(true);
            LinkedBlockingQueue<?> queue = 
                (LinkedBlockingQueue<?>) queueField.get(gameClient);
            
            System.out.println("Queue size: " + queue.size());
            for (Object packet : queue) {
                System.out.println("Queued: " + 
                    packet.getClass().getSimpleName());
            }
            
            // Access private latency manager
            Field latencyField = ag.class.getDeclaredField("a");
            latencyField.setAccessible(true);
            ab latencyMgr = (ab) latencyField.get(gameClient);
            
            // Access private ping field
            Field pingField = ab.class.getDeclaredField("d");
            pingField.setAccessible(true);
            int currentPing = pingField.getInt(latencyMgr);
            
            System.out.println("Current ping: " + currentPing + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### Méthode 5: Aspect-Oriented Programming (AOP)

**Utiliser AspectJ pour intercepter méthodes:**

```java
// PacketInterceptor.aj
public aspect PacketInterceptor {
    
    // Intercepter all sendTCP calls
    pointcut sendPacket() : 
        call(void com.esotericsoftware.kryonet.Connection.sendTCP(Object));
    
    before() : sendPacket() {
        System.out.println("[OUTBOUND] Sending: " + thisJoinPoint.getArgs()[0]);
    }
    
    // Intercepter all handle() calls
    pointcut handlePacket(Object packet) : 
        call(void com.arenaofkings.packets.misc.PublicPacket.handle(..)) &&
        args(packet);
    
    before(Object packet) : handlePacket(packet) {
        System.out.println("[HANDLE] Processing: " + 
            packet.getClass().getSimpleName());
    }
    
    // Measure dispatch time
    around(Object packet) : handlePacket(packet) {
        long start = System.nanoTime();
        proceed(packet);
        long duration = System.nanoTime() - start;
        System.out.println("[TIME] " + 
            packet.getClass().getSimpleName() + 
            " took " + (duration / 1_000_000.0) + "ms");
    }
}
```

**Compiler et utiliser:**
```bash
ajc -d bin PacketInterceptor.aj
java -cp bin:game.jar -Xbootclasspath/a:aspectjrt.jar Main
```

---

## 🔍 Packet Analysis Tools

### Tool 1: Kryo Packet Deserializer

**Utility pour désérialiser paquets capturés:**

```java
import com.esotericsoftware.kryo.Kryo;
import java.io.*;

public class PacketDeserializer {
    
    public static void main(String[] args) throws Exception {
        // Hex string from Wireshark
        String hexPacket = "00 01 02 03 04 05 ...";
        byte[] data = hexToBytes(hexPacket);
        
        // Initialize Kryo with same registry as game
        Kryo kryo = new Kryo();
        af.a(kryo);  // Use game's registry
        
        // Deserialize
        Input input = new Input(data);
        Object packet = kryo.readObject(input, Object.class);
        
        System.out.println("Packet Type: " + 
            packet.getClass().getSimpleName());
        System.out.println("Packet Content: " + packet);
        
        // Inspect specific fields
        if (packet instanceof PUB_GAME_SNAPSHOT) {
            PUB_GAME_SNAPSHOT snapshot = 
                (PUB_GAME_SNAPSHOT) packet;
            // Access fields...
        }
    }
    
    private static byte[] hexToBytes(String hex) {
        hex = hex.replaceAll(" ", "");
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) Integer.parseInt(
                hex.substring(i * 2, i * 2 + 2), 16);
        }
        return result;
    }
}
```

---

### Tool 2: Network Monitor Dashboard

**Real-time monitoring application:**

```java
import java.util.concurrent.*;

public class NetworkMonitor implements Listener {
    
    private AtomicLong totalPacketsReceived = new AtomicLong(0);
    private AtomicLong totalBytesSent = new AtomicLong(0);
    private ConcurrentHashMap<String, Long> packetCounts = 
        new ConcurrentHashMap<>();
    private ScheduledExecutorService scheduler = 
        Executors.newScheduledThreadPool(1);
    
    public NetworkMonitor() {
        // Print stats every 5 seconds
        scheduler.scheduleAtFixedRate(
            this::printStats, 5, 5, TimeUnit.SECONDS);
    }
    
    @Override
    public void connected(Connection conn) {
        System.out.println("[CONNECT] " + conn.getRemoteAddressTCP());
    }
    
    @Override
    public void disconnected(Connection conn) {
        System.out.println("[DISCONNECT] " + conn.getRemoteAddressTCP());
    }
    
    @Override
    public void received(Connection conn, Object obj) {
        totalPacketsReceived.incrementAndGet();
        String packetType = obj.getClass().getSimpleName();
        packetCounts.compute(packetType, 
            (k, v) -> v == null ? 1 : v + 1);
    }
    
    @Override
    public void idle(Connection conn) {
    }
    
    private void printStats() {
        System.out.println("\n=== NETWORK STATS ===");
        System.out.println("Total Packets: " + 
            totalPacketsReceived.get());
        
        packetCounts.entrySet().stream()
            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
            .limit(10)
            .forEach(e -> System.out.println(
                "  " + e.getKey() + ": " + e.getValue()));
    }
}
```

---

### Tool 3: Packet Sniffer

**Capturer et sauvegarder tous les paquets:**

```java
public class PacketSniffer extends AbstractQueue<PublicPacket> {
    private PrintWriter logFile;
    private Kryo kryo;
    private LinkedBlockingQueue<PublicPacket> wrapped;
    
    public PacketSniffer(String logPath) throws IOException {
        this.logFile = new PrintWriter(
            new FileWriter(logPath, true), true);
        this.kryo = new Kryo();
        af.a(this.kryo);
        this.wrapped = new LinkedBlockingQueue<>();
    }
    
    @Override
    public Iterator<PublicPacket> iterator() {
        return wrapped.iterator();
    }
    
    @Override
    public int size() {
        return wrapped.size();
    }
    
    @Override
    public boolean offer(PublicPacket packet) {
        // Log packet
        logFile.println("[" + System.currentTimeMillis() + "] " +
            "PACKET: " + packet.getClass().getSimpleName() +
            " | " + packet.toString());
        
        // Serialize for capture
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeObject(output, packet);
        output.close();
        
        byte[] data = baos.toByteArray();
        logFile.println("  HEX: " + bytesToHex(data));
        logFile.println("  SIZE: " + data.length + " bytes\n");
        
        return wrapped.offer(packet);
    }
    
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}
```

---

## 🎯 Analysis Examples

### Example 1: Extract All Tokens

**Intercept authentication tokens:**

```java
public class TokenExtractor implements Listener {
    
    @Override
    public void received(Connection conn, Object obj) {
        if (obj instanceof PUB_MISC_PLAYER_TOKEN) {
            PUB_MISC_PLAYER_TOKEN token = 
                (PUB_MISC_PLAYER_TOKEN) obj;
            
            String playerToken = token.getToken();
            int gameID = token.getGameID();
            
            System.out.println("=== CREDENTIALS ===");
            System.out.println("Token: " + playerToken);
            System.out.println("GameID: " + gameID);
            System.out.println("Connection: " + 
                conn.getRemoteAddressTCP());
            
            // Save to file for later use
            saveCredentials(playerToken, gameID, 
                conn.getRemoteAddressTCP().toString());
        }
    }
    
    private void saveCredentials(String token, int gameID, 
            String connection) {
        try (FileWriter fw = new FileWriter("tokens.txt", true)) {
            fw.write(String.format(
                "%s | GameID: %d | Conn: %s%n", 
                token, gameID, connection));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void connected(Connection c) {}
    
    @Override
    public void disconnected(Connection c) {}
    
    @Override
    public void idle(Connection c) {}
}
```

**Output:**
```
=== CREDENTIALS ===
Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
GameID: 123456789
Connection: 192.168.1.100:54321
```

---

### Example 2: Detect Cheating Behavior

**Monitor suspicious packet patterns:**

```java
public class CheatDetector implements Listener {
    
    private Map<String, PlayerMetrics> playerMetrics = 
        new ConcurrentHashMap<>();
    private final long MAX_MOVEMENT_SPEED = 50;  // units/sec
    private final int MAX_PKT_PER_SEC = 100;
    
    @Override
    public void received(Connection conn, Object obj) {
        String playerId = conn.getRemoteAddressTCP().toString();
        
        PlayerMetrics metrics = playerMetrics.computeIfAbsent(
            playerId, k -> new PlayerMetrics());
        
        // Check movement speed exploit
        if (obj instanceof PlayerCoordinateUpdate) {
            PlayerCoordinateUpdate update = 
                (PlayerCoordinateUpdate) obj;
            
            double distance = metrics.lastPosition
                .distance(update.getPosition());
            long timeDelta = System.currentTimeMillis() - 
                metrics.lastUpdateTime;
            
            double speed = distance / (timeDelta / 1000.0);
            
            if (speed > MAX_MOVEMENT_SPEED) {
                System.out.println("[CHEAT] " + playerId + 
                    " moving at " + speed + " units/sec " +
                    "(max: " + MAX_MOVEMENT_SPEED + ")");
            }
            
            metrics.lastPosition = update.getPosition();
            metrics.lastUpdateTime = System.currentTimeMillis();
        }
        
        // Check packet spam
        metrics.packetCount++;
        if (System.currentTimeMillis() - 
                metrics.secondStartTime > 1000) {
            
            if (metrics.packetCount > MAX_PKT_PER_SEC) {
                System.out.println("[CHEAT] " + playerId + 
                    " spam: " + metrics.packetCount + 
                    " packets/sec");
            }
            
            metrics.packetCount = 0;
            metrics.secondStartTime = System.currentTimeMillis();
        }
    }
    
    private static class PlayerMetrics {
        Location lastPosition = new Location(0, 0, 0);
        long lastUpdateTime = System.currentTimeMillis();
        long secondStartTime = System.currentTimeMillis();
        int packetCount = 0;
    }
    
    @Override
    public void connected(Connection c) {}
    @Override
    public void disconnected(Connection c) {}
    @Override
    public void idle(Connection c) {}
}
```

**Output:**
```
[CHEAT] 192.168.1.100:54321 moving at 500 units/sec (max: 50)
[CHEAT] 192.168.1.100:54321 spam: 450 packets/sec
```

---

### Example 3: Packet Timeline Reconstruction

**Reconstruire la timeline d'une session de jeu:**

```java
public class SessionRecorder {
    
    private List<PacketRecord> timeline = new ArrayList<>();
    private long sessionStart = System.currentTimeMillis();
    
    public void recordPacket(Object packet) {
        long timestamp = System.currentTimeMillis() - sessionStart;
        String type = packet.getClass().getSimpleName();
        
        timeline.add(new PacketRecord(timestamp, type, packet));
    }
    
    public void generateReport(String outputFile) 
            throws IOException {
        try (PrintWriter writer = 
                new PrintWriter(new FileWriter(outputFile))) {
            
            writer.println("=== ARENA OF KINGS SESSION TIMELINE ===");
            writer.println("Duration: " + 
                timeline.get(timeline.size() - 1).timestamp + 
                " ms\n");
            
            long lastTime = 0;
            for (PacketRecord record : timeline) {
                long delta = record.timestamp - lastTime;
                writer.printf("[%6d ms] +%4d ms | %s%n", 
                    record.timestamp, delta, record.type);
                
                // Detail important packets
                if (record.packet instanceof 
                        PlayerCoordinateUpdate) {
                    PlayerCoordinateUpdate p = 
                        (PlayerCoordinateUpdate) record.packet;
                    writer.printf("            └─ Position: %s%n", 
                        p.getPosition());
                }
                
                lastTime = record.timestamp;
            }
        }
    }
    
    private static class PacketRecord {
        long timestamp;
        String type;
        Object packet;
        
        PacketRecord(long ts, String t, Object p) {
            this.timestamp = ts;
            this.type = t;
            this.packet = p;
        }
    }
}

// Usage
SessionRecorder recorder = new SessionRecorder();

// Hook into ae.received()
// recorder.recordPacket(object);

recorder.generateReport("session_log.txt");
```

**Output:**
```
=== ARENA OF KINGS SESSION TIMELINE ===
Duration: 15234 ms

[     0 ms] +   0 ms | PUB_GAME_INIT
[    15 ms] +  15 ms | PUB_GAME_SNAPSHOT
[    45 ms] +  30 ms | PlayerCoordinateUpdate
            └─ Position: (100.5, 50.2, 10.0)
[    50 ms] +   5 ms | MOVE_REQUEST_NORTH
[    75 ms] +  25 ms | PlayerCoordinateUpdate
            └─ Position: (100.5, 55.2, 10.0)
[ 5000 ms] +4925 ms | PUB_GAME_PING
[ 5010 ms] +  10 ms | PUB_GAME_PING_RESPONSE
...
```

---

## 🧪 Protocol Fuzzing

**Fuzzer pour tester robustesse du serveur:**

```java
import java.util.Random;

public class PacketFuzzer {
    
    public static void main(String[] args) 
            throws Exception {
        Random rand = new Random();
        Connection conn = new Client(524280, 65535)
            .connect(5000, "localhost", 7777, 7778);
        
        Kryo kryo = new Kryo();
        af.a(kryo);
        
        int iterations = 10000;
        
        for (int i = 0; i < iterations; i++) {
            try {
                // Generate random packet type
                Class<?> packetType = getRandomPacketType();
                Object packet = packetType.newInstance();
                
                // Randomize fields
                fuzzeFields(packet, rand);
                
                // Send
                conn.sendTCP(packet);
                System.out.println("[FUZZ #" + i + "] Sent: " + 
                    packetType.getSimpleName());
                
                Thread.sleep(10);
                
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        
        conn.close();
    }
    
    private static Class<?> getRandomPacketType() {
        // Get random type from af registry
        Class<?>[] types = {
            MOVE_REQUEST_NORTH.class,
            SPELL_REQUEST.class,
            DIRECTION_CHANGE_REQUEST.class,
            TargetRequest.class,
            // ... all registered types
        };
        return types[new Random().nextInt(types.length)];
    }
    
    private static void fuzzeFields(Object packet, Random rand) {
        // Randomize all object fields
        for (Field field : packet.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            
            Class<?> type = field.getType();
            Object value = null;
            
            if (type == int.class) {
                value = rand.nextInt();
            } else if (type == long.class) {
                value = rand.nextLong();
            } else if (type == float.class) {
                value = rand.nextFloat();
            } else if (type == double.class) {
                value = rand.nextDouble();
            } else if (type == boolean.class) {
                value = rand.nextBoolean();
            } else if (type == String.class) {
                value = "FUZZ_" + rand.nextInt();
            }
            
            try {
                field.set(packet, value);
            } catch (IllegalAccessException e) {
                // Skip
            }
        }
    }
}
```

---

## 📋 Checklist for Full Reverse Engineering

- [x] Identify network framework (KryoNet)
- [x] Find event listeners (ae.java)
- [x] Extract packet registry (af.java)
- [x] Map connection setup (ag.java)
- [x] Analyze latency system (ab.java)
- [x] Document all 100+ packet types
- [ ] Reverse engineer server packet handlers
- [ ] Capture authentication flow
- [ ] Document game state updates
- [ ] Map player data structures
- [ ] Analyze spell/effect system
- [ ] Document item/inventory system
- [ ] Extract client-side validation logic
- [ ] Identify server-side validation logic
- [ ] Document anti-cheat mechanisms
- [ ] Analyze rate limiting
- [ ] Test packet injection attacks
- [ ] Test DDoS scenarios
- [ ] Create bot client using extracted protocol
- [ ] Write protocol emulator

---

This guide provides comprehensive tools and techniques for analyzing, intercepting, and monitoring the Arena of Kings KryoNet protocol.
