/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils {
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final String PACKAGE_SEPARATOR;
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String INNER_CLASS_SEPARATOR;
    private static final Map<String, Class<?>> namePrimitiveMap;
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    private static final Map<String, String> abbreviationMap;
    private static final Map<String, String> reverseAbbreviationMap;

    public static String getShortClassName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getShortClassName(object.getClass());
    }

    public static String getShortClassName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getShortClassName(clazz.getName());
    }

    public static String getShortClassName(String string) {
        int n2;
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string.startsWith("[")) {
            while (string.charAt(0) == '[') {
                string = string.substring(1);
                stringBuilder.append("[]");
            }
            if (string.charAt(0) == 'L' && string.charAt(string.length() - 1) == ';') {
                string = string.substring(1, string.length() - 1);
            }
            if (reverseAbbreviationMap.containsKey(string)) {
                string = reverseAbbreviationMap.get(string);
            }
        }
        int n3 = string.indexOf(36, (n2 = string.lastIndexOf(46)) == -1 ? 0 : n2 + 1);
        String string2 = string.substring(n2 + 1);
        if (n3 != -1) {
            string2 = string2.replace('$', '.');
        }
        return string2 + stringBuilder;
    }

    public static String getSimpleName(Class<?> clazz) {
        return ClassUtils.getSimpleName(clazz, "");
    }

    public static String getSimpleName(Class<?> clazz, String string) {
        return clazz == null ? string : clazz.getSimpleName();
    }

    public static String getSimpleName(Object object) {
        return ClassUtils.getSimpleName(object, "");
    }

    public static String getSimpleName(Object object, String string) {
        return object == null ? string : object.getClass().getSimpleName();
    }

    public static String getName(Class<?> clazz) {
        return ClassUtils.getName(clazz, "");
    }

    public static String getName(Class<?> clazz, String string) {
        return clazz == null ? string : clazz.getName();
    }

    public static String getName(Object object) {
        return ClassUtils.getName(object, "");
    }

    public static String getName(Object object, String string) {
        return object == null ? string : object.getClass().getName();
    }

    public static String getPackageName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getPackageName(object.getClass());
    }

    public static String getPackageName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getPackageName(clazz.getName());
    }

    public static String getPackageName(String string) {
        int n2;
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        while (string.charAt(0) == '[') {
            string = string.substring(1);
        }
        if (string.charAt(0) == 'L' && string.charAt(string.length() - 1) == ';') {
            string = string.substring(1);
        }
        if ((n2 = string.lastIndexOf(46)) == -1) {
            return "";
        }
        return string.substring(0, n2);
    }

    public static String getAbbreviatedName(Class<?> clazz, int n2) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getAbbreviatedName(clazz.getName(), n2);
    }

    public static String getAbbreviatedName(String string, int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (string == null) {
            return "";
        }
        if (string.length() <= n2) {
            return string;
        }
        char[] cArray = string.toCharArray();
        int n3 = 0;
        int n4 = 0;
        while (n4 < cArray.length) {
            int n5 = n3;
            while (n4 < cArray.length && cArray[n4] != '.') {
                cArray[n5++] = cArray[n4++];
            }
            if (ClassUtils.useFull(n5, n4, cArray.length, n2) || ++n3 > n5) {
                n3 = n5;
            }
            if (n4 >= cArray.length) continue;
            cArray[n3++] = cArray[n4++];
        }
        return new String(cArray, 0, n3);
    }

    private static boolean useFull(int n2, int n3, int n4, int n5) {
        return n3 >= n4 || n2 + n4 - n3 <= n5;
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> clazz2 = clazz.getSuperclass(); clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            arrayList.add(clazz2);
        }
        return arrayList;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ClassUtils.getAllInterfaces(clazz, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class<?> clazz, HashSet<Class<?>> hashSet) {
        while (clazz != null) {
            Class<?>[] classArray;
            for (Class<?> clazz2 : classArray = clazz.getInterfaces()) {
                if (!hashSet.add(clazz2)) continue;
                ClassUtils.getAllInterfaces(clazz2, hashSet);
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String string : list) {
            try {
                arrayList.add(Class.forName(string));
            }
            catch (Exception exception) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (Class<?> clazz : list) {
            if (clazz == null) {
                arrayList.add(null);
                continue;
            }
            arrayList.add(clazz.getName());
        }
        return arrayList;
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?> ... classArray2) {
        return ClassUtils.isAssignable(classArray, classArray2, true);
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] classArray2, boolean bl2) {
        if (!ArrayUtils.isSameLength(classArray, classArray2)) {
            return false;
        }
        if (classArray == null) {
            classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (classArray2 == null) {
            classArray2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (ClassUtils.isAssignable(classArray[i2], classArray2[i2], bl2)) continue;
            return false;
        }
        return true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return clazz.isPrimitive() || ClassUtils.isPrimitiveWrapper(clazz);
    }

    public static boolean isPrimitiveWrapper(Class<?> clazz) {
        return wrapperPrimitiveMap.containsKey(clazz);
    }

    public static boolean isAssignable(Class<?> clazz, Class<?> clazz2) {
        return ClassUtils.isAssignable(clazz, clazz2, true);
    }

    public static boolean isAssignable(Class<?> clazz, Class<?> clazz2, boolean bl2) {
        if (clazz2 == null) {
            return false;
        }
        if (clazz == null) {
            return !clazz2.isPrimitive();
        }
        if (bl2) {
            if (clazz.isPrimitive() && !clazz2.isPrimitive() && (clazz = ClassUtils.primitiveToWrapper(clazz)) == null) {
                return false;
            }
            if (clazz2.isPrimitive() && !clazz.isPrimitive() && (clazz = ClassUtils.wrapperToPrimitive(clazz)) == null) {
                return false;
            }
        }
        if (clazz.equals(clazz2)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            if (!clazz2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(clazz)) {
                return Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Long.TYPE.equals(clazz)) {
                return Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Boolean.TYPE.equals(clazz)) {
                return false;
            }
            if (Double.TYPE.equals(clazz)) {
                return false;
            }
            if (Float.TYPE.equals(clazz)) {
                return Double.TYPE.equals(clazz2);
            }
            if (Character.TYPE.equals(clazz)) {
                return Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Short.TYPE.equals(clazz)) {
                return Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Byte.TYPE.equals(clazz)) {
                return Short.TYPE.equals(clazz2) || Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            return false;
        }
        return clazz2.isAssignableFrom(clazz);
    }

    public static Class<?> primitiveToWrapper(Class<?> clazz) {
        Class<?> clazz2 = clazz;
        if (clazz != null && clazz.isPrimitive()) {
            clazz2 = primitiveWrapperMap.get(clazz);
        }
        return clazz2;
    }

    public static Class<?>[] primitivesToWrappers(Class<?> ... classArray) {
        if (classArray == null) {
            return null;
        }
        if (classArray.length == 0) {
            return classArray;
        }
        Class[] classArray2 = new Class[classArray.length];
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            classArray2[i2] = ClassUtils.primitiveToWrapper(classArray[i2]);
        }
        return classArray2;
    }

    public static Class<?> wrapperToPrimitive(Class<?> clazz) {
        return wrapperPrimitiveMap.get(clazz);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?> ... classArray) {
        if (classArray == null) {
            return null;
        }
        if (classArray.length == 0) {
            return classArray;
        }
        Class[] classArray2 = new Class[classArray.length];
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            classArray2[i2] = ClassUtils.wrapperToPrimitive(classArray[i2]);
        }
        return classArray2;
    }

    public static boolean isInnerClass(Class<?> clazz) {
        return clazz != null && clazz.getEnclosingClass() != null;
    }

    public static Class<?> getClass(ClassLoader classLoader, String string, boolean bl2) {
        try {
            Class<?> clazz = namePrimitiveMap.containsKey(string) ? namePrimitiveMap.get(string) : Class.forName(ClassUtils.toCanonicalName(string), bl2, classLoader);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            int n2 = string.lastIndexOf(46);
            if (n2 != -1) {
                try {
                    return ClassUtils.getClass(classLoader, string.substring(0, n2) + '$' + string.substring(n2 + 1), bl2);
                }
                catch (ClassNotFoundException classNotFoundException2) {
                    // empty catch block
                }
            }
            throw classNotFoundException;
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String string) {
        return ClassUtils.getClass(classLoader, string, true);
    }

    public static Class<?> getClass(String string) {
        return ClassUtils.getClass(string, true);
    }

    public static Class<?> getClass(String string, boolean bl2) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader2 = classLoader == null ? ClassUtils.class.getClassLoader() : classLoader;
        return ClassUtils.getClass(classLoader2, string, bl2);
    }

    public static Method getPublicMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        Method method = clazz.getMethod(string, classArray);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList arrayList = new ArrayList(ClassUtils.getAllInterfaces(clazz));
        arrayList.addAll(ClassUtils.getAllSuperclasses(clazz));
        for (Class clazz2 : arrayList) {
            Method method2;
            if (!Modifier.isPublic(clazz2.getModifiers())) continue;
            try {
                method2 = clazz2.getMethod(string, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                continue;
            }
            if (!Modifier.isPublic(method2.getDeclaringClass().getModifiers())) continue;
            return method2;
        }
        throw new NoSuchMethodException("Can't find a public method for " + string + " " + ArrayUtils.toString(classArray));
    }

    private static String toCanonicalName(String string) {
        string = StringUtils.deleteWhitespace(string);
        Validate.notNull(string, "className", new Object[0]);
        if (string.endsWith("[]")) {
            StringBuilder stringBuilder = new StringBuilder();
            while (string.endsWith("[]")) {
                string = string.substring(0, string.length() - 2);
                stringBuilder.append("[");
            }
            String string2 = abbreviationMap.get(string);
            if (string2 != null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append("L").append(string).append(";");
            }
            string = stringBuilder.toString();
        }
        return string;
    }

    public static Class<?>[] toClass(Object ... objectArray) {
        if (objectArray == null) {
            return null;
        }
        if (objectArray.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class[] classArray = new Class[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            classArray[i2] = objectArray[i2] == null ? null : objectArray[i2].getClass();
        }
        return classArray;
    }

    public static String getShortCanonicalName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getShortCanonicalName(object.getClass().getName());
    }

    public static String getCanonicalName(Class<?> clazz) {
        return ClassUtils.getCanonicalName(clazz, "");
    }

    public static String getCanonicalName(Class<?> clazz, String string) {
        if (clazz == null) {
            return string;
        }
        String string2 = clazz.getCanonicalName();
        return string2 == null ? string : string2;
    }

    public static String getCanonicalName(Object object) {
        return ClassUtils.getCanonicalName(object, "");
    }

    public static String getCanonicalName(Object object, String string) {
        if (object == null) {
            return string;
        }
        String string2 = object.getClass().getCanonicalName();
        return string2 == null ? string : string2;
    }

    public static String getShortCanonicalName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getShortCanonicalName(clazz.getName());
    }

    public static String getShortCanonicalName(String string) {
        return ClassUtils.getShortClassName(ClassUtils.getCanonicalName(string));
    }

    public static String getPackageCanonicalName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getPackageCanonicalName(object.getClass().getName());
    }

    public static String getPackageCanonicalName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getPackageCanonicalName(clazz.getName());
    }

    public static String getPackageCanonicalName(String string) {
        return ClassUtils.getPackageName(ClassUtils.getCanonicalName(string));
    }

    private static String getCanonicalName(String string) {
        if ((string = StringUtils.deleteWhitespace(string)) == null) {
            return null;
        }
        int n2 = 0;
        while (string.startsWith("[")) {
            ++n2;
            string = string.substring(1);
        }
        if (n2 < 1) {
            return string;
        }
        if (string.startsWith("L")) {
            string = string.substring(1, string.endsWith(";") ? string.length() - 1 : string.length());
        } else if (!string.isEmpty()) {
            string = reverseAbbreviationMap.get(string.substring(0, 1));
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append("[]");
        }
        return stringBuilder.toString();
    }

    public static Iterable<Class<?>> hierarchy(Class<?> clazz) {
        return ClassUtils.hierarchy(clazz, Interfaces.EXCLUDE);
    }

    public static Iterable<Class<?>> hierarchy(Class<?> clazz, Interfaces interfaces) {
        Iterable<Class<?>> iterable = () -> {
            final MutableObject<Class> mutableObject = new MutableObject<Class>(clazz);
            return new Iterator<Class<?>>(){

                @Override
                public boolean hasNext() {
                    return mutableObject.getValue() != null;
                }

                @Override
                public Class<?> next() {
                    Class clazz = (Class)mutableObject.getValue();
                    mutableObject.setValue(clazz.getSuperclass());
                    return clazz;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        };
        if (interfaces != Interfaces.INCLUDE) {
            return iterable;
        }
        return () -> {
            final HashSet hashSet = new HashSet();
            final Iterator iterator = iterable.iterator();
            return new Iterator<Class<?>>(){
                Iterator interfaces = Collections.emptySet().iterator();

                @Override
                public boolean hasNext() {
                    return this.interfaces.hasNext() || iterator.hasNext();
                }

                @Override
                public Class<?> next() {
                    if (this.interfaces.hasNext()) {
                        Class clazz = (Class)this.interfaces.next();
                        hashSet.add(clazz);
                        return clazz;
                    }
                    Class clazz = (Class)iterator.next();
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    this.walkInterfaces(linkedHashSet, clazz);
                    this.interfaces = linkedHashSet.iterator();
                    return clazz;
                }

                private void walkInterfaces(Set<Class<?>> set, Class<?> clazz) {
                    for (Class<?> clazz2 : clazz.getInterfaces()) {
                        if (!hashSet.contains(clazz2)) {
                            set.add(clazz2);
                        }
                        this.walkInterfaces(set, clazz2);
                    }
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        };
    }

    static {
        Map.Entry<Class<?>, Class<?>> entry22;
        PACKAGE_SEPARATOR = String.valueOf('.');
        INNER_CLASS_SEPARATOR = String.valueOf('$');
        namePrimitiveMap = new HashMap();
        namePrimitiveMap.put("boolean", Boolean.TYPE);
        namePrimitiveMap.put("byte", Byte.TYPE);
        namePrimitiveMap.put("char", Character.TYPE);
        namePrimitiveMap.put("short", Short.TYPE);
        namePrimitiveMap.put("int", Integer.TYPE);
        namePrimitiveMap.put("long", Long.TYPE);
        namePrimitiveMap.put("double", Double.TYPE);
        namePrimitiveMap.put("float", Float.TYPE);
        namePrimitiveMap.put("void", Void.TYPE);
        primitiveWrapperMap = new HashMap();
        primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        for (Map.Entry<Class<?>, Class<?>> entry22 : primitiveWrapperMap.entrySet()) {
            Class<?> object;
            Class<?> clazz = entry22.getKey();
            if (clazz.equals(object = entry22.getValue())) continue;
            wrapperPrimitiveMap.put(object, clazz);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("int", "I");
        hashMap.put("boolean", "Z");
        hashMap.put("float", "F");
        hashMap.put("long", "J");
        hashMap.put("short", "S");
        hashMap.put("byte", "B");
        hashMap.put("double", "D");
        hashMap.put("char", "C");
        entry22 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            entry22.put((Class<?>)entry.getValue(), (Class<?>)entry.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap);
        reverseAbbreviationMap = Collections.unmodifiableMap(entry22);
    }

    public static enum Interfaces {
        INCLUDE,
        EXCLUDE;

    }
}

