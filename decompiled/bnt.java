/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class bnt
extends bmn
implements Serializable {
    protected final Class<?> var_java_lang_Class____a;
    protected final bfw var_bfw_a;
    protected final String var_java_lang_String_a;

    public bnt(bns bns2, Class<?> clazz, String string, bfw bfw2) {
        super(bns2, null);
        this.var_java_lang_Class____a = clazz;
        this.var_bfw_a = bfw2;
        this.var_java_lang_String_a = string;
    }

    @Override
    public bmg a(bmu bmu2) {
        return this;
    }

    @Override
    public Field java_lang_reflect_Field_a() {
        return null;
    }

    @Override
    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
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
        return this.var_java_lang_Class____a;
    }

    @Override
    public Member java_lang_reflect_Member_a() {
        return null;
    }

    @Override
    public void a(Object object, Object object2) {
        throw new IllegalArgumentException("Cannot set virtual property '" + this.var_java_lang_String_a + "'");
    }

    @Override
    public Object b(Object object) {
        throw new IllegalArgumentException("Cannot get virtual property '" + this.var_java_lang_String_a + "'");
    }

    @Override
    public int hashCode() {
        return this.var_java_lang_String_a.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (buk.a(object, this.getClass()) == false) {
            return false;
        }
        bnt bnt2 = (bnt)object;
        return bnt2.var_java_lang_Class____a == this.var_java_lang_Class____a && bnt2.var_java_lang_String_a.equals(this.var_java_lang_String_a);
    }

    @Override
    public String toString() {
        return "[virtual " + this.java_lang_String_b() + "]";
    }
}

