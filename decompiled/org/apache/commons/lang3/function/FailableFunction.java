/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableFunction<T, R, E extends Throwable> {
    public static final FailableFunction NOP = object -> null;

    public static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
        return object -> object;
    }

    public static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
        return NOP;
    }

    default public <V> FailableFunction<T, V, E> andThen(FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return object -> failableFunction.apply((R)this.apply(object));
    }

    public R apply(T var1);

    default public <V> FailableFunction<V, R, E> compose(FailableFunction<? super V, ? extends T, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return object -> this.apply(failableFunction.apply((Object)object));
    }
}

