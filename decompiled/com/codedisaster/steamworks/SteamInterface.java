/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamException;
import java.nio.Buffer;

abstract class SteamInterface {
    protected final long pointer;
    protected long callback;

    SteamInterface(long l2) {
        this(l2, 0L);
    }

    SteamInterface(long l2, long l3) {
        if (l2 == 0L) {
            throw new RuntimeException("Steam interface created with null pointer. Always check result of SteamAPI.init(), or with SteamAPI.isSteamRunning()!");
        }
        this.pointer = l2;
        this.callback = l3;
    }

    void setCallback(long l2) {
        this.callback = l2;
    }

    public void dispose() {
        SteamInterface.deleteCallback(this.callback);
    }

    void checkBuffer(Buffer buffer) {
        if (!buffer.isDirect()) {
            throw new SteamException("Direct buffer required.");
        }
    }

    void checkArray(byte[] byArray, int n2) {
        if (byArray.length < n2) {
            throw new SteamException("Array too small, " + byArray.length + " found but " + n2 + " expected.");
        }
    }

    protected static native void deleteCallback(long var0);
}

