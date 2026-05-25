/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.model.FrameworkMethod;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TestClass {
    private final Class<?> fClass;
    private Map<Class<?>, List<FrameworkMethod>> fMethodsForAnnotations = new HashMap();

    public TestClass(Class<?> clazz) {
        this.fClass = clazz;
        if (clazz != null && clazz.getConstructors().length > 1) {
            throw new IllegalArgumentException("Test class can only have one constructor");
        }
        for (Class<?> clazz2 : this.getSuperClasses(this.fClass)) {
            for (Method method : clazz2.getDeclaredMethods()) {
                this.addToAnnotationLists(new FrameworkMethod(method));
            }
        }
    }

    private void addToAnnotationLists(FrameworkMethod frameworkMethod) {
        for (Annotation annotation : this.computeAnnotations(frameworkMethod)) {
            this.addToAnnotationList(annotation.annotationType(), frameworkMethod);
        }
    }

    protected Annotation[] computeAnnotations(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotations();
    }

    private void addToAnnotationList(Class<? extends Annotation> clazz, FrameworkMethod frameworkMethod) {
        List<FrameworkMethod> list = this.getAnnotatedMethods(clazz);
        if (frameworkMethod.isShadowedBy(list)) {
            return;
        }
        if (this.runsTopToBottom(clazz)) {
            list.add(0, frameworkMethod);
        } else {
            list.add(frameworkMethod);
        }
    }

    private void ensureKey(Class<? extends Annotation> clazz) {
        if (!this.fMethodsForAnnotations.containsKey(clazz)) {
            this.fMethodsForAnnotations.put(clazz, new ArrayList());
        }
    }

    public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> clazz) {
        this.ensureKey(clazz);
        return this.fMethodsForAnnotations.get(clazz);
    }

    private boolean runsTopToBottom(Class<? extends Annotation> clazz) {
        return clazz.equals(Before.class) || clazz.equals(BeforeClass.class);
    }

    private List<Class<?>> getSuperClasses(Class<?> clazz) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            arrayList.add(clazz2);
        }
        return arrayList;
    }

    public Class<?> getJavaClass() {
        return this.fClass;
    }

    public String getName() {
        if (this.fClass == null) {
            return "null";
        }
        return this.fClass.getName();
    }

    public Constructor<?> getOnlyConstructor() {
        Constructor<?>[] constructorArray = this.fClass.getConstructors();
        Assert.assertEquals(1L, constructorArray.length);
        return constructorArray[0];
    }

    public Annotation[] getAnnotations() {
        if (this.fClass == null) {
            return new Annotation[0];
        }
        return this.fClass.getAnnotations();
    }
}

