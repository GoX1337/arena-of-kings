/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class beh {
    private final bdv var_bdv_a;
    private final InputStream var_java_io_InputStream_a;
    private final byte[] var_byte_arr_a;
    private int var_int_a;
    private int var_int_b;
    private final boolean var_boolean_a;
    private boolean var_boolean_b = true;
    private int c;

    public beh(bdv bdv2, InputStream inputStream) {
        this.var_bdv_a = bdv2;
        this.var_java_io_InputStream_a = inputStream;
        this.var_byte_arr_a = bdv2.byte_arr_a();
        this.var_int_a = 0;
        this.var_int_b = 0;
        this.var_boolean_a = true;
    }

    public bcv bcv_a() {
        bcv bcv2;
        int n2;
        boolean bl2 = false;
        if (this.a(4)) {
            n2 = this.var_byte_arr_a[this.var_int_a] << 24 | (this.var_byte_arr_a[this.var_int_a + 1] & 0xFF) << 16 | (this.var_byte_arr_a[this.var_int_a + 2] & 0xFF) << 8 | this.var_byte_arr_a[this.var_int_a + 3] & 0xFF;
            if (this.b(n2)) {
                bl2 = true;
            } else if (this.c(n2)) {
                bl2 = true;
            } else if (this.d(n2 >>> 16)) {
                bl2 = true;
            }
        } else if (this.a(2) && this.d(n2 = (this.var_byte_arr_a[this.var_int_a] & 0xFF) << 8 | this.var_byte_arr_a[this.var_int_a + 1] & 0xFF)) {
            bl2 = true;
        }
        if (!bl2) {
            bcv2 = bcv.var_bcv_a;
        } else {
            switch (this.c) {
                case 1: {
                    bcv2 = bcv.var_bcv_a;
                    break;
                }
                case 2: {
                    bcv2 = this.var_boolean_b ? bcv.b : bcv.c;
                    break;
                }
                case 4: {
                    bcv2 = this.var_boolean_b ? bcv.d : bcv.e;
                    break;
                }
                default: {
                    throw new RuntimeException("Internal error");
                }
            }
        }
        this.var_bdv_a.a(bcv2);
        return bcv2;
    }

    public Reader java_io_Reader_a() {
        bcv bcv2 = this.var_bdv_a.bcv_a();
        switch (bcv2.int_a()) {
            case 8: 
            case 16: {
                InputStream inputStream = this.var_java_io_InputStream_a;
                if (inputStream == null) {
                    inputStream = new ByteArrayInputStream(this.var_byte_arr_a, this.var_int_a, this.var_int_b);
                } else if (this.var_int_a < this.var_int_b) {
                    inputStream = new bdz(this.var_bdv_a, inputStream, this.var_byte_arr_a, this.var_int_a, this.var_int_b);
                }
                return new InputStreamReader(inputStream, bcv2.java_lang_String_a());
            }
            case 32: {
                return new bef(this.var_bdv_a, this.var_java_io_InputStream_a, this.var_byte_arr_a, this.var_int_a, this.var_int_b, this.var_bdv_a.bcv_a().boolean_a());
            }
        }
        throw new RuntimeException("Internal error");
    }

    public bdc a(int n2, bdg bdg2, ber ber2, bes bes2, int n3) {
        int n4 = this.var_int_a;
        bcv bcv2 = this.bcv_a();
        int n5 = this.var_int_a - n4;
        if (bcv2 == bcv.var_bcv_a && bcw.a.b.a(n3)) {
            ber ber3 = ber2.ber_b(n3);
            return new bep(this.var_bdv_a, n2, this.var_java_io_InputStream_a, bdg2, ber3, this.var_byte_arr_a, this.var_int_a, this.var_int_b, n5, this.var_boolean_a);
        }
        return new ben(this.var_bdv_a, n2, this.java_io_Reader_a(), bdg2, bes2.bes_b(n3));
    }

    private boolean b(int n2) {
        switch (n2) {
            case 65279: {
                this.var_boolean_b = true;
                this.var_int_a += 4;
                this.c = 4;
                return true;
            }
            case -131072: {
                this.var_int_a += 4;
                this.c = 4;
                this.var_boolean_b = false;
                return true;
            }
            case 65534: {
                this.a("2143");
                break;
            }
            case -16842752: {
                this.a("3412");
                break;
            }
        }
        int n3 = n2 >>> 16;
        if (n3 == 65279) {
            this.var_int_a += 2;
            this.c = 2;
            this.var_boolean_b = true;
            return true;
        }
        if (n3 == 65534) {
            this.var_int_a += 2;
            this.c = 2;
            this.var_boolean_b = false;
            return true;
        }
        if (n2 >>> 8 == 0xEFBBBF) {
            this.var_int_a += 3;
            this.c = 1;
            this.var_boolean_b = true;
            return true;
        }
        return false;
    }

    private boolean c(int n2) {
        if (n2 >> 8 == 0) {
            this.var_boolean_b = true;
        } else if ((n2 & 0xFFFFFF) == 0) {
            this.var_boolean_b = false;
        } else if ((n2 & 0xFF00FFFF) == 0) {
            this.a("3412");
        } else if ((n2 & 0xFFFF00FF) == 0) {
            this.a("2143");
        } else {
            return false;
        }
        this.c = 4;
        return true;
    }

    private boolean d(int n2) {
        if ((n2 & 0xFF00) == 0) {
            this.var_boolean_b = true;
        } else if ((n2 & 0xFF) == 0) {
            this.var_boolean_b = false;
        } else {
            return false;
        }
        this.c = 2;
        return true;
    }

    private void a(String string) {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + string + ") detected");
    }

    protected boolean a(int n2) {
        int n3;
        for (int i2 = this.var_int_b - this.var_int_a; i2 < n2; i2 += n3) {
            n3 = this.var_java_io_InputStream_a == null ? -1 : this.var_java_io_InputStream_a.read(this.var_byte_arr_a, this.var_int_b, this.var_byte_arr_a.length - this.var_int_b);
            if (n3 < 1) {
                return false;
            }
            this.var_int_b += n3;
        }
        return true;
    }
}

