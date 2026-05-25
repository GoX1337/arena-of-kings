/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.basic.ConstructorInstantiator;

@Instantiator(value=Typology.NOT_COMPLIANT)
public class AccessibleInstantiator<T>
extends ConstructorInstantiator<T> {
    public AccessibleInstantiator(Class<T> clazz) {
        super(clazz);
        if (this.constructor != null) {
            this.constructor.setAccessible(true);
        }
    }
}

