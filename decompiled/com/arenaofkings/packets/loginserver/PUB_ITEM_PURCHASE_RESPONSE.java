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

public class PUB_ITEM_PURCHASE_RESPONSE
extends PublicPacket {
    ItemData itemData;
    int newSilver;
    int position;

    @Override
    public void handle(Engine engine) {
        if (this.itemData.getItemLocation() == ItemLocation.INVENTORY) {
            fm fm2 = null;
            switch (this.itemData.getItemSlot()) {
                case HEAD: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case SHOULDER: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case CHEST: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case HANDS: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case WRIST: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case LEGS: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case FEET: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case BACK: {
                    fm2 = new fv(this.itemData);
                    break;
                }
                case NECK: {
                    fm2 = new fy(this.itemData);
                    break;
                }
                case RING: {
                    fm2 = new fy(this.itemData);
                    break;
                }
                case TRINKET: {
                    fm2 = new fy(this.itemData);
                    break;
                }
                case WEAPON: {
                    fm2 = new ga(this.itemData);
                    break;
                }
                case CONSUMABLE: {
                    fm2 = new fx(this.itemData);
                    break;
                }
            }
            if (fm2 != null) {
                fm2.c(true);
                ay.ay_a().gd_a().as_a().a().set(this.itemData.getItemPosition(), fm2);
                if (t.a(we.class, engine) && ay.ay_a().gd_a().int_a() != this.newSilver) {
                    PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[AOK_GOLD_GAIN]You receive " + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()) + "[[" + fm2.fp_a().java_lang_String_a() + "][].");
                    pUB_MISC_CHAT_MESSAGE.channel = " ";
                    ItemLocale itemLocale = new ItemLocale(this.itemData, 0, 0);
                    itemLocale.linkLeft = 27 + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()).length();
                    itemLocale.linkRight = 27 + ItemRarity.getColorCode(fm2.com_arenaofkings_packets_misc_items_ItemRarity_a()).length() + fm2.fp_a().java_lang_String_a().length() + 3;
                    pUB_MISC_CHAT_MESSAGE.itemData.add(itemLocale);
                    ((we)engine.axc_a()).wh_a().wg_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                }
                engine.var_baa_a.a(fm2.ajw_a(), fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
                if (fm2.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.RARE) {
                    engine.var_baa_a.a(ajw.kq, fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
                } else if (fm2.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.EPIC) {
                    engine.var_baa_a.a(ajw.kr, fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
                } else if (fm2.com_arenaofkings_packets_misc_items_ItemRarity_a() == ItemRarity.LEGENDARY) {
                    engine.var_baa_a.a(ajw.ks, fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
                }
                if (this.position >= 0) {
                    ay.ay_a().gd_a().cg_a().a(this.position);
                } else {
                    engine.var_baa_a.a(ajw.kp, fm2.com_arenaofkings_packets_misc_items_ItemRarity_a());
                }
                ay.ay_a().gd_a().f(this.newSilver);
            }
        }
    }
}

