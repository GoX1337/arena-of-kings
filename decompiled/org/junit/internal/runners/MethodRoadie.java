/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.TestMethod;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class MethodRoadie {
    private final Object fTest;
    private final RunNotifier fNotifier;
    private final Description fDescription;
    private TestMethod fTestMethod;

    public MethodRoadie(Object object, TestMethod testMethod, RunNotifier runNotifier, Description description) {
        this.fTest = object;
        this.fNotifier = runNotifier;
        this.fDescription = description;
        this.fTestMethod = testMethod;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        if (this.fTestMethod.isIgnored()) {
            this.fNotifier.fireTestIgnored(this.fDescription);
            return;
        }
        this.fNotifier.fireTestStarted(this.fDescription);
        try {
            long l2 = this.fTestMethod.getTimeout();
            if (l2 > 0L) {
                this.runWithTimeout(l2);
            } else {
                this.runTest();
            }
        }
        finally {
            this.fNotifier.fireTestFinished(this.fDescription);
        }
    }

    private void runWithTimeout(long l2) {
        this.runBeforesThenTestThenAfters(new byk(this, l2));
    }

    public void runTest() {
        this.runBeforesThenTestThenAfters(new bym(this));
    }

    public void runBeforesThenTestThenAfters(Runnable runnable) {
        try {
            this.runBefores();
            runnable.run();
        }
        catch (byh byh2) {
        }
        catch (Exception exception) {
            throw new RuntimeException("test should never throw an exception to this level");
        }
        finally {
            this.runAfters();
        }
    }

    public void runTestMethod() {
        try {
            this.fTestMethod.invoke(this.fTest);
            if (this.fTestMethod.expectsException()) {
                this.addFailure((Throwable)((Object)new AssertionError((Object)("Expected exception: " + this.fTestMethod.getExpectedException().getName()))));
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof AssumptionViolatedException) {
                return;
            }
            if (!this.fTestMethod.expectsException()) {
                this.addFailure(throwable);
            } else if (this.fTestMethod.isUnexpected(throwable)) {
                String string = "Unexpected exception, expected<" + this.fTestMethod.getExpectedException().getName() + "> but was<" + throwable.getClass().getName() + ">";
                this.addFailure(new Exception(string, throwable));
            }
        }
        catch (Throwable throwable) {
            this.addFailure(throwable);
        }
    }

    private void runBefores() {
        try {
            try {
                List<Method> list = this.fTestMethod.getBefores();
                for (Method method : list) {
                    method.invoke(this.fTest, new Object[0]);
                }
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getTargetException();
            }
        }
        catch (AssumptionViolatedException assumptionViolatedException) {
            throw new byh();
        }
        catch (Throwable throwable) {
            this.addFailure(throwable);
            throw new byh();
        }
    }

    private void runAfters() {
        List<Method> list = this.fTestMethod.getAfters();
        for (Method method : list) {
            try {
                method.invoke(this.fTest, new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.addFailure(invocationTargetException.getTargetException());
            }
            catch (Throwable throwable) {
                this.addFailure(throwable);
            }
        }
    }

    public void addFailure(Throwable throwable) {
        this.fNotifier.fireTestFailure(new Failure(this.fDescription, throwable));
    }
}

