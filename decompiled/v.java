/*
 * Decompiled with CFR 0.152.
 */
public final class v
extends Enum<v> {
    public static final /* enum */ v var_v_a;
    public static final /* enum */ v b;
    private static final /* synthetic */ v[] var_v_arr_a;

    public static v[] values() {
        return (v[])var_v_arr_a.clone();
    }

    public static v valueOf(String string) {
        return Enum.valueOf(v.class, string);
    }

    static {
        var_v_a = new v();
        b = new v();
        var_v_arr_a = new v[]{var_v_a, b};
    }
}

