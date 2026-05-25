/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.NOT_COMPLIANT)
public class FailingInstantiator<T>
implements ObjectInstantiator<T> {
    public FailingInstantiator(Class<T> clazz) {
    }

    @Override
    public T newInstance() {
        throw new ObjenesisException("Always failing");
    }
}

