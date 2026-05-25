/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bgq {
    public a[] bgq$a_arr_a() default {};

    public b[] bgq$b_arr_a() default {};

    public boolean boolean_a() default false;

    public static @interface b {
        public Class<? extends bqs> a();

        public String java_lang_String_a() default "";

        public String b() default "";

        public bbr.a bbr$a_a() default bbr.a.NON_NULL;

        public boolean boolean_a() default false;

        public Class<?> b() default Object.class;
    }

    public static @interface a {
        public String java_lang_String_a();

        public String b() default "";

        public String c() default "";

        public bbr.a bbr$a_a() default bbr.a.NON_NULL;

        public boolean boolean_a() default false;
    }
}

