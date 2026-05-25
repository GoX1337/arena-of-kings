/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class beg
extends Writer {
    private final bdv var_bdv_a;
    private OutputStream var_java_io_OutputStream_a;
    private byte[] var_byte_arr_a;
    private final int var_int_a;
    private int b;
    private int c;

    public beg(bdv bdv2, OutputStream outputStream) {
        this.var_bdv_a = bdv2;
        this.var_java_io_OutputStream_a = outputStream;
        this.var_byte_arr_a = bdv2.byte_arr_b();
        this.var_int_a = this.var_byte_arr_a.length - 4;
        this.b = 0;
    }

    @Override
    public Writer append(char c2) {
        this.write(c2);
        return this;
    }

    @Override
    public void close() {
        if (this.var_java_io_OutputStream_a != null) {
            if (this.b > 0) {
                this.var_java_io_OutputStream_a.write(this.var_byte_arr_a, 0, this.b);
                this.b = 0;
            }
            OutputStream outputStream = this.var_java_io_OutputStream_a;
            this.var_java_io_OutputStream_a = null;
            byte[] byArray = this.var_byte_arr_a;
            if (byArray != null) {
                this.var_byte_arr_a = null;
                this.var_bdv_a.b(byArray);
            }
            outputStream.close();
            int n2 = this.c;
            this.c = 0;
            if (n2 > 0) {
                beg.void_a(n2);
            }
        }
    }

    @Override
    public void flush() {
        if (this.var_java_io_OutputStream_a != null) {
            if (this.b > 0) {
                this.var_java_io_OutputStream_a.write(this.var_byte_arr_a, 0, this.b);
                this.b = 0;
            }
            this.var_java_io_OutputStream_a.flush();
        }
    }

    @Override
    public void write(char[] cArray) {
        this.write(cArray, 0, cArray.length);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void write(char[] var1_1, int var2_2, int var3_3) {
        if (var3_3 < 2) {
            if (var3_3 == 1) {
                this.write(var1_1[var2_2]);
            }
            return;
        }
        if (this.c > 0) {
            var4_4 = var1_1[var2_2++];
            --var3_3;
            this.write(this.int_a(var4_4));
        }
        var4_4 = this.b;
        var5_5 = this.var_byte_arr_a;
        var6_6 = this.var_int_a;
        var3_3 += var2_2;
        block0: while (var2_2 < var3_3) {
            if (var4_4 >= var6_6) {
                this.var_java_io_OutputStream_a.write(var5_5, 0, var4_4);
                var4_4 = 0;
            }
            if ((var7_7 = var1_1[var2_2++]) >= 128) ** GOTO lbl28
            var5_5[var4_4++] = (byte)var7_7;
            var8_8 = var3_3 - var2_2;
            var9_9 = var6_6 - var4_4;
            if (var8_8 > var9_9) {
                var8_8 = var9_9;
            }
            var8_8 += var2_2;
            while (var2_2 < var8_8) {
                if ((var7_7 = var1_1[var2_2++]) < 128) {
                    var5_5[var4_4++] = (byte)var7_7;
                    continue;
                }
lbl28:
                // 3 sources

                if (var7_7 < 2048) {
                    var5_5[var4_4++] = (byte)(192 | var7_7 >> 6);
                    var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                    continue block0;
                }
                if (var7_7 < 55296 || var7_7 > 57343) {
                    var5_5[var4_4++] = (byte)(224 | var7_7 >> 12);
                    var5_5[var4_4++] = (byte)(128 | var7_7 >> 6 & 63);
                    var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                    continue block0;
                }
                if (var7_7 > 56319) {
                    this.b = var4_4;
                    beg.void_a(var7_7);
                }
                this.c = var7_7;
                if (var2_2 >= var3_3) break block0;
                if ((var7_7 = this.int_a(var1_1[var2_2++])) > 0x10FFFF) {
                    this.b = var4_4;
                    beg.void_a(var7_7);
                }
                var5_5[var4_4++] = (byte)(240 | var7_7 >> 18);
                var5_5[var4_4++] = (byte)(128 | var7_7 >> 12 & 63);
                var5_5[var4_4++] = (byte)(128 | var7_7 >> 6 & 63);
                var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                continue block0;
            }
        }
        this.b = var4_4;
    }

    @Override
    public void write(int n2) {
        if (this.c > 0) {
            n2 = this.int_a(n2);
        } else if (n2 >= 55296 && n2 <= 57343) {
            if (n2 > 56319) {
                beg.void_a(n2);
            }
            this.c = n2;
            return;
        }
        if (this.b >= this.var_int_a) {
            this.var_java_io_OutputStream_a.write(this.var_byte_arr_a, 0, this.b);
            this.b = 0;
        }
        if (n2 < 128) {
            this.var_byte_arr_a[this.b++] = (byte)n2;
        } else {
            int n3 = this.b;
            if (n2 < 2048) {
                this.var_byte_arr_a[n3++] = (byte)(0xC0 | n2 >> 6);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 & 0x3F);
            } else if (n2 <= 65535) {
                this.var_byte_arr_a[n3++] = (byte)(0xE0 | n2 >> 12);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 >> 6 & 0x3F);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 & 0x3F);
            } else {
                if (n2 > 0x10FFFF) {
                    beg.void_a(n2);
                }
                this.var_byte_arr_a[n3++] = (byte)(0xF0 | n2 >> 18);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 >> 12 & 0x3F);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 >> 6 & 0x3F);
                this.var_byte_arr_a[n3++] = (byte)(0x80 | n2 & 0x3F);
            }
            this.b = n3;
        }
    }

    @Override
    public void write(String string) {
        this.write(string, 0, string.length());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void write(String var1_1, int var2_2, int var3_3) {
        if (var3_3 < 2) {
            if (var3_3 == 1) {
                this.write(var1_1.charAt(var2_2));
            }
            return;
        }
        if (this.c > 0) {
            var4_4 = var1_1.charAt(var2_2++);
            --var3_3;
            this.write(this.int_a(var4_4));
        }
        var4_4 = this.b;
        var5_5 = this.var_byte_arr_a;
        var6_6 = this.var_int_a;
        var3_3 += var2_2;
        block0: while (var2_2 < var3_3) {
            if (var4_4 >= var6_6) {
                this.var_java_io_OutputStream_a.write(var5_5, 0, var4_4);
                var4_4 = 0;
            }
            if ((var7_7 = var1_1.charAt(var2_2++)) >= 128) ** GOTO lbl28
            var5_5[var4_4++] = (byte)var7_7;
            var8_8 = var3_3 - var2_2;
            var9_9 = var6_6 - var4_4;
            if (var8_8 > var9_9) {
                var8_8 = var9_9;
            }
            var8_8 += var2_2;
            while (var2_2 < var8_8) {
                if ((var7_7 = (int)var1_1.charAt(var2_2++)) < 128) {
                    var5_5[var4_4++] = (byte)var7_7;
                    continue;
                }
lbl28:
                // 3 sources

                if (var7_7 < 2048) {
                    var5_5[var4_4++] = (byte)(192 | var7_7 >> 6);
                    var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                    continue block0;
                }
                if (var7_7 < 55296 || var7_7 > 57343) {
                    var5_5[var4_4++] = (byte)(224 | var7_7 >> 12);
                    var5_5[var4_4++] = (byte)(128 | var7_7 >> 6 & 63);
                    var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                    continue block0;
                }
                if (var7_7 > 56319) {
                    this.b = var4_4;
                    beg.void_a(var7_7);
                }
                this.c = var7_7;
                if (var2_2 >= var3_3) break block0;
                if ((var7_7 = this.int_a(var1_1.charAt(var2_2++))) > 0x10FFFF) {
                    this.b = var4_4;
                    beg.void_a(var7_7);
                }
                var5_5[var4_4++] = (byte)(240 | var7_7 >> 18);
                var5_5[var4_4++] = (byte)(128 | var7_7 >> 12 & 63);
                var5_5[var4_4++] = (byte)(128 | var7_7 >> 6 & 63);
                var5_5[var4_4++] = (byte)(128 | var7_7 & 63);
                continue block0;
            }
        }
        this.b = var4_4;
    }

    protected int int_a(int n2) {
        int n3 = this.c;
        this.c = 0;
        if (n2 < 56320 || n2 > 57343) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(n3) + ", second 0x" + Integer.toHexString(n2) + "; illegal combination");
        }
        return 65536 + (n3 - 55296 << 10) + (n2 - 56320);
    }

    protected static void void_a(int n2) {
        throw new IOException(beg.java_lang_String_a(n2));
    }

    protected static String java_lang_String_a(int n2) {
        if (n2 > 0x10FFFF) {
            return "Illegal character point (0x" + Integer.toHexString(n2) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (n2 >= 55296) {
            if (n2 <= 56319) {
                return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(n2) + ")";
            }
            return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(n2) + ")";
        }
        return "Illegal character point (0x" + Integer.toHexString(n2) + ") to output";
    }
}

