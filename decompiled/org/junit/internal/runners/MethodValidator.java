/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.TestClass;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class MethodValidator {
    private final List<Throwable> fErrors = new ArrayList<Throwable>();
    private TestClass fTestClass;

    public MethodValidator(TestClass testClass) {
        this.fTestClass = testClass;
    }

    public void validateInstanceMethods() {
        this.validateTestMethods(After.class, false);
        this.validateTestMethods(Before.class, false);
        this.validateTestMethods(Test.class, false);
        List<Method> list = this.fTestClass.getAnnotatedMethods(Test.class);
        if (list.size() == 0) {
            this.fErrors.add(new Exception("No runnable methods"));
        }
    }

    public void validateStaticMethods() {
        this.validateTestMethods(BeforeClass.class, true);
        this.validateTestMethods(AfterClass.class, true);
    }

    public List<Throwable> validateMethodsForDefaultRunner() {
        this.validateNoArgConstructor();
        this.validateStaticMethods();
        this.validateInstanceMethods();
        return this.fErrors;
    }

    public void assertValid() {
        if (!this.fErrors.isEmpty()) {
            throw new InitializationError(this.fErrors);
        }
    }

    public void validateNoArgConstructor() {
        try {
            this.fTestClass.getConstructor();
        }
        catch (Exception exception) {
            this.fErrors.add(new Exception("Test class should have public zero-argument constructor", exception));
        }
    }

    private void validateTestMethods(Class<? extends Annotation> clazz, boolean bl2) {
        List<Method> list = this.fTestClass.getAnnotatedMethods(clazz);
        for (Method method : list) {
            if (Modifier.isStatic(method.getModifiers()) != bl2) {
                String string = bl2 ? "should" : "should not";
                this.fErrors.add(new Exception("Method " + method.getName() + "() " + string + " be static"));
            }
            if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                this.fErrors.add(new Exception("Class " + method.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                this.fErrors.add(new Exception("Method " + method.getName() + " should be public"));
            }
            if (method.getReturnType() != Void.TYPE) {
                this.fErrors.add(new Exception("Method " + method.getName() + " should be void"));
            }
            if (method.getParameterTypes().length == 0) continue;
            this.fErrors.add(new Exception("Method " + method.getName() + " should have no parameters"));
        }
    }
}

