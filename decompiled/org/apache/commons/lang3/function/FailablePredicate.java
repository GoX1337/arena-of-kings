/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE = object -> false;
    public static final FailablePredicate TRUE = object -> true;

    public static <T, E extends Throwable> FailablePredicate<T, E> falsePredicate() {
        return FALSE;
    }

    public static <T, E extends Throwable> FailablePredicate<T, E> truePredicate() {
        return TRUE;
    }

    default public FailablePredicate<T, E> and(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return object -> this.test(object) && failablePredicate.test(object);
    }

    default public FailablePredicate<T, E> negate() {
        return object -> !this.test(object);
    }

    default public FailablePredicate<T, E> or(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return object -> this.test(object) || failablePredicate.test(object);
    }

    public boolean test(T var1);
}

