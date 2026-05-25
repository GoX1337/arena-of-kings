/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.TypeLiteral
 */
package com.google.gwt.inject.client;

import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinAnnotatedConstantBindingBuilder;
import com.google.gwt.inject.client.binder.GinBinder;
import com.google.inject.TypeLiteral;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractGinModule
implements GinModule {
    private GinBinder binder;

    @Override
    public final void configure(GinBinder ginBinder) {
        this.binder = ginBinder;
        this.configure();
    }

    protected abstract void configure();

    protected final <T> GinAnnotatedBindingBuilder<T> bind(Class<T> clazz) {
        return this.binder.bind(clazz);
    }

    protected final <T> GinAnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
        return this.binder.bind(typeLiteral);
    }

    protected final GinAnnotatedConstantBindingBuilder bindConstant() {
        return this.binder.bindConstant();
    }

    protected final void install(GinModule ginModule) {
        this.binder.install(ginModule);
    }

    protected void requestStaticInjection(Class<?> ... classArray) {
        this.binder.requestStaticInjection(classArray);
    }

    protected GinBinder binder() {
        return this.binder;
    }
}

