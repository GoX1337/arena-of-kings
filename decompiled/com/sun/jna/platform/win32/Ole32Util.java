/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.platform.win32.WinNT;

public abstract class Ole32Util {
    public static Guid.GUID getGUIDFromString(String string) {
        Guid.GUID gUID = new Guid.GUID();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.IIDFromString(string, gUID);
        if (!hRESULT.equals(W32Errors.S_OK)) {
            throw new RuntimeException(hRESULT.toString());
        }
        return gUID;
    }

    public static String getStringFromGUID(Guid.GUID gUID) {
        int n2;
        char[] cArray;
        Guid.GUID gUID2 = new Guid.GUID(gUID.getPointer());
        int n3 = Ole32.INSTANCE.StringFromGUID2(gUID2, cArray = new char[n2 = 39], n2);
        if (n3 == 0) {
            throw new RuntimeException("StringFromGUID2");
        }
        cArray[n3 - 1] = '\u0000';
        return Native.toString(cArray);
    }

    public static Guid.GUID generateGUID() {
        Guid.GUID gUID = new Guid.GUID();
        WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoCreateGuid(gUID);
        if (!hRESULT.equals(W32Errors.S_OK)) {
            throw new RuntimeException(hRESULT.toString());
        }
        return gUID;
    }
}

