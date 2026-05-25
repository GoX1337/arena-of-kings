/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.gcj;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.SerializationInstantiatorHelper;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.gcj.GCJInstantiatorBase;

@Instantiator(value=Typology.SERIALIZATION)
public class GCJSerializationInstantiator<T>
extends GCJInstantiatorBase<T> {
    private final Class<? super T> superType;

    public GCJSerializationInstantiator(Class<T> clazz) {
        super(clazz);
        this.superType = SerializationInstantiatorHelper.getNonSerializableSuperClass(clazz);
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(newObjectMethod.invoke((Object)dummyStream, this.type, this.superType));
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }
}

