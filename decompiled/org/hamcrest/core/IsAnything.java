/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IsAnything<T>
extends BaseMatcher<T> {
    private final String description;

    public IsAnything() {
        this("ANYTHING");
    }

    public IsAnything(String string) {
        this.description = string;
    }

    @Override
    public boolean matches(Object object) {
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(this.description);
    }

    @Factory
    public static <T> Matcher<T> anything() {
        return new IsAnything<T>();
    }

    @Factory
    public static <T> Matcher<T> anything(String string) {
        return new IsAnything<T>(string);
    }

    @Factory
    public static <T> Matcher<T> any(Class<T> clazz) {
        return new IsAnything<T>();
    }
}

