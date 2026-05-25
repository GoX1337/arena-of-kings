/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

public interface FailableDoubleUnaryOperator<E extends Throwable> {
    public static final FailableDoubleUnaryOperator NOP = d2 -> 0.0;

    public static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
        return d2 -> d2;
    }

    public static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
        return NOP;
    }

    default public FailableDoubleUnaryOperator<E> andThen(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return d2 -> failableDoubleUnaryOperator.applyAsDouble(this.applyAsDouble(d2));
    }

    public double applyAsDouble(double var1);

    default public FailableDoubleUnaryOperator<E> compose(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return d2 -> this.applyAsDouble(failableDoubleUnaryOperator.applyAsDouble(d2));
    }
}

