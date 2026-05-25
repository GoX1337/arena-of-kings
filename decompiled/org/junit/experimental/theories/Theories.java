/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Theories
extends BlockJUnit4ClassRunner {
    public Theories(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        this.validateDataPointFields(list);
    }

    private void validateDataPointFields(List<Throwable> list) {
        Field[] fieldArray;
        for (Field field : fieldArray = this.getTestClass().getJavaClass().getDeclaredFields()) {
            if (field.getAnnotation(DataPoint.class) == null || Modifier.isStatic(field.getModifiers())) continue;
            list.add(new Error("DataPoint field " + field.getName() + " must be static"));
        }
    }

    @Override
    public void validateZeroArgConstructor(List<Throwable> list) {
    }

    @Override
    public void validateTestMethods(List<Throwable> list) {
        for (FrameworkMethod frameworkMethod : this.computeTestMethods()) {
            if (frameworkMethod.getAnnotation(Theory.class) != null) {
                frameworkMethod.validatePublicVoid(false, list);
                continue;
            }
            frameworkMethod.validatePublicVoidNoArg(false, list);
        }
    }

    @Override
    public List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        List<FrameworkMethod> list2 = this.getTestClass().getAnnotatedMethods(Theory.class);
        list.removeAll(list2);
        list.addAll(list2);
        return list;
    }

    @Override
    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        return new TheoryAnchor(frameworkMethod);
    }

    public class TheoryAnchor
    extends Statement {
        private int successes = 0;
        private FrameworkMethod fTestMethod;
        private List<AssumptionViolatedException> fInvalidParameters = new ArrayList<AssumptionViolatedException>();

        public TheoryAnchor(FrameworkMethod frameworkMethod) {
            this.fTestMethod = frameworkMethod;
        }

        public void evaluate() {
            this.runWithAssignment(Assignments.allUnassigned(this.fTestMethod.getMethod(), Theories.this.getTestClass()));
            if (this.successes == 0) {
                Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
            }
        }

        protected void runWithAssignment(Assignments assignments) {
            if (!assignments.isComplete()) {
                this.runWithIncompleteAssignment(assignments);
            } else {
                this.runWithCompleteAssignment(assignments);
            }
        }

        protected void runWithIncompleteAssignment(Assignments assignments) {
            for (PotentialAssignment potentialAssignment : assignments.potentialsForNextUnassigned()) {
                this.runWithAssignment(assignments.assignNext(potentialAssignment));
            }
        }

        protected void runWithCompleteAssignment(Assignments assignments) {
            new byd(this, Theories.this.getTestClass().getJavaClass(), assignments).methodBlock(this.fTestMethod).evaluate();
        }

        private Statement methodCompletesWithParameters(FrameworkMethod frameworkMethod, Assignments assignments, Object object) {
            return new byf(this, assignments, frameworkMethod, object);
        }

        public void handleAssumptionViolation(AssumptionViolatedException assumptionViolatedException) {
            this.fInvalidParameters.add(assumptionViolatedException);
        }

        public void reportParameterizedError(Throwable throwable, Object ... objectArray) {
            if (objectArray.length == 0) {
                throw throwable;
            }
            throw new ParameterizedAssertionError(throwable, this.fTestMethod.getName(), objectArray);
        }

        private boolean nullsOk() {
            Theory theory = this.fTestMethod.getMethod().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        public void handleDataPointSuccess() {
            ++this.successes;
        }

        public static /* synthetic */ boolean access$200(TheoryAnchor theoryAnchor) {
            return theoryAnchor.nullsOk();
        }

        public static /* synthetic */ Statement access$300(TheoryAnchor theoryAnchor, FrameworkMethod frameworkMethod, Assignments assignments, Object object) {
            return theoryAnchor.methodCompletesWithParameters(frameworkMethod, assignments, object);
        }
    }
}

