/*
 * Decompiled with CFR 0.152.
 */
package oshi;

public enum PlatformEnum {
    MACOS("macOS"),
    LINUX("Linux"),
    WINDOWS("Windows"),
    SOLARIS("Solaris"),
    FREEBSD("FreeBSD"),
    OPENBSD("OpenBSD"),
    WINDOWSCE("Windows CE"),
    AIX("AIX"),
    ANDROID("Android"),
    GNU("GNU"),
    KFREEBSD("kFreeBSD"),
    NETBSD("NetBSD"),
    UNKNOWN("Unknown");

    private final String name;

    private PlatformEnum(String string2) {
        this.name = string2;
    }

    public String getName() {
        return this.name;
    }

    public static String getName(int n2) {
        return PlatformEnum.getValue(n2).getName();
    }

    public static PlatformEnum getValue(int n2) {
        if (n2 < 0 || n2 >= UNKNOWN.ordinal()) {
            return UNKNOWN;
        }
        return PlatformEnum.values()[n2];
    }
}

