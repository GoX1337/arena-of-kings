/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class LARGE_INTEGER
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int U;
    public static final int U_LOWPART;
    public static final int U_HIGHPART;
    public static final int QUADPART;

    public LARGE_INTEGER(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), LARGE_INTEGER.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int u_LowPart() {
        return LARGE_INTEGER.nu_LowPart(this.address());
    }

    @NativeType(value="LONG")
    public int u_HighPart() {
        return LARGE_INTEGER.nu_HighPart(this.address());
    }

    @NativeType(value="LONGLONG")
    public long QuadPart() {
        return LARGE_INTEGER.nQuadPart(this.address());
    }

    public LARGE_INTEGER u_LowPart(@NativeType(value="DWORD") int n2) {
        LARGE_INTEGER.nu_LowPart(this.address(), n2);
        return this;
    }

    public LARGE_INTEGER u_HighPart(@NativeType(value="LONG") int n2) {
        LARGE_INTEGER.nu_HighPart(this.address(), n2);
        return this;
    }

    public LARGE_INTEGER QuadPart(@NativeType(value="LONGLONG") long l2) {
        LARGE_INTEGER.nQuadPart(this.address(), l2);
        return this;
    }

    public LARGE_INTEGER set(LARGE_INTEGER lARGE_INTEGER) {
        MemoryUtil.memCopy(lARGE_INTEGER.address(), this.address(), SIZEOF);
        return this;
    }

    public static LARGE_INTEGER malloc() {
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static LARGE_INTEGER calloc() {
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static LARGE_INTEGER create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static LARGE_INTEGER create(long l2) {
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, l2);
    }

    @Nullable
    public static LARGE_INTEGER createSafe(long l2) {
        return l2 == 0L ? null : LARGE_INTEGER.wrap(LARGE_INTEGER.class, l2);
    }

    public static Buffer malloc(int n2) {
        return LARGE_INTEGER.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(LARGE_INTEGER.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return LARGE_INTEGER.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = LARGE_INTEGER.__create(n2, SIZEOF);
        return LARGE_INTEGER.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return LARGE_INTEGER.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : LARGE_INTEGER.wrap(Buffer.class, l2, n2);
    }

    public static LARGE_INTEGER malloc(MemoryStack memoryStack) {
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static LARGE_INTEGER calloc(MemoryStack memoryStack) {
        return LARGE_INTEGER.wrap(LARGE_INTEGER.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return LARGE_INTEGER.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return LARGE_INTEGER.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nu_LowPart(long l2) {
        return UNSAFE.getInt(null, l2 + (long)U_LOWPART);
    }

    public static int nu_HighPart(long l2) {
        return UNSAFE.getInt(null, l2 + (long)U_HIGHPART);
    }

    public static long nQuadPart(long l2) {
        return UNSAFE.getLong(null, l2 + (long)QUADPART);
    }

    public static void nu_LowPart(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)U_LOWPART, n2);
    }

    public static void nu_HighPart(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)U_HIGHPART, n2);
    }

    public static void nQuadPart(long l2, long l3) {
        UNSAFE.putLong(null, l2 + (long)QUADPART, l3);
    }

    static {
        Struct.Layout layout = LARGE_INTEGER.__union(LARGE_INTEGER.__struct(LARGE_INTEGER.__member(4), LARGE_INTEGER.__member(4)), LARGE_INTEGER.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        U = layout.offsetof(0);
        U_LOWPART = layout.offsetof(1);
        U_HIGHPART = layout.offsetof(2);
        QUADPART = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<LARGE_INTEGER, Buffer>
    implements NativeResource {
        private static final LARGE_INTEGER ELEMENT_FACTORY = LARGE_INTEGER.create(-1L);

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
        protected LARGE_INTEGER getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int u_LowPart() {
            return LARGE_INTEGER.nu_LowPart(this.address());
        }

        @NativeType(value="LONG")
        public int u_HighPart() {
            return LARGE_INTEGER.nu_HighPart(this.address());
        }

        @NativeType(value="LONGLONG")
        public long QuadPart() {
            return LARGE_INTEGER.nQuadPart(this.address());
        }

        public Buffer u_LowPart(@NativeType(value="DWORD") int n2) {
            LARGE_INTEGER.nu_LowPart(this.address(), n2);
            return this;
        }

        public Buffer u_HighPart(@NativeType(value="LONG") int n2) {
            LARGE_INTEGER.nu_HighPart(this.address(), n2);
            return this;
        }

        public Buffer QuadPart(@NativeType(value="LONGLONG") long l2) {
            LARGE_INTEGER.nQuadPart(this.address(), l2);
            return this;
        }
    }
}

