/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Wininet;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class WininetUtil {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Map<String, String> getCache() {
        ArrayList<Wininet.INTERNET_CACHE_ENTRY_INFO> arrayList = new ArrayList<Wininet.INTERNET_CACHE_ENTRY_INFO>();
        WinNT.HANDLE hANDLE = null;
        Object object = null;
        int n2 = 0;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        try {
            Object object2 = new IntByReference();
            hANDLE = Wininet.INSTANCE.FindFirstUrlCacheEntry(null, null, (IntByReference)object2);
            n2 = Native.getLastError();
            if (n2 == 259) {
                LinkedHashMap<String, String> linkedHashMap2 = linkedHashMap;
                return linkedHashMap2;
            }
            if (n2 != 0 && n2 != 122) {
                throw new Win32Exception(n2);
            }
            Wininet.INTERNET_CACHE_ENTRY_INFO iNTERNET_CACHE_ENTRY_INFO = new Wininet.INTERNET_CACHE_ENTRY_INFO(((IntByReference)object2).getValue());
            hANDLE = Wininet.INSTANCE.FindFirstUrlCacheEntry(null, iNTERNET_CACHE_ENTRY_INFO, (IntByReference)object2);
            if (hANDLE == null) {
                throw new Win32Exception(Native.getLastError());
            }
            arrayList.add(iNTERNET_CACHE_ENTRY_INFO);
            while (true) {
                boolean bl2;
                if (!(bl2 = Wininet.INSTANCE.FindNextUrlCacheEntry(hANDLE, null, (IntByReference)(object2 = new IntByReference())))) {
                    n2 = Native.getLastError();
                    if (n2 == 259) break;
                    if (n2 != 0 && n2 != 122) {
                        throw new Win32Exception(n2);
                    }
                }
                if (!(bl2 = Wininet.INSTANCE.FindNextUrlCacheEntry(hANDLE, iNTERNET_CACHE_ENTRY_INFO = new Wininet.INTERNET_CACHE_ENTRY_INFO(((IntByReference)object2).getValue()), (IntByReference)object2))) {
                    n2 = Native.getLastError();
                    if (n2 == 259) break;
                    if (n2 != 0 && n2 != 122) {
                        throw new Win32Exception(n2);
                    }
                }
                arrayList.add(iNTERNET_CACHE_ENTRY_INFO);
            }
            for (Wininet.INTERNET_CACHE_ENTRY_INFO iNTERNET_CACHE_ENTRY_INFO2 : arrayList) {
                linkedHashMap.put(iNTERNET_CACHE_ENTRY_INFO2.lpszSourceUrlName.getWideString(0L), iNTERNET_CACHE_ENTRY_INFO2.lpszLocalFileName == null ? "" : iNTERNET_CACHE_ENTRY_INFO2.lpszLocalFileName.getWideString(0L));
            }
        }
        catch (Win32Exception win32Exception) {
            object = win32Exception;
        }
        finally {
            if (hANDLE != null && !Wininet.INSTANCE.FindCloseUrlCache(hANDLE) && object != null) {
                Win32Exception win32Exception = new Win32Exception(Native.getLastError());
                win32Exception.addSuppressedReflected((Throwable)object);
                object = win32Exception;
            }
        }
        if (object != null) {
            throw object;
        }
        return linkedHashMap;
    }
}

