/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner;

import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Computer {
    public static Computer serial() {
        return new Computer();
    }

    public Suite getSuite(RunnerBuilder runnerBuilder, Class<?>[] classArray) {
        return new Suite(new byo(this, runnerBuilder), classArray);
    }

    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> clazz) {
        return runnerBuilder.runnerForClass(clazz);
    }
}

