/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_SPELL_CHANGE
extends PublicPacket {
    private String character_name;
    private int spell_slot;
    private String spell_name;

    public PUB_SPELL_CHANGE() {
    }

    public PUB_SPELL_CHANGE(String string, int n2, String string2) {
        this.character_name = string;
        this.spell_slot = n2;
        this.spell_name = string2;
    }

    @Override
    public void handle(Engine engine) {
        br br2 = ay.ay_a().br_a(this.character_name);
        if (br2 == ay.ay_a()) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(this.spell_name, this.spell_slot + 1);
        } else if (br2 != null) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(this.spell_name, this.spell_slot);
        } else {
            Engine.a("[ERROR] PUB_SPELL_CHANGE Player is null");
        }
    }
}

