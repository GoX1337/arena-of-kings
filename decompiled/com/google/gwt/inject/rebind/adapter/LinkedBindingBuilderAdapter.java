/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Key
 *  com.google.inject.Provider
 *  com.google.inject.TypeLiteral
 *  com.google.inject.binder.LinkedBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinLinkedBindingBuilder;
import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.google.gwt.inject.rebind.adapter.GwtDotCreateProvider;
import com.google.gwt.inject.rebind.adapter.ScopedBindingBuilderAdapter;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class LinkedBindingBuilderAdapter<T>
implements GinLinkedBindingBuilder<T> {
    private final LinkedBindingBuilder<T> linkedBindingBuilder;

    public LinkedBindingBuilderAdapter(LinkedBindingBuilder<T> linkedBindingBuilder) {
        this.linkedBindingBuilder = linkedBindingBuilder;
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(TypeLiteral<I> typeLiteral) {
        return new ScopedBindingBuilderAdapter(this.linkedBindingBuilder.to(typeLiteral));
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(Key<I> key) {
        return new ScopedBindingBuilderAdapter(this.linkedBindingBuilder.to(key));
    }

    @Override
    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Key<I> key) {
        return new ScopedBindingBuilderAdapter(this.linkedBindingBuilder.toProvider(key));
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(Class<I> clazz) {
        return new ScopedBindingBuilderAdapter(this.linkedBindingBuilder.to(clazz));
    }

    @Override
    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Class<I> clazz) {
        return new ScopedBindingBuilderAdapter(this.linkedBindingBuilder.toProvider(clazz));
    }

    @Override
    public void asEagerSingleton() {
        GwtDotCreateProvider.bind(this.linkedBindingBuilder).asEagerSingleton();
    }

    @Override
    public void in(Class<? extends Annotation> clazz) {
        GwtDotCreateProvider.bind(this.linkedBindingBuilder).in(clazz);
    }
}

