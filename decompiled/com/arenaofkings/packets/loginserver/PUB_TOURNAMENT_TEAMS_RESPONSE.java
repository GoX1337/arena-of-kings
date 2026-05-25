/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_TOURNAMENT_TEAMS_RESPONSE
extends PublicPacket {
    private ArrayList<String> team_name_tag = new ArrayList();

    @Override
    public void handle(Engine engine) {
        we we2 = (we)engine.axc_a();
        wg wg2 = we2.wh_a().wg_a();
        String string = "There are " + this.team_name_tag.size() + " teams registered.\n";
        for (String string2 : this.team_name_tag) {
            string = string + string2;
        }
        wg2.a(string);
    }
}

