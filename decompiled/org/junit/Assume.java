/*
 * Decompiled with CFR 0.152.
 */
package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.matchers.Each;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Assume {
    public static void assumeTrue(boolean bl2) {
        Assume.assumeThat(bl2, CoreMatchers.is(true));
    }

    public static void assumeNotNull(Object ... objectArray) {
        Assume.assumeThat(Arrays.asList(objectArray), Each.each(CoreMatchers.notNullValue()));
    }

    public static <T> void assumeThat(T t2, Matcher<T> matcher) {
        if (!matcher.matches(t2)) {
            throw new AssumptionViolatedException(t2, matcher);
        }
    }

    public static void assumeNoException(Throwable throwable) {
        Assume.assumeThat(throwable, CoreMatchers.nullValue());
    }
}

