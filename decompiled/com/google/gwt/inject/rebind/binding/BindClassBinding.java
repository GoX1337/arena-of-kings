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
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import java.util.Collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BindClassBinding
implements Binding {
    private final NameGenerator nameGenerator;
    private final SourceWriteUtil sourceWriteUtil;
    private Key<?> boundClassKey;

    @Inject
    public BindClassBinding(NameGenerator nameGenerator, SourceWriteUtil sourceWriteUtil) {
        this.nameGenerator = nameGenerator;
        this.sourceWriteUtil = sourceWriteUtil;
    }

    public void setBoundClassKey(Key<?> key) {
        this.boundClassKey = key;
    }

    @Override
    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        assert (this.boundClassKey != null);
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return " + this.nameGenerator.getGetterMethodName(this.boundClassKey) + "();");
    }

    @Override
    public RequiredKeys getRequiredKeys() {
        assert (this.boundClassKey != null);
        return new RequiredKeys(Collections.singleton(this.boundClassKey));
    }
}

