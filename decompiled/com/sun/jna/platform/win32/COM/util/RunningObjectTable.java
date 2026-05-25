/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.util;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.util.EnumMoniker;
import com.sun.jna.platform.win32.COM.util.IDispatch;
import com.sun.jna.platform.win32.COM.util.IRunningObjectTable;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;
import java.util.List;

public class RunningObjectTable
implements IRunningObjectTable {
    ObjectFactory factory;
    com.sun.jna.platform.win32.COM.RunningObjectTable raw;

    protected RunningObjectTable(com.sun.jna.platform.win32.COM.RunningObjectTable runningObjectTable, ObjectFactory objectFactory) {
        this.raw = runningObjectTable;
        this.factory = objectFactory;
    }

    @Override
    public Iterable<IDispatch> enumRunning() {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        PointerByReference pointerByReference = new PointerByReference();
        WinNT.HRESULT hRESULT = this.raw.EnumRunning(pointerByReference);
        COMUtils.checkRC(hRESULT);
        com.sun.jna.platform.win32.COM.EnumMoniker enumMoniker = new com.sun.jna.platform.win32.COM.EnumMoniker(pointerByReference.getValue());
        return new EnumMoniker(enumMoniker, this.raw, this.factory);
    }

    @Override
    public <T> List<T> getActiveObjectsByInterface(Class<T> clazz) {
        assert (COMUtils.comIsInitialized()) : "COM not initialized";
        ArrayList<T> arrayList = new ArrayList<T>();
        for (IDispatch iDispatch : this.enumRunning()) {
            try {
                T t2 = iDispatch.queryInterface(clazz);
                arrayList.add(t2);
            }
            catch (COMException cOMException) {}
        }
        return arrayList;
    }
}

