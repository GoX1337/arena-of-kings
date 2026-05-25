/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.async;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.async.AsyncResult;
import com.badlogic.gdx.utils.async.AsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class AsyncExecutor
implements Disposable {
    private final ExecutorService executor;

    public AsyncExecutor(int n2) {
        this(n2, "AsynchExecutor-Thread");
    }

    public AsyncExecutor(int n2, final String string) {
        this.executor = Executors.newFixedThreadPool(n2, new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, string);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    public <T> AsyncResult<T> submit(final AsyncTask<T> asyncTask) {
        if (this.executor.isShutdown()) {
            throw new GdxRuntimeException("Cannot run tasks on an executor that has been shutdown (disposed)");
        }
        return new AsyncResult(this.executor.submit(new Callable<T>(){

            @Override
            public T call() {
                return asyncTask.call();
            }
        }));
    }

    @Override
    public void dispose() {
        this.executor.shutdown();
        try {
            this.executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedException) {
            throw new GdxRuntimeException("Couldn't shutdown loading thread", interruptedException);
        }
    }
}

