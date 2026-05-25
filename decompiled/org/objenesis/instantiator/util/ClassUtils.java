/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.util;

import org.objenesis.ObjenesisException;

public final class ClassUtils {
    private ClassUtils() {
    }

    public static String classNameToInternalClassName(String string) {
        return string.replace('.', '/');
    }

    public static String classNameToResource(String string) {
        return ClassUtils.classNameToInternalClassName(string) + ".class";
    }

    public static <T> Class<T> getExistingClass(ClassLoader classLoader, String string) {
        try {
            return Class.forName(string, true, classLoader);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
            throw new ObjenesisException(reflectiveOperationException);
        }
    }
}

