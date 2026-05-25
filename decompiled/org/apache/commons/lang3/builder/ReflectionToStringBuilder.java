/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringSummary;

public class ReflectionToStringBuilder
extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    private boolean excludeNullValues;
    protected String[] excludeFieldNames;
    private Class<?> upToClass;

    public static String toString(Object object) {
        return ReflectionToStringBuilder.toString(object, null, false, false, null);
    }

    public static String toString(Object object, ToStringStyle toStringStyle) {
        return ReflectionToStringBuilder.toString(object, toStringStyle, false, false, null);
    }

    public static String toString(Object object, ToStringStyle toStringStyle, boolean bl2) {
        return ReflectionToStringBuilder.toString(object, toStringStyle, bl2, false, null);
    }

    public static String toString(Object object, ToStringStyle toStringStyle, boolean bl2, boolean bl3) {
        return ReflectionToStringBuilder.toString(object, toStringStyle, bl2, bl3, null);
    }

    public static <T> String toString(T t2, ToStringStyle toStringStyle, boolean bl2, boolean bl3, Class<? super T> clazz) {
        return new ReflectionToStringBuilder(t2, toStringStyle, null, clazz, bl2, bl3).toString();
    }

    public static <T> String toString(T t2, ToStringStyle toStringStyle, boolean bl2, boolean bl3, boolean bl4, Class<? super T> clazz) {
        return new ReflectionToStringBuilder(t2, toStringStyle, null, clazz, bl2, bl3, bl4).toString();
    }

    public static String toStringExclude(Object object, Collection<String> collection) {
        return ReflectionToStringBuilder.toStringExclude(object, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    static String[] toNoNullStringArray(Collection<String> collection) {
        if (collection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return ReflectionToStringBuilder.toNoNullStringArray(collection.toArray());
    }

    static String[] toNoNullStringArray(Object[] objectArray) {
        ArrayList<String> arrayList = new ArrayList<String>(objectArray.length);
        for (Object object : objectArray) {
            if (object == null) continue;
            arrayList.add(object.toString());
        }
        return arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String toStringExclude(Object object, String ... stringArray) {
        return new ReflectionToStringBuilder(object).setExcludeFieldNames(stringArray).toString();
    }

    private static Object checkNotNull(Object object) {
        return Validate.notNull(object, "obj", new Object[0]);
    }

    public ReflectionToStringBuilder(Object object) {
        super(ReflectionToStringBuilder.checkNotNull(object));
    }

    public ReflectionToStringBuilder(Object object, ToStringStyle toStringStyle) {
        super(ReflectionToStringBuilder.checkNotNull(object), toStringStyle);
    }

    public ReflectionToStringBuilder(Object object, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(ReflectionToStringBuilder.checkNotNull(object), toStringStyle, stringBuffer);
    }

    public <T> ReflectionToStringBuilder(T t2, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> clazz, boolean bl2, boolean bl3) {
        super(ReflectionToStringBuilder.checkNotNull(t2), toStringStyle, stringBuffer);
        this.setUpToClass(clazz);
        this.setAppendTransients(bl2);
        this.setAppendStatics(bl3);
    }

    public <T> ReflectionToStringBuilder(T t2, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> clazz, boolean bl2, boolean bl3, boolean bl4) {
        super(ReflectionToStringBuilder.checkNotNull(t2), toStringStyle, stringBuffer);
        this.setUpToClass(clazz);
        this.setAppendTransients(bl2);
        this.setAppendStatics(bl3);
        this.setExcludeNullValues(bl4);
    }

    protected boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !this.isAppendTransients()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !this.isAppendStatics()) {
            return false;
        }
        if (this.excludeFieldNames != null && Arrays.binarySearch(this.excludeFieldNames, field.getName()) >= 0) {
            return false;
        }
        return !field.isAnnotationPresent(ToStringExclude.class);
    }

    protected void appendFieldsIn(Class<?> clazz) {
        if (clazz.isArray()) {
            this.reflectionAppendArray(this.getObject());
            return;
        }
        AccessibleObject[] accessibleObjectArray = ArraySorter.sort(clazz.getDeclaredFields(), Comparator.comparing(Field::getName));
        AccessibleObject.setAccessible(accessibleObjectArray, true);
        for (AccessibleObject accessibleObject : accessibleObjectArray) {
            String string = ((Field)accessibleObject).getName();
            if (!this.accept((Field)accessibleObject)) continue;
            try {
                Object object = this.getValue((Field)accessibleObject);
                if (this.excludeNullValues && object == null) continue;
                this.append(string, object, !accessibleObject.isAnnotationPresent(ToStringSummary.class));
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new InternalError("Unexpected IllegalAccessException: " + illegalAccessException.getMessage());
            }
        }
    }

    public String[] getExcludeFieldNames() {
        return (String[])this.excludeFieldNames.clone();
    }

    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field field) {
        return field.get(this.getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public boolean isExcludeNullValues() {
        return this.excludeNullValues;
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object object) {
        this.getStyle().reflectionAppendArrayDetail(this.getStringBuffer(), null, object);
        return this;
    }

    public void setAppendStatics(boolean bl2) {
        this.appendStatics = bl2;
    }

    public void setAppendTransients(boolean bl2) {
        this.appendTransients = bl2;
    }

    public void setExcludeNullValues(boolean bl2) {
        this.excludeNullValues = bl2;
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String ... stringArray) {
        this.excludeFieldNames = stringArray == null ? null : ArraySorter.sort(ReflectionToStringBuilder.toNoNullStringArray(stringArray));
        return this;
    }

    public void setUpToClass(Class<?> clazz) {
        Object object;
        if (clazz != null && (object = this.getObject()) != null && !clazz.isInstance(object)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.upToClass = clazz;
    }

    @Override
    public String toString() {
        Class<?> clazz;
        if (this.getObject() == null) {
            return this.getStyle().getNullText();
        }
        this.appendFieldsIn(clazz);
        for (clazz = this.getObject().getClass(); clazz.getSuperclass() != null && clazz != this.getUpToClass(); clazz = clazz.getSuperclass()) {
            this.appendFieldsIn(clazz);
        }
        return super.toString();
    }
}

