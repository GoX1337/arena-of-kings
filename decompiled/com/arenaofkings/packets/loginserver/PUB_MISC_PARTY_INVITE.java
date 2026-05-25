/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.PUB_MISC_CHAT_MESSAGE;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_MISC_PARTY_INVITE
extends PublicPacket {
    private String inviter_name;
    private int partyType;

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            ay.ay_a().gd_a().as_a().f();
            ay.ay_a().gd_a().bu_a().void_c();
            PUB_MISC_CHAT_MESSAGE pUB_MISC_CHAT_MESSAGE = new PUB_MISC_CHAT_MESSAGE(" ", "[AOK_PARTY]" + this.inviter_name + " has invited you to a Party!");
            pUB_MISC_CHAT_MESSAGE.channel = " ";
            ((we)engine.axc_a()).wh_a().wg_a().a(pUB_MISC_CHAT_MESSAGE, " ", true);
            ((we)engine.axc_a()).wh_a().gg_a().a(this.inviter_name);
            wh wh2 = (wh)engine.axc_a().aya_a();
            wh2.yp_a().a(this.partyType);
            engine.var_baa_a.a(ajw.ku, 0.8f);
        }
    }
}

