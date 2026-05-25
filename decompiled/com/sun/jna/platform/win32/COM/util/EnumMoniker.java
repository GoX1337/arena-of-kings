/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Dispatch;
import com.sun.jna.platform.win32.COM.IEnumMoniker;
import com.sun.jna.platform.win32.COM.IRunningObjectTable;
import com.sun.jna.platform.win32.COM.Moniker;
import com.sun.jna.platform.win32.COM.util.IDispatch;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import java.util.Iterator;

public class EnumMoniker
implements Iterable<IDispatch> {
    ObjectFactory factory;
    IRunningObjectTable rawRot;
    IEnumMoniker raw;
    Moniker rawNext;

    protected EnumMoniker(IEnumMoniker iEnumMoniker, IRunningObjectTable iRunningObjectTable, ObjectFactory objectFactory) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        this.rawRot = iRunningObjectTable;
        this.raw = iEnumMoniker;
        this.factory = objectFactory;
        WinNT.HRESULT hRESULT = iEnumMoniker.Reset();
        COMUtils.checkRC(hRESULT);
        this.cacheNext();
    }

    protected void cacheNext() {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        PointerByReference pointerByReference = new PointerByReference();
        WinDef.ULONGByReference uLONGByReference = new WinDef.ULONGByReference();
        WinNT.HRESULT hRESULT = this.raw.Next(new WinDef.ULONG(1L), pointerByReference, uLONGByReference);
        if (WinNT.S_OK.equals(hRESULT) && uLONGByReference.getValue().intValue() > 0) {
            this.rawNext = new Moniker(pointerByReference.getValue());
        } else {
            if (!WinNT.S_FALSE.equals(hRESULT)) {
                COMUtils.checkRC(hRESULT);
            }
            this.rawNext = null;
        }
    }

    @Override
    public Iterator<IDispatch> iterator() {
        return new Iterator<IDispatch>(){

            @Override
            public boolean hasNext() {
                return null != EnumMoniker.this.rawNext;
            }

            @Override
            public IDispatch next() {
                assert (COMUtils.comIsInitialized()) : "COM not initialized";
                Moniker moniker = EnumMoniker.this.rawNext;
                PointerByReference pointerByReference = new PointerByReference();
                WinNT.HRESULT hRESULT = EnumMoniker.this.rawRot.GetObject(moniker.getPointer(), pointerByReference);
                COMUtils.checkRC(hRESULT);
                Dispatch dispatch = new Dispatch(pointerByReference.getValue());
                EnumMoniker.this.cacheNext();
                IDispatch iDispatch = EnumMoniker.this.factory.createProxy(IDispatch.class, dispatch);
                int n2 = dispatch.Release();
                return iDispatch;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        };
    }
}

