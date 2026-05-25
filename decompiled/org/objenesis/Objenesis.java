/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis;

import org.objenesis.instantiator.ObjectInstantiator;

public interface Objenesis {
    public <T> T newInstance(Class<T> var1);

    public <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> var1);
}

