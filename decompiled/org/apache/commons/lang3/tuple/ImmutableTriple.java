/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.Triple;

public final class ImmutableTriple<L, M, R>
extends Triple<L, M, R> {
    public static final ImmutableTriple<?, ?, ?>[] EMPTY_ARRAY = new ImmutableTriple[0];
    private static final ImmutableTriple NULL = ImmutableTriple.of(null, null, null);
    private static final long serialVersionUID = 1L;
    public final L left;
    public final M middle;
    public final R right;

    public static <L, M, R> ImmutableTriple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> nullTriple() {
        return NULL;
    }

    public static <L, M, R> ImmutableTriple<L, M, R> of(L l2, M m2, R r2) {
        return new ImmutableTriple<L, M, R>(l2, m2, r2);
    }

    public ImmutableTriple(L l2, M m2, R r2) {
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
}

