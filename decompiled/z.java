/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_GAME_PING;
import com.arenaofkings.packets.misc.PublicPacket;
import com.badlogic.gdx.utils.Json;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.client.WebSocketClient;

public class z
extends ad {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private axn var_axn_a = axn.var_axn_a;
    private w var_w_a = w.c;
    private azv var_azv_a = new azv(10L, true);
    private LinkedBlockingQueue<PublicPacket> var_java_util_concurrent_LinkedBlockingQueue_com_arenaofkings_packets_misc_PublicPacket__a;
    private List<PublicPacket> var_java_util_List_com_arenaofkings_packets_misc_PublicPacket__a;
    private Iterator<PublicPacket> var_java_util_Iterator_com_arenaofkings_packets_misc_PublicPacket__a;

    public z(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = new LinkedBlockingQueue();
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList();
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.void_a();
    }

    public void void_a() {
        String string = this.java_lang_String_a(new PUB_GAME_PING());
        this.var_com_arenaofkings_client_core_Engine_a = new ac(this, string);
    }

    public void void_b() {
        this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-LS] connect()");
        Engine.a("loginClient.connect() in");
        this.var_com_arenaofkings_client_core_Engine_a.var_azv_a.void_c();
        String string = "";
        if (Engine.var_azm_a == azm.var_azm_a) {
            string = "wss://live-us-east-ls1.arenaofkings.com/websocket/loginserver/";
        } else if (Engine.var_azm_a == azm.b) {
            string = "wss://ptr-us-east-ls1.arenaofkings.com/websocket/loginserver/";
        }
        try {
            this.var_com_arenaofkings_client_core_Engine_a = new aa(this, new URI(string));
            ((AbstractWebSocket)((Object)this.var_com_arenaofkings_client_core_Engine_a)).setConnectionLostTimeout(0);
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
        }
        try {
            ((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).connectBlocking();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        Engine.a("loginClient.connect() out");
    }

    public void a(int n2, String string, boolean bl2) {
        if (this.var_com_arenaofkings_client_core_Engine_a.var_ag_a != null) {
            this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.d();
        }
        this.b = false;
        this.var_com_arenaofkings_client_core_Engine_a.var_azv_a.void_c();
        this.var_axn_a = axn.var_axn_a;
        this.var_w_a = w.b;
        if (this.var_com_arenaofkings_client_core_Engine_a.var_ag_a != null && this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.com_esotericsoftware_kryonet_Connection_a() != null && this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.com_esotericsoftware_kryonet_Connection_a().isConnected()) {
            this.var_com_arenaofkings_client_core_Engine_a.var_ag_a.g();
        }
        Engine.a("onClose() loginClient");
        this.var_com_arenaofkings_client_core_Engine_a.d();
        if (t.a(aes.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            ((aex)((aes)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).aya_a()).k();
            ((aex)((aes)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_a().setDisabled(false);
            ((aex)((aes)this.var_com_arenaofkings_client_core_Engine_a.axc_a()).aya_a()).com_badlogic_gdx_scenes_scene2d_ui_TextField_b().setDisabled(false);
        }
        if (!t.a(aes.class, this.var_com_arenaofkings_client_core_Engine_a) && !t.a(um.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            this.var_com_arenaofkings_client_core_Engine_a.a(afx.class, new afz(true, n2, string, bl2));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void void_c() {
        Object object = this.var_com_arenaofkings_client_core_Engine_a;
        synchronized (object) {
            this.var_com_arenaofkings_client_core_Engine_a = new ArrayList(this.var_com_arenaofkings_client_core_Engine_a);
            ((LinkedBlockingQueue)((Object)this.var_com_arenaofkings_client_core_Engine_a)).clear();
        }
        this.var_com_arenaofkings_client_core_Engine_a = this.var_com_arenaofkings_client_core_Engine_a.iterator();
        while (this.var_com_arenaofkings_client_core_Engine_a.hasNext()) {
            object = (PublicPacket)this.var_com_arenaofkings_client_core_Engine_a.next();
            this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-LS] " + object.getClass().getSimpleName() + ".handle()");
            ((PublicPacket)object).handle(this.var_com_arenaofkings_client_core_Engine_a);
        }
        this.var_com_arenaofkings_client_core_Engine_a.clear();
    }

    public void d() {
        this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-LS] disconnect()");
        Engine.b("LoginClient.disconnect() called");
        if (this.var_com_arenaofkings_client_core_Engine_a != null) {
            Engine.a("[LOGINCLIENT] close() " + (Object)((Object)((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).getReadyState()) + " " + this.var_com_arenaofkings_client_core_Engine_a.toString());
            ((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).close();
        }
        this.var_com_arenaofkings_client_core_Engine_a = (Engine)false;
        this.var_axn_a = axn.var_axn_a;
    }

    @Override
    public void void_a(Object object) {
        this.var_com_arenaofkings_client_core_Engine_a.var_q_a.a("[NETWORK-LS] OUT: " + object.getClass().getSimpleName());
        System.out.println("[NETWORK] OUT: " + object.getClass().getSimpleName());
        if (this.var_com_arenaofkings_client_core_Engine_a != false && this.b && ((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isOpen()) {
            if (t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
                if (((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isOpen()) {
                    ((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).send(this.java_lang_String_a(object));
                }
            } else if (((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).isOpen()) {
                ((WebSocketClient)((Object)this.var_com_arenaofkings_client_core_Engine_a)).send(this.java_lang_String_a(object));
            }
        }
    }

    public String java_lang_String_a(Object object) {
        return ((Json)((Object)this.var_com_arenaofkings_client_core_Engine_a)).toJson(object, Object.class);
    }

    public Object a(String string) {
        return ((Json)((Object)this.var_com_arenaofkings_client_core_Engine_a)).fromJson(Object.class, string);
    }

    @Override
    public ac ac_a() {
        return this.var_com_arenaofkings_client_core_Engine_a;
    }

    public w w_a() {
        return this.var_w_a;
    }

    public void a(w w2) {
        this.var_w_a = w2;
    }

    public axn axn_a() {
        return this.var_axn_a;
    }

    public void a(axn axn2) {
        this.var_axn_a = axn2;
    }

    static /* synthetic */ Engine com_arenaofkings_client_core_Engine_a(z z2) {
        return z2.var_com_arenaofkings_client_core_Engine_a;
    }

    static /* synthetic */ axn a(z z2, axn axn2) {
        z2.var_axn_a = axn2;
        return z2.var_axn_a;
    }

    static /* synthetic */ w a(z z2, w w2) {
        z2.var_w_a = w2;
        return z2.var_w_a;
    }

    static /* synthetic */ LinkedBlockingQueue java_util_concurrent_LinkedBlockingQueue_a(z z2) {
        return z2.var_com_arenaofkings_client_core_Engine_a;
    }
}

