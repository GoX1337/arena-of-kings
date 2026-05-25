/*
 * Decompiled with CFR 0.152.
 */
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;

public abstract class y {
    public Client var_com_esotericsoftware_kryonet_Client_a;
    protected boolean var_boolean_a;
    protected ab var_ab_a;

    public ab ab_a() {
        return this.var_ab_a;
    }

    public Connection com_esotericsoftware_kryonet_Connection_a() {
        return this.var_com_esotericsoftware_kryonet_Client_a;
    }

    public boolean boolean_a() {
        if (this.var_com_esotericsoftware_kryonet_Client_a == null) {
            return false;
        }
        return this.var_com_esotericsoftware_kryonet_Client_a.isConnected();
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public abstract void a(Object var1);
}

