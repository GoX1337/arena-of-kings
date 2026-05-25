/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.BooleanUtils;

public class InheritanceUtils {
    public static int distance(Class<?> clazz, Class<?> clazz2) {
        if (clazz == null || clazz2 == null) {
            return -1;
        }
        if (clazz.equals(clazz2)) {
            return 0;
        }
        Class<?> clazz3 = clazz.getSuperclass();
        int n2 = BooleanUtils.toInteger(clazz2.equals(clazz3));
        if (n2 == 1) {
            return n2;
        }
        return (n2 += InheritanceUtils.distance(clazz3, clazz2)) > 0 ? n2 + 1 : -1;
    }
}

