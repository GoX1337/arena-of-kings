/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import oshi.annotation.concurrent.Immutable;
import oshi.driver.linux.Dmidecode;
import oshi.driver.linux.Sysfs;
import oshi.hardware.common.AbstractFirmware;
import oshi.util.ExecutingCommand;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@Immutable
final class LinuxFirmware
extends AbstractFirmware {
    private static final DateTimeFormatter VCGEN_FORMATTER = DateTimeFormatter.ofPattern("MMM d uuuu HH:mm:ss", Locale.ENGLISH);
    private final Supplier<String> manufacturer = Memoizer.memoize(this::queryManufacturer);
    private final Supplier<String> description = Memoizer.memoize(this::queryDescription);
    private final Supplier<String> version = Memoizer.memoize(this::queryVersion);
    private final Supplier<String> releaseDate = Memoizer.memoize(this::queryReleaseDate);
    private final Supplier<String> name = Memoizer.memoize(this::queryName);
    private final Supplier<VcGenCmdStrings> vcGenCmd = Memoizer.memoize(LinuxFirmware::queryVcGenCmd);
    private final Supplier<Pair<String, String>> biosNameRev = Memoizer.memoize(Dmidecode::queryBiosNameRev);

    LinuxFirmware() {
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer.get();
    }

    @Override
    public String getDescription() {
        return this.description.get();
    }

    @Override
    public String getVersion() {
        return this.version.get();
    }

    @Override
    public String getReleaseDate() {
        return this.releaseDate.get();
    }

    @Override
    public String getName() {
        return this.name.get();
    }

    private String queryManufacturer() {
        String string = null;
        string = Sysfs.queryBiosVendor();
        if (string == null && (string = this.vcGenCmd.get().manufacturer) == null) {
            return "unknown";
        }
        return string;
    }

    private String queryDescription() {
        String string = null;
        string = Sysfs.queryBiosDescription();
        if (string == null && (string = this.vcGenCmd.get().description) == null) {
            return "unknown";
        }
        return string;
    }

    private String queryVersion() {
        String string = null;
        string = Sysfs.queryBiosVersion(this.biosNameRev.get().getB());
        if (string == null && (string = this.vcGenCmd.get().version) == null) {
            return "unknown";
        }
        return string;
    }

    private String queryReleaseDate() {
        String string = null;
        string = Sysfs.queryBiosReleaseDate();
        if (string == null && (string = this.vcGenCmd.get().releaseDate) == null) {
            return "unknown";
        }
        return string;
    }

    private String queryName() {
        String string = null;
        string = this.biosNameRev.get().getA();
        if (string == null && (string = this.vcGenCmd.get().name) == null) {
            return "unknown";
        }
        return string;
    }

    private static VcGenCmdStrings queryVcGenCmd() {
        String string = null;
        String string2 = null;
        String string3 = null;
        List<String> list = ExecutingCommand.runNative("vcgencmd version");
        if (list.size() >= 3) {
            try {
                string = DateTimeFormatter.ISO_LOCAL_DATE.format(VCGEN_FORMATTER.parse(list.get(0)));
            }
            catch (DateTimeParseException dateTimeParseException) {
                string = "unknown";
            }
            String[] stringArray = ParseUtil.whitespaces.split(list.get(1));
            string2 = stringArray[stringArray.length - 1];
            string3 = list.get(2).replace("version ", "");
            return new VcGenCmdStrings(string, string2, string3, "RPi", "Bootloader");
        }
        return new VcGenCmdStrings(null, null, null, null, null);
    }

    static final class VcGenCmdStrings {
        private final String releaseDate;
        private final String manufacturer;
        private final String version;
        private final String name;
        private final String description;

        private VcGenCmdStrings(String string, String string2, String string3, String string4, String string5) {
            this.releaseDate = string;
            this.manufacturer = string2;
            this.version = string3;
            this.name = string4;
            this.description = string5;
        }
    }
}

