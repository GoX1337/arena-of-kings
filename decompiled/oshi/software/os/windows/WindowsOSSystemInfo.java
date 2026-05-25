/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsOSSystemInfo {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsOSSystemInfo.class);
    private WinBase.SYSTEM_INFO systemInfo = null;

    public WindowsOSSystemInfo() {
        this.init();
    }

    public WindowsOSSystemInfo(WinBase.SYSTEM_INFO sYSTEM_INFO) {
        this.systemInfo = sYSTEM_INFO;
    }

    private void init() {
        WinBase.SYSTEM_INFO sYSTEM_INFO = new WinBase.SYSTEM_INFO();
        Kernel32.INSTANCE.GetSystemInfo(sYSTEM_INFO);
        try {
            IntByReference intByReference = new IntByReference();
            WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
            if (Kernel32.INSTANCE.IsWow64Process(hANDLE, intByReference) && intByReference.getValue() > 0) {
                Kernel32.INSTANCE.GetNativeSystemInfo(sYSTEM_INFO);
            }
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            LOG.trace("No WOW64 support: {}", (Object)unsatisfiedLinkError.getMessage());
        }
        this.systemInfo = sYSTEM_INFO;
        LOG.debug("Initialized OSNativeSystemInfo");
    }

    public int getNumberOfProcessors() {
        return this.systemInfo.dwNumberOfProcessors.intValue();
    }
}

