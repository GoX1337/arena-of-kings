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

@NativeType(value="struct stbtt_packedchar")
public class STBTTPackedchar
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int X0;
    public static final int Y0;
    public static final int X1;
    public static final int Y1;
    public static final int XOFF;
    public static final int YOFF;
    public static final int XADVANCE;
    public static final int XOFF2;
    public static final int YOFF2;

    public STBTTPackedchar(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBTTPackedchar.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned short")
    public short x0() {
        return STBTTPackedchar.nx0(this.address());
    }

    @NativeType(value="unsigned short")
    public short y0() {
        return STBTTPackedchar.ny0(this.address());
    }

    @NativeType(value="unsigned short")
    public short x1() {
        return STBTTPackedchar.nx1(this.address());
    }

    @NativeType(value="unsigned short")
    public short y1() {
        return STBTTPackedchar.ny1(this.address());
    }

    public float xoff() {
        return STBTTPackedchar.nxoff(this.address());
    }

    public float yoff() {
        return STBTTPackedchar.nyoff(this.address());
    }

    public float xadvance() {
        return STBTTPackedchar.nxadvance(this.address());
    }

    public float xoff2() {
        return STBTTPackedchar.nxoff2(this.address());
    }

    public float yoff2() {
        return STBTTPackedchar.nyoff2(this.address());
    }

    public STBTTPackedchar x0(@NativeType(value="unsigned short") short s2) {
        STBTTPackedchar.nx0(this.address(), s2);
        return this;
    }

    public STBTTPackedchar y0(@NativeType(value="unsigned short") short s2) {
        STBTTPackedchar.ny0(this.address(), s2);
        return this;
    }

    public STBTTPackedchar x1(@NativeType(value="unsigned short") short s2) {
        STBTTPackedchar.nx1(this.address(), s2);
        return this;
    }

    public STBTTPackedchar y1(@NativeType(value="unsigned short") short s2) {
        STBTTPackedchar.ny1(this.address(), s2);
        return this;
    }

    public STBTTPackedchar xoff(float f2) {
        STBTTPackedchar.nxoff(this.address(), f2);
        return this;
    }

    public STBTTPackedchar yoff(float f2) {
        STBTTPackedchar.nyoff(this.address(), f2);
        return this;
    }

    public STBTTPackedchar xadvance(float f2) {
        STBTTPackedchar.nxadvance(this.address(), f2);
        return this;
    }

    public STBTTPackedchar xoff2(float f2) {
        STBTTPackedchar.nxoff2(this.address(), f2);
        return this;
    }

    public STBTTPackedchar yoff2(float f2) {
        STBTTPackedchar.nyoff2(this.address(), f2);
        return this;
    }

    public STBTTPackedchar set(short s2, short s3, short s4, short s5, float f2, float f3, float f4, float f5, float f6) {
        this.x0(s2);
        this.y0(s3);
        this.x1(s4);
        this.y1(s5);
        this.xoff(f2);
        this.yoff(f3);
        this.xadvance(f4);
        this.xoff2(f5);
        this.yoff2(f6);
        return this;
    }

    public STBTTPackedchar set(STBTTPackedchar sTBTTPackedchar) {
        MemoryUtil.memCopy(sTBTTPackedchar.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBTTPackedchar malloc() {
        return STBTTPackedchar.wrap(STBTTPackedchar.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBTTPackedchar calloc() {
        return STBTTPackedchar.wrap(STBTTPackedchar.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBTTPackedchar create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBTTPackedchar.wrap(STBTTPackedchar.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBTTPackedchar create(long l2) {
        return STBTTPackedchar.wrap(STBTTPackedchar.class, l2);
    }

    @Nullable
    public static STBTTPackedchar createSafe(long l2) {
        return l2 == 0L ? null : STBTTPackedchar.wrap(STBTTPackedchar.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBTTPackedchar.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBTTPackedchar.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBTTPackedchar.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBTTPackedchar.__create(n2, SIZEOF);
        return STBTTPackedchar.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBTTPackedchar.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBTTPackedchar.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBTTPackedchar mallocStack() {
        return STBTTPackedchar.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTPackedchar callocStack() {
        return STBTTPackedchar.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBTTPackedchar mallocStack(MemoryStack memoryStack) {
        return STBTTPackedchar.malloc(memoryStack);
    }

    @Deprecated
    public static STBTTPackedchar callocStack(MemoryStack memoryStack) {
        return STBTTPackedchar.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBTTPackedchar.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBTTPackedchar.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBTTPackedchar.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBTTPackedchar.calloc(n2, memoryStack);
    }

    public static STBTTPackedchar malloc(MemoryStack memoryStack) {
        return STBTTPackedchar.wrap(STBTTPackedchar.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBTTPackedchar calloc(MemoryStack memoryStack) {
        return STBTTPackedchar.wrap(STBTTPackedchar.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBTTPackedchar.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBTTPackedchar.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static short nx0(long l2) {
        return UNSAFE.getShort(null, l2 + (long)X0);
    }

    public static short ny0(long l2) {
        return UNSAFE.getShort(null, l2 + (long)Y0);
    }

    public static short nx1(long l2) {
        return UNSAFE.getShort(null, l2 + (long)X1);
    }

    public static short ny1(long l2) {
        return UNSAFE.getShort(null, l2 + (long)Y1);
    }

    public static float nxoff(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)XOFF);
    }

    public static float nyoff(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)YOFF);
    }

    public static float nxadvance(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)XADVANCE);
    }

    public static float nxoff2(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)XOFF2);
    }

    public static float nyoff2(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)YOFF2);
    }

    public static void nx0(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)X0, s2);
    }

    public static void ny0(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)Y0, s2);
    }

    public static void nx1(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)X1, s2);
    }

    public static void ny1(long l2, short s2) {
        UNSAFE.putShort(null, l2 + (long)Y1, s2);
    }

    public static void nxoff(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)XOFF, f2);
    }

    public static void nyoff(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)YOFF, f2);
    }

    public static void nxadvance(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)XADVANCE, f2);
    }

    public static void nxoff2(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)XOFF2, f2);
    }

    public static void nyoff2(long l2, float f2) {
        UNSAFE.putFloat(null, l2 + (long)YOFF2, f2);
    }

    static {
        Struct.Layout layout = STBTTPackedchar.__struct(STBTTPackedchar.__member(2), STBTTPackedchar.__member(2), STBTTPackedchar.__member(2), STBTTPackedchar.__member(2), STBTTPackedchar.__member(4), STBTTPackedchar.__member(4), STBTTPackedchar.__member(4), STBTTPackedchar.__member(4), STBTTPackedchar.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        X0 = layout.offsetof(0);
        Y0 = layout.offsetof(1);
        X1 = layout.offsetof(2);
        Y1 = layout.offsetof(3);
        XOFF = layout.offsetof(4);
        YOFF = layout.offsetof(5);
        XADVANCE = layout.offsetof(6);
        XOFF2 = layout.offsetof(7);
        YOFF2 = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<STBTTPackedchar, Buffer>
    implements NativeResource {
        private static final STBTTPackedchar ELEMENT_FACTORY = STBTTPackedchar.create(-1L);

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
        protected STBTTPackedchar getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned short")
        public short x0() {
            return STBTTPackedchar.nx0(this.address());
        }

        @NativeType(value="unsigned short")
        public short y0() {
            return STBTTPackedchar.ny0(this.address());
        }

        @NativeType(value="unsigned short")
        public short x1() {
            return STBTTPackedchar.nx1(this.address());
        }

        @NativeType(value="unsigned short")
        public short y1() {
            return STBTTPackedchar.ny1(this.address());
        }

        public float xoff() {
            return STBTTPackedchar.nxoff(this.address());
        }

        public float yoff() {
            return STBTTPackedchar.nyoff(this.address());
        }

        public float xadvance() {
            return STBTTPackedchar.nxadvance(this.address());
        }

        public float xoff2() {
            return STBTTPackedchar.nxoff2(this.address());
        }

        public float yoff2() {
            return STBTTPackedchar.nyoff2(this.address());
        }

        public Buffer x0(@NativeType(value="unsigned short") short s2) {
            STBTTPackedchar.nx0(this.address(), s2);
            return this;
        }

        public Buffer y0(@NativeType(value="unsigned short") short s2) {
            STBTTPackedchar.ny0(this.address(), s2);
            return this;
        }

        public Buffer x1(@NativeType(value="unsigned short") short s2) {
            STBTTPackedchar.nx1(this.address(), s2);
            return this;
        }

        public Buffer y1(@NativeType(value="unsigned short") short s2) {
            STBTTPackedchar.ny1(this.address(), s2);
            return this;
        }

        public Buffer xoff(float f2) {
            STBTTPackedchar.nxoff(this.address(), f2);
            return this;
        }

        public Buffer yoff(float f2) {
            STBTTPackedchar.nyoff(this.address(), f2);
            return this;
        }

        public Buffer xadvance(float f2) {
            STBTTPackedchar.nxadvance(this.address(), f2);
            return this;
        }

        public Buffer xoff2(float f2) {
            STBTTPackedchar.nxoff2(this.address(), f2);
            return this;
        }

        public Buffer yoff2(float f2) {
            STBTTPackedchar.nyoff2(this.address(), f2);
            return this;
        }
    }
}

