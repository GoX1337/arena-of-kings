/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.lang3.Validate;

public final class Range<T>
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    public static <T extends Comparable<T>> Range<T> between(T t2, T t3) {
        return Range.between(t2, t3, null);
    }

    public static <T> Range<T> between(T t2, T t3, Comparator<T> comparator) {
        return new Range<T>(t2, t3, comparator);
    }

    public static <T extends Comparable<T>> Range<T> is(T t2) {
        return Range.between(t2, t2, null);
    }

    public static <T> Range<T> is(T t2, Comparator<T> comparator) {
        return Range.between(t2, t2, comparator);
    }

    private Range(T t2, T t3, Comparator<T> comparator) {
        if (t2 == null || t3 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + t2 + ", element2=" + t3);
        }
        this.comparator = comparator == null ? ComparableComparator.INSTANCE : comparator;
        if (this.comparator.compare(t2, t3) < 1) {
            this.minimum = t2;
            this.maximum = t3;
        } else {
            this.minimum = t3;
            this.maximum = t2;
        }
    }

    public boolean contains(T t2) {
        if (t2 == null) {
            return false;
        }
        return this.comparator.compare(t2, this.minimum) > -1 && this.comparator.compare(t2, this.maximum) < 1;
    }

    public boolean containsRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return this.contains(range.minimum) && this.contains(range.maximum);
    }

    public int elementCompareTo(T t2) {
        Validate.notNull(t2, "element", new Object[0]);
        if (this.isAfter(t2)) {
            return -1;
        }
        if (this.isBefore(t2)) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Range range = (Range)object;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int n2 = this.hashCode;
        if (this.hashCode == 0) {
            n2 = 17;
            n2 = 37 * n2 + this.getClass().hashCode();
            n2 = 37 * n2 + this.minimum.hashCode();
            this.hashCode = n2 = 37 * n2 + this.maximum.hashCode();
        }
        return n2;
    }

    public Range<T> intersectionWith(Range<T> range) {
        if (!this.isOverlappedBy(range)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
        }
        if (this.equals(range)) {
            return this;
        }
        T t2 = this.getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum;
        T t3 = this.getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum;
        return Range.between(t2, t3, this.getComparator());
    }

    public boolean isAfter(T t2) {
        if (t2 == null) {
            return false;
        }
        return this.comparator.compare(t2, this.minimum) < 0;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return this.isAfter(range.maximum);
    }

    public boolean isBefore(T t2) {
        if (t2 == null) {
            return false;
        }
        return this.comparator.compare(t2, this.maximum) > 0;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return this.isBefore(range.minimum);
    }

    public boolean isEndedBy(T t2) {
        if (t2 == null) {
            return false;
        }
        return this.comparator.compare(t2, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || this.contains(range.minimum);
    }

    public boolean isStartedBy(T t2) {
        if (t2 == null) {
            return false;
        }
        return this.comparator.compare(t2, this.minimum) == 0;
    }

    public T fit(T t2) {
        Validate.notNull(t2, "element", new Object[0]);
        if (this.isAfter(t2)) {
            return this.minimum;
        }
        if (this.isBefore(t2)) {
            return this.maximum;
        }
        return t2;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = "[" + this.minimum + ".." + this.maximum + "]";
        }
        return this.toString;
    }

    public String toString(String string) {
        return String.format(string, this.minimum, this.maximum, this.comparator);
    }

    static enum ComparableComparator implements Comparator
    {
        INSTANCE;


        public int compare(Object object, Object object2) {
            return ((Comparable)object).compareTo(object2);
        }
    }
}

