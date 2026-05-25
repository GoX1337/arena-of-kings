/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.compare;

import java.util.function.Predicate;

public class ComparableUtils {
    public static <A extends Comparable<A>> Predicate<A> between(A a2, A a3) {
        return comparable3 -> ComparableUtils.is(comparable3).between(a2, a3);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A a2, A a3) {
        return comparable3 -> ComparableUtils.is(comparable3).betweenExclusive(a2, a3);
    }

    public static <A extends Comparable<A>> Predicate<A> ge(A a2) {
        return comparable2 -> ComparableUtils.is(comparable2).greaterThanOrEqualTo(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> gt(A a2) {
        return comparable2 -> ComparableUtils.is(comparable2).greaterThan(a2);
    }

    public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A a2) {
        return new ComparableCheckBuilder(a2, null);
    }

    public static <A extends Comparable<A>> Predicate<A> le(A a2) {
        return comparable2 -> ComparableUtils.is(comparable2).lessThanOrEqualTo(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> lt(A a2) {
        return comparable2 -> ComparableUtils.is(comparable2).lessThan(a2);
    }

    private ComparableUtils() {
    }

    public static class ComparableCheckBuilder<A extends Comparable<A>> {
        private final A a;

        private ComparableCheckBuilder(A a2) {
            this.a = a2;
        }

        public boolean between(A a2, A a3) {
            return this.betweenOrdered(a2, a3) || this.betweenOrdered(a3, a2);
        }

        public boolean betweenExclusive(A a2, A a3) {
            return this.betweenOrderedExclusive(a2, a3) || this.betweenOrderedExclusive(a3, a2);
        }

        private boolean betweenOrdered(A a2, A a3) {
            return this.greaterThanOrEqualTo(a2) && this.lessThanOrEqualTo(a3);
        }

        private boolean betweenOrderedExclusive(A a2, A a3) {
            return this.greaterThan(a2) && this.lessThan(a3);
        }

        public boolean equalTo(A a2) {
            return this.a.compareTo(a2) == 0;
        }

        public boolean greaterThan(A a2) {
            return this.a.compareTo(a2) > 0;
        }

        public boolean greaterThanOrEqualTo(A a2) {
            return this.a.compareTo(a2) >= 0;
        }

        public boolean lessThan(A a2) {
            return this.a.compareTo(a2) < 0;
        }

        public boolean lessThanOrEqualTo(A a2) {
            return this.a.compareTo(a2) <= 0;
        }

        /* synthetic */ ComparableCheckBuilder(Comparable comparable, _1 var2_2) {
            this(comparable);
        }
    }
}

