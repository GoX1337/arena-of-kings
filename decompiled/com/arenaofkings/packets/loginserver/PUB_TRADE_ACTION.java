/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TRADE_ACTION
extends PublicPacket {
    public int action;

    @Override
    public void handle(Engine engine) {
        if (this.action != 1) {
            if (this.action == 2) {
                if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().ca_a() != null) {
                    ay.ay_a().gd_a().ca_a().b();
                    if (t.a(we.class, engine)) {
                        ((we)engine.axc_a()).wh_a().wg_a().a("[ERROR]Your trading session ended.");
                        engine.var_baa_a.a(ajw.kE, 0.4f);
                    }
                    ay.ay_a().gd_a().ca_a().a(false);
                }
            } else if (this.action != 3) {
                if (this.action == 4) {
                    if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().ca_a() != null) {
                        ay.ay_a().gd_a().ca_a().a(cf.d);
                        if (t.a(we.class, engine)) {
                            we we2 = (we)engine.axc_a();
                            wg wg2 = we2.wh_a().wg_a();
                            wg2.a("[RARITY_UNCOMMON]You accepted the Trade.");
                            engine.var_baa_a.a(ajw.kE, 0.4f);
                        }
                    }
                } else if (this.action == 5) {
                    if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().ca_a() != null) {
                        ay.ay_a().gd_a().ca_a().b(cf.d);
                        if (t.a(we.class, engine)) {
                            we we3 = (we)engine.axc_a();
                            wg wg3 = we3.wh_a().wg_a();
                            wg3.a("[RARITY_UNCOMMON]" + ay.ay_a().gd_a().ca_a().java_lang_String_a() + " accepted the Trade.");
                            engine.var_baa_a.a(ajw.kE, 0.4f);
                        }
                    }
                } else if (this.action == 6) {
                    if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().ca_a() != null) {
                        ay.ay_a().gd_a().ca_a().b();
                        if (t.a(we.class, engine)) {
                            ((we)engine.axc_a()).wh_a().wg_a().a("[ERROR]Failed to complete trade, I need more free space.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
                            engine.var_baa_a.a(ajw.kG, 0.4f);
                        }
                        ay.ay_a().gd_a().ca_a().a(false);
                    }
                } else if (this.action == 7) {
                    if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().ca_a() != null) {
                        ay.ay_a().gd_a().ca_a().b();
                        if (t.a(we.class, engine)) {
                            ((we)engine.axc_a()).wh_a().wg_a().a("[ERROR]Failed to complete trade, player has no free space.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
                            engine.var_baa_a.a(ajw.kG, 0.4f);
                        }
                        ay.ay_a().gd_a().ca_a().a(false);
                    }
                } else if (this.action != 8 && this.action == 99) {
                    if (t.a(we.class, engine)) {
                        ((we)engine.axc_a()).wh_a().wg_a().a("[ERROR]The trade was changed recently. For your safety, check the items and try again.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a);
                    }
                    engine.var_baa_a.a(ajw.kG, 0.4f);
                }
            }
        }
    }
}

