/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionUtils {
    private static final Logger LOG = Logger.getLogger(ReflectionUtils.class.getName());
    private static final Method METHOD_IS_DEFAULT;
    private static final Method METHOD_HANDLES_LOOKUP;
    private static final Method METHOD_HANDLES_LOOKUP_IN;
    private static final Method METHOD_HANDLES_PRIVATE_LOOKUP_IN;
    private static final Method METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL;
    private static final Method METHOD_HANDLES_LOOKUP_FIND_SPECIAL;
    private static final Method METHOD_HANDLES_BIND_TO;
    private static final Method METHOD_HANDLES_INVOKE_WITH_ARGUMENTS;
    private static final Method METHOD_TYPE;
    private static Constructor CONSTRUCTOR_LOOKUP_CLASS;

    private static Constructor getConstructorLookupClass() {
        if (CONSTRUCTOR_LOOKUP_CLASS == null) {
            Class clazz = ReflectionUtils.lookupClass("java.lang.invoke.MethodHandles$Lookup");
            CONSTRUCTOR_LOOKUP_CLASS = ReflectionUtils.lookupDeclaredConstructor(clazz, Class.class);
        }
        return CONSTRUCTOR_LOOKUP_CLASS;
    }

    private static Constructor lookupDeclaredConstructor(Class clazz, Class ... classArray) {
        if (clazz == null) {
            LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{clazz, Arrays.toString(classArray)});
            return null;
        }
        try {
            Constructor constructor = clazz.getDeclaredConstructor(classArray);
            constructor.setAccessible(true);
            return constructor;
        }
        catch (Exception exception) {
            LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{clazz, Arrays.toString(classArray)});
            return null;
        }
    }

    private static Method lookupMethod(Class clazz, String string, Class ... classArray) {
        if (clazz == null) {
            LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{clazz, string, Arrays.toString(classArray)});
            return null;
        }
        try {
            return clazz.getMethod(string, classArray);
        }
        catch (Exception exception) {
            LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{clazz, string, Arrays.toString(classArray)});
            return null;
        }
    }

    private static Class lookupClass(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOG.log(Level.FINE, "Failed to lookup class: " + string, classNotFoundException);
            return null;
        }
    }

    public static boolean isDefault(Method method) {
        if (METHOD_IS_DEFAULT == null) {
            return false;
        }
        try {
            return (Boolean)METHOD_IS_DEFAULT.invoke((Object)method, new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException(illegalArgumentException);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw new RuntimeException(throwable);
        }
    }

    public static Object getMethodHandle(Method method) {
        assert (ReflectionUtils.isDefault(method));
        Object object = ReflectionUtils.createLookup();
        try {
            Object object2 = ReflectionUtils.createPrivateLookupIn(method.getDeclaringClass(), object);
            Object object3 = ReflectionUtils.mhViaFindSpecial(object2, method);
            return object3;
        }
        catch (Exception exception) {
            Object t2 = ReflectionUtils.getConstructorLookupClass().newInstance(method.getDeclaringClass());
            Object object4 = ReflectionUtils.mhViaUnreflectSpecial(t2, method);
            return object4;
        }
    }

    private static Object mhViaFindSpecial(Object object, Method method) {
        return METHOD_HANDLES_LOOKUP_FIND_SPECIAL.invoke(object, method.getDeclaringClass(), method.getName(), METHOD_TYPE.invoke(null, method.getReturnType(), method.getParameterTypes()), method.getDeclaringClass());
    }

    private static Object mhViaUnreflectSpecial(Object object, Method method) {
        Object object2 = METHOD_HANDLES_LOOKUP_IN.invoke(object, method.getDeclaringClass());
        return METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL.invoke(object2, method, method.getDeclaringClass());
    }

    private static Object createPrivateLookupIn(Class clazz, Object object) {
        return METHOD_HANDLES_PRIVATE_LOOKUP_IN.invoke(null, clazz, object);
    }

    private static Object createLookup() {
        return METHOD_HANDLES_LOOKUP.invoke(null, new Object[0]);
    }

    public static Object invokeDefaultMethod(Object object, Object object2, Object ... objectArray) {
        Object object3 = METHOD_HANDLES_BIND_TO.invoke(object2, object);
        return METHOD_HANDLES_INVOKE_WITH_ARGUMENTS.invoke(object3, new Object[]{objectArray});
    }

    static {
        Class clazz = ReflectionUtils.lookupClass("java.lang.invoke.MethodHandles");
        Class clazz2 = ReflectionUtils.lookupClass("java.lang.invoke.MethodHandle");
        Class clazz3 = ReflectionUtils.lookupClass("java.lang.invoke.MethodHandles$Lookup");
        Class clazz4 = ReflectionUtils.lookupClass("java.lang.invoke.MethodType");
        METHOD_IS_DEFAULT = ReflectionUtils.lookupMethod(Method.class, "isDefault", new Class[0]);
        METHOD_HANDLES_LOOKUP = ReflectionUtils.lookupMethod(clazz, "lookup", new Class[0]);
        METHOD_HANDLES_LOOKUP_IN = ReflectionUtils.lookupMethod(clazz3, "in", Class.class);
        METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL = ReflectionUtils.lookupMethod(clazz3, "unreflectSpecial", Method.class, Class.class);
        METHOD_HANDLES_LOOKUP_FIND_SPECIAL = ReflectionUtils.lookupMethod(clazz3, "findSpecial", Class.class, String.class, clazz4, Class.class);
        METHOD_HANDLES_BIND_TO = ReflectionUtils.lookupMethod(clazz2, "bindTo", Object.class);
        METHOD_HANDLES_INVOKE_WITH_ARGUMENTS = ReflectionUtils.lookupMethod(clazz2, "invokeWithArguments", Object[].class);
        METHOD_HANDLES_PRIVATE_LOOKUP_IN = ReflectionUtils.lookupMethod(clazz, "privateLookupIn", Class.class, clazz3);
        METHOD_TYPE = ReflectionUtils.lookupMethod(clazz4, "methodType", Class.class, Class[].class);
    }
}

