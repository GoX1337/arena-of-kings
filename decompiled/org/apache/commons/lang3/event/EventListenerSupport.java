/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

public class EventListenerSupport<L>
implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    private List<L> listeners = new CopyOnWriteArrayList<L>();
    private transient L proxy;
    private transient L[] prototypeArray;

    public static <T> EventListenerSupport<T> create(Class<T> clazz) {
        return new EventListenerSupport<T>(clazz);
    }

    public EventListenerSupport(Class<L> clazz) {
        this(clazz, Thread.currentThread().getContextClassLoader());
    }

    public EventListenerSupport(Class<L> clazz, ClassLoader classLoader) {
        this();
        Validate.notNull(clazz, "listenerInterface", new Object[0]);
        Validate.notNull(classLoader, "classLoader", new Object[0]);
        Validate.isTrue(clazz.isInterface(), "Class %s is not an interface", clazz.getName());
        super.initializeTransientFields(clazz, classLoader);
    }

    private EventListenerSupport() {
    }

    public L fire() {
        return this.proxy;
    }

    public void addListener(L l2) {
        this.addListener(l2, true);
    }

    public void addListener(L l2, boolean bl2) {
        Validate.notNull(l2, "listener", new Object[0]);
        if (bl2 || !this.listeners.contains(l2)) {
            this.listeners.add(l2);
        }
    }

    int getListenerCount() {
        return this.listeners.size();
    }

    public void removeListener(L l2) {
        Validate.notNull(l2, "listener", new Object[0]);
        this.listeners.remove(l2);
    }

    public L[] getListeners() {
        return this.listeners.toArray(this.prototypeArray);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ArrayList<L> arrayList = new ArrayList<L>();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L l2 : this.listeners) {
            try {
                objectOutputStream2.writeObject(l2);
                arrayList.add(l2);
            }
            catch (IOException iOException) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object[] objectArray = (Object[])objectInputStream.readObject();
        this.listeners = new CopyOnWriteArrayList<Object>(objectArray);
        Class<?> clazz = objectArray.getClass().getComponentType();
        this.initializeTransientFields(clazz, Thread.currentThread().getContextClassLoader());
    }

    private void initializeTransientFields(Class<L> clazz, ClassLoader classLoader) {
        Object[] objectArray = (Object[])Array.newInstance(clazz, 0);
        this.prototypeArray = objectArray;
        this.createProxy(clazz, classLoader);
    }

    private void createProxy(Class<L> clazz, ClassLoader classLoader) {
        this.proxy = clazz.cast(Proxy.newProxyInstance(classLoader, new Class[]{clazz}, this.createInvocationHandler()));
    }

    protected InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler();
    }

    protected class ProxyInvocationHandler
    implements InvocationHandler {
        protected ProxyInvocationHandler() {
        }

        @Override
        public Object invoke(Object object, Method method, Object[] objectArray) {
            for (Object e2 : EventListenerSupport.this.listeners) {
                method.invoke(e2, objectArray);
            }
            return null;
        }
    }
}

