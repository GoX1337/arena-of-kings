/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.IMoniker;
import com.sun.jna.platform.win32.COM.IStream;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public class Moniker
extends Unknown
implements IMoniker {
    static final int vTableIdStart = 7;

    public Moniker() {
    }

    public Moniker(Pointer pointer) {
        super(pointer);
    }

    @Override
    public void BindToObject() {
        int n2 = 8;
        throw new UnsupportedOperationException();
    }

    @Override
    public void BindToStorage() {
        int n2 = 9;
        throw new UnsupportedOperationException();
    }

    @Override
    public void Reduce() {
        int n2 = 10;
        throw new UnsupportedOperationException();
    }

    @Override
    public void ComposeWith() {
        int n2 = 11;
        throw new UnsupportedOperationException();
    }

    @Override
    public void Enum() {
        int n2 = 12;
        throw new UnsupportedOperationException();
    }

    @Override
    public void IsEqual() {
        int n2 = 13;
        throw new UnsupportedOperationException();
    }

    @Override
    public void Hash() {
        int n2 = 14;
        throw new UnsupportedOperationException();
    }

    @Override
    public void IsRunning() {
        int n2 = 15;
        throw new UnsupportedOperationException();
    }

    @Override
    public void GetTimeOfLastChange() {
        int n2 = 16;
        throw new UnsupportedOperationException();
    }

    @Override
    public void Inverse() {
        int n2 = 17;
        throw new UnsupportedOperationException();
    }

    @Override
    public void CommonPrefixWith() {
        int n2 = 18;
        throw new UnsupportedOperationException();
    }

    @Override
    public void RelativePathTo() {
        int n2 = 19;
        throw new UnsupportedOperationException();
    }

    @Override
    public String GetDisplayName(Pointer pointer, Pointer pointer2) {
        int n2 = 20;
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = (WinNT.HRESULT)this._invokeNativeObject(20, new Object[]{this.getPointer(), pointer, pointer2, pointerByReference}, WinNT.HRESULT.class);
        COMUtils.checkRC(hRESULT);
        Pointer pointer3 = pointerByReference.getValue();
        if (pointer3 == null) {
            return null;
        }
        WTypes.LPOLESTR lPOLESTR = new WTypes.LPOLESTR(pointer3);
        String string = lPOLESTR.getValue();
        Ole32.INSTANCE.CoTaskMemFree(pointer3);
        return string;
    }

    @Override
    public void ParseDisplayName() {
        int n2 = 21;
        throw new UnsupportedOperationException();
    }

    @Override
    public void IsSystemMoniker() {
        int n2 = 22;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean IsDirty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Load(IStream iStream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void Save(IStream iStream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void GetSizeMax() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Guid.CLSID GetClassID() {
        throw new UnsupportedOperationException();
    }

    public static class ByReference
    extends Moniker
    implements Structure.ByReference {
    }
}

