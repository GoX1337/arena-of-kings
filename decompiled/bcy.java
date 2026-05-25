/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class bcy
implements Closeable,
Flushable {
    protected static final bfd<bdk> var_bfd_bdk__a;
    protected static final bfd<bdk> b;
    protected static final bfd<bdk> c;
    protected bdh var_bdh_a;

    protected bcy() {
    }

    public abstract bde bde_a();

    public void a(Object object) {
        bde bde2 = this.bde_a();
        if (bde2 != null) {
            bde2.void_a(object);
        }
    }

    public abstract bcy bcy_a(a var1);

    public abstract boolean boolean_a(a var1);

    public abstract int int_a();

    @Deprecated
    public abstract bcy bcy_a(int var1);

    public bcy bcy_a(int n2, int n3) {
        int n4 = this.int_a();
        int n5 = n4 & ~n3 | n2 & n3;
        return this.bcy_a(n5);
    }

    public bcy bcy_b(int n2, int n3) {
        return this;
    }

    public void a(bct bct2) {
        throw new UnsupportedOperationException(String.format("Generator of type %s does not support schema of type '%s'", this.getClass().getName(), bct2.a()));
    }

    public bcy a(bdh bdh2) {
        this.var_bdh_a = bdh2;
        return this;
    }

    public bdh bdh_a() {
        return this.var_bdh_a;
    }

    public bcy bcy_b(int n2) {
        return this;
    }

    public bcy a(bdu bdu2) {
        return this;
    }

    public bcy bcy_a(bdi bdi2) {
        throw new UnsupportedOperationException();
    }

    public boolean boolean_a() {
        return false;
    }

    public boolean boolean_b() {
        return false;
    }

    public boolean boolean_c() {
        return false;
    }

    public boolean boolean_d() {
        return true;
    }

    public abstract void void_a();

    @Deprecated
    public void void_a(int n2) {
        this.void_a();
    }

    public void b(Object object) {
        this.void_a();
        this.a(object);
    }

    public void a(Object object, int n2) {
        this.void_a(n2);
        this.a(object);
    }

    public abstract void void_b();

    public abstract void void_c();

    public void c(Object object) {
        this.void_c();
        this.a(object);
    }

    public void b(Object object, int n2) {
        this.void_c();
        this.a(object);
    }

    public abstract void void_d();

    public abstract void a(String var1);

    public abstract void void_a(bdi var1);

    public void a(long l2) {
        this.a(Long.toString(l2));
    }

    public void a(int[] nArray, int n2, int n3) {
        if (nArray == null) {
            throw new IllegalArgumentException("null array");
        }
        this.a(nArray.length, n2, n3);
        this.a(nArray, n3);
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; ++i2) {
            this.void_b(nArray[i2]);
        }
        this.void_b();
    }

    public void a(long[] lArray, int n2, int n3) {
        if (lArray == null) {
            throw new IllegalArgumentException("null array");
        }
        this.a(lArray.length, n2, n3);
        this.a(lArray, n3);
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; ++i2) {
            this.b(lArray[i2]);
        }
        this.void_b();
    }

    public void a(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            throw new IllegalArgumentException("null array");
        }
        this.a(dArray.length, n2, n3);
        this.a(dArray, n3);
        int n4 = n2 + n3;
        for (int i2 = n2; i2 < n4; ++i2) {
            this.a(dArray[i2]);
        }
        this.void_b();
    }

    public abstract void b(String var1);

    public abstract void a(char[] var1, int var2, int var3);

    public abstract void b(bdi var1);

    public abstract void c(String var1);

    public abstract void b(char[] var1, int var2, int var3);

    public abstract void a(char var1);

    public void c(bdi bdi2) {
        this.c(bdi2.java_lang_String_a());
    }

    public abstract void d(String var1);

    public void d(bdi bdi2) {
        this.d(bdi2.java_lang_String_a());
    }

    public abstract void a(bcq var1, byte[] var2, int var3, int var4);

    public void a(byte[] byArray, int n2, int n3) {
        this.a(bcr.a(), byArray, n2, n3);
    }

    public void a(byte[] byArray) {
        this.a(bcr.a(), byArray, 0, byArray.length);
    }

    public int a(InputStream inputStream, int n2) {
        return this.a(bcr.a(), inputStream, n2);
    }

    public abstract int a(bcq var1, InputStream var2, int var3);

    public void a(short s2) {
        this.void_b(s2);
    }

    public abstract void void_b(int var1);

    public abstract void b(long var1);

    public abstract void a(BigInteger var1);

    public abstract void a(double var1);

    public abstract void a(float var1);

    public abstract void void_a(BigDecimal var1);

    public abstract void e(String var1);

    public abstract void a(boolean var1);

    public abstract void e();

    public void d(Object object) {
        if (object == null) {
            this.e();
            return;
        }
        if (object instanceof byte[]) {
            this.a((byte[])object);
            return;
        }
        throw new bcx("No native support for writing embedded objects of type " + object.getClass().getName(), this);
    }

    public void e(Object object) {
        throw new bcx("No native support for writing Object Ids", this);
    }

    public void f(Object object) {
        throw new bcx("No native support for writing Object Ids", this);
    }

    public void g(Object object) {
        throw new bcx("No native support for writing Type Ids", this);
    }

    public beu a(beu beu2) {
        Object object = beu2.b;
        bdf bdf2 = beu2.var_bdf_a;
        if (this.boolean_b()) {
            beu2.var_boolean_a = false;
            this.g(object);
        } else {
            String string = object instanceof String ? (String)object : String.valueOf(object);
            beu2.var_boolean_a = true;
            beu.a a2 = beu2.var_beu$a_a;
            if (bdf2 != bdf.var_bdf_b && a2.a()) {
                beu2.var_beu$a_a = a2 = beu.a.var_beu$a_a;
            }
            switch (a2) {
                case e: {
                    break;
                }
                case d: {
                    break;
                }
                case c: {
                    this.c(beu2.var_java_lang_Object_a);
                    this.a(beu2.var_java_lang_String_a, string);
                    return beu2;
                }
                case b: {
                    this.void_c();
                    this.a(string);
                    break;
                }
                default: {
                    this.void_a();
                    this.b(string);
                }
            }
        }
        if (bdf2 == bdf.var_bdf_b) {
            this.c(beu2.var_java_lang_Object_a);
        } else if (bdf2 == bdf.var_bdf_d) {
            this.void_a();
        }
        return beu2;
    }

    public beu b(beu beu2) {
        bdf bdf2 = beu2.var_bdf_a;
        if (bdf2 == bdf.var_bdf_b) {
            this.void_d();
        } else if (bdf2 == bdf.var_bdf_d) {
            this.void_b();
        }
        if (beu2.var_boolean_a) {
            switch (beu2.var_beu$a_a) {
                case var_beu$a_a: {
                    this.void_b();
                    break;
                }
                case e: {
                    Object object = beu2.b;
                    String string = object instanceof String ? (String)object : String.valueOf(object);
                    this.a(beu2.var_java_lang_String_a, string);
                    break;
                }
                case d: 
                case c: {
                    break;
                }
                default: {
                    this.void_d();
                }
            }
        }
        return beu2;
    }

    public abstract void h(Object var1);

    public void a(String string, String string2) {
        this.a(string);
        this.b(string2);
    }

    public void f(String string) {
    }

    public void void_a(bdc bdc2) {
        bdf bdf2 = bdc2.bdf_c();
        int n2 = bdf2 == null ? -1 : bdf2.int_a();
        switch (n2) {
            case -1: {
                this.g("No current event to copy");
                break;
            }
            case 1: {
                this.void_c();
                break;
            }
            case 2: {
                this.void_d();
                break;
            }
            case 3: {
                this.void_a();
                break;
            }
            case 4: {
                this.void_b();
                break;
            }
            case 5: {
                this.a(bdc2.java_lang_String_c());
                break;
            }
            case 6: {
                if (bdc2.boolean_g()) {
                    this.a(bdc2.char_arr_a(), bdc2.int_d(), bdc2.int_c());
                    break;
                }
                this.b(bdc2.java_lang_String_e());
                break;
            }
            case 7: {
                bdc.b b2 = bdc2.bdc$b_a();
                if (b2 == bdc.b.var_bdc$b_a) {
                    this.void_b(bdc2.int_e());
                    break;
                }
                if (b2 == bdc.b.c) {
                    this.a((BigInteger)bdc2.java_lang_Number_a());
                    break;
                }
                this.b(bdc2.long_a());
                break;
            }
            case 8: {
                bdc.b b3 = bdc2.bdc$b_a();
                if (b3 == bdc.b.f) {
                    this.void_a((BigDecimal)bdc2.java_lang_Number_a());
                    break;
                }
                if (b3 == bdc.b.d) {
                    this.a(bdc2.float_a());
                    break;
                }
                this.a(bdc2.double_a());
                break;
            }
            case 9: {
                this.a(true);
                break;
            }
            case 10: {
                this.a(false);
                break;
            }
            case 11: {
                this.e();
                break;
            }
            case 12: {
                this.h(bdc2.java_lang_Object_a());
                break;
            }
            default: {
                throw new IllegalStateException("Internal error: unknown current token, " + (Object)((Object)bdf2));
            }
        }
    }

    public void b(bdc bdc2) {
        int n2;
        bdf bdf2 = bdc2.bdf_c();
        int n3 = n2 = bdf2 == null ? -1 : bdf2.int_a();
        if (n2 == 5) {
            this.a(bdc2.java_lang_String_c());
            bdf2 = bdc2.bdf_a();
            n2 = bdf2 == null ? -1 : bdf2.int_a();
        }
        switch (n2) {
            case 1: {
                this.void_c();
                this.c(bdc2);
                return;
            }
            case 3: {
                this.void_a();
                this.c(bdc2);
                return;
            }
        }
        this.void_a(bdc2);
    }

    protected void c(bdc bdc2) {
        bdf bdf2;
        int n2 = 1;
        block14: while ((bdf2 = bdc2.bdf_a()) != null) {
            switch (bdf2.int_a()) {
                case 5: {
                    this.a(bdc2.java_lang_String_c());
                    continue block14;
                }
                case 3: {
                    this.void_a();
                    ++n2;
                    continue block14;
                }
                case 1: {
                    this.void_c();
                    ++n2;
                    continue block14;
                }
                case 4: {
                    this.void_b();
                    if (--n2 != 0) continue block14;
                    return;
                }
                case 2: {
                    this.void_d();
                    if (--n2 != 0) continue block14;
                    return;
                }
                case 6: {
                    if (bdc2.boolean_g()) {
                        this.a(bdc2.char_arr_a(), bdc2.int_d(), bdc2.int_c());
                        continue block14;
                    }
                    this.b(bdc2.java_lang_String_e());
                    continue block14;
                }
                case 7: {
                    bdc.b b2 = bdc2.bdc$b_a();
                    if (b2 == bdc.b.var_bdc$b_a) {
                        this.void_b(bdc2.int_e());
                        continue block14;
                    }
                    if (b2 == bdc.b.c) {
                        this.a((BigInteger)bdc2.java_lang_Number_a());
                        continue block14;
                    }
                    this.b(bdc2.long_a());
                    continue block14;
                }
                case 8: {
                    bdc.b b2 = bdc2.bdc$b_a();
                    if (b2 == bdc.b.f) {
                        this.void_a((BigDecimal)bdc2.java_lang_Number_a());
                        continue block14;
                    }
                    if (b2 == bdc.b.d) {
                        this.a(bdc2.float_a());
                        continue block14;
                    }
                    this.a(bdc2.double_a());
                    continue block14;
                }
                case 9: {
                    this.a(true);
                    continue block14;
                }
                case 10: {
                    this.a(false);
                    continue block14;
                }
                case 11: {
                    this.e();
                    continue block14;
                }
                case 12: {
                    this.h(bdc2.java_lang_Object_a());
                    continue block14;
                }
            }
            throw new IllegalStateException("Internal error: unknown current token, " + (Object)((Object)bdf2));
        }
    }

    @Override
    public abstract void flush();

    @Override
    public abstract void close();

    protected void g(String string) {
        throw new bcx(string, this);
    }

    protected final void f() {
        bfl.a();
    }

    protected void g() {
        throw new UnsupportedOperationException("Operation not supported by generator of type " + this.getClass().getName());
    }

    protected final void a(int n2, int n3, int n4) {
        if (n3 < 0 || n3 + n4 > n2) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", n3, n4, n2));
        }
    }

    protected void i(Object object) {
        if (object == null) {
            this.e();
            return;
        }
        if (object instanceof String) {
            this.b((String)object);
            return;
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            if (number instanceof Integer) {
                this.void_b(number.intValue());
                return;
            }
            if (number instanceof Long) {
                this.b(number.longValue());
                return;
            }
            if (number instanceof Double) {
                this.a(number.doubleValue());
                return;
            }
            if (number instanceof Float) {
                this.a(number.floatValue());
                return;
            }
            if (number instanceof Short) {
                this.a(number.shortValue());
                return;
            }
            if (number instanceof Byte) {
                this.a(number.byteValue());
                return;
            }
            if (number instanceof BigInteger) {
                this.a((BigInteger)number);
                return;
            }
            if (number instanceof BigDecimal) {
                this.void_a((BigDecimal)number);
                return;
            }
            if (number instanceof AtomicInteger) {
                this.void_b(((AtomicInteger)number).get());
                return;
            }
            if (number instanceof AtomicLong) {
                this.b(((AtomicLong)number).get());
                return;
            }
        } else {
            if (object instanceof byte[]) {
                this.a((byte[])object);
                return;
            }
            if (object instanceof Boolean) {
                this.a((Boolean)object);
                return;
            }
            if (object instanceof AtomicBoolean) {
                this.a(((AtomicBoolean)object).get());
                return;
            }
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + object.getClass().getName() + ")");
    }

    static {
        var_bfd_bdk__a = bfd.a(bdk.values());
        b = var_bfd_bdk__a.a(bdk.b);
        c = var_bfd_bdk__a.a(bdk.var_bdk_a);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bcy$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        @Deprecated
        public static final /* enum */ a d;
        @Deprecated
        public static final /* enum */ a e;
        @Deprecated
        public static final /* enum */ a f;
        @Deprecated
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        private final boolean var_boolean_a;
        private final int var_int_a;
        private static final /* synthetic */ a[] var_bcy$a_arr_a;

        public static a[] values() {
            return (a[])var_bcy$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        public static int int_a() {
            int n2 = 0;
            for (a a2 : bcy$a.values()) {
                if (!a2.boolean_a()) continue;
                n2 |= a2.b();
            }
            return n2;
        }

        private a(boolean bl2) {
            this.var_boolean_a = bl2;
            this.var_int_a = 1 << this.ordinal();
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
            var_bcy$a_a = new a(true);
            b = new a(true);
            c = new a(true);
            d = new a(true);
            e = new a(true);
            f = new a(false);
            g = new a(false);
            h = new a(false);
            i = new a(false);
            j = new a(false);
            var_bcy$a_arr_a = new a[]{var_bcy$a_a, b, c, d, e, f, g, h, i, j};
        }
    }
}

