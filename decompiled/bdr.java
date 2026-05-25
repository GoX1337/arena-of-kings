/*
 * Decompiled with CFR 0.152.
 */
public abstract class bdr
extends bdd {
    protected transient bdc var_bdc_a;
    protected bfh var_bfh_a;

    public bdr(bdc bdc2, String string) {
        super(string, bdc2 == null ? null : bdc2.bda_b());
        this.var_bdc_a = bdc2;
    }

    public bdr(bdc bdc2, String string, Throwable throwable) {
        super(string, bdc2 == null ? null : bdc2.bda_b(), throwable);
        this.var_bdc_a = bdc2;
    }

    @Override
    public bdc bdc_a() {
        return this.var_bdc_a;
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (this.var_bfh_a != null) {
            string = string + "\nRequest payload : " + this.var_bfh_a.toString();
        }
        return string;
    }
}

