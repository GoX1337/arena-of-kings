/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableDoublePredicate<E extends Throwable> {
    public static final FailableDoublePredicate FALSE = d2 -> false;
    public static final FailableDoublePredicate TRUE = d2 -> true;

    public static <E extends Throwable> FailableDoublePredicate<E> falsePredicate() {
        return FALSE;
    }

    public static <E extends Throwable> FailableDoublePredicate<E> truePredicate() {
        return TRUE;
    }

    default public FailableDoublePredicate<E> and(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return d2 -> this.test(d2) && failableDoublePredicate.test(d2);
    }

    default public FailableDoublePredicate<E> negate() {
        return d2 -> !this.test(d2);
    }

    default public FailableDoublePredicate<E> or(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return d2 -> this.test(d2) || failableDoublePredicate.test(d2);
    }

    public boolean test(double var1);
}

