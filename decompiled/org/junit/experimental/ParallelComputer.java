/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.runner.Computer;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.RunnerBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ParallelComputer
extends Computer {
    private final boolean fClasses;
    private final boolean fMethods;

    public ParallelComputer(boolean bl2, boolean bl3) {
        this.fClasses = bl2;
        this.fMethods = bl3;
    }

    public static Computer classes() {
        return new ParallelComputer(true, false);
    }

    @Override
    public Suite getSuite(RunnerBuilder runnerBuilder, Class<?>[] classArray) {
        return this.fClasses ? new ParallelSuite(runnerBuilder, classArray) : super.getSuite(runnerBuilder, classArray);
    }

    @Override
    public Runner getRunner(RunnerBuilder runnerBuilder, Class<?> clazz) {
        return this.fMethods ? new ParallelRunner(clazz) : super.getRunner(runnerBuilder, clazz);
    }

    public static Computer methods() {
        return new ParallelComputer(false, true);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ParallelRunner
    extends BlockJUnit4ClassRunner {
        private ExecutorService fService = Executors.newCachedThreadPool();
        private List<Future<Object>> fResults = new ArrayList<Future<Object>>();

        public ParallelRunner(Class<?> clazz) {
            super(clazz);
        }

        @Override
        public void runChild(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
            bxv bxv2 = new bxv(this, frameworkMethod, runNotifier);
            this.fResults.add(this.fService.submit(bxv2));
        }

        public void superRunChild(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
            super.runChild(frameworkMethod, runNotifier);
        }

        @Override
        public void run(RunNotifier runNotifier) {
            super.run(runNotifier);
            for (Future<Object> future : this.fResults) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ParallelSuite
    extends Suite {
        private ExecutorService fService = Executors.newCachedThreadPool();
        private List<Future<Object>> fResults = new ArrayList<Future<Object>>();

        public ParallelSuite(RunnerBuilder runnerBuilder, Class<?>[] classArray) {
            super(runnerBuilder, classArray);
        }

        @Override
        public void runChild(Runner runner, RunNotifier runNotifier) {
            bxw bxw2 = new bxw(this, runner, runNotifier);
            this.fResults.add(this.fService.submit(bxw2));
        }

        public void superRunChild(Runner runner, RunNotifier runNotifier) {
            super.runChild(runner, runNotifier);
        }

        @Override
        public void run(RunNotifier runNotifier) {
            super.run(runNotifier);
            for (Future<Object> future : this.fResults) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

