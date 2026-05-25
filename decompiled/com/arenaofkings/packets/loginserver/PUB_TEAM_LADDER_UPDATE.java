/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.LadderPlayerData;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_TEAM_LADDER_UPDATE
extends PublicPacket {
    ArrayList<LadderPlayerData> data = new ArrayList();

    @Override
    public void handle(Engine engine) {
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            we2.wh_a().zi_a().zt_a().a(this.data);
        }
    }
}

