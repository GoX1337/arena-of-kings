/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class bgo
extends bfq {
    public static final bgb<Object> var_bgb_java_lang_Object__a;
    protected static final bgb<Object> b;
    protected final bgm var_bgm_a;
    protected final Class<?> var_java_lang_Class____a;
    protected final bqq var_bqq_a;
    protected final bqp var_bqp_a;
    protected transient bhj var_bhj_a;
    protected bgb<Object> c = b;
    protected bgb<Object> d;
    protected bgb<Object> e = bsn.a;
    protected bgb<Object> f = var_bgb_java_lang_Object__a;
    protected final brf var_brf_a;
    protected DateFormat var_java_text_DateFormat_a;
    protected final boolean var_boolean_a;

    public bgo() {
        this.var_bgm_a = null;
        this.var_bqq_a = null;
        this.var_bqp_a = new bqp();
        this.var_brf_a = null;
        this.var_bgb_java_lang_Object__a = null;
        this.var_bhj_a = null;
        this.var_boolean_a = true;
    }

    protected bgo(bgo bgo2, bgm bgm2, bqq bqq2) {
        this.var_bqq_a = bqq2;
        this.var_bgm_a = bgm2;
        this.var_bqp_a = bgo2.var_bqp_a;
        this.c = bgo2.c;
        this.d = bgo2.d;
        this.e = bgo2.e;
        this.f = bgo2.f;
        this.var_boolean_a = this.e == var_bgb_java_lang_Object__a;
        this.var_bgb_java_lang_Object__a = bgm2.a();
        this.var_bhj_a = bgm2.bhj_a();
        this.var_brf_a = this.var_bqp_a.a();
    }

    public final bgm bgm_a() {
        return this.var_bgm_a;
    }

    public final bfn bfn_a() {
        return this.var_bgm_a.bfn_a();
    }

    @Override
    public final btz btz_a() {
        return this.var_bgm_a.btz_a();
    }

    public bfw a(bfw bfw2, Class<?> clazz) {
        if (bfw2.boolean_a(clazz)) {
            return bfw2;
        }
        return this.bgm_a().btz_a().a(bfw2, clazz, true);
    }

    public final Class<?> a() {
        return this.var_bgb_java_lang_Object__a;
    }

    public final boolean boolean_a() {
        return this.var_bgm_a.c();
    }

    public final boolean a(bgd bgd2) {
        return this.var_bgm_a.a(bgd2);
    }

    public final bbk.d bbk$d_a(Class<?> clazz) {
        return this.var_bgm_a.bbk$d_a(clazz);
    }

    public final bbr.b bbr$b_a(Class<?> clazz) {
        return this.var_bgm_a.bbr$b_a(clazz);
    }

    public Locale java_util_Locale_a() {
        return this.var_bgm_a.java_util_Locale_a();
    }

    public TimeZone java_util_TimeZone_a() {
        return this.var_bgm_a.java_util_TimeZone_a();
    }

    public Object java_lang_Object_a(Object object) {
        return this.var_bhj_a.a(object);
    }

    public bgo a(Object object, Object object2) {
        this.var_bhj_a = this.var_bhj_a.a(object, object2);
        return this;
    }

    public final boolean a(bgn bgn2) {
        return this.var_bgm_a.a(bgn2);
    }

    public final bqj bqj_a() {
        return this.var_bgm_a.bqj_a();
    }

    public bcy bcy_a() {
        return null;
    }

    public abstract brp a(Object var1, bck<?> var2);

    public bgb<Object> a(Class<?> clazz, bfp bfp2) {
        bgb<Object> bgb2 = this.var_brf_a.b(clazz);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(clazz)) == null && (bgb2 = this.var_bqp_a.a(this.var_bgm_a.bfw_a(clazz))) == null && (bgb2 = this.c(clazz)) == null) {
            bgb2 = this.b(clazz);
            return bgb2;
        }
        return this.b(bgb2, bfp2);
    }

    public bgb<Object> a(bfw bfw2, bfp bfp2) {
        bgb<Object> bgb2;
        if (bfw2 == null) {
            this.void_a("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        }
        if ((bgb2 = this.var_brf_a.b(bfw2)) == null && (bgb2 = this.var_bqp_a.a(bfw2)) == null && (bgb2 = this.b(bfw2)) == null) {
            bgb2 = this.b((Class<?>)bfw2.a());
            return bgb2;
        }
        return this.b(bgb2, bfp2);
    }

    public bgb<Object> a(Class<?> clazz) {
        bgb<Object> bgb2 = this.var_brf_a.b(clazz);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(clazz)) == null && (bgb2 = this.var_bqp_a.a(this.var_bgm_a.bfw_a(clazz))) == null && (bgb2 = this.c(clazz)) == null) {
            bgb2 = this.b(clazz);
        }
        return bgb2;
    }

    public bgb<Object> a(bfw bfw2) {
        bgb<Object> bgb2 = this.var_brf_a.b(bfw2);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(bfw2)) == null && (bgb2 = this.b(bfw2)) == null) {
            bgb2 = this.b((Class<?>)bfw2.a());
        }
        return bgb2;
    }

    public bgb<Object> b(bfw bfw2, bfp bfp2) {
        bgb<Object> bgb2 = this.var_brf_a.b(bfw2);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(bfw2)) == null && (bgb2 = this.b(bfw2)) == null) {
            bgb2 = this.b((Class<?>)bfw2.a());
            return bgb2;
        }
        return this.a(bgb2, bfp2);
    }

    public bgb<Object> b(Class<?> clazz, bfp bfp2) {
        bgb<Object> bgb2 = this.var_brf_a.b(clazz);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(clazz)) == null && (bgb2 = this.var_bqp_a.a(this.var_bgm_a.bfw_a(clazz))) == null && (bgb2 = this.c(clazz)) == null) {
            bgb2 = this.b(clazz);
            return bgb2;
        }
        return this.a(bgb2, bfp2);
    }

    public bgb<Object> c(bfw bfw2, bfp bfp2) {
        bgb<Object> bgb2 = this.var_brf_a.b(bfw2);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(bfw2)) == null && (bgb2 = this.b(bfw2)) == null) {
            bgb2 = this.b((Class<?>)bfw2.a());
            return bgb2;
        }
        return this.b(bgb2, bfp2);
    }

    public bgb<Object> c(Class<?> clazz, bfp bfp2) {
        bgb<Object> bgb2 = this.var_brf_a.b(clazz);
        if (bgb2 == null && (bgb2 = this.var_bqp_a.a(clazz)) == null && (bgb2 = this.var_bqp_a.a(this.var_bgm_a.bfw_a(clazz))) == null && (bgb2 = this.c(clazz)) == null) {
            bgb2 = this.b(clazz);
            return bgb2;
        }
        return this.b(bgb2, bfp2);
    }

    public bgb<Object> a(Class<?> clazz, boolean bl2, bfp bfp2) {
        bgb bgb2 = this.var_brf_a.a(clazz);
        if (bgb2 != null) {
            return bgb2;
        }
        bgb2 = this.var_bqp_a.b(clazz);
        if (bgb2 != null) {
            return bgb2;
        }
        bgb2 = this.a(clazz, bfp2);
        bog bog2 = this.var_bqq_a.a(this.var_bgm_a, this.var_bgm_a.bfw_a(clazz));
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
            bgb2 = new brk(bog2, bgb2);
        }
        if (bl2) {
            this.var_bqp_a.a(clazz, bgb2);
        }
        return bgb2;
    }

    public bgb<Object> a(bfw bfw2, boolean bl2, bfp bfp2) {
        bgb bgb2 = this.var_brf_a.a(bfw2);
        if (bgb2 != null) {
            return bgb2;
        }
        bgb2 = this.var_bqp_a.b(bfw2);
        if (bgb2 != null) {
            return bgb2;
        }
        bgb2 = this.a(bfw2, bfp2);
        bog bog2 = this.var_bqq_a.a(this.var_bgm_a, bfw2);
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
            bgb2 = new brk(bog2, bgb2);
        }
        if (bl2) {
            this.var_bqp_a.a(bfw2, bgb2);
        }
        return bgb2;
    }

    public bog a(bfw bfw2) {
        return this.var_bqq_a.a(this.var_bgm_a, bfw2);
    }

    public bgb<Object> d(bfw bfw2, bfp bfp2) {
        bgb<Object> bgb2 = this.var_bqq_a.a(this, bfw2, this.d);
        return this.c(bgb2, bfp2);
    }

    public bgb<Object> d(Class<?> clazz, bfp bfp2) {
        return this.d(this.var_bgm_a.bfw_a(clazz), bfp2);
    }

    public bgb<Object> a() {
        return this.e;
    }

    public bgb<Object> e(bfw bfw2, bfp bfp2) {
        return this.f;
    }

    public bgb<Object> a(bfp bfp2) {
        return this.e;
    }

    public bgb<Object> b(Class<?> clazz) {
        if (clazz == Object.class) {
            return this.c;
        }
        return new brl(clazz);
    }

    public abstract bgb<Object> a(bmg var1, Object var2);

    public abstract Object a(bmx var1, Class<?> var2);

    public abstract boolean boolean_a(Object var1);

    public bgb<?> a(bgb<?> bgb2, bfp bfp2) {
        if (bgb2 != null && bgb2 instanceof bqh) {
            bgb2 = ((bqh)((Object)bgb2)).a(this, bfp2);
        }
        return bgb2;
    }

    public bgb<?> b(bgb<?> bgb2, bfp bfp2) {
        if (bgb2 != null && bgb2 instanceof bqh) {
            bgb2 = ((bqh)((Object)bgb2)).a(this, bfp2);
        }
        return bgb2;
    }

    public final void a(Object object, bcy bcy2) {
        if (object == null) {
            if (this.var_boolean_a) {
                bcy2.e();
            } else {
                this.e.a(null, bcy2, this);
            }
        } else {
            Class<?> clazz = object.getClass();
            this.a(clazz, true, null).a(object, bcy2, this);
        }
    }

    public final void a(Date date, bcy bcy2) {
        if (this.a(bgn.j)) {
            bcy2.b(date.getTime());
        } else {
            bcy2.b(this.java_text_DateFormat_a().format(date));
        }
    }

    public void a(long l2, bcy bcy2) {
        if (this.a(bgn.k)) {
            bcy2.a(String.valueOf(l2));
        } else {
            bcy2.a(this.java_text_DateFormat_a().format(new Date(l2)));
        }
    }

    public void b(Date date, bcy bcy2) {
        if (this.a(bgn.k)) {
            bcy2.a(String.valueOf(date.getTime()));
        } else {
            bcy2.a(this.java_text_DateFormat_a().format(date));
        }
    }

    public final void a(bcy bcy2) {
        if (this.var_boolean_a) {
            bcy2.e();
        } else {
            this.e.a(null, bcy2, this);
        }
    }

    public void void_a(String string, Object ... objectArray) {
        throw this.bfy_a(string, objectArray);
    }

    public <T> T a(bfo bfo2, String string, Object ... objectArray) {
        String string2 = "N/A";
        if (bfo2 != null) {
            string2 = buk.java_lang_String_b(bfo2.a());
        }
        string = String.format("Invalid type definition for type %s: %s", string2, this.java_lang_String_a(string, objectArray));
        throw blq.a(this.bcy_a(), string, bfo2, null);
    }

    public <T> T a(bfo bfo2, bmx bmx2, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        String string2 = "N/A";
        if (bmx2 != null) {
            string2 = this.b(bmx2.java_lang_String_a());
        }
        String string3 = "N/A";
        if (bfo2 != null) {
            string3 = buk.java_lang_String_b(bfo2.a());
        }
        string = String.format("Invalid definition for property %s (of type %s): %s", string2, string3, string);
        throw blq.a(this.bcy_a(), string, bfo2, bmx2);
    }

    @Override
    public <T> T b(bfw bfw2, String string) {
        throw blq.a(this.bcy_a(), string, bfw2);
    }

    public <T> T a(Class<?> clazz, String string, Throwable throwable) {
        blq blq2 = blq.a(this.bcy_a(), string, this.a((Type)clazz));
        blq2.initCause(throwable);
        throw blq2;
    }

    public void a(Throwable throwable, String string, Object ... objectArray) {
        string = this.java_lang_String_a(string, objectArray);
        throw bfy.a(this.bcy_a(), string, throwable);
    }

    @Override
    public bfy a(bfw bfw2, String string, String string2) {
        String string3 = String.format("Could not resolve type id '%s' as a subtype of %s", string, buk.a(bfw2));
        return blt.a(null, this.a(string3, string2), bfw2, string);
    }

    @Deprecated
    public bfy bfy_a(String string, Object ... objectArray) {
        return bfy.a(this.bcy_a(), this.java_lang_String_a(string, objectArray));
    }

    protected void a(Object object, bfw bfw2) {
        Class<?> clazz;
        if (bfw2.k() && (clazz = buk.b(bfw2.a())).isAssignableFrom(object.getClass())) {
            return;
        }
        this.b(bfw2, String.format("Incompatible types: declared root type (%s) vs %s", bfw2, buk.c(object)));
    }

    protected bgb<Object> c(Class<?> clazz) {
        bgb<Object> bgb2;
        bfw bfw2 = this.var_bgm_a.bfw_a(clazz);
        try {
            bgb2 = this.c(bfw2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            bgb2 = null;
            this.a(illegalArgumentException, buk.java_lang_String_a(illegalArgumentException), new Object[0]);
        }
        if (bgb2 != null) {
            this.var_bqp_a.a(clazz, bfw2, bgb2, this);
        }
        return bgb2;
    }

    protected bgb<Object> b(bfw bfw2) {
        bgb<Object> bgb2;
        try {
            bgb2 = this.c(bfw2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            bgb2 = null;
            this.a(illegalArgumentException, buk.java_lang_String_a(illegalArgumentException), new Object[0]);
        }
        if (bgb2 != null) {
            this.var_bqp_a.a(bfw2, bgb2, this);
        }
        return bgb2;
    }

    protected bgb<Object> c(bfw bfw2) {
        return this.var_bqq_a.a(this, bfw2);
    }

    protected bgb<Object> c(bgb<?> bgb2, bfp bfp2) {
        if (bgb2 instanceof bqo) {
            ((bqo)((Object)bgb2)).void_a(this);
        }
        return this.b(bgb2, bfp2);
    }

    protected bgb<Object> a(bgb<?> bgb2) {
        if (bgb2 instanceof bqo) {
            ((bqo)((Object)bgb2)).void_a(this);
        }
        return bgb2;
    }

    protected final DateFormat java_text_DateFormat_a() {
        if (this.var_java_text_DateFormat_a != null) {
            return this.var_java_text_DateFormat_a;
        }
        DateFormat dateFormat = this.var_bgm_a.java_text_DateFormat_a();
        this.var_java_text_DateFormat_a = dateFormat = (DateFormat)dateFormat.clone();
        return dateFormat;
    }

    static {
        var_bgb_java_lang_Object__a = new bqv("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
        b = new brl();
    }
}

