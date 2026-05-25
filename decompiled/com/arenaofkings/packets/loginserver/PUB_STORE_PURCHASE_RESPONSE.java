/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.StorePayableItem;

public class PUB_STORE_PURCHASE_RESPONSE
extends PublicPacket {
    private StorePayableItem storePayableItem;
    private int villainCoinsTotal;
    private boolean unlock;

    public PUB_STORE_PURCHASE_RESPONSE() {
    }

    public PUB_STORE_PURCHASE_RESPONSE(StorePayableItem storePayableItem, int n2, boolean bl2) {
        this.storePayableItem = storePayableItem;
        this.villainCoinsTotal = n2;
        this.unlock = bl2;
    }

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().g(this.villainCoinsTotal);
        if (this.unlock) {
            if (t.a(we.class, engine)) {
                we we2 = (we)engine.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                if (this.storePayableItem == StorePayableItem.MEMBERSHIP_1 || this.storePayableItem == StorePayableItem.MEMBERSHIP_2 || this.storePayableItem == StorePayableItem.MEMBERSHIP_3) {
                    wg2.a("[GREEN]You are now a Subscribed Member! Please relog to update your client.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_c);
                    ay.ay_a().gd_a().b(true);
                } else if (this.storePayableItem == StorePayableItem.GAME_STANDARD_EDITION) {
                    ay.ay_a().gd_a().a(engine, abi.ar);
                    wg2.a("[AOK_GOLD_GAIN]All Spells and Abilities unlocked!");
                    ay.ay_a().gd_a().i(3);
                    wg2.a("[AOK_GOLD_GAIN]3 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(1);
                    wg2.a("[AOK_GOLD_GAIN]1 Stash Tab added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You received 700 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else if (this.storePayableItem == StorePayableItem.GAME_EPIC_EDITION) {
                    ay.ay_a().gd_a().a(engine, abi.ar);
                    ay.ay_a().gd_a().a(engine, abi.as);
                    wg2.a("[AOK_GOLD_GAIN]All Spells and Abilities unlocked!");
                    ay.ay_a().gd_a().i(7);
                    wg2.a("[AOK_GOLD_GAIN]7 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(2);
                    wg2.a("[AOK_GOLD_GAIN]1 Stash Tab added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.z);
                    wg2.a("[AOK_GOLD_GAIN]Twilight Moon added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You received 1500 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else if (this.storePayableItem == StorePayableItem.GAME_LEGENDARY_EDITION) {
                    ay.ay_a().gd_a().a(engine, abi.ar);
                    ay.ay_a().gd_a().a(engine, abi.at);
                    wg2.a("[AOK_GOLD_GAIN]All Spells and Abilities unlocked!");
                    ay.ay_a().gd_a().i(12);
                    wg2.a("[AOK_GOLD_GAIN]12 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(3);
                    wg2.a("[AOK_GOLD_GAIN]3 Stash Tabs added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.z);
                    wg2.a("[AOK_GOLD_GAIN]Twilight Moon added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.T);
                    wg2.a("[AOK_GOLD_GAIN]Light Snow added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You have a gilded badge!");
                    wg2.a("[AOK_GOLD_GAIN]You received 5000 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else if (this.storePayableItem == StorePayableItem.GAME_STANDARD_TO_EPIC) {
                    ay.ay_a().gd_a().a(engine, abi.as);
                    wg2.a("[AOK_GOLD_GAIN]You upgraded to Epic Edition!");
                    ay.ay_a().gd_a().i(4);
                    wg2.a("[AOK_GOLD_GAIN]4 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(1);
                    wg2.a("[AOK_GOLD_GAIN]1 Stash Tab added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.z);
                    wg2.a("[AOK_GOLD_GAIN]Twilight Moon added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You received 800 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else if (this.storePayableItem == StorePayableItem.GAME_STANDARD_TO_LEGENDARY) {
                    ay.ay_a().gd_a().a(engine, abi.at);
                    wg2.a("[AOK_GOLD_GAIN]You upgraded to Legendary Edition!");
                    ay.ay_a().gd_a().i(9);
                    wg2.a("[AOK_GOLD_GAIN]9 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(2);
                    wg2.a("[AOK_GOLD_GAIN]2 Stash Tabs added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.z);
                    wg2.a("[AOK_GOLD_GAIN]Twilight Moon added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.T);
                    wg2.a("[AOK_GOLD_GAIN]Light Snow added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You received 4300 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else if (this.storePayableItem == StorePayableItem.GAME_EPIC_TO_LEGENDARY) {
                    ay.ay_a().gd_a().a(engine, abi.at);
                    wg2.a("[AOK_GOLD_GAIN]You upgraded to Legendary Edition!");
                    ay.ay_a().gd_a().i(5);
                    wg2.a("[AOK_GOLD_GAIN]5 Character Slots added to your collection!");
                    ay.ay_a().gd_a().bu_a().void_a(1);
                    wg2.a("[AOK_GOLD_GAIN]1 Stash Tab added to your collection!");
                    ay.ay_a().gd_a().a(engine, abi.T);
                    wg2.a("[AOK_GOLD_GAIN]Light Snow added to your collection!");
                    wg2.a("[AOK_GOLD_GAIN]You have a gilded badge!");
                    wg2.a("[AOK_GOLD_GAIN]You received 3500 Villain Coins.");
                    wg2.a("[AOK_GOLD_GAIN]Thank you for supporting development <3");
                } else {
                    wg2.a("[GREEN]You received " + StorePayableItem.getAmount(this.storePayableItem) + " Villain Coins!", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_c);
                }
                engine.var_baa_a.a(ajw.kz, 0.6f);
                engine.var_baa_a.a(ajw.ky, 0.6f);
            }
        } else if (t.a(we.class, engine)) {
            we we3 = (we)engine.axc_a();
            wg wg3 = we3.wh_a().wg_a();
            wg3.a("[ERROR]Unable to purchase item. Try relogging or checking your payment details.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
            engine.var_baa_a.a(ajw.kG, 0.6f);
        }
    }
}

