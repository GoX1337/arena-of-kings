/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XTimeCoord
extends Struct {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TIME;
    public static final int X;
    public static final int Y;

    public XTimeCoord(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XTimeCoord.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Time")
    public long time() {
        return XTimeCoord.ntime(this.address());
    }

    public short x() {
        return XTimeCoord.nx(this.address());
    }

    public short y() {
        return XTimeCoord.ny(this.address());
    }

    public static XTimeCoord create(long l2) {
        return XTimeCoord.wrap(XTimeCoord.class, l2);
    }

    @Nullable
    public static XTimeCoord createSafe(long l2) {
        return l2 == 0L ? null : XTimeCoord.wrap(XTimeCoord.class, l2);
    }

    public static Buffer create(long l2, int n2) {
        return XTimeCoord.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : XTimeCoord.wrap(Buffer.class, l2, n2);
    }

    public static long ntime(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)TIME);
    }

    public static short nx(long l2) {
        return UNSAFE.getShort(null, l2 + (long)X);
    }

    public static short ny(long l2) {
        return UNSAFE.getShort(null, l2 + (long)Y);
    }

    static {
        Struct.Layout layout = XTimeCoord.__struct(XTimeCoord.__member(CLONG_SIZE), XTimeCoord.__member(2), XTimeCoord.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TIME = layout.offsetof(0);
        X = layout.offsetof(1);
        Y = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<XTimeCoord, Buffer> {
        private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);

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
        protected XTimeCoord getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Time")
        public long time() {
            return XTimeCoord.ntime(this.address());
        }

        public short x() {
            return XTimeCoord.nx(this.address());
        }

        public short y() {
            return XTimeCoord.ny(this.address());
        }
    }
}

