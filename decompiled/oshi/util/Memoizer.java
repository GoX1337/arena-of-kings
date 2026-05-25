/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.GlobalConfig;

@ThreadSafe
public final class Memoizer {
    private static final Supplier<Long> DEFAULT_EXPIRATION_NANOS = Memoizer.memoize(Memoizer::queryExpirationConfig, TimeUnit.MINUTES.toNanos(1L));

    private Memoizer() {
    }

    private static long queryExpirationConfig() {
        return TimeUnit.MILLISECONDS.toNanos(GlobalConfig.get("oshi.util.memoizer.expiration", 300));
    }

    public static long defaultExpiration() {
        return DEFAULT_EXPIRATION_NANOS.get();
    }

    public static <T> Supplier<T> memoize(final Supplier<T> supplier, final long l2) {
        return new Supplier<T>(){
            final Supplier<T> delegate;
            volatile T value;
            volatile long expirationNanos;
            {
                this.delegate = supplier;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public T get() {
                long l22 = this.expirationNanos;
                long l3 = System.nanoTime();
                if (l22 == 0L || l2 >= 0L && l3 - l22 >= 0L) {
                    _1 var5_3 = this;
                    synchronized (var5_3) {
                        if (l22 == this.expirationNanos) {
                            Object t2 = this.delegate.get();
                            this.value = t2;
                            l22 = l3 + l2;
                            this.expirationNanos = l22 == 0L ? 1L : l22;
                            return t2;
                        }
                    }
                }
                return this.value;
            }
        };
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        return Memoizer.memoize(supplier, -1L);
    }
}

