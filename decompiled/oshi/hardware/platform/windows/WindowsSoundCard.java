/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinReg;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;

@Immutable
final class WindowsSoundCard
extends AbstractSoundCard {
    private static final String REGISTRY_SOUNDCARDS = "SYSTEM\\CurrentControlSet\\Control\\Class\\{4d36e96c-e325-11ce-bfc1-08002be10318}\\";

    WindowsSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    public static List<SoundCard> getSoundCards() {
        String[] stringArray;
        ArrayList<SoundCard> arrayList = new ArrayList<SoundCard>();
        for (String string : stringArray = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE, REGISTRY_SOUNDCARDS)) {
            String string2 = REGISTRY_SOUNDCARDS + string;
            try {
                if (!Advapi32Util.registryValueExists(WinReg.HKEY_LOCAL_MACHINE, string2, "Driver")) continue;
                arrayList.add(new WindowsSoundCard(Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, string2, "Driver") + " " + Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, string2, "DriverVersion"), Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, string2, "ProviderName") + " " + Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, string2, "DriverDesc"), Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, string2, "DriverDesc")));
            }
            catch (Win32Exception win32Exception) {
                if (win32Exception.getErrorCode() == 5) continue;
                throw win32Exception;
            }
        }
        return arrayList;
    }
}

