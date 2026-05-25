/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.binder.AnnotatedConstantBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinAnnotatedConstantBindingBuilder;
import com.google.gwt.inject.client.binder.GinConstantBindingBuilder;
import com.google.gwt.inject.rebind.adapter.ConstantBindingBuilderAdapter;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class AnnotatedConstantBindingBuilderAdapter
implements GinAnnotatedConstantBindingBuilder {
    private final AnnotatedConstantBindingBuilder guiceBuilder;

    public AnnotatedConstantBindingBuilderAdapter(AnnotatedConstantBindingBuilder annotatedConstantBindingBuilder) {
        this.guiceBuilder = annotatedConstantBindingBuilder;
    }

    @Override
    public GinConstantBindingBuilder annotatedWith(Class<? extends Annotation> clazz) {
        return new ConstantBindingBuilderAdapter(this.guiceBuilder.annotatedWith(clazz));
    }

    @Override
    public GinConstantBindingBuilder annotatedWith(Annotation annotation) {
        return new ConstantBindingBuilderAdapter(this.guiceBuilder.annotatedWith(annotation));
    }
}

