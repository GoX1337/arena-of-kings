/*
 * Decompiled with CFR 0.152.
 */
public final class bfu
extends Enum<bfu>
implements bhf {
    public static final /* enum */ bfu var_bfu_a;
    public static final /* enum */ bfu b;
    public static final /* enum */ bfu c;
    public static final /* enum */ bfu d;
    public static final /* enum */ bfu e;
    public static final /* enum */ bfu f;
    public static final /* enum */ bfu g;
    public static final /* enum */ bfu h;
    public static final /* enum */ bfu i;
    public static final /* enum */ bfu j;
    public static final /* enum */ bfu k;
    public static final /* enum */ bfu l;
    public static final /* enum */ bfu m;
    public static final /* enum */ bfu n;
    public static final /* enum */ bfu o;
    public static final /* enum */ bfu p;
    public static final /* enum */ bfu q;
    public static final /* enum */ bfu r;
    public static final /* enum */ bfu s;
    public static final /* enum */ bfu t;
    public static final /* enum */ bfu u;
    public static final /* enum */ bfu v;
    public static final /* enum */ bfu w;
    public static final /* enum */ bfu x;
    public static final /* enum */ bfu y;
    public static final /* enum */ bfu z;
    public static final /* enum */ bfu A;
    public static final /* enum */ bfu B;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bfu[] var_bfu_arr_a;

    public static bfu[] values() {
        return (bfu[])var_bfu_arr_a.clone();
    }

    public static bfu valueOf(String string) {
        return Enum.valueOf(bfu.class, string);
    }

    private bfu(boolean bl2) {
        this.var_boolean_a = bl2;
        this.var_int_a = 1 << this.ordinal();
    }

    @Override
    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public int int_a() {
        return this.var_int_a;
    }

    public boolean a(int n2) {
        return (n2 & this.var_int_a) != 0;
    }

    static {
        var_bfu_a = new bfu(false);
        b = new bfu(false);
        c = new bfu(false);
        d = new bfu(false);
        e = new bfu(true);
        f = new bfu(false);
        g = new bfu(false);
        h = new bfu(true);
        i = new bfu(false);
        j = new bfu(false);
        k = new bfu(true);
        l = new bfu(false);
        m = new bfu(false);
        n = new bfu(true);
        o = new bfu(false);
        p = new bfu(true);
        q = new bfu(false);
        r = new bfu(false);
        s = new bfu(false);
        t = new bfu(false);
        u = new bfu(false);
        v = new bfu(true);
        w = new bfu(false);
        x = new bfu(false);
        y = new bfu(false);
        z = new bfu(true);
        A = new bfu(true);
        B = new bfu(true);
        var_bfu_arr_a = new bfu[]{var_bfu_a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B};
    }
}

