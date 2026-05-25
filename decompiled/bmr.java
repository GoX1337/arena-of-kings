/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

public final class bmr
extends bmn {
    protected final bms var_bms_a;
    protected final bfw var_bfw_a;
    protected final int var_int_a;

    public bmr(bms bms2, bfw bfw2, bns bns2, bmu bmu2, int n2) {
        super(bns2, bmu2);
        this.var_bms_a = bms2;
        this.var_bfw_a = bfw2;
        this.var_int_a = n2;
    }

    @Override
    public bmr a(bmu bmu2) {
        if (bmu2 == this.var_bms_a) {
            return this;
        }
        return this.var_bms_a.a(this.var_int_a, bmu2);
    }

    @Override
    public AnnotatedElement java_lang_reflect_AnnotatedElement_a() {
        return null;
    }

    @Override
    public String java_lang_String_a() {
        return "";
    }

    @Override
    public Class<?> a() {
        return this.var_bfw_a.a();
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    @Override
    public Class<?> b() {
        return this.var_bms_a.b();
    }

    @Override
    public Member java_lang_reflect_Member_a() {
        return this.var_bms_a.java_lang_Object_a();
    }

    @Override
    public void a(Object object, Object object2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + this.b().getName());
    }

    @Override
    public Object b(Object object) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + this.b().getName());
    }

    public bms bms_a() {
        return this.var_bms_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    @Override
    public int hashCode() {
        return this.var_bms_a.hashCode() + this.var_int_a;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (buk.a(object, this.getClass()) == false) {
            return false;
        }
        bmr bmr2 = (bmr)object;
        return bmr2.var_bms_a.equals(this.var_bms_a) && bmr2.var_int_a == this.var_int_a;
    }

    @Override
    public String toString() {
        return "[parameter #" + this.int_a() + ", annotations: " + this.var_bms_a + "]";
    }
}

