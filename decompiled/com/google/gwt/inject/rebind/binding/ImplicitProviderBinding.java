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
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ImplicitProviderBinding
implements Binding {
    private final NameGenerator nameGenerator;
    private final SourceWriteUtil sourceWriteUtil;
    private ParameterizedType providerType;
    private Key<?> targetKey;

    @Inject
    public ImplicitProviderBinding(NameGenerator nameGenerator, SourceWriteUtil sourceWriteUtil) {
        this.nameGenerator = nameGenerator;
        this.sourceWriteUtil = sourceWriteUtil;
    }

    public void setProviderKey(Key<?> key) {
        this.providerType = (ParameterizedType)key.getTypeLiteral().getType();
        Type type = this.providerType.getActualTypeArguments()[0];
        this.targetKey = this.getKeyWithSameAnnotation(type, key);
    }

    @Override
    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        assert (this.providerType != null);
        String string2 = this.sourceWriteUtil.getSourceName(this.providerType);
        String string3 = this.sourceWriteUtil.getSourceName(this.targetKey.getTypeLiteral());
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return new " + string2 + "() { \n" + "  public " + string3 + " get() { \n" + "    return " + this.nameGenerator.getGetterMethodName(this.targetKey) + "();\n" + "  }\n" + "};");
    }

    @Override
    public RequiredKeys getRequiredKeys() {
        assert (this.targetKey != null);
        return new RequiredKeys(Collections.singleton(this.targetKey));
    }

    private Key<?> getKeyWithSameAnnotation(Type type, Key<?> key) {
        Annotation annotation = key.getAnnotation();
        if (annotation != null) {
            return Key.get((Type)type, (Annotation)annotation);
        }
        Class clazz = key.getAnnotationType();
        if (clazz != null) {
            return Key.get((Type)type, (Class)clazz);
        }
        return Key.get((Type)type);
    }
}

