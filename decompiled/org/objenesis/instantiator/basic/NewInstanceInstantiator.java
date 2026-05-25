/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.util.ClassUtils;

@Instantiator(value=Typology.NOT_COMPLIANT)
public class NewInstanceInstantiator<T>
implements ObjectInstantiator<T> {
    private final Class<T> type;

    public NewInstanceInstantiator(Class<T> clazz) {
        this.type = clazz;
    }

    @Override
    public T newInstance() {
        return ClassUtils.newInstance(this.type);
    }
}

