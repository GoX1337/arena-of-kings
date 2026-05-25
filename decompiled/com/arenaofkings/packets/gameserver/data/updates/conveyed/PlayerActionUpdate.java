/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.conveyed;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.data.updates.conveyed.Conveyorable;

public class PlayerActionUpdate
extends Conveyorable {
    private PlayerAction playerAction;

    public PlayerActionUpdate() {
    }

    public PlayerActionUpdate(PlayerAction playerAction) {
        this.playerAction = playerAction;
    }

    public PlayerAction getPlayerAction() {
        return this.playerAction;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("new playerActionUpdate=" + (Object)((Object)this.playerAction));
        br br2 = ay.ay_a().br_a(string);
        if (br2 == null) {
            return;
        }
        ui ui2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a();
        if (ui2 != null && !ui2.hf_a().azv_b().boolean_b() && PlayerAction.isRun(this.playerAction) && !ui2.hf_a().boolean_c()) {
            Engine.a("makingDone()");
            ui2.hf_a().azv_b().d();
        }
        if (br2 == ay.ay_a()) {
            if (PlayerAction.isAttackOrCast(this.playerAction) || PlayerAction.isAttackRun(this.playerAction) || PlayerAction.isCastRun(this.playerAction)) {
                if (ui2 == null || ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Bear_Ironhide) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.playerAction);
                }
            } else if (PlayerAction.isRun(this.playerAction) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a() == SpellBarState.AVAILABLE) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.playerAction);
            }
        } else if (!PlayerAction.isRun(this.playerAction)) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(this.playerAction);
        }
        Engine.a("out of playeractionupdate");
    }

    @Override
    public void onPop(String string) {
    }
}

