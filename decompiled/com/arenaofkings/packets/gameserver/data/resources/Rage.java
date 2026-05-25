/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.resources;

import com.arenaofkings.packets.gameserver.data.resources.Resource;

public class Rage
extends Resource {
    public Rage() {
    }

    public Rage(double d2, double d3) {
        super(d2, d3);
        this.resourceType = gx.e;
    }

    public Rage(Rage rage) {
        super(rage.getCurrentValue(), rage.getMaxValue());
        this.resourceType = gx.e;
    }

    @Override
    public void onTick() {
    }
}

