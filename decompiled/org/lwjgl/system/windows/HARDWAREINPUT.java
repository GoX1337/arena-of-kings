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

public class HARDWAREINPUT
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int UMSG;
    public static final int WPARAML;
    public static final int WPARAMH;

    public HARDWAREINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), HARDWAREINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int uMsg() {
        return HARDWAREINPUT.nuMsg(this.address());
    }

    @NativeType(value="WORD")
    public short wParamL() {
        return HARDWAREINPUT.nwParamL(this.address());
    }

    @NativeType(value="WORD")
    public short wParamH() {
        return HARDWAREINPUT.nwParamH(this.address());
    }

    public HARDWAREINPUT uMsg(@NativeType(value="DWORD") int n2) {
        HARDWAREINPUT.nuMsg(this.address(), n2);
        return this;
    }

    public HARDWAREINPUT wParamL(@NativeType(value="WORD") short s2) {
        HARDWAREINPUT.nwParamL(this.address(), s2);
        return this;
    }

    public HARDWAREINPUT wParamH(@NativeType(value="WORD") short s2) {
        HARDWAREINPUT.nwParamH(this.address(), s2);
        return this;
    }

    public HARDWAREINPUT set(int n2, short s2, short s3) {
        this.uMsg(n2);
        this.wParamL(s2);
        this.wParamH(s3);
        return this;
    }

    public HARDWAREINPUT set(HARDWAREINPUT hARDWAREINPUT) {
        MemoryUtil.memCopy(hARDWAREINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static HARDWAREINPUT malloc() {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static HARDWAREINPUT calloc() {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static HARDWAREINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static HARDWAREINPUT create(long l2) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, l2);
    }

    @Nullable
    public static HARDWAREINPUT createSafe(long l2) {
        return l2 == 0L ? null : HARDWAREINPUT.wrap(HARDWAREINPUT.class, l2);
    }

    public static Buffer malloc(int n2) {
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(HARDWAREINPUT.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = HARDWAREINPUT.__create(n2, SIZEOF);
        return HARDWAREINPUT.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return HARDWAREINPUT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : HARDWAREINPUT.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static HARDWAREINPUT mallocStack() {
        return HARDWAREINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT callocStack() {
        return HARDWAREINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT mallocStack(MemoryStack memoryStack) {
        return HARDWAREINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static HARDWAREINPUT callocStack(MemoryStack memoryStack) {
        return HARDWAREINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return HARDWAREINPUT.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return HARDWAREINPUT.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return HARDWAREINPUT.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return HARDWAREINPUT.calloc(n2, memoryStack);
    }

    public static HARDWAREINPUT malloc(MemoryStack memoryStack) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static HARDWAREINPUT calloc(MemoryStack memoryStack) {
        return HARDWAREINPUT.wrap(HARDWAREINPUT.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return HARDWAREINPUT.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return HARDWAREINPUT.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nuMsg(long l2) {
        return UNSAFE.getInt(null, l2 + (long)UMSG);
    }

    public static short nwParamL(long l2) {
        return UNSAFE.getShort(null, l2 + (long)WPARAML);
    }

    public static short nwParamH(long l2) {
        return UNSAFE.getShort(null, l2 + (long)WPARAMH);
    }

    public static void nuMsg(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)UMSG, n2);
    }

    public static void nwParamL(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)WPARAML, s2);
    }

    public static void nwParamH(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)WPARAMH, s2);
    }

    static {
        Struct.Layout layout = HARDWAREINPUT.__struct(HARDWAREINPUT.__member(4), HARDWAREINPUT.__member(2), HARDWAREINPUT.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        UMSG = layout.offsetof(0);
        WPARAML = layout.offsetof(1);
        WPARAMH = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<HARDWAREINPUT, Buffer>
    implements NativeResource {
        private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);

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
        protected HARDWAREINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int uMsg() {
            return HARDWAREINPUT.nuMsg(this.address());
        }

        @NativeType(value="WORD")
        public short wParamL() {
            return HARDWAREINPUT.nwParamL(this.address());
        }

        @NativeType(value="WORD")
        public short wParamH() {
            return HARDWAREINPUT.nwParamH(this.address());
        }

        public Buffer uMsg(@NativeType(value="DWORD") int n2) {
            HARDWAREINPUT.nuMsg(this.address(), n2);
            return this;
        }

        public Buffer wParamL(@NativeType(value="WORD") short s2) {
            HARDWAREINPUT.nwParamL(this.address(), s2);
            return this;
        }

        public Buffer wParamH(@NativeType(value="WORD") short s2) {
            HARDWAREINPUT.nwParamH(this.address(), s2);
            return this;
        }
    }
}

