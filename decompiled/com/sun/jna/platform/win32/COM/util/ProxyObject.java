/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.internal.ReflectionUtils;
import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.ConnectionPoint;
import com.sun.jna.platform.win32.COM.ConnectionPointContainer;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IDispatch;
import com.sun.jna.platform.win32.COM.IDispatchCallback;
import com.sun.jna.platform.win32.COM.util.ComEventCallbackCookie;
import com.sun.jna.platform.win32.COM.util.Convert;
import com.sun.jna.platform.win32.COM.util.IComEventCallbackCookie;
import com.sun.jna.platform.win32.COM.util.IComEventCallbackListener;
import com.sun.jna.platform.win32.COM.util.IConnectionPoint;
import com.sun.jna.platform.win32.COM.util.IConnectionPointContainer;
import com.sun.jna.platform.win32.COM.util.IRawDispatchHandle;
import com.sun.jna.platform.win32.COM.util.IUnknown;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.COM.util.annotation.ComInterface;
import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.COM.util.annotation.ComProperty;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObject
implements IConnectionPoint,
com.sun.jna.platform.win32.COM.util.IDispatch,
IRawDispatchHandle,
InvocationHandler {
    private long unknownId = -1L;
    private final Class<?> theInterface;
    private final ObjectFactory factory;
    private final IDispatch rawDispatch;

    public ProxyObject(Class<?> clazz, IDispatch iDispatch, ObjectFactory objectFactory) {
        this.rawDispatch = iDispatch;
        this.theInterface = clazz;
        this.factory = objectFactory;
        int n2 = this.rawDispatch.AddRef();
        this.getUnknownId();
        objectFactory.register(this);
    }

    private long getUnknownId() {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        if (-1L == this.unknownId) {
            try {
                PointerByReference pointerByReference = new PointerByReference();
                Thread thread = Thread.currentThread();
                String string = thread.getName();
                Guid.IID iID = com.sun.jna.platform.win32.COM.IUnknown.IID_IUNKNOWN;
                WinNT.HRESULT hRESULT = this.getRawDispatch().QueryInterface(new Guid.REFIID(iID), pointerByReference);
                if (!WinNT.S_OK.equals(hRESULT)) {
                    String string2 = Kernel32Util.formatMessage(hRESULT);
                    throw new COMException("getUnknownId: " + string2, hRESULT);
                }
                Dispatch dispatch = new Dispatch(pointerByReference.getValue());
                this.unknownId = Pointer.nativeValue(dispatch.getPointer());
                int n2 = dispatch.Release();
            }
            catch (RuntimeException runtimeException) {
                if (runtimeException instanceof COMException) {
                    throw runtimeException;
                }
                throw new COMException("Error occured when trying get Unknown Id ", runtimeException);
            }
        }
        return this.unknownId;
    }

    protected void finalize() {
        this.dispose();
        super.finalize();
    }

    public synchronized void dispose() {
        if (((Dispatch)this.rawDispatch).getPointer() != Pointer.NULL) {
            this.rawDispatch.Release();
            ((Dispatch)this.rawDispatch).setPointer(Pointer.NULL);
            this.factory.unregister(this);
        }
    }

    @Override
    public IDispatch getRawDispatch() {
        return this.rawDispatch;
    }

    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }
        if (object instanceof ProxyObject) {
            ProxyObject proxyObject = (ProxyObject)object;
            return this.getUnknownId() == proxyObject.getUnknownId();
        }
        if (Proxy.isProxyClass(object.getClass())) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(object);
            if (invocationHandler instanceof ProxyObject) {
                try {
                    ProxyObject proxyObject = (ProxyObject)invocationHandler;
                    return this.getUnknownId() == proxyObject.getUnknownId();
                }
                catch (Exception exception) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long l2 = this.getUnknownId();
        return (int)(l2 >>> 32 & 0xFFFFFFFFFFFFFFFFL) + (int)(l2 & 0xFFFFFFFFFFFFFFFFL);
    }

    public String toString() {
        return this.theInterface.getName() + "{unk=" + this.hashCode() + "}";
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        boolean bl2;
        boolean bl3 = bl2 = method.getAnnotation(ComMethod.class) != null || method.getAnnotation(ComProperty.class) != null;
        if (!bl2 && (method.getDeclaringClass().equals(Object.class) || method.getDeclaringClass().equals(IRawDispatchHandle.class) || method.getDeclaringClass().equals(IUnknown.class) || method.getDeclaringClass().equals(com.sun.jna.platform.win32.COM.util.IDispatch.class) || method.getDeclaringClass().equals(IConnectionPoint.class))) {
            try {
                return method.invoke((Object)this, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw invocationTargetException.getCause();
            }
        }
        if (!bl2 && ReflectionUtils.isDefault(method)) {
            Object object2 = ReflectionUtils.getMethodHandle(method);
            return ReflectionUtils.invokeDefaultMethod(object, object2, objectArray);
        }
        Class<?> clazz = method.getReturnType();
        boolean bl4 = Void.TYPE.equals(clazz);
        ComProperty comProperty = method.getAnnotation(ComProperty.class);
        if (null != comProperty) {
            int n2 = comProperty.dispId();
            Object[] objectArray2 = this.unfoldWhenVarargs(method, objectArray);
            if (bl4) {
                if (n2 != -1) {
                    this.setProperty(new OaIdl.DISPID(n2), objectArray2);
                    return null;
                }
                String string = this.getMutatorName(method, comProperty);
                this.setProperty(string, objectArray2);
                return null;
            }
            if (n2 != -1) {
                return this.getProperty(clazz, new OaIdl.DISPID(n2), objectArray);
            }
            String string = this.getAccessorName(method, comProperty);
            return this.getProperty(clazz, string, objectArray);
        }
        ComMethod comMethod = method.getAnnotation(ComMethod.class);
        if (null != comMethod) {
            Object[] objectArray3 = this.unfoldWhenVarargs(method, objectArray);
            int n3 = comMethod.dispId();
            if (n3 != -1) {
                return this.invokeMethod(clazz, new OaIdl.DISPID(n3), objectArray3);
            }
            String string = this.getMethodName(method, comMethod);
            return this.invokeMethod(clazz, string, objectArray3);
        }
        return null;
    }

    private ConnectionPoint fetchRawConnectionPoint(Guid.IID iID) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        IConnectionPointContainer iConnectionPointContainer = this.queryInterface(IConnectionPointContainer.class);
        Dispatch dispatch = (Dispatch)iConnectionPointContainer.getRawDispatch();
        ConnectionPointContainer connectionPointContainer = new ConnectionPointContainer(dispatch.getPointer());
        Guid.REFIID rEFIID = new Guid.REFIID(iID.getPointer());
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = connectionPointContainer.FindConnectionPoint(rEFIID, pointerByReference);
        COMUtils.checkRC(hRESULT);
        ConnectionPoint connectionPoint = new ConnectionPoint(pointerByReference.getValue());
        return connectionPoint;
    }

    @Override
    public IComEventCallbackCookie advise(Class<?> clazz, IComEventCallbackListener iComEventCallbackListener) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        try {
            ComInterface comInterface = clazz.getAnnotation(ComInterface.class);
            if (null == comInterface) {
                throw new COMException("advise: Interface must define a value for either iid via the ComInterface annotation");
            }
            Guid.IID iID = this.getIID(comInterface);
            ConnectionPoint connectionPoint = this.fetchRawConnectionPoint(iID);
            IDispatchCallback iDispatchCallback = this.factory.createDispatchCallback(clazz, iComEventCallbackListener);
            iComEventCallbackListener.setDispatchCallbackListener(iDispatchCallback);
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
            WinNT.HRESULT hRESULT = connectionPoint.Advise(iDispatchCallback, dWORDByReference);
            int n2 = connectionPoint.Release();
            COMUtils.checkRC(hRESULT);
            return new ComEventCallbackCookie(dWORDByReference.getValue());
        }
        catch (RuntimeException runtimeException) {
            if (runtimeException instanceof COMException) {
                throw runtimeException;
            }
            throw new COMException("Error occured in advise when trying to connect the listener " + iComEventCallbackListener, runtimeException);
        }
    }

    @Override
    public void unadvise(Class<?> clazz, IComEventCallbackCookie iComEventCallbackCookie) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        try {
            ComInterface comInterface = clazz.getAnnotation(ComInterface.class);
            if (null == comInterface) {
                throw new COMException("unadvise: Interface must define a value for iid via the ComInterface annotation");
            }
            Guid.IID iID = this.getIID(comInterface);
            ConnectionPoint connectionPoint = this.fetchRawConnectionPoint(iID);
            WinNT.HRESULT hRESULT = connectionPoint.Unadvise(((ComEventCallbackCookie)iComEventCallbackCookie).getValue());
            connectionPoint.Release();
            COMUtils.checkRC(hRESULT);
        }
        catch (RuntimeException runtimeException) {
            if (runtimeException instanceof COMException) {
                throw runtimeException;
            }
            throw new COMException("Error occured in unadvise when trying to disconnect the listener from " + this, runtimeException);
        }
    }

    @Override
    public <T> void setProperty(String string, T t2) {
        OaIdl.DISPID dISPID = this.resolveDispId(this.getRawDispatch(), string);
        this.setProperty(dISPID, t2);
    }

    @Override
    public <T> void setProperty(OaIdl.DISPID dISPID, T t2) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        Variant.VARIANT vARIANT = Convert.toVariant(t2);
        WinNT.HRESULT hRESULT = this.oleMethod(4, null, this.getRawDispatch(), dISPID, vARIANT);
        Convert.free(vARIANT, t2);
        COMUtils.checkRC(hRESULT);
    }

    private void setProperty(String string, Object ... objectArray) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        OaIdl.DISPID dISPID = this.resolveDispId(this.getRawDispatch(), string);
        this.setProperty(dISPID, objectArray);
    }

    private void setProperty(OaIdl.DISPID dISPID, Object ... objectArray) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        Variant.VARIANT[] vARIANTArray = null == objectArray ? new Variant.VARIANT[]{} : new Variant.VARIANT[objectArray.length];
        for (int i2 = 0; i2 < vARIANTArray.length; ++i2) {
            vARIANTArray[i2] = Convert.toVariant(objectArray[i2]);
        }
        WinNT.HRESULT hRESULT = this.oleMethod(4, null, this.getRawDispatch(), dISPID, vARIANTArray);
        for (int i3 = 0; i3 < vARIANTArray.length; ++i3) {
            Convert.free(vARIANTArray[i3], objectArray[i3]);
        }
        COMUtils.checkRC(hRESULT);
    }

    @Override
    public <T> T getProperty(Class<T> clazz, String string, Object ... objectArray) {
        OaIdl.DISPID dISPID = this.resolveDispId(this.getRawDispatch(), string);
        return this.getProperty(clazz, dISPID, objectArray);
    }

    @Override
    public <T> T getProperty(Class<T> clazz, OaIdl.DISPID dISPID, Object ... objectArray) {
        Variant.VARIANT[] vARIANTArray = null == objectArray ? new Variant.VARIANT[]{} : new Variant.VARIANT[objectArray.length];
        for (int i2 = 0; i2 < vARIANTArray.length; ++i2) {
            vARIANTArray[i2] = Convert.toVariant(objectArray[i2]);
        }
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        WinNT.HRESULT hRESULT = this.oleMethod(2, byReference, this.getRawDispatch(), dISPID, vARIANTArray);
        for (int i3 = 0; i3 < vARIANTArray.length; ++i3) {
            Convert.free(vARIANTArray[i3], objectArray[i3]);
        }
        COMUtils.checkRC(hRESULT);
        return (T)Convert.toJavaObject(byReference, clazz, this.factory, false, true);
    }

    @Override
    public <T> T invokeMethod(Class<T> clazz, String string, Object ... objectArray) {
        OaIdl.DISPID dISPID = this.resolveDispId(this.getRawDispatch(), string);
        return this.invokeMethod(clazz, dISPID, objectArray);
    }

    @Override
    public <T> T invokeMethod(Class<T> clazz, OaIdl.DISPID dISPID, Object ... objectArray) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        Variant.VARIANT[] vARIANTArray = null == objectArray ? new Variant.VARIANT[]{} : new Variant.VARIANT[objectArray.length];
        for (int i2 = 0; i2 < vARIANTArray.length; ++i2) {
            vARIANTArray[i2] = Convert.toVariant(objectArray[i2]);
        }
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        WinNT.HRESULT hRESULT = this.oleMethod(1, byReference, this.getRawDispatch(), dISPID, vARIANTArray);
        for (int i3 = 0; i3 < vARIANTArray.length; ++i3) {
            Convert.free(vARIANTArray[i3], objectArray[i3]);
        }
        COMUtils.checkRC(hRESULT);
        return (T)Convert.toJavaObject(byReference, clazz, this.factory, false, true);
    }

    private Object[] unfoldWhenVarargs(Method method, Object[] objectArray) {
        if (null == objectArray) {
            return null;
        }
        if (objectArray.length == 0 || !method.isVarArgs() || !(objectArray[objectArray.length - 1] instanceof Object[])) {
            return objectArray;
        }
        Object[] objectArray2 = (Object[])objectArray[objectArray.length - 1];
        Object[] objectArray3 = new Object[objectArray.length - 1 + objectArray2.length];
        System.arraycopy(objectArray, 0, objectArray3, 0, objectArray.length - 1);
        System.arraycopy(objectArray2, 0, objectArray3, objectArray.length - 1, objectArray2.length);
        return objectArray3;
    }

    @Override
    public <T> T queryInterface(Class<T> clazz) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        try {
            ComInterface comInterface = clazz.getAnnotation(ComInterface.class);
            if (null == comInterface) {
                throw new COMException("queryInterface: Interface must define a value for iid via the ComInterface annotation");
            }
            Guid.IID iID = this.getIID(comInterface);
            PointerByReference pointerByReference = new PointerByReference();
            WinNT.HRESULT hRESULT = this.getRawDispatch().QueryInterface(new Guid.REFIID(iID), pointerByReference);
            if (WinNT.S_OK.equals(hRESULT)) {
                Dispatch dispatch = new Dispatch(pointerByReference.getValue());
                T t2 = this.factory.createProxy(clazz, dispatch);
                int n2 = dispatch.Release();
                return t2;
            }
            String string = Kernel32Util.formatMessage(hRESULT);
            throw new COMException("queryInterface: " + string, hRESULT);
        }
        catch (RuntimeException runtimeException) {
            if (runtimeException instanceof COMException) {
                throw runtimeException;
            }
            throw new COMException("Error occured when trying to query for interface " + clazz.getName(), runtimeException);
        }
    }

    private Guid.IID getIID(ComInterface comInterface) {
        String string = comInterface.iid();
        if (null != string && !string.isEmpty()) {
            return new Guid.IID(string);
        }
        throw new COMException("ComInterface must define a value for iid");
    }

    private String getAccessorName(Method method, ComProperty comProperty) {
        if (comProperty.name().isEmpty()) {
            String string = method.getName();
            if (string.startsWith("get")) {
                return string.replaceFirst("get", "");
            }
            throw new RuntimeException("Property Accessor name must start with 'get', or set the anotation 'name' value");
        }
        return comProperty.name();
    }

    private String getMutatorName(Method method, ComProperty comProperty) {
        if (comProperty.name().isEmpty()) {
            String string = method.getName();
            if (string.startsWith("set")) {
                return string.replaceFirst("set", "");
            }
            throw new RuntimeException("Property Mutator name must start with 'set', or set the anotation 'name' value");
        }
        return comProperty.name();
    }

    private String getMethodName(Method method, ComMethod comMethod) {
        if (comMethod.name().isEmpty()) {
            String string = method.getName();
            return string;
        }
        return comMethod.name();
    }

    protected OaIdl.DISPID resolveDispId(String string) {
        return this.resolveDispId(this.getRawDispatch(), string);
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, String string, Variant.VARIANT vARIANT) {
        return this.oleMethod(n2, byReference, string, new Variant.VARIANT[]{vARIANT});
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dISPID, Variant.VARIANT vARIANT) {
        return this.oleMethod(n2, byReference, dISPID, new Variant.VARIANT[]{vARIANT});
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, String string) {
        return this.oleMethod(n2, byReference, string, (Variant.VARIANT[])null);
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dISPID) {
        return this.oleMethod(n2, byReference, dISPID, (Variant.VARIANT[])null);
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, String string, Variant.VARIANT[] vARIANTArray) {
        return this.oleMethod(n2, byReference, this.resolveDispId(string), vARIANTArray);
    }

    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, OaIdl.DISPID dISPID, Variant.VARIANT[] vARIANTArray) {
        return this.oleMethod(n2, byReference, this.getRawDispatch(), dISPID, vARIANTArray);
    }

    @Deprecated
    protected OaIdl.DISPID resolveDispId(IDispatch iDispatch, String string) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        if (iDispatch == null) {
            throw new COMException("pDisp (IDispatch) parameter is null!");
        }
        WString[] wStringArray = new WString[]{new WString(string)};
        OaIdl.DISPIDByReference dISPIDByReference = new OaIdl.DISPIDByReference();
        WinNT.HRESULT hRESULT = iDispatch.GetIDsOfNames(new Guid.REFIID(Guid.IID_NULL), wStringArray, 1, this.factory.getLCID(), dISPIDByReference);
        COMUtils.checkRC(hRESULT);
        return dISPIDByReference.getValue();
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, String string, Variant.VARIANT vARIANT) {
        return this.oleMethod(n2, byReference, iDispatch, string, new Variant.VARIANT[]{vARIANT});
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, OaIdl.DISPID dISPID, Variant.VARIANT vARIANT) {
        return this.oleMethod(n2, byReference, iDispatch, dISPID, new Variant.VARIANT[]{vARIANT});
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, String string) {
        return this.oleMethod(n2, byReference, iDispatch, string, (Variant.VARIANT[])null);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, OaIdl.DISPID dISPID) {
        return this.oleMethod(n2, byReference, iDispatch, dISPID, (Variant.VARIANT[])null);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, String string, Variant.VARIANT[] vARIANTArray) {
        return this.oleMethod(n2, byReference, iDispatch, this.resolveDispId(iDispatch, string), vARIANTArray);
    }

    @Deprecated
    protected WinNT.HRESULT oleMethod(int n2, Variant.VARIANT.ByReference byReference, IDispatch iDispatch, OaIdl.DISPID dISPID, Variant.VARIANT[] vARIANTArray) {
        int n3;
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        if (iDispatch == null) {
            throw new COMException("pDisp (IDispatch) parameter is null!");
        }
        int n4 = 0;
        Variant.VARIANT[] vARIANTArray2 = null;
        OleAuto.DISPPARAMS.ByReference byReference2 = new OleAuto.DISPPARAMS.ByReference();
        OaIdl.EXCEPINFO.ByReference byReference3 = new OaIdl.EXCEPINFO.ByReference();
        IntByReference intByReference = new IntByReference();
        if (vARIANTArray != null && vARIANTArray.length > 0) {
            n4 = vARIANTArray.length;
            vARIANTArray2 = new Variant.VARIANT[n4];
            n3 = n4;
            for (int i2 = 0; i2 < n4; ++i2) {
                vARIANTArray2[i2] = vARIANTArray[--n3];
            }
        }
        if (n2 == 4) {
            byReference2.setRgdispidNamedArgs(new OaIdl.DISPID[]{OaIdl.DISPID_PROPERTYPUT});
        }
        n3 = n2 == 1 || n2 == 2 ? 3 : n2;
        if (n4 > 0) {
            byReference2.setArgs(vARIANTArray2);
            byReference2.write();
        }
        WinNT.HRESULT hRESULT = iDispatch.Invoke(dISPID, new Guid.REFIID(Guid.IID_NULL), this.factory.getLCID(), new WinDef.WORD((long)n3), byReference2, byReference, byReference3, intByReference);
        COMUtils.checkRC(hRESULT, byReference3, intByReference);
        return hRESULT;
    }
}

