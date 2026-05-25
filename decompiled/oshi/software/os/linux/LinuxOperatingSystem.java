/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import com.sun.jna.Native;
import com.sun.jna.platform.linux.LibC;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.Who;
import oshi.driver.linux.proc.CpuStat;
import oshi.driver.linux.proc.ProcessStat;
import oshi.driver.linux.proc.UpTime;
import oshi.jna.platform.linux.LinuxLibc;
import oshi.software.common.AbstractOperatingSystem;
import oshi.software.os.FileSystem;
import oshi.software.os.InternetProtocolStats;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSProcess;
import oshi.software.os.OSService;
import oshi.software.os.OSSession;
import oshi.software.os.OperatingSystem;
import oshi.software.os.linux.LinuxFileSystem;
import oshi.software.os.linux.LinuxInternetProtocolStats;
import oshi.software.os.linux.LinuxNetworkParams;
import oshi.software.os.linux.LinuxOSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public class LinuxOperatingSystem
extends AbstractOperatingSystem {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxOperatingSystem.class);
    private static final String OS_RELEASE_LOG = "os-release: {}";
    private static final String LSB_RELEASE_A_LOG = "lsb_release -a: {}";
    private static final String LSB_RELEASE_LOG = "lsb-release: {}";
    private static final String RELEASE_DELIM = " release ";
    private static final String DOUBLE_QUOTES = "(?:^\")|(?:\"$)";
    private static final String FILENAME_PROPERTIES = "oshi.linux.filename.properties";
    private static final long USER_HZ = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf CLK_TCK"), 100L);
    static final long BOOTTIME;
    private static final int[] PPID_INDEX;

    @Override
    public String queryManufacturer() {
        return "GNU/Linux";
    }

    @Override
    public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
        Object object;
        Triplet<String, String, String> triplet = LinuxOperatingSystem.queryFamilyVersionCodenameFromReleaseFiles();
        String string = null;
        List<String> list = FileUtil.readFile(ProcPath.VERSION);
        if (!list.isEmpty()) {
            for (String string2 : object = ParseUtil.whitespaces.split(list.get(0))) {
                if ("Linux".equals(string2) || "version".equals(string2)) continue;
                string = string2;
                break;
            }
        }
        object = new OperatingSystem.OSVersionInfo(triplet.getB(), triplet.getC(), string);
        return new Pair<String, String[]>(triplet.getA(), (String[])object);
    }

    @Override
    public int queryBitness(int n2) {
        if (n2 < 64 && !ExecutingCommand.getFirstAnswer("uname -m").contains("64")) {
            return n2;
        }
        return 64;
    }

    @Override
    public FileSystem getFileSystem() {
        return new LinuxFileSystem();
    }

    @Override
    public InternetProtocolStats getInternetProtocolStats() {
        return new LinuxInternetProtocolStats();
    }

    @Override
    public List<OSSession> getSessions() {
        return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
    }

    @Override
    public OSProcess getProcess(int n2) {
        LinuxOSProcess linuxOSProcess = new LinuxOSProcess(n2);
        if (!linuxOSProcess.getState().equals((Object)OSProcess.State.INVALID)) {
            return linuxOSProcess;
        }
        return null;
    }

    @Override
    public List<OSProcess> queryAllProcesses() {
        return this.queryChildProcesses(-1);
    }

    @Override
    public List<OSProcess> queryChildProcesses(int n2) {
        File[] fileArray = ProcessStat.getPidFiles();
        if (n2 >= 0) {
            return LinuxOperatingSystem.queryProcessList(LinuxOperatingSystem.getChildrenOrDescendants(LinuxOperatingSystem.getParentPidsFromProcFiles(fileArray), n2, false));
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (File file : fileArray) {
            int n3 = ParseUtil.parseIntOrDefault(file.getName(), -2);
            if (n3 == -2) continue;
            hashSet.add(n3);
        }
        return LinuxOperatingSystem.queryProcessList(hashSet);
    }

    @Override
    public List<OSProcess> queryDescendantProcesses(int n2) {
        File[] fileArray = ProcessStat.getPidFiles();
        return LinuxOperatingSystem.queryProcessList(LinuxOperatingSystem.getChildrenOrDescendants(LinuxOperatingSystem.getParentPidsFromProcFiles(fileArray), n2, true));
    }

    private static List<OSProcess> queryProcessList(Set<Integer> set) {
        ArrayList<OSProcess> arrayList = new ArrayList<OSProcess>();
        for (int n2 : set) {
            LinuxOSProcess linuxOSProcess = new LinuxOSProcess(n2);
            if (linuxOSProcess.getState().equals((Object)OSProcess.State.INVALID)) continue;
            arrayList.add(linuxOSProcess);
        }
        return arrayList;
    }

    private static Map<Integer, Integer> getParentPidsFromProcFiles(File[] fileArray) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (File file : fileArray) {
            int n2 = ParseUtil.parseIntOrDefault(file.getName(), 0);
            hashMap.put(n2, LinuxOperatingSystem.getParentPidFromProcFile(n2));
        }
        return hashMap;
    }

    private static int getParentPidFromProcFile(int n2) {
        String string = FileUtil.getStringFromFile(String.format("/proc/%d/stat", n2));
        if (string.isEmpty()) {
            return 0;
        }
        long[] lArray = ParseUtil.parseStringToLongArray(string, PPID_INDEX, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
        return (int)lArray[0];
    }

    @Override
    public int getProcessId() {
        return LinuxLibc.INSTANCE.getpid();
    }

    @Override
    public int getProcessCount() {
        return ProcessStat.getPidFiles().length;
    }

    @Override
    public int getThreadCount() {
        try {
            LibC.Sysinfo sysinfo = new LibC.Sysinfo();
            if (0 != LibC.INSTANCE.sysinfo(sysinfo)) {
                LOG.error("Failed to get process thread count. Error code: {}", (Object)Native.getLastError());
                return 0;
            }
            return sysinfo.procs;
        }
        catch (NoClassDefFoundError | UnsatisfiedLinkError linkageError) {
            LOG.error("Failed to get procs from sysinfo. {}", (Object)linkageError.getMessage());
            return 0;
        }
    }

    @Override
    public long getSystemUptime() {
        return (long)UpTime.getSystemUptimeSeconds();
    }

    @Override
    public long getSystemBootTime() {
        return BOOTTIME;
    }

    @Override
    public NetworkParams getNetworkParams() {
        return new LinuxNetworkParams();
    }

    private static Triplet<String, String, String> queryFamilyVersionCodenameFromReleaseFiles() {
        Triplet<String, String, String> triplet = LinuxOperatingSystem.readDistribRelease("/etc/system-release");
        if (triplet != null) {
            return triplet;
        }
        triplet = LinuxOperatingSystem.readOsRelease();
        if (triplet != null) {
            return triplet;
        }
        triplet = LinuxOperatingSystem.execLsbRelease();
        if (triplet != null) {
            return triplet;
        }
        triplet = LinuxOperatingSystem.readLsbRelease();
        if (triplet != null) {
            return triplet;
        }
        String string = LinuxOperatingSystem.getReleaseFilename();
        triplet = LinuxOperatingSystem.readDistribRelease(string);
        if (triplet != null) {
            return triplet;
        }
        String string2 = LinuxOperatingSystem.filenameToFamily(string.replace("/etc/", "").replace("release", "").replace("version", "").replace("-", "").replace("_", ""));
        return new Triplet<String, String, String>(string2, "unknown", "unknown");
    }

    private static Triplet<String, String, String> readOsRelease() {
        String string = null;
        String string2 = "unknown";
        String string3 = "unknown";
        List<String> list = FileUtil.readFile("/etc/os-release");
        for (String string4 : list) {
            if (string4.startsWith("VERSION=")) {
                LOG.debug(OS_RELEASE_LOG, (Object)string4);
                string4 = string4.replace("VERSION=", "").replaceAll(DOUBLE_QUOTES, "").trim();
                String[] stringArray = string4.split("[()]");
                if (stringArray.length <= 1) {
                    stringArray = string4.split(", ");
                }
                if (stringArray.length > 0) {
                    string2 = stringArray[0].trim();
                }
                if (stringArray.length <= 1) continue;
                string3 = stringArray[1].trim();
                continue;
            }
            if (string4.startsWith("NAME=") && string == null) {
                LOG.debug(OS_RELEASE_LOG, (Object)string4);
                string = string4.replace("NAME=", "").replaceAll(DOUBLE_QUOTES, "").trim();
                continue;
            }
            if (!string4.startsWith("VERSION_ID=") || !string2.equals("unknown")) continue;
            LOG.debug(OS_RELEASE_LOG, (Object)string4);
            string2 = string4.replace("VERSION_ID=", "").replaceAll(DOUBLE_QUOTES, "").trim();
        }
        return string == null ? null : new Triplet<Object, String, String>(string, string2, string3);
    }

    private static Triplet<String, String, String> execLsbRelease() {
        String string = null;
        String string2 = "unknown";
        String string3 = "unknown";
        for (String string4 : ExecutingCommand.runNative("lsb_release -a")) {
            if (string4.startsWith("Description:")) {
                LOG.debug(LSB_RELEASE_A_LOG, (Object)string4);
                if (!(string4 = string4.replace("Description:", "").trim()).contains(RELEASE_DELIM)) continue;
                Triplet<String, String, String> triplet = LinuxOperatingSystem.parseRelease(string4, RELEASE_DELIM);
                string = triplet.getA();
                if (string2.equals("unknown")) {
                    string2 = triplet.getB();
                }
                if (!string3.equals("unknown")) continue;
                string3 = triplet.getC();
                continue;
            }
            if (string4.startsWith("Distributor ID:") && string == null) {
                LOG.debug(LSB_RELEASE_A_LOG, (Object)string4);
                string = string4.replace("Distributor ID:", "").trim();
                continue;
            }
            if (string4.startsWith("Release:") && string2.equals("unknown")) {
                LOG.debug(LSB_RELEASE_A_LOG, (Object)string4);
                string2 = string4.replace("Release:", "").trim();
                continue;
            }
            if (!string4.startsWith("Codename:") || !string3.equals("unknown")) continue;
            LOG.debug(LSB_RELEASE_A_LOG, (Object)string4);
            string3 = string4.replace("Codename:", "").trim();
        }
        return string == null ? null : new Triplet<Object, String, String>(string, string2, string3);
    }

    private static Triplet<String, String, String> readLsbRelease() {
        String string = null;
        String string2 = "unknown";
        String string3 = "unknown";
        List<String> list = FileUtil.readFile("/etc/lsb-release");
        for (String string4 : list) {
            if (string4.startsWith("DISTRIB_DESCRIPTION=")) {
                LOG.debug(LSB_RELEASE_LOG, (Object)string4);
                if (!(string4 = string4.replace("DISTRIB_DESCRIPTION=", "").replaceAll(DOUBLE_QUOTES, "").trim()).contains(RELEASE_DELIM)) continue;
                Triplet<String, String, String> triplet = LinuxOperatingSystem.parseRelease(string4, RELEASE_DELIM);
                string = triplet.getA();
                if (string2.equals("unknown")) {
                    string2 = triplet.getB();
                }
                if (!string3.equals("unknown")) continue;
                string3 = triplet.getC();
                continue;
            }
            if (string4.startsWith("DISTRIB_ID=") && string == null) {
                LOG.debug(LSB_RELEASE_LOG, (Object)string4);
                string = string4.replace("DISTRIB_ID=", "").replaceAll(DOUBLE_QUOTES, "").trim();
                continue;
            }
            if (string4.startsWith("DISTRIB_RELEASE=") && string2.equals("unknown")) {
                LOG.debug(LSB_RELEASE_LOG, (Object)string4);
                string2 = string4.replace("DISTRIB_RELEASE=", "").replaceAll(DOUBLE_QUOTES, "").trim();
                continue;
            }
            if (!string4.startsWith("DISTRIB_CODENAME=") || !string3.equals("unknown")) continue;
            LOG.debug(LSB_RELEASE_LOG, (Object)string4);
            string3 = string4.replace("DISTRIB_CODENAME=", "").replaceAll(DOUBLE_QUOTES, "").trim();
        }
        return string == null ? null : new Triplet<Object, String, String>(string, string2, string3);
    }

    private static Triplet<String, String, String> readDistribRelease(String string) {
        if (new File(string).exists()) {
            List<String> list = FileUtil.readFile(string);
            for (String string2 : list) {
                LOG.debug("{}: {}", (Object)string, (Object)string2);
                if (string2.contains(RELEASE_DELIM)) {
                    return LinuxOperatingSystem.parseRelease(string2, RELEASE_DELIM);
                }
                if (!string2.contains(" VERSION ")) continue;
                return LinuxOperatingSystem.parseRelease(string2, " VERSION ");
            }
        }
        return null;
    }

    private static Triplet<String, String, String> parseRelease(String string, String string2) {
        String[] stringArray = string.split(string2);
        String string3 = stringArray[0].trim();
        String string4 = "unknown";
        String string5 = "unknown";
        if (stringArray.length > 1) {
            if ((stringArray = stringArray[1].split("[()]")).length > 0) {
                string4 = stringArray[0].trim();
            }
            if (stringArray.length > 1) {
                string5 = stringArray[1].trim();
            }
        }
        return new Triplet<String, String, String>(string3, string4, string5);
    }

    protected static String getReleaseFilename() {
        File file2 = new File("/etc");
        File[] fileArray = file2.listFiles(file -> (file.getName().endsWith("-release") || file.getName().endsWith("-version") || file.getName().endsWith("_release") || file.getName().endsWith("_version")) && !file.getName().endsWith("os-release") && !file.getName().endsWith("lsb-release") && !file.getName().endsWith("system-release"));
        if (fileArray != null && fileArray.length > 0) {
            return fileArray[0].getPath();
        }
        if (new File("/etc/release").exists()) {
            return "/etc/release";
        }
        return "/etc/issue";
    }

    private static String filenameToFamily(String string) {
        if (string.isEmpty()) {
            return "Solaris";
        }
        if ("issue".equalsIgnoreCase(string)) {
            return "Unknown";
        }
        Properties properties = FileUtil.readPropertiesFromFilename(FILENAME_PROPERTIES);
        String string2 = properties.getProperty(string.toLowerCase());
        return string2 != null ? string2 : string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    @Override
    public List<OSService> getServices() {
        String string2;
        Object object;
        ArrayList<OSService> arrayList = new ArrayList<OSService>();
        HashSet<String> hashSet = new HashSet<String>();
        for (OSProcess object22 : this.getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
            object = new OSService(object22.getName(), object22.getProcessID(), OSService.State.RUNNING);
            arrayList.add((OSService)object);
            hashSet.add(object22.getName());
        }
        boolean bl2 = false;
        List<String> list = ExecutingCommand.runNative("systemctl list-unit-files");
        for (File[] fileArray : list) {
            String[] stringArray = ParseUtil.whitespaces.split((CharSequence)fileArray);
            if (stringArray.length < 2 || !stringArray[0].endsWith(".service") || !"enabled".equals(stringArray[1])) continue;
            String string3 = stringArray[0].substring(0, stringArray[0].length() - 8);
            int file2 = string3.lastIndexOf(46);
            String string4 = string2 = file2 < 0 || file2 > string3.length() - 2 ? string3 : string3.substring(file2 + 1);
            if (hashSet.contains(string3) || hashSet.contains(string2)) continue;
            OSService n3 = new OSService(string3, 0, OSService.State.STOPPED);
            arrayList.add(n3);
            bl2 = true;
        }
        if (!bl2) {
            object = new File("/etc/init");
            if (((File)object).exists() && ((File)object).isDirectory()) {
                for (File file2 : ((File)object).listFiles((file, string) -> string.toLowerCase().endsWith(".conf"))) {
                    String string5;
                    string2 = file2.getName().substring(0, file2.getName().length() - 5);
                    int n2 = string2.lastIndexOf(46);
                    String string6 = string5 = n2 < 0 || n2 > string2.length() - 2 ? string2 : string2.substring(n2 + 1);
                    if (hashSet.contains(string2) || hashSet.contains(string5)) continue;
                    OSService oSService = new OSService(string2, 0, OSService.State.STOPPED);
                    arrayList.add(oSService);
                }
            } else {
                LOG.error("Directory: /etc/init does not exist");
            }
        }
        return arrayList;
    }

    public static long getHz() {
        return USER_HZ;
    }

    static {
        long l2 = CpuStat.getBootTime();
        if (l2 == 0L) {
            l2 = System.currentTimeMillis() / 1000L - (long)UpTime.getSystemUptimeSeconds();
        }
        BOOTTIME = l2;
        PPID_INDEX = new int[]{3};
    }
}

