/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.Triple;

public class MutableTriple<L, M, R>
extends Triple<L, M, R> {
    public static final MutableTriple<?, ?, ?>[] EMPTY_ARRAY = new MutableTriple[0];
    private static final long serialVersionUID = 1L;
    public L left;
    public M middle;
    public R right;

    public static <L, M, R> MutableTriple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> MutableTriple<L, M, R> of(L l2, M m2, R r2) {
        return new MutableTriple<L, M, R>(l2, m2, r2);
    }

    public MutableTriple() {
    }

    public MutableTriple(L l2, M m2, R r2) {
        this.left = l2;
        this.middle = m2;
        this.right = r2;
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public M getMiddle() {
        return this.middle;
    }

    @Override
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l2) {
        this.left = l2;
    }

    public void setMiddle(M m2) {
        this.middle = m2;
    }

    public void setRight(R r2) {
        this.right = r2;
    }
}

