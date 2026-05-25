/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.sun;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.STANDARD)
public class SunReflectionFactoryInstantiator<T>
implements ObjectInstantiator<T> {
    private final Constructor<T> mungedConstructor;

    public SunReflectionFactoryInstantiator(Class<T> clazz) {
        Constructor<Object> constructor = SunReflectionFactoryInstantiator.getJavaLangObjectConstructor();
        this.mungedConstructor = bze.a(clazz, constructor);
        this.mungedConstructor.setAccessible(true);
    }

    @Override
    public T newInstance() {
        try {
            return this.mungedConstructor.newInstance(null);
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Constructor<Object> getJavaLangObjectConstructor() {
        try {
            return Object.class.getConstructor(null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException(noSuchMethodException);
        }
    }
}

