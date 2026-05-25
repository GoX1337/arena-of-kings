/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

@bgp
public class blh
extends bir
implements Serializable {
    protected final String var_java_lang_String_a;
    protected final Class<?> var_java_lang_Class____a;
    protected bms var_bms_a;
    protected bms var_bms_b;
    protected bio[] var_bio_arr_a;
    protected bfw var_bfw_a;
    protected bms var_bms_c;
    protected bio[] var_bio_arr_b;
    protected bfw var_bfw_b;
    protected bms d;
    protected bio[] var_bio_arr_c;
    protected bms e;
    protected bms f;
    protected bms g;
    protected bms h;
    protected bms i;
    protected bms j;
    protected bms k;

    public blh(bfr bfr2, bfw bfw2) {
        this.var_java_lang_String_a = bfw2 == null ? "UNKNOWN TYPE" : bfw2.toString();
        this.var_java_lang_String_a = bfw2 == null ? Object.class : bfw2.a();
    }

    public void a(bms bms2, bms bms3, bfw bfw2, bio[] bioArray, bms bms4, bio[] bioArray2) {
        this.var_bms_a = bms2;
        this.var_bms_c = bms3;
        this.var_bfw_a = bfw2;
        this.var_bio_arr_b = bioArray;
        this.var_bms_b = bms4;
        this.var_bio_arr_a = bioArray2;
    }

    public void a(bms bms2, bfw bfw2, bio[] bioArray) {
        this.d = bms2;
        this.var_bfw_b = bfw2;
        this.var_bio_arr_c = bioArray;
    }

    public void a(bms bms2) {
        this.e = bms2;
    }

    public void b(bms bms2) {
        this.f = bms2;
    }

    public void c(bms bms2) {
        this.g = bms2;
    }

    public void d(bms bms2) {
        this.h = bms2;
    }

    public void e(bms bms2) {
        this.i = bms2;
    }

    public void f(bms bms2) {
        this.j = bms2;
    }

    public void g(bms bms2) {
        this.k = bms2;
    }

    @Override
    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    @Override
    public Class<?> a() {
        return this.var_java_lang_String_a;
    }

    @Override
    public boolean boolean_b() {
        return this.e != null;
    }

    @Override
    public boolean boolean_c() {
        return this.f != null;
    }

    @Override
    public boolean d() {
        return this.g != null;
    }

    @Override
    public boolean e() {
        return this.h != null;
    }

    @Override
    public boolean f() {
        return this.i != null;
    }

    @Override
    public boolean g() {
        return this.j != null;
    }

    @Override
    public boolean h() {
        return this.k != null;
    }

    @Override
    public boolean i() {
        return this.var_bms_a != null;
    }

    @Override
    public boolean j() {
        return this.var_bfw_a != null;
    }

    @Override
    public boolean k() {
        return this.var_bfw_b != null;
    }

    @Override
    public boolean l() {
        return this.var_bms_b != null;
    }

    @Override
    public boolean boolean_a() {
        return this.i() || this.j() || this.k() || this.l() || this.boolean_b() || this.boolean_c() || this.d() || this.f() || this.h();
    }

    @Override
    public bfw bfw_a(bfr bfr2) {
        return this.var_bfw_a;
    }

    @Override
    public bfw b(bfr bfr2) {
        return this.var_bfw_b;
    }

    @Override
    public bio[] bio_arr_a(bfr bfr2) {
        return this.var_bio_arr_a;
    }

    @Override
    public Object a(bfs bfs2) {
        if (this.var_bms_a == null) {
            return super.a(bfs2);
        }
        try {
            return this.var_bms_a.java_lang_Object_a();
        }
        catch (Exception exception) {
            return bfs2.a((Class<?>)((Object)this.var_java_lang_String_a), (Object)null, this.b(bfs2, exception));
        }
    }

    @Override
    public Object a(bfs bfs2, Object[] objectArray) {
        if (this.var_bms_b == null) {
            return super.a(bfs2, objectArray);
        }
        try {
            return this.var_bms_b.a(objectArray);
        }
        catch (Exception exception) {
            return bfs2.a((Class<?>)((Object)this.var_java_lang_String_a), (Object)objectArray, this.b(bfs2, exception));
        }
    }

    @Override
    public Object a(bfs bfs2, Object object) {
        if (this.var_bms_c == null && this.d != null) {
            return this.a(this.d, this.var_bio_arr_c, bfs2, object);
        }
        return this.a(this.var_bms_c, this.var_bio_arr_b, bfs2, object);
    }

    @Override
    public Object b(bfs bfs2, Object object) {
        if (this.d == null && this.var_bms_c != null) {
            return this.a(bfs2, object);
        }
        return this.a(this.d, this.var_bio_arr_c, bfs2, object);
    }

    @Override
    public Object a(bfs bfs2, String string) {
        if (this.e != null) {
            try {
                return this.e.a(string);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.e.b(), (Object)string, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, string);
    }

    @Override
    public Object a(bfs bfs2, int n2) {
        if (this.f != null) {
            Integer n3 = n2;
            try {
                return this.f.a(n3);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.f.b(), (Object)n3, this.b(bfs2, throwable));
            }
        }
        if (this.g != null) {
            Long l2 = n2;
            try {
                return this.g.a(l2);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.g.b(), (Object)l2, this.b(bfs2, throwable));
            }
        }
        if (this.h != null) {
            BigInteger bigInteger = BigInteger.valueOf(n2);
            try {
                return this.h.a(bigInteger);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.h.b(), (Object)bigInteger, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, n2);
    }

    @Override
    public Object a(bfs bfs2, long l2) {
        if (this.g != null) {
            Long l3 = l2;
            try {
                return this.g.a(l3);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.g.b(), (Object)l3, this.b(bfs2, throwable));
            }
        }
        if (this.h != null) {
            BigInteger bigInteger = BigInteger.valueOf(l2);
            try {
                return this.h.a(bigInteger);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.h.b(), (Object)bigInteger, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, l2);
    }

    @Override
    public Object a(bfs bfs2, BigInteger bigInteger) {
        if (this.h != null) {
            try {
                return this.h.a(bigInteger);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.h.b(), (Object)bigInteger, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, bigInteger);
    }

    @Override
    public Object a(bfs bfs2, double d2) {
        if (this.i != null) {
            Double d3 = d2;
            try {
                return this.i.a(d3);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.i.b(), (Object)d3, this.b(bfs2, throwable));
            }
        }
        if (this.j != null) {
            BigDecimal bigDecimal = BigDecimal.valueOf(d2);
            try {
                return this.j.a(bigDecimal);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.j.b(), (Object)bigDecimal, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, d2);
    }

    @Override
    public Object a(bfs bfs2, BigDecimal bigDecimal) {
        Double d2;
        if (this.j != null) {
            try {
                return this.j.a(bigDecimal);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.j.b(), (Object)bigDecimal, this.b(bfs2, throwable));
            }
        }
        if (this.i != null && (d2 = blh.a(bigDecimal)) != null) {
            try {
                return this.i.a(d2);
            }
            catch (Throwable throwable) {
                return bfs2.a(this.i.b(), (Object)d2, this.b(bfs2, throwable));
            }
        }
        return super.a(bfs2, bigDecimal);
    }

    static Double a(BigDecimal bigDecimal) {
        double d2 = bigDecimal.doubleValue();
        return Double.isInfinite(d2) ? null : Double.valueOf(d2);
    }

    @Override
    public Object a(bfs bfs2, boolean bl2) {
        if (this.k == null) {
            return super.a(bfs2, bl2);
        }
        Boolean bl3 = bl2;
        try {
            return this.k.a(bl3);
        }
        catch (Throwable throwable) {
            return bfs2.a(this.k.b(), (Object)bl3, this.b(bfs2, throwable));
        }
    }

    @Override
    public bms bms_b() {
        return this.var_bms_c;
    }

    @Override
    public bms bms_c() {
        return this.d;
    }

    @Override
    public bms bms_a() {
        return this.var_bms_a;
    }

    protected bfy a(bfs bfs2, Throwable throwable) {
        if (throwable instanceof bfy) {
            return (bfy)throwable;
        }
        return bfs2.a(this.a(), throwable);
    }

    protected bfy b(bfs bfs2, Throwable throwable) {
        Throwable throwable2;
        if ((throwable instanceof ExceptionInInitializerError || throwable instanceof InvocationTargetException) && (throwable2 = throwable.getCause()) != null) {
            throwable = throwable2;
        }
        return this.a(bfs2, throwable);
    }

    private Object a(bms bms2, bio[] bioArray, bfs bfs2, Object object) {
        if (bms2 == null) {
            throw new IllegalStateException("No delegate constructor for " + this.java_lang_String_a());
        }
        try {
            if (bioArray == null) {
                return bms2.a(object);
            }
            int n2 = bioArray.length;
            Object[] objectArray = new Object[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                bio bio2 = bioArray[i2];
                objectArray[i2] = bio2 == null ? object : bfs2.a(bio2.java_lang_Object_a(), (bfp)bio2, null);
            }
            return bms2.a(objectArray);
        }
        catch (Throwable throwable) {
            throw this.b(bfs2, throwable);
        }
    }
}

