/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.statements;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.Statement;

public class FailOnTimeout
extends Statement {
    private Statement fNext;
    private final long fTimeout;

    public FailOnTimeout(Statement statement, long l2) {
        this.fNext = statement;
        this.fTimeout = l2;
    }

    public void evaluate() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        byn byn2 = new byn(this);
        Future<Object> future = executorService.submit(byn2);
        executorService.shutdown();
        try {
            boolean bl2 = executorService.awaitTermination(this.fTimeout, TimeUnit.MILLISECONDS);
            if (!bl2) {
                executorService.shutdownNow();
            }
            future.get(0L, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException timeoutException) {
            throw new Exception(String.format("test timed out after %d milliseconds", this.fTimeout));
        }
        catch (ExecutionException executionException) {
            throw this.unwrap(executionException);
        }
    }

    private Throwable unwrap(Throwable throwable) {
        if (throwable instanceof ExecutionException) {
            return this.unwrap(throwable.getCause());
        }
        return throwable;
    }

    public static /* synthetic */ Statement access$000(FailOnTimeout failOnTimeout) {
        return failOnTimeout.fNext;
    }
}

