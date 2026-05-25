/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.gcj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public abstract class GCJInstantiatorBase<T>
implements ObjectInstantiator<T> {
    static Method newObjectMethod = null;
    static ObjectInputStream dummyStream;
    protected final Class<T> type;

    private static void initialize() {
        if (newObjectMethod == null) {
            try {
                newObjectMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                newObjectMethod.setAccessible(true);
                dummyStream = new a();
            }
            catch (IOException | NoSuchMethodException | RuntimeException exception) {
                throw new ObjenesisException(exception);
            }
        }
    }

    public GCJInstantiatorBase(Class<T> clazz) {
        this.type = clazz;
        GCJInstantiatorBase.initialize();
    }

    @Override
    public abstract T newInstance();

    static class a
    extends ObjectInputStream {
    }
}

