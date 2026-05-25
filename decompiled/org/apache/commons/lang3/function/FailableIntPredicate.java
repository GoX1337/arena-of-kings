/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableIntPredicate<E extends Throwable> {
    public static final FailableIntPredicate FALSE = n2 -> false;
    public static final FailableIntPredicate TRUE = n2 -> true;

    public static <E extends Throwable> FailableIntPredicate<E> falsePredicate() {
        return FALSE;
    }

    public static <E extends Throwable> FailableIntPredicate<E> truePredicate() {
        return TRUE;
    }

    default public FailableIntPredicate<E> and(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return n2 -> this.test(n2) && failableIntPredicate.test(n2);
    }

    default public FailableIntPredicate<E> negate() {
        return n2 -> !this.test(n2);
    }

    default public FailableIntPredicate<E> or(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return n2 -> this.test(n2) || failableIntPredicate.test(n2);
    }

    public boolean test(int var1);
}

