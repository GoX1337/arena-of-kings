/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.mac;

import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public class IOKitUtil {
    private static final IOKit IO = IOKit.INSTANCE;
    private static final SystemB SYS = SystemB.INSTANCE;

    private IOKitUtil() {
    }

    public static int getMasterPort() {
        IntByReference intByReference = new IntByReference();
        IO.IOMasterPort(0, intByReference);
        return intByReference.getValue();
    }

    public static IOKit.IORegistryEntry getRoot() {
        int n2 = IOKitUtil.getMasterPort();
        IOKit.IORegistryEntry iORegistryEntry = IO.IORegistryGetRootEntry(n2);
        SYS.mach_port_deallocate(SYS.mach_task_self(), n2);
        return iORegistryEntry;
    }

    public static IOKit.IOService getMatchingService(String string) {
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOServiceMatching(string);
        if (cFMutableDictionaryRef != null) {
            return IOKitUtil.getMatchingService(cFMutableDictionaryRef);
        }
        return null;
    }

    public static IOKit.IOService getMatchingService(CoreFoundation.CFDictionaryRef cFDictionaryRef) {
        int n2 = IOKitUtil.getMasterPort();
        IOKit.IOService iOService = IO.IOServiceGetMatchingService(n2, cFDictionaryRef);
        SYS.mach_port_deallocate(SYS.mach_task_self(), n2);
        return iOService;
    }

    public static IOKit.IOIterator getMatchingServices(String string) {
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOServiceMatching(string);
        if (cFMutableDictionaryRef != null) {
            return IOKitUtil.getMatchingServices(cFMutableDictionaryRef);
        }
        return null;
    }

    public static IOKit.IOIterator getMatchingServices(CoreFoundation.CFDictionaryRef cFDictionaryRef) {
        int n2 = IOKitUtil.getMasterPort();
        PointerByReference pointerByReference = new PointerByReference();
        int n3 = IO.IOServiceGetMatchingServices(n2, cFDictionaryRef, pointerByReference);
        SYS.mach_port_deallocate(SYS.mach_task_self(), n2);
        if (n3 == 0 && pointerByReference.getValue() != null) {
            return new IOKit.IOIterator(pointerByReference.getValue());
        }
        return null;
    }

    public static CoreFoundation.CFMutableDictionaryRef getBSDNameMatchingDict(String string) {
        int n2 = IOKitUtil.getMasterPort();
        CoreFoundation.CFMutableDictionaryRef cFMutableDictionaryRef = IO.IOBSDNameMatching(n2, 0, string);
        SYS.mach_port_deallocate(SYS.mach_task_self(), n2);
        return cFMutableDictionaryRef;
    }
}

