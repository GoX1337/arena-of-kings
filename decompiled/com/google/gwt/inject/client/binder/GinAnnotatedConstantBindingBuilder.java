/*
 * Decompiled with CFR 0.152.
 */
package com.google.gwt.inject.client.binder;

import com.google.gwt.inject.client.binder.GinConstantBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GinAnnotatedConstantBindingBuilder {
    public GinConstantBindingBuilder annotatedWith(Class<? extends Annotation> var1);

    public GinConstantBindingBuilder annotatedWith(Annotation var1);
}

