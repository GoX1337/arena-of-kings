/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Provider
 *  com.google.inject.binder.LinkedBindingBuilder
 *  com.google.inject.binder.ScopedBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.inject.Provider;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GwtDotCreateProvider<T>
implements Provider<T> {
    static <T> ScopedBindingBuilder bind(LinkedBindingBuilder<T> linkedBindingBuilder) {
        return linkedBindingBuilder.toProvider(new GwtDotCreateProvider<T>());
    }

    private GwtDotCreateProvider() {
    }

    public T get() {
        throw new AssertionError((Object)"should never be actually called");
    }
}

