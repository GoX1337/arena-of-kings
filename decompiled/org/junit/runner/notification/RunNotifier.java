/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.StoppedByUserException;

public class RunNotifier {
    private final List<RunListener> fListeners = new ArrayList<RunListener>();
    private boolean fPleaseStop = false;

    public void addListener(RunListener runListener) {
        this.fListeners.add(runListener);
    }

    public void removeListener(RunListener runListener) {
        this.fListeners.remove(runListener);
    }

    public void fireTestRunStarted(Description description) {
        new byt(this, description).a();
    }

    public void fireTestRunFinished(Result result) {
        new byu(this, result).a();
    }

    public void fireTestStarted(Description description) {
        if (this.fPleaseStop) {
            throw new StoppedByUserException();
        }
        new byv(this, description).a();
    }

    public void fireTestFailure(Failure failure) {
        new byw(this, failure).a();
    }

    public void fireTestAssumptionFailed(Failure failure) {
        new byx(this, failure).a();
    }

    public void fireTestIgnored(Description description) {
        new byy(this, description).a();
    }

    public void fireTestFinished(Description description) {
        new byz(this, description).a();
    }

    public void pleaseStop() {
        this.fPleaseStop = true;
    }

    public void addFirstListener(RunListener runListener) {
        this.fListeners.add(0, runListener);
    }

    public abstract class a {
        private a() {
        }

        void a() {
            Iterator iterator = RunNotifier.this.fListeners.iterator();
            while (iterator.hasNext()) {
                try {
                    this.a((RunListener)iterator.next());
                }
                catch (Exception exception) {
                    iterator.remove();
                    RunNotifier.this.fireTestFailure(new Failure(Description.TEST_MECHANISM, exception));
                }
            }
        }

        protected abstract void a(RunListener var1);

        public /* synthetic */ a(byt byt2) {
            this();
        }
    }
}

