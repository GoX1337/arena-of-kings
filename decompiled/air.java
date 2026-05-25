/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.HitCircle;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.badlogic.gdx.audio.Sound;

public class air
extends aim {
    private Direction var_com_arenaofkings_packets_gameserver_data_Direction_a = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a();
    private PlayerAction var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_PlayerAction_a();
    private boolean var_boolean_a = false;

    public air(int n2) {
        super(n2);
    }

    @Override
    public void a(Engine engine) {
        PlayerAction playerAction;
        Direction direction;
        if (this.var_boolean_a && ay.ay_a().gd_a().boolean_b()) {
            return;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a() && ay.ay_a().e()) {
            return;
        }
        if (this.var_boolean_a && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a()) {
            direction = axp.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a(), new HitCircle(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y, 0), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a());
            playerAction = PlayerAction.getAction(cw.e, direction);
            if (!this.a(playerAction)) {
                return;
            }
            if (!PlayerAction.isSameDirectionRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a, playerAction) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
            }
            if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_a(playerAction)) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = direction;
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().c(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
                this.b(engine);
            }
            if (((agd)engine.axc_a()).boolean_b()) {
                ((agd)engine.axc_a()).f(true);
            }
        }
        if (this.var_boolean_a && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a()) {
            direction = axp.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a(), new HitCircle(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y, 0), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a());
            playerAction = PlayerAction.getAction(cw.e, direction);
            if (!PlayerAction.isSameDirectionRun(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a, playerAction) && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
            }
            if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_a(playerAction)) {
                this.var_com_arenaofkings_packets_gameserver_data_Direction_a = direction;
                this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().c(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
            }
        }
    }

    @Override
    public boolean a(Engine engine, agd agd2, int n2, int n3, int n4, int n5) {
        if (n5 == this.var_com_arenaofkings_packets_gameserver_data_Direction_a) {
            this.var_boolean_a = true;
            Engine.a("moveTocursor consume touchDown");
            return true;
        }
        return false;
    }

    @Override
    public boolean b(Engine engine, agd agd2, int n2, int n3, int n4, int n5) {
        if (n5 == this.var_com_arenaofkings_packets_gameserver_data_Direction_a) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
            Direction direction = axp.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a(), new HitCircle(engine.var_com_badlogic_gdx_math_Vector3_b.x, engine.var_com_badlogic_gdx_math_Vector3_b.y, 0), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a());
            PlayerAction playerAction = PlayerAction.getAction(cw.e, direction);
            Engine.a("Working move: " + (Object)((Object)this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a));
            Engine.a("Temp action: " + (Object)((Object)playerAction));
            if (this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a != playerAction) {
                Engine.a("ERROR CORRECTED TOUCHUP?");
            }
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(playerAction);
            this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a = playerAction;
            this.var_boolean_a = false;
            Engine.a("moveTocursor consume touchUp");
            Engine.a("releasing: " + this.var_com_arenaofkings_packets_gameserver_data_PlayerAction_a.name());
            return true;
        }
        return false;
    }

    @Override
    public boolean a(Engine engine, agd agd2, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public boolean a(agd agd2, int n2) {
        return false;
    }

    public void void_a() {
        this.var_boolean_a = false;
    }

    public void b(Engine engine) {
        if (ay.ay_a().gu_a().ui_a() != null && !ay.ay_a().gu_a().ui_a().boolean_a() && ay.ay_a().gu_a().ui_a().hf_a().uk_a() == uk.var_uk_a) {
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null) {
                Sound sound;
                ajw ajw2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b();
                if (((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2) != null && (sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2)) != null) {
                    sound.stop();
                }
            }
        } else if (ay.ay_a().gu_a().ui_a() != null && !ay.ay_a().gu_a().ui_a().boolean_a() && ay.ay_a().gu_a().ui_a().hf_a().uk_a() == uk.d && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
            Sound sound;
            ajw ajw3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a();
            if (((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3) != null && (sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3)) != null) {
                sound.stop();
            }
        }
    }

    private boolean a(PlayerAction playerAction) {
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().k()) {
            return true;
        }
        switch (playerAction) {
            case RUN_EAST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_h() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_i()) break;
                return true;
            }
            case RUN_NORTH: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_g() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_j()) break;
                return true;
            }
            case RUN_NORTH_EAST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_g() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_h()) break;
                return true;
            }
            case RUN_NORTH_WEST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_j() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_h()) break;
                return true;
            }
            case RUN_SOUTH: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_g() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_j()) break;
                return true;
            }
            case RUN_SOUTH_EAST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_g() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_i()) break;
                return true;
            }
            case RUN_SOUTH_WEST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_j() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_i()) break;
                return true;
            }
            case RUN_WEST: {
                if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_h() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_i()) break;
                return true;
            }
        }
        return false;
    }
}

