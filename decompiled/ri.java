/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class ri
extends rc {
    public ri(Engine engine) {
        super(engine, EffectList.Stealth);
        this.a(0.15f);
    }

    @Override
    public void c() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(true);
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().c(true);
    }

    @Override
    public void void_b() {
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b(false);
        this.a.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().c(false);
    }
}

