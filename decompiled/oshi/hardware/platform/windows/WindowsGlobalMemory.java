/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Psapi;
import com.sun.jna.platform.win32.VersionHelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.windows.wmi.Win32PhysicalMemory;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.VirtualMemory;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.windows.WindowsVirtualMemory;
import oshi.util.Memoizer;
import oshi.util.platform.windows.WmiUtil;
import oshi.util.tuples.Triplet;

@ThreadSafe
final class WindowsGlobalMemory
extends AbstractGlobalMemory {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsGlobalMemory.class);
    private static final boolean IS_WINDOWS10_OR_GREATER = VersionHelpers.IsWindows10OrGreater();
    private final Supplier<Triplet<Long, Long, Long>> availTotalSize = Memoizer.memoize(WindowsGlobalMemory::readPerfInfo, Memoizer.defaultExpiration());
    private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);

    WindowsGlobalMemory() {
    }

    @Override
    public long getAvailable() {
        return this.availTotalSize.get().getA();
    }

    @Override
    public long getTotal() {
        return this.availTotalSize.get().getB();
    }

    @Override
    public long getPageSize() {
        return this.availTotalSize.get().getC();
    }

    @Override
    public VirtualMemory getVirtualMemory() {
        return this.vm.get();
    }

    private VirtualMemory createVirtualMemory() {
        return new WindowsVirtualMemory(this);
    }

    @Override
    public List<PhysicalMemory> getPhysicalMemory() {
        ArrayList<PhysicalMemory> arrayList = new ArrayList<PhysicalMemory>();
        if (IS_WINDOWS10_OR_GREATER) {
            WbemcliUtil.WmiResult<Win32PhysicalMemory.PhysicalMemoryProperty> wmiResult = Win32PhysicalMemory.queryphysicalMemory();
            for (int i2 = 0; i2 < wmiResult.getResultCount(); ++i2) {
                String string = WmiUtil.getString(wmiResult, Win32PhysicalMemory.PhysicalMemoryProperty.BANKLABEL, i2);
                long l2 = WmiUtil.getUint64(wmiResult, Win32PhysicalMemory.PhysicalMemoryProperty.CAPACITY, i2);
                long l3 = (long)WmiUtil.getUint32(wmiResult, Win32PhysicalMemory.PhysicalMemoryProperty.SPEED, i2) * 1000000L;
                String string2 = WmiUtil.getString(wmiResult, Win32PhysicalMemory.PhysicalMemoryProperty.MANUFACTURER, i2);
                String string3 = WindowsGlobalMemory.smBiosMemoryType(WmiUtil.getUint32(wmiResult, Win32PhysicalMemory.PhysicalMemoryProperty.SMBIOSMEMORYTYPE, i2));
                arrayList.add(new PhysicalMemory(string, l2, l3, string2, string3));
            }
        } else {
            WbemcliUtil.WmiResult<Win32PhysicalMemory.PhysicalMemoryPropertyWin8> wmiResult = Win32PhysicalMemory.queryphysicalMemoryWin8();
            for (int i3 = 0; i3 < wmiResult.getResultCount(); ++i3) {
                String string = WmiUtil.getString(wmiResult, Win32PhysicalMemory.PhysicalMemoryPropertyWin8.BANKLABEL, i3);
                long l4 = WmiUtil.getUint64(wmiResult, Win32PhysicalMemory.PhysicalMemoryPropertyWin8.CAPACITY, i3);
                long l5 = (long)WmiUtil.getUint32(wmiResult, Win32PhysicalMemory.PhysicalMemoryPropertyWin8.SPEED, i3) * 1000000L;
                String string4 = WmiUtil.getString(wmiResult, Win32PhysicalMemory.PhysicalMemoryPropertyWin8.MANUFACTURER, i3);
                String string5 = WindowsGlobalMemory.memoryType(WmiUtil.getUint16(wmiResult, Win32PhysicalMemory.PhysicalMemoryPropertyWin8.MEMORYTYPE, i3));
                arrayList.add(new PhysicalMemory(string, l4, l5, string4, string5));
            }
        }
        return arrayList;
    }

    private static String memoryType(int n2) {
        switch (n2) {
            case 1: {
                return "Other";
            }
            case 2: {
                return "DRAM";
            }
            case 3: {
                return "Synchronous DRAM";
            }
            case 4: {
                return "Cache DRAM";
            }
            case 5: {
                return "EDO";
            }
            case 6: {
                return "EDRAM";
            }
            case 7: {
                return "VRAM";
            }
            case 8: {
                return "SRAM";
            }
            case 9: {
                return "RAM";
            }
            case 10: {
                return "ROM";
            }
            case 11: {
                return "Flash";
            }
            case 12: {
                return "EEPROM";
            }
            case 13: {
                return "FEPROM";
            }
            case 14: {
                return "EPROM";
            }
            case 15: {
                return "CDRAM";
            }
            case 16: {
                return "3DRAM";
            }
            case 17: {
                return "SDRAM";
            }
            case 18: {
                return "SGRAM";
            }
            case 19: {
                return "RDRAM";
            }
            case 20: {
                return "DDR";
            }
            case 21: {
                return "DDR2";
            }
            case 22: {
                return "DDR2-FB-DIMM";
            }
            case 24: {
                return "DDR3";
            }
            case 25: {
                return "FBD2";
            }
        }
        return "Unknown";
    }

    private static String smBiosMemoryType(int n2) {
        switch (n2) {
            case 1: {
                return "Other";
            }
            case 3: {
                return "DRAM";
            }
            case 4: {
                return "EDRAM";
            }
            case 5: {
                return "VRAM";
            }
            case 6: {
                return "SRAM";
            }
            case 7: {
                return "RAM";
            }
            case 8: {
                return "ROM";
            }
            case 9: {
                return "FLASH";
            }
            case 10: {
                return "EEPROM";
            }
            case 11: {
                return "FEPROM";
            }
            case 12: {
                return "EPROM";
            }
            case 13: {
                return "CDRAM";
            }
            case 14: {
                return "3DRAM";
            }
            case 15: {
                return "SDRAM";
            }
            case 16: {
                return "SGRAM";
            }
            case 17: {
                return "RDRAM";
            }
            case 18: {
                return "DDR";
            }
            case 19: {
                return "DDR2";
            }
            case 20: {
                return "DDR2 FB-DIMM";
            }
            case 24: {
                return "DDR3";
            }
            case 25: {
                return "FBD2";
            }
            case 26: {
                return "DDR4";
            }
            case 27: {
                return "LPDDR";
            }
            case 28: {
                return "LPDDR2";
            }
            case 29: {
                return "LPDDR3";
            }
            case 30: {
                return "LPDDR4";
            }
            case 31: {
                return "Logical non-volatile device";
            }
        }
        return "Unknown";
    }

    private static Triplet<Long, Long, Long> readPerfInfo() {
        Psapi.PERFORMANCE_INFORMATION pERFORMANCE_INFORMATION = new Psapi.PERFORMANCE_INFORMATION();
        if (!Psapi.INSTANCE.GetPerformanceInfo(pERFORMANCE_INFORMATION, pERFORMANCE_INFORMATION.size())) {
            LOG.error("Failed to get Performance Info. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
            return new Triplet<Long, Long, Long>(0L, 0L, 4098L);
        }
        long l2 = pERFORMANCE_INFORMATION.PageSize.longValue();
        long l3 = l2 * pERFORMANCE_INFORMATION.PhysicalAvailable.longValue();
        long l4 = l2 * pERFORMANCE_INFORMATION.PhysicalTotal.longValue();
        return new Triplet<Long, Long, Long>(l3, l4, l2);
    }
}

