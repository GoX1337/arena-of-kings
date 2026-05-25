/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

@bgp
public final class bqx
extends brr<List<?>> {
    public bqx(bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        super(List.class, bfw2, bl2, bog2, bgb2);
    }

    public bqx(bqx bqx2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bqx2, bfp2, bog2, bgb2, bl2);
    }

    public bqx a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        return new bqx(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, List<?> list) {
        return list.isEmpty();
    }

    @Override
    public boolean a(List<?> list) {
        return list.size() == 1;
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bqx(this, this.a, bog2, this.a, this.a);
    }

    @Override
    public final void a(List<?> list, bcy bcy2, bgo bgo2) {
        int n2 = list.size();
        if (n2 == 1 && (this.a == null && bgo2.a(bgn.t) || this.a == Boolean.TRUE)) {
            this.b(list, bcy2, bgo2);
            return;
        }
        bcy2.a(list, n2);
        this.b(list, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(List<?> list, bcy bcy2, bgo bgo2) {
        int n2;
        if (this.a != null) {
            this.a(list, bcy2, bgo2, this.a);
            return;
        }
        if (this.a != null) {
            this.c(list, bcy2, bgo2);
            return;
        }
        int n3 = list.size();
        if (n3 == 0) {
            return;
        }
        try {
            bre bre2 = this.a;
            for (n2 = 0; n2 < n3; ++n2) {
                Object obj = list.get(n2);
                if (obj == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                Class<?> clazz = obj.getClass();
                bgb<Object> bgb2 = bre2.a(clazz);
                if (bgb2 == null) {
                    bgb2 = this.a.r() ? this.a(bre2, bgo2.a(this.a, clazz), bgo2) : this.a(bre2, clazz, bgo2);
                    bre2 = this.a;
                }
                bgb2.a(obj, bcy2, bgo2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, list, n2);
        }
    }

    public void a(List<?> list, bcy bcy2, bgo bgo2, bgb<Object> bgb2) {
        int n2 = list.size();
        if (n2 == 0) {
            return;
        }
        bog bog2 = this.a;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object obj = list.get(i2);
            try {
                if (obj == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                if (bog2 == null) {
                    bgb2.a(obj, bcy2, bgo2);
                    continue;
                }
                bgb2.a(obj, bcy2, bgo2, bog2);
                continue;
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, list, i2);
            }
        }
    }

    public void c(List<?> list, bcy bcy2, bgo bgo2) {
        int n2;
        int n3 = list.size();
        if (n3 == 0) {
            return;
        }
        try {
            bog bog2 = this.a;
            bre bre2 = this.a;
            for (n2 = 0; n2 < n3; ++n2) {
                Object obj = list.get(n2);
                if (obj == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                Class<?> clazz = obj.getClass();
                bgb<Object> bgb2 = bre2.a(clazz);
                if (bgb2 == null) {
                    bgb2 = this.a.r() ? this.a(bre2, bgo2.a(this.a, clazz), bgo2) : this.a(bre2, clazz, bgo2);
                    bre2 = this.a;
                }
                bgb2.a(obj, bcy2, bgo2, bog2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, list, n2);
        }
    }
}

