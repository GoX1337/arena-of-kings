/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.unix.UnixBaseboard;
import oshi.hardware.platform.unix.solaris.SolarisFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;

@Immutable
final class SolarisComputerSystem
extends AbstractComputerSystem {
    private final Supplier<SmbiosStrings> smbiosStrings = Memoizer.memoize(SolarisComputerSystem::readSmbios);

    SolarisComputerSystem() {
    }

    @Override
    public String getManufacturer() {
        return this.smbiosStrings.get().manufacturer;
    }

    @Override
    public String getModel() {
        return this.smbiosStrings.get().model;
    }

    @Override
    public String getSerialNumber() {
        return this.smbiosStrings.get().serialNumber;
    }

    @Override
    public String getHardwareUUID() {
        return this.smbiosStrings.get().uuid;
    }

    @Override
    public Firmware createFirmware() {
        return new SolarisFirmware(this.smbiosStrings.get().biosVendor, this.smbiosStrings.get().biosVersion, this.smbiosStrings.get().biosDate);
    }

    @Override
    public Baseboard createBaseboard() {
        return new UnixBaseboard(this.smbiosStrings.get().boardManufacturer, this.smbiosStrings.get().boardModel, this.smbiosStrings.get().boardSerialNumber, this.smbiosStrings.get().boardVersion);
    }

    private static SmbiosStrings readSmbios() {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = null;
        String string8 = null;
        String string9 = null;
        String string10 = null;
        String string11 = null;
        String string12 = "Vendor:";
        String string13 = "Release Date:";
        String string14 = "VersionString:";
        String string15 = "Manufacturer:";
        String string16 = "Product:";
        String string17 = "Serial Number:";
        String string18 = "UUID:";
        String string19 = "Version:";
        int n2 = -1;
        for (String string20 : ExecutingCommand.runNative("smbios")) {
            if (string20.contains("SMB_TYPE_") && (n2 = SolarisComputerSystem.getSmbType(string20)) == Integer.MAX_VALUE) break;
            switch (n2) {
                case 0: {
                    if (string20.contains("Vendor:")) {
                        string = string20.split("Vendor:")[1].trim();
                        break;
                    }
                    if (string20.contains("VersionString:")) {
                        string2 = string20.split("VersionString:")[1].trim();
                        break;
                    }
                    if (!string20.contains("Release Date:")) break;
                    string3 = string20.split("Release Date:")[1].trim();
                    break;
                }
                case 1: {
                    if (string20.contains("Manufacturer:")) {
                        string4 = string20.split("Manufacturer:")[1].trim();
                        break;
                    }
                    if (string20.contains("Product:")) {
                        string5 = string20.split("Product:")[1].trim();
                        break;
                    }
                    if (string20.contains("Serial Number:")) {
                        string6 = string20.split("Serial Number:")[1].trim();
                        break;
                    }
                    if (!string20.contains("UUID:")) break;
                    string7 = string20.split("UUID:")[1].trim();
                    break;
                }
                case 2: {
                    if (string20.contains("Manufacturer:")) {
                        string8 = string20.split("Manufacturer:")[1].trim();
                        break;
                    }
                    if (string20.contains("Product:")) {
                        string9 = string20.split("Product:")[1].trim();
                        break;
                    }
                    if (string20.contains("Version:")) {
                        string10 = string20.split("Version:")[1].trim();
                        break;
                    }
                    if (!string20.contains("Serial Number:")) break;
                    string11 = string20.split("Serial Number:")[1].trim();
                    break;
                }
            }
        }
        if (Util.isBlank(string6)) {
            string6 = SolarisComputerSystem.readSerialNumber();
        }
        return new SmbiosStrings(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
    }

    private static int getSmbType(String string) {
        if (string.contains("SMB_TYPE_BIOS")) {
            return 0;
        }
        if (string.contains("SMB_TYPE_SYSTEM")) {
            return 1;
        }
        if (string.contains("SMB_TYPE_BASEBOARD")) {
            return 2;
        }
        return Integer.MAX_VALUE;
    }

    private static String readSerialNumber() {
        String string = ExecutingCommand.getFirstAnswer("sneep");
        if (string.isEmpty()) {
            String string2 = "chassis-sn:";
            for (String string3 : ExecutingCommand.runNative("prtconf -pv")) {
                if (!string3.contains(string2)) continue;
                string = ParseUtil.getSingleQuoteStringValue(string3);
                break;
            }
        }
        return string;
    }

    static final class SmbiosStrings {
        private final String biosVendor;
        private final String biosVersion;
        private final String biosDate;
        private final String manufacturer;
        private final String model;
        private final String serialNumber;
        private final String uuid;
        private final String boardManufacturer;
        private final String boardModel;
        private final String boardVersion;
        private final String boardSerialNumber;

        private SmbiosStrings(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
            this.biosVendor = Util.isBlank(string) ? "unknown" : string;
            this.biosVersion = Util.isBlank(string2) ? "unknown" : string2;
            this.biosDate = Util.isBlank(string3) ? "unknown" : string3;
            this.manufacturer = Util.isBlank(string4) ? "unknown" : string4;
            this.model = Util.isBlank(string5) ? "unknown" : string5;
            this.serialNumber = Util.isBlank(string6) ? "unknown" : string6;
            this.uuid = Util.isBlank(string7) ? "unknown" : string7;
            this.boardManufacturer = Util.isBlank(string8) ? "unknown" : string8;
            this.boardModel = Util.isBlank(string9) ? "unknown" : string9;
            this.boardVersion = Util.isBlank(string10) ? "unknown" : string10;
            this.boardSerialNumber = Util.isBlank(string11) ? "unknown" : string11;
        }
    }
}

