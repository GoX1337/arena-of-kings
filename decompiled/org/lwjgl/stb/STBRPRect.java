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

@NativeType(value="struct stbrp_rect")
public class STBRPRect
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ID;
    public static final int W;
    public static final int H;
    public static final int X;
    public static final int Y;
    public static final int WAS_PACKED;

    public STBRPRect(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBRPRect.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int id() {
        return STBRPRect.nid(this.address());
    }

    @NativeType(value="stbrp_coord")
    public int w() {
        return STBRPRect.nw(this.address());
    }

    @NativeType(value="stbrp_coord")
    public int h() {
        return STBRPRect.nh(this.address());
    }

    @NativeType(value="stbrp_coord")
    public int x() {
        return STBRPRect.nx(this.address());
    }

    @NativeType(value="stbrp_coord")
    public int y() {
        return STBRPRect.ny(this.address());
    }

    @NativeType(value="int")
    public boolean was_packed() {
        return STBRPRect.nwas_packed(this.address()) != 0;
    }

    public STBRPRect id(int n2) {
        STBRPRect.nid(this.address(), n2);
        return this;
    }

    public STBRPRect w(@NativeType(value="stbrp_coord") int n2) {
        STBRPRect.nw(this.address(), n2);
        return this;
    }

    public STBRPRect h(@NativeType(value="stbrp_coord") int n2) {
        STBRPRect.nh(this.address(), n2);
        return this;
    }

    public STBRPRect x(@NativeType(value="stbrp_coord") int n2) {
        STBRPRect.nx(this.address(), n2);
        return this;
    }

    public STBRPRect y(@NativeType(value="stbrp_coord") int n2) {
        STBRPRect.ny(this.address(), n2);
        return this;
    }

    public STBRPRect was_packed(@NativeType(value="int") boolean bl2) {
        STBRPRect.nwas_packed(this.address(), bl2 ? 1 : 0);
        return this;
    }

    public STBRPRect set(int n2, int n3, int n4, int n5, int n6, boolean bl2) {
        this.id(n2);
        this.w(n3);
        this.h(n4);
        this.x(n5);
        this.y(n6);
        this.was_packed(bl2);
        return this;
    }

    public STBRPRect set(STBRPRect sTBRPRect) {
        MemoryUtil.memCopy(sTBRPRect.address(), this.address(), SIZEOF);
        return this;
    }

    public static STBRPRect malloc() {
        return STBRPRect.wrap(STBRPRect.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBRPRect calloc() {
        return STBRPRect.wrap(STBRPRect.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBRPRect create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBRPRect.wrap(STBRPRect.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBRPRect create(long l2) {
        return STBRPRect.wrap(STBRPRect.class, l2);
    }

    @Nullable
    public static STBRPRect createSafe(long l2) {
        return l2 == 0L ? null : STBRPRect.wrap(STBRPRect.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBRPRect.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBRPRect.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBRPRect.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBRPRect.__create(n2, SIZEOF);
        return STBRPRect.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBRPRect.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBRPRect.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBRPRect mallocStack() {
        return STBRPRect.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPRect callocStack() {
        return STBRPRect.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPRect mallocStack(MemoryStack memoryStack) {
        return STBRPRect.malloc(memoryStack);
    }

    @Deprecated
    public static STBRPRect callocStack(MemoryStack memoryStack) {
        return STBRPRect.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBRPRect.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBRPRect.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBRPRect.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBRPRect.calloc(n2, memoryStack);
    }

    public static STBRPRect malloc(MemoryStack memoryStack) {
        return STBRPRect.wrap(STBRPRect.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBRPRect calloc(MemoryStack memoryStack) {
        return STBRPRect.wrap(STBRPRect.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBRPRect.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBRPRect.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nid(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ID);
    }

    public static int nw(long l2) {
        return UNSAFE.getInt(null, l2 + (long)W);
    }

    public static int nh(long l2) {
        return UNSAFE.getInt(null, l2 + (long)H);
    }

    public static int nx(long l2) {
        return UNSAFE.getInt(null, l2 + (long)X);
    }

    public static int ny(long l2) {
        return UNSAFE.getInt(null, l2 + (long)Y);
    }

    public static int nwas_packed(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WAS_PACKED);
    }

    public static void nid(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)ID, n2);
    }

    public static void nw(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)W, n2);
    }

    public static void nh(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)H, n2);
    }

    public static void nx(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)X, n2);
    }

    public static void ny(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)Y, n2);
    }

    public static void nwas_packed(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)WAS_PACKED, n2);
    }

    static {
        Struct.Layout layout = STBRPRect.__struct(STBRPRect.__member(4), STBRPRect.__member(4), STBRPRect.__member(4), STBRPRect.__member(4), STBRPRect.__member(4), STBRPRect.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ID = layout.offsetof(0);
        W = layout.offsetof(1);
        H = layout.offsetof(2);
        X = layout.offsetof(3);
        Y = layout.offsetof(4);
        WAS_PACKED = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<STBRPRect, Buffer>
    implements NativeResource {
        private static final STBRPRect ELEMENT_FACTORY = STBRPRect.create(-1L);

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
        protected STBRPRect getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int id() {
            return STBRPRect.nid(this.address());
        }

        @NativeType(value="stbrp_coord")
        public int w() {
            return STBRPRect.nw(this.address());
        }

        @NativeType(value="stbrp_coord")
        public int h() {
            return STBRPRect.nh(this.address());
        }

        @NativeType(value="stbrp_coord")
        public int x() {
            return STBRPRect.nx(this.address());
        }

        @NativeType(value="stbrp_coord")
        public int y() {
            return STBRPRect.ny(this.address());
        }

        @NativeType(value="int")
        public boolean was_packed() {
            return STBRPRect.nwas_packed(this.address()) != 0;
        }

        public Buffer id(int n2) {
            STBRPRect.nid(this.address(), n2);
            return this;
        }

        public Buffer w(@NativeType(value="stbrp_coord") int n2) {
            STBRPRect.nw(this.address(), n2);
            return this;
        }

        public Buffer h(@NativeType(value="stbrp_coord") int n2) {
            STBRPRect.nh(this.address(), n2);
            return this;
        }

        public Buffer x(@NativeType(value="stbrp_coord") int n2) {
            STBRPRect.nx(this.address(), n2);
            return this;
        }

        public Buffer y(@NativeType(value="stbrp_coord") int n2) {
            STBRPRect.ny(this.address(), n2);
            return this;
        }

        public Buffer was_packed(@NativeType(value="int") boolean bl2) {
            STBRPRect.nwas_packed(this.address(), bl2 ? 1 : 0);
            return this;
        }
    }
}

