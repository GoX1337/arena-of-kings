/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;

public final class bea {
    static final String a = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String b = String.valueOf(Long.MAX_VALUE);

    public static int int_a(char[] cArray, int n2, int n3) {
        int n4 = cArray[n2 + n3 - 1] - 48;
        switch (n3) {
            case 9: {
                n4 += (cArray[n2++] - 48) * 100000000;
            }
            case 8: {
                n4 += (cArray[n2++] - 48) * 10000000;
            }
            case 7: {
                n4 += (cArray[n2++] - 48) * 1000000;
            }
            case 6: {
                n4 += (cArray[n2++] - 48) * 100000;
            }
            case 5: {
                n4 += (cArray[n2++] - 48) * 10000;
            }
            case 4: {
                n4 += (cArray[n2++] - 48) * 1000;
            }
            case 3: {
                n4 += (cArray[n2++] - 48) * 100;
            }
            case 2: {
                n4 += (cArray[n2] - 48) * 10;
            }
        }
        return n4;
    }

    public static int int_a(String string) {
        char c2 = string.charAt(0);
        int n2 = string.length();
        boolean bl2 = c2 == '-';
        int n3 = 1;
        if (bl2) {
            if (n2 == 1 || n2 > 10) {
                return Integer.parseInt(string);
            }
            c2 = string.charAt(n3++);
        } else if (n2 > 9) {
            return Integer.parseInt(string);
        }
        if (c2 > '9' || c2 < '0') {
            return Integer.parseInt(string);
        }
        int n4 = c2 - 48;
        if (n3 < n2) {
            if ((c2 = string.charAt(n3++)) > '9' || c2 < '0') {
                return Integer.parseInt(string);
            }
            n4 = n4 * 10 + (c2 - 48);
            if (n3 < n2) {
                if ((c2 = string.charAt(n3++)) > '9' || c2 < '0') {
                    return Integer.parseInt(string);
                }
                n4 = n4 * 10 + (c2 - 48);
                if (n3 < n2) {
                    do {
                        if ((c2 = string.charAt(n3++)) > '9' || c2 < '0') {
                            return Integer.parseInt(string);
                        }
                        n4 = n4 * 10 + (c2 - 48);
                    } while (n3 < n2);
                }
            }
        }
        return bl2 ? -n4 : n4;
    }

    public static long long_a(char[] cArray, int n2, int n3) {
        int n4 = n3 - 9;
        long l2 = (long)bea.int_a(cArray, n2, n4) * 1000000000L;
        return l2 + (long)bea.int_a(cArray, n2 + n4, 9);
    }

    public static long long_a(String string) {
        int n2 = string.length();
        if (n2 <= 9) {
            return bea.int_a(string);
        }
        return Long.parseLong(string);
    }

    public static boolean a(char[] cArray, int n2, int n3, boolean bl2) {
        String string = bl2 ? a : b;
        int n4 = string.length();
        if (n3 < n4) {
            return true;
        }
        if (n3 > n4) {
            return false;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = cArray[n2 + i2] - string.charAt(i2);
            if (n5 == 0) continue;
            return n5 < 0;
        }
        return true;
    }

    public static boolean a(String string, boolean bl2) {
        String string2 = bl2 ? a : b;
        int n2 = string2.length();
        int n3 = string.length();
        if (n3 < n2) {
            return true;
        }
        if (n3 > n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = string.charAt(i2) - string2.charAt(i2);
            if (n4 == 0) continue;
            return n4 < 0;
        }
        return true;
    }

    public static int a(String string, int n2) {
        if (string == null) {
            return n2;
        }
        int n3 = (string = string.trim()).length();
        if (n3 == 0) {
            return n2;
        }
        int n4 = 0;
        char c2 = string.charAt(0);
        if (c2 == '+') {
            string = string.substring(1);
            n3 = string.length();
        } else if (c2 == '-') {
            n4 = 1;
        }
        while (n4 < n3) {
            char c3 = string.charAt(n4);
            if (c3 > '9' || c3 < '0') {
                try {
                    return (int)bea.double_a(string);
                }
                catch (NumberFormatException numberFormatException) {
                    return n2;
                }
            }
            ++n4;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
    }

    public static long a(String string, long l2) {
        if (string == null) {
            return l2;
        }
        int n2 = (string = string.trim()).length();
        if (n2 == 0) {
            return l2;
        }
        int n3 = 0;
        char c2 = string.charAt(0);
        if (c2 == '+') {
            string = string.substring(1);
            n2 = string.length();
        } else if (c2 == '-') {
            n3 = 1;
        }
        while (n3 < n2) {
            char c3 = string.charAt(n3);
            if (c3 > '9' || c3 < '0') {
                try {
                    return (long)bea.double_a(string);
                }
                catch (NumberFormatException numberFormatException) {
                    return l2;
                }
            }
            ++n3;
        }
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            return l2;
        }
    }

    public static double double_a(String string) {
        if ("2.2250738585072012e-308".equals(string)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(string);
    }

    public static BigDecimal java_math_BigDecimal_a(String string) {
        try {
            return new BigDecimal(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw bea.java_lang_NumberFormatException_a(string);
        }
    }

    public static BigDecimal a(char[] cArray) {
        return bea.java_math_BigDecimal_a(cArray, 0, cArray.length);
    }

    public static BigDecimal java_math_BigDecimal_a(char[] cArray, int n2, int n3) {
        try {
            return new BigDecimal(cArray, n2, n3);
        }
        catch (NumberFormatException numberFormatException) {
            throw bea.java_lang_NumberFormatException_a(new String(cArray, n2, n3));
        }
    }

    private static NumberFormatException java_lang_NumberFormatException_a(String string) {
        return new NumberFormatException("Value \"" + string + "\" can not be represented as BigDecimal");
    }
}

