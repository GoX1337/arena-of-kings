/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class ParentRunner<T>
extends Runner
implements Filterable,
Sortable {
    private final TestClass fTestClass;
    private Filter fFilter = null;
    private Sorter fSorter = Sorter.NULL;

    protected ParentRunner(Class<?> clazz) {
        this.fTestClass = new TestClass(clazz);
        this.validate();
    }

    protected abstract List<T> getChildren();

    public abstract Description describeChild(T var1);

    protected abstract void runChild(T var1, RunNotifier var2);

    protected void collectInitializationErrors(List<Throwable> list) {
        this.validatePublicVoidNoArgMethods(BeforeClass.class, true, list);
        this.validatePublicVoidNoArgMethods(AfterClass.class, true, list);
    }

    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> clazz, boolean bl2, List<Throwable> list) {
        List<FrameworkMethod> list2 = this.getTestClass().getAnnotatedMethods(clazz);
        for (FrameworkMethod frameworkMethod : list2) {
            frameworkMethod.validatePublicVoidNoArg(bl2, list);
        }
    }

    protected Statement classBlock(RunNotifier runNotifier) {
        Statement statement = this.childrenInvoker(runNotifier);
        statement = this.withBeforeClasses(statement);
        statement = this.withAfterClasses(statement);
        return statement;
    }

    protected Statement withBeforeClasses(Statement statement) {
        List<FrameworkMethod> list = this.fTestClass.getAnnotatedMethods(BeforeClass.class);
        statement = new RunBefores(statement, list, null);
        return statement;
    }

    protected Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> list = this.fTestClass.getAnnotatedMethods(AfterClass.class);
        statement = new RunAfters(statement, list, null);
        return statement;
    }

    protected Statement childrenInvoker(RunNotifier runNotifier) {
        return new bzb(this, runNotifier);
    }

    private void runChildren(RunNotifier runNotifier) {
        for (T t2 : this.getFilteredChildren()) {
            this.runChild(t2, runNotifier);
        }
    }

    protected String getName() {
        return this.fTestClass.getName();
    }

    public final TestClass getTestClass() {
        return this.fTestClass;
    }

    @Override
    public Description getDescription() {
        Description description = Description.createSuiteDescription(this.getName(), this.fTestClass.getAnnotations());
        for (T t2 : this.getFilteredChildren()) {
            description.addChild(this.describeChild(t2));
        }
        return description;
    }

    @Override
    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, this.getDescription());
        try {
            Statement statement = this.classBlock(runNotifier);
            statement.evaluate();
        }
        catch (AssumptionViolatedException assumptionViolatedException) {
            eachTestNotifier.fireTestIgnored();
        }
        catch (StoppedByUserException stoppedByUserException) {
            throw stoppedByUserException;
        }
        catch (Throwable throwable) {
            eachTestNotifier.addFailure(throwable);
        }
    }

    @Override
    public void filter(Filter filter) {
        this.fFilter = filter;
        for (T t2 : this.getChildren()) {
            if (!this.shouldRun(t2)) continue;
            return;
        }
        throw new NoTestsRemainException();
    }

    @Override
    public void sort(Sorter sorter) {
        this.fSorter = sorter;
    }

    private void validate() {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        this.collectInitializationErrors(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InitializationError(arrayList);
        }
    }

    protected List<T> getFilteredChildren() {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (T t2 : this.getChildren()) {
            if (!this.shouldRun(t2)) continue;
            try {
                this.filterChild(t2);
                this.sortChild(t2);
                arrayList.add(t2);
            }
            catch (NoTestsRemainException noTestsRemainException) {}
        }
        Collections.sort(arrayList, this.comparator());
        return arrayList;
    }

    private void sortChild(T t2) {
        this.fSorter.apply(t2);
    }

    private void filterChild(T t2) {
        if (this.fFilter != null) {
            this.fFilter.apply(t2);
        }
    }

    private boolean shouldRun(T t2) {
        return this.fFilter == null || this.fFilter.shouldRun(this.describeChild(t2));
    }

    private Comparator<? super T> comparator() {
        return new bzc(this);
    }

    public static /* synthetic */ void access$000(ParentRunner parentRunner, RunNotifier runNotifier) {
        parentRunner.runChildren(runNotifier);
    }

    public static /* synthetic */ Sorter access$100(ParentRunner parentRunner) {
        return parentRunner.fSorter;
    }
}

