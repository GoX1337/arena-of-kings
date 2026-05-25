/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.ItemAttributes;
import com.arenaofkings.packets.misc.items.ItemModData;
import com.arenaofkings.packets.misc.items.ItemRarity;

public class ItemModifier {
    protected ItemRarity rarity;
    protected ItemAttributes attribute;
    protected float value;

    public ItemModifier() {
    }

    public ItemModifier(ItemRarity itemRarity, ItemAttributes itemAttributes, float f2) {
        this.rarity = itemRarity;
        this.attribute = itemAttributes;
        this.value = f2;
    }

    public ItemModifier(ItemModData itemModData) {
        this.rarity = ItemRarity.valueOf(itemModData.rarity);
        this.attribute = ItemAttributes.valueOf(itemModData.attribute);
        this.value = itemModData.value;
    }

    public ItemAttributes getAttribute() {
        return this.attribute;
    }

    public ItemRarity getRarity() {
        return this.rarity;
    }

    public int getValue() {
        return (int)this.value;
    }

    public float getFloatValue() {
        return this.value;
    }

    public void addValue(float f2) {
        this.value += f2;
    }

    public void subtractValue(float f2) {
        this.value -= f2;
    }

    public String toString() {
        return "ItemModifier [rarity=" + (Object)((Object)this.rarity) + ", attribute=" + (Object)((Object)this.attribute) + ", value=" + this.value + "]";
    }
}

