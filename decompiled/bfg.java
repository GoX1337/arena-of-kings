/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bfg
implements bdh,
Serializable {
    protected String a;
    protected bfi b;

    public bfg() {
        this(((bee)((Object)a)).toString());
    }

    public bfg(String string) {
        this.a = string;
        this.b = a;
    }

    @Override
    public void a(bcy bcy2) {
        if (this.a != null) {
            bcy2.c(this.a);
        }
    }

    @Override
    public void b(bcy bcy2) {
        bcy2.a('{');
    }

    @Override
    public void h(bcy bcy2) {
    }

    @Override
    public void d(bcy bcy2) {
        bcy2.a(this.b.char_a());
    }

    @Override
    public void c(bcy bcy2) {
        bcy2.a(this.b.b());
    }

    @Override
    public void a(bcy bcy2, int n2) {
        bcy2.a('}');
    }

    @Override
    public void e(bcy bcy2) {
        bcy2.a('[');
    }

    @Override
    public void g(bcy bcy2) {
    }

    @Override
    public void f(bcy bcy2) {
        bcy2.a(this.b.c());
    }

    @Override
    public void b(bcy bcy2, int n2) {
        bcy2.a(']');
    }
}

