/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLink;
import com.arenaofkings.packets.misc.items.ItemLocation;

public class ItemLocale {
    public ItemLocation itemLocation;
    public int itemPosition;
    public int stashTabIndex;
    public int linkLeft;
    public int linkRight;
    public String name;
    public boolean stale;
    public ItemData itemData;

    public ItemLocale() {
    }

    public ItemLocale(ItemData itemData, int n2, int n3) {
        this.itemData = itemData;
        this.itemLocation = itemData.getItemLocation();
        this.itemPosition = itemData.getItemPosition();
        this.stashTabIndex = itemData.getStashTabIndex();
        this.name = itemData.getName();
        this.stale = false;
        this.linkLeft = n2;
        this.linkRight = n3;
    }

    public ItemLocale(ItemLink itemLink) {
        Engine.b("itemLink data: " + itemLink);
        this.itemLocation = itemLink.item.com_arenaofkings_packets_misc_items_ItemLocation_a();
        this.itemPosition = itemLink.item.int_a();
        this.stashTabIndex = itemLink.item.int_d();
        this.linkLeft = itemLink.linkLeft;
        this.linkRight = itemLink.linkRight;
        this.name = itemLink.name;
    }

    public String toString() {
        return "ItemLocale [itemLocation=" + (Object)((Object)this.itemLocation) + ", itemPosition=" + this.itemPosition + ", linkLeft=" + this.linkLeft + ", linkRight=" + this.linkRight + ", name=" + this.name + ", stale=" + this.stale + ", itemData=" + this.itemData + "]";
    }
}

