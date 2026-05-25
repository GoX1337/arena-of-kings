/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ParameterizedAssertionError
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ParameterizedAssertionError(Throwable throwable, String string, Object ... objectArray) {
        super(String.format("%s(%s)", string, ParameterizedAssertionError.join(", ", objectArray)), throwable);
    }

    public boolean equals(Object object) {
        return this.toString().equals(object.toString());
    }

    public static String join(String string, Object ... objectArray) {
        return ParameterizedAssertionError.join(string, Arrays.asList(objectArray));
    }

    public static String join(String string, Collection<Object> collection) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            stringBuffer.append(ParameterizedAssertionError.stringValueOf(object));
            if (!iterator.hasNext()) continue;
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    private static String stringValueOf(Object object) {
        try {
            return String.valueOf(object);
        }
        catch (Throwable throwable) {
            return "[toString failed]";
        }
    }
}

