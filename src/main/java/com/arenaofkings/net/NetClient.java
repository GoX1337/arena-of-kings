package com.arenaofkings.net;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Game-side network endpoint (no libGDX dependency, safe to use headless).
 * KryoNet callbacks run on its own thread: state is exposed via volatile fields
 * polled from the render loop, never pushed.
 */
public class NetClient {
  private final Client client = new Client(1 << 20, 1 << 20);
  private volatile Net.Snapshot latest;
  private volatile int selfId = -1;
  private volatile boolean open;
  private final ConcurrentLinkedQueue<Integer> left = new ConcurrentLinkedQueue<>();
  private int seq;

  public NetClient() {
    Net.register(client.getKryo());
    client.addListener(new Listener() {
      @Override
      public void received(Connection c, Object o) {
        if (o instanceof Net.Welcome) {
          Net.Welcome w = (Net.Welcome) o;
          selfId = w.id;
        } else if (o instanceof Net.Snapshot) {
          latest = (Net.Snapshot) o;
        } else if (o instanceof Net.Bye) {
          left.add(((Net.Bye) o).id);
        }
      }

      @Override
      public void disconnected(Connection c) {
        open = false;
      }
    });
  }

  /** Connects (blocking, up to timeoutMs). Returns false when unreachable. */
  public boolean connect(String host, int timeoutMs, String skin) {
    try {
      client.start();
      client.connect(timeoutMs, host, Net.TCP_PORT, Net.UDP_PORT);
      open = true;
      Net.Hello hello = new Net.Hello();
      hello.skin = skin == null ? "" : skin;
      client.sendTCP(hello);
      return true;
    } catch (IOException e) {
      try {
        client.stop();
      } catch (Exception ignored) {
        // Already stopped.
      }
      return false;
    }
  }

  public boolean isConnected() {
    return open && client.isConnected();
  }

  public int selfId() {
    return selfId;
  }

  /** Latest snapshot, or null if none received yet. */
  public Net.Snapshot snapshot() {
    return latest;
  }

  /** Queued departed player id, or null. */
  public Integer pollLeft() {
    return left.poll();
  }

  /**
   * Sends an input intent over UDP with the next sequence number.
   * Returns the sequence used, or -1 when not connected.
   */
  public int sendInput(float x, float y, int dir) {
    if (!isConnected()) {
      return -1;
    }
    Net.Input in = new Net.Input();
    in.x = x;
    in.y = y;
    in.dir = dir;
    in.seq = ++seq;
    client.sendUDP(in);
    return in.seq;
  }

  public void sendSkin(String skin) {
    if (!isConnected()) {
      return;
    }
    Net.Skin s = new Net.Skin();
    s.skin = skin == null ? "" : skin;
    client.sendTCP(s);
  }

  public void close() {
    open = false;
    try {
      client.stop();
    } catch (Exception ignored) {
      // Already stopped.
    }
  }
}
