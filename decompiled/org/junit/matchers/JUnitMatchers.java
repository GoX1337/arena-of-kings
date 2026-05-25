/*
 * Decompiled with CFR 0.152.
 */
package org.junit.matchers;

import org.hamcrest.Matcher;
import org.junit.internal.matchers.CombinableMatcher;
import org.junit.internal.matchers.Each;
import org.junit.internal.matchers.IsCollectionContaining;
import org.junit.internal.matchers.StringContains;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JUnitMatchers {
    public static <T> Matcher<Iterable<T>> hasItem(T t2) {
        return IsCollectionContaining.hasItem(t2);
    }

    public static <T> Matcher<Iterable<T>> hasItem(Matcher<? extends T> matcher) {
        return IsCollectionContaining.hasItem(matcher);
    }

    public static <T> Matcher<Iterable<T>> hasItems(T ... TArray) {
        return IsCollectionContaining.hasItems(TArray);
    }

    public static <T> Matcher<Iterable<T>> hasItems(Matcher<? extends T> ... matcherArray) {
        return IsCollectionContaining.hasItems(matcherArray);
    }

    public static <T> Matcher<Iterable<T>> everyItem(Matcher<T> matcher) {
        return Each.each(matcher);
    }

    public static Matcher<String> containsString(String string) {
        return StringContains.containsString(string);
    }

    public static <T> CombinableMatcher<T> both(Matcher<T> matcher) {
        return new CombinableMatcher<T>(matcher);
    }

    public static <T> CombinableMatcher<T> either(Matcher<T> matcher) {
        return new CombinableMatcher<T>(matcher);
    }
}

