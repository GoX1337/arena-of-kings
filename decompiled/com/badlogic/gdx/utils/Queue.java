/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Collections;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T>
implements Iterable<T> {
    protected T[] values;
    protected int head = 0;
    protected int tail = 0;
    public int size = 0;
    private transient QueueIterable iterable;

    public Queue() {
        this(16);
    }

    public Queue(int n2) {
        this.values = new Object[n2];
    }

    public Queue(int n2, Class<T> clazz) {
        this.values = (Object[])ArrayReflection.newInstance(clazz, n2);
    }

    public void addLast(@Null T t2) {
        T[] TArray = this.values;
        if (this.size == TArray.length) {
            this.resize(TArray.length << 1);
            TArray = this.values;
        }
        TArray[this.tail++] = t2;
        if (this.tail == TArray.length) {
            this.tail = 0;
        }
        ++this.size;
    }

    public void addFirst(@Null T t2) {
        T[] TArray = this.values;
        if (this.size == TArray.length) {
            this.resize(TArray.length << 1);
            TArray = this.values;
        }
        int n2 = this.head;
        if (--n2 == -1) {
            n2 = TArray.length - 1;
        }
        TArray[n2] = t2;
        this.head = n2;
        ++this.size;
    }

    public void ensureCapacity(int n2) {
        int n3 = this.size + n2;
        if (this.values.length < n3) {
            this.resize(n3);
        }
    }

    protected void resize(int n2) {
        T[] TArray = this.values;
        int n3 = this.head;
        int n4 = this.tail;
        Object[] objectArray = (Object[])ArrayReflection.newInstance(TArray.getClass().getComponentType(), n2);
        if (n3 < n4) {
            System.arraycopy(TArray, n3, objectArray, 0, n4 - n3);
        } else if (this.size > 0) {
            int n5 = TArray.length - n3;
            System.arraycopy(TArray, n3, objectArray, 0, n5);
            System.arraycopy(TArray, 0, objectArray, n5, n4);
        }
        this.values = objectArray;
        this.head = 0;
        this.tail = this.size;
    }

    public T removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T[] TArray = this.values;
        T t2 = TArray[this.head];
        TArray[this.head] = null;
        ++this.head;
        if (this.head == TArray.length) {
            this.head = 0;
        }
        --this.size;
        return t2;
    }

    public T removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T[] TArray = this.values;
        int n2 = this.tail;
        if (--n2 == -1) {
            n2 = TArray.length - 1;
        }
        T t2 = TArray[n2];
        TArray[n2] = null;
        this.tail = n2;
        --this.size;
        return t2;
    }

    public int indexOf(T t2, boolean bl2) {
        if (this.size == 0) {
            return -1;
        }
        T[] TArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        if (bl2 || t2 == null) {
            if (n2 < n3) {
                for (int i2 = n2; i2 < n3; ++i2) {
                    if (TArray[i2] != t2) continue;
                    return i2 - n2;
                }
            } else {
                int n4;
                int n5 = TArray.length;
                for (n4 = n2; n4 < n5; ++n4) {
                    if (TArray[n4] != t2) continue;
                    return n4 - n2;
                }
                for (n4 = 0; n4 < n3; ++n4) {
                    if (TArray[n4] != t2) continue;
                    return n4 + TArray.length - n2;
                }
            }
        } else if (n2 < n3) {
            for (int i3 = n2; i3 < n3; ++i3) {
                if (!t2.equals(TArray[i3])) continue;
                return i3 - n2;
            }
        } else {
            int n6;
            int n7 = TArray.length;
            for (n6 = n2; n6 < n7; ++n6) {
                if (!t2.equals(TArray[n6])) continue;
                return n6 - n2;
            }
            for (n6 = 0; n6 < n3; ++n6) {
                if (!t2.equals(TArray[n6])) continue;
                return n6 + TArray.length - n2;
            }
        }
        return -1;
    }

    public boolean removeValue(T t2, boolean bl2) {
        int n2 = this.indexOf(t2, bl2);
        if (n2 == -1) {
            return false;
        }
        this.removeIndex(n2);
        return true;
    }

    public T removeIndex(int n2) {
        T t2;
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + n2);
        }
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        T[] TArray = this.values;
        int n3 = this.head++;
        int n4 = this.tail--;
        n2 += n3;
        if (n3 < n4) {
            t2 = TArray[n2];
            System.arraycopy(TArray, n2 + 1, TArray, n2, n4 - n2);
            TArray[n4] = null;
        } else if (n2 >= TArray.length) {
            t2 = TArray[n2 -= TArray.length];
            System.arraycopy(TArray, n2 + 1, TArray, n2, n4 - n2);
            --this.tail;
        } else {
            t2 = TArray[n2];
            System.arraycopy(TArray, n3, TArray, n3 + 1, n2 - n3);
            TArray[n3] = null;
            if (this.head == TArray.length) {
                this.head = 0;
            }
        }
        --this.size;
        return t2;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T first() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.values[this.head];
    }

    public T last() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T[] TArray = this.values;
        int n2 = this.tail;
        if (--n2 == -1) {
            n2 = TArray.length - 1;
        }
        return TArray[n2];
    }

    public T get(int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + n2);
        }
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = this.head + n2;
        T[] TArray = this.values;
        if (n3 >= TArray.length) {
            n3 -= TArray.length;
        }
        return TArray[n3];
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        T[] TArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        if (n2 < n3) {
            for (int i2 = n2; i2 < n3; ++i2) {
                TArray[i2] = null;
            }
        } else {
            int n4;
            for (n4 = n2; n4 < TArray.length; ++n4) {
                TArray[n4] = null;
            }
            for (n4 = 0; n4 < n3; ++n4) {
                TArray[n4] = null;
            }
        }
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        if (Collections.allocateIterators) {
            return new QueueIterator(this, true);
        }
        if (this.iterable == null) {
            this.iterable = new QueueIterable(this);
        }
        return this.iterable.iterator();
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        T[] TArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append('[');
        stringBuilder.append(TArray[n2]);
        int n4 = (n2 + 1) % TArray.length;
        while (n4 != n3) {
            stringBuilder.append(", ").append(TArray[n4]);
            n4 = (n4 + 1) % TArray.length;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        T[] TArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(TArray[n2]);
        int n4 = (n2 + 1) % TArray.length;
        while (n4 != n3) {
            stringBuilder.append(string).append(TArray[n4]);
            n4 = (n4 + 1) % TArray.length;
        }
        return stringBuilder.toString();
    }

    public int hashCode() {
        int n2 = this.size;
        T[] TArray = this.values;
        int n3 = TArray.length;
        int n4 = this.head;
        int n5 = n2 + 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = TArray[n4];
            n5 *= 31;
            if (t2 != null) {
                n5 += t2.hashCode();
            }
            if (++n4 != n3) continue;
            n4 = 0;
        }
        return n5;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof Queue)) {
            return false;
        }
        Queue queue = (Queue)object;
        int n2 = this.size;
        if (queue.size != n2) {
            return false;
        }
        T[] TArray = this.values;
        int n3 = TArray.length;
        T[] TArray2 = queue.values;
        int n4 = TArray2.length;
        int n5 = this.head;
        int n6 = queue.head;
        for (int i2 = 0; i2 < n2; ++i2) {
            T t2 = TArray[n5];
            T t3 = TArray2[n6];
            if (!(t2 != null ? t2.equals(t3) : t3 == null)) {
                return false;
            }
            ++n6;
            if (++n5 == n3) {
                n5 = 0;
            }
            if (n6 != n4) continue;
            n6 = 0;
        }
        return true;
    }

    public boolean equalsIdentity(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof Queue)) {
            return false;
        }
        Queue queue = (Queue)object;
        int n2 = this.size;
        if (queue.size != n2) {
            return false;
        }
        T[] TArray = this.values;
        int n3 = TArray.length;
        T[] TArray2 = queue.values;
        int n4 = TArray2.length;
        int n5 = this.head;
        int n6 = queue.head;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (TArray[n5] != TArray2[n6]) {
                return false;
            }
            ++n6;
            if (++n5 == n3) {
                n5 = 0;
            }
            if (n6 != n4) continue;
            n6 = 0;
        }
        return true;
    }

    public static class QueueIterable<T>
    implements Iterable<T> {
        private final Queue<T> queue;
        private final boolean allowRemove;
        private QueueIterator iterator1;
        private QueueIterator iterator2;

        public QueueIterable(Queue<T> queue) {
            this(queue, true);
        }

        public QueueIterable(Queue<T> queue, boolean bl2) {
            this.queue = queue;
            this.allowRemove = bl2;
        }

        @Override
        public Iterator<T> iterator() {
            if (Collections.allocateIterators) {
                return new QueueIterator<T>(this.queue, this.allowRemove);
            }
            if (this.iterator1 == null) {
                this.iterator1 = new QueueIterator<T>(this.queue, this.allowRemove);
                this.iterator2 = new QueueIterator<T>(this.queue, this.allowRemove);
            }
            if (!this.iterator1.valid) {
                this.iterator1.index = 0;
                this.iterator1.valid = true;
                this.iterator2.valid = false;
                return this.iterator1;
            }
            this.iterator2.index = 0;
            this.iterator2.valid = true;
            this.iterator1.valid = false;
            return this.iterator2;
        }
    }

    public static class QueueIterator<T>
    implements Iterable<T>,
    Iterator<T> {
        private final Queue<T> queue;
        private final boolean allowRemove;
        int index;
        boolean valid = true;

        public QueueIterator(Queue<T> queue) {
            this(queue, true);
        }

        public QueueIterator(Queue<T> queue, boolean bl2) {
            this.queue = queue;
            this.allowRemove = bl2;
        }

        @Override
        public boolean hasNext() {
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.index < this.queue.size;
        }

        @Override
        public T next() {
            if (this.index >= this.queue.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            if (!this.valid) {
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return this.queue.get(this.index++);
        }

        @Override
        public void remove() {
            if (!this.allowRemove) {
                throw new GdxRuntimeException("Remove not allowed.");
            }
            --this.index;
            this.queue.removeIndex(this.index);
        }

        public void reset() {
            this.index = 0;
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }
    }
}

