/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import java.util.Arrays;
import java.util.Comparator;

class TimSort<T> {
    private static final int MIN_MERGE = 32;
    private T[] a;
    private Comparator<? super T> c;
    private static final int MIN_GALLOP = 7;
    private int minGallop = 7;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private T[] tmp;
    private int tmpCount;
    private int stackSize = 0;
    private final int[] runBase;
    private final int[] runLen;
    private static final boolean DEBUG = false;

    TimSort() {
        this.tmp = new Object[256];
        this.runBase = new int[40];
        this.runLen = new int[40];
    }

    public void doSort(T[] TArray, Comparator<T> comparator, int n2, int n3) {
        int n4;
        int n5;
        this.stackSize = 0;
        TimSort.rangeCheck(TArray.length, n2, n3);
        int n6 = n3 - n2;
        if (n6 < 2) {
            return;
        }
        if (n6 < 32) {
            int n7 = TimSort.countRunAndMakeAscending(TArray, n2, n3, comparator);
            TimSort.binarySort(TArray, n2, n3, n2 + n7, comparator);
            return;
        }
        this.a = TArray;
        this.c = comparator;
        this.tmpCount = 0;
        int n8 = TimSort.minRunLength(n6);
        do {
            if ((n5 = TimSort.countRunAndMakeAscending(TArray, n2, n3, comparator)) < n8) {
                n4 = n6 <= n8 ? n6 : n8;
                TimSort.binarySort(TArray, n2, n2 + n4, n2 + n5, comparator);
                n5 = n4;
            }
            this.pushRun(n2, n5);
            this.mergeCollapse();
            n2 += n5;
        } while ((n6 -= n5) != 0);
        this.mergeForceCollapse();
        this.a = null;
        this.c = null;
        T[] TArray2 = this.tmp;
        int n9 = this.tmpCount;
        for (n4 = 0; n4 < n9; ++n4) {
            TArray2[n4] = null;
        }
    }

    private TimSort(T[] TArray, Comparator<? super T> comparator) {
        this.a = TArray;
        this.c = comparator;
        int n2 = TArray.length;
        Object[] objectArray = new Object[n2 < 512 ? n2 >>> 1 : 256];
        this.tmp = objectArray;
        int n3 = n2 < 120 ? 5 : (n2 < 1542 ? 10 : (n2 < 119151 ? 19 : 40));
        this.runBase = new int[n3];
        this.runLen = new int[n3];
    }

    static <T> void sort(T[] TArray, Comparator<? super T> comparator) {
        TimSort.sort(TArray, 0, TArray.length, comparator);
    }

    static <T> void sort(T[] TArray, int n2, int n3, Comparator<? super T> comparator) {
        int n4;
        if (comparator == null) {
            Arrays.sort(TArray, n2, n3);
            return;
        }
        TimSort.rangeCheck(TArray.length, n2, n3);
        int n5 = n3 - n2;
        if (n5 < 2) {
            return;
        }
        if (n5 < 32) {
            int n6 = TimSort.countRunAndMakeAscending(TArray, n2, n3, comparator);
            TimSort.binarySort(TArray, n2, n3, n2 + n6, comparator);
            return;
        }
        TimSort<? super T> timSort = new TimSort<T>(TArray, comparator);
        int n7 = TimSort.minRunLength(n5);
        do {
            if ((n4 = TimSort.countRunAndMakeAscending(TArray, n2, n3, comparator)) < n7) {
                int n8 = n5 <= n7 ? n5 : n7;
                TimSort.binarySort(TArray, n2, n2 + n8, n2 + n4, comparator);
                n4 = n8;
            }
            super.pushRun(n2, n4);
            super.mergeCollapse();
            n2 += n4;
        } while ((n5 -= n4) != 0);
        super.mergeForceCollapse();
    }

    private static <T> void binarySort(T[] TArray, int n2, int n3, int n4, Comparator<? super T> comparator) {
        if (n4 == n2) {
            ++n4;
        }
        while (n4 < n3) {
            int n5;
            T t2 = TArray[n4];
            int n6 = n2;
            int n7 = n4;
            while (n6 < n7) {
                n5 = n6 + n7 >>> 1;
                if (comparator.compare(t2, TArray[n5]) < 0) {
                    n7 = n5;
                    continue;
                }
                n6 = n5 + 1;
            }
            n5 = n4 - n6;
            switch (n5) {
                case 2: {
                    TArray[n6 + 2] = TArray[n6 + 1];
                }
                case 1: {
                    TArray[n6 + 1] = TArray[n6];
                    break;
                }
                default: {
                    System.arraycopy(TArray, n6, TArray, n6 + 1, n5);
                }
            }
            TArray[n6] = t2;
            ++n4;
        }
    }

    private static <T> int countRunAndMakeAscending(T[] TArray, int n2, int n3, Comparator<? super T> comparator) {
        int n4 = n2 + 1;
        if (n4 == n3) {
            return 1;
        }
        if (comparator.compare(TArray[n4++], TArray[n2]) < 0) {
            while (n4 < n3 && comparator.compare(TArray[n4], TArray[n4 - 1]) < 0) {
                ++n4;
            }
            TimSort.reverseRange(TArray, n2, n4);
        } else {
            while (n4 < n3 && comparator.compare(TArray[n4], TArray[n4 - 1]) >= 0) {
                ++n4;
            }
        }
        return n4 - n2;
    }

    private static void reverseRange(Object[] objectArray, int n2, int n3) {
        --n3;
        while (n2 < n3) {
            Object object = objectArray[n2];
            objectArray[n2++] = objectArray[n3];
            objectArray[n3--] = object;
        }
    }

    private static int minRunLength(int n2) {
        int n3 = 0;
        while (n2 >= 32) {
            n3 |= n2 & 1;
            n2 >>= 1;
        }
        return n2 + n3;
    }

    private void pushRun(int n2, int n3) {
        this.runBase[this.stackSize] = n2;
        this.runLen[this.stackSize] = n3;
        ++this.stackSize;
    }

    private void mergeCollapse() {
        while (this.stackSize > 1) {
            int n2 = this.stackSize - 2;
            if (n2 >= 1 && this.runLen[n2 - 1] <= this.runLen[n2] + this.runLen[n2 + 1] || n2 >= 2 && this.runLen[n2 - 2] <= this.runLen[n2] + this.runLen[n2 - 1]) {
                if (this.runLen[n2 - 1] < this.runLen[n2 + 1]) {
                    --n2;
                }
            } else if (this.runLen[n2] > this.runLen[n2 + 1]) break;
            this.mergeAt(n2);
        }
    }

    private void mergeForceCollapse() {
        while (this.stackSize > 1) {
            int n2 = this.stackSize - 2;
            if (n2 > 0 && this.runLen[n2 - 1] < this.runLen[n2 + 1]) {
                --n2;
            }
            this.mergeAt(n2);
        }
    }

    private void mergeAt(int n2) {
        int n3 = this.runBase[n2];
        int n4 = this.runLen[n2];
        int n5 = this.runBase[n2 + 1];
        int n6 = this.runLen[n2 + 1];
        this.runLen[n2] = n4 + n6;
        if (n2 == this.stackSize - 3) {
            this.runBase[n2 + 1] = this.runBase[n2 + 2];
            this.runLen[n2 + 1] = this.runLen[n2 + 2];
        }
        --this.stackSize;
        int n7 = TimSort.gallopRight(this.a[n5], this.a, n3, n4, 0, this.c);
        n3 += n7;
        if ((n4 -= n7) == 0) {
            return;
        }
        if ((n6 = TimSort.gallopLeft(this.a[n3 + n4 - 1], this.a, n5, n6, n6 - 1, this.c)) == 0) {
            return;
        }
        if (n4 <= n6) {
            this.mergeLo(n3, n4, n5, n6);
        } else {
            this.mergeHi(n3, n4, n5, n6);
        }
    }

    private static <T> int gallopLeft(T t2, T[] TArray, int n2, int n3, int n4, Comparator<? super T> comparator) {
        int n5;
        int n6 = 0;
        int n7 = 1;
        if (comparator.compare(t2, TArray[n2 + n4]) > 0) {
            n5 = n3 - n4;
            while (n7 < n5 && comparator.compare(t2, TArray[n2 + n4 + n7]) > 0) {
                n6 = n7;
                if ((n7 = (n7 << 1) + 1) > 0) continue;
                n7 = n5;
            }
            if (n7 > n5) {
                n7 = n5;
            }
            n6 += n4;
            n7 += n4;
        } else {
            n5 = n4 + 1;
            while (n7 < n5 && comparator.compare(t2, TArray[n2 + n4 - n7]) <= 0) {
                n6 = n7;
                if ((n7 = (n7 << 1) + 1) > 0) continue;
                n7 = n5;
            }
            if (n7 > n5) {
                n7 = n5;
            }
            int n8 = n6;
            n6 = n4 - n7;
            n7 = n4 - n8;
        }
        ++n6;
        while (n6 < n7) {
            n5 = n6 + (n7 - n6 >>> 1);
            if (comparator.compare(t2, TArray[n2 + n5]) > 0) {
                n6 = n5 + 1;
                continue;
            }
            n7 = n5;
        }
        return n7;
    }

    private static <T> int gallopRight(T t2, T[] TArray, int n2, int n3, int n4, Comparator<? super T> comparator) {
        int n5;
        int n6 = 1;
        int n7 = 0;
        if (comparator.compare(t2, TArray[n2 + n4]) < 0) {
            n5 = n4 + 1;
            while (n6 < n5 && comparator.compare(t2, TArray[n2 + n4 - n6]) < 0) {
                n7 = n6;
                if ((n6 = (n6 << 1) + 1) > 0) continue;
                n6 = n5;
            }
            if (n6 > n5) {
                n6 = n5;
            }
            int n8 = n7;
            n7 = n4 - n6;
            n6 = n4 - n8;
        } else {
            n5 = n3 - n4;
            while (n6 < n5 && comparator.compare(t2, TArray[n2 + n4 + n6]) >= 0) {
                n7 = n6;
                if ((n6 = (n6 << 1) + 1) > 0) continue;
                n6 = n5;
            }
            if (n6 > n5) {
                n6 = n5;
            }
            n7 += n4;
            n6 += n4;
        }
        ++n7;
        while (n7 < n6) {
            n5 = n7 + (n6 - n7 >>> 1);
            if (comparator.compare(t2, TArray[n2 + n5]) < 0) {
                n6 = n5;
                continue;
            }
            n7 = n5 + 1;
        }
        return n6;
    }

    private void mergeLo(int n2, int n3, int n4, int n5) {
        T[] TArray = this.a;
        T[] TArray2 = this.ensureCapacity(n3);
        System.arraycopy(TArray, n2, TArray2, 0, n3);
        int n6 = 0;
        int n7 = n4;
        int n8 = n2;
        TArray[n8++] = TArray[n7++];
        if (--n5 == 0) {
            System.arraycopy(TArray2, n6, TArray, n8, n3);
            return;
        }
        if (n3 == 1) {
            System.arraycopy(TArray, n7, TArray, n8, n5);
            TArray[n8 + n5] = TArray2[n6];
            return;
        }
        Comparator<T> comparator = this.c;
        int n9 = this.minGallop;
        block0: while (true) {
            int n10 = 0;
            int n11 = 0;
            do {
                if (comparator.compare(TArray[n7], TArray2[n6]) < 0) {
                    TArray[n8++] = TArray[n7++];
                    ++n11;
                    n10 = 0;
                    if (--n5 != 0) continue;
                    break block0;
                }
                TArray[n8++] = TArray2[n6++];
                ++n10;
                n11 = 0;
                if (--n3 == 1) break block0;
            } while ((n10 | n11) < n9);
            do {
                if ((n10 = TimSort.gallopRight(TArray[n7], TArray2, n6, n3, 0, comparator)) != 0) {
                    System.arraycopy(TArray2, n6, TArray, n8, n10);
                    n8 += n10;
                    n6 += n10;
                    if ((n3 -= n10) <= 1) break block0;
                }
                TArray[n8++] = TArray[n7++];
                if (--n5 == 0) break block0;
                n11 = TimSort.gallopLeft(TArray2[n6], TArray, n7, n5, 0, comparator);
                if (n11 != 0) {
                    System.arraycopy(TArray, n7, TArray, n8, n11);
                    n8 += n11;
                    n7 += n11;
                    if ((n5 -= n11) == 0) break block0;
                }
                TArray[n8++] = TArray2[n6++];
                if (--n3 == 1) break block0;
                --n9;
            } while (n10 >= 7 | n11 >= 7);
            if (n9 < 0) {
                n9 = 0;
            }
            n9 += 2;
        }
        int n12 = this.minGallop = n9 < 1 ? 1 : n9;
        if (n3 == 1) {
            System.arraycopy(TArray, n7, TArray, n8, n5);
            TArray[n8 + n5] = TArray2[n6];
        } else {
            if (n3 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            System.arraycopy(TArray2, n6, TArray, n8, n3);
        }
    }

    private void mergeHi(int n2, int n3, int n4, int n5) {
        T[] TArray = this.a;
        T[] TArray2 = this.ensureCapacity(n5);
        System.arraycopy(TArray, n4, TArray2, 0, n5);
        int n6 = n2 + n3 - 1;
        int n7 = n5 - 1;
        int n8 = n4 + n5 - 1;
        TArray[n8--] = TArray[n6--];
        if (--n3 == 0) {
            System.arraycopy(TArray2, 0, TArray, n8 - (n5 - 1), n5);
            return;
        }
        if (n5 == 1) {
            System.arraycopy(TArray, (n6 -= n3) + 1, TArray, (n8 -= n3) + 1, n3);
            TArray[n8] = TArray2[n7];
            return;
        }
        Comparator<T> comparator = this.c;
        int n9 = this.minGallop;
        block0: while (true) {
            int n10 = 0;
            int n11 = 0;
            do {
                if (comparator.compare(TArray2[n7], TArray[n6]) < 0) {
                    TArray[n8--] = TArray[n6--];
                    ++n10;
                    n11 = 0;
                    if (--n3 != 0) continue;
                    break block0;
                }
                TArray[n8--] = TArray2[n7--];
                ++n11;
                n10 = 0;
                if (--n5 == 1) break block0;
            } while ((n10 | n11) < n9);
            do {
                if ((n10 = n3 - TimSort.gallopRight(TArray2[n7], TArray, n2, n3, n3 - 1, comparator)) != 0) {
                    System.arraycopy(TArray, (n6 -= n10) + 1, TArray, (n8 -= n10) + 1, n10);
                    if ((n3 -= n10) == 0) break block0;
                }
                TArray[n8--] = TArray2[n7--];
                if (--n5 == 1) break block0;
                n11 = n5 - TimSort.gallopLeft(TArray[n6], TArray2, 0, n5, n5 - 1, comparator);
                if (n11 != 0) {
                    System.arraycopy(TArray2, (n7 -= n11) + 1, TArray, (n8 -= n11) + 1, n11);
                    if ((n5 -= n11) <= 1) break block0;
                }
                TArray[n8--] = TArray[n6--];
                if (--n3 == 0) break block0;
                --n9;
            } while (n10 >= 7 | n11 >= 7);
            if (n9 < 0) {
                n9 = 0;
            }
            n9 += 2;
        }
        int n12 = this.minGallop = n9 < 1 ? 1 : n9;
        if (n5 == 1) {
            System.arraycopy(TArray, (n6 -= n3) + 1, TArray, (n8 -= n3) + 1, n3);
            TArray[n8] = TArray2[n7];
        } else {
            if (n5 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            System.arraycopy(TArray2, 0, TArray, n8 - (n5 - 1), n5);
        }
    }

    private T[] ensureCapacity(int n2) {
        this.tmpCount = Math.max(this.tmpCount, n2);
        if (this.tmp.length < n2) {
            int n3 = n2;
            n3 |= n3 >> 1;
            n3 |= n3 >> 2;
            n3 |= n3 >> 4;
            n3 |= n3 >> 8;
            n3 |= n3 >> 16;
            n3 = ++n3 < 0 ? n2 : Math.min(n3, this.a.length >>> 1);
            Object[] objectArray = new Object[n3];
            this.tmp = objectArray;
        }
        return this.tmp;
    }

    private static void rangeCheck(int n2, int n3, int n4) {
        if (n3 > n4) {
            throw new IllegalArgumentException("fromIndex(" + n3 + ") > toIndex(" + n4 + ")");
        }
        if (n3 < 0) {
            throw new ArrayIndexOutOfBoundsException(n3);
        }
        if (n4 > n2) {
            throw new ArrayIndexOutOfBoundsException(n4);
        }
    }
}

