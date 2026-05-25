/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.SetupApi;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Display;
import oshi.hardware.common.AbstractDisplay;

@Immutable
final class WindowsDisplay
extends AbstractDisplay {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsDisplay.class);
    private static final SetupApi SU = SetupApi.INSTANCE;
    private static final Advapi32 ADV = Advapi32.INSTANCE;
    private static final Guid.GUID GUID_DEVINTERFACE_MONITOR = new Guid.GUID("E6F07B5F-EE97-4a90-B076-33F57BF4EAA7");

    WindowsDisplay(byte[] byArray) {
        super(byArray);
        LOG.debug("Initialized WindowsDisplay");
    }

    public static List<Display> getDisplays() {
        ArrayList<Display> arrayList = new ArrayList<Display>();
        WinNT.HANDLE hANDLE = SU.SetupDiGetClassDevs(GUID_DEVINTERFACE_MONITOR, null, null, 18);
        if (!hANDLE.equals(WinBase.INVALID_HANDLE_VALUE)) {
            SetupApi.SP_DEVICE_INTERFACE_DATA sP_DEVICE_INTERFACE_DATA = new SetupApi.SP_DEVICE_INTERFACE_DATA();
            sP_DEVICE_INTERFACE_DATA.cbSize = sP_DEVICE_INTERFACE_DATA.size();
            SetupApi.SP_DEVINFO_DATA sP_DEVINFO_DATA = new SetupApi.SP_DEVINFO_DATA();
            int n2 = 0;
            while (SU.SetupDiEnumDeviceInfo(hANDLE, n2, sP_DEVINFO_DATA)) {
                IntByReference intByReference;
                byte[] byArray;
                IntByReference intByReference2;
                WinReg.HKEY hKEY = SU.SetupDiOpenDevRegKey(hANDLE, sP_DEVINFO_DATA, 1, 0, 1, 1);
                if (ADV.RegQueryValueEx(hKEY, "EDID", 0, intByReference2 = new IntByReference(), byArray = new byte[1], intByReference = new IntByReference()) == 234 && ADV.RegQueryValueEx(hKEY, "EDID", 0, intByReference2, byArray = new byte[intByReference.getValue()], intByReference) == 0) {
                    WindowsDisplay windowsDisplay = new WindowsDisplay(byArray);
                    arrayList.add(windowsDisplay);
                }
                Advapi32.INSTANCE.RegCloseKey(hKEY);
                ++n2;
            }
            SU.SetupDiDestroyDeviceInfoList(hANDLE);
        }
        return arrayList;
    }
}

