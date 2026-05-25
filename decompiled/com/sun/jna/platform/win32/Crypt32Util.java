/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Crypt32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinCrypt;
import com.sun.jna.ptr.PointerByReference;

public abstract class Crypt32Util {
    public static byte[] cryptProtectData(byte[] byArray) {
        return Crypt32Util.cryptProtectData(byArray, 0);
    }

    public static byte[] cryptProtectData(byte[] byArray, int n2) {
        return Crypt32Util.cryptProtectData(byArray, null, n2, "", null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] cryptProtectData(byte[] byArray, byte[] byArray2, int n2, String string, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT) {
        WinCrypt.DATA_BLOB dATA_BLOB = new WinCrypt.DATA_BLOB(byArray);
        WinCrypt.DATA_BLOB dATA_BLOB2 = new WinCrypt.DATA_BLOB();
        WinCrypt.DATA_BLOB dATA_BLOB3 = byArray2 == null ? null : new WinCrypt.DATA_BLOB(byArray2);
        try {
            if (!Crypt32.INSTANCE.CryptProtectData(dATA_BLOB, string, dATA_BLOB3, null, cRYPTPROTECT_PROMPTSTRUCT, n2, dATA_BLOB2)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            byte[] byArray3 = dATA_BLOB2.getData();
            return byArray3;
        }
        finally {
            if (dATA_BLOB2.pbData != null) {
                Kernel32Util.freeLocalMemory(dATA_BLOB2.pbData);
            }
        }
    }

    public static byte[] cryptUnprotectData(byte[] byArray) {
        return Crypt32Util.cryptUnprotectData(byArray, 0);
    }

    public static byte[] cryptUnprotectData(byte[] byArray, int n2) {
        return Crypt32Util.cryptUnprotectData(byArray, null, n2, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] cryptUnprotectData(byte[] byArray, byte[] byArray2, int n2, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT) {
        WinCrypt.DATA_BLOB dATA_BLOB = new WinCrypt.DATA_BLOB(byArray);
        WinCrypt.DATA_BLOB dATA_BLOB2 = new WinCrypt.DATA_BLOB();
        WinCrypt.DATA_BLOB dATA_BLOB3 = byArray2 == null ? null : new WinCrypt.DATA_BLOB(byArray2);
        PointerByReference pointerByReference = new PointerByReference();
        Win32Exception win32Exception = null;
        byte[] byArray3 = null;
        try {
            if (!Crypt32.INSTANCE.CryptUnprotectData(dATA_BLOB, pointerByReference, dATA_BLOB3, null, cRYPTPROTECT_PROMPTSTRUCT, n2, dATA_BLOB2)) {
                win32Exception = new Win32Exception(Kernel32.INSTANCE.GetLastError());
            } else {
                byArray3 = dATA_BLOB2.getData();
            }
        }
        finally {
            if (dATA_BLOB2.pbData != null) {
                try {
                    Kernel32Util.freeLocalMemory(dATA_BLOB2.pbData);
                }
                catch (Win32Exception win32Exception2) {
                    if (win32Exception == null) {
                        win32Exception = win32Exception2;
                    }
                    win32Exception.addSuppressedReflected(win32Exception2);
                }
            }
            if (pointerByReference.getValue() != null) {
                try {
                    Kernel32Util.freeLocalMemory(pointerByReference.getValue());
                }
                catch (Win32Exception win32Exception3) {
                    if (win32Exception == null) {
                        win32Exception = win32Exception3;
                    }
                    win32Exception.addSuppressedReflected(win32Exception3);
                }
            }
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return byArray3;
    }

    public static String CertNameToStr(int n2, int n3, WinCrypt.DATA_BLOB dATA_BLOB) {
        int n4 = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
        int n5 = Crypt32.INSTANCE.CertNameToStr(n2, dATA_BLOB, n3, Pointer.NULL, 0);
        Memory memory = new Memory(n5 * n4);
        int n6 = Crypt32.INSTANCE.CertNameToStr(n2, dATA_BLOB, n3, memory, n5);
        assert (n6 == n5);
        if (Boolean.getBoolean("w32.ascii")) {
            return memory.getString(0L);
        }
        return memory.getWideString(0L);
    }
}

