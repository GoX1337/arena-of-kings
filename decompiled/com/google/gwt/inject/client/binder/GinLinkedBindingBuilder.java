/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Key
 *  com.google.inject.Provider
 *  com.google.inject.TypeLiteral
 */
package com.google.gwt.inject.client.binder;

import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GinLinkedBindingBuilder<T>
extends GinScopedBindingBuilder {
    public <I extends T> GinScopedBindingBuilder to(Class<I> var1);

    public <I extends T> GinScopedBindingBuilder to(TypeLiteral<I> var1);

    public <I extends T> GinScopedBindingBuilder to(Key<I> var1);

    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Class<I> var1);

    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Key<I> var1);
}

