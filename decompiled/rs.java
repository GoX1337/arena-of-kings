/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class rs
extends rc {
    public rs(Engine engine) {
        super(engine, EffectList.Bear, "skill_137");
    }

    @Override
    public void c() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(cv.c);
        if (this.a == ay.ay_a()) {
            ay.ay_a().gu_a().d();
        }
    }

    @Override
    public void void_b() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(cv.c);
        if (this.a == ay.ay_a()) {
            ay.ay_a().gu_a().d();
        }
    }
}

