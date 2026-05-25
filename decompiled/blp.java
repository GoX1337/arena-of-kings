/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

public class blp
extends blv {
    public blp(bdc bdc2, String string, bda bda2, Class<?> clazz, String string2, Collection<Object> collection) {
        super(bdc2, string, bda2, clazz, string2, collection);
    }

    public static blp a(bdc bdc2, Object object, String string, Collection<Object> collection) {
        Class<?> clazz = object instanceof Class ? (Class<?>)object : object.getClass();
        String string2 = String.format("Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", string, clazz.getName());
        blp blp2 = new blp(bdc2, string2, bdc2.bda_b(), clazz, string, collection);
        blp2.a(object, string);
        return blp2;
    }
}

