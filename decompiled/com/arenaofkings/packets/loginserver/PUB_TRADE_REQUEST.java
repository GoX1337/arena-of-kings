/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TRADE_REQUEST
extends PublicPacket {
    public String inviter_name;

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            wg2.a("[RARITY_LEGENDARY]" + this.inviter_name + " is requesting to trade.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_h);
            ay.ay_a().gd_a().ca_a().b(this.inviter_name);
            engine.var_baa_a.a(ajw.ku, 0.8f);
        }
    }
}

