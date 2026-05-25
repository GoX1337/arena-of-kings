/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.model;

import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MultipleFailureException
extends Exception {
    private static final long serialVersionUID = 1L;
    private final List<Throwable> fErrors;

    public MultipleFailureException(List<Throwable> list) {
        this.fErrors = list;
    }

    public List<Throwable> getFailures() {
        return this.fErrors;
    }
}

