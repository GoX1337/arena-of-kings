/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.android;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.STANDARD)
public class Android10Instantiator<T>
implements ObjectInstantiator<T> {
    private final Class<T> type;
    private final Method newStaticMethod;

    public Android10Instantiator(Class<T> clazz) {
        this.type = clazz;
        this.newStaticMethod = Android10Instantiator.getNewStaticMethod();
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(this.newStaticMethod.invoke(null, this.type, Object.class));
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Method getNewStaticMethod() {
        try {
            Method method = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException | RuntimeException exception) {
            throw new ObjenesisException(exception);
        }
    }
}

