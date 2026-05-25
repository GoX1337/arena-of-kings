/*
 * Decompiled with CFR 0.152.
 */
public final class brk
extends bgb<Object>
implements bqh {
    protected final bog var_bog_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;

    public brk(bog bog2, bgb<?> bgb2) {
        this.var_bog_a = bog2;
        this.var_bog_a = bgb2;
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        ((bgb)((Object)this.var_bog_a)).a(object, bcy2, bgo2, this.var_bog_a);
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        ((bgb)((Object)this.var_bog_a)).a(object, bcy2, bgo2, bog2);
    }

    @Override
    public Class<Object> a() {
        return Object.class;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Object object = this.var_bog_a;
        if (object instanceof bqh) {
            object = bgo2.b((bgb<?>)object, bfp2);
        }
        if (object == this.var_bog_a) {
            return this;
        }
        return new brk(this.var_bog_a, (bgb<?>)object);
    }

    public bog a() {
        return this.var_bog_a;
    }
}

