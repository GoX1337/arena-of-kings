/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public class SteamMatchmakingServerNetAdr {
    short connectionPort;
    short queryPort;
    int ip;

    SteamMatchmakingServerNetAdr() {
    }

    public SteamMatchmakingServerNetAdr(int n2, short s2, short s3) {
        this.ip = n2;
        this.queryPort = s2;
        this.connectionPort = s3;
    }

    public short getConnectionPort() {
        return this.connectionPort;
    }

    public short getQueryPort() {
        return this.queryPort;
    }

    public int getIP() {
        return this.ip;
    }

    public String getConnectionAddressString() {
        return SteamMatchmakingServerNetAdr.toString(this.ip, this.connectionPort);
    }

    public String getQueryAddressString() {
        return SteamMatchmakingServerNetAdr.toString(this.ip, this.queryPort);
    }

    private static String toString(int n2, short s2) {
        return String.format("%d.%d.%d.%d:%d", n2 >> 24 & 0xFF, n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, s2);
    }
}

