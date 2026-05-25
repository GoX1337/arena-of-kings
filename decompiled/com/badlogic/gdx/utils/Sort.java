/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ComparableTimSort;
import com.badlogic.gdx.utils.TimSort;
import java.util.Comparator;

public class Sort {
    private static Sort instance;
    private TimSort timSort;
    private ComparableTimSort comparableTimSort;

    public <T extends Comparable> void sort(Array<T> array) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new ComparableTimSort();
        }
        this.comparableTimSort.doSort(array.items, 0, array.size);
    }

    public void sort(Object[] objectArray) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new ComparableTimSort();
        }
        this.comparableTimSort.doSort(objectArray, 0, objectArray.length);
    }

    public void sort(Object[] objectArray, int n2, int n3) {
        if (this.comparableTimSort == null) {
            this.comparableTimSort = new ComparableTimSort();
        }
        this.comparableTimSort.doSort(objectArray, n2, n3);
    }

    public <T> void sort(Array<T> array, Comparator<? super T> comparator) {
        if (this.timSort == null) {
            this.timSort = new TimSort();
        }
        this.timSort.doSort(array.items, comparator, 0, array.size);
    }

    public <T> void sort(T[] TArray, Comparator<? super T> comparator) {
        if (this.timSort == null) {
            this.timSort = new TimSort();
        }
        this.timSort.doSort(TArray, comparator, 0, TArray.length);
    }

    public <T> void sort(T[] TArray, Comparator<? super T> comparator, int n2, int n3) {
        if (this.timSort == null) {
            this.timSort = new TimSort();
        }
        this.timSort.doSort(TArray, comparator, n2, n3);
    }

    public static Sort instance() {
        if (instance == null) {
            instance = new Sort();
        }
        return instance;
    }
}

