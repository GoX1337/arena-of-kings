/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.binder.ScopedBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class ScopedBindingBuilderAdapter
implements GinScopedBindingBuilder {
    private final ScopedBindingBuilder scopedBindingBuilder;

    public ScopedBindingBuilderAdapter(ScopedBindingBuilder scopedBindingBuilder) {
        this.scopedBindingBuilder = scopedBindingBuilder;
    }

    @Override
    public void in(Class<? extends Annotation> clazz) {
        this.scopedBindingBuilder.in(clazz);
    }

    @Override
    public void asEagerSingleton() {
        this.scopedBindingBuilder.asEagerSingleton();
    }
}

