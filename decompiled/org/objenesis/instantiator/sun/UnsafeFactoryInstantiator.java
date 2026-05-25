/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.sun;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

@Instantiator(value=Typology.STANDARD)
public class UnsafeFactoryInstantiator<T>
implements ObjectInstantiator<T> {
    private final Unsafe unsafe = UnsafeUtils.getUnsafe();
    private final Class<T> type;

    public UnsafeFactoryInstantiator(Class<T> clazz) {
        this.type = clazz;
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(this.unsafe.allocateInstance(this.type));
        }
        catch (InstantiationException instantiationException) {
            throw new ObjenesisException(instantiationException);
        }
    }
}

