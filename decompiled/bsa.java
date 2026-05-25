/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Iterator;

public class bsa
extends brr<Collection<?>> {
    public bsa(bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        super(Collection.class, bfw2, bl2, bog2, bgb2);
    }

    public bsa(bsa bsa2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bsa2, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bsa(this, this.a, bog2, this.a, this.a);
    }

    public bsa a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        return new bsa(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override
    public boolean a(Collection<?> collection) {
        return collection.size() == 1;
    }

    @Override
    public final void a(Collection<?> collection, bcy bcy2, bgo bgo2) {
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
    public void b(Collection<?> collection, bcy bcy2, bgo bgo2) {
        bcy2.a(collection);
        if (this.a != null) {
            this.a(collection, bcy2, bgo2, this.a);
            return;
        }
        Iterator<?> iterator = collection.iterator();
        if (!iterator.hasNext()) {
            return;
        }
        bre bre2 = this.a;
        bog bog2 = this.a;
        int n2 = 0;
        try {
            do {
                Object obj;
                if ((obj = iterator.next()) == null) {
                    bgo2.a(bcy2);
                } else {
                    Class<?> clazz = obj.getClass();
                    bgb<Object> bgb2 = bre2.a(clazz);
                    if (bgb2 == null) {
                        bgb2 = this.a.r() ? this.a(bre2, bgo2.a(this.a, clazz), bgo2) : this.a(bre2, clazz, bgo2);
                        bre2 = this.a;
                    }
                    if (bog2 == null) {
                        bgb2.a(obj, bcy2, bgo2);
                    } else {
                        bgb2.a(obj, bcy2, bgo2, bog2);
                    }
                }
                ++n2;
            } while (iterator.hasNext());
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, collection, n2);
        }
    }

    public void a(Collection<?> collection, bcy bcy2, bgo bgo2, bgb<Object> bgb2) {
        Iterator<?> iterator = collection.iterator();
        if (iterator.hasNext()) {
            bog bog2 = this.a;
            int n2 = 0;
            do {
                Object obj = iterator.next();
                try {
                    if (obj == null) {
                        bgo2.a(bcy2);
                    } else if (bog2 == null) {
                        bgb2.a(obj, bcy2, bgo2);
                    } else {
                        bgb2.a(obj, bcy2, bgo2, bog2);
                    }
                    ++n2;
                }
                catch (Exception exception) {
                    this.a(bgo2, (Throwable)exception, collection, n2);
                }
            } while (iterator.hasNext());
        }
    }
}

