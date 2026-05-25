/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.chat.Chat;
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.ReadyStatus;

public class PUB_READY_UPDATE
extends PublicPacket {
    private String player_name;
    private ReadyStatus readyStatus;

    @Override
    public void handle(Engine engine) {
        Engine.a("new ready status : " + this.player_name + " " + (Object)((Object)this.readyStatus));
        br br2 = ay.ay_a().br_a(this.player_name);
        if (br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a() != null) {
            Engine.a("set ready status: " + (Object)((Object)this.readyStatus));
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(this.readyStatus);
            switch (this.readyStatus) {
                case GREEN: {
                    ay.ay_a().gf_a().a(1);
                    break;
                }
                case RED: {
                    ay.ay_a().gf_a().a(1);
                    break;
                }
                case YELLOW: {
                    ay.ay_a().gf_a().a(2);
                    break;
                }
            }
        }
        if (this.player_name.equals("EVERYBODYCHANGEREADY")) {
            ay.ay_a().gd_a().j(3);
            if (t.a(we.class, engine)) {
                Object object2;
                for (Object object2 : ay.ay_a().gf_a().a().values()) {
                    ((br)object2).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(this.readyStatus);
                }
                we we2 = (we)engine.axc_a();
                object2 = we2.wh_a().wg_a();
                ((Chat)object2).a("[AOK_BLUE]Searching for a worthy opponent...");
                we2.wh_a().a("3v3 Ranked Solo");
                engine.var_baa_a.a(ajw.kw, 0.6f);
                ay.ay_a().gd_a().azv_b().d();
            }
        }
    }
}

