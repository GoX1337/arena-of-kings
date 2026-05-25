/*
 * Decompiled with CFR 0.152.
 */
public class blr
extends blu {
    protected final Object a;

    public blr(bdc bdc2, String string, Object object, Class<?> clazz) {
        super(bdc2, string, clazz);
        this.a = object;
    }

    public static blr a(bdc bdc2, String string, Object object, Class<?> clazz) {
        return new blr(bdc2, string, object, clazz);
    }
}

