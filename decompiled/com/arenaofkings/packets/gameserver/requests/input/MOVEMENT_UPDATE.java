/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.requests.input.JAVA_16_GFX_CL$61892;
import com.arenaofkings.packets.misc.PublicPacket;

public class MOVEMENT_UPDATE
extends PublicPacket {
    protected String character_name;
    protected int x;
    protected int y;
    protected int SEQUENCE_NUMBER;
    protected Direction direction;

    public MOVEMENT_UPDATE() {
    }

    public MOVEMENT_UPDATE(String string, int n2, int n3, int n4, Direction direction) {
        this.character_name = string;
        this.SEQUENCE_NUMBER = n2;
        this.x = n3;
        this.y = n4;
        this.direction = direction;
    }

    @Override
    public void handle(Engine engine) {
        br br2 = ay.ay_a().br_a(this.character_name);
        if (br2 != null) {
            JAVA_16_GFX_CL$61892 jAVA_16_GFX_CL$61892 = new JAVA_16_GFX_CL$61892(this.SEQUENCE_NUMBER, this.x, this.y, this.direction);
            if (br2 == ay.ay_a() && this.SEQUENCE_NUMBER > 0) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().bp_a().a(jAVA_16_GFX_CL$61892);
            } else {
                if (this.direction != null) {
                    jAVA_16_GFX_CL$61892.f = cw.a(cw.e, this.direction);
                }
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().ar_a().a(jAVA_16_GFX_CL$61892);
            }
        }
    }
}

