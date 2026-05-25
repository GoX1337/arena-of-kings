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

@NativeType(value="struct f_owner_ex")
public class FOwnerEx
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int PID;

    public FOwnerEx(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FOwnerEx.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return FOwnerEx.ntype(this.address());
    }

    @NativeType(value="pid_t")
    public int pid() {
        return FOwnerEx.npid(this.address());
    }

    public FOwnerEx type(int n2) {
        FOwnerEx.ntype(this.address(), n2);
        return this;
    }

    public FOwnerEx pid(@NativeType(value="pid_t") int n2) {
        FOwnerEx.npid(this.address(), n2);
        return this;
    }

    public FOwnerEx set(int n2, int n3) {
        this.type(n2);
        this.pid(n3);
        return this;
    }

    public FOwnerEx set(FOwnerEx fOwnerEx) {
        MemoryUtil.memCopy(fOwnerEx.address(), this.address(), SIZEOF);
        return this;
    }

    public static FOwnerEx malloc() {
        return FOwnerEx.wrap(FOwnerEx.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static FOwnerEx calloc() {
        return FOwnerEx.wrap(FOwnerEx.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static FOwnerEx create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return FOwnerEx.wrap(FOwnerEx.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FOwnerEx create(long l2) {
        return FOwnerEx.wrap(FOwnerEx.class, l2);
    }

    @Nullable
    public static FOwnerEx createSafe(long l2) {
        return l2 == 0L ? null : FOwnerEx.wrap(FOwnerEx.class, l2);
    }

    public static Buffer malloc(int n2) {
        return FOwnerEx.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(FOwnerEx.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return FOwnerEx.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = FOwnerEx.__create(n2, SIZEOF);
        return FOwnerEx.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return FOwnerEx.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : FOwnerEx.wrap(Buffer.class, l2, n2);
    }

    public static FOwnerEx malloc(MemoryStack memoryStack) {
        return FOwnerEx.wrap(FOwnerEx.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static FOwnerEx calloc(MemoryStack memoryStack) {
        return FOwnerEx.wrap(FOwnerEx.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return FOwnerEx.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return FOwnerEx.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static int npid(long l2) {
        return UNSAFE.getInt(null, l2 + (long)PID);
    }

    public static void ntype(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)TYPE, n2);
    }

    public static void npid(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)PID, n2);
    }

    static {
        Struct.Layout layout = FOwnerEx.__struct(FOwnerEx.__member(4), FOwnerEx.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        PID = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<FOwnerEx, Buffer>
    implements NativeResource {
        private static final FOwnerEx ELEMENT_FACTORY = FOwnerEx.create(-1L);

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
        protected FOwnerEx getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return FOwnerEx.ntype(this.address());
        }

        @NativeType(value="pid_t")
        public int pid() {
            return FOwnerEx.npid(this.address());
        }

        public Buffer type(int n2) {
            FOwnerEx.ntype(this.address(), n2);
            return this;
        }

        public Buffer pid(@NativeType(value="pid_t") int n2) {
            FOwnerEx.npid(this.address(), n2);
            return this;
        }
    }
}

