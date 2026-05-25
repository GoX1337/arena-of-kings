/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class bml
extends bmn
implements Serializable {
    protected final transient Field a;

    public bml(bns bns2, Field field, bmu bmu2) {
        super(bns2, bmu2);
        this.a = field;
    }

    @Override
    public bml a(bmu bmu2) {
        return new bml((bns)((Object)this.a), this.a, bmu2);
    }

    @Override
    public Field java_lang_reflect_Field_a() {
        return this.a;
    }

    public int int_a() {
        return this.a.getModifiers();
    }

    @Override
    public String java_lang_String_a() {
        return this.a.getName();
    }

    @Override
    public Class<?> a() {
        return this.a.getType();
    }

    @Override
    public bfw bfw_a() {
        return this.a.a(this.a.getGenericType());
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
        try {
            this.a.set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalArgumentException("Failed to setValue() for field " + this.java_lang_String_b() + ": " + illegalAccessException.getMessage(), illegalAccessException);
        }
    }

    @Override
    public Object b(Object object) {
        try {
            return this.a.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalArgumentException("Failed to getValue() for field " + this.java_lang_String_b() + ": " + illegalAccessException.getMessage(), illegalAccessException);
        }
    }

    public boolean boolean_a() {
        return Modifier.isTransient(this.int_a());
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
        return buk.a(object, this.getClass()) != false && ((bml)object).a == this.a;
    }

    @Override
    public String toString() {
        return "[field " + this.java_lang_String_b() + "]";
    }
}

