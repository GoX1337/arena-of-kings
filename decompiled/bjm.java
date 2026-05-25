/*
 * Decompiled with CFR 0.152.
 */
public class bjm
extends bio {
    private final bio a;

    public bjm(bio bio2, bni bni2) {
        super(bio2);
        this.a = bio2;
        this.a = bni2;
    }

    public bjm(bjm bjm2, bfx<?> bfx2, bil bil2) {
        super(bjm2, bfx2, bil2);
        this.a = bjm2.a;
        this.a = bjm2.a;
    }

    public bjm(bjm bjm2, bgj bgj2) {
        super(bjm2, bgj2);
        this.a = bjm2.a;
        this.a = bjm2.a;
    }

    @Override
    public bio a(bgj bgj2) {
        return new bjm(this, bgj2);
    }

    @Override
    public bio a(bfx<?> bfx2) {
        if (this.b == bfx2) {
            return this;
        }
        Object object = this.b == this.a ? bfx2 : this.a;
        return new bjm(this, bfx2, (bil)object);
    }

    @Override
    public bio a(bil bil2) {
        return new bjm(this, this.b, bil2);
    }

    @Override
    public void a(bfr bfr2) {
        if (this.a != null) {
            this.a.a(bfr2);
        }
    }

    @Override
    public bmn bmn_a() {
        return this.a.bmn_a();
    }

    @Override
    public int int_a() {
        return this.a.int_a();
    }

    @Override
    public void void_a(bdc bdc2, bfs bfs2, Object object) {
        this.java_lang_Object_a(bdc2, bfs2, object);
    }

    @Override
    public Object java_lang_Object_a(bdc bdc2, bfs bfs2, Object object) {
        try {
            return this.java_lang_Object_a(object, this.java_lang_Object_a(bdc2, bfs2));
        }
        catch (bip bip2) {
            boolean bl2;
            boolean bl3 = bl2 = this.a != null || this.b.bjl_a() != null;
            if (!bl2) {
                throw bfy.a(bdc2, "Unresolved forward reference but no identity info", (Throwable)bip2);
            }
            bip2.bjs_a().a(new a(this, bip2, (Class<?>)((bfw)((Object)this.a)).a(), object));
            return null;
        }
    }

    @Override
    public void void_a(Object object, Object object2) {
        this.a.void_a(object, object2);
    }

    @Override
    public Object java_lang_Object_a(Object object, Object object2) {
        return this.a.java_lang_Object_a(object, object2);
    }

    public static final class a
    extends bjs.a {
        private final bjm var_bjm_a;
        public final Object var_java_lang_Object_a;

        public a(bjm bjm2, bip bip2, Class<?> clazz, Object object) {
            super(bip2, clazz);
            this.var_bjm_a = bjm2;
            this.var_java_lang_Object_a = object;
        }

        @Override
        public void a(Object object, Object object2) {
            if (!this.boolean_a(object)) {
                throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + object + "] that wasn't previously seen as unresolved.");
            }
            this.var_bjm_a.void_a(this.var_java_lang_Object_a, object2);
        }
    }
}

