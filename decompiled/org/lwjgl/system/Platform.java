/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.function.Function;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;

public enum Platform {
    LINUX("Linux", "linux"){
        private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");

        @Override
        String mapLibraryName(String string) {
            if (this.SO.matcher(string).find()) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    }
    ,
    MACOSX("macOS", "macos"){
        private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");

        @Override
        String mapLibraryName(String string) {
            if (this.DYLIB.matcher(string).find()) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    }
    ,
    WINDOWS("Windows", "windows"){

        @Override
        String mapLibraryName(String string) {
            if (string.endsWith(".dll")) {
                return string;
            }
            return System.mapLibraryName(string);
        }
    };

    private static final Platform current;
    private static final Function<String, String> bundledLibraryNameMapper;
    private static final Function<String, String> bundledLibraryPathMapper;
    private final String name;
    private final String nativePath;

    private Platform(String string2, String string3) {
        this.name = string2;
        this.nativePath = string3;
    }

    public String getName() {
        return this.name;
    }

    abstract String mapLibraryName(String var1);

    public static Platform get() {
        return current;
    }

    public static Architecture getArchitecture() {
        return Architecture.current;
    }

    public static String mapLibraryNameBundled(String string) {
        return bundledLibraryNameMapper.apply(string);
    }

    static String mapLibraryPathBundled(String string) {
        return bundledLibraryPathMapper.apply(string);
    }

    private static Function<String, String> getMapper(@Nullable Object object, Function<String, String> function, Function<String, String> function2) {
        if (object == null || "default".equals(object)) {
            return function;
        }
        if ("legacy".equals(object)) {
            return function2;
        }
        if (object instanceof Function) {
            return (Function)object;
        }
        String string = object.toString();
        try {
            return (Function)Class.forName(string).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Throwable throwable) {
            if (Checks.DEBUG) {
                throwable.printStackTrace(APIUtil.DEBUG_STREAM);
            }
            APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", string));
            return function;
        }
    }

    static {
        String string2 = System.getProperty("os.name");
        if (string2.startsWith("Windows")) {
            current = WINDOWS;
        } else if (string2.startsWith("Linux") || string2.startsWith("FreeBSD") || string2.startsWith("SunOS") || string2.startsWith("Unix")) {
            current = LINUX;
        } else if (string2.startsWith("Mac OS X") || string2.startsWith("Darwin")) {
            current = MACOSX;
        } else {
            throw new LinkageError("Unknown platform: " + string2);
        }
        bundledLibraryNameMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER.get("default"), string -> string, string -> Architecture.current.is64Bit ? string : string + "32");
        bundledLibraryPathMapper = Platform.getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER.get("default"), string -> Platform.current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + string, string -> string.substring(string.lastIndexOf(47)));
    }

    public static final class Architecture
    extends Enum<Architecture> {
        public static final /* enum */ Architecture X64;
        public static final /* enum */ Architecture X86;
        public static final /* enum */ Architecture ARM64;
        public static final /* enum */ Architecture ARM32;
        static final Architecture current;
        final boolean is64Bit;
        private static final /* synthetic */ Architecture[] $VALUES;

        public static Architecture[] values() {
            return (Architecture[])$VALUES.clone();
        }

        public static Architecture valueOf(String string) {
            return Enum.valueOf(Architecture.class, string);
        }

        private Architecture(boolean bl2) {
            this.is64Bit = bl2;
        }

        static {
            boolean bl2;
            X64 = new Architecture(true);
            X86 = new Architecture(false);
            ARM64 = new Architecture(true);
            ARM32 = new Architecture(false);
            $VALUES = new Architecture[]{X64, X86, ARM64, ARM32};
            String string = System.getProperty("os.arch");
            boolean bl3 = bl2 = string.contains("64") || string.startsWith("armv8");
            current = string.startsWith("arm") || string.startsWith("aarch64") ? (bl2 ? ARM64 : ARM32) : (bl2 ? X64 : X86);
        }
    }
}

