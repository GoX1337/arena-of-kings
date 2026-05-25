/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.Provider
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BindProviderBinding
implements Binding {
    private final NameGenerator nameGenerator;
    private final SourceWriteUtil sourceWriteUtil;
    private Key<? extends Provider<?>> providerKey;

    @Inject
    public BindProviderBinding(NameGenerator nameGenerator, SourceWriteUtil sourceWriteUtil) {
        this.nameGenerator = nameGenerator;
        this.sourceWriteUtil = sourceWriteUtil;
    }

    public void setProviderKey(Key<? extends Provider<?>> key) {
        this.providerKey = key;
    }

    @Override
    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        assert (this.providerKey != null);
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return " + this.nameGenerator.getGetterMethodName(this.providerKey) + "().get();");
    }

    @Override
    public RequiredKeys getRequiredKeys() {
        assert (this.providerKey != null);
        return new RequiredKeys(Collections.singleton(this.providerKey));
    }
}

