/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class beo
extends bej {
    private static final byte[] b = bdt.byte_arr_a();
    private static final byte[] c = new byte[]{110, 117, 108, 108};
    private static final byte[] var_byte_arr_d;
    private static final byte[] var_byte_arr_e;
    protected final OutputStream var_java_io_OutputStream_a;
    protected byte var_byte_a;
    protected byte[] var_byte_arr_a;
    protected int var_int_d;
    protected final int var_int_e;
    protected final int f;
    protected char[] var_char_arr_a;
    protected final int g;
    protected boolean var_boolean_d;

    public beo(bdv bdv2, int n2, bdg bdg2, OutputStream outputStream, char c2) {
        super(bdv2, n2, bdg2);
        this.var_java_io_OutputStream_a = outputStream;
        this.var_byte_a = (byte)c2;
        if (c2 != '\"') {
            this.b = (byte[])bdt.int_arr_a(c2);
        }
        this.var_boolean_d = true;
        this.var_byte_arr_a = bdv2.byte_arr_b();
        this.var_int_e = this.var_byte_arr_a.length;
        this.f = this.var_int_e >> 3;
        this.var_char_arr_a = bdv2.char_arr_b();
        this.g = this.var_char_arr_a.length;
        if (this.boolean_a(bcy.a.f)) {
            this.bcy_b(127);
        }
    }

    @Override
    public void a(String string) {
        if (this.var_java_io_OutputStream_a != null) {
            this.j(string);
            return;
        }
        int n2 = ((bem)((Object)this.var_java_io_OutputStream_a)).a(string);
        if (n2 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        if (n2 == 1) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 44;
        }
        if (this.c != false) {
            this.a(string, false);
            return;
        }
        int n3 = string.length();
        if (n3 > this.g) {
            this.a(string, true);
            return;
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        if (n3 <= this.f) {
            if (this.var_int_d + n3 > this.var_int_e) {
                this.i();
            }
            this.c(string, 0, n3);
        } else {
            this.b(string, 0, n3);
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void void_a(bdi bdi2) {
        if (this.var_java_io_OutputStream_a != null) {
            this.e(bdi2);
            return;
        }
        int n2 = ((bem)((Object)this.var_java_io_OutputStream_a)).a(bdi2.java_lang_String_a());
        if (n2 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        if (n2 == 1) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 44;
        }
        if (this.c != false) {
            this.f(bdi2);
            return;
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        int n3 = bdi2.a(this.var_byte_arr_a, this.var_int_d);
        if (n3 < 0) {
            this.b(bdi2.b());
        } else {
            this.var_int_d += n3;
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    private final void f(bdi bdi2) {
        int n2 = bdi2.a(this.var_byte_arr_a, this.var_int_d);
        if (n2 < 0) {
            this.b(bdi2.b());
        } else {
            this.var_int_d += n2;
        }
    }

    @Override
    public final void void_a() {
        this.h("start an array");
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).java_lang_Object_a();
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.e(this);
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 91;
        }
    }

    @Override
    public final void b(Object object) {
        this.h("start an array");
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).bem_a(object);
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.e(this);
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 91;
        }
    }

    @Override
    public void a(Object object, int n2) {
        this.h("start an array");
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).bem_a(object);
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.e(this);
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 91;
        }
    }

    @Override
    public final void void_b() {
        if (!((bde)((Object)this.var_java_io_OutputStream_a)).boolean_a()) {
            this.g("Current context not Array but " + (String)((bem)((Object)this.var_java_io_OutputStream_a)).java_lang_Object_a());
        }
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.b(this, ((bde)((Object)this.var_java_io_OutputStream_a)).int_a());
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 93;
        }
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).d();
    }

    @Override
    public final void void_c() {
        this.h("start an object");
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).bem_b();
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.b(this);
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 123;
        }
    }

    @Override
    public void c(Object object) {
        this.h("start an object");
        bem bem2 = ((bem)((Object)this.var_java_io_OutputStream_a)).b(object);
        this.var_java_io_OutputStream_a = bem2;
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.b(this);
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 123;
        }
    }

    @Override
    public final void void_d() {
        if (!((bde)((Object)this.var_java_io_OutputStream_a)).boolean_c()) {
            this.g("Current context not Object but " + (String)((bem)((Object)this.var_java_io_OutputStream_a)).java_lang_Object_a());
        }
        if (this.var_java_io_OutputStream_a != null) {
            this.var_java_io_OutputStream_a.a(this, ((bde)((Object)this.var_java_io_OutputStream_a)).int_a());
        } else {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = 125;
        }
        this.var_java_io_OutputStream_a = ((bem)((Object)this.var_java_io_OutputStream_a)).d();
    }

    protected final void j(String string) {
        int n2 = ((bem)((Object)this.var_java_io_OutputStream_a)).a(string);
        if (n2 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        if (n2 == 1) {
            this.var_java_io_OutputStream_a.c(this);
        } else {
            this.var_java_io_OutputStream_a.h(this);
        }
        if (this.c != false) {
            this.a(string, false);
            return;
        }
        int n3 = string.length();
        if (n3 > this.g) {
            this.a(string, true);
            return;
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        string.getChars(0, n3, this.var_char_arr_a, 0);
        if (n3 <= this.f) {
            if (this.var_int_d + n3 > this.var_int_e) {
                this.i();
            }
            this.f(this.var_char_arr_a, 0, n3);
        } else {
            this.e(this.var_char_arr_a, 0, n3);
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    protected final void e(bdi bdi2) {
        int n2;
        boolean bl2;
        int n3 = ((bem)((Object)this.var_java_io_OutputStream_a)).a(bdi2.java_lang_String_a());
        if (n3 == 4) {
            this.g("Can not write a field name, expecting a value");
        }
        if (n3 == 1) {
            this.var_java_io_OutputStream_a.c(this);
        } else {
            this.var_java_io_OutputStream_a.h(this);
        }
        boolean bl3 = bl2 = this.c == false;
        if (bl2) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        }
        if ((n2 = bdi2.a(this.var_byte_arr_a, this.var_int_d)) < 0) {
            this.b(bdi2.b());
        } else {
            this.var_int_d += n2;
        }
        if (bl2) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        }
    }

    @Override
    public void b(String string) {
        this.h("write a string");
        if (string == null) {
            this.j();
            return;
        }
        int n2 = string.length();
        if (n2 > this.f) {
            this.a(string, true);
            return;
        }
        if (this.var_int_d + n2 >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.c(string, 0, n2);
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void a(char[] cArray, int n2, int n3) {
        this.h("write a string");
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        if (n3 <= this.f) {
            if (this.var_int_d + n3 > this.var_int_e) {
                this.i();
            }
            this.f(cArray, n2, n3);
        } else {
            this.e(cArray, n2, n3);
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public final void b(bdi bdi2) {
        this.h("write a string");
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        int n2 = bdi2.a(this.var_byte_arr_a, this.var_int_d);
        if (n2 < 0) {
            this.b(bdi2.b());
        } else {
            this.var_int_d += n2;
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void c(String string) {
        char[] cArray;
        int n2 = string.length();
        if (n2 <= (cArray = this.var_char_arr_a).length) {
            string.getChars(0, n2, cArray, 0);
            this.b(cArray, 0, n2);
        } else {
            this.a(string, 0, n2);
        }
    }

    public void a(String string, int n2, int n3) {
        char[] cArray = this.var_char_arr_a;
        int n4 = cArray.length;
        if (n3 <= n4) {
            string.getChars(n2, n2 + n3, cArray, 0);
            this.b(cArray, 0, n3);
            return;
        }
        int n5 = Math.min(n4, (this.var_int_e >> 2) + (this.var_int_e >> 4));
        int n6 = n5 * 3;
        while (n3 > 0) {
            char c2;
            int n7 = Math.min(n5, n3);
            string.getChars(n2, n2 + n7, cArray, 0);
            if (this.var_int_d + n6 > this.var_int_e) {
                this.i();
            }
            if (n7 > 1 && (c2 = cArray[n7 - 1]) >= '\ud800' && c2 <= '\udbff') {
                --n7;
            }
            this.d(cArray, 0, n7);
            n2 += n7;
            n3 -= n7;
        }
    }

    @Override
    public void c(bdi bdi2) {
        int n2 = bdi2.b(this.var_byte_arr_a, this.var_int_d);
        if (n2 < 0) {
            this.b(bdi2.byte_arr_a());
        } else {
            this.var_int_d += n2;
        }
    }

    @Override
    public void d(bdi bdi2) {
        this.h("write a raw (unencoded) value");
        int n2 = bdi2.b(this.var_byte_arr_a, this.var_int_d);
        if (n2 < 0) {
            this.b(bdi2.byte_arr_a());
        } else {
            this.var_int_d += n2;
        }
    }

    @Override
    public final void b(char[] cArray, int n2, int n3) {
        int n4 = n3 + n3 + n3;
        if (this.var_int_d + n4 > this.var_int_e) {
            if (this.var_int_e < n4) {
                this.c(cArray, n2, n3);
                return;
            }
            this.i();
        }
        n3 += n2;
        block0: while (n2 < n3) {
            while ((n4 = cArray[n2]) <= 127) {
                this.var_byte_arr_a[this.var_int_d++] = (byte)n4;
                if (++n2 < n3) continue;
                break block0;
            }
            n4 = cArray[n2++];
            if (n4 < 2048) {
                this.var_byte_arr_a[this.var_int_d++] = (byte)(0xC0 | n4 >> 6);
                this.var_byte_arr_a[this.var_int_d++] = (byte)(0x80 | n4 & 0x3F);
                continue;
            }
            n2 = this.a(n4, cArray, n2, n3);
        }
    }

    @Override
    public void a(char c2) {
        if (this.var_int_d + 3 >= this.var_int_e) {
            this.i();
        }
        byte[] byArray = this.var_byte_arr_a;
        if (c2 <= '\u007f') {
            byArray[this.var_int_d++] = (byte)c2;
        } else if (c2 < '\u0800') {
            byArray[this.var_int_d++] = (byte)(0xC0 | c2 >> 6);
            byArray[this.var_int_d++] = (byte)(0x80 | c2 & 0x3F);
        } else {
            this.a(c2, null, 0, 0);
        }
    }

    private final void c(char[] cArray, int n2, int n3) {
        int n4 = this.var_int_e;
        byte[] byArray = this.var_byte_arr_a;
        int n5 = n2 + n3;
        block0: while (n2 < n5) {
            char c2;
            while ((c2 = cArray[n2]) < '\u0080') {
                if (this.var_int_d >= n4) {
                    this.i();
                }
                byArray[this.var_int_d++] = (byte)c2;
                if (++n2 < n5) continue;
                break block0;
            }
            if (this.var_int_d + 3 >= this.var_int_e) {
                this.i();
            }
            if ((c2 = cArray[n2++]) < '\u0800') {
                byArray[this.var_int_d++] = (byte)(0xC0 | c2 >> 6);
                byArray[this.var_int_d++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n2 = this.a(c2, cArray, n2, n5);
        }
    }

    private void d(char[] cArray, int n2, int n3) {
        block0: while (n2 < n3) {
            char c2;
            while ((c2 = cArray[n2]) <= '\u007f') {
                this.var_byte_arr_a[this.var_int_d++] = (byte)c2;
                if (++n2 < n3) continue;
                break block0;
            }
            c2 = cArray[n2++];
            if (c2 < '\u0800') {
                this.var_byte_arr_a[this.var_int_d++] = (byte)(0xC0 | c2 >> 6);
                this.var_byte_arr_a[this.var_int_d++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n2 = this.a(c2, cArray, n2, n3);
        }
    }

    @Override
    public void a(bcq bcq2, byte[] byArray, int n2, int n3) {
        this.h("write a binary value");
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.b(bcq2, byArray, n2, n2 + n3);
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int a(bcq bcq2, InputStream inputStream, int n2) {
        int n3;
        this.h("write a binary value");
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        byte[] byArray = ((bdv)((Object)this.var_java_io_OutputStream_a)).c();
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
            ((bdv)((Object)this.var_java_io_OutputStream_a)).c(byArray);
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        return n3;
    }

    @Override
    public void a(short s2) {
        this.h("write a number");
        if (this.var_int_d + 6 >= this.var_int_e) {
            this.i();
        }
        if (this.var_java_io_OutputStream_a != false) {
            this.b(s2);
            return;
        }
        this.var_int_d = beb.a((int)s2, this.var_byte_arr_a, this.var_int_d);
    }

    private final void b(short s2) {
        if (this.var_int_d + 8 >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.var_int_d = beb.a((int)s2, this.var_byte_arr_a, this.var_int_d);
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void void_b(int n2) {
        this.h("write a number");
        if (this.var_int_d + 11 >= this.var_int_e) {
            this.i();
        }
        if (this.var_java_io_OutputStream_a != false) {
            this.c(n2);
            return;
        }
        this.var_int_d = beb.a(n2, this.var_byte_arr_a, this.var_int_d);
    }

    private final void c(int n2) {
        if (this.var_int_d + 13 >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.var_int_d = beb.a(n2, this.var_byte_arr_a, this.var_int_d);
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void b(long l2) {
        this.h("write a number");
        if (this.var_java_io_OutputStream_a != false) {
            this.c(l2);
            return;
        }
        if (this.var_int_d + 21 >= this.var_int_e) {
            this.i();
        }
        this.var_int_d = beb.a(l2, this.var_byte_arr_a, this.var_int_d);
    }

    private final void c(long l2) {
        if (this.var_int_d + 23 >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.var_int_d = beb.a(l2, this.var_byte_arr_a, this.var_int_d);
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void a(BigInteger bigInteger) {
        this.h("write a number");
        if (bigInteger == null) {
            this.j();
        } else if (this.var_java_io_OutputStream_a != false) {
            this.k(bigInteger.toString());
        } else {
            this.c(bigInteger.toString());
        }
    }

    @Override
    public void a(double d2) {
        if (this.var_java_io_OutputStream_a != false || beb.a(d2) && bcy.a.e.a((int)this.b)) {
            this.b(String.valueOf(d2));
            return;
        }
        this.h("write a number");
        this.c(String.valueOf(d2));
    }

    @Override
    public void a(float f2) {
        if (this.var_java_io_OutputStream_a != false || beb.a(f2) && bcy.a.e.a((int)this.b)) {
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
        } else if (this.var_java_io_OutputStream_a != false) {
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
        } else if (this.var_java_io_OutputStream_a != false) {
            this.k(string);
        } else {
            this.c(string);
        }
    }

    private final void k(String string) {
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        this.c(string);
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
    }

    @Override
    public void a(boolean bl2) {
        this.h("write a boolean value");
        if (this.var_int_d + 5 >= this.var_int_e) {
            this.i();
        }
        byte[] byArray = bl2 ? var_byte_arr_d : var_byte_arr_e;
        int n2 = byArray.length;
        System.arraycopy(byArray, 0, this.var_byte_arr_a, this.var_int_d, n2);
        this.var_int_d += n2;
    }

    @Override
    public void e() {
        this.h("write a null");
        this.j();
    }

    @Override
    protected final void h(String string) {
        int n2;
        int n3 = ((bem)((Object)this.var_java_io_OutputStream_a)).int_c();
        if (this.var_java_io_OutputStream_a != null) {
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
                byte[] byArray;
                if (this.var_java_io_OutputStream_a != null && (byArray = this.var_java_io_OutputStream_a.byte_arr_a()).length > 0) {
                    this.b(byArray);
                }
                return;
            }
            case 5: {
                this.i(string);
                return;
            }
        }
        if (this.var_int_d >= this.var_int_e) {
            this.i();
        }
        this.var_byte_arr_a[this.var_int_d++] = n2;
    }

    @Override
    public void flush() {
        this.i();
        if (this.var_java_io_OutputStream_a != null && this.boolean_a(bcy.a.c)) {
            this.var_java_io_OutputStream_a.flush();
        }
    }

    @Override
    public void close() {
        super.close();
        if (this.var_byte_arr_a != null && this.boolean_a(bcy.a.b)) {
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
        if (this.var_java_io_OutputStream_a != null) {
            if (((bdv)((Object)this.var_java_io_OutputStream_a)).boolean_a() || this.boolean_a(bcy.a.var_bcy$a_a)) {
                this.var_java_io_OutputStream_a.close();
            } else if (this.boolean_a(bcy.a.c)) {
                this.var_java_io_OutputStream_a.flush();
            }
        }
        this.h();
    }

    @Override
    protected void h() {
        char[] cArray;
        byte[] byArray = this.var_byte_arr_a;
        if (byArray != null && this.var_boolean_d) {
            this.var_byte_arr_a = null;
            ((bdv)((Object)this.var_java_io_OutputStream_a)).b(byArray);
        }
        if ((cArray = this.var_char_arr_a) != null) {
            this.var_char_arr_a = null;
            ((bdv)((Object)this.var_java_io_OutputStream_a)).b(cArray);
        }
    }

    private final void b(byte[] byArray) {
        int n2 = byArray.length;
        if (this.var_int_d + n2 > this.var_int_e) {
            this.i();
            if (n2 > 512) {
                this.var_java_io_OutputStream_a.write(byArray, 0, n2);
                return;
            }
        }
        System.arraycopy(byArray, 0, this.var_byte_arr_a, this.var_int_d, n2);
        this.var_int_d += n2;
    }

    private final void a(String string, boolean bl2) {
        int n2;
        if (bl2) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        }
        int n3 = 0;
        for (int i2 = string.length(); i2 > 0; i2 -= n2) {
            n2 = Math.min(this.f, i2);
            if (this.var_int_d + n2 > this.var_int_e) {
                this.i();
            }
            this.c(string, n3, n2);
            n3 += n2;
        }
        if (bl2) {
            if (this.var_int_d >= this.var_int_e) {
                this.i();
            }
            this.var_byte_arr_a[this.var_int_d++] = this.var_byte_a;
        }
    }

    private final void e(char[] cArray, int n2, int n3) {
        int n4;
        do {
            if (this.var_int_d + (n4 = Math.min(this.f, n3)) > this.var_int_e) {
                this.i();
            }
            this.f(cArray, n2, n4);
            n2 += n4;
        } while ((n3 -= n4) > 0);
    }

    private final void b(String string, int n2, int n3) {
        int n4;
        do {
            if (this.var_int_d + (n4 = Math.min(this.f, n3)) > this.var_int_e) {
                this.i();
            }
            this.c(string, n2, n4);
            n2 += n4;
        } while ((n3 -= n4) > 0);
    }

    private final void f(char[] cArray, int n2, int n3) {
        char c2;
        n3 += n2;
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        while (n2 < n3 && (c2 = cArray[n2]) <= '\u007f' && byArray2[c2] == 0) {
            byArray[n4++] = (byte)c2;
            ++n2;
        }
        this.var_int_d = n4;
        if (n2 < n3) {
            if (this.var_java_io_OutputStream_a != null) {
                this.i(cArray, n2, n3);
            } else if (this.c == false) {
                this.g(cArray, n2, n3);
            } else {
                this.h(cArray, n2, n3);
            }
        }
    }

    private final void c(String string, int n2, int n3) {
        char c2;
        n3 += n2;
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        while (n2 < n3 && (c2 = string.charAt(n2)) <= '\u007f' && byArray2[c2] == 0) {
            byArray[n4++] = (byte)c2;
            ++n2;
        }
        this.var_int_d = n4;
        if (n2 < n3) {
            if (this.var_java_io_OutputStream_a != null) {
                this.f(string, n2, n3);
            } else if (this.c == false) {
                this.d(string, n2, n3);
            } else {
                this.e(string, n2, n3);
            }
        }
    }

    private final void g(char[] cArray, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        while (n2 < n3) {
            char c2;
            if ((c2 = cArray[n2++]) <= '\u007f') {
                if (byArray2[c2] == 0) {
                    byArray[n4++] = (byte)c2;
                    continue;
                }
                byte by2 = byArray2[c2];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c2 >> 6);
                byArray[n4++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n4 = this.int_b(c2, n4);
        }
        this.var_int_d = n4;
    }

    private final void d(String string, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        while (n2 < n3) {
            char c2;
            if ((c2 = string.charAt(n2++)) <= '\u007f') {
                if (byArray2[c2] == 0) {
                    byArray[n4++] = (byte)c2;
                    continue;
                }
                byte by2 = byArray2[c2];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c2 >> 6);
                byArray[n4++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n4 = this.int_b(c2, n4);
        }
        this.var_int_d = n4;
    }

    private final void h(char[] cArray, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        byte[] byArray3 = this.c;
        while (n2 < n3) {
            char c2;
            if ((c2 = cArray[n2++]) <= '\u007f') {
                if (byArray2[c2] == 0) {
                    byArray[n4++] = (byte)c2;
                    continue;
                }
                byte by2 = byArray2[c2];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 > byArray3) {
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c2 >> 6);
                byArray[n4++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n4 = this.int_b(c2, n4);
        }
        this.var_int_d = n4;
    }

    private final void e(String string, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        byte[] byArray3 = this.c;
        while (n2 < n3) {
            char c2;
            if ((c2 = string.charAt(n2++)) <= '\u007f') {
                if (byArray2[c2] == 0) {
                    byArray[n4++] = (byte)c2;
                    continue;
                }
                byte by2 = byArray2[c2];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 > byArray3) {
                n4 = this.c(c2, n4);
                continue;
            }
            if (c2 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c2 >> 6);
                byArray[n4++] = (byte)(0x80 | c2 & 0x3F);
                continue;
            }
            n4 = this.int_b(c2, n4);
        }
        this.var_int_d = n4;
    }

    private final void i(char[] cArray, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        char c2 = this.c <= 0 ? 65535 : (int)this.c;
        OutputStream outputStream = this.var_java_io_OutputStream_a;
        while (n2 < n3) {
            char c3;
            if ((c3 = cArray[n2++]) <= '\u007f') {
                if (byArray2[c3] == 0) {
                    byArray[n4++] = (byte)c3;
                    continue;
                }
                byte by2 = byArray2[c3];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                if (by2 == -2) {
                    bdi bdi2 = ((bdu)((Object)outputStream)).a(c3);
                    if (bdi2 == null) {
                        this.g("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c3) + ", although was supposed to have one");
                    }
                    n4 = this.a(byArray, n4, bdi2, n3 - n2);
                    continue;
                }
                n4 = this.c(c3, n4);
                continue;
            }
            if (c3 > c2) {
                n4 = this.c(c3, n4);
                continue;
            }
            bdi bdi3 = ((bdu)((Object)outputStream)).a(c3);
            if (bdi3 != null) {
                n4 = this.a(byArray, n4, bdi3, n3 - n2);
                continue;
            }
            if (c3 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c3 >> 6);
                byArray[n4++] = (byte)(0x80 | c3 & 0x3F);
                continue;
            }
            n4 = this.int_b(c3, n4);
        }
        this.var_int_d = n4;
    }

    private final void f(String string, int n2, int n3) {
        if (this.var_int_d + 6 * (n3 - n2) > this.var_int_e) {
            this.i();
        }
        int n4 = this.var_int_d;
        byte[] byArray = this.var_byte_arr_a;
        byte[] byArray2 = this.b;
        char c2 = this.c <= 0 ? 65535 : (int)this.c;
        OutputStream outputStream = this.var_java_io_OutputStream_a;
        while (n2 < n3) {
            char c3;
            if ((c3 = string.charAt(n2++)) <= '\u007f') {
                if (byArray2[c3] == 0) {
                    byArray[n4++] = (byte)c3;
                    continue;
                }
                byte by2 = byArray2[c3];
                if (by2 > 0) {
                    byArray[n4++] = 92;
                    byArray[n4++] = by2;
                    continue;
                }
                if (by2 == -2) {
                    bdi bdi2 = ((bdu)((Object)outputStream)).a(c3);
                    if (bdi2 == null) {
                        this.g("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c3) + ", although was supposed to have one");
                    }
                    n4 = this.a(byArray, n4, bdi2, n3 - n2);
                    continue;
                }
                n4 = this.c(c3, n4);
                continue;
            }
            if (c3 > c2) {
                n4 = this.c(c3, n4);
                continue;
            }
            bdi bdi3 = ((bdu)((Object)outputStream)).a(c3);
            if (bdi3 != null) {
                n4 = this.a(byArray, n4, bdi3, n3 - n2);
                continue;
            }
            if (c3 <= '\u07ff') {
                byArray[n4++] = (byte)(0xC0 | c3 >> 6);
                byArray[n4++] = (byte)(0x80 | c3 & 0x3F);
                continue;
            }
            n4 = this.int_b(c3, n4);
        }
        this.var_int_d = n4;
    }

    private final int a(byte[] byArray, int n2, bdi bdi2, int n3) {
        byte[] byArray2 = bdi2.byte_arr_a();
        int n4 = byArray2.length;
        if (n4 > 6) {
            return this.a(byArray, n2, this.var_int_e, byArray2, n3);
        }
        System.arraycopy(byArray2, 0, byArray, n2, n4);
        return n2 + n4;
    }

    private final int a(byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        int n5 = byArray2.length;
        if (n2 + n5 > n3) {
            this.var_int_d = n2;
            this.i();
            n2 = this.var_int_d;
            if (n5 > byArray.length) {
                this.var_java_io_OutputStream_a.write(byArray2, 0, n5);
                return n2;
            }
        }
        System.arraycopy(byArray2, 0, byArray, n2, n5);
        if ((n2 += n5) + 6 * n4 > n3) {
            this.var_int_d = n2;
            this.i();
            return this.var_int_d;
        }
        return n2;
    }

    protected final void b(bcq bcq2, byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = n3 - 3;
        int n6 = this.var_int_e - 6;
        int n7 = bcq2.int_a() >> 2;
        while (n2 <= n5) {
            if (this.var_int_d > n6) {
                this.i();
            }
            n4 = byArray[n2++] << 8;
            n4 |= byArray[n2++] & 0xFF;
            n4 = n4 << 8 | byArray[n2++] & 0xFF;
            this.var_int_d = bcq2.a(n4, this.var_byte_arr_a, this.var_int_d);
            if (--n7 > 0) continue;
            this.var_byte_arr_a[this.var_int_d++] = 92;
            this.var_byte_arr_a[this.var_int_d++] = 110;
            n7 = bcq2.int_a() >> 2;
        }
        n4 = n3 - n2;
        if (n4 > 0) {
            if (this.var_int_d > n6) {
                this.i();
            }
            int n8 = byArray[n2++] << 16;
            if (n4 == 2) {
                n8 |= (byArray[n2++] & 0xFF) << 8;
            }
            this.var_int_d = bcq2.a(n8, n4, this.var_byte_arr_a, this.var_int_d);
        }
    }

    protected final int a(bcq bcq2, InputStream inputStream, byte[] byArray, int n2) {
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = -3;
        int n7 = this.var_int_e - 6;
        int n8 = bcq2.int_a() >> 2;
        while (n2 > 2) {
            if (n4 > n6) {
                n5 = this.a(inputStream, byArray, n4, n5, n2);
                n4 = 0;
                if (n5 < 3) break;
                n6 = n5 - 3;
            }
            if (this.var_int_d > n7) {
                this.i();
            }
            n3 = byArray[n4++] << 8;
            n3 |= byArray[n4++] & 0xFF;
            n3 = n3 << 8 | byArray[n4++] & 0xFF;
            n2 -= 3;
            this.var_int_d = bcq2.a(n3, this.var_byte_arr_a, this.var_int_d);
            if (--n8 > 0) continue;
            this.var_byte_arr_a[this.var_int_d++] = 92;
            this.var_byte_arr_a[this.var_int_d++] = 110;
            n8 = bcq2.int_a() >> 2;
        }
        if (n2 > 0) {
            n5 = this.a(inputStream, byArray, n4, n5, n2);
            n4 = 0;
            if (n5 > 0) {
                int n9;
                if (this.var_int_d > n7) {
                    this.i();
                }
                n3 = byArray[n4++] << 16;
                if (n4 < n5) {
                    n3 |= (byArray[n4] & 0xFF) << 8;
                    n9 = 2;
                } else {
                    n9 = 1;
                }
                this.var_int_d = bcq2.a(n3, n9, this.var_byte_arr_a, this.var_int_d);
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
        int n7 = this.var_int_e - 6;
        int n8 = bcq2.int_a() >> 2;
        while (true) {
            if (n3 > n5) {
                n4 = this.a(inputStream, byArray, n3, n4, byArray.length);
                n3 = 0;
                if (n4 < 3) break;
                n5 = n4 - 3;
            }
            if (this.var_int_d > n7) {
                this.i();
            }
            n2 = byArray[n3++] << 8;
            n2 |= byArray[n3++] & 0xFF;
            n2 = n2 << 8 | byArray[n3++] & 0xFF;
            n6 += 3;
            this.var_int_d = bcq2.a(n2, this.var_byte_arr_a, this.var_int_d);
            if (--n8 > 0) continue;
            this.var_byte_arr_a[this.var_int_d++] = 92;
            this.var_byte_arr_a[this.var_int_d++] = 110;
            n8 = bcq2.int_a() >> 2;
        }
        if (n3 < n4) {
            if (this.var_int_d > n7) {
                this.i();
            }
            n2 = byArray[n3++] << 16;
            int n9 = 1;
            if (n3 < n4) {
                n2 |= (byArray[n3] & 0xFF) << 8;
                n9 = 2;
            }
            n6 += n9;
            this.var_int_d = bcq2.a(n2, n9, this.var_byte_arr_a, this.var_int_d);
        }
        return n6;
    }

    private final int a(InputStream inputStream, byte[] byArray, int n2, int n3, int n4) {
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

    private final int a(int n2, char[] cArray, int n3, int n4) {
        if (n2 >= 55296 && n2 <= 57343) {
            if (n3 >= n4 || cArray == null) {
                this.g(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", n2));
            } else {
                this.void_b(n2, (int)cArray[n3]);
            }
            return n3 + 1;
        }
        byte[] byArray = this.var_byte_arr_a;
        byArray[this.var_int_d++] = (byte)(0xE0 | n2 >> 12);
        byArray[this.var_int_d++] = (byte)(0x80 | n2 >> 6 & 0x3F);
        byArray[this.var_int_d++] = (byte)(0x80 | n2 & 0x3F);
        return n3;
    }

    protected final void void_b(int n2, int n3) {
        int n4 = this.int_a(n2, n3);
        if (this.var_int_d + 4 > this.var_int_e) {
            this.i();
        }
        byte[] byArray = this.var_byte_arr_a;
        byArray[this.var_int_d++] = (byte)(0xF0 | n4 >> 18);
        byArray[this.var_int_d++] = (byte)(0x80 | n4 >> 12 & 0x3F);
        byArray[this.var_int_d++] = (byte)(0x80 | n4 >> 6 & 0x3F);
        byArray[this.var_int_d++] = (byte)(0x80 | n4 & 0x3F);
    }

    private final int int_b(int n2, int n3) {
        byte[] byArray = this.var_byte_arr_a;
        if (n2 >= 55296 && n2 <= 57343) {
            byArray[n3++] = 92;
            byArray[n3++] = 117;
            byArray[n3++] = b[n2 >> 12 & 0xF];
            byArray[n3++] = b[n2 >> 8 & 0xF];
            byArray[n3++] = b[n2 >> 4 & 0xF];
            byArray[n3++] = b[n2 & 0xF];
        } else {
            byArray[n3++] = (byte)(0xE0 | n2 >> 12);
            byArray[n3++] = (byte)(0x80 | n2 >> 6 & 0x3F);
            byArray[n3++] = (byte)(0x80 | n2 & 0x3F);
        }
        return n3;
    }

    private final void j() {
        if (this.var_int_d + 4 >= this.var_int_e) {
            this.i();
        }
        System.arraycopy(c, 0, this.var_byte_arr_a, this.var_int_d, 4);
        this.var_int_d += 4;
    }

    private int c(int n2, int n3) {
        byte[] byArray = this.var_byte_arr_a;
        byArray[n3++] = 92;
        byArray[n3++] = 117;
        if (n2 > 255) {
            int n4 = n2 >> 8 & 0xFF;
            byArray[n3++] = b[n4 >> 4];
            byArray[n3++] = b[n4 & 0xF];
            n2 &= 0xFF;
        } else {
            byArray[n3++] = 48;
            byArray[n3++] = 48;
        }
        byArray[n3++] = b[n2 >> 4];
        byArray[n3++] = b[n2 & 0xF];
        return n3;
    }

    protected final void i() {
        int n2 = this.var_int_d;
        if (n2 > 0) {
            this.var_int_d = 0;
            this.var_java_io_OutputStream_a.write(this.var_byte_arr_a, 0, n2);
        }
    }

    static {
        var_byte_arr_d = new byte[]{116, 114, 117, 101};
        var_byte_arr_e = new byte[]{102, 97, 108, 115, 101};
    }
}

