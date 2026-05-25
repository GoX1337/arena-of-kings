/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    MemberUtils() {
    }

    static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            return false;
        }
        Member member = (Member)((Object)accessibleObject);
        if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && MemberUtils.isPackageAccess(member.getDeclaringClass().getModifiers())) {
            try {
                accessibleObject.setAccessible(true);
                return true;
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
        }
        return false;
    }

    static boolean isPackageAccess(int n2) {
        return (n2 & 7) == 0;
    }

    static boolean isAccessible(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    static int compareConstructorFit(Constructor<?> constructor, Constructor<?> constructor2, Class<?>[] classArray) {
        return MemberUtils.compareParameterTypes(Executable.of(constructor), Executable.of(constructor2), classArray);
    }

    static int compareMethodFit(Method method, Method method2, Class<?>[] classArray) {
        return MemberUtils.compareParameterTypes(Executable.of(method), Executable.of(method2), classArray);
    }

    private static int compareParameterTypes(Executable executable, Executable executable2, Class<?>[] classArray) {
        float f2 = MemberUtils.getTotalTransformationCost(classArray, executable);
        float f3 = MemberUtils.getTotalTransformationCost(classArray, executable2);
        return Float.compare(f2, f3);
    }

    private static float getTotalTransformationCost(Class<?>[] classArray, Executable executable) {
        long l2;
        Class<?>[] classArray2 = executable.getParameterTypes();
        boolean bl2 = executable.isVarArgs();
        float f2 = 0.0f;
        long l3 = l2 = bl2 ? (long)(classArray2.length - 1) : (long)classArray2.length;
        if ((long)classArray.length < l2) {
            return Float.MAX_VALUE;
        }
        int n2 = 0;
        while ((long)n2 < l2) {
            f2 += MemberUtils.getObjectTransformationCost(classArray[n2], classArray2[n2]);
            ++n2;
        }
        if (bl2) {
            n2 = classArray.length < classArray2.length ? 1 : 0;
            boolean bl3 = classArray.length == classArray2.length && classArray[classArray.length - 1] != null && classArray[classArray.length - 1].isArray();
            float f3 = 0.001f;
            Class<?> clazz = classArray2[classArray2.length - 1].getComponentType();
            if (n2 != 0) {
                f2 += MemberUtils.getObjectTransformationCost(clazz, Object.class) + 0.001f;
            } else if (bl3) {
                Class<?> clazz2 = classArray[classArray.length - 1].getComponentType();
                f2 += MemberUtils.getObjectTransformationCost(clazz2, clazz) + 0.001f;
            } else {
                for (int i2 = classArray2.length - 1; i2 < classArray.length; ++i2) {
                    Class<?> clazz3 = classArray[i2];
                    f2 += MemberUtils.getObjectTransformationCost(clazz3, clazz) + 0.001f;
                }
            }
        }
        return f2;
    }

    private static float getObjectTransformationCost(Class<?> clazz, Class<?> clazz2) {
        if (clazz2.isPrimitive()) {
            return MemberUtils.getPrimitivePromotionCost(clazz, clazz2);
        }
        float f2 = 0.0f;
        while (clazz != null && !clazz2.equals(clazz)) {
            if (clazz2.isInterface() && ClassUtils.isAssignable(clazz, clazz2)) {
                f2 += 0.25f;
                break;
            }
            f2 += 1.0f;
            clazz = clazz.getSuperclass();
        }
        if (clazz == null) {
            f2 += 1.5f;
        }
        return f2;
    }

    private static float getPrimitivePromotionCost(Class<?> clazz, Class<?> clazz2) {
        if (clazz == null) {
            return 1.5f;
        }
        float f2 = 0.0f;
        Class<?> clazz3 = clazz;
        if (!clazz3.isPrimitive()) {
            f2 += 0.1f;
            clazz3 = ClassUtils.wrapperToPrimitive(clazz3);
        }
        for (int i2 = 0; clazz3 != clazz2 && i2 < ORDERED_PRIMITIVE_TYPES.length; ++i2) {
            if (clazz3 != ORDERED_PRIMITIVE_TYPES[i2]) continue;
            f2 += 0.1f;
            if (i2 >= ORDERED_PRIMITIVE_TYPES.length - 1) continue;
            clazz3 = ORDERED_PRIMITIVE_TYPES[i2 + 1];
        }
        return f2;
    }

    static boolean isMatchingMethod(Method method, Class<?>[] classArray) {
        return MemberUtils.isMatchingExecutable(Executable.of(method), classArray);
    }

    static boolean isMatchingConstructor(Constructor<?> constructor, Class<?>[] classArray) {
        return MemberUtils.isMatchingExecutable(Executable.of(constructor), classArray);
    }

    private static boolean isMatchingExecutable(Executable executable, Class<?>[] classArray) {
        Class<?>[] classArray2 = executable.getParameterTypes();
        if (ClassUtils.isAssignable(classArray, classArray2, true)) {
            return true;
        }
        if (executable.isVarArgs()) {
            int n2;
            for (n2 = 0; n2 < classArray2.length - 1 && n2 < classArray.length; ++n2) {
                if (ClassUtils.isAssignable(classArray[n2], classArray2[n2], true)) continue;
                return false;
            }
            Class<?> clazz = classArray2[classArray2.length - 1].getComponentType();
            while (n2 < classArray.length) {
                if (!ClassUtils.isAssignable(classArray[n2], clazz, true)) {
                    return false;
                }
                ++n2;
            }
            return true;
        }
        return false;
    }

    static final class Executable {
        private final Class<?>[] parameterTypes;
        private final boolean isVarArgs;

        private static Executable of(Method method) {
            return new Executable(method);
        }

        private static Executable of(Constructor<?> constructor) {
            return new Executable(constructor);
        }

        private Executable(Method method) {
            this.parameterTypes = method.getParameterTypes();
            this.isVarArgs = method.isVarArgs();
        }

        private Executable(Constructor<?> constructor) {
            this.parameterTypes = constructor.getParameterTypes();
            this.isVarArgs = constructor.isVarArgs();
        }

        public Class<?>[] getParameterTypes() {
            return this.parameterTypes;
        }

        public boolean isVarArgs() {
            return this.isVarArgs;
        }
    }
}

