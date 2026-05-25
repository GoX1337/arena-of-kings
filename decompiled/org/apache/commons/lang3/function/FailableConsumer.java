/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableConsumer<T, E extends Throwable> {
    public static final FailableConsumer NOP = object -> {};

    public static <T, E extends Throwable> FailableConsumer<T, E> nop() {
        return NOP;
    }

    public void accept(T var1);

    default public FailableConsumer<T, E> andThen(FailableConsumer<? super T, E> failableConsumer) {
        Objects.requireNonNull(failableConsumer);
        return object -> {
            this.accept(object);
            failableConsumer.accept(object);
        };
    }
}

