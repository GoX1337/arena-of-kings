/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.util.Objects;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class Win32LogicalDisk {
    private static final String WIN32_LOGICAL_DISK = "Win32_LogicalDisk";

    private Win32LogicalDisk() {
    }

    public static WbemcliUtil.WmiResult<LogicalDiskProperty> queryLogicalDisk(String string, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(WIN32_LOGICAL_DISK);
        boolean bl3 = false;
        if (bl2) {
            stringBuilder.append(" WHERE DriveType != 4");
            bl3 = true;
        }
        if (string != null) {
            stringBuilder.append(bl3 ? " AND" : " WHERE").append(" Name=\"").append(string).append('\"');
        }
        WbemcliUtil.WmiQuery<LogicalDiskProperty> wmiQuery = new WbemcliUtil.WmiQuery<LogicalDiskProperty>(stringBuilder.toString(), LogicalDiskProperty.class);
        return Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(wmiQuery);
    }

    public static enum LogicalDiskProperty {
        ACCESS,
        DESCRIPTION,
        DRIVETYPE,
        FILESYSTEM,
        FREESPACE,
        NAME,
        PROVIDERNAME,
        SIZE,
        VOLUMENAME;

    }
}

