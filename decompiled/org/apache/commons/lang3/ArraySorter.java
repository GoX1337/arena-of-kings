/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySorter {
    public static byte[] sort(byte[] byArray) {
        Arrays.sort(byArray);
        return byArray;
    }

    public static char[] sort(char[] cArray) {
        Arrays.sort(cArray);
        return cArray;
    }

    public static double[] sort(double[] dArray) {
        Arrays.sort(dArray);
        return dArray;
    }

    public static float[] sort(float[] fArray) {
        Arrays.sort(fArray);
        return fArray;
    }

    public static int[] sort(int[] nArray) {
        Arrays.sort(nArray);
        return nArray;
    }

    public static long[] sort(long[] lArray) {
        Arrays.sort(lArray);
        return lArray;
    }

    public static short[] sort(short[] sArray) {
        Arrays.sort(sArray);
        return sArray;
    }

    public static <T> T[] sort(T[] TArray) {
        Arrays.sort(TArray);
        return TArray;
    }

    public static <T> T[] sort(T[] TArray, Comparator<? super T> comparator) {
        Arrays.sort(TArray, comparator);
        return TArray;
    }
}

