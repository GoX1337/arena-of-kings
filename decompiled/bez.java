/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bez
implements bdh,
bfa<bez>,
Serializable {
    public static final bee var_bee_b;
    protected b var_bez$b_a = bez$a.a;
    protected b var_bez$b_b = bey.var_bey_a;
    protected final bdi var_bdi_a;
    protected boolean var_boolean_a = true;
    protected transient int var_int_a;
    protected bfi var_bfi_b;
    protected String var_java_lang_String_a;

    public bez() {
        this(var_bee_b);
    }

    public bez(bdi bdi2) {
        this.var_bdi_a = bdi2;
        this.a((bfi)((Object)var_bez$b_a));
    }

    public bez(bez bez2) {
        this(bez2, bez2.var_bdi_a);
    }

    public bez(bez bez2, bdi bdi2) {
        this.var_bez$b_a = bez2.var_bez$b_a;
        this.var_bez$b_b = bez2.var_bez$b_b;
        this.var_boolean_a = bez2.var_boolean_a;
        this.var_int_a = bez2.var_int_a;
        this.var_bfi_b = bez2.var_bfi_b;
        this.var_java_lang_String_a = bez2.var_java_lang_String_a;
        this.var_bdi_a = bdi2;
    }

    public bez a(bfi bfi2) {
        this.var_bfi_b = bfi2;
        this.var_java_lang_String_a = " " + bfi2.char_a() + " ";
        return this;
    }

    @Override
    public bez a() {
        if (this.getClass() != bez.class) {
            throw new IllegalStateException("Failed `createInstance()`: " + this.getClass().getName() + " does not override method; it has to");
        }
        return new bez(this);
    }

    @Override
    public void a(bcy bcy2) {
        if (this.var_bdi_a != null) {
            bcy2.c(this.var_bdi_a);
        }
    }

    @Override
    public void b(bcy bcy2) {
        bcy2.a('{');
        if (!this.var_bez$b_b.a()) {
            ++this.var_int_a;
        }
    }

    @Override
    public void h(bcy bcy2) {
        this.var_bez$b_b.a(bcy2, this.var_int_a);
    }

    @Override
    public void d(bcy bcy2) {
        if (this.var_boolean_a) {
            bcy2.c(this.var_java_lang_String_a);
        } else {
            bcy2.a(this.var_bfi_b.char_a());
        }
    }

    @Override
    public void c(bcy bcy2) {
        bcy2.a(this.var_bfi_b.b());
        this.var_bez$b_b.a(bcy2, this.var_int_a);
    }

    @Override
    public void a(bcy bcy2, int n2) {
        if (!this.var_bez$b_b.a()) {
            --this.var_int_a;
        }
        if (n2 > 0) {
            this.var_bez$b_b.a(bcy2, this.var_int_a);
        } else {
            bcy2.a(' ');
        }
        bcy2.a('}');
    }

    @Override
    public void e(bcy bcy2) {
        if (!this.var_bez$b_a.a()) {
            ++this.var_int_a;
        }
        bcy2.a('[');
    }

    @Override
    public void g(bcy bcy2) {
        this.var_bez$b_a.a(bcy2, this.var_int_a);
    }

    @Override
    public void f(bcy bcy2) {
        bcy2.a(this.var_bfi_b.c());
        this.var_bez$b_a.a(bcy2, this.var_int_a);
    }

    @Override
    public void b(bcy bcy2, int n2) {
        if (!this.var_bez$b_a.a()) {
            --this.var_int_a;
        }
        if (n2 > 0) {
            this.var_bez$b_a.a(bcy2, this.var_int_a);
        } else {
            bcy2.a(' ');
        }
        bcy2.a(']');
    }

    static {
        var_bee_b = new bee(" ");
    }

    public static class a
    extends c {
        public static final a a = new a();

        @Override
        public void a(bcy bcy2, int n2) {
            bcy2.a(' ');
        }

        @Override
        public boolean a() {
            return true;
        }
    }

    public static class c
    implements b,
    Serializable {
        public static final c a = new c();

        @Override
        public void a(bcy bcy2, int n2) {
        }

        @Override
        public boolean a() {
            return true;
        }
    }

    public static interface b {
        public void a(bcy var1, int var2);

        public boolean a();
    }
}

