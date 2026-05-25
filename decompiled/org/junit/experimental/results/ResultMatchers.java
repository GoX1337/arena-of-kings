/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.results;

import org.hamcrest.Matcher;
import org.junit.experimental.results.PrintableResult;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ResultMatchers {
    public static Matcher<PrintableResult> isSuccessful() {
        return ResultMatchers.failureCountIs(0);
    }

    public static Matcher<PrintableResult> failureCountIs(int n2) {
        return new bxz(n2);
    }

    public static Matcher<Object> hasSingleFailureContaining(String string) {
        return new bya(string);
    }

    public static Matcher<PrintableResult> hasFailureContaining(String string) {
        return new byb(string);
    }
}

