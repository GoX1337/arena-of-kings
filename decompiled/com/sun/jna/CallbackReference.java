/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.AltCallingConvention;
import com.sun.jna.Callback;
import com.sun.jna.CallbackParameterContext;
import com.sun.jna.CallbackProxy;
import com.sun.jna.CallbackResultContext;
import com.sun.jna.CallbackThreadInitializer;
import com.sun.jna.FromNativeConverter;
import com.sun.jna.Function;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.NativeString;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import com.sun.jna.ToNativeConverter;
import com.sun.jna.TypeMapper;
import com.sun.jna.WString;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class CallbackReference
extends WeakReference<Callback> {
    static final Map<Callback, CallbackReference> callbackMap = new WeakHashMap<Callback, CallbackReference>();
    static final Map<Callback, CallbackReference> directCallbackMap = new WeakHashMap<Callback, CallbackReference>();
    static final Map<Pointer, Reference<Callback>[]> pointerCallbackMap = new WeakHashMap<Pointer, Reference<Callback>[]>();
    static final Map<Object, Object> allocations = Collections.synchronizedMap(new WeakHashMap());
    private static final Map<CallbackReference, Reference<CallbackReference>> allocatedMemory = Collections.synchronizedMap(new WeakHashMap());
    private static final Method PROXY_CALLBACK_METHOD;
    private static final Class<?> DLL_CALLBACK_CLASS;
    private static final Map<Callback, CallbackThreadInitializer> initializers;
    Pointer cbstruct;
    Pointer trampoline;
    CallbackProxy proxy;
    Method method;
    int callingConvention;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static CallbackThreadInitializer setCallbackThreadInitializer(Callback callback, CallbackThreadInitializer callbackThreadInitializer) {
        Map<Callback, CallbackThreadInitializer> map = initializers;
        synchronized (map) {
            if (callbackThreadInitializer != null) {
                return initializers.put(callback, callbackThreadInitializer);
            }
            return initializers.remove(callback);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ThreadGroup initializeThread(Callback callback, AttachOptions attachOptions) {
        CallbackThreadInitializer callbackThreadInitializer = null;
        if (callback instanceof DefaultCallbackProxy) {
            callback = ((DefaultCallbackProxy)callback).getCallback();
        }
        Object object = initializers;
        synchronized (object) {
            callbackThreadInitializer = initializers.get(callback);
        }
        object = null;
        if (callbackThreadInitializer != null) {
            object = callbackThreadInitializer.getThreadGroup(callback);
            attachOptions.name = callbackThreadInitializer.getName(callback);
            attachOptions.daemon = callbackThreadInitializer.isDaemon(callback);
            attachOptions.detach = callbackThreadInitializer.detach(callback);
            attachOptions.write();
        }
        return object;
    }

    public static Callback getCallback(Class<?> clazz, Pointer pointer) {
        return CallbackReference.getCallback(clazz, pointer, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Callback getCallback(Class<?> clazz, Pointer pointer, boolean bl2) {
        if (pointer == null) {
            return null;
        }
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException("Callback type must be an interface");
        }
        Map<Callback, CallbackReference> map = bl2 ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map2 = pointerCallbackMap;
        synchronized (map2) {
            Reference<Callback>[] referenceArray = pointerCallbackMap.get(pointer);
            Callback callback = CallbackReference.getTypeAssignableCallback(clazz, referenceArray);
            if (callback != null) {
                return callback;
            }
            callback = CallbackReference.createCallback(clazz, pointer);
            pointerCallbackMap.put(pointer, CallbackReference.addCallbackToArray(callback, referenceArray));
            map.remove(callback);
            return callback;
        }
    }

    private static Callback getTypeAssignableCallback(Class<?> clazz, Reference<Callback>[] referenceArray) {
        if (referenceArray != null) {
            for (int i2 = 0; i2 < referenceArray.length; ++i2) {
                Callback callback = referenceArray[i2].get();
                if (callback == null || !clazz.isAssignableFrom(callback.getClass())) continue;
                return callback;
            }
        }
        return null;
    }

    private static Reference<Callback>[] addCallbackToArray(Callback callback, Reference<Callback>[] referenceArray) {
        int n2 = 1;
        if (referenceArray != null) {
            for (int i2 = 0; i2 < referenceArray.length; ++i2) {
                if (referenceArray[i2].get() == null) {
                    referenceArray[i2] = null;
                    continue;
                }
                ++n2;
            }
        }
        Reference[] referenceArray2 = new Reference[n2];
        int n3 = 0;
        if (referenceArray != null) {
            for (int i3 = 0; i3 < referenceArray.length; ++i3) {
                if (referenceArray[i3] == null) continue;
                referenceArray2[n3++] = referenceArray[i3];
            }
        }
        referenceArray2[n3] = new WeakReference<Callback>(callback);
        return referenceArray2;
    }

    private static Callback createCallback(Class<?> clazz, Pointer pointer) {
        int n2 = AltCallingConvention.class.isAssignableFrom(clazz) ? 63 : 0;
        HashMap<String, Object> hashMap = new HashMap<String, Object>(Native.getLibraryOptions(clazz));
        hashMap.put("invoking-method", CallbackReference.getCallbackMethod(clazz));
        NativeFunctionHandler nativeFunctionHandler = new NativeFunctionHandler(pointer, n2, hashMap);
        return (Callback)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (InvocationHandler)nativeFunctionHandler);
    }

    private CallbackReference(Callback callback, int n2, boolean bl2) {
        super(callback);
        Object object;
        TypeMapper typeMapper = Native.getTypeMapper(callback.getClass());
        this.callingConvention = n2;
        boolean bl3 = Platform.isPPC();
        if (bl2) {
            object = CallbackReference.getCallbackMethod(callback);
            Class<?>[] classArray = ((Method)object).getParameterTypes();
            for (int i2 = 0; i2 < classArray.length; ++i2) {
                if (bl3 && (classArray[i2] == Float.TYPE || classArray[i2] == Double.TYPE)) {
                    bl2 = false;
                    break;
                }
                if (typeMapper == null || typeMapper.getFromNativeConverter(classArray[i2]) == null) continue;
                bl2 = false;
                break;
            }
            if (typeMapper != null && typeMapper.getToNativeConverter(((Method)object).getReturnType()) != null) {
                bl2 = false;
            }
        }
        object = Native.getStringEncoding(callback.getClass());
        long l2 = 0L;
        if (bl2) {
            this.method = CallbackReference.getCallbackMethod(callback);
            Class<?>[] classArray = this.method.getParameterTypes();
            Class<?> clazz = this.method.getReturnType();
            int n3 = 1;
            if (DLL_CALLBACK_CLASS != null && DLL_CALLBACK_CLASS.isInstance(callback)) {
                n3 |= 2;
            }
            l2 = Native.createNativeCallback(callback, this.method, classArray, clazz, n2, n3, (String)object);
        } else {
            int n4;
            Object object2;
            this.proxy = callback instanceof CallbackProxy ? (CallbackProxy)callback : new DefaultCallbackProxy(CallbackReference.getCallbackMethod(callback), typeMapper, (String)object);
            Class<?>[] classArray = this.proxy.getParameterTypes();
            Class<?> clazz = this.proxy.getReturnType();
            if (typeMapper != null) {
                for (int i3 = 0; i3 < classArray.length; ++i3) {
                    object2 = typeMapper.getFromNativeConverter(classArray[i3]);
                    if (object2 == null) continue;
                    classArray[i3] = object2.nativeType();
                }
                ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(clazz);
                if (toNativeConverter != null) {
                    clazz = toNativeConverter.nativeType();
                }
            }
            for (n4 = 0; n4 < classArray.length; ++n4) {
                classArray[n4] = this.getNativeType(classArray[n4]);
                if (CallbackReference.isAllowableNativeType(classArray[n4])) continue;
                object2 = "Callback argument " + classArray[n4] + " requires custom type conversion";
                throw new IllegalArgumentException((String)object2);
            }
            if (!CallbackReference.isAllowableNativeType(clazz = this.getNativeType(clazz))) {
                String string = "Callback return type " + clazz + " requires custom type conversion";
                throw new IllegalArgumentException(string);
            }
            n4 = DLL_CALLBACK_CLASS != null && DLL_CALLBACK_CLASS.isInstance(callback) ? 2 : 0;
            l2 = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, classArray, clazz, n2, n4, (String)object);
        }
        this.cbstruct = l2 != 0L ? new Pointer(l2) : null;
        allocatedMemory.put(this, new WeakReference<CallbackReference>(this));
    }

    private Class<?> getNativeType(Class<?> clazz) {
        if (Structure.class.isAssignableFrom(clazz)) {
            Structure.validate(clazz);
            if (!Structure.ByValue.class.isAssignableFrom(clazz)) {
                return Pointer.class;
            }
        } else {
            if (NativeMapped.class.isAssignableFrom(clazz)) {
                return NativeMappedConverter.getInstance(clazz).nativeType();
            }
            if (clazz == String.class || clazz == WString.class || clazz == String[].class || clazz == WString[].class || Callback.class.isAssignableFrom(clazz)) {
                return Pointer.class;
            }
        }
        return clazz;
    }

    private static Method checkMethod(Method method) {
        if (method.getParameterTypes().length > 256) {
            String string = "Method signature exceeds the maximum parameter count: " + method;
            throw new UnsupportedOperationException(string);
        }
        return method;
    }

    static Class<?> findCallbackClass(Class<?> clazz) {
        if (!Callback.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(clazz.getName() + " is not derived from com.sun.jna.Callback");
        }
        if (clazz.isInterface()) {
            return clazz;
        }
        Class<?>[] classArray = clazz.getInterfaces();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (!Callback.class.isAssignableFrom(classArray[i2])) continue;
            try {
                CallbackReference.getCallbackMethod(classArray[i2]);
                return classArray[i2];
            }
            catch (IllegalArgumentException illegalArgumentException) {
                break;
            }
        }
        if (Callback.class.isAssignableFrom(clazz.getSuperclass())) {
            return CallbackReference.findCallbackClass(clazz.getSuperclass());
        }
        return clazz;
    }

    private static Method getCallbackMethod(Callback callback) {
        return CallbackReference.getCallbackMethod(CallbackReference.findCallbackClass(callback.getClass()));
    }

    private static Method getCallbackMethod(Class<?> clazz) {
        Method[] methodArray = clazz.getDeclaredMethods();
        Method[] methodArray2 = clazz.getMethods();
        HashSet<Method> hashSet = new HashSet<Method>(Arrays.asList(methodArray));
        hashSet.retainAll(Arrays.asList(methodArray2));
        Method[] methodArray3 = hashSet.iterator();
        while (methodArray3.hasNext()) {
            Method method = (Method)methodArray3.next();
            if (!Callback.FORBIDDEN_NAMES.contains(method.getName())) continue;
            methodArray3.remove();
        }
        methodArray3 = hashSet.toArray(new Method[0]);
        if (methodArray3.length == 1) {
            return CallbackReference.checkMethod(methodArray3[0]);
        }
        for (int i2 = 0; i2 < methodArray3.length; ++i2) {
            Method method = methodArray3[i2];
            if (!"callback".equals(method.getName())) continue;
            return CallbackReference.checkMethod(method);
        }
        String string = "Callback must implement a single public method, or one public method named 'callback'";
        throw new IllegalArgumentException(string);
    }

    private void setCallbackOptions(int n2) {
        this.cbstruct.setInt(Native.POINTER_SIZE, n2);
    }

    public Pointer getTrampoline() {
        if (this.trampoline == null) {
            this.trampoline = this.cbstruct.getPointer(0L);
        }
        return this.trampoline;
    }

    protected void finalize() {
        this.dispose();
    }

    protected synchronized void dispose() {
        if (this.cbstruct != null) {
            try {
                Native.freeNativeCallback(this.cbstruct.peer);
            }
            finally {
                this.cbstruct.peer = 0L;
                this.cbstruct = null;
                allocatedMemory.remove(this);
            }
        }
    }

    static void disposeAll() {
        LinkedList<CallbackReference> linkedList = new LinkedList<CallbackReference>(allocatedMemory.keySet());
        for (CallbackReference callbackReference : linkedList) {
            callbackReference.dispose();
        }
    }

    private Callback getCallback() {
        return (Callback)this.get();
    }

    private static Pointer getNativeFunctionPointer(Callback callback) {
        InvocationHandler invocationHandler;
        if (Proxy.isProxyClass(callback.getClass()) && (invocationHandler = Proxy.getInvocationHandler(callback)) instanceof NativeFunctionHandler) {
            return ((NativeFunctionHandler)invocationHandler).getPointer();
        }
        return null;
    }

    public static Pointer getFunctionPointer(Callback callback) {
        return CallbackReference.getFunctionPointer(callback, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Pointer getFunctionPointer(Callback callback, boolean bl2) {
        Pointer pointer = null;
        if (callback == null) {
            return null;
        }
        pointer = CallbackReference.getNativeFunctionPointer(callback);
        if (pointer != null) {
            return pointer;
        }
        Map<String, Object> map = Native.getLibraryOptions(callback.getClass());
        int n2 = callback instanceof AltCallingConvention ? 63 : (map != null && map.containsKey("calling-convention") ? (Integer)map.get("calling-convention") : 0);
        Map<Callback, CallbackReference> map2 = bl2 ? directCallbackMap : callbackMap;
        Map<Pointer, Reference<Callback>[]> map3 = pointerCallbackMap;
        synchronized (map3) {
            CallbackReference callbackReference = map2.get(callback);
            if (callbackReference == null) {
                callbackReference = new CallbackReference(callback, n2, bl2);
                map2.put(callback, callbackReference);
                pointerCallbackMap.put(callbackReference.getTrampoline(), CallbackReference.addCallbackToArray(callback, null));
                if (initializers.containsKey(callback)) {
                    callbackReference.setCallbackOptions(1);
                }
            }
            return callbackReference.getTrampoline();
        }
    }

    private static boolean isAllowableNativeType(Class<?> clazz) {
        return clazz == Void.TYPE || clazz == Void.class || clazz == Boolean.TYPE || clazz == Boolean.class || clazz == Byte.TYPE || clazz == Byte.class || clazz == Short.TYPE || clazz == Short.class || clazz == Character.TYPE || clazz == Character.class || clazz == Integer.TYPE || clazz == Integer.class || clazz == Long.TYPE || clazz == Long.class || clazz == Float.TYPE || clazz == Float.class || clazz == Double.TYPE || clazz == Double.class || Structure.ByValue.class.isAssignableFrom(clazz) && Structure.class.isAssignableFrom(clazz) || Pointer.class.isAssignableFrom(clazz);
    }

    private static Pointer getNativeString(Object object, boolean bl2) {
        if (object != null) {
            NativeString nativeString = new NativeString(object.toString(), bl2);
            allocations.put(object, nativeString);
            return nativeString.getPointer();
        }
        return null;
    }

    static {
        try {
            PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod("callback", Object[].class);
        }
        catch (Exception exception) {
            throw new Error("Error looking up CallbackProxy.callback() method");
        }
        if (Platform.isWindows()) {
            try {
                DLL_CALLBACK_CLASS = Class.forName("com.sun.jna.win32.DLLCallback");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new Error("Error loading DLLCallback class", classNotFoundException);
            }
        } else {
            DLL_CALLBACK_CLASS = null;
        }
        initializers = new WeakHashMap<Callback, CallbackThreadInitializer>();
    }

    static class NativeFunctionHandler
    implements InvocationHandler {
        private final Function function;
        private final Map<String, ?> options;

        public NativeFunctionHandler(Pointer pointer, int n2, Map<String, ?> map) {
            this.options = map;
            this.function = new Function(pointer, n2, (String)map.get("string-encoding"));
        }

        @Override
        public Object invoke(Object object, Method method, Object[] objectArray) {
            if (Library.Handler.OBJECT_TOSTRING.equals(method)) {
                String string = "Proxy interface to " + this.function;
                Method method2 = (Method)this.options.get("invoking-method");
                Class<?> clazz = CallbackReference.findCallbackClass(method2.getDeclaringClass());
                string = string + " (" + clazz.getName() + ")";
                return string;
            }
            if (Library.Handler.OBJECT_HASHCODE.equals(method)) {
                return this.hashCode();
            }
            if (Library.Handler.OBJECT_EQUALS.equals(method)) {
                Object object2 = objectArray[0];
                if (object2 != null && Proxy.isProxyClass(object2.getClass())) {
                    return Function.valueOf(Proxy.getInvocationHandler(object2) == this);
                }
                return Boolean.FALSE;
            }
            if (Function.isVarArgs(method)) {
                objectArray = Function.concatenateVarArgs(objectArray);
            }
            return this.function.invoke(method.getReturnType(), objectArray, this.options);
        }

        public Pointer getPointer() {
            return this.function;
        }
    }

    class DefaultCallbackProxy
    implements CallbackProxy {
        private final Method callbackMethod;
        private ToNativeConverter toNative;
        private final FromNativeConverter[] fromNative;
        private final String encoding;

        public DefaultCallbackProxy(Method method, TypeMapper typeMapper, String string) {
            this.callbackMethod = method;
            this.encoding = string;
            Class<?>[] classArray = method.getParameterTypes();
            Class<?> clazz = method.getReturnType();
            this.fromNative = new FromNativeConverter[classArray.length];
            if (NativeMapped.class.isAssignableFrom(clazz)) {
                this.toNative = NativeMappedConverter.getInstance(clazz);
            } else if (typeMapper != null) {
                this.toNative = typeMapper.getToNativeConverter(clazz);
            }
            for (int i2 = 0; i2 < this.fromNative.length; ++i2) {
                if (NativeMapped.class.isAssignableFrom(classArray[i2])) {
                    this.fromNative[i2] = new NativeMappedConverter(classArray[i2]);
                    continue;
                }
                if (typeMapper == null) continue;
                this.fromNative[i2] = typeMapper.getFromNativeConverter(classArray[i2]);
            }
            if (!method.isAccessible()) {
                try {
                    method.setAccessible(true);
                }
                catch (SecurityException securityException) {
                    throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + method);
                }
            }
        }

        public Callback getCallback() {
            return CallbackReference.this.getCallback();
        }

        private Object invokeCallback(Object[] objectArray) {
            Object object;
            Class<?>[] classArray = this.callbackMethod.getParameterTypes();
            Object[] objectArray2 = new Object[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                object = classArray[i2];
                Object object2 = objectArray[i2];
                if (this.fromNative[i2] != null) {
                    CallbackParameterContext callbackParameterContext = new CallbackParameterContext((Class<?>)object, this.callbackMethod, objectArray, i2);
                    objectArray2[i2] = this.fromNative[i2].fromNative(object2, callbackParameterContext);
                    continue;
                }
                objectArray2[i2] = this.convertArgument(object2, (Class<?>)object);
            }
            Object object3 = null;
            object = this.getCallback();
            if (object != null) {
                try {
                    object3 = this.convertResult(this.callbackMethod.invoke(object, objectArray2));
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    Native.getCallbackExceptionHandler().uncaughtException((Callback)object, illegalArgumentException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Native.getCallbackExceptionHandler().uncaughtException((Callback)object, illegalAccessException);
                }
                catch (InvocationTargetException invocationTargetException) {
                    Native.getCallbackExceptionHandler().uncaughtException((Callback)object, invocationTargetException.getTargetException());
                }
            }
            for (int i3 = 0; i3 < objectArray2.length; ++i3) {
                if (!(objectArray2[i3] instanceof Structure) || objectArray2[i3] instanceof Structure.ByValue) continue;
                ((Structure)objectArray2[i3]).autoWrite();
            }
            return object3;
        }

        @Override
        public Object callback(Object[] objectArray) {
            try {
                return this.invokeCallback(objectArray);
            }
            catch (Throwable throwable) {
                Native.getCallbackExceptionHandler().uncaughtException(this.getCallback(), throwable);
                return null;
            }
        }

        private Object convertArgument(Object object, Class<?> clazz) {
            if (object instanceof Pointer) {
                if (clazz == String.class) {
                    object = ((Pointer)object).getString(0L, this.encoding);
                } else if (clazz == WString.class) {
                    object = new WString(((Pointer)object).getWideString(0L));
                } else if (clazz == String[].class) {
                    object = ((Pointer)object).getStringArray(0L, this.encoding);
                } else if (clazz == WString[].class) {
                    object = ((Pointer)object).getWideStringArray(0L);
                } else if (Callback.class.isAssignableFrom(clazz)) {
                    object = CallbackReference.getCallback(clazz, (Pointer)object);
                } else if (Structure.class.isAssignableFrom(clazz)) {
                    if (Structure.ByValue.class.isAssignableFrom(clazz)) {
                        Object obj = Structure.newInstance(clazz);
                        byte[] byArray = new byte[((Structure)obj).size()];
                        ((Pointer)object).read(0L, byArray, 0, byArray.length);
                        ((Structure)obj).getPointer().write(0L, byArray, 0, byArray.length);
                        ((Structure)obj).read();
                        object = obj;
                    } else {
                        Object obj = Structure.newInstance(clazz, (Pointer)object);
                        ((Structure)obj).conditionalAutoRead();
                        object = obj;
                    }
                }
            } else if ((Boolean.TYPE == clazz || Boolean.class == clazz) && object instanceof Number) {
                object = Function.valueOf(((Number)object).intValue() != 0);
            }
            return object;
        }

        private Object convertResult(Object object) {
            if (this.toNative != null) {
                object = this.toNative.toNative(object, new CallbackResultContext(this.callbackMethod));
            }
            if (object == null) {
                return null;
            }
            Class<?> clazz = object.getClass();
            if (Structure.class.isAssignableFrom(clazz)) {
                if (Structure.ByValue.class.isAssignableFrom(clazz)) {
                    return object;
                }
                return ((Structure)object).getPointer();
            }
            if (clazz == Boolean.TYPE || clazz == Boolean.class) {
                return Boolean.TRUE.equals(object) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
            }
            if (clazz == String.class || clazz == WString.class) {
                return CallbackReference.getNativeString(object, clazz == WString.class);
            }
            if (clazz == String[].class || clazz == WString[].class) {
                StringArray stringArray = clazz == String[].class ? new StringArray((String[])object, this.encoding) : new StringArray((WString[])object);
                allocations.put(object, stringArray);
                return stringArray;
            }
            if (Callback.class.isAssignableFrom(clazz)) {
                return CallbackReference.getFunctionPointer((Callback)object);
            }
            return object;
        }

        @Override
        public Class<?>[] getParameterTypes() {
            return this.callbackMethod.getParameterTypes();
        }

        @Override
        public Class<?> getReturnType() {
            return this.callbackMethod.getReturnType();
        }
    }

    static class AttachOptions
    extends Structure {
        public static final List<String> FIELDS = AttachOptions.createFieldsOrder("daemon", "detach", "name");
        public boolean daemon;
        public boolean detach;
        public String name;

        AttachOptions() {
            this.setStringEncoding("utf8");
        }

        @Override
        protected List<String> getFieldOrder() {
            return FIELDS;
        }
    }
}

