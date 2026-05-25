/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableBiConsumer<T, U, E extends Throwable> {
    public static final FailableBiConsumer NOP = (object, object2) -> {};

    public static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
        return NOP;
    }

    public void accept(T var1, U var2);

    default public FailableBiConsumer<T, U, E> andThen(FailableBiConsumer<? super T, ? super U, E> failableBiConsumer) {
        Objects.requireNonNull(failableBiConsumer);
        return (object, object2) -> {
            this.accept(object, object2);
            failableBiConsumer.accept(object, object2);
        };
    }
}

