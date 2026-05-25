/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories;

public abstract class PotentialAssignment {
    public static PotentialAssignment forValue(String string, Object object) {
        return new byc(object, string);
    }

    public abstract Object getValue();

    public abstract String getDescription();

    public static class CouldNotGenerateValueException
    extends Exception {
        private static final long serialVersionUID = 1L;
    }
}

