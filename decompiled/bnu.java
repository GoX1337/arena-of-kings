/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public interface bnu<T extends bnu<T>> {
    public T a(bbe var1);

    public T a(bbe.a var1);

    public T a(bco var1, bbe.b var2);

    public T a(bbe.b var1);

    public T b(bbe.b var1);

    public T c(bbe.b var1);

    public T d(bbe.b var1);

    public T e(bbe.b var1);

    public boolean a(bmo var1);

    public boolean b(bmo var1);

    public boolean c(bmo var1);

    public boolean a(bmn var1);

    public boolean a(bml var1);

    public static class a
    implements bnu<a>,
    Serializable {
        protected static final a var_bnu$a_a;
        protected final bbe.b var_bbe$b_a;
        protected final bbe.b b;
        protected final bbe.b c;
        protected final bbe.b d;
        protected final bbe.b e;

        public static a a() {
            return var_bnu$a_a;
        }

        public a(bbe.b b2, bbe.b b3, bbe.b b4, bbe.b b5, bbe.b b6) {
            this.var_bbe$b_a = b2;
            this.b = b3;
            this.c = b4;
            this.d = b5;
            this.e = b6;
        }

        public a(bbe.b b2) {
            if (b2 == bbe.b.f) {
                this.var_bbe$b_a = bnu$a.var_bnu$a_a.var_bbe$b_a;
                this.b = bnu$a.var_bnu$a_a.b;
                this.c = bnu$a.var_bnu$a_a.c;
                this.d = bnu$a.var_bnu$a_a.d;
                this.e = bnu$a.var_bnu$a_a.e;
            } else {
                this.var_bbe$b_a = b2;
                this.b = b2;
                this.c = b2;
                this.d = b2;
                this.e = b2;
            }
        }

        protected a a(bbe.b b2, bbe.b b3, bbe.b b4, bbe.b b5, bbe.b b6) {
            if (b2 == this.var_bbe$b_a && b3 == this.b && b4 == this.c && b5 == this.d && b6 == this.e) {
                return this;
            }
            return new a(b2, b3, b4, b5, b6);
        }

        @Override
        public a a(bbe bbe2) {
            a a2 = this;
            if (bbe2 != null) {
                return this.a(this.a(this.var_bbe$b_a, bbe2.a()), this.a(this.b, bbe2.b()), this.a(this.c, bbe2.c()), this.a(this.d, bbe2.d()), this.a(this.e, bbe2.e()));
            }
            return a2;
        }

        @Override
        public a a(bbe.a a2) {
            a a3 = this;
            if (a2 != null) {
                return this.a(this.a(this.var_bbe$b_a, a2.b()), this.a(this.b, a2.c()), this.a(this.c, a2.d()), this.a(this.d, a2.e()), this.a(this.e, a2.a()));
            }
            return a3;
        }

        private bbe.b a(bbe.b b2, bbe.b b3) {
            if (b3 == bbe.b.f) {
                return b2;
            }
            return b3;
        }

        @Override
        public a bnu$a_a(bbe.b b2) {
            if (b2 == bbe.b.f) {
                return var_bnu$a_a;
            }
            return new a(b2);
        }

        @Override
        public a a(bco bco2, bbe.b b2) {
            switch (bco2) {
                case var_bco_a: {
                    return this.bnu$a_b(b2);
                }
                case b: {
                    return this.bnu$a_d(b2);
                }
                case c: {
                    return this.bnu$a_e(b2);
                }
                case d: {
                    return this.f(b2);
                }
                case e: {
                    return this.bnu$a_c(b2);
                }
                case g: {
                    return this.bnu$a_a(b2);
                }
            }
            return this;
        }

        @Override
        public a bnu$a_b(bbe.b b2) {
            if (b2 == bbe.b.f) {
                b2 = bnu$a.var_bnu$a_a.var_bbe$b_a;
            }
            if (this.var_bbe$b_a == b2) {
                return this;
            }
            return new a(b2, this.b, this.c, this.d, this.e);
        }

        @Override
        public a bnu$a_c(bbe.b b2) {
            if (b2 == bbe.b.f) {
                b2 = bnu$a.var_bnu$a_a.b;
            }
            if (this.b == b2) {
                return this;
            }
            return new a(this.var_bbe$b_a, b2, this.c, this.d, this.e);
        }

        @Override
        public a bnu$a_d(bbe.b b2) {
            if (b2 == bbe.b.f) {
                b2 = bnu$a.var_bnu$a_a.c;
            }
            if (this.c == b2) {
                return this;
            }
            return new a(this.var_bbe$b_a, this.b, b2, this.d, this.e);
        }

        @Override
        public a bnu$a_e(bbe.b b2) {
            if (b2 == bbe.b.f) {
                b2 = bnu$a.var_bnu$a_a.d;
            }
            if (this.d == b2) {
                return this;
            }
            return new a(this.var_bbe$b_a, this.b, this.c, b2, this.e);
        }

        public a f(bbe.b b2) {
            if (b2 == bbe.b.f) {
                b2 = bnu$a.var_bnu$a_a.e;
            }
            if (this.e == b2) {
                return this;
            }
            return new a(this.var_bbe$b_a, this.b, this.c, this.d, b2);
        }

        public boolean a(Member member) {
            return this.d.a(member);
        }

        @Override
        public boolean a(bmn bmn2) {
            return this.a(bmn2.java_lang_reflect_Member_a());
        }

        public boolean a(Field field) {
            return this.e.a(field);
        }

        @Override
        public boolean a(bml bml2) {
            return this.a(bml2.java_lang_reflect_Field_a());
        }

        public boolean a(Method method) {
            return this.var_bbe$b_a.a(method);
        }

        @Override
        public boolean a(bmo bmo2) {
            return this.a(bmo2.java_lang_reflect_Method_a());
        }

        public boolean b(Method method) {
            return this.b.a(method);
        }

        @Override
        public boolean b(bmo bmo2) {
            return this.b(bmo2.java_lang_reflect_Method_a());
        }

        public boolean c(Method method) {
            return this.c.a(method);
        }

        @Override
        public boolean c(bmo bmo2) {
            return this.c(bmo2.java_lang_reflect_Method_a());
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", new Object[]{this.var_bbe$b_a, this.b, this.c, this.d, this.e});
        }

        @Override
        public /* synthetic */ bnu bnu_e(bbe.b b2) {
            return this.f(b2);
        }

        @Override
        public /* synthetic */ bnu bnu_d(bbe.b b2) {
            return this.bnu$a_e(b2);
        }

        @Override
        public /* synthetic */ bnu bnu_c(bbe.b b2) {
            return this.bnu$a_d(b2);
        }

        @Override
        public /* synthetic */ bnu bnu_b(bbe.b b2) {
            return this.bnu$a_c(b2);
        }

        @Override
        public /* synthetic */ bnu bnu_a(bbe.b b2) {
            return this.bnu$a_b(b2);
        }

        static {
            var_bnu$a_a = new a(bbe.b.d, bbe.b.d, bbe.b.var_bbe$b_a, bbe.b.var_bbe$b_a, bbe.b.d);
        }
    }
}

