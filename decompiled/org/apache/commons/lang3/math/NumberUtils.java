/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = 0;
    public static final Byte BYTE_ONE = 1;
    public static final Byte BYTE_MINUS_ONE = -1;
    public static final Double DOUBLE_ZERO = 0.0;
    public static final Double DOUBLE_ONE = 1.0;
    public static final Double DOUBLE_MINUS_ONE = -1.0;
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Long LONG_INT_MAX_VALUE = Integer.MAX_VALUE;
    public static final Long LONG_INT_MIN_VALUE = Integer.MIN_VALUE;

    public static int toInt(String string) {
        return NumberUtils.toInt(string, 0);
    }

    public static int toInt(String string, int n2) {
        if (string == null) {
            return n2;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
    }

    public static long toLong(String string) {
        return NumberUtils.toLong(string, 0L);
    }

    public static long toLong(String string, long l2) {
        if (string == null) {
            return l2;
        }
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            return l2;
        }
    }

    public static float toFloat(String string) {
        return NumberUtils.toFloat(string, 0.0f);
    }

    public static float toFloat(String string, float f2) {
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            return f2;
        }
    }

    public static double toDouble(String string) {
        return NumberUtils.toDouble(string, 0.0);
    }

    public static double toDouble(String string, double d2) {
        if (string == null) {
            return d2;
        }
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException numberFormatException) {
            return d2;
        }
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return NumberUtils.toDouble(bigDecimal, 0.0);
    }

    public static double toDouble(BigDecimal bigDecimal, double d2) {
        return bigDecimal == null ? d2 : bigDecimal.doubleValue();
    }

    public static byte toByte(String string) {
        return NumberUtils.toByte(string, (byte)0);
    }

    public static byte toByte(String string, byte by2) {
        if (string == null) {
            return by2;
        }
        try {
            return Byte.parseByte(string);
        }
        catch (NumberFormatException numberFormatException) {
            return by2;
        }
    }

    public static short toShort(String string) {
        return NumberUtils.toShort(string, (short)0);
    }

    public static short toShort(String string, short s2) {
        if (string == null) {
            return s2;
        }
        try {
            return Short.parseShort(string);
        }
        catch (NumberFormatException numberFormatException) {
            return s2;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return NumberUtils.toScaledBigDecimal(bigDecimal, (int)INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int n2, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.setScale(n2, roundingMode == null ? RoundingMode.HALF_EVEN : roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Float f2) {
        return NumberUtils.toScaledBigDecimal(f2, (int)INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float f2, int n2, RoundingMode roundingMode) {
        if (f2 == null) {
            return BigDecimal.ZERO;
        }
        return NumberUtils.toScaledBigDecimal(BigDecimal.valueOf(f2.floatValue()), n2, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d2) {
        return NumberUtils.toScaledBigDecimal(d2, (int)INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d2, int n2, RoundingMode roundingMode) {
        if (d2 == null) {
            return BigDecimal.ZERO;
        }
        return NumberUtils.toScaledBigDecimal(BigDecimal.valueOf(d2), n2, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String string) {
        return NumberUtils.toScaledBigDecimal(string, (int)INTEGER_TWO, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String string, int n2, RoundingMode roundingMode) {
        if (string == null) {
            return BigDecimal.ZERO;
        }
        return NumberUtils.toScaledBigDecimal(NumberUtils.createBigDecimal(string), n2, roundingMode);
    }

    public static Number createNumber(String string) {
        String string2;
        String string3;
        String string4;
        if (string == null) {
            return null;
        }
        if (StringUtils.isBlank(string)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] stringArray = new String[]{"0x", "0X", "-0x", "-0X", "#", "-#"};
        int n2 = string.length();
        int n3 = 0;
        String[] stringArray2 = stringArray;
        int n4 = stringArray2.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            string4 = stringArray2[i2];
            if (!string.startsWith(string4)) continue;
            n3 += string4.length();
            break;
        }
        if (n3 > 0) {
            char c2 = '\u0000';
            for (n4 = n3; n4 < n2 && (c2 = string.charAt(n4)) == '0'; ++n4) {
                ++n3;
            }
            n4 = n2 - n3;
            if (n4 > 16 || n4 == 16 && c2 > '7') {
                return NumberUtils.createBigInteger(string);
            }
            if (n4 > 8 || n4 == 8 && c2 > '7') {
                return NumberUtils.createLong(string);
            }
            return NumberUtils.createInteger(string);
        }
        char c3 = string.charAt(n2 - 1);
        int n5 = string.indexOf(46);
        int n6 = string.indexOf(101) + string.indexOf(69) + 1;
        if (n5 > -1) {
            if (n6 > -1) {
                if (n6 < n5 || n6 > n2) {
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                string3 = string.substring(n5 + 1, n6);
            } else {
                string3 = string.substring(n5 + 1);
            }
            string2 = NumberUtils.getMantissa(string, n5);
        } else {
            if (n6 > -1) {
                if (n6 > n2) {
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                string2 = NumberUtils.getMantissa(string, n6);
            } else {
                string2 = NumberUtils.getMantissa(string);
            }
            string3 = null;
        }
        if (!Character.isDigit(c3) && c3 != '.') {
            string4 = n6 > -1 && n6 < n2 - 1 ? string.substring(n6 + 1, n2 - 1) : null;
            String string5 = string.substring(0, n2 - 1);
            boolean bl2 = NumberUtils.isAllZeros(string2) && NumberUtils.isAllZeros(string4);
            switch (c3) {
                case 'L': 
                case 'l': {
                    if (string3 == null && string4 == null && (!string5.isEmpty() && string5.charAt(0) == '-' && NumberUtils.isDigits(string5.substring(1)) || NumberUtils.isDigits(string5))) {
                        try {
                            return NumberUtils.createLong(string5);
                        }
                        catch (NumberFormatException numberFormatException) {
                            return NumberUtils.createBigInteger(string5);
                        }
                    }
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                case 'F': 
                case 'f': {
                    Number number;
                    try {
                        number = NumberUtils.createFloat(string);
                        if (!((Float)number).isInfinite() && (((Float)number).floatValue() != 0.0f || bl2)) {
                            return number;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
                case 'D': 
                case 'd': {
                    Number number;
                    try {
                        number = NumberUtils.createDouble(string);
                        if (!((Double)number).isInfinite() && ((Double)number != 0.0 || bl2)) {
                            return number;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                    try {
                        return NumberUtils.createBigDecimal(string5);
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
            }
            throw new NumberFormatException(string + " is not a valid number.");
        }
        string4 = n6 > -1 && n6 < n2 - 1 ? string.substring(n6 + 1) : null;
        if (string3 == null && string4 == null) {
            try {
                return NumberUtils.createInteger(string);
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    return NumberUtils.createLong(string);
                }
                catch (NumberFormatException numberFormatException2) {
                    return NumberUtils.createBigInteger(string);
                }
            }
        }
        boolean bl3 = NumberUtils.isAllZeros(string2) && NumberUtils.isAllZeros(string4);
        try {
            Float f2 = NumberUtils.createFloat(string);
            Double d2 = NumberUtils.createDouble(string);
            if (!f2.isInfinite() && (f2.floatValue() != 0.0f || bl3) && f2.toString().equals(d2.toString())) {
                return f2;
            }
            if (!d2.isInfinite() && (d2 != 0.0 || bl3)) {
                BigDecimal bigDecimal = NumberUtils.createBigDecimal(string);
                if (bigDecimal.compareTo(BigDecimal.valueOf(d2)) == 0) {
                    return d2;
                }
                return bigDecimal;
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        return NumberUtils.createBigDecimal(string);
    }

    private static String getMantissa(String string) {
        return NumberUtils.getMantissa(string, string.length());
    }

    private static String getMantissa(String string, int n2) {
        char c2 = string.charAt(0);
        boolean bl2 = c2 == '-' || c2 == '+';
        return bl2 ? string.substring(1, n2) : string.substring(0, n2);
    }

    private static boolean isAllZeros(String string) {
        if (string == null) {
            return true;
        }
        for (int i2 = string.length() - 1; i2 >= 0; --i2) {
            if (string.charAt(i2) == '0') continue;
            return false;
        }
        return !string.isEmpty();
    }

    public static Float createFloat(String string) {
        if (string == null) {
            return null;
        }
        return Float.valueOf(string);
    }

    public static Double createDouble(String string) {
        if (string == null) {
            return null;
        }
        return Double.valueOf(string);
    }

    public static Integer createInteger(String string) {
        if (string == null) {
            return null;
        }
        return Integer.decode(string);
    }

    public static Long createLong(String string) {
        if (string == null) {
            return null;
        }
        return Long.decode(string);
    }

    public static BigInteger createBigInteger(String string) {
        if (string == null) {
            return null;
        }
        int n2 = 0;
        int n3 = 10;
        boolean bl2 = false;
        if (string.startsWith("-")) {
            bl2 = true;
            n2 = 1;
        }
        if (string.startsWith("0x", n2) || string.startsWith("0X", n2)) {
            n3 = 16;
            n2 += 2;
        } else if (string.startsWith("#", n2)) {
            n3 = 16;
            ++n2;
        } else if (string.startsWith("0", n2) && string.length() > n2 + 1) {
            n3 = 8;
            ++n2;
        }
        BigInteger bigInteger = new BigInteger(string.substring(n2), n3);
        return bl2 ? bigInteger.negate() : bigInteger;
    }

    public static BigDecimal createBigDecimal(String string) {
        if (string == null) {
            return null;
        }
        if (StringUtils.isBlank(string)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(string);
    }

    public static long min(long ... lArray) {
        NumberUtils.validateArray(lArray);
        long l2 = lArray[0];
        for (int i2 = 1; i2 < lArray.length; ++i2) {
            if (lArray[i2] >= l2) continue;
            l2 = lArray[i2];
        }
        return l2;
    }

    public static int min(int ... nArray) {
        NumberUtils.validateArray(nArray);
        int n2 = nArray[0];
        for (int i2 = 1; i2 < nArray.length; ++i2) {
            if (nArray[i2] >= n2) continue;
            n2 = nArray[i2];
        }
        return n2;
    }

    public static short min(short ... sArray) {
        NumberUtils.validateArray(sArray);
        short s2 = sArray[0];
        for (int i2 = 1; i2 < sArray.length; ++i2) {
            if (sArray[i2] >= s2) continue;
            s2 = sArray[i2];
        }
        return s2;
    }

    public static byte min(byte ... byArray) {
        NumberUtils.validateArray(byArray);
        byte by2 = byArray[0];
        for (int i2 = 1; i2 < byArray.length; ++i2) {
            if (byArray[i2] >= by2) continue;
            by2 = byArray[i2];
        }
        return by2;
    }

    public static double min(double ... dArray) {
        NumberUtils.validateArray(dArray);
        double d2 = dArray[0];
        for (int i2 = 1; i2 < dArray.length; ++i2) {
            if (Double.isNaN(dArray[i2])) {
                return Double.NaN;
            }
            if (!(dArray[i2] < d2)) continue;
            d2 = dArray[i2];
        }
        return d2;
    }

    public static float min(float ... fArray) {
        NumberUtils.validateArray(fArray);
        float f2 = fArray[0];
        for (int i2 = 1; i2 < fArray.length; ++i2) {
            if (Float.isNaN(fArray[i2])) {
                return Float.NaN;
            }
            if (!(fArray[i2] < f2)) continue;
            f2 = fArray[i2];
        }
        return f2;
    }

    public static long max(long ... lArray) {
        NumberUtils.validateArray(lArray);
        long l2 = lArray[0];
        for (int i2 = 1; i2 < lArray.length; ++i2) {
            if (lArray[i2] <= l2) continue;
            l2 = lArray[i2];
        }
        return l2;
    }

    public static int max(int ... nArray) {
        NumberUtils.validateArray(nArray);
        int n2 = nArray[0];
        for (int i2 = 1; i2 < nArray.length; ++i2) {
            if (nArray[i2] <= n2) continue;
            n2 = nArray[i2];
        }
        return n2;
    }

    public static short max(short ... sArray) {
        NumberUtils.validateArray(sArray);
        short s2 = sArray[0];
        for (int i2 = 1; i2 < sArray.length; ++i2) {
            if (sArray[i2] <= s2) continue;
            s2 = sArray[i2];
        }
        return s2;
    }

    public static byte max(byte ... byArray) {
        NumberUtils.validateArray(byArray);
        byte by2 = byArray[0];
        for (int i2 = 1; i2 < byArray.length; ++i2) {
            if (byArray[i2] <= by2) continue;
            by2 = byArray[i2];
        }
        return by2;
    }

    public static double max(double ... dArray) {
        NumberUtils.validateArray(dArray);
        double d2 = dArray[0];
        for (int i2 = 1; i2 < dArray.length; ++i2) {
            if (Double.isNaN(dArray[i2])) {
                return Double.NaN;
            }
            if (!(dArray[i2] > d2)) continue;
            d2 = dArray[i2];
        }
        return d2;
    }

    public static float max(float ... fArray) {
        NumberUtils.validateArray(fArray);
        float f2 = fArray[0];
        for (int i2 = 1; i2 < fArray.length; ++i2) {
            if (Float.isNaN(fArray[i2])) {
                return Float.NaN;
            }
            if (!(fArray[i2] > f2)) continue;
            f2 = fArray[i2];
        }
        return f2;
    }

    private static void validateArray(Object object) {
        Validate.notNull(object, "array", new Object[0]);
        Validate.isTrue(Array.getLength(object) != 0, "Array cannot be empty.", new Object[0]);
    }

    public static long min(long l2, long l3, long l4) {
        if (l3 < l2) {
            l2 = l3;
        }
        if (l4 < l2) {
            l2 = l4;
        }
        return l2;
    }

    public static int min(int n2, int n3, int n4) {
        if (n3 < n2) {
            n2 = n3;
        }
        if (n4 < n2) {
            n2 = n4;
        }
        return n2;
    }

    public static short min(short s2, short s3, short s4) {
        if (s3 < s2) {
            s2 = s3;
        }
        if (s4 < s2) {
            s2 = s4;
        }
        return s2;
    }

    public static byte min(byte by2, byte by3, byte by4) {
        if (by3 < by2) {
            by2 = by3;
        }
        if (by4 < by2) {
            by2 = by4;
        }
        return by2;
    }

    public static double min(double d2, double d3, double d4) {
        return Math.min(Math.min(d2, d3), d4);
    }

    public static float min(float f2, float f3, float f4) {
        return Math.min(Math.min(f2, f3), f4);
    }

    public static long max(long l2, long l3, long l4) {
        if (l3 > l2) {
            l2 = l3;
        }
        if (l4 > l2) {
            l2 = l4;
        }
        return l2;
    }

    public static int max(int n2, int n3, int n4) {
        if (n3 > n2) {
            n2 = n3;
        }
        if (n4 > n2) {
            n2 = n4;
        }
        return n2;
    }

    public static short max(short s2, short s3, short s4) {
        if (s3 > s2) {
            s2 = s3;
        }
        if (s4 > s2) {
            s2 = s4;
        }
        return s2;
    }

    public static byte max(byte by2, byte by3, byte by4) {
        if (by3 > by2) {
            by2 = by3;
        }
        if (by4 > by2) {
            by2 = by4;
        }
        return by2;
    }

    public static double max(double d2, double d3, double d4) {
        return Math.max(Math.max(d2, d3), d4);
    }

    public static float max(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    public static boolean isDigits(String string) {
        return StringUtils.isNumeric(string);
    }

    @Deprecated
    public static boolean isNumber(String string) {
        return NumberUtils.isCreatable(string);
    }

    public static boolean isCreatable(String string) {
        int n2;
        int n3;
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        char[] cArray = string.toCharArray();
        int n4 = cArray.length;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        int n5 = n3 = cArray[0] == '-' || cArray[0] == '+' ? 1 : 0;
        if (n4 > n3 + 1 && cArray[n3] == '0' && !StringUtils.contains((CharSequence)string, 46)) {
            if (cArray[n3 + 1] == 'x' || cArray[n3 + 1] == 'X') {
                int n6 = n3 + 2;
                if (n6 == n4) {
                    return false;
                }
                while (n6 < cArray.length) {
                    if (!(cArray[n6] >= '0' && cArray[n6] <= '9' || cArray[n6] >= 'a' && cArray[n6] <= 'f' || cArray[n6] >= 'A' && cArray[n6] <= 'F')) {
                        return false;
                    }
                    ++n6;
                }
                return true;
            }
            if (Character.isDigit(cArray[n3 + 1])) {
                for (int i2 = n3 + 1; i2 < cArray.length; ++i2) {
                    if (cArray[i2] >= '0' && cArray[i2] <= '7') continue;
                    return false;
                }
                return true;
            }
        }
        --n4;
        for (n2 = n3; n2 < n4 || n2 < n4 + 1 && bl4 && !bl5; ++n2) {
            if (cArray[n2] >= '0' && cArray[n2] <= '9') {
                bl5 = true;
                bl4 = false;
                continue;
            }
            if (cArray[n2] == '.') {
                if (bl3 || bl2) {
                    return false;
                }
                bl3 = true;
                continue;
            }
            if (cArray[n2] == 'e' || cArray[n2] == 'E') {
                if (bl2) {
                    return false;
                }
                if (!bl5) {
                    return false;
                }
                bl2 = true;
                bl4 = true;
                continue;
            }
            if (cArray[n2] == '+' || cArray[n2] == '-') {
                if (!bl4) {
                    return false;
                }
                bl4 = false;
                bl5 = false;
                continue;
            }
            return false;
        }
        if (n2 < cArray.length) {
            if (cArray[n2] >= '0' && cArray[n2] <= '9') {
                return true;
            }
            if (cArray[n2] == 'e' || cArray[n2] == 'E') {
                return false;
            }
            if (cArray[n2] == '.') {
                if (bl3 || bl2) {
                    return false;
                }
                return bl5;
            }
            if (!(bl4 || cArray[n2] != 'd' && cArray[n2] != 'D' && cArray[n2] != 'f' && cArray[n2] != 'F')) {
                return bl5;
            }
            if (cArray[n2] == 'l' || cArray[n2] == 'L') {
                return bl5 && !bl2 && !bl3;
            }
            return false;
        }
        return !bl4 && bl5;
    }

    public static boolean isParsable(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        if (string.charAt(string.length() - 1) == '.') {
            return false;
        }
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            return NumberUtils.withDecimalsParsing(string, 1);
        }
        return NumberUtils.withDecimalsParsing(string, 0);
    }

    private static boolean withDecimalsParsing(String string, int n2) {
        int n3 = 0;
        for (int i2 = n2; i2 < string.length(); ++i2) {
            boolean bl2;
            boolean bl3 = bl2 = string.charAt(i2) == '.';
            if (bl2) {
                ++n3;
            }
            if (n3 > 1) {
                return false;
            }
            if (bl2 || Character.isDigit(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static int compare(int n2, int n3) {
        if (n2 == n3) {
            return 0;
        }
        return n2 < n3 ? -1 : 1;
    }

    public static int compare(long l2, long l3) {
        if (l2 == l3) {
            return 0;
        }
        return l2 < l3 ? -1 : 1;
    }

    public static int compare(short s2, short s3) {
        if (s2 == s3) {
            return 0;
        }
        return s2 < s3 ? -1 : 1;
    }

    public static int compare(byte by2, byte by3) {
        return by2 - by3;
    }
}

