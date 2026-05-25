/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import oshi.annotation.concurrent.Immutable;
import oshi.hardware.common.AbstractFirmware;

@Immutable
final class SolarisFirmware
extends AbstractFirmware {
    private final String manufacturer;
    private final String version;
    private final String releaseDate;

    SolarisFirmware(String string, String string2, String string3) {
        this.manufacturer = string;
        this.version = string2;
        this.releaseDate = string3;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public String getReleaseDate() {
        return this.releaseDate;
    }
}

