/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.basic;

import java.io.ObjectStreamClass;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.SERIALIZATION)
public class ObjectStreamClassInstantiator<T>
implements ObjectInstantiator<T> {
    private static Method newInstanceMethod;
    private final ObjectStreamClass objStreamClass;

    private static void initialize() {
        if (newInstanceMethod == null) {
            try {
                newInstanceMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[0]);
                newInstanceMethod.setAccessible(true);
            }
            catch (NoSuchMethodException | RuntimeException exception) {
                throw new ObjenesisException(exception);
            }
        }
    }

    public ObjectStreamClassInstantiator(Class<T> clazz) {
        ObjectStreamClassInstantiator.initialize();
        this.objStreamClass = ObjectStreamClass.lookup(clazz);
    }

    @Override
    public T newInstance() {
        try {
            return (T)newInstanceMethod.invoke((Object)this.objStreamClass, new Object[0]);
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }
}

