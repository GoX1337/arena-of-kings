/*
 * Decompiled with CFR 0.152.
 */
@bgp
public class brw
extends bte<byte[]> {
    public brw() {
        super(byte[].class);
    }

    @Override
    public boolean a(bgo bgo2, byte[] byArray) {
        return byArray.length == 0;
    }

    @Override
    public void a(byte[] byArray, bcy bcy2, bgo bgo2) {
        bcy2.a(bgo2.bgm_a().bcq_a(), byArray, 0, byArray.length);
    }

    @Override
    public void a(byte[] byArray, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(byArray, bdf.g));
        bcy2.a(bgo2.bgm_a().bcq_a(), byArray, 0, byArray.length);
        bog2.b(bcy2, beu2);
    }
}

