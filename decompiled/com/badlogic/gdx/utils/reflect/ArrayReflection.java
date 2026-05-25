/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.Array;

public final class ArrayReflection {
    public static Object newInstance(Class clazz, int n2) {
        return Array.newInstance(clazz, n2);
    }

    public static int getLength(Object object) {
        return Array.getLength(object);
    }

    public static Object get(Object object, int n2) {
        return Array.get(object, n2);
    }

    public static void set(Object object, int n2, Object object2) {
        Array.set(object, n2, object2);
    }
}

