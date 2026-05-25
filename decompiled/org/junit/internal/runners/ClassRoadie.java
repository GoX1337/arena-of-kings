/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.TestClass;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@Deprecated
public class ClassRoadie {
    private RunNotifier fNotifier;
    private TestClass fTestClass;
    private Description fDescription;
    private final Runnable fRunnable;

    public ClassRoadie(RunNotifier runNotifier, TestClass testClass, Description description, Runnable runnable) {
        this.fNotifier = runNotifier;
        this.fTestClass = testClass;
        this.fDescription = description;
        this.fRunnable = runnable;
    }

    protected void runUnprotected() {
        this.fRunnable.run();
    }

    protected void addFailure(Throwable throwable) {
        this.fNotifier.fireTestFailure(new Failure(this.fDescription, throwable));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void runProtected() {
        try {
            this.runBefores();
            this.runUnprotected();
        }
        catch (byh byh2) {
        }
        finally {
            this.runAfters();
        }
    }

    private void runBefores() {
        try {
            try {
                List<Method> list = this.fTestClass.getBefores();
                for (Method method : list) {
                    method.invoke(null, new Object[0]);
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
        List<Method> list = this.fTestClass.getAfters();
        for (Method method : list) {
            try {
                method.invoke(null, new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.addFailure(invocationTargetException.getTargetException());
            }
            catch (Throwable throwable) {
                this.addFailure(throwable);
            }
        }
    }
}

