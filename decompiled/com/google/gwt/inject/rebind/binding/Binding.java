/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.rebind.SourceWriter
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.user.rebind.SourceWriter;

public interface Binding {
    public void writeCreatorMethods(SourceWriter var1, String var2);

    public RequiredKeys getRequiredKeys();
}

