/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Cfgmgr32;
import com.sun.jna.ptr.IntByReference;

public abstract class Cfgmgr32Util {
    public static String CM_Get_Device_ID(int n2) {
        int n3 = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
        IntByReference intByReference = new IntByReference();
        int n4 = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, n2, 0);
        if (n4 != 0) {
            throw new Cfgmgr32Exception(n4);
        }
        Memory memory = new Memory((intByReference.getValue() + 1) * n3);
        memory.clear();
        n4 = Cfgmgr32.INSTANCE.CM_Get_Device_ID(n2, memory, intByReference.getValue(), 0);
        if (n4 == 26) {
            n4 = Cfgmgr32.INSTANCE.CM_Get_Device_ID_Size(intByReference, n2, 0);
            if (n4 != 0) {
                throw new Cfgmgr32Exception(n4);
            }
            memory = new Memory((intByReference.getValue() + 1) * n3);
            memory.clear();
            n4 = Cfgmgr32.INSTANCE.CM_Get_Device_ID(n2, memory, intByReference.getValue(), 0);
        }
        if (n4 != 0) {
            throw new Cfgmgr32Exception(n4);
        }
        if (n3 == 1) {
            return memory.getString(0L);
        }
        return memory.getWideString(0L);
    }

    public static class Cfgmgr32Exception
    extends RuntimeException {
        private final int errorCode;

        public Cfgmgr32Exception(int n2) {
            this.errorCode = n2;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }
}

