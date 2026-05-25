/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.junit.internal.JUnitSystem;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TextListener
extends RunListener {
    private final PrintStream fWriter;

    public TextListener(JUnitSystem jUnitSystem) {
        this(jUnitSystem.out());
    }

    public TextListener(PrintStream printStream) {
        this.fWriter = printStream;
    }

    public void testRunFinished(Result result) {
        this.printHeader(result.getRunTime());
        this.printFailures(result);
        this.printFooter(result);
    }

    public void testStarted(Description description) {
        this.fWriter.append('.');
    }

    public void testFailure(Failure failure) {
        this.fWriter.append('E');
    }

    public void testIgnored(Description description) {
        this.fWriter.append('I');
    }

    private PrintStream getWriter() {
        return this.fWriter;
    }

    protected void printHeader(long l2) {
        this.getWriter().println();
        this.getWriter().println("Time: " + this.elapsedTimeAsString(l2));
    }

    protected void printFailures(Result result) {
        List<Failure> list = result.getFailures();
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            this.getWriter().println("There was " + list.size() + " failure:");
        } else {
            this.getWriter().println("There were " + list.size() + " failures:");
        }
        int n2 = 1;
        for (Failure failure : list) {
            this.printFailure(failure, "" + n2++);
        }
    }

    protected void printFailure(Failure failure, String string) {
        this.getWriter().println(string + ") " + failure.getTestHeader());
        this.getWriter().print(failure.getTrace());
    }

    protected void printFooter(Result result) {
        if (result.wasSuccessful()) {
            this.getWriter().println();
            this.getWriter().print("OK");
            this.getWriter().println(" (" + result.getRunCount() + " test" + (result.getRunCount() == 1 ? "" : "s") + ")");
        } else {
            this.getWriter().println();
            this.getWriter().println("FAILURES!!!");
            this.getWriter().println("Tests run: " + result.getRunCount() + ",  Failures: " + result.getFailureCount());
        }
        this.getWriter().println();
    }

    protected String elapsedTimeAsString(long l2) {
        return NumberFormat.getInstance().format((double)l2 / 1000.0);
    }
}

