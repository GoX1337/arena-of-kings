/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class sk
extends rc {
    public sk(Engine engine) {
        super(engine, EffectList.SpiritForm);
        this.a(0.15f);
    }

    @Override
    public void c() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(true);
    }

    @Override
    public void void_b() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(false);
    }
}

