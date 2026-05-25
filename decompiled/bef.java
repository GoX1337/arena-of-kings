/*
 * Decompiled with CFR 0.152.
 */
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class bef
extends Reader {
    protected final bdv var_bdv_a;
    protected InputStream var_java_io_InputStream_a;
    protected byte[] var_byte_arr_a;
    protected int var_int_a;
    protected int var_int_b;
    protected final boolean var_boolean_a;
    protected char var_char_a = '\u0000';
    protected int c;
    protected int d;
    protected final boolean var_boolean_b;
    protected char[] var_char_arr_a;

    public bef(bdv bdv2, InputStream inputStream, byte[] byArray, int n2, int n3, boolean bl2) {
        this.var_bdv_a = bdv2;
        this.var_java_io_InputStream_a = inputStream;
        this.var_byte_arr_a = byArray;
        this.var_int_a = n2;
        this.var_int_b = n3;
        this.var_boolean_a = bl2;
        this.var_boolean_b = inputStream != null;
    }

    @Override
    public void close() {
        InputStream inputStream = this.var_java_io_InputStream_a;
        if (inputStream != null) {
            this.var_java_io_InputStream_a = null;
            this.a();
            inputStream.close();
        }
    }

    @Override
    public int read() {
        if (this.var_char_arr_a == null) {
            this.var_char_arr_a = new char[1];
        }
        if (this.read(this.var_char_arr_a, 0, 1) < 1) {
            return -1;
        }
        return this.var_char_arr_a[0];
    }

    @Override
    public int read(char[] cArray, int n2, int n3) {
        int n4;
        int n5;
        if (this.var_byte_arr_a == null) {
            return -1;
        }
        if (n3 < 1) {
            return n3;
        }
        if (n2 < 0 || n2 + n3 > cArray.length) {
            this.a(cArray, n2, n3);
        }
        int n6 = n2;
        int n7 = n3 + n2;
        if (this.var_char_a != '\u0000') {
            cArray[n6++] = this.var_char_a;
            this.var_char_a = '\u0000';
        } else {
            n5 = this.var_int_b - this.var_int_a;
            if (n5 < 4 && !this.a(n5)) {
                if (n5 == 0) {
                    return -1;
                }
                this.a(this.var_int_b - this.var_int_a, 4);
            }
        }
        n5 = this.var_int_b - 4;
        while (n6 < n7) {
            int n8;
            int n9;
            n4 = this.var_int_a;
            if (this.var_boolean_a) {
                n9 = this.var_byte_arr_a[n4] << 8 | this.var_byte_arr_a[n4 + 1] & 0xFF;
                n8 = (this.var_byte_arr_a[n4 + 2] & 0xFF) << 8 | this.var_byte_arr_a[n4 + 3] & 0xFF;
            } else {
                n8 = this.var_byte_arr_a[n4] & 0xFF | (this.var_byte_arr_a[n4 + 1] & 0xFF) << 8;
                n9 = this.var_byte_arr_a[n4 + 2] & 0xFF | this.var_byte_arr_a[n4 + 3] << 8;
            }
            this.var_int_a += 4;
            if (n9 != 0) {
                int n10 = (n9 &= 0xFFFF) - 1 << 16 | n8;
                if (n9 > 16) {
                    this.a(n10, n6 - n2, String.format(" (above 0x%08x)", 0x10FFFF));
                }
                cArray[n6++] = (char)(55296 + (n10 >> 10));
                n8 = 0xDC00 | n10 & 0x3FF;
                if (n6 >= n7) {
                    this.var_char_a = (char)n10;
                    break;
                }
            }
            cArray[n6++] = (char)n8;
            if (this.var_int_a <= n5) continue;
            break;
        }
        n4 = n6 - n2;
        this.c += n4;
        return n4;
    }

    private void a(int n2, int n3) {
        int n4 = this.d + n2;
        int n5 = this.c;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + n2 + ", needed " + n3 + ", at char #" + n5 + ", byte #" + n4 + ")");
    }

    private void a(int n2, int n3, String string) {
        int n4 = this.d + this.var_int_a - 1;
        int n5 = this.c + n3;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(n2) + string + " at char #" + n5 + ", byte #" + n4 + ")");
    }

    private boolean a(int n2) {
        int n3;
        this.d += this.var_int_b - n2;
        if (n2 > 0) {
            if (this.var_int_a > 0) {
                System.arraycopy(this.var_byte_arr_a, this.var_int_a, this.var_byte_arr_a, 0, n2);
                this.var_int_a = 0;
            }
            this.var_int_b = n2;
        } else {
            this.var_int_a = 0;
            int n4 = n3 = this.var_java_io_InputStream_a == null ? -1 : this.var_java_io_InputStream_a.read(this.var_byte_arr_a);
            if (n3 < 1) {
                this.var_int_b = 0;
                if (n3 < 0) {
                    if (this.var_boolean_b) {
                        this.a();
                    }
                    return false;
                }
                this.b();
            }
            this.var_int_b = n3;
        }
        while (this.var_int_b < 4) {
            int n5 = n3 = this.var_java_io_InputStream_a == null ? -1 : this.var_java_io_InputStream_a.read(this.var_byte_arr_a, this.var_int_b, this.var_byte_arr_a.length - this.var_int_b);
            if (n3 < 1) {
                if (n3 < 0) {
                    if (this.var_boolean_b) {
                        this.a();
                    }
                    this.a(this.var_int_b, 4);
                }
                this.b();
            }
            this.var_int_b += n3;
        }
        return true;
    }

    private void a() {
        byte[] byArray = this.var_byte_arr_a;
        if (byArray != null) {
            this.var_byte_arr_a = null;
            this.var_bdv_a.a(byArray);
        }
    }

    private void a(char[] cArray, int n2, int n3) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + n2 + "," + n3 + "), cbuf[" + cArray.length + "]");
    }

    private void b() {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}

