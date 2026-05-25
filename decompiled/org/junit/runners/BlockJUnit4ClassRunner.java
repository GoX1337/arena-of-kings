/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BlockJUnit4ClassRunner
extends ParentRunner<FrameworkMethod> {
    public BlockJUnit4ClassRunner(Class<?> clazz) {
        super(clazz);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void runChild(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = this.makeNotifier(frameworkMethod, runNotifier);
        if (frameworkMethod.getAnnotation(Ignore.class) != null) {
            eachTestNotifier.fireTestIgnored();
            return;
        }
        eachTestNotifier.fireTestStarted();
        try {
            this.methodBlock(frameworkMethod).evaluate();
        }
        catch (AssumptionViolatedException assumptionViolatedException) {
            eachTestNotifier.addFailedAssumption(assumptionViolatedException);
        }
        catch (Throwable throwable) {
            eachTestNotifier.addFailure(throwable);
        }
        finally {
            eachTestNotifier.fireTestFinished();
        }
    }

    @Override
    protected Description describeChild(FrameworkMethod frameworkMethod) {
        return Description.createTestDescription(this.getTestClass().getJavaClass(), this.testName(frameworkMethod), frameworkMethod.getAnnotations());
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        return this.computeTestMethods();
    }

    public List<FrameworkMethod> computeTestMethods() {
        return this.getTestClass().getAnnotatedMethods(Test.class);
    }

    @Override
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        this.validateConstructor(list);
        this.validateInstanceMethods(list);
    }

    private void validateConstructor(List<Throwable> list) {
        this.validateOnlyOneConstructor(list);
        this.validateZeroArgConstructor(list);
    }

    private void validateOnlyOneConstructor(List<Throwable> list) {
        if (!this.hasOneConstructor()) {
            String string = "Test class should have exactly one public constructor";
            list.add(new Exception(string));
        }
    }

    protected void validateZeroArgConstructor(List<Throwable> list) {
        if (this.hasOneConstructor() && this.getTestClass().getOnlyConstructor().getParameterTypes().length != 0) {
            String string = "Test class should have exactly one public zero-argument constructor";
            list.add(new Exception(string));
        }
    }

    private boolean hasOneConstructor() {
        return this.getTestClass().getJavaClass().getConstructors().length == 1;
    }

    protected void validateInstanceMethods(List<Throwable> list) {
        this.validatePublicVoidNoArgMethods(After.class, false, list);
        this.validatePublicVoidNoArgMethods(Before.class, false, list);
        this.validateTestMethods(list);
        if (this.computeTestMethods().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    protected void validateTestMethods(List<Throwable> list) {
        this.validatePublicVoidNoArgMethods(Test.class, false, list);
    }

    public Object createTest() {
        return this.getTestClass().getOnlyConstructor().newInstance(new Object[0]);
    }

    protected String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        Object object;
        try {
            object = new bza(this).run();
        }
        catch (Throwable throwable) {
            return new Fail(throwable);
        }
        Statement statement = this.methodInvoker(frameworkMethod, object);
        statement = this.possiblyExpectingExceptions(frameworkMethod, object, statement);
        statement = this.withPotentialTimeout(frameworkMethod, object, statement);
        statement = this.withBefores(frameworkMethod, object, statement);
        statement = this.withAfters(frameworkMethod, object, statement);
        return statement;
    }

    protected Statement methodInvoker(FrameworkMethod frameworkMethod, Object object) {
        return new InvokeMethod(frameworkMethod, object);
    }

    protected Statement possiblyExpectingExceptions(FrameworkMethod frameworkMethod, Object object, Statement statement) {
        Test test = frameworkMethod.getAnnotation(Test.class);
        return this.expectsException(test) ? new ExpectException(statement, this.getExpectedException(test)) : statement;
    }

    protected Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object object, Statement statement) {
        long l2 = this.getTimeout(frameworkMethod.getAnnotation(Test.class));
        return l2 > 0L ? new FailOnTimeout(statement, l2) : statement;
    }

    protected Statement withBefores(FrameworkMethod frameworkMethod, Object object, Statement statement) {
        List<FrameworkMethod> list = this.getTestClass().getAnnotatedMethods(Before.class);
        return new RunBefores(statement, list, object);
    }

    protected Statement withAfters(FrameworkMethod frameworkMethod, Object object, Statement statement) {
        List<FrameworkMethod> list = this.getTestClass().getAnnotatedMethods(After.class);
        return new RunAfters(statement, list, object);
    }

    protected EachTestNotifier makeNotifier(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description description = this.describeChild(frameworkMethod);
        return new EachTestNotifier(runNotifier, description);
    }

    private Class<? extends Throwable> getExpectedException(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    private boolean expectsException(Test test) {
        return this.getExpectedException(test) != null;
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }
}

