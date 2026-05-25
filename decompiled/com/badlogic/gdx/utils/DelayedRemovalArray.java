/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import java.util.Comparator;

public class DelayedRemovalArray<T>
extends Array<T> {
    private int iterating;
    private IntArray remove = new IntArray(0);
    private int clear;

    public DelayedRemovalArray() {
    }

    public DelayedRemovalArray(Array array) {
        super(array);
    }

    public DelayedRemovalArray(boolean bl2, int n2, Class clazz) {
        super(bl2, n2, clazz);
    }

    public DelayedRemovalArray(boolean bl2, int n2) {
        super(bl2, n2);
    }

    public DelayedRemovalArray(boolean bl2, T[] TArray, int n2, int n3) {
        super(bl2, TArray, n2, n3);
    }

    public DelayedRemovalArray(Class clazz) {
        super(clazz);
    }

    public DelayedRemovalArray(int n2) {
        super(n2);
    }

    public DelayedRemovalArray(T[] TArray) {
        super(TArray);
    }

    public void begin() {
        ++this.iterating;
    }

    public void end() {
        if (this.iterating == 0) {
            throw new IllegalStateException("begin must be called before end.");
        }
        --this.iterating;
        if (this.iterating == 0) {
            if (this.clear > 0 && this.clear == this.size) {
                this.remove.clear();
                this.clear();
            } else {
                int n2;
                int n3 = this.remove.size;
                for (n2 = 0; n2 < n3; ++n2) {
                    int n4 = this.remove.pop();
                    if (n4 < this.clear) continue;
                    this.removeIndex(n4);
                }
                for (n2 = this.clear - 1; n2 >= 0; --n2) {
                    this.removeIndex(n2);
                }
            }
            this.clear = 0;
        }
    }

    private void remove(int n2) {
        if (n2 < this.clear) {
            return;
        }
        int n3 = this.remove.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.remove.get(i2);
            if (n2 == n4) {
                return;
            }
            if (n2 >= n4) continue;
            this.remove.insert(i2, n2);
            return;
        }
        this.remove.add(n2);
    }

    @Override
    public boolean removeValue(T t2, boolean bl2) {
        if (this.iterating > 0) {
            int n2 = this.indexOf(t2, bl2);
            if (n2 == -1) {
                return false;
            }
            this.remove(n2);
            return true;
        }
        return super.removeValue(t2, bl2);
    }

    @Override
    public T removeIndex(int n2) {
        if (this.iterating > 0) {
            this.remove(n2);
            return this.get(n2);
        }
        return super.removeIndex(n2);
    }

    @Override
    public void removeRange(int n2, int n3) {
        if (this.iterating > 0) {
            for (int i2 = n3; i2 >= n2; --i2) {
                this.remove(i2);
            }
        } else {
            super.removeRange(n2, n3);
        }
    }

    @Override
    public void clear() {
        if (this.iterating > 0) {
            this.clear = this.size;
            return;
        }
        super.clear();
    }

    @Override
    public void set(int n2, T t2) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.set(n2, t2);
    }

    @Override
    public void insert(int n2, T t2) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.insert(n2, t2);
    }

    @Override
    public void insertRange(int n2, int n3) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.insertRange(n2, n3);
    }

    @Override
    public void swap(int n2, int n3) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.swap(n2, n3);
    }

    @Override
    public T pop() {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        return super.pop();
    }

    @Override
    public void sort() {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.sort();
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.sort(comparator);
    }

    @Override
    public void reverse() {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.reverse();
    }

    @Override
    public void shuffle() {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.shuffle();
    }

    @Override
    public void truncate(int n2) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        super.truncate(n2);
    }

    @Override
    public T[] setSize(int n2) {
        if (this.iterating > 0) {
            throw new IllegalStateException("Invalid between begin/end.");
        }
        return super.setSize(n2);
    }

    public static <T> DelayedRemovalArray<T> with(T ... TArray) {
        return new DelayedRemovalArray<T>(TArray);
    }
}

