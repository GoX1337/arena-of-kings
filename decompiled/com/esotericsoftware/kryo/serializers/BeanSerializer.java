/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.MethodAccess;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BeanSerializer<T>
extends Serializer<T> {
    static final Object[] noArgs = new Object[0];
    private CachedProperty[] properties;
    Object access;

    public BeanSerializer(Kryo kryo, Class clazz) {
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        }
        catch (IntrospectionException introspectionException) {
            throw new KryoException("Error getting bean info.", introspectionException);
        }
        PropertyDescriptor[] propertyDescriptorArray = beanInfo.getPropertyDescriptors();
        Arrays.sort(propertyDescriptorArray, new Comparator<PropertyDescriptor>(){

            @Override
            public int compare(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
                return propertyDescriptor.getName().compareTo(propertyDescriptor2.getName());
            }
        });
        ArrayList arrayList = new ArrayList(propertyDescriptorArray.length);
        for (PropertyDescriptor object : propertyDescriptorArray) {
            String string = object.getName();
            if (string.equals("class")) continue;
            Method method = object.getReadMethod();
            Method method2 = object.getWriteMethod();
            if (method == null || method2 == null) continue;
            Serializer serializer = null;
            Class<?> clazz2 = method.getReturnType();
            if (kryo.isFinal(clazz2)) {
                serializer = kryo.getRegistration(clazz2).getSerializer();
            }
            CachedProperty cachedProperty = new CachedProperty();
            cachedProperty.name = string;
            cachedProperty.getMethod = method;
            cachedProperty.setMethod = method2;
            cachedProperty.serializer = serializer;
            cachedProperty.setMethodType = method2.getParameterTypes()[0];
            arrayList.add(cachedProperty);
        }
        this.properties = arrayList.toArray(new CachedProperty[arrayList.size()]);
        try {
            this.access = MethodAccess.get(clazz);
            for (CachedProperty cachedProperty : this.properties) {
                cachedProperty.getterAccessIndex = ((MethodAccess)this.access).getIndex(cachedProperty.getMethod.getName(), cachedProperty.getMethod.getParameterTypes());
                cachedProperty.setterAccessIndex = ((MethodAccess)this.access).getIndex(cachedProperty.setMethod.getName(), cachedProperty.setMethod.getParameterTypes());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        Class<?> clazz = t2.getClass();
        for (CachedProperty cachedProperty : this.properties) {
            Object object;
            try {
                if (Log.TRACE) {
                    Log.trace("kryo", "Write property: " + cachedProperty + " (" + clazz.getName() + ")");
                }
                Object object2 = cachedProperty.get(t2);
                object = cachedProperty.serializer;
                if (object != null) {
                    kryo.writeObjectOrNull(output, object2, (Serializer)object);
                    continue;
                }
                kryo.writeClassAndObject(output, object2);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new KryoException("Error accessing getter method: " + cachedProperty + " (" + clazz.getName() + ")", illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new KryoException("Error invoking getter method: " + cachedProperty + " (" + clazz.getName() + ")", invocationTargetException);
            }
            catch (KryoException kryoException) {
                kryoException.addTrace(cachedProperty + " (" + clazz.getName() + ")");
                throw kryoException;
            }
            catch (Throwable throwable) {
                object = new KryoException(throwable);
                ((KryoException)object).addTrace(cachedProperty + " (" + clazz.getName() + ")");
                throw object;
            }
        }
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        T t2 = kryo.newInstance(clazz);
        kryo.reference(t2);
        for (CachedProperty cachedProperty : this.properties) {
            Object object;
            try {
                if (Log.TRACE) {
                    Log.trace("kryo", "Read property: " + cachedProperty + " (" + t2.getClass() + ")");
                }
                Object object2 = (object = cachedProperty.serializer) != null ? kryo.readObjectOrNull(input, cachedProperty.setMethodType, (Serializer)object) : kryo.readClassAndObject(input);
                cachedProperty.set(t2, object2);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new KryoException("Error accessing setter method: " + cachedProperty + " (" + t2.getClass().getName() + ")", illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new KryoException("Error invoking setter method: " + cachedProperty + " (" + t2.getClass().getName() + ")", invocationTargetException);
            }
            catch (KryoException kryoException) {
                kryoException.addTrace(cachedProperty + " (" + t2.getClass().getName() + ")");
                throw kryoException;
            }
            catch (Throwable throwable) {
                object = new KryoException(throwable);
                ((KryoException)object).addTrace(cachedProperty + " (" + t2.getClass().getName() + ")");
                throw object;
            }
        }
        return t2;
    }

    @Override
    public T copy(Kryo kryo, T t2) {
        Object obj = kryo.newInstance(t2.getClass());
        for (CachedProperty cachedProperty : this.properties) {
            try {
                Object object = cachedProperty.get(t2);
                cachedProperty.set(obj, object);
            }
            catch (KryoException kryoException) {
                kryoException.addTrace(cachedProperty + " (" + obj.getClass().getName() + ")");
                throw kryoException;
            }
            catch (Exception exception) {
                throw new KryoException("Error copying bean property: " + cachedProperty + " (" + obj.getClass().getName() + ")", exception);
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(cachedProperty + " (" + obj.getClass().getName() + ")");
                throw kryoException;
            }
        }
        return (T)obj;
    }

    class CachedProperty<X> {
        String name;
        Method getMethod;
        Method setMethod;
        Class setMethodType;
        Serializer serializer;
        int getterAccessIndex;
        int setterAccessIndex;

        CachedProperty() {
        }

        public String toString() {
            return this.name;
        }

        Object get(Object object) {
            if (BeanSerializer.this.access != null) {
                return ((MethodAccess)BeanSerializer.this.access).invoke(object, this.getterAccessIndex, new Object[0]);
            }
            return this.getMethod.invoke(object, noArgs);
        }

        void set(Object object, Object object2) {
            if (BeanSerializer.this.access != null) {
                ((MethodAccess)BeanSerializer.this.access).invoke(object, this.setterAccessIndex, object2);
                return;
            }
            this.setMethod.invoke(object, object2);
        }
    }
}

