/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TRADE_SILVER_OFFER
extends PublicPacket {
    public int amount;
    public boolean me;

    @Override
    public void handle(Engine engine) {
        engine.var_baa_a.a(ajw.jU);
        engine.var_baa_a.a(ajw.jW);
        if (this.me) {
            ay.ay_a().gd_a().ca_a().a(this.amount);
        } else {
            ay.ay_a().gd_a().ca_a().b(this.amount);
            if (t.a(we.class, engine)) {
                we we2 = (we)engine.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a("[RED]Careful! Items were modified in Trade.");
            }
        }
    }
}

