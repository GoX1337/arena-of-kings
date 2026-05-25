/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bep
extends bdo {
    private static final int p = bdc.a.l.b();
    private static final int q = bdc.a.h.b();
    private static final int r = bdc.a.j.b();
    private static final int s = bdc.a.k.b();
    private static final int t = bdc.a.e.b();
    private static final int u = bdc.a.d.b();
    private static final int v = bdc.a.b.b();
    private static final int w = bdc.a.c.b();
    private static final int[] var_int_arr_d;
    protected static final int[] b;
    protected bdg var_bdg_a;
    protected final ber var_ber_a;
    protected int[] var_int_arr_c = new int[16];
    protected boolean var_boolean_d;
    private int x;
    protected int m;
    protected int n;
    protected int o;
    protected InputStream var_java_io_InputStream_a;
    protected byte[] var_byte_arr_c;
    protected boolean e;

    public bep(bdv bdv2, int n2, InputStream inputStream, bdg bdg2, ber ber2, byte[] byArray, int n3, int n4, int n5, boolean bl2) {
        super(bdv2, n2);
        this.var_java_io_InputStream_a = inputStream;
        this.var_bdg_a = bdg2;
        this.var_ber_a = ber2;
        this.var_byte_arr_c = byArray;
        this.b = (int[])n3;
        this.var_int_arr_c = (int[])n4;
        this.e = n3 - n5;
        this.var_bdg_a = (bdg)((long)(-n3 + n5));
        this.e = bl2;
    }

    @Override
    public bdg bdg_a() {
        return this.var_bdg_a;
    }

    @Override
    public bfd<bdj> a() {
        return b;
    }

    protected final boolean boolean_j() {
        if (this.var_java_io_InputStream_a != null) {
            int n2 = this.var_byte_arr_c.length;
            if (n2 == 0) {
                return false;
            }
            int n3 = this.var_java_io_InputStream_a.read(this.var_byte_arr_c, 0, n2);
            if (n3 > 0) {
                int[] nArray = this.var_int_arr_c;
                this.var_bdg_a += (long)nArray;
                this.e -= nArray;
                this.m -= nArray;
                this.b = (int[])false;
                this.var_int_arr_c = (int[])n3;
                return true;
            }
            this.void_c();
            if (n3 == 0) {
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.var_byte_arr_c.length + " bytes");
            }
        }
        return false;
    }

    @Override
    protected void void_c() {
        if (this.var_java_io_InputStream_a != null) {
            if (((bdv)((Object)this.var_bdg_a)).boolean_a() || this.a(bdc.a.var_bdc$a_a)) {
                this.var_java_io_InputStream_a.close();
            }
            this.var_java_io_InputStream_a = null;
        }
    }

    @Override
    protected void void_d() {
        byte[] byArray;
        super.void_d();
        this.var_ber_a.void_a();
        if (this.e && (byArray = this.var_byte_arr_c) != null && byArray != b) {
            this.var_byte_arr_c = (byte[])b;
            ((bdv)((Object)this.var_bdg_a)).a(byArray);
        }
    }

    @Override
    public String java_lang_String_e() {
        if (this.b == bdf.h) {
            if (this.var_boolean_d) {
                this.var_boolean_d = false;
                return this.java_lang_String_k();
            }
            return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
        }
        return this.java_lang_String_a((bdf)this.b);
    }

    @Override
    public String java_lang_String_f() {
        if (this.b == bdf.h) {
            if (this.var_boolean_d) {
                this.var_boolean_d = false;
                return this.java_lang_String_k();
            }
            return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
        }
        if (this.b == bdf.f) {
            return this.java_lang_String_c();
        }
        return super.java_lang_String_a((String)null);
    }

    @Override
    public String java_lang_String_a(String string) {
        if (this.b == bdf.h) {
            if (this.var_boolean_d) {
                this.var_boolean_d = false;
                return this.java_lang_String_k();
            }
            return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
        }
        if (this.b == bdf.f) {
            return this.java_lang_String_c();
        }
        return super.java_lang_String_a(string);
    }

    @Override
    public int int_f() {
        int[] nArray = this.b;
        if (nArray == bdf.i || nArray == bdf.j) {
            if ((this.h & 1) == 0) {
                if (this.h == 0) {
                    return this.int_j();
                }
                if ((this.h & 1) == 0) {
                    this.void_f();
                }
            }
            return this.i;
        }
        return super.int_a(0);
    }

    @Override
    public int int_a(int n2) {
        int[] nArray = this.b;
        if (nArray == bdf.i || nArray == bdf.j) {
            if ((this.h & 1) == 0) {
                if (this.h == 0) {
                    return this.int_j();
                }
                if ((this.h & 1) == 0) {
                    this.void_f();
                }
            }
            return this.i;
        }
        return super.int_a(n2);
    }

    protected final String java_lang_String_a(bdf bdf2) {
        if (bdf2 == null) {
            return null;
        }
        switch (bdf2.int_a()) {
            case 5: {
                return ((bek)((Object)this.var_bdg_a)).java_lang_String_b();
            }
            case 6: 
            case 7: 
            case 8: {
                return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
            }
        }
        return bdf2.java_lang_String_a();
    }

    @Override
    public char[] char_arr_a() {
        if (this.b != null) {
            switch (this.b.int_a()) {
                case 5: {
                    if (this.b == false) {
                        String string = ((bek)((Object)this.var_bdg_a)).java_lang_String_b();
                        int n2 = string.length();
                        if (this.var_bdg_a == null) {
                            this.var_bdg_a = ((bdv)((Object)this.var_bdg_a)).a(n2);
                        } else if (((bdg)this.var_bdg_a).length < n2) {
                            this.var_bdg_a = new char[n2];
                        }
                        string.getChars(0, n2, (char[])this.var_bdg_a, 0);
                        this.b = (int[])true;
                    }
                    return this.var_bdg_a;
                }
                case 6: {
                    if (this.var_boolean_d) {
                        this.var_boolean_d = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_bdg_a)).char_arr_a();
                }
            }
            return this.b.char_arr_a();
        }
        return null;
    }

    @Override
    public int int_c() {
        if (this.b != null) {
            switch (this.b.int_a()) {
                case 5: {
                    return ((bek)((Object)this.var_bdg_a)).java_lang_String_b().length();
                }
                case 6: {
                    if (this.var_boolean_d) {
                        this.var_boolean_d = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_bdg_a)).int_a();
                }
            }
            return this.b.char_arr_a().length;
        }
        return 0;
    }

    @Override
    public int int_d() {
        if (this.b != null) {
            switch (this.b.int_a()) {
                case 5: {
                    return 0;
                }
                case 6: {
                    if (this.var_boolean_d) {
                        this.var_boolean_d = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_bdg_a)).int_b();
                }
            }
        }
        return 0;
    }

    @Override
    public byte[] byte_arr_a(bcq bcq2) {
        if (this.b != bdf.h && (this.b != bdf.g || this.var_bdg_a == null)) {
            this.d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.var_boolean_d) {
            try {
                this.var_bdg_a = this.b(bcq2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw this.bdb_a("Failed to decode VALUE_STRING as base64 (" + bcq2 + "): " + illegalArgumentException.getMessage());
            }
            this.var_boolean_d = false;
        } else if (this.var_bdg_a == null) {
            bex bex2 = this.bex_a();
            this.a(this.java_lang_String_e(), bex2, bcq2);
            this.var_bdg_a = bex2.byte_arr_a();
        }
        return this.var_bdg_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int a(bcq bcq2, OutputStream outputStream) {
        if (!this.var_boolean_d || this.b != bdf.h) {
            byte[] byArray = this.byte_arr_a(bcq2);
            outputStream.write(byArray);
            return byArray.length;
        }
        byte[] byArray = ((bdv)((Object)this.var_bdg_a)).c();
        try {
            int n2 = this.a(bcq2, outputStream, byArray);
            return n2;
        }
        finally {
            ((bdv)((Object)this.var_bdg_a)).c(byArray);
        }
    }

    protected int a(bcq bcq2, OutputStream outputStream, byte[] byArray) {
        int n2 = 0;
        int n3 = byArray.length - 3;
        int n4 = 0;
        while (true) {
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n5 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n5 <= 32) continue;
            int n6 = bcq2.int_a(n5);
            if (n6 < 0) {
                if (n5 == 34) break;
                n6 = this.int_a(bcq2, n5, 0);
                if (n6 < 0) continue;
            }
            if (n2 > n3) {
                n4 += n2;
                outputStream.write(byArray, 0, n2);
                n2 = 0;
            }
            int n7 = n6;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n5 = this.var_byte_arr_c[bep3.b] & 0xFF;
            n6 = bcq2.int_a(n5);
            if (n6 < 0) {
                n6 = this.int_a(bcq2, n5, 1);
            }
            n7 = n7 << 6 | n6;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep4 = this;
            bep4.b = bep4.b + true;
            n5 = this.var_byte_arr_c[bep4.b] & 0xFF;
            n6 = bcq2.int_a(n5);
            if (n6 < 0) {
                if (n6 != -2) {
                    if (n5 == 34) {
                        byArray[n2++] = (byte)(n7 >>= 4);
                        if (!bcq2.boolean_a()) break;
                        this.b = this.b - true;
                        this.void_a(bcq2);
                        break;
                    }
                    n6 = this.int_a(bcq2, n5, 2);
                }
                if (n6 == -2) {
                    if (this.b >= this.var_int_arr_c) {
                        this.void_p();
                    }
                    bep bep5 = this;
                    bep5.b = bep5.b + true;
                    n5 = this.var_byte_arr_c[bep5.b] & 0xFF;
                    if (!bcq2.boolean_a(n5) && this.int_a(bcq2, n5, 3) != -2) {
                        throw this.a(bcq2, n5, 3, "expected padding character '" + bcq2.char_a() + "'");
                    }
                    byArray[n2++] = (byte)(n7 >>= 4);
                    continue;
                }
            }
            n7 = n7 << 6 | n6;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep6 = this;
            bep6.b = bep6.b + true;
            n5 = this.var_byte_arr_c[bep6.b] & 0xFF;
            n6 = bcq2.int_a(n5);
            if (n6 < 0) {
                if (n6 != -2) {
                    if (n5 == 34) {
                        byArray[n2++] = (byte)((n7 >>= 2) >> 8);
                        byArray[n2++] = (byte)n7;
                        if (!bcq2.boolean_a()) break;
                        this.b = this.b - true;
                        this.void_a(bcq2);
                        break;
                    }
                    n6 = this.int_a(bcq2, n5, 3);
                }
                if (n6 == -2) {
                    byArray[n2++] = (byte)((n7 >>= 2) >> 8);
                    byArray[n2++] = (byte)n7;
                    continue;
                }
            }
            n7 = n7 << 6 | n6;
            byArray[n2++] = (byte)(n7 >> 16);
            byArray[n2++] = (byte)(n7 >> 8);
            byArray[n2++] = (byte)n7;
        }
        this.var_boolean_d = false;
        if (n2 > 0) {
            n4 += n2;
            outputStream.write(byArray, 0, n2);
        }
        return n4;
    }

    @Override
    public bdf bdf_a() {
        bdf bdf2;
        int n2;
        if (this.b == bdf.f) {
            return this.bdf_h();
        }
        this.h = 0;
        if (this.var_boolean_d) {
            this.void_q();
        }
        if ((n2 = this.int_n()) < 0) {
            this.close();
            this.b = null;
            return null;
        }
        this.var_bdg_a = null;
        if (n2 == 93) {
            this.C();
            bdf bdf3 = bdf.var_bdf_e;
            this.b = (int[])bdf3;
            return bdf3;
        }
        if (n2 == 125) {
            this.D();
            bdf bdf4 = bdf.var_bdf_c;
            this.b = (int[])bdf4;
            return bdf4;
        }
        if (((bek)((Object)this.var_bdg_a)).d()) {
            if (n2 != 44) {
                this.d(n2, "was expecting comma to separate " + (String)((bek)((Object)this.var_bdg_a)).java_lang_Object_a() + " entries");
            }
            n2 = this.int_l();
            if ((this.var_bdg_a & p) != 0 && (n2 == 93 || n2 == 125)) {
                return this.bdf_d(n2);
            }
        }
        if (!((bde)((Object)this.var_bdg_a)).boolean_c()) {
            this.A();
            return this.bdf_c(n2);
        }
        this.B();
        String string = this.java_lang_String_b(n2);
        ((bek)((Object)this.var_bdg_a)).a(string);
        this.b = (int[])bdf.f;
        n2 = this.int_p();
        this.A();
        if (n2 == 34) {
            this.var_boolean_d = true;
            this.var_bdg_a = bdf.h;
            return this.b;
        }
        switch (n2) {
            case 45: {
                bdf2 = this.bdf_f();
                break;
            }
            case 46: {
                bdf2 = this.bdf_e();
                break;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                bdf2 = this.bdf_a(n2);
                break;
            }
            case 102: {
                this.s();
                bdf2 = bdf.l;
                break;
            }
            case 110: {
                this.t();
                bdf2 = bdf.m;
                break;
            }
            case 116: {
                this.r();
                bdf2 = bdf.k;
                break;
            }
            case 91: {
                bdf2 = bdf.var_bdf_d;
                break;
            }
            case 123: {
                bdf2 = bdf.var_bdf_b;
                break;
            }
            default: {
                bdf2 = this.bdf_b(n2);
            }
        }
        this.var_bdg_a = bdf2;
        return this.b;
    }

    private final bdf bdf_c(int n2) {
        if (n2 == 34) {
            this.var_boolean_d = true;
            bdf bdf2 = bdf.h;
            this.b = (int[])bdf2;
            return bdf2;
        }
        switch (n2) {
            case 91: {
                this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).a(this.f, this.g);
                bdf bdf3 = bdf.var_bdf_d;
                this.b = (int[])bdf3;
                return bdf3;
            }
            case 123: {
                this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).b(this.f, this.g);
                bdf bdf4 = bdf.var_bdf_b;
                this.b = (int[])bdf4;
                return bdf4;
            }
            case 116: {
                this.r();
                bdf bdf5 = bdf.k;
                this.b = (int[])bdf5;
                return bdf5;
            }
            case 102: {
                this.s();
                bdf bdf6 = bdf.l;
                this.b = (int[])bdf6;
                return bdf6;
            }
            case 110: {
                this.t();
                bdf bdf7 = bdf.m;
                this.b = (int[])bdf7;
                return bdf7;
            }
            case 45: {
                bdf bdf8 = this.bdf_f();
                this.b = (int[])bdf8;
                return bdf8;
            }
            case 46: {
                bdf bdf9 = this.bdf_e();
                this.b = (int[])bdf9;
                return bdf9;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                bdf bdf10 = this.bdf_a(n2);
                this.b = (int[])bdf10;
                return bdf10;
            }
        }
        bdf bdf11 = this.bdf_b(n2);
        this.b = (int[])bdf11;
        return bdf11;
    }

    private final bdf bdf_h() {
        this.b = (int[])false;
        bdg bdg2 = this.var_bdg_a;
        this.var_bdg_a = null;
        if (bdg2 == bdf.var_bdf_d) {
            this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).a(this.f, this.g);
        } else if (bdg2 == bdf.var_bdf_b) {
            this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).b(this.f, this.g);
        }
        bdg bdg3 = bdg2;
        this.b = (int[])bdg3;
        return bdg3;
    }

    @Override
    public String java_lang_String_a() {
        bdf bdf2;
        int n2;
        this.h = 0;
        if (this.b == bdf.f) {
            this.bdf_h();
            return null;
        }
        if (this.var_boolean_d) {
            this.void_q();
        }
        if ((n2 = this.int_n()) < 0) {
            this.close();
            this.b = null;
            return null;
        }
        this.var_bdg_a = null;
        if (n2 == 93) {
            this.C();
            this.b = (int[])bdf.var_bdf_e;
            return null;
        }
        if (n2 == 125) {
            this.D();
            this.b = (int[])bdf.var_bdf_c;
            return null;
        }
        if (((bek)((Object)this.var_bdg_a)).d()) {
            if (n2 != 44) {
                this.d(n2, "was expecting comma to separate " + (String)((bek)((Object)this.var_bdg_a)).java_lang_Object_a() + " entries");
            }
            n2 = this.int_l();
            if ((this.var_bdg_a & p) != 0 && (n2 == 93 || n2 == 125)) {
                this.bdf_d(n2);
                return null;
            }
        }
        if (!((bde)((Object)this.var_bdg_a)).boolean_c()) {
            this.A();
            this.bdf_c(n2);
            return null;
        }
        this.B();
        String string = this.java_lang_String_b(n2);
        ((bek)((Object)this.var_bdg_a)).a(string);
        this.b = (int[])bdf.f;
        n2 = this.int_p();
        this.A();
        if (n2 == 34) {
            this.var_boolean_d = true;
            this.var_bdg_a = bdf.h;
            return string;
        }
        switch (n2) {
            case 45: {
                bdf2 = this.bdf_f();
                break;
            }
            case 46: {
                bdf2 = this.bdf_e();
                break;
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: {
                bdf2 = this.bdf_a(n2);
                break;
            }
            case 102: {
                this.s();
                bdf2 = bdf.l;
                break;
            }
            case 110: {
                this.t();
                bdf2 = bdf.m;
                break;
            }
            case 116: {
                this.r();
                bdf2 = bdf.k;
                break;
            }
            case 91: {
                bdf2 = bdf.var_bdf_d;
                break;
            }
            case 123: {
                bdf2 = bdf.var_bdf_b;
                break;
            }
            default: {
                bdf2 = this.bdf_b(n2);
            }
        }
        this.var_bdg_a = bdf2;
        return string;
    }

    @Override
    public String java_lang_String_b() {
        if (this.b == bdf.f) {
            this.b = (int[])false;
            bdg bdg2 = this.var_bdg_a;
            this.var_bdg_a = null;
            this.b = (int[])bdg2;
            if (bdg2 == bdf.h) {
                if (this.var_boolean_d) {
                    this.var_boolean_d = false;
                    return this.java_lang_String_k();
                }
                return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
            }
            if (bdg2 == bdf.var_bdf_d) {
                this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).a(this.f, this.g);
            } else if (bdg2 == bdf.var_bdf_b) {
                this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).b(this.f, this.g);
            }
            return null;
        }
        return this.bdf_a() == bdf.h ? this.java_lang_String_e() : null;
    }

    protected final bdf bdf_e() {
        if (!this.a(bel.h.bdc$a_a())) {
            return this.bdf_b(46);
        }
        return this.a(((bfj)((Object)this.var_bdg_a)).d(), 0, 46, false, 0);
    }

    protected bdf bdf_a(int n2) {
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        if (n2 == 48) {
            n2 = this.int_k();
        }
        cArray[0] = (char)n2;
        int n3 = 1;
        int n4 = 1;
        int n5 = Math.min((int)this.var_int_arr_c, (int)(this.b + cArray.length - true));
        while (true) {
            if (this.b >= n5) {
                return this.a(cArray, n4, false, n3);
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 < 48 || n2 > 57) break;
            ++n3;
            cArray[n4++] = (char)n2;
        }
        if (n2 == 46 || n2 == 101 || n2 == 69) {
            return this.a(cArray, n4, n2, false, n3);
        }
        this.b = this.b - true;
        ((bfj)((Object)this.var_bdg_a)).void_a(n4);
        if (((bde)((Object)this.var_bdg_a)).boolean_b()) {
            this.g(n2);
        }
        return this.a(false, n3);
    }

    protected bdf bdf_f() {
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        int n2 = 0;
        cArray[n2++] = 45;
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n3 = this.var_byte_arr_c[bep2.b] & 0xFF;
        if (n3 <= 48) {
            if (n3 != 48) {
                return this.a(n3, true);
            }
            n3 = this.int_k();
        } else if (n3 > 57) {
            return this.a(n3, true);
        }
        cArray[n2++] = (char)n3;
        int n4 = 1;
        int n5 = Math.min((int)this.var_int_arr_c, (int)(this.b + cArray.length - n2));
        while (true) {
            if (this.b >= n5) {
                return this.a(cArray, n2, true, n4);
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n3 = this.var_byte_arr_c[bep3.b] & 0xFF;
            if (n3 < 48 || n3 > 57) break;
            ++n4;
            cArray[n2++] = (char)n3;
        }
        if (n3 == 46 || n3 == 101 || n3 == 69) {
            return this.a(cArray, n2, n3, true, n4);
        }
        this.b = this.b - true;
        ((bfj)((Object)this.var_bdg_a)).void_a(n2);
        if (((bde)((Object)this.var_bdg_a)).boolean_b()) {
            this.g(n3);
        }
        return this.a(true, n4);
    }

    private final bdf a(char[] cArray, int n2, boolean bl2, int n3) {
        while (true) {
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                ((bfj)((Object)this.var_bdg_a)).void_a(n2);
                return this.a(bl2, n3);
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n4 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n4 > 57 || n4 < 48) {
                if (n4 != 46 && n4 != 101 && n4 != 69) break;
                return this.a(cArray, n2, n4, bl2, n3);
            }
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n2 = 0;
            }
            cArray[n2++] = (char)n4;
            ++n3;
        }
        this.b = this.b - true;
        ((bfj)((Object)this.var_bdg_a)).void_a(n2);
        if (((bde)((Object)this.var_bdg_a)).boolean_b()) {
            this.g(this.var_byte_arr_c[this.b] & 0xFF);
        }
        return this.a(bl2, n3);
    }

    private final int int_k() {
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            return 48;
        }
        int n2 = this.var_byte_arr_c[this.b] & 0xFF;
        if (n2 < 48 || n2 > 57) {
            return 48;
        }
        if ((this.var_bdg_a & q) == 0) {
            this.void_a("Leading zeroes not allowed");
        }
        this.b = this.b + true;
        if (n2 == 48) {
            while (this.b < this.var_int_arr_c || this.boolean_j()) {
                n2 = this.var_byte_arr_c[this.b] & 0xFF;
                if (n2 < 48 || n2 > 57) {
                    return 48;
                }
                this.b = this.b + true;
                if (n2 == 48) continue;
                break;
            }
        }
        return n2;
    }

    private final bdf a(char[] cArray, int n2, int n3, boolean bl2, int n4) {
        int n5 = 0;
        boolean bl3 = false;
        if (n3 == 46) {
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n2 = 0;
            }
            cArray[n2++] = (char)n3;
            while (true) {
                if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                    bl3 = true;
                    break;
                }
                bep bep2 = this;
                bep2.b = bep2.b + true;
                n3 = this.var_byte_arr_c[bep2.b] & 0xFF;
                if (n3 < 48 || n3 > 57) break;
                ++n5;
                if (n2 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_bdg_a)).e();
                    n2 = 0;
                }
                cArray[n2++] = (char)n3;
            }
            if (n5 == 0) {
                this.c(n3, "Decimal point not followed by a digit");
            }
        }
        int n6 = 0;
        if (n3 == 101 || n3 == 69) {
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n2 = 0;
            }
            cArray[n2++] = (char)n3;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n3 = this.var_byte_arr_c[bep3.b] & 0xFF;
            if (n3 == 45 || n3 == 43) {
                if (n2 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_bdg_a)).e();
                    n2 = 0;
                }
                cArray[n2++] = (char)n3;
                if (this.b >= this.var_int_arr_c) {
                    this.void_p();
                }
                bep bep4 = this;
                bep4.b = bep4.b + true;
                n3 = this.var_byte_arr_c[bep4.b] & 0xFF;
            }
            while (n3 >= 48 && n3 <= 57) {
                ++n6;
                if (n2 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_bdg_a)).e();
                    n2 = 0;
                }
                cArray[n2++] = (char)n3;
                if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                    bl3 = true;
                    break;
                }
                bep bep5 = this;
                bep5.b = bep5.b + true;
                n3 = this.var_byte_arr_c[bep5.b] & 0xFF;
            }
            if (n6 == 0) {
                this.c(n3, "Exponent indicator not followed by a digit");
            }
        }
        if (!bl3) {
            this.b = this.b - true;
            if (((bde)((Object)this.var_bdg_a)).boolean_b()) {
                this.g(n3);
            }
        }
        ((bfj)((Object)this.var_bdg_a)).void_a(n2);
        return this.b(bl2, n4, n5, n6);
    }

    private final void g(int n2) {
        this.b = this.b + true;
        switch (n2) {
            case 9: 
            case 32: {
                return;
            }
            case 13: {
                this.u();
                return;
            }
            case 10: {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                return;
            }
        }
        this.void_b(n2);
    }

    protected final String java_lang_String_b(int n2) {
        if (n2 != 34) {
            return this.java_lang_String_d(n2);
        }
        if (this.b + 13 > this.var_int_arr_c) {
            return this.java_lang_String_i();
        }
        byte[] byArray = this.var_byte_arr_c;
        int[] nArray = b;
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n3 = byArray[bep2.b] & 0xFF;
        if (nArray[n3] == 0) {
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n2 = byArray[bep3.b] & 0xFF;
            if (nArray[n2] == 0) {
                n3 = n3 << 8 | n2;
                bep bep4 = this;
                bep4.b = bep4.b + true;
                n2 = byArray[bep4.b] & 0xFF;
                if (nArray[n2] == 0) {
                    n3 = n3 << 8 | n2;
                    bep bep5 = this;
                    bep5.b = bep5.b + true;
                    n2 = byArray[bep5.b] & 0xFF;
                    if (nArray[n2] == 0) {
                        n3 = n3 << 8 | n2;
                        bep bep6 = this;
                        bep6.b = bep6.b + true;
                        n2 = byArray[bep6.b] & 0xFF;
                        if (nArray[n2] == 0) {
                            this.x = n3;
                            return this.java_lang_String_c(n2);
                        }
                        if (n2 == 34) {
                            return this.java_lang_String_b(n3, 4);
                        }
                        return this.b(n3, n2, 4);
                    }
                    if (n2 == 34) {
                        return this.java_lang_String_b(n3, 3);
                    }
                    return this.b(n3, n2, 3);
                }
                if (n2 == 34) {
                    return this.java_lang_String_b(n3, 2);
                }
                return this.b(n3, n2, 2);
            }
            if (n2 == 34) {
                return this.java_lang_String_b(n3, 1);
            }
            return this.b(n3, n2, 1);
        }
        if (n3 == 34) {
            return "";
        }
        return this.b(0, n3, 0);
    }

    protected final String java_lang_String_c(int n2) {
        byte[] byArray = this.var_byte_arr_c;
        int[] nArray = b;
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n3 = byArray[bep2.b] & 0xFF;
        if (nArray[n3] != 0) {
            if (n3 == 34) {
                return this.c(this.x, n2, 1);
            }
            return this.a(this.x, n2, n3, 1);
        }
        n2 = n2 << 8 | n3;
        bep bep3 = this;
        bep3.b = bep3.b + true;
        n3 = byArray[bep3.b] & 0xFF;
        if (nArray[n3] != 0) {
            if (n3 == 34) {
                return this.c(this.x, n2, 2);
            }
            return this.a(this.x, n2, n3, 2);
        }
        n2 = n2 << 8 | n3;
        bep bep4 = this;
        bep4.b = bep4.b + true;
        n3 = byArray[bep4.b] & 0xFF;
        if (nArray[n3] != 0) {
            if (n3 == 34) {
                return this.c(this.x, n2, 3);
            }
            return this.a(this.x, n2, n3, 3);
        }
        n2 = n2 << 8 | n3;
        bep bep5 = this;
        bep5.b = bep5.b + true;
        n3 = byArray[bep5.b] & 0xFF;
        if (nArray[n3] != 0) {
            if (n3 == 34) {
                return this.c(this.x, n2, 4);
            }
            return this.a(this.x, n2, n3, 4);
        }
        return this.java_lang_String_a(n3, n2);
    }

    protected final String java_lang_String_a(int n2, int n3) {
        byte[] byArray = this.var_byte_arr_c;
        int[] nArray = b;
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n4 = byArray[bep2.b] & 0xFF;
        if (nArray[n4] != 0) {
            if (n4 == 34) {
                return this.b(this.x, n3, n2, 1);
            }
            return this.a(this.x, n3, n2, n4, 1);
        }
        n2 = n2 << 8 | n4;
        bep bep3 = this;
        bep3.b = bep3.b + true;
        n4 = byArray[bep3.b] & 0xFF;
        if (nArray[n4] != 0) {
            if (n4 == 34) {
                return this.b(this.x, n3, n2, 2);
            }
            return this.a(this.x, n3, n2, n4, 2);
        }
        n2 = n2 << 8 | n4;
        bep bep4 = this;
        bep4.b = bep4.b + true;
        n4 = byArray[bep4.b] & 0xFF;
        if (nArray[n4] != 0) {
            if (n4 == 34) {
                return this.b(this.x, n3, n2, 3);
            }
            return this.a(this.x, n3, n2, n4, 3);
        }
        n2 = n2 << 8 | n4;
        bep bep5 = this;
        bep5.b = bep5.b + true;
        n4 = byArray[bep5.b] & 0xFF;
        if (nArray[n4] != 0) {
            if (n4 == 34) {
                return this.b(this.x, n3, n2, 4);
            }
            return this.a(this.x, n3, n2, n4, 4);
        }
        return this.a(n4, n3, n2);
    }

    protected final String a(int n2, int n3, int n4) {
        this.var_int_arr_c[0] = this.x;
        this.var_int_arr_c[1] = n3;
        this.var_int_arr_c[2] = n4;
        byte[] byArray = this.var_byte_arr_c;
        int[] nArray = b;
        int n5 = 3;
        while (this.b + 4 <= this.var_int_arr_c) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n6 = byArray[bep2.b] & 0xFF;
            if (nArray[n6] != 0) {
                if (n6 == 34) {
                    return this.a(this.var_int_arr_c, n5, n2, 1);
                }
                return this.a(this.var_int_arr_c, n5, n2, n6, 1);
            }
            n2 = n2 << 8 | n6;
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n6 = byArray[bep3.b] & 0xFF;
            if (nArray[n6] != 0) {
                if (n6 == 34) {
                    return this.a(this.var_int_arr_c, n5, n2, 2);
                }
                return this.a(this.var_int_arr_c, n5, n2, n6, 2);
            }
            n2 = n2 << 8 | n6;
            bep bep4 = this;
            bep4.b = bep4.b + true;
            n6 = byArray[bep4.b] & 0xFF;
            if (nArray[n6] != 0) {
                if (n6 == 34) {
                    return this.a(this.var_int_arr_c, n5, n2, 3);
                }
                return this.a(this.var_int_arr_c, n5, n2, n6, 3);
            }
            n2 = n2 << 8 | n6;
            bep bep5 = this;
            bep5.b = bep5.b + true;
            n6 = byArray[bep5.b] & 0xFF;
            if (nArray[n6] != 0) {
                if (n6 == 34) {
                    return this.a(this.var_int_arr_c, n5, n2, 4);
                }
                return this.a(this.var_int_arr_c, n5, n2, n6, 4);
            }
            if (n5 >= this.var_int_arr_c.length) {
                this.var_int_arr_c = bep.a(this.var_int_arr_c, n5);
            }
            this.var_int_arr_c[n5++] = n2;
            n2 = n6;
        }
        return this.a(this.var_int_arr_c, n5, 0, n2, 0);
    }

    protected String java_lang_String_i() {
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            this.c(": was expecting closing '\"' for name", bdf.f);
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
        if (n2 == 34) {
            return "";
        }
        return this.a(this.var_int_arr_c, 0, 0, n2, 0);
    }

    private final String b(int n2, int n3, int n4) {
        return this.a(this.var_int_arr_c, 0, n2, n3, n4);
    }

    private final String a(int n2, int n3, int n4, int n5) {
        this.var_int_arr_c[0] = n2;
        return this.a(this.var_int_arr_c, 1, n3, n4, n5);
    }

    private final String a(int n2, int n3, int n4, int n5, int n6) {
        this.var_int_arr_c[0] = n2;
        this.var_int_arr_c[1] = n3;
        return this.a(this.var_int_arr_c, 2, n4, n5, n6);
    }

    protected final String a(int[] nArray, int n2, int n3, int n4, int n5) {
        String string;
        int[] nArray2 = b;
        while (true) {
            if (nArray2[n4] != 0) {
                if (n4 == 34) break;
                if (n4 != 92) {
                    this.b(n4, "name");
                } else {
                    n4 = this.char_a();
                }
                if (n4 > 127) {
                    if (n5 >= 4) {
                        if (n2 >= nArray.length) {
                            nArray = bep.a(nArray, nArray.length);
                            this.var_int_arr_c = nArray;
                        }
                        nArray[n2++] = n3;
                        n3 = 0;
                        n5 = 0;
                    }
                    if (n4 < 2048) {
                        n3 = n3 << 8 | (0xC0 | n4 >> 6);
                        ++n5;
                    } else {
                        n3 = n3 << 8 | (0xE0 | n4 >> 12);
                        if (++n5 >= 4) {
                            if (n2 >= nArray.length) {
                                nArray = bep.a(nArray, nArray.length);
                                this.var_int_arr_c = nArray;
                            }
                            nArray[n2++] = n3;
                            n3 = 0;
                            n5 = 0;
                        }
                        n3 = n3 << 8 | (0x80 | n4 >> 6 & 0x3F);
                        ++n5;
                    }
                    n4 = 0x80 | n4 & 0x3F;
                }
            }
            if (n5 < 4) {
                ++n5;
                n3 = n3 << 8 | n4;
            } else {
                if (n2 >= nArray.length) {
                    nArray = bep.a(nArray, nArray.length);
                    this.var_int_arr_c = nArray;
                }
                nArray[n2++] = n3;
                n3 = n4;
                n5 = 1;
            }
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                this.c(" in field name", bdf.f);
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            n4 = this.var_byte_arr_c[bep2.b] & 0xFF;
        }
        if (n5 > 0) {
            if (n2 >= nArray.length) {
                nArray = bep.a(nArray, nArray.length);
                this.var_int_arr_c = nArray;
            }
            nArray[n2++] = bep.int_a(n3, n5);
        }
        if ((string = this.var_ber_a.java_lang_String_a(nArray, n2)) == null) {
            string = this.a(nArray, n2, n5);
        }
        return string;
    }

    protected String java_lang_String_d(int n2) {
        String string;
        int[] nArray;
        if (n2 == 39 && (this.var_bdg_a & t) != 0) {
            return this.java_lang_String_j();
        }
        if ((this.var_bdg_a & u) == 0) {
            char c2 = (char)this.int_b(n2);
            this.d(c2, "was expecting double-quote to start field name");
        }
        if ((nArray = bdt.d())[n2] != 0) {
            this.d(n2, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] nArray2 = this.var_int_arr_c;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (true) {
            if (n5 < 4) {
                ++n5;
                n4 = n4 << 8 | n2;
            } else {
                if (n3 >= nArray2.length) {
                    this.var_int_arr_c = nArray2 = bep.a(nArray2, nArray2.length);
                }
                nArray2[n3++] = n4;
                n4 = n2;
                n5 = 1;
            }
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                this.c(" in field name", bdf.f);
            }
            if (nArray[n2 = this.var_byte_arr_c[this.b] & 0xFF] != 0) break;
            this.b = this.b + true;
        }
        if (n5 > 0) {
            if (n3 >= nArray2.length) {
                this.var_int_arr_c = nArray2 = bep.a(nArray2, nArray2.length);
            }
            nArray2[n3++] = n4;
        }
        if ((string = this.var_ber_a.java_lang_String_a(nArray2, n3)) == null) {
            string = this.a(nArray2, n3, n5);
        }
        return string;
    }

    protected String java_lang_String_j() {
        String string;
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            this.c(": was expecting closing ''' for field name", bdf.f);
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
        if (n2 == 39) {
            return "";
        }
        int[] nArray = this.var_int_arr_c;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int[] nArray2 = b;
        while (n2 != 39) {
            if (nArray2[n2] != 0 && n2 != 34) {
                if (n2 != 92) {
                    this.b(n2, "name");
                } else {
                    n2 = this.char_a();
                }
                if (n2 > 127) {
                    if (n5 >= 4) {
                        if (n3 >= nArray.length) {
                            this.var_int_arr_c = nArray = bep.a(nArray, nArray.length);
                        }
                        nArray[n3++] = n4;
                        n4 = 0;
                        n5 = 0;
                    }
                    if (n2 < 2048) {
                        n4 = n4 << 8 | (0xC0 | n2 >> 6);
                        ++n5;
                    } else {
                        n4 = n4 << 8 | (0xE0 | n2 >> 12);
                        if (++n5 >= 4) {
                            if (n3 >= nArray.length) {
                                this.var_int_arr_c = nArray = bep.a(nArray, nArray.length);
                            }
                            nArray[n3++] = n4;
                            n4 = 0;
                            n5 = 0;
                        }
                        n4 = n4 << 8 | (0x80 | n2 >> 6 & 0x3F);
                        ++n5;
                    }
                    n2 = 0x80 | n2 & 0x3F;
                }
            }
            if (n5 < 4) {
                ++n5;
                n4 = n4 << 8 | n2;
            } else {
                if (n3 >= nArray.length) {
                    this.var_int_arr_c = nArray = bep.a(nArray, nArray.length);
                }
                nArray[n3++] = n4;
                n4 = n2;
                n5 = 1;
            }
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                this.c(" in field name", bdf.f);
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n2 = this.var_byte_arr_c[bep3.b] & 0xFF;
        }
        if (n5 > 0) {
            if (n3 >= nArray.length) {
                this.var_int_arr_c = nArray = bep.a(nArray, nArray.length);
            }
            nArray[n3++] = bep.int_a(n4, n5);
        }
        if ((string = this.var_ber_a.java_lang_String_a(nArray, n3)) == null) {
            string = this.a(nArray, n3, n5);
        }
        return string;
    }

    private final String java_lang_String_b(int n2, int n3) {
        String string = this.var_ber_a.java_lang_String_a(n2 = bep.int_a(n2, n3));
        if (string != null) {
            return string;
        }
        this.var_int_arr_c[0] = n2;
        return this.a(this.var_int_arr_c, 1, n3);
    }

    private final String c(int n2, int n3, int n4) {
        String string = this.var_ber_a.java_lang_String_a(n2, n3 = bep.int_a(n3, n4));
        if (string != null) {
            return string;
        }
        this.var_int_arr_c[0] = n2;
        this.var_int_arr_c[1] = n3;
        return this.a(this.var_int_arr_c, 2, n4);
    }

    private final String b(int n2, int n3, int n4, int n5) {
        String string = this.var_ber_a.java_lang_String_a(n2, n3, n4 = bep.int_a(n4, n5));
        if (string != null) {
            return string;
        }
        int[] nArray = this.var_int_arr_c;
        nArray[0] = n2;
        nArray[1] = n3;
        nArray[2] = bep.int_a(n4, n5);
        return this.a(nArray, 3, n5);
    }

    private final String a(int[] nArray, int n2, int n3, int n4) {
        if (n2 >= nArray.length) {
            nArray = bep.a(nArray, nArray.length);
            this.var_int_arr_c = nArray;
        }
        nArray[n2++] = bep.int_a(n3, n4);
        String string = this.var_ber_a.java_lang_String_a(nArray, n2);
        if (string == null) {
            return this.a(nArray, n2, n4);
        }
        return string;
    }

    private final String a(int[] nArray, int n2, int n3) {
        int n4;
        int n5 = (n2 << 2) - 4 + n3;
        if (n3 < 4) {
            n4 = nArray[n2 - 1];
            nArray[n2 - 1] = n4 << (4 - n3 << 3);
        } else {
            n4 = 0;
        }
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        int n6 = 0;
        int n7 = 0;
        while (n7 < n5) {
            int n8 = nArray[n7 >> 2];
            int n9 = n7 & 3;
            n8 = n8 >> (3 - n9 << 3) & 0xFF;
            ++n7;
            if (n8 > 127) {
                int n10;
                if ((n8 & 0xE0) == 192) {
                    n8 &= 0x1F;
                    n10 = 1;
                } else if ((n8 & 0xF0) == 224) {
                    n8 &= 0xF;
                    n10 = 2;
                } else if ((n8 & 0xF8) == 240) {
                    n8 &= 7;
                    n10 = 3;
                } else {
                    this.void_e(n8);
                    n8 = 1;
                    n10 = 1;
                }
                if (n7 + n10 > n5) {
                    this.c(" in field name", bdf.f);
                }
                int n11 = nArray[n7 >> 2];
                n9 = n7 & 3;
                ++n7;
                if (((n11 >>= 3 - n9 << 3) & 0xC0) != 128) {
                    this.void_f(n11);
                }
                n8 = n8 << 6 | n11 & 0x3F;
                if (n10 > 1) {
                    n11 = nArray[n7 >> 2];
                    n9 = n7 & 3;
                    ++n7;
                    if (((n11 >>= 3 - n9 << 3) & 0xC0) != 128) {
                        this.void_f(n11);
                    }
                    n8 = n8 << 6 | n11 & 0x3F;
                    if (n10 > 2) {
                        n11 = nArray[n7 >> 2];
                        n9 = n7 & 3;
                        ++n7;
                        if (((n11 >>= 3 - n9 << 3) & 0xC0) != 128) {
                            this.void_f(n11 & 0xFF);
                        }
                        n8 = n8 << 6 | n11 & 0x3F;
                    }
                }
                if (n10 > 2) {
                    n8 -= 65536;
                    if (n6 >= cArray.length) {
                        cArray = ((bfj)((Object)this.var_bdg_a)).f();
                    }
                    cArray[n6++] = (char)(55296 + (n8 >> 10));
                    n8 = 0xDC00 | n8 & 0x3FF;
                }
            }
            if (n6 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).f();
            }
            cArray[n6++] = (char)n8;
        }
        String string = new String(cArray, 0, n6);
        if (n3 < 4) {
            nArray[n2 - 1] = n4;
        }
        return this.var_ber_a.a(string, nArray, n2);
    }

    private static final int int_a(int n2, int n3) {
        return n3 == 4 ? n2 : n2 | -1 << (n3 << 3);
    }

    protected void void_p() {
        if (!this.boolean_j()) {
            this.void_n();
        }
    }

    @Override
    protected void void_k() {
        Object object = this.b;
        if (object >= this.var_int_arr_c) {
            this.void_p();
            object = this.b;
        }
        int n2 = 0;
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        int[] nArray = var_int_arr_d;
        int n3 = Math.min((int)this.var_int_arr_c, (int)(object + cArray.length));
        byte[] byArray = this.var_byte_arr_c;
        while (object < n3) {
            int n4 = byArray[object] & 0xFF;
            if (nArray[n4] != 0) {
                if (n4 != 34) break;
                this.b = object + true;
                ((bfj)((Object)this.var_bdg_a)).void_a(n2);
                return;
            }
            object = object + 1;
            cArray[n2++] = (char)n4;
        }
        this.b = object;
        this.a(cArray, n2);
    }

    protected String java_lang_String_k() {
        Object object = this.b;
        if (object >= this.var_int_arr_c) {
            this.void_p();
            object = this.b;
        }
        int n2 = 0;
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        int[] nArray = var_int_arr_d;
        int n3 = Math.min((int)this.var_int_arr_c, (int)(object + cArray.length));
        byte[] byArray = this.var_byte_arr_c;
        while (object < n3) {
            int n4 = byArray[object] & 0xFF;
            if (nArray[n4] != 0) {
                if (n4 != 34) break;
                this.b = object + true;
                return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a(n2);
            }
            object = object + 1;
            cArray[n2++] = (char)n4;
        }
        this.b = object;
        this.a(cArray, n2);
        return ((bfj)((Object)this.var_bdg_a)).java_lang_String_a();
    }

    private final void a(char[] cArray, int n2) {
        int[] nArray = var_int_arr_d;
        byte[] byArray = this.var_byte_arr_c;
        while (true) {
            int n3;
            Object object;
            block15: {
                if ((object = this.b) >= this.var_int_arr_c) {
                    this.void_p();
                    object = this.b;
                }
                if (n2 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_bdg_a)).e();
                    n2 = 0;
                }
                int n4 = Math.min((int)this.var_int_arr_c, (int)(object + (cArray.length - n2)));
                while (object < n4) {
                    int[] nArray2 = object;
                    object = object + 1;
                    n3 = byArray[nArray2] & 0xFF;
                    if (nArray[n3] == 0) {
                        cArray[n2++] = (char)n3;
                        continue;
                    }
                    break block15;
                }
                this.b = object;
                continue;
            }
            this.b = object;
            if (n3 == 34) break;
            switch (nArray[n3]) {
                case 1: {
                    n3 = this.char_a();
                    break;
                }
                case 2: {
                    n3 = this.int_c(n3);
                    break;
                }
                case 3: {
                    if (this.var_int_arr_c - this.b >= 2) {
                        n3 = this.int_e(n3);
                        break;
                    }
                    n3 = this.int_d(n3);
                    break;
                }
                case 4: {
                    n3 = this.int_f(n3);
                    cArray[n2++] = (char)(0xD800 | n3 >> 10);
                    if (n2 >= cArray.length) {
                        cArray = ((bfj)((Object)this.var_bdg_a)).e();
                        n2 = 0;
                    }
                    n3 = 0xDC00 | n3 & 0x3FF;
                    break;
                }
                default: {
                    if (n3 < 32) {
                        this.b(n3, "string value");
                        break;
                    }
                    this.void_d(n3);
                }
            }
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n2 = 0;
            }
            cArray[n2++] = (char)n3;
        }
        ((bfj)((Object)this.var_bdg_a)).void_a(n2);
    }

    protected void void_q() {
        this.var_boolean_d = false;
        int[] nArray = var_int_arr_d;
        byte[] byArray = this.var_byte_arr_c;
        block6: while (true) {
            int n2;
            Object object;
            block10: {
                int[] nArray2;
                if ((object = this.b) >= (nArray2 = this.var_int_arr_c)) {
                    this.void_p();
                    object = this.b;
                    nArray2 = this.var_int_arr_c;
                }
                while (object < nArray2) {
                    int[] nArray3 = object;
                    object = object + 1;
                    n2 = byArray[nArray3] & 0xFF;
                    if (nArray[n2] == 0) continue;
                    break block10;
                }
                this.b = object;
                continue;
            }
            this.b = object;
            if (n2 == 34) break;
            switch (nArray[n2]) {
                case 1: {
                    this.char_a();
                    continue block6;
                }
                case 2: {
                    this.y();
                    continue block6;
                }
                case 3: {
                    this.z();
                    continue block6;
                }
                case 4: {
                    this.h(n2);
                    continue block6;
                }
            }
            if (n2 < 32) {
                this.b(n2, "string value");
                continue;
            }
            this.void_d(n2);
        }
    }

    protected bdf bdf_b(int n2) {
        switch (n2) {
            case 93: {
                if (!((bde)((Object)this.var_bdg_a)).boolean_a()) break;
            }
            case 44: {
                if (!((bde)((Object)this.var_bdg_a)).boolean_b() && (this.var_bdg_a & s) != 0) {
                    this.b = this.b - true;
                    return bdf.m;
                }
            }
            case 125: {
                this.d(n2, "expected a value");
            }
            case 39: {
                if ((this.var_bdg_a & t) == 0) break;
                return this.bdf_g();
            }
            case 78: {
                this.a("NaN", 1);
                if ((this.var_bdg_a & r) != 0) {
                    return this.a("NaN", Double.NaN);
                }
                this.d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 73: {
                this.a("Infinity", 1);
                if ((this.var_bdg_a & r) != 0) {
                    return this.a("Infinity", Double.POSITIVE_INFINITY);
                }
                this.d("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 43: {
                if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                    this.void_a(bdf.i);
                }
                bep bep2 = this;
                bep2.b = bep2.b + true;
                return this.a(this.var_byte_arr_c[bep2.b] & 0xFF, false);
            }
        }
        if (Character.isJavaIdentifierStart(n2)) {
            this.a("" + (char)n2, this.java_lang_String_g());
        }
        this.d(n2, "expected a valid value " + this.java_lang_String_h());
        return null;
    }

    protected bdf bdf_g() {
        int n2 = 0;
        int n3 = 0;
        char[] cArray = ((bfj)((Object)this.var_bdg_a)).d();
        int[] nArray = var_int_arr_d;
        byte[] byArray = this.var_byte_arr_c;
        block6: while (true) {
            Object object;
            reference var7_7;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            if (n3 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n3 = 0;
            }
            if ((var7_7 = this.b + (cArray.length - n3)) < (object = this.var_int_arr_c)) {
                object = var7_7;
            }
            while (true) {
                if (this.b >= object) continue block6;
                bep bep2 = this;
                bep2.b = bep2.b + true;
                n2 = byArray[bep2.b] & 0xFF;
                if (n2 == 39 || nArray[n2] != 0) break;
                cArray[n3++] = (char)n2;
            }
            if (n2 == 39) break;
            switch (nArray[n2]) {
                case 1: {
                    n2 = this.char_a();
                    break;
                }
                case 2: {
                    n2 = this.int_c(n2);
                    break;
                }
                case 3: {
                    if (this.var_int_arr_c - this.b >= 2) {
                        n2 = this.int_e(n2);
                        break;
                    }
                    n2 = this.int_d(n2);
                    break;
                }
                case 4: {
                    n2 = this.int_f(n2);
                    cArray[n3++] = (char)(0xD800 | n2 >> 10);
                    if (n3 >= cArray.length) {
                        cArray = ((bfj)((Object)this.var_bdg_a)).e();
                        n3 = 0;
                    }
                    n2 = 0xDC00 | n2 & 0x3FF;
                    break;
                }
                default: {
                    if (n2 < 32) {
                        this.b(n2, "string value");
                    }
                    this.void_d(n2);
                }
            }
            if (n3 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_bdg_a)).e();
                n3 = 0;
            }
            cArray[n3++] = (char)n2;
        }
        ((bfj)((Object)this.var_bdg_a)).void_a(n3);
        return bdf.h;
    }

    protected bdf a(int n2, boolean bl2) {
        while (n2 == 73) {
            String string;
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                this.void_a(bdf.j);
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            n2 = this.var_byte_arr_c[bep2.b];
            if (n2 == 78) {
                string = bl2 ? "-INF" : "+INF";
            } else {
                if (n2 != 110) break;
                string = bl2 ? "-Infinity" : "+Infinity";
            }
            this.a(string, 3);
            if ((this.var_bdg_a & r) != 0) {
                return this.a(string, bl2 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            this.a("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", (Object)string);
        }
        this.c(n2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected final void r() {
        Object object = this.b;
        if (object + 3 < this.var_int_arr_c) {
            byte[] byArray = this.var_byte_arr_c;
            int[] nArray = object;
            object = object + 1;
            if (byArray[nArray] == 114) {
                Object object2 = object;
                object = object + 1;
                if (byArray[object2] == 117) {
                    int n2;
                    Object object3 = object;
                    object = object + 1;
                    if (byArray[object3] == 101 && ((n2 = byArray[object] & 0xFF) < 48 || n2 == 93 || n2 == 125)) {
                        this.b = object;
                        return;
                    }
                }
            }
        }
        this.b("true", 1);
    }

    protected final void s() {
        Object object = this.b;
        if (object + 4 < this.var_int_arr_c) {
            byte[] byArray = this.var_byte_arr_c;
            int[] nArray = object;
            object = object + 1;
            if (byArray[nArray] == 97) {
                Object object2 = object;
                object = object + 1;
                if (byArray[object2] == 108) {
                    Object object3 = object;
                    object = object + 1;
                    if (byArray[object3] == 115) {
                        int n2;
                        Object object4 = object;
                        object = object + 1;
                        if (byArray[object4] == 101 && ((n2 = byArray[object] & 0xFF) < 48 || n2 == 93 || n2 == 125)) {
                            this.b = object;
                            return;
                        }
                    }
                }
            }
        }
        this.b("false", 1);
    }

    protected final void t() {
        Object object = this.b;
        if (object + 3 < this.var_int_arr_c) {
            byte[] byArray = this.var_byte_arr_c;
            int[] nArray = object;
            object = object + 1;
            if (byArray[nArray] == 117) {
                Object object2 = object;
                object = object + 1;
                if (byArray[object2] == 108) {
                    int n2;
                    Object object3 = object;
                    object = object + 1;
                    if (byArray[object3] == 108 && ((n2 = byArray[object] & 0xFF) < 48 || n2 == 93 || n2 == 125)) {
                        this.b = object;
                        return;
                    }
                }
            }
        }
        this.b("null", 1);
    }

    protected final void a(String string, int n2) {
        int n3 = string.length();
        if (this.b + n3 >= this.var_int_arr_c) {
            this.b(string, n2);
            return;
        }
        do {
            if (this.var_byte_arr_c[this.b] != string.charAt(n2)) {
                this.e(string.substring(0, n2));
            }
            this.b = this.b + true;
        } while (++n2 < n3);
        int n4 = this.var_byte_arr_c[this.b] & 0xFF;
        if (n4 >= 48 && n4 != 93 && n4 != 125) {
            this.a(string, n2, n4);
        }
    }

    private final void b(String string, int n2) {
        int n3 = string.length();
        do {
            if (this.b >= this.var_int_arr_c && !this.boolean_j() || this.var_byte_arr_c[this.b] != string.charAt(n2)) {
                this.e(string.substring(0, n2));
            }
            this.b = this.b + true;
        } while (++n2 < n3);
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            return;
        }
        int n4 = this.var_byte_arr_c[this.b] & 0xFF;
        if (n4 >= 48 && n4 != 93 && n4 != 125) {
            this.a(string, n2, n4);
        }
    }

    private final void a(String string, int n2, int n3) {
        char c2 = (char)this.int_b(n3);
        if (Character.isJavaIdentifierPart(c2)) {
            this.e(string.substring(0, n2));
        }
    }

    private final int int_l() {
        while (this.b < this.var_int_arr_c) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47 || n2 == 35) {
                    this.b = this.b - true;
                    return this.int_m();
                }
                return n2;
            }
            if (n2 == 32) continue;
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                continue;
            }
            if (n2 == 13) {
                this.u();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        return this.int_m();
    }

    private final int int_m() {
        while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.v();
                    continue;
                }
                if (n2 == 35 && this.boolean_k()) continue;
                return n2;
            }
            if (n2 == 32) continue;
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                continue;
            }
            if (n2 == 13) {
                this.u();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        throw this.bdb_a("Unexpected end-of-input within/between " + (String)((bek)((Object)this.var_bdg_a)).java_lang_Object_a() + " entries");
    }

    private final int int_n() {
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            return this.int_i();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
        if (n2 > 32) {
            if (n2 == 47 || n2 == 35) {
                this.b = this.b - true;
                return this.int_o();
            }
            return n2;
        }
        if (n2 != 32) {
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
            } else if (n2 == 13) {
                this.u();
            } else if (n2 != 9) {
                this.void_c(n2);
            }
        }
        while (this.b < this.var_int_arr_c) {
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n2 = this.var_byte_arr_c[bep3.b] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47 || n2 == 35) {
                    this.b = this.b - true;
                    return this.int_o();
                }
                return n2;
            }
            if (n2 == 32) continue;
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                continue;
            }
            if (n2 == 13) {
                this.u();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        return this.int_o();
    }

    private final int int_o() {
        while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.v();
                    continue;
                }
                if (n2 == 35 && this.boolean_k()) continue;
                return n2;
            }
            if (n2 == 32) continue;
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                continue;
            }
            if (n2 == 13) {
                this.u();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        return this.int_i();
    }

    private final int int_p() {
        if (this.b + 4 >= this.var_int_arr_c) {
            return this.a(false);
        }
        byte by2 = this.var_byte_arr_c[this.b];
        if (by2 == 58) {
            reference v0 = this.b + true;
            this.b = v0;
            by2 = this.var_byte_arr_c[v0];
            if (by2 > 32) {
                if (by2 == 47 || by2 == 35) {
                    return this.a(true);
                }
                this.b = this.b + true;
                return by2;
            }
            if (by2 == 32 || by2 == 9) {
                reference v1 = this.b + true;
                this.b = v1;
                by2 = this.var_byte_arr_c[v1];
                if (by2 > 32) {
                    if (by2 == 47 || by2 == 35) {
                        return this.a(true);
                    }
                    this.b = this.b + true;
                    return by2;
                }
            }
            return this.a(true);
        }
        if (by2 == 32 || by2 == 9) {
            reference v2 = this.b + true;
            this.b = v2;
            by2 = this.var_byte_arr_c[v2];
        }
        if (by2 == 58) {
            reference v3 = this.b + true;
            this.b = v3;
            by2 = this.var_byte_arr_c[v3];
            if (by2 > 32) {
                if (by2 == 47 || by2 == 35) {
                    return this.a(true);
                }
                this.b = this.b + true;
                return by2;
            }
            if (by2 == 32 || by2 == 9) {
                reference v4 = this.b + true;
                this.b = v4;
                by2 = this.var_byte_arr_c[v4];
                if (by2 > 32) {
                    if (by2 == 47 || by2 == 35) {
                        return this.a(true);
                    }
                    this.b = this.b + true;
                    return by2;
                }
            }
            return this.a(true);
        }
        return this.a(false);
    }

    private final int a(boolean bl2) {
        while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.v();
                    continue;
                }
                if (n2 == 35 && this.boolean_k()) continue;
                if (bl2) {
                    return n2;
                }
                if (n2 != 58) {
                    this.d(n2, "was expecting a colon to separate field name and value");
                }
                bl2 = true;
                continue;
            }
            if (n2 == 32) continue;
            if (n2 == 10) {
                this.var_int_arr_d = this.var_int_arr_d + true;
                this.e = this.b;
                continue;
            }
            if (n2 == 13) {
                this.u();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        this.c(" within/between " + (String)((bek)((Object)this.var_bdg_a)).java_lang_Object_a() + " entries", null);
        return -1;
    }

    private final void v() {
        if ((this.var_bdg_a & v) == 0) {
            this.d(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            this.c(" in a comment", null);
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
        if (n2 == 47) {
            this.x();
        } else if (n2 == 42) {
            this.w();
        } else {
            this.d(n2, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void w() {
        int[] nArray = bdt.e();
        block8: while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            int n3 = nArray[n2];
            if (n3 == 0) continue;
            switch (n3) {
                case 42: {
                    if (this.b >= this.var_int_arr_c && !this.boolean_j()) break block8;
                    if (this.var_byte_arr_c[this.b] != 47) continue block8;
                    this.b = this.b + true;
                    return;
                }
                case 10: {
                    this.var_int_arr_d = this.var_int_arr_d + true;
                    this.e = this.b;
                    break;
                }
                case 13: {
                    this.u();
                    break;
                }
                case 2: {
                    this.y();
                    break;
                }
                case 3: {
                    this.z();
                    break;
                }
                case 4: {
                    this.h(n2);
                    break;
                }
                default: {
                    this.void_d(n2);
                }
            }
        }
        this.c(" in a comment", null);
    }

    private final boolean boolean_k() {
        if ((this.var_bdg_a & w) == 0) {
            return false;
        }
        this.x();
        return true;
    }

    private final void x() {
        int[] nArray = bdt.e();
        block8: while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            int n3 = nArray[n2];
            if (n3 == 0) continue;
            switch (n3) {
                case 10: {
                    this.var_int_arr_d = this.var_int_arr_d + true;
                    this.e = this.b;
                    return;
                }
                case 13: {
                    this.u();
                    return;
                }
                case 42: {
                    continue block8;
                }
                case 2: {
                    this.y();
                    continue block8;
                }
                case 3: {
                    this.z();
                    continue block8;
                }
                case 4: {
                    this.h(n2);
                    continue block8;
                }
            }
            if (n3 >= 0) continue;
            this.void_d(n2);
        }
    }

    @Override
    protected char char_a() {
        if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
            this.c(" in character escape sequence", bdf.h);
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        switch (by2) {
            case 98: {
                return '\b';
            }
            case 116: {
                return '\t';
            }
            case 110: {
                return '\n';
            }
            case 102: {
                return '\f';
            }
            case 114: {
                return '\r';
            }
            case 34: 
            case 47: 
            case 92: {
                return (char)by2;
            }
            case 117: {
                break;
            }
            default: {
                return this.a((char)this.int_b(by2));
            }
        }
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.b >= this.var_int_arr_c && !this.boolean_j()) {
                this.c(" in character escape sequence", bdf.h);
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            byte by3 = this.var_byte_arr_c[bep3.b];
            int n3 = bdt.int_a(by3);
            if (n3 < 0) {
                this.d(by3 & 0xFF, "expected a hex-digit for character escape sequence");
            }
            n2 = n2 << 4 | n3;
        }
        return (char)n2;
    }

    protected int int_b(int n2) {
        int n3 = n2 & 0xFF;
        if (n3 > 127) {
            int n4;
            if ((n3 & 0xE0) == 192) {
                n3 &= 0x1F;
                n4 = 1;
            } else if ((n3 & 0xF0) == 224) {
                n3 &= 0xF;
                n4 = 2;
            } else if ((n3 & 0xF8) == 240) {
                n3 &= 7;
                n4 = 3;
            } else {
                this.void_e(n3 & 0xFF);
                n4 = 1;
            }
            int n5 = this.int_q();
            if ((n5 & 0xC0) != 128) {
                this.void_f(n5 & 0xFF);
            }
            n3 = n3 << 6 | n5 & 0x3F;
            if (n4 > 1) {
                n5 = this.int_q();
                if ((n5 & 0xC0) != 128) {
                    this.void_f(n5 & 0xFF);
                }
                n3 = n3 << 6 | n5 & 0x3F;
                if (n4 > 2) {
                    n5 = this.int_q();
                    if ((n5 & 0xC0) != 128) {
                        this.void_f(n5 & 0xFF);
                    }
                    n3 = n3 << 6 | n5 & 0x3F;
                }
            }
        }
        return n3;
    }

    private final int int_c(int n2) {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        return (n2 & 0x1F) << 6 | by2 & 0x3F;
    }

    private final int int_d(int n2) {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        n2 &= 0xF;
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        int n3 = n2 << 6 | by2 & 0x3F;
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep3 = this;
        bep3.b = bep3.b + true;
        by2 = this.var_byte_arr_c[bep3.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        n3 = n3 << 6 | by2 & 0x3F;
        return n3;
    }

    private final int int_e(int n2) {
        n2 &= 0xF;
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        int n3 = n2 << 6 | by2 & 0x3F;
        bep bep3 = this;
        bep3.b = bep3.b + true;
        by2 = this.var_byte_arr_c[bep3.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        n3 = n3 << 6 | by2 & 0x3F;
        return n3;
    }

    private final int int_f(int n2) {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        n2 = (n2 & 7) << 6 | by2 & 0x3F;
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep3 = this;
        bep3.b = bep3.b + true;
        by2 = this.var_byte_arr_c[bep3.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        n2 = n2 << 6 | by2 & 0x3F;
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep4 = this;
        bep4.b = bep4.b + true;
        by2 = this.var_byte_arr_c[bep4.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        return (n2 << 6 | by2 & 0x3F) - 65536;
    }

    private final void y() {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
    }

    private final void z() {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep3 = this;
        bep3.b = bep3.b + true;
        by2 = this.var_byte_arr_c[bep3.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
    }

    private final void h(int n2) {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        byte by2 = this.var_byte_arr_c[bep2.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep3 = this;
        bep3.b = bep3.b + true;
        by2 = this.var_byte_arr_c[bep3.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep4 = this;
        bep4.b = bep4.b + true;
        by2 = this.var_byte_arr_c[bep4.b];
        if ((by2 & 0xC0) != 128) {
            this.void_b(by2 & 0xFF, (int)this.b);
        }
    }

    protected final void u() {
        if ((this.b < this.var_int_arr_c || this.boolean_j()) && this.var_byte_arr_c[this.b] == 10) {
            this.b = this.b + true;
        }
        this.var_int_arr_d = this.var_int_arr_d + true;
        this.e = this.b;
    }

    private int int_q() {
        if (this.b >= this.var_int_arr_c) {
            this.void_p();
        }
        bep bep2 = this;
        bep2.b = bep2.b + true;
        return this.var_byte_arr_c[bep2.b] & 0xFF;
    }

    protected void e(String string) {
        this.a(string, this.java_lang_String_g());
    }

    protected void a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string);
        while (this.b < this.var_int_arr_c || this.boolean_j()) {
            bep bep2 = this;
            bep2.b = bep2.b + true;
            byte by2 = this.var_byte_arr_c[bep2.b];
            char c2 = (char)this.int_b(by2);
            if (!Character.isJavaIdentifierPart(c2)) break;
            stringBuilder.append(c2);
            if (stringBuilder.length() < 256) continue;
            stringBuilder.append("...");
            break;
        }
        this.a("Unrecognized token '%s': was expecting %s", stringBuilder, string2);
    }

    protected void void_d(int n2) {
        if (n2 < 32) {
            this.void_c(n2);
        }
        this.void_e(n2);
    }

    protected void void_e(int n2) {
        this.d("Invalid UTF-8 start byte 0x" + Integer.toHexString(n2));
    }

    protected void void_f(int n2) {
        this.d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(n2));
    }

    protected void void_b(int n2, int n3) {
        this.b = (int[])n3;
        this.void_f(n2);
    }

    protected final byte[] b(bcq bcq2) {
        bex bex2 = this.bex_a();
        while (true) {
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep2 = this;
            bep2.b = bep2.b + true;
            int n2 = this.var_byte_arr_c[bep2.b] & 0xFF;
            if (n2 <= 32) continue;
            int n3 = bcq2.int_a(n2);
            if (n3 < 0) {
                if (n2 == 34) {
                    return bex2.byte_arr_a();
                }
                n3 = this.int_a(bcq2, n2, 0);
                if (n3 < 0) continue;
            }
            int n4 = n3;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep3 = this;
            bep3.b = bep3.b + true;
            n2 = this.var_byte_arr_c[bep3.b] & 0xFF;
            n3 = bcq2.int_a(n2);
            if (n3 < 0) {
                n3 = this.int_a(bcq2, n2, 1);
            }
            n4 = n4 << 6 | n3;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep4 = this;
            bep4.b = bep4.b + true;
            n2 = this.var_byte_arr_c[bep4.b] & 0xFF;
            n3 = bcq2.int_a(n2);
            if (n3 < 0) {
                if (n3 != -2) {
                    if (n2 == 34) {
                        bex2.void_a(n4 >>= 4);
                        if (bcq2.boolean_a()) {
                            this.b = this.b - true;
                            this.void_a(bcq2);
                        }
                        return bex2.byte_arr_a();
                    }
                    n3 = this.int_a(bcq2, n2, 2);
                }
                if (n3 == -2) {
                    if (this.b >= this.var_int_arr_c) {
                        this.void_p();
                    }
                    bep bep5 = this;
                    bep5.b = bep5.b + true;
                    n2 = this.var_byte_arr_c[bep5.b] & 0xFF;
                    if (!bcq2.boolean_a(n2) && this.int_a(bcq2, n2, 3) != -2) {
                        throw this.a(bcq2, n2, 3, "expected padding character '" + bcq2.char_a() + "'");
                    }
                    bex2.void_a(n4 >>= 4);
                    continue;
                }
            }
            n4 = n4 << 6 | n3;
            if (this.b >= this.var_int_arr_c) {
                this.void_p();
            }
            bep bep6 = this;
            bep6.b = bep6.b + true;
            n2 = this.var_byte_arr_c[bep6.b] & 0xFF;
            n3 = bcq2.int_a(n2);
            if (n3 < 0) {
                if (n3 != -2) {
                    if (n2 == 34) {
                        bex2.b(n4 >>= 2);
                        if (bcq2.boolean_a()) {
                            this.b = this.b - true;
                            this.void_a(bcq2);
                        }
                        return bex2.byte_arr_a();
                    }
                    n3 = this.int_a(bcq2, n2, 3);
                }
                if (n3 == -2) {
                    bex2.b(n4 >>= 2);
                    continue;
                }
            }
            n4 = n4 << 6 | n3;
            bex2.c(n4);
        }
    }

    @Override
    public bda bda_a() {
        if (this.b == bdf.f) {
            reference var1_1 = this.var_bdg_a + (long)(this.m - 1);
            return new bda(this.java_lang_Object_d(), (long)var1_1, -1L, this.n, this.o);
        }
        return new bda(this.java_lang_Object_d(), (long)(this.b - 1L), -1L, this.f, this.g);
    }

    @Override
    public bda bda_b() {
        reference var1_1 = this.b - this.e + true;
        return new bda(this.java_lang_Object_d(), (long)(this.var_bdg_a + (long)this.b), -1L, (int)this.var_int_arr_d, (int)var1_1);
    }

    private final void A() {
        this.f = (int)this.var_int_arr_d;
        int[] nArray = this.b;
        this.b = this.var_bdg_a + (long)nArray;
        this.g = (int)(nArray - this.e);
    }

    private final void B() {
        this.n = (int)this.var_int_arr_d;
        int[] nArray = this.b;
        this.m = (int)nArray;
        this.o = (int)(nArray - this.e);
    }

    private final bdf bdf_d(int n2) {
        if (n2 == 125) {
            this.D();
            bdf bdf2 = bdf.var_bdf_c;
            this.b = (int[])bdf2;
            return bdf2;
        }
        this.C();
        bdf bdf3 = bdf.var_bdf_e;
        this.b = (int[])bdf3;
        return bdf3;
    }

    private final void C() {
        this.A();
        if (!((bde)((Object)this.var_bdg_a)).boolean_a()) {
            this.a(93, '}');
        }
        this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).bek_b();
    }

    private final void D() {
        this.A();
        if (!((bde)((Object)this.var_bdg_a)).boolean_c()) {
            this.a(125, ']');
        }
        this.var_bdg_a = ((bek)((Object)this.var_bdg_a)).bek_b();
    }

    static {
        var_int_arr_d = bdt.b();
        b = bdt.int_arr_a();
    }
}

