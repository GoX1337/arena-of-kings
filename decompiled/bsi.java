/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

@bgp
public class bsi
extends brr<Iterable<?>> {
    public bsi(bfw bfw2, boolean bl2, bog bog2) {
        super(Iterable.class, bfw2, bl2, bog2, null);
    }

    public bsi(bsi bsi2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bsi2, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bsi(this, this.a, bog2, this.a, this.a);
    }

    public bsi a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        return new bsi(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, Iterable<?> iterable) {
        return !iterable.iterator().hasNext();
    }

    @Override
    public boolean a(Iterable<?> iterable) {
        Iterator<?> iterator;
        if (iterable != null && (iterator = iterable.iterator()).hasNext()) {
            iterator.next();
            if (!iterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void a(Iterable<?> iterable, bcy bcy2, bgo bgo2) {
        if ((this.a == null && bgo2.a(bgn.t) || this.a == Boolean.TRUE) && this.a(iterable)) {
            this.b(iterable, bcy2, bgo2);
            return;
        }
        bcy2.b(iterable);
        this.b(iterable, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(Iterable<?> iterable, bcy bcy2, bgo bgo2) {
        Iterator<?> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            bog bog2 = this.a;
            bgb<Object> bgb2 = null;
            Class<?> clazz = null;
            do {
                Object obj;
                if ((obj = iterator.next()) == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                bgb<Object> bgb3 = this.a;
                if (bgb3 == null) {
                    Class<?> clazz2 = obj.getClass();
                    if (clazz2 == clazz) {
                        bgb3 = bgb2;
                    } else {
                        bgb2 = bgb3 = bgo2.a(clazz2, this.a);
                        clazz = clazz2;
                    }
                }
                if (bog2 == null) {
                    bgb3.a(obj, bcy2, bgo2);
                    continue;
                }
                bgb3.a(obj, bcy2, bgo2, bog2);
            } while (iterator.hasNext());
        }
    }
}

