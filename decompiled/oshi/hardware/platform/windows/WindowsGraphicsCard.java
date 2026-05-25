/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.VersionHelpers;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.driver.windows.wmi.Win32VideoController;
import oshi.hardware.GraphicsCard;
import oshi.hardware.common.AbstractGraphicsCard;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Triplet;

@Immutable
final class WindowsGraphicsCard
extends AbstractGraphicsCard {
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();

    WindowsGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        super(string, string2, string3, string4, l2);
    }

    public static List<GraphicsCard> getGraphicsCards() {
        ArrayList<GraphicsCard> arrayList = new ArrayList<GraphicsCard>();
        if (IS_VISTA_OR_GREATER) {
            WbemcliUtil.WmiResult<Win32VideoController.VideoControllerProperty> wmiResult = Win32VideoController.queryVideoController();
            for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                String string;
                String string2 = WmiUtil.getString(wmiResult, Win32VideoController.VideoControllerProperty.NAME, i2);
                Triplet<String, String, String> triplet = ParseUtil.parseDeviceIdToVendorProductSerial(WmiUtil.getString(wmiResult, Win32VideoController.VideoControllerProperty.PNPDEVICEID, i2));
                String string3 = triplet == null ? "unknown" : triplet.getB();
                String string4 = WmiUtil.getString(wmiResult, Win32VideoController.VideoControllerProperty.ADAPTERCOMPATIBILITY, i2);
                if (triplet != null) {
                    if (Util.isBlank(string4)) {
                        string3 = triplet.getA();
                    } else {
                        string4 = string4 + " (" + triplet.getA() + ")";
                    }
                }
                string = !Util.isBlank(string = WmiUtil.getString(wmiResult, Win32VideoController.VideoControllerProperty.DRIVERVERSION, i2)) ? "DriverVersion=" + string : "unknown";
                long l2 = WmiUtil.getUint32asLong(wmiResult, Win32VideoController.VideoControllerProperty.ADAPTERRAM, i2);
                arrayList.add(new WindowsGraphicsCard(Util.isBlank(string2) ? "unknown" : string2, string3, Util.isBlank(string4) ? "unknown" : string4, string, l2));
            }
        }
        return arrayList;
    }
}

