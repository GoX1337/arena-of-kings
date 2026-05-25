/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.STANDARD)
public class Android17Instantiator<T>
implements ObjectInstantiator<T> {
    private final Class<T> type;
    private final Method newInstanceMethod;
    private final Integer objectConstructorId;

    public Android17Instantiator(Class<T> clazz) {
        this.type = clazz;
        this.newInstanceMethod = Android17Instantiator.getNewInstanceMethod();
        this.objectConstructorId = Android17Instantiator.findConstructorIdForJavaLangObjectConstructor();
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(this.newInstanceMethod.invoke(null, this.type, this.objectConstructorId));
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Method getNewInstanceMethod() {
        try {
            Method method = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException | RuntimeException exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Integer findConstructorIdForJavaLangObjectConstructor() {
        try {
            Method method = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            method.setAccessible(true);
            return (Integer)method.invoke(null, Object.class);
        }
        catch (IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException exception) {
            throw new ObjenesisException(exception);
        }
    }
}

