/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix.aix;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.platform.unix.LibCAPI;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.AixLibc;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

@ThreadSafe
public final class PsInfo {
    private static final Logger LOG = LoggerFactory.getLogger(PsInfo.class);
    private static final AixLibc LIBC = AixLibc.INSTANCE;
    private static final long PAGE_SIZE = 4096L;
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
    public static Triplet<Integer, Long, Long> queryArgsEnvAddrs(int n2) {
        File file = new File("/proc/" + n2 + "/psinfo");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
             FileChannel fileChannel = randomAccessFile.getChannel();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            ByteBuffer byteBuffer;
            int n3 = psInfoOffsets.get((Object)PsInfoT.SIZE);
            if ((long)n3 > fileChannel.size()) {
                n3 = (int)fileChannel.size();
            }
            if (fileChannel.read(byteBuffer = ByteBuffer.allocate(n3)) < psInfoOffsets.get((Object)PsInfoT.PR_FNAME)) return null;
            int n4 = byteBuffer.getInt(psInfoOffsets.get((Object)PsInfoT.PR_ARGC));
            long l2 = byteBuffer.getLong(psInfoOffsets.get((Object)PsInfoT.PR_ARGV));
            long l3 = byteBuffer.getLong(psInfoOffsets.get((Object)PsInfoT.PR_ENVP));
            Triplet<Integer, Long, Long> triplet = new Triplet<Integer, Long, Long>(n4, l2, l3);
            return triplet;
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
        Triplet<Integer, Long, Long> triplet = PsInfo.queryArgsEnvAddrs(n2);
        if (triplet != null) {
            String string = "/proc/" + n2 + "/as";
            int n3 = LIBC.open(string, 0);
            if (n3 < 0) {
                LOG.trace("No permission to read file: {} ", (Object)string);
                return new Pair<List<String>, Map<String, String>>(arrayList, linkedHashMap);
            }
            try {
                int n4 = triplet.getA();
                long l2 = triplet.getB();
                long l3 = triplet.getC();
                long l4 = (l3 - l2) / (long)(n4 + 1);
                long l5 = 0L;
                Memory memory = new Memory(8192L);
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
        if (l3 < l2 || l3 - l2 > 4096L) {
            long l4 = Math.floorDiv(l3, 4096L) * 4096L;
            LibCAPI.ssize_t ssize_t2 = LIBC.pread(n2, memory, size_t2, new NativeLong(l4));
            if (ssize_t2.longValue() < 4096L) {
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
        PR_LWPID(8),
        PR_ADDR(8),
        PR_WCHAN(8),
        PR_FLAG(4),
        PR_WTYPE(1),
        PR_STATE(1),
        PR_SNAME(1),
        PR_NICE(1),
        PR_PRI(4),
        PR_POLICY(4),
        PR_CLNAME(8),
        PR_ONPRO(Native.POINTER_SIZE),
        PR_BINDPRO(Native.POINTER_SIZE),
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
        PR_FLAG2(4),
        PR_NLWP(4),
        PR_PAD1(4),
        PR_UID(8),
        PR_EUID(8),
        PR_GID(8),
        PR_EGID(8),
        PR_PID(8),
        PR_PPID(8),
        PR_PGID(8),
        PR_SID(8),
        PR_TTYDEV(8),
        PR_ADDR(8),
        PR_SIZE(8),
        PR_RSSIZE(8),
        PR_START(16),
        PR_TIME(16),
        PR_CID(2),
        PR_PAD2(2),
        PR_ARGC(4),
        PR_ARGV(8),
        PR_ENVP(8),
        PR_FNAME(16),
        PR_PSARGS(80),
        PR_PAD(64),
        PR_LWP((Integer)PsInfo.access$000().get((Object)((Object)LwpsInfoT.SIZE))),
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

