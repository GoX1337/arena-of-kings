package com.arenaofkings.server;

import com.arenaofkings.net.Net;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Authoritative movement server (TCP only, fixed {@link Net#TICK_HZ} timestep).
 * Clients only send input intents ({@link Net.Input}); positions are integrated here,
 * clamped to the arena, and broadcast as {@link Net.Snapshot}. Run with:
 * {@code mvn compile exec:java -Dexec.mainClass=com.arenaofkings.server.GameServer}
 */
public class GameServer {
  private static final class Player {
    int id;
    float x, y;
    float ix, iy;
    int dir;
    int lastSeq;
    String skin = "";
  }

  private final Server server = new Server(1 << 20, 1 << 20);
  private final Map<Connection, Player> players = new ConcurrentHashMap<>();
  private final AtomicInteger nextId = new AtomicInteger(1);
  private volatile boolean running = true;
  private long tick = 0;

  public void start() throws IOException {
    Net.register(server.getKryo());
    server.addListener(new Listener() {
      @Override
      public void connected(Connection c) {
        Player p = new Player();
        p.id = nextId.getAndIncrement();
        p.x = (p.id % 5) * 80f;
        p.y = 0;
        players.put(c, p);
        Net.Welcome w = new Net.Welcome();
        w.id = p.id;
        w.x = p.x;
        w.y = p.y;
        c.sendTCP(w);
        System.out.println("[srv] + player " + p.id + " (" + players.size() + " online)");
      }

      @Override
      public void disconnected(Connection c) {
        Player p = players.remove(c);
        if (p != null) {
          Net.Bye b = new Net.Bye();
          b.id = p.id;
          server.sendToAllTCP(b);
          System.out.println("[srv] - player " + p.id + " (" + players.size() + " online)");
        }
      }

      @Override
      public void received(Connection c, Object o) {
        if (o instanceof Net.Hello) {
          Player p = players.get(c);
          if (p != null && ((Net.Hello) o).skin != null) {
            p.skin = ((Net.Hello) o).skin;
          }
        } else if (o instanceof Net.Skin) {
          Player p = players.get(c);
          if (p != null && ((Net.Skin) o).skin != null) {
            p.skin = ((Net.Skin) o).skin;
            System.out.println("[srv] player " + p.id + " skin=" + p.skin);
          }
        } else if (o instanceof Net.Input) {
          Player p = players.get(c);
          if (p != null) {
            Net.Input in = (Net.Input) o;
            // Drop stale/duplicate inputs (UDP reorders and duplicates).
            if (in.seq <= p.lastSeq) {
              return;
            }
            p.lastSeq = in.seq;
            // Clamp input magnitude so a hacked client can't exceed SPEED.
            float len = (float) Math.sqrt(in.x * in.x + in.y * in.y);
            if (len > 1f) {
              p.ix = in.x / len;
              p.iy = in.y / len;
            } else {
              p.ix = in.x;
              p.iy = in.y;
            }
            p.dir = Math.max(0, Math.min(7, in.dir));
          }
        }
      }
    });
    server.bind(Net.TCP_PORT, Net.UDP_PORT);
    server.start();
    System.out.println("[srv] listening TCP+UDP " + Net.TCP_PORT + " @ " + Net.TICK_HZ + "Hz");
  }

  /** Fixed-timestep loop: integrate, then broadcast one snapshot per step. */
  public void loop() {
    long stepNs = 1_000_000_000L / Net.TICK_HZ;
    long next = System.nanoTime();
    long lastLog = System.currentTimeMillis();
    while (running) {
      long now = System.nanoTime();
      if (now >= next) {
        step(1f / Net.TICK_HZ);
        next += stepNs;
        if (next < now - stepNs) {
          next = now; // shed backlog instead of spiralling
        }
      } else {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          running = false;
        }
      }
      if (System.currentTimeMillis() - lastLog > 5000) {
        lastLog = System.currentTimeMillis();
        logState();
      }
    }
  }

  private void step(float dt) {
    tick++;
    Net.Snapshot s = new Net.Snapshot();
    s.tick = tick;
    s.serverTime = System.nanoTime();
    int n = players.size();
    s.ids = new int[n];
    s.xs = new float[n];
    s.ys = new float[n];
    s.skins = new String[n];
    s.dirs = new int[n];
    s.acks = new int[n];
    int i = 0;
    for (Player p : players.values()) {
      p.x = clamp(p.x + p.ix * Net.SPEED * dt);
      p.y = clamp(p.y + p.iy * Net.SPEED * dt);
      s.ids[i] = p.id;
      s.xs[i] = p.x;
      s.ys[i] = p.y;
      s.skins[i] = p.skin;
      s.dirs[i] = p.dir;
      s.acks[i] = p.lastSeq;
      i++;
    }
    if (n > 0) {
      // Snapshots are latest-wins: UDP avoids head-of-line blocking from TCP.
      server.sendToAllUDP(s);
    }
  }

  private static float clamp(float v) {
    return Math.max(-Net.ARENA_HALF, Math.min(Net.ARENA_HALF, v));
  }

  private void logState() {
    StringBuilder sb = new StringBuilder("[srv] tick ").append(tick);
    for (Player p : players.values()) {
      sb.append(" #").append(p.id).append("=(")
          .append((int) p.x).append(',').append((int) p.y).append(')');
    }
    System.out.println(sb);
  }

  public void stop() {
    running = false;
    server.stop();
  }

  public static void main(String[] args) throws Exception {
    GameServer srv = new GameServer();
    srv.start();
    Runtime.getRuntime().addShutdownHook(new Thread(srv::stop));
    srv.loop();
  }
}
