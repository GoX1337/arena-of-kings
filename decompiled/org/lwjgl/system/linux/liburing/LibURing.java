/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.EpollEvent;
import org.lwjgl.system.linux.IOVec;
import org.lwjgl.system.linux.KernelTimespec;
import org.lwjgl.system.linux.Msghdr;
import org.lwjgl.system.linux.OpenHow;
import org.lwjgl.system.linux.Sockaddr;
import org.lwjgl.system.linux.Statx;
import org.lwjgl.system.linux.liburing.IOURing;
import org.lwjgl.system.linux.liburing.IOURingCQE;
import org.lwjgl.system.linux.liburing.IOURingParams;
import org.lwjgl.system.linux.liburing.IOURingProbe;
import org.lwjgl.system.linux.liburing.IOURingRestriction;
import org.lwjgl.system.linux.liburing.IOURingSQE;

public class LibURing {
    public static final long LIBURING_UDATA_TIMEOUT = -1L;

    protected LibURing() {
        throw new UnsupportedOperationException();
    }

    public static native long nio_uring_get_probe_ring(long var0);

    @Nullable
    @NativeType(value="struct io_uring_probe *")
    public static IOURingProbe io_uring_get_probe_ring(@NativeType(value="struct io_uring *") IOURing iOURing) {
        long l2 = LibURing.nio_uring_get_probe_ring(iOURing.address());
        return IOURingProbe.createSafe(l2);
    }

    public static native long nio_uring_get_probe();

    @Nullable
    @NativeType(value="struct io_uring_probe *")
    public static IOURingProbe io_uring_get_probe() {
        long l2 = LibURing.nio_uring_get_probe();
        return IOURingProbe.createSafe(l2);
    }

    public static native void nio_uring_free_probe(long var0);

    public static void io_uring_free_probe(@NativeType(value="struct io_uring_probe *") IOURingProbe iOURingProbe) {
        LibURing.nio_uring_free_probe(iOURingProbe.address());
    }

    public static native int nio_uring_opcode_supported(long var0, int var2);

    public static int io_uring_opcode_supported(@NativeType(value="struct io_uring_probe const *") IOURingProbe iOURingProbe, int n2) {
        return LibURing.nio_uring_opcode_supported(iOURingProbe.address(), n2);
    }

    public static native int nio_uring_queue_init_params(int var0, long var1, long var3);

    public static int io_uring_queue_init_params(@NativeType(value="unsigned") int n2, @NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams) {
        return LibURing.nio_uring_queue_init_params(n2, iOURing.address(), iOURingParams.address());
    }

    public static native int nio_uring_queue_init(int var0, long var1, int var3);

    public static int io_uring_queue_init(@NativeType(value="unsigned") int n2, @NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n3) {
        return LibURing.nio_uring_queue_init(n2, iOURing.address(), n3);
    }

    public static native int nio_uring_queue_mmap(int var0, long var1, long var3);

    public static int io_uring_queue_mmap(int n2, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams, @NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_queue_mmap(n2, iOURingParams.address(), iOURing.address());
    }

    public static native int nio_uring_ring_dontfork(long var0);

    public static int io_uring_ring_dontfork(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_ring_dontfork(iOURing.address());
    }

    public static native void nio_uring_queue_exit(long var0);

    public static void io_uring_queue_exit(@NativeType(value="struct io_uring *") IOURing iOURing) {
        LibURing.nio_uring_queue_exit(iOURing.address());
    }

    public static native int nio_uring_peek_batch_cqe(long var0, long var2, int var4);

    @NativeType(value="unsigned")
    public static int io_uring_peek_batch_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        return LibURing.nio_uring_peek_batch_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining());
    }

    public static native int nio_uring_wait_cqes(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_wait_cqes(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="sigset_t *") long l2) {
        return LibURing.nio_uring_wait_cqes(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), l2);
    }

    public static native int nio_uring_wait_cqe_timeout(long var0, long var2, long var4);

    public static int io_uring_wait_cqe_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_wait_cqe_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddressSafe(kernelTimespec));
    }

    public static native int nio_uring_submit(long var0);

    public static int io_uring_submit(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_submit(iOURing.address());
    }

    public static native int nio_uring_submit_and_wait(long var0, int var2);

    public static int io_uring_submit_and_wait(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2) {
        return LibURing.nio_uring_submit_and_wait(iOURing.address(), n2);
    }

    public static native int nio_uring_submit_and_wait_timeout(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_submit_and_wait_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="sigset_t *") long l2) {
        return LibURing.nio_uring_submit_and_wait_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), l2);
    }

    public static native long nio_uring_get_sqe(long var0);

    @Nullable
    @NativeType(value="struct io_uring_sqe *")
    public static IOURingSQE io_uring_get_sqe(@NativeType(value="struct io_uring *") IOURing iOURing) {
        long l2 = LibURing.nio_uring_get_sqe(iOURing.address());
        return IOURingSQE.createSafe(l2);
    }

    public static native int nio_uring_register_buffers(long var0, long var2, int var4);

    public static int io_uring_register_buffers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct iovec const *") IOVec.Buffer buffer) {
        return LibURing.nio_uring_register_buffers(iOURing.address(), buffer.address(), buffer.remaining());
    }

    public static native int nio_uring_register_buffers_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_buffers_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_tags(iOURing.address(), buffer.address(), MemoryUtil.memAddress(longBuffer), buffer.remaining());
    }

    public static native int nio_uring_register_buffers_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_buffers_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_update_tag(iOURing.address(), n2, buffer.address(), MemoryUtil.memAddress(longBuffer), buffer.remaining());
    }

    public static native int nio_uring_unregister_buffers(long var0);

    public static int io_uring_unregister_buffers(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_buffers(iOURing.address());
    }

    public static native int nio_uring_register_files(long var0, long var2, int var4);

    public static int io_uring_register_files(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") IntBuffer intBuffer) {
        return LibURing.nio_uring_register_files(iOURing.address(), MemoryUtil.memAddress(intBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_files_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_files_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") IntBuffer intBuffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        return LibURing.nio_uring_register_files_tags(iOURing.address(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_files_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_files_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="int const *") IntBuffer intBuffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        return LibURing.nio_uring_register_files_update_tag(iOURing.address(), n2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_unregister_files(long var0);

    public static int io_uring_unregister_files(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_files(iOURing.address());
    }

    public static native int nio_uring_register_files_update(long var0, int var2, long var3, int var5);

    public static int io_uring_register_files_update(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        return LibURing.nio_uring_register_files_update(iOURing.address(), n2, MemoryUtil.memAddress(intBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_eventfd(long var0, int var2);

    public static int io_uring_register_eventfd(@NativeType(value="struct io_uring *") IOURing iOURing, int n2) {
        return LibURing.nio_uring_register_eventfd(iOURing.address(), n2);
    }

    public static native int nio_uring_register_eventfd_async(long var0, int var2);

    public static int io_uring_register_eventfd_async(@NativeType(value="struct io_uring *") IOURing iOURing, int n2) {
        return LibURing.nio_uring_register_eventfd_async(iOURing.address(), n2);
    }

    public static native int nio_uring_unregister_eventfd(long var0);

    public static int io_uring_unregister_eventfd(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_eventfd(iOURing.address());
    }

    public static native int nio_uring_register_probe(long var0, long var2, int var4);

    public static int io_uring_register_probe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_probe *") IOURingProbe iOURingProbe, @NativeType(value="unsigned") int n2) {
        return LibURing.nio_uring_register_probe(iOURing.address(), iOURingProbe.address(), n2);
    }

    public static native int nio_uring_register_personality(long var0);

    public static int io_uring_register_personality(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_register_personality(iOURing.address());
    }

    public static native int nio_uring_unregister_personality(long var0, int var2);

    public static int io_uring_unregister_personality(@NativeType(value="struct io_uring *") IOURing iOURing, int n2) {
        return LibURing.nio_uring_unregister_personality(iOURing.address(), n2);
    }

    public static native int nio_uring_register_restrictions(long var0, long var2, int var4);

    public static int io_uring_register_restrictions(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_restriction *") IOURingRestriction.Buffer buffer) {
        return LibURing.nio_uring_register_restrictions(iOURing.address(), buffer.address(), buffer.remaining());
    }

    public static native int nio_uring_enable_rings(long var0);

    public static int io_uring_enable_rings(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_enable_rings(iOURing.address());
    }

    public static native int n__io_uring_sqring_wait(long var0);

    public static int __io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.n__io_uring_sqring_wait(iOURing.address());
    }

    public static native int nio_uring_register_iowq_aff(long var0, long var2, long var4);

    public static int io_uring_register_iowq_aff(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="size_t") long l2, @NativeType(value="cpu_set_t const *") long l3) {
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return LibURing.nio_uring_register_iowq_aff(iOURing.address(), l2, l3);
    }

    public static native int nio_uring_unregister_iowq_aff(long var0);

    public static int io_uring_unregister_iowq_aff(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_iowq_aff(iOURing.address());
    }

    public static native int nio_uring_register_iowq_max_workers(long var0, long var2);

    public static int io_uring_register_iowq_max_workers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 2);
        }
        return LibURing.nio_uring_register_iowq_max_workers(iOURing.address(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nio_uring_cqe_seen(long var0, long var2);

    public static void io_uring_cqe_seen(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
        LibURing.nio_uring_cqe_seen(iOURing.address(), iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_data(long var0, long var2);

    public static void io_uring_sqe_set_data(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        LibURing.nio_uring_sqe_set_data(iOURingSQE.address(), l2);
    }

    public static native long nio_uring_cqe_get_data(long var0);

    @NativeType(value="void *")
    public static long io_uring_cqe_get_data(@NativeType(value="struct io_uring_cqe const *") IOURingCQE iOURingCQE) {
        return LibURing.nio_uring_cqe_get_data(iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_data64(long var0, long var2);

    public static void io_uring_sqe_set_data64(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l2) {
        LibURing.nio_uring_sqe_set_data64(iOURingSQE.address(), l2);
    }

    public static native long nio_uring_cqe_get_data64(long var0);

    @NativeType(value="__u64")
    public static long io_uring_cqe_get_data64(@NativeType(value="struct io_uring_cqe const *") IOURingCQE iOURingCQE) {
        return LibURing.nio_uring_cqe_get_data64(iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_flags(long var0, int var2);

    public static void io_uring_sqe_set_flags(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_sqe_set_flags(iOURingSQE.address(), n2);
    }

    public static native void nio_uring_prep_splice(long var0, int var2, long var3, int var5, long var6, int var8, int var9);

    public static void io_uring_prep_splice(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="int64_t") long l2, int n3, @NativeType(value="int64_t") long l3, @NativeType(value="unsigned int") int n4, @NativeType(value="unsigned int") int n5) {
        LibURing.nio_uring_prep_splice(iOURingSQE.address(), n2, l2, n3, l3, n4, n5);
    }

    public static native void nio_uring_prep_tee(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_tee(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="unsigned int") int n5) {
        LibURing.nio_uring_prep_tee(iOURingSQE.address(), n2, n3, n4, n5);
    }

    public static native void nio_uring_prep_readv(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_readv(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n3) {
        LibURing.nio_uring_prep_readv(iOURingSQE.address(), n2, buffer.address(), buffer.remaining(), n3);
    }

    public static native void nio_uring_prep_readv2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_readv2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n3, int n4) {
        LibURing.nio_uring_prep_readv2(iOURingSQE.address(), n2, buffer.address(), buffer.remaining(), n3, n4);
    }

    public static native void nio_uring_prep_read_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_read_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void *") ByteBuffer byteBuffer, int n3, int n4) {
        LibURing.nio_uring_prep_read_fixed(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3, n4);
    }

    public static native void nio_uring_prep_writev(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_writev(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n3) {
        LibURing.nio_uring_prep_writev(iOURingSQE.address(), n2, buffer.address(), buffer.remaining(), n3);
    }

    public static native void nio_uring_prep_writev2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_writev2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n3, int n4) {
        LibURing.nio_uring_prep_writev2(iOURingSQE.address(), n2, buffer.address(), buffer.remaining(), n3, n4);
    }

    public static native void nio_uring_prep_write_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_write_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, int n3, int n4) {
        LibURing.nio_uring_prep_write_fixed(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3, n4);
    }

    public static native void nio_uring_prep_recvmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_recvmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct msghdr *") Msghdr msghdr, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_recvmsg(iOURingSQE.address(), n2, msghdr.address(), n3);
    }

    public static native void nio_uring_prep_sendmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_sendmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct msghdr const *") Msghdr msghdr, @NativeType(value="unsigned int") int n3) {
        if (Checks.CHECKS) {
            Msghdr.validate(msghdr.address());
        }
        LibURing.nio_uring_prep_sendmsg(iOURingSQE.address(), n2, msghdr.address(), n3);
    }

    public static native void nio_uring_prep_poll_add(long var0, int var2, int var3);

    public static void io_uring_prep_poll_add(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_poll_add(iOURingSQE.address(), n2, n3);
    }

    public static native void nio_uring_prep_poll_multishot(long var0, int var2, int var3);

    public static void io_uring_prep_poll_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_poll_multishot(iOURingSQE.address(), n2, n3);
    }

    public static native void nio_uring_prep_poll_remove(long var0, long var2);

    public static void io_uring_prep_poll_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l2) {
        LibURing.nio_uring_prep_poll_remove(iOURingSQE.address(), l2);
    }

    public static native void nio_uring_prep_poll_update(long var0, long var2, long var4, int var6, int var7);

    public static void io_uring_prep_poll_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l2, @NativeType(value="__u64") long l3, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_poll_update(iOURingSQE.address(), l2, l3, n2, n3);
    }

    public static native void nio_uring_prep_fsync(long var0, int var2, int var3);

    public static void io_uring_prep_fsync(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_fsync(iOURingSQE.address(), n2, n3);
    }

    public static native void nio_uring_prep_nop(long var0);

    public static void io_uring_prep_nop(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
        LibURing.nio_uring_prep_nop(iOURingSQE.address());
    }

    public static native void nio_uring_prep_timeout(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_timeout(iOURingSQE.address(), kernelTimespec.address(), n2, n3);
    }

    public static native void nio_uring_prep_timeout_remove(long var0, long var2, int var4);

    public static void io_uring_prep_timeout_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l2, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_timeout_remove(iOURingSQE.address(), l2, n2);
    }

    public static native void nio_uring_prep_timeout_update(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_timeout_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="__u64") long l2, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_timeout_update(iOURingSQE.address(), kernelTimespec.address(), l2, n2);
    }

    public static native void nio_uring_prep_accept(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_accept(iOURingSQE.address(), n2, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n3);
    }

    public static native void nio_uring_prep_accept_direct(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n3, @NativeType(value="unsigned int") int n4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_accept_direct(iOURingSQE.address(), n2, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n3, n4);
    }

    public static native void nio_uring_prep_cancel(long var0, long var2, int var4);

    public static void io_uring_prep_cancel(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l2, int n2) {
        LibURing.nio_uring_prep_cancel(iOURingSQE.address(), l2, n2);
    }

    public static native void nio_uring_prep_link_timeout(long var0, long var2, int var4);

    public static void io_uring_prep_link_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_link_timeout(iOURingSQE.address(), kernelTimespec.address(), n2);
    }

    public static native void nio_uring_prep_connect(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_connect(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct sockaddr const *") Sockaddr sockaddr, @NativeType(value="socklen_t") int n3) {
        LibURing.nio_uring_prep_connect(iOURingSQE.address(), n2, sockaddr.address(), n3);
    }

    public static native void nio_uring_prep_files_update(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_files_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="int *") IntBuffer intBuffer, int n2) {
        LibURing.nio_uring_prep_files_update(iOURingSQE.address(), MemoryUtil.memAddress(intBuffer), intBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_fallocate(long var0, int var2, int var3, long var4, long var6);

    public static void io_uring_prep_fallocate(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3, @NativeType(value="off_t") long l2, @NativeType(value="off_t") long l3) {
        LibURing.nio_uring_prep_fallocate(iOURingSQE.address(), n2, n3, l2, l3);
    }

    public static native void nio_uring_prep_openat(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3, n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat(iOURingSQE.address(), n2, l2, n3, n4);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nio_uring_prep_openat_direct(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, int n4, @NativeType(value="unsigned int") int n5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat_direct(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, int n4, @NativeType(value="unsigned int") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat_direct(iOURingSQE.address(), n2, l2, n3, n4, n5);
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nio_uring_prep_close(long var0, int var2);

    public static void io_uring_prep_close(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2) {
        LibURing.nio_uring_prep_close(iOURingSQE.address(), n2);
    }

    public static native void nio_uring_prep_close_direct(long var0, int var2);

    public static void io_uring_prep_close_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_close_direct(iOURingSQE.address(), n2);
    }

    public static native void nio_uring_prep_read(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_read(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void *") ByteBuffer byteBuffer, int n3) {
        LibURing.nio_uring_prep_read(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3);
    }

    public static native void nio_uring_prep_write(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_write(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, int n3) {
        LibURing.nio_uring_prep_write(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3);
    }

    public static native void nio_uring_prep_statx(long var0, int var2, long var3, int var5, int var6, long var7);

    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="struct statx *") Statx statx) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_statx(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3, n4, statx.address());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="struct statx *") Statx statx) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_statx(iOURingSQE.address(), n2, l2, n3, n4, statx.address());
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nio_uring_prep_fadvise(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_fadvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3, @NativeType(value="off_t") long l2, int n4) {
        LibURing.nio_uring_prep_fadvise(iOURingSQE.address(), n2, n3, l2, n4);
    }

    public static native void nio_uring_prep_madvise(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_madvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_madvise(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_send(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_send(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, int n3) {
        LibURing.nio_uring_prep_send(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3);
    }

    public static native void nio_uring_prep_recv(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_recv(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="void *") ByteBuffer byteBuffer, int n3) {
        LibURing.nio_uring_prep_recv(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n3);
    }

    public static native void nio_uring_prep_openat2(long var0, int var2, long var3, long var5);

    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct open_how *") OpenHow openHow) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat2(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), openHow.address());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct open_how *") OpenHow openHow) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat2(iOURingSQE.address(), n2, l2, openHow.address());
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_openat2_direct(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct open_how *") OpenHow openHow, @NativeType(value="unsigned int") int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat2_direct(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), openHow.address(), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct open_how *") OpenHow openHow, @NativeType(value="unsigned int") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat2_direct(iOURingSQE.address(), n2, l2, openHow.address(), n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_epoll_ctl(long var0, int var2, int var3, int var4, long var5);

    public static void io_uring_prep_epoll_ctl(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3, int n4, @NativeType(value="struct epoll_event *") EpollEvent epollEvent) {
        LibURing.nio_uring_prep_epoll_ctl(iOURingSQE.address(), n2, n3, n4, epollEvent.address());
    }

    public static native void nio_uring_prep_provide_buffers(long var0, long var2, int var4, int var5, int var6, int var7);

    public static void io_uring_prep_provide_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") ByteBuffer byteBuffer, int n2, int n3, int n4) {
        LibURing.nio_uring_prep_provide_buffers(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, n3, n4);
    }

    public static native void nio_uring_prep_remove_buffers(long var0, int var2, int var3);

    public static void io_uring_prep_remove_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3) {
        LibURing.nio_uring_prep_remove_buffers(iOURingSQE.address(), n2, n3);
    }

    public static native void nio_uring_prep_shutdown(long var0, int var2, int var3);

    public static void io_uring_prep_shutdown(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, int n3) {
        LibURing.nio_uring_prep_shutdown(iOURingSQE.address(), n2, n3);
    }

    public static native void nio_uring_prep_unlinkat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_unlinkat(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_unlinkat(iOURingSQE.address(), n2, l2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_renameat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_renameat(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3, MemoryUtil.memAddress(byteBuffer2), n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, @NativeType(value="char const *") CharSequence charSequence2, int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_renameat(iOURingSQE.address(), n2, l2, n3, l3, n4);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nio_uring_prep_sync_file_range(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_sync_file_range(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="unsigned int") int n3, int n4, int n5) {
        LibURing.nio_uring_prep_sync_file_range(iOURingSQE.address(), n2, n3, n4, n5);
    }

    public static native void nio_uring_prep_mkdirat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_mkdirat(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_mkdirat(iOURingSQE.address(), n2, l2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_symlinkat(long var0, long var2, int var4, long var5);

    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_symlinkat(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n2, MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n2, @NativeType(value="char const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_symlinkat(iOURingSQE.address(), l2, n2, l3);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_linkat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, int n3, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_linkat(iOURingSQE.address(), n2, MemoryUtil.memAddress(byteBuffer), n3, MemoryUtil.memAddress(byteBuffer2), n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="char const *") CharSequence charSequence, int n3, @NativeType(value="char const *") CharSequence charSequence2, int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l3 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_linkat(iOURingSQE.address(), n2, l2, n3, l3, n4);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native int nio_uring_sq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_ready(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_sq_ready(iOURing.address());
    }

    public static native int nio_uring_sq_space_left(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_space_left(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_sq_space_left(iOURing.address());
    }

    public static native int nio_uring_sqring_wait(long var0);

    public static int io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_sqring_wait(iOURing.address());
    }

    public static native int nio_uring_cq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_cq_ready(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_cq_ready(iOURing.address());
    }

    public static native boolean nio_uring_cq_eventfd_enabled(long var0);

    @NativeType(value="bool")
    public static boolean io_uring_cq_eventfd_enabled(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_cq_eventfd_enabled(iOURing.address());
    }

    public static native int nio_uring_cq_eventfd_toggle(long var0, boolean var2);

    public static int io_uring_cq_eventfd_toggle(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="bool") boolean bl2) {
        return LibURing.nio_uring_cq_eventfd_toggle(iOURing.address(), bl2);
    }

    public static native int nio_uring_wait_cqe_nr(long var0, long var2, int var4);

    public static int io_uring_wait_cqe_nr(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        return LibURing.nio_uring_wait_cqe_nr(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining());
    }

    public static native int nio_uring_peek_cqe(long var0, long var2);

    public static int io_uring_peek_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_peek_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer));
    }

    public static native int nio_uring_wait_cqe(long var0, long var2);

    public static int io_uring_wait_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_wait_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer));
    }

    public static native int io_uring_mlock_size(@NativeType(value="unsigned") int var0, @NativeType(value="unsigned") int var1);

    public static native int nio_uring_mlock_size_params(int var0, long var1);

    public static int io_uring_mlock_size_params(@NativeType(value="unsigned") int n2, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams) {
        return LibURing.nio_uring_mlock_size_params(n2, iOURingParams.address());
    }

    public static native int nio_uring_register_buffers_tags(long var0, long var2, long[] var4, int var5);

    public static int io_uring_register_buffers_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") long[] lArray) {
        if (Checks.CHECKS) {
            Checks.check(lArray, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_tags(iOURing.address(), buffer.address(), lArray, buffer.remaining());
    }

    public static native int nio_uring_register_buffers_update_tag(long var0, int var2, long var3, long[] var5, int var6);

    public static int io_uring_register_buffers_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") long[] lArray) {
        if (Checks.CHECKS) {
            Checks.check(lArray, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_update_tag(iOURing.address(), n2, buffer.address(), lArray, buffer.remaining());
    }

    public static native int nio_uring_register_files(long var0, int[] var2, int var3);

    public static int io_uring_register_files(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") int[] nArray) {
        return LibURing.nio_uring_register_files(iOURing.address(), nArray, nArray.length);
    }

    public static native int nio_uring_register_files_tags(long var0, int[] var2, long[] var3, int var4);

    public static int io_uring_register_files_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") int[] nArray, @NativeType(value="__u64 const *") long[] lArray) {
        if (Checks.CHECKS) {
            Checks.check(lArray, nArray.length);
        }
        return LibURing.nio_uring_register_files_tags(iOURing.address(), nArray, lArray, nArray.length);
    }

    public static native int nio_uring_register_files_update_tag(long var0, int var2, int[] var3, long[] var4, int var5);

    public static int io_uring_register_files_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="int const *") int[] nArray, @NativeType(value="__u64 const *") long[] lArray) {
        if (Checks.CHECKS) {
            Checks.check(lArray, nArray.length);
        }
        return LibURing.nio_uring_register_files_update_tag(iOURing.address(), n2, nArray, lArray, nArray.length);
    }

    public static native int nio_uring_register_files_update(long var0, int var2, int[] var3, int var4);

    public static int io_uring_register_files_update(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2, @NativeType(value="int *") int[] nArray) {
        return LibURing.nio_uring_register_files_update(iOURing.address(), n2, nArray, nArray.length);
    }

    public static native int nio_uring_register_iowq_max_workers(long var0, int[] var2);

    public static int io_uring_register_iowq_max_workers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned int *") int[] nArray) {
        if (Checks.CHECKS) {
            Checks.check(nArray, 2);
        }
        return LibURing.nio_uring_register_iowq_max_workers(iOURing.address(), nArray);
    }

    public static native void nio_uring_prep_accept(long var0, int var2, long var3, int[] var5, int var6);

    public static void io_uring_prep_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") int[] nArray, int n3) {
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        LibURing.nio_uring_prep_accept(iOURingSQE.address(), n2, sockaddr.address(), nArray, n3);
    }

    public static native void nio_uring_prep_accept_direct(long var0, int var2, long var3, int[] var5, int var6, int var7);

    public static void io_uring_prep_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n2, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") int[] nArray, int n3, @NativeType(value="unsigned int") int n4) {
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        LibURing.nio_uring_prep_accept_direct(iOURingSQE.address(), n2, sockaddr.address(), nArray, n3, n4);
    }

    public static native void nio_uring_prep_files_update(long var0, int[] var2, int var3, int var4);

    public static void io_uring_prep_files_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="int *") int[] nArray, int n2) {
        LibURing.nio_uring_prep_files_update(iOURingSQE.address(), nArray, nArray.length, n2);
    }

    static {
        Library.initialize();
    }
}

