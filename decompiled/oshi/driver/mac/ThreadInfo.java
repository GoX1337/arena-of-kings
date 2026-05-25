/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.mac;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSProcess;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public final class ThreadInfo {
    private static final Pattern PS_M = Pattern.compile("\\D+(\\d+).+(\\d+\\.\\d)\\s+(\\w)\\s+(\\d+)\\D+(\\d+:\\d{2}\\.\\d{2})\\s+(\\d+:\\d{2}\\.\\d{2}).+");

    private ThreadInfo() {
    }

    public static List<ThreadStats> queryTaskThreads(int n2) {
        String string = " " + n2 + " ";
        ArrayList<ThreadStats> arrayList = new ArrayList<ThreadStats>();
        List list = ExecutingCommand.runNative("ps -awwxM").stream().filter(string2 -> string2.contains(string)).collect(Collectors.toList());
        int n3 = 0;
        for (String string3 : list) {
            Matcher matcher = PS_M.matcher(string3);
            if (!matcher.matches() || n2 != ParseUtil.parseIntOrDefault(matcher.group(1), -1)) continue;
            double d2 = ParseUtil.parseDoubleOrDefault(matcher.group(2), 0.0);
            char c2 = matcher.group(3).charAt(0);
            int n4 = ParseUtil.parseIntOrDefault(matcher.group(4), 0);
            long l2 = ParseUtil.parseDHMSOrDefault(matcher.group(5), 0L);
            long l3 = ParseUtil.parseDHMSOrDefault(matcher.group(6), 0L);
            arrayList.add(new ThreadStats(n3++, d2, c2, l2, l3, n4));
        }
        return arrayList;
    }

    @Immutable
    public static class ThreadStats {
        private final int threadId;
        private final long userTime;
        private final long systemTime;
        private final long upTime;
        private final OSProcess.State state;
        private final int priority;

        public ThreadStats(int n2, double d2, char c2, long l2, long l3, int n3) {
            this.threadId = n2;
            this.userTime = l3;
            this.systemTime = l2;
            this.upTime = (long)((double)(l3 + l2) / (d2 / 100.0 + 5.0E-4));
            switch (c2) {
                case 'I': 
                case 'S': {
                    this.state = OSProcess.State.SLEEPING;
                    break;
                }
                case 'U': {
                    this.state = OSProcess.State.WAITING;
                    break;
                }
                case 'R': {
                    this.state = OSProcess.State.RUNNING;
                    break;
                }
                case 'Z': {
                    this.state = OSProcess.State.ZOMBIE;
                    break;
                }
                case 'T': {
                    this.state = OSProcess.State.STOPPED;
                    break;
                }
                default: {
                    this.state = OSProcess.State.OTHER;
                }
            }
            this.priority = n3;
        }

        public int getThreadId() {
            return this.threadId;
        }

        public long getUserTime() {
            return this.userTime;
        }

        public long getSystemTime() {
            return this.systemTime;
        }

        public long getUpTime() {
            return this.upTime;
        }

        public OSProcess.State getState() {
            return this.state;
        }

        public int getPriority() {
            return this.priority;
        }
    }
}

