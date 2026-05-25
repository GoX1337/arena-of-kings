/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.DispatchListener;
import com.sun.jna.platform.win32.COM.IDispatchCallback;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.COM.util.Convert;
import com.sun.jna.platform.win32.COM.util.IComEventCallbackListener;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.COM.util.annotation.ComEventCallback;
import com.sun.jna.platform.win32.COM.util.annotation.ComInterface;
import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CallbackProxy
implements IDispatchCallback {
    private static boolean DEFAULT_BOOLEAN;
    private static byte DEFAULT_BYTE;
    private static short DEFAULT_SHORT;
    private static int DEFAULT_INT;
    private static long DEFAULT_LONG;
    private static float DEFAULT_FLOAT;
    private static double DEFAULT_DOUBLE;
    ObjectFactory factory;
    Class<?> comEventCallbackInterface;
    IComEventCallbackListener comEventCallbackListener;
    Guid.REFIID listenedToRiid;
    public DispatchListener dispatchListener;
    Map<OaIdl.DISPID, Method> dsipIdMap;

    public CallbackProxy(ObjectFactory objectFactory, Class<?> clazz, IComEventCallbackListener iComEventCallbackListener) {
        this.factory = objectFactory;
        this.comEventCallbackInterface = clazz;
        this.comEventCallbackListener = iComEventCallbackListener;
        this.listenedToRiid = this.createRIID(clazz);
        this.dsipIdMap = this.createDispIdMap(clazz);
        this.dispatchListener = new DispatchListener(this);
    }

    Guid.REFIID createRIID(Class<?> clazz) {
        ComInterface comInterface = clazz.getAnnotation(ComInterface.class);
        if (null == comInterface) {
            throw new COMException("advise: Interface must define a value for either iid via the ComInterface annotation");
        }
        String string = comInterface.iid();
        if (null == string || string.isEmpty()) {
            throw new COMException("ComInterface must define a value for iid");
        }
        return new Guid.REFIID(new Guid.IID(string).getPointer());
    }

    Map<OaIdl.DISPID, Method> createDispIdMap(Class<?> clazz) {
        HashMap<OaIdl.DISPID, Method> hashMap = new HashMap<OaIdl.DISPID, Method>();
        for (Method method : clazz.getMethods()) {
            int n2;
            ComEventCallback comEventCallback = method.getAnnotation(ComEventCallback.class);
            ComMethod comMethod = method.getAnnotation(ComMethod.class);
            if (comMethod != null) {
                n2 = comMethod.dispId();
                if (-1 == n2) {
                    n2 = this.fetchDispIdFromName(comEventCallback);
                }
                if (n2 == -1) {
                    this.comEventCallbackListener.errorReceivingCallbackEvent("DISPID for " + method.getName() + " not found", null);
                }
                hashMap.put(new OaIdl.DISPID(n2), method);
                continue;
            }
            if (null == comEventCallback) continue;
            n2 = comEventCallback.dispid();
            if (-1 == n2) {
                n2 = this.fetchDispIdFromName(comEventCallback);
            }
            if (n2 == -1) {
                this.comEventCallbackListener.errorReceivingCallbackEvent("DISPID for " + method.getName() + " not found", null);
            }
            hashMap.put(new OaIdl.DISPID(n2), method);
        }
        return hashMap;
    }

    int fetchDispIdFromName(ComEventCallback comEventCallback) {
        return -1;
    }

    void invokeOnThread(OaIdl.DISPID dISPID, Guid.REFIID rEFIID, WinDef.LCID lCID, WinDef.WORD wORD, OleAuto.DISPPARAMS.ByReference byReference) {
        Object[] objectArray;
        int n2;
        Variant.VARIANT[] vARIANTArray = byReference.getArgs();
        Method method = this.dsipIdMap.get(dISPID);
        if (method == null) {
            this.comEventCallbackListener.errorReceivingCallbackEvent("No method found with dispId = " + dISPID, null);
            return;
        }
        OaIdl.DISPID[] dISPIDArray = byReference.getRgdispidNamedArgs();
        Class<?>[] classArray = method.getParameterTypes();
        Object[] objectArray2 = new Object[classArray.length];
        for (n2 = 0; n2 < objectArray2.length && vARIANTArray.length - dISPIDArray.length - n2 > 0; ++n2) {
            Class<?> clazz = classArray[n2];
            objectArray = vARIANTArray[vARIANTArray.length - n2 - 1];
            objectArray2[n2] = Convert.toJavaObject((Variant.VARIANT)objectArray, clazz, this.factory, true, false);
        }
        for (n2 = 0; n2 < dISPIDArray.length; ++n2) {
            int n3 = dISPIDArray[n2].intValue();
            if (n3 >= objectArray2.length) continue;
            objectArray = classArray[n3];
            Variant.VARIANT vARIANT = vARIANTArray[n2];
            objectArray2[n3] = Convert.toJavaObject(vARIANT, objectArray, this.factory, true, false);
        }
        for (n2 = 0; n2 < objectArray2.length; ++n2) {
            if (objectArray2[n2] != null || !classArray[n2].isPrimitive()) continue;
            if (classArray[n2].equals(Boolean.TYPE)) {
                objectArray2[n2] = DEFAULT_BOOLEAN;
                continue;
            }
            if (classArray[n2].equals(Byte.TYPE)) {
                objectArray2[n2] = DEFAULT_BYTE;
                continue;
            }
            if (classArray[n2].equals(Short.TYPE)) {
                objectArray2[n2] = DEFAULT_SHORT;
                continue;
            }
            if (classArray[n2].equals(Integer.TYPE)) {
                objectArray2[n2] = DEFAULT_INT;
                continue;
            }
            if (classArray[n2].equals(Long.TYPE)) {
                objectArray2[n2] = DEFAULT_LONG;
                continue;
            }
            if (classArray[n2].equals(Float.TYPE)) {
                objectArray2[n2] = Float.valueOf(DEFAULT_FLOAT);
                continue;
            }
            if (classArray[n2].equals(Double.TYPE)) {
                objectArray2[n2] = DEFAULT_DOUBLE;
                continue;
            }
            throw new IllegalArgumentException("Class type " + classArray[n2].getName() + " not mapped to primitive default value.");
        }
        try {
            method.invoke((Object)this.comEventCallbackListener, objectArray2);
        }
        catch (Exception exception) {
            ArrayList<String> arrayList = new ArrayList<String>(objectArray2.length);
            for (Object object : objectArray2) {
                if (object == null) {
                    arrayList.add("NULL");
                    continue;
                }
                arrayList.add(object.getClass().getName());
            }
            this.comEventCallbackListener.errorReceivingCallbackEvent("Exception invoking method " + method + " supplied: " + ((Object)arrayList).toString(), exception);
        }
    }

    @Override
    public Pointer getPointer() {
        return this.dispatchListener.getPointer();
    }

    @Override
    public WinNT.HRESULT GetTypeInfoCount(WinDef.UINTByReference uINTByReference) {
        return new WinNT.HRESULT(-2147467263);
    }

    @Override
    public WinNT.HRESULT GetTypeInfo(WinDef.UINT uINT, WinDef.LCID lCID, PointerByReference pointerByReference) {
        return new WinNT.HRESULT(-2147467263);
    }

    @Override
    public WinNT.HRESULT GetIDsOfNames(Guid.REFIID rEFIID, WString[] wStringArray, int n2, WinDef.LCID lCID, OaIdl.DISPIDByReference dISPIDByReference) {
        return new WinNT.HRESULT(-2147467263);
    }

    @Override
    public WinNT.HRESULT Invoke(OaIdl.DISPID dISPID, Guid.REFIID rEFIID, WinDef.LCID lCID, WinDef.WORD wORD, OleAuto.DISPPARAMS.ByReference byReference, Variant.VARIANT.ByReference byReference2, OaIdl.EXCEPINFO.ByReference byReference3, IntByReference intByReference) {
        assert (COMUtils.comIsInitialized()) : "Assumption about COM threading broken.";
        this.invokeOnThread(dISPID, rEFIID, lCID, wORD, byReference);
        return WinError.S_OK;
    }

    @Override
    public WinNT.HRESULT QueryInterface(Guid.REFIID rEFIID, PointerByReference pointerByReference) {
        if (null == pointerByReference) {
            return new WinNT.HRESULT(-2147467261);
        }
        if (rEFIID.equals(this.listenedToRiid)) {
            pointerByReference.setValue(this.getPointer());
            return WinError.S_OK;
        }
        if (rEFIID.getValue().equals(Unknown.IID_IUNKNOWN)) {
            pointerByReference.setValue(this.getPointer());
            return WinError.S_OK;
        }
        if (rEFIID.getValue().equals(Dispatch.IID_IDISPATCH)) {
            pointerByReference.setValue(this.getPointer());
            return WinError.S_OK;
        }
        return new WinNT.HRESULT(-2147467262);
    }

    @Override
    public int AddRef() {
        return 0;
    }

    @Override
    public int Release() {
        return 0;
    }
}

