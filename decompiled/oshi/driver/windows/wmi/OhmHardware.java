/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class OhmHardware {
    private static final String HARDWARE = "Hardware";

    private OhmHardware() {
    }

    public static WbemcliUtil.WmiResult<IdentifierProperty> queryHwIdentifier(WmiQueryHandler wmiQueryHandler, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(HARDWARE);
        stringBuilder.append(" WHERE ").append(string).append("Type=\"").append(string2).append('\"');
        WbemcliUtil.WmiQuery<IdentifierProperty> wmiQuery = new WbemcliUtil.WmiQuery<IdentifierProperty>("ROOT\\OpenHardwareMonitor", stringBuilder.toString(), IdentifierProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static enum IdentifierProperty {
        IDENTIFIER;

    }
}

