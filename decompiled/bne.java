/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class bne {
    static final Class<?>[] var_java_lang_Class____arr_a;
    final String var_java_lang_String_a;
    final Class<?>[] b;

    public bne(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public bne(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public bne(String string, Class<?>[] classArray) {
        this.var_java_lang_String_a = string;
        this.b = classArray == null ? var_java_lang_Class____arr_a : classArray;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public int int_a() {
        return this.b.length;
    }

    public String toString() {
        return this.var_java_lang_String_a + "(" + this.b.length + "-args)";
    }

    public int hashCode() {
        return this.var_java_lang_String_a.hashCode() + this.b.length;
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
        bne bne2 = (bne)object;
        if (!this.var_java_lang_String_a.equals(bne2.var_java_lang_String_a)) {
            return false;
        }
        Class<?>[] classArray = bne2.b;
        int n2 = this.b.length;
        if (classArray.length != n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            Class<?> clazz = classArray[i2];
            Class<?> clazz2 = this.b[i2];
            if (clazz == clazz2) continue;
            return false;
        }
        return true;
    }

    static {
        var_java_lang_Class____arr_a = new Class[0];
    }
}

