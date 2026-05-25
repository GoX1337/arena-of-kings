/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OaIdlUtil;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public interface Wbemcli {
    public static final int WBEM_FLAG_RETURN_IMMEDIATELY = 16;
    public static final int WBEM_FLAG_FORWARD_ONLY = 32;
    public static final int WBEM_INFINITE = -1;
    public static final int WBEM_S_NO_ERROR = 0;
    public static final int WBEM_S_FALSE = 1;
    public static final int WBEM_S_TIMEDOUT = 262148;
    public static final int WBEM_S_NO_MORE_DATA = 262149;
    public static final int WBEM_E_INVALID_NAMESPACE = -2147217394;
    public static final int WBEM_E_INVALID_CLASS = -2147217392;
    public static final int WBEM_E_INVALID_QUERY = -2147217385;
    public static final int CIM_ILLEGAL = 4095;
    public static final int CIM_EMPTY = 0;
    public static final int CIM_SINT8 = 16;
    public static final int CIM_UINT8 = 17;
    public static final int CIM_SINT16 = 2;
    public static final int CIM_UINT16 = 18;
    public static final int CIM_SINT32 = 3;
    public static final int CIM_UINT32 = 19;
    public static final int CIM_SINT64 = 20;
    public static final int CIM_UINT64 = 21;
    public static final int CIM_REAL32 = 4;
    public static final int CIM_REAL64 = 5;
    public static final int CIM_BOOLEAN = 11;
    public static final int CIM_STRING = 8;
    public static final int CIM_DATETIME = 101;
    public static final int CIM_REFERENCE = 102;
    public static final int CIM_CHAR16 = 103;
    public static final int CIM_OBJECT = 13;
    public static final int CIM_FLAG_ARRAY = 8192;

    public static class IWbemContext
    extends Unknown {
        public IWbemContext() {
        }

        public IWbemContext(Pointer pointer) {
            super(pointer);
        }
    }

    public static class IWbemServices
    extends Unknown {
        public IWbemServices() {
        }

        public IWbemServices(Pointer pointer) {
            super(pointer);
        }

        public WinNT.HRESULT ExecQuery(WTypes.BSTR bSTR, WTypes.BSTR bSTR2, int n2, IWbemContext iWbemContext, PointerByReference pointerByReference) {
            return (WinNT.HRESULT)this._invokeNativeObject(20, new Object[]{this.getPointer(), bSTR, bSTR2, n2, iWbemContext, pointerByReference}, WinNT.HRESULT.class);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public IEnumWbemClassObject ExecQuery(String string, String string2, int n2, IWbemContext iWbemContext) {
            WTypes.BSTR bSTR = OleAuto.INSTANCE.SysAllocString(string);
            WTypes.BSTR bSTR2 = OleAuto.INSTANCE.SysAllocString(string2);
            try {
                PointerByReference pointerByReference = new PointerByReference();
                WinNT.HRESULT hRESULT = this.ExecQuery(bSTR, bSTR2, n2, iWbemContext, pointerByReference);
                COMUtils.checkRC(hRESULT);
                IEnumWbemClassObject iEnumWbemClassObject = new IEnumWbemClassObject(pointerByReference.getValue());
                return iEnumWbemClassObject;
            }
            finally {
                OleAuto.INSTANCE.SysFreeString(bSTR);
                OleAuto.INSTANCE.SysFreeString(bSTR2);
            }
        }
    }

    public static class IWbemLocator
    extends Unknown {
        public static final Guid.CLSID CLSID_WbemLocator = new Guid.CLSID("4590f811-1d3a-11d0-891f-00aa004b2e24");
        public static final Guid.GUID IID_IWbemLocator = new Guid.GUID("dc12a687-737f-11cf-884d-00aa004b2e24");

        public IWbemLocator() {
        }

        private IWbemLocator(Pointer pointer) {
            super(pointer);
        }

        public static IWbemLocator create() {
            PointerByReference pointerByReference = new PointerByReference();
            WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateInstance(CLSID_WbemLocator, null, 1, IID_IWbemLocator, pointerByReference);
            if (COMUtils.FAILED(hRESULT)) {
                return null;
            }
            return new IWbemLocator(pointerByReference.getValue());
        }

        public WinNT.HRESULT ConnectServer(WTypes.BSTR bSTR, WTypes.BSTR bSTR2, WTypes.BSTR bSTR3, WTypes.BSTR bSTR4, int n2, WTypes.BSTR bSTR5, IWbemContext iWbemContext, PointerByReference pointerByReference) {
            return (WinNT.HRESULT)this._invokeNativeObject(3, new Object[]{this.getPointer(), bSTR, bSTR2, bSTR3, bSTR4, n2, bSTR5, iWbemContext, pointerByReference}, WinNT.HRESULT.class);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public IWbemServices ConnectServer(String string, String string2, String string3, String string4, int n2, String string5, IWbemContext iWbemContext) {
            WTypes.BSTR bSTR = OleAuto.INSTANCE.SysAllocString(string);
            WTypes.BSTR bSTR2 = OleAuto.INSTANCE.SysAllocString(string2);
            WTypes.BSTR bSTR3 = OleAuto.INSTANCE.SysAllocString(string3);
            WTypes.BSTR bSTR4 = OleAuto.INSTANCE.SysAllocString(string4);
            WTypes.BSTR bSTR5 = OleAuto.INSTANCE.SysAllocString(string5);
            PointerByReference pointerByReference = new PointerByReference();
            try {
                WinNT.HRESULT hRESULT = this.ConnectServer(bSTR, bSTR2, bSTR3, bSTR4, n2, bSTR5, iWbemContext, pointerByReference);
                COMUtils.checkRC(hRESULT);
                IWbemServices iWbemServices = new IWbemServices(pointerByReference.getValue());
                return iWbemServices;
            }
            finally {
                OleAuto.INSTANCE.SysFreeString(bSTR);
                OleAuto.INSTANCE.SysFreeString(bSTR2);
                OleAuto.INSTANCE.SysFreeString(bSTR3);
                OleAuto.INSTANCE.SysFreeString(bSTR4);
                OleAuto.INSTANCE.SysFreeString(bSTR5);
            }
        }
    }

    public static class IEnumWbemClassObject
    extends Unknown {
        public IEnumWbemClassObject() {
        }

        public IEnumWbemClassObject(Pointer pointer) {
            super(pointer);
        }

        public WinNT.HRESULT Next(int n2, int n3, Pointer[] pointerArray, IntByReference intByReference) {
            return (WinNT.HRESULT)this._invokeNativeObject(4, new Object[]{this.getPointer(), n2, n3, pointerArray, intByReference}, WinNT.HRESULT.class);
        }

        public IWbemClassObject[] Next(int n2, int n3) {
            Pointer[] pointerArray = new Pointer[n3];
            IntByReference intByReference = new IntByReference();
            WinNT.HRESULT hRESULT = this.Next(n2, n3, pointerArray, intByReference);
            COMUtils.checkRC(hRESULT);
            IWbemClassObject[] iWbemClassObjectArray = new IWbemClassObject[intByReference.getValue()];
            for (int i2 = 0; i2 < intByReference.getValue(); ++i2) {
                iWbemClassObjectArray[i2] = new IWbemClassObject(pointerArray[i2]);
            }
            return iWbemClassObjectArray;
        }
    }

    public static class IWbemClassObject
    extends Unknown {
        public IWbemClassObject() {
        }

        public IWbemClassObject(Pointer pointer) {
            super(pointer);
        }

        public WinNT.HRESULT Get(WString wString, int n2, Variant.VARIANT.ByReference byReference, IntByReference intByReference, IntByReference intByReference2) {
            return (WinNT.HRESULT)this._invokeNativeObject(4, new Object[]{this.getPointer(), wString, n2, byReference, intByReference, intByReference2}, WinNT.HRESULT.class);
        }

        public WinNT.HRESULT Get(String string, int n2, Variant.VARIANT.ByReference byReference, IntByReference intByReference, IntByReference intByReference2) {
            return this.Get(string == null ? null : new WString(string), n2, byReference, intByReference, intByReference2);
        }

        public WinNT.HRESULT GetNames(String string, int n2, Variant.VARIANT.ByReference byReference, PointerByReference pointerByReference) {
            return this.GetNames(string == null ? null : new WString(string), n2, byReference, pointerByReference);
        }

        public WinNT.HRESULT GetNames(WString wString, int n2, Variant.VARIANT.ByReference byReference, PointerByReference pointerByReference) {
            return (WinNT.HRESULT)this._invokeNativeObject(7, new Object[]{this.getPointer(), wString, n2, byReference, pointerByReference}, WinNT.HRESULT.class);
        }

        public String[] GetNames(String string, int n2, Variant.VARIANT.ByReference byReference) {
            PointerByReference pointerByReference = new PointerByReference();
            COMUtils.checkRC(this.GetNames(string, n2, byReference, pointerByReference));
            Object[] objectArray = (Object[])OaIdlUtil.toPrimitiveArray(new OaIdl.SAFEARRAY(pointerByReference.getValue()), true);
            String[] stringArray = new String[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                stringArray[i2] = (String)objectArray[i2];
            }
            return stringArray;
        }
    }

    public static interface WBEM_CONDITION_FLAG_TYPE {
        public static final int WBEM_FLAG_ALWAYS = 0;
        public static final int WBEM_FLAG_ONLY_IF_TRUE = 1;
        public static final int WBEM_FLAG_ONLY_IF_FALSE = 2;
        public static final int WBEM_FLAG_ONLY_IF_IDENTICAL = 3;
        public static final int WBEM_MASK_PRIMARY_CONDITION = 3;
        public static final int WBEM_FLAG_KEYS_ONLY = 4;
        public static final int WBEM_FLAG_REFS_ONLY = 8;
        public static final int WBEM_FLAG_LOCAL_ONLY = 16;
        public static final int WBEM_FLAG_PROPAGATED_ONLY = 32;
        public static final int WBEM_FLAG_SYSTEM_ONLY = 48;
        public static final int WBEM_FLAG_NONSYSTEM_ONLY = 64;
        public static final int WBEM_MASK_CONDITION_ORIGIN = 112;
        public static final int WBEM_FLAG_CLASS_OVERRIDES_ONLY = 256;
        public static final int WBEM_FLAG_CLASS_LOCAL_AND_OVERRIDES = 512;
        public static final int WBEM_MASK_CLASS_CONDITION = 768;
    }
}

