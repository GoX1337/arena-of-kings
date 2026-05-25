/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = d2 -> {};

    public static <E extends Throwable> FailableDoubleConsumer<E> nop() {
        return NOP;
    }

    public void accept(double var1);

    default public FailableDoubleConsumer<E> andThen(FailableDoubleConsumer<E> failableDoubleConsumer) {
        Objects.requireNonNull(failableDoubleConsumer);
        return d2 -> {
            this.accept(d2);
            failableDoubleConsumer.accept(d2);
        };
    }
}

