/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.inject.rebind.binding.CreatorBinding;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;

public class CallGwtDotCreateBinding
extends CreatorBinding {
    @Inject
    public CallGwtDotCreateBinding(SourceWriteUtil sourceWriteUtil, KeyUtil keyUtil) {
        super(sourceWriteUtil, keyUtil);
    }

    protected final void appendCreationStatement(SourceWriter sourceWriter, StringBuilder stringBuilder) {
        String string = this.getTypeNameToCreate();
        stringBuilder.append("GWT.create(").append(string).append(".class);");
    }

    protected String getTypeNameToCreate() {
        return this.getClassType().getQualifiedSourceName();
    }
}

