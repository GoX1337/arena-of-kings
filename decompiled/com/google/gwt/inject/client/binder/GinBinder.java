/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.TypeLiteral
 */
package com.google.gwt.inject.client.binder;

import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinAnnotatedConstantBindingBuilder;
import com.google.inject.TypeLiteral;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GinBinder {
    public <T> GinAnnotatedBindingBuilder<T> bind(Class<T> var1);

    public <T> GinAnnotatedBindingBuilder<T> bind(TypeLiteral<T> var1);

    public GinAnnotatedConstantBindingBuilder bindConstant();

    public void install(GinModule var1);

    public void requestStaticInjection(Class<?> ... var1);
}

