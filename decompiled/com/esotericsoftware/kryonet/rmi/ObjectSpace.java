/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.rmi;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.IntMap;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.rmi.RemoteObject;
import com.esotericsoftware.kryonet.rmi.TimeoutException;
import com.esotericsoftware.kryonet.util.ObjectIntMap;
import com.esotericsoftware.minlog.Log;
import com.esotericsoftware.reflectasm.MethodAccess;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectSpace {
    private static final int returnValueMask = 128;
    private static final int returnExceptionMask = 64;
    private static final int responseIdMask = 63;
    private static final Object instancesLock = new Object();
    static ObjectSpace[] instances = new ObjectSpace[0];
    private static final HashMap<Class<?>, CachedMethod[]> methodCache = new HashMap();
    private static boolean useAsm = true;
    final IntMap<Object> idToObject = new IntMap();
    final ObjectIntMap<Object> objectToID = new ObjectIntMap();
    Connection[] connections = new Connection[0];
    final Object connectionsLock = new Object();
    Executor executor;
    private final Listener invokeListener = new Listener(){

        @Override
        public void received(final Connection connection, Object object) {
            if (!(object instanceof InvokeMethod)) {
                return;
            }
            if (ObjectSpace.this.connections != null) {
                int n2;
                int n3 = ObjectSpace.this.connections.length;
                for (n2 = 0; n2 < n3 && connection != ObjectSpace.this.connections[n2]; ++n2) {
                }
                if (n2 == n3) {
                    return;
                }
            }
            final InvokeMethod invokeMethod = (InvokeMethod)object;
            final Object object2 = ObjectSpace.this.idToObject.get(invokeMethod.objectID);
            if (object2 == null) {
                if (Log.WARN) {
                    Log.warn("kryonet", "Ignoring remote invocation request for unknown object ID: " + invokeMethod.objectID);
                }
                return;
            }
            if (ObjectSpace.this.executor == null) {
                ObjectSpace.this.invoke(connection, object2, invokeMethod);
            } else {
                ObjectSpace.this.executor.execute(new Runnable(){

                    @Override
                    public void run() {
                        ObjectSpace.this.invoke(connection, object2, invokeMethod);
                    }
                });
            }
        }

        @Override
        public void disconnected(Connection connection) {
            ObjectSpace.this.removeConnection(connection);
        }
    };

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ObjectSpace() {
        Object object = instancesLock;
        synchronized (object) {
            ObjectSpace[] objectSpaceArray = instances;
            ObjectSpace[] objectSpaceArray2 = new ObjectSpace[objectSpaceArray.length + 1];
            objectSpaceArray2[0] = this;
            System.arraycopy(objectSpaceArray, 0, objectSpaceArray2, 1, objectSpaceArray.length);
            instances = objectSpaceArray2;
        }
    }

    public ObjectSpace(Connection connection) {
        this();
        this.addConnection(connection);
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public void register(int n2, Object object) {
        if (n2 == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("objectID cannot be Integer.MAX_VALUE.");
        }
        if (object == null) {
            throw new NullPointerException("object to register cannot be null.");
        }
        this.idToObject.put(n2, object);
        this.objectToID.put(object, n2);
        if (Log.TRACE) {
            Log.trace("kryonet", "Object registered with ObjectSpace as " + n2 + ": " + object);
        }
    }

    public void remove(int n2) {
        Object object = this.idToObject.remove(n2);
        if (object != null) {
            this.objectToID.remove(object, 0);
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Object " + n2 + " removed from ObjectSpace: " + object);
        }
    }

    public void remove(Object object) {
        if (!this.idToObject.containsValue(object, true)) {
            return;
        }
        int n2 = this.idToObject.findKey(object, true, -1);
        this.idToObject.remove(n2);
        this.objectToID.remove(object, 0);
        if (Log.TRACE) {
            Log.trace("kryonet", "Object " + n2 + " removed from ObjectSpace: " + object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        Connection[] connectionArray = this.connections;
        for (int i2 = 0; i2 < connectionArray.length; ++i2) {
            connectionArray[i2].removeListener(this.invokeListener);
        }
        Object object = instancesLock;
        synchronized (object) {
            ArrayList<ObjectSpace> arrayList = new ArrayList<ObjectSpace>(Arrays.asList(instances));
            arrayList.remove(this);
            instances = arrayList.toArray(new ObjectSpace[arrayList.size()]);
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Closed ObjectSpace.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addConnection(Connection connection) {
        if (connection == null) {
            throw new NullPointerException("connection cannot be null.");
        }
        Object object = this.connectionsLock;
        synchronized (object) {
            Connection[] connectionArray = new Connection[this.connections.length + 1];
            connectionArray[0] = connection;
            System.arraycopy(this.connections, 0, connectionArray, 1, this.connections.length);
            this.connections = connectionArray;
        }
        connection.addListener(this.invokeListener);
        if (Log.TRACE) {
            Log.trace("kryonet", "Added connection to ObjectSpace: " + connection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeConnection(Connection connection) {
        if (connection == null) {
            throw new NullPointerException("connection cannot be null.");
        }
        connection.removeListener(this.invokeListener);
        Object object = this.connectionsLock;
        synchronized (object) {
            ArrayList<Connection> arrayList = new ArrayList<Connection>(Arrays.asList(this.connections));
            arrayList.remove(connection);
            this.connections = arrayList.toArray(new Connection[arrayList.size()]);
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Removed connection from ObjectSpace: " + connection);
        }
    }

    protected void invoke(Connection connection, Object object, InvokeMethod invokeMethod) {
        byte by2;
        if (Log.DEBUG) {
            String string = "";
            if (invokeMethod.args != null) {
                string = Arrays.deepToString(invokeMethod.args);
                string = string.substring(1, string.length() - 1);
            }
            Log.debug("kryonet", connection + " received: " + object.getClass().getSimpleName() + "#" + invokeMethod.cachedMethod.method.getName() + "(" + string + ")");
        }
        boolean bl2 = ((by2 = invokeMethod.responseData) & 0x80) == 128;
        boolean bl3 = (by2 & 0x40) == 64;
        int n2 = by2 & 0x3F;
        CachedMethod cachedMethod = invokeMethod.cachedMethod;
        Object object2 = null;
        try {
            object2 = cachedMethod.invoke(object, invokeMethod.args);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (bl3) {
                object2 = invocationTargetException.getCause();
            }
            throw new KryoNetException("Error invoking method: " + cachedMethod.method.getDeclaringClass().getName() + "." + cachedMethod.method.getName(), invocationTargetException);
        }
        catch (Exception exception) {
            throw new KryoNetException("Error invoking method: " + cachedMethod.method.getDeclaringClass().getName() + "." + cachedMethod.method.getName(), exception);
        }
        if (n2 == 0) {
            return;
        }
        InvokeMethodResult invokeMethodResult = new InvokeMethodResult();
        invokeMethodResult.objectID = invokeMethod.objectID;
        invokeMethodResult.responseID = (byte)n2;
        invokeMethodResult.result = !bl2 && !invokeMethod.cachedMethod.method.getReturnType().isPrimitive() ? null : object2;
        int n3 = connection.sendTCP(invokeMethodResult);
        if (Log.DEBUG) {
            Log.debug("kryonet", connection + " sent TCP: " + object2 + " (" + n3 + ")");
        }
    }

    public static <T> T getRemoteObject(Connection connection, int n2, Class<T> clazz) {
        return (T)ObjectSpace.getRemoteObject(connection, n2, new Class[]{clazz});
    }

    public static RemoteObject getRemoteObject(Connection connection, int n2, Class<?> ... classArray) {
        if (connection == null) {
            throw new NullPointerException("connection cannot be null.");
        }
        if (classArray == null) {
            throw new NullPointerException("ifaces cannot be null.");
        }
        Class[] classArray2 = new Class[classArray.length + 1];
        classArray2[0] = RemoteObject.class;
        System.arraycopy(classArray, 0, classArray2, 1, classArray.length);
        return (RemoteObject)Proxy.newProxyInstance(ObjectSpace.class.getClassLoader(), classArray2, (InvocationHandler)new RemoteInvocationHandler(connection, n2));
    }

    static CachedMethod[] getMethods(Kryo kryo, Class<?> clazz) {
        CachedMethod[] cachedMethodArray = methodCache.get(clazz);
        if (cachedMethodArray != null) {
            return cachedMethodArray;
        }
        ArrayList arrayList = new ArrayList();
        Class<?> clazz2 = clazz;
        while (clazz2 != null) {
            Collections.addAll(arrayList, clazz2.getDeclaredMethods());
            if ((clazz2 = clazz2.getSuperclass()) != Object.class) continue;
        }
        ArrayList<Method> arrayList2 = new ArrayList<Method>(Math.max(1, arrayList.size()));
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Method method = (Method)arrayList.get(i2);
            int n3 = method.getModifiers();
            if (Modifier.isStatic(n3) || Modifier.isPrivate(n3) || method.isSynthetic()) continue;
            arrayList2.add(method);
        }
        Collections.sort(arrayList2, new Comparator<Method>(){

            @Override
            public int compare(Method method, Method method2) {
                Class<?>[] classArray;
                int n2 = method.getName().compareTo(method2.getName());
                if (n2 != 0) {
                    return n2;
                }
                Class<?>[] classArray2 = method.getParameterTypes();
                if (classArray2.length > (classArray = method2.getParameterTypes()).length) {
                    return 1;
                }
                if (classArray2.length < classArray.length) {
                    return -1;
                }
                for (int i2 = 0; i2 < classArray2.length; ++i2) {
                    n2 = classArray2[i2].getName().compareTo(classArray[i2].getName());
                    if (n2 == 0) continue;
                    return n2;
                }
                throw new RuntimeException("Two methods with same signature!");
            }
        });
        MethodAccess methodAccess = null;
        if (useAsm && !Util.isAndroid && Modifier.isPublic(clazz.getModifiers())) {
            methodAccess = MethodAccess.get(clazz);
        }
        n2 = arrayList2.size();
        cachedMethodArray = new CachedMethod[n2];
        for (int i3 = 0; i3 < n2; ++i3) {
            Method method = (Method)arrayList2.get(i3);
            Class[] classArray = method.getParameterTypes();
            CachedMethod cachedMethod = null;
            if (methodAccess != null) {
                try {
                    AsmCachedMethod asmCachedMethod = new AsmCachedMethod();
                    asmCachedMethod.methodAccessIndex = methodAccess.getIndex(method.getName(), classArray);
                    asmCachedMethod.methodAccess = methodAccess;
                    cachedMethod = asmCachedMethod;
                }
                catch (RuntimeException runtimeException) {
                    // empty catch block
                }
            }
            if (cachedMethod == null) {
                cachedMethod = new CachedMethod();
            }
            cachedMethod.method = method;
            cachedMethod.methodClassID = kryo.getRegistration(method.getDeclaringClass()).getId();
            cachedMethod.methodIndex = i3;
            cachedMethod.serializers = new Serializer[classArray.length];
            int n4 = classArray.length;
            for (int i4 = 0; i4 < n4; ++i4) {
                if (!kryo.isFinal(classArray[i4])) continue;
                cachedMethod.serializers[i4] = kryo.getSerializer(classArray[i4]);
            }
            cachedMethodArray[i3] = cachedMethod;
        }
        methodCache.put(clazz, cachedMethodArray);
        return cachedMethodArray;
    }

    static Object getRegisteredObject(Connection connection, int n2) {
        for (ObjectSpace objectSpace : instances) {
            Connection[] connectionArray = objectSpace.connections;
            for (int i2 = 0; i2 < connectionArray.length; ++i2) {
                Object object;
                if (connectionArray[i2] != connection || (object = objectSpace.idToObject.get(n2)) == null) continue;
                return object;
            }
        }
        return null;
    }

    static int getRegisteredID(Connection connection, Object object) {
        for (ObjectSpace objectSpace : instances) {
            Connection[] connectionArray = objectSpace.connections;
            for (int i2 = 0; i2 < connectionArray.length; ++i2) {
                int n2;
                if (connectionArray[i2] != connection || (n2 = objectSpace.objectToID.get(object, Integer.MAX_VALUE)) == Integer.MAX_VALUE) continue;
                return n2;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void setAsm(boolean bl2) {
        useAsm = bl2;
    }

    public static class InvokeMethod
    implements KryoSerializable,
    FrameworkMessage {
        public int objectID;
        public CachedMethod cachedMethod;
        public Object[] args;
        public byte responseData;

        @Override
        public void write(Kryo kryo, Output output) {
            output.writeInt(this.objectID, true);
            output.writeInt(this.cachedMethod.methodClassID, true);
            output.writeByte(this.cachedMethod.methodIndex);
            Serializer<?>[] serializerArray = this.cachedMethod.serializers;
            Object[] objectArray = this.args;
            int n2 = serializerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Serializer<?> serializer = serializerArray[i2];
                if (serializer != null) {
                    kryo.writeObjectOrNull(output, objectArray[i2], serializer);
                    continue;
                }
                kryo.writeClassAndObject(output, objectArray[i2]);
            }
            output.writeByte(this.responseData);
        }

        @Override
        public void read(Kryo kryo, Input input) {
            this.objectID = input.readInt(true);
            int n2 = input.readInt(true);
            Class clazz = kryo.getRegistration(n2).getType();
            byte by2 = input.readByte();
            try {
                this.cachedMethod = ObjectSpace.getMethods(kryo, clazz)[by2];
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new KryoException("Invalid method index " + by2 + " for class: " + clazz.getName());
            }
            Serializer<?>[] serializerArray = this.cachedMethod.serializers;
            Class<?>[] classArray = this.cachedMethod.method.getParameterTypes();
            Object[] objectArray = new Object[serializerArray.length];
            this.args = objectArray;
            int n3 = objectArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                Serializer<?> serializer = serializerArray[i2];
                objectArray[i2] = serializer != null ? kryo.readObjectOrNull(input, classArray[i2], serializer) : kryo.readClassAndObject(input);
            }
            this.responseData = input.readByte();
        }
    }

    static class CachedMethod {
        Method method;
        int methodClassID;
        int methodIndex;
        Serializer<?>[] serializers;

        CachedMethod() {
        }

        public Object invoke(Object object, Object[] objectArray) {
            return this.method.invoke(object, objectArray);
        }
    }

    public static class InvokeMethodResult
    implements FrameworkMessage {
        public int objectID;
        public byte responseID;
        public Object result;
    }

    static class RemoteInvocationHandler
    implements InvocationHandler {
        private final Connection connection;
        final int objectID;
        private int timeoutMillis = 3000;
        private boolean nonBlocking;
        private boolean transmitReturnValue = true;
        private boolean transmitExceptions = true;
        private boolean remoteToString;
        private boolean udp;
        private Byte lastResponseID;
        private byte nextResponseId = 1;
        private final Listener responseListener;
        final ReentrantLock lock = new ReentrantLock();
        final Condition responseCondition = this.lock.newCondition();
        final InvokeMethodResult[] responseTable = new InvokeMethodResult[64];
        final boolean[] pendingResponses = new boolean[64];

        public RemoteInvocationHandler(Connection connection, final int n2) {
            this.connection = connection;
            this.objectID = n2;
            this.responseListener = new Listener(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void received(Connection connection, Object object) {
                    if (!(object instanceof InvokeMethodResult)) {
                        return;
                    }
                    InvokeMethodResult invokeMethodResult = (InvokeMethodResult)object;
                    if (invokeMethodResult.objectID != n2) {
                        return;
                    }
                    byte by2 = invokeMethodResult.responseID;
                    _1 var5_5 = this;
                    synchronized (var5_5) {
                        if (pendingResponses[by2]) {
                            responseTable[by2] = invokeMethodResult;
                        }
                    }
                    lock.lock();
                    try {
                        responseCondition.signalAll();
                    }
                    finally {
                        lock.unlock();
                    }
                }

                @Override
                public void disconnected(Connection connection) {
                    this.close();
                }

                @Override
                public void connected(Connection connection) {
                }

                @Override
                public void idle(Connection connection) {
                }
            };
            connection.addListener(this.responseListener);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public Object invoke(Object object, Method method, Object[] objectArray) {
            Class<?> clazz;
            int n2;
            Class<?> clazz2 = method.getDeclaringClass();
            if (clazz2 == RemoteObject.class) {
                String string;
                switch (string = method.getName()) {
                    case "close": {
                        this.close();
                        return null;
                    }
                    case "setResponseTimeout": {
                        this.timeoutMillis = (Integer)objectArray[0];
                        return null;
                    }
                    case "setNonBlocking": {
                        this.nonBlocking = (Boolean)objectArray[0];
                        return null;
                    }
                    case "setTransmitReturnValue": {
                        this.transmitReturnValue = (Boolean)objectArray[0];
                        return null;
                    }
                    case "setUDP": {
                        this.udp = (Boolean)objectArray[0];
                        return null;
                    }
                    case "setTransmitExceptions": {
                        this.transmitExceptions = (Boolean)objectArray[0];
                        return null;
                    }
                    case "setRemoteToString": {
                        this.remoteToString = (Boolean)objectArray[0];
                        return null;
                    }
                    case "waitForLastResponse": {
                        if (this.lastResponseID == null) {
                            throw new IllegalStateException("There is no last response to wait for.");
                        }
                        return this.waitForResponse(this.lastResponseID);
                    }
                    case "hasLastResponse": {
                        if (this.lastResponseID == null) {
                            throw new IllegalStateException("There is no last response.");
                        }
                        RemoteInvocationHandler remoteInvocationHandler = this;
                        synchronized (remoteInvocationHandler) {
                            return this.responseTable[this.lastResponseID] != null;
                        }
                    }
                    case "getLastResponseID": {
                        if (this.lastResponseID == null) {
                            throw new IllegalStateException("There is no last response ID.");
                        }
                        return this.lastResponseID;
                    }
                    case "waitForResponse": {
                        if (!this.transmitReturnValue && !this.transmitExceptions && this.nonBlocking) {
                            throw new IllegalStateException("This RemoteObject is currently set to ignore all responses.");
                        }
                        return this.waitForResponse((Byte)objectArray[0]);
                    }
                    case "hasResponse": {
                        RemoteInvocationHandler remoteInvocationHandler = this;
                        synchronized (remoteInvocationHandler) {
                            return this.responseTable[(Byte)objectArray[0]] != null;
                        }
                    }
                    case "getConnection": {
                        return this.connection;
                    }
                }
                throw new KryoNetException("Invocation handler could not find RemoteObject method. Check ObjectSpace.java");
            }
            if (!this.remoteToString && clazz2 == Object.class && method.getName().equals("toString")) {
                return "<proxy>";
            }
            InvokeMethod invokeMethod = new InvokeMethod();
            invokeMethod.objectID = this.objectID;
            invokeMethod.args = objectArray;
            for (CachedMethod object2 : ObjectSpace.getMethods(this.connection.getEndPoint().getKryo(), method.getDeclaringClass())) {
                if (!object2.method.equals(method)) continue;
                invokeMethod.cachedMethod = object2;
                break;
            }
            if (invokeMethod.cachedMethod == null) {
                throw new KryoNetException("Method not found: " + method);
            }
            int n3 = !this.udp && (this.transmitReturnValue || this.transmitExceptions || !this.nonBlocking) ? 1 : 0;
            int n4 = 0;
            if (n3 != 0) {
                byte by2;
                byte by3;
                RemoteInvocationHandler n5 = this;
                synchronized (n5) {
                    byte by4 = this.nextResponseId;
                    this.nextResponseId = (byte)(by4 + 1);
                    n4 = by4;
                    if (this.nextResponseId > 63) {
                        this.nextResponseId = 1;
                    }
                    this.pendingResponses[n4] = true;
                }
                int n22 = n4;
                if (this.transmitReturnValue) {
                    by3 = (byte)(n22 | 0x80);
                }
                if (this.transmitExceptions) {
                    by2 = (byte)(by3 | 0x40);
                }
                invokeMethod.responseData = by2;
            } else {
                invokeMethod.responseData = 0;
            }
            int n5 = n2 = this.udp ? this.connection.sendUDP(invokeMethod) : this.connection.sendTCP(invokeMethod);
            if (Log.DEBUG) {
                clazz = "";
                if (objectArray != null) {
                    clazz = Arrays.deepToString(objectArray);
                    clazz = ((String)((Object)clazz)).substring(1, ((String)((Object)clazz)).length() - 1);
                }
                Log.debug("kryonet", this.connection + " sent " + (this.udp ? "UDP" : "TCP") + ": " + method.getDeclaringClass().getSimpleName() + "#" + method.getName() + "(" + (String)((Object)clazz) + ") (" + n2 + ")");
            }
            this.lastResponseID = (byte)(invokeMethod.responseData & 0x3F);
            if (this.nonBlocking || this.udp) {
                clazz = method.getReturnType();
                if (clazz.isPrimitive()) {
                    if (clazz == Integer.TYPE) {
                        return 0;
                    }
                    if (clazz == Boolean.TYPE) {
                        return Boolean.FALSE;
                    }
                    if (clazz == Float.TYPE) {
                        return Float.valueOf(0.0f);
                    }
                    if (clazz == Character.TYPE) {
                        return Character.valueOf('\u0000');
                    }
                    if (clazz == Long.TYPE) {
                        return 0L;
                    }
                    if (clazz == Short.TYPE) {
                        return (short)0;
                    }
                    if (clazz == Byte.TYPE) {
                        return (byte)0;
                    }
                    if (clazz == Double.TYPE) {
                        return 0.0;
                    }
                }
                return null;
            }
            try {
                clazz = this.waitForResponse(this.lastResponseID);
                if (clazz instanceof Exception) {
                    throw (Exception)((Object)clazz);
                }
                Class<?> clazz3 = clazz;
                return clazz3;
            }
            catch (TimeoutException timeoutException) {
                throw new TimeoutException("Response timed out: " + method.getDeclaringClass().getName() + "." + method.getName());
            }
            finally {
                RemoteInvocationHandler remoteInvocationHandler = this;
                synchronized (remoteInvocationHandler) {
                    this.pendingResponses[n4] = false;
                    this.responseTable[n4] = null;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Object waitForResponse(byte by2) {
            if (this.connection.getEndPoint().getUpdateThread() == Thread.currentThread()) {
                throw new IllegalStateException("Cannot wait for a RMI response on the connection's update thread.");
            }
            long l2 = System.currentTimeMillis() + (long)this.timeoutMillis;
            while (true) {
                InvokeMethodResult invokeMethodResult;
                long l3 = l2 - System.currentTimeMillis();
                RemoteInvocationHandler remoteInvocationHandler = this;
                synchronized (remoteInvocationHandler) {
                    invokeMethodResult = this.responseTable[by2];
                }
                if (invokeMethodResult != null) {
                    this.lastResponseID = null;
                    return invokeMethodResult.result;
                }
                if (l3 <= 0L) {
                    throw new TimeoutException("Response timed out.");
                }
                this.lock.lock();
                try {
                    this.responseCondition.await(l3, TimeUnit.MILLISECONDS);
                    continue;
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    throw new KryoNetException(interruptedException);
                }
                finally {
                    this.lock.unlock();
                    continue;
                }
                break;
            }
        }

        void close() {
            this.connection.removeListener(this.responseListener);
        }
    }

    static class AsmCachedMethod
    extends CachedMethod {
        MethodAccess methodAccess;
        int methodAccessIndex = -1;

        AsmCachedMethod() {
        }

        @Override
        public Object invoke(Object object, Object[] objectArray) {
            try {
                return this.methodAccess.invoke(object, this.methodAccessIndex, objectArray);
            }
            catch (Exception exception) {
                throw new InvocationTargetException(exception);
            }
        }
    }

    public static class RemoteObjectSerializer
    extends Serializer {
        public void write(Kryo kryo, Output output, Object object) {
            Connection connection = (Connection)kryo.getContext().get("connection");
            if (connection == null) {
                throw new KryoException("Connection in kryo context cannot be null", new NullPointerException());
            }
            int n2 = ObjectSpace.getRegisteredID(connection, object);
            if (n2 == Integer.MAX_VALUE) {
                throw new KryoNetException("Object not found in an ObjectSpace: " + object);
            }
            output.writeInt(n2, true);
        }

        public Object read(Kryo kryo, Input input, Class clazz) {
            int n2 = input.readInt(true);
            Connection connection = (Connection)kryo.getContext().get("connection");
            if (connection == null) {
                throw new KryoException("Connection in kryo context cannot be null", new NullPointerException());
            }
            return ObjectSpace.getRemoteObject(connection, n2, clazz);
        }
    }
}

