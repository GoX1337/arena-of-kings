/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.math;

import com.badlogic.gdx.math.RandomXS128;
import java.util.Random;

public final class MathUtils {
    public static final float nanoToSec = 1.0E-9f;
    public static final float FLOAT_ROUNDING_ERROR = 1.0E-6f;
    public static final float PI = (float)Math.PI;
    public static final float PI2 = (float)Math.PI * 2;
    public static final float HALF_PI = 1.5707964f;
    public static final float E = (float)Math.E;
    private static final int SIN_BITS = 14;
    private static final int SIN_MASK = 16383;
    private static final int SIN_COUNT = 16384;
    private static final float radFull = (float)Math.PI * 2;
    private static final float degFull = 360.0f;
    private static final float radToIndex = 2607.5945f;
    private static final float degToIndex = 45.511112f;
    public static final float radiansToDegrees = 57.295776f;
    public static final float radDeg = 57.295776f;
    public static final float degreesToRadians = (float)Math.PI / 180;
    public static final float degRad = (float)Math.PI / 180;
    public static Random random = new RandomXS128();
    private static final int BIG_ENOUGH_INT = 16384;
    private static final double BIG_ENOUGH_FLOOR = 16384.0;
    private static final double CEIL = 0.9999999;
    private static final double BIG_ENOUGH_CEIL = 16384.999999999996;
    private static final double BIG_ENOUGH_ROUND = 16384.5;

    private MathUtils() {
    }

    public static float sin(float f2) {
        return Sin.table[(int)(f2 * 2607.5945f) & 0x3FFF];
    }

    public static float cos(float f2) {
        return Sin.table[(int)((f2 + 1.5707964f) * 2607.5945f) & 0x3FFF];
    }

    public static float sinDeg(float f2) {
        return Sin.table[(int)(f2 * 45.511112f) & 0x3FFF];
    }

    public static float cosDeg(float f2) {
        return Sin.table[(int)((f2 + 90.0f) * 45.511112f) & 0x3FFF];
    }

    public static float atanUnchecked(double d2) {
        double d3 = Math.abs(d2);
        double d4 = (d3 - 1.0) / (d3 + 1.0);
        double d5 = d4 * d4;
        double d6 = d4 * d5;
        double d7 = d6 * d5;
        double d8 = d7 * d5;
        double d9 = d8 * d5;
        double d10 = d9 * d5;
        return (float)Math.copySign(0.7853981633974483 + (0.99997726 * d4 - 0.33262347 * d6 + 0.19354346 * d7 - 0.11643287 * d8 + 0.05265332 * d9 - 0.0117212 * d10), d2);
    }

    public static float atan2(float f2, float f3) {
        float f4 = f2 / f3;
        if (f4 != f4) {
            f4 = f2 == f3 ? 1.0f : -1.0f;
        } else if (f4 - f4 != f4 - f4) {
            f3 = 0.0f;
        }
        if (f3 > 0.0f) {
            return MathUtils.atanUnchecked(f4);
        }
        if (f3 < 0.0f) {
            if (f2 >= 0.0f) {
                return MathUtils.atanUnchecked(f4) + (float)Math.PI;
            }
            return MathUtils.atanUnchecked(f4) - (float)Math.PI;
        }
        if (f2 > 0.0f) {
            return f3 + 1.5707964f;
        }
        if (f2 < 0.0f) {
            return f3 - 1.5707964f;
        }
        return f3 + f2;
    }

    public static float acos(float f2) {
        float f3 = f2 * f2;
        float f4 = f2 * f3;
        if (f2 >= 0.0f) {
            return (float)Math.sqrt(1.0f - f2) * (1.5707288f - 0.2121144f * f2 + 0.074261f * f3 - 0.0187293f * f4);
        }
        return (float)Math.PI - (float)Math.sqrt(1.0f + f2) * (1.5707288f + 0.2121144f * f2 + 0.074261f * f3 + 0.0187293f * f4);
    }

    public static float asin(float f2) {
        float f3 = f2 * f2;
        float f4 = f2 * f3;
        if (f2 >= 0.0f) {
            return 1.5707964f - (float)Math.sqrt(1.0f - f2) * (1.5707288f - 0.2121144f * f2 + 0.074261f * f3 - 0.0187293f * f4);
        }
        return -1.5707964f + (float)Math.sqrt(1.0f + f2) * (1.5707288f + 0.2121144f * f2 + 0.074261f * f3 + 0.0187293f * f4);
    }

    public static float atan(float f2) {
        double d2 = Math.min((double)Math.abs(f2), Double.MAX_VALUE);
        double d3 = (d2 - 1.0) / (d2 + 1.0);
        double d4 = d3 * d3;
        double d5 = d3 * d4;
        double d6 = d5 * d4;
        double d7 = d6 * d4;
        double d8 = d7 * d4;
        double d9 = d8 * d4;
        return (float)Math.copySign(0.7853981633974483 + (0.99997726 * d3 - 0.33262347 * d5 + 0.19354346 * d6 - 0.11643287 * d7 + 0.05265332 * d8 - 0.0117212 * d9), (double)f2);
    }

    public static int random(int n2) {
        return random.nextInt(n2 + 1);
    }

    public static int random(int n2, int n3) {
        return n2 + random.nextInt(n3 - n2 + 1);
    }

    public static long random(long l2) {
        return MathUtils.random(0L, l2);
    }

    public static long random(long l2, long l3) {
        long l4;
        long l5 = random.nextLong();
        if (l3 < l2) {
            l4 = l3;
            l3 = l2;
            l2 = l4;
        }
        l4 = l3 - l2 + 1L;
        long l6 = l5 & 0xFFFFFFFFL;
        long l7 = l4 & 0xFFFFFFFFL;
        long l8 = l5 >>> 32;
        long l9 = l4 >>> 32;
        return l2 + (l8 * l7 >>> 32) + (l6 * l9 >>> 32) + l8 * l9;
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static boolean randomBoolean(float f2) {
        return MathUtils.random() < f2;
    }

    public static float random() {
        return random.nextFloat();
    }

    public static float random(float f2) {
        return random.nextFloat() * f2;
    }

    public static float random(float f2, float f3) {
        return f2 + random.nextFloat() * (f3 - f2);
    }

    public static int randomSign() {
        return 1 | random.nextInt() >> 31;
    }

    public static float randomTriangular() {
        return random.nextFloat() - random.nextFloat();
    }

    public static float randomTriangular(float f2) {
        return (random.nextFloat() - random.nextFloat()) * f2;
    }

    public static float randomTriangular(float f2, float f3) {
        return MathUtils.randomTriangular(f2, f3, (f2 + f3) * 0.5f);
    }

    public static float randomTriangular(float f2, float f3, float f4) {
        float f5;
        float f6 = random.nextFloat();
        if (f6 <= (f4 - f2) / (f5 = f3 - f2)) {
            return f2 + (float)Math.sqrt(f6 * f5 * (f4 - f2));
        }
        return f3 - (float)Math.sqrt((1.0f - f6) * f5 * (f3 - f4));
    }

    public static int nextPowerOfTwo(int n2) {
        if (n2 == 0) {
            return 1;
        }
        --n2;
        n2 |= n2 >> 1;
        n2 |= n2 >> 2;
        n2 |= n2 >> 4;
        n2 |= n2 >> 8;
        n2 |= n2 >> 16;
        return n2 + 1;
    }

    public static boolean isPowerOfTwo(int n2) {
        return n2 != 0 && (n2 & n2 - 1) == 0;
    }

    public static short clamp(short s2, short s3, short s4) {
        if (s2 < s3) {
            return s3;
        }
        if (s2 > s4) {
            return s4;
        }
        return s2;
    }

    public static int clamp(int n2, int n3, int n4) {
        if (n2 < n3) {
            return n3;
        }
        if (n2 > n4) {
            return n4;
        }
        return n2;
    }

    public static long clamp(long l2, long l3, long l4) {
        if (l2 < l3) {
            return l3;
        }
        if (l2 > l4) {
            return l4;
        }
        return l2;
    }

    public static float clamp(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        if (f2 > f4) {
            return f4;
        }
        return f2;
    }

    public static double clamp(double d2, double d3, double d4) {
        if (d2 < d3) {
            return d3;
        }
        if (d2 > d4) {
            return d4;
        }
        return d2;
    }

    public static float lerp(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    public static float norm(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public static float map(float f2, float f3, float f4, float f5, float f6) {
        return f4 + (f6 - f2) * (f5 - f4) / (f3 - f2);
    }

    public static float lerpAngle(float f2, float f3, float f4) {
        float f5 = (f3 - f2 + (float)Math.PI * 2 + (float)Math.PI) % ((float)Math.PI * 2) - (float)Math.PI;
        return (f2 + f5 * f4 + (float)Math.PI * 2) % ((float)Math.PI * 2);
    }

    public static float lerpAngleDeg(float f2, float f3, float f4) {
        float f5 = (f3 - f2 + 360.0f + 180.0f) % 360.0f - 180.0f;
        return (f2 + f5 * f4 + 360.0f) % 360.0f;
    }

    public static int floor(float f2) {
        return (int)((double)f2 + 16384.0) - 16384;
    }

    public static int floorPositive(float f2) {
        return (int)f2;
    }

    public static int ceil(float f2) {
        return 16384 - (int)(16384.0 - (double)f2);
    }

    public static int ceilPositive(float f2) {
        return (int)((double)f2 + 0.9999999);
    }

    public static int round(float f2) {
        return (int)((double)f2 + 16384.5) - 16384;
    }

    public static int roundPositive(float f2) {
        return (int)(f2 + 0.5f);
    }

    public static boolean isZero(float f2) {
        return Math.abs(f2) <= 1.0E-6f;
    }

    public static boolean isZero(float f2, float f3) {
        return Math.abs(f2) <= f3;
    }

    public static boolean isEqual(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.0E-6f;
    }

    public static boolean isEqual(float f2, float f3, float f4) {
        return Math.abs(f2 - f3) <= f4;
    }

    public static float log(float f2, float f3) {
        return (float)(Math.log(f3) / Math.log(f2));
    }

    public static float log2(float f2) {
        return MathUtils.log(2.0f, f2);
    }

    static class Sin {
        static final float[] table = new float[16384];

        private Sin() {
        }

        static {
            for (int i2 = 0; i2 < 16384; ++i2) {
                Sin.table[i2] = (float)Math.sin(((float)i2 + 0.5f) / 16384.0f * ((float)Math.PI * 2));
            }
            Sin.table[0] = 0.0f;
            Sin.table[4096] = 1.0f;
            Sin.table[8192] = 0.0f;
            Sin.table[12288] = -1.0f;
        }
    }
}

