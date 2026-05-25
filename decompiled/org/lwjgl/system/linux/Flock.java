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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct flock64")
public class Flock
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int L_TYPE;
    public static final int L_WHENCE;
    public static final int L_START;
    public static final int L_LEN;
    public static final int L_PID;

    public Flock(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Flock.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public short l_type() {
        return Flock.nl_type(this.address());
    }

    public short l_whence() {
        return Flock.nl_whence(this.address());
    }

    @NativeType(value="off_t")
    public long l_start() {
        return Flock.nl_start(this.address());
    }

    @NativeType(value="off_t")
    public long l_len() {
        return Flock.nl_len(this.address());
    }

    @NativeType(value="pid_t")
    public int l_pid() {
        return Flock.nl_pid(this.address());
    }

    public Flock l_type(short s2) {
        Flock.nl_type(this.address(), s2);
        return this;
    }

    public Flock l_whence(short s2) {
        Flock.nl_whence(this.address(), s2);
        return this;
    }

    public Flock l_start(@NativeType(value="off_t") long l2) {
        Flock.nl_start(this.address(), l2);
        return this;
    }

    public Flock l_len(@NativeType(value="off_t") long l2) {
        Flock.nl_len(this.address(), l2);
        return this;
    }

    public Flock l_pid(@NativeType(value="pid_t") int n2) {
        Flock.nl_pid(this.address(), n2);
        return this;
    }

    public Flock set(short s2, short s3, long l2, long l3, int n2) {
        this.l_type(s2);
        this.l_whence(s3);
        this.l_start(l2);
        this.l_len(l3);
        this.l_pid(n2);
        return this;
    }

    public Flock set(Flock flock) {
        MemoryUtil.memCopy(flock.address(), this.address(), SIZEOF);
        return this;
    }

    public static Flock malloc() {
        return Flock.wrap(Flock.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static Flock calloc() {
        return Flock.wrap(Flock.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static Flock create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return Flock.wrap(Flock.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Flock create(long l2) {
        return Flock.wrap(Flock.class, l2);
    }

    @Nullable
    public static Flock createSafe(long l2) {
        return l2 == 0L ? null : Flock.wrap(Flock.class, l2);
    }

    public static Buffer malloc(int n2) {
        return Flock.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(Flock.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return Flock.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = Flock.__create(n2, SIZEOF);
        return Flock.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return Flock.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : Flock.wrap(Buffer.class, l2, n2);
    }

    public static Flock malloc(MemoryStack memoryStack) {
        return Flock.wrap(Flock.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static Flock calloc(MemoryStack memoryStack) {
        return Flock.wrap(Flock.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return Flock.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return Flock.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nl_type(long l2) {
        return UNSAFE.getShort(null, l2 + (long)L_TYPE);
    }

    public static short nl_whence(long l2) {
        return UNSAFE.getShort(null, l2 + (long)L_WHENCE);
    }

    public static long nl_start(long l2) {
        return UNSAFE.getLong(null, l2 + (long)L_START);
    }

    public static long nl_len(long l2) {
        return UNSAFE.getLong(null, l2 + (long)L_LEN);
    }

    public static int nl_pid(long l2) {
        return UNSAFE.getInt(null, l2 + (long)L_PID);
    }

    public static void nl_type(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)L_TYPE, s2);
    }

    public static void nl_whence(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)L_WHENCE, s2);
    }

    public static void nl_start(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)L_START, l3);
    }

    public static void nl_len(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)L_LEN, l3);
    }

    public static void nl_pid(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)L_PID, n2);
    }

    static {
        Struct.Layout layout = Flock.__struct(Flock.__member(2), Flock.__member(2), Flock.__member(8), Flock.__member(8), Flock.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        L_TYPE = layout.offsetof(0);
        L_WHENCE = layout.offsetof(1);
        L_START = layout.offsetof(2);
        L_LEN = layout.offsetof(3);
        L_PID = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<Flock, Buffer>
    implements NativeResource {
        private static final Flock ELEMENT_FACTORY = Flock.create(-1L);

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
        protected Flock getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public short l_type() {
            return Flock.nl_type(this.address());
        }

        public short l_whence() {
            return Flock.nl_whence(this.address());
        }

        @NativeType(value="off_t")
        public long l_start() {
            return Flock.nl_start(this.address());
        }

        @NativeType(value="off_t")
        public long l_len() {
            return Flock.nl_len(this.address());
        }

        @NativeType(value="pid_t")
        public int l_pid() {
            return Flock.nl_pid(this.address());
        }

        public Buffer l_type(short s2) {
            Flock.nl_type(this.address(), s2);
            return this;
        }

        public Buffer l_whence(short s2) {
            Flock.nl_whence(this.address(), s2);
            return this;
        }

        public Buffer l_start(@NativeType(value="off_t") long l2) {
            Flock.nl_start(this.address(), l2);
            return this;
        }

        public Buffer l_len(@NativeType(value="off_t") long l2) {
            Flock.nl_len(this.address(), l2);
            return this;
        }

        public Buffer l_pid(@NativeType(value="pid_t") int n2) {
            Flock.nl_pid(this.address(), n2);
            return this;
        }
    }
}

