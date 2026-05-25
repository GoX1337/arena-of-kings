/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class InitializationError
extends Exception {
    private static final long serialVersionUID = 1L;
    private final List<Throwable> fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public InitializationError(String string) {
        this(Arrays.asList(new Exception(string)));
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }
}

