/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import oshi.annotation.concurrent.Immutable;
import oshi.hardware.common.AbstractFirmware;

@Immutable
final class AixFirmware
extends AbstractFirmware {
    private final String manufacturer;
    private final String name;
    private final String version;

    AixFirmware(String string, String string2, String string3) {
        this.manufacturer = string;
        this.name = string2;
        this.version = string3;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getVersion() {
        return this.version;
    }
}

