/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.builders;

import java.util.Arrays;
import java.util.List;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.internal.builders.NullBuilder;
import org.junit.internal.builders.SuiteMethodBuilder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AllDefaultPossibilitiesBuilder
extends RunnerBuilder {
    private final boolean fCanUseSuiteMethod;

    public AllDefaultPossibilitiesBuilder(boolean bl2) {
        this.fCanUseSuiteMethod = bl2;
    }

    @Override
    public Runner runnerForClass(Class<?> clazz) {
        List<RunnerBuilder> list = Arrays.asList(this.ignoredBuilder(), this.annotatedBuilder(), this.suiteMethodBuilder(), this.junit3Builder(), this.junit4Builder());
        for (RunnerBuilder runnerBuilder : list) {
            Runner runner = runnerBuilder.safeRunnerForClass(clazz);
            if (runner == null) continue;
            return runner;
        }
        return null;
    }

    protected JUnit4Builder junit4Builder() {
        return new JUnit4Builder();
    }

    protected JUnit3Builder junit3Builder() {
        return new JUnit3Builder();
    }

    protected AnnotatedBuilder annotatedBuilder() {
        return new AnnotatedBuilder(this);
    }

    protected IgnoredBuilder ignoredBuilder() {
        return new IgnoredBuilder();
    }

    protected RunnerBuilder suiteMethodBuilder() {
        if (this.fCanUseSuiteMethod) {
            return new SuiteMethodBuilder();
        }
        return new NullBuilder();
    }
}

