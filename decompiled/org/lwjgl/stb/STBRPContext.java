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
import org.lwjgl.stb.STBRPNode;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct stbrp_context")
public class STBRPContext
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int ALIGN;
    public static final int INIT_MODE;
    public static final int HEURISTIC;
    public static final int NUM_NODES;
    public static final int ACTIVE_HEAD;
    public static final int FREE_HEAD;
    public static final int EXTRA;

    public STBRPContext(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), STBRPContext.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int width() {
        return STBRPContext.nwidth(this.address());
    }

    public int height() {
        return STBRPContext.nheight(this.address());
    }

    public int align() {
        return STBRPContext.nalign(this.address());
    }

    public int init_mode() {
        return STBRPContext.ninit_mode(this.address());
    }

    public int heuristic() {
        return STBRPContext.nheuristic(this.address());
    }

    public int num_nodes() {
        return STBRPContext.nnum_nodes(this.address());
    }

    @Nullable
    @NativeType(value="stbrp_node *")
    public STBRPNode active_head() {
        return STBRPContext.nactive_head(this.address());
    }

    @Nullable
    @NativeType(value="stbrp_node *")
    public STBRPNode free_head() {
        return STBRPContext.nfree_head(this.address());
    }

    @NativeType(value="stbrp_node[2]")
    public STBRPNode.Buffer extra() {
        return STBRPContext.nextra(this.address());
    }

    @NativeType(value="stbrp_node")
    public STBRPNode extra(int n2) {
        return STBRPContext.nextra(this.address(), n2);
    }

    public static STBRPContext malloc() {
        return STBRPContext.wrap(STBRPContext.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static STBRPContext calloc() {
        return STBRPContext.wrap(STBRPContext.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static STBRPContext create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return STBRPContext.wrap(STBRPContext.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static STBRPContext create(long l2) {
        return STBRPContext.wrap(STBRPContext.class, l2);
    }

    @Nullable
    public static STBRPContext createSafe(long l2) {
        return l2 == 0L ? null : STBRPContext.wrap(STBRPContext.class, l2);
    }

    public static Buffer malloc(int n2) {
        return STBRPContext.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(STBRPContext.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return STBRPContext.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = STBRPContext.__create(n2, SIZEOF);
        return STBRPContext.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return STBRPContext.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : STBRPContext.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static STBRPContext mallocStack() {
        return STBRPContext.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPContext callocStack() {
        return STBRPContext.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static STBRPContext mallocStack(MemoryStack memoryStack) {
        return STBRPContext.malloc(memoryStack);
    }

    @Deprecated
    public static STBRPContext callocStack(MemoryStack memoryStack) {
        return STBRPContext.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return STBRPContext.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return STBRPContext.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return STBRPContext.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return STBRPContext.calloc(n2, memoryStack);
    }

    public static STBRPContext malloc(MemoryStack memoryStack) {
        return STBRPContext.wrap(STBRPContext.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static STBRPContext calloc(MemoryStack memoryStack) {
        return STBRPContext.wrap(STBRPContext.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return STBRPContext.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return STBRPContext.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int nwidth(long l2) {
        return UNSAFE.getInt(null, l2 + (long)WIDTH);
    }

    public static int nheight(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEIGHT);
    }

    public static int nalign(long l2) {
        return UNSAFE.getInt(null, l2 + (long)ALIGN);
    }

    public static int ninit_mode(long l2) {
        return UNSAFE.getInt(null, l2 + (long)INIT_MODE);
    }

    public static int nheuristic(long l2) {
        return UNSAFE.getInt(null, l2 + (long)HEURISTIC);
    }

    public static int nnum_nodes(long l2) {
        return UNSAFE.getInt(null, l2 + (long)NUM_NODES);
    }

    @Nullable
    public static STBRPNode nactive_head(long l2) {
        return STBRPNode.createSafe(MemoryUtil.memGetAddress(l2 + (long)ACTIVE_HEAD));
    }

    @Nullable
    public static STBRPNode nfree_head(long l2) {
        return STBRPNode.createSafe(MemoryUtil.memGetAddress(l2 + (long)FREE_HEAD));
    }

    public static STBRPNode.Buffer nextra(long l2) {
        return STBRPNode.create(l2 + (long)EXTRA, 2);
    }

    public static STBRPNode nextra(long l2, int n2) {
        return STBRPNode.create(l2 + (long)EXTRA + Checks.check(n2, 2) * (long)STBRPNode.SIZEOF);
    }

    static {
        Struct.Layout layout = STBRPContext.__struct(STBRPContext.__member(4), STBRPContext.__member(4), STBRPContext.__member(4), STBRPContext.__member(4), STBRPContext.__member(4), STBRPContext.__member(4), STBRPContext.__member(POINTER_SIZE), STBRPContext.__member(POINTER_SIZE), STBRPContext.__array(STBRPNode.SIZEOF, STBRPNode.ALIGNOF, 2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        ALIGN = layout.offsetof(2);
        INIT_MODE = layout.offsetof(3);
        HEURISTIC = layout.offsetof(4);
        NUM_NODES = layout.offsetof(5);
        ACTIVE_HEAD = layout.offsetof(6);
        FREE_HEAD = layout.offsetof(7);
        EXTRA = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<STBRPContext, Buffer>
    implements NativeResource {
        private static final STBRPContext ELEMENT_FACTORY = STBRPContext.create(-1L);

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
        protected STBRPContext getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int width() {
            return STBRPContext.nwidth(this.address());
        }

        public int height() {
            return STBRPContext.nheight(this.address());
        }

        public int align() {
            return STBRPContext.nalign(this.address());
        }

        public int init_mode() {
            return STBRPContext.ninit_mode(this.address());
        }

        public int heuristic() {
            return STBRPContext.nheuristic(this.address());
        }

        public int num_nodes() {
            return STBRPContext.nnum_nodes(this.address());
        }

        @Nullable
        @NativeType(value="stbrp_node *")
        public STBRPNode active_head() {
            return STBRPContext.nactive_head(this.address());
        }

        @Nullable
        @NativeType(value="stbrp_node *")
        public STBRPNode free_head() {
            return STBRPContext.nfree_head(this.address());
        }

        @NativeType(value="stbrp_node[2]")
        public STBRPNode.Buffer extra() {
            return STBRPContext.nextra(this.address());
        }

        @NativeType(value="stbrp_node")
        public STBRPNode extra(int n2) {
            return STBRPContext.nextra(this.address(), n2);
        }
    }
}

