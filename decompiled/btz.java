/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class btz
implements Serializable {
    private static final bfw[] var_bfw_arr_a;
    protected static final btz var_btz_a;
    protected static final bty var_bty_a;
    private static final Class<?> var_java_lang_Class____a;
    private static final Class<?> var_java_lang_Class____b;
    private static final Class<?> var_java_lang_Class____c;
    private static final Class<?> var_java_lang_Class____d;
    private static final Class<?> var_java_lang_Class____e;
    private static final Class<?> var_java_lang_Class____f;
    private static final Class<?> var_java_lang_Class____g;
    private static final Class<?> var_java_lang_Class____h;
    private static final Class<?> var_java_lang_Class____i;
    protected static final btw var_btw_a;
    protected static final btw var_btw_b;
    protected static final btw var_btw_c;
    protected static final btw var_btw_d;
    protected static final btw var_btw_e;
    protected static final btw var_btw_f;
    protected static final btw var_btw_g;
    protected static final btw var_btw_h;
    protected static final btw var_btw_i;
    protected final bus<Object, bfw> cfr_renamed_43;
    protected final bua[] var_bua_arr_a;
    protected final bub var_bub_a;
    protected final ClassLoader var_java_lang_ClassLoader_a;

    private btz() {
        this(null);
    }

    protected btz(bus<Object, bfw> bus2) {
        if (bus2 == null) {
            bus2 = new buq<Object, bfw>(16, 200);
        }
        this.var_bfw_arr_a = bus2;
        this.var_bub_a = new bub(this);
        this.var_bua_arr_a = null;
        this.var_java_lang_ClassLoader_a = null;
    }

    public static btz btz_a() {
        return var_btz_a;
    }

    public ClassLoader java_lang_ClassLoader_a() {
        return this.var_java_lang_ClassLoader_a;
    }

    public static bfw bfw_a() {
        return btz.btz_a().b();
    }

    public Class<?> a(String string) {
        Serializable serializable;
        if (string.indexOf(46) < 0 && (serializable = this.c(string)) != null) {
            return serializable;
        }
        serializable = null;
        ClassLoader classLoader = this.java_lang_ClassLoader_a();
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        if (classLoader != null) {
            try {
                return this.a(string, true, classLoader);
            }
            catch (Exception exception) {
                serializable = buk.d(exception);
            }
        }
        try {
            return this.b(string);
        }
        catch (Exception exception) {
            if (serializable == null) {
                serializable = buk.d(exception);
            }
            buk.java_lang_Throwable_b(serializable);
            throw new ClassNotFoundException(((Throwable)serializable).getMessage(), (Throwable)serializable);
        }
    }

    protected Class<?> a(String string, boolean bl2, ClassLoader classLoader) {
        return Class.forName(string, true, classLoader);
    }

    protected Class<?> b(String string) {
        return Class.forName(string);
    }

    protected Class<?> c(String string) {
        if ("int".equals(string)) {
            return Integer.TYPE;
        }
        if ("long".equals(string)) {
            return Long.TYPE;
        }
        if ("float".equals(string)) {
            return Float.TYPE;
        }
        if ("double".equals(string)) {
            return Double.TYPE;
        }
        if ("boolean".equals(string)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(string)) {
            return Byte.TYPE;
        }
        if ("char".equals(string)) {
            return Character.TYPE;
        }
        if ("short".equals(string)) {
            return Short.TYPE;
        }
        if ("void".equals(string)) {
            return Void.TYPE;
        }
        return null;
    }

    public bfw bfw_a(bfw bfw2, Class<?> clazz) {
        return this.a(bfw2, clazz, false);
    }

    /*
     * Unable to fully structure code
     */
    public bfw a(bfw var1_1, Class<?> var2_2, boolean var3_3) {
        block10: {
            block11: {
                block9: {
                    var4_4 = var1_1.a();
                    if (var4_4 == var2_2) {
                        return var1_1;
                    }
                    if (var4_4 != Object.class) break block9;
                    var5_5 = this.bfw_a(null, var2_2, btz.var_bty_a);
                    break block10;
                }
                if (!var4_4.isAssignableFrom(var2_2)) {
                    throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{buk.java_lang_String_b(var2_2), buk.a(var1_1)}));
                }
                if (!var1_1.m()) ** GOTO lbl22
                if (!var1_1.o()) break block11;
                if (var2_2 != HashMap.class && var2_2 != LinkedHashMap.class && var2_2 != EnumMap.class && var2_2 != TreeMap.class) ** GOTO lbl22
                var5_5 = this.bfw_a(null, var2_2, bty.a(var2_2, var1_1.bfw_b(), var1_1.bfw_c()));
                break block10;
            }
            if (!var1_1.n()) ** GOTO lbl22
            if (var2_2 == ArrayList.class || var2_2 == LinkedList.class || var2_2 == HashSet.class || var2_2 == TreeSet.class) {
                var5_5 = this.bfw_a(null, var2_2, bty.a(var2_2, var1_1.bfw_c()));
            } else {
                if (var4_4 == EnumSet.class) {
                    return var1_1;
                }
lbl22:
                // 5 sources

                if (var1_1.bty_a().boolean_a()) {
                    var5_5 = this.bfw_a(null, var2_2, btz.var_bty_a);
                } else {
                    var6_6 = var2_2.getTypeParameters().length;
                    if (var6_6 == 0) {
                        var5_5 = this.bfw_a(null, var2_2, btz.var_bty_a);
                    } else {
                        var7_7 = this.a(var1_1, var6_6, var2_2, var3_3);
                        var5_5 = this.bfw_a(null, var2_2, var7_7);
                    }
                }
            }
        }
        var5_5 = var5_5.bfw_a(var1_1);
        return var5_5;
    }

    private bty a(bfw bfw2, int n2, Class<?> clazz, boolean bl2) {
        bfw[] bfwArray = new btt[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bfwArray[i2] = new btt(i2);
        }
        bty bty2 = bty.a(clazz, bfwArray);
        bfw bfw3 = this.bfw_a(null, clazz, bty2);
        bfw bfw4 = bfw3.bfw_a((Class<?>)bfw2.a());
        if (bfw4 == null) {
            throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", ((Class)bfw2.a()).getName(), clazz.getName()));
        }
        String string = this.java_lang_String_a(bfw2, bfw4);
        if (string != null && !bl2) {
            throw new IllegalArgumentException("Failed to specialize base type " + bfw2.a() + " as " + clazz.getName() + ", problem: " + string);
        }
        bfw[] bfwArray2 = new bfw[n2];
        for (int i3 = 0; i3 < n2; ++i3) {
            bfw bfw5 = ((btt)bfwArray[i3]).bfw_f();
            if (bfw5 == null) {
                bfw5 = btz.bfw_a();
            }
            bfwArray2[i3] = bfw5;
        }
        return bty.a(clazz, bfwArray2);
    }

    private String java_lang_String_a(bfw bfw2, bfw bfw3) {
        List<bfw> list = bfw2.bty_a().a();
        List<bfw> list2 = bfw3.bty_a().a();
        int n2 = list2.size();
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            bfw bfw4;
            bfw bfw5 = list.get(i2);
            bfw bfw6 = bfw4 = i2 < n2 ? list2.get(i2) : btz.bfw_a();
            if (this.boolean_a(bfw5, bfw4) || bfw5.boolean_a(Object.class) || i2 == 0 && bfw2.o() && bfw4.boolean_a(Object.class) || bfw5.j() && bfw5.c((Class<?>)bfw4.a())) continue;
            return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", i2 + 1, n3, bfw5.a(), bfw4.a());
        }
        return null;
    }

    private boolean boolean_a(bfw bfw2, bfw bfw3) {
        if (bfw3 instanceof btt) {
            ((btt)bfw3).void_a(bfw2);
            return true;
        }
        if (bfw2.a() != bfw3.a()) {
            return false;
        }
        List<bfw> list = bfw2.bty_a().a();
        List<bfw> list2 = bfw3.bty_a().a();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            bfw bfw4;
            bfw bfw5 = list.get(i2);
            if (this.boolean_a(bfw5, bfw4 = list2.get(i2))) continue;
            return false;
        }
        return true;
    }

    public bfw b(bfw bfw2, Class<?> clazz) {
        Object t2 = bfw2.a();
        if (t2 == clazz) {
            return bfw2;
        }
        bfw bfw3 = bfw2.bfw_a(clazz);
        if (bfw3 == null) {
            if (!clazz.isAssignableFrom((Class<?>)t2)) {
                throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", clazz.getName(), bfw2));
            }
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", clazz.getName(), bfw2));
        }
        return bfw3;
    }

    public bfw a(String string) {
        return this.var_bub_a.a(string);
    }

    public bfw[] bfw_arr_a(bfw bfw2, Class<?> clazz) {
        bfw bfw3 = bfw2.bfw_a(clazz);
        if (bfw3 == null) {
            return var_bfw_arr_a;
        }
        return bfw3.bty_a().bfw_arr_a();
    }

    public bfw a(Type type) {
        return this.a(null, type, var_bty_a);
    }

    public bfw a(Type type, bty bty2) {
        return this.a(null, type, bty2);
    }

    public btp a(Class<? extends Collection> clazz, Class<?> clazz2) {
        return this.a(clazz, this.bfw_a(null, clazz2, var_bty_a));
    }

    public btp a(Class<? extends Collection> clazz, bfw bfw2) {
        bfw bfw3;
        bfw bfw4;
        bty bty2 = bty.b(clazz, bfw2);
        btp btp2 = (btp)this.bfw_a(null, clazz, bty2);
        if (bty2.boolean_a() && bfw2 != null && !(bfw4 = (bfw3 = btp2.bfw_a(Collection.class)).bfw_c()).equals(bfw2)) {
            throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", buk.java_lang_String_b(clazz), bfw2, bfw4));
        }
        return btp2;
    }

    public bts a(Class<? extends Map> clazz, Class<?> clazz2, Class<?> clazz3) {
        bfw bfw2;
        bfw bfw3;
        if (clazz == Properties.class) {
            bfw2 = bfw3 = var_btw_d;
        } else {
            bfw2 = this.bfw_a(null, clazz2, var_bty_a);
            bfw3 = this.bfw_a(null, clazz3, var_bty_a);
        }
        return this.a(clazz, bfw2, bfw3);
    }

    public bts a(Class<? extends Map> clazz, bfw bfw2, bfw bfw3) {
        bty bty2 = bty.b(clazz, new bfw[]{bfw2, bfw3});
        bts bts2 = (bts)this.bfw_a(null, clazz, bty2);
        if (bty2.boolean_a()) {
            bfw bfw4 = bts2.bfw_a(Map.class);
            bfw bfw5 = bfw4.bfw_b();
            if (!bfw5.equals(bfw2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", buk.java_lang_String_b(clazz), bfw2, bfw5));
            }
            bfw bfw6 = bfw4.bfw_c();
            if (!bfw6.equals(bfw3)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", buk.java_lang_String_b(clazz), bfw3, bfw6));
            }
        }
        return bts2;
    }

    @Deprecated
    public bfw a(Class<?> clazz) {
        return this.a(clazz, var_bty_a, null, null);
    }

    public bfw a(Class<?> clazz, bty bty2) {
        bfw bfw2 = this.bfw_a(null, clazz, bty2);
        return this.a((Type)clazz, bfw2);
    }

    private bfw c(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        bfw bfw3;
        bfw bfw4;
        if (clazz == Properties.class) {
            bfw3 = bfw4 = var_btw_d;
        } else {
            List<bfw> list = bty2.a();
            int n2 = list.size();
            switch (n2) {
                case 0: {
                    bfw3 = bfw4 = this.b();
                    break;
                }
                case 2: {
                    bfw3 = list.get(0);
                    bfw4 = list.get(1);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", buk.java_lang_String_b(clazz), n2, n2 == 1 ? "" : "s", bty2));
                }
            }
        }
        return bts.a(clazz, bty2, bfw2, bfwArray, bfw3, bfw4);
    }

    private bfw d(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        bfw bfw3;
        List<bfw> list = bty2.a();
        if (list.isEmpty()) {
            bfw3 = this.b();
        } else if (list.size() == 1) {
            bfw3 = list.get(0);
        } else {
            throw new IllegalArgumentException("Strange Collection type " + clazz.getName() + ": cannot determine type parameters");
        }
        return btp.a(clazz, bty2, bfw2, bfwArray, bfw3);
    }

    private bfw e(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        bfw bfw3;
        List<bfw> list = bty2.a();
        if (list.isEmpty()) {
            bfw3 = this.b();
        } else if (list.size() == 1) {
            bfw3 = list.get(0);
        } else {
            throw new IllegalArgumentException("Strange Reference type " + clazz.getName() + ": cannot determine type parameters");
        }
        return btu.a(clazz, bty2, bfw2, bfwArray, bfw3);
    }

    protected bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        bfw bfw3;
        if (bty2.boolean_a() && (bfw3 = this.b(clazz)) != null) {
            return bfw3;
        }
        return this.b(clazz, bty2, bfw2, bfwArray);
    }

    protected bfw b(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new btw(clazz, bty2, bfw2, bfwArray);
    }

    protected bfw b() {
        return var_btw_e;
    }

    protected bfw b(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            if (clazz == var_java_lang_Class____g) {
                return var_btw_a;
            }
            if (clazz == var_java_lang_Class____h) {
                return var_btw_b;
            }
            if (clazz == var_java_lang_Class____i) {
                return var_btw_c;
            }
        } else {
            if (clazz == var_bfw_arr_a) {
                return var_btw_d;
            }
            if (clazz == var_java_lang_Class____b) {
                return var_btw_e;
            }
            if (clazz == var_java_lang_Class____f) {
                return var_btw_i;
            }
        }
        return null;
    }

    protected bfw a(btn btn2, Type type, bty bty2) {
        bfw bfw2;
        if (type instanceof Class) {
            bfw2 = this.bfw_a(btn2, (Class)type, var_bty_a);
        } else if (type instanceof ParameterizedType) {
            bfw2 = this.a(btn2, (ParameterizedType)type, bty2);
        } else {
            if (type instanceof bfw) {
                return (bfw)type;
            }
            if (type instanceof GenericArrayType) {
                bfw2 = this.a(btn2, (GenericArrayType)type, bty2);
            } else if (type instanceof TypeVariable) {
                bfw2 = this.a(btn2, (TypeVariable)type, bty2);
            } else if (type instanceof WildcardType) {
                bfw2 = this.a(btn2, (WildcardType)type, bty2);
            } else {
                throw new IllegalArgumentException("Unrecognized Type: " + (type == null ? "[null]" : type.toString()));
            }
        }
        return this.a(type, bfw2);
    }

    protected bfw a(Type type, bfw bfw2) {
        if (this.var_bua_arr_a == null) {
            return bfw2;
        }
        bfw bfw3 = bfw2;
        bty bty2 = bfw3.bty_a();
        if (bty2 == null) {
            bty2 = var_bty_a;
        }
        for (bua bua2 : this.var_bua_arr_a) {
            bfw bfw4 = bua2.a(bfw3, type, bty2, this);
            if (bfw4 == null) {
                throw new IllegalStateException(String.format("TypeModifier %s (of type %s) return null for type %s", bua2, bua2.getClass().getName(), bfw3));
            }
            bfw3 = bfw4;
        }
        return bfw3;
    }

    protected bfw bfw_a(btn btn2, Class<?> clazz, bty bty2) {
        Object object;
        bfw bfw2 = this.b(clazz);
        if (bfw2 != null) {
            return bfw2;
        }
        Object object2 = bty2 == null || bty2.boolean_a() ? clazz : bty2.a(clazz);
        bfw2 = (bfw)this.var_bfw_arr_a.a(object2);
        if (bfw2 != null) {
            return bfw2;
        }
        if (btn2 == null) {
            btn2 = new btn(clazz);
        } else {
            object = btn2.b(clazz);
            if (object != null) {
                btv btv2 = new btv(clazz, var_bty_a);
                ((btn)object).a(btv2);
                return btv2;
            }
            btn2 = btn2.a(clazz);
        }
        if (clazz.isArray()) {
            bfw2 = btl.a(this.a(btn2, (Type)clazz.getComponentType(), bty2), bty2);
        } else {
            bfw[] bfwArray;
            if (clazz.isInterface()) {
                object = null;
                bfwArray = this.bfw_arr_a(btn2, clazz, bty2);
            } else {
                object = this.b(btn2, clazz, bty2);
                bfwArray = this.bfw_arr_a(btn2, clazz, bty2);
            }
            if (clazz == Properties.class) {
                bfw2 = bts.a(clazz, bty2, (bfw)object, bfwArray, var_btw_d, var_btw_d);
            } else if (object != null) {
                bfw2 = ((bfw)object).a(clazz, bty2, (bfw)object, bfwArray);
            }
            if (bfw2 == null && (bfw2 = this.a(btn2, clazz, bty2, (bfw)object, bfwArray)) == null && (bfw2 = this.b(btn2, clazz, bty2, (bfw)object, bfwArray)) == null) {
                bfw2 = this.b(clazz, bty2, (bfw)object, bfwArray);
            }
        }
        btn2.a(bfw2);
        if (!bfw2.s()) {
            this.var_bfw_arr_a.b(object2, bfw2);
        }
        return bfw2;
    }

    protected bfw b(btn btn2, Class<?> clazz, bty bty2) {
        Type type = buk.java_lang_reflect_Type_a(clazz);
        if (type == null) {
            return null;
        }
        return this.a(btn2, type, bty2);
    }

    protected bfw[] bfw_arr_a(btn btn2, Class<?> clazz, bty bty2) {
        Type[] typeArray = buk.java_lang_reflect_Type_arr_a(clazz);
        if (typeArray == null || typeArray.length == 0) {
            return var_bfw_arr_a;
        }
        int n2 = typeArray.length;
        bfw[] bfwArray = new bfw[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            Type type = typeArray[i2];
            bfwArray[i2] = this.a(btn2, type, bty2);
        }
        return bfwArray;
    }

    protected bfw a(btn btn2, Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        if (bty2 == null) {
            bty2 = var_bty_a;
        }
        if (clazz == Map.class) {
            return this.c(clazz, bty2, bfw2, bfwArray);
        }
        if (clazz == Collection.class) {
            return this.d(clazz, bty2, bfw2, bfwArray);
        }
        if (clazz == AtomicReference.class) {
            return this.e(clazz, bty2, bfw2, bfwArray);
        }
        return null;
    }

    protected bfw b(btn btn2, Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        int n2 = bfwArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            bfw bfw3 = bfwArray[i2].a(clazz, bty2, bfw2, bfwArray);
            if (bfw3 == null) continue;
            return bfw3;
        }
        return null;
    }

    protected bfw a(btn btn2, ParameterizedType parameterizedType, bty bty2) {
        bty bty3;
        int n2;
        Class clazz = (Class)parameterizedType.getRawType();
        if (clazz == var_java_lang_Class____e) {
            return var_btw_g;
        }
        if (clazz == var_java_lang_Class____c) {
            return var_btw_f;
        }
        if (clazz == var_java_lang_Class____d) {
            return var_btw_h;
        }
        Type[] typeArray = parameterizedType.getActualTypeArguments();
        int n3 = n2 = typeArray == null ? 0 : typeArray.length;
        if (n2 == 0) {
            bty3 = var_bty_a;
        } else {
            bfw[] bfwArray = new bfw[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                bfwArray[i2] = this.a(btn2, typeArray[i2], bty2);
            }
            bty3 = bty.a(clazz, bfwArray);
        }
        return this.bfw_a(btn2, clazz, bty3);
    }

    protected bfw a(btn btn2, GenericArrayType genericArrayType, bty bty2) {
        bfw bfw2 = this.a(btn2, genericArrayType.getGenericComponentType(), bty2);
        return btl.a(bfw2, bty2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected bfw a(btn btn2, TypeVariable<?> typeVariable, bty bty2) {
        Type[] typeArray;
        String string = typeVariable.getName();
        if (bty2 == null) {
            throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + string + "\")");
        }
        bfw bfw2 = bty2.bfw_a(string);
        if (bfw2 != null) {
            return bfw2;
        }
        if (bty2.boolean_a(string)) {
            return var_btw_e;
        }
        bty2 = bty2.bty_a(string);
        TypeVariable<?> typeVariable2 = typeVariable;
        synchronized (typeVariable2) {
            typeArray = typeVariable.getBounds();
        }
        return this.a(btn2, typeArray[0], bty2);
    }

    protected bfw a(btn btn2, WildcardType wildcardType, bty bty2) {
        return this.a(btn2, wildcardType.getUpperBounds()[0], bty2);
    }

    static {
        var_bfw_arr_a = new bfw[0];
        var_btz_a = new btz();
        var_bty_a = bty.bty_a();
        var_bfw_arr_a = String.class;
        var_java_lang_Class____b = Object.class;
        var_java_lang_Class____c = Comparable.class;
        var_java_lang_Class____d = Class.class;
        var_java_lang_Class____e = Enum.class;
        var_java_lang_Class____f = bfz.class;
        var_java_lang_Class____g = Boolean.TYPE;
        var_java_lang_Class____h = Integer.TYPE;
        var_java_lang_Class____i = Long.TYPE;
        var_btw_a = new btw(var_java_lang_Class____g);
        var_btw_b = new btw(var_java_lang_Class____h);
        var_btw_c = new btw(var_java_lang_Class____i);
        var_btw_d = new btw((Class<?>)var_bfw_arr_a);
        var_btw_e = new btw(var_java_lang_Class____b);
        var_btw_f = new btw(var_java_lang_Class____c);
        var_btw_g = new btw(var_java_lang_Class____e);
        var_btw_h = new btw(var_java_lang_Class____d);
        var_btw_i = new btw(var_java_lang_Class____f);
    }
}

