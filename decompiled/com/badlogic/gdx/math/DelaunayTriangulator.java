/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.BooleanArray;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class DelaunayTriangulator {
    private static final float EPSILON = 1.0E-6f;
    private static final int INSIDE = 0;
    private static final int COMPLETE = 1;
    private static final int INCOMPLETE = 2;
    private final IntArray quicksortStack = new IntArray();
    private float[] sortedPoints;
    private final ShortArray triangles = new ShortArray(false, 16);
    private final ShortArray originalIndices = new ShortArray(false, 0);
    private final IntArray edges = new IntArray();
    private final BooleanArray complete = new BooleanArray(false, 16);
    private final float[] superTriangle = new float[6];
    private final Vector2 centroid = new Vector2();

    public ShortArray computeTriangles(FloatArray floatArray, boolean bl2) {
        return this.computeTriangles(floatArray.items, 0, floatArray.size, bl2);
    }

    public ShortArray computeTriangles(float[] fArray, boolean bl2) {
        return this.computeTriangles(fArray, 0, fArray.length, bl2);
    }

    public ShortArray computeTriangles(float[] fArray, int n2, int n3, boolean bl2) {
        float f2;
        if (n3 > Short.MAX_VALUE) {
            throw new IllegalArgumentException("count must be <= 32767");
        }
        ShortArray shortArray = this.triangles;
        shortArray.clear();
        if (n3 < 6) {
            return shortArray;
        }
        shortArray.ensureCapacity(n3);
        if (!bl2) {
            if (this.sortedPoints == null || this.sortedPoints.length < n3) {
                this.sortedPoints = new float[n3];
            }
            System.arraycopy(fArray, n2, this.sortedPoints, 0, n3);
            fArray = this.sortedPoints;
            n2 = 0;
            this.sort(fArray, n3);
        }
        int n4 = n2 + n3;
        float f3 = fArray[0];
        float f4 = fArray[1];
        float f5 = f3;
        float f6 = f4;
        for (int i2 = n2 + 2; i2 < n4; ++i2) {
            f2 = fArray[i2];
            if (f2 < f3) {
                f3 = f2;
            }
            if (f2 > f5) {
                f5 = f2;
            }
            if ((f2 = fArray[++i2]) < f4) {
                f4 = f2;
            }
            if (!(f2 > f6)) continue;
            f6 = f2;
        }
        float f7 = f5 - f3;
        f2 = f6 - f4;
        float f8 = (f7 > f2 ? f7 : f2) * 20.0f;
        float f9 = (f5 + f3) / 2.0f;
        float f10 = (f6 + f4) / 2.0f;
        float[] fArray2 = this.superTriangle;
        fArray2[0] = f9 - f8;
        fArray2[1] = f10 - f8;
        fArray2[2] = f9;
        fArray2[3] = f10 + f8;
        fArray2[4] = f9 + f8;
        fArray2[5] = f10 - f8;
        IntArray intArray = this.edges;
        intArray.ensureCapacity(n3 / 2);
        BooleanArray booleanArray = this.complete;
        booleanArray.clear();
        booleanArray.ensureCapacity(n3);
        shortArray.add(n4);
        shortArray.add(n4 + 2);
        shortArray.add(n4 + 4);
        booleanArray.add(false);
        for (int i3 = n2; i3 < n4; i3 += 2) {
            int n5;
            int n6;
            int n7;
            int n8;
            float f11 = fArray[i3];
            float f12 = fArray[i3 + 1];
            short[] sArray = shortArray.items;
            boolean[] blArray = booleanArray.items;
            block6: for (int i4 = shortArray.size - 1; i4 >= 0; i4 -= 3) {
                float f13;
                float f14;
                float f15;
                float f16;
                float f17;
                float f18;
                int n9;
                n8 = i4 / 3;
                if (blArray[n8]) continue;
                n7 = sArray[i4 - 2];
                n6 = sArray[i4 - 1];
                n5 = sArray[i4];
                if (n7 >= n4) {
                    n9 = n7 - n4;
                    f18 = fArray2[n9];
                    f17 = fArray2[n9 + 1];
                } else {
                    f18 = fArray[n7];
                    f17 = fArray[n7 + 1];
                }
                if (n6 >= n4) {
                    n9 = n6 - n4;
                    f16 = fArray2[n9];
                    f15 = fArray2[n9 + 1];
                } else {
                    f16 = fArray[n6];
                    f15 = fArray[n6 + 1];
                }
                if (n5 >= n4) {
                    n9 = n5 - n4;
                    f14 = fArray2[n9];
                    f13 = fArray2[n9 + 1];
                } else {
                    f14 = fArray[n5];
                    f13 = fArray[n5 + 1];
                }
                switch (this.circumCircle(f11, f12, f18, f17, f16, f15, f14, f13)) {
                    case 1: {
                        blArray[n8] = true;
                        continue block6;
                    }
                    case 0: {
                        intArray.add(n7, n6, n6, n5);
                        intArray.add(n5, n7);
                        shortArray.removeRange(i4 - 2, i4);
                        booleanArray.removeIndex(n8);
                    }
                }
            }
            int[] nArray = intArray.items;
            n7 = intArray.size;
            for (n8 = 0; n8 < n7; n8 += 2) {
                n6 = nArray[n8];
                if (n6 == -1) continue;
                n5 = nArray[n8 + 1];
                boolean bl3 = false;
                for (int i5 = n8 + 2; i5 < n7; i5 += 2) {
                    if (n6 != nArray[i5 + 1] || n5 != nArray[i5]) continue;
                    bl3 = true;
                    nArray[i5] = -1;
                }
                if (bl3) continue;
                shortArray.add(n6);
                shortArray.add(nArray[n8 + 1]);
                shortArray.add(i3);
                booleanArray.add(false);
            }
            intArray.clear();
        }
        short[] sArray = shortArray.items;
        for (int i6 = shortArray.size - 1; i6 >= 0; i6 -= 3) {
            if (sArray[i6] < n4 && sArray[i6 - 1] < n4 && sArray[i6 - 2] < n4) continue;
            shortArray.removeIndex(i6);
            shortArray.removeIndex(i6 - 1);
            shortArray.removeIndex(i6 - 2);
        }
        if (!bl2) {
            short[] sArray2 = this.originalIndices.items;
            int n10 = shortArray.size;
            for (int i7 = 0; i7 < n10; ++i7) {
                sArray[i7] = (short)(sArray2[sArray[i7] / 2] * 2);
            }
        }
        if (n2 == 0) {
            int n11 = shortArray.size;
            for (int i8 = 0; i8 < n11; ++i8) {
                sArray[i8] = (short)(sArray[i8] / 2);
            }
        } else {
            int n12 = shortArray.size;
            for (int i9 = 0; i9 < n12; ++i9) {
                sArray[i9] = (short)((sArray[i9] - n2) / 2);
            }
        }
        return shortArray;
    }

    private int circumCircle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15 = Math.abs(f5 - f7);
        float f16 = Math.abs(f7 - f9);
        if (f15 < 1.0E-6f) {
            if (f16 < 1.0E-6f) {
                return 2;
            }
            f14 = -(f8 - f6) / (f9 - f7);
            f13 = (f6 + f8) / 2.0f;
            f12 = (f7 + f9) / 2.0f;
            f11 = (f6 + f4) / 2.0f;
            f10 = f14 * (f11 - f13) + f12;
        } else {
            f14 = -(f6 - f4) / (f7 - f5);
            f13 = (f4 + f6) / 2.0f;
            f12 = (f5 + f7) / 2.0f;
            if (f16 < 1.0E-6f) {
                f11 = (f8 + f6) / 2.0f;
                f10 = f14 * (f11 - f13) + f12;
            } else {
                float f17 = -(f8 - f6) / (f9 - f7);
                float f18 = (f6 + f8) / 2.0f;
                float f19 = (f7 + f9) / 2.0f;
                f11 = (f14 * f13 - f17 * f18 + f19 - f12) / (f14 - f17);
                f10 = f14 * (f11 - f13) + f12;
            }
        }
        f14 = f6 - f11;
        f13 = f7 - f10;
        f12 = f14 * f14 + f13 * f13;
        f14 = f2 - f11;
        f14 *= f14;
        f13 = f3 - f10;
        if (f14 + f13 * f13 - f12 <= 1.0E-6f) {
            return 0;
        }
        return f2 > f11 && f14 > f12 ? 1 : 2;
    }

    private void sort(float[] fArray, int n2) {
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
            int n6 = this.quicksortPartition(fArray, n3, n5, sArray);
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

    private int quicksortPartition(float[] fArray, int n2, int n3, short[] sArray) {
        short s2;
        float f2;
        float f3 = fArray[n2];
        int n4 = n3;
        int n5 = n2 + 2;
        while (n5 < n4) {
            while (n5 < n4 && fArray[n5] <= f3) {
                n5 += 2;
            }
            while (fArray[n4] > f3) {
                n4 -= 2;
            }
            if (n5 >= n4) continue;
            f2 = fArray[n5];
            fArray[n5] = fArray[n4];
            fArray[n4] = f2;
            f2 = fArray[n5 + 1];
            fArray[n5 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f2;
            s2 = sArray[n5 / 2];
            sArray[n5 / 2] = sArray[n4 / 2];
            sArray[n4 / 2] = s2;
        }
        if (f3 > fArray[n4]) {
            fArray[n2] = fArray[n4];
            fArray[n4] = f3;
            f2 = fArray[n2 + 1];
            fArray[n2 + 1] = fArray[n4 + 1];
            fArray[n4 + 1] = f2;
            s2 = sArray[n2 / 2];
            sArray[n2 / 2] = sArray[n4 / 2];
            sArray[n4 / 2] = s2;
        }
        return n4;
    }

    public void trim(ShortArray shortArray, float[] fArray, float[] fArray2, int n2, int n3) {
        short[] sArray = shortArray.items;
        for (int i2 = shortArray.size - 1; i2 >= 0; i2 -= 3) {
            int n4 = sArray[i2 - 2] * 2;
            int n5 = sArray[i2 - 1] * 2;
            int n6 = sArray[i2] * 2;
            GeometryUtils.triangleCentroid(fArray[n4], fArray[n4 + 1], fArray[n5], fArray[n5 + 1], fArray[n6], fArray[n6 + 1], this.centroid);
            if (Intersector.isPointInPolygon(fArray2, n2, n3, this.centroid.x, this.centroid.y)) continue;
            shortArray.removeIndex(i2);
            shortArray.removeIndex(i2 - 1);
            shortArray.removeIndex(i2 - 2);
        }
    }
}

