/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware;

import oshi.annotation.concurrent.Immutable;
import oshi.util.FormatUtil;

@Immutable
public class HWPartition {
    private final String identification;
    private final String name;
    private final String type;
    private final String uuid;
    private final long size;
    private final int major;
    private final int minor;
    private final String mountPoint;

    public HWPartition(String string, String string2, String string3, String string4, long l2, int n2, int n3, String string5) {
        this.identification = string;
        this.name = string2;
        this.type = string3;
        this.uuid = string4;
        this.size = l2;
        this.major = n2;
        this.minor = n3;
        this.mountPoint = string5;
    }

    public String getIdentification() {
        return this.identification;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getUuid() {
        return this.uuid;
    }

    public long getSize() {
        return this.size;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getIdentification()).append(": ");
        stringBuilder.append(this.getName()).append(" ");
        stringBuilder.append("(").append(this.getType()).append(") ");
        stringBuilder.append("Maj:Min=").append(this.getMajor()).append(":").append(this.getMinor()).append(", ");
        stringBuilder.append("size: ").append(FormatUtil.formatBytesDecimal(this.getSize()));
        stringBuilder.append(this.getMountPoint().isEmpty() ? "" : " @ " + this.getMountPoint());
        return stringBuilder.toString();
    }
}

