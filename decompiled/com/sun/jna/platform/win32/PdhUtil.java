/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Pdh;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinReg;
import java.util.ArrayList;
import java.util.List;

public abstract class PdhUtil {
    private static final int CHAR_TO_BYTES = Boolean.getBoolean("w32.ascii") ? 1 : Native.WCHAR_SIZE;
    private static final String ENGLISH_COUNTER_KEY = "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009";
    private static final String ENGLISH_COUNTER_VALUE = "Counter";

    public static String PdhLookupPerfNameByIndex(String string, int n2) {
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
        int n3 = Pdh.INSTANCE.PdhLookupPerfNameByIndex(string, n2, null, dWORDByReference);
        Pointer pointer = null;
        if (n3 != -1073738819) {
            if (n3 != 0 && n3 != -2147481646) {
                throw new PdhException(n3);
            }
            if (dWORDByReference.getValue().intValue() < 1) {
                return "";
            }
            pointer = new Memory(dWORDByReference.getValue().intValue() * CHAR_TO_BYTES);
            n3 = Pdh.INSTANCE.PdhLookupPerfNameByIndex(string, n2, pointer, dWORDByReference);
        } else {
            for (int i2 = 32; i2 <= 1024 && ((n3 = Pdh.INSTANCE.PdhLookupPerfNameByIndex(string, n2, pointer = new Memory(i2 * CHAR_TO_BYTES), dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD((long)i2)))) == -1073738819 || n3 == -1073738814); i2 *= 2) {
            }
        }
        if (n3 != 0) {
            throw new PdhException(n3);
        }
        if (CHAR_TO_BYTES == 1) {
            return pointer.getString(0L);
        }
        return ((Memory)pointer).getWideString(0L);
    }

    public static int PdhLookupPerfIndexByEnglishName(String string) {
        String[] stringArray = Advapi32Util.registryGetStringArray(WinReg.HKEY_LOCAL_MACHINE, ENGLISH_COUNTER_KEY, ENGLISH_COUNTER_VALUE);
        for (int i2 = 1; i2 < stringArray.length; i2 += 2) {
            if (!stringArray[i2].equals(string)) continue;
            try {
                return Integer.parseInt(stringArray[i2 - 1]);
            }
            catch (NumberFormatException numberFormatException) {
                return 0;
            }
        }
        return 0;
    }

    public static PdhEnumObjectItems PdhEnumObjectItems(String string, String string2, String string3, int n2) {
        String string4;
        int n3;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
        WinDef.DWORDByReference dWORDByReference2 = new WinDef.DWORDByReference(new WinDef.DWORD(0L));
        int n4 = Pdh.INSTANCE.PdhEnumObjectItems(string, string2, string3, null, dWORDByReference, null, dWORDByReference2, n2, 0);
        if (n4 != 0 && n4 != -2147481646) {
            throw new PdhException(n4);
        }
        Memory memory = null;
        Memory memory2 = null;
        if (dWORDByReference.getValue().intValue() > 0) {
            memory = new Memory(dWORDByReference.getValue().intValue() * CHAR_TO_BYTES);
        }
        if (dWORDByReference2.getValue().intValue() > 0) {
            memory2 = new Memory(dWORDByReference2.getValue().intValue() * CHAR_TO_BYTES);
        }
        if ((n4 = Pdh.INSTANCE.PdhEnumObjectItems(string, string2, string3, memory, dWORDByReference, memory2, dWORDByReference2, n2, 0)) != 0) {
            throw new PdhException(n4);
        }
        if (memory != null) {
            n3 = 0;
            while ((long)n3 < memory.size()) {
                string4 = null;
                string4 = CHAR_TO_BYTES == 1 ? memory.getString(n3) : memory.getWideString(n3);
                if (string4.isEmpty()) break;
                arrayList.add(string4);
                n3 += (string4.length() + 1) * CHAR_TO_BYTES;
            }
        }
        if (memory2 != null) {
            n3 = 0;
            while ((long)n3 < memory2.size()) {
                string4 = null;
                string4 = CHAR_TO_BYTES == 1 ? memory2.getString(n3) : memory2.getWideString(n3);
                if (string4.isEmpty()) break;
                arrayList2.add(string4);
                n3 += (string4.length() + 1) * CHAR_TO_BYTES;
            }
        }
        return new PdhEnumObjectItems(arrayList, arrayList2);
    }

    public static final class PdhException
    extends RuntimeException {
        private final int errorCode;

        public PdhException(int n2) {
            super(String.format("Pdh call failed with error code 0x%08X", n2));
            this.errorCode = n2;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static class PdhEnumObjectItems {
        private final List<String> counters;
        private final List<String> instances;

        public PdhEnumObjectItems(List<String> list, List<String> list2) {
            this.counters = this.copyAndEmptyListForNullList(list);
            this.instances = this.copyAndEmptyListForNullList(list2);
        }

        public List<String> getCounters() {
            return this.counters;
        }

        public List<String> getInstances() {
            return this.instances;
        }

        private List<String> copyAndEmptyListForNullList(List<String> list) {
            if (list == null) {
                return new ArrayList<String>();
            }
            return new ArrayList<String>(list);
        }

        public String toString() {
            return "PdhEnumObjectItems{counters=" + this.counters + ", instances=" + this.instances + '}';
        }
    }
}

