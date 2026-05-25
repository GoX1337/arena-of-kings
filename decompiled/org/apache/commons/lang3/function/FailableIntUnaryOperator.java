/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

public interface FailableIntUnaryOperator<E extends Throwable> {
    public static final FailableIntUnaryOperator NOP = n2 -> 0;

    public static <E extends Throwable> FailableIntUnaryOperator<E> identity() {
        return n2 -> n2;
    }

    public static <E extends Throwable> FailableIntUnaryOperator<E> nop() {
        return NOP;
    }

    default public FailableIntUnaryOperator<E> andThen(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return n2 -> failableIntUnaryOperator.applyAsInt(this.applyAsInt(n2));
    }

    public int applyAsInt(int var1);

    default public FailableIntUnaryOperator<E> compose(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return n2 -> this.applyAsInt(failableIntUnaryOperator.applyAsInt(n2));
    }
}

