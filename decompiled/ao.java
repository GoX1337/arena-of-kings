/*
 * Decompiled with CFR 0.152.
 */
public final class ao
extends Enum<ao> {
    public static final /* enum */ ao var_ao_a;
    public static final /* enum */ ao var_ao_b;
    public static final /* enum */ ao c;
    public static final /* enum */ ao d;
    public static final /* enum */ ao e;
    public static final /* enum */ ao f;
    public static final /* enum */ ao g;
    public static final /* enum */ ao h;
    public static final /* enum */ ao i;
    public static final /* enum */ ao j;
    public static final /* enum */ ao k;
    public static final /* enum */ ao l;
    public static final /* enum */ ao m;
    public static final /* enum */ ao n;
    public static final /* enum */ ao o;
    private int var_int_a;
    private int var_int_b;
    private String var_java_lang_String_a;
    private static final /* synthetic */ ao[] var_ao_arr_a;

    public static ao[] values() {
        return (ao[])var_ao_arr_a.clone();
    }

    public static ao valueOf(String string) {
        return Enum.valueOf(ao.class, string);
    }

    private ao(int n3, int n4, String string2) {
        this.var_int_a = n3;
        this.var_int_b = n4;
        this.var_java_lang_String_a = string2;
    }

    public static ao a(int n2) {
        ao ao2 = var_ao_a;
        for (ao ao3 : ao.values()) {
            if (n2 < ao3.var_int_b) {
                return ao2;
            }
            ao2 = ao3;
        }
        return ao2;
    }

    public static ao a(ao ao2) {
        switch (ao2) {
            case var_ao_a: {
                return var_ao_b;
            }
            case var_ao_b: {
                return c;
            }
            case c: {
                return d;
            }
            case d: {
                return e;
            }
            case e: {
                return f;
            }
            case f: {
                return g;
            }
            case g: {
                return h;
            }
            case h: {
                return i;
            }
            case i: {
                return j;
            }
            case j: {
                return k;
            }
            case k: {
                return l;
            }
            case l: {
                return m;
            }
            case m: {
                return n;
            }
            case n: {
                return o;
            }
            case o: {
                return o;
            }
        }
        return var_ao_a;
    }

    public static int a(ao ao2, int n2) {
        return Math.abs(ao2.b() - n2);
    }

    public int int_a() {
        return this.var_int_a;
    }

    public int b() {
        return this.var_int_b;
    }

    public String java_lang_String_a() {
        return "[" + this.var_java_lang_String_a + "]";
    }

    static {
        var_ao_a = new ao(1, 0, "RARITY_POOR");
        var_ao_b = new ao(2, 25, "RARITY_POOR");
        c = new ao(3, 75, "RARITY_POOR");
        d = new ao(4, 180, "RARITY_UNCOMMON");
        e = new ao(5, 360, "RARITY_UNCOMMON");
        f = new ao(6, 600, "RARITY_UNCOMMON");
        g = new ao(7, 1000, "RARITY_RARE");
        h = new ao(8, 1680, "RARITY_RARE");
        i = new ao(9, 2800, "RARITY_RARE");
        j = new ao(10, 4665, "RARITY_EPIC");
        k = new ao(11, 7750, "RARITY_EPIC");
        l = new ao(12, 12960, "RARITY_EPIC");
        m = new ao(13, 21600, "RARITY_LEGENDARY");
        n = new ao(14, 46000, "RARITY_LEGENDARY");
        o = new ao(15, 100000, "RARITY_ANCIENT");
        var_ao_arr_a = new ao[]{var_ao_a, var_ao_b, c, d, e, f, g, h, i, j, k, l, m, n, o};
    }
}

