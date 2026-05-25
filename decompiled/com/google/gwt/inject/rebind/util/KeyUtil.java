/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.typeinfo.HasAnnotations
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JArrayType
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JField
 *  com.google.gwt.core.ext.typeinfo.JGenericType
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.JParameter
 *  com.google.gwt.core.ext.typeinfo.JPrimitiveType
 *  com.google.gwt.core.ext.typeinfo.JType
 *  com.google.gwt.core.ext.typeinfo.JWildcardType
 *  com.google.gwt.core.ext.typeinfo.JWildcardType$BoundType
 *  com.google.gwt.core.ext.typeinfo.NotFoundException
 *  com.google.gwt.core.ext.typeinfo.TypeOracle
 *  com.google.inject.BindingAnnotation
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.ProvisionException
 *  com.google.inject.Singleton
 *  com.google.inject.util.Types
 */
package com.google.gwt.inject.rebind.util;

import com.google.gwt.core.ext.typeinfo.HasAnnotations;
import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JGenericType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.JWildcardType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.rebind.binding.Injectable;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.MemberCollector;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.ProvisionException;
import com.google.inject.Singleton;
import com.google.inject.util.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Singleton
public class KeyUtil {
    private final TypeOracle typeOracle;
    private final NameGenerator nameGenerator;
    private final MemberCollector memberCollector;

    @Inject
    public KeyUtil(TypeOracle typeOracle, NameGenerator nameGenerator, @Injectable MemberCollector memberCollector) {
        this.typeOracle = typeOracle;
        this.nameGenerator = nameGenerator;
        this.memberCollector = memberCollector;
    }

    public Key<?> getKey(JMethod jMethod) {
        if (this.isMemberInject(jMethod)) {
            return this.getKey(jMethod.getParameters()[0]);
        }
        return this.getKey(jMethod.getReturnType(), KeyUtil.getAnnotations(JAbstractMethod.class, jMethod));
    }

    public Key<?> getKey(JParameter jParameter) {
        return this.getKey(jParameter.getType(), KeyUtil.getAnnotations(JParameter.class, jParameter));
    }

    public Key<?> getKey(JField jField) {
        return this.getKey(jField.getType(), KeyUtil.getAnnotations(JField.class, jField));
    }

    public boolean isMemberInject(JMethod jMethod) {
        return jMethod.getReturnType() == JPrimitiveType.VOID;
    }

    public Class<?> getRawType(Key<?> key) {
        Type type = key.getTypeLiteral().getType();
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            return (Class)((ParameterizedType)type).getRawType();
        }
        throw new ProvisionException("Can't get raw type for " + key);
    }

    public JClassType getRawClassType(Key<?> key) {
        return this.getClassType(this.getRawType(key));
    }

    public JClassType getClassType(Key<?> key) {
        return this.getClassType(key.getTypeLiteral().getType());
    }

    public JClassType getClassType(Type type) {
        if (type instanceof Class) {
            return this.typeOracle.findType(((Class)type).getCanonicalName());
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            JClassType[] jClassTypeArray = new JClassType[parameterizedType.getActualTypeArguments().length];
            int n2 = 0;
            for (Type type2 : parameterizedType.getActualTypeArguments()) {
                jClassTypeArray[n2++] = this.getClassType(type2);
            }
            Class clazz = (Class)parameterizedType.getRawType();
            JClassType jClassType = this.typeOracle.findType(clazz.getCanonicalName());
            JGenericType jGenericType = jClassType.isGenericType();
            if (jGenericType == null) {
                throw new ProvisionException("Can't get class type for " + type);
            }
            return this.typeOracle.getParameterizedType(jGenericType, jGenericType.getEnclosingType(), jClassTypeArray);
        }
        throw new ProvisionException("Can't get class type for " + type);
    }

    public Key<?> getKey(JType jType, Annotation ... annotationArray) {
        try {
            Type type = this.gwtTypeToJavaType(jType);
            return this.getKey(type, annotationArray);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ProvisionException("Error creating key for " + jType, (Throwable)classNotFoundException);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new ProvisionException("Error creating key for " + jType, (Throwable)noSuchFieldException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ProvisionException("Error creating key for " + jType, (Throwable)illegalAccessException);
        }
    }

    public Key<?> getKey(Type type, Annotation ... annotationArray) {
        Annotation annotation = this.getBindingAnnotation(annotationArray);
        if (annotation == null) {
            return Key.get((Type)type);
        }
        return Key.get((Type)type, (Annotation)annotation);
    }

    public JMethod javaToGwtMethod(Method method) {
        JClassType jClassType = this.typeOracle.findType(method.getDeclaringClass().getCanonicalName());
        JMethod jMethod = null;
        for (JMethod jMethod2 : jClassType.getMethods()) {
            Class<?>[] classArray;
            JParameter[] jParameterArray;
            if (!jMethod2.getName().equals(method.getName()) || (jParameterArray = jMethod2.getParameters()).length != (classArray = method.getParameterTypes()).length) continue;
            boolean bl2 = true;
            for (int i2 = 0; i2 < jParameterArray.length; ++i2) {
                bl2 = bl2 && jParameterArray[i2].getType().getQualifiedSourceName().equals(classArray[i2].getCanonicalName());
            }
            if (!bl2) continue;
            jMethod = jMethod2;
            break;
        }
        if (jMethod == null) {
            throw new NotFoundException("Couldn't locate requested method in source: " + method);
        }
        return jMethod;
    }

    public JField javaToGwtField(Field field) {
        JClassType jClassType = this.typeOracle.findType(field.getDeclaringClass().getCanonicalName());
        return jClassType.getField(field.getName());
    }

    public boolean isOptional(HasAnnotations hasAnnotations) {
        Inject inject = (Inject)hasAnnotations.getAnnotation(Inject.class);
        return inject != null && inject.optional();
    }

    public RequiredKeys getRequiredKeys(JClassType jClassType) {
        Key<?> key;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (JMethod jMethod : this.memberCollector.getMethods(jClassType)) {
            key = this.getRequiredKeys((JAbstractMethod)jMethod);
            hashSet.addAll(key.getRequiredKeys());
            hashSet2.addAll(key.getOptionalKeys());
        }
        for (JField jField : this.memberCollector.getFields(jClassType)) {
            key = this.getKey(jField);
            if (this.isOptional((HasAnnotations)jField)) {
                hashSet2.add(key);
                continue;
            }
            hashSet.add(key);
        }
        return new RequiredKeys(hashSet, hashSet2);
    }

    public RequiredKeys getRequiredKeys(JAbstractMethod jAbstractMethod) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (JParameter jParameter : jAbstractMethod.getParameters()) {
            Key<?> key = this.getKey(jParameter);
            if (this.isOptional((HasAnnotations)jAbstractMethod)) {
                hashSet2.add(key);
                continue;
            }
            hashSet.add(key);
        }
        return new RequiredKeys(hashSet, hashSet2);
    }

    private Annotation getBindingAnnotation(Annotation[] annotationArray) {
        if (annotationArray == null || annotationArray.length == 0) {
            return null;
        }
        Annotation annotation = null;
        for (Annotation annotation2 : annotationArray) {
            if (annotation2.annotationType().getAnnotation(BindingAnnotation.class) == null) continue;
            if (annotation != null) {
                throw new ProvisionException(">1 binding annotation found: " + annotation2 + ", " + annotation);
            }
            annotation = annotation2;
        }
        return annotation;
    }

    private Type gwtTypeToJavaType(JType jType) {
        Object object;
        JPrimitiveType jPrimitiveType = jType.isPrimitive();
        if (jPrimitiveType != null) {
            return KeyUtil.loadClass((JType)jPrimitiveType);
        }
        JArrayType jArrayType = jType.isArray();
        if (jType.isArray() != null) {
            Type type = this.gwtTypeToJavaType(jArrayType.getComponentType());
            return Types.arrayOf((Type)type);
        }
        JWildcardType jWildcardType = jType.isWildcard();
        if (jWildcardType != null) {
            object = this.gwtTypeToJavaType((JType)jWildcardType.getBaseType());
            switch (jWildcardType.getBoundType()) {
                case EXTENDS: {
                    return Types.subtypeOf((Type)object);
                }
                case SUPER: {
                    return Types.supertypeOf((Type)object);
                }
            }
        }
        object = jType.isParameterized();
        if (jType.isParameterized() != null) {
            JClassType[] jClassTypeArray = object.getTypeArgs();
            ArrayList<Type> arrayList = new ArrayList<Type>();
            for (JClassType jClassType : jClassTypeArray) {
                JWildcardType jWildcardType2 = jClassType.isWildcard();
                if (jWildcardType2 != null && jWildcardType2.getBoundType() == JWildcardType.BoundType.UNBOUND) continue;
                arrayList.add(this.gwtTypeToJavaType((JType)jClassType));
            }
            Type type = this.gwtTypeToJavaType((JType)object.getRawType());
            if (object.getEnclosingType() != null) {
                return Types.newParameterizedTypeWithOwner((Type)this.gwtTypeToJavaType((JType)object.getEnclosingType()), (Type)type, (Type[])arrayList.toArray(new Type[arrayList.size()]));
            }
            return Types.newParameterizedType((Type)type, (Type[])arrayList.toArray(new Type[arrayList.size()]));
        }
        JClassType jClassType = jType.isClassOrInterface();
        if (jType.isClassOrInterface() != null) {
            return KeyUtil.loadClass((JType)jClassType);
        }
        throw new ProvisionException("Unknown GWT type: " + jType);
    }

    private static Class<?> loadClass(JType jType) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        JPrimitiveType jPrimitiveType = jType.isPrimitive();
        if (jPrimitiveType != null) {
            String string = jPrimitiveType.getQualifiedBoxedSourceName();
            Class<?> clazz = Class.forName(string, false, classLoader);
            return (Class)clazz.getField("TYPE").get(null);
        }
        JClassType jClassType = jType.isClassOrInterface();
        if (jClassType == null) {
            throw new UnsupportedOperationException("Cannot load " + jType + ".");
        }
        return Class.forName(KeyUtil.getBinaryName((JClassType)jType), false, classLoader);
    }

    private static String getBinaryName(JClassType jClassType) {
        JClassType jClassType2 = jClassType.getEnclosingType();
        if (jClassType2 != null) {
            return KeyUtil.getBinaryName(jClassType2) + "$" + jClassType.getSimpleSourceName();
        }
        return jClassType.getQualifiedSourceName();
    }

    private static <T> Annotation[] getAnnotations(Class<T> clazz, T t2) {
        try {
            Method method = clazz.getDeclaredMethod("getAnnotations", new Class[0]);
            method.setAccessible(true);
            return (Annotation[])method.invoke(t2, new Object[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ProvisionException("Failed to get annotations from " + t2, (Throwable)noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ProvisionException("Failed to get annotations from " + t2, (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new ProvisionException("Failed to get annotations from " + t2, (Throwable)invocationTargetException);
        }
    }
}

