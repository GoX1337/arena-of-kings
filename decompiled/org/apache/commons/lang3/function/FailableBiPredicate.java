/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableBiPredicate<T, U, E extends Throwable> {
    public static final FailableBiPredicate FALSE = (object, object2) -> false;
    public static final FailableBiPredicate TRUE = (object, object2) -> true;

    public static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> falsePredicate() {
        return FALSE;
    }

    public static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> truePredicate() {
        return TRUE;
    }

    default public FailableBiPredicate<T, U, E> and(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return (object, object2) -> this.test(object, object2) && failableBiPredicate.test(object, object2);
    }

    default public FailableBiPredicate<T, U, E> negate() {
        return (object, object2) -> !this.test(object, object2);
    }

    default public FailableBiPredicate<T, U, E> or(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return (object, object2) -> this.test(object, object2) || failableBiPredicate.test(object, object2);
    }

    public boolean test(T var1, U var2);
}

