/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.sun;

import java.io.NotSerializableException;
import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.SerializationInstantiatorHelper;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.SERIALIZATION)
public class SunReflectionFactorySerializationInstantiator<T>
implements ObjectInstantiator<T> {
    private final Constructor<T> mungedConstructor;

    public SunReflectionFactorySerializationInstantiator(Class<T> clazz) {
        Constructor<T> constructor;
        Class<T> clazz2 = SerializationInstantiatorHelper.getNonSerializableSuperClass(clazz);
        try {
            constructor = clazz2.getDeclaredConstructor(null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException(new NotSerializableException(clazz + " has no suitable superclass constructor"));
        }
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
}

