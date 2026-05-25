/*
 * Decompiled with CFR 0.152.
 */
public final class yo
extends Enum<yo> {
    public static final /* enum */ yo var_yo_a;
    public static final /* enum */ yo b;
    public static final /* enum */ yo c;
    private static final /* synthetic */ yo[] var_yo_arr_a;

    public static yo[] values() {
        return (yo[])var_yo_arr_a.clone();
    }

    public static yo valueOf(String string) {
        return Enum.valueOf(yo.class, string);
    }

    static {
        var_yo_a = new yo();
        b = new yo();
        c = new yo();
        var_yo_arr_a = new yo[]{var_yo_a, b, c};
    }
}

