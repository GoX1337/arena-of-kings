/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.Vector2;

public final class GeometryUtils {
    private static final Vector2 tmp1 = new Vector2();
    private static final Vector2 tmp2 = new Vector2();
    private static final Vector2 tmp3 = new Vector2();

    private GeometryUtils() {
    }

    public static Vector2 toBarycoord(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, Vector2 vector25) {
        Vector2 vector26 = tmp1.set(vector23).sub(vector22);
        Vector2 vector27 = tmp2.set(vector24).sub(vector22);
        Vector2 vector28 = tmp3.set(vector2).sub(vector22);
        float f2 = vector26.dot(vector26);
        float f3 = vector26.dot(vector27);
        float f4 = vector27.dot(vector27);
        float f5 = vector28.dot(vector26);
        float f6 = vector28.dot(vector27);
        float f7 = f2 * f4 - f3 * f3;
        vector25.x = (f4 * f5 - f3 * f6) / f7;
        vector25.y = (f2 * f6 - f3 * f5) / f7;
        return vector25;
    }

    public static boolean barycoordInsideTriangle(Vector2 vector2) {
        return vector2.x >= 0.0f && vector2.y >= 0.0f && vector2.x + vector2.y <= 1.0f;
    }

    public static Vector2 fromBarycoord(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, Vector2 vector25) {
        float f2 = 1.0f - vector2.x - vector2.y;
        vector25.x = f2 * vector22.x + vector2.x * vector23.x + vector2.y * vector24.x;
        vector25.y = f2 * vector22.y + vector2.x * vector23.y + vector2.y * vector24.y;
        return vector25;
    }

    public static float fromBarycoord(Vector2 vector2, float f2, float f3, float f4) {
        float f5 = 1.0f - vector2.x - vector2.y;
        return f5 * f2 + vector2.x * f3 + vector2.y * f4;
    }

    public static float lowestPositiveRoot(float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7 = f3 * f3 - 4.0f * f2 * f4;
        if (f7 < 0.0f) {
            return Float.NaN;
        }
        float f8 = (float)Math.sqrt(f7);
        float f9 = (-f3 - f8) * (f6 = 1.0f / (2.0f * f2));
        if (f9 > (f5 = (-f3 + f8) * f6)) {
            float f10 = f5;
            f5 = f9;
            f9 = f10;
        }
        if (f9 > 0.0f) {
            return f9;
        }
        if (f5 > 0.0f) {
            return f5;
        }
        return Float.NaN;
    }

    public static boolean colinear(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f5 - f3;
        float f10 = f4 - f2;
        float f11 = f7 - f5;
        float f12 = f8 * f9 - f10 * f11;
        return Math.abs(f12) < 1.0E-6f;
    }

    public static Vector2 triangleCentroid(float f2, float f3, float f4, float f5, float f6, float f7, Vector2 vector2) {
        vector2.x = (f2 + f4 + f6) / 3.0f;
        vector2.y = (f3 + f5 + f7) / 3.0f;
        return vector2;
    }

    public static Vector2 triangleCircumcenter(float f2, float f3, float f4, float f5, float f6, float f7, Vector2 vector2) {
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = f6 - f4;
        float f11 = f7 - f5;
        float f12 = f2 - f6;
        float f13 = f3 - f7;
        float f14 = f10 * f9 - f8 * f11;
        if (Math.abs(f14) < 1.0E-6f) {
            throw new IllegalArgumentException("Triangle points must not be colinear.");
        }
        float f15 = f2 * f2 + f3 * f3;
        float f16 = f4 * f4 + f5 * f5;
        float f17 = f6 * f6 + f7 * f7;
        vector2.set((f15 * f11 + f16 * f13 + f17 * f9) / (f14 *= 2.0f), -(f15 * f10 + f16 * f12 + f17 * f8) / f14);
        return vector2;
    }

    public static float triangleCircumradius(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        if (Math.abs(f5 - f3) < 1.0E-6f) {
            float f10 = -(f6 - f4) / (f7 - f5);
            float f11 = (f4 + f6) / 2.0f;
            float f12 = (f5 + f7) / 2.0f;
            f9 = (f4 + f2) / 2.0f;
            f8 = f10 * (f9 - f11) + f12;
        } else if (Math.abs(f7 - f5) < 1.0E-6f) {
            float f13 = -(f4 - f2) / (f5 - f3);
            float f14 = (f2 + f4) / 2.0f;
            float f15 = (f3 + f5) / 2.0f;
            f9 = (f6 + f4) / 2.0f;
            f8 = f13 * (f9 - f14) + f15;
        } else {
            float f16 = -(f4 - f2) / (f5 - f3);
            float f17 = -(f6 - f4) / (f7 - f5);
            float f18 = (f2 + f4) / 2.0f;
            float f19 = (f4 + f6) / 2.0f;
            float f20 = (f3 + f5) / 2.0f;
            float f21 = (f5 + f7) / 2.0f;
            f9 = (f16 * f18 - f17 * f19 + f21 - f20) / (f16 - f17);
            f8 = f16 * (f9 - f18) + f20;
        }
        float f22 = f2 - f9;
        float f23 = f3 - f8;
        return (float)Math.sqrt(f22 * f22 + f23 * f23);
    }

    public static float triangleQuality(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = (float)Math.sqrt(f2 * f2 + f3 * f3);
        float f9 = (float)Math.sqrt(f4 * f4 + f5 * f5);
        float f10 = (float)Math.sqrt(f6 * f6 + f7 * f7);
        return Math.min(f8, Math.min(f9, f10)) / GeometryUtils.triangleCircumradius(f2, f3, f4, f5, f6, f7);
    }

    public static float triangleArea(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.abs((f2 - f6) * (f5 - f3) - (f2 - f4) * (f7 - f3)) * 0.5f;
    }

    public static Vector2 quadrilateralCentroid(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2 vector2) {
        float f10 = (f2 + f4 + f6) / 3.0f;
        float f11 = (f3 + f5 + f7) / 3.0f;
        float f12 = (f2 + f8 + f6) / 3.0f;
        float f13 = (f3 + f9 + f7) / 3.0f;
        vector2.x = f10 - (f10 - f12) / 2.0f;
        vector2.y = f11 - (f11 - f13) / 2.0f;
        return vector2;
    }

    public static Vector2 polygonCentroid(float[] fArray, int n2, int n3, Vector2 vector2) {
        if (n3 < 6) {
            throw new IllegalArgumentException("A polygon must have 3 or more coordinate pairs.");
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n4 = n2 + n3 - 2;
        float f5 = fArray[n4];
        float f6 = fArray[n4 + 1];
        for (int i2 = n2; i2 <= n4; i2 += 2) {
            float f7 = fArray[i2];
            float f8 = fArray[i2 + 1];
            float f9 = f5 * f8 - f7 * f6;
            f2 += f9;
            f3 += (f5 + f7) * f9;
            f4 += (f6 + f8) * f9;
            f5 = f7;
            f6 = f8;
        }
        if (f2 == 0.0f) {
            vector2.x = 0.0f;
            vector2.y = 0.0f;
        } else {
            vector2.x = f3 / (6.0f * (f2 *= 0.5f));
            vector2.y = f4 / (6.0f * f2);
        }
        return vector2;
    }

    public static float polygonArea(float[] fArray, int n2, int n3) {
        float f2 = 0.0f;
        int n4 = n2 + n3 - 2;
        float f3 = fArray[n4];
        float f4 = fArray[n4 + 1];
        for (int i2 = n2; i2 <= n4; i2 += 2) {
            float f5 = fArray[i2];
            float f6 = fArray[i2 + 1];
            f2 += f3 * f6 - f5 * f4;
            f3 = f5;
            f4 = f6;
        }
        return f2 * 0.5f;
    }

    public static void ensureCCW(float[] fArray) {
        GeometryUtils.ensureCCW(fArray, 0, fArray.length);
    }

    public static void ensureCCW(float[] fArray, int n2, int n3) {
        if (!GeometryUtils.isClockwise(fArray, n2, n3)) {
            return;
        }
        GeometryUtils.reverseVertices(fArray, n2, n3);
    }

    public static void ensureClockwise(float[] fArray) {
        GeometryUtils.ensureClockwise(fArray, 0, fArray.length);
    }

    public static void ensureClockwise(float[] fArray, int n2, int n3) {
        if (GeometryUtils.isClockwise(fArray, n2, n3)) {
            return;
        }
        GeometryUtils.reverseVertices(fArray, n2, n3);
    }

    public static void reverseVertices(float[] fArray, int n2, int n3) {
        int n4 = n2 + n3 - 2;
        int n5 = n2 + n3 / 2;
        for (int i2 = n2; i2 < n5; i2 += 2) {
            int n6 = n4 - i2;
            float f2 = fArray[i2];
            float f3 = fArray[i2 + 1];
            fArray[i2] = fArray[n6];
            fArray[i2 + 1] = fArray[n6 + 1];
            fArray[n6] = f2;
            fArray[n6 + 1] = f3;
        }
    }

    public static boolean isClockwise(float[] fArray, int n2, int n3) {
        if (n3 <= 2) {
            return false;
        }
        float f2 = 0.0f;
        int n4 = n2 + n3 - 2;
        float f3 = fArray[n4];
        float f4 = fArray[n4 + 1];
        for (int i2 = n2; i2 <= n4; i2 += 2) {
            float f5 = fArray[i2];
            float f6 = fArray[i2 + 1];
            f2 += f3 * f6 - f5 * f4;
            f3 = f5;
            f4 = f6;
        }
        return f2 < 0.0f;
    }

    public static boolean isCCW(float[] fArray, int n2, int n3) {
        return !GeometryUtils.isClockwise(fArray, n2, n3);
    }
}

