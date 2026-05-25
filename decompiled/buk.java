/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public final class buk {
    private static final Class<?> var_java_lang_Class____a;
    private static final Annotation[] var_java_lang_annotation_Annotation_arr_a;
    private static final a[] var_buk$a_arr_a;
    private static final Iterator<?> var_java_util_Iterator____a;

    public static <T> Iterator<T> a() {
        return var_java_lang_Class____a;
    }

    public static List<Class<?>> a(Class<?> clazz, Class<?> clazz2, boolean bl2) {
        if (clazz == null || clazz == clazz2 || clazz == Object.class) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(8);
        buk.a(clazz, clazz2, arrayList, bl2);
        return arrayList;
    }

    public static List<Class<?>> b(Class<?> clazz, Class<?> clazz2, boolean bl2) {
        ArrayList arrayList = new ArrayList(8);
        if (clazz != null && clazz != clazz2) {
            if (bl2) {
                arrayList.add(clazz);
            }
            while ((clazz = clazz.getSuperclass()) != null && clazz != clazz2) {
                arrayList.add(clazz);
            }
        }
        return arrayList;
    }

    private static void a(Class<?> clazz, Class<?> clazz2, Collection<Class<?>> collection, boolean bl2) {
        if (clazz == clazz2 || clazz == null || clazz == Object.class) {
            return;
        }
        if (bl2) {
            if (collection.contains(clazz)) {
                return;
            }
            collection.add(clazz);
        }
        for (Class<?> clazz3 : buk.java_lang_Class____arr_a(clazz)) {
            buk.a(clazz3, clazz2, collection, true);
        }
        buk.a(clazz.getSuperclass(), clazz2, collection, true);
    }

    public static String java_lang_String_a(Class<?> clazz) {
        if (clazz.isAnnotation()) {
            return "annotation";
        }
        if (clazz.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(clazz)) {
            return "enum";
        }
        if (clazz.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String a(Class<?> clazz, boolean bl2) {
        try {
            boolean bl3 = Modifier.isStatic(clazz.getModifiers());
            if (!bl3 && buk.j(clazz)) {
                return "local/anonymous";
            }
            if (!bl2 && !bl3 && buk.e(clazz) != null) {
                return "non-static member class";
            }
        }
        catch (SecurityException securityException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return null;
    }

    public static Class<?> a(Class<?> clazz) {
        if (!Modifier.isStatic(clazz.getModifiers())) {
            try {
                if (buk.j(clazz)) {
                    return null;
                }
                return buk.e(clazz);
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
        }
        return null;
    }

    public static boolean boolean_a(Class<?> clazz) {
        String string = clazz.getName();
        return string.startsWith("net.sf.cglib.proxy.") || string.startsWith("org.hibernate.proxy.");
    }

    public static boolean boolean_b(Class<?> clazz) {
        int n2 = clazz.getModifiers();
        return (n2 & 0x600) == 0;
    }

    public static boolean c(Class<?> clazz) {
        return clazz == Void.class || clazz == Void.TYPE || clazz == bgy.class;
    }

    public static boolean d(Class<?> clazz) {
        Class<?> clazz2 = clazz.getSuperclass();
        return clazz2 != null && "java.lang.Record".equals(clazz2.getName());
    }

    public static boolean e(Class<?> clazz) {
        return clazz == var_java_lang_Class____a || clazz.isPrimitive();
    }

    public static boolean a(Object object, Class<?> clazz) {
        return object != null && object.getClass() == clazz;
    }

    public static void a(Class<?> clazz, Object object, String string) {
        if (object.getClass() != clazz) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", object.getClass().getName(), clazz.getName(), string));
        }
    }

    public static Throwable java_lang_Throwable_a(Throwable throwable) {
        if (throwable instanceof Error) {
            throw (Error)throwable;
        }
        return throwable;
    }

    public static Throwable java_lang_Throwable_b(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException)throwable;
        }
        return throwable;
    }

    public static Throwable c(Throwable throwable) {
        if (throwable instanceof IOException) {
            throw (IOException)throwable;
        }
        return throwable;
    }

    public static Throwable d(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

    public static Throwable e(Throwable throwable) {
        return buk.c(buk.d(throwable));
    }

    public static void void_a(Throwable throwable) {
        buk.a(throwable, throwable.getMessage());
    }

    public static void a(Throwable throwable, String string) {
        buk.java_lang_Throwable_b(throwable);
        buk.java_lang_Throwable_a(throwable);
        throw new IllegalArgumentException(string, throwable);
    }

    public static <T> T a(bfs bfs2, IOException iOException) {
        if (iOException instanceof bfy) {
            throw (bfy)iOException;
        }
        bfy bfy2 = bfy.a(bfs2, iOException.getMessage());
        bfy2.initCause(iOException);
        throw bfy2;
    }

    public static void void_b(Throwable throwable) {
        buk.void_a(buk.d(throwable));
    }

    public static void b(Throwable throwable, String string) {
        buk.a(buk.d(throwable), string);
    }

    public static void a(bcy bcy2, Exception exception) {
        bcy2.bcy_a(bcy.a.b);
        try {
            bcy2.close();
        }
        catch (Exception exception2) {
            exception.addSuppressed(exception2);
        }
        buk.c(exception);
        buk.java_lang_Throwable_b(exception);
        throw new RuntimeException(exception);
    }

    public static void a(bcy bcy2, Closeable closeable, Exception exception) {
        if (bcy2 != null) {
            bcy2.bcy_a(bcy.a.b);
            try {
                bcy2.close();
            }
            catch (Exception exception2) {
                exception.addSuppressed(exception2);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Exception exception3) {
                exception.addSuppressed(exception3);
            }
        }
        buk.c(exception);
        buk.java_lang_Throwable_b(exception);
        throw new RuntimeException(exception);
    }

    public static <T> T a(Class<T> clazz, boolean bl2) {
        boolean bl3 = buk.a(clazz, bl2);
        if (bl3 == null) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " has no default (no arg) constructor");
        }
        try {
            return bl3.newInstance(new Object[0]);
        }
        catch (Exception exception) {
            buk.b(exception, "Failed to instantiate class " + clazz.getName() + ", problem: " + exception.getMessage());
            return null;
        }
    }

    public static <T> Constructor<T> a(Class<T> clazz, boolean bl2) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(new Class[0]);
            if (bl2) {
                buk.a(constructor, bl2);
            } else if (!Modifier.isPublic(constructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + clazz.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return constructor;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (Exception exception) {
            buk.b(exception, "Failed to find default constructor of class " + clazz.getName() + ", problem: " + exception.getMessage());
        }
        return null;
    }

    public static Class<?> a(Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass();
    }

    public static Class<?> a(bfw bfw2) {
        if (bfw2 == null) {
            return null;
        }
        return bfw2.a();
    }

    public static <T> T a(T t2, T t3) {
        return t2 == null ? t3 : t2;
    }

    public static String java_lang_String_a(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static String a(String string) {
        if (string == null) {
            return "";
        }
        return string;
    }

    public static String a(Object object, String string) {
        if (object == null) {
            return string;
        }
        return String.format("\"%s\"", object);
    }

    public static String b(Object object) {
        if (object == null) {
            return "unknown";
        }
        Class<?> clazz = object instanceof Class ? (Class<?>)object : object.getClass();
        return buk.java_lang_String_b(clazz);
    }

    public static String a(bfw bfw2) {
        if (bfw2 == null) {
            return "[null]";
        }
        StringBuilder stringBuilder = new StringBuilder(80).append('`');
        stringBuilder.append((String)bfw2.a());
        return stringBuilder.append('`').toString();
    }

    public static String c(Object object) {
        if (object == null) {
            return "[null]";
        }
        Class<?> clazz = object instanceof Class ? (Class<?>)object : object.getClass();
        return buk.java_lang_String_b(clazz);
    }

    public static String java_lang_String_b(Class<?> clazz) {
        String string;
        if (clazz == null) {
            return "[null]";
        }
        int n2 = 0;
        while (clazz.isArray()) {
            ++n2;
            clazz = clazz.getComponentType();
        }
        String string2 = string = clazz.isPrimitive() ? clazz.getSimpleName() : clazz.getName();
        if (n2 > 0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            do {
                stringBuilder.append("[]");
            } while (--n2 > 0);
            string = stringBuilder.toString();
        }
        return buk.c(string);
    }

    public static String a(bux bux2) {
        if (bux2 == null) {
            return "[null]";
        }
        return buk.d(bux2.java_lang_String_a());
    }

    public static String b(String string) {
        if (string == null) {
            return "[null]";
        }
        return buk.d(string);
    }

    public static String a(bgj bgj2) {
        if (bgj2 == null) {
            return "[null]";
        }
        return buk.d(bgj2.java_lang_String_a());
    }

    public static String c(String string) {
        if (string == null) {
            return "[null]";
        }
        return new StringBuilder(string.length() + 2).append('`').append(string).append('`').toString();
    }

    public static String d(String string) {
        if (string == null) {
            return "[null]";
        }
        return new StringBuilder(string.length() + 2).append('\'').append(string).append('\'').toString();
    }

    public static String java_lang_String_a(Throwable throwable) {
        if (throwable instanceof bdd) {
            return ((bdd)throwable).java_lang_String_a();
        }
        return throwable.getMessage();
    }

    public static Object java_lang_Object_a(Class<?> clazz) {
        if (clazz == Integer.TYPE) {
            return 0;
        }
        if (clazz == Long.TYPE) {
            return 0L;
        }
        if (clazz == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clazz == Double.TYPE) {
            return 0.0;
        }
        if (clazz == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clazz == Byte.TYPE) {
            return (byte)0;
        }
        if (clazz == Short.TYPE) {
            return (short)0;
        }
        if (clazz == Character.TYPE) {
            return Character.valueOf('\u0000');
        }
        throw new IllegalArgumentException("Class " + clazz.getName() + " is not a primitive type");
    }

    public static Class<?> b(Class<?> clazz) {
        if (clazz == Integer.TYPE) {
            return Integer.class;
        }
        if (clazz == Long.TYPE) {
            return Long.class;
        }
        if (clazz == Boolean.TYPE) {
            return Boolean.class;
        }
        if (clazz == Double.TYPE) {
            return Double.class;
        }
        if (clazz == Float.TYPE) {
            return Float.class;
        }
        if (clazz == Byte.TYPE) {
            return Byte.class;
        }
        if (clazz == Short.TYPE) {
            return Short.class;
        }
        if (clazz == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + clazz.getName() + " is not a primitive type");
    }

    public static Class<?> c(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return clazz;
        }
        if (clazz == Integer.class) {
            return Integer.TYPE;
        }
        if (clazz == Long.class) {
            return Long.TYPE;
        }
        if (clazz == Boolean.class) {
            return Boolean.TYPE;
        }
        if (clazz == Double.class) {
            return Double.TYPE;
        }
        if (clazz == Float.class) {
            return Float.TYPE;
        }
        if (clazz == Byte.class) {
            return Byte.TYPE;
        }
        if (clazz == Short.class) {
            return Short.TYPE;
        }
        if (clazz == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    public static void a(Member member, boolean bl2) {
        block3: {
            AccessibleObject accessibleObject = (AccessibleObject)((Object)member);
            try {
                if (bl2 || !Modifier.isPublic(member.getModifiers()) || !Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    accessibleObject.setAccessible(true);
                }
            }
            catch (SecurityException securityException) {
                if (accessibleObject.isAccessible()) break block3;
                Class<?> clazz = member.getDeclaringClass();
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + clazz.getName() + "; failed to set access: " + securityException.getMessage());
            }
        }
    }

    public static boolean f(Class<?> clazz) {
        return Enum.class.isAssignableFrom(clazz);
    }

    public static Class<? extends Enum<?>> a(EnumSet<?> enumSet) {
        if (!enumSet.isEmpty()) {
            return buk.a((Enum)enumSet.iterator().next());
        }
        return b.var_buk$b_a.a(enumSet);
    }

    public static Class<? extends Enum<?>> a(EnumMap<?, ?> enumMap) {
        if (!enumMap.isEmpty()) {
            return buk.a((Enum)enumMap.keySet().iterator().next());
        }
        return b.var_buk$b_a.a(enumMap);
    }

    public static Class<? extends Enum<?>> a(Enum<?> enum_) {
        return enum_.getDeclaringClass();
    }

    public static Class<? extends Enum<?>> d(Class<?> clazz) {
        if (clazz.getSuperclass() != Enum.class) {
            clazz = clazz.getSuperclass();
        }
        return clazz;
    }

    public static <T extends Annotation> Enum<?> a(Class<Enum<?>> clazz, Class<T> clazz2) {
        Field[] fieldArray;
        for (Field field : fieldArray = clazz.getDeclaredFields()) {
            T t2;
            if (!field.isEnumConstant() || (t2 = field.getAnnotation(clazz2)) == null) continue;
            String string = field.getName();
            for (Enum<?> enum_ : clazz.getEnumConstants()) {
                if (!string.equals(enum_.name())) continue;
                return enum_;
            }
        }
        return null;
    }

    public static boolean boolean_a(Object object) {
        return object == null || buk.g(object.getClass());
    }

    public static boolean g(Class<?> clazz) {
        return clazz.getAnnotation(bgp.class) != null;
    }

    public static boolean h(Class<?> clazz) {
        String string = clazz.getName();
        return string.startsWith("java.") || string.startsWith("javax.");
    }

    public static boolean i(Class<?> clazz) {
        return !Modifier.isStatic(clazz.getModifiers()) && buk.e(clazz) != null;
    }

    public static boolean j(Class<?> clazz) {
        return !buk.e(clazz) && clazz.getEnclosingMethod() != null;
    }

    public static Annotation[] java_lang_annotation_Annotation_arr_a(Class<?> clazz) {
        if (buk.e(clazz)) {
            return var_java_lang_annotation_Annotation_arr_a;
        }
        return clazz.getDeclaredAnnotations();
    }

    public static Method[] java_lang_reflect_Method_arr_a(Class<?> clazz) {
        try {
            return clazz.getDeclaredMethods();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            Class<?> clazz2;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            if (classLoader == null) {
                return buk.a(clazz, noClassDefFoundError);
            }
            try {
                clazz2 = classLoader.loadClass(clazz.getName());
            }
            catch (ClassNotFoundException classNotFoundException) {
                noClassDefFoundError.addSuppressed(classNotFoundException);
                return buk.a(clazz, noClassDefFoundError);
            }
            try {
                return clazz2.getDeclaredMethods();
            }
            catch (Throwable throwable) {
                return buk.a(clazz, throwable);
            }
        }
        catch (Throwable throwable) {
            return buk.a(clazz, throwable);
        }
    }

    private static Method[] a(Class<?> clazz, Throwable throwable) {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", clazz.getName(), throwable.getClass().getName(), throwable.getMessage()), throwable);
    }

    public static a[] buk$a_arr_a(Class<?> clazz) {
        if (clazz.isInterface() || buk.e(clazz)) {
            return var_buk$a_arr_a;
        }
        Constructor<?>[] constructorArray = clazz.getDeclaredConstructors();
        int n2 = constructorArray.length;
        a[] aArray = new a[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            aArray[i2] = new a(constructorArray[i2]);
        }
        return aArray;
    }

    public static Type java_lang_reflect_Type_a(Class<?> clazz) {
        return clazz.getGenericSuperclass();
    }

    public static Type[] java_lang_reflect_Type_arr_a(Class<?> clazz) {
        return clazz.getGenericInterfaces();
    }

    public static Class<?> e(Class<?> clazz) {
        return buk.e(clazz) ? null : clazz.getEnclosingClass();
    }

    private static Class<?>[] java_lang_Class____arr_a(Class<?> clazz) {
        return clazz.getInterfaces();
    }

    static {
        var_java_lang_Class____a = Object.class;
        var_java_lang_annotation_Annotation_arr_a = new Annotation[0];
        var_buk$a_arr_a = new a[0];
        var_java_lang_Class____a = Collections.emptyIterator();
    }

    public static final class a {
        public final Constructor<?> var_java_lang_reflect_Constructor____a;
        private transient Annotation[] var_java_lang_annotation_Annotation_arr_a;
        private transient Annotation[][] var_java_lang_annotation_Annotation_arr_arr_a;
        private int var_int_a = -1;

        public a(Constructor<?> constructor) {
            this.var_java_lang_reflect_Constructor____a = constructor;
        }

        public Constructor<?> a() {
            return this.var_java_lang_reflect_Constructor____a;
        }

        public int int_a() {
            int n2 = this.var_int_a;
            if (n2 < 0) {
                this.var_int_a = n2 = this.var_java_lang_reflect_Constructor____a.getParameterTypes().length;
            }
            return n2;
        }

        public Class<?> a() {
            return this.var_java_lang_reflect_Constructor____a.getDeclaringClass();
        }

        public Annotation[] java_lang_annotation_Annotation_arr_a() {
            Annotation[] annotationArray = this.var_java_lang_annotation_Annotation_arr_a;
            if (annotationArray == null) {
                annotationArray = this.var_java_lang_reflect_Constructor____a.getDeclaredAnnotations();
                this.var_java_lang_annotation_Annotation_arr_a = annotationArray;
            }
            return annotationArray;
        }

        public Annotation[][] java_lang_annotation_Annotation_arr_arr_a() {
            Annotation[][] annotationArray = this.var_java_lang_annotation_Annotation_arr_arr_a;
            if (annotationArray == null) {
                annotationArray = this.var_java_lang_reflect_Constructor____a.getParameterAnnotations();
                this.var_java_lang_annotation_Annotation_arr_arr_a = annotationArray;
            }
            return annotationArray;
        }
    }

    static class b {
        static final b var_buk$b_a;
        private final Field var_java_lang_reflect_Field_a = buk$b.a(EnumSet.class, "elementType", Class.class);
        private final Field b = buk$b.a(EnumMap.class, "elementType", Class.class);

        private b() {
        }

        public Class<? extends Enum<?>> a(EnumSet<?> enumSet) {
            if (this.var_java_lang_reflect_Field_a != null) {
                return (Class)this.a(enumSet, this.var_java_lang_reflect_Field_a);
            }
            throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
        }

        public Class<? extends Enum<?>> a(EnumMap<?, ?> enumMap) {
            if (this.b != null) {
                return (Class)this.a(enumMap, this.b);
            }
            throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
        }

        private Object a(Object object, Field field) {
            try {
                return field.get(object);
            }
            catch (Exception exception) {
                throw new IllegalArgumentException(exception);
            }
        }

        private static Field a(Class<?> clazz, String string, Class<?> clazz2) {
            Field[] fieldArray;
            Field field = null;
            for (Field field2 : fieldArray = clazz.getDeclaredFields()) {
                if (!string.equals(field2.getName()) || field2.getType() != clazz2) continue;
                field = field2;
                break;
            }
            if (field == null) {
                for (Field field2 : fieldArray) {
                    if (field2.getType() != clazz2) continue;
                    if (field != null) {
                        return null;
                    }
                    field = field2;
                }
            }
            if (field != null) {
                try {
                    field.setAccessible(true);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            return field;
        }

        static {
            var_buk$b_a = new b();
        }
    }
}

