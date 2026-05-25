/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemArmorType;
import com.arenaofkings.packets.misc.items.ItemRequirement;

public class ArmorRequirement
extends EquippableRequirement {
    protected ItemArmorType armorType;

    public ArmorRequirement() {
    }

    public ArmorRequirement(ItemArmorType itemArmorType) {
        super(ItemRequirement.ARMOR_TYPE);
        this.armorType = itemArmorType;
    }

    public ItemArmorType getArmorType() {
        return this.armorType;
    }

    @Override
    public String getValue() {
        return String.valueOf((Object)this.armorType);
    }

    public String toString() {
        return "ArmorRequirement [armorType=" + (Object)((Object)this.armorType) + "]";
    }
}

