/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class bul
implements Serializable {
    private static final bul var_bul_a;
    private final int var_int_a;
    private final int b;
    private final Object[] var_java_lang_Object_arr_a;

    private bul(int n2, int n3, Object[] objectArray) {
        this.var_int_a = n2;
        this.b = n3;
        this.var_java_lang_Object_arr_a = objectArray;
    }

    public static <T> bul a(Map<String, T> map) {
        if (map.isEmpty()) {
            return var_bul_a;
        }
        int n2 = bul.a(map.size());
        int n3 = n2 - 1;
        int n4 = (n2 + (n2 >> 1)) * 2;
        Object[] objectArray = new Object[n4];
        int n5 = 0;
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String string = entry.getKey();
            if (string == null) continue;
            int n6 = string.hashCode() & n3;
            int n7 = n6 + n6;
            if (objectArray[n7] != null && objectArray[n7 = n2 + (n6 >> 1) << 1] != null) {
                n7 = (n2 + (n2 >> 1) << 1) + n5;
                n5 += 2;
                if (n7 >= objectArray.length) {
                    objectArray = Arrays.copyOf(objectArray, objectArray.length + 4);
                }
            }
            objectArray[n7] = string;
            objectArray[n7 + 1] = entry.getValue();
        }
        return new bul(n3, n5, objectArray);
    }

    private static final int a(int n2) {
        int n3;
        if (n2 <= 5) {
            return 8;
        }
        if (n2 <= 12) {
            return 16;
        }
        int n4 = n2 + (n2 >> 2);
        for (n3 = 32; n3 < n4; n3 += n3) {
        }
        return n3;
    }

    public Object a(String string) {
        int n2 = string.hashCode() & this.var_int_a;
        int n3 = n2 << 1;
        Object object = this.var_java_lang_Object_arr_a[n3];
        if (object == string || string.equals(object)) {
            return this.var_java_lang_Object_arr_a[n3 + 1];
        }
        return this.a(string, n2, object);
    }

    private final Object a(String string, int n2, Object object) {
        if (object == null) {
            return null;
        }
        int n3 = this.var_int_a + 1;
        int n4 = n3 + (n2 >> 1) << 1;
        object = this.var_java_lang_Object_arr_a[n4];
        if (string.equals(object)) {
            return this.var_java_lang_Object_arr_a[n4 + 1];
        }
        if (object != null) {
            int n5;
            int n6 = n5 + this.b;
            for (n5 = n3 + (n3 >> 1) << 1; n5 < n6; n5 += 2) {
                object = this.var_java_lang_Object_arr_a[n5];
                if (object != string && !string.equals(object)) continue;
                return this.var_java_lang_Object_arr_a[n5 + 1];
            }
        }
        return null;
    }

    public Object b(String string) {
        int n2 = this.var_java_lang_Object_arr_a.length;
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string2;
            Object object = this.var_java_lang_Object_arr_a[i2];
            if (object == null || !(string2 = (String)object).equalsIgnoreCase(string)) continue;
            return this.var_java_lang_Object_arr_a[i2 + 1];
        }
        return null;
    }

    public List<String> a() {
        int n2 = this.var_java_lang_Object_arr_a.length;
        ArrayList<String> arrayList = new ArrayList<String>(n2 >> 2);
        for (int i2 = 0; i2 < n2; i2 += 2) {
            Object object = this.var_java_lang_Object_arr_a[i2];
            if (object == null) continue;
            arrayList.add((String)object);
        }
        return arrayList;
    }

    static {
        var_bul_a = new bul(1, 0, new Object[4]);
    }
}

