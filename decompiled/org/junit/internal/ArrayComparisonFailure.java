/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal;

import java.util.ArrayList;
import java.util.List;

public class ArrayComparisonFailure
extends AssertionError {
    private static final long serialVersionUID = 1L;
    private List<Integer> fIndices = new ArrayList<Integer>();
    private final String fMessage;
    private final AssertionError fCause;

    public ArrayComparisonFailure(String string, AssertionError assertionError, int n2) {
        this.fMessage = string;
        this.fCause = assertionError;
        this.addDimension(n2);
    }

    public void addDimension(int n2) {
        this.fIndices.add(0, n2);
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.fMessage != null) {
            stringBuilder.append(this.fMessage);
        }
        stringBuilder.append("arrays first differed at element ");
        for (int n2 : this.fIndices) {
            stringBuilder.append("[");
            stringBuilder.append(n2);
            stringBuilder.append("]");
        }
        stringBuilder.append("; ");
        stringBuilder.append(((Throwable)((Object)this.fCause)).getMessage());
        return stringBuilder.toString();
    }

    public String toString() {
        return this.getMessage();
    }
}

