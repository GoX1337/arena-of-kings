/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class EarClippingTriangulator {
    private static final int CONCAVE = -1;
    private static final int CONVEX = 1;
    private final ShortArray indicesArray = new ShortArray();
    private short[] indices;
    private float[] vertices;
    private int vertexCount;
    private final IntArray vertexTypes = new IntArray();
    private final ShortArray triangles = new ShortArray();

    public ShortArray computeTriangles(FloatArray floatArray) {
        return this.computeTriangles(floatArray.items, 0, floatArray.size);
    }

    public ShortArray computeTriangles(float[] fArray) {
        return this.computeTriangles(fArray, 0, fArray.length);
    }

    public ShortArray computeTriangles(float[] fArray, int n2, int n3) {
        int n4;
        int n5;
        this.vertices = fArray;
        int n6 = this.vertexCount = n3 / 2;
        int n7 = n2 / 2;
        ShortArray shortArray = this.indicesArray;
        shortArray.clear();
        shortArray.ensureCapacity(n6);
        shortArray.size = n6;
        this.indices = shortArray.items;
        short[] sArray = shortArray.items;
        if (GeometryUtils.isClockwise(fArray, n2, n3)) {
            for (n5 = 0; n5 < n6; n5 = (int)((short)(n5 + 1))) {
                sArray[n5] = (short)(n7 + n5);
            }
        } else {
            n4 = n6 - 1;
            for (n5 = 0; n5 < n6; ++n5) {
                sArray[n5] = (short)(n7 + n4 - n5);
            }
        }
        IntArray intArray = this.vertexTypes;
        intArray.clear();
        intArray.ensureCapacity(n6);
        int n8 = n6;
        for (n4 = 0; n4 < n8; ++n4) {
            intArray.add(this.classifyVertex(n4));
        }
        ShortArray shortArray2 = this.triangles;
        shortArray2.clear();
        shortArray2.ensureCapacity(Math.max(0, n6 - 2) * 3);
        this.triangulate();
        return shortArray2;
    }

    private void triangulate() {
        int[] nArray = this.vertexTypes.items;
        while (this.vertexCount > 3) {
            int n2 = this.findEarTip();
            this.cutEarTip(n2);
            int n3 = this.previousIndex(n2);
            int n4 = n2 == this.vertexCount ? 0 : n2;
            nArray[n3] = this.classifyVertex(n3);
            nArray[n4] = this.classifyVertex(n4);
        }
        if (this.vertexCount == 3) {
            ShortArray shortArray = this.triangles;
            short[] sArray = this.indices;
            shortArray.add(sArray[0]);
            shortArray.add(sArray[1]);
            shortArray.add(sArray[2]);
        }
    }

    private int classifyVertex(int n2) {
        short[] sArray = this.indices;
        int n3 = sArray[this.previousIndex(n2)] * 2;
        int n4 = sArray[n2] * 2;
        int n5 = sArray[this.nextIndex(n2)] * 2;
        float[] fArray = this.vertices;
        return EarClippingTriangulator.computeSpannedAreaSign(fArray[n3], fArray[n3 + 1], fArray[n4], fArray[n4 + 1], fArray[n5], fArray[n5 + 1]);
    }

    private int findEarTip() {
        int n2 = this.vertexCount;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!this.isEarTip(i2)) continue;
            return i2;
        }
        int[] nArray = this.vertexTypes.items;
        for (int i3 = 0; i3 < n2; ++i3) {
            if (nArray[i3] == -1) continue;
            return i3;
        }
        return 0;
    }

    private boolean isEarTip(int n2) {
        int[] nArray = this.vertexTypes.items;
        if (nArray[n2] == -1) {
            return false;
        }
        int n3 = this.previousIndex(n2);
        int n4 = this.nextIndex(n2);
        short[] sArray = this.indices;
        int n5 = sArray[n3] * 2;
        int n6 = sArray[n2] * 2;
        int n7 = sArray[n4] * 2;
        float[] fArray = this.vertices;
        float f2 = fArray[n5];
        float f3 = fArray[n5 + 1];
        float f4 = fArray[n6];
        float f5 = fArray[n6 + 1];
        float f6 = fArray[n7];
        float f7 = fArray[n7 + 1];
        int n8 = this.nextIndex(n4);
        while (n8 != n3) {
            float f8;
            int n9;
            float f9;
            if (nArray[n8] != 1 && EarClippingTriangulator.computeSpannedAreaSign(f6, f7, f2, f3, f9 = fArray[n9 = sArray[n8] * 2], f8 = fArray[n9 + 1]) >= 0 && EarClippingTriangulator.computeSpannedAreaSign(f2, f3, f4, f5, f9, f8) >= 0 && EarClippingTriangulator.computeSpannedAreaSign(f4, f5, f6, f7, f9, f8) >= 0) {
                return false;
            }
            n8 = this.nextIndex(n8);
        }
        return true;
    }

    private void cutEarTip(int n2) {
        short[] sArray = this.indices;
        ShortArray shortArray = this.triangles;
        shortArray.add(sArray[this.previousIndex(n2)]);
        shortArray.add(sArray[n2]);
        shortArray.add(sArray[this.nextIndex(n2)]);
        this.indicesArray.removeIndex(n2);
        this.vertexTypes.removeIndex(n2);
        --this.vertexCount;
    }

    private int previousIndex(int n2) {
        return (n2 == 0 ? this.vertexCount : n2) - 1;
    }

    private int nextIndex(int n2) {
        return (n2 + 1) % this.vertexCount;
    }

    private static int computeSpannedAreaSign(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f2 * (f7 - f5);
        f8 += f4 * (f3 - f7);
        return (int)Math.signum(f8 += f6 * (f5 - f3));
    }
}

