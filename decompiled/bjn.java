/*
 * Decompiled with CFR 0.152.
 */
public final class bjn
extends bio {
    protected final bjl a;

    public bjn(bjl bjl2, bgi bgi2) {
        super(bjl2.var_bgj_a, bjl2.bfw_a(), bgi2, bjl2.a());
        this.a = bjl2;
    }

    protected bjn(bjn bjn2, bfx<?> bfx2, bil bil2) {
        super(bjn2, bfx2, bil2);
        this.a = bjn2.a;
    }

    protected bjn(bjn bjn2, bgj bgj2) {
        super(bjn2, bgj2);
        this.a = bjn2.a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bjn(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.a ? bfx2 : this.a;
        return new bjn(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bjn(this, this.b, bil2);
    }

    @Override
    public bmn bmn_a() {
        return null;
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        this.java_lang_Object_a(bdc2, bfs2, object);
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        if (bdc2.boolean_a(bdf.m)) {
            return null;
        }
        Object t2 = this.b.a(bdc2, bfs2);
        bjs bjs2 = bfs2.a(t2, (bck<?>)((Object)this.a.var_bfw_a), this.a.var_bcm_a);
        bjs2.a(object);
        bio bio2 = this.a.var_bio_a;
        if (bio2 != null) {
            return bio2.java_lang_Object_a(object, t2);
        }
        return object;
    }

    @Override
    public void void_a(Object object, Object object2) {
        this.java_lang_Object_a(object, object2);
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        bio bio2 = this.a.var_bio_a;
        if (bio2 == null) {
            throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
        }
        return bio2.java_lang_Object_a(object, object2);
    }
}

