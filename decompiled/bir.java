/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class bir {
    public bir a(bfs bfs2, bfo bfo2) {
        return this;
    }

    public Class<?> a() {
        return Object.class;
    }

    public String java_lang_String_a() {
        Class<?> clazz = this.a();
        if (clazz == null) {
            return "UNKNOWN";
        }
        return clazz.getName();
    }

    public boolean boolean_a() {
        return this.i() || this.j() || this.k() || this.l() || this.boolean_b() || this.boolean_c() || this.d() || this.f() || this.h();
    }

    public boolean boolean_b() {
        return false;
    }

    public boolean boolean_c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this.bms_a() != null;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public bio[] bio_arr_a(bfr bfr2) {
        return null;
    }

    public bfw bfw_a(bfr bfr2) {
        return null;
    }

    public bfw b(bfr bfr2) {
        return null;
    }

    public Object a(bfs bfs2) {
        return bfs2.a(this.a(), this, null, "no default no-arguments constructor found", new Object[0]);
    }

    public Object a(bfs bfs2, Object[] objectArray) {
        return bfs2.a(this.a(), this, null, "no creator with arguments specified", new Object[0]);
    }

    public Object a(bfs bfs2, bio[] bioArray, bjr bjr2) {
        return this.a(bfs2, bjr2.a(bioArray));
    }

    public Object a(bfs bfs2, Object object) {
        return bfs2.a(this.a(), this, null, "no delegate creator specified", new Object[0]);
    }

    public Object b(bfs bfs2, Object object) {
        return bfs2.a(this.a(), this, null, "no array delegate creator specified", new Object[0]);
    }

    public Object a(bfs bfs2, String string) {
        return bfs2.a(this.a(), this, bfs2.bdc_a(), "no String-argument constructor/factory method to deserialize from String value ('%s')", string);
    }

    public Object a(bfs bfs2, int n2) {
        return bfs2.a(this.a(), this, null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", n2);
    }

    public Object a(bfs bfs2, long l2) {
        return bfs2.a(this.a(), this, null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", l2);
    }

    public Object a(bfs bfs2, BigInteger bigInteger) {
        return bfs2.a(this.a(), this, null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
    }

    public Object a(bfs bfs2, double d2) {
        return bfs2.a(this.a(), this, null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", d2);
    }

    public Object a(bfs bfs2, BigDecimal bigDecimal) {
        return bfs2.a(this.a(), this, null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
    }

    public Object a(bfs bfs2, boolean bl2) {
        return bfs2.a(this.a(), this, null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", bl2);
    }

    public bms bms_a() {
        return null;
    }

    public bms bms_b() {
        return null;
    }

    public bms bms_c() {
        return null;
    }

    public static class a
    extends bir
    implements Serializable {
        protected final Class<?> a;

        public a(Class<?> clazz) {
            this.a = clazz;
        }

        public a(bfw bfw2) {
            this.a = bfw2.a();
        }

        @Override
        public String java_lang_String_a() {
            return this.a.getName();
        }

        @Override
        public Class<?> a() {
            return this.a;
        }
    }
}

