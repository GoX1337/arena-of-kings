/*
 * Decompiled with CFR 0.152.
 */
public final class ak
extends Enum<ak> {
    public static final /* enum */ ak var_ak_a;
    public static final /* enum */ ak b;
    private String var_java_lang_String_a;
    private static final /* synthetic */ ak[] var_ak_arr_a;

    public static ak[] values() {
        return (ak[])var_ak_arr_a.clone();
    }

    public static ak valueOf(String string) {
        return Enum.valueOf(ak.class, string);
    }

    private ak(String string2) {
        this.var_java_lang_String_a = string2;
    }

    public String a() {
        return this.var_java_lang_String_a;
    }

    static {
        var_ak_a = new ak("true");
        b = new ak("");
        var_ak_arr_a = new ak[]{var_ak_a, b};
    }
}

