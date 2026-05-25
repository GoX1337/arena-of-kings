/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.HashMap;

public final class bih
implements Serializable {
    protected final buq<bfw, bfx<Object>> cfr_renamed_21 = new HashMap(8);
    protected final HashMap<bfw, bfx<Object>> cfr_renamed_22;

    public bih() {
        this(2000);
    }

    public bih(int n2) {
        int n3 = Math.min(64, n2 >> 2);
        this.cfr_renamed_21 = new buq(n3, n2);
    }

    public bfx<Object> a(bfs bfs2, bii bii2, bfw bfw2) {
        bfx<Object> bfx2 = this.a(bfw2);
        if (bfx2 == null && (bfx2 = this.b(bfs2, bii2, bfw2)) == null) {
            bfx2 = this.a(bfs2, bfw2);
        }
        return bfx2;
    }

    public bgc a(bfs bfs2, bii bii2, bfw bfw2) {
        bgc bgc2 = bii2.a(bfs2, bfw2);
        if (bgc2 == null) {
            return this.a(bfs2, bfw2);
        }
        if (bgc2 instanceof bim) {
            ((bim)((Object)bgc2)).a(bfs2);
        }
        return bgc2;
    }

    protected bfx<Object> a(bfw bfw2) {
        if (bfw2 == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        }
        if (this.a(bfw2)) {
            return null;
        }
        return this.cfr_renamed_21.a(bfw2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected bfx<Object> b(bfs bfs2, bii bii2, bfw bfw2) {
        buq<bfw, bfx<Object>> buq2 = this.cfr_renamed_21;
        synchronized (buq2) {
            bfx<Object> bfx2;
            block9: {
                bfx bfx3 = this.a(bfw2);
                if (bfx3 != null) {
                    return bfx3;
                }
                int n2 = ((HashMap)((Object)this.cfr_renamed_21)).size();
                if (n2 > 0 && (bfx3 = (bfx)((HashMap)((Object)this.cfr_renamed_21)).get(bfw2)) != null) {
                    return bfx3;
                }
                try {
                    bfx2 = this.c(bfs2, bii2, bfw2);
                    if (n2 != 0 || ((HashMap)((Object)this.cfr_renamed_21)).size() <= 0) break block9;
                    ((HashMap)((Object)this.cfr_renamed_21)).clear();
                }
                catch (Throwable throwable) {
                    if (n2 == 0 && ((HashMap)((Object)this.cfr_renamed_21)).size() > 0) {
                        ((HashMap)((Object)this.cfr_renamed_21)).clear();
                    }
                    throw throwable;
                }
            }
            return bfx2;
        }
    }

    protected bfx<Object> c(bfs bfs2, bii bii2, bfw bfw2) {
        boolean bl2;
        bfx<Object> bfx2;
        try {
            bfx2 = this.d(bfs2, bii2, bfw2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw bfy.a(bfs2, buk.java_lang_String_a(illegalArgumentException), (Throwable)illegalArgumentException);
        }
        if (bfx2 == null) {
            return null;
        }
        boolean bl3 = bl2 = !this.a(bfw2) && bfx2.boolean_a();
        if (bfx2 instanceof bim) {
            ((HashMap)((Object)this.cfr_renamed_21)).put(bfw2, bfx2);
            ((bim)((Object)bfx2)).a(bfs2);
            ((HashMap)((Object)this.cfr_renamed_21)).remove(bfw2);
        }
        if (bl2) {
            this.cfr_renamed_21.a(bfw2, bfx2);
        }
        return bfx2;
    }

    protected bfx<Object> d(bfs bfs2, bii bii2, bfw bfw2) {
        Class<?> clazz;
        bfo bfo2;
        bfx<Object> bfx2;
        bfr bfr2 = bfs2.bfr_a();
        if (bfw2.boolean_c() || bfw2.o() || bfw2.n()) {
            bfw2 = bii2.bfw_a(bfr2, bfw2);
        }
        if ((bfx2 = this.a(bfs2, (bfo2 = bfr2.bfo_a(bfw2)).bmh_a())) != null) {
            return bfx2;
        }
        bfw bfw3 = this.a(bfs2, (bmg)bfo2.bmh_a(), bfw2);
        if (bfw3 != bfw2) {
            bfw2 = bfw3;
            bfo2 = bfr2.bfo_a(bfw3);
        }
        if ((clazz = bfo2.b()) != null) {
            return bii2.a(bfs2, bfw2, bfo2, clazz);
        }
        bum<Object, Object> bum2 = bfo2.b();
        if (bum2 == null) {
            return this.a(bfs2, bii2, bfw2, bfo2);
        }
        bfw bfw4 = bum2.a(bfs2.btz_a());
        if (!bfw4.boolean_a((Class<?>)bfw2.a())) {
            bfo2 = bfr2.bfo_a(bfw4);
        }
        return new blb<Object>(bum2, bfw4, this.a(bfs2, bii2, bfw4, bfo2));
    }

    protected bfx<?> a(bfs bfs2, bii bii2, bfw bfw2, bfo bfo2) {
        bfr bfr2 = bfs2.bfr_a();
        if (bfw2.g()) {
            return bii2.a(bfs2, bfw2, bfo2);
        }
        if (bfw2.m()) {
            bbk.d d2;
            if (bfw2.boolean_f()) {
                return bii2.a(bfs2, (btl)bfw2, bfo2);
            }
            if (bfw2.o() && (d2 = bfo2.a((bbk.d)null)).bbk$c_a() != bbk.c.e) {
                btr btr2 = (btr)bfw2;
                if (btr2 instanceof bts) {
                    return bii2.a(bfs2, (bts)btr2, bfo2);
                }
                return bii2.a(bfs2, btr2, bfo2);
            }
            if (bfw2.n() && (d2 = bfo2.a((bbk.d)null)).bbk$c_a() != bbk.c.e) {
                bto bto2 = (bto)bfw2;
                if (bto2 instanceof btp) {
                    return bii2.a(bfs2, (btp)bto2, bfo2);
                }
                return bii2.a(bfs2, bto2, bfo2);
            }
        }
        if (bfw2.a() != false) {
            return bii2.a(bfs2, (btu)bfw2, bfo2);
        }
        if (bfz.class.isAssignableFrom((Class<?>)bfw2.a())) {
            return bii2.a(bfr2, bfw2, bfo2);
        }
        return bii2.d(bfs2, bfw2, bfo2);
    }

    protected bfx<Object> a(bfs bfs2, bmg bmg2) {
        Object object = bfs2.bfn_a().g(bmg2);
        if (object == null) {
            return null;
        }
        bfx<Object> bfx2 = bfs2.a(bmg2, object);
        return this.a(bfs2, bmg2, bfx2);
    }

    protected bfx<Object> a(bfs bfs2, bmg bmg2, bfx<Object> bfx2) {
        bum<Object, Object> bum2 = this.a(bfs2, bmg2);
        if (bum2 == null) {
            return bfx2;
        }
        bfw bfw2 = bum2.a(bfs2.btz_a());
        return new blb<Object>(bum2, bfw2, bfx2);
    }

    protected bum<Object, Object> a(bfs bfs2, bmg bmg2) {
        Object object = bfs2.bfn_a().j(bmg2);
        if (object == null) {
            return null;
        }
        return bfs2.a(bmg2, object);
    }

    private bfw a(bfs bfs2, bmg bmg2, bfw bfw2) {
        bfx<Object> bfx2;
        Object object;
        bfw bfw3;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 == null) {
            return bfw2;
        }
        if (bfw2.o() && (bfw3 = bfw2.bfw_b()) != null && bfw3.a() == null && (object = bfn2.h(bmg2)) != null && (bfx2 = bfs2.a(bmg2, object)) != null) {
            bfw2 = ((btr)bfw2).e(bfx2);
        }
        if ((bfw3 = bfw2.bfw_c()) != null && bfw3.a() == null && (object = bfn2.i(bmg2)) != null) {
            bfx2 = null;
            if (object instanceof bfx) {
                bfx2 = (bfx)object;
            } else {
                Class<?> clazz = this.a(object, "findContentDeserializer", bfx.a.class);
                if (clazz != null) {
                    bfx2 = bfs2.a(bmg2, clazz);
                }
            }
            if (bfx2 != null) {
                bfw2 = bfw2.d(bfx2);
            }
        }
        bfw2 = bfn2.b(bfs2.bfr_a(), bmg2, bfw2);
        return bfw2;
    }

    private boolean a(bfw bfw2) {
        if (bfw2.m()) {
            bfw bfw3;
            bfw bfw4 = bfw2.bfw_c();
            if (bfw4 != null && (bfw4.a() != null || bfw4.b() != null)) {
                return true;
            }
            if (bfw2.o() && (bfw3 = bfw2.bfw_b()).a() != null) {
                return true;
            }
        }
        return false;
    }

    private Class<?> a(Object object, String string, Class<?> clazz) {
        if (object == null) {
            return null;
        }
        if (!(object instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector." + string + "() returned value of type " + object.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        Class clazz2 = (Class)object;
        if (clazz2 == clazz || buk.c(clazz2)) {
            return null;
        }
        return clazz2;
    }

    protected bfx<Object> a(bfs bfs2, bfw bfw2) {
        Object t2 = bfw2.a();
        if (!buk.boolean_b(t2)) {
            return (bfx)bfs2.b(bfw2, "Cannot find a Value deserializer for abstract type " + bfw2);
        }
        return (bfx)bfs2.b(bfw2, "Cannot find a Value deserializer for type " + bfw2);
    }

    protected bgc a(bfs bfs2, bfw bfw2) {
        return (bgc)bfs2.b(bfw2, "Cannot find a (Map) Key deserializer for type " + bfw2);
    }
}

