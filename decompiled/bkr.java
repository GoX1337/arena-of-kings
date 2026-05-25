/*
 * Decompiled with CFR 0.152.
 */
public class bkr
extends bkd<bfz> {
    private static final bkr a = new bkr();

    protected bkr() {
        super(bfz.class, null);
    }

    public static bfx<? extends bfz> a(Class<?> clazz) {
        if (clazz == bpt.class) {
            return bkr$b.a();
        }
        if (clazz == bpd.class) {
            return bkr$a.a();
        }
        return a;
    }

    @Override
    public bfz a(bfs bfs2) {
        return bfs2.bpo_a().bpr_a();
    }

    @Override
    public bfz a(bdc bdc2, bfs bfs2) {
        switch (bdc2.int_a()) {
            case 1: {
                return this.bpt_a(bdc2, bfs2, bfs2.bpo_a());
            }
            case 3: {
                return this.bpd_a(bdc2, bfs2, bfs2.bpo_a());
            }
        }
        return this.bfz_a(bdc2, bfs2, bfs2.bpo_a());
    }

    static final class a
    extends bkd<bpd> {
        protected static final a a = new a();

        protected a() {
            super(bpd.class, true);
        }

        public static a a() {
            return a;
        }

        @Override
        public bpd a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_c()) {
                return this.bpd_a(bdc2, bfs2, bfs2.bpo_a());
            }
            return (bpd)bfs2.a(bpd.class, bdc2);
        }

        @Override
        public bpd a(bdc bdc2, bfs bfs2, bpd bpd2) {
            if (bdc2.boolean_c()) {
                return (bpd)this.a(bdc2, bfs2, bpd2);
            }
            return (bpd)bfs2.a(bpd.class, bdc2);
        }
    }

    static final class b
    extends bkd<bpt> {
        protected static final b a = new b();

        protected b() {
            super(bpt.class, true);
        }

        public static b a() {
            return a;
        }

        @Override
        public bpt a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_d()) {
                return this.bpt_a(bdc2, bfs2, bfs2.bpo_a());
            }
            if (bdc2.boolean_a(bdf.f)) {
                return this.bpt_b(bdc2, bfs2, bfs2.bpo_a());
            }
            if (bdc2.boolean_a(bdf.var_bdf_c)) {
                return bfs2.bpo_a().bpt_a();
            }
            return (bpt)bfs2.a(bpt.class, bdc2);
        }

        @Override
        public bpt a(bdc bdc2, bfs bfs2, bpt bpt2) {
            if (bdc2.boolean_d() || bdc2.boolean_a(bdf.f)) {
                return (bpt)this.a(bdc2, bfs2, bpt2);
            }
            return (bpt)bfs2.a(bpt.class, bdc2);
        }
    }
}

