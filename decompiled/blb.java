/*
 * Decompiled with CFR 0.152.
 */
public class blb<T>
extends blc<T>
implements bib,
bim {
    protected final bum<Object, T> cfr_renamed_27;
    protected final bfw var_bfw_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;

    public blb(bum<?, T> bum2) {
        super(Object.class);
        this.cfr_renamed_27 = bum2;
        this.var_bfw_a = null;
        this.cfr_renamed_27 = null;
    }

    public blb(bum<Object, T> bum2, bfw bfw2, bfx<?> bfx2) {
        super(bfw2);
        this.cfr_renamed_27 = bum2;
        this.var_bfw_a = bfw2;
        this.cfr_renamed_27 = bfx2;
    }

    protected blb<T> a(bum<Object, T> bum2, bfw bfw2, bfx<?> bfx2) {
        buk.a(blb.class, this, "withDelegate");
        return new blb<T>(bum2, bfw2, bfx2);
    }

    @Override
    public void a(bfs bfs2) {
        if (this.cfr_renamed_27 != null && this.cfr_renamed_27 instanceof bim) {
            ((bim)((Object)this.cfr_renamed_27)).a(bfs2);
        }
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        if (this.cfr_renamed_27 != null) {
            bfx<?> bfx2 = bfs2.b((bfx<?>)((Object)this.cfr_renamed_27), bfp2, this.var_bfw_a);
            if (bfx2 != this.cfr_renamed_27) {
                return this.a(this.cfr_renamed_27, this.var_bfw_a, bfx2);
            }
            return this;
        }
        bfw bfw2 = this.cfr_renamed_27.a(bfs2.btz_a());
        return this.a(this.cfr_renamed_27, bfw2, bfs2.a(bfw2, bfp2));
    }

    @Override
    public Class<?> a() {
        return ((bfx)((Object)this.cfr_renamed_27)).a();
    }

    @Override
    public btq a() {
        return ((bfx)((Object)this.cfr_renamed_27)).btq_a();
    }

    @Override
    public Boolean a(bfr bfr2) {
        return ((bfx)((Object)this.cfr_renamed_27)).a(bfr2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2) {
        Object t2 = ((bfx)((Object)this.cfr_renamed_27)).a(bdc2, bfs2);
        if (t2 == null) {
            return null;
        }
        return this.a(t2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        Object t2 = ((bfx)((Object)this.cfr_renamed_27)).a(bdc2, bfs2);
        if (t2 == null) {
            return null;
        }
        return this.a(t2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2, Object object) {
        if (((Class)this.var_bfw_a.a()).isAssignableFrom(object.getClass())) {
            return (T)((bfx)((Object)this.cfr_renamed_27)).a(bdc2, bfs2, object);
        }
        return (T)this.b(bdc2, bfs2, object);
    }

    protected Object b(bdc bdc2, bfs bfs2, Object object) {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)" + object.getClass().getName(), this.var_bfw_a));
    }

    protected T a(Object object) {
        return this.cfr_renamed_27.a(object);
    }
}

