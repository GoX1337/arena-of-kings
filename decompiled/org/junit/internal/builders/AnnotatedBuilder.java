/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.builders;

import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AnnotatedBuilder
extends RunnerBuilder {
    private static final String CONSTRUCTOR_ERROR_FORMAT = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";
    private RunnerBuilder fSuiteBuilder;

    public AnnotatedBuilder(RunnerBuilder runnerBuilder) {
        this.fSuiteBuilder = runnerBuilder;
    }

    @Override
    public Runner runnerForClass(Class<?> clazz) {
        RunWith runWith = clazz.getAnnotation(RunWith.class);
        if (runWith != null) {
            return this.buildRunner(runWith.value(), clazz);
        }
        return null;
    }

    public Runner buildRunner(Class<? extends Runner> clazz, Class<?> clazz2) {
        try {
            return clazz.getConstructor(Class.class).newInstance(clazz2);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            try {
                return clazz.getConstructor(Class.class, RunnerBuilder.class).newInstance(clazz2, this.fSuiteBuilder);
            }
            catch (NoSuchMethodException noSuchMethodException2) {
                String string = clazz.getSimpleName();
                throw new InitializationError(String.format(CONSTRUCTOR_ERROR_FORMAT, string, string));
            }
        }
    }
}

