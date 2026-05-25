/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.tuple.ImmutableTriple;

public abstract class Triple<L, M, R>
implements Serializable,
Comparable<Triple<L, M, R>> {
    private static final long serialVersionUID = 1L;
    public static final Triple<?, ?, ?>[] EMPTY_ARRAY = new TripleAdapter[0];

    public static <L, M, R> Triple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> Triple<L, M, R> of(L l2, M m2, R r2) {
        return new ImmutableTriple<L, M, R>(l2, m2, r2);
    }

    @Override
    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(this.getLeft(), triple.getLeft()).append(this.getMiddle(), triple.getMiddle()).append(this.getRight(), triple.getRight()).toComparison();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Triple) {
            Triple triple = (Triple)object;
            return Objects.equals(this.getLeft(), triple.getLeft()) && Objects.equals(this.getMiddle(), triple.getMiddle()) && Objects.equals(this.getRight(), triple.getRight());
        }
        return false;
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        return Objects.hashCode(this.getLeft()) ^ Objects.hashCode(this.getMiddle()) ^ Objects.hashCode(this.getRight());
    }

    public String toString() {
        return "(" + this.getLeft() + "," + this.getMiddle() + "," + this.getRight() + ")";
    }

    public String toString(String string) {
        return String.format(string, this.getLeft(), this.getMiddle(), this.getRight());
    }

    static final class TripleAdapter<L, M, R>
    extends Triple<L, M, R> {
        private static final long serialVersionUID = 1L;

        private TripleAdapter() {
        }

        @Override
        public L getLeft() {
            return null;
        }

        @Override
        public M getMiddle() {
            return null;
        }

        @Override
        public R getRight() {
            return null;
        }
    }
}

