/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class bpt
extends bpi<bpt>
implements Serializable {
    protected final Map<String, bfz> a = new LinkedHashMap<String, bfz>();

    public bpt(bpo bpo2) {
        super(bpo2);
    }

    @Override
    public boolean a(bgo bgo2) {
        return this.a.isEmpty();
    }

    @Override
    public Iterator<bfz> a() {
        return this.a.values().iterator();
    }

    @Override
    public bfz a(String string) {
        return this.a.get(string);
    }

    @Override
    public void a(bcy bcy2, bgo bgo2) {
        boolean bl2 = bgo2 != null && !bgo2.a(bgn.s);
        bcy2.c(this);
        for (Map.Entry<String, bfz> entry : this.a.entrySet()) {
            bpe bpe2 = (bpe)entry.getValue();
            if (bl2 && bpe2.boolean_a() && bpe2.a(bgo2)) continue;
            bcy2.a(entry.getKey());
            bpe2.a(bcy2, bgo2);
        }
        bcy2.void_d();
    }

    @Override
    public void a(bcy bcy2, bgo bgo2, bog bog2) {
        boolean bl2 = bgo2 != null && !bgo2.a(bgn.s);
        beu beu2 = bog2.a(bcy2, bog2.a(this, bdf.var_bdf_b));
        for (Map.Entry<String, bfz> entry : this.a.entrySet()) {
            bpe bpe2 = (bpe)entry.getValue();
            if (bl2 && bpe2.boolean_a() && bpe2.a(bgo2)) continue;
            bcy2.a(entry.getKey());
            bpe2.a(bcy2, bgo2);
        }
        bog2.b(bcy2, beu2);
    }

    public <T extends bfz> T a(String string, bfz bfz2) {
        if (bfz2 == null) {
            bfz2 = this.bpr_a();
        }
        this.a.put(string, bfz2);
        return (T)this;
    }

    public bfz b(String string, bfz bfz2) {
        if (bfz2 == null) {
            bfz2 = this.bpr_a();
        }
        return this.a.put(string, bfz2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpt) {
            return this.a((bpt)object);
        }
        return false;
    }

    protected boolean a(bpt bpt2) {
        return this.a.equals(bpt2.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

