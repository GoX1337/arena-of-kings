/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.IOVec;

@NativeType(value="struct msghdr")
public class Msghdr
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int MSG_NAME;
    public static final int MSG_NAMELEN;
    public static final int MSG_IOV;
    public static final int MSG_IOVLEN;
    public static final int MSG_CONTROL;
    public static final int MSG_CONTROLLEN;
    public static final int MSG_FLAGS;

    public Msghdr(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Msghdr.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public ByteBuffer msg_name() {
        return Msghdr.nmsg_name(this.address());
    }

    @NativeType(value="socklen_t")
    public int msg_namelen() {
        return Msghdr.nmsg_namelen(this.address());
    }

    @NativeType(value="struct iovec *")
    public IOVec.Buffer msg_iov() {
        return Msghdr.nmsg_iov(this.address());
    }

    @NativeType(value="size_t")
    public long msg_iovlen() {
        return Msghdr.nmsg_iovlen(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer msg_control() {
        return Msghdr.nmsg_control(this.address());
    }

    @NativeType(value="size_t")
    public long msg_controllen() {
        return Msghdr.nmsg_controllen(this.address());
    }

    public int msg_flags() {
        return Msghdr.nmsg_flags(this.address());
    }

    public Msghdr msg_name(@NativeType(value="void *") ByteBuffer byteBuffer) {
        Msghdr.nmsg_name(this.address(), byteBuffer);
        return this;
    }

    public Msghdr msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer buffer) {
        Msghdr.nmsg_iov(this.address(), buffer);
        return this;
    }

    public Msghdr msg_control(@NativeType(value="void *") ByteBuffer byteBuffer) {
        Msghdr.nmsg_control(this.address(), byteBuffer);
        return this;
    }

    public Msghdr msg_flags(int n2) {
        Msghdr.nmsg_flags(this.address(), n2);
        return this;
    }

    public Msghdr set(ByteBuffer byteBuffer, IOVec.Buffer buffer, ByteBuffer byteBuffer2, int n2) {
        this.msg_name(byteBuffer);
        this.msg_iov(buffer);
        this.msg_control(byteBuffer2);
        this.msg_flags(n2);
        return this;
    }

    public Msghdr set(Msghdr msghdr) {
        MemoryUtil.memCopy(msghdr.address(), this.address(), SIZEOF);
        return this;
    }

    public static Msghdr malloc() {
        return Msghdr.wrap(Msghdr.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static Msghdr calloc() {
        return Msghdr.wrap(Msghdr.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static Msghdr create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return Msghdr.wrap(Msghdr.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Msghdr create(long l2) {
        return Msghdr.wrap(Msghdr.class, l2);
    }

    @Nullable
    public static Msghdr createSafe(long l2) {
        return l2 == 0L ? null : Msghdr.wrap(Msghdr.class, l2);
    }

    public static Buffer malloc(int n2) {
        return Msghdr.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(Msghdr.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return Msghdr.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = Msghdr.__create(n2, SIZEOF);
        return Msghdr.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return Msghdr.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : Msghdr.wrap(Buffer.class, l2, n2);
    }

    public static Msghdr malloc(MemoryStack memoryStack) {
        return Msghdr.wrap(Msghdr.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static Msghdr calloc(MemoryStack memoryStack) {
        return Msghdr.wrap(Msghdr.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return Msghdr.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return Msghdr.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nmsg_name(long l2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)MSG_NAME), Msghdr.nmsg_namelen(l2));
    }

    public static int nmsg_namelen(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MSG_NAMELEN);
    }

    public static IOVec.Buffer nmsg_iov(long l2) {
        return IOVec.create(MemoryUtil.memGetAddress(l2 + (long)MSG_IOV), (int)Msghdr.nmsg_iovlen(l2));
    }

    public static long nmsg_iovlen(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)MSG_IOVLEN);
    }

    public static ByteBuffer nmsg_control(long l2) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l2 + (long)MSG_CONTROL), (int)Msghdr.nmsg_controllen(l2));
    }

    public static long nmsg_controllen(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)MSG_CONTROLLEN);
    }

    public static int nmsg_flags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)MSG_FLAGS);
    }

    public static void nmsg_name(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)MSG_NAME, MemoryUtil.memAddress(byteBuffer));
        Msghdr.nmsg_namelen(l2, byteBuffer.remaining());
    }

    public static void nmsg_namelen(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MSG_NAMELEN, n2);
    }

    public static void nmsg_iov(long l2, IOVec.Buffer buffer) {
        MemoryUtil.memPutAddress(l2 + (long)MSG_IOV, buffer.address());
        Msghdr.nmsg_iovlen(l2, buffer.remaining());
    }

    public static void nmsg_iovlen(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)MSG_IOVLEN, l3);
    }

    public static void nmsg_control(long l2, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l2 + (long)MSG_CONTROL, MemoryUtil.memAddress(byteBuffer));
        Msghdr.nmsg_controllen(l2, byteBuffer.remaining());
    }

    public static void nmsg_controllen(long l2, long l3) {
        MemoryUtil.memPutAddress(l2 + (long)MSG_CONTROLLEN, l3);
    }

    public static void nmsg_flags(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)MSG_FLAGS, n2);
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)MSG_NAME));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)MSG_IOV));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)MSG_CONTROL));
    }

    static {
        Struct.Layout layout = Msghdr.__struct(Msghdr.__member(POINTER_SIZE), Msghdr.__member(4), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        MSG_NAME = layout.offsetof(0);
        MSG_NAMELEN = layout.offsetof(1);
        MSG_IOV = layout.offsetof(2);
        MSG_IOVLEN = layout.offsetof(3);
        MSG_CONTROL = layout.offsetof(4);
        MSG_CONTROLLEN = layout.offsetof(5);
        MSG_FLAGS = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<Msghdr, Buffer>
    implements NativeResource {
        private static final Msghdr ELEMENT_FACTORY = Msghdr.create(-1L);

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
        protected Msghdr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public ByteBuffer msg_name() {
            return Msghdr.nmsg_name(this.address());
        }

        @NativeType(value="socklen_t")
        public int msg_namelen() {
            return Msghdr.nmsg_namelen(this.address());
        }

        @NativeType(value="struct iovec *")
        public IOVec.Buffer msg_iov() {
            return Msghdr.nmsg_iov(this.address());
        }

        @NativeType(value="size_t")
        public long msg_iovlen() {
            return Msghdr.nmsg_iovlen(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer msg_control() {
            return Msghdr.nmsg_control(this.address());
        }

        @NativeType(value="size_t")
        public long msg_controllen() {
            return Msghdr.nmsg_controllen(this.address());
        }

        public int msg_flags() {
            return Msghdr.nmsg_flags(this.address());
        }

        public Buffer msg_name(@NativeType(value="void *") ByteBuffer byteBuffer) {
            Msghdr.nmsg_name(this.address(), byteBuffer);
            return this;
        }

        public Buffer msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer buffer) {
            Msghdr.nmsg_iov(this.address(), buffer);
            return this;
        }

        public Buffer msg_control(@NativeType(value="void *") ByteBuffer byteBuffer) {
            Msghdr.nmsg_control(this.address(), byteBuffer);
            return this;
        }

        public Buffer msg_flags(int n2) {
            Msghdr.nmsg_flags(this.address(), n2);
            return this;
        }
    }
}

