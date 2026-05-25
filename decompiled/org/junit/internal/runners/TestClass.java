/*
 * Decompiled with CFR 0.152.
 */
package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public class TestClass {
    private final Class<?> fClass;

    public TestClass(Class<?> clazz) {
        this.fClass = clazz;
    }

    public List<Method> getTestMethods() {
        return this.getAnnotatedMethods(Test.class);
    }

    List<Method> getBefores() {
        return this.getAnnotatedMethods(BeforeClass.class);
    }

    List<Method> getAfters() {
        return this.getAnnotatedMethods(AfterClass.class);
    }

    public List<Method> getAnnotatedMethods(Class<? extends Annotation> clazz) {
        ArrayList<Method> arrayList = new ArrayList<Method>();
        for (Class<?> clazz2 : this.getSuperClasses(this.fClass)) {
            Method[] methodArray;
            for (Method method : methodArray = clazz2.getDeclaredMethods()) {
                Annotation annotation = method.getAnnotation(clazz);
                if (annotation == null || this.isShadowed(method, arrayList)) continue;
                arrayList.add(method);
            }
        }
        if (this.runsTopToBottom(clazz)) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    private boolean runsTopToBottom(Class<? extends Annotation> clazz) {
        return clazz.equals(Before.class) || clazz.equals(BeforeClass.class);
    }

    private boolean isShadowed(Method method, List<Method> list) {
        for (Method method2 : list) {
            if (!this.isShadowed(method, method2)) continue;
            return true;
        }
        return false;
    }

    private boolean isShadowed(Method method, Method method2) {
        if (!method2.getName().equals(method.getName())) {
            return false;
        }
        if (method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i2 = 0; i2 < method2.getParameterTypes().length; ++i2) {
            if (method2.getParameterTypes()[i2].equals(method.getParameterTypes()[i2])) continue;
            return false;
        }
        return true;
    }

    private List<Class<?>> getSuperClasses(Class<?> clazz) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            arrayList.add(clazz2);
        }
        return arrayList;
    }

    public Constructor<?> getConstructor() {
        return this.fClass.getConstructor(new Class[0]);
    }

    public Class<?> getJavaClass() {
        return this.fClass;
    }

    public String getName() {
        return this.fClass.getName();
    }
}

