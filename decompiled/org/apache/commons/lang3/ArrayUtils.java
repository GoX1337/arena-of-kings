/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;

public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final Method[] EMPTY_METHOD_ARRAY = new Method[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
    public static final int INDEX_NOT_FOUND = -1;

    public static boolean[] add(boolean[] blArray, boolean bl2) {
        boolean[] blArray2 = (boolean[])ArrayUtils.copyArrayGrow1(blArray, Boolean.TYPE);
        blArray2[blArray2.length - 1] = bl2;
        return blArray2;
    }

    @Deprecated
    public static boolean[] add(boolean[] blArray, int n2, boolean bl2) {
        return (boolean[])ArrayUtils.add(blArray, n2, bl2, Boolean.TYPE);
    }

    public static byte[] add(byte[] byArray, byte by2) {
        byte[] byArray2 = (byte[])ArrayUtils.copyArrayGrow1(byArray, Byte.TYPE);
        byArray2[byArray2.length - 1] = by2;
        return byArray2;
    }

    @Deprecated
    public static byte[] add(byte[] byArray, int n2, byte by2) {
        return (byte[])ArrayUtils.add(byArray, n2, by2, Byte.TYPE);
    }

    public static char[] add(char[] cArray, char c2) {
        char[] cArray2 = (char[])ArrayUtils.copyArrayGrow1(cArray, Character.TYPE);
        cArray2[cArray2.length - 1] = c2;
        return cArray2;
    }

    @Deprecated
    public static char[] add(char[] cArray, int n2, char c2) {
        return (char[])ArrayUtils.add(cArray, n2, Character.valueOf(c2), Character.TYPE);
    }

    public static double[] add(double[] dArray, double d2) {
        double[] dArray2 = (double[])ArrayUtils.copyArrayGrow1(dArray, Double.TYPE);
        dArray2[dArray2.length - 1] = d2;
        return dArray2;
    }

    @Deprecated
    public static double[] add(double[] dArray, int n2, double d2) {
        return (double[])ArrayUtils.add(dArray, n2, d2, Double.TYPE);
    }

    public static float[] add(float[] fArray, float f2) {
        float[] fArray2 = (float[])ArrayUtils.copyArrayGrow1(fArray, Float.TYPE);
        fArray2[fArray2.length - 1] = f2;
        return fArray2;
    }

    @Deprecated
    public static float[] add(float[] fArray, int n2, float f2) {
        return (float[])ArrayUtils.add(fArray, n2, Float.valueOf(f2), Float.TYPE);
    }

    public static int[] add(int[] nArray, int n2) {
        int[] nArray2 = (int[])ArrayUtils.copyArrayGrow1(nArray, Integer.TYPE);
        nArray2[nArray2.length - 1] = n2;
        return nArray2;
    }

    @Deprecated
    public static int[] add(int[] nArray, int n2, int n3) {
        return (int[])ArrayUtils.add(nArray, n2, n3, Integer.TYPE);
    }

    @Deprecated
    public static long[] add(long[] lArray, int n2, long l2) {
        return (long[])ArrayUtils.add(lArray, n2, l2, Long.TYPE);
    }

    public static long[] add(long[] lArray, long l2) {
        long[] lArray2 = (long[])ArrayUtils.copyArrayGrow1(lArray, Long.TYPE);
        lArray2[lArray2.length - 1] = l2;
        return lArray2;
    }

    private static Object add(Object object, int n2, Object object2, Class<?> clazz) {
        if (object == null) {
            if (n2 != 0) {
                throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: 0");
            }
            Object object3 = Array.newInstance(clazz, 1);
            Array.set(object3, 0, object2);
            return object3;
        }
        int n3 = Array.getLength(object);
        if (n2 > n3 || n2 < 0) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + n3);
        }
        Object object4 = Array.newInstance(clazz, n3 + 1);
        System.arraycopy(object, 0, object4, 0, n2);
        Array.set(object4, n2, object2);
        if (n2 < n3) {
            System.arraycopy(object, n2, object4, n2 + 1, n3 - n2);
        }
        return object4;
    }

    @Deprecated
    public static short[] add(short[] sArray, int n2, short s2) {
        return (short[])ArrayUtils.add(sArray, n2, s2, Short.TYPE);
    }

    public static short[] add(short[] sArray, short s2) {
        short[] sArray2 = (short[])ArrayUtils.copyArrayGrow1(sArray, Short.TYPE);
        sArray2[sArray2.length - 1] = s2;
        return sArray2;
    }

    @Deprecated
    public static <T> T[] add(T[] TArray, int n2, T t2) {
        Class<?> clazz = null;
        if (TArray != null) {
            clazz = TArray.getClass().getComponentType();
        } else if (t2 != null) {
            clazz = t2.getClass();
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        Object[] objectArray = (Object[])ArrayUtils.add(TArray, n2, t2, clazz);
        return objectArray;
    }

    public static <T> T[] add(T[] TArray, T t2) {
        Class<?> clazz;
        if (TArray != null) {
            clazz = TArray.getClass().getComponentType();
        } else if (t2 != null) {
            clazz = t2.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        Object[] objectArray = (Object[])ArrayUtils.copyArrayGrow1(TArray, clazz);
        objectArray[objectArray.length - 1] = t2;
        return objectArray;
    }

    public static boolean[] addAll(boolean[] blArray, boolean ... blArray2) {
        if (blArray == null) {
            return ArrayUtils.clone(blArray2);
        }
        if (blArray2 == null) {
            return ArrayUtils.clone(blArray);
        }
        boolean[] blArray3 = new boolean[blArray.length + blArray2.length];
        System.arraycopy(blArray, 0, blArray3, 0, blArray.length);
        System.arraycopy(blArray2, 0, blArray3, blArray.length, blArray2.length);
        return blArray3;
    }

    public static byte[] addAll(byte[] byArray, byte ... byArray2) {
        if (byArray == null) {
            return ArrayUtils.clone(byArray2);
        }
        if (byArray2 == null) {
            return ArrayUtils.clone(byArray);
        }
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static char[] addAll(char[] cArray, char ... cArray2) {
        if (cArray == null) {
            return ArrayUtils.clone(cArray2);
        }
        if (cArray2 == null) {
            return ArrayUtils.clone(cArray);
        }
        char[] cArray3 = new char[cArray.length + cArray2.length];
        System.arraycopy(cArray, 0, cArray3, 0, cArray.length);
        System.arraycopy(cArray2, 0, cArray3, cArray.length, cArray2.length);
        return cArray3;
    }

    public static double[] addAll(double[] dArray, double ... dArray2) {
        if (dArray == null) {
            return ArrayUtils.clone(dArray2);
        }
        if (dArray2 == null) {
            return ArrayUtils.clone(dArray);
        }
        double[] dArray3 = new double[dArray.length + dArray2.length];
        System.arraycopy(dArray, 0, dArray3, 0, dArray.length);
        System.arraycopy(dArray2, 0, dArray3, dArray.length, dArray2.length);
        return dArray3;
    }

    public static float[] addAll(float[] fArray, float ... fArray2) {
        if (fArray == null) {
            return ArrayUtils.clone(fArray2);
        }
        if (fArray2 == null) {
            return ArrayUtils.clone(fArray);
        }
        float[] fArray3 = new float[fArray.length + fArray2.length];
        System.arraycopy(fArray, 0, fArray3, 0, fArray.length);
        System.arraycopy(fArray2, 0, fArray3, fArray.length, fArray2.length);
        return fArray3;
    }

    public static int[] addAll(int[] nArray, int ... nArray2) {
        if (nArray == null) {
            return ArrayUtils.clone(nArray2);
        }
        if (nArray2 == null) {
            return ArrayUtils.clone(nArray);
        }
        int[] nArray3 = new int[nArray.length + nArray2.length];
        System.arraycopy(nArray, 0, nArray3, 0, nArray.length);
        System.arraycopy(nArray2, 0, nArray3, nArray.length, nArray2.length);
        return nArray3;
    }

    public static long[] addAll(long[] lArray, long ... lArray2) {
        if (lArray == null) {
            return ArrayUtils.clone(lArray2);
        }
        if (lArray2 == null) {
            return ArrayUtils.clone(lArray);
        }
        long[] lArray3 = new long[lArray.length + lArray2.length];
        System.arraycopy(lArray, 0, lArray3, 0, lArray.length);
        System.arraycopy(lArray2, 0, lArray3, lArray.length, lArray2.length);
        return lArray3;
    }

    public static short[] addAll(short[] sArray, short ... sArray2) {
        if (sArray == null) {
            return ArrayUtils.clone(sArray2);
        }
        if (sArray2 == null) {
            return ArrayUtils.clone(sArray);
        }
        short[] sArray3 = new short[sArray.length + sArray2.length];
        System.arraycopy(sArray, 0, sArray3, 0, sArray.length);
        System.arraycopy(sArray2, 0, sArray3, sArray.length, sArray2.length);
        return sArray3;
    }

    public static <T> T[] addAll(T[] TArray, T ... TArray2) {
        if (TArray == null) {
            return ArrayUtils.clone(TArray2);
        }
        if (TArray2 == null) {
            return ArrayUtils.clone(TArray);
        }
        Class<?> clazz = TArray.getClass().getComponentType();
        Object[] objectArray = (Object[])Array.newInstance(clazz, TArray.length + TArray2.length);
        System.arraycopy(TArray, 0, objectArray, 0, TArray.length);
        try {
            System.arraycopy(TArray2, 0, objectArray, TArray.length, TArray2.length);
        }
        catch (ArrayStoreException arrayStoreException) {
            Class<?> clazz2 = TArray2.getClass().getComponentType();
            if (!clazz.isAssignableFrom(clazz2)) {
                throw new IllegalArgumentException("Cannot store " + clazz2.getName() + " in an array of " + clazz.getName(), arrayStoreException);
            }
            throw arrayStoreException;
        }
        return objectArray;
    }

    public static boolean[] addFirst(boolean[] blArray, boolean bl2) {
        return blArray == null ? ArrayUtils.add(blArray, bl2) : ArrayUtils.insert(0, blArray, bl2);
    }

    public static byte[] addFirst(byte[] byArray, byte by2) {
        return byArray == null ? ArrayUtils.add(byArray, by2) : ArrayUtils.insert(0, byArray, by2);
    }

    public static char[] addFirst(char[] cArray, char c2) {
        return cArray == null ? ArrayUtils.add(cArray, c2) : ArrayUtils.insert(0, cArray, c2);
    }

    public static double[] addFirst(double[] dArray, double d2) {
        return dArray == null ? ArrayUtils.add(dArray, d2) : ArrayUtils.insert(0, dArray, d2);
    }

    public static float[] addFirst(float[] fArray, float f2) {
        return fArray == null ? ArrayUtils.add(fArray, f2) : ArrayUtils.insert(0, fArray, f2);
    }

    public static int[] addFirst(int[] nArray, int n2) {
        return nArray == null ? ArrayUtils.add(nArray, n2) : ArrayUtils.insert(0, nArray, n2);
    }

    public static long[] addFirst(long[] lArray, long l2) {
        return lArray == null ? ArrayUtils.add(lArray, l2) : ArrayUtils.insert(0, lArray, l2);
    }

    public static short[] addFirst(short[] sArray, short s2) {
        return sArray == null ? ArrayUtils.add(sArray, s2) : ArrayUtils.insert(0, sArray, s2);
    }

    public static <T> T[] addFirst(T[] TArray, T t2) {
        return TArray == null ? ArrayUtils.add(TArray, t2) : ArrayUtils.insert(0, TArray, t2);
    }

    public static boolean[] clone(boolean[] blArray) {
        if (blArray == null) {
            return null;
        }
        return (boolean[])blArray.clone();
    }

    public static byte[] clone(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        return (byte[])byArray.clone();
    }

    public static char[] clone(char[] cArray) {
        if (cArray == null) {
            return null;
        }
        return (char[])cArray.clone();
    }

    public static double[] clone(double[] dArray) {
        if (dArray == null) {
            return null;
        }
        return (double[])dArray.clone();
    }

    public static float[] clone(float[] fArray) {
        if (fArray == null) {
            return null;
        }
        return (float[])fArray.clone();
    }

    public static int[] clone(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        return (int[])nArray.clone();
    }

    public static long[] clone(long[] lArray) {
        if (lArray == null) {
            return null;
        }
        return (long[])lArray.clone();
    }

    public static short[] clone(short[] sArray) {
        if (sArray == null) {
            return null;
        }
        return (short[])sArray.clone();
    }

    public static <T> T[] clone(T[] TArray) {
        if (TArray == null) {
            return null;
        }
        return (Object[])TArray.clone();
    }

    public static boolean contains(boolean[] blArray, boolean bl2) {
        return ArrayUtils.indexOf(blArray, bl2) != -1;
    }

    public static boolean contains(byte[] byArray, byte by2) {
        return ArrayUtils.indexOf(byArray, by2) != -1;
    }

    public static boolean contains(char[] cArray, char c2) {
        return ArrayUtils.indexOf(cArray, c2) != -1;
    }

    public static boolean contains(double[] dArray, double d2) {
        return ArrayUtils.indexOf(dArray, d2) != -1;
    }

    public static boolean contains(double[] dArray, double d2, double d3) {
        return ArrayUtils.indexOf(dArray, d2, 0, d3) != -1;
    }

    public static boolean contains(float[] fArray, float f2) {
        return ArrayUtils.indexOf(fArray, f2) != -1;
    }

    public static boolean contains(int[] nArray, int n2) {
        return ArrayUtils.indexOf(nArray, n2) != -1;
    }

    public static boolean contains(long[] lArray, long l2) {
        return ArrayUtils.indexOf(lArray, l2) != -1;
    }

    public static boolean contains(Object[] objectArray, Object object) {
        return ArrayUtils.indexOf(objectArray, object) != -1;
    }

    public static boolean contains(short[] sArray, short s2) {
        return ArrayUtils.indexOf(sArray, s2) != -1;
    }

    private static Object copyArrayGrow1(Object object, Class<?> clazz) {
        if (object != null) {
            int n2 = Array.getLength(object);
            Object object2 = Array.newInstance(object.getClass().getComponentType(), n2 + 1);
            System.arraycopy(object, 0, object2, 0, n2);
            return object2;
        }
        return Array.newInstance(clazz, 1);
    }

    public static <T> T get(T[] TArray, int n2) {
        return ArrayUtils.get(TArray, n2, null);
    }

    public static <T> T get(T[] TArray, int n2, T t2) {
        return ArrayUtils.isArrayIndexValid(TArray, n2) ? TArray[n2] : t2;
    }

    public static int getLength(Object object) {
        if (object == null) {
            return 0;
        }
        return Array.getLength(object);
    }

    public static int hashCode(Object object) {
        return new HashCodeBuilder().append(object).toHashCode();
    }

    public static BitSet indexesOf(boolean[] blArray, boolean bl2) {
        return ArrayUtils.indexesOf(blArray, bl2, 0);
    }

    public static BitSet indexesOf(boolean[] blArray, boolean bl2, int n2) {
        BitSet bitSet = new BitSet();
        if (blArray == null) {
            return bitSet;
        }
        while (n2 < blArray.length && (n2 = ArrayUtils.indexOf(blArray, bl2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(byte[] byArray, byte by2) {
        return ArrayUtils.indexesOf(byArray, by2, 0);
    }

    public static BitSet indexesOf(byte[] byArray, byte by2, int n2) {
        BitSet bitSet = new BitSet();
        if (byArray == null) {
            return bitSet;
        }
        while (n2 < byArray.length && (n2 = ArrayUtils.indexOf(byArray, by2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(char[] cArray, char c2) {
        return ArrayUtils.indexesOf(cArray, c2, 0);
    }

    public static BitSet indexesOf(char[] cArray, char c2, int n2) {
        BitSet bitSet = new BitSet();
        if (cArray == null) {
            return bitSet;
        }
        while (n2 < cArray.length && (n2 = ArrayUtils.indexOf(cArray, c2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(double[] dArray, double d2) {
        return ArrayUtils.indexesOf(dArray, d2, 0);
    }

    public static BitSet indexesOf(double[] dArray, double d2, double d3) {
        return ArrayUtils.indexesOf(dArray, d2, 0, d3);
    }

    public static BitSet indexesOf(double[] dArray, double d2, int n2) {
        BitSet bitSet = new BitSet();
        if (dArray == null) {
            return bitSet;
        }
        while (n2 < dArray.length && (n2 = ArrayUtils.indexOf(dArray, d2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(double[] dArray, double d2, int n2, double d3) {
        BitSet bitSet = new BitSet();
        if (dArray == null) {
            return bitSet;
        }
        while (n2 < dArray.length && (n2 = ArrayUtils.indexOf(dArray, d2, n2, d3)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(float[] fArray, float f2) {
        return ArrayUtils.indexesOf(fArray, f2, 0);
    }

    public static BitSet indexesOf(float[] fArray, float f2, int n2) {
        BitSet bitSet = new BitSet();
        if (fArray == null) {
            return bitSet;
        }
        while (n2 < fArray.length && (n2 = ArrayUtils.indexOf(fArray, f2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(int[] nArray, int n2) {
        return ArrayUtils.indexesOf(nArray, n2, 0);
    }

    public static BitSet indexesOf(int[] nArray, int n2, int n3) {
        BitSet bitSet = new BitSet();
        if (nArray == null) {
            return bitSet;
        }
        while (n3 < nArray.length && (n3 = ArrayUtils.indexOf(nArray, n2, n3)) != -1) {
            bitSet.set(n3);
            ++n3;
        }
        return bitSet;
    }

    public static BitSet indexesOf(long[] lArray, long l2) {
        return ArrayUtils.indexesOf(lArray, l2, 0);
    }

    public static BitSet indexesOf(long[] lArray, long l2, int n2) {
        BitSet bitSet = new BitSet();
        if (lArray == null) {
            return bitSet;
        }
        while (n2 < lArray.length && (n2 = ArrayUtils.indexOf(lArray, l2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(Object[] objectArray, Object object) {
        return ArrayUtils.indexesOf(objectArray, object, 0);
    }

    public static BitSet indexesOf(Object[] objectArray, Object object, int n2) {
        BitSet bitSet = new BitSet();
        if (objectArray == null) {
            return bitSet;
        }
        while (n2 < objectArray.length && (n2 = ArrayUtils.indexOf(objectArray, object, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static BitSet indexesOf(short[] sArray, short s2) {
        return ArrayUtils.indexesOf(sArray, s2, 0);
    }

    public static BitSet indexesOf(short[] sArray, short s2, int n2) {
        BitSet bitSet = new BitSet();
        if (sArray == null) {
            return bitSet;
        }
        while (n2 < sArray.length && (n2 = ArrayUtils.indexOf(sArray, s2, n2)) != -1) {
            bitSet.set(n2);
            ++n2;
        }
        return bitSet;
    }

    public static int indexOf(boolean[] blArray, boolean bl2) {
        return ArrayUtils.indexOf(blArray, bl2, 0);
    }

    public static int indexOf(boolean[] blArray, boolean bl2, int n2) {
        if (ArrayUtils.isEmpty(blArray)) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i2 = n2; i2 < blArray.length; ++i2) {
            if (bl2 != blArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(byte[] byArray, byte by2) {
        return ArrayUtils.indexOf(byArray, by2, 0);
    }

    public static int indexOf(byte[] byArray, byte by2, int n2) {
        if (byArray == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i2 = n2; i2 < byArray.length; ++i2) {
            if (by2 != byArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(char[] cArray, char c2) {
        return ArrayUtils.indexOf(cArray, c2, 0);
    }

    public static int indexOf(char[] cArray, char c2, int n2) {
        if (cArray == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i2 = n2; i2 < cArray.length; ++i2) {
            if (c2 != cArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(double[] dArray, double d2) {
        return ArrayUtils.indexOf(dArray, d2, 0);
    }

    public static int indexOf(double[] dArray, double d2, double d3) {
        return ArrayUtils.indexOf(dArray, d2, 0, d3);
    }

    public static int indexOf(double[] dArray, double d2, int n2) {
        if (ArrayUtils.isEmpty(dArray)) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        boolean bl2 = Double.isNaN(d2);
        for (int i2 = n2; i2 < dArray.length; ++i2) {
            double d3 = dArray[i2];
            if (d2 != d3 && (!bl2 || !Double.isNaN(d3))) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(double[] dArray, double d2, int n2, double d3) {
        if (ArrayUtils.isEmpty(dArray)) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        for (int i2 = n2; i2 < dArray.length; ++i2) {
            if (!(dArray[i2] >= d4) || !(dArray[i2] <= d5)) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(float[] fArray, float f2) {
        return ArrayUtils.indexOf(fArray, f2, 0);
    }

    public static int indexOf(float[] fArray, float f2, int n2) {
        if (ArrayUtils.isEmpty(fArray)) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        boolean bl2 = Float.isNaN(f2);
        for (int i2 = n2; i2 < fArray.length; ++i2) {
            float f3 = fArray[i2];
            if (f2 != f3 && (!bl2 || !Float.isNaN(f3))) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(int[] nArray, int n2) {
        return ArrayUtils.indexOf(nArray, n2, 0);
    }

    public static int indexOf(int[] nArray, int n2, int n3) {
        if (nArray == null) {
            return -1;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        for (int i2 = n3; i2 < nArray.length; ++i2) {
            if (n2 != nArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(long[] lArray, long l2) {
        return ArrayUtils.indexOf(lArray, l2, 0);
    }

    public static int indexOf(long[] lArray, long l2, int n2) {
        if (lArray == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i2 = n2; i2 < lArray.length; ++i2) {
            if (l2 != lArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int indexOf(Object[] objectArray, Object object) {
        return ArrayUtils.indexOf(objectArray, object, 0);
    }

    public static int indexOf(Object[] objectArray, Object object, int n2) {
        if (objectArray == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (object == null) {
            for (int i2 = n2; i2 < objectArray.length; ++i2) {
                if (objectArray[i2] != null) continue;
                return i2;
            }
        } else {
            for (int i3 = n2; i3 < objectArray.length; ++i3) {
                if (!object.equals(objectArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    public static int indexOf(short[] sArray, short s2) {
        return ArrayUtils.indexOf(sArray, s2, 0);
    }

    public static int indexOf(short[] sArray, short s2, int n2) {
        if (sArray == null) {
            return -1;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i2 = n2; i2 < sArray.length; ++i2) {
            if (s2 != sArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static boolean[] insert(int n2, boolean[] blArray, boolean ... blArray2) {
        if (blArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(blArray2)) {
            return ArrayUtils.clone(blArray);
        }
        if (n2 < 0 || n2 > blArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + blArray.length);
        }
        boolean[] blArray3 = new boolean[blArray.length + blArray2.length];
        System.arraycopy(blArray2, 0, blArray3, n2, blArray2.length);
        if (n2 > 0) {
            System.arraycopy(blArray, 0, blArray3, 0, n2);
        }
        if (n2 < blArray.length) {
            System.arraycopy(blArray, n2, blArray3, n2 + blArray2.length, blArray.length - n2);
        }
        return blArray3;
    }

    public static byte[] insert(int n2, byte[] byArray, byte ... byArray2) {
        if (byArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(byArray2)) {
            return ArrayUtils.clone(byArray);
        }
        if (n2 < 0 || n2 > byArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + byArray.length);
        }
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray2, 0, byArray3, n2, byArray2.length);
        if (n2 > 0) {
            System.arraycopy(byArray, 0, byArray3, 0, n2);
        }
        if (n2 < byArray.length) {
            System.arraycopy(byArray, n2, byArray3, n2 + byArray2.length, byArray.length - n2);
        }
        return byArray3;
    }

    public static char[] insert(int n2, char[] cArray, char ... cArray2) {
        if (cArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(cArray2)) {
            return ArrayUtils.clone(cArray);
        }
        if (n2 < 0 || n2 > cArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + cArray.length);
        }
        char[] cArray3 = new char[cArray.length + cArray2.length];
        System.arraycopy(cArray2, 0, cArray3, n2, cArray2.length);
        if (n2 > 0) {
            System.arraycopy(cArray, 0, cArray3, 0, n2);
        }
        if (n2 < cArray.length) {
            System.arraycopy(cArray, n2, cArray3, n2 + cArray2.length, cArray.length - n2);
        }
        return cArray3;
    }

    public static double[] insert(int n2, double[] dArray, double ... dArray2) {
        if (dArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(dArray2)) {
            return ArrayUtils.clone(dArray);
        }
        if (n2 < 0 || n2 > dArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + dArray.length);
        }
        double[] dArray3 = new double[dArray.length + dArray2.length];
        System.arraycopy(dArray2, 0, dArray3, n2, dArray2.length);
        if (n2 > 0) {
            System.arraycopy(dArray, 0, dArray3, 0, n2);
        }
        if (n2 < dArray.length) {
            System.arraycopy(dArray, n2, dArray3, n2 + dArray2.length, dArray.length - n2);
        }
        return dArray3;
    }

    public static float[] insert(int n2, float[] fArray, float ... fArray2) {
        if (fArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(fArray2)) {
            return ArrayUtils.clone(fArray);
        }
        if (n2 < 0 || n2 > fArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + fArray.length);
        }
        float[] fArray3 = new float[fArray.length + fArray2.length];
        System.arraycopy(fArray2, 0, fArray3, n2, fArray2.length);
        if (n2 > 0) {
            System.arraycopy(fArray, 0, fArray3, 0, n2);
        }
        if (n2 < fArray.length) {
            System.arraycopy(fArray, n2, fArray3, n2 + fArray2.length, fArray.length - n2);
        }
        return fArray3;
    }

    public static int[] insert(int n2, int[] nArray, int ... nArray2) {
        if (nArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(nArray2)) {
            return ArrayUtils.clone(nArray);
        }
        if (n2 < 0 || n2 > nArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + nArray.length);
        }
        int[] nArray3 = new int[nArray.length + nArray2.length];
        System.arraycopy(nArray2, 0, nArray3, n2, nArray2.length);
        if (n2 > 0) {
            System.arraycopy(nArray, 0, nArray3, 0, n2);
        }
        if (n2 < nArray.length) {
            System.arraycopy(nArray, n2, nArray3, n2 + nArray2.length, nArray.length - n2);
        }
        return nArray3;
    }

    public static long[] insert(int n2, long[] lArray, long ... lArray2) {
        if (lArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(lArray2)) {
            return ArrayUtils.clone(lArray);
        }
        if (n2 < 0 || n2 > lArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + lArray.length);
        }
        long[] lArray3 = new long[lArray.length + lArray2.length];
        System.arraycopy(lArray2, 0, lArray3, n2, lArray2.length);
        if (n2 > 0) {
            System.arraycopy(lArray, 0, lArray3, 0, n2);
        }
        if (n2 < lArray.length) {
            System.arraycopy(lArray, n2, lArray3, n2 + lArray2.length, lArray.length - n2);
        }
        return lArray3;
    }

    public static short[] insert(int n2, short[] sArray, short ... sArray2) {
        if (sArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(sArray2)) {
            return ArrayUtils.clone(sArray);
        }
        if (n2 < 0 || n2 > sArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + sArray.length);
        }
        short[] sArray3 = new short[sArray.length + sArray2.length];
        System.arraycopy(sArray2, 0, sArray3, n2, sArray2.length);
        if (n2 > 0) {
            System.arraycopy(sArray, 0, sArray3, 0, n2);
        }
        if (n2 < sArray.length) {
            System.arraycopy(sArray, n2, sArray3, n2 + sArray2.length, sArray.length - n2);
        }
        return sArray3;
    }

    @SafeVarargs
    public static <T> T[] insert(int n2, T[] TArray, T ... TArray2) {
        if (TArray == null) {
            return null;
        }
        if (ArrayUtils.isEmpty(TArray2)) {
            return ArrayUtils.clone(TArray);
        }
        if (n2 < 0 || n2 > TArray.length) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + TArray.length);
        }
        Class<?> clazz = TArray.getClass().getComponentType();
        Object[] objectArray = (Object[])Array.newInstance(clazz, TArray.length + TArray2.length);
        System.arraycopy(TArray2, 0, objectArray, n2, TArray2.length);
        if (n2 > 0) {
            System.arraycopy(TArray, 0, objectArray, 0, n2);
        }
        if (n2 < TArray.length) {
            System.arraycopy(TArray, n2, objectArray, n2 + TArray2.length, TArray.length - n2);
        }
        return objectArray;
    }

    public static <T> boolean isArrayIndexValid(T[] TArray, int n2) {
        return n2 >= 0 && ArrayUtils.getLength(TArray) > n2;
    }

    public static boolean isEmpty(boolean[] blArray) {
        return ArrayUtils.getLength(blArray) == 0;
    }

    public static boolean isEmpty(byte[] byArray) {
        return ArrayUtils.getLength(byArray) == 0;
    }

    public static boolean isEmpty(char[] cArray) {
        return ArrayUtils.getLength(cArray) == 0;
    }

    public static boolean isEmpty(double[] dArray) {
        return ArrayUtils.getLength(dArray) == 0;
    }

    public static boolean isEmpty(float[] fArray) {
        return ArrayUtils.getLength(fArray) == 0;
    }

    public static boolean isEmpty(int[] nArray) {
        return ArrayUtils.getLength(nArray) == 0;
    }

    public static boolean isEmpty(long[] lArray) {
        return ArrayUtils.getLength(lArray) == 0;
    }

    public static boolean isEmpty(Object[] objectArray) {
        return ArrayUtils.getLength(objectArray) == 0;
    }

    public static boolean isEmpty(short[] sArray) {
        return ArrayUtils.getLength(sArray) == 0;
    }

    @Deprecated
    public static boolean isEquals(Object object, Object object2) {
        return new EqualsBuilder().append(object, object2).isEquals();
    }

    public static boolean isNotEmpty(boolean[] blArray) {
        return !ArrayUtils.isEmpty(blArray);
    }

    public static boolean isNotEmpty(byte[] byArray) {
        return !ArrayUtils.isEmpty(byArray);
    }

    public static boolean isNotEmpty(char[] cArray) {
        return !ArrayUtils.isEmpty(cArray);
    }

    public static boolean isNotEmpty(double[] dArray) {
        return !ArrayUtils.isEmpty(dArray);
    }

    public static boolean isNotEmpty(float[] fArray) {
        return !ArrayUtils.isEmpty(fArray);
    }

    public static boolean isNotEmpty(int[] nArray) {
        return !ArrayUtils.isEmpty(nArray);
    }

    public static boolean isNotEmpty(long[] lArray) {
        return !ArrayUtils.isEmpty(lArray);
    }

    public static boolean isNotEmpty(short[] sArray) {
        return !ArrayUtils.isEmpty(sArray);
    }

    public static <T> boolean isNotEmpty(T[] TArray) {
        return !ArrayUtils.isEmpty(TArray);
    }

    public static boolean isSameLength(boolean[] blArray, boolean[] blArray2) {
        return ArrayUtils.getLength(blArray) == ArrayUtils.getLength(blArray2);
    }

    public static boolean isSameLength(byte[] byArray, byte[] byArray2) {
        return ArrayUtils.getLength(byArray) == ArrayUtils.getLength(byArray2);
    }

    public static boolean isSameLength(char[] cArray, char[] cArray2) {
        return ArrayUtils.getLength(cArray) == ArrayUtils.getLength(cArray2);
    }

    public static boolean isSameLength(double[] dArray, double[] dArray2) {
        return ArrayUtils.getLength(dArray) == ArrayUtils.getLength(dArray2);
    }

    public static boolean isSameLength(float[] fArray, float[] fArray2) {
        return ArrayUtils.getLength(fArray) == ArrayUtils.getLength(fArray2);
    }

    public static boolean isSameLength(int[] nArray, int[] nArray2) {
        return ArrayUtils.getLength(nArray) == ArrayUtils.getLength(nArray2);
    }

    public static boolean isSameLength(long[] lArray, long[] lArray2) {
        return ArrayUtils.getLength(lArray) == ArrayUtils.getLength(lArray2);
    }

    public static boolean isSameLength(Object object, Object object2) {
        return ArrayUtils.getLength(object) == ArrayUtils.getLength(object2);
    }

    public static boolean isSameLength(Object[] objectArray, Object[] objectArray2) {
        return ArrayUtils.getLength(objectArray) == ArrayUtils.getLength(objectArray2);
    }

    public static boolean isSameLength(short[] sArray, short[] sArray2) {
        return ArrayUtils.getLength(sArray) == ArrayUtils.getLength(sArray2);
    }

    public static boolean isSameType(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return object.getClass().getName().equals(object2.getClass().getName());
    }

    public static boolean isSorted(boolean[] blArray) {
        if (blArray == null || blArray.length < 2) {
            return true;
        }
        boolean bl2 = blArray[0];
        int n2 = blArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            boolean bl3 = blArray[i2];
            if (BooleanUtils.compare(bl2, bl3) > 0) {
                return false;
            }
            bl2 = bl3;
        }
        return true;
    }

    public static boolean isSorted(byte[] byArray) {
        if (byArray == null || byArray.length < 2) {
            return true;
        }
        byte by2 = byArray[0];
        int n2 = byArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            byte by3 = byArray[i2];
            if (NumberUtils.compare(by2, by3) > 0) {
                return false;
            }
            by2 = by3;
        }
        return true;
    }

    public static boolean isSorted(char[] cArray) {
        if (cArray == null || cArray.length < 2) {
            return true;
        }
        char c2 = cArray[0];
        int n2 = cArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            char c3 = cArray[i2];
            if (CharUtils.compare(c2, c3) > 0) {
                return false;
            }
            c2 = c3;
        }
        return true;
    }

    public static boolean isSorted(double[] dArray) {
        if (dArray == null || dArray.length < 2) {
            return true;
        }
        double d2 = dArray[0];
        int n2 = dArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            double d3 = dArray[i2];
            if (Double.compare(d2, d3) > 0) {
                return false;
            }
            d2 = d3;
        }
        return true;
    }

    public static boolean isSorted(float[] fArray) {
        if (fArray == null || fArray.length < 2) {
            return true;
        }
        float f2 = fArray[0];
        int n2 = fArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            float f3 = fArray[i2];
            if (Float.compare(f2, f3) > 0) {
                return false;
            }
            f2 = f3;
        }
        return true;
    }

    public static boolean isSorted(int[] nArray) {
        if (nArray == null || nArray.length < 2) {
            return true;
        }
        int n2 = nArray[0];
        int n3 = nArray.length;
        for (int i2 = 1; i2 < n3; ++i2) {
            int n4 = nArray[i2];
            if (NumberUtils.compare(n2, n4) > 0) {
                return false;
            }
            n2 = n4;
        }
        return true;
    }

    public static boolean isSorted(long[] lArray) {
        if (lArray == null || lArray.length < 2) {
            return true;
        }
        long l2 = lArray[0];
        int n2 = lArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            long l3 = lArray[i2];
            if (NumberUtils.compare(l2, l3) > 0) {
                return false;
            }
            l2 = l3;
        }
        return true;
    }

    public static boolean isSorted(short[] sArray) {
        if (sArray == null || sArray.length < 2) {
            return true;
        }
        short s2 = sArray[0];
        int n2 = sArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            short s3 = sArray[i2];
            if (NumberUtils.compare(s2, s3) > 0) {
                return false;
            }
            s2 = s3;
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] TArray) {
        return ArrayUtils.isSorted(TArray, Comparable::compareTo);
    }

    public static <T> boolean isSorted(T[] TArray, Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator should not be null.");
        }
        if (TArray == null || TArray.length < 2) {
            return true;
        }
        T t2 = TArray[0];
        int n2 = TArray.length;
        for (int i2 = 1; i2 < n2; ++i2) {
            T t3 = TArray[i2];
            if (comparator.compare(t2, t3) > 0) {
                return false;
            }
            t2 = t3;
        }
        return true;
    }

    public static int lastIndexOf(boolean[] blArray, boolean bl2) {
        return ArrayUtils.lastIndexOf(blArray, bl2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(boolean[] blArray, boolean bl2, int n2) {
        if (ArrayUtils.isEmpty(blArray)) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= blArray.length) {
            n2 = blArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (bl2 != blArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] byArray, byte by2) {
        return ArrayUtils.lastIndexOf(byArray, by2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(byte[] byArray, byte by2, int n2) {
        if (byArray == null) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= byArray.length) {
            n2 = byArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (by2 != byArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArray, char c2) {
        return ArrayUtils.lastIndexOf(cArray, c2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(char[] cArray, char c2, int n2) {
        if (cArray == null) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= cArray.length) {
            n2 = cArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (c2 != cArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArray, double d2) {
        return ArrayUtils.lastIndexOf(dArray, d2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(double[] dArray, double d2, double d3) {
        return ArrayUtils.lastIndexOf(dArray, d2, Integer.MAX_VALUE, d3);
    }

    public static int lastIndexOf(double[] dArray, double d2, int n2) {
        if (ArrayUtils.isEmpty(dArray)) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= dArray.length) {
            n2 = dArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (d2 != dArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArray, double d2, int n2, double d3) {
        if (ArrayUtils.isEmpty(dArray)) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= dArray.length) {
            n2 = dArray.length - 1;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        for (int i2 = n2; i2 >= 0; --i2) {
            if (!(dArray[i2] >= d4) || !(dArray[i2] <= d5)) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArray, float f2) {
        return ArrayUtils.lastIndexOf(fArray, f2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(float[] fArray, float f2, int n2) {
        if (ArrayUtils.isEmpty(fArray)) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= fArray.length) {
            n2 = fArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (f2 != fArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(int[] nArray, int n2) {
        return ArrayUtils.lastIndexOf(nArray, n2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(int[] nArray, int n2, int n3) {
        if (nArray == null) {
            return -1;
        }
        if (n3 < 0) {
            return -1;
        }
        if (n3 >= nArray.length) {
            n3 = nArray.length - 1;
        }
        for (int i2 = n3; i2 >= 0; --i2) {
            if (n2 != nArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(long[] lArray, long l2) {
        return ArrayUtils.lastIndexOf(lArray, l2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(long[] lArray, long l2, int n2) {
        if (lArray == null) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= lArray.length) {
            n2 = lArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (l2 != lArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objectArray, Object object) {
        return ArrayUtils.lastIndexOf(objectArray, object, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(Object[] objectArray, Object object, int n2) {
        block6: {
            block5: {
                if (objectArray == null) {
                    return -1;
                }
                if (n2 < 0) {
                    return -1;
                }
                if (n2 >= objectArray.length) {
                    n2 = objectArray.length - 1;
                }
                if (object != null) break block5;
                for (int i2 = n2; i2 >= 0; --i2) {
                    if (objectArray[i2] != null) continue;
                    return i2;
                }
                break block6;
            }
            if (!objectArray.getClass().getComponentType().isInstance(object)) break block6;
            for (int i3 = n2; i3 >= 0; --i3) {
                if (!object.equals(objectArray[i3])) continue;
                return i3;
            }
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArray, short s2) {
        return ArrayUtils.lastIndexOf(sArray, s2, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(short[] sArray, short s2, int n2) {
        if (sArray == null) {
            return -1;
        }
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= sArray.length) {
            n2 = sArray.length - 1;
        }
        for (int i2 = n2; i2 >= 0; --i2) {
            if (s2 != sArray[i2]) continue;
            return i2;
        }
        return -1;
    }

    public static boolean[] nullToEmpty(boolean[] blArray) {
        if (ArrayUtils.isEmpty(blArray)) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return blArray;
    }

    public static Boolean[] nullToEmpty(Boolean[] booleanArray) {
        if (ArrayUtils.isEmpty((Object[])booleanArray)) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        return booleanArray;
    }

    public static byte[] nullToEmpty(byte[] byArray) {
        if (ArrayUtils.isEmpty(byArray)) {
            return EMPTY_BYTE_ARRAY;
        }
        return byArray;
    }

    public static Byte[] nullToEmpty(Byte[] byteArray) {
        if (ArrayUtils.isEmpty((Object[])byteArray)) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        return byteArray;
    }

    public static char[] nullToEmpty(char[] cArray) {
        if (ArrayUtils.isEmpty(cArray)) {
            return EMPTY_CHAR_ARRAY;
        }
        return cArray;
    }

    public static Character[] nullToEmpty(Character[] characterArray) {
        if (ArrayUtils.isEmpty((Object[])characterArray)) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        return characterArray;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] classArray) {
        if (ArrayUtils.isEmpty(classArray)) {
            return EMPTY_CLASS_ARRAY;
        }
        return classArray;
    }

    public static double[] nullToEmpty(double[] dArray) {
        if (ArrayUtils.isEmpty(dArray)) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return dArray;
    }

    public static Double[] nullToEmpty(Double[] doubleArray) {
        if (ArrayUtils.isEmpty((Object[])doubleArray)) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return doubleArray;
    }

    public static float[] nullToEmpty(float[] fArray) {
        if (ArrayUtils.isEmpty(fArray)) {
            return EMPTY_FLOAT_ARRAY;
        }
        return fArray;
    }

    public static Float[] nullToEmpty(Float[] floatArray) {
        if (ArrayUtils.isEmpty((Object[])floatArray)) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        return floatArray;
    }

    public static int[] nullToEmpty(int[] nArray) {
        if (ArrayUtils.isEmpty(nArray)) {
            return EMPTY_INT_ARRAY;
        }
        return nArray;
    }

    public static Integer[] nullToEmpty(Integer[] integerArray) {
        if (ArrayUtils.isEmpty((Object[])integerArray)) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        return integerArray;
    }

    public static long[] nullToEmpty(long[] lArray) {
        if (ArrayUtils.isEmpty(lArray)) {
            return EMPTY_LONG_ARRAY;
        }
        return lArray;
    }

    public static Long[] nullToEmpty(Long[] longArray) {
        if (ArrayUtils.isEmpty((Object[])longArray)) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        return longArray;
    }

    public static Object[] nullToEmpty(Object[] objectArray) {
        if (ArrayUtils.isEmpty(objectArray)) {
            return EMPTY_OBJECT_ARRAY;
        }
        return objectArray;
    }

    public static short[] nullToEmpty(short[] sArray) {
        if (ArrayUtils.isEmpty(sArray)) {
            return EMPTY_SHORT_ARRAY;
        }
        return sArray;
    }

    public static Short[] nullToEmpty(Short[] shortArray) {
        if (ArrayUtils.isEmpty((Object[])shortArray)) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        return shortArray;
    }

    public static String[] nullToEmpty(String[] stringArray) {
        if (ArrayUtils.isEmpty(stringArray)) {
            return EMPTY_STRING_ARRAY;
        }
        return stringArray;
    }

    public static <T> T[] nullToEmpty(T[] TArray, Class<T[]> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        if (TArray == null) {
            return clazz.cast(Array.newInstance(clazz.getComponentType(), 0));
        }
        return TArray;
    }

    public static boolean[] remove(boolean[] blArray, int n2) {
        return (boolean[])ArrayUtils.remove((Object)blArray, n2);
    }

    public static byte[] remove(byte[] byArray, int n2) {
        return (byte[])ArrayUtils.remove((Object)byArray, n2);
    }

    public static char[] remove(char[] cArray, int n2) {
        return (char[])ArrayUtils.remove((Object)cArray, n2);
    }

    public static double[] remove(double[] dArray, int n2) {
        return (double[])ArrayUtils.remove((Object)dArray, n2);
    }

    public static float[] remove(float[] fArray, int n2) {
        return (float[])ArrayUtils.remove((Object)fArray, n2);
    }

    public static int[] remove(int[] nArray, int n2) {
        return (int[])ArrayUtils.remove((Object)nArray, n2);
    }

    public static long[] remove(long[] lArray, int n2) {
        return (long[])ArrayUtils.remove((Object)lArray, n2);
    }

    private static Object remove(Object object, int n2) {
        int n3 = ArrayUtils.getLength(object);
        if (n2 < 0 || n2 >= n3) {
            throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + n3);
        }
        Object object2 = Array.newInstance(object.getClass().getComponentType(), n3 - 1);
        System.arraycopy(object, 0, object2, 0, n2);
        if (n2 < n3 - 1) {
            System.arraycopy(object, n2 + 1, object2, n2, n3 - n2 - 1);
        }
        return object2;
    }

    public static short[] remove(short[] sArray, int n2) {
        return (short[])ArrayUtils.remove((Object)sArray, n2);
    }

    public static <T> T[] remove(T[] TArray, int n2) {
        return (Object[])ArrayUtils.remove(TArray, n2);
    }

    public static boolean[] removeAll(boolean[] blArray, int ... nArray) {
        return (boolean[])ArrayUtils.removeAll((Object)blArray, nArray);
    }

    public static byte[] removeAll(byte[] byArray, int ... nArray) {
        return (byte[])ArrayUtils.removeAll((Object)byArray, nArray);
    }

    public static char[] removeAll(char[] cArray, int ... nArray) {
        return (char[])ArrayUtils.removeAll((Object)cArray, nArray);
    }

    public static double[] removeAll(double[] dArray, int ... nArray) {
        return (double[])ArrayUtils.removeAll((Object)dArray, nArray);
    }

    public static float[] removeAll(float[] fArray, int ... nArray) {
        return (float[])ArrayUtils.removeAll((Object)fArray, nArray);
    }

    public static int[] removeAll(int[] nArray, int ... nArray2) {
        return (int[])ArrayUtils.removeAll((Object)nArray, nArray2);
    }

    public static long[] removeAll(long[] lArray, int ... nArray) {
        return (long[])ArrayUtils.removeAll((Object)lArray, nArray);
    }

    static Object removeAll(Object object, BitSet bitSet) {
        int n2;
        int n3;
        if (object == null) {
            return null;
        }
        int n4 = ArrayUtils.getLength(object);
        int n5 = bitSet.cardinality();
        Object object2 = Array.newInstance(object.getClass().getComponentType(), n4 - n5);
        int n6 = 0;
        int n7 = 0;
        while ((n3 = bitSet.nextSetBit(n6)) != -1) {
            n2 = n3 - n6;
            if (n2 > 0) {
                System.arraycopy(object, n6, object2, n7, n2);
                n7 += n2;
            }
            n6 = bitSet.nextClearBit(n3);
        }
        n2 = n4 - n6;
        if (n2 > 0) {
            System.arraycopy(object, n6, object2, n7, n2);
        }
        return object2;
    }

    static Object removeAll(Object object, int ... nArray) {
        int n2;
        int n3;
        int n4 = ArrayUtils.getLength(object);
        int n5 = 0;
        int[] nArray2 = ArraySorter.sort(ArrayUtils.clone(nArray));
        if (ArrayUtils.isNotEmpty(nArray2)) {
            int n6 = nArray2.length;
            n3 = n4;
            while (--n6 >= 0) {
                n2 = nArray2[n6];
                if (n2 < 0 || n2 >= n4) {
                    throw new IndexOutOfBoundsException("Index: " + n2 + ", Length: " + n4);
                }
                if (n2 >= n3) continue;
                ++n5;
                n3 = n2;
            }
        }
        Object object2 = Array.newInstance(object.getClass().getComponentType(), n4 - n5);
        if (n5 < n4) {
            n3 = n4;
            n2 = n4 - n5;
            for (int i2 = nArray2.length - 1; i2 >= 0; --i2) {
                int n7 = nArray2[i2];
                if (n3 - n7 > 1) {
                    int n8 = n3 - n7 - 1;
                    System.arraycopy(object, n7 + 1, object2, n2 -= n8, n8);
                }
                n3 = n7;
            }
            if (n3 > 0) {
                System.arraycopy(object, 0, object2, 0, n3);
            }
        }
        return object2;
    }

    public static short[] removeAll(short[] sArray, int ... nArray) {
        return (short[])ArrayUtils.removeAll((Object)sArray, nArray);
    }

    public static <T> T[] removeAll(T[] TArray, int ... nArray) {
        return (Object[])ArrayUtils.removeAll(TArray, nArray);
    }

    @Deprecated
    public static boolean[] removeAllOccurences(boolean[] blArray, boolean bl2) {
        return (boolean[])ArrayUtils.removeAll((Object)blArray, ArrayUtils.indexesOf(blArray, bl2));
    }

    @Deprecated
    public static byte[] removeAllOccurences(byte[] byArray, byte by2) {
        return (byte[])ArrayUtils.removeAll((Object)byArray, ArrayUtils.indexesOf(byArray, by2));
    }

    @Deprecated
    public static char[] removeAllOccurences(char[] cArray, char c2) {
        return (char[])ArrayUtils.removeAll((Object)cArray, ArrayUtils.indexesOf(cArray, c2));
    }

    @Deprecated
    public static double[] removeAllOccurences(double[] dArray, double d2) {
        return (double[])ArrayUtils.removeAll((Object)dArray, ArrayUtils.indexesOf(dArray, d2));
    }

    @Deprecated
    public static float[] removeAllOccurences(float[] fArray, float f2) {
        return (float[])ArrayUtils.removeAll((Object)fArray, ArrayUtils.indexesOf(fArray, f2));
    }

    @Deprecated
    public static int[] removeAllOccurences(int[] nArray, int n2) {
        return (int[])ArrayUtils.removeAll((Object)nArray, ArrayUtils.indexesOf(nArray, n2));
    }

    @Deprecated
    public static long[] removeAllOccurences(long[] lArray, long l2) {
        return (long[])ArrayUtils.removeAll((Object)lArray, ArrayUtils.indexesOf(lArray, l2));
    }

    @Deprecated
    public static short[] removeAllOccurences(short[] sArray, short s2) {
        return (short[])ArrayUtils.removeAll((Object)sArray, ArrayUtils.indexesOf(sArray, s2));
    }

    @Deprecated
    public static <T> T[] removeAllOccurences(T[] TArray, T t2) {
        return (Object[])ArrayUtils.removeAll(TArray, ArrayUtils.indexesOf(TArray, t2));
    }

    public static boolean[] removeAllOccurrences(boolean[] blArray, boolean bl2) {
        return (boolean[])ArrayUtils.removeAll((Object)blArray, ArrayUtils.indexesOf(blArray, bl2));
    }

    public static byte[] removeAllOccurrences(byte[] byArray, byte by2) {
        return (byte[])ArrayUtils.removeAll((Object)byArray, ArrayUtils.indexesOf(byArray, by2));
    }

    public static char[] removeAllOccurrences(char[] cArray, char c2) {
        return (char[])ArrayUtils.removeAll((Object)cArray, ArrayUtils.indexesOf(cArray, c2));
    }

    public static double[] removeAllOccurrences(double[] dArray, double d2) {
        return (double[])ArrayUtils.removeAll((Object)dArray, ArrayUtils.indexesOf(dArray, d2));
    }

    public static float[] removeAllOccurrences(float[] fArray, float f2) {
        return (float[])ArrayUtils.removeAll((Object)fArray, ArrayUtils.indexesOf(fArray, f2));
    }

    public static int[] removeAllOccurrences(int[] nArray, int n2) {
        return (int[])ArrayUtils.removeAll((Object)nArray, ArrayUtils.indexesOf(nArray, n2));
    }

    public static long[] removeAllOccurrences(long[] lArray, long l2) {
        return (long[])ArrayUtils.removeAll((Object)lArray, ArrayUtils.indexesOf(lArray, l2));
    }

    public static short[] removeAllOccurrences(short[] sArray, short s2) {
        return (short[])ArrayUtils.removeAll((Object)sArray, ArrayUtils.indexesOf(sArray, s2));
    }

    public static <T> T[] removeAllOccurrences(T[] TArray, T t2) {
        return (Object[])ArrayUtils.removeAll(TArray, ArrayUtils.indexesOf(TArray, t2));
    }

    public static boolean[] removeElement(boolean[] blArray, boolean bl2) {
        int n2 = ArrayUtils.indexOf(blArray, bl2);
        if (n2 == -1) {
            return ArrayUtils.clone(blArray);
        }
        return ArrayUtils.remove(blArray, n2);
    }

    public static byte[] removeElement(byte[] byArray, byte by2) {
        int n2 = ArrayUtils.indexOf(byArray, by2);
        if (n2 == -1) {
            return ArrayUtils.clone(byArray);
        }
        return ArrayUtils.remove(byArray, n2);
    }

    public static char[] removeElement(char[] cArray, char c2) {
        int n2 = ArrayUtils.indexOf(cArray, c2);
        if (n2 == -1) {
            return ArrayUtils.clone(cArray);
        }
        return ArrayUtils.remove(cArray, n2);
    }

    public static double[] removeElement(double[] dArray, double d2) {
        int n2 = ArrayUtils.indexOf(dArray, d2);
        if (n2 == -1) {
            return ArrayUtils.clone(dArray);
        }
        return ArrayUtils.remove(dArray, n2);
    }

    public static float[] removeElement(float[] fArray, float f2) {
        int n2 = ArrayUtils.indexOf(fArray, f2);
        if (n2 == -1) {
            return ArrayUtils.clone(fArray);
        }
        return ArrayUtils.remove(fArray, n2);
    }

    public static int[] removeElement(int[] nArray, int n2) {
        int n3 = ArrayUtils.indexOf(nArray, n2);
        if (n3 == -1) {
            return ArrayUtils.clone(nArray);
        }
        return ArrayUtils.remove(nArray, n3);
    }

    public static long[] removeElement(long[] lArray, long l2) {
        int n2 = ArrayUtils.indexOf(lArray, l2);
        if (n2 == -1) {
            return ArrayUtils.clone(lArray);
        }
        return ArrayUtils.remove(lArray, n2);
    }

    public static short[] removeElement(short[] sArray, short s2) {
        int n2 = ArrayUtils.indexOf(sArray, s2);
        if (n2 == -1) {
            return ArrayUtils.clone(sArray);
        }
        return ArrayUtils.remove(sArray, n2);
    }

    public static <T> T[] removeElement(T[] TArray, Object object) {
        int n2 = ArrayUtils.indexOf(TArray, object);
        if (n2 == -1) {
            return ArrayUtils.clone(TArray);
        }
        return ArrayUtils.remove(TArray, n2);
    }

    public static boolean[] removeElements(boolean[] blArray, boolean ... blArray2) {
        if (ArrayUtils.isEmpty(blArray) || ArrayUtils.isEmpty(blArray2)) {
            return ArrayUtils.clone(blArray);
        }
        HashMap<Boolean, MutableInt> hashMap = new HashMap<Boolean, MutableInt>(2);
        for (boolean bl2 : blArray2) {
            Boolean bl3 = bl2;
            MutableInt mutableInt = (MutableInt)hashMap.get(bl3);
            if (mutableInt == null) {
                hashMap.put(bl3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            int n2 = blArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(n2 != 0);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(n2 != 0);
            }
            ((BitSet)object).set(i2);
        }
        return (boolean[])ArrayUtils.removeAll((Object)blArray, (BitSet)object);
    }

    public static byte[] removeElements(byte[] byArray, byte ... byArray2) {
        if (ArrayUtils.isEmpty(byArray) || ArrayUtils.isEmpty(byArray2)) {
            return ArrayUtils.clone(byArray);
        }
        HashMap<Byte, MutableInt> hashMap = new HashMap<Byte, MutableInt>(byArray2.length);
        for (byte by2 : byArray2) {
            Byte by3 = by2;
            MutableInt mutableInt = (MutableInt)hashMap.get(by3);
            if (mutableInt == null) {
                hashMap.put(by3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            int n2 = byArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get((byte)n2);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove((byte)n2);
            }
            ((BitSet)object).set(i2);
        }
        return (byte[])ArrayUtils.removeAll((Object)byArray, (BitSet)object);
    }

    public static char[] removeElements(char[] cArray, char ... cArray2) {
        if (ArrayUtils.isEmpty(cArray) || ArrayUtils.isEmpty(cArray2)) {
            return ArrayUtils.clone(cArray);
        }
        HashMap<Character, MutableInt> hashMap = new HashMap<Character, MutableInt>(cArray2.length);
        for (char c2 : cArray2) {
            Character c3 = Character.valueOf(c2);
            MutableInt mutableInt = (MutableInt)hashMap.get(c3);
            if (mutableInt == null) {
                hashMap.put(c3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            int n2 = cArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(Character.valueOf((char)n2));
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(Character.valueOf((char)n2));
            }
            ((BitSet)object).set(i2);
        }
        return (char[])ArrayUtils.removeAll((Object)cArray, (BitSet)object);
    }

    public static double[] removeElements(double[] dArray, double ... dArray2) {
        if (ArrayUtils.isEmpty(dArray) || ArrayUtils.isEmpty(dArray2)) {
            return ArrayUtils.clone(dArray);
        }
        HashMap<Double, MutableInt> hashMap = new HashMap<Double, MutableInt>(dArray2.length);
        for (double d2 : dArray2) {
            Double d3 = d2;
            MutableInt mutableInt = (MutableInt)hashMap.get(d3);
            if (mutableInt == null) {
                hashMap.put(d3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d4 = dArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(d4);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(d4);
            }
            ((BitSet)object).set(i2);
        }
        return (double[])ArrayUtils.removeAll((Object)dArray, (BitSet)object);
    }

    public static float[] removeElements(float[] fArray, float ... fArray2) {
        if (ArrayUtils.isEmpty(fArray) || ArrayUtils.isEmpty(fArray2)) {
            return ArrayUtils.clone(fArray);
        }
        HashMap<Float, MutableInt> hashMap = new HashMap<Float, MutableInt>(fArray2.length);
        for (float f2 : fArray2) {
            Float f3 = Float.valueOf(f2);
            MutableInt mutableInt = (MutableInt)hashMap.get(f3);
            if (mutableInt == null) {
                hashMap.put(f3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            float f4 = fArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(Float.valueOf(f4));
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(Float.valueOf(f4));
            }
            ((BitSet)object).set(i2);
        }
        return (float[])ArrayUtils.removeAll((Object)fArray, (BitSet)object);
    }

    public static int[] removeElements(int[] nArray, int ... nArray2) {
        if (ArrayUtils.isEmpty(nArray) || ArrayUtils.isEmpty(nArray2)) {
            return ArrayUtils.clone(nArray);
        }
        HashMap<Integer, MutableInt> hashMap = new HashMap<Integer, MutableInt>(nArray2.length);
        for (int n2 : nArray2) {
            Integer n3 = n2;
            MutableInt mutableInt = (MutableInt)hashMap.get(n3);
            if (mutableInt == null) {
                hashMap.put(n3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n4 = nArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(n4);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(n4);
            }
            ((BitSet)object).set(i2);
        }
        return (int[])ArrayUtils.removeAll((Object)nArray, (BitSet)object);
    }

    public static long[] removeElements(long[] lArray, long ... lArray2) {
        if (ArrayUtils.isEmpty(lArray) || ArrayUtils.isEmpty(lArray2)) {
            return ArrayUtils.clone(lArray);
        }
        HashMap<Long, MutableInt> hashMap = new HashMap<Long, MutableInt>(lArray2.length);
        for (long l2 : lArray2) {
            Long l3 = l2;
            MutableInt mutableInt = (MutableInt)hashMap.get(l3);
            if (mutableInt == null) {
                hashMap.put(l3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            long l4 = lArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get(l4);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove(l4);
            }
            ((BitSet)object).set(i2);
        }
        return (long[])ArrayUtils.removeAll((Object)lArray, (BitSet)object);
    }

    public static short[] removeElements(short[] sArray, short ... sArray2) {
        if (ArrayUtils.isEmpty(sArray) || ArrayUtils.isEmpty(sArray2)) {
            return ArrayUtils.clone(sArray);
        }
        HashMap<Short, MutableInt> hashMap = new HashMap<Short, MutableInt>(sArray2.length);
        for (short s2 : sArray2) {
            Short s3 = s2;
            MutableInt mutableInt = (MutableInt)hashMap.get(s3);
            if (mutableInt == null) {
                hashMap.put(s3, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        Object object = new BitSet();
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            int n2 = sArray[i2];
            MutableInt mutableInt = (MutableInt)hashMap.get((short)n2);
            if (mutableInt == null) continue;
            if (mutableInt.decrementAndGet() == 0) {
                hashMap.remove((short)n2);
            }
            ((BitSet)object).set(i2);
        }
        return (short[])ArrayUtils.removeAll((Object)sArray, (BitSet)object);
    }

    @SafeVarargs
    public static <T> T[] removeElements(T[] TArray, T ... TArray2) {
        if (ArrayUtils.isEmpty(TArray) || ArrayUtils.isEmpty(TArray2)) {
            return ArrayUtils.clone(TArray);
        }
        HashMap<T, MutableInt> hashMap = new HashMap<T, MutableInt>(TArray2.length);
        for (Object object : TArray2) {
            MutableInt mutableInt = (MutableInt)hashMap.get(object);
            if (mutableInt == null) {
                hashMap.put(object, new MutableInt(1));
                continue;
            }
            mutableInt.increment();
        }
        BitSet bitSet = new BitSet();
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            Object object;
            T t2 = TArray[i2];
            object = (MutableInt)hashMap.get(t2);
            if (object == null) continue;
            if (((MutableInt)object).decrementAndGet() == 0) {
                hashMap.remove(t2);
            }
            bitSet.set(i2);
        }
        Object[] objectArray = (Object[])ArrayUtils.removeAll(TArray, bitSet);
        return objectArray;
    }

    public static void reverse(boolean[] blArray) {
        if (blArray == null) {
            return;
        }
        ArrayUtils.reverse(blArray, 0, blArray.length);
    }

    public static void reverse(boolean[] blArray, int n2, int n3) {
        if (blArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(blArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            boolean bl2 = blArray[i2];
            blArray[i2] = blArray[n4];
            blArray[n4] = bl2;
        }
    }

    public static void reverse(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        ArrayUtils.reverse(byArray, 0, byArray.length);
    }

    public static void reverse(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(byArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            byte by2 = byArray[i2];
            byArray[i2] = byArray[n4];
            byArray[n4] = by2;
        }
    }

    public static void reverse(char[] cArray) {
        if (cArray == null) {
            return;
        }
        ArrayUtils.reverse(cArray, 0, cArray.length);
    }

    public static void reverse(char[] cArray, int n2, int n3) {
        if (cArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(cArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            char c2 = cArray[i2];
            cArray[i2] = cArray[n4];
            cArray[n4] = c2;
        }
    }

    public static void reverse(double[] dArray) {
        if (dArray == null) {
            return;
        }
        ArrayUtils.reverse(dArray, 0, dArray.length);
    }

    public static void reverse(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(dArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            double d2 = dArray[i2];
            dArray[i2] = dArray[n4];
            dArray[n4] = d2;
        }
    }

    public static void reverse(float[] fArray) {
        if (fArray == null) {
            return;
        }
        ArrayUtils.reverse(fArray, 0, fArray.length);
    }

    public static void reverse(float[] fArray, int n2, int n3) {
        if (fArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(fArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            float f2 = fArray[i2];
            fArray[i2] = fArray[n4];
            fArray[n4] = f2;
        }
    }

    public static void reverse(int[] nArray) {
        if (nArray == null) {
            return;
        }
        ArrayUtils.reverse(nArray, 0, nArray.length);
    }

    public static void reverse(int[] nArray, int n2, int n3) {
        if (nArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(nArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            int n5 = nArray[i2];
            nArray[i2] = nArray[n4];
            nArray[n4] = n5;
        }
    }

    public static void reverse(long[] lArray) {
        if (lArray == null) {
            return;
        }
        ArrayUtils.reverse(lArray, 0, lArray.length);
    }

    public static void reverse(long[] lArray, int n2, int n3) {
        if (lArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(lArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            long l2 = lArray[i2];
            lArray[i2] = lArray[n4];
            lArray[n4] = l2;
        }
    }

    public static void reverse(Object[] objectArray) {
        if (objectArray == null) {
            return;
        }
        ArrayUtils.reverse(objectArray, 0, objectArray.length);
    }

    public static void reverse(Object[] objectArray, int n2, int n3) {
        if (objectArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(objectArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            Object object = objectArray[i2];
            objectArray[i2] = objectArray[n4];
            objectArray[n4] = object;
        }
    }

    public static void reverse(short[] sArray) {
        if (sArray == null) {
            return;
        }
        ArrayUtils.reverse(sArray, 0, sArray.length);
    }

    public static void reverse(short[] sArray, int n2, int n3) {
        if (sArray == null) {
            return;
        }
        int n4 = Math.max(n2, 0);
        for (int i2 = Math.min(sArray.length, n3) - 1; i2 > n4; --i2, ++n4) {
            short s2 = sArray[i2];
            sArray[i2] = sArray[n4];
            sArray[n4] = s2;
        }
    }

    public static void shift(boolean[] blArray, int n2) {
        if (blArray == null) {
            return;
        }
        ArrayUtils.shift(blArray, 0, blArray.length, n2);
    }

    public static void shift(boolean[] blArray, int n2, int n3, int n4) {
        int n5;
        if (blArray == null) {
            return;
        }
        if (n2 >= blArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= blArray.length) {
            n3 = blArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(blArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(blArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(blArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(byte[] byArray, int n2) {
        if (byArray == null) {
            return;
        }
        ArrayUtils.shift(byArray, 0, byArray.length, n2);
    }

    public static void shift(byte[] byArray, int n2, int n3, int n4) {
        int n5;
        if (byArray == null) {
            return;
        }
        if (n2 >= byArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= byArray.length) {
            n3 = byArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(byArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(byArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(byArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(char[] cArray, int n2) {
        if (cArray == null) {
            return;
        }
        ArrayUtils.shift(cArray, 0, cArray.length, n2);
    }

    public static void shift(char[] cArray, int n2, int n3, int n4) {
        int n5;
        if (cArray == null) {
            return;
        }
        if (n2 >= cArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= cArray.length) {
            n3 = cArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(cArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(cArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(cArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(double[] dArray, int n2) {
        if (dArray == null) {
            return;
        }
        ArrayUtils.shift(dArray, 0, dArray.length, n2);
    }

    public static void shift(double[] dArray, int n2, int n3, int n4) {
        int n5;
        if (dArray == null) {
            return;
        }
        if (n2 >= dArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= dArray.length) {
            n3 = dArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(dArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(dArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(dArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(float[] fArray, int n2) {
        if (fArray == null) {
            return;
        }
        ArrayUtils.shift(fArray, 0, fArray.length, n2);
    }

    public static void shift(float[] fArray, int n2, int n3, int n4) {
        int n5;
        if (fArray == null) {
            return;
        }
        if (n2 >= fArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= fArray.length) {
            n3 = fArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(fArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(fArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(fArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(int[] nArray, int n2) {
        if (nArray == null) {
            return;
        }
        ArrayUtils.shift(nArray, 0, nArray.length, n2);
    }

    public static void shift(int[] nArray, int n2, int n3, int n4) {
        int n5;
        if (nArray == null) {
            return;
        }
        if (n2 >= nArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= nArray.length) {
            n3 = nArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(nArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(nArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(nArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(long[] lArray, int n2) {
        if (lArray == null) {
            return;
        }
        ArrayUtils.shift(lArray, 0, lArray.length, n2);
    }

    public static void shift(long[] lArray, int n2, int n3, int n4) {
        int n5;
        if (lArray == null) {
            return;
        }
        if (n2 >= lArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= lArray.length) {
            n3 = lArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(lArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(lArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(lArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(Object[] objectArray, int n2) {
        if (objectArray == null) {
            return;
        }
        ArrayUtils.shift(objectArray, 0, objectArray.length, n2);
    }

    public static void shift(Object[] objectArray, int n2, int n3, int n4) {
        int n5;
        if (objectArray == null) {
            return;
        }
        if (n2 >= objectArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= objectArray.length) {
            n3 = objectArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(objectArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(objectArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(objectArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shift(short[] sArray, int n2) {
        if (sArray == null) {
            return;
        }
        ArrayUtils.shift(sArray, 0, sArray.length, n2);
    }

    public static void shift(short[] sArray, int n2, int n3, int n4) {
        int n5;
        if (sArray == null) {
            return;
        }
        if (n2 >= sArray.length - 1 || n3 <= 0) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 >= sArray.length) {
            n3 = sArray.length;
        }
        if ((n5 = n3 - n2) <= 1) {
            return;
        }
        if ((n4 %= n5) < 0) {
            n4 += n5;
        }
        while (n5 > 1 && n4 > 0) {
            int n6 = n5 - n4;
            if (n4 > n6) {
                ArrayUtils.swap(sArray, n2, n2 + n5 - n6, n6);
                n5 = n4;
                n4 -= n6;
                continue;
            }
            if (n4 < n6) {
                ArrayUtils.swap(sArray, n2, n2 + n6, n4);
                n2 += n4;
                n5 = n6;
                continue;
            }
            ArrayUtils.swap(sArray, n2, n2 + n6, n4);
            break;
        }
    }

    public static void shuffle(boolean[] blArray) {
        ArrayUtils.shuffle(blArray, new Random());
    }

    public static void shuffle(boolean[] blArray, Random random) {
        for (int i2 = blArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(blArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(byte[] byArray) {
        ArrayUtils.shuffle(byArray, new Random());
    }

    public static void shuffle(byte[] byArray, Random random) {
        for (int i2 = byArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(byArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(char[] cArray) {
        ArrayUtils.shuffle(cArray, new Random());
    }

    public static void shuffle(char[] cArray, Random random) {
        for (int i2 = cArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(cArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(double[] dArray) {
        ArrayUtils.shuffle(dArray, new Random());
    }

    public static void shuffle(double[] dArray, Random random) {
        for (int i2 = dArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(dArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(float[] fArray) {
        ArrayUtils.shuffle(fArray, new Random());
    }

    public static void shuffle(float[] fArray, Random random) {
        for (int i2 = fArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(fArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(int[] nArray) {
        ArrayUtils.shuffle(nArray, new Random());
    }

    public static void shuffle(int[] nArray, Random random) {
        for (int i2 = nArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(nArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(long[] lArray) {
        ArrayUtils.shuffle(lArray, new Random());
    }

    public static void shuffle(long[] lArray, Random random) {
        for (int i2 = lArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(lArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(Object[] objectArray) {
        ArrayUtils.shuffle(objectArray, new Random());
    }

    public static void shuffle(Object[] objectArray, Random random) {
        for (int i2 = objectArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(objectArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static void shuffle(short[] sArray) {
        ArrayUtils.shuffle(sArray, new Random());
    }

    public static void shuffle(short[] sArray, Random random) {
        for (int i2 = sArray.length; i2 > 1; --i2) {
            ArrayUtils.swap(sArray, i2 - 1, random.nextInt(i2), 1);
        }
    }

    public static boolean[] subarray(boolean[] blArray, int n2, int n3) {
        int n4;
        if (blArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > blArray.length) {
            n3 = blArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] blArray2 = new boolean[n4];
        System.arraycopy(blArray, n2, blArray2, 0, n4);
        return blArray2;
    }

    public static byte[] subarray(byte[] byArray, int n2, int n3) {
        int n4;
        if (byArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > byArray.length) {
            n3 = byArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] byArray2 = new byte[n4];
        System.arraycopy(byArray, n2, byArray2, 0, n4);
        return byArray2;
    }

    public static char[] subarray(char[] cArray, int n2, int n3) {
        int n4;
        if (cArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > cArray.length) {
            n3 = cArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArray2 = new char[n4];
        System.arraycopy(cArray, n2, cArray2, 0, n4);
        return cArray2;
    }

    public static double[] subarray(double[] dArray, int n2, int n3) {
        int n4;
        if (dArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > dArray.length) {
            n3 = dArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArray2 = new double[n4];
        System.arraycopy(dArray, n2, dArray2, 0, n4);
        return dArray2;
    }

    public static float[] subarray(float[] fArray, int n2, int n3) {
        int n4;
        if (fArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > fArray.length) {
            n3 = fArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArray2 = new float[n4];
        System.arraycopy(fArray, n2, fArray2, 0, n4);
        return fArray2;
    }

    public static int[] subarray(int[] nArray, int n2, int n3) {
        int n4;
        if (nArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > nArray.length) {
            n3 = nArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] nArray2 = new int[n4];
        System.arraycopy(nArray, n2, nArray2, 0, n4);
        return nArray2;
    }

    public static long[] subarray(long[] lArray, int n2, int n3) {
        int n4;
        if (lArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > lArray.length) {
            n3 = lArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] lArray2 = new long[n4];
        System.arraycopy(lArray, n2, lArray2, 0, n4);
        return lArray2;
    }

    public static short[] subarray(short[] sArray, int n2, int n3) {
        int n4;
        if (sArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > sArray.length) {
            n3 = sArray.length;
        }
        if ((n4 = n3 - n2) <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArray2 = new short[n4];
        System.arraycopy(sArray, n2, sArray2, 0, n4);
        return sArray2;
    }

    public static <T> T[] subarray(T[] TArray, int n2, int n3) {
        if (TArray == null) {
            return null;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 > TArray.length) {
            n3 = TArray.length;
        }
        int n4 = n3 - n2;
        Class<?> clazz = TArray.getClass().getComponentType();
        if (n4 <= 0) {
            Object[] objectArray = (Object[])Array.newInstance(clazz, 0);
            return objectArray;
        }
        Object[] objectArray = (Object[])Array.newInstance(clazz, n4);
        System.arraycopy(TArray, n2, objectArray, 0, n4);
        return objectArray;
    }

    public static void swap(boolean[] blArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(blArray)) {
            return;
        }
        ArrayUtils.swap(blArray, n2, n3, 1);
    }

    public static void swap(boolean[] blArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(blArray) || n2 >= blArray.length || n3 >= blArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, blArray.length - n2), blArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            boolean bl2 = blArray[n2];
            blArray[n2] = blArray[n3];
            blArray[n3] = bl2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(byte[] byArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(byArray)) {
            return;
        }
        ArrayUtils.swap(byArray, n2, n3, 1);
    }

    public static void swap(byte[] byArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(byArray) || n2 >= byArray.length || n3 >= byArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, byArray.length - n2), byArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            byte by2 = byArray[n2];
            byArray[n2] = byArray[n3];
            byArray[n3] = by2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(char[] cArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(cArray)) {
            return;
        }
        ArrayUtils.swap(cArray, n2, n3, 1);
    }

    public static void swap(char[] cArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(cArray) || n2 >= cArray.length || n3 >= cArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, cArray.length - n2), cArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            char c2 = cArray[n2];
            cArray[n2] = cArray[n3];
            cArray[n3] = c2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(double[] dArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(dArray)) {
            return;
        }
        ArrayUtils.swap(dArray, n2, n3, 1);
    }

    public static void swap(double[] dArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(dArray) || n2 >= dArray.length || n3 >= dArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, dArray.length - n2), dArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            double d2 = dArray[n2];
            dArray[n2] = dArray[n3];
            dArray[n3] = d2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(float[] fArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(fArray)) {
            return;
        }
        ArrayUtils.swap(fArray, n2, n3, 1);
    }

    public static void swap(float[] fArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(fArray) || n2 >= fArray.length || n3 >= fArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, fArray.length - n2), fArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            float f2 = fArray[n2];
            fArray[n2] = fArray[n3];
            fArray[n3] = f2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(int[] nArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(nArray)) {
            return;
        }
        ArrayUtils.swap(nArray, n2, n3, 1);
    }

    public static void swap(int[] nArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(nArray) || n2 >= nArray.length || n3 >= nArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, nArray.length - n2), nArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            int n6 = nArray[n2];
            nArray[n2] = nArray[n3];
            nArray[n3] = n6;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(long[] lArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(lArray)) {
            return;
        }
        ArrayUtils.swap(lArray, n2, n3, 1);
    }

    public static void swap(long[] lArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(lArray) || n2 >= lArray.length || n3 >= lArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, lArray.length - n2), lArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            long l2 = lArray[n2];
            lArray[n2] = lArray[n3];
            lArray[n3] = l2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(Object[] objectArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(objectArray)) {
            return;
        }
        ArrayUtils.swap(objectArray, n2, n3, 1);
    }

    public static void swap(Object[] objectArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(objectArray) || n2 >= objectArray.length || n3 >= objectArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        n4 = Math.min(Math.min(n4, objectArray.length - n2), objectArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            Object object = objectArray[n2];
            objectArray[n2] = objectArray[n3];
            objectArray[n3] = object;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static void swap(short[] sArray, int n2, int n3) {
        if (ArrayUtils.isEmpty(sArray)) {
            return;
        }
        ArrayUtils.swap(sArray, n2, n3, 1);
    }

    public static void swap(short[] sArray, int n2, int n3, int n4) {
        if (ArrayUtils.isEmpty(sArray) || n2 >= sArray.length || n3 >= sArray.length) {
            return;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n2 == n3) {
            return;
        }
        n4 = Math.min(Math.min(n4, sArray.length - n2), sArray.length - n3);
        int n5 = 0;
        while (n5 < n4) {
            short s2 = sArray[n2];
            sArray[n2] = sArray[n3];
            sArray[n3] = s2;
            ++n5;
            ++n2;
            ++n3;
        }
    }

    public static <T> T[] toArray(T ... TArray) {
        return TArray;
    }

    public static Map<Object, Object> toMap(Object[] objectArray) {
        if (objectArray == null) {
            return null;
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>((int)((double)objectArray.length * 1.5));
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object[] objectArray2;
            Object object = objectArray[i2];
            if (object instanceof Map.Entry) {
                objectArray2 = (Object[])object;
                hashMap.put(objectArray2.getKey(), objectArray2.getValue());
                continue;
            }
            if (object instanceof Object[]) {
                objectArray2 = (Object[])object;
                if (objectArray2.length < 2) {
                    throw new IllegalArgumentException("Array element " + i2 + ", '" + object + "', has a length less than 2");
                }
                hashMap.put(objectArray2[0], objectArray2[1]);
                continue;
            }
            throw new IllegalArgumentException("Array element " + i2 + ", '" + object + "', is neither of type Map.Entry nor an Array");
        }
        return hashMap;
    }

    public static Boolean[] toObject(boolean[] blArray) {
        if (blArray == null) {
            return null;
        }
        if (blArray.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] booleanArray = new Boolean[blArray.length];
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            booleanArray[i2] = blArray[i2] ? Boolean.TRUE : Boolean.FALSE;
        }
        return booleanArray;
    }

    public static Byte[] toObject(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (byArray.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] byteArray = new Byte[byArray.length];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byteArray[i2] = byArray[i2];
        }
        return byteArray;
    }

    public static Character[] toObject(char[] cArray) {
        if (cArray == null) {
            return null;
        }
        if (cArray.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] characterArray = new Character[cArray.length];
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            characterArray[i2] = Character.valueOf(cArray[i2]);
        }
        return characterArray;
    }

    public static Double[] toObject(double[] dArray) {
        if (dArray == null) {
            return null;
        }
        if (dArray.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] doubleArray = new Double[dArray.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            doubleArray[i2] = dArray[i2];
        }
        return doubleArray;
    }

    public static Float[] toObject(float[] fArray) {
        if (fArray == null) {
            return null;
        }
        if (fArray.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] floatArray = new Float[fArray.length];
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            floatArray[i2] = Float.valueOf(fArray[i2]);
        }
        return floatArray;
    }

    public static Integer[] toObject(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        if (nArray.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] integerArray = new Integer[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            integerArray[i2] = nArray[i2];
        }
        return integerArray;
    }

    public static Long[] toObject(long[] lArray) {
        if (lArray == null) {
            return null;
        }
        if (lArray.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] longArray = new Long[lArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            longArray[i2] = lArray[i2];
        }
        return longArray;
    }

    public static Short[] toObject(short[] sArray) {
        if (sArray == null) {
            return null;
        }
        if (sArray.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shortArray = new Short[sArray.length];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            shortArray[i2] = sArray[i2];
        }
        return shortArray;
    }

    public static boolean[] toPrimitive(Boolean[] booleanArray) {
        if (booleanArray == null) {
            return null;
        }
        if (booleanArray.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] blArray = new boolean[booleanArray.length];
        for (int i2 = 0; i2 < booleanArray.length; ++i2) {
            blArray[i2] = booleanArray[i2];
        }
        return blArray;
    }

    public static boolean[] toPrimitive(Boolean[] booleanArray, boolean bl2) {
        if (booleanArray == null) {
            return null;
        }
        if (booleanArray.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] blArray = new boolean[booleanArray.length];
        for (int i2 = 0; i2 < booleanArray.length; ++i2) {
            Boolean bl3 = booleanArray[i2];
            blArray[i2] = bl3 == null ? bl2 : bl3;
        }
        return blArray;
    }

    public static byte[] toPrimitive(Byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        if (byteArray.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] byArray = new byte[byteArray.length];
        for (int i2 = 0; i2 < byteArray.length; ++i2) {
            byArray[i2] = byteArray[i2];
        }
        return byArray;
    }

    public static byte[] toPrimitive(Byte[] byteArray, byte by2) {
        if (byteArray == null) {
            return null;
        }
        if (byteArray.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] byArray = new byte[byteArray.length];
        for (int i2 = 0; i2 < byteArray.length; ++i2) {
            Byte by3 = byteArray[i2];
            byArray[i2] = by3 == null ? by2 : by3;
        }
        return byArray;
    }

    public static char[] toPrimitive(Character[] characterArray) {
        if (characterArray == null) {
            return null;
        }
        if (characterArray.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArray = new char[characterArray.length];
        for (int i2 = 0; i2 < characterArray.length; ++i2) {
            cArray[i2] = characterArray[i2].charValue();
        }
        return cArray;
    }

    public static char[] toPrimitive(Character[] characterArray, char c2) {
        if (characterArray == null) {
            return null;
        }
        if (characterArray.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArray = new char[characterArray.length];
        for (int i2 = 0; i2 < characterArray.length; ++i2) {
            Character c3 = characterArray[i2];
            cArray[i2] = c3 == null ? c2 : c3.charValue();
        }
        return cArray;
    }

    public static double[] toPrimitive(Double[] doubleArray) {
        if (doubleArray == null) {
            return null;
        }
        if (doubleArray.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArray = new double[doubleArray.length];
        for (int i2 = 0; i2 < doubleArray.length; ++i2) {
            dArray[i2] = doubleArray[i2];
        }
        return dArray;
    }

    public static double[] toPrimitive(Double[] doubleArray, double d2) {
        if (doubleArray == null) {
            return null;
        }
        if (doubleArray.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArray = new double[doubleArray.length];
        for (int i2 = 0; i2 < doubleArray.length; ++i2) {
            Double d3 = doubleArray[i2];
            dArray[i2] = d3 == null ? d2 : d3;
        }
        return dArray;
    }

    public static float[] toPrimitive(Float[] floatArray) {
        if (floatArray == null) {
            return null;
        }
        if (floatArray.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArray = new float[floatArray.length];
        for (int i2 = 0; i2 < floatArray.length; ++i2) {
            fArray[i2] = floatArray[i2].floatValue();
        }
        return fArray;
    }

    public static float[] toPrimitive(Float[] floatArray, float f2) {
        if (floatArray == null) {
            return null;
        }
        if (floatArray.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArray = new float[floatArray.length];
        for (int i2 = 0; i2 < floatArray.length; ++i2) {
            Float f3 = floatArray[i2];
            fArray[i2] = f3 == null ? f2 : f3.floatValue();
        }
        return fArray;
    }

    public static int[] toPrimitive(Integer[] integerArray) {
        if (integerArray == null) {
            return null;
        }
        if (integerArray.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] nArray = new int[integerArray.length];
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            nArray[i2] = integerArray[i2];
        }
        return nArray;
    }

    public static int[] toPrimitive(Integer[] integerArray, int n2) {
        if (integerArray == null) {
            return null;
        }
        if (integerArray.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] nArray = new int[integerArray.length];
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            Integer n3 = integerArray[i2];
            nArray[i2] = n3 == null ? n2 : n3;
        }
        return nArray;
    }

    public static long[] toPrimitive(Long[] longArray) {
        if (longArray == null) {
            return null;
        }
        if (longArray.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] lArray = new long[longArray.length];
        for (int i2 = 0; i2 < longArray.length; ++i2) {
            lArray[i2] = longArray[i2];
        }
        return lArray;
    }

    public static long[] toPrimitive(Long[] longArray, long l2) {
        if (longArray == null) {
            return null;
        }
        if (longArray.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] lArray = new long[longArray.length];
        for (int i2 = 0; i2 < longArray.length; ++i2) {
            Long l3 = longArray[i2];
            lArray[i2] = l3 == null ? l2 : l3;
        }
        return lArray;
    }

    public static Object toPrimitive(Object object) {
        if (object == null) {
            return null;
        }
        Class<?> clazz = object.getClass().getComponentType();
        Class<?> clazz2 = ClassUtils.wrapperToPrimitive(clazz);
        if (Boolean.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Boolean[])object);
        }
        if (Character.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Character[])object);
        }
        if (Byte.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Byte[])object);
        }
        if (Integer.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Integer[])object);
        }
        if (Long.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Long[])object);
        }
        if (Short.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Short[])object);
        }
        if (Double.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Double[])object);
        }
        if (Float.TYPE.equals(clazz2)) {
            return ArrayUtils.toPrimitive((Float[])object);
        }
        return object;
    }

    public static short[] toPrimitive(Short[] shortArray) {
        if (shortArray == null) {
            return null;
        }
        if (shortArray.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArray = new short[shortArray.length];
        for (int i2 = 0; i2 < shortArray.length; ++i2) {
            sArray[i2] = shortArray[i2];
        }
        return sArray;
    }

    public static short[] toPrimitive(Short[] shortArray, short s2) {
        if (shortArray == null) {
            return null;
        }
        if (shortArray.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArray = new short[shortArray.length];
        for (int i2 = 0; i2 < shortArray.length; ++i2) {
            Short s3 = shortArray[i2];
            sArray[i2] = s3 == null ? s2 : s3;
        }
        return sArray;
    }

    public static String toString(Object object) {
        return ArrayUtils.toString(object, "{}");
    }

    public static String toString(Object object, String string) {
        if (object == null) {
            return string;
        }
        return new ToStringBuilder(object, ToStringStyle.SIMPLE_STYLE).append(object).toString();
    }

    public static String[] toStringArray(Object[] objectArray) {
        if (objectArray == null) {
            return null;
        }
        if (objectArray.length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = new String[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            stringArray[i2] = objectArray[i2].toString();
        }
        return stringArray;
    }

    public static String[] toStringArray(Object[] objectArray, String string) {
        if (null == objectArray) {
            return null;
        }
        if (objectArray.length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray = new String[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            stringArray[i2] = object == null ? string : object.toString();
        }
        return stringArray;
    }
}

