/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.common.AbstractSensors;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;

@ThreadSafe
final class LinuxSensors
extends AbstractSensors {
    private static final String TEMP = "temp";
    private static final String FAN = "fan";
    private static final String VOLTAGE = "in";
    private static final String[] SENSORS = new String[]{"temp", "fan", "in"};
    private static final String HWMON = "hwmon";
    private static final String HWMON_PATH = "/sys/class/hwmon/hwmon";
    private static final String THERMAL_ZONE = "thermal_zone";
    private static final String THERMAL_ZONE_PATH = "/sys/class/thermal/thermal_zone";
    private static final boolean IS_PI = LinuxSensors.queryCpuTemperatureFromVcGenCmd() > 0.0;
    private final Map<String, String> sensorsMap = new HashMap<String, String>();

    LinuxSensors() {
        if (!IS_PI) {
            this.populateSensorsMapFromHwmon();
            if (!this.sensorsMap.containsKey(TEMP)) {
                this.populateSensorsMapFromThermalZone();
            }
        }
    }

    private void populateSensorsMapFromHwmon() {
        String[] stringArray = SENSORS;
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string;
            String string2 = string = stringArray[i2];
            this.getSensorFilesFromPath(HWMON_PATH, string, file -> {
                try {
                    return file.getName().startsWith(string2) && file.getName().endsWith("_input") && FileUtil.getIntFromFile(file.getCanonicalPath()) > 0;
                }
                catch (IOException iOException) {
                    return false;
                }
            });
        }
    }

    private void populateSensorsMapFromThermalZone() {
        this.getSensorFilesFromPath(THERMAL_ZONE_PATH, TEMP, file -> file.getName().equals(TEMP));
    }

    private void getSensorFilesFromPath(String string, String string2, FileFilter fileFilter) {
        int n2 = 0;
        while (Paths.get(string + n2, new String[0]).toFile().isDirectory()) {
            String string3 = string + n2;
            File file = new File(string3);
            File[] fileArray = file.listFiles(fileFilter);
            if (fileArray != null && fileArray.length > 0) {
                this.sensorsMap.put(string2, String.format("%s/%s", string3, string2));
            }
            ++n2;
        }
    }

    @Override
    public double queryCpuTemperature() {
        if (IS_PI) {
            return LinuxSensors.queryCpuTemperatureFromVcGenCmd();
        }
        String string = this.sensorsMap.get(TEMP);
        if (string != null) {
            long l2 = 0L;
            if (string.contains(HWMON)) {
                l2 = FileUtil.getLongFromFile(String.format("%s1_input", string));
                if (l2 > 0L) {
                    return (double)l2 / 1000.0;
                }
                long l3 = 0L;
                int n2 = 0;
                for (int i2 = 2; i2 <= 6; ++i2) {
                    l2 = FileUtil.getLongFromFile(String.format("%s%d_input", string, i2));
                    if (l2 <= 0L) continue;
                    l3 += l2;
                    ++n2;
                }
                if (n2 > 0) {
                    return (double)l3 / ((double)n2 * 1000.0);
                }
            } else if (string.contains(THERMAL_ZONE) && (l2 = FileUtil.getLongFromFile(string)) > 0L) {
                return (double)l2 / 1000.0;
            }
        }
        return 0.0;
    }

    private static double queryCpuTemperatureFromVcGenCmd() {
        String string = ExecutingCommand.getFirstAnswer("vcgencmd measure_temp");
        if (string.startsWith("temp=")) {
            return ParseUtil.parseDoubleOrDefault(string.replaceAll("[^\\d|\\.]+", ""), 0.0);
        }
        return 0.0;
    }

    @Override
    public int[] queryFanSpeeds() {
        String string;
        if (!IS_PI && (string = this.sensorsMap.get(FAN)) != null) {
            Object object;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int n2 = 1;
            while (new File((String)(object = String.format("%s%d_input", string, n2))).exists()) {
                arrayList.add(FileUtil.getIntFromFile((String)object));
                ++n2;
            }
            object = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                object[i2] = (Integer)arrayList.get(i2);
            }
            return object;
        }
        return new int[0];
    }

    @Override
    public double queryCpuVoltage() {
        if (IS_PI) {
            return LinuxSensors.queryCpuVoltageFromVcGenCmd();
        }
        String string = this.sensorsMap.get(VOLTAGE);
        if (string != null) {
            return (double)FileUtil.getIntFromFile(String.format("%s1_input", string)) / 1000.0;
        }
        return 0.0;
    }

    private static double queryCpuVoltageFromVcGenCmd() {
        String string = ExecutingCommand.getFirstAnswer("vcgencmd measure_volts core");
        if (string.startsWith("volt=")) {
            return ParseUtil.parseDoubleOrDefault(string.replaceAll("[^\\d|\\.]+", ""), 0.0);
        }
        return 0.0;
    }
}

