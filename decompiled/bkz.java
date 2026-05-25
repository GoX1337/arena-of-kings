/*
 * Decompiled with CFR 0.152.
 */
public abstract class bkz<T>
extends blc<T>
implements bib {
    protected final bfw var_bfw_a;
    protected final bir var_bir_a;
    protected final boc var_boc_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;

    public bkz(bfw bfw2, bir bir2, boc boc2, bfx<?> bfx2) {
        super(bfw2);
        this.var_bir_a = bir2;
        this.var_bfw_a = bfw2;
        this.var_bfw_a = bfx2;
        this.var_boc_a = boc2;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Object object = this.var_bfw_a;
        object = object == null ? bfs2.a(this.var_bfw_a.bfw_d(), bfp2) : bfs2.b((bfx<?>)object, bfp2, this.var_bfw_a.bfw_d());
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        if (object == this.var_bfw_a && boc2 == this.var_boc_a) {
            return this;
        }
        return this.a(boc2, (bfx<?>)object);
    }

    @Override
    public buc buc_a() {
        return buc.c;
    }

    protected abstract bkz<T> a(boc var1, bfx<?> var2);

    @Override
    public abstract T a(bfs var1);

    @Override
    public Object b(bfs bfs2) {
        return this.a((T)bfs2);
    }

    public abstract T b(Object var1);

    public abstract T a(T var1, Object var2);

    public abstract Object a(T var1);

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public btq btq_a() {
        if (this.var_bfw_a != null) {
            return ((bfx)((Object)this.var_bfw_a)).btq_a();
        }
        return super.btq_a();
    }

    @Override
    public Boolean a(bfr bfr2) {
        return this.var_bfw_a == null ? null : ((bfx)((Object)this.var_bfw_a)).a(bfr2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2) {
        if (this.var_bir_a != null) {
            Object object = this.var_bir_a.a(bfs2);
            return (T)this.a(bdc2, bfs2, object);
        }
        Object t2 = this.var_boc_a == null ? ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2, this.var_boc_a);
        return this.b(t2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2, T t2) {
        Object object;
        Boolean bl2 = ((bfx)((Object)this.var_bfw_a)).a(bfs2.bfr_a());
        if (bl2.equals(Boolean.FALSE) || this.var_boc_a != null) {
            object = this.var_boc_a == null ? ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2, this.var_boc_a);
        } else {
            object = this.a(t2);
            if (object == null) {
                object = this.var_boc_a == null ? ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2, this.var_boc_a);
                return this.b(object);
            }
            object = ((bfx)((Object)this.var_bfw_a)).a(bdc2, bfs2, object);
        }
        return this.a(t2, object);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        if (bdc2.boolean_a(bdf.m)) {
            return this.a((T)bfs2);
        }
        if (this.var_boc_a == null) {
            return this.a(bdc2, bfs2);
        }
        return this.b(this.var_boc_a.d(bdc2, bfs2));
    }
}

