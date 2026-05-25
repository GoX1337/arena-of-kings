/*
 * Decompiled with CFR 0.152.
 */
public abstract class bma {
    private static final bma a;

    public static bma a() {
        return a;
    }

    public abstract Boolean a(bmg var1);

    public abstract Boolean b(bmg var1);

    public abstract bgj a(bmr var1);

    static {
        bma bma2 = null;
        try {
            Class<?> clazz = Class.forName("bmb");
            bma2 = (bma)buk.a(clazz, false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        a = bma2;
    }
}

