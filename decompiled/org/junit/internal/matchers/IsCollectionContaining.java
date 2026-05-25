/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.matchers;

import java.util.ArrayList;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsEqual;
import org.junit.internal.matchers.TypeSafeMatcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IsCollectionContaining<T>
extends TypeSafeMatcher<Iterable<T>> {
    private final Matcher<? extends T> elementMatcher;

    public IsCollectionContaining(Matcher<? extends T> matcher) {
        this.elementMatcher = matcher;
    }

    @Override
    public boolean matchesSafely(Iterable<T> iterable) {
        for (T t2 : iterable) {
            if (!this.elementMatcher.matches(t2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a collection containing ").appendDescriptionOf(this.elementMatcher);
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItem(Matcher<? extends T> matcher) {
        return new IsCollectionContaining<T>(matcher);
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItem(T t2) {
        return IsCollectionContaining.hasItem(IsEqual.equalTo(t2));
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? extends T> ... matcherArray) {
        ArrayList arrayList = new ArrayList(matcherArray.length);
        for (Matcher<? extends T> matcher : matcherArray) {
            arrayList.add(IsCollectionContaining.hasItem(matcher));
        }
        return AllOf.allOf(arrayList);
    }

    @Factory
    public static <T> Matcher<Iterable<T>> hasItems(T ... TArray) {
        ArrayList arrayList = new ArrayList(TArray.length);
        for (T t2 : TArray) {
            arrayList.add(IsCollectionContaining.hasItem(t2));
        }
        return AllOf.allOf(arrayList);
    }
}

