/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JConstructor
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JConstructor;
import com.google.gwt.inject.rebind.binding.CreatorBinding;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CallConstructorBinding
extends CreatorBinding {
    private final SourceWriteUtil sourceWriteUtil;
    private JConstructor constructor;

    @Inject
    public CallConstructorBinding(SourceWriteUtil sourceWriteUtil, KeyUtil keyUtil) {
        super(sourceWriteUtil, keyUtil);
        this.sourceWriteUtil = sourceWriteUtil;
    }

    public void setConstructor(JConstructor jConstructor, Key<?> key) {
        this.constructor = jConstructor;
        this.setClassType(jConstructor.getEnclosingType(), key);
        this.addParamTypes((JAbstractMethod)jConstructor);
    }

    @Override
    protected void appendCreationStatement(SourceWriter sourceWriter, StringBuilder stringBuilder) {
        assert (this.constructor != null);
        stringBuilder.append(this.sourceWriteUtil.createConstructorInjection(sourceWriter, this.constructor));
    }
}

