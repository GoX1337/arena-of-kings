/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class bmj
extends bms {
    protected final Constructor<?> a;

    public bmj(bns bns2, Constructor<?> constructor, bmu bmu2, bmu[] bmuArray) {
        super(bns2, bmu2, bmuArray);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.a = constructor;
    }

    @Override
    public bmj a(bmu bmu2) {
        return new bmj((bns)((Object)this.a), this.a, bmu2, (bmu[])this.a);
    }

    @Override
    public Constructor<?> a() {
        return this.a;
    }

    @Override
    public String java_lang_String_a() {
        return this.a.getName();
    }

    @Override
    public bfw bfw_a() {
        return this.a.a((Type)this.java_lang_Object_a());
    }

    @Override
    public Class<?> a() {
        return this.a.getDeclaringClass();
    }

    @Override
    public int int_a() {
        return this.a.getParameterTypes().length;
    }

    @Override
    public Class<?> a(int n2) {
        Class<?>[] classArray = this.a.getParameterTypes();
        return n2 >= classArray.length ? null : classArray[n2];
    }

    @Override
    public bfw bfw_a(int n2) {
        Type[] typeArray = this.a.getGenericParameterTypes();
        if (n2 >= typeArray.length) {
            return null;
        }
        return this.a.a(typeArray[n2]);
    }

    @Override
    public final Object java_lang_Object_a() {
        return this.a.newInstance(new Object[0]);
    }

    @Override
    public final Object a(Object[] objectArray) {
        return this.a.newInstance(objectArray);
    }

    @Override
    public final Object a(Object object) {
        return this.a.newInstance(object);
    }

    @Override
    public Class<?> b() {
        return this.a.getDeclaringClass();
    }

    @Override
    public Member java_lang_reflect_Member_a() {
        return this.a;
    }

    @Override
    public void a(Object object, Object object2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + this.b().getName());
    }

    @Override
    public Object b(Object object) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + this.b().getName());
    }

    @Override
    public String toString() {
        int n2 = this.a.getParameterTypes().length;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", buk.java_lang_String_b(this.a.getDeclaringClass()), n2, n2 == 1 ? "" : "s", this.a);
    }

    @Override
    public int hashCode() {
        return this.a.getName().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return buk.a(object, this.getClass()) != false && ((bmj)object).a == this.a;
    }
}

