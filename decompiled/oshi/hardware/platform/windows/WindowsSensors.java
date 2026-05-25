/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.COMException;
import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.wmi.MSAcpiThermalZoneTemperature;
import oshi.driver.windows.wmi.OhmHardware;
import oshi.driver.windows.wmi.OhmSensor;
import oshi.driver.windows.wmi.Win32Fan;
import oshi.driver.windows.wmi.Win32Processor;
import oshi.hardware.common.AbstractSensors;
import oshi.util.platform.windows.WmiQueryHandler;
import oshi.util.platform.windows.WmiUtil;

@ThreadSafe
final class WindowsSensors
extends AbstractSensors {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsSensors.class);
    private static final String COM_EXCEPTION_MSG = "COM exception: {}";

    WindowsSensors() {
    }

    @Override
    public double queryCpuTemperature() {
        double d2 = WindowsSensors.getTempFromOHM();
        if (d2 > 0.0) {
            return d2;
        }
        d2 = WindowsSensors.getTempFromWMI();
        return d2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static double getTempFromOHM() {
        WmiQueryHandler wmiQueryHandler = Objects.requireNonNull(WmiQueryHandler.createInstance());
        boolean bl2 = false;
        try {
            bl2 = wmiQueryHandler.initCOM();
            WbemcliUtil.WmiResult<OhmHardware.IdentifierProperty> wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Hardware", "CPU");
            if (wmiResult.getResultCount() > 0) {
                WbemcliUtil.WmiResult<OhmSensor.ValueProperty> wmiResult2;
                LOG.debug("Found Temperature data in Open Hardware Monitor");
                String string = WmiUtil.getString(wmiResult, OhmHardware.IdentifierProperty.IDENTIFIER, 0);
                if (string.length() > 0 && (wmiResult2 = OhmSensor.querySensorValue(wmiQueryHandler, string, "Temperature")).getResultCount() > 0) {
                    double d2 = 0.0;
                    for (int i2 = 0; i2 < wmiResult2.getResultCount(); ++i2) {
                        d2 += (double)WmiUtil.getFloat(wmiResult2, OhmSensor.ValueProperty.VALUE, i2);
                    }
                    double d3 = d2 / (double)wmiResult2.getResultCount();
                    return d3;
                }
            }
        }
        catch (COMException cOMException) {
            LOG.warn(COM_EXCEPTION_MSG, (Object)cOMException.getMessage());
        }
        finally {
            if (bl2) {
                wmiQueryHandler.unInitCOM();
            }
        }
        return 0.0;
    }

    private static double getTempFromWMI() {
        double d2 = 0.0;
        long l2 = 0L;
        WbemcliUtil.WmiResult<MSAcpiThermalZoneTemperature.TemperatureProperty> wmiResult = MSAcpiThermalZoneTemperature.queryCurrentTemperature();
        if (wmiResult.getResultCount() > 0) {
            LOG.debug("Found Temperature data in WMI");
            l2 = WmiUtil.getUint32asLong(wmiResult, MSAcpiThermalZoneTemperature.TemperatureProperty.CURRENTTEMPERATURE, 0);
        }
        if (l2 > 2732L) {
            d2 = (double)l2 / 10.0 - 273.15;
        } else if (l2 > 274L) {
            d2 = (double)l2 - 273.0;
        }
        return d2 < 0.0 ? 0.0 : d2;
    }

    @Override
    public int[] queryFanSpeeds() {
        int[] nArray = WindowsSensors.getFansFromOHM();
        if (nArray.length > 0) {
            return nArray;
        }
        nArray = WindowsSensors.getFansFromWMI();
        if (nArray.length > 0) {
            return nArray;
        }
        return new int[0];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static int[] getFansFromOHM() {
        WmiQueryHandler wmiQueryHandler = Objects.requireNonNull(WmiQueryHandler.createInstance());
        boolean bl2 = false;
        try {
            bl2 = wmiQueryHandler.initCOM();
            WbemcliUtil.WmiResult<OhmHardware.IdentifierProperty> wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Hardware", "CPU");
            if (wmiResult.getResultCount() > 0) {
                WbemcliUtil.WmiResult<OhmSensor.ValueProperty> wmiResult2;
                LOG.debug("Found Fan data in Open Hardware Monitor");
                String string = WmiUtil.getString(wmiResult, OhmHardware.IdentifierProperty.IDENTIFIER, 0);
                if (string.length() > 0 && (wmiResult2 = OhmSensor.querySensorValue(wmiQueryHandler, string, "Fan")).getResultCount() > 0) {
                    int[] nArray = new int[wmiResult2.getResultCount()];
                    for (int i2 = 0; i2 < wmiResult2.getResultCount(); ++i2) {
                        nArray[i2] = (int)WmiUtil.getFloat(wmiResult2, OhmSensor.ValueProperty.VALUE, i2);
                    }
                    int[] nArray2 = nArray;
                    return nArray2;
                }
            }
        }
        catch (COMException cOMException) {
            LOG.warn(COM_EXCEPTION_MSG, (Object)cOMException.getMessage());
        }
        finally {
            if (bl2) {
                wmiQueryHandler.unInitCOM();
            }
        }
        return new int[0];
    }

    private static int[] getFansFromWMI() {
        WbemcliUtil.WmiResult<Win32Fan.SpeedProperty> wmiResult = Win32Fan.querySpeed();
        if (wmiResult.getResultCount() > 1) {
            LOG.debug("Found Fan data in WMI");
            int[] nArray = new int[wmiResult.getResultCount()];
            for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                nArray[i2] = (int)WmiUtil.getUint64(wmiResult, Win32Fan.SpeedProperty.DESIREDSPEED, i2);
            }
            return nArray;
        }
        return new int[0];
    }

    @Override
    public double queryCpuVoltage() {
        double d2 = WindowsSensors.getVoltsFromOHM();
        if (d2 > 0.0) {
            return d2;
        }
        d2 = WindowsSensors.getVoltsFromWMI();
        return d2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static double getVoltsFromOHM() {
        WmiQueryHandler wmiQueryHandler = Objects.requireNonNull(WmiQueryHandler.createInstance());
        boolean bl2 = false;
        try {
            bl2 = wmiQueryHandler.initCOM();
            WbemcliUtil.WmiResult<OhmHardware.IdentifierProperty> wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Sensor", "Voltage");
            if (wmiResult.getResultCount() > 0) {
                WbemcliUtil.WmiResult<OhmSensor.ValueProperty> wmiResult2;
                LOG.debug("Found Voltage data in Open Hardware Monitor");
                String string = null;
                for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                    String string2 = WmiUtil.getString(wmiResult, OhmHardware.IdentifierProperty.IDENTIFIER, i2);
                    if (!string2.toLowerCase().contains("cpu")) continue;
                    string = string2;
                    break;
                }
                if (string == null) {
                    string = WmiUtil.getString(wmiResult, OhmHardware.IdentifierProperty.IDENTIFIER, 0);
                }
                if ((wmiResult2 = OhmSensor.querySensorValue(wmiQueryHandler, string, "Voltage")).getResultCount() > 0) {
                    double d2 = WmiUtil.getFloat(wmiResult2, OhmSensor.ValueProperty.VALUE, 0);
                    return d2;
                }
            }
        }
        catch (COMException cOMException) {
            LOG.warn(COM_EXCEPTION_MSG, (Object)cOMException.getMessage());
        }
        finally {
            if (bl2) {
                wmiQueryHandler.unInitCOM();
            }
        }
        return 0.0;
    }

    private static double getVoltsFromWMI() {
        WbemcliUtil.WmiResult<Win32Processor.VoltProperty> wmiResult = Win32Processor.queryVoltage();
        if (wmiResult.getResultCount() > 1) {
            LOG.debug("Found Voltage data in WMI");
            int n2 = WmiUtil.getUint16(wmiResult, Win32Processor.VoltProperty.CURRENTVOLTAGE, 0);
            if (n2 > 0) {
                if ((n2 & 0x80) == 0) {
                    n2 = WmiUtil.getUint32(wmiResult, Win32Processor.VoltProperty.VOLTAGECAPS, 0);
                    if ((n2 & 1) > 0) {
                        return 5.0;
                    }
                    if ((n2 & 2) > 0) {
                        return 3.3;
                    }
                    if ((n2 & 4) > 0) {
                        return 2.9;
                    }
                } else {
                    return (double)(n2 & 0x7F) / 10.0;
                }
            }
        }
        return 0.0;
    }
}

