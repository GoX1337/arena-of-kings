/*
 * Decompiled with CFR 0.152.
 */
public final class abe
extends Enum<abe> {
    public static final /* enum */ abe var_abe_a;
    public static final /* enum */ abe var_abe_b;
    public static final /* enum */ abe c;
    public static final /* enum */ abe d;
    public static final /* enum */ abe e;
    public static final /* enum */ abe f;
    protected float var_float_a;
    protected float var_float_b;
    private static final /* synthetic */ abe[] var_abe_arr_a;

    public static abe[] values() {
        return (abe[])var_abe_arr_a.clone();
    }

    public static abe valueOf(String string) {
        return Enum.valueOf(abe.class, string);
    }

    private abe(float f2, float f3) {
        this.var_float_a = f2;
        this.var_float_b = f3;
    }

    public static int a(abe abe2) {
        switch (abe2) {
            case var_abe_a: {
                return 0;
            }
            case var_abe_b: {
                return 1;
            }
            case c: {
                return 2;
            }
            case d: {
                return 3;
            }
            case e: {
                return 4;
            }
            case f: {
                return 5;
            }
        }
        return 0;
    }

    static {
        var_abe_a = new abe(690.0f, 680.0f);
        var_abe_b = new abe(960.0f, 680.0f);
        c = new abe(1235.0f, 680.0f);
        d = new abe(690.0f, 415.0f);
        e = new abe(960.0f, 415.0f);
        f = new abe(1235.0f, 415.0f);
        var_abe_arr_a = new abe[]{var_abe_a, var_abe_b, c, d, e, f};
    }
}

