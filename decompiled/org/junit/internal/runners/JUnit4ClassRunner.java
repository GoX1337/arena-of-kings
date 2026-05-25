/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.runners.ClassRoadie;
import org.junit.internal.runners.MethodRoadie;
import org.junit.internal.runners.MethodValidator;
import org.junit.internal.runners.TestClass;
import org.junit.internal.runners.TestMethod;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class JUnit4ClassRunner
extends Runner
implements Filterable,
Sortable {
    private final List<Method> fTestMethods;
    private TestClass fTestClass;

    public JUnit4ClassRunner(Class<?> clazz) {
        this.fTestClass = new TestClass(clazz);
        this.fTestMethods = this.getTestMethods();
        this.validate();
    }

    protected List<Method> getTestMethods() {
        return this.fTestClass.getTestMethods();
    }

    protected void validate() {
        MethodValidator methodValidator = new MethodValidator(this.fTestClass);
        methodValidator.validateMethodsForDefaultRunner();
        methodValidator.assertValid();
    }

    @Override
    public void run(RunNotifier runNotifier) {
        new ClassRoadie(runNotifier, this.fTestClass, this.getDescription(), new byi(this, runNotifier)).runProtected();
    }

    public void runMethods(RunNotifier runNotifier) {
        for (Method method : this.fTestMethods) {
            this.invokeTestMethod(method, runNotifier);
        }
    }

    @Override
    public Description getDescription() {
        Description description = Description.createSuiteDescription(this.getName(), this.classAnnotations());
        List<Method> list = this.fTestMethods;
        for (Method method : list) {
            description.addChild(this.methodDescription(method));
        }
        return description;
    }

    protected Annotation[] classAnnotations() {
        return this.fTestClass.getJavaClass().getAnnotations();
    }

    protected String getName() {
        return this.getTestClass().getName();
    }

    protected Object createTest() {
        return this.getTestClass().getConstructor().newInstance(new Object[0]);
    }

    protected void invokeTestMethod(Method method, RunNotifier runNotifier) {
        Object object;
        Description description = this.methodDescription(method);
        try {
            object = this.createTest();
        }
        catch (InvocationTargetException invocationTargetException) {
            this.testAborted(runNotifier, description, invocationTargetException.getCause());
            return;
        }
        catch (Exception exception) {
            this.testAborted(runNotifier, description, exception);
            return;
        }
        TestMethod testMethod = this.wrapMethod(method);
        new MethodRoadie(object, testMethod, runNotifier, description).run();
    }

    private void testAborted(RunNotifier runNotifier, Description description, Throwable throwable) {
        runNotifier.fireTestStarted(description);
        runNotifier.fireTestFailure(new Failure(description, throwable));
        runNotifier.fireTestFinished(description);
    }

    protected TestMethod wrapMethod(Method method) {
        return new TestMethod(method, this.fTestClass);
    }

    protected String testName(Method method) {
        return method.getName();
    }

    public Description methodDescription(Method method) {
        return Description.createTestDescription(this.getTestClass().getJavaClass(), this.testName(method), this.testAnnotations(method));
    }

    protected Annotation[] testAnnotations(Method method) {
        return method.getAnnotations();
    }

    @Override
    public void filter(Filter filter) {
        Iterator<Method> iterator = this.fTestMethods.iterator();
        while (iterator.hasNext()) {
            Method method = iterator.next();
            if (filter.shouldRun(this.methodDescription(method))) continue;
            iterator.remove();
        }
        if (this.fTestMethods.isEmpty()) {
            throw new NoTestsRemainException();
        }
    }

    @Override
    public void sort(Sorter sorter) {
        Collections.sort(this.fTestMethods, new byj(this, sorter));
    }

    protected TestClass getTestClass() {
        return this.fTestClass;
    }
}

