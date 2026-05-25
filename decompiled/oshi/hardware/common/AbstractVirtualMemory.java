/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.VirtualMemory;
import oshi.util.FormatUtil;

@ThreadSafe
public abstract class AbstractVirtualMemory
implements VirtualMemory {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Swap Used/Avail: ");
        stringBuilder.append(FormatUtil.formatBytes(this.getSwapUsed()));
        stringBuilder.append("/");
        stringBuilder.append(FormatUtil.formatBytes(this.getSwapTotal()));
        stringBuilder.append(", Virtual Memory In Use/Max=");
        stringBuilder.append(FormatUtil.formatBytes(this.getVirtualInUse()));
        stringBuilder.append("/");
        stringBuilder.append(FormatUtil.formatBytes(this.getVirtualMax()));
        return stringBuilder.toString();
    }
}

