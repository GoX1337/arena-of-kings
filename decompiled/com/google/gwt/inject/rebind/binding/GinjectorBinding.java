/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import java.util.Collections;

public class GinjectorBinding
implements Binding {
    private final SourceWriteUtil sourceWriteUtil;

    @Inject
    public GinjectorBinding(SourceWriteUtil sourceWriteUtil) {
        this.sourceWriteUtil = sourceWriteUtil;
    }

    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return this;");
    }

    public RequiredKeys getRequiredKeys() {
        return new RequiredKeys(Collections.<Key<?>>emptySet());
    }
}

