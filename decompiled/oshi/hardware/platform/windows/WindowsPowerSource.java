/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.SetupApi;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APITypeMapper;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.jna.platform.windows.PowrProf;

@ThreadSafe
public final class WindowsPowerSource
extends AbstractPowerSource {
    private static final Guid.GUID GUID_DEVCLASS_BATTERY = Guid.GUID.fromString("{72631E54-78A4-11D0-BCF7-00AA00B7B32A}");
    private static final int CHAR_WIDTH = W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE ? 2 : 1;
    private static final boolean X64 = Platform.is64Bit();
    private static final int BATTERY_SYSTEM_BATTERY = Integer.MIN_VALUE;
    private static final int BATTERY_IS_SHORT_TERM = 0x20000000;
    private static final int BATTERY_POWER_ON_LINE = 1;
    private static final int BATTERY_DISCHARGING = 2;
    private static final int BATTERY_CHARGING = 4;
    private static final int BATTERY_CAPACITY_RELATIVE = 0x40000000;
    private static final int IOCTL_BATTERY_QUERY_TAG = 2703424;
    private static final int IOCTL_BATTERY_QUERY_STATUS = 2703436;
    private static final int IOCTL_BATTERY_QUERY_INFORMATION = 2703428;

    public WindowsPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        return Arrays.asList(WindowsPowerSource.getPowerSource("System Battery"));
    }

    private static WindowsPowerSource getPowerSource(String string) {
        Object object;
        String string2 = string;
        String string3 = "unknown";
        double d2 = 1.0;
        double d3 = -1.0;
        double d4 = 0.0;
        int n2 = 0;
        double d5 = -1.0;
        double d6 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n3 = 0;
        int n4 = 1;
        int n5 = 1;
        int n6 = -1;
        String string4 = "unknown";
        LocalDate localDate = null;
        String string5 = "unknown";
        String string6 = "unknown";
        double d7 = 0.0;
        int n7 = new PowrProf.SystemBatteryState().size();
        Memory memory = new Memory(n7);
        if (0 == PowrProf.INSTANCE.CallNtPowerInformation(5, null, 0, memory, n7)) {
            object = new PowrProf.SystemBatteryState(memory);
            if (((PowrProf.SystemBatteryState)object).batteryPresent > 0) {
                if (((PowrProf.SystemBatteryState)object).acOnLine == 0 && ((PowrProf.SystemBatteryState)object).charging == 0 && ((PowrProf.SystemBatteryState)object).discharging > 0) {
                    d3 = ((PowrProf.SystemBatteryState)object).estimatedTime;
                } else if (((PowrProf.SystemBatteryState)object).charging > 0) {
                    d3 = -2.0;
                }
                n4 = ((PowrProf.SystemBatteryState)object).maxCapacity;
                n3 = ((PowrProf.SystemBatteryState)object).remainingCapacity;
                d2 = Math.min(1.0, (double)n3 / (double)n4);
                n2 = ((PowrProf.SystemBatteryState)object).rate;
            }
        }
        if (!WinBase.INVALID_HANDLE_VALUE.equals(object = SetupApi.INSTANCE.SetupDiGetClassDevs(GUID_DEVCLASS_BATTERY, null, null, 18))) {
            boolean bl5 = false;
            for (int i2 = 0; !bl5 && i2 < 100; ++i2) {
                SetupApi.SP_DEVICE_INTERFACE_DATA sP_DEVICE_INTERFACE_DATA = new SetupApi.SP_DEVICE_INTERFACE_DATA();
                sP_DEVICE_INTERFACE_DATA.cbSize = sP_DEVICE_INTERFACE_DATA.size();
                if (SetupApi.INSTANCE.SetupDiEnumDeviceInterfaces((WinNT.HANDLE)object, null, GUID_DEVCLASS_BATTERY, i2, sP_DEVICE_INTERFACE_DATA)) {
                    String string7;
                    WinNT.HANDLE hANDLE;
                    IntByReference intByReference = new IntByReference(0);
                    SetupApi.INSTANCE.SetupDiGetDeviceInterfaceDetail((WinNT.HANDLE)object, sP_DEVICE_INTERFACE_DATA, null, 0, intByReference, null);
                    if (122 != Kernel32.INSTANCE.GetLastError()) continue;
                    Memory memory2 = new Memory(intByReference.getValue());
                    memory2.setInt(0L, 4 + (X64 ? 4 : CHAR_WIDTH));
                    if (!SetupApi.INSTANCE.SetupDiGetDeviceInterfaceDetail((WinNT.HANDLE)object, sP_DEVICE_INTERFACE_DATA, memory2, (int)memory2.size(), intByReference, null) || WinBase.INVALID_HANDLE_VALUE.equals(hANDLE = Kernel32.INSTANCE.CreateFile(string7 = CHAR_WIDTH > 1 ? memory2.getWideString(4L) : memory2.getString(4L), -1073741824, 3, null, 3, 128, null))) continue;
                    PowrProf.BATTERY_QUERY_INFORMATION bATTERY_QUERY_INFORMATION = new PowrProf.BATTERY_QUERY_INFORMATION();
                    IntByReference intByReference2 = new IntByReference(0);
                    IntByReference intByReference3 = new IntByReference();
                    IntByReference intByReference4 = new IntByReference();
                    if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703424, intByReference2.getPointer(), 4, intByReference3.getPointer(), 4, intByReference4, null)) {
                        bATTERY_QUERY_INFORMATION.BatteryTag = intByReference3.getValue();
                        if (bATTERY_QUERY_INFORMATION.BatteryTag > 0) {
                            bATTERY_QUERY_INFORMATION.InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryInformation.ordinal();
                            bATTERY_QUERY_INFORMATION.write();
                            PowrProf.BATTERY_INFORMATION bATTERY_INFORMATION = new PowrProf.BATTERY_INFORMATION();
                            if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION.size(), bATTERY_INFORMATION.getPointer(), bATTERY_INFORMATION.size(), intByReference4, null)) {
                                Object object2;
                                Structure structure;
                                bATTERY_INFORMATION.read();
                                if (0 != (bATTERY_INFORMATION.Capabilities & Integer.MIN_VALUE) && 0 == (bATTERY_INFORMATION.Capabilities & 0x20000000)) {
                                    if (0 == (bATTERY_INFORMATION.Capabilities & 0x40000000)) {
                                        capacityUnits = PowerSource.CapacityUnits.MWH;
                                    }
                                    string4 = Native.toString(bATTERY_INFORMATION.Chemistry, StandardCharsets.US_ASCII);
                                    n5 = bATTERY_INFORMATION.DesignedCapacity;
                                    n4 = bATTERY_INFORMATION.FullChargedCapacity;
                                    n6 = bATTERY_INFORMATION.CycleCount;
                                    structure = new PowrProf.BATTERY_WAIT_STATUS();
                                    ((PowrProf.BATTERY_WAIT_STATUS)structure).BatteryTag = bATTERY_QUERY_INFORMATION.BatteryTag;
                                    structure.write();
                                    object2 = new PowrProf.BATTERY_STATUS();
                                    if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703436, structure.getPointer(), structure.size(), ((Structure)object2).getPointer(), ((Structure)object2).size(), intByReference4, null)) {
                                        ((Structure)object2).read();
                                        if (0 != (((PowrProf.BATTERY_STATUS)object2).PowerState & 1)) {
                                            bl2 = true;
                                        }
                                        if (0 != (((PowrProf.BATTERY_STATUS)object2).PowerState & 2)) {
                                            bl4 = true;
                                        }
                                        if (0 != (((PowrProf.BATTERY_STATUS)object2).PowerState & 4)) {
                                            bl3 = true;
                                        }
                                        n3 = ((PowrProf.BATTERY_STATUS)object2).Capacity;
                                        d5 = ((PowrProf.BATTERY_STATUS)object2).Voltage > 0 ? (double)((PowrProf.BATTERY_STATUS)object2).Voltage / 1000.0 : (double)((PowrProf.BATTERY_STATUS)object2).Voltage;
                                        n2 = ((PowrProf.BATTERY_STATUS)object2).Rate;
                                        if (d5 > 0.0) {
                                            d6 = (double)n2 / d5;
                                        }
                                    }
                                }
                                string3 = WindowsPowerSource.batteryQueryString(hANDLE, intByReference3.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryDeviceName.ordinal());
                                string5 = WindowsPowerSource.batteryQueryString(hANDLE, intByReference3.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryManufactureName.ordinal());
                                string6 = WindowsPowerSource.batteryQueryString(hANDLE, intByReference3.getValue(), PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatterySerialNumber.ordinal());
                                bATTERY_QUERY_INFORMATION.InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryManufactureDate.ordinal();
                                bATTERY_QUERY_INFORMATION.write();
                                structure = new PowrProf.BATTERY_MANUFACTURE_DATE();
                                if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION.size(), structure.getPointer(), structure.size(), intByReference4, null)) {
                                    structure.read();
                                    if (((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Year > 1900 && ((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Month > 0 && ((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Day > 0) {
                                        localDate = LocalDate.of((int)((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Year, ((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Month, (int)((PowrProf.BATTERY_MANUFACTURE_DATE)structure).Day);
                                    }
                                }
                                bATTERY_QUERY_INFORMATION.InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryTemperature.ordinal();
                                bATTERY_QUERY_INFORMATION.write();
                                object2 = new IntByReference();
                                if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION.size(), ((PointerType)object2).getPointer(), 4, intByReference4, null)) {
                                    d7 = (double)((IntByReference)object2).getValue() / 10.0 - 273.15;
                                }
                                bATTERY_QUERY_INFORMATION.InformationLevel = PowrProf.BATTERY_QUERY_INFORMATION_LEVEL.BatteryEstimatedTime.ordinal();
                                if (n2 != 0) {
                                    bATTERY_QUERY_INFORMATION.AtRate = n2;
                                }
                                bATTERY_QUERY_INFORMATION.write();
                                IntByReference intByReference5 = new IntByReference();
                                if (Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION.size(), intByReference5.getPointer(), 4, intByReference4, null)) {
                                    d4 = intByReference5.getValue();
                                }
                                if (d4 < 0.0 && n2 != 0 && (d4 = (double)(n4 - n3) * 3600.0 / (double)n2) < 0.0) {
                                    d4 *= -1.0;
                                }
                                bl5 = true;
                            }
                        }
                    }
                    Kernel32.INSTANCE.CloseHandle(hANDLE);
                    continue;
                }
                if (259 == Kernel32.INSTANCE.GetLastError()) break;
            }
            SetupApi.INSTANCE.SetupDiDestroyDeviceInfoList((WinNT.HANDLE)object);
        }
        return new WindowsPowerSource(string2, string3, d2, d3, d4, n2, d5, d6, bl2, bl3, bl4, capacityUnits, n3, n4, n5, n6, string4, localDate, string5, string6, d7);
    }

    private static String batteryQueryString(WinNT.HANDLE hANDLE, int n2, int n3) {
        Memory memory;
        PowrProf.BATTERY_QUERY_INFORMATION bATTERY_QUERY_INFORMATION = new PowrProf.BATTERY_QUERY_INFORMATION();
        bATTERY_QUERY_INFORMATION.BatteryTag = n2;
        bATTERY_QUERY_INFORMATION.InformationLevel = n3;
        bATTERY_QUERY_INFORMATION.write();
        IntByReference intByReference = new IntByReference();
        boolean bl2 = false;
        long l2 = 0L;
        do {
            memory = new Memory(l2 += 256L);
        } while (!(bl2 = Kernel32.INSTANCE.DeviceIoControl(hANDLE, 2703428, bATTERY_QUERY_INFORMATION.getPointer(), bATTERY_QUERY_INFORMATION.size(), memory, (int)memory.size(), intByReference, null)) && l2 < 4096L);
        return CHAR_WIDTH > 1 ? memory.getWideString(0L) : memory.getString(0L);
    }
}

