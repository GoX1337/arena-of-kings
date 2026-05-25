/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class bmt {
    protected static final bud var_bud_a;
    protected final Object var_java_lang_Object_a;

    protected bmt(Object object) {
        this.var_java_lang_Object_a = object;
    }

    public static bud bmu_a() {
        return var_bud_a;
    }

    public static bmt bmt_a() {
        return bmt$a.a;
    }

    public abstract bud b();

    public abstract bmu bmu_a();

    public abstract boolean boolean_a(Annotation var1);

    public abstract bmt bmt_a(Annotation var1);

    static {
        var_bud_a = new c();
    }

    public static class f
    implements bud,
    Serializable {
        private final Class<?> var_java_lang_Class____a;
        private final Class<?> var_java_lang_Class____b;
        private final Annotation var_java_lang_annotation_Annotation_a;
        private final Annotation var_java_lang_annotation_Annotation_b;

        public f(Class<?> clazz, Annotation annotation, Class<?> clazz2, Annotation annotation2) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_annotation_Annotation_a = annotation;
            this.var_java_lang_Class____b = clazz2;
            this.var_java_lang_annotation_Annotation_b = annotation2;
        }

        @Override
        public <A extends Annotation> A a(Class<A> clazz) {
            if (this.var_java_lang_Class____a == clazz) {
                return (A)this.var_java_lang_annotation_Annotation_a;
            }
            if (this.var_java_lang_Class____b == clazz) {
                return (A)this.var_java_lang_annotation_Annotation_b;
            }
            return null;
        }

        @Override
        public boolean a(Class<?> clazz) {
            return this.var_java_lang_Class____a == clazz || this.var_java_lang_Class____b == clazz;
        }

        @Override
        public boolean a(Class<? extends Annotation>[] classArray) {
            for (Class<? extends Annotation> clazz : classArray) {
                if (clazz != this.var_java_lang_Class____a && clazz != this.var_java_lang_Class____b) continue;
                return true;
            }
            return false;
        }

        @Override
        public int a() {
            return 2;
        }
    }

    public static class d
    implements bud,
    Serializable {
        private final Class<?> var_java_lang_Class____a;
        private final Annotation var_java_lang_annotation_Annotation_a;

        public d(Class<?> clazz, Annotation annotation) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_annotation_Annotation_a = annotation;
        }

        @Override
        public <A extends Annotation> A a(Class<A> clazz) {
            if (this.var_java_lang_Class____a == clazz) {
                return (A)this.var_java_lang_annotation_Annotation_a;
            }
            return null;
        }

        @Override
        public boolean a(Class<?> clazz) {
            return this.var_java_lang_Class____a == clazz;
        }

        @Override
        public boolean a(Class<? extends Annotation>[] classArray) {
            for (Class<? extends Annotation> clazz : classArray) {
                if (clazz != this.var_java_lang_Class____a) continue;
                return true;
            }
            return false;
        }

        @Override
        public int a() {
            return 1;
        }
    }

    public static class c
    implements bud,
    Serializable {
        c() {
        }

        @Override
        public <A extends Annotation> A a(Class<A> clazz) {
            return null;
        }

        @Override
        public boolean a(Class<?> clazz) {
            return false;
        }

        @Override
        public boolean a(Class<? extends Annotation>[] classArray) {
            return false;
        }

        @Override
        public int a() {
            return 0;
        }
    }

    static class b
    extends bmt {
        protected final HashMap<Class<?>, Annotation> a = new HashMap();

        public b(Object object, Class<?> clazz, Annotation annotation, Class<?> clazz2, Annotation annotation2) {
            super(object);
            this.a.put(clazz, annotation);
            this.a.put(clazz2, annotation2);
        }

        @Override
        public bud b() {
            if (this.a.size() == 2) {
                Iterator<Map.Entry<Class<?>, Annotation>> iterator = this.a.entrySet().iterator();
                Map.Entry<Class<?>, Annotation> entry = iterator.next();
                Map.Entry<Class<?>, Annotation> entry2 = iterator.next();
                return new f(entry.getKey(), entry.getValue(), entry2.getKey(), entry2.getValue());
            }
            return new bmu(this.a);
        }

        @Override
        public bmu bmu_a() {
            bmu bmu2 = new bmu();
            for (Annotation annotation : this.a.values()) {
                bmu2.a(annotation);
            }
            return bmu2;
        }

        @Override
        public boolean boolean_a(Annotation annotation) {
            return this.a.containsKey(annotation.annotationType());
        }

        @Override
        public bmt bmt_a(Annotation annotation) {
            this.a.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    static class e
    extends bmt {
        private Class<?> var_java_lang_Class____a;
        private Annotation var_java_lang_annotation_Annotation_a;

        public e(Object object, Class<?> clazz, Annotation annotation) {
            super(object);
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_annotation_Annotation_a = annotation;
        }

        @Override
        public bud b() {
            return new d(this.var_java_lang_Class____a, this.var_java_lang_annotation_Annotation_a);
        }

        @Override
        public bmu bmu_a() {
            return bmu.a(this.var_java_lang_Class____a, this.var_java_lang_annotation_Annotation_a);
        }

        @Override
        public boolean boolean_a(Annotation annotation) {
            return annotation.annotationType() == this.var_java_lang_Class____a;
        }

        @Override
        public bmt bmt_a(Annotation annotation) {
            Class<? extends Annotation> clazz = annotation.annotationType();
            if (this.var_java_lang_Class____a == clazz) {
                this.var_java_lang_annotation_Annotation_a = annotation;
                return this;
            }
            return new b(this.var_java_lang_Class____a, this.var_java_lang_Class____a, this.var_java_lang_annotation_Annotation_a, clazz, annotation);
        }
    }

    static class a
    extends bmt {
        public static final a a = new a(null);

        a(Object object) {
            super(object);
        }

        @Override
        public bud b() {
            return a;
        }

        @Override
        public bmu bmu_a() {
            return new bmu();
        }

        @Override
        public boolean boolean_a(Annotation annotation) {
            return false;
        }

        @Override
        public bmt bmt_a(Annotation annotation) {
            return new e(this.a, annotation.annotationType(), annotation);
        }
    }
}

