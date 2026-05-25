/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.strategy;

import org.objenesis.instantiator.ObjectInstantiator;

public interface InstantiatorStrategy {
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> var1);
}

