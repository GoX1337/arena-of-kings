/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Objects;

public abstract class brr<T>
extends bqg<T>
implements bqh {
    protected final bfw var_bfw_a;
    protected final bfp var_bfp_a;
    protected final boolean var_boolean_a;
    protected final Boolean var_java_lang_Boolean_a;
    protected final bog var_bog_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;
    protected bre var_bre_a;

    protected brr(Class<?> clazz, bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        this(clazz, bfw2, bl2, bog2, null, bgb2, null);
    }

    protected brr(Class<?> clazz, bfw bfw2, boolean bl2, bog bog2, bfp bfp2, bgb<?> bgb2, Boolean bl3) {
        super(clazz, false);
        this.var_bfw_a = bfw2;
        this.var_boolean_a = bl2 || bfw2 != null && bfw2.l();
        this.var_bog_a = bog2;
        this.var_bfp_a = bfp2;
        this.var_bfw_a = bgb2;
        this.var_bre_a = bre.a();
        this.var_java_lang_Boolean_a = bl3;
    }

    protected brr(brr<?> brr2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super((bqg<?>)brr2);
        this.var_bfw_a = brr2.var_bfw_a;
        this.var_boolean_a = brr2.var_boolean_a;
        this.var_bog_a = bog2;
        this.var_bfp_a = bfp2;
        this.var_bfw_a = bgb2;
        this.var_bre_a = bre.a();
        this.var_java_lang_Boolean_a = bl2;
    }

    public abstract brr<T> a(bfp var1, bog var2, bgb<?> var3, Boolean var4);

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Serializable serializable;
        bog bog2 = this.var_bog_a;
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
        }
        bgb<Object> bgb2 = null;
        Boolean bl2 = null;
        if (bfp2 != null) {
            Object object;
            serializable = bgo2.bfn_a();
            bmn bmn2 = bfp2.bmn_a();
            if (bmn2 != null && (object = ((bfn)serializable).java_lang_Object_d(bmn2)) != null) {
                bgb2 = bgo2.a((bmg)bmn2, object);
            }
        }
        if ((serializable = this.bbk$d_a(bgo2, bfp2, this.a())) != null) {
            bl2 = ((bbk.d)serializable).a(bbk.a.f);
        }
        if (bgb2 == null) {
            bgb2 = this.var_bfw_a;
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null && this.var_bfw_a != null && this.var_boolean_a && !this.var_bfw_a.p()) {
            bgb2 = bgo2.c(this.var_bfw_a, bfp2);
        }
        if (bgb2 != this.var_bfw_a || bfp2 != this.var_bfp_a || this.var_bog_a != bog2 || !Objects.equals(this.var_java_lang_Boolean_a, bl2)) {
            return this.a(bfp2, bog2, bgb2, bl2);
        }
        return this;
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2) {
        if (bgo2.a(bgn.t) && this.a(t2)) {
            this.b(t2, bcy2, bgo2);
            return;
        }
        bcy2.b(t2);
        this.b(t2, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(t2, bdf.var_bdf_d));
        bcy2.a(t2);
        this.b(t2, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    protected abstract void b(T var1, bcy var2, bgo var3);

    protected final bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bre.d d2 = bre2.b(clazz, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    protected final bgb<Object> a(bre bre2, bfw bfw2, bgo bgo2) {
        bre.d d2 = bre2.b(bfw2, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }
}

