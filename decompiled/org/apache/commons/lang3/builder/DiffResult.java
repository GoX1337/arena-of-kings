/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DiffResult<T>
implements Iterable<Diff<?>> {
    public static final String OBJECTS_SAME_STRING = "";
    private static final String DIFFERS_STRING = "differs from";
    private final List<Diff<?>> diffList;
    private final T lhs;
    private final T rhs;
    private final ToStringStyle style;

    DiffResult(T t2, T t3, List<Diff<?>> list, ToStringStyle toStringStyle) {
        Validate.notNull(t2, "lhs", new Object[0]);
        Validate.notNull(t3, "rhs", new Object[0]);
        Validate.notNull(list, "diffList", new Object[0]);
        this.diffList = list;
        this.lhs = t2;
        this.rhs = t3;
        this.style = toStringStyle == null ? ToStringStyle.DEFAULT_STYLE : toStringStyle;
    }

    public T getLeft() {
        return this.lhs;
    }

    public T getRight() {
        return this.rhs;
    }

    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffList);
    }

    public int getNumberOfDiffs() {
        return this.diffList.size();
    }

    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    public String toString() {
        return this.toString(this.style);
    }

    public String toString(ToStringStyle toStringStyle) {
        if (this.diffList.isEmpty()) {
            return OBJECTS_SAME_STRING;
        }
        ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        for (Diff<?> diff : this.diffList) {
            toStringBuilder.append(diff.getFieldName(), diff.getLeft());
            toStringBuilder2.append(diff.getFieldName(), diff.getRight());
        }
        return String.format("%s %s %s", toStringBuilder.build(), DIFFERS_STRING, toStringBuilder2.build());
    }

    @Override
    public Iterator<Diff<?>> iterator() {
        return this.diffList.iterator();
    }
}

