/*
 * Decompiled with CFR 0.152.
 */
package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FrameworkMethod {
    private final Method fMethod;

    public FrameworkMethod(Method method) {
        this.fMethod = method;
    }

    public Method getMethod() {
        return this.fMethod;
    }

    public Object invokeExplosively(Object object, Object ... objectArray) {
        return new bzd(this, object, objectArray).run();
    }

    public String getName() {
        return this.fMethod.getName();
    }

    public void validatePublicVoidNoArg(boolean bl2, List<Throwable> list) {
        this.validatePublicVoid(bl2, list);
        if (this.fMethod.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.fMethod.getName() + " should have no parameters"));
        }
    }

    public void validatePublicVoid(boolean bl2, List<Throwable> list) {
        if (Modifier.isStatic(this.fMethod.getModifiers()) != bl2) {
            String string = bl2 ? "should" : "should not";
            list.add(new Exception("Method " + this.fMethod.getName() + "() " + string + " be static"));
        }
        if (!Modifier.isPublic(this.fMethod.getDeclaringClass().getModifiers())) {
            list.add(new Exception("Class " + this.fMethod.getDeclaringClass().getName() + " should be public"));
        }
        if (!Modifier.isPublic(this.fMethod.getModifiers())) {
            list.add(new Exception("Method " + this.fMethod.getName() + "() should be public"));
        }
        if (this.fMethod.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.fMethod.getName() + "() should be void"));
        }
    }

    boolean isShadowedBy(List<FrameworkMethod> list) {
        for (FrameworkMethod frameworkMethod : list) {
            if (!this.isShadowedBy(frameworkMethod)) continue;
            return true;
        }
        return false;
    }

    private boolean isShadowedBy(FrameworkMethod frameworkMethod) {
        if (!frameworkMethod.getName().equals(this.getName())) {
            return false;
        }
        if (frameworkMethod.getParameterTypes().length != this.getParameterTypes().length) {
            return false;
        }
        for (int i2 = 0; i2 < frameworkMethod.getParameterTypes().length; ++i2) {
            if (frameworkMethod.getParameterTypes()[i2].equals(this.getParameterTypes()[i2])) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        if (!FrameworkMethod.class.isInstance(object)) {
            return false;
        }
        return ((FrameworkMethod)object).fMethod.equals(this.fMethod);
    }

    public int hashCode() {
        return this.fMethod.hashCode();
    }

    public boolean producesType(Class<?> clazz) {
        return this.getParameterTypes().length == 0 && clazz.isAssignableFrom(this.fMethod.getReturnType());
    }

    private Class<?>[] getParameterTypes() {
        return this.fMethod.getParameterTypes();
    }

    public Annotation[] getAnnotations() {
        return this.fMethod.getAnnotations();
    }

    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        return this.fMethod.getAnnotation(clazz);
    }

    public static /* synthetic */ Method access$000(FrameworkMethod frameworkMethod) {
        return frameworkMethod.fMethod;
    }
}

