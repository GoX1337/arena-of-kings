/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

public final class NumberUtils {
    public static int floatToIntBits(float f2) {
        return Float.floatToIntBits(f2);
    }

    public static int floatToRawIntBits(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    public static int floatToIntColor(float f2) {
        int n2 = Float.floatToRawIntBits(f2);
        n2 |= (int)((float)(n2 >>> 24) * 1.003937f) << 24;
        return n2;
    }

    public static float intToFloatColor(int n2) {
        return Float.intBitsToFloat(n2 & 0xFEFFFFFF);
    }

    public static float intBitsToFloat(int n2) {
        return Float.intBitsToFloat(n2);
    }

    public static long doubleToLongBits(double d2) {
        return Double.doubleToLongBits(d2);
    }

    public static double longBitsToDouble(long l2) {
        return Double.longBitsToDouble(l2);
    }
}

