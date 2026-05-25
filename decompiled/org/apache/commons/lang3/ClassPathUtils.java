/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.Validate;

public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> clazz, String string) {
        Validate.notNull(clazz, "context", new Object[0]);
        Validate.notNull(string, "resourceName", new Object[0]);
        return ClassPathUtils.toFullyQualifiedName(clazz.getPackage(), string);
    }

    public static String toFullyQualifiedName(Package package_, String string) {
        Validate.notNull(package_, "context", new Object[0]);
        Validate.notNull(string, "resourceName", new Object[0]);
        return package_.getName() + "." + string;
    }

    public static String toFullyQualifiedPath(Class<?> clazz, String string) {
        Validate.notNull(clazz, "context", new Object[0]);
        Validate.notNull(string, "resourceName", new Object[0]);
        return ClassPathUtils.toFullyQualifiedPath(clazz.getPackage(), string);
    }

    public static String toFullyQualifiedPath(Package package_, String string) {
        Validate.notNull(package_, "context", new Object[0]);
        Validate.notNull(string, "resourceName", new Object[0]);
        return package_.getName().replace('.', '/') + "/" + string;
    }
}

