/*
 * Decompiled with CFR 0.152.
 */
public final class beb {
    private static int var_int_a;
    private static int var_int_b;
    private static long var_long_a;
    private static long var_long_b;
    private static long c;
    static final String var_java_lang_String_a;
    static final String var_java_lang_String_b;
    private static final int[] var_int_arr_a;
    private static final String[] var_java_lang_String_arr_a;
    private static final String[] var_java_lang_String_arr_b;

    public static int a(int n2, char[] cArray, int n3) {
        if (n2 < 0) {
            if (n2 == Integer.MIN_VALUE) {
                return beb.b(cArray, n3);
            }
            cArray[n3++] = 45;
            n2 = -n2;
        }
        if (n2 < var_int_a) {
            if (n2 < 1000) {
                if (n2 < 10) {
                    cArray[n3] = (char)(48 + n2);
                    return n3 + 1;
                }
                return beb.d(n2, cArray, n3);
            }
            int n4 = n2 / 1000;
            n3 = beb.d(n4, cArray, n3);
            n3 = beb.e(n2 -= n4 * 1000, cArray, n3);
            return n3;
        }
        if (n2 >= var_int_b) {
            if ((n2 -= var_int_b) >= var_int_b) {
                n2 -= var_int_b;
                cArray[n3++] = 50;
            } else {
                cArray[n3++] = 49;
            }
            return beb.c(n2, cArray, n3);
        }
        int n5 = n2 / 1000;
        int n6 = n2 - n5 * 1000;
        n2 = n5;
        int n7 = n2 - (n5 /= 1000) * 1000;
        n3 = beb.d(n5, cArray, n3);
        n3 = beb.e(n7, cArray, n3);
        return beb.e(n6, cArray, n3);
    }

    public static int a(int n2, byte[] byArray, int n3) {
        if (n2 < 0) {
            if (n2 == Integer.MIN_VALUE) {
                return beb.b(byArray, n3);
            }
            byArray[n3++] = 45;
            n2 = -n2;
        }
        if (n2 < var_int_a) {
            if (n2 < 1000) {
                if (n2 < 10) {
                    byArray[n3++] = (byte)(48 + n2);
                } else {
                    n3 = beb.d(n2, byArray, n3);
                }
            } else {
                int n4 = n2 / 1000;
                n3 = beb.d(n4, byArray, n3);
                n3 = beb.e(n2 -= n4 * 1000, byArray, n3);
            }
            return n3;
        }
        if (n2 >= var_int_b) {
            if ((n2 -= var_int_b) >= var_int_b) {
                n2 -= var_int_b;
                byArray[n3++] = 50;
            } else {
                byArray[n3++] = 49;
            }
            return beb.c(n2, byArray, n3);
        }
        int n5 = n2 / 1000;
        int n6 = n2 - n5 * 1000;
        n2 = n5;
        int n7 = n2 - (n5 /= 1000) * 1000;
        n3 = beb.d(n5, byArray, n3);
        n3 = beb.e(n7, byArray, n3);
        return beb.e(n6, byArray, n3);
    }

    public static int a(long l2, char[] cArray, int n2) {
        if (l2 < 0L) {
            if (l2 > var_long_b) {
                return beb.a((int)l2, cArray, n2);
            }
            if (l2 == Long.MIN_VALUE) {
                return beb.a(cArray, n2);
            }
            cArray[n2++] = 45;
            l2 = -l2;
        } else if (l2 <= c) {
            return beb.a((int)l2, cArray, n2);
        }
        long l3 = l2 / var_long_a;
        l2 -= l3 * var_long_a;
        if (l3 < var_long_a) {
            n2 = beb.b((int)l3, cArray, n2);
        } else {
            long l4 = l3 / var_long_a;
            n2 = beb.d((int)l4, cArray, n2);
            n2 = beb.c((int)(l3 -= l4 * var_long_a), cArray, n2);
        }
        return beb.c((int)l2, cArray, n2);
    }

    public static int a(long l2, byte[] byArray, int n2) {
        if (l2 < 0L) {
            if (l2 > var_long_b) {
                return beb.a((int)l2, byArray, n2);
            }
            if (l2 == Long.MIN_VALUE) {
                return beb.a(byArray, n2);
            }
            byArray[n2++] = 45;
            l2 = -l2;
        } else if (l2 <= c) {
            return beb.a((int)l2, byArray, n2);
        }
        long l3 = l2 / var_long_a;
        l2 -= l3 * var_long_a;
        if (l3 < var_long_a) {
            n2 = beb.b((int)l3, byArray, n2);
        } else {
            long l4 = l3 / var_long_a;
            n2 = beb.d((int)l4, byArray, n2);
            n2 = beb.c((int)(l3 -= l4 * var_long_a), byArray, n2);
        }
        return beb.c((int)l2, byArray, n2);
    }

    public static boolean a(double d2) {
        return Double.isNaN(d2) || Double.isInfinite(d2);
    }

    public static boolean a(float f2) {
        return Float.isNaN(f2) || Float.isInfinite(f2);
    }

    private static int b(int n2, char[] cArray, int n3) {
        if (n2 < var_int_a) {
            if (n2 < 1000) {
                return beb.d(n2, cArray, n3);
            }
            int n4 = n2 / 1000;
            int n5 = n2 - n4 * 1000;
            return beb.a(cArray, n3, n4, n5);
        }
        int n6 = n2 / 1000;
        int n7 = n2 - n6 * 1000;
        int n8 = n6 / 1000;
        n3 = beb.d(n8, cArray, n3);
        int n9 = var_int_arr_a[n6 -= n8 * 1000];
        cArray[n3++] = (char)(n9 >> 16);
        cArray[n3++] = (char)(n9 >> 8 & 0x7F);
        cArray[n3++] = (char)(n9 & 0x7F);
        n9 = var_int_arr_a[n7];
        cArray[n3++] = (char)(n9 >> 16);
        cArray[n3++] = (char)(n9 >> 8 & 0x7F);
        cArray[n3++] = (char)(n9 & 0x7F);
        return n3;
    }

    private static int c(int n2, char[] cArray, int n3) {
        int n4 = n2 / 1000;
        int n5 = n2 - n4 * 1000;
        int n6 = n4 / 1000;
        int n7 = var_int_arr_a[n6];
        cArray[n3++] = (char)(n7 >> 16);
        cArray[n3++] = (char)(n7 >> 8 & 0x7F);
        cArray[n3++] = (char)(n7 & 0x7F);
        n7 = var_int_arr_a[n4 -= n6 * 1000];
        cArray[n3++] = (char)(n7 >> 16);
        cArray[n3++] = (char)(n7 >> 8 & 0x7F);
        cArray[n3++] = (char)(n7 & 0x7F);
        n7 = var_int_arr_a[n5];
        cArray[n3++] = (char)(n7 >> 16);
        cArray[n3++] = (char)(n7 >> 8 & 0x7F);
        cArray[n3++] = (char)(n7 & 0x7F);
        return n3;
    }

    private static int b(int n2, byte[] byArray, int n3) {
        if (n2 < var_int_a) {
            if (n2 < 1000) {
                return beb.d(n2, byArray, n3);
            }
            int n4 = n2 / 1000;
            int n5 = n2 - n4 * 1000;
            return beb.a(byArray, n3, n4, n5);
        }
        int n6 = n2 / 1000;
        int n7 = n2 - n6 * 1000;
        int n8 = n6 / 1000;
        n3 = beb.d(n8, byArray, n3);
        int n9 = var_int_arr_a[n6 -= n8 * 1000];
        byArray[n3++] = (byte)(n9 >> 16);
        byArray[n3++] = (byte)(n9 >> 8);
        byArray[n3++] = (byte)n9;
        n9 = var_int_arr_a[n7];
        byArray[n3++] = (byte)(n9 >> 16);
        byArray[n3++] = (byte)(n9 >> 8);
        byArray[n3++] = (byte)n9;
        return n3;
    }

    private static int c(int n2, byte[] byArray, int n3) {
        int n4 = n2 / 1000;
        int n5 = n2 - n4 * 1000;
        int n6 = n4 / 1000;
        int n7 = var_int_arr_a[n6];
        byArray[n3++] = (byte)(n7 >> 16);
        byArray[n3++] = (byte)(n7 >> 8);
        byArray[n3++] = (byte)n7;
        n7 = var_int_arr_a[n4 -= n6 * 1000];
        byArray[n3++] = (byte)(n7 >> 16);
        byArray[n3++] = (byte)(n7 >> 8);
        byArray[n3++] = (byte)n7;
        n7 = var_int_arr_a[n5];
        byArray[n3++] = (byte)(n7 >> 16);
        byArray[n3++] = (byte)(n7 >> 8);
        byArray[n3++] = (byte)n7;
        return n3;
    }

    private static int a(char[] cArray, int n2, int n3, int n4) {
        int n5 = var_int_arr_a[n3];
        if (n3 > 9) {
            if (n3 > 99) {
                cArray[n2++] = (char)(n5 >> 16);
            }
            cArray[n2++] = (char)(n5 >> 8 & 0x7F);
        }
        cArray[n2++] = (char)(n5 & 0x7F);
        n5 = var_int_arr_a[n4];
        cArray[n2++] = (char)(n5 >> 16);
        cArray[n2++] = (char)(n5 >> 8 & 0x7F);
        cArray[n2++] = (char)(n5 & 0x7F);
        return n2;
    }

    private static int a(byte[] byArray, int n2, int n3, int n4) {
        int n5 = var_int_arr_a[n3];
        if (n3 > 9) {
            if (n3 > 99) {
                byArray[n2++] = (byte)(n5 >> 16);
            }
            byArray[n2++] = (byte)(n5 >> 8);
        }
        byArray[n2++] = (byte)n5;
        n5 = var_int_arr_a[n4];
        byArray[n2++] = (byte)(n5 >> 16);
        byArray[n2++] = (byte)(n5 >> 8);
        byArray[n2++] = (byte)n5;
        return n2;
    }

    private static int d(int n2, char[] cArray, int n3) {
        int n4 = var_int_arr_a[n2];
        if (n2 > 9) {
            if (n2 > 99) {
                cArray[n3++] = (char)(n4 >> 16);
            }
            cArray[n3++] = (char)(n4 >> 8 & 0x7F);
        }
        cArray[n3++] = (char)(n4 & 0x7F);
        return n3;
    }

    private static int d(int n2, byte[] byArray, int n3) {
        int n4 = var_int_arr_a[n2];
        if (n2 > 9) {
            if (n2 > 99) {
                byArray[n3++] = (byte)(n4 >> 16);
            }
            byArray[n3++] = (byte)(n4 >> 8);
        }
        byArray[n3++] = (byte)n4;
        return n3;
    }

    private static int e(int n2, char[] cArray, int n3) {
        int n4 = var_int_arr_a[n2];
        cArray[n3++] = (char)(n4 >> 16);
        cArray[n3++] = (char)(n4 >> 8 & 0x7F);
        cArray[n3++] = (char)(n4 & 0x7F);
        return n3;
    }

    private static int e(int n2, byte[] byArray, int n3) {
        int n4 = var_int_arr_a[n2];
        byArray[n3++] = (byte)(n4 >> 16);
        byArray[n3++] = (byte)(n4 >> 8);
        byArray[n3++] = (byte)n4;
        return n3;
    }

    private static int a(char[] cArray, int n2) {
        int n3 = var_java_lang_String_b.length();
        var_java_lang_String_b.getChars(0, n3, cArray, n2);
        return n2 + n3;
    }

    private static int a(byte[] byArray, int n2) {
        int n3 = var_java_lang_String_b.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            byArray[n2++] = (byte)var_java_lang_String_b.charAt(i2);
        }
        return n2;
    }

    private static int b(char[] cArray, int n2) {
        int n3 = var_java_lang_String_a.length();
        var_java_lang_String_a.getChars(0, n3, cArray, n2);
        return n2 + n3;
    }

    private static int b(byte[] byArray, int n2) {
        int n3 = var_java_lang_String_a.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            byArray[n2++] = (byte)var_java_lang_String_a.charAt(i2);
        }
        return n2;
    }

    static {
        var_int_a = 1000000;
        var_int_b = 1000000000;
        var_long_a = 1000000000L;
        var_long_b = Integer.MIN_VALUE;
        c = Integer.MAX_VALUE;
        var_java_lang_String_a = String.valueOf(Integer.MIN_VALUE);
        var_java_lang_String_b = String.valueOf(Long.MIN_VALUE);
        var_int_arr_a = new int[1000];
        int n2 = 0;
        for (int i2 = 0; i2 < 10; ++i2) {
            for (int i3 = 0; i3 < 10; ++i3) {
                for (int i4 = 0; i4 < 10; ++i4) {
                    int n3 = i2 + 48 << 16 | i3 + 48 << 8 | i4 + 48;
                    beb.var_int_arr_a[n2++] = n3;
                }
            }
        }
        var_java_lang_String_arr_a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        var_java_lang_String_arr_b = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }
}

