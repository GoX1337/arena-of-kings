/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class beq
extends bej {
    protected static final char[] var_char_arr_a;
    protected final Writer var_java_io_Writer_a;
    protected char var_char_a;
    protected char[] var_char_arr_b;
    protected int var_int_d;
    protected int e;
    protected int f;
    protected char[] c;
    protected bdi var_bdi_b;
    protected char[] var_char_arr_d;

    public beq(bdv bdv2, int n2, bdg bdg2, Writer writer, char c2) {
        super(bdv2, n2, bdg2);
        this.var_java_io_Writer_a = writer;
        this.var_char_arr_b = bdv2.char_arr_b();
        this.f = this.var_char_arr_b.length;
        this.var_char_a = c2;
        if (c2 != '\"') {
            this.var_char_arr_b = (char[])bdt.int_arr_a(c2);
        }
    }

    @Override
    public void a(String string) {
        int n2 = this.var_char_arr_a.a(string);
        if (n2 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        this.a(string, n2 == 1);
    }

    @Override
    public void void_a(bdi bdi2) {
        int n2 = this.var_char_arr_a.a(bdi2.java_lang_String_a());
        if (n2 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        this.a(bdi2, n2 == 1);
    }

    protected final void a(String string, boolean bl2) {
        if (this.var_char_arr_a != null) {
            this.b(string, bl2);
            return;
        }
        if (this.e + 1 >= this.f) {
            this.i();
        }
        if (bl2) {
            this.var_char_arr_b[this.e++] = 44;
        }
        if (this.c != false) {
            this.l(string);
            return;
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.l(string);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    protected final void a(bdi bdi2, boolean bl2) {
        if (this.var_char_arr_a != null) {
            this.b(bdi2, bl2);
            return;
        }
        if (this.e + 1 >= this.f) {
            this.i();
        }
        if (bl2) {
            this.var_char_arr_b[this.e++] = 44;
        }
        if (this.c != false) {
            char[] cArray = bdi2.char_arr_a();
            this.b(cArray, 0, cArray.length);
            return;
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        int n2 = bdi2.a(this.var_char_arr_b, this.e);
        if (n2 < 0) {
            this.e(bdi2);
            return;
        }
        this.e += n2;
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    private final void e(bdi bdi2) {
        char[] cArray = bdi2.char_arr_a();
        this.b(cArray, 0, cArray.length);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void void_a() {
        this.h("start an array");
        this.var_char_arr_a = (char[])this.var_char_arr_a.java_lang_Object_a();
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.e(this);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 91;
        }
    }

    @Override
    public void b(Object object) {
        this.h("start an array");
        this.var_char_arr_a = (char[])this.var_char_arr_a.bem_a(object);
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.e(this);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 91;
        }
    }

    @Override
    public void a(Object object, int n2) {
        this.h("start an array");
        this.var_char_arr_a = (char[])this.var_char_arr_a.bem_a(object);
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.e(this);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 91;
        }
    }

    @Override
    public void void_b() {
        if (!this.var_char_arr_a.boolean_a()) {
            this.g("Current context not Array but " + (String)this.var_char_arr_a.java_lang_Object_a());
        }
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.b(this, this.var_char_arr_a.int_a());
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 93;
        }
        this.var_char_arr_a = (char[])this.var_char_arr_a.d();
    }

    @Override
    public void void_c() {
        this.h("start an object");
        this.var_char_arr_a = (char[])this.var_char_arr_a.bem_b();
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.b(this);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 123;
        }
    }

    @Override
    public void c(Object object) {
        this.h("start an object");
        bem bem2 = this.var_char_arr_a.b(object);
        this.var_char_arr_a = (char[])bem2;
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.b(this);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 123;
        }
    }

    @Override
    public void void_d() {
        if (!this.var_char_arr_a.boolean_c()) {
            this.g("Current context not Object but " + (String)this.var_char_arr_a.java_lang_Object_a());
        }
        if (this.var_char_arr_a != null) {
            this.var_char_arr_a.a(this, this.var_char_arr_a.int_a());
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 125;
        }
        this.var_char_arr_a = (char[])this.var_char_arr_a.d();
    }

    protected final void b(String string, boolean bl2) {
        if (bl2) {
            this.var_char_arr_a.c(this);
        } else {
            this.var_char_arr_a.h(this);
        }
        if (this.c != false) {
            this.l(string);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = this.var_char_a;
            this.l(string);
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = this.var_char_a;
        }
    }

    protected final void b(bdi bdi2, boolean bl2) {
        if (bl2) {
            this.var_char_arr_a.c(this);
        } else {
            this.var_char_arr_a.h(this);
        }
        char[] cArray = bdi2.char_arr_a();
        if (this.c != false) {
            this.b(cArray, 0, cArray.length);
        } else {
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = this.var_char_a;
            this.b(cArray, 0, cArray.length);
            if (this.e >= this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = this.var_char_a;
        }
    }

    @Override
    public void b(String string) {
        this.h("write a string");
        if (string == null) {
            this.j();
            return;
        }
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.l(string);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void a(char[] cArray, int n2, int n3) {
        this.h("write a string");
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.c(cArray, n2, n3);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void b(bdi bdi2) {
        this.h("write a string");
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        int n2 = bdi2.a(this.var_char_arr_b, this.e);
        if (n2 < 0) {
            this.f(bdi2);
            return;
        }
        this.e += n2;
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    private void f(bdi bdi2) {
        char[] cArray = bdi2.char_arr_a();
        int n2 = cArray.length;
        if (n2 < 32) {
            int n3 = this.f - this.e;
            if (n2 > n3) {
                this.i();
            }
            System.arraycopy(cArray, 0, this.var_char_arr_b, this.e, n2);
            this.e += n2;
        } else {
            this.i();
            this.var_java_io_Writer_a.write(cArray, 0, n2);
        }
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void c(String string) {
        int n2 = string.length();
        int n3 = this.f - this.e;
        if (n3 == 0) {
            this.i();
            n3 = this.f - this.e;
        }
        if (n3 >= n2) {
            string.getChars(0, n2, this.var_char_arr_b, this.e);
            this.e += n2;
        } else {
            this.j(string);
        }
    }

    @Override
    public void c(bdi bdi2) {
        int n2 = bdi2.b(this.var_char_arr_b, this.e);
        if (n2 < 0) {
            this.c(bdi2.java_lang_String_a());
            return;
        }
        this.e += n2;
    }

    @Override
    public void b(char[] cArray, int n2, int n3) {
        if (n3 < 32) {
            int n4 = this.f - this.e;
            if (n3 > n4) {
                this.i();
            }
            System.arraycopy(cArray, n2, this.var_char_arr_b, this.e, n3);
            this.e += n3;
            return;
        }
        this.i();
        this.var_java_io_Writer_a.write(cArray, n2, n3);
    }

    @Override
    public void a(char c2) {
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = c2;
    }

    private void j(String string) {
        int n2;
        int n3;
        int n4 = this.f - this.e;
        string.getChars(0, n4, this.var_char_arr_b, this.e);
        this.e += n4;
        this.i();
        int n5 = n4;
        for (n2 = string.length() - n4; n2 > this.f; n2 -= n3) {
            n3 = this.f;
            string.getChars(n5, n5 + n3, this.var_char_arr_b, 0);
            this.var_int_d = 0;
            this.e = n3;
            this.i();
            n5 += n3;
        }
        string.getChars(n5, n5 + n2, this.var_char_arr_b, 0);
        this.var_int_d = 0;
        this.e = n2;
    }

    @Override
    public void a(bcq bcq2, byte[] byArray, int n2, int n3) {
        this.h("write a binary value");
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.b(bcq2, byArray, n2, n2 + n3);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int a(bcq bcq2, InputStream inputStream, int n2) {
        int n3;
        this.h("write a binary value");
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        byte[] byArray = this.var_char_arr_a.c();
        try {
            if (n2 < 0) {
                n3 = this.a(bcq2, inputStream, byArray);
            } else {
                int n4 = this.a(bcq2, inputStream, byArray, n2);
                if (n4 > 0) {
                    this.g("Too few bytes available: missing " + n4 + " bytes (out of " + n2 + ")");
                }
                n3 = n2;
            }
        }
        finally {
            this.var_char_arr_a.c(byArray);
        }
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        return n3;
    }

    @Override
    public void a(short s2) {
        this.h("write a number");
        if (this.var_char_arr_a != false) {
            this.b(s2);
            return;
        }
        if (this.e + 6 >= this.f) {
            this.i();
        }
        this.e = beb.a((int)s2, this.var_char_arr_b, this.e);
    }

    private void b(short s2) {
        if (this.e + 8 >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.e = beb.a((int)s2, this.var_char_arr_b, this.e);
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void void_b(int n2) {
        this.h("write a number");
        if (this.var_char_arr_a != false) {
            this.c(n2);
            return;
        }
        if (this.e + 11 >= this.f) {
            this.i();
        }
        this.e = beb.a(n2, this.var_char_arr_b, this.e);
    }

    private void c(int n2) {
        if (this.e + 13 >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.e = beb.a(n2, this.var_char_arr_b, this.e);
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void b(long l2) {
        this.h("write a number");
        if (this.var_char_arr_a != false) {
            this.c(l2);
            return;
        }
        if (this.e + 21 >= this.f) {
            this.i();
        }
        this.e = beb.a(l2, this.var_char_arr_b, this.e);
    }

    private void c(long l2) {
        if (this.e + 23 >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.e = beb.a(l2, this.var_char_arr_b, this.e);
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void a(BigInteger bigInteger) {
        this.h("write a number");
        if (bigInteger == null) {
            this.j();
        } else if (this.var_char_arr_a != false) {
            this.k(bigInteger.toString());
        } else {
            this.c(bigInteger.toString());
        }
    }

    @Override
    public void a(double d2) {
        if (this.var_char_arr_a != false || beb.a(d2) && this.boolean_a(bcy.a.e)) {
            this.b(String.valueOf(d2));
            return;
        }
        this.h("write a number");
        this.c(String.valueOf(d2));
    }

    @Override
    public void a(float f2) {
        if (this.var_char_arr_a != false || beb.a(f2) && this.boolean_a(bcy.a.e)) {
            this.b(String.valueOf(f2));
            return;
        }
        this.h("write a number");
        this.c(String.valueOf(f2));
    }

    @Override
    public void void_a(BigDecimal bigDecimal) {
        this.h("write a number");
        if (bigDecimal == null) {
            this.j();
        } else if (this.var_char_arr_a != false) {
            this.k(this.java_lang_String_a(bigDecimal));
        } else {
            this.c(this.java_lang_String_a(bigDecimal));
        }
    }

    @Override
    public void e(String string) {
        this.h("write a number");
        if (string == null) {
            this.j();
        } else if (this.var_char_arr_a != false) {
            this.k(string);
        } else {
            this.c(string);
        }
    }

    private void k(String string) {
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
        this.c(string);
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = this.var_char_a;
    }

    @Override
    public void a(boolean bl2) {
        this.h("write a boolean value");
        if (this.e + 5 >= this.f) {
            this.i();
        }
        int n2 = this.e;
        char[] cArray = this.var_char_arr_b;
        if (bl2) {
            cArray[n2] = 116;
            cArray[++n2] = 114;
            cArray[++n2] = 117;
            cArray[++n2] = 101;
        } else {
            cArray[n2] = 102;
            cArray[++n2] = 97;
            cArray[++n2] = 108;
            cArray[++n2] = 115;
            cArray[++n2] = 101;
        }
        this.e = n2 + 1;
    }

    @Override
    public void e() {
        this.h("write a null");
        this.j();
    }

    @Override
    protected final void h(String string) {
        int n2;
        int n3 = this.var_char_arr_a.int_c();
        if (this.var_char_arr_a != null) {
            this.a(string, n3);
            return;
        }
        switch (n3) {
            default: {
                return;
            }
            case 1: {
                n2 = 44;
                break;
            }
            case 2: {
                n2 = 58;
                break;
            }
            case 3: {
                if (this.var_char_arr_a != null) {
                    this.c(this.var_char_arr_a.java_lang_String_a());
                }
                return;
            }
            case 5: {
                this.i(string);
                return;
            }
        }
        if (this.e >= this.f) {
            this.i();
        }
        this.var_char_arr_b[this.e++] = n2;
    }

    @Override
    public void flush() {
        this.i();
        if (this.var_java_io_Writer_a != null && this.boolean_a(bcy.a.c)) {
            this.var_java_io_Writer_a.flush();
        }
    }

    @Override
    public void close() {
        super.close();
        if (this.var_char_arr_b != null && this.boolean_a(bcy.a.b)) {
            while (true) {
                bde bde2;
                if ((bde2 = this.bde_a()).boolean_a()) {
                    this.void_b();
                    continue;
                }
                if (!bde2.boolean_c()) break;
                this.void_d();
            }
        }
        this.i();
        this.var_int_d = 0;
        this.e = 0;
        if (this.var_java_io_Writer_a != null) {
            if (this.var_char_arr_a.boolean_a() || this.boolean_a(bcy.a.var_bcy$a_a)) {
                this.var_java_io_Writer_a.close();
            } else if (this.boolean_a(bcy.a.c)) {
                this.var_java_io_Writer_a.flush();
            }
        }
        this.h();
    }

    @Override
    protected void h() {
        char[] cArray = this.var_char_arr_b;
        if (cArray != null) {
            this.var_char_arr_b = null;
            this.var_char_arr_a.b(cArray);
        }
        if ((cArray = this.var_char_arr_d) != null) {
            this.var_char_arr_d = null;
            this.var_char_arr_a.c(cArray);
        }
    }

    private void l(String string) {
        int n2 = string.length();
        if (n2 > this.f) {
            this.m(string);
            return;
        }
        if (this.e + n2 > this.f) {
            this.i();
        }
        string.getChars(0, n2, this.var_char_arr_b, this.e);
        if (this.var_char_arr_a != null) {
            this.f(n2);
        } else if (this.c != false) {
            this.void_b(n2, (int)this.c);
        } else {
            this.d(n2);
        }
    }

    private void d(int n2) {
        int n3 = this.e + n2;
        char[] cArray = this.var_char_arr_b;
        int n4 = cArray.length;
        block0: while (this.e < n3) {
            int n5;
            while ((n5 = this.var_char_arr_b[this.e]) >= n4 || cArray[n5] == '\u0000') {
                if (++this.e < n3) continue;
                break block0;
            }
            n5 = this.e - this.var_int_d;
            if (n5 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, this.var_int_d, n5);
            }
            char c2 = this.var_char_arr_b[this.e++];
            this.a(c2, (int)cArray[c2]);
        }
    }

    private void m(String string) {
        int n2;
        this.i();
        int n3 = string.length();
        int n4 = 0;
        do {
            int n5;
            n2 = n4 + (n5 = this.f) > n3 ? n3 - n4 : n5;
            string.getChars(n4, n4 + n2, this.var_char_arr_b, 0);
            if (this.var_char_arr_a != null) {
                this.g(n2);
                continue;
            }
            if (this.c != false) {
                this.c(n2, (int)this.c);
                continue;
            }
            this.e(n2);
        } while ((n4 += n2) < n3);
    }

    private void e(int n2) {
        int n3;
        char[] cArray = this.var_char_arr_b;
        int n4 = cArray.length;
        int n5 = n3 = 0;
        while (n3 < n2) {
            char c2;
            while (((c2 = this.var_char_arr_b[n3]) >= n4 || cArray[c2] == '\u0000') && ++n3 < n2) {
            }
            int n6 = n3 - n5;
            if (n6 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, n5, n6);
                if (n3 >= n2) break;
            }
            n5 = this.a(this.var_char_arr_b, ++n3, n2, c2, (int)cArray[c2]);
        }
    }

    private void c(char[] cArray, int n2, int n3) {
        if (this.var_char_arr_a != null) {
            this.d(cArray, n2, n3);
            return;
        }
        if (this.c != false) {
            this.a(cArray, n2, n3, (int)this.c);
            return;
        }
        n3 += n2;
        char[] cArray2 = this.var_char_arr_b;
        int n4 = cArray2.length;
        while (n2 < n3) {
            int n5;
            int n6 = n2;
            while (((n5 = cArray[n2]) >= n4 || cArray2[n5] == '\u0000') && ++n2 < n3) {
            }
            n5 = n2 - n6;
            if (n5 < 32) {
                if (this.e + n5 > this.f) {
                    this.i();
                }
                if (n5 > 0) {
                    System.arraycopy(cArray, n6, this.var_char_arr_b, this.e, n5);
                    this.e += n5;
                }
            } else {
                this.i();
                this.var_java_io_Writer_a.write(cArray, n6, n5);
            }
            if (n2 >= n3) break;
            char c2 = cArray[n2++];
            this.b(c2, (int)cArray2[c2]);
        }
    }

    private void void_b(int n2, int n3) {
        int n4 = this.e + n2;
        char[] cArray = this.var_char_arr_b;
        int n5 = Math.min(cArray.length, n3 + 1);
        int n6 = 0;
        while (this.e < n4) {
            char c2;
            block5: {
                do {
                    if ((c2 = this.var_char_arr_b[this.e]) < n5) {
                        n6 = cArray[c2];
                        if (n6 == 0) continue;
                    } else {
                        if (c2 <= n3) continue;
                        n6 = -1;
                    }
                    break block5;
                } while (++this.e < n4);
                break;
            }
            int n7 = this.e - this.var_int_d;
            if (n7 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, this.var_int_d, n7);
            }
            ++this.e;
            this.a(c2, n6);
        }
    }

    private void c(int n2, int n3) {
        char[] cArray = this.var_char_arr_b;
        int n4 = Math.min(cArray.length, n3 + 1);
        int n5 = 0;
        int n6 = 0;
        int n7 = n5;
        while (n5 < n2) {
            char c2;
            do {
                if ((c2 = this.var_char_arr_b[n5]) < n4) {
                    n6 = cArray[c2];
                    if (n6 == 0) continue;
                    break;
                }
                if (c2 <= n3) continue;
                n6 = -1;
                break;
            } while (++n5 < n2);
            int n8 = n5 - n7;
            if (n8 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, n7, n8);
                if (n5 >= n2) break;
            }
            n7 = this.a(this.var_char_arr_b, ++n5, n2, c2, n6);
        }
    }

    private void a(char[] cArray, int n2, int n3, int n4) {
        n3 += n2;
        char[] cArray2 = this.var_char_arr_b;
        int n5 = Math.min(cArray2.length, n4 + 1);
        int n6 = 0;
        while (n2 < n3) {
            char c2;
            int n7 = n2;
            do {
                if ((c2 = cArray[n2]) < n5) {
                    n6 = cArray2[c2];
                    if (n6 == 0) continue;
                    break;
                }
                if (c2 <= n4) continue;
                n6 = -1;
                break;
            } while (++n2 < n3);
            int n8 = n2 - n7;
            if (n8 < 32) {
                if (this.e + n8 > this.f) {
                    this.i();
                }
                if (n8 > 0) {
                    System.arraycopy(cArray, n7, this.var_char_arr_b, this.e, n8);
                    this.e += n8;
                }
            } else {
                this.i();
                this.var_java_io_Writer_a.write(cArray, n7, n8);
            }
            if (n2 >= n3) break;
            ++n2;
            this.b(c2, n6);
        }
    }

    private void f(int n2) {
        int n3 = this.e + n2;
        char[] cArray = this.var_char_arr_b;
        char c2 = this.c < true ? 65535 : (int)this.c;
        int n4 = Math.min(cArray.length, c2 + 1);
        int n5 = 0;
        char[] cArray2 = this.var_char_arr_a;
        while (this.e < n3) {
            char c3;
            block7: {
                do {
                    if ((c3 = this.var_char_arr_b[this.e]) < n4) {
                        n5 = cArray[c3];
                        if (n5 == 0) continue;
                    } else if (c3 > c2) {
                        n5 = -1;
                    } else {
                        this.var_bdi_b = cArray2.a(c3);
                        if (this.var_bdi_b == null) continue;
                        n5 = -2;
                    }
                    break block7;
                } while (++this.e < n3);
                break;
            }
            int n6 = this.e - this.var_int_d;
            if (n6 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, this.var_int_d, n6);
            }
            ++this.e;
            this.a(c3, n5);
        }
    }

    private void g(int n2) {
        char[] cArray = this.var_char_arr_b;
        char c2 = this.c < true ? 65535 : (int)this.c;
        int n3 = Math.min(cArray.length, c2 + 1);
        char[] cArray2 = this.var_char_arr_a;
        int n4 = 0;
        int n5 = 0;
        int n6 = n4;
        while (n4 < n2) {
            char c3;
            do {
                if ((c3 = this.var_char_arr_b[n4]) < n3) {
                    n5 = cArray[c3];
                    if (n5 == 0) continue;
                    break;
                }
                if (c3 > c2) {
                    n5 = -1;
                    break;
                }
                this.var_bdi_b = cArray2.a(c3);
                if (this.var_bdi_b == null) continue;
                n5 = -2;
                break;
            } while (++n4 < n2);
            int n7 = n4 - n6;
            if (n7 > 0) {
                this.var_java_io_Writer_a.write(this.var_char_arr_b, n6, n7);
                if (n4 >= n2) break;
            }
            n6 = this.a(this.var_char_arr_b, ++n4, n2, c3, n5);
        }
    }

    private void d(char[] cArray, int n2, int n3) {
        n3 += n2;
        char[] cArray2 = this.var_char_arr_b;
        char c2 = this.c < true ? 65535 : (int)this.c;
        int n4 = Math.min(cArray2.length, c2 + 1);
        char[] cArray3 = this.var_char_arr_a;
        int n5 = 0;
        while (n2 < n3) {
            char c3;
            int n6 = n2;
            do {
                if ((c3 = cArray[n2]) < n4) {
                    n5 = cArray2[c3];
                    if (n5 == 0) continue;
                    break;
                }
                if (c3 > c2) {
                    n5 = -1;
                    break;
                }
                this.var_bdi_b = cArray3.a(c3);
                if (this.var_bdi_b == null) continue;
                n5 = -2;
                break;
            } while (++n2 < n3);
            int n7 = n2 - n6;
            if (n7 < 32) {
                if (this.e + n7 > this.f) {
                    this.i();
                }
                if (n7 > 0) {
                    System.arraycopy(cArray, n6, this.var_char_arr_b, this.e, n7);
                    this.e += n7;
                }
            } else {
                this.i();
                this.var_java_io_Writer_a.write(cArray, n6, n7);
            }
            if (n2 >= n3) break;
            ++n2;
            this.b(c3, n5);
        }
    }

    protected final void b(bcq bcq2, byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = n3 - 3;
        int n6 = this.f - 6;
        int n7 = bcq2.int_a() >> 2;
        while (n2 <= n5) {
            if (this.e > n6) {
                this.i();
            }
            n4 = byArray[n2++] << 8;
            n4 |= byArray[n2++] & 0xFF;
            n4 = n4 << 8 | byArray[n2++] & 0xFF;
            this.e = bcq2.a(n4, this.var_char_arr_b, this.e);
            if (--n7 > 0) continue;
            this.var_char_arr_b[this.e++] = 92;
            this.var_char_arr_b[this.e++] = 110;
            n7 = bcq2.int_a() >> 2;
        }
        n4 = n3 - n2;
        if (n4 > 0) {
            if (this.e > n6) {
                this.i();
            }
            int n8 = byArray[n2++] << 16;
            if (n4 == 2) {
                n8 |= (byArray[n2++] & 0xFF) << 8;
            }
            this.e = bcq2.a(n8, n4, this.var_char_arr_b, this.e);
        }
    }

    protected final int a(bcq bcq2, InputStream inputStream, byte[] byArray, int n2) {
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = -3;
        int n7 = this.f - 6;
        int n8 = bcq2.int_a() >> 2;
        while (n2 > 2) {
            if (n4 > n6) {
                n5 = this.a(inputStream, byArray, n4, n5, n2);
                n4 = 0;
                if (n5 < 3) break;
                n6 = n5 - 3;
            }
            if (this.e > n7) {
                this.i();
            }
            n3 = byArray[n4++] << 8;
            n3 |= byArray[n4++] & 0xFF;
            n3 = n3 << 8 | byArray[n4++] & 0xFF;
            n2 -= 3;
            this.e = bcq2.a(n3, this.var_char_arr_b, this.e);
            if (--n8 > 0) continue;
            this.var_char_arr_b[this.e++] = 92;
            this.var_char_arr_b[this.e++] = 110;
            n8 = bcq2.int_a() >> 2;
        }
        if (n2 > 0) {
            n5 = this.a(inputStream, byArray, n4, n5, n2);
            n4 = 0;
            if (n5 > 0) {
                int n9;
                if (this.e > n7) {
                    this.i();
                }
                n3 = byArray[n4++] << 16;
                if (n4 < n5) {
                    n3 |= (byArray[n4] & 0xFF) << 8;
                    n9 = 2;
                } else {
                    n9 = 1;
                }
                this.e = bcq2.a(n3, n9, this.var_char_arr_b, this.e);
                n2 -= n9;
            }
        }
        return n2;
    }

    protected final int a(bcq bcq2, InputStream inputStream, byte[] byArray) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        int n5 = -3;
        int n6 = 0;
        int n7 = this.f - 6;
        int n8 = bcq2.int_a() >> 2;
        while (true) {
            if (n3 > n5) {
                n4 = this.a(inputStream, byArray, n3, n4, byArray.length);
                n3 = 0;
                if (n4 < 3) break;
                n5 = n4 - 3;
            }
            if (this.e > n7) {
                this.i();
            }
            n2 = byArray[n3++] << 8;
            n2 |= byArray[n3++] & 0xFF;
            n2 = n2 << 8 | byArray[n3++] & 0xFF;
            n6 += 3;
            this.e = bcq2.a(n2, this.var_char_arr_b, this.e);
            if (--n8 > 0) continue;
            this.var_char_arr_b[this.e++] = 92;
            this.var_char_arr_b[this.e++] = 110;
            n8 = bcq2.int_a() >> 2;
        }
        if (n3 < n4) {
            if (this.e > n7) {
                this.i();
            }
            n2 = byArray[n3++] << 16;
            int n9 = 1;
            if (n3 < n4) {
                n2 |= (byArray[n3] & 0xFF) << 8;
                n9 = 2;
            }
            n6 += n9;
            this.e = bcq2.a(n2, n9, this.var_char_arr_b, this.e);
        }
        return n6;
    }

    private int a(InputStream inputStream, byte[] byArray, int n2, int n3, int n4) {
        int n5;
        int n6 = 0;
        while (n2 < n3) {
            byArray[n6++] = byArray[n2++];
        }
        n2 = 0;
        n3 = n6;
        n4 = Math.min(n4, byArray.length);
        while ((n5 = n4 - n3) != 0) {
            int n7 = inputStream.read(byArray, n3, n5);
            if (n7 < 0) {
                return n3;
            }
            if ((n3 += n7) < 3) continue;
        }
        return n3;
    }

    private final void j() {
        if (this.e + 4 >= this.f) {
            this.i();
        }
        int n2 = this.e;
        char[] cArray = this.var_char_arr_b;
        cArray[n2] = 110;
        cArray[++n2] = 117;
        cArray[++n2] = 108;
        cArray[++n2] = 108;
        this.e = n2 + 1;
    }

    private void a(char c2, int n2) {
        String string;
        if (n2 >= 0) {
            if (this.e >= 2) {
                int n3;
                this.var_int_d = n3 = this.e - 2;
                this.var_char_arr_b[n3++] = 92;
                this.var_char_arr_b[n3] = (char)n2;
                return;
            }
            char[] cArray = this.c;
            if (cArray == null) {
                cArray = this.char_arr_a();
            }
            this.var_int_d = this.e;
            cArray[1] = (char)n2;
            this.var_java_io_Writer_a.write(cArray, 0, 2);
            return;
        }
        if (n2 != -2) {
            if (this.e >= 6) {
                int n4;
                char[] cArray = this.var_char_arr_b;
                this.var_int_d = n4 = this.e - 6;
                cArray[n4] = 92;
                cArray[++n4] = 117;
                if (c2 > '\u00ff') {
                    int n5 = c2 >> 8 & 0xFF;
                    cArray[++n4] = var_char_arr_a[n5 >> 4];
                    cArray[++n4] = var_char_arr_a[n5 & 0xF];
                    c2 = (char)(c2 & 0xFF);
                } else {
                    cArray[++n4] = 48;
                    cArray[++n4] = 48;
                }
                cArray[++n4] = var_char_arr_a[c2 >> 4];
                cArray[++n4] = var_char_arr_a[c2 & 0xF];
                return;
            }
            char[] cArray = this.c;
            if (cArray == null) {
                cArray = this.char_arr_a();
            }
            this.var_int_d = this.e;
            if (c2 > '\u00ff') {
                int n6 = c2 >> 8 & 0xFF;
                int n7 = c2 & 0xFF;
                cArray[10] = var_char_arr_a[n6 >> 4];
                cArray[11] = var_char_arr_a[n6 & 0xF];
                cArray[12] = var_char_arr_a[n7 >> 4];
                cArray[13] = var_char_arr_a[n7 & 0xF];
                this.var_java_io_Writer_a.write(cArray, 8, 6);
            } else {
                cArray[6] = var_char_arr_a[c2 >> 4];
                cArray[7] = var_char_arr_a[c2 & 0xF];
                this.var_java_io_Writer_a.write(cArray, 2, 6);
            }
            return;
        }
        if (this.var_bdi_b == null) {
            string = this.var_char_arr_a.a(c2).java_lang_String_a();
        } else {
            string = this.var_bdi_b.java_lang_String_a();
            this.var_bdi_b = null;
        }
        int n8 = string.length();
        if (this.e >= n8) {
            int n9;
            this.var_int_d = n9 = this.e - n8;
            string.getChars(0, n8, this.var_char_arr_b, n9);
            return;
        }
        this.var_int_d = this.e;
        this.var_java_io_Writer_a.write(string);
    }

    private int a(char[] cArray, int n2, int n3, char c2, int n4) {
        String string;
        if (n4 >= 0) {
            if (n2 > 1 && n2 < n3) {
                cArray[n2 -= 2] = 92;
                cArray[n2 + 1] = (char)n4;
            } else {
                char[] cArray2 = this.c;
                if (cArray2 == null) {
                    cArray2 = this.char_arr_a();
                }
                cArray2[1] = (char)n4;
                this.var_java_io_Writer_a.write(cArray2, 0, 2);
            }
            return n2;
        }
        if (n4 != -2) {
            if (n2 > 5 && n2 < n3) {
                n2 -= 6;
                cArray[n2++] = 92;
                cArray[n2++] = 117;
                if (c2 > '\u00ff') {
                    int n5 = c2 >> 8 & 0xFF;
                    cArray[n2++] = var_char_arr_a[n5 >> 4];
                    cArray[n2++] = var_char_arr_a[n5 & 0xF];
                    c2 = (char)(c2 & 0xFF);
                } else {
                    cArray[n2++] = 48;
                    cArray[n2++] = 48;
                }
                cArray[n2++] = var_char_arr_a[c2 >> 4];
                cArray[n2] = var_char_arr_a[c2 & 0xF];
                n2 -= 5;
            } else {
                char[] cArray3 = this.c;
                if (cArray3 == null) {
                    cArray3 = this.char_arr_a();
                }
                this.var_int_d = this.e;
                if (c2 > '\u00ff') {
                    int n6 = c2 >> 8 & 0xFF;
                    int n7 = c2 & 0xFF;
                    cArray3[10] = var_char_arr_a[n6 >> 4];
                    cArray3[11] = var_char_arr_a[n6 & 0xF];
                    cArray3[12] = var_char_arr_a[n7 >> 4];
                    cArray3[13] = var_char_arr_a[n7 & 0xF];
                    this.var_java_io_Writer_a.write(cArray3, 8, 6);
                } else {
                    cArray3[6] = var_char_arr_a[c2 >> 4];
                    cArray3[7] = var_char_arr_a[c2 & 0xF];
                    this.var_java_io_Writer_a.write(cArray3, 2, 6);
                }
            }
            return n2;
        }
        if (this.var_bdi_b == null) {
            string = this.var_char_arr_a.a(c2).java_lang_String_a();
        } else {
            string = this.var_bdi_b.java_lang_String_a();
            this.var_bdi_b = null;
        }
        int n8 = string.length();
        if (n2 >= n8 && n2 < n3) {
            string.getChars(0, n8, cArray, n2 -= n8);
        } else {
            this.var_java_io_Writer_a.write(string);
        }
        return n2;
    }

    private void b(char c2, int n2) {
        String string;
        if (n2 >= 0) {
            if (this.e + 2 > this.f) {
                this.i();
            }
            this.var_char_arr_b[this.e++] = 92;
            this.var_char_arr_b[this.e++] = (char)n2;
            return;
        }
        if (n2 != -2) {
            if (this.e + 5 >= this.f) {
                this.i();
            }
            int n3 = this.e;
            char[] cArray = this.var_char_arr_b;
            cArray[n3++] = 92;
            cArray[n3++] = 117;
            if (c2 > '\u00ff') {
                int n4 = c2 >> 8 & 0xFF;
                cArray[n3++] = var_char_arr_a[n4 >> 4];
                cArray[n3++] = var_char_arr_a[n4 & 0xF];
                c2 = (char)(c2 & 0xFF);
            } else {
                cArray[n3++] = 48;
                cArray[n3++] = 48;
            }
            cArray[n3++] = var_char_arr_a[c2 >> 4];
            cArray[n3++] = var_char_arr_a[c2 & 0xF];
            this.e = n3;
            return;
        }
        if (this.var_bdi_b == null) {
            string = this.var_char_arr_a.a(c2).java_lang_String_a();
        } else {
            string = this.var_bdi_b.java_lang_String_a();
            this.var_bdi_b = null;
        }
        int n5 = string.length();
        if (this.e + n5 > this.f) {
            this.i();
            if (n5 > this.f) {
                this.var_java_io_Writer_a.write(string);
                return;
            }
        }
        string.getChars(0, n5, this.var_char_arr_b, this.e);
        this.e += n5;
    }

    private char[] char_arr_a() {
        char[] cArray = new char[14];
        cArray[0] = 92;
        cArray[2] = 92;
        cArray[3] = 117;
        cArray[4] = 48;
        cArray[5] = 48;
        cArray[8] = 92;
        cArray[9] = 117;
        this.c = cArray;
        return cArray;
    }

    protected void i() {
        int n2 = this.e - this.var_int_d;
        if (n2 > 0) {
            int n3 = this.var_int_d;
            this.var_int_d = 0;
            this.e = 0;
            this.var_java_io_Writer_a.write(this.var_char_arr_b, n3, n2);
        }
    }

    static {
        var_char_arr_a = bdt.char_arr_a();
    }
}

