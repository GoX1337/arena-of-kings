/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class bun
implements Serializable {
    protected final Class<Enum<?>> var_java_lang_Class_java_lang_Enum_____a;
    protected final Enum<?>[] var_java_lang_Enum____arr_a;
    protected final HashMap<String, Enum<?>> cfr_renamed_44;
    protected final Enum<?> var_java_lang_Enum____a;
    protected final boolean var_boolean_a;

    protected bun(Class<Enum<?>> clazz, Enum<?>[] enumArray, HashMap<String, Enum<?>> hashMap, Enum<?> enum_, boolean bl2) {
        this.var_java_lang_Class_java_lang_Enum_____a = clazz;
        this.var_java_lang_Class_java_lang_Enum_____a = enumArray;
        this.var_java_lang_Class_java_lang_Enum_____a = hashMap;
        this.var_java_lang_Class_java_lang_Enum_____a = enum_;
        this.var_boolean_a = bl2;
    }

    public static bun a(bfr bfr2, Class<?> clazz) {
        return bun.a(clazz, bfr2.bfn_a(), bfr2.a(bgd.w));
    }

    protected static bun a(Class<?> clazz, bfn bfn2, boolean bl2) {
        Class<Enum<?>> clazz2 = bun.a(clazz);
        Enum<?>[] enumArray = bun.a(clazz);
        String[] stringArray = bfn2.a(clazz2, enumArray, new String[enumArray.length]);
        String[][] stringArray2 = new String[stringArray.length][];
        bfn2.a(clazz2, enumArray, stringArray2);
        HashMap hashMap = new HashMap();
        int n2 = enumArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Enum<?> enum_ = enumArray[i2];
            String string = stringArray[i2];
            if (string == null) {
                string = enum_.name();
            }
            hashMap.put(string, enum_);
            String[] stringArray3 = stringArray2[i2];
            if (stringArray3 == null) continue;
            for (String string2 : stringArray3) {
                if (hashMap.containsKey(string2)) continue;
                hashMap.put(string2, enum_);
            }
        }
        return new bun(clazz2, enumArray, hashMap, bun.a(bfn2, clazz2), bl2);
    }

    public static bun b(bfr bfr2, Class<?> clazz) {
        return bun.b(clazz, bfr2.bfn_a(), bfr2.a(bgd.w));
    }

    protected static bun b(Class<?> clazz, bfn bfn2, boolean bl2) {
        Class<Enum<?>> clazz2 = bun.a(clazz);
        Enum<?>[] enumArray = bun.a(clazz);
        HashMap hashMap = new HashMap();
        String[][] stringArray = new String[enumArray.length][];
        bfn2.a(clazz2, enumArray, stringArray);
        int n2 = enumArray.length;
        while (--n2 >= 0) {
            Enum<?> enum_ = enumArray[n2];
            hashMap.put(enum_.toString(), enum_);
            String[] stringArray2 = stringArray[n2];
            if (stringArray2 == null) continue;
            for (String string : stringArray2) {
                if (hashMap.containsKey(string)) continue;
                hashMap.put(string, enum_);
            }
        }
        return new bun(clazz2, enumArray, hashMap, bun.a(bfn2, clazz2), bl2);
    }

    public static bun a(bfr bfr2, Class<?> clazz, bmn bmn2) {
        return bun.a(clazz, bmn2, bfr2.bfn_a(), bfr2.a(bgd.w));
    }

    protected static bun a(Class<?> clazz, bmn bmn2, bfn bfn2, boolean bl2) {
        Class<Enum<?>> clazz2 = bun.a(clazz);
        Enum<?>[] enumArray = bun.a(clazz);
        HashMap hashMap = new HashMap();
        int n2 = enumArray.length;
        while (--n2 >= 0) {
            Enum<?> enum_ = enumArray[n2];
            try {
                Object object = bmn2.b(enum_);
                if (object == null) continue;
                hashMap.put(object.toString(), enum_);
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + enum_ + ": " + exception.getMessage());
            }
        }
        return new bun(clazz2, enumArray, hashMap, bun.a(bfn2, clazz2), bl2);
    }

    public bul bul_a() {
        return bul.a(this.var_java_lang_Class_java_lang_Enum_____a);
    }

    protected static Class<Enum<?>> a(Class<?> clazz) {
        return clazz;
    }

    protected static Enum<?>[] a(Class<?> clazz) {
        Enum<?>[] enumArray = bun.a(clazz).getEnumConstants();
        if (enumArray == null) {
            throw new IllegalArgumentException("No enum constants for class " + clazz.getName());
        }
        return enumArray;
    }

    protected static Enum<?> a(bfn bfn2, Class<?> clazz) {
        return bfn2 != null ? bfn2.a(bun.a(clazz)) : null;
    }

    public Enum<?> a(String string) {
        Enum enum_ = (Enum)((HashMap)((Object)this.var_java_lang_Class_java_lang_Enum_____a)).get(string);
        if (enum_ == null && this.var_boolean_a) {
            return this.b(string);
        }
        return enum_;
    }

    protected Enum<?> b(String string) {
        for (Map.Entry entry : ((HashMap)((Object)this.var_java_lang_Class_java_lang_Enum_____a)).entrySet()) {
            if (!string.equalsIgnoreCase((String)entry.getKey())) continue;
            return (Enum)entry.getValue();
        }
        return null;
    }

    public Enum<?> a() {
        return this.var_java_lang_Class_java_lang_Enum_____a;
    }

    public Enum<?>[] java_lang_Enum____arr_a() {
        return this.var_java_lang_Class_java_lang_Enum_____a;
    }

    public Collection<String> a() {
        return ((HashMap)((Object)this.var_java_lang_Class_java_lang_Enum_____a)).keySet();
    }

    public Class<Enum<?>> a() {
        return this.var_java_lang_Class_java_lang_Enum_____a;
    }
}

