/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.KryoException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public class GenericsUtil {
    public static Type resolveType(Class clazz, Class clazz2, Type type) {
        if (type instanceof Class) {
            return type;
        }
        if (type instanceof TypeVariable) {
            return GenericsUtil.resolveTypeVariable(clazz, clazz2, type, true);
        }
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType)type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            int n2 = 1;
            while ((type = ((GenericArrayType)type).getGenericComponentType()) instanceof GenericArrayType) {
                ++n2;
            }
            Type type2 = GenericsUtil.resolveType(clazz, clazz2, type);
            if (!(type2 instanceof Class)) {
                return type;
            }
            if (n2 == 1) {
                return Array.newInstance((Class)type2, 0).getClass();
            }
            return Array.newInstance((Class)type2, new int[n2]).getClass();
        }
        if (type instanceof WildcardType) {
            Type type3 = ((WildcardType)type).getUpperBounds()[0];
            if (type3 != Object.class) {
                return GenericsUtil.resolveType(clazz, clazz2, type3);
            }
            Type[] typeArray = ((WildcardType)type).getLowerBounds();
            if (typeArray.length != 0) {
                return GenericsUtil.resolveType(clazz, clazz2, typeArray[0]);
            }
            return Object.class;
        }
        throw new KryoException("Unable to resolve type: " + type);
    }

    private static Type resolveTypeVariable(Class clazz, Class clazz2, Type object, boolean bl2) {
        Object object2;
        Type type = clazz2.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            return object;
        }
        Class clazz3 = clazz2.getSuperclass();
        if (clazz3 != clazz) {
            object2 = GenericsUtil.resolveTypeVariable(clazz, clazz3, (Type)object, false);
            if (object2 instanceof Class) {
                return object2;
            }
            object = object2;
        }
        object2 = object.toString();
        TypeVariable<Class<T>>[] typeVariableArray = clazz3.getTypeParameters();
        int n2 = typeVariableArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            TypeVariable typeVariable = typeVariableArray[i2];
            if (!typeVariable.getName().equals(object2)) continue;
            Type type2 = ((ParameterizedType)type).getActualTypeArguments()[i2];
            if (type2 instanceof Class) {
                return type2;
            }
            if (type2 instanceof ParameterizedType) {
                return GenericsUtil.resolveType(clazz, clazz2, type2);
            }
            if (type2 instanceof GenericArrayType) {
                return GenericsUtil.resolveType(clazz, clazz2, type2);
            }
            if (!(type2 instanceof TypeVariable)) continue;
            if (bl2) {
                return object;
            }
            return type2;
        }
        return object;
    }

    public static Type[] resolveTypeParameters(Class clazz, Class clazz2, Type type) {
        if (type instanceof ParameterizedType) {
            Type[] typeArray = ((ParameterizedType)type).getActualTypeArguments();
            int n2 = typeArray.length;
            Type[] typeArray2 = new Type[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                typeArray2[i2] = GenericsUtil.resolveType(clazz, clazz2, typeArray[i2]);
            }
            return typeArray2;
        }
        if (type instanceof GenericArrayType) {
            while ((type = ((GenericArrayType)type).getGenericComponentType()) instanceof GenericArrayType) {
            }
            return GenericsUtil.resolveTypeParameters(clazz, clazz2, type);
        }
        return null;
    }
}

