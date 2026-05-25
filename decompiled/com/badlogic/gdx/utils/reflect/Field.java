/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.reflect;

import com.badlogic.gdx.utils.reflect.Annotation;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class Field {
    private final java.lang.reflect.Field field;

    Field(java.lang.reflect.Field field) {
        this.field = field;
    }

    public String getName() {
        return this.field.getName();
    }

    public Class getType() {
        return this.field.getType();
    }

    public Class getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public boolean isAccessible() {
        return this.field.isAccessible();
    }

    public void setAccessible(boolean bl2) {
        this.field.setAccessible(bl2);
    }

    public boolean isDefaultAccess() {
        return !this.isPrivate() && !this.isProtected() && !this.isPublic();
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.field.getModifiers());
    }

    public boolean isPrivate() {
        return Modifier.isPrivate(this.field.getModifiers());
    }

    public boolean isProtected() {
        return Modifier.isProtected(this.field.getModifiers());
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.field.getModifiers());
    }

    public boolean isStatic() {
        return Modifier.isStatic(this.field.getModifiers());
    }

    public boolean isTransient() {
        return Modifier.isTransient(this.field.getModifiers());
    }

    public boolean isVolatile() {
        return Modifier.isVolatile(this.field.getModifiers());
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }

    public Class getElementType(int n2) {
        Type[] typeArray;
        Type type = this.field.getGenericType();
        if (type instanceof ParameterizedType && (typeArray = ((ParameterizedType)type).getActualTypeArguments()).length - 1 >= n2) {
            Type type2;
            Type type3 = typeArray[n2];
            if (type3 instanceof Class) {
                return (Class)type3;
            }
            if (type3 instanceof ParameterizedType) {
                return (Class)((ParameterizedType)type3).getRawType();
            }
            if (type3 instanceof GenericArrayType && (type2 = ((GenericArrayType)type3).getGenericComponentType()) instanceof Class) {
                return ArrayReflection.newInstance((Class)type2, 0).getClass();
            }
        }
        return null;
    }

    public boolean isAnnotationPresent(Class<? extends java.lang.annotation.Annotation> clazz) {
        return this.field.isAnnotationPresent(clazz);
    }

    public Annotation[] getDeclaredAnnotations() {
        java.lang.annotation.Annotation[] annotationArray = this.field.getDeclaredAnnotations();
        Annotation[] annotationArray2 = new Annotation[annotationArray.length];
        for (int i2 = 0; i2 < annotationArray.length; ++i2) {
            annotationArray2[i2] = new Annotation(annotationArray[i2]);
        }
        return annotationArray2;
    }

    public Annotation getDeclaredAnnotation(Class<? extends java.lang.annotation.Annotation> clazz) {
        java.lang.annotation.Annotation[] annotationArray = this.field.getDeclaredAnnotations();
        if (annotationArray == null) {
            return null;
        }
        for (java.lang.annotation.Annotation annotation : annotationArray) {
            if (!annotation.annotationType().equals(clazz)) continue;
            return new Annotation(annotation);
        }
        return null;
    }

    public Object get(Object object) {
        try {
            return this.field.get(object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ReflectionException("Object is not an instance of " + this.getDeclaringClass(), illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ReflectionException("Illegal access to field: " + this.getName(), illegalAccessException);
        }
    }

    public void set(Object object, Object object2) {
        try {
            this.field.set(object, object2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ReflectionException("Argument not valid for field: " + this.getName(), illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ReflectionException("Illegal access to field: " + this.getName(), illegalAccessException);
        }
    }
}

