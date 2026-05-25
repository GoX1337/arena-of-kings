/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public final class bdt {
    protected static final char[] var_char_arr_a;
    protected static final byte[] var_byte_arr_a;
    protected static final int[] var_int_arr_a;
    protected static final int[] b;
    protected static final int[] c;
    protected static final int[] d;
    protected static final int[] e;
    protected static final int[] f;
    protected static final int[] g;
    protected static final int[] h;

    public static int[] int_arr_a() {
        return var_int_arr_a;
    }

    public static int[] b() {
        return b;
    }

    public static int[] c() {
        return c;
    }

    public static int[] d() {
        return d;
    }

    public static int[] e() {
        return e;
    }

    public static int[] f() {
        return g;
    }

    public static int[] int_arr_a(int n2) {
        if (n2 == 34) {
            return g;
        }
        return bdt$a.var_bdt$a_a.a(n2);
    }

    public static int int_a(int n2) {
        return h[n2 & 0xFF];
    }

    public static void a(StringBuilder stringBuilder, String string) {
        int[] nArray = g;
        int n2 = nArray.length;
        int n3 = string.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 >= n2 || nArray[c2] == 0) {
                stringBuilder.append(c2);
                continue;
            }
            stringBuilder.append('\\');
            int n4 = nArray[c2];
            if (n4 < 0) {
                stringBuilder.append('u');
                stringBuilder.append('0');
                stringBuilder.append('0');
                char c3 = c2;
                stringBuilder.append(var_char_arr_a[c3 >> 4]);
                stringBuilder.append(var_char_arr_a[c3 & 0xF]);
                continue;
            }
            stringBuilder.append((char)n4);
        }
    }

    public static char[] char_arr_a() {
        return (char[])var_char_arr_a.clone();
    }

    public static byte[] byte_arr_a() {
        return (byte[])var_byte_arr_a.clone();
    }

    static {
        int n2;
        int n3;
        var_char_arr_a = "0123456789ABCDEF".toCharArray();
        int n4 = var_char_arr_a.length;
        var_byte_arr_a = new byte[n4];
        for (n3 = 0; n3 < n4; ++n3) {
            bdt.var_byte_arr_a[n3] = (byte)var_char_arr_a[n3];
        }
        int[] nArray = new int[256];
        for (n3 = 0; n3 < 32; ++n3) {
            nArray[n3] = -1;
        }
        nArray[34] = 1;
        nArray[92] = 1;
        var_int_arr_a = nArray;
        nArray = new int[var_int_arr_a.length];
        System.arraycopy(var_int_arr_a, 0, nArray, 0, nArray.length);
        for (n3 = 128; n3 < 256; ++n3) {
            int n5 = (n3 & 0xE0) == 192 ? 2 : ((n3 & 0xF0) == 224 ? 3 : ((n3 & 0xF8) == 240 ? 4 : -1));
            nArray[n3] = n5;
        }
        b = nArray;
        nArray = new int[256];
        Arrays.fill(nArray, -1);
        for (n3 = 33; n3 < 256; ++n3) {
            if (!Character.isJavaIdentifierPart((char)n3)) continue;
            nArray[n3] = 0;
        }
        nArray[64] = 0;
        nArray[35] = 0;
        nArray[42] = 0;
        nArray[45] = 0;
        nArray[43] = 0;
        c = nArray;
        nArray = new int[256];
        System.arraycopy(c, 0, nArray, 0, nArray.length);
        Arrays.fill(nArray, 128, 128, 0);
        d = nArray;
        nArray = new int[256];
        System.arraycopy(b, 128, nArray, 128, 128);
        Arrays.fill(nArray, 0, 32, -1);
        nArray[9] = 0;
        nArray[10] = 10;
        nArray[13] = 13;
        nArray[42] = 42;
        e = nArray;
        nArray = new int[256];
        System.arraycopy(b, 128, nArray, 128, 128);
        Arrays.fill(nArray, 0, 32, -1);
        nArray[32] = 1;
        nArray[9] = 1;
        nArray[10] = 10;
        nArray[13] = 13;
        nArray[47] = 47;
        nArray[35] = 35;
        f = nArray;
        nArray = new int[128];
        for (n3 = 0; n3 < 32; ++n3) {
            nArray[n3] = -1;
        }
        nArray[34] = 34;
        nArray[92] = 92;
        nArray[8] = 98;
        nArray[9] = 116;
        nArray[12] = 102;
        nArray[10] = 110;
        nArray[13] = 114;
        g = nArray;
        h = new int[256];
        Arrays.fill(h, -1);
        for (n2 = 0; n2 < 10; ++n2) {
            bdt.h[48 + n2] = n2;
        }
        for (n2 = 0; n2 < 6; ++n2) {
            bdt.h[97 + n2] = 10 + n2;
            bdt.h[65 + n2] = 10 + n2;
        }
    }

    static class a {
        public static final a var_bdt$a_a;
        private int[][] var_int_arr_arr_a = new int[128][];

        private a() {
        }

        public int[] a(int n2) {
            int[] nArray = this.var_int_arr_arr_a[n2];
            if (nArray == null) {
                nArray = Arrays.copyOf(g, 128);
                if (nArray[n2] == 0) {
                    nArray[n2] = -1;
                }
                this.var_int_arr_arr_a[n2] = nArray;
            }
            return nArray;
        }

        static {
            var_bdt$a_a = new a();
        }
    }
}

