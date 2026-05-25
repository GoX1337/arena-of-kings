/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbtt_aligned_quad")
public class STBTTAlignedQuad
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X0;
    public static final int Y0;
    public static final int S0;
    public static final int T0;
    public static final int X1;
    public static final int Y1;
    public static final int S1;
    public static final int T1;

    public STBTTAlignedQuad(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTAlignedQuad.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public float x0() {
        return STBTTAlignedQuad.nx0(this.address());
    }

    public float y0() {
        return STBTTAlignedQuad.ny0(this.address());
    }

    public float s0() {
        return STBTTAlignedQuad.ns0(this.address());
    }

    public float t0() {
        return STBTTAlignedQuad.nt0(this.address());
    }

    public float x1() {
        return STBTTAlignedQuad.nx1(this.address());
    }

    public float y1() {
        return STBTTAlignedQuad.ny1(this.address());
    }

    public float s1() {
        return STBTTAlignedQuad.ns1(this.address());
    }

    public float t1() {
        return STBTTAlignedQuad.nt1(this.address());
    }

    public static STBTTAlignedQuad malloc() {
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTAlignedQuad calloc() {
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTAlignedQuad create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTAlignedQuad create(long l2) {
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, l2);
    }

    @Nullable
    public static STBTTAlignedQuad createSafe(long l2) {
        return l2 == 0L ? null : STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTAlignedQuad.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTAlignedQuad.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTAlignedQuad.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTAlignedQuad.__create(n2, SIZEOF);
        return STBTTAlignedQuad.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTAlignedQuad.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTAlignedQuad.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTAlignedQuad mallocStack() {
        return STBTTAlignedQuad.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTAlignedQuad callocStack() {
        return STBTTAlignedQuad.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTAlignedQuad mallocStack(MemoryStack memoryStack) {
        return STBTTAlignedQuad.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTAlignedQuad callocStack(MemoryStack memoryStack) {
        return STBTTAlignedQuad.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTAlignedQuad.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTAlignedQuad.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTAlignedQuad.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTAlignedQuad.calloc(n2, memoryStack);
    }

    public static STBTTAlignedQuad malloc(MemoryStack memoryStack) {
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTAlignedQuad calloc(MemoryStack memoryStack) {
        return STBTTAlignedQuad.wrap(STBTTAlignedQuad.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTAlignedQuad.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTAlignedQuad.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static float nx0(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)X0);
    }

    public static float ny0(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)Y0);
    }

    public static float ns0(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)S0);
    }

    public static float nt0(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)T0);
    }

    public static float nx1(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)X1);
    }

    public static float ny1(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)Y1);
    }

    public static float ns1(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)S1);
    }

    public static float nt1(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)T1);
    }

    static {
        Struct.Layout layout = STBTTAlignedQuad.__struct(STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4), STBTTAlignedQuad.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X0 = layout.offsetof(0);
        Y0 = layout.offsetof(1);
        S0 = layout.offsetof(2);
        T0 = layout.offsetof(3);
        X1 = layout.offsetof(4);
        Y1 = layout.offsetof(5);
        S1 = layout.offsetof(6);
        T1 = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<STBTTAlignedQuad, Buffer>
    implements NativeResource {
        private static final STBTTAlignedQuad ELEMENT_FACTORY = STBTTAlignedQuad.create(-1L);

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
        protected STBTTAlignedQuad getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public float x0() {
            return STBTTAlignedQuad.nx0(this.address());
        }

        public float y0() {
            return STBTTAlignedQuad.ny0(this.address());
        }

        public float s0() {
            return STBTTAlignedQuad.ns0(this.address());
        }

        public float t0() {
            return STBTTAlignedQuad.nt0(this.address());
        }

        public float x1() {
            return STBTTAlignedQuad.nx1(this.address());
        }

        public float y1() {
            return STBTTAlignedQuad.ny1(this.address());
        }

        public float s1() {
            return STBTTAlignedQuad.ns1(this.address());
        }

        public float t1() {
            return STBTTAlignedQuad.nt1(this.address());
        }
    }
}

