/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.Generator
 *  com.google.gwt.core.ext.GeneratorContext
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.UnableToCompleteException
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.inject.Guice
 *  com.google.inject.Module
 *  com.google.inject.Stage
 */
package com.google.gwt.inject.rebind;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.inject.rebind.GinjectorGeneratorImpl;
import com.google.gwt.inject.rebind.GinjectorGeneratorModule;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Stage;

public class GinjectorGenerator
extends Generator {
    public String generate(TreeLogger treeLogger, GeneratorContext generatorContext, String string) {
        JClassType jClassType = generatorContext.getTypeOracle().findType(string);
        if (jClassType == null) {
            treeLogger.log(TreeLogger.ERROR, "Unable to find metadata for type '" + string + "'", null);
            throw new UnableToCompleteException();
        }
        GinjectorGeneratorModule ginjectorGeneratorModule = new GinjectorGeneratorModule(treeLogger, generatorContext, jClassType);
        return ((GinjectorGeneratorImpl)Guice.createInjector((Stage)Stage.PRODUCTION, (Module[])new Module[]{ginjectorGeneratorModule}).getInstance(GinjectorGeneratorImpl.class)).generate();
    }
}

