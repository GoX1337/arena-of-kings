/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.typeinfo.HasAnnotations
 *  com.google.gwt.core.ext.typeinfo.JAbstractMethod
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JConstructor
 *  com.google.gwt.core.ext.typeinfo.JField
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.JParameter
 *  com.google.gwt.core.ext.typeinfo.JPrimitiveType
 *  com.google.gwt.core.ext.typeinfo.JType
 *  com.google.gwt.user.rebind.SourceWriter
 *  com.google.inject.Inject
 *  com.google.inject.Key
 *  com.google.inject.Singleton
 *  com.google.inject.TypeLiteral
 *  com.google.inject.internal.MoreTypes
 */
package com.google.gwt.inject.rebind.util;

import com.google.gwt.core.ext.typeinfo.HasAnnotations;
import com.google.gwt.core.ext.typeinfo.JAbstractMethod;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JConstructor;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.inject.rebind.binding.BindingIndex;
import com.google.gwt.inject.rebind.binding.Injectable;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.MemberCollector;
import com.google.gwt.inject.rebind.util.NameGenerator;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Singleton
public class SourceWriteUtil {
    private final KeyUtil keyUtil;
    private final NameGenerator nameGenerator;
    private final MemberCollector memberCollector;
    private final BindingIndex bindingIndex;

    @Inject
    protected SourceWriteUtil(KeyUtil keyUtil, NameGenerator nameGenerator, @Injectable MemberCollector memberCollector, BindingIndex bindingIndex) {
        this.keyUtil = keyUtil;
        this.nameGenerator = nameGenerator;
        this.memberCollector = memberCollector;
        this.bindingIndex = bindingIndex;
    }

    public String appendFieldInjection(SourceWriter sourceWriter, Iterable<JField> iterable, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (JField jField : iterable) {
            stringBuilder.append(this.createFieldInjection(sourceWriter, jField, string)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String createFieldInjection(SourceWriter sourceWriter, JField jField, String string) {
        boolean bl2 = string != null;
        boolean bl3 = jField.isPublic() && jField.getEnclosingType().isPublic();
        String string2 = jField.getEnclosingType().getQualifiedSourceName();
        String string3 = jField.getType().getQualifiedSourceName();
        String string4 = this.nameGenerator.convertToValidMemberName(string2 + "_" + jField.getName() + "_fieldInjection");
        String string5 = this.nameGenerator.createMethodName(string4);
        String string6 = string3 + " value";
        String string7 = this.nameGenerator.getGetterMethodName(this.keyUtil.getKey(jField)) + "()";
        if (bl2) {
            string6 = string2 + " injectee, " + string6;
            string7 = string + ", " + string7;
        }
        String string8 = "private" + (bl3 ? "" : " native") + " void " + string5 + "(" + string6 + ")";
        String string9 = string5 + "(" + string7 + ");";
        if (bl3) {
            String string10 = (bl2 ? "injectee." : string2 + ".") + jField.getName() + " = value;";
            this.writeMethod(sourceWriter, string8, string10);
        } else {
            String string11 = (bl2 ? "injectee." : "") + this.getJsniSignature(jField) + " = value;";
            this.writeNativeMethod(sourceWriter, string8, string11);
        }
        return string9;
    }

    public String createMethodInjection(SourceWriter sourceWriter, Iterable<? extends JAbstractMethod> iterable, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (JAbstractMethod jAbstractMethod : iterable) {
            stringBuilder.append(this.createMethodCallWithInjection(sourceWriter, jAbstractMethod, string)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String createConstructorInjection(SourceWriter sourceWriter, JConstructor jConstructor) {
        return this.createMethodCallWithInjection(sourceWriter, (JAbstractMethod)jConstructor, null);
    }

    public String createMethodCallWithInjection(SourceWriter sourceWriter, JAbstractMethod jAbstractMethod, String string) {
        boolean bl2 = false;
        boolean bl3 = string != null;
        boolean bl4 = jAbstractMethod.isPublic() && jAbstractMethod.getEnclosingType().isPublic();
        String string2 = jAbstractMethod.getEnclosingType().getQualifiedSourceName();
        String string3 = this.nameGenerator.convertToValidMemberName(string2 + "_" + jAbstractMethod.getName() + "_methodInjection");
        String string4 = this.nameGenerator.createMethodName(string3);
        String string5 = "void";
        if (jAbstractMethod.isConstructor() != null) {
            string5 = string2;
            bl2 = true;
        } else {
            JType jType = ((JMethod)jAbstractMethod).getReturnType();
            if (jType != JPrimitiveType.VOID) {
                string5 = jType.getQualifiedSourceName();
                bl2 = true;
            }
        }
        int n2 = jAbstractMethod.getParameters().length + (bl3 ? 1 : 0);
        ArrayList<String> arrayList = new ArrayList<String>(n2);
        ArrayList<String> arrayList2 = new ArrayList<String>(n2);
        ArrayList<String> arrayList3 = new ArrayList<String>(jAbstractMethod.getParameters().length);
        if (bl3) {
            arrayList.add(string);
            arrayList2.add(string2 + " injectee");
        }
        int n3 = 0;
        for (JParameter jParameter : jAbstractMethod.getParameters()) {
            String string6 = "_" + n3;
            arrayList.add(this.nameGenerator.getGetterMethodName(this.keyUtil.getKey(jParameter)) + "()");
            arrayList2.add(jParameter.getType().getQualifiedSourceName() + " " + string6);
            arrayList3.add(string6);
            ++n3;
        }
        String string7 = "private " + (bl4 ? "" : "native ") + string5 + " " + string4 + "(" + SourceWriteUtil.join(", ", arrayList2) + ")";
        String string8 = string4 + "(" + SourceWriteUtil.join(", ", arrayList) + ");";
        StringBuilder stringBuilder = new StringBuilder();
        if (bl2) {
            stringBuilder.append("return ");
        }
        if (bl4) {
            if (bl3) {
                stringBuilder.append("injectee.").append(jAbstractMethod.getName());
            } else if (jAbstractMethod.isConstructor() != null) {
                stringBuilder.append("new ").append(string2);
            } else {
                stringBuilder.append(string2).append(".").append(jAbstractMethod.getName());
            }
        } else {
            if (bl3) {
                stringBuilder.append("injectee.");
            }
            stringBuilder.append(this.getJsniSignature(jAbstractMethod));
        }
        stringBuilder.append("(").append(SourceWriteUtil.join(", ", arrayList3)).append(");");
        if (bl4) {
            this.writeMethod(sourceWriter, string7, stringBuilder.toString());
        } else {
            this.writeNativeMethod(sourceWriter, string7, stringBuilder.toString());
        }
        return string8;
    }

    public void writeMethod(SourceWriter sourceWriter, String string, String string2) {
        sourceWriter.println(string + " {");
        sourceWriter.indent();
        sourceWriter.println(string2);
        sourceWriter.outdent();
        sourceWriter.println("}");
        sourceWriter.println();
    }

    public void writeNativeMethod(SourceWriter sourceWriter, String string, String string2) {
        sourceWriter.println(string + " /*-{");
        sourceWriter.indent();
        sourceWriter.println(string2);
        sourceWriter.outdent();
        sourceWriter.println("}-*/;");
        sourceWriter.println();
    }

    public String appendMemberInjection(SourceWriter sourceWriter, Key<?> key) {
        JClassType jClassType = this.keyUtil.getClassType(key);
        String string = this.nameGenerator.getMemberInjectMethodName(key);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.createMethodInjection(sourceWriter, this.getMethodsToInject(jClassType), "injectee"));
        stringBuilder.append(this.appendFieldInjection(sourceWriter, this.getFieldsToInject(jClassType), "injectee"));
        this.writeMethod(sourceWriter, "private void " + string + "(" + jClassType.getQualifiedSourceName() + " injectee)", stringBuilder.toString());
        return string;
    }

    public String getSourceName(TypeLiteral<?> typeLiteral) {
        Type type = typeLiteral.getType();
        return this.getSourceName(type);
    }

    public String getSourceName(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getCanonicalName();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getSourceName(parameterizedType.getRawType()));
            if (typeArray.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(this.getSourceName(typeArray[0]));
            for (int i2 = 1; i2 < typeArray.length; ++i2) {
                stringBuilder.append(", ").append(this.getSourceName(typeArray[i2]));
            }
            return stringBuilder.append(">").toString();
        }
        return MoreTypes.toString((Type)type);
    }

    private String getJsniSignature(JAbstractMethod jAbstractMethod) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(jAbstractMethod.getEnclosingType().getQualifiedSourceName());
        String string = jAbstractMethod instanceof JConstructor ? "new" : jAbstractMethod.getName();
        stringBuilder.append("::").append(string).append("(");
        for (JParameter jParameter : jAbstractMethod.getParameters()) {
            stringBuilder.append(jParameter.getType().getJNISignature());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private String getJsniSignature(JField jField) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(jField.getEnclosingType().getQualifiedSourceName());
        stringBuilder.append("::").append(jField.getName());
        return stringBuilder.toString();
    }

    private static CharSequence join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        Iterator<? extends CharSequence> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(iterator.next());
            while (iterator.hasNext()) {
                stringBuilder.append(charSequence);
                stringBuilder.append(iterator.next());
            }
            return stringBuilder.toString();
        }
        return "";
    }

    private Set<JField> getFieldsToInject(JClassType jClassType) {
        HashSet<JField> hashSet = new HashSet<JField>();
        for (JField jField : this.memberCollector.getFields(jClassType)) {
            if (this.keyUtil.isOptional((HasAnnotations)jField) && !this.bindingIndex.isBound(this.keyUtil.getKey(jField))) continue;
            hashSet.add(jField);
        }
        return hashSet;
    }

    private Set<JMethod> getMethodsToInject(JClassType jClassType) {
        HashSet<JMethod> hashSet = new HashSet<JMethod>();
        for (JMethod jMethod : this.memberCollector.getMethods(jClassType)) {
            if (!this.shouldInject(jMethod)) continue;
            hashSet.add(jMethod);
        }
        return hashSet;
    }

    private boolean shouldInject(JMethod jMethod) {
        if (this.keyUtil.isOptional((HasAnnotations)jMethod)) {
            for (JParameter jParameter : jMethod.getParameters()) {
                if (this.bindingIndex.isBound(this.keyUtil.getKey(jParameter))) continue;
                return false;
            }
        }
        return true;
    }
}

