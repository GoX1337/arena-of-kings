/*
 * Decompiled with CFR 0.152.
 */
public final class fr
extends Enum<fr> {
    public static final /* enum */ fr var_fr_a;
    public static final /* enum */ fr b;
    public static final /* enum */ fr c;
    private static final /* synthetic */ fr[] var_fr_arr_a;

    public static fr[] values() {
        return (fr[])var_fr_arr_a.clone();
    }

    public static fr valueOf(String string) {
        return Enum.valueOf(fr.class, string);
    }

    public static String a(fr fr2) {
        switch (fr2) {
            case var_fr_a: {
                return " Ability Score";
            }
            case b: {
                return " Defense Score";
            }
            case c: {
                return " Utility Score";
            }
        }
        return "";
    }

    static {
        var_fr_a = new fr();
        b = new fr();
        c = new fr();
        var_fr_arr_a = new fr[]{var_fr_a, b, c};
    }
}

