/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.NOT_COMPLIANT)
public class ConstructorInstantiator<T>
implements ObjectInstantiator<T> {
    protected Constructor<T> constructor;

    public ConstructorInstantiator(Class<T> clazz) {
        try {
            this.constructor = clazz.getDeclaredConstructor(null);
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }

    @Override
    public T newInstance() {
        try {
            return this.constructor.newInstance(null);
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }
}

