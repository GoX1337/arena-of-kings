/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class Win32Process {
    private static final String WIN32_PROCESS = "Win32_Process";

    private Win32Process() {
    }

    public static WbemcliUtil.WmiResult<CommandLineProperty> queryCommandLines(Set<Integer> set) {
        String string = WIN32_PROCESS;
        if (set != null) {
            string = string + " WHERE ProcessID=" + set.stream().map(String::valueOf).collect(Collectors.joining(" OR PROCESSID="));
        }
        WbemcliUtil.WmiQuery<CommandLineProperty> wmiQuery = new WbemcliUtil.WmiQuery<CommandLineProperty>(string, CommandLineProperty.class);
        return Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(wmiQuery);
    }

    public static WbemcliUtil.WmiResult<ProcessXPProperty> queryProcesses(Collection<Integer> collection) {
        String string = WIN32_PROCESS;
        if (collection != null) {
            string = string + " WHERE ProcessID=" + collection.stream().map(String::valueOf).collect(Collectors.joining(" OR PROCESSID="));
        }
        WbemcliUtil.WmiQuery<ProcessXPProperty> wmiQuery = new WbemcliUtil.WmiQuery<ProcessXPProperty>(string, ProcessXPProperty.class);
        return Objects.requireNonNull(WmiQueryHandler.createInstance()).queryWMI(wmiQuery);
    }

    public static enum CommandLineProperty {
        PROCESSID,
        COMMANDLINE;

    }

    public static enum ProcessXPProperty {
        PROCESSID,
        NAME,
        KERNELMODETIME,
        USERMODETIME,
        THREADCOUNT,
        PAGEFILEUSAGE,
        HANDLECOUNT,
        EXECUTABLEPATH;

    }
}

