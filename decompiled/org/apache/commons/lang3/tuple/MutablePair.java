/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public class MutablePair<L, R>
extends Pair<L, R> {
    public static final MutablePair<?, ?>[] EMPTY_ARRAY = new MutablePair[0];
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    public static <L, R> MutablePair<L, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, R> MutablePair<L, R> of(L l2, R r2) {
        return new MutablePair<L, R>(l2, r2);
    }

    public static <L, R> MutablePair<L, R> of(Map.Entry<L, R> entry) {
        R r2;
        L l2;
        if (entry != null) {
            l2 = entry.getKey();
            r2 = entry.getValue();
        } else {
            l2 = null;
            r2 = null;
        }
        return new MutablePair<Object, Object>(l2, r2);
    }

    public MutablePair() {
    }

    public MutablePair(L l2, R r2) {
        this.left = l2;
        this.right = r2;
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public R getRight() {
        return this.right;
    }

    public void setLeft(L l2) {
        this.left = l2;
    }

    public void setRight(R r2) {
        this.right = r2;
    }

    @Override
    public R setValue(R r2) {
        R r3 = this.getRight();
        this.setRight(r2);
        return r3;
    }
}

