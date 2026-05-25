/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.reflect;

import com.badlogic.gdx.utils.reflect.Annotation;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.lang.reflect.Modifier;

public final class ClassReflection {
    public static Class forName(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ReflectionException("Class not found: " + string, classNotFoundException);
        }
    }

    public static String getSimpleName(Class clazz) {
        return clazz.getSimpleName();
    }

    public static boolean isInstance(Class clazz, Object object) {
        return clazz.isInstance(object);
    }

    public static boolean isAssignableFrom(Class clazz, Class clazz2) {
        return clazz.isAssignableFrom(clazz2);
    }

    public static boolean isMemberClass(Class clazz) {
        return clazz.isMemberClass();
    }

    public static boolean isStaticClass(Class clazz) {
        return Modifier.isStatic(clazz.getModifiers());
    }

    public static boolean isArray(Class clazz) {
        return clazz.isArray();
    }

    public static boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive();
    }

    public static boolean isEnum(Class clazz) {
        return clazz.isEnum();
    }

    public static boolean isAnnotation(Class clazz) {
        return clazz.isAnnotation();
    }

    public static boolean isInterface(Class clazz) {
        return clazz.isInterface();
    }

    public static boolean isAbstract(Class clazz) {
        return Modifier.isAbstract(clazz.getModifiers());
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException instantiationException) {
            throw new ReflectionException("Could not instantiate instance of class: " + clazz.getName(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ReflectionException("Could not instantiate instance of class: " + clazz.getName(), illegalAccessException);
        }
    }

    public static Class getComponentType(Class clazz) {
        return clazz.getComponentType();
    }

    public static Constructor[] getConstructors(Class clazz) {
        java.lang.reflect.Constructor<?>[] constructorArray = clazz.getConstructors();
        Constructor[] constructorArray2 = new Constructor[constructorArray.length];
        int n2 = constructorArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            constructorArray2[i2] = new Constructor(constructorArray[i2]);
        }
        return constructorArray2;
    }

    public static Constructor getConstructor(Class clazz, Class ... classArray) {
        try {
            return new Constructor(clazz.getConstructor(classArray));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation occurred while getting constructor for class: '" + clazz.getName() + "'.", securityException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ReflectionException("Constructor not found for class: " + clazz.getName(), noSuchMethodException);
        }
    }

    public static Constructor getDeclaredConstructor(Class clazz, Class ... classArray) {
        try {
            return new Constructor(clazz.getDeclaredConstructor(classArray));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation while getting constructor for class: " + clazz.getName(), securityException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ReflectionException("Constructor not found for class: " + clazz.getName(), noSuchMethodException);
        }
    }

    public static Object[] getEnumConstants(Class clazz) {
        return clazz.getEnumConstants();
    }

    public static Method[] getMethods(Class clazz) {
        java.lang.reflect.Method[] methodArray = clazz.getMethods();
        Method[] methodArray2 = new Method[methodArray.length];
        int n2 = methodArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            methodArray2[i2] = new Method(methodArray[i2]);
        }
        return methodArray2;
    }

    public static Method getMethod(Class clazz, String string, Class ... classArray) {
        try {
            return new Method(clazz.getMethod(string, classArray));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation while getting method: " + string + ", for class: " + clazz.getName(), securityException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ReflectionException("Method not found: " + string + ", for class: " + clazz.getName(), noSuchMethodException);
        }
    }

    public static Method[] getDeclaredMethods(Class clazz) {
        java.lang.reflect.Method[] methodArray = clazz.getDeclaredMethods();
        Method[] methodArray2 = new Method[methodArray.length];
        int n2 = methodArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            methodArray2[i2] = new Method(methodArray[i2]);
        }
        return methodArray2;
    }

    public static Method getDeclaredMethod(Class clazz, String string, Class ... classArray) {
        try {
            return new Method(clazz.getDeclaredMethod(string, classArray));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation while getting method: " + string + ", for class: " + clazz.getName(), securityException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ReflectionException("Method not found: " + string + ", for class: " + clazz.getName(), noSuchMethodException);
        }
    }

    public static Field[] getFields(Class clazz) {
        java.lang.reflect.Field[] fieldArray = clazz.getFields();
        Field[] fieldArray2 = new Field[fieldArray.length];
        int n2 = fieldArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            fieldArray2[i2] = new Field(fieldArray[i2]);
        }
        return fieldArray2;
    }

    public static Field getField(Class clazz, String string) {
        try {
            return new Field(clazz.getField(string));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation while getting field: " + string + ", for class: " + clazz.getName(), securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new ReflectionException("Field not found: " + string + ", for class: " + clazz.getName(), noSuchFieldException);
        }
    }

    public static Field[] getDeclaredFields(Class clazz) {
        java.lang.reflect.Field[] fieldArray = clazz.getDeclaredFields();
        Field[] fieldArray2 = new Field[fieldArray.length];
        int n2 = fieldArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            fieldArray2[i2] = new Field(fieldArray[i2]);
        }
        return fieldArray2;
    }

    public static Field getDeclaredField(Class clazz, String string) {
        try {
            return new Field(clazz.getDeclaredField(string));
        }
        catch (SecurityException securityException) {
            throw new ReflectionException("Security violation while getting field: " + string + ", for class: " + clazz.getName(), securityException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new ReflectionException("Field not found: " + string + ", for class: " + clazz.getName(), noSuchFieldException);
        }
    }

    public static boolean isAnnotationPresent(Class clazz, Class<? extends java.lang.annotation.Annotation> clazz2) {
        return clazz.isAnnotationPresent(clazz2);
    }

    public static Annotation[] getAnnotations(Class clazz) {
        java.lang.annotation.Annotation[] annotationArray = clazz.getAnnotations();
        Annotation[] annotationArray2 = new Annotation[annotationArray.length];
        for (int i2 = 0; i2 < annotationArray.length; ++i2) {
            annotationArray2[i2] = new Annotation(annotationArray[i2]);
        }
        return annotationArray2;
    }

    public static Annotation getAnnotation(Class clazz, Class<? extends java.lang.annotation.Annotation> clazz2) {
        java.lang.annotation.Annotation annotation = clazz.getAnnotation(clazz2);
        if (annotation != null) {
            return new Annotation(annotation);
        }
        return null;
    }

    public static Annotation[] getDeclaredAnnotations(Class clazz) {
        java.lang.annotation.Annotation[] annotationArray = clazz.getDeclaredAnnotations();
        Annotation[] annotationArray2 = new Annotation[annotationArray.length];
        for (int i2 = 0; i2 < annotationArray.length; ++i2) {
            annotationArray2[i2] = new Annotation(annotationArray[i2]);
        }
        return annotationArray2;
    }

    public static Annotation getDeclaredAnnotation(Class clazz, Class<? extends java.lang.annotation.Annotation> clazz2) {
        java.lang.annotation.Annotation[] annotationArray;
        for (java.lang.annotation.Annotation annotation : annotationArray = clazz.getDeclaredAnnotations()) {
            if (!annotation.annotationType().equals(clazz2)) continue;
            return new Annotation(annotation);
        }
        return null;
    }

    public static Class[] getInterfaces(Class clazz) {
        return clazz.getInterfaces();
    }
}

