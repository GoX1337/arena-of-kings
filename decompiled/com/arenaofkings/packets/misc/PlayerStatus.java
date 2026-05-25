/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc;

public enum PlayerStatus {
    AVAILABLE(0),
    QUEUED(1),
    BUSY(2),
    OFFLINE(3);

    private final int code;

    private PlayerStatus(int n3) {
        this.code = n3;
    }

    public int getCode() {
        return this.code;
    }
}

