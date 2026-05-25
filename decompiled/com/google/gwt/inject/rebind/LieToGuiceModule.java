/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.TreeLogger$Type
 *  com.google.inject.AbstractModule
 *  com.google.inject.Binder
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.Module
 *  com.google.inject.Provider
 *  com.google.inject.ProvisionException
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.ext.TreeLogger;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class LieToGuiceModule
extends AbstractModule {
    private final List<Module> lies = new ArrayList<Module>();
    private final TreeLogger logger;

    @Inject
    LieToGuiceModule(TreeLogger treeLogger) {
        this.logger = treeLogger;
    }

    protected void configure() {
        for (Module module : this.lies) {
            this.install(module);
        }
    }

    <T> void registerImplicitBinding(Key<T> key) {
        this.logger.log(TreeLogger.Type.TRACE, "Implicit binding registered with Guice for " + key);
        this.lies.add(new ImplicitBindingModule(key));
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    class ImplicitBindingModule<T>
    implements Module,
    Provider<T> {
        private final Key<T> key;

        private ImplicitBindingModule(Key<T> key) {
            this.key = key;
        }

        public void configure(Binder binder) {
            LieToGuiceModule.this.logger.log(TreeLogger.Type.TRACE, "Binding " + this.key + "in Guice");
            binder.bind(this.key).toProvider((Provider)this);
        }

        public T get() {
            throw new ProvisionException("Gin implicit binding provider should not be called directly!");
        }
    }
}

