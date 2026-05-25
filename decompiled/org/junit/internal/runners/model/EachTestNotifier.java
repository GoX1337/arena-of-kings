/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners.model;

import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class EachTestNotifier {
    private final RunNotifier fNotifier;
    private final Description fDescription;

    public EachTestNotifier(RunNotifier runNotifier, Description description) {
        this.fNotifier = runNotifier;
        this.fDescription = description;
    }

    public void addFailure(Throwable throwable) {
        if (throwable instanceof MultipleFailureException) {
            MultipleFailureException multipleFailureException = (MultipleFailureException)throwable;
            for (Throwable throwable2 : multipleFailureException.getFailures()) {
                this.addFailure(throwable2);
            }
            return;
        }
        this.fNotifier.fireTestFailure(new Failure(this.fDescription, throwable));
    }

    public void addFailedAssumption(AssumptionViolatedException assumptionViolatedException) {
        this.fNotifier.fireTestAssumptionFailed(new Failure(this.fDescription, assumptionViolatedException));
    }

    public void fireTestFinished() {
        this.fNotifier.fireTestFinished(this.fDescription);
    }

    public void fireTestStarted() {
        this.fNotifier.fireTestStarted(this.fDescription);
    }

    public void fireTestIgnored() {
        this.fNotifier.fireTestIgnored(this.fDescription);
    }
}

