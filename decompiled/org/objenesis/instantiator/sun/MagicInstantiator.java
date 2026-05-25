/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.sun;

import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.basic.DelegatingToExoticInstantiator;

@Instantiator(value=Typology.STANDARD)
public class MagicInstantiator<T>
extends DelegatingToExoticInstantiator<T> {
    public MagicInstantiator(Class<T> clazz) {
        super("org.objenesis.instantiator.exotic.MagicInstantiator", clazz);
    }
}

