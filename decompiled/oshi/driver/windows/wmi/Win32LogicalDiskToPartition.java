/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class Win32LogicalDiskToPartition {
    private static final String WIN32_LOGICAL_DISK_TO_PARTITION = "Win32_LogicalDiskToPartition";

    private Win32LogicalDiskToPartition() {
    }

    public static WbemcliUtil.WmiResult<DiskToPartitionProperty> queryDiskToPartition(WmiQueryHandler wmiQueryHandler) {
        WbemcliUtil.WmiQuery<DiskToPartitionProperty> wmiQuery = new WbemcliUtil.WmiQuery<DiskToPartitionProperty>(WIN32_LOGICAL_DISK_TO_PARTITION, DiskToPartitionProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static enum DiskToPartitionProperty {
        ANTECEDENT,
        DEPENDENT,
        ENDINGADDRESS,
        STARTINGADDRESS;

    }
}

