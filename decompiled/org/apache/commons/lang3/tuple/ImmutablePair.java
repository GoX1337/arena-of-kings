/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public final class ImmutablePair<L, R>
extends Pair<L, R> {
    public static final ImmutablePair<?, ?>[] EMPTY_ARRAY = new ImmutablePair[0];
    private static final ImmutablePair NULL = ImmutablePair.of(null, null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public static <L, R> ImmutablePair<L, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, R> Pair<L, R> left(L l2) {
        return ImmutablePair.of(l2, null);
    }

    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    public static <L, R> ImmutablePair<L, R> of(L l2, R r2) {
        return new ImmutablePair<L, R>(l2, r2);
    }

    public static <L, R> ImmutablePair<L, R> of(Map.Entry<L, R> entry) {
        R r2;
        L l2;
        if (entry != null) {
            l2 = entry.getKey();
            r2 = entry.getValue();
        } else {
            l2 = null;
            r2 = null;
        }
        return new ImmutablePair<Object, Object>(l2, r2);
    }

    public static <L, R> Pair<L, R> right(R r2) {
        return ImmutablePair.of(null, r2);
    }

    public ImmutablePair(L l2, R r2) {
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

    @Override
    public R setValue(R r2) {
        throw new UnsupportedOperationException();
    }
}

