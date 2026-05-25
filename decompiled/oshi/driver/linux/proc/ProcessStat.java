/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.linux.proc;

import java.io.File;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSProcess;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class ProcessStat {
    private static final Pattern DIGITS = Pattern.compile("\\d+");
    private static final Pattern SOCKET = Pattern.compile("socket:\\[(\\d+)\\]");
    public static final int PROC_PID_STAT_LENGTH;

    private ProcessStat() {
    }

    public static Triplet<String, Character, Map<PidStat, Long>> getPidStats(int n2) {
        String string = FileUtil.getStringFromFile(String.format(ProcPath.PID_STAT, n2));
        if (string.isEmpty()) {
            return null;
        }
        int n3 = string.indexOf(40) + 1;
        int n4 = string.indexOf(41);
        String string2 = string.substring(n3, n4);
        Character c2 = Character.valueOf(string.charAt(n4 + 2));
        String[] stringArray = ParseUtil.whitespaces.split(string.substring(n4 + 4).trim());
        EnumMap<PidStat, Long> enumMap = new EnumMap<PidStat, Long>(PidStat.class);
        PidStat[] pidStatArray = (PidStat[])PidStat.class.getEnumConstants();
        for (int i2 = 3; i2 < pidStatArray.length && i2 - 3 < stringArray.length; ++i2) {
            enumMap.put(pidStatArray[i2], ParseUtil.parseLongOrDefault(stringArray[i2 - 3], 0L));
        }
        return new Triplet<String, Character, Map<PidStat, Long>>(string2, c2, enumMap);
    }

    public static Map<PidStatM, Long> getPidStatM(int n2) {
        String string = FileUtil.getStringFromFile(String.format(ProcPath.PID_STATM, n2));
        if (string.isEmpty()) {
            return null;
        }
        String[] stringArray = ParseUtil.whitespaces.split(string);
        EnumMap<PidStatM, Long> enumMap = new EnumMap<PidStatM, Long>(PidStatM.class);
        PidStatM[] pidStatMArray = (PidStatM[])PidStatM.class.getEnumConstants();
        for (int i2 = 0; i2 < pidStatMArray.length && i2 < stringArray.length; ++i2) {
            enumMap.put(pidStatMArray[i2], ParseUtil.parseLongOrDefault(stringArray[i2], 0L));
        }
        return enumMap;
    }

    public static File[] getFileDescriptorFiles(int n2) {
        return ProcessStat.listNumericFiles(String.format(ProcPath.PID_FD, n2));
    }

    public static File[] getPidFiles() {
        return ProcessStat.listNumericFiles(ProcPath.PROC);
    }

    public static Map<Integer, Integer> querySocketToPidMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (File file : ProcessStat.getPidFiles()) {
            File[] fileArray;
            int n2 = ParseUtil.parseIntOrDefault(file.getName(), -1);
            for (File file2 : fileArray = ProcessStat.getFileDescriptorFiles(n2)) {
                Matcher matcher;
                String string = FileUtil.readSymlinkTarget(file2);
                if (string == null || !(matcher = SOCKET.matcher(string)).matches()) continue;
                hashMap.put(ParseUtil.parseIntOrDefault(matcher.group(1), -1), n2);
            }
        }
        return hashMap;
    }

    public static List<Integer> getThreadIds(int n2) {
        File[] fileArray = ProcessStat.listNumericFiles(String.format(ProcPath.TASK_PATH, n2));
        return Arrays.stream(fileArray).map(file -> ParseUtil.parseIntOrDefault(file.getName(), 0)).filter(n3 -> n3 != n2).collect(Collectors.toList());
    }

    private static File[] listNumericFiles(String string) {
        File file2 = new File(string);
        File[] fileArray = file2.listFiles(file -> DIGITS.matcher(file.getName()).matches());
        return fileArray == null ? new File[]{} : fileArray;
    }

    public static OSProcess.State getState(char c2) {
        OSProcess.State state;
        switch (c2) {
            case 'R': {
                state = OSProcess.State.RUNNING;
                break;
            }
            case 'S': {
                state = OSProcess.State.SLEEPING;
                break;
            }
            case 'D': {
                state = OSProcess.State.WAITING;
                break;
            }
            case 'Z': {
                state = OSProcess.State.ZOMBIE;
                break;
            }
            case 'T': {
                state = OSProcess.State.STOPPED;
                break;
            }
            default: {
                state = OSProcess.State.OTHER;
            }
        }
        return state;
    }

    static {
        String string = FileUtil.getStringFromFile(ProcPath.SELF_STAT);
        PROC_PID_STAT_LENGTH = string.contains(")") ? ParseUtil.countStringToLongArray(string, ' ') + 3 : 52;
    }

    public static enum PidStat {
        PID,
        COMM,
        STATE,
        PPID,
        PGRP,
        SESSION,
        TTY_NR,
        PTGID,
        FLAGS,
        MINFLT,
        CMINFLT,
        MAJFLT,
        CMAJFLT,
        UTIME,
        STIME,
        CUTIME,
        CSTIME,
        PRIORITY,
        NICE,
        NUM_THREADS,
        ITREALVALUE,
        STARTTIME,
        VSIZE,
        RSS,
        RSSLIM,
        STARTCODE,
        ENDCODE,
        STARTSTACK,
        KSTKESP,
        KSTKEIP,
        SIGNAL,
        BLOCKED,
        SIGIGNORE,
        SIGCATCH,
        WCHAN,
        NSWAP,
        CNSWAP,
        EXIT_SIGNAL,
        PROCESSOR,
        RT_PRIORITY,
        POLICY,
        DELAYACCT_BLKIO_TICKS,
        GUEST_TIME,
        CGUEST_TIME,
        START_DATA,
        END_DATA,
        START_BRK,
        ARG_START,
        ARG_END,
        ENV_START,
        ENV_END,
        EXIT_CODE;

    }

    public static enum PidStatM {
        SIZE,
        RESIDENT,
        SHARED,
        TEXT,
        LIB,
        DATA,
        DT;

    }
}

