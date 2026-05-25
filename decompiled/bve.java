/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

public class bve
extends bcy {
    protected static final int var_int_a;
    protected bdg var_bdg_a;
    protected bde var_bde_a;
    protected int var_int_b;
    protected boolean var_boolean_a;
    protected boolean var_boolean_b;
    protected boolean var_boolean_c;
    protected boolean d;
    protected boolean e;
    protected b var_bve$b_a;
    protected b var_bve$b_b;
    protected int var_int_c;
    protected Object var_java_lang_Object_a;
    protected Object var_java_lang_Object_b;
    protected boolean f = false;
    protected bem var_bem_a;

    public bve(bdg bdg2, boolean bl2) {
        this.var_bdg_a = bdg2;
        this.var_int_b = var_int_a;
        this.var_bem_a = bem.b(null);
        this.var_bve$b_a = this.var_bve$b_b = new b();
        this.var_int_c = 0;
        this.var_boolean_b = bl2;
        this.var_boolean_c = bl2;
        this.d = this.var_boolean_b || this.var_boolean_c;
    }

    public bve(bdc bdc2) {
        this(bdc2, null);
    }

    public bve(bdc bdc2, bfs bfs2) {
        this.var_bdg_a = bdc2.bdg_a();
        this.var_bde_a = bdc2.bde_a();
        this.var_int_b = var_int_a;
        this.var_bem_a = bem.b(null);
        this.var_bve$b_a = this.var_bve$b_b = new b();
        this.var_int_c = 0;
        this.var_boolean_b = bdc2.boolean_i();
        this.var_boolean_c = bdc2.boolean_h();
        this.d = this.var_boolean_b || this.var_boolean_c;
        this.e = bfs2 == null ? false : bfs2.a(bfu.var_bfu_a);
    }

    public static bve bve_a(bdc bdc2) {
        bve bve2 = new bve(bdc2);
        bve2.b(bdc2);
        return bve2;
    }

    public bdc bdc_a() {
        return this.a(this.var_bdg_a);
    }

    public bdc bdc_b() {
        bdc bdc2 = this.a(this.var_bdg_a);
        bdc2.bdf_a();
        return bdc2;
    }

    public bdc a(bdg bdg2) {
        return new a(this.var_bve$b_a, bdg2, this.var_boolean_b, this.var_boolean_c, this.var_bde_a);
    }

    public bdc bdc_a(bdc bdc2) {
        a a2 = new a(this.var_bve$b_a, bdc2.bdg_a(), this.var_boolean_b, this.var_boolean_c, this.var_bde_a);
        a2.a(bdc2.bda_a());
        return a2;
    }

    public bdf bdf_a() {
        return this.var_bve$b_a.bdf_a(0);
    }

    public bve a(bve bve2) {
        if (!this.var_boolean_b) {
            this.var_boolean_b = bve2.boolean_b();
        }
        if (!this.var_boolean_c) {
            this.var_boolean_c = bve2.boolean_a();
        }
        this.d = this.var_boolean_b || this.var_boolean_c;
        bdc bdc2 = bve2.bdc_a();
        while (bdc2.bdf_a() != null) {
            this.b(bdc2);
        }
        return this;
    }

    public void a(bcy bcy2) {
        boolean bl2;
        b b2 = this.var_bve$b_a;
        int n2 = -1;
        boolean bl3 = this.d;
        boolean bl4 = bl2 = bl3 && b2.boolean_a();
        while (true) {
            Object object;
            bdf bdf2;
            if (++n2 >= 16) {
                n2 = 0;
                if ((b2 = b2.bve$b_a()) == null) break;
                boolean bl5 = bl2 = bl3 && b2.boolean_a();
            }
            if ((bdf2 = b2.bdf_a(n2)) == null) break;
            if (bl2) {
                object = b2.java_lang_Object_b(n2);
                if (object != null) {
                    bcy2.e(object);
                }
                if ((object = b2.c(n2)) != null) {
                    bcy2.g(object);
                }
            }
            switch (bdf2) {
                case var_bdf_b: {
                    bcy2.void_c();
                    break;
                }
                case var_bdf_c: {
                    bcy2.void_d();
                    break;
                }
                case var_bdf_d: {
                    bcy2.void_a();
                    break;
                }
                case var_bdf_e: {
                    bcy2.void_b();
                    break;
                }
                case f: {
                    object = b2.java_lang_Object_a(n2);
                    if (object instanceof bdi) {
                        bcy2.void_a((bdi)object);
                        break;
                    }
                    bcy2.a((String)object);
                    break;
                }
                case h: {
                    object = b2.java_lang_Object_a(n2);
                    if (object instanceof bdi) {
                        bcy2.b((bdi)object);
                        break;
                    }
                    bcy2.b((String)object);
                    break;
                }
                case i: {
                    object = b2.java_lang_Object_a(n2);
                    if (object instanceof Integer) {
                        bcy2.void_b((Integer)object);
                        break;
                    }
                    if (object instanceof BigInteger) {
                        bcy2.a((BigInteger)object);
                        break;
                    }
                    if (object instanceof Long) {
                        bcy2.b((Long)object);
                        break;
                    }
                    if (object instanceof Short) {
                        bcy2.a((Short)object);
                        break;
                    }
                    bcy2.void_b(((Number)object).intValue());
                    break;
                }
                case j: {
                    object = b2.java_lang_Object_a(n2);
                    if (object instanceof Double) {
                        bcy2.a((Double)object);
                        break;
                    }
                    if (object instanceof BigDecimal) {
                        bcy2.void_a((BigDecimal)object);
                        break;
                    }
                    if (object instanceof Float) {
                        bcy2.a(((Float)object).floatValue());
                        break;
                    }
                    if (object == null) {
                        bcy2.e();
                        break;
                    }
                    if (object instanceof String) {
                        bcy2.e((String)object);
                        break;
                    }
                    throw new bcx(String.format("Unrecognized value type for VALUE_NUMBER_FLOAT: %s, cannot serialize", object.getClass().getName()), bcy2);
                }
                case k: {
                    bcy2.a(true);
                    break;
                }
                case l: {
                    bcy2.a(false);
                    break;
                }
                case m: {
                    bcy2.e();
                    break;
                }
                case g: {
                    object = b2.java_lang_Object_a(n2);
                    if (object instanceof bva) {
                        ((bva)object).a(bcy2);
                        break;
                    }
                    if (object instanceof bga) {
                        bcy2.h(object);
                        break;
                    }
                    bcy2.d(object);
                    break;
                }
                default: {
                    throw new RuntimeException("Internal error: should never end up through this code path");
                }
            }
        }
    }

    public bve a(bdc bdc2, bfs bfs2) {
        bdf bdf2;
        if (!bdc2.boolean_a(bdf.f)) {
            this.b(bdc2);
            return this;
        }
        this.void_c();
        do {
            this.b(bdc2);
        } while ((bdf2 = bdc2.bdf_a()) == bdf.f);
        if (bdf2 != bdf.var_bdf_c) {
            bfs2.a(bve.class, bdf.var_bdf_c, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + (Object)((Object)bdf2), new Object[0]);
        }
        this.void_d();
        return this;
    }

    public String toString() {
        int n2 = 100;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[TokenBuffer: ");
        bdc bdc2 = this.bdc_a();
        int n3 = 0;
        boolean bl2 = this.var_boolean_b || this.var_boolean_c;
        while (true) {
            try {
                bdf bdf2 = bdc2.bdf_a();
                if (bdf2 == null) break;
                if (bl2) {
                    this.a(stringBuilder);
                }
                if (n3 < 100) {
                    if (n3 > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(bdf2.toString());
                    if (bdf2 == bdf.f) {
                        stringBuilder.append('(');
                        stringBuilder.append(bdc2.java_lang_String_d());
                        stringBuilder.append(')');
                    }
                }
            }
            catch (IOException iOException) {
                throw new IllegalStateException(iOException);
            }
            ++n3;
        }
        if (n3 >= 100) {
            stringBuilder.append(" ... (truncated ").append(n3 - 100).append(" entries)");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private final void a(StringBuilder stringBuilder) {
        Object object;
        Object object2 = this.var_bve$b_b.java_lang_Object_b(this.var_int_c - 1);
        if (object2 != null) {
            stringBuilder.append("[objectId=").append(String.valueOf(object2)).append(']');
        }
        if ((object = this.var_bve$b_b.c(this.var_int_c - 1)) != null) {
            stringBuilder.append("[typeId=").append(String.valueOf(object)).append(']');
        }
    }

    @Override
    public bcy bcy_a(bcy.a a2) {
        this.var_int_b &= ~a2.b();
        return this;
    }

    @Override
    public boolean boolean_a(bcy.a a2) {
        return (this.var_int_b & a2.b()) != 0;
    }

    @Override
    public int int_a() {
        return this.var_int_b;
    }

    @Override
    @Deprecated
    public bcy bcy_a(int n2) {
        this.var_int_b = n2;
        return this;
    }

    @Override
    public bcy bcy_a(int n2, int n3) {
        int n4 = this.int_a();
        this.var_int_b = n4 & ~n3 | n2 & n3;
        return this;
    }

    @Override
    public final bem bem_a() {
        return this.var_bem_a;
    }

    @Override
    public boolean boolean_c() {
        return true;
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
        this.var_boolean_a = true;
    }

    @Override
    public final void void_a() {
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_d);
        this.var_bem_a = this.var_bem_a.java_lang_Object_a();
    }

    @Override
    public void b(Object object) {
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_d);
        this.var_bem_a = this.var_bem_a.bem_a(object);
    }

    @Override
    public void a(Object object, int n2) {
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_d);
        this.var_bem_a = this.var_bem_a.bem_a(object);
    }

    @Override
    public final void void_b() {
        this.c(bdf.var_bdf_e);
        bem bem2 = this.var_bem_a.bem_c();
        if (bem2 != null) {
            this.var_bem_a = bem2;
        }
    }

    @Override
    public final void void_c() {
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_b);
        this.var_bem_a = this.var_bem_a.bem_b();
    }

    @Override
    public void c(Object object) {
        bem bem2;
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_b);
        this.var_bem_a = bem2 = this.var_bem_a.b(object);
    }

    @Override
    public void b(Object object, int n2) {
        bem bem2;
        this.var_bem_a.int_c();
        this.b(bdf.var_bdf_b);
        this.var_bem_a = bem2 = this.var_bem_a.b(object);
    }

    @Override
    public final void void_d() {
        this.c(bdf.var_bdf_c);
        bem bem2 = this.var_bem_a.bem_c();
        if (bem2 != null) {
            this.var_bem_a = bem2;
        }
    }

    @Override
    public final void a(String string) {
        this.var_bem_a.a(string);
        this.j(string);
    }

    @Override
    public void void_a(bdi bdi2) {
        this.var_bem_a.a(bdi2.java_lang_String_a());
        this.j(bdi2);
    }

    @Override
    public void b(String string) {
        if (string == null) {
            this.e();
        } else {
            this.a(bdf.h, (Object)string);
        }
    }

    @Override
    public void a(char[] cArray, int n2, int n3) {
        this.b(new String(cArray, n2, n3));
    }

    @Override
    public void b(bdi bdi2) {
        if (bdi2 == null) {
            this.e();
        } else {
            this.a(bdf.h, bdi2);
        }
    }

    @Override
    public void c(String string) {
        this.g();
    }

    @Override
    public void c(bdi bdi2) {
        this.g();
    }

    @Override
    public void b(char[] cArray, int n2, int n3) {
        this.g();
    }

    @Override
    public void a(char c2) {
        this.g();
    }

    @Override
    public void d(String string) {
        this.a(bdf.g, new bva(string));
    }

    @Override
    public void a(short s2) {
        this.a(bdf.i, (Object)s2);
    }

    @Override
    public void void_b(int n2) {
        this.a(bdf.i, (Object)n2);
    }

    @Override
    public void b(long l2) {
        this.a(bdf.i, l2);
    }

    @Override
    public void a(double d2) {
        this.a(bdf.j, d2);
    }

    @Override
    public void a(float f2) {
        this.a(bdf.j, Float.valueOf(f2));
    }

    @Override
    public void void_a(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            this.e();
        } else {
            this.a(bdf.j, bigDecimal);
        }
    }

    @Override
    public void a(BigInteger bigInteger) {
        if (bigInteger == null) {
            this.e();
        } else {
            this.a(bdf.i, bigInteger);
        }
    }

    @Override
    public void e(String string) {
        this.a(bdf.j, (Object)string);
    }

    @Override
    public void a(boolean bl2) {
        this.a(bl2 ? bdf.k : bdf.l);
    }

    @Override
    public void e() {
        this.a(bdf.m);
    }

    @Override
    public void h(Object object) {
        if (object == null) {
            this.e();
            return;
        }
        Class<?> clazz = object.getClass();
        if (clazz == byte[].class || object instanceof bva) {
            this.a(bdf.g, object);
            return;
        }
        if (this.var_bdg_a == null) {
            this.a(bdf.g, object);
        } else {
            this.var_bdg_a.a(this, object);
        }
    }

    @Override
    public void a(bcq bcq2, byte[] byArray, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        System.arraycopy(byArray, n2, byArray2, 0, n3);
        this.h(byArray2);
    }

    @Override
    public int a(bcq bcq2, InputStream inputStream, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    @Override
    public boolean boolean_a() {
        return this.var_boolean_c;
    }

    @Override
    public void g(Object object) {
        this.var_java_lang_Object_a = object;
        this.f = true;
    }

    @Override
    public void e(Object object) {
        this.var_java_lang_Object_b = object;
        this.f = true;
    }

    @Override
    public void d(Object object) {
        this.a(bdf.g, object);
    }

    @Override
    public void void_a(bdc bdc2) {
        if (this.d) {
            this.e(bdc2);
        }
        block0 : switch (bdc2.bdf_c()) {
            case var_bdf_b: {
                this.void_c();
                break;
            }
            case var_bdf_c: {
                this.void_d();
                break;
            }
            case var_bdf_d: {
                this.void_a();
                break;
            }
            case var_bdf_e: {
                this.void_b();
                break;
            }
            case f: {
                this.a(bdc2.java_lang_String_d());
                break;
            }
            case h: {
                if (bdc2.boolean_g()) {
                    this.a(bdc2.char_arr_a(), bdc2.int_d(), bdc2.int_c());
                    break;
                }
                this.b(bdc2.java_lang_String_e());
                break;
            }
            case i: {
                switch (bdc2.bdc$b_a()) {
                    case var_bdc$b_a: {
                        this.void_b(bdc2.int_e());
                        break block0;
                    }
                    case c: {
                        this.a((BigInteger)bdc2.java_lang_Number_a());
                        break block0;
                    }
                }
                this.b(bdc2.long_a());
                break;
            }
            case j: {
                if (this.e) {
                    this.void_a((BigDecimal)bdc2.java_lang_Number_a());
                    break;
                }
                switch (bdc2.bdc$b_a()) {
                    case f: {
                        this.void_a((BigDecimal)bdc2.java_lang_Number_a());
                        break block0;
                    }
                    case d: {
                        this.a(bdc2.float_a());
                        break block0;
                    }
                }
                this.a(bdc2.double_a());
                break;
            }
            case k: {
                this.a(true);
                break;
            }
            case l: {
                this.a(false);
                break;
            }
            case m: {
                this.e();
                break;
            }
            case g: {
                this.h(bdc2.java_lang_Object_a());
                break;
            }
            default: {
                throw new RuntimeException("Internal error: unexpected token: " + (Object)((Object)bdc2.bdf_c()));
            }
        }
    }

    @Override
    public void b(bdc bdc2) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.f) {
            if (this.d) {
                this.e(bdc2);
            }
            this.a(bdc2.java_lang_String_d());
            bdf2 = bdc2.bdf_a();
        } else if (bdf2 == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        switch (bdf2) {
            case var_bdf_d: {
                if (this.d) {
                    this.e(bdc2);
                }
                this.void_a();
                this.d(bdc2);
                break;
            }
            case var_bdf_b: {
                if (this.d) {
                    this.e(bdc2);
                }
                this.void_c();
                this.d(bdc2);
                break;
            }
            case var_bdf_e: {
                this.void_b();
                break;
            }
            case var_bdf_c: {
                this.void_d();
                break;
            }
            default: {
                this.a(bdc2, bdf2);
            }
        }
    }

    protected void d(bdc bdc2) {
        bdf bdf2;
        int n2 = 1;
        block7: while ((bdf2 = bdc2.bdf_a()) != null) {
            switch (bdf2) {
                case f: {
                    if (this.d) {
                        this.e(bdc2);
                    }
                    this.a(bdc2.java_lang_String_d());
                    continue block7;
                }
                case var_bdf_d: {
                    if (this.d) {
                        this.e(bdc2);
                    }
                    this.void_a();
                    ++n2;
                    continue block7;
                }
                case var_bdf_b: {
                    if (this.d) {
                        this.e(bdc2);
                    }
                    this.void_c();
                    ++n2;
                    continue block7;
                }
                case var_bdf_e: {
                    this.void_b();
                    if (--n2 != 0) continue block7;
                    return;
                }
                case var_bdf_c: {
                    this.void_d();
                    if (--n2 != 0) continue block7;
                    return;
                }
            }
            this.a(bdc2, bdf2);
        }
    }

    private void a(bdc bdc2, bdf bdf2) {
        if (this.d) {
            this.e(bdc2);
        }
        block0 : switch (bdf2) {
            case h: {
                if (bdc2.boolean_g()) {
                    this.a(bdc2.char_arr_a(), bdc2.int_d(), bdc2.int_c());
                    break;
                }
                this.b(bdc2.java_lang_String_e());
                break;
            }
            case i: {
                switch (bdc2.bdc$b_a()) {
                    case var_bdc$b_a: {
                        this.void_b(bdc2.int_e());
                        break block0;
                    }
                    case c: {
                        this.a((BigInteger)bdc2.java_lang_Number_a());
                        break block0;
                    }
                }
                this.b(bdc2.long_a());
                break;
            }
            case j: {
                if (this.e) {
                    this.void_a((BigDecimal)bdc2.java_lang_Number_a());
                    break;
                }
                Number number = bdc2.java_lang_Number_b();
                this.a(bdf.j, number);
                break;
            }
            case k: {
                this.a(true);
                break;
            }
            case l: {
                this.a(false);
                break;
            }
            case m: {
                this.e();
                break;
            }
            case g: {
                this.h(bdc2.java_lang_Object_a());
                break;
            }
            default: {
                throw new RuntimeException("Internal error: unexpected token: " + (Object)((Object)bdf2));
            }
        }
    }

    private final void e(bdc bdc2) {
        this.var_java_lang_Object_a = bdc2.java_lang_Object_c();
        if (this.var_java_lang_Object_a != null) {
            this.f = true;
        }
        if ((this.var_java_lang_Object_b = bdc2.java_lang_Object_b()) != null) {
            this.f = true;
        }
    }

    protected final void a(bdf bdf2) {
        this.var_bem_a.int_c();
        b b2 = this.f ? this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2, this.var_java_lang_Object_b, this.var_java_lang_Object_a) : this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2);
        if (b2 == null) {
            ++this.var_int_c;
        } else {
            this.var_bve$b_b = b2;
            this.var_int_c = 1;
        }
    }

    protected final void a(bdf bdf2, Object object) {
        this.var_bem_a.int_c();
        b b2 = this.f ? this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2, object, this.var_java_lang_Object_b, this.var_java_lang_Object_a) : this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2, object);
        if (b2 == null) {
            ++this.var_int_c;
        } else {
            this.var_bve$b_b = b2;
            this.var_int_c = 1;
        }
    }

    protected final void j(Object object) {
        b b2 = this.f ? this.var_bve$b_b.bve$b_a(this.var_int_c, bdf.f, object, this.var_java_lang_Object_b, this.var_java_lang_Object_a) : this.var_bve$b_b.bve$b_a(this.var_int_c, bdf.f, object);
        if (b2 == null) {
            ++this.var_int_c;
        } else {
            this.var_bve$b_b = b2;
            this.var_int_c = 1;
        }
    }

    protected final void b(bdf bdf2) {
        b b2 = this.f ? this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2, this.var_java_lang_Object_b, this.var_java_lang_Object_a) : this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2);
        if (b2 == null) {
            ++this.var_int_c;
        } else {
            this.var_bve$b_b = b2;
            this.var_int_c = 1;
        }
    }

    protected final void c(bdf bdf2) {
        b b2 = this.var_bve$b_b.bve$b_a(this.var_int_c, bdf2);
        if (b2 == null) {
            ++this.var_int_c;
        } else {
            this.var_bve$b_b = b2;
            this.var_int_c = 1;
        }
    }

    @Override
    protected void g() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    static {
        var_int_a = bcy.a.int_a();
    }

    protected static final class b {
        private static final bdf[] var_bdf_arr_a;
        protected b var_bve$b_a;
        protected long var_long_a;
        protected final Object[] var_java_lang_Object_arr_a = new Object[16];
        protected TreeMap<Integer, Object> cfr_renamed_46;

        public bdf bdf_a(int n2) {
            long l2 = this.var_long_a;
            if (n2 > 0) {
                l2 >>= n2 << 2;
            }
            int n3 = (int)l2 & 0xF;
            return var_bdf_arr_a[n3];
        }

        public Object java_lang_Object_a(int n2) {
            return this.var_java_lang_Object_arr_a[n2];
        }

        public b bve$b_a() {
            return this.var_bve$b_a;
        }

        public boolean boolean_a() {
            return this.var_bdf_arr_a != null;
        }

        public b bve$b_a(int n2, bdf bdf2) {
            if (n2 < 16) {
                this.void_a(n2, bdf2);
                return null;
            }
            this.var_bve$b_a = new b();
            this.var_bve$b_a.void_a(0, bdf2);
            return this.var_bve$b_a;
        }

        public b bve$b_a(int n2, bdf bdf2, Object object, Object object2) {
            if (n2 < 16) {
                this.void_a(n2, bdf2, object, object2);
                return null;
            }
            this.var_bve$b_a = new b();
            this.var_bve$b_a.void_a(0, bdf2, object, object2);
            return this.var_bve$b_a;
        }

        public b bve$b_a(int n2, bdf bdf2, Object object) {
            if (n2 < 16) {
                this.void_a(n2, bdf2, object);
                return null;
            }
            this.var_bve$b_a = new b();
            this.var_bve$b_a.void_a(0, bdf2, object);
            return this.var_bve$b_a;
        }

        public b bve$b_a(int n2, bdf bdf2, Object object, Object object2, Object object3) {
            if (n2 < 16) {
                this.void_a(n2, bdf2, object, object2, object3);
                return null;
            }
            this.var_bve$b_a = new b();
            this.var_bve$b_a.void_a(0, bdf2, object, object2, object3);
            return this.var_bve$b_a;
        }

        private void void_a(int n2, bdf bdf2) {
            long l2 = bdf2.ordinal();
            if (n2 > 0) {
                l2 <<= n2 << 2;
            }
            this.var_long_a |= l2;
        }

        private void void_a(int n2, bdf bdf2, Object object, Object object2) {
            long l2 = bdf2.ordinal();
            if (n2 > 0) {
                l2 <<= n2 << 2;
            }
            this.var_long_a |= l2;
            this.a(n2, object, object2);
        }

        private void void_a(int n2, bdf bdf2, Object object) {
            this.var_java_lang_Object_arr_a[n2] = object;
            long l2 = bdf2.ordinal();
            if (n2 > 0) {
                l2 <<= n2 << 2;
            }
            this.var_long_a |= l2;
        }

        private void void_a(int n2, bdf bdf2, Object object, Object object2, Object object3) {
            this.var_java_lang_Object_arr_a[n2] = object;
            long l2 = bdf2.ordinal();
            if (n2 > 0) {
                l2 <<= n2 << 2;
            }
            this.var_long_a |= l2;
            this.a(n2, object2, object3);
        }

        private final void a(int n2, Object object, Object object2) {
            if (this.var_bdf_arr_a == null) {
                this.var_bdf_arr_a = new TreeMap();
            }
            if (object != null) {
                this.var_bdf_arr_a.put(this.int_b(n2), object);
            }
            if (object2 != null) {
                this.var_bdf_arr_a.put(this.int_a(n2), object2);
            }
        }

        Object java_lang_Object_b(int n2) {
            return this.var_bdf_arr_a == null ? null : this.var_bdf_arr_a.get(this.int_b(n2));
        }

        Object c(int n2) {
            return this.var_bdf_arr_a == null ? null : this.var_bdf_arr_a.get(this.int_a(n2));
        }

        private final int int_a(int n2) {
            return n2 + n2;
        }

        private final int int_b(int n2) {
            return n2 + n2 + 1;
        }

        static {
            var_bdf_arr_a = new bdf[16];
            bdf[] bdfArray = bdf.values();
            System.arraycopy(bdfArray, 1, var_bdf_arr_a, 1, Math.min(15, bdfArray.length - 1));
        }
    }

    protected static final class a
    extends bdp {
        protected bdg var_bdg_a;
        protected final boolean var_boolean_a;
        protected final boolean var_boolean_b;
        protected final boolean c;
        protected b var_bve$b_a;
        protected int var_int_b;
        protected bvg var_bvg_a;
        protected boolean d;
        protected transient bex var_bex_a;
        protected bda var_bda_a = null;

        public a(b b2, bdg bdg2, boolean bl2, boolean bl3, bde bde2) {
            super(0);
            this.var_bve$b_a = b2;
            this.var_int_b = -1;
            this.var_bdg_a = bdg2;
            this.var_bvg_a = bvg.a(bde2);
            this.var_boolean_a = bl2;
            this.var_boolean_b = bl3;
            this.c = bl2 || bl3;
        }

        public void a(bda bda2) {
            this.var_bda_a = bda2;
        }

        @Override
        public bdg bdg_a() {
            return this.var_bdg_a;
        }

        @Override
        public bfd<bdj> a() {
            return var_bdg_a;
        }

        @Override
        public void close() {
            if (!this.d) {
                this.d = true;
            }
        }

        @Override
        public bdf bdf_a() {
            if (this.d || this.var_bve$b_a == null) {
                return null;
            }
            if (++this.var_int_b >= 16) {
                this.var_int_b = 0;
                this.var_bve$b_a = this.var_bve$b_a.bve$b_a();
                if (this.var_bve$b_a == null) {
                    return null;
                }
            }
            this.var_boolean_b = this.var_bve$b_a.bdf_a(this.var_int_b);
            if (this.var_boolean_b == bdf.f) {
                Object object = this.java_lang_Object_d();
                String string = object instanceof String ? (String)object : object.toString();
                this.var_bvg_a.a(string);
            } else if (this.var_boolean_b == bdf.var_bdf_b) {
                this.var_bvg_a = this.var_bvg_a.bvg_b();
            } else if (this.var_boolean_b == bdf.var_bdf_d) {
                this.var_bvg_a = this.var_bvg_a.java_lang_Object_a();
            } else if (this.var_boolean_b == bdf.var_bdf_c || this.var_boolean_b == bdf.var_bdf_e) {
                this.var_bvg_a = this.var_bvg_a.bvg_c();
            } else {
                this.var_bvg_a.void_a();
            }
            return this.var_boolean_b;
        }

        @Override
        public String java_lang_String_a() {
            if (this.d || this.var_bve$b_a == null) {
                return null;
            }
            int n2 = this.var_int_b + 1;
            if (n2 < 16 && this.var_bve$b_a.bdf_a(n2) == bdf.f) {
                this.var_int_b = n2;
                this.var_boolean_b = bdf.f;
                Object object = this.var_bve$b_a.java_lang_Object_a(n2);
                String string = object instanceof String ? (String)object : object.toString();
                this.var_bvg_a.a(string);
                return string;
            }
            return this.bdf_a() == bdf.f ? this.java_lang_String_d() : null;
        }

        @Override
        public bde bde_a() {
            return this.var_bvg_a;
        }

        @Override
        public bda bda_a() {
            return this.bda_b();
        }

        @Override
        public bda bda_b() {
            return this.var_bda_a == null ? bda.var_bda_a : this.var_bda_a;
        }

        @Override
        public String java_lang_String_d() {
            if (this.var_boolean_b == bdf.var_bdf_b || this.var_boolean_b == bdf.var_bdf_d) {
                Object object = this.var_bvg_a.java_lang_Object_a();
                return ((bde)object).java_lang_String_b();
            }
            return this.var_bvg_a.java_lang_String_b();
        }

        @Override
        public String java_lang_String_c() {
            return this.java_lang_String_d();
        }

        @Override
        public String java_lang_String_e() {
            if (this.var_boolean_b == bdf.h || this.var_boolean_b == bdf.f) {
                Object object = this.java_lang_Object_d();
                if (object instanceof String) {
                    return (String)object;
                }
                return buk.java_lang_String_a(object);
            }
            if (this.var_boolean_b == null) {
                return null;
            }
            switch (bvf.a[this.var_boolean_b.ordinal()]) {
                case 7: 
                case 8: {
                    return buk.java_lang_String_a(this.java_lang_Object_d());
                }
            }
            return this.var_boolean_b.java_lang_String_a();
        }

        @Override
        public char[] char_arr_a() {
            String string = this.java_lang_String_e();
            return string == null ? null : string.toCharArray();
        }

        @Override
        public int int_c() {
            String string = this.java_lang_String_e();
            return string == null ? 0 : string.length();
        }

        @Override
        public int int_d() {
            return 0;
        }

        @Override
        public boolean boolean_g() {
            return false;
        }

        @Override
        public boolean boolean_f() {
            if (this.var_boolean_b == bdf.j) {
                Object object = this.java_lang_Object_d();
                if (object instanceof Double) {
                    Double d2 = (Double)object;
                    return d2.isNaN() || d2.isInfinite();
                }
                if (object instanceof Float) {
                    Float f2 = (Float)object;
                    return f2.isNaN() || f2.isInfinite();
                }
            }
            return false;
        }

        @Override
        public BigInteger java_math_BigInteger_a() {
            Number number = this.java_lang_Number_a();
            if (number instanceof BigInteger) {
                return (BigInteger)number;
            }
            if (this.bdc$b_a() == bdc.b.f) {
                return ((BigDecimal)number).toBigInteger();
            }
            return BigInteger.valueOf(number.longValue());
        }

        @Override
        public BigDecimal java_math_BigDecimal_a() {
            Number number = this.java_lang_Number_a();
            if (number instanceof BigDecimal) {
                return (BigDecimal)number;
            }
            switch (this.bdc$b_a()) {
                case var_bdc$b_a: 
                case b: {
                    return BigDecimal.valueOf(number.longValue());
                }
                case c: {
                    return new BigDecimal((BigInteger)number);
                }
            }
            return BigDecimal.valueOf(number.doubleValue());
        }

        @Override
        public double double_a() {
            return this.java_lang_Number_a().doubleValue();
        }

        @Override
        public float float_a() {
            return this.java_lang_Number_a().floatValue();
        }

        @Override
        public int int_e() {
            Number number;
            Number number2 = number = this.var_boolean_b == bdf.i ? (Number)((Number)this.java_lang_Object_d()) : (Number)this.java_lang_Number_a();
            if (number instanceof Integer || this.boolean_a(number)) {
                return number.intValue();
            }
            return this.int_a(number);
        }

        @Override
        public long long_a() {
            Number number;
            Number number2 = number = this.var_boolean_b == bdf.i ? (Number)((Number)this.java_lang_Object_d()) : (Number)this.java_lang_Number_a();
            if (number instanceof Long || this.b(number)) {
                return number.longValue();
            }
            return this.long_a(number);
        }

        @Override
        public bdc.b bdc$b_a() {
            Number number = this.java_lang_Number_a();
            if (number instanceof Integer) {
                return bdc.b.var_bdc$b_a;
            }
            if (number instanceof Long) {
                return bdc.b.b;
            }
            if (number instanceof Double) {
                return bdc.b.e;
            }
            if (number instanceof BigDecimal) {
                return bdc.b.f;
            }
            if (number instanceof BigInteger) {
                return bdc.b.c;
            }
            if (number instanceof Float) {
                return bdc.b.d;
            }
            if (number instanceof Short) {
                return bdc.b.var_bdc$b_a;
            }
            return null;
        }

        @Override
        public final Number java_lang_Number_a() {
            this.void_c();
            Object object = this.java_lang_Object_d();
            if (object instanceof Number) {
                return (Number)object;
            }
            if (object instanceof String) {
                String string = (String)object;
                if (string.indexOf(46) >= 0) {
                    return Double.parseDouble(string);
                }
                return Long.parseLong(string);
            }
            if (object == null) {
                return null;
            }
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + object.getClass().getName());
        }

        private final boolean boolean_a(Number number) {
            return number instanceof Short || number instanceof Byte;
        }

        private final boolean b(Number number) {
            return number instanceof Integer || number instanceof Short || number instanceof Byte;
        }

        protected int int_a(Number number) {
            if (number instanceof Long) {
                long l2 = number.longValue();
                int n2 = (int)l2;
                if ((long)n2 != l2) {
                    this.void_l();
                }
                return n2;
            }
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger)number;
                if (var_boolean_b.compareTo(bigInteger) > 0 || c.compareTo(bigInteger) < 0) {
                    this.void_l();
                }
            } else {
                if (number instanceof Double || number instanceof Float) {
                    double d2 = number.doubleValue();
                    if (d2 < -2.147483648E9 || d2 > 2.147483647E9) {
                        this.void_l();
                    }
                    return (int)d2;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal)number;
                    if (d.compareTo(bigDecimal) > 0 || e.compareTo(bigDecimal) < 0) {
                        this.void_l();
                    }
                } else {
                    this.void_o();
                }
            }
            return number.intValue();
        }

        protected long long_a(Number number) {
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger)number;
                if (d.compareTo(bigInteger) > 0 || e.compareTo(bigInteger) < 0) {
                    this.void_m();
                }
            } else {
                if (number instanceof Double || number instanceof Float) {
                    double d2 = number.doubleValue();
                    if (d2 < -9.223372036854776E18 || d2 > 9.223372036854776E18) {
                        this.void_m();
                    }
                    return (long)d2;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal)number;
                    if (var_boolean_b.compareTo(bigDecimal) > 0 || c.compareTo(bigDecimal) < 0) {
                        this.void_m();
                    }
                } else {
                    this.void_o();
                }
            }
            return number.longValue();
        }

        @Override
        public Object java_lang_Object_a() {
            if (this.var_boolean_b == bdf.g) {
                return this.java_lang_Object_d();
            }
            return null;
        }

        @Override
        public byte[] byte_arr_a(bcq bcq2) {
            Object object;
            if (this.var_boolean_b == bdf.g && (object = this.java_lang_Object_d()) instanceof byte[]) {
                return (byte[])object;
            }
            if (this.var_boolean_b != bdf.h) {
                throw this.bdb_a("Current token (" + this.var_boolean_b + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
            }
            object = this.java_lang_String_e();
            if (object == null) {
                return null;
            }
            bex bex2 = this.var_bex_a;
            if (bex2 == null) {
                this.var_bex_a = bex2 = new bex(100);
            } else {
                this.var_bex_a.void_a();
            }
            this.a((String)object, bex2, bcq2);
            return bex2.byte_arr_a();
        }

        @Override
        public int a(bcq bcq2, OutputStream outputStream) {
            byte[] byArray = this.byte_arr_a(bcq2);
            if (byArray != null) {
                outputStream.write(byArray, 0, byArray.length);
                return byArray.length;
            }
            return 0;
        }

        @Override
        public boolean boolean_h() {
            return this.var_boolean_b;
        }

        @Override
        public boolean boolean_i() {
            return this.var_boolean_a;
        }

        @Override
        public Object java_lang_Object_c() {
            return this.var_bve$b_a.c(this.var_int_b);
        }

        @Override
        public Object java_lang_Object_b() {
            return this.var_bve$b_a.java_lang_Object_b(this.var_int_b);
        }

        protected final Object java_lang_Object_d() {
            return this.var_bve$b_a.java_lang_Object_a(this.var_int_b);
        }

        protected final void void_c() {
            if (this.var_boolean_b == null || !this.var_boolean_b.boolean_a()) {
                throw this.bdb_a("Current token (" + this.var_boolean_b + ") not numeric, cannot use numeric value accessors");
            }
        }

        @Override
        protected void void_e() {
            this.void_o();
        }
    }
}

