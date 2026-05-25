/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import com.sun.jna.Platform;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.GlobalConfig;
import oshi.util.Memoizer;
import oshi.util.tuples.Pair;

public abstract class AbstractOperatingSystem
implements OperatingSystem {
    public static final String OSHI_OS_UNIX_WHOCOMMAND = "oshi.os.unix.whoCommand";
    protected static final boolean USE_WHO_COMMAND = GlobalConfig.get("oshi.os.unix.whoCommand", false);
    private final Supplier<String> manufacturer = Memoizer.memoize(this::queryManufacturer);
    private final Supplier<Pair<String, OperatingSystem.OSVersionInfo>> familyVersionInfo = Memoizer.memoize(this::queryFamilyVersionInfo);
    private final Supplier<Integer> bitness = Memoizer.memoize(this::queryPlatformBitness);

    @Override
    public String getManufacturer() {
        return this.manufacturer.get();
    }

    protected abstract String queryManufacturer();

    @Override
    public String getFamily() {
        return this.familyVersionInfo.get().getA();
    }

    @Override
    public OperatingSystem.OSVersionInfo getVersionInfo() {
        return this.familyVersionInfo.get().getB();
    }

    protected abstract Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo();

    @Override
    public int getBitness() {
        return this.bitness.get();
    }

    private int queryPlatformBitness() {
        if (Platform.is64Bit()) {
            return 64;
        }
        int n2 = System.getProperty("os.arch").contains("64") ? 64 : 32;
        return this.queryBitness(n2);
    }

    protected abstract int queryBitness(int var1);

    @Override
    public List<OSProcess> getProcesses(Predicate<OSProcess> predicate, Comparator<OSProcess> comparator, int n2) {
        return this.queryAllProcesses().stream().filter(predicate == null ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : predicate).sorted(comparator == null ? OperatingSystem.ProcessSorting.NO_SORTING : comparator).limit(n2 > 0 ? (long)n2 : Long.MAX_VALUE).collect(Collectors.toList());
    }

    protected abstract List<OSProcess> queryAllProcesses();

    @Override
    public List<OSProcess> getChildProcesses(int n2, Predicate<OSProcess> predicate, Comparator<OSProcess> comparator, int n3) {
        List<OSProcess> list = this.queryChildProcesses(n2);
        OSProcess oSProcess2 = list.stream().filter(oSProcess -> oSProcess.getParentProcessID() == n2).findAny().orElse(null);
        long l2 = oSProcess2 == null ? 0L : oSProcess2.getStartTime();
        return this.queryChildProcesses(n2).stream().filter(predicate == null ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : predicate).filter(oSProcess -> oSProcess.getProcessID() != n2 && oSProcess.getStartTime() >= l2).sorted(comparator == null ? OperatingSystem.ProcessSorting.NO_SORTING : comparator).limit(n3 > 0 ? (long)n3 : Long.MAX_VALUE).collect(Collectors.toList());
    }

    protected abstract List<OSProcess> queryChildProcesses(int var1);

    @Override
    public List<OSProcess> getDescendantProcesses(int n2, Predicate<OSProcess> predicate, Comparator<OSProcess> comparator, int n3) {
        List<OSProcess> list = this.queryDescendantProcesses(n2);
        OSProcess oSProcess2 = list.stream().filter(oSProcess -> oSProcess.getParentProcessID() == n2).findAny().orElse(null);
        long l2 = oSProcess2 == null ? 0L : oSProcess2.getStartTime();
        return this.queryDescendantProcesses(n2).stream().filter(predicate == null ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : predicate).filter(oSProcess -> oSProcess.getProcessID() != n2 && oSProcess.getStartTime() >= l2).sorted(comparator == null ? OperatingSystem.ProcessSorting.NO_SORTING : comparator).limit(n3 > 0 ? (long)n3 : Long.MAX_VALUE).collect(Collectors.toList());
    }

    protected abstract List<OSProcess> queryDescendantProcesses(int var1);

    protected static Set<Integer> getChildrenOrDescendants(Collection<OSProcess> collection, int n2, boolean bl2) {
        Map<Integer, Integer> map = collection.stream().collect(Collectors.toMap(OSProcess::getProcessID, OSProcess::getParentProcessID));
        return AbstractOperatingSystem.getChildrenOrDescendants(map, n2, bl2);
    }

    protected static Set<Integer> getChildrenOrDescendants(Map<Integer, Integer> map, int n2, boolean bl2) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(n2);
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        arrayDeque.add(n2);
        do {
            for (int n3 : AbstractOperatingSystem.getChildren(map, (Integer)arrayDeque.poll())) {
                if (hashSet.contains(n3)) continue;
                hashSet.add(n3);
                arrayDeque.add(n3);
            }
        } while (bl2 && !arrayDeque.isEmpty());
        return hashSet;
    }

    private static Set<Integer> getChildren(Map<Integer, Integer> map, int n2) {
        return map.entrySet().stream().filter(entry -> ((Integer)entry.getValue()).equals(n2) && !((Integer)entry.getKey()).equals(n2)).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getManufacturer()).append(' ').append(this.getFamily()).append(' ').append(this.getVersionInfo());
        return stringBuilder.toString();
    }
}

