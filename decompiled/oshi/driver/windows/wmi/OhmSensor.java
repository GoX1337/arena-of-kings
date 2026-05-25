/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class OhmSensor {
    private static final String SENSOR = "Sensor";

    private OhmSensor() {
    }

    public static WbemcliUtil.WmiResult<ValueProperty> querySensorValue(WmiQueryHandler wmiQueryHandler, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(SENSOR);
        stringBuilder.append(" WHERE Parent = \"").append(string);
        stringBuilder.append("\" AND SensorType=\"").append(string2).append('\"');
        WbemcliUtil.WmiQuery<ValueProperty> wmiQuery = new WbemcliUtil.WmiQuery<ValueProperty>("ROOT\\OpenHardwareMonitor", stringBuilder.toString(), ValueProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static enum ValueProperty {
        VALUE;

    }
}

