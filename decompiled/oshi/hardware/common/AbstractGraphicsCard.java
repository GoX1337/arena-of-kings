/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import oshi.annotation.concurrent.Immutable;
import oshi.hardware.GraphicsCard;

@Immutable
public abstract class AbstractGraphicsCard
implements GraphicsCard {
    private final String name;
    private final String deviceId;
    private final String vendor;
    private final String versionInfo;
    private long vram;

    public AbstractGraphicsCard(String string, String string2, String string3, String string4, long l2) {
        this.name = string;
        this.deviceId = string2;
        this.vendor = string3;
        this.versionInfo = string4;
        this.vram = l2;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDeviceId() {
        return this.deviceId;
    }

    @Override
    public String getVendor() {
        return this.vendor;
    }

    @Override
    public String getVersionInfo() {
        return this.versionInfo;
    }

    @Override
    public long getVRam() {
        return this.vram;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GraphicsCard@");
        stringBuilder.append(Integer.toHexString(this.hashCode()));
        stringBuilder.append(" [name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", deviceId=");
        stringBuilder.append(this.deviceId);
        stringBuilder.append(", vendor=");
        stringBuilder.append(this.vendor);
        stringBuilder.append(", vRam=");
        stringBuilder.append(this.vram);
        stringBuilder.append(", versionInfo=[");
        stringBuilder.append(this.versionInfo);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}

