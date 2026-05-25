/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.resources;

import com.arenaofkings.packets.gameserver.data.resources.Resource;

public class Energy
extends Resource {
    private int combo_points = 0;

    public Energy() {
    }

    public Energy(double d2, double d3) {
        super(d2, d3);
        this.resourceType = gx.d;
        this.combo_points = 0;
    }

    public Energy(Energy energy) {
        super(energy.getCurrentValue(), energy.getMaxValue());
        this.resourceType = gx.d;
        this.combo_points = energy.combo_points;
    }

    public int getCombo_points() {
        return this.combo_points;
    }

    public void setCombo_points(int n2) {
        this.combo_points = n2;
    }

    @Override
    public void onTick() {
        this.grantValue(10.0);
    }
}

