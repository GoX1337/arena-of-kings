/*
 * Decompiled with CFR 0.152.
 */
public final class bcn
extends Enum<bcn> {
    public static final /* enum */ bcn var_bcn_a;
    public static final /* enum */ bcn b;
    public static final /* enum */ bcn c;
    private static final /* synthetic */ bcn[] var_bcn_arr_a;

    public static bcn[] values() {
        return (bcn[])var_bcn_arr_a.clone();
    }

    public static bcn valueOf(String string) {
        return Enum.valueOf(bcn.class, string);
    }

    public Boolean a() {
        if (this == c) {
            return null;
        }
        return this == var_bcn_a ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean a(Boolean bl2, Boolean bl3) {
        if (bl2 == null) {
            return bl3 == null;
        }
        return bl2.equals(bl3);
    }

    static {
        var_bcn_a = new bcn();
        b = new bcn();
        c = new bcn();
        var_bcn_arr_a = new bcn[]{var_bcn_a, b, c};
    }
}

