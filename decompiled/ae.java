/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_GAME_INIT;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING_RESPONSE;
import com.arenaofkings.packets.gameserver.PUB_GAME_STATUS_UPDATE;
import com.arenaofkings.packets.gameserver.PUB_MISC_PLAYER_TOKEN;
import com.arenaofkings.packets.gameserver.data.GameStatus;
import com.arenaofkings.packets.misc.PublicPacket;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.Listener;
import java.util.AbstractQueue;

public class ae
implements Listener {
    private ag var_ag_a;
    private final String var_java_lang_String_a;
    private final int var_int_a;
    private int b;

    public ae(ag ag2, String string, int n2, int n3) {
        this.var_ag_a = ag2;
        this.var_java_lang_String_a = string;
        this.var_int_a = n2;
        this.b = n3;
    }

    @Override
    public void connected(Connection connection) {
        Engine.a("[NETWORK-GS] Connection opened. onOpen()");
        this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] onOpen");
        this.var_ag_a.ab_a().azv_a().void_c();
        this.var_ag_a.a(true);
        PUB_MISC_PLAYER_TOKEN pUB_MISC_PLAYER_TOKEN = new PUB_MISC_PLAYER_TOKEN();
        pUB_MISC_PLAYER_TOKEN.setToken(ay.ay_a().gd_a().java_lang_String_a());
        pUB_MISC_PLAYER_TOKEN.setGameID(this.b);
        this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_ag_a.b(pUB_MISC_PLAYER_TOKEN);
    }

    @Override
    public void disconnected(Connection connection) {
        Engine.a("[NETWORK-GS] Connection closed.");
        System.out.println("dc1");
        this.var_ag_a.d();
        this.var_ag_a.a(false);
        System.out.println("dc2");
        if (ay.ay_a() != null && ay.ay_a().gd_a() != null && ay.ay_a().gd_a().boolean_b()) {
            System.out.println("dc3");
            PUB_GAME_STATUS_UPDATE pUB_GAME_STATUS_UPDATE = new PUB_GAME_STATUS_UPDATE();
            pUB_GAME_STATUS_UPDATE.setGameStatus(GameStatus.ENDED);
            pUB_GAME_STATUS_UPDATE.handle(this.var_ag_a.var_com_arenaofkings_client_core_Engine_a);
            return;
        }
        System.out.println("dc4");
        if (this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_z_a.boolean_a()) {
            System.out.println("Relog required");
            return;
        }
        PUB_GAME_STATUS_UPDATE pUB_GAME_STATUS_UPDATE = new PUB_GAME_STATUS_UPDATE();
        pUB_GAME_STATUS_UPDATE.setGameStatus(GameStatus.ENDED);
        pUB_GAME_STATUS_UPDATE.handle(this.var_ag_a.var_com_arenaofkings_client_core_Engine_a);
        System.out.println("dc5");
        Engine.b("GameClient onClose() out");
    }

    @Override
    public void received(Connection connection, Object object) {
        System.out.println("Received: " + object.getClass().getName());
        long l2 = System.nanoTime();
        if (object == null) {
            return;
        }
        if (object instanceof FrameworkMessage) {
            return;
        }
        this.var_ag_a.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] IN: " + object.getClass().getSimpleName());
        if (object != null) {
            if (object instanceof PUB_GAME_PING_RESPONSE) {
                this.var_ag_a.ab_a().a(l2);
            } else if (object instanceof PUB_GAME_INIT) {
                this.var_ag_a.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a = (PUB_GAME_INIT)object;
            } else {
                ((AbstractQueue)((Object)this.var_ag_a.var_com_arenaofkings_client_core_Engine_a)).add((PublicPacket)object);
            }
        }
    }

    public void a(int n2) {
        this.b = n2;
    }
}

