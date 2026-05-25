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
import oshi.hardware.common.AbstractFirmware;
import oshi.util.Memoizer;
import oshi.util.Util;
import oshi.util.tuples.Quintet;

@Immutable
final class MacFirmware
extends AbstractFirmware {
    private final Supplier<Quintet<String, String, String, String, String>> manufNameDescVersRelease = Memoizer.memoize(MacFirmware::queryEfi);

    MacFirmware() {
    }

    @Override
    public String getManufacturer() {
        return this.manufNameDescVersRelease.get().getA();
    }

    @Override
    public String getName() {
        return this.manufNameDescVersRelease.get().getB();
    }

    @Override
    public String getDescription() {
        return this.manufNameDescVersRelease.get().getC();
    }

    @Override
    public String getVersion() {
        return this.manufNameDescVersRelease.get().getD();
    }

    @Override
    public String getReleaseDate() {
        return this.manufNameDescVersRelease.get().getE();
    }

    private static Quintet<String, String, String, String, String> queryEfi() {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
        if (iOService != null) {
            byte[] byArray;
            IOKit.IOIterator iOIterator = iOService.getChildIterator("IODeviceTree");
            if (iOIterator != null) {
                IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
                while (iORegistryEntry != null) {
                    switch (iORegistryEntry.getName()) {
                        case "rom": {
                            byArray = iORegistryEntry.getByteArrayProperty("vendor");
                            if (byArray != null) {
                                string = Native.toString(byArray, StandardCharsets.UTF_8);
                            }
                            if ((byArray = iORegistryEntry.getByteArrayProperty("version")) != null) {
                                string4 = Native.toString(byArray, StandardCharsets.UTF_8);
                            }
                            if ((byArray = iORegistryEntry.getByteArrayProperty("release-date")) == null) break;
                            string5 = Native.toString(byArray, StandardCharsets.UTF_8);
                            break;
                        }
                        case "chosen": {
                            byArray = iORegistryEntry.getByteArrayProperty("booter-name");
                            if (byArray == null) break;
                            string2 = Native.toString(byArray, StandardCharsets.UTF_8);
                            break;
                        }
                        case "efi": {
                            byArray = iORegistryEntry.getByteArrayProperty("firmware-abi");
                            if (byArray == null) break;
                            string3 = Native.toString(byArray, StandardCharsets.UTF_8);
                            break;
                        }
                        default: {
                            if (!Util.isBlank(string2)) break;
                            string2 = iORegistryEntry.getStringProperty("IONameMatch");
                        }
                    }
                    iORegistryEntry.release();
                    iORegistryEntry = iOIterator.next();
                }
                iOIterator.release();
            }
            if (Util.isBlank(string) && (byArray = iOService.getByteArrayProperty("manufacturer")) != null) {
                string = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if (Util.isBlank(string4) && (byArray = iOService.getByteArrayProperty("target-type")) != null) {
                string4 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if (Util.isBlank(string2) && (byArray = iOService.getByteArrayProperty("device_type")) != null) {
                string2 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            iOService.release();
        }
        return new Quintet<String, String, String, String, String>(Util.isBlank(string) ? "unknown" : string, Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string3) ? "unknown" : string3, Util.isBlank(string4) ? "unknown" : string4, Util.isBlank(string5) ? "unknown" : string5);
    }
}

