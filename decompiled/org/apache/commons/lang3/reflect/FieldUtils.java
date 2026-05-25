/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.MemberUtils;

public class FieldUtils {
    public static Field getField(Class<?> clazz, String string) {
        Field field = FieldUtils.getField(clazz, string, false);
        MemberUtils.setAccessibleWorkaround(field);
        return field;
    }

    public static Field getField(Class<?> clazz, String string, boolean bl2) {
        AnnotatedElement annotatedElement;
        Validate.notNull(clazz, "cls", new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(string), "The field name must not be blank/empty", new Object[0]);
        for (annotatedElement = clazz; annotatedElement != null; annotatedElement = annotatedElement.getSuperclass()) {
            try {
                Field field = annotatedElement.getDeclaredField(string);
                if (!Modifier.isPublic(field.getModifiers())) {
                    if (!bl2) continue;
                    field.setAccessible(true);
                }
                return field;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
        }
        annotatedElement = null;
        for (Class clazz2 : ClassUtils.getAllInterfaces(clazz)) {
            try {
                Field field = clazz2.getField(string);
                Validate.isTrue(annotatedElement == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", string, clazz);
                annotatedElement = field;
            }
            catch (NoSuchFieldException noSuchFieldException) {}
        }
        return annotatedElement;
    }

    public static Field getDeclaredField(Class<?> clazz, String string) {
        return FieldUtils.getDeclaredField(clazz, string, false);
    }

    public static Field getDeclaredField(Class<?> clazz, String string, boolean bl2) {
        Validate.notNull(clazz, "cls", new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(string), "The field name must not be blank/empty", new Object[0]);
        try {
            Field field = clazz.getDeclaredField(string);
            if (!MemberUtils.isAccessible(field)) {
                if (bl2) {
                    field.setAccessible(true);
                } else {
                    return null;
                }
            }
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    public static Field[] getAllFields(Class<?> clazz) {
        List<Field> list = FieldUtils.getAllFieldsList(clazz);
        return list.toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    public static List<Field> getAllFieldsList(Class<?> clazz) {
        Validate.notNull(clazz, "cls", new Object[0]);
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            Field[] fieldArray = clazz2.getDeclaredFields();
            Collections.addAll(arrayList, fieldArray);
        }
        return arrayList;
    }

    public static Field[] getFieldsWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2) {
        List<Field> list = FieldUtils.getFieldsListWithAnnotation(clazz, clazz2);
        return list.toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    public static List<Field> getFieldsListWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2) {
        Validate.notNull(clazz2, "annotationCls", new Object[0]);
        List<Field> list = FieldUtils.getAllFieldsList(clazz);
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Field field : list) {
            if (field.getAnnotation(clazz2) == null) continue;
            arrayList.add(field);
        }
        return arrayList;
    }

    public static Object readStaticField(Field field) {
        return FieldUtils.readStaticField(field, false);
    }

    public static Object readStaticField(Field field, boolean bl2) {
        Validate.notNull(field, "field", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return FieldUtils.readField(field, null, bl2);
    }

    public static Object readStaticField(Class<?> clazz, String string) {
        return FieldUtils.readStaticField(clazz, string, false);
    }

    public static Object readStaticField(Class<?> clazz, String string, boolean bl2) {
        Field field = FieldUtils.getField(clazz, string, bl2);
        Validate.notNull(field, "Cannot locate field '%s' on %s", string, clazz);
        return FieldUtils.readStaticField(field, false);
    }

    public static Object readDeclaredStaticField(Class<?> clazz, String string) {
        return FieldUtils.readDeclaredStaticField(clazz, string, false);
    }

    public static Object readDeclaredStaticField(Class<?> clazz, String string, boolean bl2) {
        Field field = FieldUtils.getDeclaredField(clazz, string, bl2);
        Validate.notNull(field, "Cannot locate declared field %s.%s", clazz.getName(), string);
        return FieldUtils.readStaticField(field, false);
    }

    public static Object readField(Field field, Object object) {
        return FieldUtils.readField(field, object, false);
    }

    public static Object readField(Field field, Object object, boolean bl2) {
        Validate.notNull(field, "field", new Object[0]);
        if (bl2 && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        return field.get(object);
    }

    public static Object readField(Object object, String string) {
        return FieldUtils.readField(object, string, false);
    }

    public static Object readField(Object object, String string, boolean bl2) {
        Validate.notNull(object, "target", new Object[0]);
        Class<?> clazz = object.getClass();
        Field field = FieldUtils.getField(clazz, string, bl2);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", string, clazz);
        return FieldUtils.readField(field, object, false);
    }

    public static Object readDeclaredField(Object object, String string) {
        return FieldUtils.readDeclaredField(object, string, false);
    }

    public static Object readDeclaredField(Object object, String string, boolean bl2) {
        Validate.notNull(object, "target", new Object[0]);
        Class<?> clazz = object.getClass();
        Field field = FieldUtils.getDeclaredField(clazz, string, bl2);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", clazz, string);
        return FieldUtils.readField(field, object, false);
    }

    public static void writeStaticField(Field field, Object object) {
        FieldUtils.writeStaticField(field, object, false);
    }

    public static void writeStaticField(Field field, Object object, boolean bl2) {
        Validate.notNull(field, "field", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        FieldUtils.writeField(field, null, object, bl2);
    }

    public static void writeStaticField(Class<?> clazz, String string, Object object) {
        FieldUtils.writeStaticField(clazz, string, object, false);
    }

    public static void writeStaticField(Class<?> clazz, String string, Object object, boolean bl2) {
        Field field = FieldUtils.getField(clazz, string, bl2);
        Validate.notNull(field, "Cannot locate field %s on %s", string, clazz);
        FieldUtils.writeStaticField(field, object, false);
    }

    public static void writeDeclaredStaticField(Class<?> clazz, String string, Object object) {
        FieldUtils.writeDeclaredStaticField(clazz, string, object, false);
    }

    public static void writeDeclaredStaticField(Class<?> clazz, String string, Object object, boolean bl2) {
        Field field = FieldUtils.getDeclaredField(clazz, string, bl2);
        Validate.notNull(field, "Cannot locate declared field %s.%s", clazz.getName(), string);
        FieldUtils.writeField(field, null, object, false);
    }

    public static void writeField(Field field, Object object, Object object2) {
        FieldUtils.writeField(field, object, object2, false);
    }

    public static void writeField(Field field, Object object, Object object2, boolean bl2) {
        Validate.notNull(field, "field", new Object[0]);
        if (bl2 && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        field.set(object, object2);
    }

    public static void removeFinalModifier(Field field) {
        FieldUtils.removeFinalModifier(field, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Deprecated
    public static void removeFinalModifier(Field field, boolean bl2) {
        block7: {
            Validate.notNull(field, "field", new Object[0]);
            try {
                boolean bl3;
                if (!Modifier.isFinal(field.getModifiers())) break block7;
                Field field2 = Field.class.getDeclaredField("modifiers");
                boolean bl4 = bl3 = bl2 && !field2.isAccessible();
                if (bl3) {
                    field2.setAccessible(true);
                }
                try {
                    field2.setInt(field, field.getModifiers() & 0xFFFFFFEF);
                }
                finally {
                    if (bl3) {
                        field2.setAccessible(false);
                    }
                }
            }
            catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
                if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_12)) break block7;
                throw new UnsupportedOperationException("In java 12+ final cannot be removed.", reflectiveOperationException);
            }
        }
    }

    public static void writeField(Object object, String string, Object object2) {
        FieldUtils.writeField(object, string, object2, false);
    }

    public static void writeField(Object object, String string, Object object2, boolean bl2) {
        Validate.notNull(object, "target", new Object[0]);
        Class<?> clazz = object.getClass();
        Field field = FieldUtils.getField(clazz, string, bl2);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", clazz.getName(), string);
        FieldUtils.writeField(field, object, object2, false);
    }

    public static void writeDeclaredField(Object object, String string, Object object2) {
        FieldUtils.writeDeclaredField(object, string, object2, false);
    }

    public static void writeDeclaredField(Object object, String string, Object object2, boolean bl2) {
        Validate.notNull(object, "target", new Object[0]);
        Class<?> clazz = object.getClass();
        Field field = FieldUtils.getDeclaredField(clazz, string, bl2);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", clazz.getName(), string);
        FieldUtils.writeField(field, object, object2, false);
    }
}

