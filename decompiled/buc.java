/*
 * Decompiled with CFR 0.152.
 */
public final class buc
extends Enum<buc> {
    public static final /* enum */ buc var_buc_a;
    public static final /* enum */ buc b;
    public static final /* enum */ buc c;
    private static final /* synthetic */ buc[] var_buc_arr_a;

    public static buc[] values() {
        return (buc[])var_buc_arr_a.clone();
    }

    public static buc valueOf(String string) {
        return Enum.valueOf(buc.class, string);
    }

    static {
        var_buc_a = new buc();
        b = new buc();
        c = new buc();
        var_buc_arr_a = new buc[]{var_buc_a, b, c};
    }
}

