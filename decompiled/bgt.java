/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bgt {
    public String a() default "build";

    public String b() default "with";

    public static class a {
        public final String a;
        public final String b;

        public a(bgt bgt2) {
            this(bgt2.a(), bgt2.b());
        }

        public a(String string, String string2) {
            this.a = string;
            this.b = string2;
        }
    }
}

