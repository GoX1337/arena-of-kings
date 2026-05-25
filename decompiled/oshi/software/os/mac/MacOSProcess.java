/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.software.os.mac;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.platform.unix.LibCAPI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.mac.ThreadInfo;
import oshi.software.common.AbstractOSProcess;
import oshi.software.os.OSProcess;
import oshi.software.os.OSThread;
import oshi.software.os.mac.MacOSThread;
import oshi.util.Memoizer;
import oshi.util.platform.mac.SysctlUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class MacOSProcess
extends AbstractOSProcess {
    private static final Logger LOG = LoggerFactory.getLogger(MacOSProcess.class);
    private static final int ARGMAX = SysctlUtil.sysctl("kern.argmax", 0);
    private static final int P_LP64 = 4;
    private static final int SSLEEP = 1;
    private static final int SWAIT = 2;
    private static final int SRUN = 3;
    private static final int SIDL = 4;
    private static final int SZOMB = 5;
    private static final int SSTOP = 6;
    private int minorVersion;
    private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
    private Supplier<Pair<List<String>, Map<String, String>>> argsEnviron = Memoizer.memoize(this::queryArgsAndEnvironment);
    private String name = "";
    private String path = "";
    private String currentWorkingDirectory;
    private String user;
    private String userID;
    private String group;
    private String groupID;
    private OSProcess.State state = OSProcess.State.INVALID;
    private int parentProcessID;
    private int threadCount;
    private int priority;
    private long virtualSize;
    private long residentSetSize;
    private long kernelTime;
    private long userTime;
    private long startTime;
    private long upTime;
    private long bytesRead;
    private long bytesWritten;
    private long openFiles;
    private int bitness;
    private long minorFaults;
    private long majorFaults;
    private long contextSwitches;

    public MacOSProcess(int n2, int n3) {
        super(n2);
        this.minorVersion = n3;
        this.updateAttributes();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getCommandLine() {
        return this.commandLine.get();
    }

    private String queryCommandLine() {
        return String.join((CharSequence)" ", this.getArguments());
    }

    @Override
    public List<String> getArguments() {
        return this.argsEnviron.get().getA();
    }

    @Override
    public Map<String, String> getEnvironmentVariables() {
        return this.argsEnviron.get().getB();
    }

    private Pair<List<String>, Map<String, String>> queryArgsAndEnvironment() {
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        int[] nArray = new int[]{1, 49, this.getProcessID()};
        Memory memory = new Memory(ARGMAX);
        memory.clear();
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference((long)ARGMAX);
        if (0 == SystemB.INSTANCE.sysctl(nArray, nArray.length, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            int n2 = memory.getInt(0L);
            if (n2 > 0 && n2 <= 1024) {
                long l2 = SystemB.INT_SIZE;
                l2 += (long)memory.getString(l2).length();
                while (l2 < byReference.longValue()) {
                    while (memory.getByte(l2) == 0 && ++l2 < byReference.longValue()) {
                    }
                    String string = memory.getString(l2);
                    if (n2-- > 0) {
                        arrayList.add(string);
                    } else {
                        int n3 = string.indexOf(61);
                        if (n3 > 0) {
                            linkedHashMap.put(string.substring(0, n3), string.substring(n3 + 1));
                        }
                    }
                    l2 += (long)string.length();
                }
            }
        } else {
            LOG.warn("Failed sysctl call for process arguments (kern.procargs2), process {} may not exist. Error code: {}", (Object)this.getProcessID(), (Object)Native.getLastError());
        }
        return new Pair<List<String>, Map<String, String>>(Collections.unmodifiableList(arrayList), Collections.unmodifiableMap(linkedHashMap));
    }

    @Override
    public String getCurrentWorkingDirectory() {
        return this.currentWorkingDirectory;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getUserID() {
        return this.userID;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public String getGroupID() {
        return this.groupID;
    }

    @Override
    public OSProcess.State getState() {
        return this.state;
    }

    @Override
    public int getParentProcessID() {
        return this.parentProcessID;
    }

    @Override
    public int getThreadCount() {
        return this.threadCount;
    }

    @Override
    public List<OSThread> getThreadDetails() {
        long l2 = System.currentTimeMillis();
        ArrayList<OSThread> arrayList = new ArrayList<OSThread>();
        List<ThreadInfo.ThreadStats> list = ThreadInfo.queryTaskThreads(this.getProcessID());
        for (ThreadInfo.ThreadStats threadStats : list) {
            long l3 = l2 - threadStats.getUpTime();
            if (l3 < this.getStartTime()) {
                l3 = this.getStartTime();
            }
            arrayList.add(new MacOSThread(this.getProcessID(), threadStats.getThreadId(), threadStats.getState(), threadStats.getSystemTime(), threadStats.getUserTime(), l3, l2 - l3, threadStats.getPriority()));
        }
        return arrayList;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public long getVirtualSize() {
        return this.virtualSize;
    }

    @Override
    public long getResidentSetSize() {
        return this.residentSetSize;
    }

    @Override
    public long getKernelTime() {
        return this.kernelTime;
    }

    @Override
    public long getUserTime() {
        return this.userTime;
    }

    @Override
    public long getUpTime() {
        return this.upTime;
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public long getBytesRead() {
        return this.bytesRead;
    }

    @Override
    public long getBytesWritten() {
        return this.bytesWritten;
    }

    @Override
    public long getOpenFiles() {
        return this.openFiles;
    }

    @Override
    public int getBitness() {
        return this.bitness;
    }

    @Override
    public long getAffinityMask() {
        int n2 = SysctlUtil.sysctl("hw.logicalcpu", 1);
        return n2 < 64 ? (1L << n2) - 1L : -1L;
    }

    @Override
    public long getMinorFaults() {
        return this.minorFaults;
    }

    @Override
    public long getMajorFaults() {
        return this.majorFaults;
    }

    @Override
    public long getContextSwitches() {
        return this.contextSwitches;
    }

    @Override
    public boolean updateAttributes() {
        Structure structure;
        Object object;
        long l2 = System.currentTimeMillis();
        SystemB.ProcTaskAllInfo procTaskAllInfo = new SystemB.ProcTaskAllInfo();
        if (0 > SystemB.INSTANCE.proc_pidinfo(this.getProcessID(), 2, 0L, procTaskAllInfo, procTaskAllInfo.size()) || procTaskAllInfo.ptinfo.pti_threadnum < 1) {
            this.state = OSProcess.State.INVALID;
            return false;
        }
        Memory memory = new Memory(4096L);
        if (0 < SystemB.INSTANCE.proc_pidpath(this.getProcessID(), memory, 4096)) {
            this.path = memory.getString(0L).trim();
            object = this.path.split("/");
            if (((String[])object).length > 0) {
                this.name = object[((String[])object).length - 1];
            }
        }
        if (this.name.isEmpty()) {
            this.name = Native.toString(procTaskAllInfo.pbsd.pbi_comm, StandardCharsets.UTF_8);
        }
        switch (procTaskAllInfo.pbsd.pbi_status) {
            case 1: {
                this.state = OSProcess.State.SLEEPING;
                break;
            }
            case 2: {
                this.state = OSProcess.State.WAITING;
                break;
            }
            case 3: {
                this.state = OSProcess.State.RUNNING;
                break;
            }
            case 4: {
                this.state = OSProcess.State.NEW;
                break;
            }
            case 5: {
                this.state = OSProcess.State.ZOMBIE;
                break;
            }
            case 6: {
                this.state = OSProcess.State.STOPPED;
                break;
            }
            default: {
                this.state = OSProcess.State.OTHER;
            }
        }
        this.parentProcessID = procTaskAllInfo.pbsd.pbi_ppid;
        this.userID = Integer.toString(procTaskAllInfo.pbsd.pbi_uid);
        object = SystemB.INSTANCE.getpwuid(procTaskAllInfo.pbsd.pbi_uid);
        if (object != null) {
            this.user = object.pw_name;
        }
        this.groupID = Integer.toString(procTaskAllInfo.pbsd.pbi_gid);
        SystemB.Group group = SystemB.INSTANCE.getgrgid(procTaskAllInfo.pbsd.pbi_gid);
        if (group != null) {
            this.group = group.gr_name;
        }
        this.threadCount = procTaskAllInfo.ptinfo.pti_threadnum;
        this.priority = procTaskAllInfo.ptinfo.pti_priority;
        this.virtualSize = procTaskAllInfo.ptinfo.pti_virtual_size;
        this.residentSetSize = procTaskAllInfo.ptinfo.pti_resident_size;
        this.kernelTime = procTaskAllInfo.ptinfo.pti_total_system / 1000000L;
        this.userTime = procTaskAllInfo.ptinfo.pti_total_user / 1000000L;
        this.startTime = procTaskAllInfo.pbsd.pbi_start_tvsec * 1000L + procTaskAllInfo.pbsd.pbi_start_tvusec / 1000L;
        this.upTime = l2 - this.startTime;
        this.openFiles = procTaskAllInfo.pbsd.pbi_nfiles;
        this.bitness = (procTaskAllInfo.pbsd.pbi_flags & 4) == 0 ? 32 : 64;
        this.majorFaults = procTaskAllInfo.ptinfo.pti_pageins;
        this.minorFaults = procTaskAllInfo.ptinfo.pti_faults - procTaskAllInfo.ptinfo.pti_pageins;
        this.contextSwitches = procTaskAllInfo.ptinfo.pti_csw;
        if (this.minorVersion >= 9) {
            structure = new SystemB.RUsageInfoV2();
            if (0 == SystemB.INSTANCE.proc_pid_rusage(this.getProcessID(), 2, (SystemB.RUsageInfoV2)structure)) {
                this.bytesRead = ((SystemB.RUsageInfoV2)structure).ri_diskio_bytesread;
                this.bytesWritten = ((SystemB.RUsageInfoV2)structure).ri_diskio_byteswritten;
            }
        }
        structure = new SystemB.VnodePathInfo();
        if (0 < SystemB.INSTANCE.proc_pidinfo(this.getProcessID(), 9, 0L, structure, structure.size())) {
            this.currentWorkingDirectory = Native.toString(((SystemB.VnodePathInfo)structure).pvi_cdir.vip_path, StandardCharsets.US_ASCII);
        }
        return true;
    }
}

