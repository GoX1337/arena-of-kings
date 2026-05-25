/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bbe {
    public b a() default b.DEFAULT;

    public b b() default b.DEFAULT;

    public b c() default b.DEFAULT;

    public b d() default b.DEFAULT;

    public b e() default b.DEFAULT;

    public static class a
    implements Serializable {
        private static final b f = bbe$b.d;
        protected static final a var_bbe$a_a;
        protected static final a var_bbe$a_b;
        protected final b var_bbe$b_a;
        protected final b var_bbe$b_b;
        protected final b c;
        protected final b d;
        protected final b e;

        private a(b b2, b b3, b b4, b b5, b b6) {
            this.var_bbe$b_a = b2;
            this.var_bbe$b_b = b3;
            this.c = b4;
            this.d = b5;
            this.e = b6;
        }

        public b a() {
            return this.var_bbe$b_a;
        }

        public b b() {
            return this.var_bbe$b_b;
        }

        public b c() {
            return this.c;
        }

        public b d() {
            return this.d;
        }

        public b e() {
            return this.e;
        }

        public String toString() {
            return String.format("JsonAutoDetect.Value(fields=%s,getters=%s,isGetters=%s,setters=%s,creators=%s)", new Object[]{this.var_bbe$b_a, this.var_bbe$b_b, this.c, this.d, this.e});
        }

        public int hashCode() {
            return 1 + this.var_bbe$b_a.ordinal() ^ 3 * this.var_bbe$b_b.ordinal() - 7 * this.c.ordinal() + 11 * this.d.ordinal() ^ 13 * this.e.ordinal();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            return object.getClass() == this.getClass() && bbe$a.a(this, (a)object);
        }

        private static boolean a(a a2, a a3) {
            return a2.var_bbe$b_a == a3.var_bbe$b_a && a2.var_bbe$b_b == a3.var_bbe$b_b && a2.c == a3.c && a2.d == a3.d && a2.e == a3.e;
        }

        static {
            var_bbe$a_a = new a(f, bbe$b.d, bbe$b.d, bbe$b.var_bbe$b_a, bbe$b.d);
            var_bbe$a_b = new a(bbe$b.f, bbe$b.f, bbe$b.f, bbe$b.f, bbe$b.f);
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b var_bbe$b_a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        private static final /* synthetic */ b[] var_bbe$b_arr_a;

        public static b[] values() {
            return (b[])var_bbe$b_arr_a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        public boolean a(Member member) {
            switch (this) {
                case var_bbe$b_a: {
                    return true;
                }
                case e: {
                    return false;
                }
                case b: {
                    return !Modifier.isPrivate(member.getModifiers());
                }
                case c: {
                    if (Modifier.isProtected(member.getModifiers())) {
                        return true;
                    }
                }
                case d: {
                    return Modifier.isPublic(member.getModifiers());
                }
            }
            return false;
        }

        static {
            var_bbe$b_a = new b();
            b = new b();
            c = new b();
            d = new b();
            e = new b();
            f = new b();
            var_bbe$b_arr_a = new b[]{var_bbe$b_a, b, c, d, e, f};
        }
    }
}

