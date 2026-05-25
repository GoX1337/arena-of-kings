/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.builders;

import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SuiteMethodBuilder
extends RunnerBuilder {
    @Override
    public Runner runnerForClass(Class<?> clazz) {
        if (this.hasSuiteMethod(clazz)) {
            return new SuiteMethod(clazz);
        }
        return null;
    }

    public boolean hasSuiteMethod(Class<?> clazz) {
        try {
            clazz.getMethod("suite", new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return false;
        }
        return true;
    }
}

