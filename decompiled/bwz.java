/*
 * Decompiled with CFR 0.152.
 */
public class bwz {
    private bxa var_bxa_a;
    private bxb var_bxb_a;
    private bxb var_bxb_b;
    private bwy var_bwy_a;
    private bwx var_bwx_a;
    private bww var_bww_a;
    private int var_int_a;
    private int var_int_b;
    private boolean var_boolean_a;

    public bxa a(bwu bwu2, bwp bwp2) {
        if (!this.var_boolean_a) {
            this.a(bwu2);
        }
        int n2 = bwu2.int_b();
        bwt bwt2 = this.a(bwu2, bwp2, n2);
        bwt2.void_a();
        return this.var_bxa_a;
    }

    public void a(bxa bxa2) {
        this.var_bxa_a = bxa2;
    }

    protected bws a(int n2, Throwable throwable) {
        return new bws(n2, throwable);
    }

    protected bwt a(bwu bwu2, bwp bwp2, int n2) {
        bwt bwt2 = null;
        switch (n2) {
            case 3: {
                if (this.var_bwy_a == null) {
                    this.var_bwy_a = new bwy(bwp2, bwu2, this.var_bxb_a, this.var_bxb_b, this.var_bxa_a, 0);
                }
                bwt2 = this.var_bwy_a;
                break;
            }
            case 2: {
                if (this.var_bwx_a == null) {
                    this.var_bwx_a = new bwx();
                    this.var_bwx_a.a(bwp2, bwu2, this.var_bxb_a, this.var_bxb_b, this.var_bxa_a, 0);
                }
                bwt2 = this.var_bwx_a;
                break;
            }
            case 1: {
                if (this.var_bww_a == null) {
                    this.var_bww_a = new bww();
                    this.var_bww_a.a(bwp2, bwu2, this.var_bxb_a, this.var_bxb_b, this.var_bxa_a, 0);
                }
                bwt2 = this.var_bww_a;
            }
        }
        if (bwt2 == null) {
            throw this.a(513, null);
        }
        return bwt2;
    }

    private void a(bwu bwu2) {
        int n2;
        float f2 = 32700.0f;
        int n3 = bwu2.f();
        bwu2.int_b();
        int n4 = n2 = n3 == 3 ? 1 : 2;
        if (this.var_bxa_a == null) {
            throw new RuntimeException("Output buffer was not set.");
        }
        this.var_bxb_a = new bxb(0, f2, null);
        if (n2 == 2) {
            this.var_bxb_b = new bxb(1, f2, null);
        }
        this.var_int_b = n2;
        this.var_int_a = bwu2.int_e();
        this.var_boolean_a = true;
    }
}

