/*
 * Decompiled with CFR 0.152.
 */
public final class bdf
extends Enum<bdf> {
    public static final /* enum */ bdf var_bdf_a;
    public static final /* enum */ bdf var_bdf_b;
    public static final /* enum */ bdf var_bdf_c;
    public static final /* enum */ bdf var_bdf_d;
    public static final /* enum */ bdf var_bdf_e;
    public static final /* enum */ bdf f;
    public static final /* enum */ bdf g;
    public static final /* enum */ bdf h;
    public static final /* enum */ bdf i;
    public static final /* enum */ bdf j;
    public static final /* enum */ bdf k;
    public static final /* enum */ bdf l;
    public static final /* enum */ bdf m;
    final String var_java_lang_String_a;
    final char[] var_char_arr_a;
    final byte[] var_byte_arr_a;
    final int var_int_a;
    final boolean var_boolean_a;
    final boolean var_boolean_b;
    final boolean var_boolean_c;
    final boolean var_boolean_d;
    final boolean var_boolean_e;
    private static final /* synthetic */ bdf[] var_bdf_arr_a;

    public static bdf[] values() {
        return (bdf[])var_bdf_arr_a.clone();
    }

    public static bdf valueOf(String string) {
        return Enum.valueOf(bdf.class, string);
    }

    private bdf(String string2, int n3) {
        if (string2 == null) {
            this.var_java_lang_String_a = null;
            this.var_char_arr_a = null;
            this.var_byte_arr_a = null;
        } else {
            this.var_java_lang_String_a = string2;
            this.var_char_arr_a = string2.toCharArray();
            int n4 = this.var_char_arr_a.length;
            this.var_byte_arr_a = new byte[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                this.var_byte_arr_a[i2] = (byte)this.var_char_arr_a[i2];
            }
        }
        this.var_int_a = n3;
        this.var_boolean_d = n3 == 10 || n3 == 9;
        this.var_boolean_c = n3 == 7 || n3 == 8;
        this.var_boolean_a = n3 == 1 || n3 == 3;
        this.var_boolean_b = n3 == 2 || n3 == 4;
        this.var_boolean_e = !this.var_boolean_a && !this.var_boolean_b && n3 != 5 && n3 != -1;
    }

    public final int int_a() {
        return this.var_int_a;
    }

    public final String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public final char[] char_arr_a() {
        return this.var_char_arr_a;
    }

    public final boolean boolean_a() {
        return this.var_boolean_c;
    }

    public final boolean b() {
        return this.var_boolean_a;
    }

    public final boolean c() {
        return this.var_boolean_b;
    }

    public final boolean d() {
        return this.var_boolean_e;
    }

    static {
        var_bdf_a = new bdf(null, -1);
        var_bdf_b = new bdf("{", 1);
        var_bdf_c = new bdf("}", 2);
        var_bdf_d = new bdf("[", 3);
        var_bdf_e = new bdf("]", 4);
        f = new bdf(null, 5);
        g = new bdf(null, 12);
        h = new bdf(null, 6);
        i = new bdf(null, 7);
        j = new bdf(null, 8);
        k = new bdf("true", 9);
        l = new bdf("false", 10);
        m = new bdf("null", 11);
        var_bdf_arr_a = new bdf[]{var_bdf_a, var_bdf_b, var_bdf_c, var_bdf_d, var_bdf_e, f, g, h, i, j, k, l, m};
    }
}

