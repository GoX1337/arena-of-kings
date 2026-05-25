/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest;

import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.DescribedAs;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CoreMatchers {
    public static <T> Matcher<T> is(Matcher<T> matcher) {
        return Is.is(matcher);
    }

    public static <T> Matcher<T> is(T t2) {
        return Is.is(t2);
    }

    public static Matcher<Object> is(Class<?> clazz) {
        return Is.is(clazz);
    }

    public static <T> Matcher<T> not(Matcher<T> matcher) {
        return IsNot.not(matcher);
    }

    public static <T> Matcher<T> not(T t2) {
        return IsNot.not(t2);
    }

    public static <T> Matcher<T> equalTo(T t2) {
        return IsEqual.equalTo(t2);
    }

    public static Matcher<Object> instanceOf(Class<?> clazz) {
        return IsInstanceOf.instanceOf(clazz);
    }

    public static <T> Matcher<T> allOf(Matcher<? extends T> ... matcherArray) {
        return AllOf.allOf(matcherArray);
    }

    public static <T> Matcher<T> allOf(Iterable<Matcher<? extends T>> iterable) {
        return AllOf.allOf(iterable);
    }

    public static <T> Matcher<T> anyOf(Matcher<? extends T> ... matcherArray) {
        return AnyOf.anyOf(matcherArray);
    }

    public static <T> Matcher<T> anyOf(Iterable<Matcher<? extends T>> iterable) {
        return AnyOf.anyOf(iterable);
    }

    public static <T> Matcher<T> sameInstance(T t2) {
        return IsSame.sameInstance(t2);
    }

    public static <T> Matcher<T> anything() {
        return IsAnything.anything();
    }

    public static <T> Matcher<T> anything(String string) {
        return IsAnything.anything(string);
    }

    public static <T> Matcher<T> any(Class<T> clazz) {
        return IsAnything.any(clazz);
    }

    public static <T> Matcher<T> nullValue() {
        return IsNull.nullValue();
    }

    public static <T> Matcher<T> nullValue(Class<T> clazz) {
        return IsNull.nullValue(clazz);
    }

    public static <T> Matcher<T> notNullValue() {
        return IsNull.notNullValue();
    }

    public static <T> Matcher<T> notNullValue(Class<T> clazz) {
        return IsNull.notNullValue(clazz);
    }

    public static <T> Matcher<T> describedAs(String string, Matcher<T> matcher, Object ... objectArray) {
        return DescribedAs.describedAs(string, matcher, objectArray);
    }
}

