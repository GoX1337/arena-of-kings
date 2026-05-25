/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_GAME_INIT;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING;
import com.arenaofkings.packets.gameserver.PUB_GAME_SNAPSHOT;
import com.arenaofkings.packets.gameserver.data.updates.PlayerUpdateBundle;
import com.arenaofkings.packets.gameserver.requests.input.DIRECTION_CHANGE_REQUEST;
import com.arenaofkings.packets.gameserver.requests.input.JAVA_16_GFX_CL$61892;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_NORTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_SOUTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_RELEASE_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_NORTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH_EAST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_SOUTH_WEST;
import com.arenaofkings.packets.gameserver.requests.input.MOVE_REQUEST_WEST;
import com.arenaofkings.packets.misc.PublicPacket;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class ag
extends y {
    final Engine var_com_arenaofkings_client_core_Engine_a = new ArrayList();
    int var_int_a = 0;
    int var_int_b = 0;
    public boolean var_boolean_b = false;
    LinkedBlockingQueue<PublicPacket> var_java_util_concurrent_LinkedBlockingQueue_com_arenaofkings_packets_misc_PublicPacket__a;
    private List<PublicPacket> var_java_util_List_com_arenaofkings_packets_misc_PublicPacket__a;
    private Iterator<PublicPacket> var_java_util_Iterator_com_arenaofkings_packets_misc_PublicPacket__a;
    private PlayerUpdateBundle var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a;
    private List<PublicPacket> var_java_util_List_com_arenaofkings_packets_misc_PublicPacket__b;
    private azv var_azv_a = new azv(20L, true);
    private ListIterator<PublicPacket> var_java_util_ListIterator_com_arenaofkings_packets_misc_PublicPacket__a;
    private PublicPacket var_com_arenaofkings_packets_misc_PublicPacket_a;
    private Map<Class, Boolean> cfr_renamed_4;
    private String var_java_lang_String_a = "";
    private boolean var_boolean_c = false;
    private boolean var_boolean_d = false;
    private String var_java_lang_String_b;
    private int var_int_c;
    private int var_int_d;
    private boolean e = false;
    PUB_GAME_INIT var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a;
    private PUB_GAME_PING var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a;
    private ae var_ae_a;

    public ag(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = new HashMap();
        this.var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a = new PUB_GAME_PING();
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.void_a();
    }

    public void void_a() {
        this.var_com_arenaofkings_client_core_Engine_a = new ab(this, this.var_com_arenaofkings_packets_gameserver_PUB_GAME_PING_a);
        this.var_com_arenaofkings_client_core_Engine_a.put(JAVA_16_GFX_CL$61892.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(DIRECTION_CHANGE_REQUEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(PUB_GAME_PING.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_NORTH.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_SOUTH.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_WEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_NORTH_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_NORTH_WEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_SOUTH_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_REQUEST_SOUTH_WEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_NORTH.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_SOUTH.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_WEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_NORTH_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_NORTH_WEST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_SOUTH_EAST.class, false);
        this.var_com_arenaofkings_client_core_Engine_a.put(MOVE_RELEASE_SOUTH_WEST.class, false);
        this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a = new PlayerUpdateBundle();
        this.var_int_b = (int)this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a.getUpdates();
        this.e = false;
        this.var_com_arenaofkings_client_core_Engine_a = new Client(524280, 65535);
        af.a(((Client)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getKryo());
        this.var_ae_a = new ae(this, this.var_java_lang_String_b, this.var_int_c, this.var_int_d);
        ((Client)((Object)this.var_com_arenaofkings_client_core_Engine_a)).addListener(this.var_ae_a);
    }

    public void a(String string, int n2, int n3) {
        this.var_java_lang_String_b = string;
        this.var_int_c = n2;
        this.var_int_d = n3;
        this.e = true;
        this.var_ae_a.a(n3);
    }

    public void void_b() {
        Engine.b("Connecting to: " + this.var_java_lang_String_b);
        this.var_ae_a.a(this.var_int_d);
        try {
            ((Client)((Object)this.var_com_arenaofkings_client_core_Engine_a)).stop();
        }
        catch (Exception exception) {
            // empty catch block
        }
        Thread thread = new Thread(new ah(this));
        thread.start();
        this.e = false;
        System.out.println("thread size " + Thread.getAllStackTraces().keySet().size());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void c() {
        if (t.a(agd.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            Object object = this.var_com_arenaofkings_client_core_Engine_a;
            synchronized (object) {
                this.var_com_arenaofkings_client_core_Engine_a = new ArrayList(this.var_com_arenaofkings_client_core_Engine_a);
                ((LinkedBlockingQueue)((Object)this.var_com_arenaofkings_client_core_Engine_a)).clear();
            }
            this.var_com_arenaofkings_client_core_Engine_a = this.var_com_arenaofkings_client_core_Engine_a.iterator();
            while (this.var_com_arenaofkings_client_core_Engine_a.hasNext()) {
                object = (PublicPacket)this.var_com_arenaofkings_client_core_Engine_a.next();
                if (!(object instanceof PUB_GAME_SNAPSHOT)) {
                    this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] " + object.getClass().getSimpleName() + ".handle()");
                }
                ((PublicPacket)object).handle(this.var_com_arenaofkings_client_core_Engine_a);
            }
            this.var_com_arenaofkings_client_core_Engine_a.clear();
        } else if ((t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a) || t.a(xw.class, this.var_com_arenaofkings_client_core_Engine_a)) && this.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a != null) {
            PUB_GAME_INIT pUB_GAME_INIT = this.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a;
            synchronized (pUB_GAME_INIT) {
                this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] special gameInit.handle()");
                this.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a.handle(this.var_com_arenaofkings_client_core_Engine_a);
                this.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a = null;
            }
        }
    }

    public void d() {
        this.var_com_arenaofkings_packets_gameserver_PUB_GAME_INIT_a = null;
    }

    public void e() {
        System.out.println("Clearing: " + ((LinkedBlockingQueue)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size());
        ((LinkedBlockingQueue)((Object)this.var_com_arenaofkings_client_core_Engine_a)).clear();
    }

    @Override
    public void a(Object object) {
        if (this.var_com_arenaofkings_client_core_Engine_a != false && this.var_com_arenaofkings_client_core_Engine_a != null && ((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isConnected()) {
            if (!this.var_com_arenaofkings_client_core_Engine_a.containsKey(object.getClass())) {
                this.var_com_arenaofkings_client_core_Engine_a.put(object.getClass(), false);
            }
            this.var_int_b.add((PublicPacket)object);
        }
    }

    public void b(Object object) {
        if (this.var_com_arenaofkings_client_core_Engine_a != false && this.var_com_arenaofkings_client_core_Engine_a != null && ((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isConnected()) {
            this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] OUT: forceSend " + object.getClass().getSimpleName());
            if (((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isConnected()) {
                ((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).sendTCP(object);
            }
        }
    }

    private void h() {
        if (this.var_com_arenaofkings_client_core_Engine_a != false && this.var_com_arenaofkings_client_core_Engine_a != null && ((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isConnected() && this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a != null && !this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a.getUpdates().isEmpty() && !ay.ay_a().gd_a().boolean_b()) {
            String string = "";
            for (PublicPacket publicPacket : this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a.getUpdates()) {
                string = string + "[" + publicPacket.getClass().getSimpleName() + "] ";
            }
            this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-GS] OUT: netSend " + this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a.getClass().getSimpleName() + string);
            if (((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isConnected()) {
                Engine.b("[NETWORK-GS] OUT: netSend " + this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a.getClass().getSimpleName() + string);
                ((Connection)((Object)this.var_com_arenaofkings_client_core_Engine_a)).sendTCP(this.var_com_arenaofkings_packets_gameserver_data_updates_PlayerUpdateBundle_a);
                Engine.b("sent tcp -");
            }
        }
    }

    public void f() {
        if (!this.var_int_b.isEmpty()) {
            this.i();
        }
    }

    private void i() {
        this.var_com_arenaofkings_client_core_Engine_a = this.var_int_b.listIterator(this.var_int_b.size());
        while (this.var_com_arenaofkings_client_core_Engine_a.hasPrevious()) {
            this.var_com_arenaofkings_packets_misc_PublicPacket_a = (PublicPacket)this.var_com_arenaofkings_client_core_Engine_a.previous();
            if (((Boolean)this.var_com_arenaofkings_client_core_Engine_a.get(this.var_com_arenaofkings_packets_misc_PublicPacket_a.getClass())).booleanValue()) {
                this.var_com_arenaofkings_client_core_Engine_a.remove();
                continue;
            }
            this.var_com_arenaofkings_client_core_Engine_a.put(this.var_com_arenaofkings_packets_misc_PublicPacket_a.getClass(), true);
        }
        if (this.var_com_arenaofkings_client_core_Engine_a.containsKey(JAVA_16_GFX_CL$61892.class) && this.var_com_arenaofkings_client_core_Engine_a.containsKey(DIRECTION_CHANGE_REQUEST.class)) {
            this.var_com_arenaofkings_client_core_Engine_a = this.var_int_b.listIterator(this.var_int_b.size());
            while (this.var_com_arenaofkings_client_core_Engine_a.hasPrevious()) {
                this.var_com_arenaofkings_packets_misc_PublicPacket_a = (PublicPacket)this.var_com_arenaofkings_client_core_Engine_a.previous();
                if (this.var_com_arenaofkings_packets_misc_PublicPacket_a.getClass() != DIRECTION_CHANGE_REQUEST.class) continue;
                this.var_com_arenaofkings_client_core_Engine_a.remove();
            }
        }
        this.h();
        this.var_int_b.clear();
        this.j();
    }

    public boolean boolean_b() {
        return this.e;
    }

    private void j() {
        for (Map.Entry entry : this.var_com_arenaofkings_client_core_Engine_a.entrySet()) {
            entry.setValue(false);
        }
    }

    public void g() {
        Engine.b("GameClient.disconnect() called");
        if (this.var_com_arenaofkings_client_core_Engine_a != null) {
            Engine.a("[GAMECLIENT] close() ");
            ((Client)((Object)this.var_com_arenaofkings_client_core_Engine_a)).close();
        }
    }

    static /* synthetic */ String a(ag ag2) {
        return ag2.var_java_lang_String_b;
    }
}

