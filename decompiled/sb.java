/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class sb
extends rc {
    public sb(Engine engine) {
        super(engine, EffectList.SpiritWolf);
        this.a(0.4f);
    }

    @Override
    public void c() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(cv.b);
    }

    @Override
    public void void_b() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(cv.b);
    }
}

