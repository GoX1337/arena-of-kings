/*
 * Decompiled with CFR 0.152.
 */
public class bqt
extends bqs {
    protected final String a;

    protected bqt(String string, bmx bmx2, bud bud2, bfw bfw2) {
        this(string, bmx2, bud2, bfw2, bmx2.bbr$b_a());
    }

    protected bqt(String string, bmx bmx2, bud bud2, bfw bfw2, bbr.b b2) {
        super(bmx2, bud2, bfw2, null, null, null, b2, null);
        this.a = string;
    }

    public static bqt a(String string, bmx bmx2, bud bud2, bfw bfw2) {
        return new bqt(string, bmx2, bud2, bfw2);
    }

    @Override
    public bqs a(bhm<?> bhm2, bmh bmh2, bmx bmx2, bfw bfw2) {
        throw new IllegalStateException("Should not be called on this type");
    }

    @Override
    protected Object java_lang_Object_a(Object object, bcy bcy2, bgo bgo2) {
        return bgo2.java_lang_Object_a((Object)this.a);
    }
}

