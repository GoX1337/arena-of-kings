/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableFunction;

@FunctionalInterface
public interface FailableBiFunction<T, U, R, E extends Throwable> {
    public static final FailableBiFunction NOP = (object, object2) -> null;

    public static <T, U, R, E extends Throwable> FailableBiFunction<T, U, R, E> nop() {
        return NOP;
    }

    default public <V> FailableBiFunction<T, U, V, E> andThen(FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return (object, object2) -> failableFunction.apply((R)this.apply(object, object2));
    }

    public R apply(T var1, U var2);
}

