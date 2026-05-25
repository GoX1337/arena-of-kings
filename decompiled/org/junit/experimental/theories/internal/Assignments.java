/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.internal.AllMembersSupplier;
import org.junit.runners.model.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Assignments {
    private List<PotentialAssignment> fAssigned;
    private final List<ParameterSignature> fUnassigned;
    private final TestClass fClass;

    public Assignments(List<PotentialAssignment> list, List<ParameterSignature> list2, TestClass testClass) {
        this.fUnassigned = list2;
        this.fAssigned = list;
        this.fClass = testClass;
    }

    public static Assignments allUnassigned(Method method, TestClass testClass) {
        List<ParameterSignature> list = ParameterSignature.signatures(testClass.getOnlyConstructor());
        list.addAll(ParameterSignature.signatures(method));
        return new Assignments(new ArrayList<PotentialAssignment>(), list, testClass);
    }

    public boolean isComplete() {
        return this.fUnassigned.size() == 0;
    }

    public ParameterSignature nextUnassigned() {
        return this.fUnassigned.get(0);
    }

    public Assignments assignNext(PotentialAssignment potentialAssignment) {
        ArrayList<PotentialAssignment> arrayList = new ArrayList<PotentialAssignment>(this.fAssigned);
        arrayList.add(potentialAssignment);
        return new Assignments(arrayList, this.fUnassigned.subList(1, this.fUnassigned.size()), this.fClass);
    }

    public Object[] getActualValues(int n2, int n3, boolean bl2) {
        Object[] objectArray = new Object[n3 - n2];
        for (int i2 = n2; i2 < n3; ++i2) {
            Object object = this.fAssigned.get(i2).getValue();
            if (object == null && !bl2) {
                throw new PotentialAssignment.CouldNotGenerateValueException();
            }
            objectArray[i2 - n2] = object;
        }
        return objectArray;
    }

    public List<PotentialAssignment> potentialsForNextUnassigned() {
        ParameterSignature parameterSignature = this.nextUnassigned();
        return this.getSupplier(parameterSignature).getValueSources(parameterSignature);
    }

    public ParameterSupplier getSupplier(ParameterSignature parameterSignature) {
        ParameterSupplier parameterSupplier = this.getAnnotatedSupplier(parameterSignature);
        if (parameterSupplier != null) {
            return parameterSupplier;
        }
        return new AllMembersSupplier(this.fClass);
    }

    public ParameterSupplier getAnnotatedSupplier(ParameterSignature parameterSignature) {
        ParametersSuppliedBy parametersSuppliedBy = parameterSignature.findDeepAnnotation(ParametersSuppliedBy.class);
        if (parametersSuppliedBy == null) {
            return null;
        }
        return parametersSuppliedBy.value().newInstance();
    }

    public Object[] getConstructorArguments(boolean bl2) {
        return this.getActualValues(0, this.getConstructorParameterCount(), bl2);
    }

    public Object[] getMethodArguments(boolean bl2) {
        return this.getActualValues(this.getConstructorParameterCount(), this.fAssigned.size(), bl2);
    }

    public Object[] getAllArguments(boolean bl2) {
        return this.getActualValues(0, this.fAssigned.size(), bl2);
    }

    private int getConstructorParameterCount() {
        List<ParameterSignature> list = ParameterSignature.signatures(this.fClass.getOnlyConstructor());
        int n2 = list.size();
        return n2;
    }

    public Object[] getArgumentStrings(boolean bl2) {
        Object[] objectArray = new Object[this.fAssigned.size()];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2] = this.fAssigned.get(i2).getDescription();
        }
        return objectArray;
    }
}

