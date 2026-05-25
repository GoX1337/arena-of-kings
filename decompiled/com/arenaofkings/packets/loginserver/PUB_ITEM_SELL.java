/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.items.ItemData;
import com.arenaofkings.packets.misc.items.ItemLocale;
import com.arenaofkings.packets.misc.items.ItemLocation;
import com.arenaofkings.packets.misc.items.ItemRarity;

public class PUB_ITEM_SELL
extends PublicPacket {
    int newSilver;
    ItemLocation itemLocation;
    int itemPosition;
    int stashTabIndex;

    @Deprecated
    public PUB_ITEM_SELL() {
    }

    public PUB_ITEM_SELL(ItemLocation itemLocation, int n2, int n3) {
        this.itemLocation = itemLocation;
        this.itemPosition = n2;
        this.stashTabIndex = n3;
    }

    @Override
    public void handle(Engine engine) {
        Engine.b("new sell: " + (Object)((Object)this.itemLocation) + " " + this.itemPosition);
        ff ff2 = new ff(this.itemLocation, this.itemPosition);
        if (this.itemLocation == ItemLocation.INVENTORY) {
            fm fm2 = ay.ay_a().gd_a().as_a().a().get(this.itemPosition);
            if (fm2 == null || fm2 instanceof ff) {
                return;
            }
            ItemData itemData = null;
            if (fm2 instanceof fv) {
                itemData = new ItemData((fv)fm2);
            } else if (fm2 instanceof ga) {
                itemData = new ItemData((ga)fm2);
            } else if (fm2 instanceof fy) {
                itemData = new ItemData((fy)fm2);
            }
            if (itemData == null) {
                engine.var_z_a.d();
                return;
            }
            PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[AOK_GOLD_GAIN]You sold " + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()) + "[[" + fm2.fp_a().java_lang_String_a() + "][AOK_GOLD_GAIN] for []" + (this.newSilver - ay.ay_a().gd_a().int_a()) + " Silver.");
            pUB_MISC_CHAT_MESSAGE.channel = " ";
            ItemLocale itemLocale = new ItemLocale(itemData, 0, 0);
            itemLocale.linkLeft = 24 + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()).length();
            itemLocale.linkRight = 24 + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()).length() + fm2.fp_a().java_lang_String_a().length() + 3;
            pUB_MISC_CHAT_MESSAGE.itemData.add(itemLocale);
            ((we)engine.axc_a()).wh_a().wg_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
            ay.ay_a().gd_a().as_a().a().set(this.itemPosition, ff2);
        } else if (this.itemLocation == ItemLocation.STASH) {
            fm fm3 = ay.ay_a().gd_a().bu_a().fm_a(this.stashTabIndex, this.itemPosition);
            if (fm3 == null || fm3 instanceof ff) {
                return;
            }
            ItemData itemData = null;
            if (fm3 instanceof fv) {
                itemData = new ItemData((fv)fm3);
            } else if (fm3 instanceof ga) {
                itemData = new ItemData((ga)fm3);
            } else if (fm3 instanceof fy) {
                itemData = new ItemData((fy)fm3);
            }
            PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[AOK_GOLD_GAIN]You sold " + ItemRarity.getColorCode(fm3.com_arenaofkings_packets_misc_items_ItemRarity_a()) + "[[" + fm3.fp_a().java_lang_String_a() + "][AOK_GOLD_GAIN] for []" + (this.newSilver - ay.ay_a().gd_a().int_a()) + " Silver.");
            pUB_MISC_CHAT_MESSAGE.channel = " ";
            ItemLocale itemLocale = new ItemLocale(itemData, 0, 0);
            itemLocale.linkLeft = 24 + ItemRarity.getColorCode(fm3.com_arenaofkings_packets_misc_items_ItemRarity_a()).length();
            itemLocale.linkRight = 24 + ItemRarity.getColorCode(fm3.com_arenaofkings_packets_misc_items_ItemRarity_a()).length() + fm3.fp_a().java_lang_String_a().length() + 3;
            pUB_MISC_CHAT_MESSAGE.itemData.add(itemLocale);
            ((we)engine.axc_a()).wh_a().wg_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
            ay.ay_a().gd_a().bu_a().a(ff2, this.itemPosition, this.stashTabIndex);
        }
        ay.ay_a().gd_a().f(this.newSilver);
        engine.var_baa_a.a(ajw.jU);
        engine.var_baa_a.a(ajw.jW);
    }
}

