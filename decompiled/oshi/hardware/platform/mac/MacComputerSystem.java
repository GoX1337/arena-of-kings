/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Native;
import com.sun.jna.platform.mac.IOKit;
import com.sun.jna.platform.mac.IOKitUtil;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.Baseboard;
import oshi.hardware.Firmware;
import oshi.hardware.common.AbstractComputerSystem;
import oshi.hardware.platform.mac.MacBaseboard;
import oshi.hardware.platform.mac.MacFirmware;
import oshi.util.Memoizer;
import oshi.util.Util;
import oshi.util.tuples.Quartet;

@Immutable
final class MacComputerSystem
extends AbstractComputerSystem {
    private final Supplier<Quartet<String, String, String, String>> manufacturerModelSerialUUID = Memoizer.memoize(MacComputerSystem::platformExpert);

    MacComputerSystem() {
    }

    @Override
    public String getManufacturer() {
        return this.manufacturerModelSerialUUID.get().getA();
    }

    @Override
    public String getModel() {
        return this.manufacturerModelSerialUUID.get().getB();
    }

    @Override
    public String getSerialNumber() {
        return this.manufacturerModelSerialUUID.get().getC();
    }

    @Override
    public String getHardwareUUID() {
        return this.manufacturerModelSerialUUID.get().getD();
    }

    @Override
    public Firmware createFirmware() {
        return new MacFirmware();
    }

    @Override
    public Baseboard createBaseboard() {
        return new MacBaseboard();
    }

    private static Quartet<String, String, String, String> platformExpert() {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
        if (iOService != null) {
            byte[] byArray = iOService.getByteArrayProperty("manufacturer");
            if (byArray != null) {
                string = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if ((byArray = iOService.getByteArrayProperty("model")) != null) {
                string2 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            string3 = iOService.getStringProperty("IOPlatformSerialNumber");
            string4 = iOService.getStringProperty("IOPlatformUUID");
            iOService.release();
        }
        return new Quartet<String, String, String, String>(Util.isBlank(string) ? "Apple Inc." : string, Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string3) ? "unknown" : string3, Util.isBlank(string4) ? "unknown" : string4);
    }
}

