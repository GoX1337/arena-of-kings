/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.Generator
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.inject.rebind.binding.Binding;
import com.google.gwt.inject.rebind.binding.RequiredKeys;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import java.lang.reflect.Type;
import java.util.Collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BindConstantBinding
implements Binding {
    private final NameGenerator nameGenerator;
    private String valueToOutput;
    private final SourceWriteUtil sourceWriteUtil;

    public static boolean isConstantKey(Key<?> key) {
        Type type = key.getTypeLiteral().getType();
        if (!(type instanceof Class)) {
            return false;
        }
        Class clazz = (Class)type;
        return clazz == String.class || clazz.isPrimitive() || Number.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || clazz.isEnum();
    }

    @Inject
    public BindConstantBinding(SourceWriteUtil sourceWriteUtil, NameGenerator nameGenerator) {
        this.sourceWriteUtil = sourceWriteUtil;
        this.nameGenerator = nameGenerator;
    }

    public <T> void setKeyAndInstance(Key<T> key, T t2) {
        Type type = key.getTypeLiteral().getType();
        if (type == String.class) {
            this.valueToOutput = "\"" + Generator.escape((String)t2.toString()) + "\"";
        } else if (type == Character.class) {
            this.valueToOutput = "'" + (Character.valueOf('\'').equals(t2) ? "\\" : "") + t2 + "'";
        } else if (type == Float.class) {
            this.valueToOutput = t2.toString() + "f";
        } else if (type == Long.class) {
            this.valueToOutput = t2.toString() + "L";
        } else if (type == Double.class) {
            this.valueToOutput = t2.toString() + "d";
        } else if (t2 instanceof Number || t2 instanceof Boolean) {
            this.valueToOutput = t2.toString();
        } else if (t2 instanceof Enum) {
            Class<?> clazz = t2.getClass();
            if (clazz.getName().matches(".+\\$\\d+\\z")) {
                clazz = t2.getClass().getEnclosingClass();
            }
            String string = clazz.getCanonicalName();
            this.valueToOutput = string + "." + ((Enum)t2).name();
        } else {
            throw new IllegalArgumentException("Attempted to create a constant binding with a non-constant type: " + type);
        }
    }

    @Override
    public void writeCreatorMethods(SourceWriter sourceWriter, String string) {
        assert (this.valueToOutput != null);
        this.sourceWriteUtil.writeMethod(sourceWriter, string, "return " + this.valueToOutput + ";");
    }

    @Override
    public RequiredKeys getRequiredKeys() {
        return new RequiredKeys(Collections.<Key<?>>emptySet());
    }
}

