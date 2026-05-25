/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class bqp {
    private final HashMap<bvh, bgb<Object>> cfr_renamed_41 = new AtomicReference();
    private final AtomicReference<brf> var_java_util_concurrent_atomic_AtomicReference_brf__a;

    public brf a() {
        brf brf2 = (brf)((AtomicReference)((Object)this.cfr_renamed_41)).get();
        if (brf2 != null) {
            return brf2;
        }
        return this.b();
    }

    private final synchronized brf b() {
        brf brf2 = (brf)((AtomicReference)((Object)this.cfr_renamed_41)).get();
        if (brf2 == null) {
            brf2 = brf.a(this.cfr_renamed_41);
            ((AtomicReference)((Object)this.cfr_renamed_41)).set((bgb<Object>)((Object)brf2));
        }
        return brf2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bgb<Object> a(Class<?> clazz) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            return this.cfr_renamed_41.get(new bvh(clazz, false));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bgb<Object> a(bfw bfw2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            return this.cfr_renamed_41.get(new bvh(bfw2, false));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bgb<Object> b(bfw bfw2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            return this.cfr_renamed_41.get(new bvh(bfw2, true));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bgb<Object> b(Class<?> clazz) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            return this.cfr_renamed_41.get(new bvh(clazz, true));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bfw bfw2, bgb<Object> bgb2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            if (this.cfr_renamed_41.put(new bvh(bfw2, true), bgb2) == null) {
                ((AtomicReference)((Object)this.cfr_renamed_41)).set(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Class<?> clazz, bgb<Object> bgb2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            if (this.cfr_renamed_41.put(new bvh(clazz, true), bgb2) == null) {
                ((AtomicReference)((Object)this.cfr_renamed_41)).set(null);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bfw bfw2, bgb<Object> bgb2, bgo bgo2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            if (this.cfr_renamed_41.put(new bvh(bfw2, false), bgb2) == null) {
                ((AtomicReference)((Object)this.cfr_renamed_41)).set(null);
            }
            if (bgb2 instanceof bqo) {
                ((bqo)((Object)bgb2)).void_a(bgo2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Class<?> clazz, bfw bfw2, bgb<Object> bgb2, bgo bgo2) {
        bqp bqp2 = this;
        synchronized (bqp2) {
            bgb<Object> bgb3 = this.cfr_renamed_41.put(new bvh(clazz, false), bgb2);
            bgb<Object> bgb4 = this.cfr_renamed_41.put(new bvh(bfw2, false), bgb2);
            if (bgb3 == null || bgb4 == null) {
                ((AtomicReference)((Object)this.cfr_renamed_41)).set(null);
            }
            if (bgb2 instanceof bqo) {
                ((bqo)((Object)bgb2)).void_a(bgo2);
            }
        }
    }
}

