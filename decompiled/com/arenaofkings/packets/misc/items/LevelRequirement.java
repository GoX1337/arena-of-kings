/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemRequirement;

public class LevelRequirement
extends EquippableRequirement {
    protected int levelRequirement;

    public LevelRequirement() {
    }

    public LevelRequirement(int n2) {
        super(ItemRequirement.CHARACTER_LEVEL);
        this.levelRequirement = n2;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.levelRequirement);
    }

    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    public String toString() {
        return "LevelRequirement [levelRequirement=" + this.levelRequirement + "]";
    }
}

