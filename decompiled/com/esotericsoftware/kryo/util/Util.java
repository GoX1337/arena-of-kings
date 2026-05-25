/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.serializers.ClosureSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.util.Generics;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static final boolean isAndroid;
    public static final boolean unsafe;
    public static final int maxArraySize = 0x7FFFFFF7;
    private static final Map<Class<?>, Class<?>> primitiveWrappers;

    public static boolean isClassAvailable(String string) {
        try {
            Class.forName(string);
            return true;
        }
        catch (Exception exception) {
            Log.debug("kryo", "Class not available: " + string);
            return false;
        }
    }

    public static Class getWrapperClass(Class clazz) {
        if (clazz == Integer.TYPE) {
            return Integer.class;
        }
        if (clazz == Float.TYPE) {
            return Float.class;
        }
        if (clazz == Boolean.TYPE) {
            return Boolean.class;
        }
        if (clazz == Byte.TYPE) {
            return Byte.class;
        }
        if (clazz == Long.TYPE) {
            return Long.class;
        }
        if (clazz == Character.TYPE) {
            return Character.class;
        }
        if (clazz == Double.TYPE) {
            return Double.class;
        }
        if (clazz == Short.TYPE) {
            return Short.class;
        }
        return clazz;
    }

    public static Class getPrimitiveClass(Class clazz) {
        if (clazz == Integer.class) {
            return Integer.TYPE;
        }
        if (clazz == Float.class) {
            return Float.TYPE;
        }
        if (clazz == Boolean.class) {
            return Boolean.TYPE;
        }
        if (clazz == Byte.class) {
            return Byte.TYPE;
        }
        if (clazz == Long.class) {
            return Long.TYPE;
        }
        if (clazz == Character.class) {
            return Character.TYPE;
        }
        if (clazz == Double.class) {
            return Double.TYPE;
        }
        if (clazz == Short.class) {
            return Short.TYPE;
        }
        if (clazz == Void.class) {
            return Void.TYPE;
        }
        return clazz;
    }

    public static boolean isWrapperClass(Class clazz) {
        return clazz == Integer.class || clazz == Float.class || clazz == Boolean.class || clazz == Byte.class || clazz == Long.class || clazz == Character.class || clazz == Double.class || clazz == Short.class;
    }

    public static boolean isEnum(Class clazz) {
        return Enum.class.isAssignableFrom(clazz) && clazz != Enum.class;
    }

    public static void log(String string, Object object, int n2) {
        if (object == null) {
            if (Log.TRACE) {
                Log.trace("kryo", string + ": null" + Util.pos(n2));
            }
            return;
        }
        Class<?> clazz = object.getClass();
        if (clazz.isPrimitive() || Util.isWrapperClass(clazz) || clazz == String.class) {
            if (Log.TRACE) {
                Log.trace("kryo", string + ": " + Util.string(object) + Util.pos(n2));
            }
        } else {
            Log.debug("kryo", string + ": " + Util.string(object) + Util.pos(n2));
        }
    }

    public static String pos(int n2) {
        return n2 == -1 ? "" : " [" + n2 + "]";
    }

    public static String string(Object object) {
        if (object == null) {
            return "null";
        }
        Class<?> clazz = object.getClass();
        if (clazz.isArray()) {
            return Util.className(clazz);
        }
        String string = Log.TRACE ? Util.className(clazz) : clazz.getSimpleName();
        try {
            if (clazz.getMethod("toString", new Class[0]).getDeclaringClass() == Object.class) {
                return string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            String string2 = String.valueOf(object) + " (" + string + ")";
            return string2.length() > 97 ? string2.substring(0, 97) + "..." : string2;
        }
        catch (Throwable throwable) {
            return string + " (toString exception: " + throwable + ")";
        }
    }

    public static String className(Class clazz) {
        if (clazz == null) {
            return "null";
        }
        if (clazz.isArray()) {
            Class clazz2 = Util.getElementClass(clazz);
            StringBuilder stringBuilder = new StringBuilder(16);
            int n2 = Util.getDimensionCount(clazz);
            for (int i2 = 0; i2 < n2; ++i2) {
                stringBuilder.append("[]");
            }
            return Util.className(clazz2) + stringBuilder;
        }
        if (clazz.isPrimitive() || clazz == Object.class || clazz == Boolean.class || clazz == Byte.class || clazz == Character.class || clazz == Short.class || clazz == Integer.class || clazz == Long.class || clazz == Float.class || clazz == Double.class || clazz == String.class) {
            return clazz.getSimpleName();
        }
        return clazz.getName();
    }

    public static String classNames(Class[] classArray) {
        StringBuilder stringBuilder = new StringBuilder(32);
        int n2 = classArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(Util.className(classArray[i2]));
        }
        return stringBuilder.toString();
    }

    public static String canonicalName(Class clazz) {
        if (clazz == null) {
            return "null";
        }
        String string = clazz.getCanonicalName();
        return string != null ? string : Util.className(clazz);
    }

    public static String simpleName(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getSimpleName();
        }
        return type.toString();
    }

    public static String simpleName(Class clazz, Generics.GenericType genericType) {
        int n2;
        int n3;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append((clazz.isArray() ? Util.getElementClass(clazz) : clazz).getSimpleName());
        if (genericType.arguments != null) {
            stringBuilder.append('<');
            n3 = genericType.arguments.length;
            for (n2 = 0; n2 < n3; ++n2) {
                if (n2 > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(genericType.arguments[n2].toString());
            }
            stringBuilder.append('>');
        }
        if (clazz.isArray()) {
            n3 = Util.getDimensionCount(clazz);
            for (n2 = 0; n2 < n3; ++n2) {
                stringBuilder.append("[]");
            }
        }
        return stringBuilder.toString();
    }

    public static int getDimensionCount(Class clazz) {
        int n2 = 0;
        for (Class<?> clazz2 = clazz.getComponentType(); clazz2 != null; clazz2 = clazz2.getComponentType()) {
            ++n2;
        }
        return n2;
    }

    public static Class getElementClass(Class clazz) {
        Class<?> clazz2 = clazz;
        while (clazz2.getComponentType() != null) {
            clazz2 = clazz2.getComponentType();
        }
        return clazz2;
    }

    public static boolean isAssignableTo(Class<?> clazz, Class<?> clazz2) {
        if (clazz2 == Object.class) {
            return true;
        }
        if (clazz2.isAssignableFrom(clazz)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            return Util.isPrimitiveWrapperOf(clazz2, clazz);
        }
        if (clazz2.isPrimitive()) {
            return Util.isPrimitiveWrapperOf(clazz, clazz2);
        }
        if (clazz == ClosureSerializer.Closure.class) {
            return clazz2.isInterface();
        }
        return false;
    }

    private static boolean isPrimitiveWrapperOf(Class<?> clazz, Class<?> clazz2) {
        if (!clazz2.isPrimitive()) {
            throw new IllegalArgumentException("First argument has to be primitive type");
        }
        return primitiveWrappers.get(clazz2) == clazz;
    }

    public static boolean isAscii(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (string.charAt(i2) <= '\u007f') continue;
            return false;
        }
        return true;
    }

    public static <T extends SerializerFactory> T newFactory(Class<T> clazz, Class<? extends Serializer> clazz2) {
        try {
            if (clazz2 != null) {
                try {
                    return (T)((SerializerFactory)clazz.getConstructor(Class.class).newInstance(clazz2));
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    // empty catch block
                }
            }
            return (T)((SerializerFactory)clazz.newInstance());
        }
        catch (Exception exception) {
            if (clazz2 == null) {
                throw new IllegalArgumentException("Unable to create serializer factory: " + clazz.getName(), exception);
            }
            throw new IllegalArgumentException("Unable to create serializer factory \"" + clazz.getName() + "\" for serializer class: " + Util.className(clazz2), exception);
        }
    }

    static {
        boolean bl2;
        block5: {
            isAndroid = "Dalvik".equals(System.getProperty("java.vm.name"));
            bl2 = false;
            if ("false".equals(System.getProperty("kryo.unsafe"))) {
                if (Log.TRACE) {
                    Log.trace("kryo", "Unsafe is disabled.");
                }
            } else {
                try {
                    bl2 = Class.forName("com.esotericsoftware.kryo.unsafe.UnsafeUtil", true, FieldSerializer.class.getClassLoader()).getField("unsafe").get(null) != null;
                }
                catch (Throwable throwable) {
                    if (!Log.TRACE) break block5;
                    Log.trace("kryo", "Unsafe is unavailable.", throwable);
                }
            }
        }
        unsafe = bl2;
        primitiveWrappers = new HashMap();
        primitiveWrappers.put(Boolean.TYPE, Boolean.class);
        primitiveWrappers.put(Byte.TYPE, Byte.class);
        primitiveWrappers.put(Character.TYPE, Character.class);
        primitiveWrappers.put(Double.TYPE, Double.class);
        primitiveWrappers.put(Float.TYPE, Float.class);
        primitiveWrappers.put(Integer.TYPE, Integer.class);
        primitiveWrappers.put(Long.TYPE, Long.class);
        primitiveWrappers.put(Short.TYPE, Short.class);
    }
}

