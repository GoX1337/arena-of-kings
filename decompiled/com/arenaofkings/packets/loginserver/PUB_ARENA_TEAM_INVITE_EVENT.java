/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_INVITE_EVENT
extends PublicPacket {
    private String inviter_name;
    private String team_name;
    private String tag;

    public PUB_ARENA_TEAM_INVITE_EVENT() {
    }

    public PUB_ARENA_TEAM_INVITE_EVENT(String string, String string2, String string3) {
        this.inviter_name = string;
        this.team_name = string2;
        this.tag = string3;
    }

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            ay.ay_a().gd_a().as_a().f();
            ay.ay_a().gd_a().bu_a().void_c();
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            wg2.a("[AOK_BLUE]" + this.inviter_name + " has invited you to " + this.team_name + "[" + this.tag + "]", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
            ((we)engine.axc_a()).wh_a().gl_a().a(this.inviter_name);
            engine.var_baa_a.a(ajw.ku, 0.8f);
        }
    }
}

