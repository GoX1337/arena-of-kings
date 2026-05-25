/*
 * Decompiled with CFR 0.152.
 */
public final class bcv
extends Enum<bcv> {
    public static final /* enum */ bcv var_bcv_a;
    public static final /* enum */ bcv b;
    public static final /* enum */ bcv c;
    public static final /* enum */ bcv d;
    public static final /* enum */ bcv e;
    private final String var_java_lang_String_a;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bcv[] var_bcv_arr_a;

    public static bcv[] values() {
        return (bcv[])var_bcv_arr_a.clone();
    }

    public static bcv valueOf(String string) {
        return Enum.valueOf(bcv.class, string);
    }

    private bcv(String string2, boolean bl2, int n3) {
        this.var_java_lang_String_a = string2;
        this.var_boolean_a = bl2;
        this.var_int_a = n3;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    static {
        var_bcv_a = new bcv("UTF-8", false, 8);
        b = new bcv("UTF-16BE", true, 16);
        c = new bcv("UTF-16LE", false, 16);
        d = new bcv("UTF-32BE", true, 32);
        e = new bcv("UTF-32LE", false, 32);
        var_bcv_arr_a = new bcv[]{var_bcv_a, b, c, d, e};
    }
}

