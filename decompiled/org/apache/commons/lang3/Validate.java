/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Validate {
    private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";

    public static void isTrue(boolean bl2, String string, long l2) {
        if (!bl2) {
            throw new IllegalArgumentException(String.format(string, l2));
        }
    }

    public static void isTrue(boolean bl2, String string, double d2) {
        if (!bl2) {
            throw new IllegalArgumentException(String.format(string, d2));
        }
    }

    public static void isTrue(boolean bl2, String string, Object ... objectArray) {
        if (!bl2) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static void isTrue(boolean bl2) {
        if (!bl2) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T> T notNull(T t2) {
        return Validate.notNull(t2, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T> T notNull(T t2, String string, Object ... objectArray) {
        return Objects.requireNonNull(t2, () -> String.format(string, objectArray));
    }

    public static <T> T[] notEmpty(T[] TArray, String string, Object ... objectArray) {
        Objects.requireNonNull(TArray, () -> String.format(string, objectArray));
        if (TArray.length == 0) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
        return TArray;
    }

    public static <T> T[] notEmpty(T[] TArray) {
        return Validate.notEmpty(TArray, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T notEmpty(T t2, String string, Object ... objectArray) {
        Objects.requireNonNull(t2, () -> String.format(string, objectArray));
        if (t2.isEmpty()) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends Collection<?>> T notEmpty(T t2) {
        return Validate.notEmpty(t2, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2, String string, Object ... objectArray) {
        Objects.requireNonNull(t2, () -> String.format(string, objectArray));
        if (t2.isEmpty()) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2) {
        return Validate.notEmpty(t2, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T notEmpty(T t2, String string, Object ... objectArray) {
        Objects.requireNonNull(t2, () -> String.format(string, objectArray));
        if (t2.length() == 0) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends CharSequence> T notEmpty(T t2) {
        return Validate.notEmpty(t2, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T notBlank(T t2, String string, Object ... objectArray) {
        Objects.requireNonNull(t2, () -> String.format(string, objectArray));
        if (StringUtils.isBlank(t2)) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends CharSequence> T notBlank(T t2) {
        return Validate.notBlank(t2, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] noNullElements(T[] TArray, String string, Object ... objectArray) {
        Validate.notNull(TArray);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            if (TArray[i2] != null) continue;
            Object[] objectArray2 = ArrayUtils.add(objectArray, Integer.valueOf(i2));
            throw new IllegalArgumentException(String.format(string, objectArray2));
        }
        return TArray;
    }

    public static <T> T[] noNullElements(T[] TArray) {
        return Validate.noNullElements(TArray, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Iterable<?>> T noNullElements(T t2, String string, Object ... objectArray) {
        Validate.notNull(t2);
        int n2 = 0;
        Iterator<?> iterator = t2.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                Object[] objectArray2 = ArrayUtils.addAll(objectArray, n2);
                throw new IllegalArgumentException(String.format(string, objectArray2));
            }
            ++n2;
        }
        return t2;
    }

    public static <T extends Iterable<?>> T noNullElements(T t2) {
        return Validate.noNullElements(t2, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] TArray, int n2, String string, Object ... objectArray) {
        Validate.notNull(TArray);
        if (n2 < 0 || n2 >= TArray.length) {
            throw new IndexOutOfBoundsException(String.format(string, objectArray));
        }
        return TArray;
    }

    public static <T> T[] validIndex(T[] TArray, int n2) {
        return Validate.validIndex(TArray, n2, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, new Object[]{n2});
    }

    public static <T extends Collection<?>> T validIndex(T t2, int n2, String string, Object ... objectArray) {
        Validate.notNull(t2);
        if (n2 < 0 || n2 >= t2.size()) {
            throw new IndexOutOfBoundsException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends Collection<?>> T validIndex(T t2, int n2) {
        return Validate.validIndex(t2, n2, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, new Object[]{n2});
    }

    public static <T extends CharSequence> T validIndex(T t2, int n2, String string, Object ... objectArray) {
        Validate.notNull(t2);
        if (n2 < 0 || n2 >= t2.length()) {
            throw new IndexOutOfBoundsException(String.format(string, objectArray));
        }
        return t2;
    }

    public static <T extends CharSequence> T validIndex(T t2, int n2) {
        return Validate.validIndex(t2, n2, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, n2);
    }

    public static void validState(boolean bl2) {
        if (!bl2) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void validState(boolean bl2, String string, Object ... objectArray) {
        if (!bl2) {
            throw new IllegalStateException(String.format(string, objectArray));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String string) {
        if (!Pattern.matches(string, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, string));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String string, String string2, Object ... objectArray) {
        if (!Pattern.matches(string, charSequence)) {
            throw new IllegalArgumentException(String.format(string2, objectArray));
        }
    }

    public static void notNaN(double d2) {
        Validate.notNaN(d2, DEFAULT_NOT_NAN_EX_MESSAGE, new Object[0]);
    }

    public static void notNaN(double d2, String string, Object ... objectArray) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static void finite(double d2) {
        Validate.finite(d2, DEFAULT_FINITE_EX_MESSAGE, d2);
    }

    public static void finite(double d2, String string, Object ... objectArray) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static <T> void inclusiveBetween(T t2, T t3, Comparable<T> comparable) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t3) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t3));
        }
    }

    public static <T> void inclusiveBetween(T t2, T t3, Comparable<T> comparable, String string, Object ... objectArray) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t3) > 0) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static void inclusiveBetween(long l2, long l3, long l4) {
        if (l4 < l2 || l4 > l3) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, l4, l2, l3));
        }
    }

    public static void inclusiveBetween(long l2, long l3, long l4, String string) {
        if (l4 < l2 || l4 > l3) {
            throw new IllegalArgumentException(string);
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, d4, d2, d3));
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4, String string) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(string);
        }
    }

    public static <T> void exclusiveBetween(T t2, T t3, Comparable<T> comparable) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t3) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t3));
        }
    }

    public static <T> void exclusiveBetween(T t2, T t3, Comparable<T> comparable, String string, Object ... objectArray) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t3) >= 0) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static void exclusiveBetween(long l2, long l3, long l4) {
        if (l4 <= l2 || l4 >= l3) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, l4, l2, l3));
        }
    }

    public static void exclusiveBetween(long l2, long l3, long l4, String string) {
        if (l4 <= l2 || l4 >= l3) {
            throw new IllegalArgumentException(string);
        }
    }

    public static void exclusiveBetween(double d2, double d3, double d4) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, d4, d2, d3));
        }
    }

    public static void exclusiveBetween(double d2, double d3, double d4, String string) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(string);
        }
    }

    public static void isInstanceOf(Class<?> clazz, Object object) {
        if (!clazz.isInstance(object)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, clazz.getName(), object == null ? "null" : object.getClass().getName()));
        }
    }

    public static void isInstanceOf(Class<?> clazz, Object object, String string, Object ... objectArray) {
        if (!clazz.isInstance(object)) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }

    public static void isAssignableFrom(Class<?> clazz, Class<?> clazz2) {
        if (!clazz.isAssignableFrom(clazz2)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, clazz2 == null ? "null" : clazz2.getName(), clazz.getName()));
        }
    }

    public static void isAssignableFrom(Class<?> clazz, Class<?> clazz2, String string, Object ... objectArray) {
        if (!clazz.isAssignableFrom(clazz2)) {
            throw new IllegalArgumentException(String.format(string, objectArray));
        }
    }
}

