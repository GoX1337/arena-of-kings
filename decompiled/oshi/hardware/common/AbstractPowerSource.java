/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import com.sun.jna.Platform;
import java.time.LocalDate;
import java.util.List;
import oshi.SystemInfo;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.platform.linux.LinuxPowerSource;
import oshi.hardware.platform.mac.MacPowerSource;
import oshi.hardware.platform.unix.aix.AixPowerSource;
import oshi.hardware.platform.unix.freebsd.FreeBsdPowerSource;
import oshi.hardware.platform.unix.solaris.SolarisPowerSource;
import oshi.hardware.platform.windows.WindowsPowerSource;

@ThreadSafe
public abstract class AbstractPowerSource
implements PowerSource {
    private String name;
    private String deviceName;
    private double remainingCapacityPercent;
    private double timeRemainingEstimated;
    private double timeRemainingInstant;
    private double powerUsageRate;
    private double voltage;
    private double amperage;
    private boolean powerOnLine;
    private boolean charging;
    private boolean discharging;
    private PowerSource.CapacityUnits capacityUnits;
    private int currentCapacity;
    private int maxCapacity;
    private int designCapacity;
    private int cycleCount;
    private String chemistry;
    private LocalDate manufactureDate;
    private String manufacturer;
    private String serialNumber;
    private double temperature;

    public AbstractPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        this.name = string;
        this.deviceName = string2;
        this.remainingCapacityPercent = d2;
        this.timeRemainingEstimated = d3;
        this.timeRemainingInstant = d4;
        this.powerUsageRate = d5;
        this.voltage = d6;
        this.amperage = d7;
        this.powerOnLine = bl2;
        this.charging = bl3;
        this.discharging = bl4;
        this.capacityUnits = capacityUnits;
        this.currentCapacity = n2;
        this.maxCapacity = n3;
        this.designCapacity = n4;
        this.cycleCount = n5;
        this.chemistry = string3;
        this.manufactureDate = localDate;
        this.manufacturer = string4;
        this.serialNumber = string5;
        this.temperature = d8;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override
    public double getRemainingCapacityPercent() {
        return this.remainingCapacityPercent;
    }

    @Override
    public double getTimeRemainingEstimated() {
        return this.timeRemainingEstimated;
    }

    @Override
    public double getTimeRemainingInstant() {
        return this.timeRemainingInstant;
    }

    @Override
    public double getPowerUsageRate() {
        return this.powerUsageRate;
    }

    @Override
    public double getVoltage() {
        return this.voltage;
    }

    @Override
    public double getAmperage() {
        return this.amperage;
    }

    @Override
    public boolean isPowerOnLine() {
        return this.powerOnLine;
    }

    @Override
    public boolean isCharging() {
        return this.charging;
    }

    @Override
    public boolean isDischarging() {
        return this.discharging;
    }

    @Override
    public PowerSource.CapacityUnits getCapacityUnits() {
        return this.capacityUnits;
    }

    @Override
    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public int getDesignCapacity() {
        return this.designCapacity;
    }

    @Override
    public int getCycleCount() {
        return this.cycleCount;
    }

    @Override
    public String getChemistry() {
        return this.chemistry;
    }

    @Override
    public LocalDate getManufactureDate() {
        return this.manufactureDate;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public boolean updateAttributes() {
        List<PowerSource> list = AbstractPowerSource.getPowerSources();
        for (PowerSource powerSource : list) {
            if (!powerSource.getName().equals(this.name)) continue;
            this.name = powerSource.getName();
            this.deviceName = powerSource.getDeviceName();
            this.remainingCapacityPercent = powerSource.getRemainingCapacityPercent();
            this.timeRemainingEstimated = powerSource.getTimeRemainingEstimated();
            this.timeRemainingInstant = powerSource.getTimeRemainingInstant();
            this.powerUsageRate = powerSource.getPowerUsageRate();
            this.voltage = powerSource.getVoltage();
            this.amperage = powerSource.getAmperage();
            this.powerOnLine = powerSource.isPowerOnLine();
            this.charging = powerSource.isCharging();
            this.discharging = powerSource.isDischarging();
            this.capacityUnits = powerSource.getCapacityUnits();
            this.currentCapacity = powerSource.getCurrentCapacity();
            this.maxCapacity = powerSource.getMaxCapacity();
            this.designCapacity = powerSource.getDesignCapacity();
            this.cycleCount = powerSource.getCycleCount();
            this.chemistry = powerSource.getChemistry();
            this.manufactureDate = powerSource.getManufactureDate();
            this.manufacturer = powerSource.getManufacturer();
            this.serialNumber = powerSource.getSerialNumber();
            this.temperature = powerSource.getTemperature();
            return true;
        }
        return false;
    }

    private static List<PowerSource> getPowerSources() {
        switch (SystemInfo.getCurrentPlatform()) {
            case WINDOWS: {
                return WindowsPowerSource.getPowerSources();
            }
            case MACOS: {
                return MacPowerSource.getPowerSources();
            }
            case LINUX: {
                return LinuxPowerSource.getPowerSources();
            }
            case SOLARIS: {
                return SolarisPowerSource.getPowerSources();
            }
            case FREEBSD: {
                return FreeBsdPowerSource.getPowerSources();
            }
            case AIX: {
                return AixPowerSource.getPowerSources();
            }
        }
        throw new UnsupportedOperationException("Operating system not supported: " + Platform.getOSType());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(this.getName()).append(", ");
        stringBuilder.append("Device Name: ").append(this.getDeviceName()).append(",\n ");
        stringBuilder.append("RemainingCapacityPercent: ").append(this.getRemainingCapacityPercent() * 100.0).append("%, ");
        stringBuilder.append("Time Remaining: ").append(AbstractPowerSource.formatTimeRemaining(this.getTimeRemainingEstimated())).append(", ");
        stringBuilder.append("Time Remaining Instant: ").append(AbstractPowerSource.formatTimeRemaining(this.getTimeRemainingInstant())).append(",\n ");
        stringBuilder.append("Power Usage Rate: ").append(this.getPowerUsageRate()).append("mW, ");
        stringBuilder.append("Voltage: ");
        if (this.getVoltage() > 0.0) {
            stringBuilder.append(this.getVoltage()).append("V, ");
        } else {
            stringBuilder.append("unknown");
        }
        stringBuilder.append("Amperage: ").append(this.getAmperage()).append("mA,\n ");
        stringBuilder.append("Power OnLine: ").append(this.isPowerOnLine()).append(", ");
        stringBuilder.append("Charging: ").append(this.isCharging()).append(", ");
        stringBuilder.append("Discharging: ").append(this.isDischarging()).append(",\n ");
        stringBuilder.append("Capacity Units: ").append((Object)this.getCapacityUnits()).append(", ");
        stringBuilder.append("Current Capacity: ").append(this.getCurrentCapacity()).append(", ");
        stringBuilder.append("Max Capacity: ").append(this.getMaxCapacity()).append(", ");
        stringBuilder.append("Design Capacity: ").append(this.getDesignCapacity()).append(",\n ");
        stringBuilder.append("Cycle Count: ").append(this.getCycleCount()).append(", ");
        stringBuilder.append("Chemistry: ").append(this.getChemistry()).append(", ");
        stringBuilder.append("Manufacture Date: ").append(this.getManufactureDate() != null ? this.getManufactureDate() : "unknown").append(", ");
        stringBuilder.append("Manufacturer: ").append(this.getManufacturer()).append(",\n ");
        stringBuilder.append("SerialNumber: ").append(this.getSerialNumber()).append(", ");
        stringBuilder.append("Temperature: ");
        if (this.getTemperature() > 0.0) {
            stringBuilder.append(this.getTemperature()).append("\u00b0C");
        } else {
            stringBuilder.append("unknown");
        }
        return stringBuilder.toString();
    }

    private static String formatTimeRemaining(double d2) {
        String string;
        if (d2 < -1.5) {
            string = "Charging";
        } else if (d2 < 0.0) {
            string = "Unknown";
        } else {
            int n2 = (int)(d2 / 3600.0);
            int n3 = (int)(d2 % 3600.0 / 60.0);
            string = String.format("%d:%02d", n2, n3);
        }
        return string;
    }
}

