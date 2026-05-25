/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.Random;
import org.apache.commons.lang3.Validate;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int n2) {
        Validate.isTrue(n2 >= 0, "Count cannot be negative.", new Object[0]);
        byte[] byArray = new byte[n2];
        RANDOM.nextBytes(byArray);
        return byArray;
    }

    public static int nextInt(int n2, int n3) {
        Validate.isTrue(n3 >= n2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(n2 >= 0, "Both range values must be non-negative.", new Object[0]);
        if (n2 == n3) {
            return n2;
        }
        return n2 + RANDOM.nextInt(n3 - n2);
    }

    public static int nextInt() {
        return RandomUtils.nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong(long l2, long l3) {
        Validate.isTrue(l3 >= l2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(l2 >= 0L, "Both range values must be non-negative.", new Object[0]);
        if (l2 == l3) {
            return l2;
        }
        return l2 + RandomUtils.nextLong(l3 - l2);
    }

    public static long nextLong() {
        return RandomUtils.nextLong(Long.MAX_VALUE);
    }

    private static long nextLong(long l2) {
        long l3;
        long l4;
        while ((l4 = RANDOM.nextLong() >>> 1) - (l3 = l4 % l2) + (l2 - 1L) < 0L) {
        }
        return l3;
    }

    public static double nextDouble(double d2, double d3) {
        Validate.isTrue(d3 >= d2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d2 >= 0.0, "Both range values must be non-negative.", new Object[0]);
        if (d2 == d3) {
            return d2;
        }
        return d2 + (d3 - d2) * RANDOM.nextDouble();
    }

    public static double nextDouble() {
        return RandomUtils.nextDouble(0.0, Double.MAX_VALUE);
    }

    public static float nextFloat(float f2, float f3) {
        Validate.isTrue(f3 >= f2, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f2 >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (f2 == f3) {
            return f2;
        }
        return f2 + (f3 - f2) * RANDOM.nextFloat();
    }

    public static float nextFloat() {
        return RandomUtils.nextFloat(0.0f, Float.MAX_VALUE);
    }
}

