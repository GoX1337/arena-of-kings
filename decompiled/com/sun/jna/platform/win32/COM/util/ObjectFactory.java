/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IDispatch;
import com.sun.jna.platform.win32.COM.IDispatchCallback;
import com.sun.jna.platform.win32.COM.util.CallbackProxy;
import com.sun.jna.platform.win32.COM.util.IComEventCallbackListener;
import com.sun.jna.platform.win32.COM.util.IRunningObjectTable;
import com.sun.jna.platform.win32.COM.util.ProxyObject;
import com.sun.jna.platform.win32.COM.util.RunningObjectTable;
import com.sun.jna.platform.win32.COM.util.annotation.ComObject;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ObjectFactory {
    private final List<WeakReference<ProxyObject>> registeredObjects = new LinkedList<WeakReference<ProxyObject>>();
    private static final WinDef.LCID LOCALE_USER_DEFAULT = Kernel32.INSTANCE.GetUserDefaultLCID();
    private WinDef.LCID LCID;

    protected void finalize() {
        try {
            this.disposeAll();
        }
        finally {
            super.finalize();
        }
    }

    public IRunningObjectTable getRunningObjectTable() {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.GetRunningObjectTable(new WinDef.DWORD(0L), pointerByReference);
        COMUtils.checkRC(hRESULT);
        com.sun.jna.platform.win32.COM.RunningObjectTable runningObjectTable = new com.sun.jna.platform.win32.COM.RunningObjectTable(pointerByReference.getValue());
        RunningObjectTable runningObjectTable2 = new RunningObjectTable(runningObjectTable, this);
        return runningObjectTable2;
    }

    public <T> T createProxy(Class<T> clazz, IDispatch iDispatch) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        ProxyObject proxyObject = new ProxyObject(clazz, iDispatch, this);
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (InvocationHandler)proxyObject);
        T t2 = clazz.cast(object);
        return t2;
    }

    public <T> T createObject(Class<T> clazz) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        ComObject comObject = clazz.getAnnotation(ComObject.class);
        if (null == comObject) {
            throw new COMException("createObject: Interface must define a value for either clsId or progId via the ComInterface annotation");
        }
        Guid.GUID gUID = this.discoverClsId(comObject);
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateInstance(gUID, null, 21, IDispatch.IID_IDISPATCH, pointerByReference);
        COMUtils.checkRC(hRESULT);
        Dispatch dispatch = new Dispatch(pointerByReference.getValue());
        T t2 = this.createProxy(clazz, dispatch);
        int n2 = dispatch.Release();
        return t2;
    }

    public <T> T fetchObject(Class<T> clazz) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        ComObject comObject = clazz.getAnnotation(ComObject.class);
        if (null == comObject) {
            throw new COMException("createObject: Interface must define a value for either clsId or progId via the ComInterface annotation");
        }
        Guid.GUID gUID = this.discoverClsId(comObject);
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = OleAuto.INSTANCE.GetActiveObject(gUID, null, pointerByReference);
        COMUtils.checkRC(hRESULT);
        Dispatch dispatch = new Dispatch(pointerByReference.getValue());
        T t2 = this.createProxy(clazz, dispatch);
        dispatch.Release();
        return t2;
    }

    Guid.GUID discoverClsId(ComObject comObject) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        String string = comObject.clsId();
        String string2 = comObject.progId();
        if (null != string && !string.isEmpty()) {
            return new Guid.CLSID(string);
        }
        if (null != string2 && !string2.isEmpty()) {
            Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
            WinNT.HRESULT hRESULT = Ole32.INSTANCE.CLSIDFromProgID(string2, byReference);
            COMUtils.checkRC(hRESULT);
            return byReference;
        }
        throw new COMException("ComObject must define a value for either clsId or progId");
    }

    IDispatchCallback createDispatchCallback(Class<?> clazz, IComEventCallbackListener iComEventCallbackListener) {
        return new CallbackProxy(this, clazz, iComEventCallbackListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void register(ProxyObject proxyObject) {
        List<WeakReference<ProxyObject>> list = this.registeredObjects;
        synchronized (list) {
            this.registeredObjects.add(new WeakReference<ProxyObject>(proxyObject));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregister(ProxyObject proxyObject) {
        List<WeakReference<ProxyObject>> list = this.registeredObjects;
        synchronized (list) {
            Iterator<WeakReference<ProxyObject>> iterator = this.registeredObjects.iterator();
            while (iterator.hasNext()) {
                WeakReference<ProxyObject> weakReference = iterator.next();
                ProxyObject proxyObject2 = (ProxyObject)weakReference.get();
                if (proxyObject2 != null && proxyObject2 != proxyObject) continue;
                iterator.remove();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void disposeAll() {
        List<WeakReference<ProxyObject>> list = this.registeredObjects;
        synchronized (list) {
            ArrayList<WeakReference<ProxyObject>> arrayList = new ArrayList<WeakReference<ProxyObject>>(this.registeredObjects);
            for (WeakReference weakReference : arrayList) {
                ProxyObject proxyObject = (ProxyObject)weakReference.get();
                if (proxyObject == null) continue;
                proxyObject.dispose();
            }
            this.registeredObjects.clear();
        }
    }

    public WinDef.LCID getLCID() {
        if (this.LCID != null) {
            return this.LCID;
        }
        return LOCALE_USER_DEFAULT;
    }

    public void setLCID(WinDef.LCID lCID) {
        this.LCID = lCID;
    }
}

