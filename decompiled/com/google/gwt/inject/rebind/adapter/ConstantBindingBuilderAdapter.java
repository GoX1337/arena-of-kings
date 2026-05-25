/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.binder.ConstantBindingBuilder
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinConstantBindingBuilder;
import com.google.inject.binder.ConstantBindingBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class ConstantBindingBuilderAdapter
implements GinConstantBindingBuilder {
    private final ConstantBindingBuilder guiceBuilder;

    public ConstantBindingBuilderAdapter(ConstantBindingBuilder constantBindingBuilder) {
        this.guiceBuilder = constantBindingBuilder;
    }

    @Override
    public void to(String string) {
        this.guiceBuilder.to(string);
    }

    @Override
    public void to(int n2) {
        this.guiceBuilder.to(n2);
    }

    @Override
    public void to(long l2) {
        this.guiceBuilder.to(l2);
    }

    @Override
    public void to(boolean bl2) {
        this.guiceBuilder.to(bl2);
    }

    @Override
    public void to(double d2) {
        this.guiceBuilder.to(d2);
    }

    @Override
    public void to(float f2) {
        this.guiceBuilder.to(f2);
    }

    @Override
    public void to(short s2) {
        this.guiceBuilder.to(s2);
    }

    @Override
    public void to(char c2) {
        this.guiceBuilder.to(c2);
    }

    @Override
    public void to(Class<?> clazz) {
        this.guiceBuilder.to(clazz);
    }

    @Override
    public <E extends Enum<E>> void to(E e2) {
        this.guiceBuilder.to(e2);
    }
}

