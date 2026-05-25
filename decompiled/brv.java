/*
 * Decompiled with CFR 0.152.
 */
@bgp
public final class brv
extends btd<Object>
implements bqh {
    protected final boolean a;

    public brv(boolean bl2) {
        super(bl2 ? Boolean.TYPE : Boolean.class, false);
        this.a = bl2;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbk.c c2;
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, Boolean.class);
        if (d2 != null && (c2 = d2.bbk$c_a()).a()) {
            return new a(this.a);
        }
        return this;
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        bcy2.a(Boolean.TRUE.equals(object));
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        bcy2.a(Boolean.TRUE.equals(object));
    }

    static final class a
    extends btd<Object>
    implements bqh {
        protected final boolean a;

        public a(boolean bl2) {
            super(bl2 ? Boolean.TYPE : Boolean.class, false);
            this.a = bl2;
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.void_b(Boolean.FALSE.equals(object) ? 0 : 1);
        }

        @Override
        public final void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
            bcy2.a(Boolean.TRUE.equals(object));
        }

        @Override
        public bgb<?> a(bgo bgo2, bfp bfp2) {
            bbk.c c2;
            bbk.d d2 = this.bbk$d_a(bgo2, bfp2, Boolean.class);
            if (d2 != null && !(c2 = d2.bbk$c_a()).a()) {
                return new brv(this.a);
            }
            return this;
        }
    }
}

