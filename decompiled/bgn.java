/*
 * Decompiled with CFR 0.152.
 */
public final class bgn
extends Enum<bgn>
implements bhf {
    public static final /* enum */ bgn var_bgn_a;
    public static final /* enum */ bgn b;
    public static final /* enum */ bgn c;
    public static final /* enum */ bgn d;
    public static final /* enum */ bgn e;
    public static final /* enum */ bgn f;
    public static final /* enum */ bgn g;
    public static final /* enum */ bgn h;
    public static final /* enum */ bgn i;
    public static final /* enum */ bgn j;
    public static final /* enum */ bgn k;
    public static final /* enum */ bgn l;
    public static final /* enum */ bgn m;
    public static final /* enum */ bgn n;
    public static final /* enum */ bgn o;
    public static final /* enum */ bgn p;
    public static final /* enum */ bgn q;
    @Deprecated
    public static final /* enum */ bgn r;
    @Deprecated
    public static final /* enum */ bgn s;
    public static final /* enum */ bgn t;
    @Deprecated
    public static final /* enum */ bgn u;
    public static final /* enum */ bgn v;
    public static final /* enum */ bgn w;
    public static final /* enum */ bgn x;
    public static final /* enum */ bgn y;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bgn[] var_bgn_arr_a;

    public static bgn[] values() {
        return (bgn[])var_bgn_arr_a.clone();
    }

    public static bgn valueOf(String string) {
        return Enum.valueOf(bgn.class, string);
    }

    private bgn(boolean bl2) {
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
        var_bgn_a = new bgn(false);
        b = new bgn(false);
        c = new bgn(true);
        d = new bgn(true);
        e = new bgn(true);
        f = new bgn(true);
        g = new bgn(false);
        h = new bgn(false);
        i = new bgn(true);
        j = new bgn(true);
        k = new bgn(false);
        l = new bgn(false);
        m = new bgn(true);
        n = new bgn(false);
        o = new bgn(false);
        p = new bgn(false);
        q = new bgn(false);
        r = new bgn(true);
        s = new bgn(true);
        t = new bgn(false);
        u = new bgn(false);
        v = new bgn(true);
        w = new bgn(false);
        x = new bgn(true);
        y = new bgn(false);
        var_bgn_arr_a = new bgn[]{var_bgn_a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y};
    }
}

