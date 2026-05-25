/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.TreeLogger
 *  com.google.gwt.core.ext.TreeLogger$Type
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.JField
 *  com.google.gwt.core.ext.typeinfo.JMethod
 *  com.google.gwt.core.ext.typeinfo.JPackage
 *  com.google.inject.Inject
 */
package com.google.gwt.inject.rebind.util;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JPackage;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MemberCollector {
    public static final MethodFilter ALL_METHOD_FILTER = new MethodFilter(){

        public boolean accept(JMethod jMethod) {
            return true;
        }
    };
    private static final Comparator<JMethod> METHOD_COMPARATOR = new Comparator<JMethod>(){

        @Override
        public int compare(JMethod jMethod, JMethod jMethod2) {
            if (jMethod == jMethod2) {
                return 0;
            }
            int n2 = jMethod.getName().compareTo(jMethod2.getName());
            if (n2 != 0) {
                return n2;
            }
            if (jMethod.getParameters().length != jMethod2.getParameters().length) {
                return jMethod.getParameters().length - jMethod2.getParameters().length;
            }
            for (int i2 = 0; i2 < jMethod.getParameters().length; ++i2) {
                String string;
                String string2 = jMethod.getParameters()[i2].getType().getQualifiedSourceName();
                int n3 = string2.compareTo(string = jMethod2.getParameters()[i2].getType().getQualifiedSourceName());
                if (n3 == 0) continue;
                return n3;
            }
            if (jMethod.isPrivate() || jMethod2.isPrivate() || (jMethod.isDefaultAccess() || jMethod2.isDefaultAccess()) && !this.samePackage(jMethod, jMethod2)) {
                return jMethod.getEnclosingType().getQualifiedSourceName().compareTo(jMethod2.getEnclosingType().getQualifiedSourceName());
            }
            return 0;
        }

        private boolean samePackage(JMethod jMethod, JMethod jMethod2) {
            JPackage jPackage = jMethod.getEnclosingType().getPackage();
            JPackage jPackage2 = jMethod2.getEnclosingType().getPackage();
            if (jPackage == null || jPackage2 == null) {
                return jPackage == jPackage2;
            }
            return jPackage.isDefault() && jPackage2.isDefault() || jPackage.getName().equals(jPackage2.getName());
        }
    };
    private final Map<String, Set<JMethod>> methodMultiMap = new HashMap<String, Set<JMethod>>();
    private final Map<String, Set<JField>> fieldMultiMap = new HashMap<String, Set<JField>>();
    private final TreeLogger logger;
    private MethodFilter methodFilter;
    private FieldFilter fieldFilter;
    private boolean locked;

    @Inject
    public MemberCollector(TreeLogger treeLogger) {
        this.logger = treeLogger;
        this.locked = false;
    }

    public void setMethodFilter(MethodFilter methodFilter) {
        if (this.locked) {
            String string = "A filter can only be set on this collector before members are requested!";
            this.logger.log(TreeLogger.Type.ERROR, string);
            throw new IllegalStateException(string);
        }
        this.methodFilter = methodFilter;
    }

    public void setFieldFilter(FieldFilter fieldFilter) {
        if (this.locked) {
            String string = "A filter can only be set on this collector before members are requested!";
            this.logger.log(TreeLogger.Type.ERROR, string);
            throw new IllegalStateException(string);
        }
        this.fieldFilter = fieldFilter;
    }

    public Collection<JMethod> getMethods(JClassType jClassType) {
        this.collect(jClassType);
        String string = jClassType.getParameterizedQualifiedSourceName();
        return Collections.unmodifiableCollection((Collection)this.methodMultiMap.get(string));
    }

    public Collection<JField> getFields(JClassType jClassType) {
        this.collect(jClassType);
        String string = jClassType.getParameterizedQualifiedSourceName();
        return Collections.unmodifiableCollection((Collection)this.fieldMultiMap.get(string));
    }

    private void collect(JClassType jClassType) {
        this.locked = true;
        String string = jClassType.getParameterizedQualifiedSourceName();
        if (this.methodMultiMap.containsKey(string)) {
            return;
        }
        TreeSet<JMethod> treeSet = new TreeSet<JMethod>(METHOD_COMPARATOR);
        HashSet<JField> hashSet = new HashSet<JField>();
        this.accumulateMembers(jClassType, treeSet, hashSet);
        this.methodMultiMap.put(string, treeSet);
        this.fieldMultiMap.put(string, hashSet);
    }

    private void accumulateMembers(JClassType jClassType, Set<JMethod> set, Set<JField> set2) {
        String string = jClassType.getParameterizedQualifiedSourceName();
        if (this.methodFilter != null) {
            if (this.methodMultiMap.containsKey(string)) {
                for (JMethod jMethod : this.methodMultiMap.get(string)) {
                    set.add(jMethod);
                }
            } else {
                for (JMethod object : jClassType.getMethods()) {
                    if (this.methodFilter.accept(object)) {
                        set.add(object);
                        this.logger.log(TreeLogger.TRACE, "Found method: " + jClassType.getName() + "#" + object.getReadableDeclaration());
                        continue;
                    }
                    this.logger.log(TreeLogger.DEBUG, "Ignoring method: " + jClassType.getName() + "#" + object.getReadableDeclaration());
                }
            }
        }
        if (this.fieldFilter != null) {
            if (this.fieldMultiMap.containsKey(string)) {
                for (JField jField : this.fieldMultiMap.get(string)) {
                    set2.add(jField);
                }
            } else {
                for (JField jField : jClassType.getFields()) {
                    if (this.fieldFilter.accept(jField)) {
                        set2.add(jField);
                        this.logger.log(TreeLogger.TRACE, "Found field: " + jClassType.getName() + "#" + jField.getName());
                        continue;
                    }
                    this.logger.log(TreeLogger.DEBUG, "Ignoring field: " + jClassType.getName() + "#" + jField.getName());
                }
            }
        }
        for (JClassType jClassType2 : jClassType.getImplementedInterfaces()) {
            this.accumulateMembers(jClassType2, set, set2);
        }
        JClassType jClassType2 = jClassType.getSuperclass();
        if (jClassType2 != null) {
            this.accumulateMembers(jClassType2, set, set2);
        }
    }

    public static interface FieldFilter {
        public boolean accept(JField var1);
    }

    public static interface MethodFilter {
        public boolean accept(JMethod var1);
    }
}

