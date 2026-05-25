/*
 * Decompiled with CFR 0.152.
 */
public abstract class bej
extends bdn {
    protected static final int[] var_int_arr_a;
    protected static final bfd<bdk> d;
    protected final bdv var_bdv_a;
    protected int[] b = var_int_arr_a;
    protected int var_int_c;
    protected bdu var_bdu_a;
    protected bdi var_bdi_a = bez.var_bee_b;
    protected boolean var_boolean_c;

    public bej(bdv bdv2, int n2, bdg bdg2) {
        super(n2, bdg2);
        this.var_bdv_a = bdv2;
        if (bcy.a.f.a(n2)) {
            this.var_int_c = 127;
        }
        this.var_boolean_c = !bcy.a.d.a(n2);
    }

    @Override
    public bcy bcy_a(bcy.a a2) {
        super.bcy_a(a2);
        if (a2 == bcy.a.d) {
            this.var_boolean_c = true;
        }
        return this;
    }

    @Override
    protected void void_a(int n2, int n3) {
        super.void_a(n2, n3);
        this.var_boolean_c = !bcy.a.d.a(n2);
    }

    @Override
    public bcy bcy_b(int n2) {
        this.var_int_c = n2 < 0 ? 0 : n2;
        return this;
    }

    @Override
    public bcy a(bdu bdu2) {
        this.var_bdu_a = bdu2;
        this.b = bdu2 == null ? var_int_arr_a : bdu2.a();
        return this;
    }

    @Override
    public bcy bcy_a(bdi bdi2) {
        this.var_bdi_a = bdi2;
        return this;
    }

    protected void a(String string, int n2) {
        switch (n2) {
            case 1: {
                this.var_int_arr_a.f(this);
                break;
            }
            case 2: {
                this.var_int_arr_a.d(this);
                break;
            }
            case 3: {
                this.var_int_arr_a.a(this);
                break;
            }
            case 0: {
                if (this.var_int_arr_a.boolean_a()) {
                    this.var_int_arr_a.g(this);
                    break;
                }
                if (!this.var_int_arr_a.boolean_c()) break;
                this.var_int_arr_a.h(this);
                break;
            }
            case 5: {
                this.i(string);
                break;
            }
            default: {
                this.f();
            }
        }
    }

    protected void i(String string) {
        this.g(String.format("Can not %s, expecting field name (context: %s)", string, this.var_int_arr_a.java_lang_Object_a()));
    }

    static {
        var_int_arr_a = bdt.f();
        d = b;
    }
}

