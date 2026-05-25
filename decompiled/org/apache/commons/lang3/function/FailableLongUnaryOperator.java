/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

public interface FailableLongUnaryOperator<E extends Throwable> {
    public static final FailableLongUnaryOperator NOP = l2 -> 0L;

    public static <E extends Throwable> FailableLongUnaryOperator<E> identity() {
        return l2 -> l2;
    }

    public static <E extends Throwable> FailableLongUnaryOperator<E> nop() {
        return NOP;
    }

    default public FailableLongUnaryOperator<E> andThen(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return l2 -> failableLongUnaryOperator.applyAsLong(this.applyAsLong(l2));
    }

    public long applyAsLong(long var1);

    default public FailableLongUnaryOperator<E> compose(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return l2 -> this.applyAsLong(failableLongUnaryOperator.applyAsLong(l2));
    }
}

