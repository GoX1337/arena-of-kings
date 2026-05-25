/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.requests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Request;
import org.junit.runner.Runner;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ClassRequest
extends Request {
    private final Class<?> fTestClass;
    private boolean fCanUseSuiteMethod;

    public ClassRequest(Class<?> clazz, boolean bl2) {
        this.fTestClass = clazz;
        this.fCanUseSuiteMethod = bl2;
    }

    public ClassRequest(Class<?> clazz) {
        this(clazz, true);
    }

    @Override
    public Runner getRunner() {
        return new AllDefaultPossibilitiesBuilder(this.fCanUseSuiteMethod).safeRunnerForClass(this.fTestClass);
    }
}

