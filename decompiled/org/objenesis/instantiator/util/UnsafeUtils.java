/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.util;

import java.lang.reflect.Field;
import org.objenesis.ObjenesisException;
import sun.misc.Unsafe;

public final class UnsafeUtils {
    private static final Unsafe unsafe;

    private UnsafeUtils() {
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }

    static {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new ObjenesisException(noSuchFieldException);
        }
        field.setAccessible(true);
        try {
            unsafe = (Unsafe)field.get(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ObjenesisException(illegalAccessException);
        }
    }
}

