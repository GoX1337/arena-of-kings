/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.enemy.EnemyAccountData;
import com.badlogic.gdx.math.MathUtils;

public class al
extends br {
    public al(Engine engine, String string, int n2, String string2, int n3, int n4, int n5, int n6, int n7) {
        this.a = new EnemyAccountData(engine, string, n2, string2, n3, n4, n5, n6, n7);
        this.a = new azv(2000 + MathUtils.random(500), true);
    }

    @Override
    public EnemyAccountData com_arenaofkings_packets_gameserver_data_player_enemy_EnemyAccountData_a() {
        return (EnemyAccountData)this.a;
    }
}

