/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public final class buo
implements Serializable {
    private final Class<Enum<?>> var_java_lang_Class_java_lang_Enum_____a;
    private final Enum<?>[] var_java_lang_Enum____arr_a;
    private final bdi[] var_bdi_arr_a;

    private buo(Class<Enum<?>> clazz, bdi[] bdiArray) {
        this.var_java_lang_Class_java_lang_Enum_____a = clazz;
        this.var_java_lang_Class_java_lang_Enum_____a = clazz.getEnumConstants();
        this.var_bdi_arr_a = bdiArray;
    }

    public static buo a(bhm<?> bhm2, Class<Enum<?>> clazz) {
        Class<Enum<?>> clazz2 = buk.d(clazz);
        Enum<?>[] enumArray = clazz2.getEnumConstants();
        if (enumArray == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class " + clazz.getName());
        }
        String[] stringArray = bhm2.bfn_a().a(clazz2, enumArray, new String[enumArray.length]);
        bdi[] bdiArray = new bdi[enumArray.length];
        int n2 = enumArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Enum<?> enum_ = enumArray[i2];
            String string = stringArray[i2];
            if (string == null) {
                string = enum_.name();
            }
            bdiArray[enum_.ordinal()] = bhm2.a(string);
        }
        return buo.a(clazz, bdiArray);
    }

    public static buo a(Class<Enum<?>> clazz, bdi[] bdiArray) {
        return new buo(clazz, bdiArray);
    }

    public bdi a(Enum<?> enum_) {
        return this.var_bdi_arr_a[enum_.ordinal()];
    }

    public Class<Enum<?>> a() {
        return this.var_java_lang_Class_java_lang_Enum_____a;
    }
}

