/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class bty
implements Serializable {
    private static final String[] var_java_lang_String_arr_a;
    private static final bfw[] var_bfw_arr_a;
    private static final bty var_bty_a;
    private final String[] var_java_lang_String_arr_b;
    private final bfw[] var_bfw_arr_b;
    private final String[] c;
    private final int var_int_a;

    private bty(String[] stringArray, bfw[] bfwArray, String[] stringArray2) {
        this.var_java_lang_String_arr_b = stringArray == null ? var_java_lang_String_arr_a : stringArray;
        bfw[] bfwArray2 = this.var_bfw_arr_b = bfwArray == null ? var_bfw_arr_a : bfwArray;
        if (this.var_java_lang_String_arr_b.length != this.var_bfw_arr_b.length) {
            throw new IllegalArgumentException("Mismatching names (" + this.var_java_lang_String_arr_b.length + "), types (" + this.var_bfw_arr_b.length + ")");
        }
        int n2 = 1;
        int n3 = this.var_bfw_arr_b.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 += this.var_bfw_arr_b[i2].hashCode();
        }
        this.c = stringArray2;
        this.var_int_a = n2;
    }

    public static bty bty_a() {
        return var_bty_a;
    }

    public static bty a(Class<?> clazz, List<bfw> list) {
        bfw[] bfwArray = list == null || list.isEmpty() ? var_bfw_arr_a : list.toArray(var_bfw_arr_a);
        return bty.a(clazz, bfwArray);
    }

    public static bty a(Class<?> clazz, bfw[] bfwArray) {
        String[] stringArray;
        if (bfwArray == null) {
            bfwArray = var_bfw_arr_a;
        } else {
            switch (bfwArray.length) {
                case 1: {
                    return bty.a(clazz, bfwArray[0]);
                }
                case 2: {
                    return bty.a(clazz, bfwArray[0], bfwArray[1]);
                }
            }
        }
        TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
        if (typeVariableArray == null || typeVariableArray.length == 0) {
            stringArray = var_java_lang_String_arr_a;
        } else {
            int n2 = typeVariableArray.length;
            stringArray = new String[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                stringArray[i2] = typeVariableArray[i2].getName();
            }
        }
        if (stringArray.length != bfwArray.length) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + clazz.getName() + " with " + bfwArray.length + " type parameter" + (bfwArray.length == 1 ? "" : "s") + ": class expects " + stringArray.length);
        }
        return new bty(stringArray, bfwArray, null);
    }

    public static bty a(Class<?> clazz, bfw bfw2) {
        int n2;
        TypeVariable<?>[] typeVariableArray = bty$b.a(clazz);
        int n3 = n2 = typeVariableArray == null ? 0 : typeVariableArray.length;
        if (n2 != 1) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + clazz.getName() + " with 1 type parameter: class expects " + n2);
        }
        return new bty(new String[]{typeVariableArray[0].getName()}, new bfw[]{bfw2}, null);
    }

    public static bty a(Class<?> clazz, bfw bfw2, bfw bfw3) {
        int n2;
        TypeVariable<?>[] typeVariableArray = bty$b.b(clazz);
        int n3 = n2 = typeVariableArray == null ? 0 : typeVariableArray.length;
        if (n2 != 2) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + clazz.getName() + " with 2 type parameters: class expects " + n2);
        }
        return new bty(new String[]{typeVariableArray[0].getName(), typeVariableArray[1].getName()}, new bfw[]{bfw2, bfw3}, null);
    }

    public static bty a(List<String> list, List<bfw> list2) {
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return var_bty_a;
        }
        return new bty(list.toArray(var_java_lang_String_arr_a), list2.toArray(var_bfw_arr_a), null);
    }

    public static bty b(Class<?> clazz, bfw bfw2) {
        int n2;
        TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
        int n3 = n2 = typeVariableArray == null ? 0 : typeVariableArray.length;
        if (n2 == 0) {
            return var_bty_a;
        }
        if (n2 != 1) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + clazz.getName() + " with 1 type parameter: class expects " + n2);
        }
        return new bty(new String[]{typeVariableArray[0].getName()}, new bfw[]{bfw2}, null);
    }

    public static bty b(Class<?> clazz, bfw[] bfwArray) {
        TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
        if (typeVariableArray == null || typeVariableArray.length == 0) {
            return var_bty_a;
        }
        if (bfwArray == null) {
            bfwArray = var_bfw_arr_a;
        }
        int n2 = typeVariableArray.length;
        String[] stringArray = new String[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            stringArray[i2] = typeVariableArray[i2].getName();
        }
        if (stringArray.length != bfwArray.length) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + clazz.getName() + " with " + bfwArray.length + " type parameter" + (bfwArray.length == 1 ? "" : "s") + ": class expects " + stringArray.length);
        }
        return new bty(stringArray, bfwArray, null);
    }

    public bty bty_a(String string) {
        int n2 = this.c == null ? 0 : this.c.length;
        String[] stringArray = n2 == 0 ? new String[1] : Arrays.copyOf(this.c, n2 + 1);
        stringArray[n2] = string;
        return new bty(this.var_java_lang_String_arr_b, this.var_bfw_arr_b, stringArray);
    }

    public bfw bfw_a(String string) {
        int n2 = this.var_java_lang_String_arr_b.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            btv btv2;
            bfw bfw2;
            if (!string.equals(this.var_java_lang_String_arr_b[i2])) continue;
            bfw bfw3 = this.var_bfw_arr_b[i2];
            if (bfw3 instanceof btv && (bfw2 = (btv2 = (btv)bfw3).bfw_f()) != null) {
                bfw3 = bfw2;
            }
            return bfw3;
        }
        return null;
    }

    public boolean boolean_a() {
        return this.var_bfw_arr_b.length == 0;
    }

    public int int_a() {
        return this.var_bfw_arr_b.length;
    }

    public bfw a(int n2) {
        if (n2 < 0 || n2 >= this.var_bfw_arr_b.length) {
            return null;
        }
        return this.var_bfw_arr_b[n2];
    }

    public List<bfw> a() {
        if (this.var_bfw_arr_b.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(this.var_bfw_arr_b);
    }

    public boolean boolean_a(String string) {
        if (this.c != null) {
            int n2 = this.c.length;
            while (--n2 >= 0) {
                if (!string.equals(this.c[n2])) continue;
                return true;
            }
        }
        return false;
    }

    public Object a(Class<?> clazz) {
        return new a(clazz, this.var_bfw_arr_b, this.var_int_a);
    }

    public String toString() {
        if (this.var_bfw_arr_b.length == 0) {
            return "<>";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('<');
        int n2 = this.var_bfw_arr_b.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(',');
            }
            String string = this.var_bfw_arr_b[i2].java_lang_String_b();
            stringBuilder.append(string);
        }
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.var_int_a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (buk.a(object, this.getClass()) == false) {
            return false;
        }
        int n2 = this.var_bfw_arr_b.length;
        bty bty2 = (bty)object;
        if (n2 != bty2.int_a()) {
            return false;
        }
        bfw[] bfwArray = bty2.var_bfw_arr_b;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (bfwArray[i2].equals(this.var_bfw_arr_b[i2])) continue;
            return false;
        }
        return true;
    }

    protected bfw[] bfw_arr_a() {
        return this.var_bfw_arr_b;
    }

    static {
        var_java_lang_String_arr_a = new String[0];
        var_bfw_arr_a = new bfw[0];
        var_bty_a = new bty(var_java_lang_String_arr_a, var_bfw_arr_a, null);
    }

    static final class a {
        private final Class<?> var_java_lang_Class____a;
        private final bfw[] var_bfw_arr_a;
        private final int var_int_a;

        public a(Class<?> clazz, bfw[] bfwArray, int n2) {
            this.var_java_lang_Class____a = clazz;
            this.var_bfw_arr_a = bfwArray;
            this.var_int_a = n2;
        }

        public int hashCode() {
            return this.var_int_a;
        }

        public boolean equals(Object object) {
            bfw[] bfwArray;
            int n2;
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
            if (this.var_int_a == a2.var_int_a && this.var_java_lang_Class____a == a2.var_java_lang_Class____a && (n2 = this.var_bfw_arr_a.length) == (bfwArray = a2.var_bfw_arr_a).length) {
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (this.var_bfw_arr_a[i2].equals(bfwArray[i2])) continue;
                    return false;
                }
                return true;
            }
            return false;
        }

        public String toString() {
            return this.var_java_lang_Class____a.getName() + "<>";
        }
    }

    static class b {
        private static final TypeVariable<?>[] a = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] b = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] c = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] d = List.class.getTypeParameters();
        private static final TypeVariable<?>[] e = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] f = Map.class.getTypeParameters();
        private static final TypeVariable<?>[] g = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] h = LinkedHashMap.class.getTypeParameters();

        public static TypeVariable<?>[] a(Class<?> clazz) {
            if (clazz == Collection.class) {
                return b;
            }
            if (clazz == List.class) {
                return d;
            }
            if (clazz == ArrayList.class) {
                return e;
            }
            if (clazz == AbstractList.class) {
                return a;
            }
            if (clazz == Iterable.class) {
                return c;
            }
            return clazz.getTypeParameters();
        }

        public static TypeVariable<?>[] b(Class<?> clazz) {
            if (clazz == Map.class) {
                return f;
            }
            if (clazz == HashMap.class) {
                return g;
            }
            if (clazz == LinkedHashMap.class) {
                return h;
            }
            return clazz.getTypeParameters();
        }
    }
}

