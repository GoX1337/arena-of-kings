/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal;

import java.lang.reflect.Array;
import org.junit.Assert;
import org.junit.internal.ArrayComparisonFailure;

public class InexactComparisonCriteria {
    public double fDelta;

    public InexactComparisonCriteria(double d2) {
        this.fDelta = d2;
    }

    public void internalArrayEquals(String string, Object object, Object object2) {
        if (object == object2) {
            return;
        }
        String string2 = string == null ? "" : string + ": ";
        int n2 = Assert.assertArraysAreSameLength(object, object2, string2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object3 = Array.get(object, i2);
            Object object4 = Array.get(object2, i2);
            if (Assert.isArray(object3) && Assert.isArray(object4)) {
                try {
                    this.internalArrayEquals(string, object3, object4);
                    continue;
                }
                catch (ArrayComparisonFailure arrayComparisonFailure) {
                    arrayComparisonFailure.addDimension(i2);
                    throw arrayComparisonFailure;
                }
            }
            try {
                if (object3 instanceof Double) {
                    Assert.assertEquals((Double)object3, (double)((Double)object4), this.fDelta);
                    continue;
                }
                Assert.assertEquals(((Float)object3).floatValue(), (double)((Float)object4).floatValue(), this.fDelta);
                continue;
            }
            catch (AssertionError assertionError) {
                throw new ArrayComparisonFailure(string2, assertionError, i2);
            }
        }
    }
}

