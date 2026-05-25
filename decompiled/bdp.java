/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class bdp
extends bdc {
    protected static final byte[] var_byte_arr_b;
    protected static final int[] a;
    protected static final BigInteger var_java_math_BigInteger_b;
    protected static final BigInteger var_java_math_BigInteger_c;
    protected static final BigInteger var_java_math_BigInteger_d;
    protected static final BigInteger var_java_math_BigInteger_e;
    protected static final BigDecimal var_java_math_BigDecimal_b;
    protected static final BigDecimal var_java_math_BigDecimal_c;
    protected static final BigDecimal var_java_math_BigDecimal_d;
    protected static final BigDecimal var_java_math_BigDecimal_e;
    protected bdf var_bdf_b;
    protected bdf var_bdf_c;

    protected bdp(int n2) {
        super(n2);
    }

    @Override
    public abstract bdf bdf_a();

    @Override
    public bdf bdf_c() {
        return this.var_bdf_b;
    }

    @Override
    public int int_a() {
        bdf bdf2 = this.var_bdf_b;
        return bdf2 == null ? 0 : bdf2.int_a();
    }

    @Override
    public bdf bdf_d() {
        return this.var_bdf_b;
    }

    @Override
    @Deprecated
    public int int_b() {
        bdf bdf2 = this.var_bdf_b;
        return bdf2 == null ? 0 : bdf2.int_a();
    }

    @Override
    public boolean boolean_b() {
        return this.var_bdf_b != null;
    }

    @Override
    public boolean boolean_a(int n2) {
        bdf bdf2 = this.var_bdf_b;
        if (bdf2 == null) {
            return 0 == n2;
        }
        return bdf2.int_a() == n2;
    }

    @Override
    public boolean boolean_a(bdf bdf2) {
        return this.var_bdf_b == bdf2;
    }

    @Override
    public boolean boolean_c() {
        return this.var_bdf_b == bdf.var_bdf_d;
    }

    @Override
    public boolean boolean_d() {
        return this.var_bdf_b == bdf.var_bdf_b;
    }

    @Override
    public boolean boolean_e() {
        return this.var_bdf_b == bdf.i;
    }

    @Override
    public bdf bdf_b() {
        bdf bdf2 = this.bdf_a();
        if (bdf2 == bdf.f) {
            bdf2 = this.bdf_a();
        }
        return bdf2;
    }

    @Override
    public bdc bdc_a() {
        if (this.var_bdf_b != bdf.var_bdf_b && this.var_bdf_b != bdf.var_bdf_d) {
            return this;
        }
        int n2 = 1;
        while (true) {
            bdf bdf2;
            if ((bdf2 = this.bdf_a()) == null) {
                this.void_e();
                return this;
            }
            if (bdf2.b()) {
                ++n2;
                continue;
            }
            if (bdf2.c()) {
                if (--n2 != 0) continue;
                return this;
            }
            if (bdf2 != bdf.var_bdf_a) continue;
            this.a("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", this.getClass().getName());
        }
    }

    protected abstract void void_e();

    @Override
    public abstract String java_lang_String_c();

    @Override
    public void void_a() {
        if (this.var_bdf_b != null) {
            this.var_bdf_c = this.var_bdf_b;
            this.var_bdf_b = null;
        }
    }

    @Override
    public abstract String java_lang_String_e();

    @Override
    public int int_f() {
        bdf bdf2 = this.var_bdf_b;
        if (bdf2 == bdf.i || bdf2 == bdf.j) {
            return this.int_e();
        }
        return this.int_a(0);
    }

    @Override
    public int int_a(int n2) {
        bdf bdf2 = this.var_bdf_b;
        if (bdf2 == bdf.i || bdf2 == bdf.j) {
            return this.int_e();
        }
        if (bdf2 != null) {
            switch (bdf2.int_a()) {
                case 6: {
                    String string = this.java_lang_String_e();
                    if (this.boolean_a(string)) {
                        return 0;
                    }
                    return bea.a(string, n2);
                }
                case 9: {
                    return 1;
                }
                case 10: {
                    return 0;
                }
                case 11: {
                    return 0;
                }
                case 12: {
                    Object object = this.java_lang_Object_a();
                    if (!(object instanceof Number)) break;
                    return ((Number)object).intValue();
                }
            }
        }
        return n2;
    }

    @Override
    public long long_b() {
        bdf bdf2 = this.var_bdf_b;
        if (bdf2 == bdf.i || bdf2 == bdf.j) {
            return this.long_a();
        }
        return this.a(0L);
    }

    @Override
    public long a(long l2) {
        bdf bdf2 = this.var_bdf_b;
        if (bdf2 == bdf.i || bdf2 == bdf.j) {
            return this.long_a();
        }
        if (bdf2 != null) {
            switch (bdf2.int_a()) {
                case 6: {
                    String string = this.java_lang_String_e();
                    if (this.boolean_a(string)) {
                        return 0L;
                    }
                    return bea.a(string, l2);
                }
                case 9: {
                    return 1L;
                }
                case 10: 
                case 11: {
                    return 0L;
                }
                case 12: {
                    Object object = this.java_lang_Object_a();
                    if (!(object instanceof Number)) break;
                    return ((Number)object).longValue();
                }
            }
        }
        return l2;
    }

    @Override
    public String java_lang_String_f() {
        return this.java_lang_String_a((String)null);
    }

    @Override
    public String java_lang_String_a(String string) {
        if (this.var_bdf_b == bdf.h) {
            return this.java_lang_String_e();
        }
        if (this.var_bdf_b == bdf.f) {
            return this.java_lang_String_c();
        }
        if (this.var_bdf_b == null || this.var_bdf_b == bdf.m || !this.var_bdf_b.d()) {
            return string;
        }
        return this.java_lang_String_e();
    }

    protected void a(String string, bex bex2, bcq bcq2) {
        try {
            bcq2.a(string, bex2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.d(illegalArgumentException.getMessage());
        }
    }

    protected boolean boolean_a(String string) {
        return "null".equals(string);
    }

    protected void c(int n2, String string) {
        String string2 = String.format("Unexpected character (%s) in numeric value", bdp.java_lang_String_a(n2));
        if (string != null) {
            string2 = string2 + ": " + string;
        }
        this.d(string2);
    }

    protected void void_a(String string) {
        this.d("Invalid numeric value: " + string);
    }

    protected void void_l() {
        this.void_b(this.java_lang_String_e());
    }

    protected void void_b(String string) {
        this.void_a(string, this.bdf_c());
    }

    protected void void_a(String string, bdf bdf2) {
        this.a(String.format("Numeric value (%s) out of range of int (%d - %s)", this.java_lang_String_b(string), Integer.MIN_VALUE, Integer.MAX_VALUE), bdf2, Integer.TYPE);
    }

    protected void void_m() {
        this.void_c(this.java_lang_String_e());
    }

    protected void void_c(String string) {
        this.b(string, this.bdf_c());
    }

    protected void b(String string, bdf bdf2) {
        this.a(String.format("Numeric value (%s) out of range of long (%d - %s)", this.java_lang_String_b(string), Long.MIN_VALUE, Long.MAX_VALUE), bdf2, Long.TYPE);
    }

    protected void a(String string, bdf bdf2, Class<?> clazz) {
        throw new bdq(this, string, bdf2, clazz);
    }

    protected String java_lang_String_b(String string) {
        int n2 = string.length();
        if (n2 < 1000) {
            return string;
        }
        if (string.startsWith("-")) {
            --n2;
        }
        return String.format("[Integer with %d digits]", n2);
    }

    protected String java_lang_String_c(String string) {
        int n2 = string.length();
        if (n2 < 1000) {
            return string;
        }
        if (string.startsWith("-")) {
            --n2;
        }
        return String.format("[number with %d characters]", n2);
    }

    protected void d(int n2, String string) {
        if (n2 < 0) {
            this.void_n();
        }
        String string2 = String.format("Unexpected character (%s)", bdp.java_lang_String_a(n2));
        if (string != null) {
            string2 = string2 + ": " + string;
        }
        this.d(string2);
    }

    protected void void_n() {
        this.c(" in " + (Object)((Object)this.var_bdf_b), this.var_bdf_b);
    }

    protected void void_a(bdf bdf2) {
        String string = bdf2 == bdf.h ? " in a String value" : (bdf2 == bdf.i || bdf2 == bdf.j ? " in a Number value" : " in a value");
        this.c(string, bdf2);
    }

    protected void c(String string, bdf bdf2) {
        throw new bdx((bdc)this, bdf2, "Unexpected end-of-input" + string);
    }

    protected void void_b(int n2) {
        this.d(n2, "Expected space separating root-level values");
    }

    protected void void_c(int n2) {
        char c2 = (char)n2;
        String string = "Illegal character (" + bdp.java_lang_String_a(c2) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens";
        this.d(string);
    }

    protected static final String java_lang_String_a(int n2) {
        char c2 = (char)n2;
        if (Character.isISOControl(c2)) {
            return "(CTRL-CHAR, code " + n2 + ")";
        }
        if (n2 > 255) {
            return "'" + c2 + "' (code " + n2 + " / 0x" + Integer.toHexString(n2) + ")";
        }
        return "'" + c2 + "' (code " + n2 + ")";
    }

    protected final void d(String string) {
        throw this.bdb_a(string);
    }

    protected final void a(String string, Object object) {
        throw this.bdb_a(String.format(string, object));
    }

    protected final void a(String string, Object object, Object object2) {
        throw this.bdb_a(String.format(string, object, object2));
    }

    protected final void void_a(String string, Throwable throwable) {
        throw this.bdb_a(string, throwable);
    }

    protected final void void_o() {
        bfl.a();
    }

    protected final bdb bdb_a(String string, Throwable throwable) {
        return new bdb(this, string, throwable);
    }

    static {
        var_byte_arr_b = new byte[0];
        a = new int[0];
        var_java_math_BigInteger_b = BigInteger.valueOf(Integer.MIN_VALUE);
        var_java_math_BigInteger_c = BigInteger.valueOf(Integer.MAX_VALUE);
        var_java_math_BigInteger_d = BigInteger.valueOf(Long.MIN_VALUE);
        var_java_math_BigInteger_e = BigInteger.valueOf(Long.MAX_VALUE);
        var_java_math_BigDecimal_b = new BigDecimal(var_java_math_BigInteger_d);
        var_java_math_BigDecimal_c = new BigDecimal(var_java_math_BigInteger_e);
        var_java_math_BigDecimal_d = new BigDecimal(var_java_math_BigInteger_b);
        var_java_math_BigDecimal_e = new BigDecimal(var_java_math_BigInteger_c);
    }
}

