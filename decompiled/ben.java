/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class ben
extends bdo {
    private static final int p = bdc.a.l.b();
    private static final int q = bdc.a.h.b();
    private static final int r = bdc.a.j.b();
    private static final int s = bdc.a.k.b();
    private static final int t = bdc.a.e.b();
    private static final int u = bdc.a.d.b();
    private static final int v = bdc.a.b.b();
    private static final int w = bdc.a.c.b();
    protected static final int[] var_int_arr_b;
    protected Reader var_java_io_Reader_a;
    protected char[] var_char_arr_b;
    protected boolean var_boolean_d;
    protected bdg var_bdg_a;
    protected final bes var_bes_a;
    protected final int m;
    protected boolean e;
    protected long var_long_d;
    protected int n;
    protected int o;

    public ben(bdv bdv2, int n2, Reader reader, bdg bdg2, bes bes2) {
        super(bdv2, n2);
        this.var_java_io_Reader_a = reader;
        this.var_char_arr_b = bdv2.char_arr_a();
        this.var_int_arr_b = (int[])false;
        this.c = 0;
        this.var_bdg_a = bdg2;
        this.var_bes_a = bes2;
        this.m = bes2.int_a();
        this.var_boolean_d = true;
    }

    @Override
    public bdg bdg_a() {
        return this.var_bdg_a;
    }

    @Override
    public bfd<bdj> a() {
        return var_int_arr_b;
    }

    @Deprecated
    protected char char_a(String string) {
        return this.char_a(string, (bdf)null);
    }

    protected char char_a(String string, bdf bdf2) {
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            this.c(string, bdf2);
        }
        ben ben2 = this;
        ben2.var_int_arr_b = ben2.var_int_arr_b + true;
        return this.var_char_arr_b[ben2.var_int_arr_b];
    }

    @Override
    protected void void_c() {
        if (this.var_java_io_Reader_a != null) {
            if (((bdv)((Object)this.var_java_io_Reader_a)).boolean_a() || this.a(bdc.a.var_bdc$a_a)) {
                this.var_java_io_Reader_a.close();
            }
            this.var_java_io_Reader_a = null;
        }
    }

    @Override
    protected void void_d() {
        char[] cArray;
        super.void_d();
        this.var_bes_a.void_a();
        if (this.var_boolean_d && (cArray = this.var_char_arr_b) != null) {
            this.var_char_arr_b = null;
            ((bdv)((Object)this.var_java_io_Reader_a)).a(cArray);
        }
    }

    protected void p() {
        if (!this.boolean_j()) {
            this.void_n();
        }
    }

    protected boolean boolean_j() {
        if (this.var_java_io_Reader_a != null) {
            int n2 = this.var_java_io_Reader_a.read(this.var_char_arr_b, 0, this.var_char_arr_b.length);
            if (n2 > 0) {
                int n3 = this.c;
                this.var_java_io_Reader_a += (long)n3;
                this.e -= n3;
                this.var_long_d -= (long)n3;
                this.var_int_arr_b = (int[])false;
                this.c = n2;
                return true;
            }
            this.void_c();
            if (n2 == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.c);
            }
        }
        return false;
    }

    @Override
    public final String java_lang_String_e() {
        if (this.var_int_arr_b == bdf.h) {
            if (this.e) {
                this.e = false;
                this.void_k();
            }
            return ((bfj)((Object)this.var_java_io_Reader_a)).java_lang_String_a();
        }
        return this.java_lang_String_a((bdf)this.var_int_arr_b);
    }

    @Override
    public final String java_lang_String_f() {
        if (this.var_int_arr_b == bdf.h) {
            if (this.e) {
                this.e = false;
                this.void_k();
            }
            return ((bfj)((Object)this.var_java_io_Reader_a)).java_lang_String_a();
        }
        if (this.var_int_arr_b == bdf.f) {
            return this.java_lang_String_c();
        }
        return super.java_lang_String_a((String)null);
    }

    @Override
    public final String java_lang_String_a(String string) {
        if (this.var_int_arr_b == bdf.h) {
            if (this.e) {
                this.e = false;
                this.void_k();
            }
            return ((bfj)((Object)this.var_java_io_Reader_a)).java_lang_String_a();
        }
        if (this.var_int_arr_b == bdf.f) {
            return this.java_lang_String_c();
        }
        return super.java_lang_String_a(string);
    }

    protected final String java_lang_String_a(bdf bdf2) {
        if (bdf2 == null) {
            return null;
        }
        switch (bdf2.int_a()) {
            case 5: {
                return ((bek)((Object)this.var_java_io_Reader_a)).java_lang_String_b();
            }
            case 6: 
            case 7: 
            case 8: {
                return ((bfj)((Object)this.var_java_io_Reader_a)).java_lang_String_a();
            }
        }
        return bdf2.java_lang_String_a();
    }

    @Override
    public final char[] char_arr_a() {
        if (this.var_int_arr_b != null) {
            switch (this.var_int_arr_b.int_a()) {
                case 5: {
                    if (this.var_int_arr_b == false) {
                        String string = ((bek)((Object)this.var_java_io_Reader_a)).java_lang_String_b();
                        int n2 = string.length();
                        if (this.var_java_io_Reader_a == null) {
                            this.var_java_io_Reader_a = ((bdv)((Object)this.var_java_io_Reader_a)).a(n2);
                        } else if (((Reader)this.var_java_io_Reader_a).length < n2) {
                            this.var_java_io_Reader_a = new char[n2];
                        }
                        string.getChars(0, n2, (char[])this.var_java_io_Reader_a, 0);
                        this.var_int_arr_b = (int[])true;
                    }
                    return this.var_java_io_Reader_a;
                }
                case 6: {
                    if (this.e) {
                        this.e = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_java_io_Reader_a)).char_arr_a();
                }
            }
            return this.var_int_arr_b.char_arr_a();
        }
        return null;
    }

    @Override
    public final int int_c() {
        if (this.var_int_arr_b != null) {
            switch (this.var_int_arr_b.int_a()) {
                case 5: {
                    return ((bek)((Object)this.var_java_io_Reader_a)).java_lang_String_b().length();
                }
                case 6: {
                    if (this.e) {
                        this.e = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_java_io_Reader_a)).int_a();
                }
            }
            return this.var_int_arr_b.char_arr_a().length;
        }
        return 0;
    }

    @Override
    public final int int_d() {
        if (this.var_int_arr_b != null) {
            switch (this.var_int_arr_b.int_a()) {
                case 5: {
                    return 0;
                }
                case 6: {
                    if (this.e) {
                        this.e = false;
                        this.void_k();
                    }
                }
                case 7: 
                case 8: {
                    return ((bfj)((Object)this.var_java_io_Reader_a)).int_b();
                }
            }
        }
        return 0;
    }

    @Override
    public byte[] byte_arr_a(bcq bcq2) {
        if (this.var_int_arr_b == bdf.g && this.var_java_io_Reader_a != null) {
            return this.var_java_io_Reader_a;
        }
        if (this.var_int_arr_b != bdf.h) {
            this.d("Current token (" + this.var_int_arr_b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.e) {
            try {
                this.var_java_io_Reader_a = this.b(bcq2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw this.bdb_a("Failed to decode VALUE_STRING as base64 (" + bcq2 + "): " + illegalArgumentException.getMessage());
            }
            this.e = false;
        } else if (this.var_java_io_Reader_a == null) {
            bex bex2 = this.bex_a();
            this.a(this.java_lang_String_e(), bex2, bcq2);
            this.var_java_io_Reader_a = bex2.byte_arr_a();
        }
        return this.var_java_io_Reader_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int a(bcq bcq2, OutputStream outputStream) {
        if (!this.e || this.var_int_arr_b != bdf.h) {
            byte[] byArray = this.byte_arr_a(bcq2);
            outputStream.write(byArray);
            return byArray.length;
        }
        byte[] byArray = ((bdv)((Object)this.var_java_io_Reader_a)).c();
        try {
            int n2 = this.a(bcq2, outputStream, byArray);
            return n2;
        }
        finally {
            ((bdv)((Object)this.var_java_io_Reader_a)).c(byArray);
        }
    }

    protected int a(bcq bcq2, OutputStream outputStream, byte[] byArray) {
        int n2 = 0;
        int n3 = byArray.length - 3;
        int n4 = 0;
        while (true) {
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 <= ' ') continue;
            int n5 = bcq2.int_a(c2);
            if (n5 < 0) {
                if (c2 == '\"') break;
                n5 = this.a(bcq2, c2, 0);
                if (n5 < 0) continue;
            }
            if (n2 > n3) {
                n4 += n2;
                outputStream.write(byArray, 0, n2);
                n2 = 0;
            }
            int n6 = n5;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben3 = this;
            ben3.var_int_arr_b = ben3.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben3.var_int_arr_b];
            n5 = bcq2.int_a(c2);
            if (n5 < 0) {
                n5 = this.a(bcq2, c2, 1);
            }
            n6 = n6 << 6 | n5;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben4 = this;
            ben4.var_int_arr_b = ben4.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben4.var_int_arr_b];
            n5 = bcq2.int_a(c2);
            if (n5 < 0) {
                if (n5 != -2) {
                    if (c2 == '\"') {
                        byArray[n2++] = (byte)(n6 >>= 4);
                        if (!bcq2.boolean_a()) break;
                        this.var_int_arr_b = this.var_int_arr_b - true;
                        this.void_a(bcq2);
                        break;
                    }
                    n5 = this.a(bcq2, c2, 2);
                }
                if (n5 == -2) {
                    if (this.var_int_arr_b >= this.c) {
                        this.p();
                    }
                    ben ben5 = this;
                    ben5.var_int_arr_b = ben5.var_int_arr_b + true;
                    c2 = this.var_char_arr_b[ben5.var_int_arr_b];
                    if (!bcq2.boolean_a(c2) && this.a(bcq2, c2, 3) != -2) {
                        throw this.a(bcq2, (int)c2, 3, "expected padding character '" + bcq2.char_a() + "'");
                    }
                    byArray[n2++] = (byte)(n6 >>= 4);
                    continue;
                }
            }
            n6 = n6 << 6 | n5;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben6 = this;
            ben6.var_int_arr_b = ben6.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben6.var_int_arr_b];
            n5 = bcq2.int_a(c2);
            if (n5 < 0) {
                if (n5 != -2) {
                    if (c2 == '\"') {
                        byArray[n2++] = (byte)((n6 >>= 2) >> 8);
                        byArray[n2++] = (byte)n6;
                        if (!bcq2.boolean_a()) break;
                        this.var_int_arr_b = this.var_int_arr_b - true;
                        this.void_a(bcq2);
                        break;
                    }
                    n5 = this.a(bcq2, c2, 3);
                }
                if (n5 == -2) {
                    byArray[n2++] = (byte)((n6 >>= 2) >> 8);
                    byArray[n2++] = (byte)n6;
                    continue;
                }
            }
            n6 = n6 << 6 | n5;
            byArray[n2++] = (byte)(n6 >> 16);
            byArray[n2++] = (byte)(n6 >> 8);
            byArray[n2++] = (byte)n6;
        }
        this.e = false;
        if (n2 > 0) {
            n4 += n2;
            outputStream.write(byArray, 0, n2);
        }
        return n4;
    }

    @Override
    public final bdf bdf_a() {
        Object object;
        boolean bl2;
        int n2;
        if (this.var_int_arr_b == bdf.f) {
            return this.bdf_h();
        }
        this.h = 0;
        if (this.e) {
            this.r();
        }
        if ((n2 = this.int_m()) < 0) {
            this.close();
            this.var_int_arr_b = null;
            return null;
        }
        this.var_java_io_Reader_a = null;
        if (n2 == 93 || n2 == 125) {
            this.e(n2);
            return this.var_int_arr_b;
        }
        if (((bek)((Object)this.var_java_io_Reader_a)).d()) {
            n2 = this.int_b(n2);
            if ((this.var_java_io_Reader_a & p) != 0 && (n2 == 93 || n2 == 125)) {
                this.e(n2);
                return this.var_int_arr_b;
            }
        }
        if (bl2 = ((bde)((Object)this.var_java_io_Reader_a)).boolean_c()) {
            this.A();
            object = n2 == 34 ? this.java_lang_String_i() : this.java_lang_String_b(n2);
            ((bek)((Object)this.var_java_io_Reader_a)).a((String)object);
            this.var_int_arr_b = (int[])bdf.f;
            n2 = this.int_k();
        }
        this.z();
        switch (n2) {
            case 34: {
                this.e = true;
                object = bdf.h;
                break;
            }
            case 91: {
                if (!bl2) {
                    this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).a(this.f, this.g);
                }
                object = bdf.var_bdf_d;
                break;
            }
            case 123: {
                if (!bl2) {
                    this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).b(this.f, this.g);
                }
                object = bdf.var_bdf_b;
                break;
            }
            case 125: {
                this.d(n2, "expected a value");
            }
            case 116: {
                this.w();
                object = bdf.k;
                break;
            }
            case 102: {
                this.x();
                object = bdf.l;
                break;
            }
            case 110: {
                this.y();
                object = bdf.m;
                break;
            }
            case 45: {
                object = this.bdf_f();
                break;
            }
            case 46: {
                object = this.bdf_e();
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
                object = this.bdf_a(n2);
                break;
            }
            default: {
                object = this.bdf_b(n2);
            }
        }
        if (bl2) {
            this.var_java_io_Reader_a = object;
            return this.var_int_arr_b;
        }
        this.var_int_arr_b = (int[])object;
        return object;
    }

    private final bdf bdf_h() {
        this.var_int_arr_b = (int[])false;
        Reader reader = this.var_java_io_Reader_a;
        this.var_java_io_Reader_a = null;
        if (reader == bdf.var_bdf_d) {
            this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).a(this.f, this.g);
        } else if (reader == bdf.var_bdf_b) {
            this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).b(this.f, this.g);
        }
        Reader reader2 = reader;
        this.var_int_arr_b = (int[])reader2;
        return reader2;
    }

    @Override
    public String java_lang_String_a() {
        bdf bdf2;
        int n2;
        this.h = 0;
        if (this.var_int_arr_b == bdf.f) {
            this.bdf_h();
            return null;
        }
        if (this.e) {
            this.r();
        }
        if ((n2 = this.int_m()) < 0) {
            this.close();
            this.var_int_arr_b = null;
            return null;
        }
        this.var_java_io_Reader_a = null;
        if (n2 == 93 || n2 == 125) {
            this.e(n2);
            return null;
        }
        if (((bek)((Object)this.var_java_io_Reader_a)).d()) {
            n2 = this.int_b(n2);
            if ((this.var_java_io_Reader_a & p) != 0 && (n2 == 93 || n2 == 125)) {
                this.e(n2);
                return null;
            }
        }
        if (!((bde)((Object)this.var_java_io_Reader_a)).boolean_c()) {
            this.z();
            this.bdf_c(n2);
            return null;
        }
        this.A();
        String string = n2 == 34 ? this.java_lang_String_i() : this.java_lang_String_b(n2);
        ((bek)((Object)this.var_java_io_Reader_a)).a(string);
        this.var_int_arr_b = (int[])bdf.f;
        n2 = this.int_k();
        this.z();
        if (n2 == 34) {
            this.e = true;
            this.var_java_io_Reader_a = bdf.h;
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
                this.x();
                bdf2 = bdf.l;
                break;
            }
            case 110: {
                this.y();
                bdf2 = bdf.m;
                break;
            }
            case 116: {
                this.w();
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
        this.var_java_io_Reader_a = bdf2;
        return string;
    }

    private final bdf bdf_c(int n2) {
        if (n2 == 34) {
            this.e = true;
            bdf bdf2 = bdf.h;
            this.var_int_arr_b = (int[])bdf2;
            return bdf2;
        }
        switch (n2) {
            case 91: {
                this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).a(this.f, this.g);
                bdf bdf3 = bdf.var_bdf_d;
                this.var_int_arr_b = (int[])bdf3;
                return bdf3;
            }
            case 123: {
                this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).b(this.f, this.g);
                bdf bdf4 = bdf.var_bdf_b;
                this.var_int_arr_b = (int[])bdf4;
                return bdf4;
            }
            case 116: {
                this.a("true", 1);
                bdf bdf5 = bdf.k;
                this.var_int_arr_b = (int[])bdf5;
                return bdf5;
            }
            case 102: {
                this.a("false", 1);
                bdf bdf6 = bdf.l;
                this.var_int_arr_b = (int[])bdf6;
                return bdf6;
            }
            case 110: {
                this.a("null", 1);
                bdf bdf7 = bdf.m;
                this.var_int_arr_b = (int[])bdf7;
                return bdf7;
            }
            case 45: {
                bdf bdf8 = this.bdf_f();
                this.var_int_arr_b = (int[])bdf8;
                return bdf8;
            }
            case 46: {
                bdf bdf9 = this.bdf_e();
                this.var_int_arr_b = (int[])bdf9;
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
                this.var_int_arr_b = (int[])bdf10;
                return bdf10;
            }
            case 44: {
                if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b() || (this.var_java_io_Reader_a & s) == 0) break;
                this.var_int_arr_b = this.var_int_arr_b - true;
                bdf bdf11 = bdf.m;
                this.var_int_arr_b = (int[])bdf11;
                return bdf11;
            }
        }
        bdf bdf12 = this.bdf_b(n2);
        this.var_int_arr_b = (int[])bdf12;
        return bdf12;
    }

    @Override
    public final String java_lang_String_b() {
        if (this.var_int_arr_b == bdf.f) {
            this.var_int_arr_b = (int[])false;
            Reader reader = this.var_java_io_Reader_a;
            this.var_java_io_Reader_a = null;
            this.var_int_arr_b = (int[])reader;
            if (reader == bdf.h) {
                if (this.e) {
                    this.e = false;
                    this.void_k();
                }
                return ((bfj)((Object)this.var_java_io_Reader_a)).java_lang_String_a();
            }
            if (reader == bdf.var_bdf_d) {
                this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).a(this.f, this.g);
            } else if (reader == bdf.var_bdf_b) {
                this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).b(this.f, this.g);
            }
            return null;
        }
        return this.bdf_a() == bdf.h ? this.java_lang_String_e() : null;
    }

    protected final bdf bdf_e() {
        if (!this.a(bel.h.bdc$a_a())) {
            return this.bdf_b(46);
        }
        return this.a(46, (int)(this.var_int_arr_b - true), (int)this.var_int_arr_b, false, 0);
    }

    protected final bdf bdf_a(int n2) {
        Object object = this.var_int_arr_b;
        reference var3_3 = object - true;
        int n3 = this.c;
        if (n2 == 48) {
            return this.b(false, (int)var3_3);
        }
        int n4 = 1;
        while (true) {
            if (object >= n3) {
                this.var_int_arr_b = var3_3;
                return this.b(false, (int)var3_3);
            }
            int[] nArray = object;
            object = object + 1;
            n2 = this.var_char_arr_b[nArray];
            if (n2 < 48 || n2 > 57) break;
            ++n4;
        }
        if (n2 == 46 || n2 == 101 || n2 == 69) {
            this.var_int_arr_b = object;
            return this.a(n2, (int)var3_3, (int)object, false, n4);
        }
        this.var_int_arr_b = object = (Object)(object - 1);
        if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b()) {
            this.d(n2);
        }
        reference var6_6 = object - var3_3;
        ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, (int)var3_3, (int)var6_6);
        return this.a(false, n4);
    }

    private final bdf a(int n2, int n3, int n4, boolean bl2, int n5) {
        int n6 = this.c;
        int n7 = 0;
        if (n2 == 46) {
            while (true) {
                if (n4 >= n6) {
                    return this.b(bl2, n3);
                }
                if ((n2 = this.var_char_arr_b[n4++]) < 48 || n2 > 57) break;
                ++n7;
            }
            if (n7 == 0) {
                this.c(n2, "Decimal point not followed by a digit");
            }
        }
        int n8 = 0;
        if (n2 == 101 || n2 == 69) {
            if (n4 >= n6) {
                this.var_int_arr_b = (int[])n3;
                return this.b(bl2, n3);
            }
            if ((n2 = this.var_char_arr_b[n4++]) == 45 || n2 == 43) {
                if (n4 >= n6) {
                    this.var_int_arr_b = (int[])n3;
                    return this.b(bl2, n3);
                }
                n2 = this.var_char_arr_b[n4++];
            }
            while (n2 <= 57 && n2 >= 48) {
                ++n8;
                if (n4 >= n6) {
                    this.var_int_arr_b = (int[])n3;
                    return this.b(bl2, n3);
                }
                n2 = this.var_char_arr_b[n4++];
            }
            if (n8 == 0) {
                this.c(n2, "Exponent indicator not followed by a digit");
            }
        }
        this.var_int_arr_b = (int[])(--n4);
        if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b()) {
            this.d(n2);
        }
        int n9 = n4 - n3;
        ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, n3, n9);
        return this.b(bl2, n5, n7, n8);
    }

    protected final bdf bdf_f() {
        Object object = this.var_int_arr_b;
        reference var2_2 = object - true;
        int n2 = this.c;
        if (object >= n2) {
            return this.b(true, (int)var2_2);
        }
        int[] nArray = object;
        object = object + 1;
        char c2 = this.var_char_arr_b[nArray];
        if (c2 > '9' || c2 < '0') {
            this.var_int_arr_b = object;
            return this.a((int)c2, true);
        }
        if (c2 == '0') {
            return this.b(true, (int)var2_2);
        }
        int n3 = 1;
        while (true) {
            if (object >= n2) {
                return this.b(true, (int)var2_2);
            }
            Object object2 = object;
            object = object + 1;
            c2 = this.var_char_arr_b[object2];
            if (c2 < '0' || c2 > '9') break;
            ++n3;
        }
        if (c2 == '.' || c2 == 'e' || c2 == 'E') {
            this.var_int_arr_b = object;
            return this.a(c2, (int)var2_2, (int)object, true, n3);
        }
        this.var_int_arr_b = object = (Object)(object - 1);
        if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b()) {
            this.d(c2);
        }
        reference var6_6 = object - var2_2;
        ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, (int)var2_2, (int)var6_6);
        return this.a(true, n3);
    }

    private final bdf b(boolean bl2, int n2) {
        char c2;
        char c3;
        this.var_int_arr_b = (int[])(bl2 ? n2 + 1 : n2);
        char[] cArray = ((bfj)((Object)this.var_java_io_Reader_a)).d();
        int n3 = 0;
        if (bl2) {
            cArray[n3++] = 45;
        }
        int n4 = 0;
        if (this.var_int_arr_b < this.c) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            c3 = this.var_char_arr_b[ben2.var_int_arr_b];
        } else {
            c3 = c2 = this.char_a("No digit following minus sign", bdf.i);
        }
        if (c2 == '0') {
            c2 = this.char_b();
        }
        boolean bl3 = false;
        while (c2 >= '0' && c2 <= '9') {
            ++n4;
            if (n3 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                n3 = 0;
            }
            cArray[n3++] = c2;
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                c2 = '\u0000';
                bl3 = true;
                break;
            }
            ben ben3 = this;
            ben3.var_int_arr_b = ben3.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben3.var_int_arr_b];
        }
        if (n4 == 0) {
            return this.a((int)c2, bl2);
        }
        int n5 = 0;
        if (c2 == '.') {
            if (n3 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                n3 = 0;
            }
            cArray[n3++] = c2;
            while (true) {
                if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                    bl3 = true;
                    break;
                }
                ben ben4 = this;
                ben4.var_int_arr_b = ben4.var_int_arr_b + true;
                c2 = this.var_char_arr_b[ben4.var_int_arr_b];
                if (c2 < '0' || c2 > '9') break;
                ++n5;
                if (n3 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                    n3 = 0;
                }
                cArray[n3++] = c2;
            }
            if (n5 == 0) {
                this.c(c2, "Decimal point not followed by a digit");
            }
        }
        int n6 = 0;
        if (c2 == 'e' || c2 == 'E') {
            char c4;
            if (n3 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                n3 = 0;
            }
            cArray[n3++] = c2;
            if (this.var_int_arr_b < this.c) {
                ben ben5 = this;
                ben5.var_int_arr_b = ben5.var_int_arr_b + true;
                c4 = this.var_char_arr_b[ben5.var_int_arr_b];
            } else {
                c4 = c2 = this.char_a("expected a digit for number exponent");
            }
            if (c2 == '-' || c2 == '+') {
                char c5;
                if (n3 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                    n3 = 0;
                }
                cArray[n3++] = c2;
                if (this.var_int_arr_b < this.c) {
                    ben ben6 = this;
                    ben6.var_int_arr_b = ben6.var_int_arr_b + true;
                    c5 = this.var_char_arr_b[ben6.var_int_arr_b];
                } else {
                    c5 = c2 = this.char_a("expected a digit for number exponent");
                }
            }
            while (c2 <= '9' && c2 >= '0') {
                ++n6;
                if (n3 >= cArray.length) {
                    cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                    n3 = 0;
                }
                cArray[n3++] = c2;
                if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                    bl3 = true;
                    break;
                }
                ben ben7 = this;
                ben7.var_int_arr_b = ben7.var_int_arr_b + true;
                c2 = this.var_char_arr_b[ben7.var_int_arr_b];
            }
            if (n6 == 0) {
                this.c(c2, "Exponent indicator not followed by a digit");
            }
        }
        if (!bl3) {
            this.var_int_arr_b = this.var_int_arr_b - true;
            if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b()) {
                this.d(c2);
            }
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).void_a(n3);
        return this.a(bl2, n4, n5, n6);
    }

    private final char char_b() {
        char c2;
        if (this.var_int_arr_b < this.c && ((c2 = this.var_char_arr_b[this.var_int_arr_b]) < '0' || c2 > '9')) {
            return '0';
        }
        return this.char_c();
    }

    private char char_c() {
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            return '0';
        }
        char c2 = this.var_char_arr_b[this.var_int_arr_b];
        if (c2 < '0' || c2 > '9') {
            return '0';
        }
        if ((this.var_java_io_Reader_a & q) == 0) {
            this.void_a("Leading zeroes not allowed");
        }
        this.var_int_arr_b = this.var_int_arr_b + true;
        if (c2 == '0') {
            while (this.var_int_arr_b < this.c || this.boolean_j()) {
                c2 = this.var_char_arr_b[this.var_int_arr_b];
                if (c2 < '0' || c2 > '9') {
                    return '0';
                }
                this.var_int_arr_b = this.var_int_arr_b + true;
                if (c2 == '0') continue;
                break;
            }
        }
        return c2;
    }

    protected bdf a(int n2, boolean bl2) {
        if (n2 == 73) {
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                this.void_a(bdf.i);
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            n2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (n2 == 78) {
                String string = bl2 ? "-INF" : "+INF";
                this.a(string, 3);
                if ((this.var_java_io_Reader_a & r) != 0) {
                    return this.a(string, bl2 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                this.d("Non-standard token '" + string + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (n2 == 110) {
                String string = bl2 ? "-Infinity" : "+Infinity";
                this.a(string, 3);
                if ((this.var_java_io_Reader_a & r) != 0) {
                    return this.a(string, bl2 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                this.d("Non-standard token '" + string + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        this.c(n2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    private final void d(int n2) {
        this.var_int_arr_b = this.var_int_arr_b + true;
        switch (n2) {
            case 9: 
            case 32: {
                return;
            }
            case 13: {
                this.s();
                return;
            }
            case 10: {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                return;
            }
        }
        this.void_b(n2);
    }

    protected final String java_lang_String_i() {
        Object object;
        Object object2;
        int n2 = this.m;
        int[] nArray = var_int_arr_b;
        for (object2 = this.var_int_arr_b; object2 < this.c; object2 = (Object)(object2 + 1)) {
            object = this.var_char_arr_b[object2];
            if (object < nArray.length && nArray[object] != 0) {
                if (object != 34) break;
                int[] nArray2 = this.var_int_arr_b;
                this.var_int_arr_b = object2 + true;
                return this.var_bes_a.a(this.var_char_arr_b, (int)nArray2, (int)(object2 - nArray2), n2);
            }
            n2 = n2 * 33 + object;
        }
        object = this.var_int_arr_b;
        this.var_int_arr_b = object2;
        return this.a((int)object, n2, 34);
    }

    private String a(int n2, int n3, int n4) {
        ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, n2, (int)(this.var_int_arr_b - n2));
        char[] cArray = ((bfj)((Object)this.var_java_io_Reader_a)).char_arr_c();
        int n5 = ((bfj)((Object)this.var_java_io_Reader_a)).int_c();
        while (true) {
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                this.c(" in field name", bdf.f);
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            char c3 = c2;
            if (c3 <= '\\') {
                if (c3 == '\\') {
                    c2 = this.char_a();
                } else if (c3 <= n4) {
                    if (c3 == n4) break;
                    if (c3 < ' ') {
                        this.b((int)c3, "name");
                    }
                }
            }
            n3 = n3 * 33 + c2;
            cArray[n5++] = c2;
            if (n5 < cArray.length) continue;
            cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
            n5 = 0;
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).void_a(n5);
        Reader reader = this.var_java_io_Reader_a;
        char[] cArray2 = ((bfj)((Object)reader)).char_arr_a();
        int n6 = ((bfj)((Object)reader)).int_b();
        int n7 = ((bfj)((Object)reader)).int_a();
        return this.var_bes_a.a(cArray2, n6, n7, n3);
    }

    protected String java_lang_String_b(int n2) {
        Object object;
        int[] nArray;
        int n3;
        boolean bl2;
        if (n2 == 39 && (this.var_java_io_Reader_a & t) != 0) {
            return this.java_lang_String_j();
        }
        if ((this.var_java_io_Reader_a & u) == 0) {
            this.d(n2, "was expecting double-quote to start field name");
        }
        if (!(bl2 = n2 < (n3 = (nArray = bdt.c()).length) ? nArray[n2] == 0 : Character.isJavaIdentifierPart((char)n2))) {
            this.d(n2, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        Object object2 = this.var_int_arr_b;
        int n4 = this.m;
        int n5 = this.c;
        if (object2 < n5) {
            do {
                if ((object = this.var_char_arr_b[object2]) < n3) {
                    if (nArray[object] != 0) {
                        reference var9_9 = this.var_int_arr_b - true;
                        this.var_int_arr_b = object2;
                        return this.var_bes_a.a(this.var_char_arr_b, (int)var9_9, (int)(object2 - var9_9), n4);
                    }
                } else if (!Character.isJavaIdentifierPart(object)) {
                    reference var9_10 = this.var_int_arr_b - true;
                    this.var_int_arr_b = object2;
                    return this.var_bes_a.a(this.var_char_arr_b, (int)var9_10, (int)(object2 - var9_10), n4);
                }
                n4 = n4 * 33 + object;
            } while ((object2 = (Object)(object2 + 1)) < n5);
        }
        object = this.var_int_arr_b - true;
        this.var_int_arr_b = object2;
        return this.a((int)object, n4, nArray);
    }

    protected String java_lang_String_j() {
        Object object = this.var_int_arr_b;
        int n2 = this.m;
        int n3 = this.c;
        if (object < n3) {
            int[] nArray = var_int_arr_b;
            int n4 = nArray.length;
            do {
                char c2;
                if ((c2 = this.var_char_arr_b[object]) == '\'') {
                    int[] nArray2 = this.var_int_arr_b;
                    this.var_int_arr_b = object + true;
                    return this.var_bes_a.a(this.var_char_arr_b, (int)nArray2, (int)(object - nArray2), n2);
                }
                if (c2 < n4 && nArray[c2] != 0) break;
                n2 = n2 * 33 + c2;
            } while ((object = (Object)(object + 1)) < n3);
        }
        int[] nArray = this.var_int_arr_b;
        this.var_int_arr_b = object;
        return this.a((int)nArray, n2, 39);
    }

    protected bdf bdf_b(int n2) {
        switch (n2) {
            case 39: {
                if ((this.var_java_io_Reader_a & t) == 0) break;
                return this.bdf_g();
            }
            case 93: {
                if (!((bde)((Object)this.var_java_io_Reader_a)).boolean_a()) break;
            }
            case 44: {
                if (((bde)((Object)this.var_java_io_Reader_a)).boolean_b() || (this.var_java_io_Reader_a & s) == 0) break;
                this.var_int_arr_b = this.var_int_arr_b - true;
                return bdf.m;
            }
            case 78: {
                this.a("NaN", 1);
                if ((this.var_java_io_Reader_a & r) != 0) {
                    return this.a("NaN", Double.NaN);
                }
                this.d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 73: {
                this.a("Infinity", 1);
                if ((this.var_java_io_Reader_a & r) != 0) {
                    return this.a("Infinity", Double.POSITIVE_INFINITY);
                }
                this.d("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 43: {
                if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                    this.void_a(bdf.i);
                }
                ben ben2 = this;
                ben2.var_int_arr_b = ben2.var_int_arr_b + true;
                return this.a((int)this.var_char_arr_b[ben2.var_int_arr_b], false);
            }
        }
        if (Character.isJavaIdentifierStart(n2)) {
            this.a("" + (char)n2, this.java_lang_String_g());
        }
        this.d(n2, "expected a valid value " + this.java_lang_String_h());
        return null;
    }

    protected bdf bdf_g() {
        char[] cArray = ((bfj)((Object)this.var_java_io_Reader_a)).d();
        int n2 = ((bfj)((Object)this.var_java_io_Reader_a)).int_c();
        while (true) {
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                this.c(": was expecting closing quote for a string value", bdf.h);
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            char c3 = c2;
            if (c3 <= '\\') {
                if (c3 == '\\') {
                    c2 = this.char_a();
                } else if (c3 <= '\'') {
                    if (c3 == '\'') break;
                    if (c3 < ' ') {
                        this.b((int)c3, "string value");
                    }
                }
            }
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                n2 = 0;
            }
            cArray[n2++] = c2;
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).void_a(n2);
        return bdf.h;
    }

    private String a(int n2, int n3, int[] nArray) {
        char c2;
        char c3;
        ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, n2, (int)(this.var_int_arr_b - n2));
        char[] cArray = ((bfj)((Object)this.var_java_io_Reader_a)).char_arr_c();
        int n4 = ((bfj)((Object)this.var_java_io_Reader_a)).int_c();
        int n5 = nArray.length;
        while ((this.var_int_arr_b < this.c || this.boolean_j()) && !((c3 = (c2 = this.var_char_arr_b[this.var_int_arr_b])) < n5 ? nArray[c3] != 0 : !Character.isJavaIdentifierPart(c2))) {
            this.var_int_arr_b = this.var_int_arr_b + true;
            n3 = n3 * 33 + c3;
            cArray[n4++] = c2;
            if (n4 < cArray.length) continue;
            cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
            n4 = 0;
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).void_a(n4);
        Reader reader = this.var_java_io_Reader_a;
        char[] cArray2 = ((bfj)((Object)reader)).char_arr_a();
        int n6 = ((bfj)((Object)reader)).int_b();
        int n7 = ((bfj)((Object)reader)).int_a();
        return this.var_bes_a.a(cArray2, n6, n7, n3);
    }

    @Override
    protected final void void_k() {
        Object object = this.var_int_arr_b;
        int n2 = this.c;
        if (object < n2) {
            int[] nArray = var_int_arr_b;
            int n3 = nArray.length;
            do {
                char c2;
                if ((c2 = this.var_char_arr_b[object]) >= n3 || nArray[c2] == 0) continue;
                if (c2 != '\"') break;
                ((bfj)((Object)this.var_java_io_Reader_a)).a(this.var_char_arr_b, (int)this.var_int_arr_b, (int)(object - this.var_int_arr_b));
                this.var_int_arr_b = object + true;
                return;
            } while ((object = (Object)(object + 1)) < n2);
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).b(this.var_char_arr_b, (int)this.var_int_arr_b, (int)(object - this.var_int_arr_b));
        this.var_int_arr_b = object;
        this.q();
    }

    protected void q() {
        char[] cArray = ((bfj)((Object)this.var_java_io_Reader_a)).char_arr_c();
        int n2 = ((bfj)((Object)this.var_java_io_Reader_a)).int_c();
        int[] nArray = var_int_arr_b;
        int n3 = nArray.length;
        while (true) {
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                this.c(": was expecting closing quote for a string value", bdf.h);
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            char c3 = c2;
            if (c3 < n3 && nArray[c3] != 0) {
                if (c3 == '\"') break;
                if (c3 == '\\') {
                    c2 = this.char_a();
                } else if (c3 < ' ') {
                    this.b((int)c3, "string value");
                }
            }
            if (n2 >= cArray.length) {
                cArray = ((bfj)((Object)this.var_java_io_Reader_a)).e();
                n2 = 0;
            }
            cArray[n2++] = c2;
        }
        ((bfj)((Object)this.var_java_io_Reader_a)).void_a(n2);
    }

    protected final void r() {
        this.e = false;
        Object object = this.var_int_arr_b;
        int n2 = this.c;
        char[] cArray = this.var_char_arr_b;
        while (true) {
            if (object >= n2) {
                this.var_int_arr_b = object;
                if (!this.boolean_j()) {
                    this.c(": was expecting closing quote for a string value", bdf.h);
                }
                object = this.var_int_arr_b;
                n2 = this.c;
            }
            int[] nArray = object;
            object = object + 1;
            char c2 = cArray[nArray];
            char c3 = c2;
            if (c3 > '\\') continue;
            if (c3 == '\\') {
                this.var_int_arr_b = object;
                this.char_a();
                object = this.var_int_arr_b;
                n2 = this.c;
                continue;
            }
            if (c3 > '\"') continue;
            if (c3 == '\"') break;
            if (c3 >= ' ') continue;
            this.var_int_arr_b = object;
            this.b((int)c3, "string value");
        }
        this.var_int_arr_b = object;
    }

    protected final void s() {
        if ((this.var_int_arr_b < this.c || this.boolean_j()) && this.var_char_arr_b[this.var_int_arr_b] == '\n') {
            this.var_int_arr_b = this.var_int_arr_b + true;
        }
        this.var_boolean_d += 1;
        this.e = this.var_int_arr_b;
    }

    private final int int_k() {
        if (this.var_int_arr_b + 4 >= this.c) {
            return this.a(false);
        }
        char c2 = this.var_char_arr_b[this.var_int_arr_b];
        if (c2 == ':') {
            reference v0 = this.var_int_arr_b + true;
            this.var_int_arr_b = v0;
            char c3 = this.var_char_arr_b[v0];
            if (c3 > ' ') {
                if (c3 == '/' || c3 == '#') {
                    return this.a(true);
                }
                this.var_int_arr_b = this.var_int_arr_b + true;
                return c3;
            }
            if (c3 == ' ' || c3 == '\t') {
                reference v1 = this.var_int_arr_b + true;
                this.var_int_arr_b = v1;
                c3 = this.var_char_arr_b[v1];
                if (c3 > ' ') {
                    if (c3 == '/' || c3 == '#') {
                        return this.a(true);
                    }
                    this.var_int_arr_b = this.var_int_arr_b + true;
                    return c3;
                }
            }
            return this.a(true);
        }
        if (c2 == ' ' || c2 == '\t') {
            reference v2 = this.var_int_arr_b + true;
            this.var_int_arr_b = v2;
            c2 = this.var_char_arr_b[v2];
        }
        if (c2 == ':') {
            reference v3 = this.var_int_arr_b + true;
            this.var_int_arr_b = v3;
            char c4 = this.var_char_arr_b[v3];
            if (c4 > ' ') {
                if (c4 == '/' || c4 == '#') {
                    return this.a(true);
                }
                this.var_int_arr_b = this.var_int_arr_b + true;
                return c4;
            }
            if (c4 == ' ' || c4 == '\t') {
                reference v4 = this.var_int_arr_b + true;
                this.var_int_arr_b = v4;
                c4 = this.var_char_arr_b[v4];
                if (c4 > ' ') {
                    if (c4 == '/' || c4 == '#') {
                        return this.a(true);
                    }
                    this.var_int_arr_b = this.var_int_arr_b + true;
                    return c4;
                }
            }
            return this.a(true);
        }
        return this.a(false);
    }

    private final int a(boolean bl2) {
        while (this.var_int_arr_b < this.c || this.boolean_j()) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 > ' ') {
                if (c2 == '/') {
                    this.t();
                    continue;
                }
                if (c2 == '#' && this.boolean_k()) continue;
                if (bl2) {
                    return c2;
                }
                if (c2 != ':') {
                    this.d(c2, "was expecting a colon to separate field name and value");
                }
                bl2 = true;
                continue;
            }
            if (c2 >= ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (c2 == '\r') {
                this.s();
                continue;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
        this.c(" within/between " + (String)((bek)((Object)this.var_java_io_Reader_a)).java_lang_Object_a() + " entries", null);
        return -1;
    }

    private final int int_b(int n2) {
        if (n2 != 44) {
            this.d(n2, "was expecting comma to separate " + (String)((bek)((Object)this.var_java_io_Reader_a)).java_lang_Object_a() + " entries");
        }
        while (this.var_int_arr_b < this.c) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            n2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (n2 > 32) {
                if (n2 == 47 || n2 == 35) {
                    this.var_int_arr_b = this.var_int_arr_b - true;
                    return this.int_l();
                }
                return n2;
            }
            if (n2 >= 32) continue;
            if (n2 == 10) {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (n2 == 13) {
                this.s();
                continue;
            }
            if (n2 == 9) continue;
            this.void_c(n2);
        }
        return this.int_l();
    }

    private final int int_l() {
        while (this.var_int_arr_b < this.c || this.boolean_j()) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 > ' ') {
                if (c2 == '/') {
                    this.t();
                    continue;
                }
                if (c2 == '#' && this.boolean_k()) continue;
                return c2;
            }
            if (c2 >= ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (c2 == '\r') {
                this.s();
                continue;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
        throw this.bdb_a("Unexpected end-of-input within/between " + (String)((bek)((Object)this.var_java_io_Reader_a)).java_lang_Object_a() + " entries");
    }

    private final int int_m() {
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            return this.int_i();
        }
        ben ben2 = this;
        ben2.var_int_arr_b = ben2.var_int_arr_b + true;
        char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
        if (c2 > ' ') {
            if (c2 == '/' || c2 == '#') {
                this.var_int_arr_b = this.var_int_arr_b - true;
                return this.int_n();
            }
            return c2;
        }
        if (c2 != ' ') {
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
            } else if (c2 == '\r') {
                this.s();
            } else if (c2 != '\t') {
                this.void_c(c2);
            }
        }
        while (this.var_int_arr_b < this.c) {
            ben ben3 = this;
            ben3.var_int_arr_b = ben3.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben3.var_int_arr_b];
            if (c2 > ' ') {
                if (c2 == '/' || c2 == '#') {
                    this.var_int_arr_b = this.var_int_arr_b - true;
                    return this.int_n();
                }
                return c2;
            }
            if (c2 == ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (c2 == '\r') {
                this.s();
                continue;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
        return this.int_n();
    }

    private int int_n() {
        while (this.var_int_arr_b < this.c || this.boolean_j()) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 > ' ') {
                if (c2 == '/') {
                    this.t();
                    continue;
                }
                if (c2 == '#' && this.boolean_k()) continue;
                return c2;
            }
            if (c2 == ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (c2 == '\r') {
                this.s();
                continue;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
        return this.int_i();
    }

    private void t() {
        if ((this.var_java_io_Reader_a & v) == 0) {
            this.d(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            this.c(" in a comment", null);
        }
        ben ben2 = this;
        ben2.var_int_arr_b = ben2.var_int_arr_b + true;
        char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
        if (c2 == '/') {
            this.v();
        } else if (c2 == '*') {
            this.u();
        } else {
            this.d(c2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void u() {
        while (this.var_int_arr_b < this.c || this.boolean_j()) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 > '*') continue;
            if (c2 == '*') {
                if (this.var_int_arr_b >= this.c && !this.boolean_j()) break;
                if (this.var_char_arr_b[this.var_int_arr_b] != '/') continue;
                this.var_int_arr_b = this.var_int_arr_b + true;
                return;
            }
            if (c2 >= ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                continue;
            }
            if (c2 == '\r') {
                this.s();
                continue;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
        this.c(" in a comment", null);
    }

    private boolean boolean_k() {
        if ((this.var_java_io_Reader_a & w) == 0) {
            return false;
        }
        this.v();
        return true;
    }

    private void v() {
        while (this.var_int_arr_b < this.c || this.boolean_j()) {
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 >= ' ') continue;
            if (c2 == '\n') {
                this.var_boolean_d += 1;
                this.e = this.var_int_arr_b;
                break;
            }
            if (c2 == '\r') {
                this.s();
                break;
            }
            if (c2 == '\t') continue;
            this.void_c(c2);
        }
    }

    @Override
    protected char char_a() {
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            this.c(" in character escape sequence", bdf.h);
        }
        ben ben2 = this;
        ben2.var_int_arr_b = ben2.var_int_arr_b + true;
        char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
        switch (c2) {
            case 'b': {
                return '\b';
            }
            case 't': {
                return '\t';
            }
            case 'n': {
                return '\n';
            }
            case 'f': {
                return '\f';
            }
            case 'r': {
                return '\r';
            }
            case '\"': 
            case '/': 
            case '\\': {
                return c2;
            }
            case 'u': {
                break;
            }
            default: {
                return this.a(c2);
            }
        }
        int n2 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
                this.c(" in character escape sequence", bdf.h);
            }
            ben ben3 = this;
            ben3.var_int_arr_b = ben3.var_int_arr_b + true;
            char c3 = this.var_char_arr_b[ben3.var_int_arr_b];
            int n3 = bdt.int_a(c3);
            if (n3 < 0) {
                this.d(c3, "expected a hex-digit for character escape sequence");
            }
            n2 = n2 << 4 | n3;
        }
        return (char)n2;
    }

    private final void w() {
        char c2;
        char[] cArray;
        Object object = this.var_int_arr_b;
        if (object + 3 < this.c && (cArray = this.var_char_arr_b)[object] == 'r' && cArray[object = (Object)(object + 1)] == 'u' && cArray[object = (Object)(object + 1)] == 'e' && ((c2 = cArray[object = (Object)(object + 1)]) < '0' || c2 == ']' || c2 == '}')) {
            this.var_int_arr_b = object;
            return;
        }
        this.a("true", 1);
    }

    private final void x() {
        char c2;
        char[] cArray;
        Object object = this.var_int_arr_b;
        if (object + 4 < this.c && (cArray = this.var_char_arr_b)[object] == 'a' && cArray[object = (Object)(object + 1)] == 'l' && cArray[object = (Object)(object + 1)] == 's' && cArray[object = (Object)(object + 1)] == 'e' && ((c2 = cArray[object = (Object)(object + 1)]) < '0' || c2 == ']' || c2 == '}')) {
            this.var_int_arr_b = object;
            return;
        }
        this.a("false", 1);
    }

    private final void y() {
        char c2;
        char[] cArray;
        Object object = this.var_int_arr_b;
        if (object + 3 < this.c && (cArray = this.var_char_arr_b)[object] == 'u' && cArray[object = (Object)(object + 1)] == 'l' && cArray[object = (Object)(object + 1)] == 'l' && ((c2 = cArray[object = (Object)(object + 1)]) < '0' || c2 == ']' || c2 == '}')) {
            this.var_int_arr_b = object;
            return;
        }
        this.a("null", 1);
    }

    protected final void a(String string, int n2) {
        int n3 = string.length();
        if (this.var_int_arr_b + n3 >= this.c) {
            this.b(string, n2);
            return;
        }
        do {
            if (this.var_char_arr_b[this.var_int_arr_b] != string.charAt(n2)) {
                this.e(string.substring(0, n2));
            }
            this.var_int_arr_b = this.var_int_arr_b + true;
        } while (++n2 < n3);
        char c2 = this.var_char_arr_b[this.var_int_arr_b];
        if (c2 >= '0' && c2 != ']' && c2 != '}') {
            this.a(string, n2, (int)c2);
        }
    }

    private final void b(String string, int n2) {
        int n3 = string.length();
        do {
            if (this.var_int_arr_b >= this.c && !this.boolean_j() || this.var_char_arr_b[this.var_int_arr_b] != string.charAt(n2)) {
                this.e(string.substring(0, n2));
            }
            this.var_int_arr_b = this.var_int_arr_b + true;
        } while (++n2 < n3);
        if (this.var_int_arr_b >= this.c && !this.boolean_j()) {
            return;
        }
        char c2 = this.var_char_arr_b[this.var_int_arr_b];
        if (c2 >= '0' && c2 != ']' && c2 != '}') {
            this.a(string, n2, (int)c2);
        }
    }

    private final void a(String string, int n2, int n3) {
        char c2 = (char)n3;
        if (Character.isJavaIdentifierPart(c2)) {
            this.e(string.substring(0, n2));
        }
    }

    protected byte[] b(bcq bcq2) {
        bex bex2 = this.bex_a();
        while (true) {
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben2 = this;
            ben2.var_int_arr_b = ben2.var_int_arr_b + true;
            char c2 = this.var_char_arr_b[ben2.var_int_arr_b];
            if (c2 <= ' ') continue;
            int n2 = bcq2.int_a(c2);
            if (n2 < 0) {
                if (c2 == '\"') {
                    return bex2.byte_arr_a();
                }
                n2 = this.a(bcq2, c2, 0);
                if (n2 < 0) continue;
            }
            int n3 = n2;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben3 = this;
            ben3.var_int_arr_b = ben3.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben3.var_int_arr_b];
            n2 = bcq2.int_a(c2);
            if (n2 < 0) {
                n2 = this.a(bcq2, c2, 1);
            }
            n3 = n3 << 6 | n2;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben4 = this;
            ben4.var_int_arr_b = ben4.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben4.var_int_arr_b];
            n2 = bcq2.int_a(c2);
            if (n2 < 0) {
                if (n2 != -2) {
                    if (c2 == '\"') {
                        bex2.void_a(n3 >>= 4);
                        if (bcq2.boolean_a()) {
                            this.var_int_arr_b = this.var_int_arr_b - true;
                            this.void_a(bcq2);
                        }
                        return bex2.byte_arr_a();
                    }
                    n2 = this.a(bcq2, c2, 2);
                }
                if (n2 == -2) {
                    if (this.var_int_arr_b >= this.c) {
                        this.p();
                    }
                    ben ben5 = this;
                    ben5.var_int_arr_b = ben5.var_int_arr_b + true;
                    c2 = this.var_char_arr_b[ben5.var_int_arr_b];
                    if (!bcq2.boolean_a(c2) && this.a(bcq2, c2, 3) != -2) {
                        throw this.a(bcq2, (int)c2, 3, "expected padding character '" + bcq2.char_a() + "'");
                    }
                    bex2.void_a(n3 >>= 4);
                    continue;
                }
            }
            n3 = n3 << 6 | n2;
            if (this.var_int_arr_b >= this.c) {
                this.p();
            }
            ben ben6 = this;
            ben6.var_int_arr_b = ben6.var_int_arr_b + true;
            c2 = this.var_char_arr_b[ben6.var_int_arr_b];
            n2 = bcq2.int_a(c2);
            if (n2 < 0) {
                if (n2 != -2) {
                    if (c2 == '\"') {
                        bex2.b(n3 >>= 2);
                        if (bcq2.boolean_a()) {
                            this.var_int_arr_b = this.var_int_arr_b - true;
                            this.void_a(bcq2);
                        }
                        return bex2.byte_arr_a();
                    }
                    n2 = this.a(bcq2, c2, 3);
                }
                if (n2 == -2) {
                    bex2.b(n3 >>= 2);
                    continue;
                }
            }
            n3 = n3 << 6 | n2;
            bex2.c(n3);
        }
    }

    @Override
    public bda bda_a() {
        if (this.var_int_arr_b == bdf.f) {
            reference var1_1 = this.var_java_io_Reader_a + (this.var_long_d - 1L);
            return new bda(this.java_lang_Object_d(), -1L, (long)var1_1, this.n, this.o);
        }
        return new bda(this.java_lang_Object_d(), -1L, (long)(this.var_int_arr_b - 1L), this.f, this.g);
    }

    @Override
    public bda bda_b() {
        reference var1_1 = this.var_int_arr_b - this.e + true;
        return new bda(this.java_lang_Object_d(), -1L, (long)(this.var_java_io_Reader_a + (long)this.var_int_arr_b), this.var_boolean_d ? 1 : 0, (int)var1_1);
    }

    private final void z() {
        int[] nArray = this.var_int_arr_b;
        this.var_int_arr_b = this.var_java_io_Reader_a + (long)nArray;
        this.f = this.var_boolean_d ? 1 : 0;
        this.g = (int)(nArray - this.e);
    }

    private final void A() {
        int[] nArray = this.var_int_arr_b;
        this.var_long_d = (long)nArray;
        this.n = this.var_boolean_d ? 1 : 0;
        this.o = (int)(nArray - this.e);
    }

    protected void e(String string) {
        this.a(string, this.java_lang_String_g());
    }

    protected void a(String string, String string2) {
        char c2;
        StringBuilder stringBuilder = new StringBuilder(string);
        while ((this.var_int_arr_b < this.c || this.boolean_j()) && Character.isJavaIdentifierPart(c2 = this.var_char_arr_b[this.var_int_arr_b])) {
            this.var_int_arr_b = this.var_int_arr_b + true;
            stringBuilder.append(c2);
            if (stringBuilder.length() < 256) continue;
            stringBuilder.append("...");
            break;
        }
        this.a("Unrecognized token '%s': was expecting %s", stringBuilder, string2);
    }

    private void e(int n2) {
        if (n2 == 93) {
            this.z();
            if (!((bde)((Object)this.var_java_io_Reader_a)).boolean_a()) {
                this.a(n2, '}');
            }
            this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).bek_b();
            this.var_int_arr_b = (int[])bdf.var_bdf_e;
        }
        if (n2 == 125) {
            this.z();
            if (!((bde)((Object)this.var_java_io_Reader_a)).boolean_c()) {
                this.a(n2, ']');
            }
            this.var_java_io_Reader_a = ((bek)((Object)this.var_java_io_Reader_a)).bek_b();
            this.var_int_arr_b = (int[])bdf.var_bdf_c;
        }
    }

    static {
        var_int_arr_b = bdt.int_arr_a();
    }
}

