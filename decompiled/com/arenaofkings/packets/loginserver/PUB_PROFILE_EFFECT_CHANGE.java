/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_PROFILE_EFFECT_CHANGE
extends PublicPacket {
    private String profileEffect;
    private int number;
    private String character_name;

    public PUB_PROFILE_EFFECT_CHANGE() {
    }

    public PUB_PROFILE_EFFECT_CHANGE(String string, int n2, String string2) {
        this.profileEffect = string;
        this.number = n2;
        this.character_name = string2;
    }

    @Override
    public void handle(Engine engine) {
        Engine.a("profile effect change for: " + this.character_name + " " + this.profileEffect);
        if (this.number == -1) {
            ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profileEffect), 1);
            ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profileEffect), 2);
            ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profileEffect), 3);
        } else {
            ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(abi.valueOf(this.profileEffect), this.number);
        }
    }
}

