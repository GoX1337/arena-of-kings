/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public interface bfp
extends bux {
    public static final bbk.d var_bbk$d_a;
    public static final bbr.b var_bbr$b_a;

    @Override
    public String java_lang_String_a();

    public bgj bgj_a();

    public bfw bfw_a();

    public bgi bgi_a();

    public bmn bmn_a();

    public bbk.d bbk$d_a(bhm<?> var1, Class<?> var2);

    public bbr.b bbr$b_a(bhm<?> var1, Class<?> var2);

    static {
        var_bbk$d_a = new bbk.d();
        var_bbr$b_a = bbr.b.bbr$b_a();
    }

    public static class a
    implements bfp {
        @Override
        public String java_lang_String_a() {
            return "";
        }

        @Override
        public bgj bgj_a() {
            return bgj.var_bgj_b;
        }

        @Override
        public bfw bfw_a() {
            return btz.bfw_a();
        }

        @Override
        public bgi bgi_a() {
            return bgi.c;
        }

        @Override
        public bmn bmn_a() {
            return null;
        }

        @Override
        public bbk.d bbk$d_a(bhm<?> bhm2, Class<?> clazz) {
            return bbk.d.bbk$d_a();
        }

        @Override
        public bbr.b bbr$b_a(bhm<?> bhm2, Class<?> clazz) {
            return null;
        }
    }

    public static class b
    implements bfp,
    Serializable {
        protected final bgj var_bgj_a;
        protected final bfw var_bfw_a;
        protected final bgj b;
        protected final bgi var_bgi_a;
        protected final bmn var_bmn_a;

        public b(bgj bgj2, bfw bfw2, bgj bgj3, bmn bmn2, bgi bgi2) {
            this.var_bgj_a = bgj2;
            this.var_bfw_a = bfw2;
            this.b = bgj3;
            this.var_bgi_a = bgi2;
            this.var_bmn_a = bmn2;
        }

        @Override
        public bbk.d bbk$d_a(bhm<?> bhm2, Class<?> clazz) {
            bbk.d d2 = bhm2.bbk$d_a(clazz);
            bfn bfn2 = bhm2.bfn_a();
            if (bfn2 == null || this.var_bmn_a == null) {
                return d2;
            }
            Object object = bfn2.java_lang_Object_a((bmg)this.var_bmn_a);
            if (object == null) {
                return d2;
            }
            return d2.a((bbk.d)object);
        }

        @Override
        public bbr.b bbr$b_a(bhm<?> bhm2, Class<?> clazz) {
            bbr.b b2 = bhm2.a(clazz, (Class<?>)this.var_bfw_a.a());
            bfn bfn2 = bhm2.bfn_a();
            if (bfn2 == null || this.var_bmn_a == null) {
                return b2;
            }
            Object object = bfn2.java_lang_Object_a((bmg)this.var_bmn_a);
            if (object == null) {
                return b2;
            }
            return b2.a((bbr.b)object);
        }

        @Override
        public String java_lang_String_a() {
            return this.var_bgj_a.java_lang_String_a();
        }

        @Override
        public bgj bgj_a() {
            return this.var_bgj_a;
        }

        @Override
        public bfw bfw_a() {
            return this.var_bfw_a;
        }

        public bgj b() {
            return this.b;
        }

        @Override
        public bgi bgi_a() {
            return this.var_bgi_a;
        }

        @Override
        public bmn bmn_a() {
            return this.var_bmn_a;
        }
    }
}

