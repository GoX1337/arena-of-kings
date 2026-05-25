/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.inject.Binder
 *  com.google.inject.Module
 *  com.google.inject.Singleton
 *  com.google.inject.internal.ProviderMethodsModule
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.rebind.adapter.BinderAdapter;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.google.inject.internal.ProviderMethodsModule;

public final class GinModuleAdapter
implements Module {
    private final GinModule ginModule;

    public GinModuleAdapter(GinModule ginModule) {
        this.ginModule = ginModule;
    }

    public void configure(Binder binder) {
        binder = binder.skipSources(new Class[]{GinModuleAdapter.class, BinderAdapter.class, AbstractGinModule.class});
        this.ginModule.configure(new BinderAdapter(binder));
        binder.bind(this.ginModule.getClass()).in(Singleton.class);
        binder.install(ProviderMethodsModule.forObject((Object)this.ginModule));
    }
}

