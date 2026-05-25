/*
 * Decompiled with CFR 0.152.
 */
public abstract class bly {
    private static final bly a;

    public static bly a() {
        return a;
    }

    public abstract bfx<?> a(Class<?> var1);

    public abstract bgb<?> a(Class<?> var1);

    static {
        bly bly2 = null;
        try {
            Class<?> clazz = Class.forName("blz");
            bly2 = (bly)buk.a(clazz, false);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        a = bly2;
    }
}

