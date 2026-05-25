/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware;

import oshi.annotation.concurrent.Immutable;
import oshi.util.FormatUtil;

@Immutable
public class PhysicalMemory {
    private final String bankLabel;
    private final long capacity;
    private final long clockSpeed;
    private final String manufacturer;
    private final String memoryType;

    public PhysicalMemory(String string, long l2, long l3, String string2, String string3) {
        this.bankLabel = string;
        this.capacity = l2;
        this.clockSpeed = l3;
        this.manufacturer = string2;
        this.memoryType = string3;
    }

    public String getBankLabel() {
        return this.bankLabel;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public long getClockSpeed() {
        return this.clockSpeed;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMemoryType() {
        return this.memoryType;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bank label: " + this.getBankLabel());
        stringBuilder.append(", Capacity: " + FormatUtil.formatBytes(this.getCapacity()));
        stringBuilder.append(", Clock speed: " + FormatUtil.formatHertz(this.getClockSpeed()));
        stringBuilder.append(", Manufacturer: " + this.getManufacturer());
        stringBuilder.append(", Memory type: " + this.getMemoryType());
        return stringBuilder.toString();
    }
}

