/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class FormatUtil {
    private static final long KIBI = 1024L;
    private static final long MEBI = 0x100000L;
    private static final long GIBI = 0x40000000L;
    private static final long TEBI = 0x10000000000L;
    private static final long PEBI = 0x4000000000000L;
    private static final long EXBI = 0x1000000000000000L;
    private static final long KILO = 1000L;
    private static final long MEGA = 1000000L;
    private static final long GIGA = 1000000000L;
    private static final long TERA = 1000000000000L;
    private static final long PETA = 1000000000000000L;
    private static final long EXA = 1000000000000000000L;
    private static final BigInteger TWOS_COMPLEMENT_REF = BigInteger.ONE.shiftLeft(64);
    public static final String HEX_ERROR = "0x%08X";

    private FormatUtil() {
    }

    public static String formatBytes(long l2) {
        if (l2 == 1L) {
            return String.format("%d byte", l2);
        }
        if (l2 < 1024L) {
            return String.format("%d bytes", l2);
        }
        if (l2 < 0x100000L) {
            return FormatUtil.formatUnits(l2, 1024L, "KiB");
        }
        if (l2 < 0x40000000L) {
            return FormatUtil.formatUnits(l2, 0x100000L, "MiB");
        }
        if (l2 < 0x10000000000L) {
            return FormatUtil.formatUnits(l2, 0x40000000L, "GiB");
        }
        if (l2 < 0x4000000000000L) {
            return FormatUtil.formatUnits(l2, 0x10000000000L, "TiB");
        }
        if (l2 < 0x1000000000000000L) {
            return FormatUtil.formatUnits(l2, 0x4000000000000L, "PiB");
        }
        return FormatUtil.formatUnits(l2, 0x1000000000000000L, "EiB");
    }

    private static String formatUnits(long l2, long l3, String string) {
        if (l2 % l3 == 0L) {
            return String.format("%d %s", l2 / l3, string);
        }
        return String.format("%.1f %s", (double)l2 / (double)l3, string);
    }

    public static String formatBytesDecimal(long l2) {
        if (l2 == 1L) {
            return String.format("%d byte", l2);
        }
        if (l2 < 1000L) {
            return String.format("%d bytes", l2);
        }
        return FormatUtil.formatValue(l2, "B");
    }

    public static String formatHertz(long l2) {
        return FormatUtil.formatValue(l2, "Hz");
    }

    public static String formatValue(long l2, String string) {
        if (l2 < 1000L) {
            return String.format("%d %s", l2, string).trim();
        }
        if (l2 < 1000000L) {
            return FormatUtil.formatUnits(l2, 1000L, "K" + string);
        }
        if (l2 < 1000000000L) {
            return FormatUtil.formatUnits(l2, 1000000L, "M" + string);
        }
        if (l2 < 1000000000000L) {
            return FormatUtil.formatUnits(l2, 1000000000L, "G" + string);
        }
        if (l2 < 1000000000000000L) {
            return FormatUtil.formatUnits(l2, 1000000000000L, "T" + string);
        }
        if (l2 < 1000000000000000000L) {
            return FormatUtil.formatUnits(l2, 1000000000000000L, "P" + string);
        }
        return FormatUtil.formatUnits(l2, 1000000000000000000L, "E" + string);
    }

    public static String formatElapsedSecs(long l2) {
        long l3 = l2;
        long l4 = TimeUnit.SECONDS.toDays(l3);
        long l5 = TimeUnit.SECONDS.toHours(l3 -= TimeUnit.DAYS.toSeconds(l4));
        long l6 = TimeUnit.SECONDS.toMinutes(l3 -= TimeUnit.HOURS.toSeconds(l5));
        long l7 = l3 -= TimeUnit.MINUTES.toSeconds(l6);
        return String.format("%d days, %02d:%02d:%02d", l4, l5, l6, l7);
    }

    public static long getUnsignedInt(int n2) {
        return (long)n2 & 0xFFFFFFFFL;
    }

    public static String toUnsignedString(int n2) {
        if (n2 >= 0) {
            return Integer.toString(n2);
        }
        return Long.toString(FormatUtil.getUnsignedInt(n2));
    }

    public static String toUnsignedString(long l2) {
        if (l2 >= 0L) {
            return Long.toString(l2);
        }
        return BigInteger.valueOf(l2).add(TWOS_COMPLEMENT_REF).toString();
    }

    public static String formatError(int n2) {
        return String.format(HEX_ERROR, n2);
    }

    public static int roundToInt(double d2) {
        return (int)Math.round(d2);
    }
}

