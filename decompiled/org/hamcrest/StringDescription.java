/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest;

import java.io.IOException;
import org.hamcrest.BaseDescription;
import org.hamcrest.SelfDescribing;

public class StringDescription
extends BaseDescription {
    private final Appendable out;

    public StringDescription() {
        this(new StringBuilder());
    }

    public StringDescription(Appendable appendable) {
        this.out = appendable;
    }

    public static String toString(SelfDescribing selfDescribing) {
        return new StringDescription().appendDescriptionOf(selfDescribing).toString();
    }

    public static String asString(SelfDescribing selfDescribing) {
        return StringDescription.toString(selfDescribing);
    }

    protected void append(String string) {
        try {
            this.out.append(string);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Could not write description", iOException);
        }
    }

    protected void append(char c2) {
        try {
            this.out.append(c2);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Could not write description", iOException);
        }
    }

    public String toString() {
        return this.out.toString();
    }
}

