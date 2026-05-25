/*
 * Decompiled with CFR 0.152.
 */
public final class bdj
extends Enum<bdj>
implements bfc {
    public static final /* enum */ bdj var_bdj_a;
    public static final /* enum */ bdj b;
    public static final /* enum */ bdj c;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bdj[] var_bdj_arr_a;

    public static bdj[] values() {
        return (bdj[])var_bdj_arr_a.clone();
    }

    public static bdj valueOf(String string) {
        return Enum.valueOf(bdj.class, string);
    }

    private bdj(boolean bl2) {
        this.var_boolean_a = bl2;
        this.var_int_a = 1 << this.ordinal();
    }

    @Override
    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public int b() {
        return this.var_int_a;
    }

    static {
        var_bdj_a = new bdj(false);
        b = new bdj(false);
        c = new bdj(false);
        var_bdj_arr_a = new bdj[]{var_bdj_a, b, c};
    }
}

