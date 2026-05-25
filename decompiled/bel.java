/*
 * Decompiled with CFR 0.152.
 */
public final class bel
extends Enum<bel>
implements bcs {
    public static final /* enum */ bel var_bel_a;
    public static final /* enum */ bel b;
    public static final /* enum */ bel c;
    public static final /* enum */ bel d;
    public static final /* enum */ bel e;
    public static final /* enum */ bel f;
    public static final /* enum */ bel g;
    public static final /* enum */ bel h;
    public static final /* enum */ bel i;
    public static final /* enum */ bel j;
    public static final /* enum */ bel k;
    private final boolean var_boolean_a;
    private final int var_int_a;
    private final bdc.a var_bdc$a_a;
    private static final /* synthetic */ bel[] var_bel_arr_a;

    public static bel[] values() {
        return (bel[])var_bel_arr_a.clone();
    }

    public static bel valueOf(String string) {
        return Enum.valueOf(bel.class, string);
    }

    private bel(boolean bl2, bdc.a a2) {
        this.var_boolean_a = bl2;
        this.var_int_a = 1 << this.ordinal();
        this.var_bdc$a_a = a2;
    }

    @Override
    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public int b() {
        return this.var_int_a;
    }

    public bdc.a bdc$a_a() {
        return this.var_bdc$a_a;
    }

    static {
        var_bel_a = new bel(false, bdc.a.b);
        b = new bel(false, bdc.a.c);
        c = new bel(false, bdc.a.e);
        d = new bel(false, bdc.a.d);
        e = new bel(false, bdc.a.f);
        f = new bel(false, bdc.a.g);
        g = new bel(false, bdc.a.h);
        h = new bel(false, bdc.a.i);
        i = new bel(false, bdc.a.j);
        j = new bel(false, bdc.a.k);
        k = new bel(false, bdc.a.l);
        var_bel_arr_a = new bel[]{var_bel_a, b, c, d, e, f, g, h, i, j, k};
    }
}

