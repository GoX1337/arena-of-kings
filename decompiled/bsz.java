/*
 * Decompiled with CFR 0.152.
 */
public class bsz
extends bte<Object>
implements bqh,
bqo {
    protected final bum<Object, ?> cfr_renamed_42;
    protected final bfw var_bfw_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;

    public bsz(bum<Object, ?> bum2, bfw bfw2, bgb<?> bgb2) {
        super(bfw2);
        this.cfr_renamed_42 = bum2;
        this.var_bfw_a = bfw2;
        this.cfr_renamed_42 = bgb2;
    }

    protected bsz a(bum<Object, ?> bum2, bfw bfw2, bgb<?> bgb2) {
        buk.a(bsz.class, this, "withDelegate");
        return new bsz(bum2, bfw2, bgb2);
    }

    @Override
    public void void_a(bgo bgo2) {
        if (this.cfr_renamed_42 != null && this.cfr_renamed_42 instanceof bqo) {
            ((bqo)((Object)this.cfr_renamed_42)).void_a(bgo2);
        }
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = this.cfr_renamed_42;
        bfw bfw2 = this.var_bfw_a;
        if (bgb2 == null) {
            if (bfw2 == null) {
                bfw2 = this.cfr_renamed_42.b(bgo2.btz_a());
            }
            if (!bfw2.p()) {
                bgb2 = bgo2.a(bfw2);
            }
        }
        if (bgb2 instanceof bqh) {
            bgb2 = bgo2.b(bgb2, bfp2);
        }
        if (bgb2 == this.cfr_renamed_42 && bfw2 == this.var_bfw_a) {
            return this;
        }
        return this.a(this.cfr_renamed_42, bfw2, bgb2);
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        Object object2 = this.a(object);
        if (object2 == null) {
            bgo2.a(bcy2);
            return;
        }
        bum<Object, ?> bum2 = this.cfr_renamed_42;
        if (bum2 == null) {
            bum2 = this.a(object2, bgo2);
        }
        ((bgb)((Object)bum2)).a(object2, bcy2, bgo2);
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        Object object2 = this.a(object);
        bum<Object, ?> bum2 = this.cfr_renamed_42;
        if (bum2 == null) {
            bum2 = this.a(object, bgo2);
        }
        ((bgb)((Object)bum2)).a(object2, bcy2, bgo2, bog2);
    }

    @Override
    public boolean a(bgo bgo2, Object object) {
        Object object2 = this.a(object);
        if (object2 == null) {
            return true;
        }
        if (this.cfr_renamed_42 == null) {
            return object == null;
        }
        return ((bgb)((Object)this.cfr_renamed_42)).a(bgo2, object2);
    }

    protected Object a(Object object) {
        return this.cfr_renamed_42.a(object);
    }

    protected bgb<Object> a(Object object, bgo bgo2) {
        return bgo2.a(object.getClass());
    }
}

