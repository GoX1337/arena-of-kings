/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

public class bze {
    public static <T> Constructor<T> a(Class<T> clazz, Constructor<?> constructor) {
        Class<?> clazz2 = bze.a();
        Object object = bze.java_lang_Object_a(clazz2);
        Method method = bze.java_lang_reflect_Method_a(clazz2);
        try {
            return (Constructor)method.invoke(object, clazz, constructor);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("sun.reflect.ReflectionFactory");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ObjenesisException(classNotFoundException);
        }
    }

    private static Object java_lang_Object_a(Class<?> clazz) {
        try {
            Method method = clazz.getDeclaredMethod("getReflectionFactory", new Class[0]);
            return method.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Method java_lang_reflect_Method_a(Class<?> clazz) {
        try {
            return clazz.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException(noSuchMethodException);
        }
    }
}

