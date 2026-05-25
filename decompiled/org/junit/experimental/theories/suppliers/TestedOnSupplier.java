/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories.suppliers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.suppliers.TestedOn;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TestedOnSupplier
extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        int[] nArray;
        ArrayList<PotentialAssignment> arrayList = new ArrayList<PotentialAssignment>();
        TestedOn testedOn = parameterSignature.getAnnotation(TestedOn.class);
        for (int n2 : nArray = testedOn.ints()) {
            arrayList.add(PotentialAssignment.forValue(Arrays.asList(new int[][]{nArray}).toString(), n2));
        }
        return arrayList;
    }
}

