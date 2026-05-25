/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableLongPredicate<E extends Throwable> {
    public static final FailableLongPredicate FALSE = l2 -> false;
    public static final FailableLongPredicate TRUE = l2 -> true;

    public static <E extends Throwable> FailableLongPredicate<E> falsePredicate() {
        return FALSE;
    }

    public static <E extends Throwable> FailableLongPredicate<E> truePredicate() {
        return TRUE;
    }

    default public FailableLongPredicate<E> and(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return l2 -> this.test(l2) && failableLongPredicate.test(l2);
    }

    default public FailableLongPredicate<E> negate() {
        return l2 -> !this.test(l2);
    }

    default public FailableLongPredicate<E> or(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return l2 -> this.test(l2) || failableLongPredicate.test(l2);
    }

    public boolean test(long var1);
}

