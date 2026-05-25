/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Result {
    private int fCount = 0;
    private int fIgnoreCount = 0;
    private final List<Failure> fFailures = new ArrayList<Failure>();
    private long fRunTime = 0L;
    private long fStartTime;

    public int getRunCount() {
        return this.fCount;
    }

    public int getFailureCount() {
        return this.fFailures.size();
    }

    public long getRunTime() {
        return this.fRunTime;
    }

    public List<Failure> getFailures() {
        return this.fFailures;
    }

    public int getIgnoreCount() {
        return this.fIgnoreCount;
    }

    public boolean wasSuccessful() {
        return this.getFailureCount() == 0;
    }

    public RunListener createListener() {
        return new a();
    }

    class a
    extends RunListener {
        private a() {
        }

        public void testRunStarted(Description description) {
            Result.this.fStartTime = System.currentTimeMillis();
        }

        public void testRunFinished(Result result) {
            long l2 = System.currentTimeMillis();
            Result.this.fRunTime += l2 - Result.this.fStartTime;
        }

        public void testFinished(Description description) {
            Result.this.fCount++;
        }

        public void testFailure(Failure failure) {
            Result.this.fFailures.add(failure);
        }

        public void testIgnored(Description description) {
            Result.this.fIgnoreCount++;
        }

        public void testAssumptionFailure(Failure failure) {
        }
    }
}

