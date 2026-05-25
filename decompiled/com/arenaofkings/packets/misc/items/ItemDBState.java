/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

public enum ItemDBState {
    REQUIRES_INSERT(3),
    REQUIRES_UPDATE(2),
    MARKED_FOR_DELETION(1),
    SYNCHRONIZED(0);

    private int dbvalue;

    private ItemDBState(int n3) {
        this.dbvalue = n3;
    }

    public int getDbvalue() {
        return this.dbvalue;
    }
}

