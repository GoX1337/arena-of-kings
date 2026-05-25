/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class SingleInstantiatorStrategy
implements InstantiatorStrategy {
    private final Constructor<?> constructor;

    public <T extends ObjectInstantiator<?>> SingleInstantiatorStrategy(Class<T> clazz) {
        try {
            this.constructor = clazz.getConstructor(Class.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException(noSuchMethodException);
        }
    }

    @Override
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> clazz) {
        try {
            return (ObjectInstantiator)this.constructor.newInstance(clazz);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            throw new ObjenesisException(reflectiveOperationException);
        }
    }
}

