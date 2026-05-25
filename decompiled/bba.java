/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bba {
    public String java_lang_String_a() default "";

    public bcn bcn_a() default bcn.DEFAULT;

    public static class a
    implements Serializable {
        protected static final a var_bba$a_a;
        protected final Object var_java_lang_Object_a;
        protected final Boolean var_java_lang_Boolean_a;

        protected a(Object object, Boolean bl2) {
            this.var_java_lang_Object_a = object;
            this.var_java_lang_Boolean_a = bl2;
        }

        public static a bba$a_a(Object object, Boolean bl2) {
            if ("".equals(object)) {
                object = null;
            }
            if (bba$a.boolean_a(object, bl2)) {
                return var_bba$a_a;
            }
            return new a(object, bl2);
        }

        public static a a(bba bba2) {
            if (bba2 == null) {
                return var_bba$a_a;
            }
            return bba$a.bba$a_a(bba2.java_lang_String_a(), bba2.bcn_a().a());
        }

        public static a a(Object object) {
            return bba$a.bba$a_a(object, null);
        }

        public a b(Object object) {
            if (object == null ? this.var_java_lang_Object_a == null : object.equals(this.var_java_lang_Object_a)) {
                return this;
            }
            return new a(object, this.var_java_lang_Boolean_a);
        }

        public Object java_lang_Object_a() {
            return this.var_java_lang_Object_a;
        }

        public boolean boolean_a() {
            return this.var_java_lang_Object_a != null;
        }

        public boolean a(boolean bl2) {
            return this.var_java_lang_Boolean_a == null ? bl2 : this.var_java_lang_Boolean_a;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.var_java_lang_Object_a, this.var_java_lang_Boolean_a);
        }

        public int hashCode() {
            int n2 = 1;
            if (this.var_java_lang_Object_a != null) {
                n2 += this.var_java_lang_Object_a.hashCode();
            }
            if (this.var_java_lang_Boolean_a != null) {
                n2 += this.var_java_lang_Boolean_a.hashCode();
            }
            return n2;
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
                if (bcn.a(this.var_java_lang_Boolean_a, a2.var_java_lang_Boolean_a)) {
                    if (this.var_java_lang_Object_a == null) {
                        return a2.var_java_lang_Object_a == null;
                    }
                    return this.var_java_lang_Object_a.equals(a2.var_java_lang_Object_a);
                }
            }
            return false;
        }

        private static boolean boolean_a(Object object, Boolean bl2) {
            return object == null && bl2 == null;
        }

        static {
            var_bba$a_a = new a(null, null);
        }
    }
}

