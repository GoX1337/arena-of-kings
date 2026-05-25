/*
 * Decompiled with CFR 0.152.
 */
public final class bgd
extends Enum<bgd>
implements bhf {
    public static final /* enum */ bgd var_bgd_a;
    public static final /* enum */ bgd b;
    public static final /* enum */ bgd c;
    public static final /* enum */ bgd d;
    public static final /* enum */ bgd e;
    public static final /* enum */ bgd f;
    public static final /* enum */ bgd g;
    public static final /* enum */ bgd h;
    public static final /* enum */ bgd i;
    public static final /* enum */ bgd j;
    public static final /* enum */ bgd k;
    public static final /* enum */ bgd l;
    public static final /* enum */ bgd m;
    public static final /* enum */ bgd n;
    public static final /* enum */ bgd o;
    public static final /* enum */ bgd p;
    public static final /* enum */ bgd q;
    public static final /* enum */ bgd r;
    public static final /* enum */ bgd s;
    public static final /* enum */ bgd t;
    public static final /* enum */ bgd u;
    public static final /* enum */ bgd v;
    public static final /* enum */ bgd w;
    public static final /* enum */ bgd x;
    public static final /* enum */ bgd y;
    public static final /* enum */ bgd z;
    public static final /* enum */ bgd A;
    public static final /* enum */ bgd B;
    public static final /* enum */ bgd C;
    public static final /* enum */ bgd D;
    public static final /* enum */ bgd E;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private static final /* synthetic */ bgd[] var_bgd_arr_a;

    public static bgd[] values() {
        return (bgd[])var_bgd_arr_a.clone();
    }

    public static bgd valueOf(String string) {
        return Enum.valueOf(bgd.class, string);
    }

    private bgd(boolean bl2) {
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
        var_bgd_a = new bgd(true);
        b = new bgd(true);
        c = new bgd(false);
        d = new bgd(true);
        e = new bgd(true);
        f = new bgd(true);
        g = new bgd(true);
        h = new bgd(true);
        i = new bgd(false);
        j = new bgd(true);
        k = new bgd(true);
        l = new bgd(true);
        m = new bgd(false);
        n = new bgd(true);
        o = new bgd(true);
        p = new bgd(false);
        q = new bgd(false);
        r = new bgd(true);
        s = new bgd(true);
        t = new bgd(false);
        u = new bgd(true);
        v = new bgd(false);
        w = new bgd(false);
        x = new bgd(false);
        y = new bgd(false);
        z = new bgd(false);
        A = new bgd(false);
        B = new bgd(true);
        C = new bgd(true);
        D = new bgd(true);
        E = new bgd(false);
        var_bgd_arr_a = new bgd[]{var_bgd_a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E};
    }
}

