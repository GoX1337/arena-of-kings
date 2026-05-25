/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

public final class MathUtil {
    private MathUtil() {
    }

    public static boolean mathIsPoT(int n2) {
        return Integer.bitCount(n2) == 1;
    }

    public static int mathRoundPoT(int n2) {
        return 1 << 32 - Integer.numberOfLeadingZeros(n2 - 1);
    }

    public static boolean mathHasZeroByte(int n2) {
        return (n2 - 0x1010101 & ~n2 & 0x80808080) != 0;
    }

    public static boolean mathHasZeroByte(long l2) {
        return (l2 - 0x101010101010101L & (l2 ^ 0xFFFFFFFFFFFFFFFFL) & 0x8080808080808080L) != 0L;
    }

    public static boolean mathHasZeroShort(int n2) {
        return (n2 - 65537 & ~n2 & 0x80008000) != 0;
    }

    public static boolean mathHasZeroShort(long l2) {
        return (l2 - 0x1000100010001L & (l2 ^ 0xFFFFFFFFFFFFFFFFL) & 0x8000800080008000L) != 0L;
    }

    public static long mathMultiplyHighU64(long l2, long l3) {
        long l4 = l2 & 0xFFFFFFFFL;
        long l5 = l2 >>> 32;
        long l6 = l3 & 0xFFFFFFFFL;
        long l7 = l3 >>> 32;
        long l8 = l5 * l6 + (l4 * l6 >>> 32);
        return l5 * l7 + (l8 >>> 32) + ((l8 & 0xFFFFFFFFL) + l4 * l7 >>> 32);
    }

    public static long mathMultiplyHighS64(long l2, long l3) {
        long l4 = l2 & 0xFFFFFFFFL;
        long l5 = l2 >> 32;
        long l6 = l3 & 0xFFFFFFFFL;
        long l7 = l3 >> 32;
        long l8 = l5 * l6 + (l4 * l6 >>> 32);
        return l5 * l7 + (l8 >> 32) + ((l8 & 0xFFFFFFFFL) + l4 * l7 >> 32);
    }

    public static long mathDivideUnsigned(long l2, long l3) {
        if (0L <= l3) {
            return 0L <= l2 ? l2 / l3 : MathUtil.udivdi3(l2, l3);
        }
        return Long.compareUnsigned(l2, l3) < 0 ? 0L : 1L;
    }

    public static long mathRemainderUnsigned(long l2, long l3) {
        if (0L < l2 && 0L < l3) {
            return l2 % l3;
        }
        return Long.compareUnsigned(l2, l3) < 0 ? l2 : l2 - l3 * MathUtil.udivdi3(l2, l3);
    }

    private static long udivdi3(long l2, long l3) {
        if (l3 >>> 32 == 0L) {
            if (l2 >>> 32 < l3) {
                long l4 = (l2 >>> 1) / l3 << Long.numberOfLeadingZeros(l3) >>> 31;
                if (l2 - l4 * l3 >= l3) {
                    ++l4;
                }
                return l4;
            }
            long l5 = l2 >>> 32;
            long l6 = l5 / l3;
            long l7 = (l5 - l6 * l3 << 32 | l2 & 0xFFFFFFFFL) / l3;
            return l6 << 32 | l7;
        }
        int n2 = Long.numberOfLeadingZeros(l3);
        long l8 = (l2 >>> 1) / (l3 << n2 >>> 32) << n2 >>> 31;
        if (l8 != 0L) {
            --l8;
        }
        if (Long.compareUnsigned(l2 - l8 * l3, l3) >= 0) {
            ++l8;
        }
        return l8;
    }
}

