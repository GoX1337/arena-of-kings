/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.experimental.results.FailureList;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class PrintableResult {
    private Result result;

    public static PrintableResult testResult(Class<?> clazz) {
        return new PrintableResult(clazz);
    }

    public PrintableResult(List<Failure> list) {
        this(new FailureList(list).result());
    }

    public PrintableResult(Result result) {
        this.result = result;
    }

    public PrintableResult(Class<?> clazz) {
        this(JUnitCore.runClasses(clazz));
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new TextListener(new PrintStream(byteArrayOutputStream)).testRunFinished(this.result);
        return byteArrayOutputStream.toString();
    }

    public List<Failure> getFailures() {
        return this.result.getFailures();
    }
}

