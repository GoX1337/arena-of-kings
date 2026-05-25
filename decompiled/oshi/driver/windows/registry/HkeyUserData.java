/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.registry;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinReg;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSSession;

@ThreadSafe
public final class HkeyUserData {
    private static final String PATH_DELIMITER = "\\";
    private static final String DEFAULT_DEVICE = "Console";
    private static final String VOLATILE_ENV_SUBKEY = "Volatile Environment";
    private static final String CLIENTNAME = "CLIENTNAME";
    private static final String SESSIONNAME = "SESSIONNAME";
    private static final Logger LOG = LoggerFactory.getLogger(HkeyUserData.class);

    private HkeyUserData() {
    }

    public static List<OSSession> queryUserSessions() {
        ArrayList<OSSession> arrayList = new ArrayList<OSSession>();
        for (String string : Advapi32Util.registryGetKeys(WinReg.HKEY_USERS)) {
            if (string.startsWith(".") || string.endsWith("_Classes")) continue;
            try {
                Advapi32Util.Account account = Advapi32Util.getAccountBySid(string);
                String string2 = account.name;
                String string3 = DEFAULT_DEVICE;
                String string4 = account.domain;
                long l2 = 0L;
                String string5 = string + PATH_DELIMITER + VOLATILE_ENV_SUBKEY;
                if (Advapi32Util.registryKeyExists(WinReg.HKEY_USERS, string5)) {
                    WinReg.HKEY hKEY = Advapi32Util.registryGetKey(WinReg.HKEY_USERS, string5, 131097).getValue();
                    Advapi32Util.InfoKey infoKey = Advapi32Util.registryQueryInfoKey(hKEY, 0);
                    l2 = infoKey.lpftLastWriteTime.toTime();
                    for (String string6 : Advapi32Util.registryGetKeys(hKEY)) {
                        String string7;
                        String string8 = string5 + PATH_DELIMITER + string6;
                        if (Advapi32Util.registryValueExists(WinReg.HKEY_USERS, string8, SESSIONNAME) && !(string7 = Advapi32Util.registryGetStringValue(WinReg.HKEY_USERS, string8, SESSIONNAME)).isEmpty()) {
                            string3 = string7;
                        }
                        if (!Advapi32Util.registryValueExists(WinReg.HKEY_USERS, string8, CLIENTNAME) || (string7 = Advapi32Util.registryGetStringValue(WinReg.HKEY_USERS, string8, CLIENTNAME)).isEmpty() || DEFAULT_DEVICE.equals(string7)) continue;
                        string4 = string7;
                    }
                    Advapi32Util.registryCloseKey(hKEY);
                }
                arrayList.add(new OSSession(string2, string3, l2, string4));
            }
            catch (Win32Exception win32Exception) {
                LOG.warn("Error querying SID {} from registry: {}", (Object)string, (Object)win32Exception.getMessage());
            }
        }
        return arrayList;
    }
}

