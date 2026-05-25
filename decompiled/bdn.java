/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.math.BigDecimal;

public abstract class bdn
extends bcy {
    protected static final int var_int_a;
    protected bdg var_bdg_a;
    protected int var_int_b;
    protected boolean var_boolean_a;
    protected bem var_bem_a;
    protected boolean var_boolean_b;

    protected bdn(int n2, bdg bdg2) {
        this.var_int_b = n2;
        this.var_bdg_a = bdg2;
        bei bei2 = bcy.a.i.a(n2) ? bei.a(this) : null;
        this.var_bem_a = bem.b(bei2);
        this.var_boolean_a = bcy.a.g.a(n2);
    }

    @Override
    public void a(Object object) {
        if (this.var_bem_a != null) {
            this.var_bem_a.void_a(object);
        }
    }

    @Override
    public final boolean boolean_a(bcy.a a2) {
        return (this.var_int_b & a2.b()) != 0;
    }

    @Override
    public int int_a() {
        return this.var_int_b;
    }

    @Override
    public bcy bcy_a(bcy.a a2) {
        int n2 = a2.b();
        this.var_int_b &= ~n2;
        if ((n2 & var_int_a) != 0) {
            if (a2 == bcy.a.g) {
                this.var_boolean_a = false;
            } else if (a2 == bcy.a.f) {
                this.bcy_b(0);
            } else if (a2 == bcy.a.i) {
                this.var_bem_a = this.var_bem_a.a((bei)null);
            }
        }
        return this;
    }

    @Override
    @Deprecated
    public bcy bcy_a(int n2) {
        int n3 = n2 ^ this.var_int_b;
        this.var_int_b = n2;
        if (n3 != 0) {
            this.void_a(n2, n3);
        }
        return this;
    }

    @Override
    public bcy bcy_a(int n2, int n3) {
        int n4 = this.var_int_b;
        int n5 = n4 & ~n3 | n2 & n3;
        int n6 = n4 ^ n5;
        if (n6 != 0) {
            this.var_int_b = n5;
            this.void_a(n5, n6);
        }
        return this;
    }

    protected void void_a(int n2, int n3) {
        if ((n3 & var_int_a) == 0) {
            return;
        }
        this.var_boolean_a = bcy.a.g.a(n2);
        if (bcy.a.f.a(n3)) {
            if (bcy.a.f.a(n2)) {
                this.bcy_b(127);
            } else {
                this.bcy_b(0);
            }
        }
        if (bcy.a.i.a(n3)) {
            if (bcy.a.i.a(n2)) {
                if (this.var_bem_a.java_lang_Object_a() == null) {
                    this.var_bem_a = this.var_bem_a.a(bei.a(this));
                }
            } else {
                this.var_bem_a = this.var_bem_a.a((bei)null);
            }
        }
    }

    @Override
    public bde bde_a() {
        return this.var_bem_a;
    }

    @Override
    public void c(Object object) {
        this.void_c();
        if (object != null) {
            this.a(object);
        }
    }

    @Override
    public void void_a(bdi bdi2) {
        this.a(bdi2.java_lang_String_a());
    }

    @Override
    public void b(bdi bdi2) {
        this.b(bdi2.java_lang_String_a());
    }

    @Override
    public void d(String string) {
        this.h("write raw value");
        this.c(string);
    }

    @Override
    public void d(bdi bdi2) {
        this.h("write raw value");
        this.c(bdi2);
    }

    @Override
    public int a(bcq bcq2, InputStream inputStream, int n2) {
        this.g();
        return 0;
    }

    @Override
    public void h(Object object) {
        if (object == null) {
            this.e();
        } else {
            if (this.var_bdg_a != null) {
                this.var_bdg_a.a(this, object);
                return;
            }
            this.i(object);
        }
    }

    @Override
    public void close() {
        this.var_boolean_b = true;
    }

    protected abstract void h();

    protected abstract void h(String var1);

    protected String java_lang_String_a(BigDecimal bigDecimal) {
        if (bcy.a.h.a(this.var_int_b)) {
            int n2 = bigDecimal.scale();
            if (n2 < -9999 || n2 > 9999) {
                this.g(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", n2, 9999, 9999));
            }
            return bigDecimal.toPlainString();
        }
        return bigDecimal.toString();
    }

    protected final int int_a(int n2, int n3) {
        if (n3 < 56320 || n3 > 57343) {
            String string = "Incomplete surrogate pair: first char 0x" + Integer.toHexString(n2) + ", second 0x" + Integer.toHexString(n3);
            this.g(string);
        }
        int n4 = 65536 + (n2 - 55296 << 10) + (n3 - 56320);
        return n4;
    }

    static {
        var_int_a = bcy.a.g.b() | bcy.a.f.b() | bcy.a.i.b();
    }
}

