/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.compare;

import java.io.Serializable;
import java.util.Comparator;

public final class ObjectToStringComparator
implements Serializable,
Comparator<Object> {
    public static final ObjectToStringComparator INSTANCE = new ObjectToStringComparator();
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Object object, Object object2) {
        if (object == null && object2 == null) {
            return 0;
        }
        if (object == null) {
            return 1;
        }
        if (object2 == null) {
            return -1;
        }
        String string = object.toString();
        String string2 = object2.toString();
        if (string == null && string2 == null) {
            return 0;
        }
        if (string == null) {
            return 1;
        }
        if (string2 == null) {
            return -1;
        }
        return string.compareTo(string2);
    }
}

