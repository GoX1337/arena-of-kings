/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.Shell32;
import com.sun.jna.platform.win32.ShlObj;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public abstract class Shell32Util {
    public static String getFolderPath(WinDef.HWND hWND, int n2, WinDef.DWORD dWORD) {
        char[] cArray = new char[260];
        WinNT.HRESULT hRESULT = Shell32.INSTANCE.SHGetFolderPath(hWND, n2, null, dWORD, cArray);
        if (!hRESULT.equals(W32Errors.S_OK)) {
            throw new Win32Exception(hRESULT);
        }
        return Native.toString(cArray);
    }

    public static String getFolderPath(int n2) {
        return Shell32Util.getFolderPath(null, n2, ShlObj.SHGFP_TYPE_CURRENT);
    }

    public static String getKnownFolderPath(Guid.GUID gUID) {
        PointerByReference pointerByReference;
        WinNT.HANDLE hANDLE;
        int n2 = ShlObj.KNOWN_FOLDER_FLAG.NONE.getFlag();
        WinNT.HRESULT hRESULT = Shell32.INSTANCE.SHGetKnownFolderPath(gUID, n2, hANDLE = null, pointerByReference = new PointerByReference());
        if (!W32Errors.SUCCEEDED(hRESULT.intValue())) {
            throw new Win32Exception(hRESULT);
        }
        String string = pointerByReference.getValue().getWideString(0L);
        Ole32.INSTANCE.CoTaskMemFree(pointerByReference.getValue());
        return string;
    }

    public static final String getSpecialFolderPath(int n2, boolean bl2) {
        char[] cArray = new char[260];
        if (!Shell32.INSTANCE.SHGetSpecialFolderPath(null, cArray, n2, bl2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArray);
    }
}

