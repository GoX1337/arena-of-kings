/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_OUTFIT_CHANGE
extends PublicPacket {
    private int outfitNumber;
    private String character_name;

    public PUB_OUTFIT_CHANGE() {
    }

    public PUB_OUTFIT_CHANGE(int n2, String string) {
        this.outfitNumber = n2;
        this.character_name = string;
    }

    @Override
    public void handle(Engine engine) {
        br br2 = (br)ay.ay_a().gf_a().a().get(this.character_name);
        if (br2 != null) {
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(this.character_name)) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().g(this.outfitNumber);
                Engine.a("PRE print");
                engine.h();
                if (br2 == ay.ay_a()) {
                    ((we)engine.axc_a()).wh_a().ya_a().ayo_a().a(this.outfitNumber);
                }
                for (ajw ajw2 : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                    engine.b(ajw2);
                }
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(null, null, this.outfitNumber);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_b();
                for (ajw ajw2 : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                    engine.a(ajw2);
                }
                Engine.a("POST print");
                engine.h();
                return;
            }
        } else {
            Engine.a("[ERROR] PUB_CHARACTER_ENTITY_CHANGE player: '" + this.character_name + "' could not be found for outfit change");
        }
    }
}

