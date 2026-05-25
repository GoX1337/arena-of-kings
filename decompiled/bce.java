/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bce {
    public b bce$b_a();

    public a bce$a_a() default a.PROPERTY;

    public String java_lang_String_a() default "";

    public Class<?> a() default bce.class;

    public boolean boolean_a() default false;

    @Deprecated
    public static abstract class c {
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bce$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        private static final /* synthetic */ a[] var_bce$a_arr_a;

        public static a[] values() {
            return (a[])var_bce$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bce$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            var_bce$a_arr_a = new a[]{var_bce$a_a, b, c, d, e};
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b var_bce$b_a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        private final String var_java_lang_String_a;
        private static final /* synthetic */ b[] var_bce$b_arr_a;

        public static b[] values() {
            return (b[])var_bce$b_arr_a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        private b(String string2) {
            this.var_java_lang_String_a = string2;
        }

        public String a() {
            return this.var_java_lang_String_a;
        }

        static {
            var_bce$b_a = new b(null);
            b = new b("@class");
            c = new b("@c");
            d = new b("@type");
            e = new b(null);
            f = new b(null);
            var_bce$b_arr_a = new b[]{var_bce$b_a, b, c, d, e, f};
        }
    }
}

