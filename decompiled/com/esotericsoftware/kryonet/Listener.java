/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryonet.Connection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public interface Listener {
    default public void connected(Connection connection) {
    }

    default public void disconnected(Connection connection) {
    }

    default public void received(Connection connection, Object object) {
    }

    default public void idle(Connection connection) {
    }

    public static class LagListener
    extends QueuedListener {
        private final ScheduledExecutorService threadPool;
        private final int lagMillisMin;
        private final int lagMillisMax;
        final LinkedList<Runnable> runnables = new LinkedList();

        public LagListener(int n2, int n3, Listener listener) {
            super(listener);
            this.lagMillisMin = n2;
            this.lagMillisMax = n3;
            this.threadPool = Executors.newScheduledThreadPool(1);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void queue(Runnable runnable) {
            LinkedList<Runnable> linkedList = this.runnables;
            synchronized (linkedList) {
                this.runnables.addFirst(runnable);
            }
            int n2 = this.lagMillisMin + (int)(Math.random() * (double)(this.lagMillisMax - this.lagMillisMin));
            this.threadPool.schedule(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    Runnable runnable;
                    LinkedList<Runnable> linkedList = runnables;
                    synchronized (linkedList) {
                        runnable = runnables.removeLast();
                    }
                    runnable.run();
                }
            }, (long)n2, TimeUnit.MILLISECONDS);
        }
    }

    public static class ThreadedListener
    extends QueuedListener {
        protected final ExecutorService threadPool;

        public ThreadedListener(Listener listener) {
            this(listener, Executors.newFixedThreadPool(1));
        }

        public ThreadedListener(Listener listener, ExecutorService executorService) {
            super(listener);
            if (executorService == null) {
                throw new NullPointerException("threadPool cannot be null.");
            }
            this.threadPool = executorService;
        }

        @Override
        public void queue(Runnable runnable) {
            this.threadPool.execute(runnable);
        }
    }

    public static abstract class QueuedListener
    implements Listener {
        final Listener listener;

        public QueuedListener(Listener listener) {
            if (listener == null) {
                throw new NullPointerException("listener cannot be null.");
            }
            this.listener = listener;
        }

        @Override
        public void connected(final Connection connection) {
            this.queue(new Runnable(){

                @Override
                public void run() {
                    listener.connected(connection);
                }
            });
        }

        @Override
        public void disconnected(final Connection connection) {
            this.queue(new Runnable(){

                @Override
                public void run() {
                    listener.disconnected(connection);
                }
            });
        }

        @Override
        public void received(final Connection connection, final Object object) {
            this.queue(new Runnable(){

                @Override
                public void run() {
                    listener.received(connection, object);
                }
            });
        }

        @Override
        public void idle(final Connection connection) {
            this.queue(new Runnable(){

                @Override
                public void run() {
                    listener.idle(connection);
                }
            });
        }

        protected abstract void queue(Runnable var1);
    }

    public static class TypeListener
    implements Listener {
        private final HashMap<Class<?>, BiConsumer> listeners = new HashMap();

        @Override
        public void received(Connection connection, Object object) {
            if (this.listeners.containsKey(object.getClass())) {
                this.listeners.get(object.getClass()).accept(connection, object);
            }
        }

        public <T> void addTypeHandler(Class<T> clazz, BiConsumer<? super Connection, ? super T> biConsumer) {
            this.listeners.put(clazz, biConsumer);
        }

        public <T> void removeTypeHandler(Class<T> clazz) {
            this.listeners.remove(clazz);
        }

        public int size() {
            return this.listeners.size();
        }

        public void clear() {
            this.listeners.clear();
        }
    }

    public static abstract class ConnectionListener
    implements Listener {
        @Override
        public abstract void disconnected(Connection var1);

        @Override
        public abstract void connected(Connection var1);

        @Override
        public void received(Connection connection, Object object) {
        }

        @Override
        public void idle(Connection connection) {
        }
    }
}

