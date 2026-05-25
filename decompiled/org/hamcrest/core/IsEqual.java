/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest.core;

import java.lang.reflect.Array;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IsEqual<T>
extends BaseMatcher<T> {
    private final Object object;

    public IsEqual(T t2) {
        this.object = t2;
    }

    @Override
    public boolean matches(Object object) {
        return IsEqual.areEqual(this.object, object);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(this.object);
    }

    private static boolean areEqual(Object object, Object object2) {
        if (object == null || object2 == null) {
            return object == null && object2 == null;
        }
        if (IsEqual.isArray(object)) {
            return IsEqual.isArray(object2) && IsEqual.areArraysEqual(object, object2);
        }
        return object.equals(object2);
    }

    private static boolean areArraysEqual(Object object, Object object2) {
        return IsEqual.areArrayLengthsEqual(object, object2) && IsEqual.areArrayElementsEqual(object, object2);
    }

    private static boolean areArrayLengthsEqual(Object object, Object object2) {
        return Array.getLength(object) == Array.getLength(object2);
    }

    private static boolean areArrayElementsEqual(Object object, Object object2) {
        for (int i2 = 0; i2 < Array.getLength(object); ++i2) {
            if (IsEqual.areEqual(Array.get(object, i2), Array.get(object2, i2))) continue;
            return false;
        }
        return true;
    }

    private static boolean isArray(Object object) {
        return object.getClass().isArray();
    }

    @Factory
    public static <T> Matcher<T> equalTo(T t2) {
        return new IsEqual<T>(t2);
    }
}

