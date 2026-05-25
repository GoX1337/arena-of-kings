/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis;

import java.util.concurrent.ConcurrentHashMap;
import org.objenesis.Objenesis;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class ObjenesisBase
implements Objenesis {
    protected final InstantiatorStrategy strategy;
    protected ConcurrentHashMap<String, ObjectInstantiator<?>> cache;

    public ObjenesisBase(InstantiatorStrategy instantiatorStrategy) {
        this(instantiatorStrategy, true);
    }

    public ObjenesisBase(InstantiatorStrategy instantiatorStrategy, boolean bl2) {
        if (instantiatorStrategy == null) {
            throw new IllegalArgumentException("A strategy can't be null");
        }
        this.strategy = instantiatorStrategy;
        this.cache = bl2 ? new ConcurrentHashMap() : null;
    }

    public String toString() {
        return this.getClass().getName() + " using " + this.strategy.getClass().getName() + (this.cache == null ? " without" : " with") + " caching";
    }

    @Override
    public <T> T newInstance(Class<T> clazz) {
        return this.getInstantiatorOf(clazz).newInstance();
    }

    @Override
    public <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> clazz) {
        if (clazz.isPrimitive()) {
            throw new IllegalArgumentException("Primitive types can't be instantiated in Java");
        }
        if (this.cache == null) {
            return this.strategy.newInstantiatorOf(clazz);
        }
        ObjectInstantiator<Object> objectInstantiator = this.cache.get(clazz.getName());
        if (objectInstantiator == null) {
            ObjectInstantiator<T> objectInstantiator2 = this.strategy.newInstantiatorOf(clazz);
            objectInstantiator = this.cache.putIfAbsent(clazz.getName(), objectInstantiator2);
            if (objectInstantiator == null) {
                objectInstantiator = objectInstantiator2;
            }
        }
        return objectInstantiator;
    }
}

