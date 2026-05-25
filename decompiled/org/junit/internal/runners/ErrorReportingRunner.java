/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.junit.internal.runners.InitializationError;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ErrorReportingRunner
extends Runner {
    private final List<Throwable> fCauses;
    private final Class<?> fTestClass;

    public ErrorReportingRunner(Class<?> clazz, Throwable throwable) {
        this.fTestClass = clazz;
        this.fCauses = this.getCauses(throwable);
    }

    @Override
    public Description getDescription() {
        Description description = Description.createSuiteDescription(this.fTestClass);
        for (Throwable throwable : this.fCauses) {
            description.addChild(this.describeCause(throwable));
        }
        return description;
    }

    @Override
    public void run(RunNotifier runNotifier) {
        for (Throwable throwable : this.fCauses) {
            this.runCause(throwable, runNotifier);
        }
    }

    private List<Throwable> getCauses(Throwable throwable) {
        if (throwable instanceof InvocationTargetException) {
            return this.getCauses(throwable.getCause());
        }
        if (throwable instanceof org.junit.runners.model.InitializationError) {
            return ((org.junit.runners.model.InitializationError)throwable).getCauses();
        }
        if (throwable instanceof InitializationError) {
            return ((InitializationError)throwable).getCauses();
        }
        return Arrays.asList(throwable);
    }

    private Description describeCause(Throwable throwable) {
        return Description.createTestDescription(this.fTestClass, "initializationError");
    }

    private void runCause(Throwable throwable, RunNotifier runNotifier) {
        Description description = this.describeCause(throwable);
        runNotifier.fireTestStarted(description);
        runNotifier.fireTestFailure(new Failure(description, throwable));
        runNotifier.fireTestFinished(description);
    }
}

