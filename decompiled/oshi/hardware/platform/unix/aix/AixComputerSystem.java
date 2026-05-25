/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.unix.aix.AixBaseboard;
import oshi.hardware.platform.unix.aix.AixFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;

@Immutable
final class AixComputerSystem
extends AbstractComputerSystem {
    private final Supplier<LsattrStrings> lsattrStrings = Memoizer.memoize(AixComputerSystem::readLsattr);
    private final Supplier<List<String>> lscfg;

    AixComputerSystem(Supplier<List<String>> supplier) {
        this.lscfg = supplier;
    }

    @Override
    public String getManufacturer() {
        return this.lsattrStrings.get().manufacturer;
    }

    @Override
    public String getModel() {
        return this.lsattrStrings.get().model;
    }

    @Override
    public String getSerialNumber() {
        return this.lsattrStrings.get().serialNumber;
    }

    @Override
    public String getHardwareUUID() {
        return this.lsattrStrings.get().uuid;
    }

    @Override
    public Firmware createFirmware() {
        return new AixFirmware(this.lsattrStrings.get().biosVendor, this.lsattrStrings.get().biosPlatformVersion, this.lsattrStrings.get().biosVersion);
    }

    @Override
    public Baseboard createBaseboard() {
        return new AixBaseboard(this.lscfg);
    }

    private static LsattrStrings readLsattr() {
        String string = "IBM";
        String string2 = null;
        String string3 = null;
        String string4 = string;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = "fwversion";
        String string9 = "modelname";
        String string10 = "systemid";
        String string11 = "os_uuid";
        String string12 = "Platform Firmware level is";
        for (String string13 : ExecutingCommand.runNative("lsattr -El sys0")) {
            int n2;
            if (string13.startsWith("fwversion")) {
                string2 = string13.split("fwversion")[1].trim();
                n2 = string2.indexOf(44);
                if (n2 > 0 && string2.length() > n2) {
                    string = string2.substring(0, n2);
                    string2 = string2.substring(n2 + 1);
                }
                string2 = ParseUtil.whitespaces.split(string2)[0];
                continue;
            }
            if (string13.startsWith("modelname")) {
                string5 = string13.split("modelname")[1].trim();
                n2 = string5.indexOf(44);
                if (n2 > 0 && string5.length() > n2) {
                    string4 = string5.substring(0, n2);
                    string5 = string5.substring(n2 + 1);
                }
                string5 = ParseUtil.whitespaces.split(string5)[0];
                continue;
            }
            if (string13.startsWith("systemid")) {
                string6 = string13.split("systemid")[1].trim();
                string6 = ParseUtil.whitespaces.split(string6)[0];
                continue;
            }
            if (!string13.startsWith("os_uuid")) continue;
            string7 = string13.split("os_uuid")[1].trim();
            string7 = ParseUtil.whitespaces.split(string7)[0];
        }
        for (String string13 : ExecutingCommand.runNative("lsmcode -c")) {
            if (!string13.startsWith("Platform Firmware level is")) continue;
            string3 = string13.split("Platform Firmware level is")[1].trim();
            break;
        }
        return new LsattrStrings(string, string3, string2, string4, string5, string6, string7);
    }

    static final class LsattrStrings {
        private final String biosVendor;
        private final String biosPlatformVersion;
        private final String biosVersion;
        private final String manufacturer;
        private final String model;
        private final String serialNumber;
        private final String uuid;

        private LsattrStrings(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
            this.biosVendor = Util.isBlank(string) ? "unknown" : string;
            this.biosPlatformVersion = Util.isBlank(string2) ? "unknown" : string2;
            this.biosVersion = Util.isBlank(string3) ? "unknown" : string3;
            this.manufacturer = Util.isBlank(string4) ? "unknown" : string4;
            this.model = Util.isBlank(string5) ? "unknown" : string5;
            this.serialNumber = Util.isBlank(string6) ? "unknown" : string6;
            this.uuid = Util.isBlank(string7) ? "unknown" : string7;
        }
    }
}

