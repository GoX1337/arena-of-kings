/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class bhm<T extends bhm<T>>
implements bmy.a,
Serializable {
    protected static final bbr.b var_bbr$b_a;
    protected static final bbk.d var_bbk$d_a;
    protected final int f;
    protected final bgz var_bgz_a;

    protected bhm(bgz bgz2, int n2) {
        this.var_bgz_a = bgz2;
        this.f = n2;
    }

    protected bhm(bhm<T> bhm2, int n2) {
        this.var_bgz_a = bhm2.var_bgz_a;
        this.f = n2;
    }

    public static <F extends Enum<F>> int int_a(Class<F> clazz) {
        int n2 = 0;
        for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
            if (!((bhf)((Object)enum_)).boolean_a()) continue;
            n2 |= ((bhf)((Object)enum_)).int_a();
        }
        return n2;
    }

    public final boolean a(bgd bgd2) {
        return bgd2.a(this.f);
    }

    public final boolean b() {
        return this.a(bgd.var_bgd_a);
    }

    public final boolean c() {
        return this.a(bgd.n);
    }

    public final boolean d() {
        return this.a(bgd.t);
    }

    public bdi a(String string) {
        return new bee(string);
    }

    public bmy bmy_a() {
        return this.var_bgz_a.bmy_a();
    }

    public bfn bfn_a() {
        if (this.a(bgd.var_bgd_a)) {
            return this.var_bgz_a.bfn_a();
        }
        return bng.a;
    }

    public final bgk bgk_a() {
        return this.var_bgz_a.bgk_a();
    }

    public final bmf.a bmf$a_a() {
        return this.var_bgz_a.bmf$a_a();
    }

    public final bhl bhl_a() {
        return this.var_bgz_a.bhl_a();
    }

    public final bof<?> a(bfw bfw2) {
        return this.var_bgz_a.a();
    }

    public boa boa_a() {
        boa boa2 = this.var_bgz_a.boa_a();
        if (boa2 == bot.a && this.a(bgd.E)) {
            boa2 = new bny();
        }
        return boa2;
    }

    public final btz btz_a() {
        return this.var_bgz_a.btz_a();
    }

    public final bfw bfw_a(Class<?> clazz) {
        return this.btz_a().a((Type)clazz);
    }

    public bfo bfo_a(Class<?> clazz) {
        return this.c(this.bfw_a(clazz));
    }

    public bfo c(bfw bfw2) {
        return this.bmy_a().bfo_a(this, bfw2, (bmy.a)this);
    }

    public abstract bhg bhg_a(Class<?> var1);

    public abstract bbr.b bbr$b_a(Class<?> var1);

    public bbr.b a(Class<?> clazz, bbr.b b2) {
        bbr.b b3 = this.bhg_a(clazz).bbr$b_a();
        if (b3 != null) {
            return b3;
        }
        return b2;
    }

    public abstract bbr.b a(Class<?> var1, Class<?> var2);

    public bbr.b a(Class<?> clazz, Class<?> clazz2, bbr.b b2) {
        bbr.b b3 = this.bhg_a(clazz).bbr$b_a();
        bbr.b b4 = this.bhg_a(clazz2).bbr$b_b();
        bbr.b b5 = bbr.b.a(b2, b3, b4);
        return b5;
    }

    public abstract bbk.d bbk$d_a(Class<?> var1);

    public abstract bnu<?> a(Class<?> var1, bmh var2);

    public abstract bcb.a bcb$a_a();

    public abstract Boolean java_lang_Boolean_a();

    public final DateFormat java_text_DateFormat_a() {
        return this.var_bgz_a.java_text_DateFormat_a();
    }

    public final Locale java_util_Locale_a() {
        return this.var_bgz_a.java_util_Locale_a();
    }

    public final TimeZone java_util_TimeZone_a() {
        return this.var_bgz_a.java_util_TimeZone_a();
    }

    public bcq bcq_a() {
        return this.var_bgz_a.bcq_a();
    }

    public bof<?> a(bmg bmg2, Class<? extends bof<?>> clazz) {
        bof<?> bof2;
        bhl bhl2 = this.bhl_a();
        if (bhl2 != null && (bof2 = bhl2.a(this, bmg2, clazz)) != null) {
            return bof2;
        }
        return (bof)buk.a(clazz, this.c());
    }

    public boe a(bmg bmg2, Class<? extends boe> clazz) {
        boe boe2;
        bhl bhl2 = this.bhl_a();
        if (bhl2 != null && (boe2 = bhl2.boe_a(this, bmg2, clazz)) != null) {
            return boe2;
        }
        return (boe)buk.a(clazz, this.c());
    }

    static {
        var_bbr$b_a = bbr.b.bbr$b_a();
        var_bbk$d_a = bbk.d.bbk$d_a();
    }
}

