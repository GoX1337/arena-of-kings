/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Is<T>
extends BaseMatcher<T> {
    private final Matcher<T> matcher;

    public Is(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Object object) {
        return this.matcher.matches(object);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    @Factory
    public static <T> Matcher<T> is(Matcher<T> matcher) {
        return new Is<T>(matcher);
    }

    @Factory
    public static <T> Matcher<T> is(T t2) {
        return Is.is(IsEqual.equalTo(t2));
    }

    @Factory
    public static Matcher<Object> is(Class<?> clazz) {
        return Is.is(IsInstanceOf.instanceOf(clazz));
    }
}

