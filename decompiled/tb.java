/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;

public class tb
extends rc {
    public tb(Engine engine) {
        super(engine, EffectList.Vigor);
        this.a(0.25f);
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

