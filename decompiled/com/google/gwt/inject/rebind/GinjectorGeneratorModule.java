/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.GeneratorContext
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JField
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.TypeOracle
 *  com.google.inject.AbstractModule
 *  com.google.inject.Inject
 *  com.google.inject.Provides
 *  com.google.inject.Singleton
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.rebind.BindingsProcessor;
import com.google.gwt.inject.rebind.GinjectorInterfaceType;
import com.google.gwt.inject.rebind.binding.BindingIndex;
import com.google.gwt.inject.rebind.binding.Injectable;
import com.google.gwt.inject.rebind.util.MemberCollector;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;

class GinjectorGeneratorModule
extends AbstractModule {
    private final TreeLogger logger;
    private final GeneratorContext ctx;
    private final JClassType ginjectorInterface;

    public GinjectorGeneratorModule(TreeLogger treeLogger, GeneratorContext generatorContext, JClassType jClassType) {
        this.logger = treeLogger;
        this.ctx = generatorContext;
        this.ginjectorInterface = jClassType;
    }

    protected void configure() {
        this.bind(TreeLogger.class).toInstance((Object)this.logger);
        this.bind(GeneratorContext.class).toInstance((Object)this.ctx);
        this.bind(TypeOracle.class).toInstance((Object)this.ctx.getTypeOracle());
        this.bind(JClassType.class).annotatedWith(GinjectorInterfaceType.class).toInstance((Object)this.ginjectorInterface);
        this.bind(BindingIndex.class).to(BindingsProcessor.class).in(Singleton.class);
    }

    @Provides
    @Injectable
    @Singleton
    MemberCollector provideInjectablesCollector(MemberCollector memberCollector) {
        memberCollector.setMethodFilter(new MemberCollector.MethodFilter(){

            public boolean accept(JMethod jMethod) {
                return jMethod.isAnnotationPresent(Inject.class) && !jMethod.isStatic();
            }
        });
        memberCollector.setFieldFilter(new MemberCollector.FieldFilter(){

            public boolean accept(JField jField) {
                return jField.isAnnotationPresent(Inject.class) && !jField.isStatic();
            }
        });
        return memberCollector;
    }
}

