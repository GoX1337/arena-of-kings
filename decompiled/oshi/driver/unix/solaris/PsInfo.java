/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.solaris;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.platform.unix.LibCAPI;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.SolarisLibc;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quartet;

@ThreadSafe
public final class PsInfo {
    private static final Logger LOG = LoggerFactory.getLogger(PsInfo.class);
    private static final boolean IS_LITTLE_ENDIAN = "little".equals(System.getProperty("sun.cpu.endian"));
    private static final SolarisLibc LIBC = SolarisLibc.INSTANCE;
    private static final long PAGE_SIZE = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("pagesize"), 4096L);
    private static Map<LwpsInfoT, Integer> lwpsInfoOffsets = PsInfo.initLwpsOffsets();
    private static Map<PsInfoT, Integer> psInfoOffsets = PsInfo.initPsOffsets();

    private PsInfo() {
    }

    private static Map<LwpsInfoT, Integer> initLwpsOffsets() {
        EnumMap<LwpsInfoT, Integer> enumMap = new EnumMap<LwpsInfoT, Integer>(LwpsInfoT.class);
        int n2 = 0;
        for (LwpsInfoT lwpsInfoT : LwpsInfoT.values()) {
            enumMap.put(lwpsInfoT, n2);
            n2 += lwpsInfoT.size;
        }
        return enumMap;
    }

    private static Map<PsInfoT, Integer> initPsOffsets() {
        EnumMap<PsInfoT, Integer> enumMap = new EnumMap<PsInfoT, Integer>(PsInfoT.class);
        int n2 = 0;
        for (PsInfoT psInfoT : PsInfoT.values()) {
            enumMap.put(psInfoT, n2);
            n2 += psInfoT.size;
        }
        return enumMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Quartet<Integer, Long, Long, Byte> queryArgsEnvAddrs(int n2) {
        File file = new File("/proc/" + n2 + "/psinfo");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
             FileChannel fileChannel = randomAccessFile.getChannel();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            int n3;
            ByteBuffer byteBuffer;
            int n4 = psInfoOffsets.get((Object)PsInfoT.SIZE);
            if ((long)n4 > fileChannel.size()) {
                n4 = (int)fileChannel.size();
            }
            if (fileChannel.read(byteBuffer = ByteBuffer.allocate(n4)) <= psInfoOffsets.get((Object)PsInfoT.PR_DMODEL)) return null;
            if (IS_LITTLE_ENDIAN) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            }
            if ((n3 = byteBuffer.getInt(psInfoOffsets.get((Object)PsInfoT.PR_ARGC))) > 0) {
                long l2 = Native.POINTER_SIZE == 8 ? byteBuffer.getLong(psInfoOffsets.get((Object)PsInfoT.PR_ARGV)) : (long)byteBuffer.getInt(psInfoOffsets.get((Object)PsInfoT.PR_ARGV));
                long l3 = Native.POINTER_SIZE == 8 ? byteBuffer.getLong(psInfoOffsets.get((Object)PsInfoT.PR_ENVP)) : (long)byteBuffer.getInt(psInfoOffsets.get((Object)PsInfoT.PR_ENVP));
                byte by2 = byteBuffer.get(psInfoOffsets.get((Object)PsInfoT.PR_DMODEL));
                if ((long)(by2 * 4) != (l3 - l2) / (long)(n3 + 1)) {
                    LOG.trace("Failed data model and offset increment sanity check: dm={} diff={}", (Object)by2, (Object)(l3 - l2));
                    Quartet<Integer, Long, Long, Byte> quartet = null;
                    return quartet;
                }
                Quartet<Integer, Long, Long, Byte> quartet = new Quartet<Integer, Long, Long, Byte>(n3, l2, l3, by2);
                return quartet;
            }
            LOG.trace("No permission to read file: {} ", (Object)file);
            return null;
        }
        catch (IOException iOException) {
            LOG.debug("Failed to read file: {} ", (Object)file);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Pair<List<String>, Map<String, String>> queryArgsEnv(int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        Quartet<Integer, Long, Long, Byte> quartet = PsInfo.queryArgsEnvAddrs(n2);
        if (quartet != null) {
            String string = "/proc/" + n2 + "/as";
            int n3 = LIBC.open(string, 0);
            if (n3 < 0) {
                LOG.trace("No permission to read file: {} ", (Object)string);
                return new Pair<List<String>, Map<String, String>>(arrayList, linkedHashMap);
            }
            try {
                int n4 = quartet.getA();
                long l2 = quartet.getB();
                long l3 = quartet.getC();
                long l4 = (long)quartet.getD().byteValue() * 4L;
                long l5 = 0L;
                Memory memory = new Memory(PAGE_SIZE * 2L);
                LibCAPI.size_t size_t2 = new LibCAPI.size_t(memory.size());
                long[] lArray = new long[n4];
                long l6 = l2;
                for (int i2 = 0; i2 < n4; ++i2) {
                    lArray[i2] = (l5 = PsInfo.conditionallyReadBufferFromStartOfPage(n3, memory, size_t2, l5, l6)) == 0L ? 0L : PsInfo.getOffsetFromBuffer(memory, l6 - l5, l4);
                    l6 += l4;
                }
                ArrayList<Long> arrayList2 = new ArrayList<Long>();
                l6 = l3;
                long l7 = 0L;
                int n5 = 500;
                do {
                    long l8 = l7 = (l5 = PsInfo.conditionallyReadBufferFromStartOfPage(n3, memory, size_t2, l5, l6)) == 0L ? 0L : PsInfo.getOffsetFromBuffer(memory, l6 - l5, l4);
                    if (l7 != 0L) {
                        arrayList2.add(l7);
                    }
                    l6 += l4;
                } while (l7 != 0L && --n5 > 0);
                for (int i3 = 0; i3 < lArray.length && lArray[i3] != 0L; ++i3) {
                    String object;
                    if ((l5 = PsInfo.conditionallyReadBufferFromStartOfPage(n3, memory, size_t2, l5, lArray[i3])) == 0L || (object = memory.getString(lArray[i3] - l5)).isEmpty()) continue;
                    arrayList.add(object);
                }
                for (Long l9 : arrayList2) {
                    String string2;
                    int n6;
                    if ((l5 = PsInfo.conditionallyReadBufferFromStartOfPage(n3, memory, size_t2, l5, l9)) == 0L || (n6 = (string2 = memory.getString(l9 - l5)).indexOf(61)) <= 0) continue;
                    linkedHashMap.put(string2.substring(0, n6), string2.substring(n6 + 1));
                }
            }
            finally {
                LIBC.close(n3);
            }
        }
        return new Pair<List<String>, Map<String, String>>(arrayList, linkedHashMap);
    }

    private static long conditionallyReadBufferFromStartOfPage(int n2, Memory memory, LibCAPI.size_t size_t2, long l2, long l3) {
        if (l3 < l2 || l3 - l2 > PAGE_SIZE) {
            long l4 = Math.floorDiv(l3, PAGE_SIZE) * PAGE_SIZE;
            LibCAPI.ssize_t ssize_t2 = LIBC.pread(n2, memory, size_t2, new NativeLong(l4));
            if (ssize_t2.longValue() < PAGE_SIZE) {
                LOG.debug("Failed to read page from address space: {} bytes read", (Object)ssize_t2.longValue());
                return 0L;
            }
            return l4;
        }
        return l2;
    }

    private static long getOffsetFromBuffer(Memory memory, long l2, long l3) {
        return l3 == 8L ? memory.getLong(l2) : (long)memory.getInt(l2);
    }

    static /* synthetic */ Map access$000() {
        return lwpsInfoOffsets;
    }

    static enum LwpsInfoT {
        PR_FLAG(4),
        PR_LWPID(4),
        PR_ADDR(Native.POINTER_SIZE),
        PR_WCHAN(Native.POINTER_SIZE),
        PR_STYPE(1),
        PR_STATE(1),
        PR_SNAME(1),
        PR_NICE(1),
        PR_SYSCALL(2),
        PR_OLDPRI(1),
        PR_CPU(1),
        PR_PRI(4),
        PR_PCTCPU(2),
        PAD(2),
        PR_START(2 * NativeLong.SIZE),
        PR_TIME(2 * NativeLong.SIZE),
        PR_CLNAME(8),
        PR_NAME(16),
        PR_ONPRO(4),
        PR_BINDPRO(4),
        PR_BINDPSET(4),
        PR_LGRP(4),
        PR_LAST_ONPROC(8),
        SIZE(0);

        private final int size;

        private LwpsInfoT(int n3) {
            this.size = n3;
        }

        public int size() {
            return this.size;
        }
    }

    static enum PsInfoT {
        PR_FLAG(4),
        PR_NLWP(4),
        PR_NZOMB(4),
        PR_PID(4),
        PR_PPID(4),
        PR_PGID(4),
        PR_SID(4),
        PR_UID(4),
        PR_EUID(4),
        PR_GID(4),
        PR_EGID(4),
        PAD1(Native.POINTER_SIZE - 4),
        PR_ADDR(Native.POINTER_SIZE),
        PR_SIZE(Native.SIZE_T_SIZE),
        PR_RSSIZE(Native.SIZE_T_SIZE),
        PR_TTYDEV(NativeLong.SIZE),
        PR_PCTCPU(2),
        PR_PCTMEM(2),
        PAD2(Native.POINTER_SIZE - 4),
        PR_START(2 * NativeLong.SIZE),
        PR_TIME(2 * NativeLong.SIZE),
        PR_CTIME(2 * NativeLong.SIZE),
        PR_FNAME(16),
        PR_PSARGS(80),
        PR_WSTAT(4),
        PR_ARGC(4),
        PR_ARGV(Native.POINTER_SIZE),
        PR_ENVP(Native.POINTER_SIZE),
        PR_DMODEL(1),
        PAD3(7),
        PR_LWP((Integer)PsInfo.access$000().get((Object)((Object)LwpsInfoT.SIZE))),
        PR_TASKID(4),
        PR_PROJID(4),
        PR_POOLID(4),
        PR_ZONEID(4),
        PR_CONTRACT(4),
        SIZE(0);

        private final int size;

        private PsInfoT(int n3) {
            this.size = n3;
        }

        public int size() {
            return this.size;
        }
    }
}

