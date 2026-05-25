/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.internal.runners.JUnit38ClassRunner;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SuiteMethod
extends JUnit38ClassRunner {
    public SuiteMethod(Class<?> clazz) {
        super(SuiteMethod.testFromSuiteMethod(clazz));
    }

    public static bxh testFromSuiteMethod(Class<?> clazz) {
        Method method = null;
        bxh bxh2 = null;
        try {
            method = clazz.getMethod("suite", new Class[0]);
            if (!Modifier.isStatic(method.getModifiers())) {
                throw new Exception(clazz.getName() + ".suite() must be static");
            }
            bxh2 = (bxh)method.invoke(null, new Object[0]);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getCause();
        }
        return bxh2;
    }
}

