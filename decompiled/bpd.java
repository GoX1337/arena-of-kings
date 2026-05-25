/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bpd
extends bpi<bpd>
implements Serializable {
    private final List<bfz> a = new ArrayList<bfz>();

    public bpd(bpo bpo2) {
        super(bpo2);
    }

    @Override
    public boolean a(bgo bgo2) {
        return this.a.isEmpty();
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public Iterator<bfz> a() {
        return this.a.iterator();
    }

    @Override
    public bfz a(String string) {
        return null;
    }

    @Override
    public void a(bcy bcy2, bgo bgo2) {
        List<bfz> list = this.a;
        int n2 = list.size();
        bcy2.a(this, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            bfz bfz2 = list.get(i2);
            ((bpe)bfz2).a(bcy2, bgo2);
        }
        bcy2.void_b();
    }

    @Override
    public void a(bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(this, bdf.var_bdf_d));
        for (bfz bfz2 : this.a) {
            ((bpe)bfz2).a(bcy2, bgo2);
        }
        bog2.b(bcy2, beu2);
    }

    public bpd a(bfz bfz2) {
        if (bfz2 == null) {
            bfz2 = this.bpr_a();
        }
        this.b(bfz2);
        return this;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpd) {
            return this.a.equals(((bpd)object).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    protected bpd b(bfz bfz2) {
        this.a.add(bfz2);
        return this;
    }
}

