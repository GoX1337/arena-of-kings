/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.IEnumMoniker;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public class EnumMoniker
extends Unknown
implements IEnumMoniker {
    public EnumMoniker(Pointer pointer) {
        super(pointer);
    }

    @Override
    public WinNT.HRESULT Next(WinDef.ULONG uLONG, PointerByReference pointerByReference, WinDef.ULONGByReference uLONGByReference) {
        int n2 = 3;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(3, new Object[]{this.getPointer(), uLONG, pointerByReference, uLONGByReference}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT Skip(WinDef.ULONG uLONG) {
        int n2 = 4;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(4, new Object[]{this.getPointer(), uLONG}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT Reset() {
        int n2 = 5;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(5, new Object[]{this.getPointer()}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT Clone(PointerByReference pointerByReference) {
        int n2 = 6;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(6, new Object[]{this.getPointer(), pointerByReference}, WinNT.HRESULT.class);
        return hRESULT;
    }
}

