/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class ajj
extends ail {
    public ajj(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        Target target = new Target(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a());
        engine.var_ag_a.a(new TargetRequest(target));
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(target);
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).agn_a().agt_a().a().a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
        }
        engine.var_baa_a.a(ajw.kD, 0.165f);
        return true;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

