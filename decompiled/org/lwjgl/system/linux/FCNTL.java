/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class FCNTL {
    public static final int O_ACCMODE = 3;
    public static final int O_RDONLY = 0;
    public static final int O_WRONLY = 1;
    public static final int O_RDWR = 2;
    public static final int O_APPEND = 1024;
    public static final int O_ASYNC = 8192;
    public static final int O_CLOEXEC = 524288;
    public static final int O_CREAT = 64;
    public static final int O_DIRECT = 16384;
    public static final int O_DIRECTORY = 65536;
    public static final int O_DSYNC = 4096;
    public static final int O_EXCL = 128;
    public static final int O_LARGEFILE = 32768;
    public static final int O_NOATIME = 262144;
    public static final int O_NOCTTY = 256;
    public static final int O_NOFOLLOW = 131072;
    public static final int O_NONBLOCK = 2048;
    public static final int O_NDELAY = 2048;
    public static final int O_PATH = 0x200000;
    public static final int O_SYNC = 0x101000;
    public static final int O_TMPFILE = 0x410000;
    public static final int O_TRUNC = 512;
    public static final int S_IFMT = 61440;
    public static final int S_IFBLK = 24576;
    public static final int S_IFCHR = 8192;
    public static final int S_IFIFO = 4096;
    public static final int S_IFREG = 32768;
    public static final int S_IFDIR = 16384;
    public static final int S_IFLNK = 40960;
    public static final int S_IFSOCK = 49152;
    public static final int S_IRWXU = 448;
    public static final int S_IRUSR = 256;
    public static final int S_IWUSR = 128;
    public static final int S_IXUSR = 64;
    public static final int S_IRWXG = 56;
    public static final int S_IRGRP = 32;
    public static final int S_IWGRP = 16;
    public static final int S_IXGRP = 8;
    public static final int S_IRWXO = 7;
    public static final int S_IROTH = 4;
    public static final int S_IWOTH = 2;
    public static final int S_IXOTH = 1;
    public static final int S_ISUID = 2048;
    public static final int S_ISGID = 1024;
    public static final int S_ISVTX = 512;
    public static final int F_DUPFD = 0;
    public static final int F_GETFD = 1;
    public static final int F_SETFD = 2;
    public static final int F_GETFL = 3;
    public static final int F_SETFL = 4;
    public static final int F_GETLK = 5;
    public static final int F_SETLK = 8;
    public static final int F_SETLKW = 7;
    public static final int F_SETOWN = 8;
    public static final int F_GETOWN = 9;
    public static final int F_SETSIG = 10;
    public static final int F_GETSIG = 11;
    public static final int F_SETOWN_EX = 15;
    public static final int F_GETOWN_EX = 16;
    public static final int F_OFD_GETLK = 36;
    public static final int F_OFD_SETLK = 37;
    public static final int F_OFD_SETLKW = 38;
    public static final int F_SETLEASE = 1024;
    public static final int F_GETLEASE = 1025;
    public static final int F_NOTIFY = 1026;
    public static final int F_SETPIPE_SZ = 1031;
    public static final int F_GETPIPE_SZ = 1032;
    public static final int F_ADD_SEALS = 1033;
    public static final int F_GET_SEALS = 1034;
    public static final int F_GET_RW_HINT = 1035;
    public static final int F_SET_RW_HINT = 1036;
    public static final int F_GET_FILE_RW_HINT = 1037;
    public static final int F_SET_FILE_RW_HINT = 1038;
    public static final int F_DUPFD_CLOEXEC = 1030;
    public static final int FD_CLOEXEC = 1;
    public static final int F_RDLCK = 0;
    public static final int F_WRLCK = 1;
    public static final int F_UNLCK = 2;
    public static final int F_EXLCK = 4;
    public static final int F_SHLCK = 8;
    public static final int F_OWNER_TID = 0;
    public static final int F_OWNER_PID = 1;
    public static final int F_OWNER_PGRP = 2;
    public static final int LOCK_SH = 1;
    public static final int LOCK_EX = 2;
    public static final int LOCK_NB = 4;
    public static final int LOCK_UN = 8;
    public static final int LOCK_MAND = 32;
    public static final int LOCK_READ = 64;
    public static final int LOCK_WRITE = 128;
    public static final int LOCK_RW = 192;
    public static final int DN_ACCESS = 1;
    public static final int DN_MODIFY = 2;
    public static final int DN_CREATE = 4;
    public static final int DN_DELETE = 8;
    public static final int DN_RENAME = 16;
    public static final int DN_ATTRIB = 32;
    public static final int DN_MULTISHOT = Integer.MIN_VALUE;
    public static final int F_SEAL_SEAL = 1;
    public static final int F_SEAL_SHRINK = 2;
    public static final int F_SEAL_GROW = 4;
    public static final int F_SEAL_WRITE = 8;
    public static final int F_SEAL_FUTURE_WRITE = 16;
    public static final int RWH_WRITE_LIFE_NOT_SET = 0;
    public static final int RWH_WRITE_LIFE_NONE = 1;
    public static final int RWH_WRITE_LIFE_SHORT = 2;
    public static final int RWH_WRITE_LIFE_MEDIUM = 3;
    public static final int RWH_WRITE_LIFE_LONG = 4;
    public static final int RWH_WRITE_LIFE_EXTREME = 5;

    protected FCNTL() {
        throw new UnsupportedOperationException();
    }

    public static native int nopen(long var0, int var2, int var3);

    public static int open(@NativeType(value="char const *") ByteBuffer byteBuffer, int n2, @NativeType(value="mode_t") int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return FCNTL.nopen(MemoryUtil.memAddress(byteBuffer), n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int open(@NativeType(value="char const *") CharSequence charSequence, int n2, @NativeType(value="mode_t") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n5 = FCNTL.nopen(l2, n2, n3);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native int nopenat(int var0, long var1, int var3, int var4);

    public static int openat(int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, @NativeType(value="mode_t") int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return FCNTL.nopenat(n2, MemoryUtil.memAddress(byteBuffer), n3, n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int openat(int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, @NativeType(value="mode_t") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n6 = FCNTL.nopenat(n2, l2, n3, n4);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native int ncreat(long var0, int var2);

    public static int creat(@NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="mode_t") int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return FCNTL.ncreat(MemoryUtil.memAddress(byteBuffer), n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int creat(@NativeType(value="char const *") CharSequence charSequence, @NativeType(value="mode_t") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = FCNTL.ncreat(l2, n2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native int fcntl(int var0, int var1);

    public static native int nfcntli(int var0, int var1, int var2);

    public static int fcntli(int n2, int n3, int n4) {
        return FCNTL.nfcntli(n2, n3, n4);
    }

    public static native int nfcntlp(int var0, int var1, long var2);

    public static int fcntlp(int n2, int n3, @NativeType(value="void *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return FCNTL.nfcntlp(n2, n3, l2);
    }

    static {
        Library.initialize();
    }
}

