/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.driver.windows.wmi.Win32Bios;
import oshi.driver.windows.wmi.Win32ComputerSystem;
import oshi.driver.windows.wmi.Win32ComputerSystemProduct;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.windows.WindowsBaseboard;
import oshi.hardware.platform.windows.WindowsFirmware;
import oshi.util.Memoizer;
import oshi.util.Util;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Pair;

@Immutable
final class WindowsComputerSystem
extends AbstractComputerSystem {
    private final Supplier<Pair<String, String>> manufacturerModel = Memoizer.memoize(WindowsComputerSystem::queryManufacturerModel);
    private final Supplier<Pair<String, String>> serialNumberUUID = Memoizer.memoize(WindowsComputerSystem::querySystemSerialNumberUUID);

    WindowsComputerSystem() {
    }

    @Override
    public String getManufacturer() {
        return this.manufacturerModel.get().getA();
    }

    @Override
    public String getModel() {
        return this.manufacturerModel.get().getB();
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumberUUID.get().getA();
    }

    @Override
    public String getHardwareUUID() {
        return this.serialNumberUUID.get().getB();
    }

    @Override
    public Firmware createFirmware() {
        return new WindowsFirmware();
    }

    @Override
    public Baseboard createBaseboard() {
        return new WindowsBaseboard();
    }

    private static Pair<String, String> queryManufacturerModel() {
        String string = null;
        String string2 = null;
        WbemcliUtil.WmiResult<Win32ComputerSystem.ComputerSystemProperty> wmiResult = Win32ComputerSystem.queryComputerSystem();
        if (wmiResult.getResultCount() > 0) {
            string = WmiUtil.getString(wmiResult, Win32ComputerSystem.ComputerSystemProperty.MANUFACTURER, 0);
            string2 = WmiUtil.getString(wmiResult, Win32ComputerSystem.ComputerSystemProperty.MODEL, 0);
        }
        return new Pair<String, String>(Util.isBlank(string) ? "unknown" : string, Util.isBlank(string2) ? "unknown" : string2);
    }

    private static Pair<String, String> querySystemSerialNumberUUID() {
        String string = null;
        String string2 = null;
        WbemcliUtil.WmiResult<Win32ComputerSystemProduct.ComputerSystemProductProperty> wmiResult = Win32ComputerSystemProduct.queryIdentifyingNumberUUID();
        if (wmiResult.getResultCount() > 0) {
            string = WmiUtil.getString(wmiResult, Win32ComputerSystemProduct.ComputerSystemProductProperty.IDENTIFYINGNUMBER, 0);
            string2 = WmiUtil.getString(wmiResult, Win32ComputerSystemProduct.ComputerSystemProductProperty.UUID, 0);
        }
        if (Util.isBlank(string)) {
            string = WindowsComputerSystem.querySerialFromBios();
        }
        if (Util.isBlank(string)) {
            string = "unknown";
        }
        if (Util.isBlank(string2)) {
            string2 = "unknown";
        }
        return new Pair<String, String>(string, string2);
    }

    private static String querySerialFromBios() {
        WbemcliUtil.WmiResult<Win32Bios.BiosSerialProperty> wmiResult = Win32Bios.querySerialNumber();
        if (wmiResult.getResultCount() > 0) {
            return WmiUtil.getString(wmiResult, Win32Bios.BiosSerialProperty.SERIALNUMBER, 0);
        }
        return null;
    }
}

