/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;

public class PlayerSpellUpdate
extends PlayerSnapshot {
    private SpellBarState castingState;

    public PlayerSpellUpdate() {
    }

    public PlayerSpellUpdate(SpellBarState spellBarState) {
        this.castingState = spellBarState;
    }

    public SpellBarState getCastingState() {
        return this.castingState;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("PlayerSpellUpdate.handle() in");
        br br2 = ay.ay_a().br_a(string);
        if (br2 != null) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(this.castingState);
            if (this.castingState == SpellBarState.AVAILABLE && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a() != null) {
                Engine.a("Reset here");
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a().hf_a().azv_b().d();
            }
        }
        Engine.a("PlayerSpellUpdate.handle() out");
    }
}

