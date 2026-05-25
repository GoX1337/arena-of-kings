/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.hamcrest.BaseMatcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class TypeSafeMatcher<T>
extends BaseMatcher<T> {
    private Class<?> expectedType;

    public abstract boolean matchesSafely(T var1);

    public TypeSafeMatcher() {
        this.expectedType = TypeSafeMatcher.findExpectedType(this.getClass());
    }

    private static Class<?> findExpectedType(Class<?> clazz) {
        for (Class<?> clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            for (Method method : clazz2.getDeclaredMethods()) {
                if (!TypeSafeMatcher.isMatchesSafelyMethod(method)) continue;
                return method.getParameterTypes()[0];
            }
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    private static boolean isMatchesSafelyMethod(Method method) {
        return method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic();
    }

    protected TypeSafeMatcher(Class<T> clazz) {
        this.expectedType = clazz;
    }

    @Override
    public final boolean matches(Object object) {
        return object != null && this.expectedType.isInstance(object) && this.matchesSafely(object);
    }
}

