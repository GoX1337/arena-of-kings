/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

class ComparableTimSort {
    private static final int MIN_MERGE = 32;
    private Object[] a;
    private static final int MIN_GALLOP = 7;
    private int minGallop = 7;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private Object[] tmp;
    private int tmpCount;
    private int stackSize = 0;
    private final int[] runBase;
    private final int[] runLen;
    private static final boolean DEBUG = false;

    ComparableTimSort() {
        this.tmp = new Object[256];
        this.runBase = new int[40];
        this.runLen = new int[40];
    }

    public void doSort(Object[] objectArray, int n2, int n3) {
        int n4;
        int n5;
        this.stackSize = 0;
        ComparableTimSort.rangeCheck(objectArray.length, n2, n3);
        int n6 = n3 - n2;
        if (n6 < 2) {
            return;
        }
        if (n6 < 32) {
            int n7 = ComparableTimSort.countRunAndMakeAscending(objectArray, n2, n3);
            ComparableTimSort.binarySort(objectArray, n2, n3, n2 + n7);
            return;
        }
        this.a = objectArray;
        this.tmpCount = 0;
        int n8 = ComparableTimSort.minRunLength(n6);
        do {
            if ((n5 = ComparableTimSort.countRunAndMakeAscending(objectArray, n2, n3)) < n8) {
                n4 = n6 <= n8 ? n6 : n8;
                ComparableTimSort.binarySort(objectArray, n2, n2 + n4, n2 + n5);
                n5 = n4;
            }
            this.pushRun(n2, n5);
            this.mergeCollapse();
            n2 += n5;
        } while ((n6 -= n5) != 0);
        this.mergeForceCollapse();
        this.a = null;
        Object[] objectArray2 = this.tmp;
        int n9 = this.tmpCount;
        for (n4 = 0; n4 < n9; ++n4) {
            objectArray2[n4] = null;
        }
    }

    private ComparableTimSort(Object[] objectArray) {
        this.a = objectArray;
        int n2 = objectArray.length;
        Object[] objectArray2 = new Object[n2 < 512 ? n2 >>> 1 : 256];
        this.tmp = objectArray2;
        int n3 = n2 < 120 ? 5 : (n2 < 1542 ? 10 : (n2 < 119151 ? 19 : 40));
        this.runBase = new int[n3];
        this.runLen = new int[n3];
    }

    static void sort(Object[] objectArray) {
        ComparableTimSort.sort(objectArray, 0, objectArray.length);
    }

    static void sort(Object[] objectArray, int n2, int n3) {
        int n4;
        ComparableTimSort.rangeCheck(objectArray.length, n2, n3);
        int n5 = n3 - n2;
        if (n5 < 2) {
            return;
        }
        if (n5 < 32) {
            int n6 = ComparableTimSort.countRunAndMakeAscending(objectArray, n2, n3);
            ComparableTimSort.binarySort(objectArray, n2, n3, n2 + n6);
            return;
        }
        ComparableTimSort comparableTimSort = new ComparableTimSort(objectArray);
        int n7 = ComparableTimSort.minRunLength(n5);
        do {
            if ((n4 = ComparableTimSort.countRunAndMakeAscending(objectArray, n2, n3)) < n7) {
                int n8 = n5 <= n7 ? n5 : n7;
                ComparableTimSort.binarySort(objectArray, n2, n2 + n8, n2 + n4);
                n4 = n8;
            }
            comparableTimSort.pushRun(n2, n4);
            comparableTimSort.mergeCollapse();
            n2 += n4;
        } while ((n5 -= n4) != 0);
        comparableTimSort.mergeForceCollapse();
    }

    private static void binarySort(Object[] objectArray, int n2, int n3, int n4) {
        if (n4 == n2) {
            ++n4;
        }
        while (n4 < n3) {
            int n5;
            Comparable comparable = (Comparable)objectArray[n4];
            int n6 = n2;
            int n7 = n4;
            while (n6 < n7) {
                n5 = n6 + n7 >>> 1;
                if (comparable.compareTo(objectArray[n5]) < 0) {
                    n7 = n5;
                    continue;
                }
                n6 = n5 + 1;
            }
            n5 = n4 - n6;
            switch (n5) {
                case 2: {
                    objectArray[n6 + 2] = objectArray[n6 + 1];
                }
                case 1: {
                    objectArray[n6 + 1] = objectArray[n6];
                    break;
                }
                default: {
                    System.arraycopy(objectArray, n6, objectArray, n6 + 1, n5);
                }
            }
            objectArray[n6] = comparable;
            ++n4;
        }
    }

    private static int countRunAndMakeAscending(Object[] objectArray, int n2, int n3) {
        int n4 = n2 + 1;
        if (n4 == n3) {
            return 1;
        }
        if (((Comparable)objectArray[n4++]).compareTo(objectArray[n2]) < 0) {
            while (n4 < n3 && ((Comparable)objectArray[n4]).compareTo(objectArray[n4 - 1]) < 0) {
                ++n4;
            }
            ComparableTimSort.reverseRange(objectArray, n2, n4);
        } else {
            while (n4 < n3 && ((Comparable)objectArray[n4]).compareTo(objectArray[n4 - 1]) >= 0) {
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
            if (n2 > 0 && this.runLen[n2 - 1] <= this.runLen[n2] + this.runLen[n2 + 1]) {
                if (this.runLen[n2 - 1] < this.runLen[n2 + 1]) {
                    --n2;
                }
                this.mergeAt(n2);
                continue;
            }
            if (this.runLen[n2] > this.runLen[n2 + 1]) break;
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
        int n7 = ComparableTimSort.gallopRight((Comparable)this.a[n5], this.a, n3, n4, 0);
        n3 += n7;
        if ((n4 -= n7) == 0) {
            return;
        }
        if ((n6 = ComparableTimSort.gallopLeft((Comparable)this.a[n3 + n4 - 1], this.a, n5, n6, n6 - 1)) == 0) {
            return;
        }
        if (n4 <= n6) {
            this.mergeLo(n3, n4, n5, n6);
        } else {
            this.mergeHi(n3, n4, n5, n6);
        }
    }

    private static int gallopLeft(Comparable<Object> comparable, Object[] objectArray, int n2, int n3, int n4) {
        int n5;
        int n6 = 0;
        int n7 = 1;
        if (comparable.compareTo(objectArray[n2 + n4]) > 0) {
            n5 = n3 - n4;
            while (n7 < n5 && comparable.compareTo(objectArray[n2 + n4 + n7]) > 0) {
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
            while (n7 < n5 && comparable.compareTo(objectArray[n2 + n4 - n7]) <= 0) {
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
            if (comparable.compareTo(objectArray[n2 + n5]) > 0) {
                n6 = n5 + 1;
                continue;
            }
            n7 = n5;
        }
        return n7;
    }

    private static int gallopRight(Comparable<Object> comparable, Object[] objectArray, int n2, int n3, int n4) {
        int n5;
        int n6 = 1;
        int n7 = 0;
        if (comparable.compareTo(objectArray[n2 + n4]) < 0) {
            n5 = n4 + 1;
            while (n6 < n5 && comparable.compareTo(objectArray[n2 + n4 - n6]) < 0) {
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
            while (n6 < n5 && comparable.compareTo(objectArray[n2 + n4 + n6]) >= 0) {
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
            if (comparable.compareTo(objectArray[n2 + n5]) < 0) {
                n6 = n5;
                continue;
            }
            n7 = n5 + 1;
        }
        return n6;
    }

    private void mergeLo(int n2, int n3, int n4, int n5) {
        Object[] objectArray = this.a;
        Object[] objectArray2 = this.ensureCapacity(n3);
        System.arraycopy(objectArray, n2, objectArray2, 0, n3);
        int n6 = 0;
        int n7 = n4;
        int n8 = n2;
        objectArray[n8++] = objectArray[n7++];
        if (--n5 == 0) {
            System.arraycopy(objectArray2, n6, objectArray, n8, n3);
            return;
        }
        if (n3 == 1) {
            System.arraycopy(objectArray, n7, objectArray, n8, n5);
            objectArray[n8 + n5] = objectArray2[n6];
            return;
        }
        int n9 = this.minGallop;
        block0: while (true) {
            int n10 = 0;
            int n11 = 0;
            do {
                if (((Comparable)objectArray[n7]).compareTo(objectArray2[n6]) < 0) {
                    objectArray[n8++] = objectArray[n7++];
                    ++n11;
                    n10 = 0;
                    if (--n5 != 0) continue;
                    break block0;
                }
                objectArray[n8++] = objectArray2[n6++];
                ++n10;
                n11 = 0;
                if (--n3 == 1) break block0;
            } while ((n10 | n11) < n9);
            do {
                if ((n10 = ComparableTimSort.gallopRight((Comparable)objectArray[n7], objectArray2, n6, n3, 0)) != 0) {
                    System.arraycopy(objectArray2, n6, objectArray, n8, n10);
                    n8 += n10;
                    n6 += n10;
                    if ((n3 -= n10) <= 1) break block0;
                }
                objectArray[n8++] = objectArray[n7++];
                if (--n5 == 0) break block0;
                n11 = ComparableTimSort.gallopLeft((Comparable)objectArray2[n6], objectArray, n7, n5, 0);
                if (n11 != 0) {
                    System.arraycopy(objectArray, n7, objectArray, n8, n11);
                    n8 += n11;
                    n7 += n11;
                    if ((n5 -= n11) == 0) break block0;
                }
                objectArray[n8++] = objectArray2[n6++];
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
            System.arraycopy(objectArray, n7, objectArray, n8, n5);
            objectArray[n8 + n5] = objectArray2[n6];
        } else {
            if (n3 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            System.arraycopy(objectArray2, n6, objectArray, n8, n3);
        }
    }

    private void mergeHi(int n2, int n3, int n4, int n5) {
        Object[] objectArray = this.a;
        Object[] objectArray2 = this.ensureCapacity(n5);
        System.arraycopy(objectArray, n4, objectArray2, 0, n5);
        int n6 = n2 + n3 - 1;
        int n7 = n5 - 1;
        int n8 = n4 + n5 - 1;
        objectArray[n8--] = objectArray[n6--];
        if (--n3 == 0) {
            System.arraycopy(objectArray2, 0, objectArray, n8 - (n5 - 1), n5);
            return;
        }
        if (n5 == 1) {
            System.arraycopy(objectArray, (n6 -= n3) + 1, objectArray, (n8 -= n3) + 1, n3);
            objectArray[n8] = objectArray2[n7];
            return;
        }
        int n9 = this.minGallop;
        block0: while (true) {
            int n10 = 0;
            int n11 = 0;
            do {
                if (((Comparable)objectArray2[n7]).compareTo(objectArray[n6]) < 0) {
                    objectArray[n8--] = objectArray[n6--];
                    ++n10;
                    n11 = 0;
                    if (--n3 != 0) continue;
                    break block0;
                }
                objectArray[n8--] = objectArray2[n7--];
                ++n11;
                n10 = 0;
                if (--n5 == 1) break block0;
            } while ((n10 | n11) < n9);
            do {
                if ((n10 = n3 - ComparableTimSort.gallopRight((Comparable)objectArray2[n7], objectArray, n2, n3, n3 - 1)) != 0) {
                    System.arraycopy(objectArray, (n6 -= n10) + 1, objectArray, (n8 -= n10) + 1, n10);
                    if ((n3 -= n10) == 0) break block0;
                }
                objectArray[n8--] = objectArray2[n7--];
                if (--n5 == 1) break block0;
                n11 = n5 - ComparableTimSort.gallopLeft((Comparable)objectArray[n6], objectArray2, 0, n5, n5 - 1);
                if (n11 != 0) {
                    System.arraycopy(objectArray2, (n7 -= n11) + 1, objectArray, (n8 -= n11) + 1, n11);
                    if ((n5 -= n11) <= 1) break block0;
                }
                objectArray[n8--] = objectArray[n6--];
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
            System.arraycopy(objectArray, (n6 -= n3) + 1, objectArray, (n8 -= n3) + 1, n3);
            objectArray[n8] = objectArray2[n7];
        } else {
            if (n5 == 0) {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
            System.arraycopy(objectArray2, 0, objectArray, n8 - (n5 - 1), n5);
        }
    }

    private Object[] ensureCapacity(int n2) {
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

