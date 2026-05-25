/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import java.lang.ref.SoftReference;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Pool<T> {
    private final Queue<T> freeObjects;
    private int peak;

    public Pool(boolean bl2, boolean bl3) {
        this(bl2, bl3, Integer.MAX_VALUE);
    }

    public Pool(boolean bl2, boolean bl3, final int n2) {
        AbstractCollection abstractCollection = bl2 ? new LinkedBlockingQueue<T>(n2){

            @Override
            public boolean add(T t2) {
                return super.offer(t2);
            }
        } : (bl3 ? new LinkedList<T>(){

            @Override
            public boolean add(T t2) {
                if (this.size() >= n2) {
                    return false;
                }
                super.add(t2);
                return true;
            }
        } : new ArrayDeque<T>(){

            @Override
            public boolean offer(T t2) {
                if (this.size() >= n2) {
                    return false;
                }
                super.offer(t2);
                return true;
            }
        });
        this.freeObjects = bl3 ? new SoftReferenceQueue(abstractCollection) : abstractCollection;
    }

    protected abstract T create();

    public T obtain() {
        T t2 = this.freeObjects.poll();
        return t2 != null ? t2 : this.create();
    }

    public void free(T t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        this.reset(t2);
        if (!this.freeObjects.offer(t2) && this.freeObjects instanceof SoftReferenceQueue) {
            ((SoftReferenceQueue)this.freeObjects).cleanOne();
            this.freeObjects.offer(t2);
        }
        this.peak = Math.max(this.peak, this.freeObjects.size());
    }

    protected void reset(T t2) {
        if (t2 instanceof Poolable) {
            ((Poolable)t2).reset();
        }
    }

    public void clear() {
        this.freeObjects.clear();
    }

    public void clean() {
        if (this.freeObjects instanceof SoftReferenceQueue) {
            ((SoftReferenceQueue)this.freeObjects).clean();
        }
    }

    public int getFree() {
        return this.freeObjects.size();
    }

    public int getPeak() {
        return this.peak;
    }

    public void resetPeak() {
        this.peak = 0;
    }

    static class SoftReferenceQueue<T>
    implements Queue<T> {
        private final Queue<SoftReference<T>> delegate;

        public SoftReferenceQueue(Queue<SoftReference<T>> queue) {
            this.delegate = queue;
        }

        @Override
        public T poll() {
            SoftReference<T> softReference;
            T t2;
            do {
                if ((softReference = this.delegate.poll()) != null) continue;
                return null;
            } while ((t2 = softReference.get()) == null);
            return t2;
        }

        @Override
        public boolean offer(T t2) {
            return this.delegate.add(new SoftReference<T>(t2));
        }

        @Override
        public int size() {
            return this.delegate.size();
        }

        @Override
        public void clear() {
            this.delegate.clear();
        }

        void cleanOne() {
            Iterator iterator = this.delegate.iterator();
            while (iterator.hasNext()) {
                if (((SoftReference)iterator.next()).get() != null) continue;
                iterator.remove();
                break;
            }
        }

        void clean() {
            this.delegate.removeIf(softReference -> softReference.get() == null);
        }

        @Override
        public boolean add(T t2) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object object) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public T remove() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return null;
        }

        @Override
        public T element() {
            return null;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public <E> E[] toArray(E[] EArray) {
            return null;
        }

        @Override
        public boolean remove(Object object) {
            return false;
        }

        @Override
        public boolean containsAll(Collection collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection collection) {
            return false;
        }
    }

    public static interface Poolable {
        public void reset();
    }
}

