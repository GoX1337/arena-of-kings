/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data;

public abstract class Effect {
    protected azv timer;

    public Effect(int n2) {
        this.timer = new azv(n2, true);
    }

    public void update(br br2) {
    }

    public azv getTimer() {
        return this.timer;
    }

    public void setTimer(azv azv2) {
        this.timer = azv2;
    }
}

