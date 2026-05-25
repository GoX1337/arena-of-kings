/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.TreeLogger$Type
 *  com.google.gwt.core.ext.UnableToCompleteException
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.NotFoundException
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.internal.ProviderMethod
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.internal.ProviderMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class ProviderMethodBinding
implements Binding {
    private final KeyUtil keyUtil;
    private final SourceWriteUtil sourceWriteUtil;
    private final TreeLogger logger;
    private final NameGenerator nameGenerator;
    private Class<?> moduleClass;
    private Set<Key<?>> parameterKeys;
    private JMethod gwtProviderMethod;

    @Inject
    public ProviderMethodBinding(KeyUtil keyUtil, SourceWriteUtil sourceWriteUtil, TreeLogger treeLogger, NameGenerator nameGenerator) {
        this.keyUtil = keyUtil;
        this.sourceWriteUtil = sourceWriteUtil;
        this.logger = treeLogger;
        this.nameGenerator = nameGenerator;
    }

    public void setProviderMethod(ProviderMethod providerMethod) {
        try {
            this.gwtProviderMethod = this.keyUtil.javaToGwtMethod(providerMethod.getMethod());
        }
        catch (NotFoundException notFoundException) {
            this.logger.log(TreeLogger.Type.ERROR, notFoundException.getMessage(), (Throwable)notFoundException);
            throw new UnableToCompleteException();
        }
        this.moduleClass = providerMethod.getInstance().getClass();
        Method method = providerMethod.getMethod();
        Type[] typeArray = method.getGenericParameterTypes();
        Annotation[][] annotationArray = method.getParameterAnnotations();
        assert (typeArray.length == annotationArray.length);
        this.parameterKeys = new HashSet(typeArray.length);
        for (int i2 = 0; i2 < typeArray.length; ++i2) {
            this.parameterKeys.add(this.keyUtil.getKey(typeArray[i2], annotationArray[i2]));
        }
    }

    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        String string2 = this.moduleClass.getCanonicalName();
        String string3 = "new " + string2 + "()";
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return " + this.sourceWriteUtil.createMethodCallWithInjection(sourceWriter, (JAbstractMethod)this.gwtProviderMethod, string3));
    }

    public RequiredKeys getRequiredKeys() {
        return new RequiredKeys(this.parameterKeys);
    }
}

