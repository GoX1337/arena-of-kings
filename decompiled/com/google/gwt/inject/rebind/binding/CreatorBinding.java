/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Key
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Key;
import java.util.HashSet;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class CreatorBinding
implements Binding {
    private final SourceWriteUtil sourceWriteUtil;
    private final KeyUtil keyUtil;
    private final Set<Key<?>> requiredKeys = new HashSet();
    private final Set<Key<?>> optionalKeys = new HashSet();
    private JClassType classType;
    private Key<?> classKey;

    protected CreatorBinding(SourceWriteUtil sourceWriteUtil, KeyUtil keyUtil) {
        this.sourceWriteUtil = sourceWriteUtil;
        this.keyUtil = keyUtil;
    }

    public void setClassType(JClassType jClassType, Key<?> key) {
        this.classType = jClassType;
        this.classKey = key;
        RequiredKeys requiredKeys = this.keyUtil.getRequiredKeys(jClassType);
        this.requiredKeys.addAll(requiredKeys.getRequiredKeys());
        this.optionalKeys.addAll(requiredKeys.getOptionalKeys());
    }

    @Override
    public final void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        assert (this.classType != null);
        String string2 = this.sourceWriteUtil.appendMemberInjection(sourceWriter, this.classKey);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getTypeName()).append(" result = ");
        this.appendCreationStatement(sourceWriter, stringBuilder);
        stringBuilder.append("\n");
        stringBuilder.append(string2).append("(result);\n");
        stringBuilder.append("return result;");
        this.sourceWriteUtil.writeMethod(sourceWriter, string, stringBuilder.toString());
    }

    @Override
    public RequiredKeys getRequiredKeys() {
        return new RequiredKeys(this.requiredKeys, this.optionalKeys);
    }

    public JClassType getClassType() {
        assert (this.classType != null);
        return this.classType;
    }

    protected abstract void appendCreationStatement(SourceWriter var1, StringBuilder var2);

    protected String getTypeName() {
        assert (this.classType != null);
        return this.classType.getQualifiedSourceName();
    }

    protected void addParamTypes(JAbstractMethod jAbstractMethod) {
        RequiredKeys requiredKeys = this.keyUtil.getRequiredKeys(jAbstractMethod);
        this.requiredKeys.addAll(requiredKeys.getRequiredKeys());
        this.optionalKeys.addAll(requiredKeys.getOptionalKeys());
    }
}

