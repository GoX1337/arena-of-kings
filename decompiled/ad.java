/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.utils.Json;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;

public abstract class ad {
    protected WebSocketClient var_org_java_websocket_client_WebSocketClient_a;
    protected boolean var_boolean_a;
    protected boolean b;
    protected Json var_com_badlogic_gdx_utils_Json_a = new Json();
    protected ac var_ac_a;

    public ac ac_a() {
        return this.var_ac_a;
    }

    public WebSocketClient org_java_websocket_client_WebSocketClient_a() {
        return this.var_org_java_websocket_client_WebSocketClient_a;
    }

    public boolean boolean_a() {
        if (this.var_org_java_websocket_client_WebSocketClient_a == null) {
            return false;
        }
        return this.var_org_java_websocket_client_WebSocketClient_a.getReadyState() == ReadyState.CLOSING || this.var_org_java_websocket_client_WebSocketClient_a.getReadyState() == ReadyState.CLOSED;
    }

    public boolean boolean_b() {
        return this.var_boolean_a;
    }

    public boolean boolean_c() {
        return this.b;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public abstract void void_a(Object var1);
}

