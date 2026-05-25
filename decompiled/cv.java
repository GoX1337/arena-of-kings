/*
 * Decompiled with CFR 0.152.
 */
public final class cv
extends Enum<cv> {
    public static final /* enum */ cv var_cv_a;
    public static final /* enum */ cv b;
    public static final /* enum */ cv c;
    public static final /* enum */ cv d;
    private static final /* synthetic */ cv[] var_cv_arr_a;

    public static cv[] values() {
        return (cv[])var_cv_arr_a.clone();
    }

    public static cv valueOf(String string) {
        return Enum.valueOf(cv.class, string);
    }

    static {
        var_cv_a = new cv();
        b = new cv();
        c = new cv();
        d = new cv();
        var_cv_arr_a = new cv[]{var_cv_a, b, c, d};
    }
}

