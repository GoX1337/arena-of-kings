/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemModifier;
import com.arenaofkings.packets.misc.items.ItemRarity;

public class ItemModData {
    protected String rarity;
    protected String attribute;
    protected int value;

    public ItemModData() {
    }

    public ItemModData(ItemModifier itemModifier) {
        this(itemModifier.rarity, itemModifier.attribute, (int)itemModifier.value);
    }

    public ItemModData(String string, String string2, int n2) {
        this.rarity = string;
        this.attribute = string2;
        this.value = n2;
    }

    public ItemModData(ItemRarity itemRarity, ItemAttributes itemAttributes, int n2) {
        this.rarity = itemRarity.name();
        this.attribute = itemAttributes.name();
        this.value = n2;
    }

    public String toString() {
        return "ItemModData [rarity=" + this.rarity + ", attribute=" + this.attribute + ", value=" + this.value + "]";
    }
}

