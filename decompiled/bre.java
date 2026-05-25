/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public abstract class bre {
    protected final boolean a;

    protected bre(boolean bl2) {
        this.a = bl2;
    }

    protected bre(bre bre2) {
        this.a = bre2.a;
    }

    public abstract bgb<Object> a(Class<?> var1);

    public final d a(Class<?> clazz, bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = bgo2.b(clazz, bfp2);
        return new d(bgb2, this.bre_a(clazz, bgb2));
    }

    public final d a(bfw bfw2, bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = bgo2.b(bfw2, bfp2);
        return new d(bgb2, this.bre_a((Class<?>)bfw2.a(), bgb2));
    }

    public final d b(Class<?> clazz, bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = bgo2.c(clazz, bfp2);
        return new d(bgb2, this.bre_a(clazz, bgb2));
    }

    public final d b(bfw bfw2, bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = bgo2.c(bfw2, bfp2);
        return new d(bgb2, this.bre_a((Class<?>)bfw2.a(), bgb2));
    }

    public final d c(Class<?> clazz, bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2 = bgo2.d(clazz, bfp2);
        return new d(bgb2, this.bre_a(clazz, bgb2));
    }

    public final d bre$d_a(Class<?> clazz, bgb<Object> bgb2) {
        return new d(bgb2, this.bre_a(clazz, bgb2));
    }

    public final d a(bfw bfw2, bgb<Object> bgb2) {
        return new d(bgb2, this.bre_a((Class<?>)bfw2.a(), bgb2));
    }

    public abstract bre bre_a(Class<?> var1, bgb<Object> var2);

    public static bre a() {
        return b.a;
    }

    static final class c
    extends bre {
        private final f[] a;

        public c(bre bre2, f[] fArray) {
            super(bre2);
            this.a = fArray;
        }

        @Override
        public bgb<Object> a(Class<?> clazz) {
            f f2 = this.a[0];
            if (f2.var_java_lang_Class____a == clazz) {
                return f2.var_java_lang_Class____a;
            }
            f2 = this.a[1];
            if (f2.var_java_lang_Class____a == clazz) {
                return f2.var_java_lang_Class____a;
            }
            f2 = this.a[2];
            if (f2.var_java_lang_Class____a == clazz) {
                return f2.var_java_lang_Class____a;
            }
            switch (this.a.length) {
                case 8: {
                    f2 = this.a[7];
                    if (f2.var_java_lang_Class____a == clazz) {
                        return f2.var_java_lang_Class____a;
                    }
                }
                case 7: {
                    f2 = this.a[6];
                    if (f2.var_java_lang_Class____a == clazz) {
                        return f2.var_java_lang_Class____a;
                    }
                }
                case 6: {
                    f2 = this.a[5];
                    if (f2.var_java_lang_Class____a == clazz) {
                        return f2.var_java_lang_Class____a;
                    }
                }
                case 5: {
                    f2 = this.a[4];
                    if (f2.var_java_lang_Class____a == clazz) {
                        return f2.var_java_lang_Class____a;
                    }
                }
                case 4: {
                    f2 = this.a[3];
                    if (f2.var_java_lang_Class____a != clazz) break;
                    return f2.var_java_lang_Class____a;
                }
            }
            return null;
        }

        @Override
        public bre bre_a(Class<?> clazz, bgb<Object> bgb2) {
            int n2 = this.a.length;
            if (n2 == 8) {
                if (this.a != false) {
                    return new e(this, clazz, bgb2);
                }
                return this;
            }
            f[] fArray = Arrays.copyOf(this.a, n2 + 1);
            fArray[n2] = new f(clazz, bgb2);
            return new c(this, fArray);
        }
    }

    static final class a
    extends bre {
        private final Class<?> var_java_lang_Class____a;
        private final Class<?> var_java_lang_Class____b;
        private final bgb<Object> var_bgb_java_lang_Object__a;
        private final bgb<Object> var_bgb_java_lang_Object__b;

        public a(bre bre2, Class<?> clazz, bgb<Object> bgb2, Class<?> clazz2, bgb<Object> bgb3) {
            super(bre2);
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = bgb2;
            this.var_java_lang_Class____b = clazz2;
            this.var_java_lang_Class____b = bgb3;
        }

        @Override
        public bgb<Object> a(Class<?> clazz) {
            if (clazz == this.var_java_lang_Class____a) {
                return this.var_java_lang_Class____a;
            }
            if (clazz == this.var_java_lang_Class____b) {
                return this.var_java_lang_Class____b;
            }
            return null;
        }

        @Override
        public bre bre_a(Class<?> clazz, bgb<Object> bgb2) {
            f[] fArray = new f[]{new f(this.var_java_lang_Class____a, (bgb<Object>)((Object)this.var_java_lang_Class____a)), new f(this.var_java_lang_Class____b, (bgb<Object>)((Object)this.var_java_lang_Class____b)), new f(clazz, bgb2)};
            return new c(this, fArray);
        }
    }

    static final class e
    extends bre {
        private final Class<?> var_java_lang_Class____a;
        private final bgb<Object> var_bgb_java_lang_Object__a;

        public e(bre bre2, Class<?> clazz, bgb<Object> bgb2) {
            super(bre2);
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = bgb2;
        }

        @Override
        public bgb<Object> a(Class<?> clazz) {
            if (clazz == this.var_java_lang_Class____a) {
                return this.var_java_lang_Class____a;
            }
            return null;
        }

        @Override
        public bre bre_a(Class<?> clazz, bgb<Object> bgb2) {
            return new a(this, this.var_java_lang_Class____a, (bgb<Object>)((Object)this.var_java_lang_Class____a), clazz, bgb2);
        }
    }

    static final class b
    extends bre {
        public static final b a = new b(false);
        public static final b b = new b(true);

        protected b(boolean bl2) {
            super(bl2);
        }

        @Override
        public bgb<Object> a(Class<?> clazz) {
            return null;
        }

        @Override
        public bre bre_a(Class<?> clazz, bgb<Object> bgb2) {
            return new e(this, clazz, bgb2);
        }
    }

    static final class f {
        public final Class<?> var_java_lang_Class____a;
        public final bgb<Object> var_bgb_java_lang_Object__a;

        public f(Class<?> clazz, bgb<Object> bgb2) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = bgb2;
        }
    }

    public static final class d {
        public final bgb<Object> var_bgb_java_lang_Object__a;
        public final bre var_bre_a;

        public d(bgb<Object> bgb2, bre bre2) {
            this.var_bgb_java_lang_Object__a = bgb2;
            this.var_bre_a = bre2;
        }
    }
}

