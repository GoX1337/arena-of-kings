/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.gcj;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.gcj.GCJInstantiatorBase;

@Instantiator(value=Typology.STANDARD)
public class GCJInstantiator<T>
extends GCJInstantiatorBase<T> {
    public GCJInstantiator(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(newObjectMethod.invoke((Object)dummyStream, this.type, Object.class));
        }
        catch (IllegalAccessException | RuntimeException | InvocationTargetException exception) {
            throw new ObjenesisException(exception);
        }
    }
}

