/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;

@bgp
public class bqz
extends brr<Iterator<?>> {
    public bqz(bfw bfw2, boolean bl2, bog bog2) {
        super(Iterator.class, bfw2, bl2, bog2, null);
    }

    public bqz(bqz bqz2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bqz2, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, Iterator<?> iterator) {
        return !iterator.hasNext();
    }

    @Override
    public boolean a(Iterator<?> iterator) {
        return false;
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bqz(this, this.a, bog2, this.a, this.a);
    }

    public bqz a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        return new bqz(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public final void a(Iterator<?> iterator, bcy bcy2, bgo bgo2) {
        bcy2.b(iterator);
        this.b(iterator, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(Iterator<?> iterator, bcy bcy2, bgo bgo2) {
        if (!iterator.hasNext()) {
            return;
        }
        bgb bgb2 = this.a;
        if (bgb2 == null) {
            this.c(iterator, bcy2, bgo2);
            return;
        }
        bog bog2 = this.a;
        do {
            Object obj;
            if ((obj = iterator.next()) == null) {
                bgo2.a(bcy2);
                continue;
            }
            if (bog2 == null) {
                bgb2.a(obj, bcy2, bgo2);
                continue;
            }
            bgb2.a(obj, bcy2, bgo2, bog2);
        } while (iterator.hasNext());
    }

    protected void c(Iterator<?> iterator, bcy bcy2, bgo bgo2) {
        bog bog2 = this.a;
        bre bre2 = this.a;
        do {
            Object obj;
            if ((obj = iterator.next()) == null) {
                bgo2.a(bcy2);
                continue;
            }
            Class<?> clazz = obj.getClass();
            bgb<Object> bgb2 = bre2.a(clazz);
            if (bgb2 == null) {
                bgb2 = this.a.r() ? this.a(bre2, bgo2.a(this.a, clazz), bgo2) : this.a(bre2, clazz, bgo2);
                bre2 = this.a;
            }
            if (bog2 == null) {
                bgb2.a(obj, bcy2, bgo2);
                continue;
            }
            bgb2.a(obj, bcy2, bgo2, bog2);
        } while (iterator.hasNext());
    }
}

