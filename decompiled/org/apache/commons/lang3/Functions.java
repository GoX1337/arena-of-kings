/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

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
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

@Deprecated
public class Functions {
    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> failableBiConsumer, O1 O1, O2 O2) {
        Functions.run(() -> failableBiConsumer.accept(O1, O2));
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> failableConsumer, O o2) {
        Functions.run(() -> failableConsumer.accept(o2));
    }

    public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> failableBiFunction, O1 O1, O2 O2) {
        return (O)Functions.get(() -> failableBiFunction.apply(O1, O2));
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> failableFunction, I i2) {
        return (O)Functions.get(() -> failableFunction.apply(i2));
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> failableBiConsumer) {
        return (object, object2) -> Functions.accept(failableBiConsumer, object, object2);
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> failableBiFunction) {
        return (object, object2) -> Functions.apply(failableBiFunction, object, object2);
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> failableBiPredicate) {
        return (object, object2) -> Functions.test(failableBiPredicate, object, object2);
    }

    public static <O> Callable<O> asCallable(FailableCallable<O, ?> failableCallable) {
        return () -> Functions.call(failableCallable);
    }

    public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> failableConsumer) {
        return object -> Functions.accept(failableConsumer, object);
    }

    public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> failableFunction) {
        return object -> Functions.apply(failableFunction, object);
    }

    public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> failablePredicate) {
        return object -> Functions.test(failablePredicate, object);
    }

    public static Runnable asRunnable(FailableRunnable<?> failableRunnable) {
        return () -> Functions.run(failableRunnable);
    }

    public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> failableSupplier) {
        return () -> Functions.get(failableSupplier);
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> failableCallable) {
        return (O)Functions.get(failableCallable::call);
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> failableSupplier) {
        try {
            return failableSupplier.get();
        }
        catch (Throwable throwable) {
            throw Functions.rethrow(throwable);
        }
    }

    private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        }
        catch (Throwable throwable) {
            throw Functions.rethrow(throwable);
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

    public static <T extends Throwable> void run(FailableRunnable<T> failableRunnable) {
        try {
            failableRunnable.run();
        }
        catch (Throwable throwable) {
            throw Functions.rethrow(throwable);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream<O>(collection.stream());
    }

    public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
        return new Streams.FailableStream<O>(stream);
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> failableBiPredicate, O1 O1, O2 O2) {
        return Functions.getAsBoolean(() -> failableBiPredicate.test(O1, O2));
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> failablePredicate, O o2) {
        return Functions.getAsBoolean(() -> failablePredicate.test(o2));
    }

    /*
     * WARNING - void declaration
     */
    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable> ... failableRunnableArray) {
        void var4_8;
        FailableConsumer<Throwable, Object> failableConsumer2 = failableConsumer == null ? Functions::rethrow : failableConsumer;
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
                throw Functions.rethrow(throwable);
            }
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable> ... failableRunnableArray) {
        Functions.tryWithResources(failableRunnable, null, failableRunnableArray);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableSupplier<R, T extends Throwable> {
        public R get();
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableRunnable<T extends Throwable> {
        public void run();
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailablePredicate<I, T extends Throwable> {
        public boolean test(I var1);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableFunction<I, R, T extends Throwable> {
        public R apply(I var1);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableConsumer<O, T extends Throwable> {
        public void accept(O var1);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableCallable<R, T extends Throwable> {
        public R call();
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiPredicate<O1, O2, T extends Throwable> {
        public boolean test(O1 var1, O2 var2);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        public R apply(O1 var1, O2 var2);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiConsumer<O1, O2, T extends Throwable> {
        public void accept(O1 var1, O2 var2);
    }
}

