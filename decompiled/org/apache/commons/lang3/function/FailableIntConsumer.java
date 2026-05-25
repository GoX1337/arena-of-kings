/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableIntConsumer<E extends Throwable> {
    public static final FailableIntConsumer NOP = n2 -> {};

    public static <E extends Throwable> FailableIntConsumer<E> nop() {
        return NOP;
    }

    public void accept(int var1);

    default public FailableIntConsumer<E> andThen(FailableIntConsumer<E> failableIntConsumer) {
        Objects.requireNonNull(failableIntConsumer);
        return n2 -> {
            this.accept(n2);
            failableIntConsumer.accept(n2);
        };
    }
}

