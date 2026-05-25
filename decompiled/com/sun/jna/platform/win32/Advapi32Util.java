/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APITypeMapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class Advapi32Util {
    public static String getUserName() {
        char[] cArray = new char[128];
        IntByReference intByReference = new IntByReference(cArray.length);
        boolean bl2 = Advapi32.INSTANCE.GetUserNameW(cArray, intByReference);
        if (!bl2) {
            switch (Kernel32.INSTANCE.GetLastError()) {
                case 122: {
                    cArray = new char[intByReference.getValue()];
                    break;
                }
                default: {
                    throw new Win32Exception(Native.getLastError());
                }
            }
            bl2 = Advapi32.INSTANCE.GetUserNameW(cArray, intByReference);
        }
        if (!bl2) {
            throw new Win32Exception(Native.getLastError());
        }
        return Native.toString(cArray);
    }

    public static Account getAccountByName(String string) {
        return Advapi32Util.getAccountByName(null, string);
    }

    public static Account getAccountByName(String string, String string2) {
        char[] cArray;
        IntByReference intByReference = new IntByReference(0);
        IntByReference intByReference2 = new IntByReference(0);
        PointerByReference pointerByReference = new PointerByReference();
        if (Advapi32.INSTANCE.LookupAccountName(string, string2, null, intByReference, null, intByReference2, pointerByReference)) {
            throw new RuntimeException("LookupAccountNameW was expected to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int n2 = Kernel32.INSTANCE.GetLastError();
        if (intByReference.getValue() == 0 || n2 != 122) {
            throw new Win32Exception(n2);
        }
        Memory memory = new Memory(intByReference.getValue());
        WinNT.PSID pSID = new WinNT.PSID(memory);
        if (!Advapi32.INSTANCE.LookupAccountName(string, string2, pSID, intByReference, cArray = new char[intByReference2.getValue() + 1], intByReference2, pointerByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Account account = new Account();
        account.accountType = pointerByReference.getPointer().getInt(0L);
        String[] stringArray = string2.split("\\\\", 2);
        String[] stringArray2 = string2.split("@", 2);
        account.name = stringArray.length == 2 ? stringArray[1] : (stringArray2.length == 2 ? stringArray2[0] : string2);
        if (intByReference2.getValue() > 0) {
            account.domain = Native.toString(cArray);
            account.fqn = account.domain + "\\" + account.name;
        } else {
            account.fqn = account.name;
        }
        account.sid = pSID.getBytes();
        account.sidString = Advapi32Util.convertSidToStringSid(new WinNT.PSID(account.sid));
        return account;
    }

    public static Account getAccountBySid(WinNT.PSID pSID) {
        return Advapi32Util.getAccountBySid(null, pSID);
    }

    public static Account getAccountBySid(String string, WinNT.PSID pSID) {
        IntByReference intByReference = new IntByReference(257);
        IntByReference intByReference2 = new IntByReference(256);
        PointerByReference pointerByReference = new PointerByReference();
        char[] cArray = new char[intByReference2.getValue()];
        char[] cArray2 = new char[intByReference.getValue()];
        int n2 = 0;
        if (!Advapi32.INSTANCE.LookupAccountSid(string, pSID, cArray2, intByReference, cArray, intByReference2, pointerByReference) && (n2 = Kernel32.INSTANCE.GetLastError()) != 1332) {
            throw new Win32Exception(n2);
        }
        Account account = new Account();
        if (n2 == 1332) {
            account.accountType = 8;
            account.name = "NONE_MAPPED";
        } else {
            account.accountType = pointerByReference.getPointer().getInt(0L);
            account.name = Native.toString(cArray2);
        }
        account.domain = Native.toString(cArray);
        account.fqn = account.domain.isEmpty() ? account.name : account.domain + "\\" + account.name;
        account.sid = pSID.getBytes();
        account.sidString = Advapi32Util.convertSidToStringSid(pSID);
        return account;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String convertSidToStringSid(WinNT.PSID pSID) {
        PointerByReference pointerByReference = new PointerByReference();
        if (!Advapi32.INSTANCE.ConvertSidToStringSid(pSID, pointerByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Pointer pointer = pointerByReference.getValue();
        try {
            String string = pointer.getWideString(0L);
            return string;
        }
        finally {
            Kernel32Util.freeLocalMemory(pointer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] convertStringSidToSid(String string) {
        WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
        if (!Advapi32.INSTANCE.ConvertStringSidToSid(string, pSIDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        WinNT.PSID pSID = pSIDByReference.getValue();
        try {
            byte[] byArray = pSID.getBytes();
            return byArray;
        }
        finally {
            Kernel32Util.freeLocalMemory(pSID.getPointer());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean isWellKnownSid(String string, int n2) {
        WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
        if (!Advapi32.INSTANCE.ConvertStringSidToSid(string, pSIDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        WinNT.PSID pSID = pSIDByReference.getValue();
        try {
            boolean bl2 = Advapi32.INSTANCE.IsWellKnownSid(pSID, n2);
            return bl2;
        }
        finally {
            Kernel32Util.freeLocalMemory(pSID.getPointer());
        }
    }

    public static boolean isWellKnownSid(byte[] byArray, int n2) {
        WinNT.PSID pSID = new WinNT.PSID(byArray);
        return Advapi32.INSTANCE.IsWellKnownSid(pSID, n2);
    }

    public static int alignOnDWORD(int n2) {
        return n2 + 3 & 0xFFFFFFFC;
    }

    public static int getAceSize(int n2) {
        return Native.getNativeSize(WinNT.ACCESS_ALLOWED_ACE.class, null) + n2 - 4;
    }

    public static Account getAccountBySid(String string) {
        return Advapi32Util.getAccountBySid(null, string);
    }

    public static Account getAccountBySid(String string, String string2) {
        return Advapi32Util.getAccountBySid(string, new WinNT.PSID(Advapi32Util.convertStringSidToSid(string2)));
    }

    public static Account[] getTokenGroups(WinNT.HANDLE hANDLE) {
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(hANDLE, 2, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int n2 = Kernel32.INSTANCE.GetLastError();
        if (n2 != 122) {
            throw new Win32Exception(n2);
        }
        WinNT.TOKEN_GROUPS tOKEN_GROUPS = new WinNT.TOKEN_GROUPS(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(hANDLE, 2, tOKEN_GROUPS, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        ArrayList<Account> arrayList = new ArrayList<Account>();
        for (WinNT.SID_AND_ATTRIBUTES sID_AND_ATTRIBUTES : tOKEN_GROUPS.getGroups()) {
            Account account;
            try {
                account = Advapi32Util.getAccountBySid(sID_AND_ATTRIBUTES.Sid);
            }
            catch (Exception exception) {
                account = new Account();
                account.sid = sID_AND_ATTRIBUTES.Sid.getBytes();
                account.name = account.sidString = Advapi32Util.convertSidToStringSid(sID_AND_ATTRIBUTES.Sid);
                account.fqn = account.sidString;
                account.accountType = 2;
            }
            arrayList.add(account);
        }
        return arrayList.toArray(new Account[0]);
    }

    public static Account getTokenPrimaryGroup(WinNT.HANDLE hANDLE) {
        Account account;
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(hANDLE, 5, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int n2 = Kernel32.INSTANCE.GetLastError();
        if (n2 != 122) {
            throw new Win32Exception(n2);
        }
        WinNT.TOKEN_PRIMARY_GROUP tOKEN_PRIMARY_GROUP = new WinNT.TOKEN_PRIMARY_GROUP(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(hANDLE, 5, tOKEN_PRIMARY_GROUP, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        try {
            account = Advapi32Util.getAccountBySid(tOKEN_PRIMARY_GROUP.PrimaryGroup);
        }
        catch (Exception exception) {
            account = new Account();
            account.sid = tOKEN_PRIMARY_GROUP.PrimaryGroup.getBytes();
            account.name = account.sidString = Advapi32Util.convertSidToStringSid(tOKEN_PRIMARY_GROUP.PrimaryGroup);
            account.fqn = account.sidString;
            account.accountType = 2;
        }
        return account;
    }

    public static Account getTokenAccount(WinNT.HANDLE hANDLE) {
        IntByReference intByReference = new IntByReference();
        if (Advapi32.INSTANCE.GetTokenInformation(hANDLE, 1, null, 0, intByReference)) {
            throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
        }
        int n2 = Kernel32.INSTANCE.GetLastError();
        if (n2 != 122) {
            throw new Win32Exception(n2);
        }
        WinNT.TOKEN_USER tOKEN_USER = new WinNT.TOKEN_USER(intByReference.getValue());
        if (!Advapi32.INSTANCE.GetTokenInformation(hANDLE, 1, tOKEN_USER, intByReference.getValue(), intByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return Advapi32Util.getAccountBySid(tOKEN_USER.User.Sid);
    }

    public static Account[] getCurrentUserGroups() {
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        Win32Exception win32Exception = null;
        try {
            WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentThread();
            if (!Advapi32.INSTANCE.OpenThreadToken(hANDLE, 10, true, hANDLEByReference)) {
                int n2 = Kernel32.INSTANCE.GetLastError();
                if (n2 != 1008) {
                    throw new Win32Exception(n2);
                }
                WinNT.HANDLE hANDLE2 = Kernel32.INSTANCE.GetCurrentProcess();
                if (!Advapi32.INSTANCE.OpenProcessToken(hANDLE2, 10, hANDLEByReference)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
            }
            Account[] accountArray = Advapi32Util.getTokenGroups(hANDLEByReference.getValue());
            return accountArray;
        }
        catch (Win32Exception win32Exception2) {
            win32Exception = win32Exception2;
            throw win32Exception;
        }
        finally {
            WinNT.HANDLE hANDLE = hANDLEByReference.getValue();
            if (!WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
                try {
                    Kernel32Util.closeHandle(hANDLE);
                }
                catch (Win32Exception win32Exception3) {
                    if (win32Exception == null) {
                        win32Exception = win32Exception3;
                    }
                    win32Exception.addSuppressedReflected(win32Exception3);
                }
            }
            if (win32Exception != null) {
                throw win32Exception;
            }
        }
    }

    public static boolean registryKeyExists(WinReg.HKEY hKEY, String string) {
        return Advapi32Util.registryKeyExists(hKEY, string, 0);
    }

    public static boolean registryKeyExists(WinReg.HKEY hKEY, String string, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        switch (n3) {
            case 0: {
                Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
                return true;
            }
            case 2: {
                return false;
            }
        }
        throw new Win32Exception(n3);
    }

    public static boolean registryValueExists(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryValueExists(hKEY, string, string2, 0);
    }

    public static boolean registryValueExists(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        switch (n3) {
            case 0: {
                break;
            }
            case 2: {
                return false;
            }
            default: {
                throw new Win32Exception(n3);
            }
        }
        try {
            IntByReference intByReference = new IntByReference();
            IntByReference intByReference2 = new IntByReference();
            n3 = Advapi32.INSTANCE.RegQueryValueEx(hKEYByReference.getValue(), string2, 0, intByReference2, (Pointer)null, intByReference);
            switch (n3) {
                case 0: 
                case 122: 
                case 234: {
                    boolean bl2 = true;
                    return bl2;
                }
                case 2: {
                    boolean bl3 = false;
                    return bl3;
                }
            }
            throw new Win32Exception(n3);
        }
        finally {
            if (hKEYByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && (n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue())) != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static String registryGetStringValue(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetStringValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String registryGetStringValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            String string3 = Advapi32Util.registryGetStringValue(hKEYByReference.getValue(), string2);
            return string3;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static String registryGetStringValue(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (Pointer)null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 1 && intByReference.getValue() != 2) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_SZ or REG_EXPAND_SZ");
        }
        if (intByReference2.getValue() == 0) {
            return "";
        }
        Memory memory = new Memory(intByReference2.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, memory, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }

    public static String registryGetExpandableStringValue(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetExpandableStringValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String registryGetExpandableStringValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            String string3 = Advapi32Util.registryGetExpandableStringValue(hKEYByReference.getValue(), string2);
            return string3;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static String registryGetExpandableStringValue(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (char[])null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 2) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_SZ");
        }
        if (intByReference2.getValue() == 0) {
            return "";
        }
        Memory memory = new Memory(intByReference2.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, memory, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            return memory.getWideString(0L);
        }
        return memory.getString(0L);
    }

    public static String[] registryGetStringArray(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetStringArray(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String[] registryGetStringArray(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            String[] stringArray = Advapi32Util.registryGetStringArray(hKEYByReference.getValue(), string2);
            return stringArray;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static String[] registryGetStringArray(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (char[])null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 7) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_SZ");
        }
        Memory memory = new Memory(intByReference2.getValue() + 2 * Native.WCHAR_SIZE);
        memory.clear();
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, memory, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        int n3 = 0;
        while ((long)n3 < memory.size()) {
            String string2;
            if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                string2 = memory.getWideString(n3);
                n3 += string2.length() * Native.WCHAR_SIZE;
                n3 += Native.WCHAR_SIZE;
            } else {
                string2 = memory.getString(n3);
                n3 += string2.length();
                ++n3;
            }
            if (string2.length() == 0) break;
            arrayList.add(string2);
        }
        return arrayList.toArray(new String[0]);
    }

    public static byte[] registryGetBinaryValue(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetBinaryValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] registryGetBinaryValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            byte[] byArray = Advapi32Util.registryGetBinaryValue(hKEYByReference.getValue(), string2);
            return byArray;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static byte[] registryGetBinaryValue(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (Pointer)null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 3) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_BINARY");
        }
        byte[] byArray = new byte[intByReference2.getValue()];
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, byArray, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        return byArray;
    }

    public static int registryGetIntValue(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetIntValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int registryGetIntValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            int n4 = Advapi32Util.registryGetIntValue(hKEYByReference.getValue(), string2);
            return n4;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static int registryGetIntValue(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (char[])null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 4) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_DWORD");
        }
        IntByReference intByReference3 = new IntByReference();
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, intByReference3, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        return intByReference3.getValue();
    }

    public static long registryGetLongValue(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryGetLongValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static long registryGetLongValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            long l2 = Advapi32Util.registryGetLongValue(hKEYByReference.getValue(), string2);
            return l2;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static long registryGetLongValue(WinReg.HKEY hKEY, String string) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, (char[])null, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() != 11) {
            throw new RuntimeException("Unexpected registry type " + intByReference.getValue() + ", expected REG_QWORD");
        }
        LongByReference longByReference = new LongByReference();
        n2 = Advapi32.INSTANCE.RegQueryValueEx(hKEY, string, 0, intByReference, longByReference, intByReference2);
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        return longByReference.getValue();
    }

    public static Object registryGetValue(WinReg.HKEY hKEY, String string, String string2) {
        Object object = null;
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegGetValue(hKEY, string, string2, 65535, intByReference, (Pointer)null, intByReference2);
        if (intByReference.getValue() == 0) {
            return null;
        }
        if (n2 != 0 && n2 != 122) {
            throw new Win32Exception(n2);
        }
        Memory memory = new Memory(intByReference2.getValue() + Native.WCHAR_SIZE);
        memory.clear();
        n2 = Advapi32.INSTANCE.RegGetValue(hKEY, string, string2, 65535, intByReference, memory, intByReference2);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
        if (intByReference.getValue() == 4) {
            object = memory.getInt(0L);
        } else if (intByReference.getValue() == 11) {
            object = memory.getLong(0L);
        } else if (intByReference.getValue() == 3) {
            object = memory.getByteArray(0L, intByReference2.getValue());
        } else if (intByReference.getValue() == 1 || intByReference.getValue() == 2) {
            object = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? memory.getWideString(0L) : memory.getString(0L);
        }
        return object;
    }

    public static boolean registryCreateKey(WinReg.HKEY hKEY, String string) {
        return Advapi32Util.registryCreateKey(hKEY, string, 0);
    }

    public static boolean registryCreateKey(WinReg.HKEY hKEY, String string, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        IntByReference intByReference = new IntByReference();
        int n3 = Advapi32.INSTANCE.RegCreateKeyEx(hKEY, string, 0, null, 0, 0x20019 | n2, null, hKEYByReference, intByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        return 1 == intByReference.getValue();
    }

    public static boolean registryCreateKey(WinReg.HKEY hKEY, String string, String string2) {
        return Advapi32Util.registryCreateKey(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean registryCreateKey(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 4 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            boolean bl2 = Advapi32Util.registryCreateKey(hKEYByReference.getValue(), string2);
            return bl2;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registrySetIntValue(WinReg.HKEY hKEY, String string, int n2) {
        byte[] byArray = new byte[]{(byte)(n2 & 0xFF), (byte)(n2 >> 8 & 0xFF), (byte)(n2 >> 16 & 0xFF), (byte)(n2 >> 24 & 0xFF)};
        int n3 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 4, byArray, 4);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
    }

    public static void registrySetIntValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        Advapi32Util.registrySetIntValue(hKEY, string, string2, n2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetIntValue(WinReg.HKEY hKEY, String string, String string2, int n2, int n3) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n4 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n3, hKEYByReference);
        if (n4 != 0) {
            throw new Win32Exception(n4);
        }
        try {
            Advapi32Util.registrySetIntValue(hKEYByReference.getValue(), string2, n2);
        }
        finally {
            n4 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n4 != 0) {
                throw new Win32Exception(n4);
            }
        }
    }

    public static void registrySetLongValue(WinReg.HKEY hKEY, String string, long l2) {
        byte[] byArray = new byte[]{(byte)(l2 & 0xFFL), (byte)(l2 >> 8 & 0xFFL), (byte)(l2 >> 16 & 0xFFL), (byte)(l2 >> 24 & 0xFFL), (byte)(l2 >> 32 & 0xFFL), (byte)(l2 >> 40 & 0xFFL), (byte)(l2 >> 48 & 0xFFL), (byte)(l2 >> 56 & 0xFFL)};
        int n2 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 11, byArray, 8);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registrySetLongValue(WinReg.HKEY hKEY, String string, String string2, long l2) {
        Advapi32Util.registrySetLongValue(hKEY, string, string2, l2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetLongValue(WinReg.HKEY hKEY, String string, String string2, long l2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registrySetLongValue(hKEYByReference.getValue(), string2, l2);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registrySetStringValue(WinReg.HKEY hKEY, String string, String string2) {
        Memory memory;
        if (string2 == null) {
            string2 = "";
        }
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            memory = new Memory((string2.length() + 1) * Native.WCHAR_SIZE);
            memory.setWideString(0L, string2);
        } else {
            memory = new Memory(string2.length() + 1);
            memory.setString(0L, string2);
        }
        int n2 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 1, memory, (int)memory.size());
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registrySetStringValue(WinReg.HKEY hKEY, String string, String string2, String string3) {
        Advapi32Util.registrySetStringValue(hKEY, string, string2, string3, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetStringValue(WinReg.HKEY hKEY, String string, String string2, String string3, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registrySetStringValue(hKEYByReference.getValue(), string2, string3);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registrySetExpandableStringValue(WinReg.HKEY hKEY, String string, String string2) {
        Memory memory;
        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
            memory = new Memory((string2.length() + 1) * Native.WCHAR_SIZE);
            memory.setWideString(0L, string2);
        } else {
            memory = new Memory(string2.length() + 1);
            memory.setString(0L, string2);
        }
        int n2 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 2, memory, (int)memory.size());
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registrySetExpandableStringValue(WinReg.HKEY hKEY, String string, String string2, String string3) {
        Advapi32Util.registrySetExpandableStringValue(hKEY, string, string2, string3, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetExpandableStringValue(WinReg.HKEY hKEY, String string, String string2, String string3, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registrySetExpandableStringValue(hKEYByReference.getValue(), string2, string3);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registrySetStringArray(WinReg.HKEY hKEY, String string, String[] stringArray) {
        int n2 = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? Native.WCHAR_SIZE : 1;
        int n3 = 0;
        for (String string2 : stringArray) {
            n3 += string2.length() * n2;
            n3 += n2;
        }
        int n4 = 0;
        Memory memory = new Memory(n3 += n2);
        memory.clear();
        for (String string3 : stringArray) {
            if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                memory.setWideString(n4, string3);
            } else {
                memory.setString((long)n4, string3);
            }
            n4 += string3.length() * n2;
            n4 += n2;
        }
        int n5 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 7, memory, n3);
        if (n5 != 0) {
            throw new Win32Exception(n5);
        }
    }

    public static void registrySetStringArray(WinReg.HKEY hKEY, String string, String string2, String[] stringArray) {
        Advapi32Util.registrySetStringArray(hKEY, string, string2, stringArray, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetStringArray(WinReg.HKEY hKEY, String string, String string2, String[] stringArray, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registrySetStringArray(hKEYByReference.getValue(), string2, stringArray);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registrySetBinaryValue(WinReg.HKEY hKEY, String string, byte[] byArray) {
        int n2 = Advapi32.INSTANCE.RegSetValueEx(hKEY, string, 0, 3, byArray, byArray.length);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registrySetBinaryValue(WinReg.HKEY hKEY, String string, String string2, byte[] byArray) {
        Advapi32Util.registrySetBinaryValue(hKEY, string, string2, byArray, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registrySetBinaryValue(WinReg.HKEY hKEY, String string, String string2, byte[] byArray, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registrySetBinaryValue(hKEYByReference.getValue(), string2, byArray);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registryDeleteKey(WinReg.HKEY hKEY, String string) {
        int n2 = Advapi32.INSTANCE.RegDeleteKey(hKEY, string);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registryDeleteKey(WinReg.HKEY hKEY, String string, String string2) {
        Advapi32Util.registryDeleteKey(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registryDeleteKey(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registryDeleteKey(hKEYByReference.getValue(), string2);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static void registryDeleteValue(WinReg.HKEY hKEY, String string) {
        int n2 = Advapi32.INSTANCE.RegDeleteValue(hKEY, string);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static void registryDeleteValue(WinReg.HKEY hKEY, String string, String string2) {
        Advapi32Util.registryDeleteValue(hKEY, string, string2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registryDeleteValue(WinReg.HKEY hKEY, String string, String string2, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x2001F | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            Advapi32Util.registryDeleteValue(hKEYByReference.getValue(), string2);
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static String[] registryGetKeys(WinReg.HKEY hKEY) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryInfoKey(hKEY, null, null, null, intByReference, intByReference2, null, null, null, null, null, null);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
        ArrayList<String> arrayList = new ArrayList<String>(intByReference.getValue());
        char[] cArray = new char[intByReference2.getValue() + 1];
        for (int i2 = 0; i2 < intByReference.getValue(); ++i2) {
            IntByReference intByReference3 = new IntByReference(intByReference2.getValue() + 1);
            n2 = Advapi32.INSTANCE.RegEnumKeyEx(hKEY, i2, cArray, intByReference3, null, null, null, null);
            if (n2 != 0) {
                throw new Win32Exception(n2);
            }
            arrayList.add(Native.toString(cArray));
        }
        return arrayList.toArray(new String[0]);
    }

    public static String[] registryGetKeys(WinReg.HKEY hKEY, String string) {
        return Advapi32Util.registryGetKeys(hKEY, string, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String[] registryGetKeys(WinReg.HKEY hKEY, String string, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            String[] stringArray = Advapi32Util.registryGetKeys(hKEYByReference.getValue());
            return stringArray;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static WinReg.HKEYByReference registryGetKey(WinReg.HKEY hKEY, String string, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        return hKEYByReference;
    }

    public static void registryCloseKey(WinReg.HKEY hKEY) {
        int n2 = Advapi32.INSTANCE.RegCloseKey(hKEY);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
    }

    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hKEY) {
        IntByReference intByReference = new IntByReference();
        IntByReference intByReference2 = new IntByReference();
        IntByReference intByReference3 = new IntByReference();
        int n2 = Advapi32.INSTANCE.RegQueryInfoKey(hKEY, null, null, null, null, null, null, intByReference, intByReference2, intByReference3, null, null);
        if (n2 != 0) {
            throw new Win32Exception(n2);
        }
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        char[] cArray = new char[intByReference2.getValue() + 1];
        Memory memory = new Memory(intByReference3.getValue() + 2 * Native.WCHAR_SIZE);
        block13: for (int i2 = 0; i2 < intByReference.getValue(); ++i2) {
            memory.clear();
            IntByReference intByReference4 = new IntByReference(intByReference2.getValue() + 1);
            IntByReference intByReference5 = new IntByReference(intByReference3.getValue());
            IntByReference intByReference6 = new IntByReference();
            n2 = Advapi32.INSTANCE.RegEnumValue(hKEY, i2, cArray, intByReference4, null, intByReference6, memory, intByReference5);
            if (n2 != 0) {
                throw new Win32Exception(n2);
            }
            String string = Native.toString(cArray);
            if (intByReference5.getValue() == 0) {
                switch (intByReference6.getValue()) {
                    case 3: {
                        treeMap.put(string, new byte[0]);
                        continue block13;
                    }
                    case 1: 
                    case 2: {
                        treeMap.put(string, new char[0]);
                        continue block13;
                    }
                    case 7: {
                        treeMap.put(string, new String[0]);
                        continue block13;
                    }
                    case 0: {
                        treeMap.put(string, null);
                        continue block13;
                    }
                    default: {
                        throw new RuntimeException("Unsupported empty type: " + intByReference6.getValue());
                    }
                }
            }
            switch (intByReference6.getValue()) {
                case 11: {
                    treeMap.put(string, memory.getLong(0L));
                    continue block13;
                }
                case 4: {
                    treeMap.put(string, memory.getInt(0L));
                    continue block13;
                }
                case 1: 
                case 2: {
                    if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                        treeMap.put(string, memory.getWideString(0L));
                        continue block13;
                    }
                    treeMap.put(string, memory.getString(0L));
                    continue block13;
                }
                case 3: {
                    treeMap.put(string, memory.getByteArray(0L, intByReference5.getValue()));
                    continue block13;
                }
                case 7: {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    int n3 = 0;
                    while ((long)n3 < memory.size()) {
                        String string2;
                        if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
                            string2 = memory.getWideString(n3);
                            n3 += string2.length() * Native.WCHAR_SIZE;
                            n3 += Native.WCHAR_SIZE;
                        } else {
                            string2 = memory.getString(n3);
                            n3 += string2.length();
                            ++n3;
                        }
                        if (string2.length() == 0) break;
                        arrayList.add(string2);
                    }
                    treeMap.put(string, arrayList.toArray(new String[0]));
                    continue block13;
                }
                default: {
                    throw new RuntimeException("Unsupported type: " + intByReference6.getValue());
                }
            }
        }
        return treeMap;
    }

    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hKEY, String string) {
        return Advapi32Util.registryGetValues(hKEY, string, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TreeMap<String, Object> registryGetValues(WinReg.HKEY hKEY, String string, int n2) {
        WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
        int n3 = Advapi32.INSTANCE.RegOpenKeyEx(hKEY, string, 0, 0x20019 | n2, hKEYByReference);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        try {
            TreeMap<String, Object> treeMap = Advapi32Util.registryGetValues(hKEYByReference.getValue());
            return treeMap;
        }
        finally {
            n3 = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
            if (n3 != 0) {
                throw new Win32Exception(n3);
            }
        }
    }

    public static InfoKey registryQueryInfoKey(WinReg.HKEY hKEY, int n2) {
        InfoKey infoKey = new InfoKey(hKEY, n2);
        int n3 = Advapi32.INSTANCE.RegQueryInfoKey(hKEY, infoKey.lpClass, infoKey.lpcClass, null, infoKey.lpcSubKeys, infoKey.lpcMaxSubKeyLen, infoKey.lpcMaxClassLen, infoKey.lpcValues, infoKey.lpcMaxValueNameLen, infoKey.lpcMaxValueLen, infoKey.lpcbSecurityDescriptor, infoKey.lpftLastWriteTime);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        return infoKey;
    }

    public static EnumKey registryRegEnumKey(WinReg.HKEY hKEY, int n2) {
        EnumKey enumKey = new EnumKey(hKEY, n2);
        int n3 = Advapi32.INSTANCE.RegEnumKeyEx(hKEY, enumKey.dwIndex, enumKey.lpName, enumKey.lpcName, null, enumKey.lpClass, enumKey.lpcbClass, enumKey.lpftLastWriteTime);
        if (n3 != 0) {
            throw new Win32Exception(n3);
        }
        return enumKey;
    }

    public static String getEnvironmentBlock(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(map.size() * 32);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String string = entry.getKey();
            String string2 = entry.getValue();
            if (string2 == null) continue;
            stringBuilder.append(string).append("=").append(string2).append('\u0000');
        }
        return stringBuilder.append('\u0000').toString();
    }

    public static WinNT.ACE_HEADER[] getFileSecurity(String string, boolean bl2) {
        Object object;
        Memory memory;
        boolean bl3;
        int n2 = 4;
        int n3 = 1024;
        do {
            int n4;
            bl3 = false;
            memory = new Memory(n3);
            object = new IntByReference();
            boolean bl4 = Advapi32.INSTANCE.GetFileSecurity(string, n2, memory, n3, (IntByReference)object);
            if (!bl4) {
                n4 = Kernel32.INSTANCE.GetLastError();
                memory.clear();
                if (122 != n4) {
                    throw new Win32Exception(n4);
                }
            }
            if (n3 >= (n4 = ((IntByReference)object).getValue())) continue;
            bl3 = true;
            n3 = n4;
            memory.clear();
        } while (bl3);
        object = new WinNT.SECURITY_DESCRIPTOR_RELATIVE(memory);
        WinNT.ACL aCL = ((WinNT.SECURITY_DESCRIPTOR_RELATIVE)object).getDiscretionaryACL();
        WinNT.ACE_HEADER[] aCE_HEADERArray = aCL.getACEs();
        if (bl2) {
            ArrayList<WinNT.ACE_HEADER> arrayList = new ArrayList<WinNT.ACE_HEADER>();
            HashMap<String, WinNT.ACCESS_ACEStructure> hashMap = new HashMap<String, WinNT.ACCESS_ACEStructure>();
            for (WinNT.ACE_HEADER aCE_HEADER : aCE_HEADERArray) {
                if (aCE_HEADER instanceof WinNT.ACCESS_ACEStructure) {
                    WinNT.ACCESS_ACEStructure aCCESS_ACEStructure = (WinNT.ACCESS_ACEStructure)aCE_HEADER;
                    boolean bl5 = (aCE_HEADER.AceFlags & 0x1F) != 0;
                    String string2 = aCCESS_ACEStructure.getSidString() + "/" + bl5 + "/" + aCE_HEADER.getClass().getName();
                    WinNT.ACCESS_ACEStructure aCCESS_ACEStructure2 = (WinNT.ACCESS_ACEStructure)hashMap.get(string2);
                    if (aCCESS_ACEStructure2 != null) {
                        int n5 = aCCESS_ACEStructure2.Mask;
                        aCCESS_ACEStructure2.Mask = n5 |= aCCESS_ACEStructure.Mask;
                        continue;
                    }
                    hashMap.put(string2, aCCESS_ACEStructure);
                    arrayList.add(aCCESS_ACEStructure2);
                    continue;
                }
                arrayList.add(aCE_HEADER);
            }
            return arrayList.toArray(new WinNT.ACE_HEADER[0]);
        }
        return aCE_HEADERArray;
    }

    private static Memory getSecurityDescriptorForFile(String string) {
        int n2;
        int n3 = 7;
        IntByReference intByReference = new IntByReference();
        boolean bl2 = Advapi32.INSTANCE.GetFileSecurity(string, 7, null, 0, intByReference);
        if (!bl2 && 122 != (n2 = Kernel32.INSTANCE.GetLastError())) {
            throw new Win32Exception(n2);
        }
        n2 = intByReference.getValue();
        Memory memory = new Memory(n2);
        bl2 = Advapi32.INSTANCE.GetFileSecurity(string, 7, memory, n2, intByReference);
        if (!bl2) {
            memory.clear();
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return memory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Memory getSecurityDescriptorForObject(String string, int n2, boolean bl2) {
        PointerByReference pointerByReference;
        int n3 = 7 | (bl2 ? 8 : 0);
        int n4 = Advapi32.INSTANCE.GetNamedSecurityInfo(string, n2, n3, null, null, null, null, pointerByReference = new PointerByReference());
        if (n4 != 0) {
            throw new Win32Exception(n4);
        }
        int n5 = Advapi32.INSTANCE.GetSecurityDescriptorLength(pointerByReference.getValue());
        Memory memory = new Memory(n5);
        Pointer pointer = pointerByReference.getValue();
        try {
            byte[] byArray = pointer.getByteArray(0L, n5);
            memory.write(0L, byArray, 0, n5);
            Memory memory2 = memory;
            return memory2;
        }
        finally {
            Kernel32Util.freeLocalMemory(pointer);
        }
    }

    public static void setSecurityDescriptorForObject(String string, int n2, WinNT.SECURITY_DESCRIPTOR_RELATIVE sECURITY_DESCRIPTOR_RELATIVE, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        int n3;
        WinNT.PSID pSID = sECURITY_DESCRIPTOR_RELATIVE.getOwner();
        WinNT.PSID pSID2 = sECURITY_DESCRIPTOR_RELATIVE.getGroup();
        WinNT.ACL aCL = sECURITY_DESCRIPTOR_RELATIVE.getDiscretionaryACL();
        WinNT.ACL aCL2 = sECURITY_DESCRIPTOR_RELATIVE.getSystemACL();
        int n4 = 0;
        if (bl2) {
            if (pSID == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain owner");
            }
            if (!Advapi32.INSTANCE.IsValidSid(pSID)) {
                throw new IllegalArgumentException("Owner PSID is invalid");
            }
            n4 |= 1;
        }
        if (bl3) {
            if (pSID2 == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain group");
            }
            if (!Advapi32.INSTANCE.IsValidSid(pSID2)) {
                throw new IllegalArgumentException("Group PSID is invalid");
            }
            n4 |= 2;
        }
        if (bl4) {
            if (aCL == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain DACL");
            }
            if (!Advapi32.INSTANCE.IsValidAcl(aCL.getPointer())) {
                throw new IllegalArgumentException("DACL is invalid");
            }
            n4 |= 4;
        }
        if (bl5) {
            if (aCL2 == null) {
                throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain SACL");
            }
            if (!Advapi32.INSTANCE.IsValidAcl(aCL2.getPointer())) {
                throw new IllegalArgumentException("SACL is invalid");
            }
            n4 |= 8;
        }
        if (bl6) {
            if ((sECURITY_DESCRIPTOR_RELATIVE.Control & 0x1000) != 0) {
                n4 |= Integer.MIN_VALUE;
            } else if ((sECURITY_DESCRIPTOR_RELATIVE.Control & 0x1000) == 0) {
                n4 |= 0x20000000;
            }
        }
        if (bl7) {
            if ((sECURITY_DESCRIPTOR_RELATIVE.Control & 0x2000) != 0) {
                n4 |= 0x40000000;
            } else if ((sECURITY_DESCRIPTOR_RELATIVE.Control & 0x2000) == 0) {
                n4 |= 0x10000000;
            }
        }
        if ((n3 = Advapi32.INSTANCE.SetNamedSecurityInfo(string, n2, n4, bl2 ? pSID.getPointer() : null, bl3 ? pSID2.getPointer() : null, bl4 ? aCL.getPointer() : null, bl5 ? aCL2.getPointer() : null)) != 0) {
            throw new Win32Exception(n3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean accessCheck(File file, AccessCheckPermission accessCheckPermission) {
        boolean bl2;
        Memory memory = Advapi32Util.getSecurityDescriptorForFile(file.getAbsolutePath().replace('/', '\\'));
        WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
        WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
        Win32Exception win32Exception = null;
        try {
            int n2 = 131086;
            WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
            if (!Advapi32.INSTANCE.OpenProcessToken(hANDLE, n2, hANDLEByReference)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            if (!Advapi32.INSTANCE.DuplicateToken(hANDLEByReference.getValue(), 2, hANDLEByReference2)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            WinNT.GENERIC_MAPPING gENERIC_MAPPING = new WinNT.GENERIC_MAPPING();
            gENERIC_MAPPING.genericRead = new WinDef.DWORD(1179785L);
            gENERIC_MAPPING.genericWrite = new WinDef.DWORD(1179926L);
            gENERIC_MAPPING.genericExecute = new WinDef.DWORD(1179808L);
            gENERIC_MAPPING.genericAll = new WinDef.DWORD(0x1F01FFL);
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD((long)accessCheckPermission.getCode()));
            Advapi32.INSTANCE.MapGenericMask(dWORDByReference, gENERIC_MAPPING);
            WinNT.PRIVILEGE_SET pRIVILEGE_SET = new WinNT.PRIVILEGE_SET(1);
            pRIVILEGE_SET.PrivilegeCount = new WinDef.DWORD(0L);
            WinDef.DWORDByReference dWORDByReference2 = new WinDef.DWORDByReference(new WinDef.DWORD((long)pRIVILEGE_SET.size()));
            WinDef.DWORDByReference dWORDByReference3 = new WinDef.DWORDByReference();
            WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
            if (!Advapi32.INSTANCE.AccessCheck(memory, hANDLEByReference2.getValue(), dWORDByReference.getValue(), gENERIC_MAPPING, pRIVILEGE_SET, dWORDByReference2, dWORDByReference3, bOOLByReference)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            bl2 = bOOLByReference.getValue().booleanValue();
        }
        catch (Win32Exception win32Exception3) {
            try {
                win32Exception = win32Exception3;
                throw win32Exception;
            }
            catch (Throwable throwable) {
                block17: {
                    try {
                        Kernel32Util.closeHandleRefs(hANDLEByReference, hANDLEByReference2);
                    }
                    catch (Win32Exception win32Exception4) {
                        if (win32Exception == null) {
                            win32Exception = win32Exception4;
                            break block17;
                        }
                        win32Exception.addSuppressedReflected(win32Exception4);
                    }
                }
                if (memory != null) {
                    memory.clear();
                }
                if (win32Exception != null) {
                    throw win32Exception;
                }
                throw throwable;
            }
        }
        try {
            Kernel32Util.closeHandleRefs(hANDLEByReference, hANDLEByReference2);
        }
        catch (Win32Exception win32Exception2) {
            if (win32Exception == null) {
                win32Exception = win32Exception2;
            }
            win32Exception.addSuppressedReflected(win32Exception2);
        }
        if (memory != null) {
            memory.clear();
        }
        if (win32Exception != null) {
            throw win32Exception;
        }
        return bl2;
    }

    public static WinNT.SECURITY_DESCRIPTOR_RELATIVE getFileSecurityDescriptor(File file, boolean bl2) {
        Memory memory = Advapi32Util.getSecurityDescriptorForObject(file.getAbsolutePath().replaceAll("/", "\\"), 1, bl2);
        WinNT.SECURITY_DESCRIPTOR_RELATIVE sECURITY_DESCRIPTOR_RELATIVE = new WinNT.SECURITY_DESCRIPTOR_RELATIVE(memory);
        return sECURITY_DESCRIPTOR_RELATIVE;
    }

    public static void setFileSecurityDescriptor(File file, WinNT.SECURITY_DESCRIPTOR_RELATIVE sECURITY_DESCRIPTOR_RELATIVE, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        Advapi32Util.setSecurityDescriptorForObject(file.getAbsolutePath().replaceAll("/", "\\"), 1, sECURITY_DESCRIPTOR_RELATIVE, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    public static void encryptFile(File file) {
        String string = file.getAbsolutePath();
        if (!Advapi32.INSTANCE.EncryptFile(string)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static void decryptFile(File file) {
        String string = file.getAbsolutePath();
        if (!Advapi32.INSTANCE.DecryptFile(string, new WinDef.DWORD(0L))) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
    }

    public static int fileEncryptionStatus(File file) {
        WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
        String string = file.getAbsolutePath();
        if (!Advapi32.INSTANCE.FileEncryptionStatus(string, dWORDByReference)) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        return dWORDByReference.getValue().intValue();
    }

    public static void disableEncryption(File file, boolean bl2) {
        String string = file.getAbsolutePath();
        if (!Advapi32.INSTANCE.EncryptionDisable(string, bl2)) {
            throw new Win32Exception(Native.getLastError());
        }
    }

    public static void backupEncryptedFile(File file, File file2) {
        PointerByReference pointerByReference;
        String string;
        if (!file2.isDirectory()) {
            throw new IllegalArgumentException("destDir must be a directory.");
        }
        WinDef.ULONG uLONG = new WinDef.ULONG(0L);
        WinDef.ULONG uLONG2 = new WinDef.ULONG(1L);
        if (file.isDirectory()) {
            uLONG2.setValue(3L);
        }
        if (Advapi32.INSTANCE.OpenEncryptedFileRaw(string = file.getAbsolutePath(), uLONG, pointerByReference = new PointerByReference()) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WinBase.FE_EXPORT_FUNC fE_EXPORT_FUNC = new WinBase.FE_EXPORT_FUNC(){

            @Override
            public WinDef.DWORD callback(Pointer pointer, Pointer pointer2, WinDef.ULONG uLONG) {
                byte[] byArray = pointer.getByteArray(0L, uLONG.intValue());
                try {
                    byteArrayOutputStream.write(byArray);
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
                return new WinDef.DWORD(0L);
            }
        };
        if (Advapi32.INSTANCE.ReadEncryptedFileRaw(fE_EXPORT_FUNC, null, pointerByReference.getValue()) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        try {
            byteArrayOutputStream.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference.getValue());
        String string2 = file2.getAbsolutePath() + File.separator + file.getName();
        pointerByReference = new PointerByReference();
        if (Advapi32.INSTANCE.OpenEncryptedFileRaw(string2, uLONG2, pointerByReference) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        final IntByReference intByReference = new IntByReference(0);
        WinBase.FE_IMPORT_FUNC fE_IMPORT_FUNC = new WinBase.FE_IMPORT_FUNC(){

            @Override
            public WinDef.DWORD callback(Pointer pointer, Pointer pointer2, WinDef.ULONGByReference uLONGByReference) {
                int n2 = intByReference.getValue();
                int n3 = byteArrayOutputStream.size() - n2;
                int n4 = Math.min(n3, uLONGByReference.getValue().intValue());
                pointer.write(0L, byteArrayOutputStream.toByteArray(), n2, n4);
                intByReference.setValue(n2 + n4);
                uLONGByReference.setValue(new WinDef.ULONG((long)n4));
                return new WinDef.DWORD(0L);
            }
        };
        if (Advapi32.INSTANCE.WriteEncryptedFileRaw(fE_IMPORT_FUNC, null, pointerByReference.getValue()) != 0) {
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }
        Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference.getValue());
    }

    public static class Privilege
    implements Closeable {
        private boolean currentlyImpersonating = false;
        private boolean privilegesEnabled = false;
        private final WinNT.LUID[] pLuids;

        public Privilege(String ... stringArray) {
            this.pLuids = new WinNT.LUID[stringArray.length];
            int n2 = 0;
            for (String string : stringArray) {
                this.pLuids[n2] = new WinNT.LUID();
                if (!Advapi32.INSTANCE.LookupPrivilegeValue(null, string, this.pLuids[n2])) {
                    throw new IllegalArgumentException("Failed to find privilege \"" + stringArray[n2] + "\" - " + Kernel32.INSTANCE.GetLastError());
                }
                ++n2;
            }
        }

        @Override
        public void close() {
            this.disable();
        }

        public Privilege enable() {
            if (this.privilegesEnabled) {
                return this;
            }
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            try {
                hANDLEByReference.setValue(this.getThreadToken());
                WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                for (int i2 = 0; i2 < this.pLuids.length; ++i2) {
                    tOKEN_PRIVILEGES.Privileges[i2] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i2], new WinDef.DWORD(2L));
                }
                if (!Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                this.privilegesEnabled = true;
            }
            catch (Win32Exception win32Exception) {
                if (this.currentlyImpersonating) {
                    Advapi32.INSTANCE.SetThreadToken(null, null);
                    this.currentlyImpersonating = false;
                } else if (this.privilegesEnabled) {
                    WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                    for (int i3 = 0; i3 < this.pLuids.length; ++i3) {
                        tOKEN_PRIVILEGES.Privileges[i3] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i3], new WinDef.DWORD(0L));
                    }
                    Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
                    this.privilegesEnabled = false;
                }
                throw win32Exception;
            }
            finally {
                if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                    hANDLEByReference.setValue(null);
                }
            }
            return this;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void disable() {
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            try {
                hANDLEByReference.setValue(this.getThreadToken());
                if (this.currentlyImpersonating) {
                    Advapi32.INSTANCE.SetThreadToken(null, null);
                } else if (this.privilegesEnabled) {
                    WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
                    for (int i2 = 0; i2 < this.pLuids.length; ++i2) {
                        tOKEN_PRIVILEGES.Privileges[i2] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[i2], new WinDef.DWORD(0L));
                    }
                    Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
                    this.privilegesEnabled = false;
                }
            }
            finally {
                if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                    hANDLEByReference.setValue(null);
                }
            }
        }

        private WinNT.HANDLE getThreadToken() {
            WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
            WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
            try {
                if (!Advapi32.INSTANCE.OpenThreadToken(Kernel32.INSTANCE.GetCurrentThread(), 32, false, hANDLEByReference)) {
                    int n2 = Kernel32.INSTANCE.GetLastError();
                    if (1008 != n2) {
                        throw new Win32Exception(n2);
                    }
                    if (!Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 2, hANDLEByReference2)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    if (!Advapi32.INSTANCE.DuplicateTokenEx(hANDLEByReference2.getValue(), 36, null, 2, 2, hANDLEByReference)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    if (!Advapi32.INSTANCE.SetThreadToken(null, hANDLEByReference.getValue())) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                    this.currentlyImpersonating = true;
                }
            }
            catch (Win32Exception win32Exception) {
                if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
                    hANDLEByReference.setValue(null);
                }
                throw win32Exception;
            }
            finally {
                if (hANDLEByReference2.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference2.getValue() != null) {
                    Kernel32.INSTANCE.CloseHandle(hANDLEByReference2.getValue());
                    hANDLEByReference2.setValue(null);
                }
            }
            return hANDLEByReference.getValue();
        }
    }

    public static enum AccessCheckPermission {
        READ(Integer.MIN_VALUE),
        WRITE(0x40000000),
        EXECUTE(0x20000000);

        final int code;

        private AccessCheckPermission(int n3) {
            this.code = n3;
        }

        public int getCode() {
            return this.code;
        }
    }

    public static class EventLogIterator
    implements Iterable<EventLogRecord>,
    Iterator<EventLogRecord> {
        private WinNT.HANDLE _h;
        private Memory _buffer = new Memory(65536L);
        private boolean _done = false;
        private int _dwRead = 0;
        private Pointer _pevlr = null;
        private int _flags;

        public EventLogIterator(String string) {
            this(null, string, 4);
        }

        public EventLogIterator(String string, String string2, int n2) {
            this._flags = n2;
            this._h = Advapi32.INSTANCE.OpenEventLog(string, string2);
            if (this._h == null) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
        }

        private boolean read() {
            if (this._done || this._dwRead > 0) {
                return false;
            }
            IntByReference intByReference = new IntByReference();
            IntByReference intByReference2 = new IntByReference();
            if (!Advapi32.INSTANCE.ReadEventLog(this._h, 1 | this._flags, 0, this._buffer, (int)this._buffer.size(), intByReference, intByReference2)) {
                int n2 = Kernel32.INSTANCE.GetLastError();
                if (n2 == 122) {
                    this._buffer = new Memory(intByReference2.getValue());
                    if (!Advapi32.INSTANCE.ReadEventLog(this._h, 1 | this._flags, 0, this._buffer, (int)this._buffer.size(), intByReference, intByReference2)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                } else {
                    this.close();
                    if (n2 != 38) {
                        throw new Win32Exception(n2);
                    }
                    return false;
                }
            }
            this._dwRead = intByReference.getValue();
            this._pevlr = this._buffer;
            return true;
        }

        public void close() {
            this._done = true;
            if (this._h != null) {
                if (!Advapi32.INSTANCE.CloseEventLog(this._h)) {
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                this._h = null;
            }
        }

        @Override
        public Iterator<EventLogRecord> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            this.read();
            return !this._done;
        }

        @Override
        public EventLogRecord next() {
            this.read();
            EventLogRecord eventLogRecord = new EventLogRecord(this._pevlr);
            this._dwRead -= eventLogRecord.getLength();
            this._pevlr = this._pevlr.share(eventLogRecord.getLength());
            return eventLogRecord;
        }

        @Override
        public void remove() {
        }
    }

    public static class EventLogRecord {
        private WinNT.EVENTLOGRECORD _record;
        private String _source;
        private byte[] _data;
        private String[] _strings;

        public WinNT.EVENTLOGRECORD getRecord() {
            return this._record;
        }

        public int getInstanceId() {
            return this._record.EventID.intValue();
        }

        @Deprecated
        public int getEventId() {
            return this._record.EventID.intValue();
        }

        public String getSource() {
            return this._source;
        }

        public int getStatusCode() {
            return this._record.EventID.intValue() & 0xFFFF;
        }

        public int getRecordNumber() {
            return this._record.RecordNumber.intValue();
        }

        public int getLength() {
            return this._record.Length.intValue();
        }

        public String[] getStrings() {
            return this._strings;
        }

        public EventLogType getType() {
            switch (this._record.EventType.intValue()) {
                case 0: 
                case 4: {
                    return EventLogType.Informational;
                }
                case 16: {
                    return EventLogType.AuditFailure;
                }
                case 8: {
                    return EventLogType.AuditSuccess;
                }
                case 1: {
                    return EventLogType.Error;
                }
                case 2: {
                    return EventLogType.Warning;
                }
            }
            throw new RuntimeException("Invalid type: " + this._record.EventType.intValue());
        }

        public byte[] getData() {
            return this._data;
        }

        public EventLogRecord(Pointer pointer) {
            this._record = new WinNT.EVENTLOGRECORD(pointer);
            this._source = pointer.getWideString(this._record.size());
            if (this._record.DataLength.intValue() > 0) {
                this._data = pointer.getByteArray(this._record.DataOffset.intValue(), this._record.DataLength.intValue());
            }
            if (this._record.NumStrings.intValue() > 0) {
                ArrayList<String> arrayList = new ArrayList<String>();
                long l2 = this._record.StringOffset.intValue();
                for (int i2 = this._record.NumStrings.intValue(); i2 > 0; --i2) {
                    String string = pointer.getWideString(l2);
                    arrayList.add(string);
                    l2 += (long)(string.length() * Native.WCHAR_SIZE);
                    l2 += (long)Native.WCHAR_SIZE;
                }
                this._strings = arrayList.toArray(new String[0]);
            }
        }
    }

    public static enum EventLogType {
        Error,
        Warning,
        Informational,
        AuditSuccess,
        AuditFailure;

    }

    public static class EnumKey {
        public WinReg.HKEY hKey;
        public int dwIndex = 0;
        public char[] lpName = new char[255];
        public IntByReference lpcName = new IntByReference(255);
        public char[] lpClass = new char[255];
        public IntByReference lpcbClass = new IntByReference(255);
        public WinBase.FILETIME lpftLastWriteTime = new WinBase.FILETIME();

        public EnumKey() {
        }

        public EnumKey(WinReg.HKEY hKEY, int n2) {
            this.hKey = hKEY;
            this.dwIndex = n2;
        }
    }

    public static class InfoKey {
        public WinReg.HKEY hKey;
        public char[] lpClass = new char[260];
        public IntByReference lpcClass = new IntByReference(260);
        public IntByReference lpcSubKeys = new IntByReference();
        public IntByReference lpcMaxSubKeyLen = new IntByReference();
        public IntByReference lpcMaxClassLen = new IntByReference();
        public IntByReference lpcValues = new IntByReference();
        public IntByReference lpcMaxValueNameLen = new IntByReference();
        public IntByReference lpcMaxValueLen = new IntByReference();
        public IntByReference lpcbSecurityDescriptor = new IntByReference();
        public WinBase.FILETIME lpftLastWriteTime = new WinBase.FILETIME();

        public InfoKey() {
        }

        public InfoKey(WinReg.HKEY hKEY, int n2) {
            this.hKey = hKEY;
            this.lpcbSecurityDescriptor = new IntByReference(n2);
        }
    }

    public static class Account {
        public String name;
        public String domain;
        public byte[] sid;
        public String sidString;
        public int accountType;
        public String fqn;
    }
}

