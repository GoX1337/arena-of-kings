/*
 * Decompiled with CFR 0.152.
 */
import java.lang.annotation.Annotation;
import java.util.HashMap;

public final class bmu
implements bud {
    protected HashMap<Class<?>, Annotation> a;

    public bmu() {
    }

    public static bmu a(Class<?> clazz, Annotation annotation) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(clazz, annotation);
        return new bmu(hashMap);
    }

    bmu(HashMap<Class<?>, Annotation> hashMap) {
        this.a = hashMap;
    }

    @Override
    public <A extends Annotation> A a(Class<A> clazz) {
        if (this.a == null) {
            return null;
        }
        return (A)this.a.get(clazz);
    }

    @Override
    public boolean a(Class<?> clazz) {
        if (this.a == null) {
            return false;
        }
        return this.a.containsKey(clazz);
    }

    @Override
    public boolean a(Class<? extends Annotation>[] classArray) {
        if (this.a != null) {
            int n2 = classArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!this.a.containsKey(classArray[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public static bmu a(bmu bmu2, bmu bmu3) {
        if (bmu2 == null || bmu2.a == null || bmu2.a.isEmpty()) {
            return bmu3;
        }
        if (bmu3 == null || bmu3.a == null || bmu3.a.isEmpty()) {
            return bmu2;
        }
        HashMap hashMap = new HashMap();
        for (Annotation annotation : bmu3.a.values()) {
            hashMap.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation : bmu2.a.values()) {
            hashMap.put(annotation.annotationType(), annotation);
        }
        return new bmu(hashMap);
    }

    @Override
    public int a() {
        return this.a == null ? 0 : this.a.size();
    }

    public boolean a(Annotation annotation) {
        return this.b(annotation);
    }

    public String toString() {
        if (this.a == null) {
            return "[null]";
        }
        return this.a.toString();
    }

    protected final boolean b(Annotation annotation) {
        Annotation annotation2;
        if (this.a == null) {
            this.a = new HashMap();
        }
        return (annotation2 = this.a.put(annotation.annotationType(), annotation)) == null || !annotation2.equals(annotation);
    }
}

