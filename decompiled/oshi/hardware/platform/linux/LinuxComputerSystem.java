/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.driver.linux.Devicetree;
import oshi.driver.linux.Dmidecode;
import oshi.driver.linux.Lshal;
import oshi.driver.linux.Lshw;
import oshi.driver.linux.Sysfs;
import oshi.driver.linux.proc.CpuInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.linux.LinuxBaseboard;
import oshi.hardware.platform.linux.LinuxFirmware;
import oshi.util.Memoizer;

@Immutable
final class LinuxComputerSystem
extends AbstractComputerSystem {
    private final Supplier<String> manufacturer = Memoizer.memoize(LinuxComputerSystem::queryManufacturer);
    private final Supplier<String> model = Memoizer.memoize(LinuxComputerSystem::queryModel);
    private final Supplier<String> serialNumber = Memoizer.memoize(LinuxComputerSystem::querySerialNumber);
    private final Supplier<String> uuid = Memoizer.memoize(LinuxComputerSystem::queryUUID);

    LinuxComputerSystem() {
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer.get();
    }

    @Override
    public String getModel() {
        return this.model.get();
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber.get();
    }

    @Override
    public String getHardwareUUID() {
        return this.uuid.get();
    }

    @Override
    public Firmware createFirmware() {
        return new LinuxFirmware();
    }

    @Override
    public Baseboard createBaseboard() {
        return new LinuxBaseboard();
    }

    private static String queryManufacturer() {
        String string = null;
        string = Sysfs.querySystemVendor();
        if (string == null && (string = CpuInfo.queryCpuManufacturer()) == null) {
            return "unknown";
        }
        return string;
    }

    private static String queryModel() {
        String string = null;
        string = Sysfs.queryProductModel();
        if (string == null && (string = Devicetree.queryModel()) == null && (string = Lshw.queryModel()) == null) {
            return "unknown";
        }
        return string;
    }

    private static String querySerialNumber() {
        String string = null;
        string = Sysfs.queryProductSerial();
        if (string == null && (string = Dmidecode.querySerialNumber()) == null && (string = Lshal.querySerialNumber()) == null && (string = Lshw.querySerialNumber()) == null) {
            return "unknown";
        }
        return string;
    }

    private static String queryUUID() {
        String string = null;
        string = Sysfs.queryUUID();
        if (string == null && (string = Dmidecode.queryUUID()) == null && (string = Lshal.queryUUID()) == null && (string = Lshw.queryUUID()) == null) {
            return "unknown";
        }
        return string;
    }
}

