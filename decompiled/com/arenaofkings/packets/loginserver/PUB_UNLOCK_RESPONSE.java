/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_UNLOCK_RESPONSE
extends PublicPacket {
    private String item;
    private int villainCoinsTotal;
    private int silverTotal;
    private int abilityEssenceTotal;
    private boolean unlock;

    @Override
    public void handle(Engine engine) {
        ay.ay_a().gd_a().g(this.villainCoinsTotal);
        ay.ay_a().gd_a().f(this.silverTotal);
        ay.ay_a().gd_a().a(this.abilityEssenceTotal);
        abi abi2 = abi.valueOf(this.item);
        if (this.unlock) {
            if (t.a(we.class, engine)) {
                we we2 = (we)engine.axc_a();
                wg wg2 = we2.wh_a().wg_a();
                wg2.a("[AOK_GOLD_GAIN]" + abi2.getContent() + " added to your collection!");
                engine.var_baa_a.a(ajw.kz, 0.6f);
                if (abi2 == abi.ak) {
                    ay.ay_a().gd_a().bu_a().void_a(1);
                } else if (abi2 == abi.al) {
                    ay.ay_a().gd_a().bu_a().void_a(3);
                }
            }
            ay.ay_a().gd_a().a(engine, abi2);
        } else if (t.a(we.class, engine)) {
            we we3 = (we)engine.axc_a();
            wg wg3 = we3.wh_a().wg_a();
            wg3.a("[RED]Unable to purchase " + abi2.getContent() + ".");
            engine.var_baa_a.a(ajw.kG, 0.6f);
        }
    }
}

