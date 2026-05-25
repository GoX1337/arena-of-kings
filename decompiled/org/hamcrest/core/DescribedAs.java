/*
 * Decompiled with CFR 0.152.
 */
package org.hamcrest.core;

import java.util.regex.Pattern;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DescribedAs<T>
extends BaseMatcher<T> {
    private final String descriptionTemplate;
    private final Matcher<T> matcher;
    private final Object[] values;
    private static final Pattern ARG_PATTERN = Pattern.compile("%([0-9]+)");

    public DescribedAs(String string, Matcher<T> matcher, Object[] objectArray) {
        this.descriptionTemplate = string;
        this.matcher = matcher;
        this.values = (Object[])objectArray.clone();
    }

    @Override
    public boolean matches(Object object) {
        return this.matcher.matches(object);
    }

    @Override
    public void describeTo(Description description) {
        java.util.regex.Matcher matcher = ARG_PATTERN.matcher(this.descriptionTemplate);
        int n2 = 0;
        while (matcher.find()) {
            description.appendText(this.descriptionTemplate.substring(n2, matcher.start()));
            int n3 = Integer.parseInt(matcher.group(1));
            description.appendValue(this.values[n3]);
            n2 = matcher.end();
        }
        if (n2 < this.descriptionTemplate.length()) {
            description.appendText(this.descriptionTemplate.substring(n2));
        }
    }

    @Factory
    public static <T> Matcher<T> describedAs(String string, Matcher<T> matcher, Object ... objectArray) {
        return new DescribedAs<T>(string, matcher, objectArray);
    }
}

