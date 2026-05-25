/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public final class bdy {
    private static final char[] var_char_arr_a;
    private static final byte[] var_byte_arr_a;
    private static final bdy var_bdy_a;

    public static bdy bdy_a() {
        return var_bdy_a;
    }

    public char[] char_arr_a(String string) {
        char[] cArray = new char[120];
        int[] nArray = bdt.f();
        int n2 = nArray.length;
        int n3 = 0;
        int n4 = string.length();
        bfj bfj2 = null;
        int n5 = 0;
        char[] cArray2 = null;
        block0: while (n3 < n4) {
            int n6;
            int n7;
            char c2;
            while ((c2 = string.charAt(n3)) >= n2 || nArray[c2] == 0) {
                if (n5 >= cArray.length) {
                    if (bfj2 == null) {
                        bfj2 = bfj.a(cArray);
                    }
                    cArray = bfj2.e();
                    n5 = 0;
                }
                cArray[n5++] = c2;
                if (++n3 < n4) continue;
                break block0;
            }
            if (cArray2 == null) {
                cArray2 = this.char_arr_a();
            }
            int n8 = n7 = (n6 = nArray[c2 = string.charAt(n3++)]) < 0 ? this.a(c2, cArray2) : this.b(n6, cArray2);
            if (n5 + n7 > cArray.length) {
                int n9 = cArray.length - n5;
                if (n9 > 0) {
                    System.arraycopy(cArray2, 0, cArray, n5, n9);
                }
                if (bfj2 == null) {
                    bfj2 = bfj.a(cArray);
                }
                cArray = bfj2.e();
                int n10 = n7 - n9;
                System.arraycopy(cArray2, n9, cArray, 0, n10);
                n5 = n10;
                continue;
            }
            System.arraycopy(cArray2, 0, cArray, n5, n7);
            n5 += n7;
        }
        if (bfj2 == null) {
            return Arrays.copyOfRange(cArray, 0, n5);
        }
        bfj2.void_a(n5);
        return bfj2.char_arr_b();
    }

    public byte[] byte_arr_a(String string) {
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        byte[] byArray = new byte[200];
        bex bex2 = null;
        block0: while (n2 < n3) {
            int n5;
            int[] nArray = bdt.f();
            while ((n5 = string.charAt(n2)) <= 127 && nArray[n5] == 0) {
                if (n4 >= byArray.length) {
                    if (bex2 == null) {
                        bex2 = bex.a(byArray, n4);
                    }
                    byArray = bex2.byte_arr_b();
                    n4 = 0;
                }
                byArray[n4++] = (byte)n5;
                if (++n2 < n3) continue;
                break block0;
            }
            if (bex2 == null) {
                bex2 = bex.a(byArray, n4);
            }
            if (n4 >= byArray.length) {
                byArray = bex2.byte_arr_b();
                n4 = 0;
            }
            if ((n5 = string.charAt(n2++)) <= 127) {
                int n6 = nArray[n5];
                n4 = this.a(n5, n6, bex2, n4);
                byArray = bex2.c();
                continue;
            }
            if (n5 <= 2047) {
                byArray[n4++] = (byte)(0xC0 | n5 >> 6);
                n5 = 0x80 | n5 & 0x3F;
            } else if (n5 < 55296 || n5 > 57343) {
                byArray[n4++] = (byte)(0xE0 | n5 >> 12);
                if (n4 >= byArray.length) {
                    byArray = bex2.byte_arr_b();
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                n5 = 0x80 | n5 & 0x3F;
            } else {
                if (n5 > 56319) {
                    bdy.a(n5);
                }
                if (n2 >= n3) {
                    bdy.a(n5);
                }
                if ((n5 = bdy.a(n5, string.charAt(n2++))) > 0x10FFFF) {
                    bdy.a(n5);
                }
                byArray[n4++] = (byte)(0xF0 | n5 >> 18);
                if (n4 >= byArray.length) {
                    byArray = bex2.byte_arr_b();
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n5 >> 12 & 0x3F);
                if (n4 >= byArray.length) {
                    byArray = bex2.byte_arr_b();
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n5 >> 6 & 0x3F);
                n5 = 0x80 | n5 & 0x3F;
            }
            if (n4 >= byArray.length) {
                byArray = bex2.byte_arr_b();
                n4 = 0;
            }
            byArray[n4++] = (byte)n5;
        }
        if (bex2 == null) {
            return Arrays.copyOfRange(byArray, 0, n4);
        }
        return bex2.byte_arr_a(n4);
    }

    public byte[] b(String string) {
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        byte[] byArray = new byte[200];
        int n5 = byArray.length;
        bex bex2 = null;
        block0: while (n2 < n3) {
            int n6 = string.charAt(n2++);
            while (n6 <= 127) {
                if (n4 >= n5) {
                    if (bex2 == null) {
                        bex2 = bex.a(byArray, n4);
                    }
                    byArray = bex2.byte_arr_b();
                    n5 = byArray.length;
                    n4 = 0;
                }
                byArray[n4++] = (byte)n6;
                if (n2 >= n3) break block0;
                n6 = string.charAt(n2++);
            }
            if (bex2 == null) {
                bex2 = bex.a(byArray, n4);
            }
            if (n4 >= n5) {
                byArray = bex2.byte_arr_b();
                n5 = byArray.length;
                n4 = 0;
            }
            if (n6 < 2048) {
                byArray[n4++] = (byte)(0xC0 | n6 >> 6);
            } else if (n6 < 55296 || n6 > 57343) {
                byArray[n4++] = (byte)(0xE0 | n6 >> 12);
                if (n4 >= n5) {
                    byArray = bex2.byte_arr_b();
                    n5 = byArray.length;
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n6 >> 6 & 0x3F);
            } else {
                if (n6 > 56319) {
                    bdy.a(n6);
                }
                if (n2 >= n3) {
                    bdy.a(n6);
                }
                if ((n6 = bdy.a(n6, string.charAt(n2++))) > 0x10FFFF) {
                    bdy.a(n6);
                }
                byArray[n4++] = (byte)(0xF0 | n6 >> 18);
                if (n4 >= n5) {
                    byArray = bex2.byte_arr_b();
                    n5 = byArray.length;
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n6 >> 12 & 0x3F);
                if (n4 >= n5) {
                    byArray = bex2.byte_arr_b();
                    n5 = byArray.length;
                    n4 = 0;
                }
                byArray[n4++] = (byte)(0x80 | n6 >> 6 & 0x3F);
            }
            if (n4 >= n5) {
                byArray = bex2.byte_arr_b();
                n5 = byArray.length;
                n4 = 0;
            }
            byArray[n4++] = (byte)(0x80 | n6 & 0x3F);
        }
        if (bex2 == null) {
            return Arrays.copyOfRange(byArray, 0, n4);
        }
        return bex2.byte_arr_a(n4);
    }

    private char[] char_arr_a() {
        char[] cArray = new char[6];
        cArray[0] = 92;
        cArray[2] = 48;
        cArray[3] = 48;
        return cArray;
    }

    private int a(int n2, char[] cArray) {
        cArray[1] = 117;
        cArray[4] = var_char_arr_a[n2 >> 4];
        cArray[5] = var_char_arr_a[n2 & 0xF];
        return 6;
    }

    private int b(int n2, char[] cArray) {
        cArray[1] = (char)n2;
        return 2;
    }

    private int a(int n2, int n3, bex bex2, int n4) {
        bex2.d(n4);
        bex2.void_a(92);
        if (n3 < 0) {
            bex2.void_a(117);
            if (n2 > 255) {
                int n5 = n2 >> 8;
                bex2.void_a(var_byte_arr_a[n5 >> 4]);
                bex2.void_a(var_byte_arr_a[n5 & 0xF]);
                n2 &= 0xFF;
            } else {
                bex2.void_a(48);
                bex2.void_a(48);
            }
            bex2.void_a(var_byte_arr_a[n2 >> 4]);
            bex2.void_a(var_byte_arr_a[n2 & 0xF]);
        } else {
            bex2.void_a((byte)n3);
        }
        return bex2.int_a();
    }

    private static int a(int n2, int n3) {
        if (n3 < 56320 || n3 > 57343) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(n2) + ", second 0x" + Integer.toHexString(n3) + "; illegal combination");
        }
        return 65536 + (n2 - 55296 << 10) + (n3 - 56320);
    }

    private static void a(int n2) {
        throw new IllegalArgumentException(beg.java_lang_String_a(n2));
    }

    static {
        var_char_arr_a = bdt.char_arr_a();
        var_byte_arr_a = bdt.byte_arr_a();
        var_bdy_a = new bdy();
    }
}

