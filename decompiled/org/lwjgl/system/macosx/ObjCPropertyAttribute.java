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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct objc_property_attribute_t")
public class ObjCPropertyAttribute
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int VALUE;

    public ObjCPropertyAttribute(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), ObjCPropertyAttribute.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return ObjCPropertyAttribute.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return ObjCPropertyAttribute.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer value() {
        return ObjCPropertyAttribute.nvalue(this.address());
    }

    @NativeType(value="char *")
    public String valueString() {
        return ObjCPropertyAttribute.nvalueString(this.address());
    }

    public ObjCPropertyAttribute name(@NativeType(value="char *") ByteBuffer byteBuffer) {
        ObjCPropertyAttribute.nname(this.address(), byteBuffer);
        return this;
    }

    public ObjCPropertyAttribute value(@NativeType(value="char *") ByteBuffer byteBuffer) {
        ObjCPropertyAttribute.nvalue(this.address(), byteBuffer);
        return this;
    }

    public ObjCPropertyAttribute set(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        this.name(byteBuffer);
        this.value(byteBuffer2);
        return this;
    }

    public ObjCPropertyAttribute set(ObjCPropertyAttribute objCPropertyAttribute) {
        MemoryUtil.memCopy(objCPropertyAttribute.address(), this.address(), SIZEOF);
        return this;
    }

    public static ObjCPropertyAttribute malloc() {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static ObjCPropertyAttribute calloc() {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static ObjCPropertyAttribute create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static ObjCPropertyAttribute create(long l2) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, l2);
    }

    @Nullable
    public static ObjCPropertyAttribute createSafe(long l2) {
        return l2 == 0L ? null : ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, l2);
    }

    public static Buffer malloc(int n2) {
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(ObjCPropertyAttribute.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = ObjCPropertyAttribute.__create(n2, SIZEOF);
        return ObjCPropertyAttribute.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return ObjCPropertyAttribute.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : ObjCPropertyAttribute.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static ObjCPropertyAttribute mallocStack() {
        return ObjCPropertyAttribute.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCPropertyAttribute callocStack() {
        return ObjCPropertyAttribute.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCPropertyAttribute mallocStack(MemoryStack memoryStack) {
        return ObjCPropertyAttribute.malloc(memoryStack);
    }

    @Deprecated
    public static ObjCPropertyAttribute callocStack(MemoryStack memoryStack) {
        return ObjCPropertyAttribute.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return ObjCPropertyAttribute.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return ObjCPropertyAttribute.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return ObjCPropertyAttribute.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return ObjCPropertyAttribute.calloc(n2, memoryStack);
    }

    public static ObjCPropertyAttribute malloc(MemoryStack memoryStack) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static ObjCPropertyAttribute calloc(MemoryStack memoryStack) {
        return ObjCPropertyAttribute.wrap(ObjCPropertyAttribute.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return ObjCPropertyAttribute.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return ObjCPropertyAttribute.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static ByteBuffer nname(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)NAME));
    }

    public static String nnameString(long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)NAME));
    }

    public static ByteBuffer nvalue(long l2) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l2 + (long)VALUE));
    }

    public static String nvalueString(long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)VALUE));
    }

    public static void nname(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)NAME, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nvalue(long l2, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l2 + (long)VALUE, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)VALUE));
    }

    static {
        Struct.Layout layout = ObjCPropertyAttribute.__struct(ObjCPropertyAttribute.__member(POINTER_SIZE), ObjCPropertyAttribute.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        VALUE = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCPropertyAttribute, Buffer>
    implements NativeResource {
        private static final ObjCPropertyAttribute ELEMENT_FACTORY = ObjCPropertyAttribute.create(-1L);

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
        protected ObjCPropertyAttribute getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return ObjCPropertyAttribute.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return ObjCPropertyAttribute.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer value() {
            return ObjCPropertyAttribute.nvalue(this.address());
        }

        @NativeType(value="char *")
        public String valueString() {
            return ObjCPropertyAttribute.nvalueString(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer byteBuffer) {
            ObjCPropertyAttribute.nname(this.address(), byteBuffer);
            return this;
        }

        public Buffer value(@NativeType(value="char *") ByteBuffer byteBuffer) {
            ObjCPropertyAttribute.nvalue(this.address(), byteBuffer);
            return this;
        }
    }
}

