/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix;

import oshi.annotation.concurrent.Immutable;
import oshi.hardware.common.AbstractBaseboard;

@Immutable
public final class UnixBaseboard
extends AbstractBaseboard {
    private final String manufacturer;
    private final String model;
    private final String serialNumber;
    private final String version;

    public UnixBaseboard(String string, String string2, String string3, String string4) {
        this.manufacturer = string;
        this.model = string2;
        this.serialNumber = string3;
        this.version = string4;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public String getVersion() {
        return this.version;
    }
}

