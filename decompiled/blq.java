/*
 * Decompiled with CFR 0.152.
 */
public class blq
extends bfy {
    protected final bfw var_bfw_a;
    protected transient bfo var_bfo_a;
    protected transient bmx var_bmx_a;

    protected blq(bdc bdc2, String string, bfw bfw2) {
        super(bdc2, string);
        this.var_bfw_a = bfw2;
        this.var_bfo_a = null;
        this.var_bmx_a = null;
    }

    protected blq(bcy bcy2, String string, bfw bfw2) {
        super(bcy2, string);
        this.var_bfw_a = bfw2;
        this.var_bfo_a = null;
        this.var_bmx_a = null;
    }

    protected blq(bdc bdc2, String string, bfo bfo2, bmx bmx2) {
        super(bdc2, string);
        this.var_bfw_a = bfo2 == null ? null : bfo2.bfw_a();
        this.var_bfo_a = bfo2;
        this.var_bmx_a = bmx2;
    }

    protected blq(bcy bcy2, String string, bfo bfo2, bmx bmx2) {
        super(bcy2, string);
        this.var_bfw_a = bfo2 == null ? null : bfo2.bfw_a();
        this.var_bfo_a = bfo2;
        this.var_bmx_a = bmx2;
    }

    public static blq a(bdc bdc2, String string, bfo bfo2, bmx bmx2) {
        return new blq(bdc2, string, bfo2, bmx2);
    }

    public static blq a(bdc bdc2, String string, bfw bfw2) {
        return new blq(bdc2, string, bfw2);
    }

    public static blq a(bcy bcy2, String string, bfo bfo2, bmx bmx2) {
        return new blq(bcy2, string, bfo2, bmx2);
    }

    public static blq a(bcy bcy2, String string, bfw bfw2) {
        return new blq(bcy2, string, bfw2);
    }
}

