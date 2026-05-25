/*
 * Decompiled with CFR 0.152.
 */
package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ParameterSignature {
    private final Class<?> type;
    private final Annotation[] annotations;

    public static ArrayList<ParameterSignature> signatures(Method method) {
        return ParameterSignature.signatures(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public static List<ParameterSignature> signatures(Constructor<?> constructor) {
        return ParameterSignature.signatures(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    private static ArrayList<ParameterSignature> signatures(Class<?>[] classArray, Annotation[][] annotationArray) {
        ArrayList<ParameterSignature> arrayList = new ArrayList<ParameterSignature>();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            arrayList.add(new ParameterSignature(classArray[i2], annotationArray[i2]));
        }
        return arrayList;
    }

    private ParameterSignature(Class<?> clazz, Annotation[] annotationArray) {
        this.type = clazz;
        this.annotations = annotationArray;
    }

    public boolean canAcceptType(Class<?> clazz) {
        return this.type.isAssignableFrom(clazz);
    }

    public Class<?> getType() {
        return this.type;
    }

    public List<Annotation> getAnnotations() {
        return Arrays.asList(this.annotations);
    }

    public boolean canAcceptArrayType(Class<?> clazz) {
        return clazz.isArray() && this.canAcceptType(clazz.getComponentType());
    }

    public boolean hasAnnotation(Class<? extends Annotation> clazz) {
        return this.getAnnotation(clazz) != null;
    }

    public <T extends Annotation> T findDeepAnnotation(Class<T> clazz) {
        Annotation[] annotationArray = this.annotations;
        return this.findDeepAnnotation(annotationArray, clazz, 3);
    }

    private <T extends Annotation> T findDeepAnnotation(Annotation[] annotationArray, Class<T> clazz, int n2) {
        if (n2 == 0) {
            return null;
        }
        for (Annotation annotation : annotationArray) {
            if (clazz.isInstance(annotation)) {
                return (T)((Annotation)clazz.cast(annotation));
            }
            T t2 = this.findDeepAnnotation(annotation.annotationType().getAnnotations(), clazz, n2 - 1);
            if (t2 == null) continue;
            return (T)((Annotation)clazz.cast(t2));
        }
        return null;
    }

    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        for (Annotation annotation : this.getAnnotations()) {
            if (!clazz.isInstance(annotation)) continue;
            return (T)((Annotation)clazz.cast(annotation));
        }
        return null;
    }
}

