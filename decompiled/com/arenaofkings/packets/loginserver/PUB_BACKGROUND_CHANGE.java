/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ProfileBackgrounds;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_BACKGROUND_CHANGE
extends PublicPacket {
    public ProfileBackgrounds profileBackground;
    public String character_name;

    @Override
    public void handle(Engine engine) {
        Engine.a("background change for: " + this.character_name + " " + (Object)((Object)this.profileBackground));
        ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(this.profileBackground);
        ay.ay_a().br_a(this.character_name).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(false);
    }
}

