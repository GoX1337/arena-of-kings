/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class bmo
extends bms
implements Serializable {
    protected final transient Method var_java_lang_reflect_Method_a;
    protected Class<?>[] var_java_lang_Class____arr_a;

    public bmo(bns bns2, Method method, bmu bmu2, bmu[] bmuArray) {
        super(bns2, bmu2, bmuArray);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.var_java_lang_reflect_Method_a = method;
    }

    @Override
    public bmo a(bmu bmu2) {
        return new bmo((bns)((Object)this.var_java_lang_reflect_Method_a), this.var_java_lang_reflect_Method_a, bmu2, (bmu[])this.var_java_lang_reflect_Method_a);
    }

    @Override
    public Method java_lang_reflect_Method_a() {
        return this.var_java_lang_reflect_Method_a;
    }

    @Override
    public String java_lang_String_a() {
        return this.var_java_lang_reflect_Method_a.getName();
    }

    @Override
    public bfw bfw_a() {
        return this.var_java_lang_reflect_Method_a.a(this.var_java_lang_reflect_Method_a.getGenericReturnType());
    }

    @Override
    public Class<?> a() {
        return this.var_java_lang_reflect_Method_a.getReturnType();
    }

    @Override
    public final Object java_lang_Object_a() {
        return this.var_java_lang_reflect_Method_a.invoke(null, new Object[0]);
    }

    @Override
    public final Object a(Object[] objectArray) {
        return this.var_java_lang_reflect_Method_a.invoke(null, objectArray);
    }

    @Override
    public final Object a(Object object) {
        return this.var_java_lang_reflect_Method_a.invoke(null, object);
    }

    public final Object a(Object object, Object ... objectArray) {
        return this.var_java_lang_reflect_Method_a.invoke(object, objectArray);
    }

    @Override
    public int int_a() {
        return this.java_lang_Class____arr_a().length;
    }

    @Override
    public Class<?> a(int n2) {
        Class<?>[] classArray = this.java_lang_Class____arr_a();
        return n2 >= classArray.length ? null : classArray[n2];
    }

    @Override
    public bfw bfw_a(int n2) {
        Type[] typeArray = this.var_java_lang_reflect_Method_a.getGenericParameterTypes();
        if (n2 >= typeArray.length) {
            return null;
        }
        return this.var_java_lang_reflect_Method_a.a(typeArray[n2]);
    }

    @Override
    public Class<?> b() {
        return this.var_java_lang_reflect_Method_a.getDeclaringClass();
    }

    public Method java_lang_reflect_Method_b() {
        return this.var_java_lang_reflect_Method_a;
    }

    @Override
    public void a(Object object, Object object2) {
        try {
            this.var_java_lang_reflect_Method_a.invoke(object, object2);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new IllegalArgumentException("Failed to setValue() with method " + this.java_lang_String_b() + ": " + reflectiveOperationException.getMessage(), reflectiveOperationException);
        }
    }

    @Override
    public Object b(Object object) {
        try {
            return this.var_java_lang_reflect_Method_a.invoke(object, (Object[])null);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new IllegalArgumentException("Failed to getValue() with method " + this.java_lang_String_b() + ": " + reflectiveOperationException.getMessage(), reflectiveOperationException);
        }
    }

    @Override
    public String java_lang_String_b() {
        String string = super.java_lang_String_b();
        switch (this.int_a()) {
            case 0: {
                return string + "()";
            }
            case 1: {
                return string + "(" + this.a(0).getName() + ")";
            }
        }
        return String.format("%s(%d params)", super.java_lang_String_b(), this.int_a());
    }

    public Class<?>[] java_lang_Class____arr_a() {
        if (this.var_java_lang_reflect_Method_a == null) {
            this.var_java_lang_reflect_Method_a = this.var_java_lang_reflect_Method_a.getParameterTypes();
        }
        return this.var_java_lang_reflect_Method_a;
    }

    public Class<?> c() {
        return this.var_java_lang_reflect_Method_a.getReturnType();
    }

    @Override
    public String toString() {
        return "[method " + this.java_lang_String_b() + "]";
    }

    @Override
    public int hashCode() {
        return this.var_java_lang_reflect_Method_a.getName().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return buk.a(object, this.getClass()) != false && ((bmo)object).var_java_lang_reflect_Method_a == this.var_java_lang_reflect_Method_a;
    }

    @Override
    public /* synthetic */ Member java_lang_reflect_Member_a() {
        return this.java_lang_reflect_Method_b();
    }
}

