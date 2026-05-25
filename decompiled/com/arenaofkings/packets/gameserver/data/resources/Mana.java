/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.resources;

import com.arenaofkings.packets.gameserver.data.resources.Resource;

public class Mana
extends Resource {
    private dc mana;
    private dc manaRegen;
    private int baseMana;

    public Mana() {
    }

    public Mana(int n2, dc dc2, dc dc3) {
        super((double)n2 + dc2.double_a(), (double)n2 + dc2.double_a());
        this.resourceType = gx.c;
        this.mana = dc2;
        this.manaRegen = dc3;
        this.baseMana = n2;
    }

    public Mana(int n2, dc dc2, dc dc3, boolean bl2) {
        super(n2, n2);
        this.resourceType = gx.c;
        this.mana = dc2;
        this.manaRegen = dc3;
        this.baseMana = n2;
    }

    public Mana(Mana mana, dc dc2, dc dc3) {
        super(mana.getCurrentValue(), mana.getMaxValue());
        this.resourceType = gx.c;
        this.mana = dc2;
        this.manaRegen = dc3;
    }

    @Override
    public void onTick() {
        this.grantValue((this.mana.double_a() + (double)this.baseMana) * (this.manaRegen.double_a() / 100.0));
    }

    @Override
    public double getCurrentValue() {
        return super.getCurrentValue();
    }

    @Override
    public double getMaxValue() {
        return super.getMaxValue();
    }

    public void setValues() {
        this.maxValue = (double)this.baseMana + this.mana.double_a();
    }
}

