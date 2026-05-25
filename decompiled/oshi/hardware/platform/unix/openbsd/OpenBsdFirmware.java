/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.openbsd;

import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.common.AbstractFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;
import oshi.util.tuples.Triplet;

@Immutable
public class OpenBsdFirmware
extends AbstractFirmware {
    private final Supplier<Triplet<String, String, String>> manufVersRelease = Memoizer.memoize(OpenBsdFirmware::readDmesg);

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

    private static Triplet<String, String, String> readDmesg() {
        String string = null;
        String string2 = null;
        String string3 = "";
        List<String> list = ExecutingCommand.runNative("dmesg");
        for (String string4 : list) {
            if (!string4.startsWith("bios0: vendor")) continue;
            string = ParseUtil.getStringBetween(string4, '\"');
            string3 = ParseUtil.parseMmDdYyyyToYyyyMmDD(ParseUtil.parseLastString(string4));
            string2 = string4.split("vendor")[1].trim();
        }
        return new Triplet<String, String, String>(Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string) ? "unknown" : string, Util.isBlank(string3) ? "unknown" : string3);
    }
}

