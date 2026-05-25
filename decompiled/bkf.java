/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@bgp
public class bkf
extends bkg<Collection<Object>>
implements bib {
    protected final bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;
    protected final bir var_bir_a;
    protected final bfx<Object> b;

    public bkf(bfw bfw2, bfx<Object> bfx2, boc boc2, bir bir2) {
        this(bfw2, bfx2, boc2, bir2, null, null, null);
    }

    protected bkf(bfw bfw2, bfx<Object> bfx2, boc boc2, bir bir2, bfx<Object> bfx3, bil bil2, Boolean bl2) {
        super(bfw2, bil2, bl2);
        this.var_bfx_java_lang_Object__a = bfx2;
        this.var_boc_a = boc2;
        this.var_bir_a = bir2;
        this.b = bfx3;
    }

    protected bkf a(bfx<?> bfx2, bfx<?> bfx3, boc boc2, bil bil2, Boolean bl2) {
        return new bkf((bfw)((Object)this.var_bfx_java_lang_Object__a), bfx3, boc2, this.var_bir_a, bfx2, bil2, bl2);
    }

    @Override
    public boolean boolean_a() {
        return this.var_bfx_java_lang_Object__a == null && this.var_boc_a == null && this.b == null;
    }

    @Override
    public btq btq_a() {
        return btq.b;
    }

    public bkf a(bfs bfs2, bfp bfp2) {
        Serializable serializable;
        bfx<Object> bfx2 = null;
        if (this.var_bir_a != null) {
            if (this.var_bir_a.j()) {
                serializable = this.var_bir_a.bfw_a(bfs2.bfr_a());
                if (serializable == null) {
                    bfs2.b((bfw)((Object)this.var_bfx_java_lang_Object__a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this.var_bfx_java_lang_Object__a, this.var_bir_a.getClass().getName()));
                }
                bfx2 = this.a(bfs2, (bfw)serializable, bfp2);
            } else if (this.var_bir_a.k()) {
                serializable = this.var_bir_a.b(bfs2.bfr_a());
                if (serializable == null) {
                    bfs2.b((bfw)((Object)this.var_bfx_java_lang_Object__a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this.var_bfx_java_lang_Object__a, this.var_bir_a.getClass().getName()));
                }
                bfx2 = this.a(bfs2, (bfw)serializable, bfp2);
            }
        }
        serializable = this.a(bfs2, bfp2, Collection.class, bbk.a.var_bbk$a_a);
        bfx<Object> bfx3 = this.var_bfx_java_lang_Object__a;
        bfx3 = this.a(bfs2, bfp2, bfx3);
        bfw bfw2 = ((bfw)((Object)this.var_bfx_java_lang_Object__a)).bfw_c();
        bfx3 = bfx3 == null ? bfs2.a(bfw2, bfp2) : bfs2.b(bfx3, bfp2, bfw2);
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        bil bil2 = this.a(bfs2, bfp2, bfx3);
        if (!Objects.equals(serializable, this.var_bfx_java_lang_Object__a) || bil2 != this.var_bfx_java_lang_Object__a || bfx2 != this.b || bfx3 != this.var_bfx_java_lang_Object__a || boc2 != this.var_boc_a) {
            return this.a(bfx2, bfx3, boc2, bil2, (Boolean)serializable);
        }
        return this;
    }

    @Override
    public bfx<Object> a() {
        return this.var_bfx_java_lang_Object__a;
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public Collection<Object> a(bdc bdc2, bfs bfs2) {
        if (this.b != null) {
            return (Collection)this.var_bir_a.a(bfs2, this.b.a(bdc2, bfs2));
        }
        if (bdc2.boolean_c()) {
            return this.a(bdc2, bfs2, this.a(bfs2));
        }
        if (bdc2.boolean_a(bdf.h)) {
            return this.a(bdc2, bfs2, bdc2.java_lang_String_e());
        }
        return this.c(bdc2, bfs2, this.a(bfs2));
    }

    @Override
    protected Collection<Object> a(bfs bfs2) {
        return (Collection)this.var_bir_a.a(bfs2);
    }

    public Collection<Object> b(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        if (bdc2.boolean_c()) {
            return this.a(bdc2, bfs2, collection);
        }
        return this.c(bdc2, bfs2, collection);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }

    @Override
    protected Collection<Object> a(bdc bdc2, bfs bfs2, String string) {
        Class<?> clazz = this.a();
        if (string.isEmpty()) {
            bha bha2 = bfs2.a(this.btq_a(), clazz, bhe.j);
            if ((bha2 = this.a(bfs2, bha2, clazz, string, "empty String (\"\")")) != null) {
                return (Collection)this.a(bdc2, bfs2, bha2, clazz, "empty String (\"\")");
            }
        }
        return this.c(bdc2, bfs2, this.a(bfs2));
    }

    @Override
    protected Collection<Object> a(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        bdf bdf2;
        bdc2.a(collection);
        bfx<Object> bfx2 = this.var_bfx_java_lang_Object__a;
        if (bfx2.bjl_a() != null) {
            return this.d(bdc2, bfs2, collection);
        }
        boc boc2 = this.var_boc_a;
        while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
            try {
                Object object;
                if (bdf2 == bdf.m) {
                    if (this.var_bfx_java_lang_Object__a != false) continue;
                    object = this.var_bfx_java_lang_Object__a.a(bfs2);
                } else {
                    object = boc2 == null ? bfx2.a(bdc2, bfs2) : bfx2.a(bdc2, bfs2, boc2);
                }
                collection.add(object);
            }
            catch (Exception exception) {
                boolean bl2;
                boolean bl3 = bl2 = bfs2 == null || bfs2.a(bfu.p);
                if (!bl2) {
                    buk.java_lang_Throwable_b(exception);
                }
                throw bfy.a((Throwable)exception, collection, collection.size());
            }
        }
        return collection;
    }

    protected final Collection<Object> c(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        Object object;
        boolean bl2;
        boolean bl3 = bl2 = this.var_bfx_java_lang_Object__a == Boolean.TRUE || this.var_bfx_java_lang_Object__a == null && bfs2.a(bfu.q);
        if (!bl2) {
            return (Collection)bfs2.a((bfw)((Object)this.var_bfx_java_lang_Object__a), bdc2);
        }
        bfx<Object> bfx2 = this.var_bfx_java_lang_Object__a;
        boc boc2 = this.var_boc_a;
        try {
            if (bdc2.boolean_a(bdf.m)) {
                if (this.var_bfx_java_lang_Object__a != false) {
                    return collection;
                }
                object = this.var_bfx_java_lang_Object__a.a(bfs2);
            } else {
                object = boc2 == null ? bfx2.a(bdc2, bfs2) : bfx2.a(bdc2, bfs2, boc2);
            }
        }
        catch (Exception exception) {
            boolean bl4 = bfs2.a(bfu.p);
            if (!bl4) {
                buk.java_lang_Throwable_b(exception);
            }
            throw bfy.a((Throwable)exception, Object.class, collection.size());
        }
        collection.add(object);
        return collection;
    }

    protected Collection<Object> d(bdc bdc2, bfs bfs2, Collection<Object> collection) {
        bdf bdf2;
        if (!bdc2.boolean_c()) {
            return this.c(bdc2, bfs2, collection);
        }
        bdc2.a(collection);
        bfx<Object> bfx2 = this.var_bfx_java_lang_Object__a;
        boc boc2 = this.var_boc_a;
        b b2 = new b((Class<?>)((bfw)((Object)this.var_bfx_java_lang_Object__a)).bfw_c().a(), collection);
        while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
            try {
                Object object;
                if (bdf2 == bdf.m) {
                    if (this.var_bfx_java_lang_Object__a != false) continue;
                    object = this.var_bfx_java_lang_Object__a.a(bfs2);
                } else {
                    object = boc2 == null ? bfx2.a(bdc2, bfs2) : bfx2.a(bdc2, bfs2, boc2);
                }
                b2.a(object);
            }
            catch (bip bip2) {
                bjs.a a2 = b2.a(bip2);
                bip2.bjs_a().a(a2);
            }
            catch (Exception exception) {
                boolean bl2;
                boolean bl3 = bl2 = bfs2 == null || bfs2.a(bfu.p);
                if (!bl2) {
                    buk.java_lang_Throwable_b(exception);
                }
                throw bfy.a((Throwable)exception, collection, collection.size());
            }
        }
        return collection;
    }

    @Override
    public /* synthetic */ Object a(bdc bdc2, bfs bfs2, Object object) {
        return this.b(bdc2, bfs2, (Collection)object);
    }

    static final class a
    extends bjs.a {
        private final b var_bkf$b_a = new ArrayList();
        public final List<Object> var_java_util_List_java_lang_Object__a;

        a(b b2, bip bip2, Class<?> clazz) {
            super(bip2, clazz);
            this.var_bkf$b_a = b2;
        }

        @Override
        public void a(Object object, Object object2) {
            this.var_bkf$b_a.a(object, object2);
        }
    }

    public static class b {
        private final Class<?> var_java_lang_Class____a = new ArrayList();
        private final Collection<Object> var_java_util_Collection_java_lang_Object__a;
        private List<a> var_java_util_List_bkf$a__a;

        public b(Class<?> clazz, Collection<Object> collection) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = collection;
        }

        public void a(Object object) {
            if (this.var_java_lang_Class____a.isEmpty()) {
                this.var_java_lang_Class____a.add((Object)object);
            } else {
                a a2 = (a)this.var_java_lang_Class____a.get(this.var_java_lang_Class____a.size() - 1);
                a2.var_bkf$b_a.add(object);
            }
        }

        public bjs.a a(bip bip2) {
            a a2 = new a(this, bip2, this.var_java_lang_Class____a);
            this.var_java_lang_Class____a.add((a)a2);
            return a2;
        }

        public void a(Object object, Object object2) {
            Iterator iterator = this.var_java_lang_Class____a.iterator();
            Object object3 = this.var_java_lang_Class____a;
            while (iterator.hasNext()) {
                a a2 = (a)iterator.next();
                if (a2.boolean_a(object)) {
                    iterator.remove();
                    object3.add((Object)object2);
                    object3.addAll(a2.var_bkf$b_a);
                    return;
                }
                object3 = a2.var_bkf$b_a;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + object + "] that wasn't previously seen as unresolved.");
        }
    }
}

