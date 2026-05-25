/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.VerRsrc;
import com.sun.jna.platform.win32.Version;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public class VersionUtil {
    public static VerRsrc.VS_FIXEDFILEINFO getFileVersionInfo(String string) {
        IntByReference intByReference = new IntByReference();
        int n2 = Version.INSTANCE.GetFileVersionInfoSize(string, intByReference);
        if (n2 == 0) {
            throw new Win32Exception(Native.getLastError());
        }
        Memory memory = new Memory(n2);
        PointerByReference pointerByReference = new PointerByReference();
        if (!Version.INSTANCE.GetFileVersionInfo(string, 0, n2, memory)) {
            throw new Win32Exception(Native.getLastError());
        }
        IntByReference intByReference2 = new IntByReference();
        if (!Version.INSTANCE.VerQueryValue(memory, "\\", pointerByReference, intByReference2)) {
            throw new UnsupportedOperationException("Unable to extract version info from the file: \"" + string + "\"");
        }
        VerRsrc.VS_FIXEDFILEINFO vS_FIXEDFILEINFO = new VerRsrc.VS_FIXEDFILEINFO(pointerByReference.getValue());
        vS_FIXEDFILEINFO.read();
        return vS_FIXEDFILEINFO;
    }
}

