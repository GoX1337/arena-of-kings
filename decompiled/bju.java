/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;

public final class bju
extends bfx<Object>
implements Serializable {
    protected final boc var_boc_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;

    public bju(boc boc2, bfx<?> bfx2) {
        this.var_boc_a = boc2;
        this.var_boc_a = bfx2;
    }

    @Override
    public btq a() {
        return ((bfx)((Object)this.var_boc_a)).btq_a();
    }

    @Override
    public Class<?> a() {
        return ((bfx)((Object)this.var_boc_a)).a();
    }

    @Override
    public Boolean a(bfr bfr2) {
        return ((bfx)((Object)this.var_boc_a)).a(bfr2);
    }

    @Override
    public Collection<Object> a() {
        return ((bfx)((Object)this.var_boc_a)).a();
    }

    @Override
    public Object a(bfs bfs2) {
        return ((bfx)((Object)this.var_boc_a)).a(bfs2);
    }

    @Override
    public Object b(bfs bfs2) {
        return ((bfx)((Object)this.var_boc_a)).b(bfs2);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        return ((bfx)((Object)this.var_boc_a)).a(bdc2, bfs2, this.var_boc_a);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, Object object) {
        return ((bfx)((Object)this.var_boc_a)).a(bdc2, bfs2, object);
    }
}

