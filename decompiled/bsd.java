/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;

@bgp
public class bsd
extends btd<Enum<?>>
implements bqh {
    protected final buo var_buo_a;
    protected final Boolean var_java_lang_Boolean_a;

    public bsd(buo buo2, Boolean bl2) {
        super(buo2.a(), false);
        this.var_buo_a = buo2;
        this.var_java_lang_Boolean_a = bl2;
    }

    public static bsd a(Class<?> clazz, bgm bgm2, bfo bfo2, bbk.d d2) {
        buo buo2 = buo.a(bgm2, clazz);
        Boolean bl2 = bsd.a(clazz, d2, true, null);
        return new bsd(buo2, bl2);
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Class clazz;
        Boolean bl2;
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, this.a());
        if (d2 != null && !Objects.equals(bl2 = bsd.a(clazz = this.a(), d2, false, this.var_java_lang_Boolean_a), this.var_java_lang_Boolean_a)) {
            return new bsd(this.var_buo_a, bl2);
        }
        return this;
    }

    @Override
    public final void a(Enum<?> enum_, bcy bcy2, bgo bgo2) {
        if (this.a(bgo2)) {
            bcy2.void_b(enum_.ordinal());
            return;
        }
        if (bgo2.a(bgn.o)) {
            bcy2.b(enum_.toString());
            return;
        }
        bcy2.b(this.var_buo_a.a(enum_));
    }

    protected final boolean a(bgo bgo2) {
        if (this.var_java_lang_Boolean_a != null) {
            return this.var_java_lang_Boolean_a;
        }
        return bgo2.a(bgn.p);
    }

    protected static Boolean a(Class<?> clazz, bbk.d d2, boolean bl2, Boolean bl3) {
        bbk.c c2;
        bbk.c c3 = c2 = d2 == null ? null : d2.bbk$c_a();
        if (c2 == null) {
            return bl3;
        }
        if (c2 == bbk.c.var_bbk$c_a || c2 == bbk.c.c) {
            return bl3;
        }
        if (c2 == bbk.c.i || c2 == bbk.c.b) {
            return Boolean.FALSE;
        }
        if (c2.a() || c2 == bbk.c.d) {
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", new Object[]{c2, clazz.getName(), bl2 ? "class" : "property"}));
    }
}

