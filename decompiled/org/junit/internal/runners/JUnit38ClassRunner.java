/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JUnit38ClassRunner
extends Runner
implements Filterable,
Sortable {
    private bxh fTest;

    public JUnit38ClassRunner(Class<?> clazz) {
        this(new bxn(clazz.asSubclass(bxi.class)));
    }

    public JUnit38ClassRunner(bxh bxh2) {
        this.setTest(bxh2);
    }

    @Override
    public void run(RunNotifier runNotifier) {
        bxl bxl2 = new bxl();
        bxl2.a(this.createAdaptingListener(runNotifier));
        this.getTest().b(bxl2);
    }

    public bxk createAdaptingListener(RunNotifier runNotifier) {
        return new a(this, runNotifier);
    }

    @Override
    public Description getDescription() {
        return JUnit38ClassRunner.makeDescription(this.getTest());
    }

    public static Description makeDescription(bxh bxh2) {
        if (bxh2 instanceof bxi) {
            bxi bxi2 = (bxi)bxh2;
            return Description.createTestDescription(bxi2.getClass(), bxi2.java_lang_String_a());
        }
        if (bxh2 instanceof bxn) {
            bxn bxn2 = (bxn)bxh2;
            String string = bxn2.java_lang_String_a() == null ? JUnit38ClassRunner.createSuiteDescription(bxn2) : bxn2.java_lang_String_a();
            Description description = Description.createSuiteDescription(string, new Annotation[0]);
            int n2 = bxn2.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                Description description2 = JUnit38ClassRunner.makeDescription(bxn2.a(i2));
                if (description2.toString().startsWith("warning(")) continue;
                description.addChild(description2);
            }
            return description;
        }
        if (bxh2 instanceof Describable) {
            Describable describable = (Describable)((Object)bxh2);
            return describable.getDescription();
        }
        if (bxh2 instanceof bxd) {
            bxd bxd2 = (bxd)bxh2;
            return JUnit38ClassRunner.makeDescription(bxd2.bxh_a());
        }
        return Description.createSuiteDescription(bxh2.getClass());
    }

    private static String createSuiteDescription(bxn bxn2) {
        int n2 = bxn2.int_a();
        String string = n2 == 0 ? "" : String.format(" [example: %s]", bxn2.a(0));
        return String.format("TestSuite with %s tests%s", n2, string);
    }

    @Override
    public void filter(Filter filter) {
        if (this.getTest() instanceof Filterable) {
            Filterable filterable = (Filterable)((Object)this.getTest());
            filterable.filter(filter);
        } else if (this.getTest() instanceof bxn) {
            bxn bxn2 = (bxn)this.getTest();
            bxn bxn3 = new bxn(bxn2.java_lang_String_a());
            int n2 = bxn2.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                bxh bxh2 = bxn2.a(i2);
                if (!filter.shouldRun(JUnit38ClassRunner.makeDescription(bxh2))) continue;
                bxn3.a(bxh2);
            }
            this.setTest(bxn3);
        }
    }

    @Override
    public void sort(Sorter sorter) {
        if (this.getTest() instanceof Sortable) {
            Sortable sortable = (Sortable)((Object)this.getTest());
            sortable.sort(sorter);
        }
    }

    private void setTest(bxh bxh2) {
        this.fTest = bxh2;
    }

    public bxh getTest() {
        return this.fTest;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements bxk {
        private final RunNotifier var_org_junit_runner_notification_RunNotifier_a;
        final /* synthetic */ JUnit38ClassRunner var_org_junit_internal_runners_JUnit38ClassRunner_a;

        private a(JUnit38ClassRunner jUnit38ClassRunner, RunNotifier runNotifier) {
            this.var_org_junit_internal_runners_JUnit38ClassRunner_a = jUnit38ClassRunner;
            this.var_org_junit_runner_notification_RunNotifier_a = runNotifier;
        }

        @Override
        public void void_a(bxh bxh2) {
            this.var_org_junit_runner_notification_RunNotifier_a.fireTestFinished(this.org_junit_runner_Description_a(bxh2));
        }

        @Override
        public void b(bxh bxh2) {
            this.var_org_junit_runner_notification_RunNotifier_a.fireTestStarted(this.org_junit_runner_Description_a(bxh2));
        }

        @Override
        public void a(bxh bxh2, Throwable throwable) {
            Failure failure = new Failure(this.org_junit_runner_Description_a(bxh2), throwable);
            this.var_org_junit_runner_notification_RunNotifier_a.fireTestFailure(failure);
        }

        private Description org_junit_runner_Description_a(bxh bxh2) {
            if (bxh2 instanceof Describable) {
                Describable describable = (Describable)((Object)bxh2);
                return describable.getDescription();
            }
            return Description.createTestDescription(this.a(bxh2), this.java_lang_String_a(bxh2));
        }

        private Class<? extends bxh> a(bxh bxh2) {
            if ("warning".equals(this.java_lang_String_a(bxh2))) {
                try {
                    return Class.forName(this.var_org_junit_internal_runners_JUnit38ClassRunner_a.fTest.toString());
                }
                catch (ClassNotFoundException classNotFoundException) {
                    return bxh2.getClass();
                }
            }
            return bxh2.getClass();
        }

        private String java_lang_String_a(bxh bxh2) {
            if (bxh2 instanceof bxi) {
                return ((bxi)bxh2).java_lang_String_a();
            }
            return bxh2.toString();
        }

        @Override
        public void a(bxh bxh2, bxf bxf2) {
            this.a(bxh2, (Throwable)((Object)bxf2));
        }
    }
}

