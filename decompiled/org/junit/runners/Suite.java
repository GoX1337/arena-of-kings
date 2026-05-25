/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Suite
extends ParentRunner<Runner> {
    private final List<Runner> fRunners;

    private static Class<?>[] getAnnotatedClasses(Class<?> clazz) {
        SuiteClasses suiteClasses = clazz.getAnnotation(SuiteClasses.class);
        if (suiteClasses == null) {
            throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", clazz.getName()));
        }
        return suiteClasses.value();
    }

    public Suite(Class<?> clazz, RunnerBuilder runnerBuilder) {
        this(runnerBuilder, clazz, Suite.getAnnotatedClasses(clazz));
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?>[] classArray) {
        this(null, runnerBuilder == null ? new ArrayList() : runnerBuilder.runners(null, classArray));
    }

    protected Suite(Class<?> clazz, Class<?>[] classArray) {
        this(new AllDefaultPossibilitiesBuilder(true), clazz, classArray);
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?> clazz, Class<?>[] classArray) {
        this(clazz, runnerBuilder.runners(clazz, classArray));
    }

    public Suite(Class<?> clazz, List<Runner> list) {
        super(clazz);
        this.fRunners = list;
    }

    @Override
    protected List<Runner> getChildren() {
        return this.fRunners;
    }

    @Override
    protected Description describeChild(Runner runner) {
        return runner.getDescription();
    }

    @Override
    public void runChild(Runner runner, RunNotifier runNotifier) {
        runner.run(runNotifier);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface SuiteClasses {
        public Class<?>[] value();
    }
}

