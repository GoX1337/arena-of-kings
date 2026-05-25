/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamNetworkingCallback;
import com.codedisaster.steamworks.SteamNetworkingCallbackAdapter;
import java.nio.ByteBuffer;

public class SteamNetworking
extends SteamInterface {
    private final int[] tmpIntResult = new int[1];
    private final long[] tmpLongResult = new long[1];

    public SteamNetworking(SteamNetworkingCallback steamNetworkingCallback) {
        this(SteamAPI.getSteamNetworkingPointer(), SteamNetworking.createCallback(new SteamNetworkingCallbackAdapter(steamNetworkingCallback)));
    }

    SteamNetworking(long l2, long l3) {
        super(l2, l3);
    }

    public boolean sendP2PPacket(SteamID steamID, ByteBuffer byteBuffer, P2PSend p2PSend, int n2) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamNetworking.sendP2PPacket(this.pointer, steamID.handle, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), p2PSend.ordinal(), n2);
    }

    public int isP2PPacketAvailable(int n2) {
        if (SteamNetworking.isP2PPacketAvailable(this.pointer, this.tmpIntResult, n2)) {
            return this.tmpIntResult[0];
        }
        return 0;
    }

    public int readP2PPacket(SteamID steamID, ByteBuffer byteBuffer, int n2) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        if (SteamNetworking.readP2PPacket(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), this.tmpIntResult, this.tmpLongResult, n2)) {
            steamID.handle = this.tmpLongResult[0];
            return this.tmpIntResult[0];
        }
        return 0;
    }

    public boolean acceptP2PSessionWithUser(SteamID steamID) {
        return SteamNetworking.acceptP2PSessionWithUser(this.pointer, steamID.handle);
    }

    public boolean closeP2PSessionWithUser(SteamID steamID) {
        return SteamNetworking.closeP2PSessionWithUser(this.pointer, steamID.handle);
    }

    public boolean closeP2PChannelWithUser(SteamID steamID, int n2) {
        return SteamNetworking.closeP2PChannelWithUser(this.pointer, steamID.handle, n2);
    }

    public boolean getP2PSessionState(SteamID steamID, P2PSessionState p2PSessionState) {
        return SteamNetworking.getP2PSessionState(this.pointer, steamID.handle, p2PSessionState);
    }

    public boolean allowP2PPacketRelay(boolean bl2) {
        return SteamNetworking.allowP2PPacketRelay(this.pointer, bl2);
    }

    private static native long createCallback(SteamNetworkingCallbackAdapter var0);

    private static native boolean sendP2PPacket(long var0, long var2, ByteBuffer var4, int var5, int var6, int var7, int var8);

    private static native boolean isP2PPacketAvailable(long var0, int[] var2, int var3);

    private static native boolean readP2PPacket(long var0, ByteBuffer var2, int var3, int var4, int[] var5, long[] var6, int var7);

    private static native boolean acceptP2PSessionWithUser(long var0, long var2);

    private static native boolean closeP2PSessionWithUser(long var0, long var2);

    private static native boolean closeP2PChannelWithUser(long var0, long var2, int var4);

    private static native boolean getP2PSessionState(long var0, long var2, P2PSessionState var4);

    private static native boolean allowP2PPacketRelay(long var0, boolean var2);

    public static class P2PSessionState {
        byte connectionActive;
        byte connecting;
        byte sessionError;
        byte usingRelay;
        int bytesQueuedForSend;
        int packetsQueuedForSend;
        int remoteIP;
        short remotePort;

        public boolean isConnectionActive() {
            return this.connectionActive != 0;
        }

        public boolean isConnecting() {
            return this.connecting != 0;
        }

        public P2PSessionError getLastSessionError() {
            return P2PSessionError.byOrdinal(this.sessionError);
        }

        public boolean isUsingRelay() {
            return this.usingRelay != 0;
        }

        public int getBytesQueuedForSend() {
            return this.bytesQueuedForSend;
        }

        public int getPacketsQueuedForSend() {
            return this.packetsQueuedForSend;
        }

        public int getRemoteIP() {
            return this.remoteIP;
        }

        public short getRemotePort() {
            return this.remotePort;
        }
    }

    public static enum P2PSessionError {
        None,
        NotRunningApp,
        NoRightsToApp,
        DestinationNotLoggedIn,
        Timeout;

        private static final P2PSessionError[] values;

        public static P2PSessionError byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = P2PSessionError.values();
        }
    }

    public static enum P2PSend {
        Unreliable,
        UnreliableNoDelay,
        Reliable,
        ReliableWithBuffering;

    }
}

