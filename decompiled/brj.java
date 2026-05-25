/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;

@bgp
public class brj
extends bsx<Collection<String>> {
    public static final brj a = new brj();

    protected brj() {
        super(Collection.class);
    }

    protected brj(brj brj2, Boolean bl2) {
        super(brj2, bl2);
    }

    @Override
    public bgb<?> a(bfp bfp2, Boolean bl2) {
        return new brj(this, bl2);
    }

    @Override
    public void a(Collection<String> collection, bcy bcy2, bgo bgo2) {
        int n2 = collection.size();
        if (n2 == 1 && (this.a == null && bgo2.a(bgn.t) || this.a == Boolean.TRUE)) {
            this.b(collection, bcy2, bgo2);
            return;
        }
        bcy2.a(collection, n2);
        this.b(collection, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void a(Collection<String> collection, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(collection, bdf.var_bdf_d));
        bcy2.a(collection);
        this.b(collection, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    private final void b(Collection<String> collection, bcy bcy2, bgo bgo2) {
        int n2 = 0;
        try {
            for (String string : collection) {
                if (string == null) {
                    bgo2.a(bcy2);
                } else {
                    bcy2.b(string);
                }
                ++n2;
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, collection, n2);
        }
    }
}

