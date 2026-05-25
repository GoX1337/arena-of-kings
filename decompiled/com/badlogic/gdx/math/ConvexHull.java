/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class ConvexHull {
    private final IntArray quicksortStack = new IntArray();
    private float[] sortedPoints;
    private final FloatArray hull = new FloatArray();
    private final IntArray indices = new IntArray();
    private final ShortArray originalIndices = new ShortArray(false, 0);

    public FloatArray computePolygon(FloatArray floatArray, boolean bl2) {
        return this.computePolygon(floatArray.items, 0, floatArray.size, bl2);
    }

    public FloatArray computePolygon(float[] fArray, boolean bl2) {
        return this.computePolygon(fArray, 0, fArray.length, bl2);
    }

    public FloatArray computePolygon(float[] fArray, int n2, int n3, boolean bl2) {
        float f2;
        int n4;
        int n5 = n2 + n3;
        if (!bl2) {
            if (this.sortedPoints == null || this.sortedPoints.length < n3) {
                this.sortedPoints = new float[n3];
            }
            System.arraycopy(fArray, n2, this.sortedPoints, 0, n3);
            fArray = this.sortedPoints;
            n2 = 0;
            this.sort(fArray, n3);
        }
        FloatArray floatArray = this.hull;
        floatArray.clear();
        for (n4 = n2; n4 < n5; n4 += 2) {
            float f3 = fArray[n4];
            f2 = fArray[n4 + 1];
            while (floatArray.size >= 4 && this.ccw(f3, f2) <= 0.0f) {
                floatArray.size -= 2;
            }
            floatArray.add(f3);
            floatArray.add(f2);
        }
        int n6 = floatArray.size + 2;
        for (n4 = n5 - 4; n4 >= n2; n4 -= 2) {
            f2 = fArray[n4];
            float f4 = fArray[n4 + 1];
            while (floatArray.size >= n6 && this.ccw(f2, f4) <= 0.0f) {
                floatArray.size -= 2;
            }
            floatArray.add(f2);
            floatArray.add(f4);
        }
        return floatArray;
    }

    public IntArray computeIndices(FloatArray floatArray, boolean bl2, boolean bl3) {
        return this.computeIndices(floatArray.items, 0, floatArray.size, bl2, bl3);
    }

    public IntArray computeIndices(float[] fArray, boolean bl2, boolean bl3) {
        return this.computeIndices(fArray, 0, fArray.length, bl2, bl3);
    }

    public IntArray computeIndices(float[] fArray, int n2, int n3, boolean bl2, boolean bl3) {
        float f2;
        if (n3 > Short.MAX_VALUE) {
            throw new IllegalArgumentException("count must be <= 32767");
        }
        int n4 = n2 + n3;
        if (!bl2) {
            if (this.sortedPoints == null || this.sortedPoints.length < n3) {
                this.sortedPoints = new float[n3];
            }
            System.arraycopy(fArray, n2, this.sortedPoints, 0, n3);
            fArray = this.sortedPoints;
            n2 = 0;
            this.sortWithIndices(fArray, n3, bl3);
        }
        IntArray intArray = this.indices;
        intArray.clear();
        FloatArray floatArray = this.hull;
        floatArray.clear();
        int n5 = n2;
        int n6 = n5 / 2;
        while (n5 < n4) {
            float f3 = fArray[n5];
            f2 = fArray[n5 + 1];
            while (floatArray.size >= 4 && this.ccw(f3, f2) <= 0.0f) {
                floatArray.size -= 2;
                --intArray.size;
            }
            floatArray.add(f3);
            floatArray.add(f2);
            intArray.add(n6);
            n5 += 2;
            ++n6;
        }
        n5 = n4 - 4;
        n6 = n5 / 2;
        int n7 = floatArray.size + 2;
        while (n5 >= n2) {
            f2 = fArray[n5];
            float f4 = fArray[n5 + 1];
            while (floatArray.size >= n7 && this.ccw(f2, f4) <= 0.0f) {
                floatArray.size -= 2;
                --intArray.size;
            }
            floatArray.add(f2);
            floatArray.add(f4);
            intArray.add(n6);
            n5 -= 2;
            --n6;
        }
        if (!bl2) {
            short[] sArray = this.originalIndices.items;
            int[] nArray = intArray.items;
            int n8 = intArray.size;
            for (n7 = 0; n7 < n8; ++n7) {
                nArray[n7] = sArray[nArray[n7]];
            }
        }
        return intArray;
    }

    private float ccw(float f2, float f3) {
        FloatArray floatArray = this.hull;
        int n2 = floatArray.size;
        float f4 = floatArray.get(n2 - 4);
        float f5 = floatArray.get(n2 - 3);
        float f6 = floatArray.get(n2 - 2);
        float f7 = floatArray.peek();
        return (f6 - f4) * (f3 - f5) - (f7 - f5) * (f2 - f4);
    }

    private void sort(float[] fArray, int n2) {
        int n3 = 0;
        int n4 = n2 - 1;
        IntArray intArray = this.quicksortStack;
        intArray.add(n3);
        intArray.add(n4 - 1);
        while (intArray.size > 0) {
            n4 = intArray.pop();
            if (n4 <= (n3 = intArray.pop())) continue;
            int n5 = this.quicksortPartition(fArray, n3, n4);
            if (n5 - n3 > n4 - n5) {
                intArray.add(n3);
                intArray.add(n5 - 2);
            }
            intArray.add(n5 + 2);
            intArray.add(n4);
            if (n4 - n5 < n5 - n3) continue;
            intArray.add(n3);
            intArray.add(n5 - 2);
        }
    }

    private int quicksortPartition(float[] fArray, int n2, int n3) {
        float f2 = fArray[n2];
        float f3 = fArray[n2 + 1];
        int n4 = n3;
        int n5 = n2;
        while (n5 < n4) {
            while (n5 < n4 && fArray[n5] <= f2) {
                n5 += 2;
            }
            while (fArray[n4] > f2 || fArray[n4] == f2 && fArray[n4 + 1] < f3) {
                n4 -= 2;
            }
            if (n5 >= n4) continue;
            float f4 = fArray[n5];
            fArray[n5] = fArray[n4];
            fArray[n4] = f4;
            f4 = fArray[n5 + 1];
            fArray[n5 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f4;
        }
        if (f2 > fArray[n4] || f2 == fArray[n4] && f3 < fArray[n4 + 1]) {
            fArray[n2] = fArray[n4];
            fArray[n4] = f2;
            fArray[n2 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f3;
        }
        return n4;
    }

    private void sortWithIndices(float[] fArray, int n2, boolean bl2) {
        int n3;
        int n4 = n2 / 2;
        this.originalIndices.clear();
        this.originalIndices.ensureCapacity(n4);
        short[] sArray = this.originalIndices.items;
        for (n3 = 0; n3 < n4; n3 = (int)((short)(n3 + 1))) {
            sArray[n3] = n3;
        }
        n3 = 0;
        int n5 = n2 - 1;
        IntArray intArray = this.quicksortStack;
        intArray.add(n3);
        intArray.add(n5 - 1);
        while (intArray.size > 0) {
            n5 = intArray.pop();
            if (n5 <= (n3 = intArray.pop())) continue;
            int n6 = this.quicksortPartitionWithIndices(fArray, n3, n5, bl2, sArray);
            if (n6 - n3 > n5 - n6) {
                intArray.add(n3);
                intArray.add(n6 - 2);
            }
            intArray.add(n6 + 2);
            intArray.add(n5);
            if (n5 - n6 < n6 - n3) continue;
            intArray.add(n3);
            intArray.add(n6 - 2);
        }
    }

    private int quicksortPartitionWithIndices(float[] fArray, int n2, int n3, boolean bl2, short[] sArray) {
        short s2;
        float f2 = fArray[n2];
        float f3 = fArray[n2 + 1];
        int n4 = n3;
        int n5 = n2;
        while (n5 < n4) {
            while (n5 < n4 && fArray[n5] <= f2) {
                n5 += 2;
            }
            if (bl2) {
                while (fArray[n4] > f2 || fArray[n4] == f2 && fArray[n4 + 1] < f3) {
                    n4 -= 2;
                }
            } else {
                while (fArray[n4] > f2 || fArray[n4] == f2 && fArray[n4 + 1] > f3) {
                    n4 -= 2;
                }
            }
            if (n5 >= n4) continue;
            float f4 = fArray[n5];
            fArray[n5] = fArray[n4];
            fArray[n4] = f4;
            f4 = fArray[n5 + 1];
            fArray[n5 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f4;
            s2 = sArray[n5 / 2];
            sArray[n5 / 2] = sArray[n4 / 2];
            sArray[n4 / 2] = s2;
        }
        if (f2 > fArray[n4] || f2 == fArray[n4] && (bl2 ? f3 < fArray[n4 + 1] : f3 > fArray[n4 + 1])) {
            fArray[n2] = fArray[n4];
            fArray[n4] = f2;
            fArray[n2 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f3;
            s2 = sArray[n2 / 2];
            sArray[n2 / 2] = sArray[n4 / 2];
            sArray[n4 / 2] = s2;
        }
        return n4;
    }
}

