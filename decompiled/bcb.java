/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bcb {
    public String java_lang_String_a() default "";

    public bcj bcj_a() default bcj.DEFAULT;

    public bcj b() default bcj.DEFAULT;

    public static class a
    implements Serializable {
        private final bcj var_bcj_a;
        private final bcj b;
        protected static final a var_bcb$a_a;

        protected a(bcj bcj2, bcj bcj3) {
            this.var_bcj_a = bcj2;
            this.b = bcj3;
        }

        public static a a(bcb bcb2) {
            if (bcb2 == null) {
                return var_bcb$a_a;
            }
            return bcb$a.bcb$a_a(bcb2.bcj_a(), bcb2.b());
        }

        public static a bcb$a_a(bcj bcj2, bcj bcj3) {
            if (bcj2 == null) {
                bcj2 = bcj.e;
            }
            if (bcj3 == null) {
                bcj3 = bcj.e;
            }
            if (bcb$a.boolean_a(bcj2, bcj3)) {
                return var_bcb$a_a;
            }
            return new a(bcj2, bcj3);
        }

        public static a bcb$a_a() {
            return var_bcb$a_a;
        }

        public bcj bcj_a() {
            return this.var_bcj_a == bcj.e ? null : this.var_bcj_a;
        }

        public bcj b() {
            return this.b == bcj.e ? null : this.b;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this.var_bcj_a, this.b});
        }

        public int hashCode() {
            return this.var_bcj_a.ordinal() + (this.b.ordinal() << 2);
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (object.getClass() == this.getClass()) {
                a a2 = (a)object;
                return a2.var_bcj_a == this.var_bcj_a && a2.b == this.b;
            }
            return false;
        }

        private static boolean boolean_a(bcj bcj2, bcj bcj3) {
            return bcj2 == bcj.e && bcj3 == bcj.e;
        }

        static {
            var_bcb$a_a = new a(bcj.e, bcj.e);
        }
    }
}

