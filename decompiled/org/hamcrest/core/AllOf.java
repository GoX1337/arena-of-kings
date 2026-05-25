/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest.core;

import java.util.Arrays;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AllOf<T>
extends BaseMatcher<T> {
    private final Iterable<Matcher<? extends T>> matchers;

    public AllOf(Iterable<Matcher<? extends T>> iterable) {
        this.matchers = iterable;
    }

    @Override
    public boolean matches(Object object) {
        for (Matcher<T> matcher : this.matchers) {
            if (matcher.matches(object)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendList("(", " and ", ")", this.matchers);
    }

    @Factory
    public static <T> Matcher<T> allOf(Matcher<? extends T> ... matcherArray) {
        return AllOf.allOf(Arrays.asList(matcherArray));
    }

    @Factory
    public static <T> Matcher<T> allOf(Iterable<Matcher<? extends T>> iterable) {
        return new AllOf<T>(iterable);
    }
}

