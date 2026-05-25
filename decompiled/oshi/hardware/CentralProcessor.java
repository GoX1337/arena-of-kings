/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware;

import java.util.List;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.FileUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.Util;

@ThreadSafe
public interface CentralProcessor {
    public ProcessorIdentifier getProcessorIdentifier();

    public long getMaxFreq();

    public long[] getCurrentFreq();

    public List<LogicalProcessor> getLogicalProcessors();

    public double getSystemCpuLoadBetweenTicks(long[] var1);

    public long[] getSystemCpuLoadTicks();

    public double[] getSystemLoadAverage(int var1);

    public double[] getProcessorCpuLoadBetweenTicks(long[][] var1);

    public long[][] getProcessorCpuLoadTicks();

    public int getLogicalProcessorCount();

    public int getPhysicalProcessorCount();

    public int getPhysicalPackageCount();

    public long getContextSwitches();

    public long getInterrupts();

    @Immutable
    public static final class ProcessorIdentifier {
        private static final String OSHI_ARCHITECTURE_PROPERTIES = "oshi.architecture.properties";
        private final String cpuVendor;
        private final String cpuName;
        private final String cpuFamily;
        private final String cpuModel;
        private final String cpuStepping;
        private final String processorID;
        private final String cpuIdentifier;
        private final boolean cpu64bit;
        private final long cpuVendorFreq;
        private final Supplier<String> microArchictecture = Memoizer.memoize(this::queryMicroarchitecture);

        public ProcessorIdentifier(String string, String string2, String string3, String string4, String string5, String string6, boolean bl2) {
            this(string, string2, string3, string4, string5, string6, bl2, -1L);
        }

        public ProcessorIdentifier(String string, String string2, String string3, String string4, String string5, String string6, boolean bl2, long l2) {
            this.cpuVendor = string;
            this.cpuName = string2;
            this.cpuFamily = string3;
            this.cpuModel = string4;
            this.cpuStepping = string5;
            this.processorID = string6;
            this.cpu64bit = bl2;
            StringBuilder stringBuilder = new StringBuilder();
            if (string.contentEquals("GenuineIntel")) {
                stringBuilder.append(bl2 ? "Intel64" : "x86");
            } else {
                stringBuilder.append(string);
            }
            stringBuilder.append(" Family ").append(string3);
            stringBuilder.append(" Model ").append(string4);
            stringBuilder.append(" Stepping ").append(string5);
            this.cpuIdentifier = stringBuilder.toString();
            if (l2 > 0L) {
                this.cpuVendorFreq = l2;
            } else {
                Pattern pattern = Pattern.compile("@ (.*)$");
                Matcher matcher = pattern.matcher(string2);
                if (matcher.find()) {
                    String string7 = matcher.group(1);
                    this.cpuVendorFreq = ParseUtil.parseHertz(string7);
                } else {
                    this.cpuVendorFreq = -1L;
                }
            }
        }

        public String getVendor() {
            return this.cpuVendor;
        }

        public String getName() {
            return this.cpuName;
        }

        public String getFamily() {
            return this.cpuFamily;
        }

        public String getModel() {
            return this.cpuModel;
        }

        public String getStepping() {
            return this.cpuStepping;
        }

        public String getProcessorID() {
            return this.processorID;
        }

        public String getIdentifier() {
            return this.cpuIdentifier;
        }

        public boolean isCpu64bit() {
            return this.cpu64bit;
        }

        public long getVendorFreq() {
            return this.cpuVendorFreq;
        }

        public String getMicroarchitecture() {
            return this.microArchictecture.get();
        }

        private String queryMicroarchitecture() {
            String string = null;
            Properties properties = FileUtil.readPropertiesFromFilename(OSHI_ARCHITECTURE_PROPERTIES);
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = this.cpuVendor.toUpperCase();
            if (string2.contains("AMD")) {
                stringBuilder.append("amd.");
            } else if (string2.contains("ARM")) {
                stringBuilder.append("arm.");
            } else if (string2.contains("IBM")) {
                int n2 = this.cpuName.indexOf("_POWER");
                if (n2 > 0) {
                    string = this.cpuName.substring(n2 + 1);
                }
            } else if (string2.contains("APPLE")) {
                stringBuilder.append("apple.");
            }
            if (Util.isBlank(string) && !stringBuilder.toString().equals("arm.")) {
                stringBuilder.append(this.cpuFamily);
                string = properties.getProperty(stringBuilder.toString());
            }
            if (Util.isBlank(string)) {
                stringBuilder.append('.').append(this.cpuModel);
                string = properties.getProperty(stringBuilder.toString());
            }
            if (Util.isBlank(string)) {
                stringBuilder.append('.').append(this.cpuStepping);
                string = properties.getProperty(stringBuilder.toString());
            }
            return Util.isBlank(string) ? "unknown" : string;
        }

        public String toString() {
            return this.getIdentifier();
        }
    }

    @Immutable
    public static class LogicalProcessor {
        private final int processorNumber;
        private final int physicalProcessorNumber;
        private final int physicalPackageNumber;
        private final int numaNode;
        private final int processorGroup;

        public LogicalProcessor(int n2, int n3, int n4) {
            this(n2, n3, n4, 0, 0);
        }

        public LogicalProcessor(int n2, int n3, int n4, int n5) {
            this(n2, n3, n4, n5, 0);
        }

        public LogicalProcessor(int n2, int n3, int n4, int n5, int n6) {
            this.processorNumber = n2;
            this.physicalProcessorNumber = n3;
            this.physicalPackageNumber = n4;
            this.numaNode = n5;
            this.processorGroup = n6;
        }

        public int getProcessorNumber() {
            return this.processorNumber;
        }

        public int getPhysicalProcessorNumber() {
            return this.physicalProcessorNumber;
        }

        public int getPhysicalPackageNumber() {
            return this.physicalPackageNumber;
        }

        public int getNumaNode() {
            return this.numaNode;
        }

        public int getProcessorGroup() {
            return this.processorGroup;
        }

        public String toString() {
            return "LogicalProcessor [processorNumber=" + this.processorNumber + ", coreNumber=" + this.physicalProcessorNumber + ", packageNumber=" + this.physicalPackageNumber + ", numaNode=" + this.numaNode + ", processorGroup=" + this.processorGroup + "]";
        }
    }

    public static enum TickType {
        USER(0),
        NICE(1),
        SYSTEM(2),
        IDLE(3),
        IOWAIT(4),
        IRQ(5),
        SOFTIRQ(6),
        STEAL(7);

        private final int index;

        private TickType(int n3) {
            this.index = n3;
        }

        public int getIndex() {
            return this.index;
        }
    }
}

