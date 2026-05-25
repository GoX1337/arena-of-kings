/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_PLAY_READY
extends PublicPacket {
    @Override
    public void handle(Engine engine) {
        if (t.a(agd.class, engine)) {
            Engine.b("SETTING CINEMATIC");
            ((agd)engine.axc_a()).a(true);
            ay.ay_a().gd_a().as_a().b((fm)null);
        }
    }
}

