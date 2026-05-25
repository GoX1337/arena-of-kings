/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bbh {
    public a a() default a.DEFAULT;

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bbh$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        private static final /* synthetic */ a[] var_bbh$a_arr_a;

        public static a[] values() {
            return (a[])var_bbh$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bbh$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            var_bbh$a_arr_a = new a[]{var_bbh$a_a, b, c, d};
        }
    }
}

