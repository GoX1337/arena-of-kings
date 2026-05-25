/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public abstract class DelegatingToExoticInstantiator<T>
implements ObjectInstantiator<T> {
    private final ObjectInstantiator<T> wrapped;

    public DelegatingToExoticInstantiator(String string, Class<T> clazz) {
        Class<ObjectInstantiator<T>> clazz2 = this.instantiatorClass(string);
        Constructor<ObjectInstantiator<T>> constructor = this.instantiatorConstructor(string, clazz2);
        this.wrapped = this.instantiator(string, clazz, constructor);
    }

    private ObjectInstantiator<T> instantiator(String string, Class<T> clazz, Constructor<ObjectInstantiator<T>> constructor) {
        try {
            return constructor.newInstance(clazz);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException("Failed to call constructor of " + string, reflectiveOperationException);
        }
    }

    private Class<ObjectInstantiator<T>> instantiatorClass(String string) {
        try {
            Class<ObjectInstantiator<T>> clazz = Class.forName(string);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ObjenesisException(this.getClass().getSimpleName() + " now requires objenesis-exotic to be in the classpath", classNotFoundException);
        }
    }

    private Constructor<ObjectInstantiator<T>> instantiatorConstructor(String string, Class<ObjectInstantiator<T>> clazz) {
        try {
            return clazz.getConstructor(Class.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException("Try to find constructor taking a Class<T> in parameter on " + string + " but can't find it", noSuchMethodException);
        }
    }

    @Override
    public T newInstance() {
        return this.wrapped.newInstance();
    }
}

