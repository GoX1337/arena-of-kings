/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.packets.loginserver.PUB_LOGIN_PING;
import java.util.ArrayList;
import java.util.List;
import org.java_websocket.enums.ReadyState;

public class ac {
    private final ad var_ad_a;
    private final int var_int_a = 5000;
    private final int var_int_b = 25000;
    private final azv var_azv_a;
    private azv var_azv_b;
    private volatile long var_long_a = System.nanoTime();
    private volatile long var_long_b = System.nanoTime();
    private volatile int c = 0;
    private volatile int d = 0;
    private List<Integer> var_java_util_List_java_lang_Integer__a;
    private final int e = 10;
    private int f = 0;
    private final String var_java_lang_String_a;

    public ac(ad ad2, String string) {
        this.var_ad_a = new ArrayList();
        this.var_ad_a = ad2;
        this.var_java_lang_String_a = string;
        this.var_azv_a = new azv(5000L, true);
        this.var_azv_b = new azv(25000L, true);
    }

    public void a() {
        if (this.var_ad_a != null && this.var_ad_a.var_org_java_websocket_client_WebSocketClient_a != null && this.var_azv_a.boolean_b() && this.var_ad_a.org_java_websocket_client_WebSocketClient_a().getReadyState() == ReadyState.OPEN) {
            if (this.var_ad_a instanceof z) {
                this.var_ad_a.void_a(new PUB_LOGIN_PING());
                this.var_azv_b.void_c();
                this.var_ad_a.org_java_websocket_client_WebSocketClient_a().sendPing();
            }
            this.var_azv_a.void_c();
        }
        if (this.var_azv_b.boolean_b()) {
            // empty if block
        }
    }
}

