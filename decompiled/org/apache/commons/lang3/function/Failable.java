/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.apache.commons.lang3.function.FailableCallable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableDoubleBinaryOperator;
import org.apache.commons.lang3.function.FailableDoubleConsumer;
import org.apache.commons.lang3.function.FailableDoubleSupplier;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableIntSupplier;
import org.apache.commons.lang3.function.FailableLongConsumer;
import org.apache.commons.lang3.function.FailableLongSupplier;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableShortSupplier;
import org.apache.commons.lang3.function.FailableSupplier;
import org.apache.commons.lang3.stream.Streams;

public class Failable {
    public static <T, U, E extends Throwable> void accept(FailableBiConsumer<T, U, E> failableBiConsumer, T t2, U u2) {
        Failable.run(() -> failableBiConsumer.accept(t2, u2));
    }

    public static <T, E extends Throwable> void accept(FailableConsumer<T, E> failableConsumer, T t2) {
        Failable.run(() -> failableConsumer.accept(t2));
    }

    public static <E extends Throwable> void accept(FailableDoubleConsumer<E> failableDoubleConsumer, double d2) {
        Failable.run(() -> failableDoubleConsumer.accept(d2));
    }

    public static <E extends Throwable> void accept(FailableIntConsumer<E> failableIntConsumer, int n2) {
        Failable.run(() -> failableIntConsumer.accept(n2));
    }

    public static <E extends Throwable> void accept(FailableLongConsumer<E> failableLongConsumer, long l2) {
        Failable.run(() -> failableLongConsumer.accept(l2));
    }

    public static <T, U, R, E extends Throwable> R apply(FailableBiFunction<T, U, R, E> failableBiFunction, T t2, U u2) {
        return (R)Failable.get(() -> failableBiFunction.apply(t2, u2));
    }

    public static <T, R, E extends Throwable> R apply(FailableFunction<T, R, E> failableFunction, T t2) {
        return (R)Failable.get(() -> failableFunction.apply(t2));
    }

    public static <E extends Throwable> double applyAsDouble(FailableDoubleBinaryOperator<E> failableDoubleBinaryOperator, double d2, double d3) {
        return Failable.getAsDouble(() -> failableDoubleBinaryOperator.applyAsDouble(d2, d3));
    }

    public static <T, U> BiConsumer<T, U> asBiConsumer(FailableBiConsumer<T, U, ?> failableBiConsumer) {
        return (object, object2) -> Failable.accept(failableBiConsumer, object, object2);
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(FailableBiFunction<T, U, R, ?> failableBiFunction) {
        return (object, object2) -> Failable.apply(failableBiFunction, object, object2);
    }

    public static <T, U> BiPredicate<T, U> asBiPredicate(FailableBiPredicate<T, U, ?> failableBiPredicate) {
        return (object, object2) -> Failable.test(failableBiPredicate, object, object2);
    }

    public static <V> Callable<V> asCallable(FailableCallable<V, ?> failableCallable) {
        return () -> Failable.call(failableCallable);
    }

    public static <T> Consumer<T> asConsumer(FailableConsumer<T, ?> failableConsumer) {
        return object -> Failable.accept(failableConsumer, object);
    }

    public static <T, R> Function<T, R> asFunction(FailableFunction<T, R, ?> failableFunction) {
        return object -> Failable.apply(failableFunction, object);
    }

    public static <T> Predicate<T> asPredicate(FailablePredicate<T, ?> failablePredicate) {
        return object -> Failable.test(failablePredicate, object);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return () -> Failable.run(failableRunnable);
    }

    public static <T> Supplier<T> asSupplier(FailableSupplier<T, ?> failableSupplier) {
        return () -> Failable.get(failableSupplier);
    }

    public static <V, E extends Throwable> V call(FailableCallable<V, E> failableCallable) {
        return (V)Failable.get(failableCallable::call);
    }

    public static <T, E extends Throwable> T get(FailableSupplier<T, E> failableSupplier) {
        try {
            return failableSupplier.get();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> failableDoubleSupplier) {
        try {
            return failableDoubleSupplier.getAsDouble();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> failableIntSupplier) {
        try {
            return failableIntSupplier.getAsInt();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> failableLongSupplier) {
        try {
            return failableLongSupplier.getAsLong();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E extends Throwable> short getAsShort(FailableShortSupplier<E> failableShortSupplier) {
        try {
            return failableShortSupplier.getAsShort();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static RuntimeException rethrow(Throwable throwable) {
        Objects.requireNonNull(throwable, "throwable");
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException)throwable;
        }
        if (throwable instanceof Error) {
            throw (Error)throwable;
        }
        if (throwable instanceof IOException) {
            throw new UncheckedIOException((IOException)throwable);
        }
        throw new UndeclaredThrowableException(throwable);
    }

    public static <E extends Throwable> void run(FailableRunnable<E> failableRunnable) {
        try {
            failableRunnable.run();
        }
        catch (Throwable throwable) {
            throw Failable.rethrow(throwable);
        }
    }

    public static <E> Streams.FailableStream<E> stream(Collection<E> collection) {
        return new Streams.FailableStream<E>(collection.stream());
    }

    public static <T> Streams.FailableStream<T> stream(Stream<T> stream) {
        return new Streams.FailableStream<T>(stream);
    }

    public static <T, U, E extends Throwable> boolean test(FailableBiPredicate<T, U, E> failableBiPredicate, T t2, U u2) {
        return Failable.getAsBoolean(() -> failableBiPredicate.test(t2, u2));
    }

    public static <T, E extends Throwable> boolean test(FailablePredicate<T, E> failablePredicate, T t2) {
        return Failable.getAsBoolean(() -> failablePredicate.test(t2));
    }

    /*
     * WARNING - void declaration
     */
    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable> ... failableRunnableArray) {
        void var4_8;
        FailableConsumer<Throwable, Object> failableConsumer2 = failableConsumer == null ? Failable::rethrow : failableConsumer;
        if (failableRunnableArray != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable2 : failableRunnableArray) {
                Objects.requireNonNull(failableRunnable2, "runnable");
            }
        }
        Object var4_5 = null;
        try {
            failableRunnable.run();
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable;
        }
        if (failableRunnableArray != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable3 : failableRunnableArray) {
                try {
                    failableRunnable3.run();
                }
                catch (Throwable throwable) {
                    if (var4_8 != null) continue;
                    Throwable throwable3 = throwable;
                }
            }
        }
        if (var4_8 != null) {
            try {
                failableConsumer2.accept((Throwable)var4_8);
            }
            catch (Throwable throwable) {
                throw Failable.rethrow(throwable);
            }
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable> ... failableRunnableArray) {
        Failable.tryWithResources(failableRunnable, null, failableRunnableArray);
    }

    private Failable() {
    }
}

