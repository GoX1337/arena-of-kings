/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.util.NoSuchElementException;

public class LongQueue {
    protected long[] values;
    protected int head = 0;
    protected int tail = 0;
    public int size = 0;

    public LongQueue() {
        this(16);
    }

    public LongQueue(int n2) {
        this.values = new long[n2];
    }

    public void addLast(long l2) {
        long[] lArray = this.values;
        if (this.size == lArray.length) {
            this.resize(lArray.length << 1);
            lArray = this.values;
        }
        lArray[this.tail++] = l2;
        if (this.tail == lArray.length) {
            this.tail = 0;
        }
        ++this.size;
    }

    public void addFirst(long l2) {
        long[] lArray = this.values;
        if (this.size == lArray.length) {
            this.resize(lArray.length << 1);
            lArray = this.values;
        }
        int n2 = this.head;
        if (--n2 == -1) {
            n2 = lArray.length - 1;
        }
        lArray[n2] = l2;
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
        long[] lArray = this.values;
        int n3 = this.head;
        int n4 = this.tail;
        long[] lArray2 = new long[n2];
        if (n3 < n4) {
            System.arraycopy(lArray, n3, lArray2, 0, n4 - n3);
        } else if (this.size > 0) {
            int n5 = lArray.length - n3;
            System.arraycopy(lArray, n3, lArray2, 0, n5);
            System.arraycopy(lArray, 0, lArray2, n5, n4);
        }
        this.values = lArray2;
        this.head = 0;
        this.tail = this.size;
    }

    public long removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] lArray = this.values;
        long l2 = lArray[this.head];
        ++this.head;
        if (this.head == lArray.length) {
            this.head = 0;
        }
        --this.size;
        return l2;
    }

    public long removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] lArray = this.values;
        int n2 = this.tail;
        if (--n2 == -1) {
            n2 = lArray.length - 1;
        }
        long l2 = lArray[n2];
        this.tail = n2;
        --this.size;
        return l2;
    }

    public int indexOf(long l2) {
        if (this.size == 0) {
            return -1;
        }
        long[] lArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        if (n2 < n3) {
            for (int i2 = n2; i2 < n3; ++i2) {
                if (lArray[i2] != l2) continue;
                return i2 - n2;
            }
        } else {
            int n4;
            int n5 = lArray.length;
            for (n4 = n2; n4 < n5; ++n4) {
                if (lArray[n4] != l2) continue;
                return n4 - n2;
            }
            for (n4 = 0; n4 < n3; ++n4) {
                if (lArray[n4] != l2) continue;
                return n4 + lArray.length - n2;
            }
        }
        return -1;
    }

    public boolean removeValue(long l2) {
        int n2 = this.indexOf(l2);
        if (n2 == -1) {
            return false;
        }
        this.removeIndex(n2);
        return true;
    }

    public long removeIndex(int n2) {
        long l2;
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + n2);
        }
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        long[] lArray = this.values;
        int n3 = this.head++;
        int n4 = this.tail--;
        n2 += n3;
        if (n3 < n4) {
            l2 = lArray[n2];
            System.arraycopy(lArray, n2 + 1, lArray, n2, n4 - n2);
        } else if (n2 >= lArray.length) {
            l2 = lArray[n2 -= lArray.length];
            System.arraycopy(lArray, n2 + 1, lArray, n2, n4 - n2);
            --this.tail;
        } else {
            l2 = lArray[n2];
            System.arraycopy(lArray, n3, lArray, n3 + 1, n2 - n3);
            if (this.head == lArray.length) {
                this.head = 0;
            }
        }
        --this.size;
        return l2;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public long first() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return this.values[this.head];
    }

    public long last() {
        if (this.size == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        long[] lArray = this.values;
        int n2 = this.tail;
        if (--n2 == -1) {
            n2 = lArray.length - 1;
        }
        return lArray[n2];
    }

    public long get(int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("index can't be < 0: " + n2);
        }
        if (n2 >= this.size) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + n2 + " >= " + this.size);
        }
        int n3 = this.head + n2;
        long[] lArray = this.values;
        if (n3 >= lArray.length) {
            n3 -= lArray.length;
        }
        return lArray[n3];
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        long[] lArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append('[');
        stringBuilder.append(lArray[n2]);
        int n4 = (n2 + 1) % lArray.length;
        while (n4 != n3) {
            stringBuilder.append(", ").append(lArray[n4]);
            n4 = (n4 + 1) % lArray.length;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public String toString(String string) {
        if (this.size == 0) {
            return "";
        }
        long[] lArray = this.values;
        int n2 = this.head;
        int n3 = this.tail;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(lArray[n2]);
        int n4 = (n2 + 1) % lArray.length;
        while (n4 != n3) {
            stringBuilder.append(string).append(lArray[n4]);
            n4 = (n4 + 1) % lArray.length;
        }
        return stringBuilder.toString();
    }

    public int hashCode() {
        int n2 = this.size;
        long[] lArray = this.values;
        int n3 = lArray.length;
        int n4 = this.head;
        int n5 = n2 + 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            long l2 = lArray[n4];
            n5 += (int)(l2 ^ l2 >>> 32) * 31;
            if (++n4 != n3) continue;
            n4 = 0;
        }
        return n5;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof LongQueue)) {
            return false;
        }
        LongQueue longQueue = (LongQueue)object;
        int n2 = this.size;
        if (longQueue.size != n2) {
            return false;
        }
        long[] lArray = this.values;
        int n3 = lArray.length;
        long[] lArray2 = longQueue.values;
        int n4 = lArray2.length;
        int n5 = this.head;
        int n6 = longQueue.head;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (lArray[n5] != lArray2[n6]) {
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
}

