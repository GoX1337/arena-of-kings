/*
 * Decompiled with CFR 0.152.
 */
package com.google.gwt.inject.client.binder;

import com.google.gwt.inject.client.binder.GinLinkedBindingBuilder;
import java.lang.annotation.Annotation;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GinAnnotatedBindingBuilder<T>
extends GinLinkedBindingBuilder<T> {
    public GinLinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> var1);

    public GinLinkedBindingBuilder<T> annotatedWith(Annotation var1);
}

