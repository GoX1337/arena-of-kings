/*
 * Decompiled with CFR 0.152.
 */
public abstract class blg<T>
extends blc<T> {
    protected blg(Class<?> clazz) {
        super(clazz);
    }

    protected blg(blg<?> blg2) {
        super(blg2);
    }

    @Override
    public btq btq_a() {
        return btq.m;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.FALSE;
    }

    @Override
    public buc buc_a() {
        return buc.b;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.c(bdc2, bfs2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2, T t2) {
        bfs2.a(this);
        return this.a(bdc2, bfs2);
    }
}

