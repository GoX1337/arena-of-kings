/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableToLongFunction<T, E extends Throwable> {
    public static final FailableToLongFunction NOP = object -> 0L;

    public static <T, E extends Throwable> FailableToLongFunction<T, E> nop() {
        return NOP;
    }

    public long applyAsLong(T var1);
}

