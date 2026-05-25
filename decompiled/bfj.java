/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class bfj {
    static final char[] var_char_arr_a;
    private final bev var_bev_a;
    private char[] var_char_arr_b;
    private int var_int_a;
    private int var_int_b;
    private ArrayList<char[]> var_java_util_ArrayList_char_arr__a;
    private boolean var_boolean_a;
    private int var_int_c;
    private char[] var_char_arr_c;
    private int var_int_d;
    private String var_java_lang_String_a;
    private char[] var_char_arr_d;

    public bfj(bev bev2) {
        this.var_bev_a = bev2;
    }

    protected bfj(bev bev2, char[] cArray) {
        this.var_bev_a = bev2;
        this.var_char_arr_c = cArray;
        this.var_int_d = cArray.length;
        this.var_int_a = -1;
    }

    public static bfj a(char[] cArray) {
        return new bfj(null, cArray);
    }

    public void void_a() {
        this.var_int_a = -1;
        this.var_int_d = 0;
        this.var_int_b = 0;
        this.var_char_arr_b = null;
        this.var_char_arr_d = null;
        if (this.var_boolean_a) {
            this.void_b();
        }
        if (this.var_bev_a != null && this.var_char_arr_c != null) {
            char[] cArray = this.var_char_arr_c;
            this.var_char_arr_c = null;
            this.var_bev_a.a(2, cArray);
        }
    }

    public void a(char[] cArray, int n2, int n3) {
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        this.var_char_arr_b = cArray;
        this.var_int_a = n2;
        this.var_int_b = n3;
        if (this.var_boolean_a) {
            this.void_b();
        }
    }

    public void b(char[] cArray, int n2, int n3) {
        this.var_char_arr_b = null;
        this.var_int_a = -1;
        this.var_int_b = 0;
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        if (this.var_boolean_a) {
            this.void_b();
        } else if (this.var_char_arr_c == null) {
            this.var_char_arr_c = this.char_arr_a(n3);
        }
        this.var_int_c = 0;
        this.var_int_d = 0;
        this.c(cArray, n2, n3);
    }

    public void a(String string) {
        this.var_char_arr_b = null;
        this.var_int_a = -1;
        this.var_int_b = 0;
        this.var_java_lang_String_a = string;
        this.var_char_arr_d = null;
        if (this.var_boolean_a) {
            this.void_b();
        }
        this.var_int_d = 0;
    }

    private char[] char_arr_a(int n2) {
        if (this.var_bev_a != null) {
            return this.var_bev_a.char_arr_a(2, n2);
        }
        return new char[Math.max(n2, 500)];
    }

    private void void_b() {
        this.var_boolean_a = false;
        this.var_char_arr_a.clear();
        this.var_int_c = 0;
        this.var_int_d = 0;
    }

    public int int_a() {
        if (this.var_int_a >= 0) {
            return this.var_int_b;
        }
        if (this.var_char_arr_d != null) {
            return this.var_char_arr_d.length;
        }
        if (this.var_java_lang_String_a != null) {
            return this.var_java_lang_String_a.length();
        }
        return this.var_int_c + this.var_int_d;
    }

    public int int_b() {
        return this.var_int_a >= 0 ? this.var_int_a : 0;
    }

    public char[] char_arr_a() {
        if (this.var_int_a >= 0) {
            return this.var_char_arr_b;
        }
        if (this.var_char_arr_d != null) {
            return this.var_char_arr_d;
        }
        if (this.var_java_lang_String_a != null) {
            this.var_char_arr_d = this.var_java_lang_String_a.toCharArray();
            return this.var_char_arr_d;
        }
        if (!this.var_boolean_a) {
            return this.var_char_arr_c == null ? var_char_arr_a : this.var_char_arr_c;
        }
        return this.char_arr_b();
    }

    public String java_lang_String_a() {
        if (this.var_java_lang_String_a == null) {
            if (this.var_char_arr_d != null) {
                this.var_java_lang_String_a = new String(this.var_char_arr_d);
            } else if (this.var_int_a >= 0) {
                if (this.var_int_b < 1) {
                    this.var_java_lang_String_a = "";
                    return "";
                }
                this.var_java_lang_String_a = new String(this.var_char_arr_b, this.var_int_a, this.var_int_b);
            } else {
                int n2 = this.var_int_c;
                int n3 = this.var_int_d;
                if (n2 == 0) {
                    this.var_java_lang_String_a = n3 == 0 ? "" : new String(this.var_char_arr_c, 0, n3);
                } else {
                    StringBuilder stringBuilder = new StringBuilder(n2 + n3);
                    if (this.var_char_arr_a != null) {
                        int n4 = this.var_char_arr_a.size();
                        for (int i2 = 0; i2 < n4; ++i2) {
                            char[] cArray = (char[])this.var_char_arr_a.get(i2);
                            stringBuilder.append(cArray, 0, cArray.length);
                        }
                    }
                    stringBuilder.append(this.var_char_arr_c, 0, this.var_int_d);
                    this.var_java_lang_String_a = stringBuilder.toString();
                }
            }
        }
        return this.var_java_lang_String_a;
    }

    public char[] char_arr_b() {
        char[] cArray = this.var_char_arr_d;
        if (cArray == null) {
            this.var_char_arr_d = cArray = this.g();
        }
        return cArray;
    }

    public BigDecimal java_math_BigDecimal_a() {
        if (this.var_char_arr_d != null) {
            return bea.a(this.var_char_arr_d);
        }
        if (this.var_int_a >= 0 && this.var_char_arr_b != null) {
            return bea.java_math_BigDecimal_a(this.var_char_arr_b, this.var_int_a, this.var_int_b);
        }
        if (this.var_int_c == 0 && this.var_char_arr_c != null) {
            return bea.java_math_BigDecimal_a(this.var_char_arr_c, 0, this.var_int_d);
        }
        return bea.a(this.char_arr_b());
    }

    public double double_a() {
        return bea.double_a(this.java_lang_String_a());
    }

    public int int_a(boolean bl2) {
        if (this.var_int_a >= 0 && this.var_char_arr_b != null) {
            if (bl2) {
                return -bea.int_a(this.var_char_arr_b, this.var_int_a + 1, this.var_int_b - 1);
            }
            return bea.int_a(this.var_char_arr_b, this.var_int_a, this.var_int_b);
        }
        if (bl2) {
            return -bea.int_a(this.var_char_arr_c, 1, this.var_int_d - 1);
        }
        return bea.int_a(this.var_char_arr_c, 0, this.var_int_d);
    }

    public long long_a(boolean bl2) {
        if (this.var_int_a >= 0 && this.var_char_arr_b != null) {
            if (bl2) {
                return -bea.long_a(this.var_char_arr_b, this.var_int_a + 1, this.var_int_b - 1);
            }
            return bea.long_a(this.var_char_arr_b, this.var_int_a, this.var_int_b);
        }
        if (bl2) {
            return -bea.long_a(this.var_char_arr_c, 1, this.var_int_d - 1);
        }
        return bea.long_a(this.var_char_arr_c, 0, this.var_int_d);
    }

    public void a(char c2) {
        if (this.var_int_a >= 0) {
            this.void_b(16);
        }
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        char[] cArray = this.var_char_arr_c;
        if (this.var_int_d >= cArray.length) {
            this.c(1);
            cArray = this.var_char_arr_c;
        }
        cArray[this.var_int_d++] = c2;
    }

    public void c(char[] cArray, int n2, int n3) {
        int n4;
        if (this.var_int_a >= 0) {
            this.void_b(n3);
        }
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        char[] cArray2 = this.var_char_arr_c;
        int n5 = cArray2.length - this.var_int_d;
        if (n5 >= n3) {
            System.arraycopy(cArray, n2, cArray2, this.var_int_d, n3);
            this.var_int_d += n3;
            return;
        }
        if (n5 > 0) {
            System.arraycopy(cArray, n2, cArray2, this.var_int_d, n5);
            n2 += n5;
            n3 -= n5;
        }
        do {
            this.c(n3);
            n4 = Math.min(this.var_char_arr_c.length, n3);
            System.arraycopy(cArray, n2, this.var_char_arr_c, 0, n4);
            this.var_int_d += n4;
            n2 += n4;
        } while ((n3 -= n4) > 0);
    }

    public void a(String string, int n2, int n3) {
        int n4;
        if (this.var_int_a >= 0) {
            this.void_b(n3);
        }
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        char[] cArray = this.var_char_arr_c;
        int n5 = cArray.length - this.var_int_d;
        if (n5 >= n3) {
            string.getChars(n2, n2 + n3, cArray, this.var_int_d);
            this.var_int_d += n3;
            return;
        }
        if (n5 > 0) {
            string.getChars(n2, n2 + n5, cArray, this.var_int_d);
            n3 -= n5;
            n2 += n5;
        }
        do {
            this.c(n3);
            n4 = Math.min(this.var_char_arr_c.length, n3);
            string.getChars(n2, n2 + n4, this.var_char_arr_c, 0);
            this.var_int_d += n4;
            n2 += n4;
        } while ((n3 -= n4) > 0);
    }

    public char[] char_arr_c() {
        if (this.var_int_a >= 0) {
            this.void_b(1);
        } else {
            char[] cArray = this.var_char_arr_c;
            if (cArray == null) {
                this.var_char_arr_c = this.char_arr_a(0);
            } else if (this.var_int_d >= cArray.length) {
                this.c(1);
            }
        }
        return this.var_char_arr_c;
    }

    public char[] d() {
        char[] cArray;
        this.var_int_a = -1;
        this.var_int_d = 0;
        this.var_int_b = 0;
        this.var_char_arr_b = null;
        this.var_java_lang_String_a = null;
        this.var_char_arr_d = null;
        if (this.var_boolean_a) {
            this.void_b();
        }
        if ((cArray = this.var_char_arr_c) == null) {
            this.var_char_arr_c = cArray = this.char_arr_a(0);
        }
        return cArray;
    }

    public int int_c() {
        return this.var_int_d;
    }

    public void void_a(int n2) {
        this.var_int_d = n2;
    }

    public String java_lang_String_a(int n2) {
        String string;
        this.var_int_d = n2;
        if (this.var_int_c > 0) {
            return this.java_lang_String_a();
        }
        int n3 = this.var_int_d;
        this.var_java_lang_String_a = string = n3 == 0 ? "" : new String(this.var_char_arr_c, 0, n3);
        return string;
    }

    public char[] e() {
        if (this.var_char_arr_a == null) {
            this.var_char_arr_a = (char[])new ArrayList();
        }
        this.var_boolean_a = true;
        this.var_char_arr_a.add(this.var_char_arr_c);
        int n2 = this.var_char_arr_c.length;
        this.var_int_c += n2;
        this.var_int_d = 0;
        int n3 = n2 + (n2 >> 1);
        if (n3 < 500) {
            n3 = 500;
        } else if (n3 > 65536) {
            n3 = 65536;
        }
        char[] cArray = this.char_arr_b(n3);
        this.var_char_arr_c = cArray;
        return cArray;
    }

    public char[] f() {
        char[] cArray = this.var_char_arr_c;
        int n2 = cArray.length;
        int n3 = n2 + (n2 >> 1);
        if (n3 > 65536) {
            n3 = n2 + (n2 >> 2);
        }
        this.var_char_arr_c = Arrays.copyOf(cArray, n3);
        return this.var_char_arr_c;
    }

    public String toString() {
        return this.java_lang_String_a();
    }

    private void void_b(int n2) {
        int n3 = this.var_int_b;
        this.var_int_b = 0;
        char[] cArray = this.var_char_arr_b;
        this.var_char_arr_b = null;
        int n4 = this.var_int_a;
        this.var_int_a = -1;
        int n5 = n3 + n2;
        if (this.var_char_arr_c == null || n5 > this.var_char_arr_c.length) {
            this.var_char_arr_c = this.char_arr_a(n5);
        }
        if (n3 > 0) {
            System.arraycopy(cArray, n4, this.var_char_arr_c, 0, n3);
        }
        this.var_int_c = 0;
        this.var_int_d = n3;
    }

    private void c(int n2) {
        if (this.var_char_arr_a == null) {
            this.var_char_arr_a = (char[])new ArrayList();
        }
        char[] cArray = this.var_char_arr_c;
        this.var_boolean_a = true;
        this.var_char_arr_a.add(cArray);
        this.var_int_c += cArray.length;
        this.var_int_d = 0;
        int n3 = cArray.length;
        int n4 = n3 + (n3 >> 1);
        if (n4 < 500) {
            n4 = 500;
        } else if (n4 > 65536) {
            n4 = 65536;
        }
        this.var_char_arr_c = this.char_arr_b(n4);
    }

    private char[] g() {
        if (this.var_java_lang_String_a != null) {
            return this.var_java_lang_String_a.toCharArray();
        }
        if (this.var_int_a >= 0) {
            int n2 = this.var_int_b;
            if (n2 < 1) {
                return var_char_arr_a;
            }
            int n3 = this.var_int_a;
            if (n3 == 0) {
                return Arrays.copyOf(this.var_char_arr_b, n2);
            }
            return Arrays.copyOfRange(this.var_char_arr_b, n3, n3 + n2);
        }
        int n4 = this.int_a();
        if (n4 < 1) {
            return var_char_arr_a;
        }
        int n5 = 0;
        char[] cArray = this.char_arr_b(n4);
        if (this.var_char_arr_a != null) {
            int n6 = this.var_char_arr_a.size();
            for (int i2 = 0; i2 < n6; ++i2) {
                char[] cArray2 = (char[])this.var_char_arr_a.get(i2);
                int n7 = cArray2.length;
                System.arraycopy(cArray2, 0, cArray, n5, n7);
                n5 += n7;
            }
        }
        System.arraycopy(this.var_char_arr_c, 0, cArray, n5, this.var_int_d);
        return cArray;
    }

    private char[] char_arr_b(int n2) {
        return new char[n2];
    }

    static {
        var_char_arr_a = new char[0];
    }
}

