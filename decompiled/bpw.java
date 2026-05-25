/*
 * Decompiled with CFR 0.152.
 */
public abstract class bpw
extends bpe {
    protected bpw() {
    }

    public abstract bdf bdf_a();

    @Override
    public void a(bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(this, this.bdf_a()));
        this.a(bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    @Override
    public final bfz a(String string) {
        return null;
    }
}

