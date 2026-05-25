/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

@bgp
public final class bqy
extends bsx<List<String>> {
    public static final bqy a = new bqy();

    protected bqy() {
        super(List.class);
    }

    public bqy(bqy bqy2, Boolean bl2) {
        super(bqy2, bl2);
    }

    @Override
    public bgb<?> a(bfp bfp2, Boolean bl2) {
        return new bqy(this, bl2);
    }

    @Override
    public void a(List<String> list, bcy bcy2, bgo bgo2) {
        int n2 = list.size();
        if (n2 == 1 && (this.a == null && bgo2.a(bgn.t) || this.a == Boolean.TRUE)) {
            this.a(list, bcy2, bgo2, 1);
            return;
        }
        bcy2.a(list, n2);
        this.a(list, bcy2, bgo2, n2);
        bcy2.void_b();
    }

    @Override
    public void a(List<String> list, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(list, bdf.var_bdf_d));
        bcy2.a(list);
        this.a(list, bcy2, bgo2, list.size());
        bog2.b(bcy2, beu2);
    }

    private final void a(List<String> list, bcy bcy2, bgo bgo2, int n2) {
        int n3;
        try {
            for (n3 = 0; n3 < n2; ++n3) {
                String string = list.get(n3);
                if (string == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                bcy2.b(string);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, list, n3);
        }
    }
}

