/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public abstract class aim
implements agb {
    protected int a;

    public aim(int n2) {
        this.a = n2;
    }

    public abstract void a(Engine var1);

    public abstract boolean a(Engine var1, agd var2, int var3, int var4, int var5, int var6);

    public abstract boolean b(Engine var1, agd var2, int var3, int var4, int var5, int var6);

    public abstract boolean a(Engine var1, agd var2, int var3, int var4, int var5);

    public abstract boolean a(agd var1, int var2);

    @Override
    public int int_a() {
        return this.a;
    }

    @Override
    public void a(int n2) {
        this.a = n2;
    }
}

