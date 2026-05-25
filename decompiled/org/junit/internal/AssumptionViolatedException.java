/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AssumptionViolatedException
extends RuntimeException
implements SelfDescribing {
    private static final long serialVersionUID = 1L;
    private final Object fValue;
    private final Matcher<?> fMatcher;

    public AssumptionViolatedException(Object object, Matcher<?> matcher) {
        super(object instanceof Throwable ? (Throwable)object : null);
        this.fValue = object;
        this.fMatcher = matcher;
    }

    public AssumptionViolatedException(String string) {
        this((Object)string, null);
    }

    @Override
    public String getMessage() {
        return StringDescription.asString(this);
    }

    @Override
    public void describeTo(Description description) {
        if (this.fMatcher != null) {
            description.appendText("got: ");
            description.appendValue(this.fValue);
            description.appendText(", expected: ");
            description.appendDescriptionOf(this.fMatcher);
        } else {
            description.appendText("failed assumption: " + this.fValue);
        }
    }
}

