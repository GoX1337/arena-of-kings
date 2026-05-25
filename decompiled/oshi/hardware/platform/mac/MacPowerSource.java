/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.PowerSource;
import oshi.hardware.common.AbstractPowerSource;
import oshi.util.platform.mac.CFUtil;

@ThreadSafe
public final class MacPowerSource
extends AbstractPowerSource {
    private static final CoreFoundation CF = CoreFoundation.INSTANCE;
    private static final IOKit IO = IOKit.INSTANCE;

    public MacPowerSource(String string, String string2, double d2, double d3, double d4, double d5, double d6, double d7, boolean bl2, boolean bl3, boolean bl4, PowerSource.CapacityUnits capacityUnits, int n2, int n3, int n4, int n5, String string3, LocalDate localDate, String string4, String string5, double d8) {
        super(string, string2, d2, d3, d4, d5, d6, d7, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string3, localDate, string4, string5, d8);
    }

    public static List<PowerSource> getPowerSources() {
        Object object;
        Object object2;
        Object object3 = "unknown";
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = -1.0;
        double d5 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        PowerSource.CapacityUnits capacityUnits = PowerSource.CapacityUnits.RELATIVE;
        int n2 = 0;
        int n3 = 1;
        int n4 = 1;
        int n5 = -1;
        String string = "unknown";
        LocalDate localDate = null;
        Object object4 = "unknown";
        Object object5 = "unknown";
        double d6 = 0.0;
        IOKit.IOService iOService = IOKitUtil.getMatchingService("AppleSmartBattery");
        if (iOService != null) {
            object2 = iOService.getStringProperty("DeviceName");
            if (object2 != null) {
                object3 = object2;
            }
            if ((object2 = iOService.getStringProperty("Manufacturer")) != null) {
                object4 = object2;
            }
            if ((object2 = iOService.getStringProperty("BatterySerialNumber")) != null) {
                object5 = object2;
            }
            if ((object = iOService.getIntegerProperty("ManufactureDate")) != null) {
                int n6 = (Integer)object & 0x1F;
                int n7 = (Integer)object >> 5 & 0xF;
                int n8 = (Integer)object >> 9 & 0x7F;
                localDate = LocalDate.of(1980 + n8, n7, n6);
            }
            if ((object = iOService.getIntegerProperty("DesignCapacity")) != null) {
                n4 = (Integer)object;
            }
            if ((object = iOService.getIntegerProperty("MaxCapacity")) != null) {
                n3 = (Integer)object;
            }
            if ((object = iOService.getIntegerProperty("CurrentCapacity")) != null) {
                n2 = (Integer)object;
            }
            capacityUnits = PowerSource.CapacityUnits.MAH;
            object = iOService.getIntegerProperty("TimeRemaining");
            if (object != null) {
                d2 = (double)((Integer)object).intValue() * 60.0;
            }
            if ((object = iOService.getIntegerProperty("CycleCount")) != null) {
                n5 = (Integer)object;
            }
            if ((object = iOService.getIntegerProperty("Temperature")) != null) {
                d6 = (double)((Integer)object).intValue() / 100.0;
            }
            if ((object = iOService.getIntegerProperty("Voltage")) != null) {
                d4 = (double)((Integer)object).intValue() / 1000.0;
            }
            if ((object = iOService.getIntegerProperty("Amperage")) != null) {
                d5 = ((Integer)object).intValue();
            }
            d3 = d4 * d5;
            Boolean bl5 = iOService.getBooleanProperty("ExternalConnected");
            if (bl5 != null) {
                bl2 = bl5;
            }
            if ((bl5 = iOService.getBooleanProperty("IsCharging")) != null) {
                bl3 = bl5;
            }
            bl4 = !bl3;
            iOService.release();
        }
        object2 = IO.IOPSCopyPowerSourcesInfo();
        object = IO.IOPSCopyPowerSourcesList((CoreFoundation.CFTypeRef)object2);
        int n9 = ((CoreFoundation.CFArrayRef)object).getCount();
        double d7 = IO.IOPSGetTimeRemainingEstimate();
        CoreFoundation.CFStringRef cFStringRef = CoreFoundation.CFStringRef.createCFString("Name");
        CoreFoundation.CFStringRef cFStringRef2 = CoreFoundation.CFStringRef.createCFString("Is Present");
        CoreFoundation.CFStringRef cFStringRef3 = CoreFoundation.CFStringRef.createCFString("Current Capacity");
        CoreFoundation.CFStringRef cFStringRef4 = CoreFoundation.CFStringRef.createCFString("Max Capacity");
        ArrayList<PowerSource> arrayList = new ArrayList<PowerSource>(n9);
        for (int i2 = 0; i2 < n9; ++i2) {
            CoreFoundation.CFBooleanRef cFBooleanRef;
            Pointer pointer = ((CoreFoundation.CFArrayRef)object).getValueAtIndex(i2);
            CoreFoundation.CFTypeRef cFTypeRef = new CoreFoundation.CFTypeRef();
            cFTypeRef.setPointer(pointer);
            CoreFoundation.CFDictionaryRef cFDictionaryRef = IO.IOPSGetPowerSourceDescription((CoreFoundation.CFTypeRef)object2, cFTypeRef);
            Pointer pointer2 = cFDictionaryRef.getValue(cFStringRef2);
            if (pointer2 == null || 0 == CF.CFBooleanGetValue(cFBooleanRef = new CoreFoundation.CFBooleanRef(pointer2))) continue;
            pointer2 = cFDictionaryRef.getValue(cFStringRef);
            String string2 = CFUtil.cfPointerToString(pointer2);
            double d8 = 0.0;
            if (cFDictionaryRef.getValueIfPresent(cFStringRef3, null)) {
                pointer2 = cFDictionaryRef.getValue(cFStringRef3);
                CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer2);
                d8 = cFNumberRef.intValue();
            }
            double d9 = 1.0;
            if (cFDictionaryRef.getValueIfPresent(cFStringRef4, null)) {
                pointer2 = cFDictionaryRef.getValue(cFStringRef4);
                CoreFoundation.CFNumberRef cFNumberRef = new CoreFoundation.CFNumberRef(pointer2);
                d9 = cFNumberRef.intValue();
            }
            double d10 = Math.min(1.0, d8 / d9);
            arrayList.add(new MacPowerSource(string2, (String)object3, d10, d7, d2, d3, d4, d5, bl2, bl3, bl4, capacityUnits, n2, n3, n4, n5, string, localDate, (String)object4, (String)object5, d6));
        }
        cFStringRef2.release();
        cFStringRef.release();
        cFStringRef3.release();
        cFStringRef4.release();
        ((CoreFoundation.CFTypeRef)object).release();
        ((CoreFoundation.CFTypeRef)object2).release();
        return arrayList;
    }
}

