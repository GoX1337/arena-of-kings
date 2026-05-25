/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bgu {
    public Class<? extends bgb> a() default bgb.a.class;

    public Class<? extends bgb> b() default bgb.a.class;

    public Class<? extends bgb> c() default bgb.a.class;

    public Class<? extends bgb> d() default bgb.a.class;

    public Class<?> e() default Void.class;

    public Class<?> f() default Void.class;

    public Class<?> g() default Void.class;

    public b bgu$b_a() default b.DEFAULT_TYPING;

    public Class<? extends bum> h() default bum.a.class;

    public Class<? extends bum> i() default bum.a.class;

    @Deprecated
    public a bgu$a_a() default a.DEFAULT_INCLUSION;

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b var_bgu$b_a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        private static final /* synthetic */ b[] var_bgu$b_arr_a;

        public static b[] values() {
            return (b[])var_bgu$b_arr_a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        static {
            var_bgu$b_a = new b();
            b = new b();
            c = new b();
            var_bgu$b_arr_a = new b[]{var_bgu$b_a, b, c};
        }
    }

    @Deprecated
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bgu$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        private static final /* synthetic */ a[] var_bgu$a_arr_a;

        public static a[] values() {
            return (a[])var_bgu$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bgu$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            var_bgu$a_arr_a = new a[]{var_bgu$a_a, b, c, d, e};
        }
    }
}

