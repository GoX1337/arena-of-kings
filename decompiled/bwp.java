/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;

public final class bwp {
    static byte var_byte_a;
    static byte var_byte_b;
    private final int[] var_int_arr_a = new int[433];
    private int var_int_a;
    private byte[] var_byte_arr_a = new byte[1732];
    private int var_int_b;
    private int var_int_c;
    private int d;
    private int e = 0;
    private Float var_java_lang_Float_a;
    private boolean var_boolean_a;
    private final int[] var_int_arr_b = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, Short.MAX_VALUE, 65535, 131071};
    private final PushbackInputStream var_java_io_PushbackInputStream_a;
    private final bwu var_bwu_a = new bwu();
    private final byte[] var_byte_arr_b = new byte[4];
    private bwr[] var_bwr_arr_a = new bwr[1];
    private byte[] var_byte_arr_c = null;
    private boolean var_boolean_b = true;

    public bwp(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        inputStream = new BufferedInputStream(inputStream);
        this.void_a(inputStream);
        this.var_boolean_b = true;
        this.var_java_io_PushbackInputStream_a = new PushbackInputStream(inputStream, 1732);
        this.c();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void void_a(InputStream inputStream) {
        int n2 = -1;
        try {
            inputStream.mark(10);
            this.e = n2 = this.int_a(inputStream);
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                inputStream.reset();
            }
            catch (IOException iOException) {}
        }
        try {
            if (n2 > 0) {
                this.var_byte_arr_c = new byte[n2];
                inputStream.read(this.var_byte_arr_c, 0, this.var_byte_arr_c.length);
                this.a(this.var_byte_arr_c);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private int int_a(InputStream inputStream) {
        byte[] byArray = new byte[4];
        int n2 = -10;
        inputStream.read(byArray, 0, 3);
        if (byArray[0] == 73 && byArray[1] == 68 && byArray[2] == 51) {
            inputStream.read(byArray, 0, 3);
            inputStream.read(byArray, 0, 4);
            n2 = (byArray[0] << 21) + (byArray[1] << 14) + (byArray[2] << 7) + byArray[3];
        }
        return n2 + 10;
    }

    private void a(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        if (!"ID3".equals(new String(byArray, 0, 3))) {
            return;
        }
        int n2 = byArray[3] & 0xFF;
        if (n2 < 2 || n2 > 4) {
            return;
        }
        try {
            int n3;
            Float f2 = null;
            Float f3 = null;
            String string = null;
            for (int i2 = 10; i2 < byArray.length && byArray[i2] > 0; i2 += n3) {
                String string2;
                String[] stringArray;
                String string3;
                if (n2 == 3 || n2 == 4) {
                    string3 = new String(byArray, i2, 4);
                    n3 = byArray[i2 + 4] << 24 & 0xFF000000 | byArray[i2 + 5] << 16 & 0xFF0000 | byArray[i2 + 6] << 8 & 0xFF00 | byArray[i2 + 7] & 0xFF;
                    if (!string3.equals("TXXX") || (stringArray = (string = this.a(byArray, i2 += 10, n3, 1)).split("\u0000")).length != 2) continue;
                    string2 = stringArray[0];
                    string = stringArray[1];
                    if (string2.equals("replaygain_track_peak")) {
                        f3 = Float.valueOf(Float.parseFloat(string));
                        if (f2 == null) continue;
                        break;
                    }
                    if (!string2.equals("replaygain_track_gain")) continue;
                    f2 = Float.valueOf(Float.parseFloat(string.replace(" dB", "")) + 3.0f);
                    if (f3 == null) continue;
                    break;
                }
                string3 = new String(byArray, i2, 3);
                n3 = 0 + (byArray[i2 + 3] << 16) + (byArray[i2 + 4] << 8) + byArray[i2 + 5];
                if (!string3.equals("TXXX") || (stringArray = (string = this.a(byArray, i2 += 6, n3, 1)).split("\u0000")).length != 2) continue;
                string2 = stringArray[0];
                string = stringArray[1];
                if (string2.equals("replaygain_track_peak")) {
                    f3 = Float.valueOf(Float.parseFloat(string));
                    if (f2 == null) continue;
                    break;
                }
                if (!string2.equals("replaygain_track_gain")) continue;
                f2 = Float.valueOf(Float.parseFloat(string.replace(" dB", "")) + 3.0f);
                if (f3 != null) break;
            }
            if (f2 != null && f3 != null) {
                this.var_java_lang_Float_a = Float.valueOf((float)Math.pow(10.0, f2.floatValue() / 20.0f));
                this.var_java_lang_Float_a = Float.valueOf(Math.min(1.0f / f3.floatValue(), this.var_java_lang_Float_a.floatValue()));
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
    }

    private String a(byte[] byArray, int n2, int n3, int n4) {
        String string = null;
        try {
            String[] stringArray = new String[]{"ISO-8859-1", "UTF16", "UTF-16BE", "UTF-8"};
            string = new String(byArray, n2 + n4, n3 - n4, stringArray[byArray[n2]]);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        return string;
    }

    public void void_a() {
        try {
            this.var_java_io_PushbackInputStream_a.close();
        }
        catch (IOException iOException) {
            throw this.a(258, iOException);
        }
    }

    public bwu bwu_a() {
        bwu bwu2;
        block7: {
            bwu2 = null;
            try {
                bwu2 = this.bwu_b();
                if (this.var_boolean_b) {
                    bwu2.a(this.var_byte_arr_a);
                    this.var_boolean_b = false;
                }
            }
            catch (bwq bwq2) {
                if (bwq2.a() == 261) {
                    try {
                        this.c();
                        bwu2 = this.bwu_b();
                    }
                    catch (bwq bwq3) {
                        if (bwq3.a() != 260) {
                            throw this.a(bwq3.a(), bwq3);
                        }
                        break block7;
                    }
                }
                if (bwq2.a() == 260) break block7;
                throw this.a(bwq2.a(), bwq2);
            }
        }
        return bwu2;
    }

    private bwu bwu_b() {
        if (this.var_int_a == -1) {
            this.e();
        }
        return this.var_bwu_a;
    }

    private void e() {
        this.var_bwu_a.a(this, this.var_bwr_arr_a);
    }

    public void void_b() {
        if (this.var_int_b == -1 && this.var_int_c == -1 && this.var_int_a > 0) {
            try {
                this.var_java_io_PushbackInputStream_a.unread(this.var_byte_arr_a, 0, this.var_int_a);
            }
            catch (IOException iOException) {
                throw this.bwq_a(258);
            }
        }
    }

    public void c() {
        this.var_int_a = -1;
        this.var_int_b = -1;
        this.var_int_c = -1;
    }

    public boolean boolean_a(int n2) {
        int n3 = this.b(this.var_byte_arr_b, 0, 4);
        int n4 = this.var_byte_arr_b[0] << 24 & 0xFF000000 | this.var_byte_arr_b[1] << 16 & 0xFF0000 | this.var_byte_arr_b[2] << 8 & 0xFF00 | this.var_byte_arr_b[3] << 0 & 0xFF;
        try {
            this.var_java_io_PushbackInputStream_a.unread(this.var_byte_arr_b, 0, n3);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        boolean bl2 = false;
        switch (n3) {
            case 0: {
                bl2 = true;
                break;
            }
            case 4: {
                bl2 = this.a(n4, n2, this.d);
            }
        }
        return bl2;
    }

    protected bwq bwq_a(int n2) {
        return new bwq(n2, null);
    }

    protected bwq a(int n2, Throwable throwable) {
        return new bwq(n2, throwable);
    }

    int a(byte by2) {
        boolean bl2;
        int n2 = this.b(this.var_byte_arr_b, 0, 3);
        if (n2 != 3) {
            throw this.a(260, null);
        }
        int n3 = this.var_byte_arr_b[0] << 16 & 0xFF0000 | this.var_byte_arr_b[1] << 8 & 0xFF00 | this.var_byte_arr_b[2] << 0 & 0xFF;
        do {
            n3 <<= 8;
            if (this.b(this.var_byte_arr_b, 3, 1) == 1) continue;
            throw this.a(260, null);
        } while (!(bl2 = this.a(n3 |= this.var_byte_arr_b[3] & 0xFF, (int)by2, this.d)));
        return n3;
    }

    public boolean a(int n2, int n3, int n4) {
        boolean bl2 = false;
        if (n3 == var_byte_a) {
            bl2 = (n2 & 0xFFE00000) == -2097152;
        } else {
            boolean bl3 = (n2 & 0xFFF80C00) == n4 && (n2 & 0xC0) == 192 == this.var_boolean_a ? true : (bl2 = false);
        }
        if (bl2) {
            boolean bl4 = bl2 = (n2 >>> 10 & 3) != 3;
        }
        if (bl2) {
            boolean bl5 = bl2 = (n2 >>> 17 & 3) != 0;
        }
        if (bl2) {
            bl2 = (n2 >>> 19 & 3) != 1;
        }
        return bl2;
    }

    int int_a(int n2) {
        int n3 = 0;
        n3 = this.a(this.var_byte_arr_a, 0, n2);
        this.var_int_a = n2;
        this.var_int_b = -1;
        this.var_int_c = -1;
        return n3;
    }

    void d() {
        int n2 = 0;
        byte[] byArray = this.var_byte_arr_a;
        int n3 = this.var_int_a;
        for (int i2 = 0; i2 < n3; i2 += 4) {
            byte by2 = 0;
            byte by3 = 0;
            byte by4 = 0;
            byte by5 = 0;
            by2 = byArray[i2];
            if (i2 + 1 < n3) {
                by3 = byArray[i2 + 1];
            }
            if (i2 + 2 < n3) {
                by4 = byArray[i2 + 2];
            }
            if (i2 + 3 < n3) {
                by5 = byArray[i2 + 3];
            }
            this.var_int_arr_a[n2++] = by2 << 24 & 0xFF000000 | by3 << 16 & 0xFF0000 | by4 << 8 & 0xFF00 | by5 & 0xFF;
        }
        this.var_int_b = 0;
        this.var_int_c = 0;
    }

    public int b(int n2) {
        int n3 = 0;
        int n4 = this.var_int_c + n2;
        if (this.var_int_b < 0) {
            this.var_int_b = 0;
        }
        if (n4 <= 32) {
            n3 = this.var_int_arr_a[this.var_int_b] >>> 32 - n4 & this.var_int_arr_b[n2];
            if ((this.var_int_c += n2) == 32) {
                this.var_int_c = 0;
                ++this.var_int_b;
            }
            return n3;
        }
        int n5 = this.var_int_arr_a[this.var_int_b] & 0xFFFF;
        ++this.var_int_b;
        int n6 = this.var_int_arr_a[this.var_int_b] & 0xFFFF0000;
        n3 = n5 << 16 & 0xFFFF0000 | n6 >>> 16 & 0xFFFF;
        n3 >>>= 48 - n4;
        this.var_int_c = n4 - 32;
        return n3 &= this.var_int_arr_b[n2];
    }

    void void_a(int n2) {
        this.d = n2 & 0xFFFFFF3F;
        this.var_boolean_a = (n2 & 0xC0) == 192;
    }

    private int a(byte[] byArray, int n2, int n3) {
        int n4 = 0;
        try {
            while (n3 > 0) {
                int n5 = this.var_java_io_PushbackInputStream_a.read(byArray, n2, n3);
                if (n5 == -1) {
                    while (n3-- > 0) {
                        byArray[n2++] = 0;
                    }
                    break;
                }
                n4 += n5;
                n2 += n5;
                n3 -= n5;
            }
        }
        catch (IOException iOException) {
            throw this.a(258, iOException);
        }
        return n4;
    }

    private int b(byte[] byArray, int n2, int n3) {
        int n4 = 0;
        try {
            int n5;
            while (n3 > 0 && (n5 = this.var_java_io_PushbackInputStream_a.read(byArray, n2, n3)) != -1) {
                n4 += n5;
                n2 += n5;
                n3 -= n5;
            }
        }
        catch (IOException iOException) {
            throw this.a(258, iOException);
        }
        return n4;
    }

    static {
        var_byte_a = 0;
        var_byte_b = 1;
    }
}

