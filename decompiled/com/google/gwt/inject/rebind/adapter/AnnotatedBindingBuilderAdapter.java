/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Key
 *  com.google.inject.Provider
 *  com.google.inject.TypeLiteral
 *  com.google.inject.binder.AnnotatedBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinLinkedBindingBuilder;
import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.google.gwt.inject.rebind.adapter.GwtDotCreateProvider;
import com.google.gwt.inject.rebind.adapter.LinkedBindingBuilderAdapter;
import com.google.gwt.inject.rebind.adapter.ScopedBindingBuilderAdapter;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class AnnotatedBindingBuilderAdapter<T>
implements GinAnnotatedBindingBuilder<T> {
    private final AnnotatedBindingBuilder<T> annotatedBindingBuilder;

    public AnnotatedBindingBuilderAdapter(AnnotatedBindingBuilder<T> annotatedBindingBuilder) {
        this.annotatedBindingBuilder = annotatedBindingBuilder;
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(Class<I> clazz) {
        return new ScopedBindingBuilderAdapter(this.annotatedBindingBuilder.to(clazz));
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(TypeLiteral<I> typeLiteral) {
        return new ScopedBindingBuilderAdapter(this.annotatedBindingBuilder.to(typeLiteral));
    }

    @Override
    public <I extends T> GinScopedBindingBuilder to(Key<I> key) {
        return new ScopedBindingBuilderAdapter(this.annotatedBindingBuilder.to(key));
    }

    @Override
    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Key<I> key) {
        return new ScopedBindingBuilderAdapter(this.annotatedBindingBuilder.toProvider(key));
    }

    @Override
    public <I extends Provider<? extends T>> GinScopedBindingBuilder toProvider(Class<I> clazz) {
        return new ScopedBindingBuilderAdapter(this.annotatedBindingBuilder.toProvider(clazz));
    }

    @Override
    public GinLinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> clazz) {
        return new LinkedBindingBuilderAdapter(this.annotatedBindingBuilder.annotatedWith(clazz));
    }

    @Override
    public GinLinkedBindingBuilder<T> annotatedWith(Annotation annotation) {
        return new LinkedBindingBuilderAdapter(this.annotatedBindingBuilder.annotatedWith(annotation));
    }

    @Override
    public void asEagerSingleton() {
        GwtDotCreateProvider.bind(this.annotatedBindingBuilder).asEagerSingleton();
    }

    @Override
    public void in(Class<? extends Annotation> clazz) {
        GwtDotCreateProvider.bind(this.annotatedBindingBuilder).in(clazz);
    }
}

