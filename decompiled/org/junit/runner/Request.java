/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner;

import java.util.Comparator;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.requests.ClassRequest;
import org.junit.internal.requests.FilterRequest;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Computer;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class Request {
    public static Request method(Class<?> clazz, String string) {
        Description description = Description.createTestDescription(clazz, string);
        return Request.aClass(clazz).filterWith(description);
    }

    public static Request aClass(Class<?> clazz) {
        return new ClassRequest(clazz);
    }

    public static Request classWithoutSuiteMethod(Class<?> clazz) {
        return new ClassRequest(clazz, false);
    }

    public static Request classes(Computer computer, Class<?> ... classArray) {
        try {
            AllDefaultPossibilitiesBuilder allDefaultPossibilitiesBuilder = new AllDefaultPossibilitiesBuilder(true);
            Suite suite = computer.getSuite(allDefaultPossibilitiesBuilder, classArray);
            return Request.runner(suite);
        }
        catch (InitializationError initializationError) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    public static Request classes(Class<?> ... classArray) {
        return Request.classes(JUnitCore.defaultComputer(), classArray);
    }

    @Deprecated
    public static Request errorReport(Class<?> clazz, Throwable throwable) {
        return Request.runner(new ErrorReportingRunner(clazz, throwable));
    }

    public static Request runner(Runner runner) {
        return new byp(runner);
    }

    public abstract Runner getRunner();

    public Request filterWith(Filter filter) {
        return new FilterRequest(this, filter);
    }

    public Request filterWith(Description description) {
        return this.filterWith(Filter.matchMethodDescription(description));
    }

    public Request sortWith(Comparator<Description> comparator) {
        return new SortingRequest(this, comparator);
    }
}

