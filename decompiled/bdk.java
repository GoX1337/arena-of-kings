/*
 * Decompiled with CFR 0.152.
 */
public final class bdk
extends Enum<bdk>
implements bfc {
    public static final /* enum */ bdk var_bdk_a;
    public static final /* enum */ bdk b;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bdk[] var_bdk_arr_a;

    public static bdk[] values() {
        return (bdk[])var_bdk_arr_a.clone();
    }

    public static bdk valueOf(String string) {
        return Enum.valueOf(bdk.class, string);
    }

    private bdk(boolean bl2) {
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
        var_bdk_a = new bdk(false);
        b = new bdk(false);
        var_bdk_arr_a = new bdk[]{var_bdk_a, b};
    }
}

