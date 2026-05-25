/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class bck<T>
implements Serializable {
    public abstract Class<?> a();

    public abstract boolean a(bck<?> var1);

    public boolean a() {
        return false;
    }

    public boolean a(String string, Object object) {
        return false;
    }

    public abstract bck<T> a(Class<?> var1);

    public abstract bck<T> a(Object var1);

    public abstract a a(Object var1);

    public abstract T a(Object var1);

    public static final class a
    implements Serializable {
        public final Class<?> var_java_lang_Class____a;
        public final Class<?> b;
        public final Object var_java_lang_Object_a;
        private final int var_int_a;

        public a(Class<?> clazz, Class<?> clazz2, Object object) {
            if (object == null) {
                throw new IllegalArgumentException("Can not construct IdKey for null key");
            }
            this.var_java_lang_Class____a = clazz;
            this.b = clazz2;
            this.var_java_lang_Object_a = object;
            int n2 = object.hashCode() + clazz.getName().hashCode();
            if (clazz2 != null) {
                n2 ^= clazz2.getName().hashCode();
            }
            this.var_int_a = n2;
        }

        public int hashCode() {
            return this.var_int_a;
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
            a a2 = (a)object;
            return a2.var_java_lang_Object_a.equals(this.var_java_lang_Object_a) && a2.var_java_lang_Class____a == this.var_java_lang_Class____a && a2.b == this.b;
        }

        public String toString() {
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", this.var_java_lang_Object_a, this.var_java_lang_Class____a == null ? "NONE" : this.var_java_lang_Class____a.getName(), this.b == null ? "NONE" : this.b.getName());
        }
    }
}

