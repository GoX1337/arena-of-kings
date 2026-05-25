/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.GeneratorContext
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.UnableToCompleteException
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JPackage
 *  com.google.gwt.core.ext.typeinfo.TypeOracle
 *  com.google.inject.Inject
 *  com.google.inject.Singleton
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JPackage;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.inject.rebind.BindingsProcessor;
import com.google.gwt.inject.rebind.GinjectorInterfaceType;
import com.google.gwt.inject.rebind.GinjectorOutputter;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.PrintWriter;

@Singleton
class GinjectorGeneratorImpl {
    private final TreeLogger logger;
    private final GeneratorContext ctx;
    private final BindingsProcessor bindingsProcessor;
    private final JClassType ginjectorInterface;
    private final TypeOracle oracle;
    private final GinjectorOutputter outputter;

    @Inject
    public GinjectorGeneratorImpl(TreeLogger treeLogger, GeneratorContext generatorContext, BindingsProcessor bindingsProcessor, @GinjectorInterfaceType JClassType jClassType, TypeOracle typeOracle, GinjectorOutputter ginjectorOutputter) {
        this.logger = treeLogger;
        this.ctx = generatorContext;
        this.bindingsProcessor = bindingsProcessor;
        this.ginjectorInterface = jClassType;
        this.oracle = typeOracle;
        this.outputter = ginjectorOutputter;
    }

    public String generate() {
        this.validateInjectorClass();
        JPackage jPackage = this.ginjectorInterface.getPackage();
        String string = jPackage == null ? "" : jPackage.getName();
        String string2 = this.ginjectorInterface.getSimpleSourceName() + "Impl";
        String string3 = string + "." + string2;
        PrintWriter printWriter = this.ctx.tryCreate(this.logger, string, string2);
        if (printWriter != null) {
            this.bindingsProcessor.process();
            this.outputter.output(string, string2, printWriter);
        }
        return string3;
    }

    private void validateInjectorClass() {
        if (this.ginjectorInterface.isInterface() == null) {
            this.logger.log(TreeLogger.ERROR, this.ginjectorInterface.getQualifiedSourceName() + " is not an interface", null);
            throw new UnableToCompleteException();
        }
        if (!this.ginjectorInterface.isAssignableTo(this.oracle.findType(Ginjector.class.getName()))) {
            this.logger.log(TreeLogger.ERROR, this.ginjectorInterface.getQualifiedSourceName() + " is not a subtype of " + Ginjector.class.getName());
            throw new UnableToCompleteException();
        }
    }
}

