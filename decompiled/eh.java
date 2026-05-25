/*
 * Decompiled with CFR 0.152.
 */
public final class eh
extends Enum<eh> {
    public static final /* enum */ eh var_eh_a;
    public static final /* enum */ eh var_eh_b;
    public static final /* enum */ eh c;
    public static final /* enum */ eh d;
    public static final /* enum */ eh e;
    public static final /* enum */ eh f;
    public static final /* enum */ eh g;
    public static final /* enum */ eh h;
    public static final /* enum */ eh i;
    public static final /* enum */ eh j;
    public static final /* enum */ eh k;
    public static final /* enum */ eh l;
    public static final /* enum */ eh m;
    public static final /* enum */ eh n;
    public static final /* enum */ eh o;
    public static final /* enum */ eh p;
    public static final /* enum */ eh q;
    public static final /* enum */ eh r;
    public static final /* enum */ eh s;
    public static final /* enum */ eh t;
    private int var_int_a;
    private int var_int_b;
    private static final /* synthetic */ eh[] var_eh_arr_a;

    public static eh[] values() {
        return (eh[])var_eh_arr_a.clone();
    }

    public static eh valueOf(String string) {
        return Enum.valueOf(eh.class, string);
    }

    private eh(int n3, int n4) {
        this.var_int_a = n3;
        this.var_int_b = n4;
    }

    public static boolean boolean_a(int n2, int n3) {
        if (n2 >= 20) {
            return false;
        }
        for (eh eh2 : eh.values()) {
            if (eh2.var_int_a != n2 || n3 < eh2.var_int_b) continue;
            return true;
        }
        return false;
    }

    public static int int_a(int n2, int n3) {
        if (n2 >= 20) {
            return 0;
        }
        for (eh eh2 : eh.values()) {
            if (eh2.var_int_a != n2) continue;
            return eh2.var_int_b - n3;
        }
        return 0;
    }

    public static eh a(int n2) {
        if (n2 >= 20) {
            return t;
        }
        for (eh eh2 : eh.values()) {
            if (eh2.var_int_a != n2) continue;
            return eh2;
        }
        return var_eh_a;
    }

    public int a() {
        return this.var_int_b;
    }

    static {
        var_eh_a = new eh(1, 400);
        var_eh_b = new eh(2, 800);
        c = new eh(3, 1300);
        d = new eh(4, 2000);
        e = new eh(5, 2700);
        f = new eh(6, 3500);
        g = new eh(7, 4500);
        h = new eh(8, 5400);
        i = new eh(9, 6500);
        j = new eh(10, 7600);
        k = new eh(11, 8700);
        l = new eh(12, 9800);
        m = new eh(13, 11000);
        n = new eh(14, 12300);
        o = new eh(15, 13600);
        p = new eh(16, 15000);
        q = new eh(17, 16700);
        r = new eh(18, 18500);
        s = new eh(19, 22500);
        t = new eh(20, 25000);
        var_eh_arr_a = new eh[]{var_eh_a, var_eh_b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t};
    }
}

