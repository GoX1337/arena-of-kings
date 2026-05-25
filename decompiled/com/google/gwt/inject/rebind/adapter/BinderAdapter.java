/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Binder
 *  com.google.inject.Module
 *  com.google.inject.TypeLiteral
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinAnnotatedConstantBindingBuilder;
import com.google.gwt.inject.client.binder.GinBinder;
import com.google.gwt.inject.rebind.adapter.AnnotatedBindingBuilderAdapter;
import com.google.gwt.inject.rebind.adapter.AnnotatedConstantBindingBuilderAdapter;
import com.google.gwt.inject.rebind.adapter.GinModuleAdapter;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class BinderAdapter
implements GinBinder {
    private final Binder binder;

    BinderAdapter(Binder binder) {
        this.binder = binder;
    }

    @Override
    public <T> GinAnnotatedBindingBuilder<T> bind(Class<T> clazz) {
        return new AnnotatedBindingBuilderAdapter(this.binder.bind(clazz));
    }

    @Override
    public <T> GinAnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
        return new AnnotatedBindingBuilderAdapter(this.binder.bind(typeLiteral));
    }

    @Override
    public GinAnnotatedConstantBindingBuilder bindConstant() {
        return new AnnotatedConstantBindingBuilderAdapter(this.binder.bindConstant());
    }

    @Override
    public void install(GinModule ginModule) {
        this.binder.install((Module)new GinModuleAdapter(ginModule));
    }

    @Override
    public void requestStaticInjection(Class<?> ... classArray) {
        this.binder.requestStaticInjection((Class[])classArray);
    }
}

