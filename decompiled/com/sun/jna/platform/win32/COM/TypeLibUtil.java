/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.ITypeInfo;
import com.sun.jna.platform.win32.COM.ITypeLib;
import com.sun.jna.platform.win32.COM.TypeComp;
import com.sun.jna.platform.win32.COM.TypeInfo;
import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLib;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public class TypeLibUtil {
    public static final OleAuto OLEAUTO = OleAuto.INSTANCE;
    private ITypeLib typelib;
    private WinDef.LCID lcid = Kernel32.INSTANCE.GetUserDefaultLCID();
    private String name;
    private String docString;
    private int helpContext;
    private String helpFile;

    public TypeLibUtil(String string, int n2, int n3) {
        Guid.CLSID.ByReference byReference = new Guid.CLSID.ByReference();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.CLSIDFromString(string, byReference);
        COMUtils.checkRC(hRESULT);
        PointerByReference pointerByReference = new PointerByReference();
        hRESULT = OleAuto.INSTANCE.LoadRegTypeLib(byReference, n2, n3, this.lcid, pointerByReference);
        COMUtils.checkRC(hRESULT);
        this.typelib = new TypeLib(pointerByReference.getValue());
        this.initTypeLibInfo();
    }

    public TypeLibUtil(String string) {
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = OleAuto.INSTANCE.LoadTypeLib(string, pointerByReference);
        COMUtils.checkRC(hRESULT);
        this.typelib = new TypeLib(pointerByReference.getValue());
        this.initTypeLibInfo();
    }

    private void initTypeLibInfo() {
        TypeLibDoc typeLibDoc = this.getDocumentation(-1);
        this.name = typeLibDoc.getName();
        this.docString = typeLibDoc.getDocString();
        this.helpContext = typeLibDoc.getHelpContext();
        this.helpFile = typeLibDoc.getHelpFile();
    }

    public int getTypeInfoCount() {
        return this.typelib.GetTypeInfoCount().intValue();
    }

    public OaIdl.TYPEKIND getTypeInfoType(int n2) {
        OaIdl.TYPEKIND.ByReference byReference = new OaIdl.TYPEKIND.ByReference();
        WinNT.HRESULT hRESULT = this.typelib.GetTypeInfoType(new WinDef.UINT((long)n2), byReference);
        COMUtils.checkRC(hRESULT);
        return byReference;
    }

    public ITypeInfo getTypeInfo(int n2) {
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = this.typelib.GetTypeInfo(new WinDef.UINT((long)n2), pointerByReference);
        COMUtils.checkRC(hRESULT);
        return new TypeInfo(pointerByReference.getValue());
    }

    public TypeInfoUtil getTypeInfoUtil(int n2) {
        return new TypeInfoUtil(this.getTypeInfo(n2));
    }

    public OaIdl.TLIBATTR getLibAttr() {
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = this.typelib.GetLibAttr(pointerByReference);
        COMUtils.checkRC(hRESULT);
        return new OaIdl.TLIBATTR(pointerByReference.getValue());
    }

    public TypeComp GetTypeComp() {
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = this.typelib.GetTypeComp(pointerByReference);
        COMUtils.checkRC(hRESULT);
        return new TypeComp(pointerByReference.getValue());
    }

    public TypeLibDoc getDocumentation(int n2) {
        WTypes.BSTRByReference bSTRByReference = new WTypes.BSTRByReference();
        WTypes.BSTRByReference bSTRByReference2 = new WTypes.BSTRByReference();
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
        WTypes.BSTRByReference bSTRByReference3 = new WTypes.BSTRByReference();
        WinNT.HRESULT hRESULT = this.typelib.GetDocumentation(n2, bSTRByReference, bSTRByReference2, dWORDByReference, bSTRByReference3);
        COMUtils.checkRC(hRESULT);
        TypeLibDoc typeLibDoc = new TypeLibDoc(bSTRByReference.getString(), bSTRByReference2.getString(), dWORDByReference.getValue().intValue(), bSTRByReference3.getString());
        OLEAUTO.SysFreeString(bSTRByReference.getValue());
        OLEAUTO.SysFreeString(bSTRByReference2.getValue());
        OLEAUTO.SysFreeString(bSTRByReference3.getValue());
        return typeLibDoc;
    }

    public IsName IsName(String string, int n2) {
        WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(string);
        WinDef.ULONG uLONG = new WinDef.ULONG((long)n2);
        WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
        WinNT.HRESULT hRESULT = this.typelib.IsName(lPOLESTR, uLONG, bOOLByReference);
        COMUtils.checkRC(hRESULT);
        return new IsName(lPOLESTR.getValue(), bOOLByReference.getValue().booleanValue());
    }

    public FindName FindName(String string, int n2, short s2) {
        Pointer pointer = Ole32.INSTANCE.CoTaskMemAlloc(((long)string.length() + 1L) * (long)Native.WCHAR_SIZE);
        WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(pointer);
        lPOLESTR.setValue(string);
        WinDef.ULONG uLONG = new WinDef.ULONG((long)n2);
        WinDef.USHORTByReference uSHORTByReference = new WinDef.USHORTByReference(s2);
        Pointer[] pointerArray = new Pointer[s2];
        OaIdl.MEMBERID[] mEMBERIDArray = new OaIdl.MEMBERID[s2];
        WinNT.HRESULT hRESULT = this.typelib.FindName(lPOLESTR, uLONG, pointerArray, mEMBERIDArray, uSHORTByReference);
        COMUtils.checkRC(hRESULT);
        FindName findName = new FindName(lPOLESTR.getValue(), pointerArray, mEMBERIDArray, uSHORTByReference.getValue().shortValue());
        Ole32.INSTANCE.CoTaskMemFree(pointer);
        return findName;
    }

    public void ReleaseTLibAttr(OaIdl.TLIBATTR tLIBATTR) {
        this.typelib.ReleaseTLibAttr(tLIBATTR);
    }

    public WinDef.LCID getLcid() {
        return this.lcid;
    }

    public ITypeLib getTypelib() {
        return this.typelib;
    }

    public String getName() {
        return this.name;
    }

    public String getDocString() {
        return this.docString;
    }

    public int getHelpContext() {
        return this.helpContext;
    }

    public String getHelpFile() {
        return this.helpFile;
    }

    public static class FindName {
        private String nameBuf;
        private Pointer[] pTInfo;
        private OaIdl.MEMBERID[] rgMemId;
        private short pcFound;

        FindName(String string, Pointer[] pointerArray, OaIdl.MEMBERID[] mEMBERIDArray, short s2) {
            this.nameBuf = string;
            this.pTInfo = new Pointer[s2];
            this.rgMemId = new OaIdl.MEMBERID[s2];
            this.pcFound = s2;
            System.arraycopy(pointerArray, 0, this.pTInfo, 0, s2);
            System.arraycopy(mEMBERIDArray, 0, this.rgMemId, 0, s2);
        }

        public String getNameBuf() {
            return this.nameBuf;
        }

        public ITypeInfo[] getTInfo() {
            ITypeInfo[] iTypeInfoArray = new ITypeInfo[this.pcFound];
            for (int i2 = 0; i2 < this.pcFound; ++i2) {
                iTypeInfoArray[i2] = new TypeInfo(this.pTInfo[i2]);
            }
            return iTypeInfoArray;
        }

        public OaIdl.MEMBERID[] getMemId() {
            return this.rgMemId;
        }

        public short getFound() {
            return this.pcFound;
        }
    }

    public static class IsName {
        private String nameBuf;
        private boolean name;

        public IsName(String string, boolean bl2) {
            this.nameBuf = string;
            this.name = bl2;
        }

        public String getNameBuf() {
            return this.nameBuf;
        }

        public boolean isName() {
            return this.name;
        }
    }

    public static class TypeLibDoc {
        private String name;
        private String docString;
        private int helpContext;
        private String helpFile;

        public TypeLibDoc(String string, String string2, int n2, String string3) {
            this.name = string;
            this.docString = string2;
            this.helpContext = n2;
            this.helpFile = string3;
        }

        public String getName() {
            return this.name;
        }

        public String getDocString() {
            return this.docString;
        }

        public int getHelpContext() {
            return this.helpContext;
        }

        public String getHelpFile() {
            return this.helpFile;
        }
    }
}

