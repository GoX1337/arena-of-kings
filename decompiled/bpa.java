/*
 * Decompiled with CFR 0.152.
 */
public abstract class bpa
implements boe {
    protected final btz var_btz_a;
    protected final bfw var_bfw_a;

    protected bpa(bfw bfw2, btz btz2) {
        this.var_bfw_a = bfw2;
        this.var_btz_a = btz2;
    }

    @Override
    public void a(bfw bfw2) {
    }

    @Override
    public String a() {
        return this.a((Object)null, (Class<?>)this.var_bfw_a.a());
    }

    @Override
    public bfw a(bfq bfq2, String string) {
        throw new IllegalStateException("Sub-class " + this.getClass().getName() + " MUST implement `typeFromId(DatabindContext,String)");
    }

    @Override
    public String b() {
        return null;
    }
}

