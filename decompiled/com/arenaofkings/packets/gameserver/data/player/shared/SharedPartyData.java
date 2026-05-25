/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.player.shared;

public abstract class SharedPartyData {
    protected int partyNumber;

    public SharedPartyData() {
    }

    public SharedPartyData(int n2) {
        this.partyNumber = n2;
    }

    public int getPartyNumber() {
        return this.partyNumber;
    }
}

