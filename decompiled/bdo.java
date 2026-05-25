/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public abstract class bdo
extends bdp {
    protected static final bfd<bdj> var_bfd_bdj__b;
    protected final bdv var_bdv_a;
    protected boolean var_boolean_a;
    protected int var_int_b;
    protected int var_int_c;
    protected long var_long_a;
    protected int d = 1;
    protected int e;
    protected long var_long_b;
    protected int f = 1;
    protected int g;
    protected bek var_bek_a;
    protected bdf var_bdf_a;
    protected final bfj var_bfj_a;
    protected char[] var_char_arr_a;
    protected boolean var_boolean_b;
    protected bex var_bex_a;
    protected byte[] var_byte_arr_a;
    protected int h = 0;
    protected int i;
    protected long var_long_c;
    protected double var_double_a;
    protected BigInteger var_java_math_BigInteger_a;
    protected BigDecimal var_java_math_BigDecimal_a;
    protected boolean var_boolean_c;
    protected int j;
    protected int k;
    protected int l;

    protected bdo(bdv bdv2, int n2) {
        super(n2);
        this.var_bdv_a = bdv2;
        this.var_bfj_a = bdv2.java_lang_Object_a();
        bei bei2 = bdc.a.m.a(n2) ? bei.a(this) : null;
        this.var_bek_a = bek.b(bei2);
    }

    @Override
    public void a(Object object) {
        this.var_bek_a.void_a(object);
    }

    @Override
    @Deprecated
    public bdc bdc_a(int n2) {
        int n3 = this.var_bdv_a ^ n2;
        if (n3 != 0) {
            this.var_bdv_a = (bdv)n2;
            this.void_a(n2, n3);
        }
        return this;
    }

    @Override
    public bdc bdc_a(int n2, int n3) {
        bdv bdv2 = this.var_bdv_a;
        int n4 = bdv2 & ~n3 | n2 & n3;
        int n5 = bdv2 ^ n4;
        if (n5 != 0) {
            this.var_bdv_a = (bdv)n4;
            this.void_a(n4, n5);
        }
        return this;
    }

    protected void void_a(int n2, int n3) {
        int n4 = bdc.a.m.b();
        if ((n3 & n4) != 0 && (n2 & n4) != 0) {
            this.var_bek_a = this.var_bek_a.java_lang_Object_a() == null ? this.var_bek_a.a(bei.a(this)) : this.var_bek_a.a((bei)null);
        }
    }

    @Override
    public String java_lang_String_c() {
        Object object;
        if ((this.var_bfd_bdj__b == bdf.var_bdf_b || this.var_bfd_bdj__b == bdf.var_bdf_d) && (object = this.var_bek_a.java_lang_Object_a()) != null) {
            return ((bek)object).java_lang_String_b();
        }
        return this.var_bek_a.java_lang_String_b();
    }

    @Override
    public void close() {
        if (!this.var_boolean_a) {
            this.var_int_b = Math.max(this.var_int_b, this.var_int_c);
            this.var_boolean_a = true;
            try {
                this.void_c();
            }
            finally {
                this.void_d();
            }
        }
    }

    @Override
    public bek bek_a() {
        return this.var_bek_a;
    }

    @Override
    public bda bda_a() {
        return new bda(this.java_lang_Object_d(), -1L, this.long_c(), this.int_g(), this.int_h());
    }

    @Override
    public bda bda_b() {
        int n2 = this.var_int_b - this.e + 1;
        return new bda(this.java_lang_Object_d(), -1L, this.var_long_a + (long)this.var_int_b, this.d, n2);
    }

    @Override
    public boolean boolean_g() {
        if (this.var_bfd_bdj__b == bdf.h) {
            return true;
        }
        if (this.var_bfd_bdj__b == bdf.f) {
            return this.var_boolean_b;
        }
        return false;
    }

    @Override
    public byte[] byte_arr_a(bcq bcq2) {
        if (this.var_byte_arr_a == null) {
            if (this.var_bfd_bdj__b != bdf.h) {
                this.d("Current token (" + this.var_bfd_bdj__b + ") not VALUE_STRING, can not access as binary");
            }
            bex bex2 = this.bex_a();
            this.a(this.java_lang_String_e(), bex2, bcq2);
            this.var_byte_arr_a = bex2.byte_arr_a();
        }
        return this.var_byte_arr_a;
    }

    public long long_c() {
        return this.var_long_b;
    }

    public int int_g() {
        return this.f;
    }

    public int int_h() {
        int n2 = this.g;
        return n2 < 0 ? n2 : n2 + 1;
    }

    protected abstract void void_c();

    protected void void_d() {
        this.var_bfj_a.void_a();
        char[] cArray = this.var_char_arr_a;
        if (cArray != null) {
            this.var_char_arr_a = null;
            this.var_bdv_a.c(cArray);
        }
    }

    @Override
    protected void void_e() {
        if (!this.var_bek_a.boolean_b()) {
            String string = this.var_bek_a.boolean_a() ? "Array" : "Object";
            this.c(String.format(": expected close marker for %s (start marker at %s)", string, this.var_bek_a.bda_a(this.java_lang_Object_d())), null);
        }
    }

    protected final int int_i() {
        this.void_e();
        return -1;
    }

    @Override
    public bex bex_a() {
        if (this.var_bex_a == null) {
            this.var_bex_a = new bex();
        } else {
            this.var_bex_a.void_a();
        }
        return this.var_bex_a;
    }

    protected final bdf a(boolean bl2, int n2, int n3, int n4) {
        if (n3 < 1 && n4 < 1) {
            return this.a(bl2, n2);
        }
        return this.b(bl2, n2, n3, n4);
    }

    protected final bdf a(boolean bl2, int n2) {
        this.var_boolean_c = bl2;
        this.j = n2;
        this.k = 0;
        this.l = 0;
        this.h = 0;
        return bdf.i;
    }

    protected final bdf b(boolean bl2, int n2, int n3, int n4) {
        this.var_boolean_c = bl2;
        this.j = n2;
        this.k = n3;
        this.l = n4;
        this.h = 0;
        return bdf.j;
    }

    protected final bdf a(String string, double d2) {
        this.var_bfj_a.a(string);
        this.var_double_a = d2;
        this.h = 8;
        return bdf.j;
    }

    @Override
    public boolean boolean_f() {
        if (this.var_bfd_bdj__b == bdf.j && (this.h & 8) != 0) {
            double d2 = this.var_double_a;
            return Double.isNaN(d2) || Double.isInfinite(d2);
        }
        return false;
    }

    @Override
    public Number java_lang_Number_a() {
        if (this.h == 0) {
            this.void_a(0);
        }
        if (this.var_bfd_bdj__b == bdf.i) {
            if ((this.h & 1) != 0) {
                return this.i;
            }
            if ((this.h & 2) != 0) {
                return this.var_long_c;
            }
            if ((this.h & 4) != 0) {
                return this.var_java_math_BigInteger_a;
            }
            this.void_o();
        }
        if ((this.h & 0x10) != 0) {
            return this.var_java_math_BigDecimal_a;
        }
        if ((this.h & 8) == 0) {
            this.void_o();
        }
        return this.var_double_a;
    }

    @Override
    public Number java_lang_Number_b() {
        if (this.var_bfd_bdj__b == bdf.i) {
            if (this.h == 0) {
                this.void_a(0);
            }
            if ((this.h & 1) != 0) {
                return this.i;
            }
            if ((this.h & 2) != 0) {
                return this.var_long_c;
            }
            if ((this.h & 4) != 0) {
                return this.var_java_math_BigInteger_a;
            }
            this.void_o();
        }
        if (this.h == 0) {
            this.void_a(16);
        }
        if ((this.h & 0x10) != 0) {
            return this.var_java_math_BigDecimal_a;
        }
        if ((this.h & 8) == 0) {
            this.void_o();
        }
        return this.var_double_a;
    }

    @Override
    public bdc.b bdc$b_a() {
        if (this.h == 0) {
            this.void_a(0);
        }
        if (this.var_bfd_bdj__b == bdf.i) {
            if ((this.h & 1) != 0) {
                return bdc.b.var_bdc$b_a;
            }
            if ((this.h & 2) != 0) {
                return bdc.b.b;
            }
            return bdc.b.c;
        }
        if ((this.h & 0x10) != 0) {
            return bdc.b.f;
        }
        return bdc.b.e;
    }

    @Override
    public int int_e() {
        if ((this.h & 1) == 0) {
            if (this.h == 0) {
                return this.int_j();
            }
            if ((this.h & 1) == 0) {
                this.void_f();
            }
        }
        return this.i;
    }

    @Override
    public long long_a() {
        if ((this.h & 2) == 0) {
            if (this.h == 0) {
                this.void_a(2);
            }
            if ((this.h & 2) == 0) {
                this.void_g();
            }
        }
        return this.var_long_c;
    }

    @Override
    public BigInteger java_math_BigInteger_a() {
        if ((this.h & 4) == 0) {
            if (this.h == 0) {
                this.void_a(4);
            }
            if ((this.h & 4) == 0) {
                this.void_h();
            }
        }
        return this.var_java_math_BigInteger_a;
    }

    @Override
    public float float_a() {
        double d2 = this.double_a();
        return (float)d2;
    }

    @Override
    public double double_a() {
        if ((this.h & 8) == 0) {
            if (this.h == 0) {
                this.void_a(8);
            }
            if ((this.h & 8) == 0) {
                this.void_i();
            }
        }
        return this.var_double_a;
    }

    @Override
    public BigDecimal java_math_BigDecimal_a() {
        if ((this.h & 0x10) == 0) {
            if (this.h == 0) {
                this.void_a(16);
            }
            if ((this.h & 0x10) == 0) {
                this.void_j();
            }
        }
        return this.var_java_math_BigDecimal_a;
    }

    protected void void_a(int n2) {
        if (this.var_boolean_a) {
            this.d("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this.var_bfd_bdj__b == bdf.i) {
            int n3 = this.j;
            if (n3 <= 9) {
                int n4;
                this.i = n4 = this.var_bfj_a.int_a(this.var_boolean_c);
                this.h = 1;
                return;
            }
            if (n3 <= 18) {
                long l2 = this.var_bfj_a.long_a(this.var_boolean_c);
                if (n3 == 10) {
                    if (this.var_boolean_c) {
                        if (l2 >= Integer.MIN_VALUE) {
                            this.i = (int)l2;
                            this.h = 1;
                            return;
                        }
                    } else if (l2 <= Integer.MAX_VALUE) {
                        this.i = (int)l2;
                        this.h = 1;
                        return;
                    }
                }
                this.var_long_c = l2;
                this.h = 2;
                return;
            }
            this.e(n2);
            return;
        }
        if (this.var_bfd_bdj__b == bdf.j) {
            this.d(n2);
            return;
        }
        this.a("Current token (%s) not numeric, can not use numeric value accessors", this.var_bfd_bdj__b);
    }

    protected int int_j() {
        if (this.var_boolean_a) {
            this.d("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this.var_bfd_bdj__b == bdf.i && this.j <= 9) {
            int n2;
            this.i = n2 = this.var_bfj_a.int_a(this.var_boolean_c);
            this.h = 1;
            return n2;
        }
        this.void_a(1);
        if ((this.h & 1) == 0) {
            this.void_f();
        }
        return this.i;
    }

    private void d(int n2) {
        try {
            if (n2 == 16) {
                this.var_java_math_BigDecimal_a = this.var_bfj_a.java_math_BigDecimal_a();
                this.h = 16;
            } else {
                this.var_double_a = this.var_bfj_a.double_a();
                this.h = 8;
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.void_a("Malformed numeric value (" + this.java_lang_String_c(this.var_bfj_a.java_lang_String_a()) + ")", numberFormatException);
        }
    }

    private void e(int n2) {
        String string = this.var_bfj_a.java_lang_String_a();
        try {
            int n3 = this.j;
            char[] cArray = this.var_bfj_a.char_arr_a();
            int n4 = this.var_bfj_a.int_b();
            if (this.var_boolean_c) {
                ++n4;
            }
            if (bea.a(cArray, n4, n3, this.var_boolean_c)) {
                this.var_long_c = Long.parseLong(string);
                this.h = 2;
            } else {
                if (n2 == 1 || n2 == 2) {
                    this.a(n2, string);
                }
                if (n2 == 8 || n2 == 32) {
                    this.var_double_a = bea.double_a(string);
                    this.h = 8;
                } else {
                    this.var_java_math_BigInteger_a = new BigInteger(string);
                    this.h = 4;
                }
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.void_a("Malformed numeric value (" + this.java_lang_String_c(string) + ")", numberFormatException);
        }
    }

    protected void a(int n2, String string) {
        if (n2 == 1) {
            this.void_b(string);
        } else {
            this.void_c(string);
        }
    }

    protected void void_f() {
        if ((this.h & 2) != 0) {
            int n2 = (int)this.var_long_c;
            if ((long)n2 != this.var_long_c) {
                this.void_a(this.java_lang_String_e(), this.bdf_c());
            }
            this.i = n2;
        } else if ((this.h & 4) != 0) {
            if (((BigInteger)((Object)var_bfd_bdj__b)).compareTo(this.var_java_math_BigInteger_a) > 0 || var_int_c.compareTo(this.var_java_math_BigInteger_a) < 0) {
                this.void_l();
            }
            this.i = this.var_java_math_BigInteger_a.intValue();
        } else if ((this.h & 8) != 0) {
            if (this.var_double_a < -2.147483648E9 || this.var_double_a > 2.147483647E9) {
                this.void_l();
            }
            this.i = (int)this.var_double_a;
        } else if ((this.h & 0x10) != 0) {
            if (d.compareTo(this.var_java_math_BigDecimal_a) > 0 || e.compareTo(this.var_java_math_BigDecimal_a) < 0) {
                this.void_l();
            }
            this.i = this.var_java_math_BigDecimal_a.intValue();
        } else {
            this.void_o();
        }
        this.h |= 1;
    }

    protected void void_g() {
        if ((this.h & 1) != 0) {
            this.var_long_c = this.i;
        } else if ((this.h & 4) != 0) {
            if (d.compareTo(this.var_java_math_BigInteger_a) > 0 || e.compareTo(this.var_java_math_BigInteger_a) < 0) {
                this.void_m();
            }
            this.var_long_c = this.var_java_math_BigInteger_a.longValue();
        } else if ((this.h & 8) != 0) {
            if (this.var_double_a < -9.223372036854776E18 || this.var_double_a > 9.223372036854776E18) {
                this.void_m();
            }
            this.var_long_c = (long)this.var_double_a;
        } else if ((this.h & 0x10) != 0) {
            if (((BigDecimal)((Object)var_bfd_bdj__b)).compareTo(this.var_java_math_BigDecimal_a) > 0 || var_int_c.compareTo(this.var_java_math_BigDecimal_a) < 0) {
                this.void_m();
            }
            this.var_long_c = this.var_java_math_BigDecimal_a.longValue();
        } else {
            this.void_o();
        }
        this.h |= 2;
    }

    protected void void_h() {
        if ((this.h & 0x10) != 0) {
            this.var_java_math_BigInteger_a = this.var_java_math_BigDecimal_a.toBigInteger();
        } else if ((this.h & 2) != 0) {
            this.var_java_math_BigInteger_a = BigInteger.valueOf(this.var_long_c);
        } else if ((this.h & 1) != 0) {
            this.var_java_math_BigInteger_a = BigInteger.valueOf(this.i);
        } else if ((this.h & 8) != 0) {
            this.var_java_math_BigInteger_a = BigDecimal.valueOf(this.var_double_a).toBigInteger();
        } else {
            this.void_o();
        }
        this.h |= 4;
    }

    protected void void_i() {
        if ((this.h & 0x10) != 0) {
            this.var_double_a = this.var_java_math_BigDecimal_a.doubleValue();
        } else if ((this.h & 4) != 0) {
            this.var_double_a = this.var_java_math_BigInteger_a.doubleValue();
        } else if ((this.h & 2) != 0) {
            this.var_double_a = this.var_long_c;
        } else if ((this.h & 1) != 0) {
            this.var_double_a = this.i;
        } else {
            this.void_o();
        }
        this.h |= 8;
    }

    protected void void_j() {
        if ((this.h & 8) != 0) {
            this.var_java_math_BigDecimal_a = bea.java_math_BigDecimal_a(this.java_lang_String_e());
        } else if ((this.h & 4) != 0) {
            this.var_java_math_BigDecimal_a = new BigDecimal(this.var_java_math_BigInteger_a);
        } else if ((this.h & 2) != 0) {
            this.var_java_math_BigDecimal_a = BigDecimal.valueOf(this.var_long_c);
        } else if ((this.h & 1) != 0) {
            this.var_java_math_BigDecimal_a = BigDecimal.valueOf(this.i);
        } else {
            this.void_o();
        }
        this.h |= 0x10;
    }

    protected void a(int n2, char c2) {
        bek bek2 = this.bek_a();
        this.d(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char)n2), Character.valueOf(c2), bek2.java_lang_Object_a(), bek2.bda_a(this.java_lang_Object_d())));
    }

    protected char a(char c2) {
        if (this.a(bdc.a.g)) {
            return c2;
        }
        if (c2 == '\'' && this.a(bdc.a.e)) {
            return c2;
        }
        this.d("Unrecognized character escape " + bdo.java_lang_String_a(c2));
        return c2;
    }

    protected void b(int n2, String string) {
        if (!this.a(bdc.a.f) || n2 > 32) {
            char c2 = (char)n2;
            String string2 = "Illegal unquoted character (" + bdo.java_lang_String_a(c2) + "): has to be escaped using backslash to be included in " + string;
            this.d(string2);
        }
    }

    protected String java_lang_String_g() {
        return this.java_lang_String_h();
    }

    protected String java_lang_String_h() {
        if (this.a(bdc.a.j)) {
            return "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')";
        }
        return "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    protected char char_a() {
        throw new UnsupportedOperationException();
    }

    protected final int int_a(bcq bcq2, int n2, int n3) {
        if (n2 != 92) {
            throw this.java_lang_IllegalArgumentException_a(bcq2, n2, n3);
        }
        char c2 = this.char_a();
        if (c2 <= ' ' && n3 == 0) {
            return -1;
        }
        int n4 = bcq2.int_a((int)c2);
        if (n4 < 0 && n4 != -2) {
            throw this.java_lang_IllegalArgumentException_a(bcq2, (int)c2, n3);
        }
        return n4;
    }

    protected final int a(bcq bcq2, char c2, int n2) {
        if (c2 != '\\') {
            throw this.java_lang_IllegalArgumentException_a(bcq2, (int)c2, n2);
        }
        char c3 = this.char_a();
        if (c3 <= ' ' && n2 == 0) {
            return -1;
        }
        int n3 = bcq2.int_a(c3);
        if (n3 < 0 && (n3 != -2 || n2 < 2)) {
            throw this.java_lang_IllegalArgumentException_a(bcq2, (int)c3, n2);
        }
        return n3;
    }

    protected IllegalArgumentException java_lang_IllegalArgumentException_a(bcq bcq2, int n2, int n3) {
        return this.a(bcq2, n2, n3, null);
    }

    protected IllegalArgumentException a(bcq bcq2, int n2, int n3, String string) {
        String string2 = n2 <= 32 ? String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(n2), n3 + 1) : (bcq2.boolean_a(n2) ? "Unexpected padding character ('" + bcq2.char_a() + "') as character #" + (n3 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(n2) || Character.isISOControl(n2) ? "Illegal character (code 0x" + Integer.toHexString(n2) + ") in base64 content" : "Illegal character '" + (char)n2 + "' (code 0x" + Integer.toHexString(n2) + ") in base64 content"));
        if (string != null) {
            string2 = string2 + ": " + string;
        }
        return new IllegalArgumentException(string2);
    }

    protected void void_a(bcq bcq2) {
        this.d(bcq2.java_lang_String_c());
    }

    protected Object java_lang_Object_d() {
        if (bdc.a.o.a((int)this.var_bdv_a)) {
            return this.var_bdv_a.java_lang_Object_a();
        }
        return null;
    }

    protected static int[] a(int[] nArray, int n2) {
        if (nArray == null) {
            return new int[n2];
        }
        return Arrays.copyOf(nArray, nArray.length + n2);
    }

    protected void void_k() {
    }

    static {
        var_bfd_bdj__b = var_bdv_a;
    }
}

