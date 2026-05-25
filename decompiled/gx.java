/*
 * Decompiled with CFR 0.152.
 */
public final class gx
extends Enum<gx> {
    public static final /* enum */ gx var_gx_a;
    public static final /* enum */ gx b;
    public static final /* enum */ gx c;
    public static final /* enum */ gx d;
    public static final /* enum */ gx e;
    private static final /* synthetic */ gx[] var_gx_arr_a;

    public static gx[] values() {
        return (gx[])var_gx_arr_a.clone();
    }

    public static gx valueOf(String string) {
        return Enum.valueOf(gx.class, string);
    }

    public static String a(gx gx2) {
        switch (gx2) {
            case d: {
                return "Energy";
            }
            case b: {
                return "Health";
            }
            case c: {
                return "Mana";
            }
            case var_gx_a: {
                return "";
            }
            case e: {
                return "Rage";
            }
        }
        return "";
    }

    static {
        var_gx_a = new gx();
        b = new gx();
        c = new gx();
        d = new gx();
        e = new gx();
        var_gx_arr_a = new gx[]{var_gx_a, b, c, d, e};
    }
}

