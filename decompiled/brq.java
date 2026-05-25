/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;

public abstract class brq<T>
extends bqg<T>
implements bqh {
    protected final bfp var_bfp_a;
    protected final Boolean var_java_lang_Boolean_a;

    protected brq(Class<T> clazz) {
        super(clazz);
        this.var_bfp_a = null;
        this.var_java_lang_Boolean_a = null;
    }

    protected brq(brq<?> brq2, bfp bfp2, Boolean bl2) {
        super((Class<?>)((Object)brq2.var_bfp_a), false);
        this.var_bfp_a = bfp2;
        this.var_java_lang_Boolean_a = bl2;
    }

    public abstract bgb<?> a(bfp var1, Boolean var2);

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbk.d d2;
        Boolean bl2 = null;
        if (bfp2 != null && (d2 = this.bbk$d_a(bgo2, bfp2, this.a())) != null && !Objects.equals(bl2 = d2.a(bbk.a.f), this.var_java_lang_Boolean_a)) {
            return this.a(bfp2, bl2);
        }
        return this;
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2) {
        if (this.a(bgo2) && this.a(t2)) {
            this.b(t2, bcy2, bgo2);
            return;
        }
        bcy2.b(t2);
        this.b(t2, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public final void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(t2, bdf.var_bdf_d));
        bcy2.a(t2);
        this.b(t2, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    protected abstract void b(T var1, bcy var2, bgo var3);

    @Override
    protected final boolean a(bgo bgo2) {
        if (this.var_java_lang_Boolean_a == null) {
            return bgo2.a(bgn.t);
        }
        return this.var_java_lang_Boolean_a;
    }
}

