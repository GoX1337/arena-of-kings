/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.reflect;

import com.badlogic.gdx.utils.reflect.Annotation;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public final class Method {
    private final java.lang.reflect.Method method;

    Method(java.lang.reflect.Method method) {
        this.method = method;
    }

    public String getName() {
        return this.method.getName();
    }

    public Class getReturnType() {
        return this.method.getReturnType();
    }

    public Class[] getParameterTypes() {
        return this.method.getParameterTypes();
    }

    public Class getDeclaringClass() {
        return this.method.getDeclaringClass();
    }

    public boolean isAccessible() {
        return this.method.isAccessible();
    }

    public void setAccessible(boolean bl2) {
        this.method.setAccessible(bl2);
    }

    public boolean isAbstract() {
        return Modifier.isAbstract(this.method.getModifiers());
    }

    public boolean isDefaultAccess() {
        return !this.isPrivate() && !this.isProtected() && !this.isPublic();
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.method.getModifiers());
    }

    public boolean isPrivate() {
        return Modifier.isPrivate(this.method.getModifiers());
    }

    public boolean isProtected() {
        return Modifier.isProtected(this.method.getModifiers());
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.method.getModifiers());
    }

    public boolean isNative() {
        return Modifier.isNative(this.method.getModifiers());
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.method.getModifiers());
    }

    public boolean isVarArgs() {
        return this.method.isVarArgs();
    }

    public Object invoke(Object object, Object ... objectArray) {
        try {
            return this.method.invoke(object, objectArray);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ReflectionException("Illegal argument(s) supplied to method: " + this.getName(), illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ReflectionException("Illegal access to method: " + this.getName(), illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new ReflectionException("Exception occurred in method: " + this.getName(), invocationTargetException);
        }
    }

    public boolean isAnnotationPresent(Class<? extends java.lang.annotation.Annotation> clazz) {
        return this.method.isAnnotationPresent(clazz);
    }

    public Annotation[] getDeclaredAnnotations() {
        java.lang.annotation.Annotation[] annotationArray = this.method.getDeclaredAnnotations();
        Annotation[] annotationArray2 = new Annotation[annotationArray.length];
        for (int i2 = 0; i2 < annotationArray.length; ++i2) {
            annotationArray2[i2] = new Annotation(annotationArray[i2]);
        }
        return annotationArray2;
    }

    public Annotation getDeclaredAnnotation(Class<? extends java.lang.annotation.Annotation> clazz) {
        java.lang.annotation.Annotation[] annotationArray = this.method.getDeclaredAnnotations();
        if (annotationArray == null) {
            return null;
        }
        for (java.lang.annotation.Annotation annotation : annotationArray) {
            if (!annotation.annotationType().equals(clazz)) continue;
            return new Annotation(annotation);
        }
        return null;
    }
}

