/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.ItemRequirement;

public abstract class EquippableRequirement {
    protected ItemRequirement requirement;

    public EquippableRequirement() {
    }

    public EquippableRequirement(ItemRequirement itemRequirement) {
        this.requirement = itemRequirement;
    }

    public ItemRequirement getRequirement() {
        return this.requirement;
    }

    public abstract String getValue();
}

