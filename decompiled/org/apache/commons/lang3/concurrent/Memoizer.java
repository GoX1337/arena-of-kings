/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import org.apache.commons.lang3.concurrent.Computable;

public class Memoizer<I, O>
implements Computable<I, O> {
    private final ConcurrentMap<I, Future<O>> cache = new ConcurrentHashMap<I, Future<O>>();
    private final Computable<I, O> computable;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this(computable, false);
    }

    public Memoizer(Computable<I, O> computable, boolean bl2) {
        this.computable = computable;
        this.recalculate = bl2;
    }

    @Override
    public O compute(I i2) {
        while (true) {
            Callable<Object> callable;
            FutureTask<Object> futureTask;
            FutureTask<Object> futureTask2;
            if ((futureTask2 = (FutureTask<Object>)this.cache.get(i2)) == null && (futureTask2 = (Future)this.cache.putIfAbsent(i2, futureTask = new FutureTask<Object>(callable = () -> this.computable.compute(i2)))) == null) {
                futureTask2 = futureTask;
                futureTask.run();
            }
            try {
                return (O)futureTask2.get();
            }
            catch (CancellationException cancellationException) {
                this.cache.remove(i2, futureTask2);
                continue;
            }
            catch (ExecutionException executionException) {
                if (this.recalculate) {
                    this.cache.remove(i2, futureTask2);
                }
                throw this.launderException(executionException.getCause());
            }
            break;
        }
    }

    private RuntimeException launderException(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            return (RuntimeException)throwable;
        }
        if (throwable instanceof Error) {
            throw (Error)throwable;
        }
        throw new IllegalStateException("Unchecked exception", throwable);
    }
}

