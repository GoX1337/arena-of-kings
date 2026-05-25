/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bbr {
    public a a() default a.ALWAYS;

    public a b() default a.ALWAYS;

    public Class<?> a() default Void.class;

    public Class<?> b() default Void.class;

    public static class b
    implements Serializable {
        protected static final b var_bbr$b_a;
        protected final a var_bbr$a_a;
        protected final a var_bbr$a_b;
        protected final Class<?> var_java_lang_Class____a;
        protected final Class<?> var_java_lang_Class____b;

        protected b(a a2, a a3, Class<?> clazz, Class<?> clazz2) {
            this.var_bbr$a_a = a2 == null ? bbr$a.g : a2;
            this.var_bbr$a_b = a3 == null ? bbr$a.g : a3;
            this.var_bbr$b_a = clazz == Void.class ? null : clazz;
            this.var_bbr$a_b = clazz2 == Void.class ? null : clazz2;
        }

        public static b bbr$b_a() {
            return var_bbr$b_a;
        }

        public static b a(b b2, b b3) {
            return b2 == null ? b3 : b2.a(b3);
        }

        public static b a(b ... bArray) {
            b b2 = null;
            for (b b3 : bArray) {
                if (b3 == null) continue;
                b2 = b2 == null ? b3 : b2.a(b3);
            }
            return b2;
        }

        public b a(b b2) {
            boolean bl2;
            if (b2 == null || b2 == var_bbr$b_a) {
                return this;
            }
            a a2 = b2.var_bbr$a_a;
            a a3 = b2.var_bbr$a_b;
            b b3 = b2.var_bbr$b_a;
            a a4 = b2.var_bbr$a_b;
            boolean bl3 = a2 != this.var_bbr$a_a && a2 != bbr$a.g;
            boolean bl4 = a3 != this.var_bbr$a_b && a3 != bbr$a.g;
            boolean bl5 = bl2 = b3 != this.var_bbr$b_a || a4 != this.var_bbr$b_a;
            if (bl3) {
                if (bl4) {
                    return new b(a2, a3, (Class<?>)((Object)b3), (Class<?>)((Object)a4));
                }
                return new b(a2, this.var_bbr$a_b, (Class<?>)((Object)b3), (Class<?>)((Object)a4));
            }
            if (bl4) {
                return new b(this.var_bbr$a_a, a3, (Class<?>)((Object)b3), (Class<?>)((Object)a4));
            }
            if (bl2) {
                return new b(this.var_bbr$a_a, this.var_bbr$a_b, (Class<?>)((Object)b3), (Class<?>)((Object)a4));
            }
            return this;
        }

        public static b a(a a2, a a3) {
            if (!(a2 != bbr$a.g && a2 != null || a3 != bbr$a.g && a3 != null)) {
                return var_bbr$b_a;
            }
            return new b(a2, a3, null, null);
        }

        public static b a(a a2, a a3, Class<?> clazz, Class<?> clazz2) {
            if (clazz == Void.class) {
                clazz = null;
            }
            if (clazz2 == Void.class) {
                clazz2 = null;
            }
            if (!(a2 != bbr$a.g && a2 != null || a3 != bbr$a.g && a3 != null || clazz != null || clazz2 != null)) {
                return var_bbr$b_a;
            }
            return new b(a2, a3, clazz, clazz2);
        }

        public static b a(bbr bbr2) {
            Class<?> clazz;
            if (bbr2 == null) {
                return var_bbr$b_a;
            }
            a a2 = bbr2.a();
            a a3 = bbr2.b();
            if (a2 == bbr$a.g && a3 == bbr$a.g) {
                return var_bbr$b_a;
            }
            Class<?> clazz2 = bbr2.a();
            if (clazz2 == Void.class) {
                clazz2 = null;
            }
            if ((clazz = bbr2.b()) == Void.class) {
                clazz = null;
            }
            return new b(a2, a3, clazz2, clazz);
        }

        public b a(a a2) {
            return a2 == this.var_bbr$a_a ? this : new b(a2, this.var_bbr$a_b, (Class<?>)((Object)this.var_bbr$b_a), (Class<?>)((Object)this.var_bbr$a_b));
        }

        public b a(Class<?> clazz) {
            a a2;
            if (clazz == null || clazz == Void.class) {
                a2 = bbr$a.g;
                clazz = null;
            } else {
                a2 = bbr$a.f;
            }
            return bbr$b.a(this.var_bbr$a_a, a2, this.var_bbr$b_a, clazz);
        }

        public b b(a a2) {
            return a2 == this.var_bbr$a_b ? this : new b(this.var_bbr$a_a, a2, (Class<?>)((Object)this.var_bbr$b_a), (Class<?>)((Object)this.var_bbr$a_b));
        }

        public a bbr$a_a() {
            return this.var_bbr$a_a;
        }

        public a b() {
            return this.var_bbr$a_b;
        }

        public Class<?> a() {
            return this.var_bbr$b_a;
        }

        public Class<?> b() {
            return this.var_bbr$a_b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(80);
            stringBuilder.append("JsonInclude.Value(value=").append((Object)this.var_bbr$a_a).append(",content=").append((Object)this.var_bbr$a_b);
            if (this.var_bbr$b_a != null) {
                stringBuilder.append(",valueFilter=").append(((Class)((Object)this.var_bbr$b_a)).getName()).append(".class");
            }
            if (this.var_bbr$a_b != null) {
                stringBuilder.append(",contentFilter=").append(((Class)((Object)this.var_bbr$a_b)).getName()).append(".class");
            }
            return stringBuilder.append(')').toString();
        }

        public int hashCode() {
            return (this.var_bbr$a_a.hashCode() << 2) + this.var_bbr$a_b.hashCode();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (object.getClass() != this.getClass()) {
                return false;
            }
            b b2 = (b)object;
            return b2.var_bbr$a_a == this.var_bbr$a_a && b2.var_bbr$a_b == this.var_bbr$a_b && b2.var_bbr$b_a == this.var_bbr$b_a && b2.var_bbr$a_b == this.var_bbr$a_b;
        }

        static {
            var_bbr$b_a = new b(bbr$a.g, bbr$a.g, null, null);
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bbr$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        private static final /* synthetic */ a[] var_bbr$a_arr_a;

        public static a[] values() {
            return (a[])var_bbr$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bbr$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            f = new a();
            g = new a();
            var_bbr$a_arr_a = new a[]{var_bbr$a_a, b, c, d, e, f, g};
        }
    }
}

