/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

public class blw
extends blv {
    public blw(bdc bdc2, String string, bda bda2, Class<?> clazz, String string2, Collection<Object> collection) {
        super(bdc2, string, bda2, clazz, string2, collection);
    }

    public static blw a(bdc bdc2, Object object, String string, Collection<Object> collection) {
        Class<?> clazz = object instanceof Class ? (Class<?>)object : object.getClass();
        String string2 = String.format("Unrecognized field \"%s\" (class %s), not marked as ignorable", string, clazz.getName());
        blw blw2 = new blw(bdc2, string2, bdc2.bda_b(), clazz, string, collection);
        blw2.a(object, string);
        return blw2;
    }
}

