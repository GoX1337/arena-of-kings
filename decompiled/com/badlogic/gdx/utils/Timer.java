/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Timer {
    static final Object threadLock = new Object();
    static TimerThread thread;
    final Array<Task> tasks = new Array(false, 8);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Timer instance() {
        Object object = threadLock;
        synchronized (object) {
            TimerThread timerThread = Timer.thread();
            if (timerThread.instance == null) {
                timerThread.instance = new Timer();
            }
            return timerThread.instance;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static TimerThread thread() {
        Object object = threadLock;
        synchronized (object) {
            if (thread == null || Timer.thread.files != Gdx.files) {
                if (thread != null) {
                    thread.dispose();
                }
                thread = new TimerThread();
            }
            return thread;
        }
    }

    public Timer() {
        this.start();
    }

    public Task postTask(Task task) {
        return this.scheduleTask(task, 0.0f, 0.0f, 0);
    }

    public Task scheduleTask(Task task, float f2) {
        return this.scheduleTask(task, f2, 0.0f, 0);
    }

    public Task scheduleTask(Task task, float f2, float f3) {
        return this.scheduleTask(task, f2, f3, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Task scheduleTask(Task task, float f2, float f3, int n2) {
        Object object = threadLock;
        synchronized (object) {
            Timer timer = this;
            synchronized (timer) {
                Task task2 = task;
                synchronized (task2) {
                    if (task.timer != null) {
                        throw new IllegalArgumentException("The same task may not be scheduled twice.");
                    }
                    task.timer = this;
                    long l2 = System.nanoTime() / 1000000L;
                    long l3 = l2 + (long)(f2 * 1000.0f);
                    if (Timer.thread.pauseTimeMillis > 0L) {
                        l3 -= l2 - Timer.thread.pauseTimeMillis;
                    }
                    task.executeTimeMillis = l3;
                    task.intervalMillis = (long)(f3 * 1000.0f);
                    task.repeatCount = n2;
                    this.tasks.add(task);
                }
            }
            threadLock.notifyAll();
        }
        return task;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        Object object = threadLock;
        synchronized (object) {
            Timer.thread().instances.removeValue(this, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() {
        Object object = threadLock;
        synchronized (object) {
            TimerThread timerThread = Timer.thread();
            Array<Timer> array = timerThread.instances;
            if (array.contains(this, true)) {
                return;
            }
            array.add(this);
            threadLock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void clear() {
        int n2 = this.tasks.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Task task;
            Task task2 = task = this.tasks.get(i2);
            synchronized (task2) {
                task.executeTimeMillis = 0L;
                task.timer = null;
                continue;
            }
        }
        this.tasks.clear();
    }

    public synchronized boolean isEmpty() {
        return this.tasks.size == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    synchronized long update(long l2, long l3) {
        int n2 = this.tasks.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Task task;
            Task task2 = task = this.tasks.get(i2);
            synchronized (task2) {
                if (task.executeTimeMillis > l2) {
                    l3 = Math.min(l3, task.executeTimeMillis - l2);
                    continue;
                }
                if (task.repeatCount == 0) {
                    task.timer = null;
                    this.tasks.removeIndex(i2);
                    --i2;
                    --n2;
                } else {
                    task.executeTimeMillis = l2 + task.intervalMillis;
                    l3 = Math.min(l3, task.intervalMillis);
                    if (task.repeatCount > 0) {
                        --task.repeatCount;
                    }
                }
                task.app.postRunnable(task);
                continue;
            }
        }
        return l3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void delay(long l2) {
        int n2 = this.tasks.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Task task;
            Task task2 = task = this.tasks.get(i2);
            synchronized (task2) {
                task.executeTimeMillis += l2;
                continue;
            }
        }
    }

    public static Task post(Task task) {
        return Timer.instance().postTask(task);
    }

    public static Task schedule(Task task, float f2) {
        return Timer.instance().scheduleTask(task, f2);
    }

    public static Task schedule(Task task, float f2, float f3) {
        return Timer.instance().scheduleTask(task, f2, f3);
    }

    public static Task schedule(Task task, float f2, float f3, int n2) {
        return Timer.instance().scheduleTask(task, f2, f3, n2);
    }

    static class TimerThread
    implements LifecycleListener,
    Runnable {
        final Files files;
        final Application app;
        final Array<Timer> instances = new Array(1);
        Timer instance;
        long pauseTimeMillis;

        public TimerThread() {
            this.files = Gdx.files;
            this.app = Gdx.app;
            this.app.addLifecycleListener(this);
            this.resume();
            Thread thread = new Thread((Runnable)this, "Timer");
            thread.setDaemon(true);
            thread.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            while (true) {
                Object object = threadLock;
                synchronized (object) {
                    if (thread != this || this.files != Gdx.files) {
                        break;
                    }
                    long l2 = 5000L;
                    if (this.pauseTimeMillis == 0L) {
                        long l3 = System.nanoTime() / 1000000L;
                        int n2 = this.instances.size;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            try {
                                l2 = this.instances.get(i2).update(l3, l2);
                                continue;
                            }
                            catch (Throwable throwable) {
                                throw new GdxRuntimeException("Task failed: " + this.instances.get(i2).getClass().getName(), throwable);
                            }
                        }
                    }
                    if (thread != this || this.files != Gdx.files) {
                        break;
                    }
                    try {
                        if (l2 > 0L) {
                            threadLock.wait(l2);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                }
            }
            this.dispose();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void resume() {
            Object object = threadLock;
            synchronized (object) {
                long l2 = System.nanoTime() / 1000000L - this.pauseTimeMillis;
                int n2 = this.instances.size;
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.instances.get(i2).delay(l2);
                }
                this.pauseTimeMillis = 0L;
                threadLock.notifyAll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void pause() {
            Object object = threadLock;
            synchronized (object) {
                this.pauseTimeMillis = System.nanoTime() / 1000000L;
                threadLock.notifyAll();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void dispose() {
            Object object = threadLock;
            synchronized (object) {
                if (thread == this) {
                    thread = null;
                }
                this.instances.clear();
                threadLock.notifyAll();
            }
            this.app.removeLifecycleListener(this);
        }
    }

    public static abstract class Task
    implements Runnable {
        final Application app = Gdx.app;
        long executeTimeMillis;
        long intervalMillis;
        int repeatCount;
        volatile Timer timer;

        public Task() {
            if (this.app == null) {
                throw new IllegalStateException("Gdx.app not available.");
            }
        }

        @Override
        public abstract void run();

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void cancel() {
            Timer timer = this.timer;
            if (timer != null) {
                Timer timer2 = timer;
                synchronized (timer2) {
                    Task task = this;
                    synchronized (task) {
                        this.executeTimeMillis = 0L;
                        this.timer = null;
                        timer.tasks.removeValue(this, true);
                    }
                }
            }
            Task task = this;
            synchronized (task) {
                this.executeTimeMillis = 0L;
                this.timer = null;
            }
        }

        public boolean isScheduled() {
            return this.timer != null;
        }

        public synchronized long getExecuteTimeMillis() {
            return this.executeTimeMillis;
        }
    }
}

