/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.builders;

import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JUnit3Builder
extends RunnerBuilder {
    @Override
    public Runner runnerForClass(Class<?> clazz) {
        if (this.isPre4Test(clazz)) {
            return new JUnit38ClassRunner(clazz);
        }
        return null;
    }

    boolean isPre4Test(Class<?> clazz) {
        return bxi.class.isAssignableFrom(clazz);
    }
}

