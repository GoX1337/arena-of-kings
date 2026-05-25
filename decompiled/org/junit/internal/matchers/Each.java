/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.matchers;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.IsCollectionContaining;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Each {
    public static <T> Matcher<Iterable<T>> each(Matcher<T> matcher) {
        Matcher<Matcher<Iterable<Matcher<Matcher<T>>>>> matcher2 = CoreMatchers.not(IsCollectionContaining.hasItem(CoreMatchers.not(matcher)));
        return new byg(matcher2, matcher);
    }
}

