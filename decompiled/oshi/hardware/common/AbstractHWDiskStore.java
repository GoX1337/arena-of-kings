/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.HWDiskStore;
import oshi.util.FormatUtil;

@ThreadSafe
public abstract class AbstractHWDiskStore
implements HWDiskStore {
    private final String name;
    private final String model;
    private final String serial;
    private final long size;

    public AbstractHWDiskStore(String string, String string2, String string3, long l2) {
        this.name = string;
        this.model = string2;
        this.serial = string3;
        this.size = l2;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getSerial() {
        return this.serial;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    public String toString() {
        boolean bl2 = this.getReads() > 0L || this.getWrites() > 0L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getName()).append(": ");
        stringBuilder.append("(model: ").append(this.getModel());
        stringBuilder.append(" - S/N: ").append(this.getSerial()).append(") ");
        stringBuilder.append("size: ").append(this.getSize() > 0L ? FormatUtil.formatBytesDecimal(this.getSize()) : "?").append(", ");
        stringBuilder.append("reads: ").append(bl2 ? Long.valueOf(this.getReads()) : "?");
        stringBuilder.append(" (").append(bl2 ? FormatUtil.formatBytes(this.getReadBytes()) : "?").append("), ");
        stringBuilder.append("writes: ").append(bl2 ? Long.valueOf(this.getWrites()) : "?");
        stringBuilder.append(" (").append(bl2 ? FormatUtil.formatBytes(this.getWriteBytes()) : "?").append("), ");
        stringBuilder.append("xfer: ").append(bl2 ? Long.valueOf(this.getTransferTime()) : "?");
        return stringBuilder.toString();
    }
}

