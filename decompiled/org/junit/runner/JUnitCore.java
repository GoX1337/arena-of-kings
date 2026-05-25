/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Computer;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class JUnitCore {
    public RunNotifier fNotifier = new RunNotifier();

    public static void main(String ... stringArray) {
        JUnitCore.runMainAndExit(new RealSystem(), stringArray);
    }

    public static void runMainAndExit(JUnitSystem jUnitSystem, String ... stringArray) {
        Result result = new JUnitCore().runMain(jUnitSystem, stringArray);
        jUnitSystem.exit(result.wasSuccessful() ? 0 : 1);
    }

    public static Result runClasses(Computer computer, Class<?> ... classArray) {
        return new JUnitCore().run(computer, classArray);
    }

    public static Result runClasses(Class<?> ... classArray) {
        return new JUnitCore().run(JUnitCore.defaultComputer(), classArray);
    }

    public Result runMain(JUnitSystem jUnitSystem, String ... stringArray) {
        jUnitSystem.out().println("JUnit version " + bxp.a());
        ArrayList arrayList = new ArrayList();
        ArrayList<Failure> arrayList2 = new ArrayList<Failure>();
        for (String string : stringArray) {
            try {
                arrayList.add(Class.forName(string));
            }
            catch (ClassNotFoundException classNotFoundException) {
                jUnitSystem.out().println("Could not find class: " + string);
                Description description = Description.createSuiteDescription(string, new Annotation[0]);
                Failure failure = new Failure(description, classNotFoundException);
                arrayList2.add(failure);
            }
        }
        TextListener textListener = new TextListener(jUnitSystem);
        this.addListener(textListener);
        Result result = this.run(arrayList.toArray(new Class[0]));
        for (Failure failure : arrayList2) {
            result.getFailures().add(failure);
        }
        return result;
    }

    public String getVersion() {
        return bxp.a();
    }

    public Result run(Class<?> ... classArray) {
        return this.run(Request.classes(JUnitCore.defaultComputer(), classArray));
    }

    public Result run(Computer computer, Class<?> ... classArray) {
        return this.run(Request.classes(computer, classArray));
    }

    public Result run(Request request) {
        return this.run(request.getRunner());
    }

    public Result run(bxh bxh2) {
        return this.run(new JUnit38ClassRunner(bxh2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Result run(Runner runner) {
        Result result = new Result();
        RunListener runListener = result.createListener();
        this.fNotifier.addFirstListener(runListener);
        try {
            this.fNotifier.fireTestRunStarted(runner.getDescription());
            runner.run(this.fNotifier);
            this.fNotifier.fireTestRunFinished(result);
        }
        finally {
            this.removeListener(runListener);
        }
        return result;
    }

    public void addListener(RunListener runListener) {
        this.fNotifier.addListener(runListener);
    }

    public void removeListener(RunListener runListener) {
        this.fNotifier.removeListener(runListener);
    }

    static Computer defaultComputer() {
        return new Computer();
    }
}

