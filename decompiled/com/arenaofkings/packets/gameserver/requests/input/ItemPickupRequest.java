/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;

public class ItemPickupRequest
extends PublicPacket {
    public int itemID;
    public boolean stash;

    @Override
    public void handle(Engine engine) {
        if (t.a(agd.class, engine)) {
            PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE;
            fj fj2 = ((agd)engine.axc_a()).aga_a().a(engine, this.itemID);
            if (fj2 != null && fj2.b()) {
                engine.var_baa_a.a(ajw.jZ);
                fj2.fm_a().c(true);
                if (this.stash) {
                    pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[GREEN]Item delivered to your Stash.");
                    pUB_MISC_CHAT_MESSAGE.channel = " ";
                    ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
                    ay.ay_a().gd_a().bu_a().a(fj2.fm_a());
                } else {
                    ay.ay_a().gd_a().as_a().a(fj2.fm_a());
                }
            }
            if (fj2 != null && !fj2.b()) {
                pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[RED]That item is not reserved to you.");
                pUB_MISC_CHAT_MESSAGE.channel = " ";
                ((agd)engine.axc_a()).agn_a().i_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
            }
        }
    }
}

