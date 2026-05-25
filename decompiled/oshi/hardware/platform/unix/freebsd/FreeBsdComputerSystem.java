/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.unix.UnixBaseboard;
import oshi.hardware.platform.unix.freebsd.FreeBsdFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
import oshi.util.tuples.Quintet;

@Immutable
final class FreeBsdComputerSystem
extends AbstractComputerSystem {
    private final Supplier<Quintet<String, String, String, String, String>> manufModelSerialUuidVers = Memoizer.memoize(FreeBsdComputerSystem::readDmiDecode);

    FreeBsdComputerSystem() {
    }

    @Override
    public String getManufacturer() {
        return this.manufModelSerialUuidVers.get().getA();
    }

    @Override
    public String getModel() {
        return this.manufModelSerialUuidVers.get().getB();
    }

    @Override
    public String getSerialNumber() {
        return this.manufModelSerialUuidVers.get().getC();
    }

    @Override
    public String getHardwareUUID() {
        return this.manufModelSerialUuidVers.get().getD();
    }

    @Override
    public Firmware createFirmware() {
        return new FreeBsdFirmware();
    }

    @Override
    public Baseboard createBaseboard() {
        return new UnixBaseboard(this.manufModelSerialUuidVers.get().getA(), this.manufModelSerialUuidVers.get().getB(), this.manufModelSerialUuidVers.get().getC(), this.manufModelSerialUuidVers.get().getE());
    }

    private static Quintet<String, String, String, String, String> readDmiDecode() {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = "Manufacturer:";
        String string7 = "Product Name:";
        String string8 = "Serial Number:";
        String string9 = "UUID:";
        String string10 = "Version:";
        for (String string11 : ExecutingCommand.runNative("dmidecode -t system")) {
            if (string11.contains("Manufacturer:")) {
                string = string11.split("Manufacturer:")[1].trim();
                continue;
            }
            if (string11.contains("Product Name:")) {
                string2 = string11.split("Product Name:")[1].trim();
                continue;
            }
            if (string11.contains("Serial Number:")) {
                string3 = string11.split("Serial Number:")[1].trim();
                continue;
            }
            if (string11.contains("UUID:")) {
                string4 = string11.split("UUID:")[1].trim();
                continue;
            }
            if (!string11.contains("Version:")) continue;
            string5 = string11.split("Version:")[1].trim();
        }
        if (Util.isBlank(string3)) {
            string3 = FreeBsdComputerSystem.querySystemSerialNumber();
        }
        if (Util.isBlank(string4)) {
            string4 = BsdSysctlUtil.sysctl("kern.hostuuid", "unknown");
        }
        return new Quintet<String, String, String, String, String>(Util.isBlank(string) ? "unknown" : string, Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string3) ? "unknown" : string3, Util.isBlank(string4) ? "unknown" : string4, Util.isBlank(string5) ? "unknown" : string5);
    }

    private static String querySystemSerialNumber() {
        String string = "system.hardware.serial =";
        for (String string2 : ExecutingCommand.runNative("lshal")) {
            if (!string2.contains(string)) continue;
            return ParseUtil.getSingleQuoteStringValue(string2);
        }
        return "unknown";
    }
}

