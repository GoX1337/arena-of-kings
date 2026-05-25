/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public abstract class ail
implements agb {
    protected int var_int_a;
    protected boolean var_boolean_a = false;
    protected boolean b = false;

    public ail(int n2) {
        this.var_int_a = n2;
    }

    public abstract boolean boolean_a(Engine var1);

    public abstract boolean b(Engine var1);

    @Override
    public int int_a() {
        return this.var_int_a;
    }

    @Override
    public void a(int n2) {
        this.var_int_a = n2;
    }
}

