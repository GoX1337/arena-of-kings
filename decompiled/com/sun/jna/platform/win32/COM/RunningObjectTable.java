/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.COM.IRunningObjectTable;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public class RunningObjectTable
extends Unknown
implements IRunningObjectTable {
    public RunningObjectTable() {
    }

    public RunningObjectTable(Pointer pointer) {
        super(pointer);
    }

    @Override
    public WinNT.HRESULT Register(WinDef.DWORD dWORD, Pointer pointer, Pointer pointer2, WinDef.DWORDByReference dWORDByReference) {
        int n2 = 3;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(3, new Object[]{this.getPointer(), dWORD, pointer, pointer2, dWORDByReference}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT Revoke(WinDef.DWORD dWORD) {
        int n2 = 4;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(4, new Object[]{this.getPointer(), dWORD}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT IsRunning(Pointer pointer) {
        int n2 = 5;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(5, new Object[]{this.getPointer(), pointer}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT GetObject(Pointer pointer, PointerByReference pointerByReference) {
        int n2 = 6;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(6, new Object[]{this.getPointer(), pointer, pointerByReference}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT NoteChangeTime(WinDef.DWORD dWORD, WinBase.FILETIME fILETIME) {
        int n2 = 7;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(7, new Object[]{this.getPointer(), dWORD, fILETIME}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT GetTimeOfLastChange(Pointer pointer, WinBase.FILETIME.ByReference byReference) {
        int n2 = 8;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(8, new Object[]{this.getPointer(), pointer, byReference}, WinNT.HRESULT.class);
        return hRESULT;
    }

    @Override
    public WinNT.HRESULT EnumRunning(PointerByReference pointerByReference) {
        int n2 = 9;
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(9, new Object[]{this.getPointer(), pointerByReference}, WinNT.HRESULT.class);
        return hRESULT;
    }

    public static class ByReference
    extends RunningObjectTable
    implements Structure.ByReference {
    }
}

