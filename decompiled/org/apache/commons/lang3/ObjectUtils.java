/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Supplier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DurationUtils;

public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    public static boolean allNotNull(Object ... objectArray) {
        if (objectArray == null) {
            return false;
        }
        for (Object object : objectArray) {
            if (object != null) continue;
            return false;
        }
        return true;
    }

    public static boolean allNull(Object ... objectArray) {
        return !ObjectUtils.anyNotNull(objectArray);
    }

    public static boolean anyNotNull(Object ... objectArray) {
        return ObjectUtils.firstNonNull(objectArray) != null;
    }

    public static boolean anyNull(Object ... objectArray) {
        return !ObjectUtils.allNotNull(objectArray);
    }

    public static <T> T clone(T t2) {
        if (t2 instanceof Cloneable) {
            Object object;
            Class<?> clazz;
            if (t2.getClass().isArray()) {
                clazz = t2.getClass().getComponentType();
                if (clazz.isPrimitive()) {
                    int n2 = Array.getLength(t2);
                    object = Array.newInstance(clazz, n2);
                    while (n2-- > 0) {
                        Array.set(object, n2, Array.get(t2, n2));
                    }
                } else {
                    object = ((Object[])t2).clone();
                }
            } else {
                try {
                    clazz = t2.getClass().getMethod("clone", new Class[0]);
                    object = ((Method)((Object)clazz)).invoke(t2, new Object[0]);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    throw new CloneFailedException("Cloneable type " + t2.getClass().getName() + " has no clone method", noSuchMethodException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new CloneFailedException("Cannot clone Cloneable type " + t2.getClass().getName(), illegalAccessException);
                }
                catch (InvocationTargetException invocationTargetException) {
                    throw new CloneFailedException("Exception cloning Cloneable type " + t2.getClass().getName(), invocationTargetException.getCause());
                }
            }
            clazz = object;
            return (T)clazz;
        }
        return null;
    }

    public static <T> T cloneIfPossible(T t2) {
        T t3 = ObjectUtils.clone(t2);
        return t3 == null ? t2 : t3;
    }

    public static <T extends Comparable<? super T>> int compare(T t2, T t3) {
        return ObjectUtils.compare(t2, t3, false);
    }

    public static <T extends Comparable<? super T>> int compare(T t2, T t3, boolean bl2) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return bl2 ? 1 : -1;
        }
        if (t3 == null) {
            return bl2 ? -1 : 1;
        }
        return t2.compareTo(t3);
    }

    public static boolean CONST(boolean bl2) {
        return bl2;
    }

    public static byte CONST(byte by2) {
        return by2;
    }

    public static char CONST(char c2) {
        return c2;
    }

    public static double CONST(double d2) {
        return d2;
    }

    public static float CONST(float f2) {
        return f2;
    }

    public static int CONST(int n2) {
        return n2;
    }

    public static long CONST(long l2) {
        return l2;
    }

    public static short CONST(short s2) {
        return s2;
    }

    public static <T> T CONST(T t2) {
        return t2;
    }

    public static byte CONST_BYTE(int n2) {
        if (n2 < -128 || n2 > 127) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + n2 + "]");
        }
        return (byte)n2;
    }

    public static short CONST_SHORT(int n2) {
        if (n2 < Short.MIN_VALUE || n2 > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + n2 + "]");
        }
        return (short)n2;
    }

    public static <T> T defaultIfNull(T t2, T t3) {
        return t2 != null ? t2 : t3;
    }

    @Deprecated
    public static boolean equals(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object == null || object2 == null) {
            return false;
        }
        return object.equals(object2);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T ... TArray) {
        if (TArray != null) {
            for (T t2 : TArray) {
                if (t2 == null) continue;
                return t2;
            }
        }
        return null;
    }

    @SafeVarargs
    public static <T> T getFirstNonNull(Supplier<T> ... supplierArray) {
        if (supplierArray != null) {
            for (Supplier<T> supplier : supplierArray) {
                T t2;
                if (supplier == null || (t2 = supplier.get()) == null) continue;
                return t2;
            }
        }
        return null;
    }

    public static <T> T getIfNull(T t2, Supplier<T> supplier) {
        return (T)(t2 != null ? t2 : (supplier == null ? null : supplier.get()));
    }

    @Deprecated
    public static int hashCode(Object object) {
        return object == null ? 0 : object.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object ... objectArray) {
        int n2 = 1;
        if (objectArray != null) {
            for (Object object : objectArray) {
                int n3 = ObjectUtils.hashCode(object);
                n2 = n2 * 31 + n3;
            }
        }
        return n2;
    }

    public static void identityToString(Appendable appendable, Object object) {
        Validate.notNull(object, "object", new Object[0]);
        appendable.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object)));
    }

    public static String identityToString(Object object) {
        if (object == null) {
            return null;
        }
        String string = object.getClass().getName();
        String string2 = Integer.toHexString(System.identityHashCode(object));
        StringBuilder stringBuilder = new StringBuilder(string.length() + 1 + string2.length());
        stringBuilder.append(string).append('@').append(string2);
        return stringBuilder.toString();
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object object) {
        Validate.notNull(object, "object", new Object[0]);
        String string = object.getClass().getName();
        String string2 = Integer.toHexString(System.identityHashCode(object));
        strBuilder.ensureCapacity(strBuilder.length() + string.length() + 1 + string2.length());
        strBuilder.append(string).append('@').append(string2);
    }

    public static void identityToString(StringBuffer stringBuffer, Object object) {
        Validate.notNull(object, "object", new Object[0]);
        String string = object.getClass().getName();
        String string2 = Integer.toHexString(System.identityHashCode(object));
        stringBuffer.ensureCapacity(stringBuffer.length() + string.length() + 1 + string2.length());
        stringBuffer.append(string).append('@').append(string2);
    }

    public static void identityToString(StringBuilder stringBuilder, Object object) {
        Validate.notNull(object, "object", new Object[0]);
        String string = object.getClass().getName();
        String string2 = Integer.toHexString(System.identityHashCode(object));
        stringBuilder.ensureCapacity(stringBuilder.length() + string.length() + 1 + string2.length());
        stringBuilder.append(string).append('@').append(string2);
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence) {
            return ((CharSequence)object).length() == 0;
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection) {
            return ((Collection)object).isEmpty();
        }
        if (object instanceof Map) {
            return ((Map)object).isEmpty();
        }
        return false;
    }

    public static boolean isNotEmpty(Object object) {
        return !ObjectUtils.isEmpty(object);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T ... TArray) {
        T t2 = null;
        if (TArray != null) {
            for (T t3 : TArray) {
                if (ObjectUtils.compare(t3, t2, false) <= 0) continue;
                t2 = t3;
            }
        }
        return t2;
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T ... TArray) {
        Validate.notEmpty(TArray, "null/empty items", new Object[0]);
        Validate.noNullElements(TArray);
        Validate.notNull(comparator, "comparator", new Object[0]);
        TreeSet<T> treeSet = new TreeSet<T>(comparator);
        Collections.addAll(treeSet, TArray);
        Object object = treeSet.toArray()[(treeSet.size() - 1) / 2];
        return (T)object;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T ... TArray) {
        Validate.notEmpty(TArray);
        Validate.noNullElements(TArray);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, TArray);
        Comparable comparable = (Comparable)treeSet.toArray()[(treeSet.size() - 1) / 2];
        return (T)comparable;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T ... TArray) {
        T t2 = null;
        if (TArray != null) {
            for (T t3 : TArray) {
                if (ObjectUtils.compare(t3, t2, true) >= 0) continue;
                t2 = t3;
            }
        }
        return t2;
    }

    /*
     * WARNING - void declaration
     */
    @SafeVarargs
    public static <T> T mode(T ... TArray) {
        if (ArrayUtils.isNotEmpty(TArray)) {
            void var2_4;
            HashMap<T, MutableInt> hashMap = new HashMap<T, MutableInt>(TArray.length);
            for (T t2 : TArray) {
                MutableInt mutableInt = (MutableInt)hashMap.get(t2);
                if (mutableInt == null) {
                    hashMap.put(t2, new MutableInt(1));
                    continue;
                }
                mutableInt.increment();
            }
            Object var2_3 = null;
            int n2 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int n3 = ((MutableInt)entry.getValue()).intValue();
                if (n3 == n2) {
                    Object var2_5 = null;
                    continue;
                }
                if (n3 <= n2) continue;
                n2 = n3;
                Object k2 = entry.getKey();
            }
            return var2_4;
        }
        return null;
    }

    public static boolean notEqual(Object object, Object object2) {
        return !ObjectUtils.equals(object, object2);
    }

    public static <T> T requireNonEmpty(T t2) {
        return ObjectUtils.requireNonEmpty(t2, "object");
    }

    public static <T> T requireNonEmpty(T t2, String string) {
        Objects.requireNonNull(t2, string);
        if (ObjectUtils.isEmpty(t2)) {
            throw new IllegalArgumentException(string);
        }
        return t2;
    }

    @Deprecated
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    @Deprecated
    public static String toString(Object object, String string) {
        return object == null ? string : object.toString();
    }

    public static String toString(Object object, Supplier<String> supplier) {
        return object == null ? (supplier == null ? null : supplier.get()) : object.toString();
    }

    public static void wait(Object object, Duration duration) {
        DurationUtils.accept(object::wait, DurationUtils.zeroIfNull(duration));
    }

    public static class Null
    implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return NULL;
        }
    }
}

