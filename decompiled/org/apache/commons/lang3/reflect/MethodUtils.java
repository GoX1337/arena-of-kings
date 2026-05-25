/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.MemberUtils;
import org.apache.commons.lang3.reflect.TypeUtils;

public class MethodUtils {
    private static final Comparator<Method> METHOD_BY_SIGNATURE = Comparator.comparing(Method::toString);

    public static Object invokeMethod(Object object, String string) {
        return MethodUtils.invokeMethod(object, string, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object object, boolean bl2, String string) {
        return MethodUtils.invokeMethod(object, bl2, string, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeMethod(Object object, String string, Object ... objectArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeMethod(object, string, objectArray, classArray);
    }

    public static Object invokeMethod(Object object, boolean bl2, String string, Object ... objectArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeMethod(object, bl2, string, objectArray, classArray);
    }

    public static Object invokeMethod(Object object, boolean bl2, String string, Object[] objectArray, Class<?>[] classArray) {
        String string2;
        classArray = ArrayUtils.nullToEmpty(classArray);
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = null;
        if (bl2) {
            string2 = "No such method: ";
            method = MethodUtils.getMatchingMethod(object.getClass(), string, classArray);
            if (method != null && !method.isAccessible()) {
                method.setAccessible(true);
            }
        } else {
            string2 = "No such accessible method: ";
            method = MethodUtils.getMatchingAccessibleMethod(object.getClass(), string, classArray);
        }
        if (method == null) {
            throw new NoSuchMethodException(string2 + string + "() on object: " + object.getClass().getName());
        }
        objectArray = MethodUtils.toVarArgs(method, objectArray);
        return method.invoke(object, objectArray);
    }

    public static Object invokeMethod(Object object, String string, Object[] objectArray, Class<?>[] classArray) {
        return MethodUtils.invokeMethod(object, false, string, objectArray, classArray);
    }

    public static Object invokeExactMethod(Object object, String string) {
        return MethodUtils.invokeExactMethod(object, string, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactMethod(Object object, String string, Object ... objectArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeExactMethod(object, string, objectArray, classArray);
    }

    public static Object invokeExactMethod(Object object, String string, Object[] objectArray, Class<?>[] classArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        classArray = ArrayUtils.nullToEmpty(classArray);
        Method method = MethodUtils.getAccessibleMethod(object.getClass(), string, classArray);
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on object: " + object.getClass().getName());
        }
        return method.invoke(object, objectArray);
    }

    public static Object invokeExactStaticMethod(Class<?> clazz, String string, Object[] objectArray, Class<?>[] classArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = MethodUtils.getAccessibleMethod(clazz, string, classArray = ArrayUtils.nullToEmpty(classArray));
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on class: " + clazz.getName());
        }
        return method.invoke(null, objectArray);
    }

    public static Object invokeStaticMethod(Class<?> clazz, String string, Object ... objectArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeStaticMethod(clazz, string, objectArray, classArray);
    }

    public static Object invokeStaticMethod(Class<?> clazz, String string, Object[] objectArray, Class<?>[] classArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = MethodUtils.getMatchingAccessibleMethod(clazz, string, classArray = ArrayUtils.nullToEmpty(classArray));
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on class: " + clazz.getName());
        }
        objectArray = MethodUtils.toVarArgs(method, objectArray);
        return method.invoke(null, objectArray);
    }

    private static Object[] toVarArgs(Method method, Object[] objectArray) {
        if (method.isVarArgs()) {
            Class<?>[] classArray = method.getParameterTypes();
            objectArray = MethodUtils.getVarArgs(objectArray, classArray);
        }
        return objectArray;
    }

    static Object[] getVarArgs(Object[] objectArray, Class<?>[] classArray) {
        if (objectArray.length == classArray.length && (objectArray[objectArray.length - 1] == null || objectArray[objectArray.length - 1].getClass().equals(classArray[classArray.length - 1]))) {
            return objectArray;
        }
        Object[] objectArray2 = new Object[classArray.length];
        System.arraycopy(objectArray, 0, objectArray2, 0, classArray.length - 1);
        Class<?> clazz = classArray[classArray.length - 1].getComponentType();
        int n2 = objectArray.length - classArray.length + 1;
        Object object = Array.newInstance(ClassUtils.primitiveToWrapper(clazz), n2);
        System.arraycopy(objectArray, classArray.length - 1, object, 0, n2);
        if (clazz.isPrimitive()) {
            object = ArrayUtils.toPrimitive(object);
        }
        objectArray2[classArray.length - 1] = object;
        return objectArray2;
    }

    public static Object invokeExactStaticMethod(Class<?> clazz, String string, Object ... objectArray) {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeExactStaticMethod(clazz, string, objectArray, classArray);
    }

    public static Method getAccessibleMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            return MethodUtils.getAccessibleMethod(clazz.getMethod(string, classArray));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        Class<?>[] classArray;
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> clazz = method.getDeclaringClass();
        if (Modifier.isPublic(clazz.getModifiers())) {
            return method;
        }
        String string = method.getName();
        if ((method = MethodUtils.getAccessibleMethodFromInterfaceNest(clazz, string, classArray = method.getParameterTypes())) == null) {
            method = MethodUtils.getAccessibleMethodFromSuperclass(clazz, string, classArray);
        }
        return method;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> clazz, String string, Class<?> ... classArray) {
        for (Class<?> clazz2 = clazz.getSuperclass(); clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            if (!Modifier.isPublic(clazz2.getModifiers())) continue;
            try {
                return clazz2.getMethod(string, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return null;
            }
        }
        return null;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> clazz, String string, Class<?> ... classArray) {
        while (clazz != null) {
            Class<?>[] classArray2;
            for (Class<?> clazz2 : classArray2 = clazz.getInterfaces()) {
                if (!Modifier.isPublic(clazz2.getModifiers())) continue;
                try {
                    return clazz2.getDeclaredMethod(string, classArray);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Method method = MethodUtils.getAccessibleMethodFromInterfaceNest(clazz2, string, classArray);
                    if (method == null) continue;
                    return method;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }

    public static Method getMatchingAccessibleMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            Method method = clazz.getMethod(string, classArray);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Method[] methodArray = clazz.getMethods();
            ArrayList<Method> arrayList = new ArrayList<Method>();
            for (Method object2 : methodArray) {
                if (!object2.getName().equals(string) || !MemberUtils.isMatchingMethod(object2, classArray)) continue;
                arrayList.add(object2);
            }
            arrayList.sort(METHOD_BY_SIGNATURE);
            Object object3 = null;
            for (Method method : arrayList) {
                Method method2 = MethodUtils.getAccessibleMethod(method);
                if (method2 == null || object3 != null && MemberUtils.compareMethodFit(method2, (Method)object3, classArray) >= 0) continue;
                object3 = method2;
            }
            if (object3 != null) {
                MemberUtils.setAccessibleWorkaround((AccessibleObject)object3);
            }
            if (object3 != null && ((Method)object3).isVarArgs() && ((Method)object3).getParameterTypes().length > 0 && classArray.length > 0) {
                String string2;
                Class<?>[] classArray2 = ((Method)object3).getParameterTypes();
                Class<?> clazz2 = classArray2[classArray2.length - 1].getComponentType();
                String string3 = ClassUtils.primitiveToWrapper(clazz2).getName();
                Class<?> clazz3 = classArray[classArray.length - 1];
                String string4 = clazz3 == null ? null : clazz3.getName();
                String string5 = string2 = clazz3 == null ? null : clazz3.getSuperclass().getName();
                if (string4 != null && string2 != null && !string3.equals(string4) && !string3.equals(string2)) {
                    return null;
                }
            }
            return object3;
        }
    }

    public static Method getMatchingMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        Object object2;
        Validate.notNull(clazz, "cls", new Object[0]);
        Validate.notEmpty(string, "methodName", new Object[0]);
        List list = Arrays.stream(clazz.getDeclaredMethods()).filter(method -> method.getName().equals(string)).collect(Collectors.toList());
        ClassUtils.getAllSuperclasses(clazz).stream().map(Class::getDeclaredMethods).flatMap(Arrays::stream).filter(method -> method.getName().equals(string)).forEach(list::add);
        for (Object object2 : list) {
            if (!Arrays.deepEquals(((Method)object2).getParameterTypes(), classArray)) continue;
            return object2;
        }
        TreeMap treeMap = new TreeMap();
        list.stream().filter(method -> ClassUtils.isAssignable(classArray, method.getParameterTypes(), true)).forEach(method -> {
            int n3 = MethodUtils.distance(classArray, method.getParameterTypes());
            List list = treeMap.computeIfAbsent(n3, n2 -> new ArrayList());
            list.add(method);
        });
        if (treeMap.isEmpty()) {
            return null;
        }
        object2 = (List)treeMap.values().iterator().next();
        if (object2.size() == 1) {
            return (Method)object2.get(0);
        }
        throw new IllegalStateException(String.format("Found multiple candidates for method %s on class %s : %s", string + Arrays.stream(classArray).map(String::valueOf).collect(Collectors.joining(",", "(", ")")), clazz.getName(), object2.stream().map(Method::toString).collect(Collectors.joining(",", "[", "]"))));
    }

    private static int distance(Class<?>[] classArray, Class<?>[] classArray2) {
        int n2 = 0;
        if (!ClassUtils.isAssignable(classArray, classArray2, true)) {
            return -1;
        }
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            Class<?> clazz = classArray[i2];
            Class<?> clazz2 = classArray2[i2];
            if (clazz == null || clazz.equals(clazz2)) continue;
            if (ClassUtils.isAssignable(clazz, clazz2, true) && !ClassUtils.isAssignable(clazz, clazz2, false)) {
                ++n2;
                continue;
            }
            n2 += 2;
        }
        return n2;
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet<Method> linkedHashSet = new LinkedHashSet<Method>();
        linkedHashSet.add(method);
        Object[] objectArray = method.getParameterTypes();
        Class<?> clazz = method.getDeclaringClass();
        Iterator<Class<?>> iterator = ClassUtils.hierarchy(clazz, interfaces).iterator();
        iterator.next();
        block0: while (iterator.hasNext()) {
            Class<?> clazz2 = iterator.next();
            Method method2 = MethodUtils.getMatchingAccessibleMethod(clazz2, method.getName(), objectArray);
            if (method2 == null) continue;
            if (Arrays.equals(method2.getParameterTypes(), objectArray)) {
                linkedHashSet.add(method2);
                continue;
            }
            Map<TypeVariable<?>, Type> map = TypeUtils.getTypeArguments(clazz, method2.getDeclaringClass());
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Type type;
                Type type2 = TypeUtils.unrollVariables(map, method.getGenericParameterTypes()[i2]);
                if (!TypeUtils.equals(type2, type = TypeUtils.unrollVariables(map, method2.getGenericParameterTypes()[i2]))) continue block0;
            }
            linkedHashSet.add(method2);
        }
        return linkedHashSet;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2) {
        return MethodUtils.getMethodsWithAnnotation(clazz, clazz2, false, false);
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2) {
        return MethodUtils.getMethodsListWithAnnotation(clazz, clazz2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2, boolean bl2, boolean bl3) {
        List<Method> list = MethodUtils.getMethodsListWithAnnotation(clazz, clazz2, bl2, bl3);
        return list.toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> clazz, Class<? extends Annotation> clazz2, boolean bl2, boolean bl3) {
        Validate.notNull(clazz, "cls", new Object[0]);
        Validate.notNull(clazz2, "annotationCls", new Object[0]);
        ArrayList arrayList = bl2 ? MethodUtils.getAllSuperclassesAndInterfaces(clazz) : new ArrayList();
        arrayList.add(0, clazz);
        ArrayList<Method> arrayList2 = new ArrayList<Method>();
        for (Class clazz3 : arrayList) {
            Method[] methodArray;
            for (Method method : methodArray = bl3 ? clazz3.getDeclaredMethods() : clazz3.getMethods()) {
                if (method.getAnnotation(clazz2) == null) continue;
                arrayList2.add(method);
            }
        }
        return arrayList2;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> clazz, boolean bl2, boolean bl3) {
        Validate.notNull(method, "method", new Object[0]);
        Validate.notNull(clazz, "annotationCls", new Object[0]);
        if (!bl3 && !MemberUtils.isAccessible(method)) {
            return null;
        }
        A a2 = method.getAnnotation(clazz);
        if (a2 == null && bl2) {
            Class<?> clazz2 = method.getDeclaringClass();
            List<Class<?>> list = MethodUtils.getAllSuperclassesAndInterfaces(clazz2);
            for (Class<?> clazz3 : list) {
                Method method2 = bl3 ? MethodUtils.getMatchingMethod(clazz3, method.getName(), method.getParameterTypes()) : MethodUtils.getMatchingAccessibleMethod(clazz3, method.getName(), method.getParameterTypes());
                if (method2 == null || (a2 = method2.getAnnotation(clazz)) == null) continue;
                break;
            }
        }
        return a2;
    }

    private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> list = ClassUtils.getAllSuperclasses(clazz);
        int n2 = 0;
        List<Class<?>> list2 = ClassUtils.getAllInterfaces(clazz);
        int n3 = 0;
        while (n3 < list2.size() || n2 < list.size()) {
            Class<?> clazz2 = n3 >= list2.size() ? list.get(n2++) : (n2 >= list.size() || n3 < n2 || n2 >= n3 ? list2.get(n3++) : list.get(n2++));
            arrayList.add(clazz2);
        }
        return arrayList;
    }
}

