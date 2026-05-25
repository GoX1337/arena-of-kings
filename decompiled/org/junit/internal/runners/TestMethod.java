/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class TestMethod {
    private final Method fMethod;
    private TestClass fTestClass;

    public TestMethod(Method method, TestClass testClass) {
        this.fMethod = method;
        this.fTestClass = testClass;
    }

    public boolean isIgnored() {
        return this.fMethod.getAnnotation(Ignore.class) != null;
    }

    public long getTimeout() {
        Test test = this.fMethod.getAnnotation(Test.class);
        if (test == null) {
            return 0L;
        }
        long l2 = test.timeout();
        return l2;
    }

    protected Class<? extends Throwable> getExpectedException() {
        Test test = this.fMethod.getAnnotation(Test.class);
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    boolean isUnexpected(Throwable throwable) {
        return !this.getExpectedException().isAssignableFrom(throwable.getClass());
    }

    boolean expectsException() {
        return this.getExpectedException() != null;
    }

    List<Method> getBefores() {
        return this.fTestClass.getAnnotatedMethods(Before.class);
    }

    List<Method> getAfters() {
        return this.fTestClass.getAnnotatedMethods(After.class);
    }

    public void invoke(Object object) {
        this.fMethod.invoke(object, new Object[0]);
    }
}

