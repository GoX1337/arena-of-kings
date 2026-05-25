/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.basic.DelegatingToExoticInstantiator;

@Instantiator(value=Typology.STANDARD)
public class ProxyingInstantiator<T>
extends DelegatingToExoticInstantiator<T> {
    public ProxyingInstantiator(Class<T> clazz) {
        super("org.objenesis.instantiator.exotic.ProxyingInstantiator", clazz);
    }
}

