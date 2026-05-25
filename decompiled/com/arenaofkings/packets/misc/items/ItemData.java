/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.misc.items;

import com.arenaofkings.packets.misc.items.EquippableRequirement;
import com.arenaofkings.packets.misc.items.ItemDBState;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemModData;
import com.arenaofkings.packets.misc.items.ItemModifier;
import com.arenaofkings.packets.misc.items.ItemRarity;
import com.arenaofkings.packets.misc.items.ItemSlot;
import java.util.ArrayList;

public class ItemData {
    public String name;
    public int itemID;
    public String accountBoundName = "";
    public int accountBoundID = 0;
    public String characterBoundName = "";
    public int characterBoundID = 0;
    public String itemRarity;
    public String itemBase;
    public int augment;
    public ItemSlot itemSlot;
    public ItemLocation itemLocation;
    protected int stashTabIndex;
    public int itemPosition;
    protected String bottomFlavorText = "";
    public ArrayList<ItemModData> itemModifiers = new ArrayList();
    public ArrayList<EquippableRequirement> requirements = new ArrayList();
    public ItemModData baseMod1;
    public ItemModData baseMod2;
    public ItemDBState itemDBState;

    public ItemData() {
    }

    public ItemData(fp fp2, ItemRarity itemRarity) {
        this.name = fp2.java_lang_String_a();
        this.itemID = -1;
        this.itemRarity = itemRarity.name();
        this.itemBase = fp2.name();
        this.itemSlot = fp2.com_arenaofkings_packets_misc_items_ItemSlot_a();
        this.itemLocation = ItemLocation.INVENTORY;
    }

    public ItemData(fv fv2) {
        this.name = fv2.java_lang_String_a();
        this.itemID = -1;
        this.itemRarity = fv2.com_arenaofkings_packets_misc_items_ItemRarity_a().name();
        this.itemBase = String.valueOf((Object)fv2.fp_a());
        this.itemSlot = fv2.com_arenaofkings_packets_misc_items_ItemSlot_a();
        this.itemLocation = fv2.com_arenaofkings_packets_misc_items_ItemLocation_a();
        this.itemPosition = fv2.int_a();
        this.bottomFlavorText = fv2.java_lang_String_b();
        for (ItemModifier object : fv2.a()) {
            this.itemModifiers.add(new ItemModData(object));
        }
        this.baseMod1 = new ItemModData(fv2.com_arenaofkings_packets_misc_items_ItemModifier_a());
        this.baseMod2 = new ItemModData(fv2.com_arenaofkings_packets_misc_items_ItemModifier_b());
        for (EquippableRequirement equippableRequirement : fv2.b()) {
            this.requirements.add(equippableRequirement);
        }
        this.itemDBState = ItemDBState.SYNCHRONIZED;
    }

    public ItemData(fy fy2) {
        this.name = fy2.java_lang_String_a();
        this.itemID = -1;
        this.itemRarity = fy2.com_arenaofkings_packets_misc_items_ItemRarity_a().name();
        this.itemBase = String.valueOf((Object)fy2.fp_a());
        this.itemSlot = fy2.com_arenaofkings_packets_misc_items_ItemSlot_a();
        this.itemLocation = fy2.com_arenaofkings_packets_misc_items_ItemLocation_a();
        this.itemPosition = fy2.int_a();
        this.bottomFlavorText = fy2.java_lang_String_b();
        for (ItemModifier object : fy2.a()) {
            this.itemModifiers.add(new ItemModData(object));
        }
        if (fy2.com_arenaofkings_packets_misc_items_ItemModifier_a() != null) {
            this.baseMod1 = new ItemModData(fy2.com_arenaofkings_packets_misc_items_ItemModifier_a());
        }
        if (fy2.com_arenaofkings_packets_misc_items_ItemModifier_b() != null) {
            this.baseMod2 = new ItemModData(fy2.com_arenaofkings_packets_misc_items_ItemModifier_b());
        }
        for (EquippableRequirement equippableRequirement : fy2.b()) {
            this.requirements.add(equippableRequirement);
        }
        this.itemDBState = ItemDBState.SYNCHRONIZED;
    }

    public ItemData(ga ga2) {
        this.name = ga2.java_lang_String_a();
        this.itemID = -1;
        this.itemRarity = ga2.com_arenaofkings_packets_misc_items_ItemRarity_a().name();
        this.itemBase = String.valueOf((Object)ga2.fp_a());
        this.itemSlot = ga2.com_arenaofkings_packets_misc_items_ItemSlot_a();
        this.itemLocation = ga2.com_arenaofkings_packets_misc_items_ItemLocation_a();
        this.itemPosition = ga2.int_a();
        this.bottomFlavorText = ga2.java_lang_String_b();
        for (ItemModifier object : ga2.a()) {
            this.itemModifiers.add(new ItemModData(object));
        }
        if (ga2.com_arenaofkings_packets_misc_items_ItemModifier_a() != null) {
            this.baseMod1 = new ItemModData(ga2.com_arenaofkings_packets_misc_items_ItemModifier_a());
        }
        if (ga2.com_arenaofkings_packets_misc_items_ItemModifier_b() != null) {
            this.baseMod2 = new ItemModData(ga2.com_arenaofkings_packets_misc_items_ItemModifier_b());
        }
        for (EquippableRequirement equippableRequirement : ga2.b()) {
            this.requirements.add(equippableRequirement);
        }
        this.itemDBState = ItemDBState.SYNCHRONIZED;
    }

    public String getName() {
        return this.name;
    }

    public String getItemBase() {
        return this.itemBase;
    }

    public void setBaseMod1(ItemModData itemModData) {
        this.baseMod1 = itemModData;
    }

    public void setBaseMod2(ItemModData itemModData) {
        this.baseMod2 = itemModData;
    }

    public ItemModData getBaseMod1() {
        return this.baseMod1;
    }

    public ItemModData getBaseMod2() {
        return this.baseMod2;
    }

    public ItemLocation getItemLocation() {
        return this.itemLocation;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public ArrayList<ItemModData> getItemModifiers() {
        return this.itemModifiers;
    }

    public String getItemRarity() {
        return this.itemRarity;
    }

    public ItemSlot getItemSlot() {
        return this.itemSlot;
    }

    public String getBottomFlavorText() {
        return this.bottomFlavorText;
    }

    public ArrayList<EquippableRequirement> getRequirements() {
        return this.requirements;
    }

    public int getStashTabIndex() {
        return this.stashTabIndex;
    }

    public void setStashTabIndex(int n2) {
        this.stashTabIndex = n2;
    }

    public String toString() {
        return "ItemData [name=" + this.name + ", itemID=" + this.itemID + ", itemRarity=" + this.itemRarity + ", itemBase=" + this.itemBase + ", augment=" + this.augment + ", itemSlot=" + (Object)((Object)this.itemSlot) + ", itemLocation=" + (Object)((Object)this.itemLocation) + ", stashTabIndex=" + this.stashTabIndex + ", itemPosition=" + this.itemPosition + "]";
    }
}

