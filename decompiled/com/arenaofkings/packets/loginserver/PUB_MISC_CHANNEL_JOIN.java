/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_MISC_CHANNEL_JOIN
extends PublicPacket {
    private String channel_name;
    private ArrayList<String> channelPlayer = new ArrayList();
    private int ordinal;

    @Override
    public void handle(Engine engine) {
        Engine.a("channel join: " + this.channel_name + " ordinal : " + this.ordinal);
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            en en2 = new en(ay.ay_a().gd_a().ev_a(), this.channel_name, this.ordinal, fd.e, engine);
            ay.ay_a().gd_a().ev_a().a(en2);
            ay.ay_a().gd_a().ev_a().a(we2.axm_a().com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c));
            int n2 = 0;
            for (String string : this.channelPlayer) {
                en2.a(new ew(string, n2++));
            }
            ay.ay_a().gd_a().ev_a().void_a(this.channel_name);
        }
    }
}

