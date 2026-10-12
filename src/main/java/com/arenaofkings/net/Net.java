package com.arenaofkings.net;

import com.esotericsoftware.kryo.Kryo;

/**
 * Shared KryoNet protocol (movement only). The server is authoritative: clients send
 * input intents, never positions. Both sides register in the same order via
 * {@link #register}, so client and server always agree on Kryo class IDs.
 */
public final class Net {
  /** Same number for TCP (reliable) and UDP (realtime): different protocols. */
  public static final int TCP_PORT = 54555;
  public static final int UDP_PORT = 54555;
  public static final int TICK_HZ = 20;
  /** World units/s, same value as the game. Only the server integrates it. */
  public static final float SPEED = 500f;
  /** Movement clamp (half-extent, world units). */
  public static final float ARENA_HALF = 4000f;

  private Net() {
  }

  /** Client -> server on connect (reserved for version checks). */
  public static class Hello {
    public int version = 1;
    /** Skin folder, e.g. "wizard/outfit_1/dark", for remote rendering. */
    public String skin = "";

    public Hello() {
    }
  }

  /** Server -> client: assigned player id + spawn position. */
  public static class Welcome {
    public int id;
    public float x;
    public float y;

    public Welcome() {
    }
  }

  /** Client -> server input intent, normalized, (0,0) = idle. Sent over UDP. */
  public static class Input {
    public float x;
    public float y;
    /** Facing 0-7 (mouse aim), see game computeDir. */
    public int dir;
    /** Monotonic per-client sequence; server drops stale/duplicate inputs. */
    public int seq;

    public Input() {
    }
  }

  /** Server -> all clients, at TICK_HZ over UDP: full world snapshot. */
  public static class Snapshot {
    public long tick;
    /** Server clock (nanos) at send time: measures data age, orders snapshots. */
    public long serverTime;
    public int[] ids = new int[0];
    public float[] xs = new float[0];
    public float[] ys = new float[0];
    /** Skin folder per player, aligned with ids ("" = unknown). */
    public String[] skins = new String[0];
    /** Facing per player, aligned with ids. */
    public int[] dirs = new int[0];
    /** Last input seq applied per player, aligned with ids (for reconciliation). */
    public int[] acks = new int[0];

    public Snapshot() {
    }
  }

  /** Client -> server: skin changed mid-game. */
  public static class Skin {
    public String skin = "";

    public Skin() {
    }
  }

  /** Server -> all clients: a player left. */
  public static class Bye {
    public int id;

    public Bye() {
    }
  }

  public static void register(Kryo kryo) {
    kryo.register(Hello.class);
    kryo.register(Welcome.class);
    kryo.register(Input.class);
    kryo.register(Snapshot.class);
    kryo.register(Bye.class);
    kryo.register(Skin.class);
    // KryoNet requires explicit registration, arrays included.
    kryo.register(int[].class);
    kryo.register(float[].class);
    kryo.register(String[].class);
  }
}
