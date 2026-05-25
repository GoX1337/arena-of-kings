/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.freebsd;

import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.common.AbstractFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.tuples.Triplet;

@Immutable
final class FreeBsdFirmware
extends AbstractFirmware {
    private final Supplier<Triplet<String, String, String>> manufVersRelease = Memoizer.memoize(FreeBsdFirmware::readDmiDecode);

    FreeBsdFirmware() {
    }

    @Override
    public String getManufacturer() {
        return this.manufVersRelease.get().getA();
    }

    @Override
    public String getVersion() {
        return this.manufVersRelease.get().getB();
    }

    @Override
    public String getReleaseDate() {
        return this.manufVersRelease.get().getC();
    }

    private static Triplet<String, String, String> readDmiDecode() {
        String string = null;
        String string2 = null;
        String string3 = "";
        String string4 = "Vendor:";
        String string5 = "Version:";
        String string6 = "Release Date:";
        for (String string7 : ExecutingCommand.runNative("dmidecode -t bios")) {
            if (string7.contains("Vendor:")) {
                string = string7.split("Vendor:")[1].trim();
                continue;
            }
            if (string7.contains("Version:")) {
                string2 = string7.split("Version:")[1].trim();
                continue;
            }
            if (!string7.contains("Release Date:")) continue;
            string3 = string7.split("Release Date:")[1].trim();
        }
        string3 = ParseUtil.parseMmDdYyyyToYyyyMmDD(string3);
        return new Triplet<String, String, String>(Util.isBlank(string) ? "unknown" : string, Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string3) ? "unknown" : string3);
    }
}

