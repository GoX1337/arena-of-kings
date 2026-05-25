/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct objc_method_description")
public class ObjCMethodDescription
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int TYPES;

    public ObjCMethodDescription(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), ObjCMethodDescription.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="SEL")
    public long name() {
        return ObjCMethodDescription.nname(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer types() {
        return ObjCMethodDescription.ntypes(this.address());
    }

    @NativeType(value="char *")
    public String typesString() {
        return ObjCMethodDescription.ntypesString(this.address());
    }

    public static ObjCMethodDescription malloc() {
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static ObjCMethodDescription calloc() {
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static ObjCMethodDescription create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static ObjCMethodDescription create(long l2) {
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, l2);
    }

    @Nullable
    public static ObjCMethodDescription createSafe(long l2) {
        return l2 == 0L ? null : ObjCMethodDescription.wrap(ObjCMethodDescription.class, l2);
    }

    public static Buffer malloc(int n2) {
        return ObjCMethodDescription.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(ObjCMethodDescription.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return ObjCMethodDescription.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = ObjCMethodDescription.__create(n2, SIZEOF);
        return ObjCMethodDescription.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return ObjCMethodDescription.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : ObjCMethodDescription.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack() {
        return ObjCMethodDescription.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription callocStack() {
        return ObjCMethodDescription.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack(MemoryStack memoryStack) {
        return ObjCMethodDescription.malloc(memoryStack);
    }

    @Deprecated
    public static ObjCMethodDescription callocStack(MemoryStack memoryStack) {
        return ObjCMethodDescription.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return ObjCMethodDescription.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return ObjCMethodDescription.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return ObjCMethodDescription.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return ObjCMethodDescription.calloc(n2, memoryStack);
    }

    public static ObjCMethodDescription malloc(MemoryStack memoryStack) {
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static ObjCMethodDescription calloc(MemoryStack memoryStack) {
        return ObjCMethodDescription.wrap(ObjCMethodDescription.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return ObjCMethodDescription.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return ObjCMethodDescription.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static long nname(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)NAME);
    }

    public static ByteBuffer ntypes(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)TYPES));
    }

    public static String ntypesString(long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)TYPES));
    }

    static {
        Struct.Layout layout = ObjCMethodDescription.__struct(ObjCMethodDescription.__member(POINTER_SIZE), ObjCMethodDescription.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        TYPES = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCMethodDescription, Buffer>
    implements NativeResource {
        private static final ObjCMethodDescription ELEMENT_FACTORY = ObjCMethodDescription.create(-1L);

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
        protected ObjCMethodDescription getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="SEL")
        public long name() {
            return ObjCMethodDescription.nname(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer types() {
            return ObjCMethodDescription.ntypes(this.address());
        }

        @NativeType(value="char *")
        public String typesString() {
            return ObjCMethodDescription.ntypesString(this.address());
        }
    }
}

