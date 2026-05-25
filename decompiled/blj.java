/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.Objects;

@bgp
public final class blj
extends bkg<Collection<String>>
implements bib {
    protected final bfx<String> var_bfx_java_lang_String__a;
    protected final bir var_bir_a;
    protected final bfx<Object> b;

    public blj(bfw bfw2, bfx<?> bfx2, bir bir2) {
        this(bfw2, bir2, null, bfx2, bfx2, null);
    }

    protected blj(bfw bfw2, bir bir2, bfx<?> bfx2, bfx<?> bfx3, bil bil2, Boolean bl2) {
        super(bfw2, bil2, bl2);
        this.var_bfx_java_lang_String__a = bfx3;
        this.var_bir_a = bir2;
        this.b = bfx2;
    }

    protected blj a(bfx<?> bfx2, bfx<?> bfx3, bil bil2, Boolean bl2) {
        if (Objects.equals(this.var_bfx_java_lang_String__a, bl2) && this.var_bfx_java_lang_String__a == bil2 && this.var_bfx_java_lang_String__a == bfx3 && this.b == bfx2) {
            return this;
        }
        return new blj((bfw)((Object)this.var_bfx_java_lang_String__a), this.var_bir_a, bfx2, bfx3, bil2, bl2);
    }

    @Override
    public boolean boolean_a() {
        return this.var_bfx_java_lang_String__a == null && this.b == null;
    }

    @Override
    public btq btq_a() {
        return btq.b;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bfw bfw2;
        Object object;
        bfx<Object> bfx2 = null;
        if (this.var_bir_a != null) {
            object = this.var_bir_a.bms_c();
            if (object != null) {
                bfw2 = this.var_bir_a.b(bfs2.bfr_a());
                bfx2 = this.a(bfs2, bfw2, bfp2);
            } else {
                object = this.var_bir_a.bms_b();
                if (object != null) {
                    bfw2 = this.var_bir_a.bfw_a(bfs2.bfr_a());
                    bfx2 = this.a(bfs2, bfw2, bfp2);
                }
            }
        }
        object = this.var_bfx_java_lang_String__a;
        bfw2 = ((bfw)((Object)this.var_bfx_java_lang_String__a)).bfw_c();
        if (object == null) {
            if ((object = this.a(bfs2, bfp2, (bfx<?>)object)) == null) {
                object = bfs2.a(bfw2, bfp2);
            }
        } else {
            object = bfs2.b((bfx<?>)object, bfp2, bfw2);
        }
        Boolean bl2 = this.a(bfs2, bfp2, Collection.class, bbk.a.var_bbk$a_a);
        bil bil2 = this.a(bfs2, bfp2, (bfx<?>)object);
        if (this.a((bfx<?>)object)) {
            object = null;
        }
        return this.a(bfx2, (bfx<?>)object, bil2, bl2);
    }

    @Override
    public bfx<Object> a() {
        bfx<Object> bfx2 = this.var_bfx_java_lang_String__a;
        return bfx2;
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public Collection<String> a(bdc bdc2, bfs bfs2) {
        if (this.b != null) {
            return (Collection)this.var_bir_a.a(bfs2, this.b.a(bdc2, bfs2));
        }
        Collection collection = (Collection)this.var_bir_a.a(bfs2);
        return this.a(bdc2, bfs2, collection);
    }

    @Override
    public Collection<String> a(bdc bdc2, bfs bfs2, Collection<String> collection) {
        if (!bdc2.boolean_c()) {
            return this.b(bdc2, bfs2, collection);
        }
        if (this.var_bfx_java_lang_String__a != null) {
            return this.a(bdc2, bfs2, collection, this.var_bfx_java_lang_String__a);
        }
        try {
            while (true) {
                Object object;
                if ((object = bdc2.java_lang_String_b()) != null) {
                    collection.add((String)object);
                    continue;
                }
                bdf bdf2 = bdc2.bdf_c();
                if (bdf2 != bdf.var_bdf_e) {
                    if (bdf2 == bdf.m) {
                        if (this.var_bfx_java_lang_String__a != false) continue;
                        object = (String)this.var_bfx_java_lang_String__a.a(bfs2);
                    } else {
                        object = this.a(bdc2, bfs2);
                    }
                    collection.add((String)object);
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, collection, collection.size());
        }
        return collection;
    }

    private Collection<String> a(bdc bdc2, bfs bfs2, Collection<String> collection, bfx<String> bfx2) {
        try {
            while (true) {
                String string;
                if (bdc2.java_lang_String_b() == null) {
                    bdf bdf2 = bdc2.bdf_c();
                    if (bdf2 == bdf.var_bdf_e) break;
                    if (bdf2 == bdf.m) {
                        if (this.var_bfx_java_lang_String__a != false) continue;
                        string = (String)this.var_bfx_java_lang_String__a.a(bfs2);
                    } else {
                        string = bfx2.a(bdc2, bfs2);
                    }
                } else {
                    string = bfx2.a(bdc2, bfs2);
                }
                collection.add(string);
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, collection, collection.size());
        }
        return collection;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }

    private final Collection<String> b(bdc bdc2, bfs bfs2, Collection<String> collection) {
        Object object;
        boolean bl2;
        boolean bl3 = bl2 = this.var_bfx_java_lang_String__a == Boolean.TRUE || this.var_bfx_java_lang_String__a == null && bfs2.a(bfu.q);
        if (!bl2) {
            if (bdc2.boolean_a(bdf.h)) {
                return (Collection)this.r(bdc2, bfs2);
            }
            return (Collection)bfs2.a((bfw)((Object)this.var_bfx_java_lang_String__a), bdc2);
        }
        bfx<String> bfx2 = this.var_bfx_java_lang_String__a;
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == bdf.m) {
            if (this.var_bfx_java_lang_String__a != false) {
                return collection;
            }
            object = (String)this.var_bfx_java_lang_String__a.a(bfs2);
        } else {
            try {
                object = bfx2 == null ? this.a(bdc2, bfs2) : bfx2.a(bdc2, bfs2);
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, collection, collection.size());
            }
        }
        collection.add((String)object);
        return collection;
    }
}

