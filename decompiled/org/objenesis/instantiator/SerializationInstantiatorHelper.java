/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator;

import java.io.Serializable;

public class SerializationInstantiatorHelper {
    public static <T> Class<? super T> getNonSerializableSuperClass(Class<T> clazz) {
        Class<T> clazz2 = clazz;
        while (Serializable.class.isAssignableFrom(clazz2)) {
            if ((clazz2 = clazz2.getSuperclass()) != null) continue;
            throw new Error("Bad class hierarchy: No non-serializable parents");
        }
        return clazz2;
    }
}

