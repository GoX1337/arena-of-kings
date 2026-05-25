/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EnemyPlayerData;
import com.arenaofkings.packets.gameserver.data.FriendlyPlayerData;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.misc.ArenaName;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.GameType;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_GAME_INIT
extends PublicPacket {
    private ArrayList<FriendlyPlayerData> friendlyPlayerData = new ArrayList();
    private ArrayList<EnemyPlayerData> enemyPlayerData = new ArrayList();
    private ArrayList<SpellName> spellList = new ArrayList();
    private ArenaTeamData friendlyArenaTeamData = new ArenaTeamData();
    private ArenaTeamData enemyArenaTeamData = new ArenaTeamData();
    private ArenaName arenaName;
    private GameType gameType;
    private boolean night;
    private boolean spectator;
    private boolean rankedGame;
    private boolean soloQueue;

    public ArenaName getArenaName() {
        return this.arenaName;
    }

    public ArrayList<EnemyPlayerData> getEnemyPlayerData() {
        return this.enemyPlayerData;
    }

    public ArrayList<FriendlyPlayerData> getFriendlyPlayerData() {
        return this.friendlyPlayerData;
    }

    @Override
    public void handle(Engine engine) {
        br br2;
        engine.c("!! Game Started !!");
        Engine.a("PUB_GAME_INIT " + this.spectator);
        ay.ay_a().gd_a().a(this.spectator);
        ay.ay_a().gd_a().as_a().void_b();
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).a(true, this.arenaName);
        }
        engine.var_baa_a.a(ajw.kB, 0.8f);
        ay.ay_a().gf_a().a(3);
        ay.ay_a().ge_a().a(engine, false);
        for (EnemyPlayerData object : this.enemyPlayerData) {
            Engine.b("DATA: " + object.character_name + " " + object.maxHealth);
            br2 = new al(engine, object.character_name, object.character_ordinal, object.character_class, object.outfit, object.x, object.y, object.maxHealth, object.maxResource);
            ay.ay_a().ge_a().a(br2);
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().clear();
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().b(false);
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().void_e();
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().void_f();
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().setPosition(object.x, object.y);
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().az_a().void_d();
            ((al)br2).com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a().getActive_character_entity().az_a().ar_a().void_a();
        }
        if (this.spectator) {
            ay.ay_a().gf_a().a(engine, true);
            for (FriendlyPlayerData friendlyPlayerData : this.friendlyPlayerData) {
                br2 = new aq(engine, friendlyPlayerData.character_name, friendlyPlayerData.character_ordinal, friendlyPlayerData.character_class, friendlyPlayerData.outfit, friendlyPlayerData.x, friendlyPlayerData.y, friendlyPlayerData.maxHealth, friendlyPlayerData.maxResource);
                ay.ay_a().gf_a().a(br2);
                Engine.b("Assigned spectate friendly player: " + friendlyPlayerData.character_name);
            }
            Engine.b("My party size: " + ay.ay_a().gf_a().a().size());
        }
        for (br br3 : ay.ay_a().gf_a().a().values()) {
            engine.var_q_a.a("[DEBUG] Friendly Player: " + br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + " " + (Object)((Object)br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a()));
        }
        for (FriendlyPlayerData friendlyPlayerData : this.friendlyPlayerData) {
            br2 = ay.ay_a().br_a(friendlyPlayerData.character_name);
            engine.var_q_a.a("[DEBUG] Load FriendlyPlayer: " + friendlyPlayerData.character_name + "  myActive: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a());
            if (br2 == null) {
                engine.var_q_a.a("[CRITICAL] The player is null");
            }
            if (br2 != ay.ay_a()) {
                if (br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a() != null) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().setPosition(friendlyPlayerData.x, friendlyPlayerData.y);
                }
            } else {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().setData(friendlyPlayerData.x, friendlyPlayerData.y, 16);
            }
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_c();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(false);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b((double)friendlyPlayerData.maxHealth);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().setMaxValue(friendlyPlayerData.maxResource);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_e();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_f();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().clear();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().void_d();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().ar_a().void_a();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().fu_a().b();
        }
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(true);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_b());
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().setCurrentValue(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().void_e();
        engine.var_hg_a.c();
        for (SpellName spellName : this.spellList) {
            engine.var_hg_a.void_a(spellName);
        }
        Engine.a("Transitioning to LoadingScreen");
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().clearTarget();
        ay.ay_a().gd_a().a(this.gameType);
        Engine.b("gameType: " + (Object)((Object)this.gameType));
        agp agp2 = new agp();
        agp2.a(this.arenaName);
        agp2.a(this.night);
        agp2.c(this.rankedGame);
        agp2.b(this.soloQueue);
        agp2.b(this.friendlyArenaTeamData);
        agp2.a(this.enemyArenaTeamData);
        Engine.b("[PUB_GAME_INIT] out - Transitioning to PlayLoadingScreen");
        engine.a(ajo.class, agp2);
    }
}

