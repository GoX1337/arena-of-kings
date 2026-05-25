/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Arrays;

public final class bcq
implements Serializable {
    private final transient int[] var_int_arr_a = new int[128];
    private final transient char[] var_char_arr_a = new char[64];
    private final transient byte[] var_byte_arr_a = new byte[64];
    final String var_java_lang_String_a;
    private final char var_char_a;
    private final int var_int_a;
    private final boolean var_boolean_a;
    private final a var_bcq$a_a;

    public bcq(String string, String string2, boolean bl2, char c2, int n2) {
        this.var_java_lang_String_a = string;
        this.var_boolean_a = bl2;
        this.var_char_a = c2;
        this.var_int_a = n2;
        int n3 = string2.length();
        if (n3 != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + n3 + ")");
        }
        string2.getChars(0, n3, this.var_char_arr_a, 0);
        Arrays.fill(this.var_int_arr_a, -1);
        int n4 = 0;
        while (n4 < n3) {
            char c3 = this.var_char_arr_a[n4];
            this.var_byte_arr_a[n4] = (byte)c3;
            this.var_int_arr_a[c3] = n4++;
        }
        if (bl2) {
            this.var_int_arr_a[c2] = -2;
        }
        this.var_bcq$a_a = bl2 ? bcq$a.b : bcq$a.var_bcq$a_a;
    }

    public bcq(bcq bcq2, String string, int n2) {
        this(bcq2, string, bcq2.var_boolean_a, bcq2.var_char_a, n2);
    }

    public bcq(bcq bcq2, String string, boolean bl2, char c2, int n2) {
        this(bcq2, string, bl2, c2, bcq2.var_bcq$a_a, n2);
    }

    private bcq(bcq bcq2, String string, boolean bl2, char c2, a a2, int n2) {
        this.var_java_lang_String_a = string;
        byte[] byArray = bcq2.var_byte_arr_a;
        System.arraycopy(byArray, 0, this.var_byte_arr_a, 0, byArray.length);
        char[] cArray = bcq2.var_char_arr_a;
        System.arraycopy(cArray, 0, this.var_char_arr_a, 0, cArray.length);
        int[] nArray = bcq2.var_int_arr_a;
        System.arraycopy(nArray, 0, this.var_int_arr_a, 0, nArray.length);
        this.var_boolean_a = bl2;
        this.var_char_a = c2;
        this.var_int_a = n2;
        this.var_bcq$a_a = a2;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public boolean boolean_b() {
        return this.var_bcq$a_a == bcq$a.b;
    }

    public boolean boolean_c() {
        return this.var_bcq$a_a != bcq$a.var_bcq$a_a;
    }

    public boolean boolean_a(char c2) {
        return c2 == this.var_char_a;
    }

    public boolean boolean_a(int n2) {
        return n2 == this.var_char_a;
    }

    public char char_a() {
        return this.var_char_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public int int_a(char c2) {
        char c3 = c2;
        return c3 <= '\u007f' ? this.var_int_arr_a[c3] : -1;
    }

    public int int_a(int n2) {
        return n2 <= 127 ? this.var_int_arr_a[n2] : -1;
    }

    public int a(int n2, char[] cArray, int n3) {
        cArray[n3++] = this.var_char_arr_a[n2 >> 18 & 0x3F];
        cArray[n3++] = this.var_char_arr_a[n2 >> 12 & 0x3F];
        cArray[n3++] = this.var_char_arr_a[n2 >> 6 & 0x3F];
        cArray[n3++] = this.var_char_arr_a[n2 & 0x3F];
        return n3;
    }

    public void a(StringBuilder stringBuilder, int n2) {
        stringBuilder.append(this.var_char_arr_a[n2 >> 18 & 0x3F]);
        stringBuilder.append(this.var_char_arr_a[n2 >> 12 & 0x3F]);
        stringBuilder.append(this.var_char_arr_a[n2 >> 6 & 0x3F]);
        stringBuilder.append(this.var_char_arr_a[n2 & 0x3F]);
    }

    public int a(int n2, int n3, char[] cArray, int n4) {
        cArray[n4++] = this.var_char_arr_a[n2 >> 18 & 0x3F];
        cArray[n4++] = this.var_char_arr_a[n2 >> 12 & 0x3F];
        if (this.boolean_a()) {
            cArray[n4++] = n3 == 2 ? this.var_char_arr_a[n2 >> 6 & 0x3F] : this.var_char_a;
            cArray[n4++] = this.var_char_a;
        } else if (n3 == 2) {
            cArray[n4++] = this.var_char_arr_a[n2 >> 6 & 0x3F];
        }
        return n4;
    }

    public void a(StringBuilder stringBuilder, int n2, int n3) {
        stringBuilder.append(this.var_char_arr_a[n2 >> 18 & 0x3F]);
        stringBuilder.append(this.var_char_arr_a[n2 >> 12 & 0x3F]);
        if (this.boolean_a()) {
            stringBuilder.append(n3 == 2 ? this.var_char_arr_a[n2 >> 6 & 0x3F] : this.var_char_a);
            stringBuilder.append(this.var_char_a);
        } else if (n3 == 2) {
            stringBuilder.append(this.var_char_arr_a[n2 >> 6 & 0x3F]);
        }
    }

    public int a(int n2, byte[] byArray, int n3) {
        byArray[n3++] = this.var_byte_arr_a[n2 >> 18 & 0x3F];
        byArray[n3++] = this.var_byte_arr_a[n2 >> 12 & 0x3F];
        byArray[n3++] = this.var_byte_arr_a[n2 >> 6 & 0x3F];
        byArray[n3++] = this.var_byte_arr_a[n2 & 0x3F];
        return n3;
    }

    public int a(int n2, int n3, byte[] byArray, int n4) {
        byArray[n4++] = this.var_byte_arr_a[n2 >> 18 & 0x3F];
        byArray[n4++] = this.var_byte_arr_a[n2 >> 12 & 0x3F];
        if (this.boolean_a()) {
            byte by2 = (byte)this.var_char_a;
            byArray[n4++] = n3 == 2 ? this.var_byte_arr_a[n2 >> 6 & 0x3F] : by2;
            byArray[n4++] = by2;
        } else if (n3 == 2) {
            byArray[n4++] = this.var_byte_arr_a[n2 >> 6 & 0x3F];
        }
        return n4;
    }

    public String a(byte[] byArray) {
        return this.a(byArray, false);
    }

    public String a(byte[] byArray, boolean bl2) {
        int n2;
        int n3 = byArray.length;
        StringBuilder stringBuilder = new StringBuilder(n3 + (n3 >> 2) + (n3 >> 3));
        if (bl2) {
            stringBuilder.append('\"');
        }
        int n4 = this.int_a() >> 2;
        int n5 = 0;
        int n6 = n3 - 3;
        while (n5 <= n6) {
            n2 = byArray[n5++] << 8;
            n2 |= byArray[n5++] & 0xFF;
            n2 = n2 << 8 | byArray[n5++] & 0xFF;
            this.a(stringBuilder, n2);
            if (--n4 > 0) continue;
            stringBuilder.append('\\');
            stringBuilder.append('n');
            n4 = this.int_a() >> 2;
        }
        n2 = n3 - n5;
        if (n2 > 0) {
            int n7 = byArray[n5++] << 16;
            if (n2 == 2) {
                n7 |= (byArray[n5++] & 0xFF) << 8;
            }
            this.a(stringBuilder, n7, n2);
        }
        if (bl2) {
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public byte[] a(String string) {
        bex bex2 = new bex();
        this.a(string, bex2);
        return bex2.byte_arr_a();
    }

    public void a(String string, bex bex2) {
        int n2 = 0;
        int n3 = string.length();
        while (n2 < n3) {
            char c2;
            if ((c2 = string.charAt(n2++)) <= ' ') continue;
            int n4 = this.int_a(c2);
            if (n4 < 0) {
                this.a(c2, 0, null);
            }
            int n5 = n4;
            if (n2 >= n3) {
                this.void_a();
            }
            if ((n4 = this.int_a(c2 = string.charAt(n2++))) < 0) {
                this.a(c2, 1, null);
            }
            n5 = n5 << 6 | n4;
            if (n2 >= n3) {
                if (!this.boolean_b()) {
                    bex2.void_a(n5 >>= 4);
                    break;
                }
                this.void_a();
            }
            if ((n4 = this.int_a(c2 = string.charAt(n2++))) < 0) {
                if (n4 != -2) {
                    this.a(c2, 2, null);
                }
                if (!this.boolean_c()) {
                    this.void_b();
                }
                if (n2 >= n3) {
                    this.void_a();
                }
                if (!this.boolean_a(c2 = string.charAt(n2++))) {
                    this.a(c2, 3, "expected padding character '" + this.char_a() + "'");
                }
                bex2.void_a(n5 >>= 4);
                continue;
            }
            n5 = n5 << 6 | n4;
            if (n2 >= n3) {
                if (!this.boolean_b()) {
                    bex2.b(n5 >>= 2);
                    break;
                }
                this.void_a();
            }
            if ((n4 = this.int_a(c2 = string.charAt(n2++))) < 0) {
                if (n4 != -2) {
                    this.a(c2, 3, null);
                }
                if (!this.boolean_c()) {
                    this.void_b();
                }
                bex2.b(n5 >>= 2);
                continue;
            }
            n5 = n5 << 6 | n4;
            bex2.c(n5);
        }
    }

    public String toString() {
        return this.var_java_lang_String_a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        bcq bcq2 = (bcq)object;
        return bcq2.var_char_a == this.var_char_a && bcq2.var_int_a == this.var_int_a && bcq2.var_boolean_a == this.var_boolean_a && bcq2.var_bcq$a_a == this.var_bcq$a_a && this.var_java_lang_String_a.equals(bcq2.var_java_lang_String_a);
    }

    public int hashCode() {
        return this.var_java_lang_String_a.hashCode();
    }

    protected void a(char c2, int n2, String string) {
        String string2 = c2 <= ' ' ? "Illegal white space character (code 0x" + Integer.toHexString(c2) + ") as character #" + (n2 + 1) + " of 4-char base64 unit: can only used between units" : (this.boolean_a(c2) ? "Unexpected padding character ('" + this.char_a() + "') as character #" + (n2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(c2) || Character.isISOControl(c2) ? "Illegal character (code 0x" + Integer.toHexString(c2) + ") in base64 content" : "Illegal character '" + c2 + "' (code 0x" + Integer.toHexString(c2) + ") in base64 content"));
        if (string != null) {
            string2 = string2 + ": " + string;
        }
        throw new IllegalArgumentException(string2);
    }

    protected void void_a() {
        throw new IllegalArgumentException(this.java_lang_String_c());
    }

    protected void void_b() {
        throw new IllegalArgumentException(this.java_lang_String_b());
    }

    protected String java_lang_String_b() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", this.java_lang_String_a());
    }

    public String java_lang_String_c() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", this.java_lang_String_a(), Character.valueOf(this.char_a()));
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bcq$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        private static final /* synthetic */ a[] var_bcq$a_arr_a;

        public static a[] values() {
            return (a[])var_bcq$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bcq$a_a = new a();
            b = new a();
            c = new a();
            var_bcq$a_arr_a = new a[]{var_bcq$a_a, b, c};
        }
    }
}

