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
import oshi.hardware.common.AbstractBaseboard;
import oshi.util.Memoizer;
import oshi.util.Util;
import oshi.util.tuples.Quartet;

@Immutable
final class MacBaseboard
extends AbstractBaseboard {
    private final Supplier<Quartet<String, String, String, String>> manufModelVersSerial = Memoizer.memoize(MacBaseboard::queryPlatform);

    MacBaseboard() {
    }

    @Override
    public String getManufacturer() {
        return this.manufModelVersSerial.get().getA();
    }

    @Override
    public String getModel() {
        return this.manufModelVersSerial.get().getB();
    }

    @Override
    public String getVersion() {
        return this.manufModelVersSerial.get().getC();
    }

    @Override
    public String getSerialNumber() {
        return this.manufModelVersSerial.get().getD();
    }

    private static Quartet<String, String, String, String> queryPlatform() {
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
            if ((byArray = iOService.getByteArrayProperty("board-id")) != null) {
                string2 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if (Util.isBlank(string2) && (byArray = iOService.getByteArrayProperty("model-number")) != null) {
                string2 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if ((byArray = iOService.getByteArrayProperty("version")) != null) {
                string3 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if ((byArray = iOService.getByteArrayProperty("mlb-serial-number")) != null) {
                string4 = Native.toString(byArray, StandardCharsets.UTF_8);
            }
            if (Util.isBlank(string4)) {
                string4 = iOService.getStringProperty("IOPlatformSerialNumber");
            }
            iOService.release();
        }
        return new Quartet<String, String, String, String>(Util.isBlank(string) ? "Apple Inc." : string, Util.isBlank(string2) ? "unknown" : string2, Util.isBlank(string3) ? "unknown" : string3, Util.isBlank(string4) ? "unknown" : string4);
    }
}

