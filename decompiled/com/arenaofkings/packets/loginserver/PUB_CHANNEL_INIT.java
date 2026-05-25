/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_CHANNEL_INIT
extends PublicPacket {
    String channelName;
    ArrayList<String> playerNames = new ArrayList();

    @Override
    public void handle(Engine engine) {
        Engine.b("PUB_CHANNEL_INIT: " + this.playerNames.size());
        en en2 = ay.ay_a().gd_a().ev_a().en_a(this.channelName);
        if (en2 == null) {
            en2 = this.channelName.equals("Game") ? new en(ay.ay_a().gd_a().ev_a(), "Game", 0, fd.d, engine) : new en(ay.ay_a().gd_a().ev_a(), this.channelName, 1, fd.e, engine);
            ay.ay_a().gd_a().ev_a().a(en2);
        } else {
            en2.a().clear();
        }
        for (String string : this.playerNames) {
            en2.a(string);
        }
    }
}

