/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class bdc
implements Closeable {
    protected static final bfd<bdj> var_bfd_bdj__a;
    protected int var_int_a;
    protected transient bfh var_bfh_a;

    protected bdc() {
    }

    protected bdc(int n2) {
        this.var_int_a = n2;
    }

    public abstract bdg bdg_a();

    public void a(Object object) {
        bde bde2 = this.bde_a();
        if (bde2 != null) {
            bde2.void_a(object);
        }
    }

    public boolean boolean_a() {
        return false;
    }

    public bfd<bdj> a() {
        return var_bfd_bdj__a;
    }

    @Override
    public abstract void close();

    public abstract bde bde_a();

    public abstract bda bda_a();

    public abstract bda bda_b();

    public boolean a(a a2) {
        return a2.a(this.var_int_a);
    }

    @Deprecated
    public bdc bdc_a(int n2) {
        this.var_int_a = n2;
        return this;
    }

    public bdc bdc_a(int n2, int n3) {
        int n4 = this.var_int_a & ~n3 | n2 & n3;
        return this.bdc_a(n4);
    }

    public bdc bdc_b(int n2, int n3) {
        return this;
    }

    public abstract bdf bdf_a();

    public abstract bdf bdf_b();

    public String java_lang_String_a() {
        return this.bdf_a() == bdf.f ? this.java_lang_String_c() : null;
    }

    public String java_lang_String_b() {
        return this.bdf_a() == bdf.h ? this.java_lang_String_e() : null;
    }

    public abstract bdc bdc_a();

    public bdf bdf_c() {
        return this.bdf_d();
    }

    public int int_a() {
        return this.int_b();
    }

    public abstract bdf bdf_d();

    @Deprecated
    public abstract int int_b();

    public abstract boolean boolean_b();

    public abstract boolean boolean_a(int var1);

    public abstract boolean boolean_a(bdf var1);

    public boolean boolean_c() {
        return this.bdf_c() == bdf.var_bdf_d;
    }

    public boolean boolean_d() {
        return this.bdf_c() == bdf.var_bdf_b;
    }

    public boolean boolean_e() {
        return this.bdf_c() == bdf.i;
    }

    public boolean boolean_f() {
        return false;
    }

    public abstract void void_a();

    public abstract String java_lang_String_c();

    public String java_lang_String_d() {
        return this.java_lang_String_c();
    }

    public abstract String java_lang_String_e();

    public abstract char[] char_arr_a();

    public abstract int int_c();

    public abstract int int_d();

    public abstract boolean boolean_g();

    public abstract Number java_lang_Number_a();

    public Number java_lang_Number_b() {
        return this.java_lang_Number_a();
    }

    public abstract b bdc$b_a();

    public byte byte_a() {
        int n2 = this.int_e();
        if (n2 < -128 || n2 > 255) {
            throw new bdq(this, String.format("Numeric value (%s) out of range of Java byte", this.java_lang_String_e()), bdf.i, Byte.TYPE);
        }
        return (byte)n2;
    }

    public short short_a() {
        int n2 = this.int_e();
        if (n2 < Short.MIN_VALUE || n2 > Short.MAX_VALUE) {
            throw new bdq(this, String.format("Numeric value (%s) out of range of Java short", this.java_lang_String_e()), bdf.i, Short.TYPE);
        }
        return (short)n2;
    }

    public abstract int int_e();

    public abstract long long_a();

    public abstract BigInteger java_math_BigInteger_a();

    public abstract float float_a();

    public abstract double double_a();

    public abstract BigDecimal java_math_BigDecimal_a();

    public Object java_lang_Object_a() {
        return null;
    }

    public abstract byte[] byte_arr_a(bcq var1);

    public byte[] byte_arr_a() {
        return this.byte_arr_a(bcr.a());
    }

    public int a(bcq bcq2, OutputStream outputStream) {
        this.void_b();
        return 0;
    }

    public int int_f() {
        return this.int_a(0);
    }

    public int int_a(int n2) {
        return n2;
    }

    public long long_b() {
        return this.a(0L);
    }

    public long a(long l2) {
        return l2;
    }

    public String java_lang_String_f() {
        return this.java_lang_String_a((String)null);
    }

    public abstract String java_lang_String_a(String var1);

    public boolean boolean_h() {
        return false;
    }

    public boolean boolean_i() {
        return false;
    }

    public Object java_lang_Object_b() {
        return null;
    }

    public Object java_lang_Object_c() {
        return null;
    }

    protected bdb bdb_a(String string) {
        return new bdb(this, string).a(this.var_bfh_a);
    }

    protected void void_b() {
        throw new UnsupportedOperationException("Operation not supported by parser of type " + this.getClass().getName());
    }

    static {
        var_bfd_bdj__a = bfd.a(bdj.values());
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bdc$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        @Deprecated
        public static final /* enum */ a f;
        @Deprecated
        public static final /* enum */ a g;
        @Deprecated
        public static final /* enum */ a h;
        @Deprecated
        public static final /* enum */ a i;
        @Deprecated
        public static final /* enum */ a j;
        @Deprecated
        public static final /* enum */ a k;
        @Deprecated
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        private final boolean var_boolean_a;
        private final int var_int_a = 1 << this.ordinal();
        private static final /* synthetic */ a[] var_bdc$a_arr_a;

        public static a[] values() {
            return (a[])var_bdc$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        public static int int_a() {
            int n2 = 0;
            for (a a2 : bdc$a.values()) {
                if (!a2.boolean_a()) continue;
                n2 |= a2.b();
            }
            return n2;
        }

        private a(boolean bl2) {
            this.var_boolean_a = bl2;
        }

        public boolean boolean_a() {
            return this.var_boolean_a;
        }

        public boolean a(int n2) {
            return (n2 & this.var_int_a) != 0;
        }

        public int b() {
            return this.var_int_a;
        }

        static {
            var_bdc$a_a = new a(true);
            b = new a(false);
            c = new a(false);
            d = new a(false);
            e = new a(false);
            f = new a(false);
            g = new a(false);
            h = new a(false);
            i = new a(false);
            j = new a(false);
            k = new a(false);
            l = new a(false);
            m = new a(false);
            n = new a(false);
            o = new a(true);
            var_bdc$a_arr_a = new a[]{var_bdc$a_a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b var_bdc$b_a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        private static final /* synthetic */ b[] var_bdc$b_arr_a;

        public static b[] values() {
            return (b[])var_bdc$b_arr_a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        static {
            var_bdc$b_a = new b();
            b = new b();
            c = new b();
            d = new b();
            e = new b();
            f = new b();
            var_bdc$b_arr_a = new b[]{var_bdc$b_a, b, c, d, e, f};
        }
    }
}

