/*
 * Decompiled with CFR 0.152.
 */
public class bxe {
    protected bxe() {
    }

    public static void a(String string, boolean bl2) {
        if (!bl2) {
            bxe.a(string);
        }
    }

    public static void a(String string) {
        throw new bxf(string);
    }

    public static void a(String string, Object object) {
        bxe.a(string, object != null);
    }
}

