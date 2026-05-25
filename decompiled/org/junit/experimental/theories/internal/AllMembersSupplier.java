/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AllMembersSupplier
extends ParameterSupplier {
    private final TestClass fClass;

    public AllMembersSupplier(TestClass testClass) {
        this.fClass = testClass;
    }

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        ArrayList<PotentialAssignment> arrayList = new ArrayList<PotentialAssignment>();
        this.addFields(parameterSignature, arrayList);
        this.addSinglePointMethods(parameterSignature, arrayList);
        this.addMultiPointMethods(arrayList);
        return arrayList;
    }

    private void addMultiPointMethods(List<PotentialAssignment> list) {
        for (FrameworkMethod frameworkMethod : this.fClass.getAnnotatedMethods(DataPoints.class)) {
            try {
                this.addArrayValues(frameworkMethod.getName(), list, frameworkMethod.invokeExplosively(null, new Object[0]));
            }
            catch (Throwable throwable) {}
        }
    }

    private void addSinglePointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (FrameworkMethod frameworkMethod : this.fClass.getAnnotatedMethods(DataPoint.class)) {
            Class<?> clazz;
            if (!frameworkMethod.producesType(clazz = parameterSignature.getType())) continue;
            list.add(new a(frameworkMethod));
        }
    }

    private void addFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field field : this.fClass.getJavaClass().getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) continue;
            Class<?> clazz = field.getType();
            if (parameterSignature.canAcceptArrayType(clazz) && field.getAnnotation(DataPoints.class) != null) {
                this.addArrayValues(field.getName(), list, this.getStaticFieldValue(field));
                continue;
            }
            if (!parameterSignature.canAcceptType(clazz) || field.getAnnotation(DataPoint.class) == null) continue;
            list.add(PotentialAssignment.forValue(field.getName(), this.getStaticFieldValue(field)));
        }
    }

    private void addArrayValues(String string, List<PotentialAssignment> list, Object object) {
        for (int i2 = 0; i2 < Array.getLength(object); ++i2) {
            list.add(PotentialAssignment.forValue(string + "[" + i2 + "]", Array.get(object, i2)));
        }
    }

    private Object getStaticFieldValue(Field field) {
        try {
            return field.get(null);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        }
    }

    static class a
    extends PotentialAssignment {
        private final FrameworkMethod a;

        private a(FrameworkMethod frameworkMethod) {
            this.a = frameworkMethod;
        }

        public Object getValue() {
            try {
                return this.a.invokeExplosively(null, new Object[0]);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new RuntimeException("unexpected: argument length is checked");
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            }
            catch (Throwable throwable) {
                throw new PotentialAssignment.CouldNotGenerateValueException();
            }
        }

        public String getDescription() {
            return this.a.getName();
        }
    }
}

