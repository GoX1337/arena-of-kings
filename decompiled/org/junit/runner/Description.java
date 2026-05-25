/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runner;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Description {
    public static final Description EMPTY = new Description("No Tests", new Annotation[0]);
    public static final Description TEST_MECHANISM = new Description("Test mechanism", new Annotation[0]);
    private final ArrayList<Description> fChildren = new ArrayList();
    private final String fDisplayName;
    private final Annotation[] fAnnotations;

    public static Description createSuiteDescription(String string, Annotation ... annotationArray) {
        if (string.length() == 0) {
            throw new IllegalArgumentException("name must have non-zero length");
        }
        return new Description(string, annotationArray);
    }

    public static Description createTestDescription(Class<?> clazz, String string, Annotation ... annotationArray) {
        return new Description(String.format("%s(%s)", string, clazz.getName()), annotationArray);
    }

    public static Description createTestDescription(Class<?> clazz, String string) {
        return Description.createTestDescription(clazz, string, new Annotation[0]);
    }

    public static Description createSuiteDescription(Class<?> clazz) {
        return new Description(clazz.getName(), clazz.getAnnotations());
    }

    private Description(String string, Annotation ... annotationArray) {
        this.fDisplayName = string;
        this.fAnnotations = annotationArray;
    }

    public String getDisplayName() {
        return this.fDisplayName;
    }

    public void addChild(Description description) {
        this.getChildren().add(description);
    }

    public ArrayList<Description> getChildren() {
        return this.fChildren;
    }

    public boolean isSuite() {
        return !this.isTest();
    }

    public boolean isTest() {
        return this.getChildren().isEmpty();
    }

    public int testCount() {
        if (this.isTest()) {
            return 1;
        }
        int n2 = 0;
        for (Description description : this.getChildren()) {
            n2 += description.testCount();
        }
        return n2;
    }

    public int hashCode() {
        return this.getDisplayName().hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof Description)) {
            return false;
        }
        Description description = (Description)object;
        return this.getDisplayName().equals(description.getDisplayName()) && this.getChildren().equals(description.getChildren());
    }

    public String toString() {
        return this.getDisplayName();
    }

    public boolean isEmpty() {
        return this.equals(EMPTY);
    }

    public Description childlessCopy() {
        return new Description(this.fDisplayName, this.fAnnotations);
    }

    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        for (Annotation annotation : this.fAnnotations) {
            if (!annotation.annotationType().equals(clazz)) continue;
            return (T)((Annotation)clazz.cast(annotation));
        }
        return null;
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.fAnnotations);
    }

    public Class<?> getTestClass() {
        String string = this.getClassName();
        if (string == null) {
            return null;
        }
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public String getClassName() {
        Matcher matcher = Pattern.compile("(.*)\\((.*)\\)").matcher(this.toString());
        return matcher.matches() ? matcher.group(2) : this.toString();
    }

    private String parseMethod() {
        Matcher matcher = Pattern.compile("(.*)\\((.*)\\)").matcher(this.toString());
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public String getMethodName() {
        return this.parseMethod();
    }
}

