/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.LastErrorException;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APITypeMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class Kernel32Util
implements WinDef {
    public static final String VOLUME_GUID_PATH_PREFIX = "\\\\?\\Volume{";
    public static final String VOLUME_GUID_PATH_SUFFIX = "}\\";

    public static String getComputerName() {
        char[] cArray = new char[WinBase.MAX_COMPUTERNAME_LENGTH + 1];
        IntByReference intByReference = new IntByReference(cArray.length);
        if (!Kernel32.INSTANCE.GetComputerName(cArray, intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArray);
    }

    public static void freeLocalMemory(Pointer pointer) {
        Pointer pointer2 = Kernel32.INSTANCE.LocalFree(pointer);
        if (pointer2 != null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static void freeGlobalMemory(Pointer pointer) {
        Pointer pointer2 = Kernel32.INSTANCE.GlobalFree(pointer);
        if (pointer2 != null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static void closeHandleRefs(WinNT.HANDLEByReference ... hANDLEByReferenceArray) {
        Win32Exception win32Exception = null;
        for (WinNT.HANDLEByReference hANDLEByReference : hANDLEByReferenceArray) {
            try {
                Kernel32Util.closeHandleRef(hANDLEByReference);
            }
            catch (Win32Exception win32Exception2) {
                if (win32Exception == null) {
                    win32Exception = win32Exception2;
                    continue;
                }
                win32Exception.addSuppressedReflected(win32Exception2);
            }
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
    }

    public static void closeHandleRef(WinNT.HANDLEByReference hANDLEByReference) {
        Kernel32Util.closeHandle(hANDLEByReference == null ? null : hANDLEByReference.getValue());
    }

    public static void closeHandles(WinNT.HANDLE ... hANDLEArray) {
        Win32Exception win32Exception = null;
        for (WinNT.HANDLE hANDLE : hANDLEArray) {
            try {
                Kernel32Util.closeHandle(hANDLE);
            }
            catch (Win32Exception win32Exception2) {
                if (win32Exception == null) {
                    win32Exception = win32Exception2;
                    continue;
                }
                win32Exception.addSuppressedReflected(win32Exception2);
            }
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
    }

    public static void closeHandle(WinNT.HANDLE hANDLE) {
        if (hANDLE == null) {
            return;
        }
        if (!Kernel32.INSTANCE.CloseHandle(hANDLE)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String formatMessage(int n2) {
        PointerByReference pointerByReference = new PointerByReference();
        int n3 = Kernel32.INSTANCE.FormatMessage(4864, null, n2, 0, pointerByReference, 0, null);
        if (n3 == 0) {
            throw new LastErrorException(Native.getLastError());
        }
        Pointer pointer = pointerByReference.getValue();
        try {
            String string = pointer.getWideString(0L);
            String string2 = string.trim();
            return string2;
        }
        finally {
            Kernel32Util.freeLocalMemory(pointer);
        }
    }

    public static String formatMessage(WinNT.HRESULT hRESULT) {
        return Kernel32Util.formatMessage(hRESULT.intValue());
    }

    public static String formatMessageFromLastErrorCode(int n2) {
        return Kernel32Util.formatMessage(W32Errors.HRESULT_FROM_WIN32(n2));
    }

    public static String getLastErrorMessage() {
        return Kernel32Util.formatMessageFromLastErrorCode(Kernel32.INSTANCE.GetLastError());
    }

    public static String getTempPath() {
        WinDef.DWORD dWORD = new WinDef.DWORD(260L);
        char[] cArray = new char[dWORD.intValue()];
        if (Kernel32.INSTANCE.GetTempPath(dWORD, cArray).intValue() == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArray);
    }

    public static void deleteFile(String string) {
        if (!Kernel32.INSTANCE.DeleteFile(string)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static List<String> getLogicalDriveStrings() {
        WinDef.DWORD dWORD = Kernel32.INSTANCE.GetLogicalDriveStrings(new WinDef.DWORD(0L), null);
        if (dWORD.intValue() <= 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        char[] cArray = new char[dWORD.intValue()];
        int n2 = (dWORD = Kernel32.INSTANCE.GetLogicalDriveStrings(dWORD, cArray)).intValue();
        if (n2 <= 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toStringList(cArray, 0, n2);
    }

    public static int getFileAttributes(String string) {
        int n2 = Kernel32.INSTANCE.GetFileAttributes(string);
        if (n2 == -1) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getFileType(String string) {
        int n4;
        File file = new File(string);
        if (!file.exists()) {
            throw new FileNotFoundException(string);
        }
        WinNT.HANDLE hANDLE = null;
        Win32Exception win32Exception = null;
        try {
            hANDLE = Kernel32.INSTANCE.CreateFile(string, Integer.MIN_VALUE, 1, new WinBase.SECURITY_ATTRIBUTES(), 3, 128, new WinNT.HANDLEByReference().getValue());
            if (WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            int n2 = Kernel32.INSTANCE.GetFileType(hANDLE);
            block4 : switch (n2) {
                case 0: {
                    int n3 = Kernel32.INSTANCE.GetLastError();
                    switch (n3) {
                        case 0: {
                            break block4;
                        }
                    }
                    throw new Win32Exception(n3);
                }
            }
            n4 = n2;
        }
        catch (Win32Exception win32Exception3) {
            try {
                win32Exception = win32Exception3;
                throw win32Exception;
            }
            catch (Throwable throwable) {
                block20: {
                    try {
                        Kernel32Util.closeHandle(hANDLE);
                    }
                    catch (Win32Exception win32Exception4) {
                        if (win32Exception == null) {
                            win32Exception = win32Exception4;
                            break block20;
                        }
                        win32Exception.addSuppressedReflected(win32Exception4);
                    }
                }
                if (win32Exception != null) {
                    throw win32Exception;
                }
                throw throwable;
            }
        }
        try {
            Kernel32Util.closeHandle(hANDLE);
        }
        catch (Win32Exception win32Exception2) {
            if (win32Exception == null) {
                win32Exception = win32Exception2;
            }
            win32Exception.addSuppressedReflected(win32Exception2);
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return n4;
    }

    public static int getDriveType(String string) {
        return Kernel32.INSTANCE.GetDriveType(string);
    }

    public static String getEnvironmentVariable(String string) {
        int n2 = Kernel32.INSTANCE.GetEnvironmentVariable(string, null, 0);
        if (n2 == 0) {
            return null;
        }
        if (n2 < 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        char[] cArray = new char[n2];
        if ((n2 = Kernel32.INSTANCE.GetEnvironmentVariable(string, cArray, cArray.length)) <= 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toString(cArray);
    }

    public static Map<String, String> getEnvironmentVariables() {
        Pointer pointer = Kernel32.INSTANCE.GetEnvironmentStrings();
        if (pointer == null) {
            throw new LastErrorException(Kernel32.INSTANCE.GetLastError());
        }
        try {
            Map<String, String> map = Kernel32Util.getEnvironmentVariables(pointer, 0L);
            return map;
        }
        finally {
            if (!Kernel32.INSTANCE.FreeEnvironmentStrings(pointer)) {
                throw new LastErrorException(Kernel32.INSTANCE.GetLastError());
            }
        }
    }

    public static Map<String, String> getEnvironmentVariables(Pointer pointer, long l2) {
        String string;
        int n2;
        if (pointer == null) {
            return null;
        }
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        boolean bl2 = Kernel32Util.isWideCharEnvironmentStringBlock(pointer, l2);
        long l3 = bl2 ? 2L : 1L;
        long l4 = l2;
        while ((n2 = (string = Kernel32Util.readEnvironmentStringBlockEntry(pointer, l4, bl2)).length()) != 0) {
            int n3 = string.indexOf(61);
            if (n3 < 0) {
                throw new IllegalArgumentException("Missing variable value separator in " + string);
            }
            String string2 = string.substring(0, n3);
            String string3 = string.substring(n3 + 1);
            treeMap.put(string2, string3);
            l4 += (long)(n2 + 1) * l3;
        }
        return treeMap;
    }

    public static String readEnvironmentStringBlockEntry(Pointer pointer, long l2, boolean bl2) {
        long l3 = Kernel32Util.findEnvironmentStringBlockEntryEnd(pointer, l2, bl2);
        int n2 = (int)(l3 - l2);
        if (n2 == 0) {
            return "";
        }
        int n3 = bl2 ? n2 / 2 : n2;
        char[] cArray = new char[n3];
        long l4 = l2;
        long l5 = bl2 ? 2L : 1L;
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        int n4 = 0;
        while (n4 < cArray.length) {
            byte by2 = pointer.getByte(l4);
            if (bl2) {
                byte by3 = pointer.getByte(l4 + 1L);
                cArray[n4] = ByteOrder.LITTLE_ENDIAN.equals(byteOrder) ? (char)(by3 << 8 & 0xFF00 | by2 & 0xFF) : (char)(by2 << 8 & 0xFF00 | by3 & 0xFF);
            } else {
                cArray[n4] = (char)(by2 & 0xFF);
            }
            ++n4;
            l4 += l5;
        }
        return new String(cArray);
    }

    public static long findEnvironmentStringBlockEntryEnd(Pointer pointer, long l2, boolean bl2) {
        long l3;
        long l4 = l2;
        long l5 = l3 = bl2 ? 2L : 1L;
        byte by2;
        while ((by2 = pointer.getByte(l4)) != 0) {
            l4 += l3;
        }
        return l4;
    }

    public static boolean isWideCharEnvironmentStringBlock(Pointer pointer, long l2) {
        byte by2 = pointer.getByte(l2);
        byte by3 = pointer.getByte(l2 + 1L);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        if (ByteOrder.LITTLE_ENDIAN.equals(byteOrder)) {
            return Kernel32Util.isWideCharEnvironmentStringBlock(by3);
        }
        return Kernel32Util.isWideCharEnvironmentStringBlock(by2);
    }

    private static boolean isWideCharEnvironmentStringBlock(byte by2) {
        return by2 == 0;
    }

    public static final int getPrivateProfileInt(String string, String string2, int n2, String string3) {
        return Kernel32.INSTANCE.GetPrivateProfileInt(string, string2, n2, string3);
    }

    public static final String getPrivateProfileString(String string, String string2, String string3, String string4) {
        char[] cArray = new char[1024];
        Kernel32.INSTANCE.GetPrivateProfileString(string, string2, string3, cArray, new WinDef.DWORD((long)cArray.length), string4);
        return Native.toString(cArray);
    }

    public static final void writePrivateProfileString(String string, String string2, String string3, String string4) {
        if (!Kernel32.INSTANCE.WritePrivateProfileString(string, string2, string3, string4)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static final WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[] getLogicalProcessorInformation() {
        Memory memory;
        int n2 = new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION().size();
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD((long)n2));
        while (!Kernel32.INSTANCE.GetLogicalProcessorInformation(memory = new Memory(dWORDByReference.getValue().intValue()), dWORDByReference)) {
            int n3 = Kernel32.INSTANCE.GetLastError();
            if (n3 == 122) continue;
            throw new Win32Exception(n3);
        }
        WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION sYSTEM_LOGICAL_PROCESSOR_INFORMATION = new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION(memory);
        int n4 = dWORDByReference.getValue().intValue() / n2;
        return (WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[])sYSTEM_LOGICAL_PROCESSOR_INFORMATION.toArray(new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[n4]);
    }

    public static final WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[] getLogicalProcessorInformationEx(int n2) {
        WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX;
        Memory memory;
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(1L));
        while (!Kernel32.INSTANCE.GetLogicalProcessorInformationEx(n2, memory = new Memory(dWORDByReference.getValue().intValue()), dWORDByReference)) {
            int n3 = Kernel32.INSTANCE.GetLastError();
            if (n3 == 122) continue;
            throw new Win32Exception(n3);
        }
        ArrayList<WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX> arrayList = new ArrayList<WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX>();
        for (int i2 = 0; i2 < dWORDByReference.getValue().intValue(); i2 += sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX.size) {
            sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX = WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX.fromPointer(memory.share(i2));
            arrayList.add(sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX);
        }
        return arrayList.toArray(new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[0]);
    }

    public static final String[] getPrivateProfileSection(String string, String string2) {
        char[] cArray = new char[32768];
        if (Kernel32.INSTANCE.GetPrivateProfileSection(string, cArray, new WinDef.DWORD((long)cArray.length), string2).intValue() == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return new String(cArray).split("\u0000");
    }

    public static final String[] getPrivateProfileSectionNames(String string) {
        char[] cArray = new char[65536];
        if (Kernel32.INSTANCE.GetPrivateProfileSectionNames(cArray, new WinDef.DWORD((long)cArray.length), string).intValue() == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return new String(cArray).split("\u0000");
    }

    public static final void writePrivateProfileSection(String string, String[] stringArray, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string3 : stringArray) {
            stringBuilder.append(string3).append('\u0000');
        }
        stringBuilder.append('\u0000');
        if (!Kernel32.INSTANCE.WritePrivateProfileSection(string, stringBuilder.toString(), string2)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static final List<String> queryDosDevice(String string, int n2) {
        char[] cArray = new char[n2];
        int n3 = Kernel32.INSTANCE.QueryDosDevice(string, cArray, cArray.length);
        if (n3 == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Native.toStringList(cArray, 0, n3);
    }

    public static final List<String> getVolumePathNamesForVolumeName(String string) {
        int n2;
        char[] cArray = new char[261];
        IntByReference intByReference = new IntByReference();
        if (!Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(string, cArray, cArray.length, intByReference)) {
            n2 = Kernel32.INSTANCE.GetLastError();
            if (n2 != 234) {
                throw new Win32Exception(n2);
            }
            int n3 = intByReference.getValue();
            cArray = new char[n3];
            if (!Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(string, cArray, cArray.length, intByReference)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
        }
        n2 = intByReference.getValue();
        return Native.toStringList(cArray, 0, n2);
    }

    public static final String extractVolumeGUID(String string) {
        if (string == null || string.length() <= VOLUME_GUID_PATH_PREFIX.length() + VOLUME_GUID_PATH_SUFFIX.length() || !string.startsWith(VOLUME_GUID_PATH_PREFIX) || !string.endsWith(VOLUME_GUID_PATH_SUFFIX)) {
            throw new IllegalArgumentException("Bad volume GUID path format: " + string);
        }
        return string.substring(VOLUME_GUID_PATH_PREFIX.length(), string.length() - VOLUME_GUID_PATH_SUFFIX.length());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final String QueryFullProcessImageName(int n2, int n3) {
        String string;
        WinNT.HANDLE hANDLE = null;
        Win32Exception win32Exception = null;
        try {
            hANDLE = Kernel32.INSTANCE.OpenProcess(1040, false, n2);
            if (hANDLE == null) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            string = Kernel32Util.QueryFullProcessImageName(hANDLE, n3);
        }
        catch (Win32Exception win32Exception3) {
            try {
                win32Exception = win32Exception3;
                throw win32Exception;
            }
            catch (Throwable throwable) {
                block13: {
                    try {
                        Kernel32Util.closeHandle(hANDLE);
                    }
                    catch (Win32Exception win32Exception4) {
                        if (win32Exception == null) {
                            win32Exception = win32Exception4;
                            break block13;
                        }
                        win32Exception.addSuppressed(win32Exception4);
                    }
                }
                if (win32Exception != null) {
                    throw win32Exception;
                }
                throw throwable;
            }
        }
        try {
            Kernel32Util.closeHandle(hANDLE);
        }
        catch (Win32Exception win32Exception2) {
            if (win32Exception == null) {
                win32Exception = win32Exception2;
            }
            win32Exception.addSuppressed(win32Exception2);
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return string;
    }

    public static final String QueryFullProcessImageName(WinNT.HANDLE hANDLE, int n2) {
        int n3 = 260;
        IntByReference intByReference = new IntByReference();
        do {
            char[] cArray = new char[n3];
            intByReference.setValue(n3);
            if (Kernel32.INSTANCE.QueryFullProcessImageName(hANDLE, n2, cArray, intByReference)) {
                return new String(cArray, 0, intByReference.getValue());
            }
            n3 += 1024;
        } while (Kernel32.INSTANCE.GetLastError() == 122);
        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] getResource(String string, String string2, String string3) {
        byte[] byArray;
        Win32Exception win32Exception;
        block16: {
            WinDef.HMODULE hMODULE = Kernel32.INSTANCE.LoadLibraryEx(string, null, 2);
            if (hMODULE == null) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            win32Exception = null;
            Pointer pointer = null;
            int n2 = 0;
            byArray = null;
            try {
                Object object = null;
                try {
                    object = new Pointer(Long.parseLong(string2));
                }
                catch (NumberFormatException numberFormatException) {
                    object = new Memory(Native.WCHAR_SIZE * (string2.length() + 1));
                    ((Pointer)object).setWideString(0L, string2);
                }
                Pointer pointer2 = null;
                try {
                    pointer2 = new Pointer(Long.parseLong(string3));
                }
                catch (NumberFormatException numberFormatException) {
                    pointer2 = new Memory(Native.WCHAR_SIZE * (string3.length() + 1));
                    pointer2.setWideString(0L, string3);
                }
                WinDef.HRSRC hRSRC = Kernel32.INSTANCE.FindResource(hMODULE, pointer2, (Pointer)object);
                if (hRSRC == null) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                WinNT.HANDLE hANDLE = Kernel32.INSTANCE.LoadResource(hMODULE, hRSRC);
                if (hANDLE == null) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                n2 = Kernel32.INSTANCE.SizeofResource(hMODULE, hRSRC);
                if (n2 == 0) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                pointer = Kernel32.INSTANCE.LockResource(hANDLE);
                if (pointer == null) {
                    throw new IllegalStateException("LockResource returned null.");
                }
                byArray = pointer.getByteArray(0L, n2);
            }
            catch (Win32Exception win32Exception2) {
                win32Exception = win32Exception2;
                return win32Exception;
            }
            finally {
                if (hMODULE == null || Kernel32.INSTANCE.FreeLibrary(hMODULE)) break block16;
                Win32Exception win32Exception3 = new Win32Exception(Kernel32.INSTANCE.GetLastError());
                if (win32Exception != null) {
                    win32Exception3.addSuppressedReflected(win32Exception);
                }
                throw win32Exception3;
            }
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Map<String, List<String>> getResourceNames(String string) {
        Win32Exception win32Exception;
        LinkedHashMap<String, List<String>> linkedHashMap;
        block12: {
            WinDef.HMODULE hMODULE = Kernel32.INSTANCE.LoadLibraryEx(string, null, 2);
            if (hMODULE == null) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            final ArrayList arrayList = new ArrayList();
            linkedHashMap = new LinkedHashMap<String, List<String>>();
            WinBase.EnumResTypeProc enumResTypeProc = new WinBase.EnumResTypeProc(){

                @Override
                public boolean invoke(WinDef.HMODULE hMODULE, Pointer pointer, Pointer pointer2) {
                    if (Pointer.nativeValue(pointer) <= 65535L) {
                        arrayList.add(Pointer.nativeValue(pointer) + "");
                    } else {
                        arrayList.add(pointer.getWideString(0L));
                    }
                    return true;
                }
            };
            WinBase.EnumResNameProc enumResNameProc = new WinBase.EnumResNameProc(){

                @Override
                public boolean invoke(WinDef.HMODULE hMODULE, Pointer pointer, Pointer pointer2, Pointer pointer3) {
                    String string = "";
                    string = Pointer.nativeValue(pointer) <= 65535L ? Pointer.nativeValue(pointer) + "" : pointer.getWideString(0L);
                    if (Pointer.nativeValue(pointer2) < 65535L) {
                        ((List)linkedHashMap.get(string)).add(Pointer.nativeValue(pointer2) + "");
                    } else {
                        ((List)linkedHashMap.get(string)).add(pointer2.getWideString(0L));
                    }
                    return true;
                }
            };
            win32Exception = null;
            try {
                if (!Kernel32.INSTANCE.EnumResourceTypes(hMODULE, enumResTypeProc, null)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                for (String string2 : arrayList) {
                    boolean bl2;
                    linkedHashMap.put(string2, new ArrayList());
                    Pointer pointer = null;
                    try {
                        pointer = new Pointer(Long.parseLong(string2));
                    }
                    catch (NumberFormatException numberFormatException) {
                        pointer = new Memory(Native.WCHAR_SIZE * (string2.length() + 1));
                        pointer.setWideString(0L, string2);
                    }
                    if (bl2 = Kernel32.INSTANCE.EnumResourceNames(hMODULE, pointer, enumResNameProc, null)) continue;
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
            }
            catch (Win32Exception win32Exception2) {
                win32Exception = win32Exception2;
                return win32Exception;
            }
            finally {
                if (hMODULE == null || Kernel32.INSTANCE.FreeLibrary(hMODULE)) break block12;
                Win32Exception win32Exception3 = new Win32Exception(Kernel32.INSTANCE.GetLastError());
                if (win32Exception != null) {
                    win32Exception3.addSuppressedReflected(win32Exception);
                }
                throw win32Exception3;
            }
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return linkedHashMap;
    }

    public static List<Tlhelp32.MODULEENTRY32W> getModules(int n2) {
        WinNT.HANDLE hANDLE = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPMODULE, new WinDef.DWORD((long)n2));
        if (hANDLE == null) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Win32Exception win32Exception = null;
        try {
            Tlhelp32.MODULEENTRY32W mODULEENTRY32W = new Tlhelp32.MODULEENTRY32W();
            if (!Kernel32.INSTANCE.Module32FirstW(hANDLE, mODULEENTRY32W)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            ArrayList<Tlhelp32.MODULEENTRY32W> arrayList = new ArrayList<Tlhelp32.MODULEENTRY32W>();
            arrayList.add(mODULEENTRY32W);
            Tlhelp32.MODULEENTRY32W mODULEENTRY32W2 = new Tlhelp32.MODULEENTRY32W();
            while (Kernel32.INSTANCE.Module32NextW(hANDLE, mODULEENTRY32W2)) {
                arrayList.add(mODULEENTRY32W2);
                mODULEENTRY32W2 = new Tlhelp32.MODULEENTRY32W();
            }
            int n3 = Kernel32.INSTANCE.GetLastError();
            if (n3 != 0 && n3 != 18) {
                throw new Win32Exception(n3);
            }
            ArrayList<Tlhelp32.MODULEENTRY32W> arrayList2 = arrayList;
            return arrayList2;
        }
        catch (Win32Exception win32Exception2) {
            win32Exception = win32Exception2;
            throw win32Exception;
        }
        finally {
            try {
                Kernel32Util.closeHandle(hANDLE);
            }
            catch (Win32Exception win32Exception3) {
                if (win32Exception == null) {
                    win32Exception = win32Exception3;
                }
                win32Exception.addSuppressedReflected(win32Exception3);
            }
            if (win32Exception != null) {
                throw win32Exception;
            }
        }
    }

    public static String expandEnvironmentStrings(String string) {
        if (string == null) {
            return "";
        }
        int n2 = Kernel32.INSTANCE.ExpandEnvironmentStrings(string, null, 0);
        if (n2 == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Memory memory = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? new Memory(n2 * Native.WCHAR_SIZE) : new Memory(n2 + 1);
        n2 = Kernel32.INSTANCE.ExpandEnvironmentStrings(string, memory, n2);
        if (n2 == 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }
}

