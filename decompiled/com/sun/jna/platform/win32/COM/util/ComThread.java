/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.WinNT;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ComThread {
    private static ThreadLocal<Boolean> isCOMThread = new ThreadLocal();
    ExecutorService executor;
    Runnable firstTask;
    boolean requiresInitialisation = true;
    long timeoutMilliseconds;
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ComThread(String string, long l2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this(string, l2, uncaughtExceptionHandler, 0);
    }

    public ComThread(final String string, long l2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, final int n2) {
        this.timeoutMilliseconds = l2;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        this.firstTask = new Runnable(){

            @Override
            public void run() {
                try {
                    WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeEx(null, n2);
                    isCOMThread.set(true);
                    COMUtils.checkRC(hRESULT);
                    ComThread.this.requiresInitialisation = false;
                }
                catch (Throwable throwable) {
                    ComThread.this.uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), throwable);
                }
            }
        };
        this.executor = Executors.newSingleThreadExecutor(new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable) {
                if (!ComThread.this.requiresInitialisation) {
                    throw new RuntimeException("ComThread executor has a problem.");
                }
                Thread thread = new Thread(runnable, string);
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

                    @Override
                    public void uncaughtException(Thread thread, Throwable throwable) {
                        ComThread.this.requiresInitialisation = true;
                        ComThread.this.uncaughtExceptionHandler.uncaughtException(thread, throwable);
                    }
                });
                return thread;
            }
        });
    }

    public void terminate(long l2) {
        try {
            this.executor.submit(new Runnable(){

                @Override
                public void run() {
                    Ole32.INSTANCE.CoUninitialize();
                }
            }).get(l2, TimeUnit.MILLISECONDS);
            this.executor.shutdown();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        catch (ExecutionException executionException) {
            executionException.printStackTrace();
        }
        catch (TimeoutException timeoutException) {
            this.executor.shutdownNow();
        }
    }

    protected void finalize() {
        if (!this.executor.isShutdown()) {
            this.terminate(100L);
        }
    }

    static void setComThread(boolean bl2) {
        isCOMThread.set(bl2);
    }

    public <T> T execute(Callable<T> callable) {
        Boolean bl2 = isCOMThread.get();
        if (bl2 == null) {
            bl2 = false;
        }
        if (bl2.booleanValue()) {
            try {
                return callable.call();
            }
            catch (Exception exception) {
                throw new ExecutionException(exception);
            }
        }
        if (this.requiresInitialisation) {
            this.executor.execute(this.firstTask);
        }
        return this.executor.submit(callable).get(this.timeoutMilliseconds, TimeUnit.MILLISECONDS);
    }
}

