/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner.notification;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.runner.Description;

public class Failure {
    private final Description fDescription;
    private final Throwable fThrownException;

    public Failure(Description description, Throwable throwable) {
        this.fThrownException = throwable;
        this.fDescription = description;
    }

    public String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public Description getDescription() {
        return this.fDescription;
    }

    public Throwable getException() {
        return this.fThrownException;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getTestHeader() + ": " + this.fThrownException.getMessage());
        return stringBuffer.toString();
    }

    public String getTrace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        this.getException().printStackTrace(printWriter);
        StringBuffer stringBuffer = stringWriter.getBuffer();
        return stringBuffer.toString();
    }

    public String getMessage() {
        return this.getException().getMessage();
    }
}

