/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_sqe")
public class IOURingSQE
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int FLAGS;
    public static final int IOPRIO;
    public static final int FD;
    public static final int OFF;
    public static final int ADDR2;
    public static final int ADDR;
    public static final int SPLICE_OFF_IN;
    public static final int LEN;
    public static final int RW_FLAGS;
    public static final int FSYNC_FLAGS;
    public static final int POLL_EVENTS;
    public static final int POLL32_EVENTS;
    public static final int SYNC_RANGE_FLAGS;
    public static final int MSG_FLAGS;
    public static final int TIMEOUT_FLAGS;
    public static final int ACCEPT_FLAGS;
    public static final int CANCEL_FLAGS;
    public static final int OPEN_FLAGS;
    public static final int STATX_FLAGS;
    public static final int FADVISE_ADVICE;
    public static final int SPLICE_FLAGS;
    public static final int RENAME_FLAGS;
    public static final int UNLINK_FLAGS;
    public static final int HARDLINK_FLAGS;
    public static final int USER_DATA;
    public static final int BUF_INDEX;
    public static final int BUF_GROUP;
    public static final int PERSONALITY;
    public static final int SPLICE_FD_IN;
    public static final int FILE_INDEX;
    public static final int __PAD2;

    public IOURingSQE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingSQE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte opcode() {
        return IOURingSQE.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte flags() {
        return IOURingSQE.nflags(this.address());
    }

    @NativeType(value="__u16")
    public short ioprio() {
        return IOURingSQE.nioprio(this.address());
    }

    @NativeType(value="__s32")
    public int fd() {
        return IOURingSQE.nfd(this.address());
    }

    @NativeType(value="__u64")
    public long off() {
        return IOURingSQE.noff(this.address());
    }

    @NativeType(value="__u64")
    public long addr2() {
        return IOURingSQE.naddr2(this.address());
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingSQE.naddr(this.address());
    }

    @NativeType(value="__u64")
    public long splice_off_in() {
        return IOURingSQE.nsplice_off_in(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingSQE.nlen(this.address());
    }

    @NativeType(value="__kernel_rwf_t")
    public int rw_flags() {
        return IOURingSQE.nrw_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fsync_flags() {
        return IOURingSQE.nfsync_flags(this.address());
    }

    @NativeType(value="__u16")
    public short poll_events() {
        return IOURingSQE.npoll_events(this.address());
    }

    @NativeType(value="__u32")
    public int poll32_events() {
        return IOURingSQE.npoll32_events(this.address());
    }

    @NativeType(value="__u32")
    public int sync_range_flags() {
        return IOURingSQE.nsync_range_flags(this.address());
    }

    @NativeType(value="__u32")
    public int msg_flags() {
        return IOURingSQE.nmsg_flags(this.address());
    }

    @NativeType(value="__u32")
    public int timeout_flags() {
        return IOURingSQE.ntimeout_flags(this.address());
    }

    @NativeType(value="__u32")
    public int accept_flags() {
        return IOURingSQE.naccept_flags(this.address());
    }

    @NativeType(value="__u32")
    public int cancel_flags() {
        return IOURingSQE.ncancel_flags(this.address());
    }

    @NativeType(value="__u32")
    public int open_flags() {
        return IOURingSQE.nopen_flags(this.address());
    }

    @NativeType(value="__u32")
    public int statx_flags() {
        return IOURingSQE.nstatx_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fadvise_advice() {
        return IOURingSQE.nfadvise_advice(this.address());
    }

    @NativeType(value="__u32")
    public int splice_flags() {
        return IOURingSQE.nsplice_flags(this.address());
    }

    @NativeType(value="__u32")
    public int rename_flags() {
        return IOURingSQE.nrename_flags(this.address());
    }

    @NativeType(value="__u32")
    public int unlink_flags() {
        return IOURingSQE.nunlink_flags(this.address());
    }

    @NativeType(value="__u32")
    public int hardlink_flags() {
        return IOURingSQE.nhardlink_flags(this.address());
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingSQE.nuser_data(this.address());
    }

    @NativeType(value="__u16")
    public short buf_index() {
        return IOURingSQE.nbuf_index(this.address());
    }

    @NativeType(value="__u16")
    public short buf_group() {
        return IOURingSQE.nbuf_group(this.address());
    }

    @NativeType(value="__u16")
    public short personality() {
        return IOURingSQE.npersonality(this.address());
    }

    @NativeType(value="__s32")
    public int splice_fd_in() {
        return IOURingSQE.nsplice_fd_in(this.address());
    }

    @NativeType(value="__u32")
    public int file_index() {
        return IOURingSQE.nfile_index(this.address());
    }

    public IOURingSQE opcode(@NativeType(value="__u8") byte by2) {
        IOURingSQE.nopcode(this.address(), by2);
        return this;
    }

    public IOURingSQE flags(@NativeType(value="__u8") byte by2) {
        IOURingSQE.nflags(this.address(), by2);
        return this;
    }

    public IOURingSQE ioprio(@NativeType(value="__u16") short s2) {
        IOURingSQE.nioprio(this.address(), s2);
        return this;
    }

    public IOURingSQE fd(@NativeType(value="__s32") int n2) {
        IOURingSQE.nfd(this.address(), n2);
        return this;
    }

    public IOURingSQE off(@NativeType(value="__u64") long l2) {
        IOURingSQE.noff(this.address(), l2);
        return this;
    }

    public IOURingSQE addr2(@NativeType(value="__u64") long l2) {
        IOURingSQE.naddr2(this.address(), l2);
        return this;
    }

    public IOURingSQE addr(@NativeType(value="__u64") long l2) {
        IOURingSQE.naddr(this.address(), l2);
        return this;
    }

    public IOURingSQE splice_off_in(@NativeType(value="__u64") long l2) {
        IOURingSQE.nsplice_off_in(this.address(), l2);
        return this;
    }

    public IOURingSQE len(@NativeType(value="__u32") int n2) {
        IOURingSQE.nlen(this.address(), n2);
        return this;
    }

    public IOURingSQE rw_flags(@NativeType(value="__kernel_rwf_t") int n2) {
        IOURingSQE.nrw_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE fsync_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nfsync_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE poll_events(@NativeType(value="__u16") short s2) {
        IOURingSQE.npoll_events(this.address(), s2);
        return this;
    }

    public IOURingSQE poll32_events(@NativeType(value="__u32") int n2) {
        IOURingSQE.npoll32_events(this.address(), n2);
        return this;
    }

    public IOURingSQE sync_range_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nsync_range_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE msg_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nmsg_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE timeout_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.ntimeout_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE accept_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.naccept_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE cancel_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.ncancel_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE open_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nopen_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE statx_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nstatx_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE fadvise_advice(@NativeType(value="__u32") int n2) {
        IOURingSQE.nfadvise_advice(this.address(), n2);
        return this;
    }

    public IOURingSQE splice_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nsplice_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE rename_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nrename_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE unlink_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nunlink_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE hardlink_flags(@NativeType(value="__u32") int n2) {
        IOURingSQE.nhardlink_flags(this.address(), n2);
        return this;
    }

    public IOURingSQE user_data(@NativeType(value="__u64") long l2) {
        IOURingSQE.nuser_data(this.address(), l2);
        return this;
    }

    public IOURingSQE buf_index(@NativeType(value="__u16") short s2) {
        IOURingSQE.nbuf_index(this.address(), s2);
        return this;
    }

    public IOURingSQE buf_group(@NativeType(value="__u16") short s2) {
        IOURingSQE.nbuf_group(this.address(), s2);
        return this;
    }

    public IOURingSQE personality(@NativeType(value="__u16") short s2) {
        IOURingSQE.npersonality(this.address(), s2);
        return this;
    }

    public IOURingSQE splice_fd_in(@NativeType(value="__s32") int n2) {
        IOURingSQE.nsplice_fd_in(this.address(), n2);
        return this;
    }

    public IOURingSQE file_index(@NativeType(value="__u32") int n2) {
        IOURingSQE.nfile_index(this.address(), n2);
        return this;
    }

    public IOURingSQE set(IOURingSQE iOURingSQE) {
        MemoryUtil.memCopy(iOURingSQE.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQE malloc() {
        return IOURingSQE.wrap(IOURingSQE.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static IOURingSQE calloc() {
        return IOURingSQE.wrap(IOURingSQE.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static IOURingSQE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return IOURingSQE.wrap(IOURingSQE.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingSQE create(long l2) {
        return IOURingSQE.wrap(IOURingSQE.class, l2);
    }

    @Nullable
    public static IOURingSQE createSafe(long l2) {
        return l2 == 0L ? null : IOURingSQE.wrap(IOURingSQE.class, l2);
    }

    public static Buffer malloc(int n2) {
        return IOURingSQE.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(IOURingSQE.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return IOURingSQE.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = IOURingSQE.__create(n2, SIZEOF);
        return IOURingSQE.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return IOURingSQE.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : IOURingSQE.wrap(Buffer.class, l2, n2);
    }

    public static IOURingSQE malloc(MemoryStack memoryStack) {
        return IOURingSQE.wrap(IOURingSQE.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static IOURingSQE calloc(MemoryStack memoryStack) {
        return IOURingSQE.wrap(IOURingSQE.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return IOURingSQE.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return IOURingSQE.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static byte nopcode(long l2) {
        return UNSAFE.getByte(null, l2 + (long)OPCODE);
    }

    public static byte nflags(long l2) {
        return UNSAFE.getByte(null, l2 + (long)FLAGS);
    }

    public static short nioprio(long l2) {
        return UNSAFE.getShort(null, l2 + (long)IOPRIO);
    }

    public static int nfd(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FD);
    }

    public static long noff(long l2) {
        return UNSAFE.getLong(null, l2 + (long)OFF);
    }

    public static long naddr2(long l2) {
        return UNSAFE.getLong(null, l2 + (long)ADDR2);
    }

    public static long naddr(long l2) {
        return UNSAFE.getLong(null, l2 + (long)ADDR);
    }

    public static long nsplice_off_in(long l2) {
        return UNSAFE.getLong(null, l2 + (long)SPLICE_OFF_IN);
    }

    public static int nlen(long l2) {
        return UNSAFE.getInt(null, l2 + (long)LEN);
    }

    public static int nrw_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RW_FLAGS);
    }

    public static int nfsync_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FSYNC_FLAGS);
    }

    public static short npoll_events(long l2) {
        return UNSAFE.getShort(null, l2 + (long)POLL_EVENTS);
    }

    public static int npoll32_events(long l2) {
        return UNSAFE.getInt(null, l2 + (long)POLL32_EVENTS);
    }

    public static int nsync_range_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SYNC_RANGE_FLAGS);
    }

    public static int nmsg_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MSG_FLAGS);
    }

    public static int ntimeout_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TIMEOUT_FLAGS);
    }

    public static int naccept_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ACCEPT_FLAGS);
    }

    public static int ncancel_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CANCEL_FLAGS);
    }

    public static int nopen_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OPEN_FLAGS);
    }

    public static int nstatx_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STATX_FLAGS);
    }

    public static int nfadvise_advice(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FADVISE_ADVICE);
    }

    public static int nsplice_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SPLICE_FLAGS);
    }

    public static int nrename_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)RENAME_FLAGS);
    }

    public static int nunlink_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)UNLINK_FLAGS);
    }

    public static int nhardlink_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HARDLINK_FLAGS);
    }

    public static long nuser_data(long l2) {
        return UNSAFE.getLong(null, l2 + (long)USER_DATA);
    }

    public static short nbuf_index(long l2) {
        return UNSAFE.getShort(null, l2 + (long)BUF_INDEX);
    }

    public static short nbuf_group(long l2) {
        return UNSAFE.getShort(null, l2 + (long)BUF_GROUP);
    }

    public static short npersonality(long l2) {
        return UNSAFE.getShort(null, l2 + (long)PERSONALITY);
    }

    public static int nsplice_fd_in(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SPLICE_FD_IN);
    }

    public static int nfile_index(long l2) {
        return UNSAFE.getInt(null, l2 + (long)FILE_INDEX);
    }

    public static LongBuffer n__pad2(long l2) {
        return MemoryUtil.memLongBuffer(l2 + (long)__PAD2, 2);
    }

    public static long n__pad2(long l2, int n2) {
        return UNSAFE.getLong(null, l2 + (long)__PAD2 + Checks.check(n2, 2) * 8L);
    }

    public static void nopcode(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)OPCODE, by2);
    }

    public static void nflags(long l2, byte by2) {
        UNSAFE.putByte(null, l2 + (long)FLAGS, by2);
    }

    public static void nioprio(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)IOPRIO, s2);
    }

    public static void nfd(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FD, n2);
    }

    public static void noff(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)OFF, l3);
    }

    public static void naddr2(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)ADDR2, l3);
    }

    public static void naddr(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)ADDR, l3);
    }

    public static void nsplice_off_in(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)SPLICE_OFF_IN, l3);
    }

    public static void nlen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)LEN, n2);
    }

    public static void nrw_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RW_FLAGS, n2);
    }

    public static void nfsync_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FSYNC_FLAGS, n2);
    }

    public static void npoll_events(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)POLL_EVENTS, s2);
    }

    public static void npoll32_events(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)POLL32_EVENTS, n2);
    }

    public static void nsync_range_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SYNC_RANGE_FLAGS, n2);
    }

    public static void nmsg_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MSG_FLAGS, n2);
    }

    public static void ntimeout_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TIMEOUT_FLAGS, n2);
    }

    public static void naccept_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)ACCEPT_FLAGS, n2);
    }

    public static void ncancel_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CANCEL_FLAGS, n2);
    }

    public static void nopen_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)OPEN_FLAGS, n2);
    }

    public static void nstatx_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)STATX_FLAGS, n2);
    }

    public static void nfadvise_advice(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FADVISE_ADVICE, n2);
    }

    public static void nsplice_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SPLICE_FLAGS, n2);
    }

    public static void nrename_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)RENAME_FLAGS, n2);
    }

    public static void nunlink_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)UNLINK_FLAGS, n2);
    }

    public static void nhardlink_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)HARDLINK_FLAGS, n2);
    }

    public static void nuser_data(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)USER_DATA, l3);
    }

    public static void nbuf_index(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)BUF_INDEX, s2);
    }

    public static void nbuf_group(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)BUF_GROUP, s2);
    }

    public static void npersonality(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)PERSONALITY, s2);
    }

    public static void nsplice_fd_in(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)SPLICE_FD_IN, n2);
    }

    public static void nfile_index(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)FILE_INDEX, n2);
    }

    public static void n__pad2(long l2, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l2 + (long)__PAD2, longBuffer.remaining() * 8);
    }

    public static void n__pad2(long l2, int n2, long l3) {
        UNSAFE.putLong(null, l2 + (long)__PAD2 + Checks.check(n2, 2) * 8L, l3);
    }

    static {
        Struct.Layout layout = IOURingSQE.__struct(IOURingSQE.__member(1), IOURingSQE.__member(1), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8)), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8)), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4)), IOURingSQE.__member(8), IOURingSQE.__union(IOURingSQE.__member(2), IOURingSQE.__member(2)), IOURingSQE.__member(2), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4)), IOURingSQE.__array(8, 2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OPCODE = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        IOPRIO = layout.offsetof(2);
        FD = layout.offsetof(3);
        OFF = layout.offsetof(5);
        ADDR2 = layout.offsetof(6);
        ADDR = layout.offsetof(8);
        SPLICE_OFF_IN = layout.offsetof(9);
        LEN = layout.offsetof(10);
        RW_FLAGS = layout.offsetof(12);
        FSYNC_FLAGS = layout.offsetof(13);
        POLL_EVENTS = layout.offsetof(14);
        POLL32_EVENTS = layout.offsetof(15);
        SYNC_RANGE_FLAGS = layout.offsetof(16);
        MSG_FLAGS = layout.offsetof(17);
        TIMEOUT_FLAGS = layout.offsetof(18);
        ACCEPT_FLAGS = layout.offsetof(19);
        CANCEL_FLAGS = layout.offsetof(20);
        OPEN_FLAGS = layout.offsetof(21);
        STATX_FLAGS = layout.offsetof(22);
        FADVISE_ADVICE = layout.offsetof(23);
        SPLICE_FLAGS = layout.offsetof(24);
        RENAME_FLAGS = layout.offsetof(25);
        UNLINK_FLAGS = layout.offsetof(26);
        HARDLINK_FLAGS = layout.offsetof(27);
        USER_DATA = layout.offsetof(28);
        BUF_INDEX = layout.offsetof(30);
        BUF_GROUP = layout.offsetof(31);
        PERSONALITY = layout.offsetof(32);
        SPLICE_FD_IN = layout.offsetof(34);
        FILE_INDEX = layout.offsetof(35);
        __PAD2 = layout.offsetof(36);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQE, Buffer>
    implements NativeResource {
        private static final IOURingSQE ELEMENT_FACTORY = IOURingSQE.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l2, int n2) {
            super(l2, null, -1, 0, n2, n2);
        }

        Buffer(long l2, @Nullable ByteBuffer byteBuffer, int n2, int n3, int n4, int n5) {
            super(l2, byteBuffer, n2, n3, n4, n5);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected IOURingSQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte opcode() {
            return IOURingSQE.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte flags() {
            return IOURingSQE.nflags(this.address());
        }

        @NativeType(value="__u16")
        public short ioprio() {
            return IOURingSQE.nioprio(this.address());
        }

        @NativeType(value="__s32")
        public int fd() {
            return IOURingSQE.nfd(this.address());
        }

        @NativeType(value="__u64")
        public long off() {
            return IOURingSQE.noff(this.address());
        }

        @NativeType(value="__u64")
        public long addr2() {
            return IOURingSQE.naddr2(this.address());
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingSQE.naddr(this.address());
        }

        @NativeType(value="__u64")
        public long splice_off_in() {
            return IOURingSQE.nsplice_off_in(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingSQE.nlen(this.address());
        }

        @NativeType(value="__kernel_rwf_t")
        public int rw_flags() {
            return IOURingSQE.nrw_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fsync_flags() {
            return IOURingSQE.nfsync_flags(this.address());
        }

        @NativeType(value="__u16")
        public short poll_events() {
            return IOURingSQE.npoll_events(this.address());
        }

        @NativeType(value="__u32")
        public int poll32_events() {
            return IOURingSQE.npoll32_events(this.address());
        }

        @NativeType(value="__u32")
        public int sync_range_flags() {
            return IOURingSQE.nsync_range_flags(this.address());
        }

        @NativeType(value="__u32")
        public int msg_flags() {
            return IOURingSQE.nmsg_flags(this.address());
        }

        @NativeType(value="__u32")
        public int timeout_flags() {
            return IOURingSQE.ntimeout_flags(this.address());
        }

        @NativeType(value="__u32")
        public int accept_flags() {
            return IOURingSQE.naccept_flags(this.address());
        }

        @NativeType(value="__u32")
        public int cancel_flags() {
            return IOURingSQE.ncancel_flags(this.address());
        }

        @NativeType(value="__u32")
        public int open_flags() {
            return IOURingSQE.nopen_flags(this.address());
        }

        @NativeType(value="__u32")
        public int statx_flags() {
            return IOURingSQE.nstatx_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fadvise_advice() {
            return IOURingSQE.nfadvise_advice(this.address());
        }

        @NativeType(value="__u32")
        public int splice_flags() {
            return IOURingSQE.nsplice_flags(this.address());
        }

        @NativeType(value="__u32")
        public int rename_flags() {
            return IOURingSQE.nrename_flags(this.address());
        }

        @NativeType(value="__u32")
        public int unlink_flags() {
            return IOURingSQE.nunlink_flags(this.address());
        }

        @NativeType(value="__u32")
        public int hardlink_flags() {
            return IOURingSQE.nhardlink_flags(this.address());
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingSQE.nuser_data(this.address());
        }

        @NativeType(value="__u16")
        public short buf_index() {
            return IOURingSQE.nbuf_index(this.address());
        }

        @NativeType(value="__u16")
        public short buf_group() {
            return IOURingSQE.nbuf_group(this.address());
        }

        @NativeType(value="__u16")
        public short personality() {
            return IOURingSQE.npersonality(this.address());
        }

        @NativeType(value="__s32")
        public int splice_fd_in() {
            return IOURingSQE.nsplice_fd_in(this.address());
        }

        @NativeType(value="__u32")
        public int file_index() {
            return IOURingSQE.nfile_index(this.address());
        }

        public Buffer opcode(@NativeType(value="__u8") byte by2) {
            IOURingSQE.nopcode(this.address(), by2);
            return this;
        }

        public Buffer flags(@NativeType(value="__u8") byte by2) {
            IOURingSQE.nflags(this.address(), by2);
            return this;
        }

        public Buffer ioprio(@NativeType(value="__u16") short s2) {
            IOURingSQE.nioprio(this.address(), s2);
            return this;
        }

        public Buffer fd(@NativeType(value="__s32") int n2) {
            IOURingSQE.nfd(this.address(), n2);
            return this;
        }

        public Buffer off(@NativeType(value="__u64") long l2) {
            IOURingSQE.noff(this.address(), l2);
            return this;
        }

        public Buffer addr2(@NativeType(value="__u64") long l2) {
            IOURingSQE.naddr2(this.address(), l2);
            return this;
        }

        public Buffer addr(@NativeType(value="__u64") long l2) {
            IOURingSQE.naddr(this.address(), l2);
            return this;
        }

        public Buffer splice_off_in(@NativeType(value="__u64") long l2) {
            IOURingSQE.nsplice_off_in(this.address(), l2);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int n2) {
            IOURingSQE.nlen(this.address(), n2);
            return this;
        }

        public Buffer rw_flags(@NativeType(value="__kernel_rwf_t") int n2) {
            IOURingSQE.nrw_flags(this.address(), n2);
            return this;
        }

        public Buffer fsync_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nfsync_flags(this.address(), n2);
            return this;
        }

        public Buffer poll_events(@NativeType(value="__u16") short s2) {
            IOURingSQE.npoll_events(this.address(), s2);
            return this;
        }

        public Buffer poll32_events(@NativeType(value="__u32") int n2) {
            IOURingSQE.npoll32_events(this.address(), n2);
            return this;
        }

        public Buffer sync_range_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nsync_range_flags(this.address(), n2);
            return this;
        }

        public Buffer msg_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nmsg_flags(this.address(), n2);
            return this;
        }

        public Buffer timeout_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.ntimeout_flags(this.address(), n2);
            return this;
        }

        public Buffer accept_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.naccept_flags(this.address(), n2);
            return this;
        }

        public Buffer cancel_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.ncancel_flags(this.address(), n2);
            return this;
        }

        public Buffer open_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nopen_flags(this.address(), n2);
            return this;
        }

        public Buffer statx_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nstatx_flags(this.address(), n2);
            return this;
        }

        public Buffer fadvise_advice(@NativeType(value="__u32") int n2) {
            IOURingSQE.nfadvise_advice(this.address(), n2);
            return this;
        }

        public Buffer splice_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nsplice_flags(this.address(), n2);
            return this;
        }

        public Buffer rename_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nrename_flags(this.address(), n2);
            return this;
        }

        public Buffer unlink_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nunlink_flags(this.address(), n2);
            return this;
        }

        public Buffer hardlink_flags(@NativeType(value="__u32") int n2) {
            IOURingSQE.nhardlink_flags(this.address(), n2);
            return this;
        }

        public Buffer user_data(@NativeType(value="__u64") long l2) {
            IOURingSQE.nuser_data(this.address(), l2);
            return this;
        }

        public Buffer buf_index(@NativeType(value="__u16") short s2) {
            IOURingSQE.nbuf_index(this.address(), s2);
            return this;
        }

        public Buffer buf_group(@NativeType(value="__u16") short s2) {
            IOURingSQE.nbuf_group(this.address(), s2);
            return this;
        }

        public Buffer personality(@NativeType(value="__u16") short s2) {
            IOURingSQE.npersonality(this.address(), s2);
            return this;
        }

        public Buffer splice_fd_in(@NativeType(value="__s32") int n2) {
            IOURingSQE.nsplice_fd_in(this.address(), n2);
            return this;
        }

        public Buffer file_index(@NativeType(value="__u32") int n2) {
            IOURingSQE.nfile_index(this.address(), n2);
            return this;
        }
    }
}

