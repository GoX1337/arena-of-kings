/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.NOT_COMPLIANT)
public class NullInstantiator<T>
implements ObjectInstantiator<T> {
    public NullInstantiator(Class<T> clazz) {
    }

    @Override
    public T newInstance() {
        return null;
    }
}

