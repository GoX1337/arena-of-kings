/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = l2 -> {};

    public static <E extends Throwable> FailableLongConsumer<E> nop() {
        return NOP;
    }

    public void accept(long var1);

    default public FailableLongConsumer<E> andThen(FailableLongConsumer<E> failableLongConsumer) {
        Objects.requireNonNull(failableLongConsumer);
        return l2 -> {
            this.accept(l2);
            failableLongConsumer.accept(l2);
        };
    }
}

