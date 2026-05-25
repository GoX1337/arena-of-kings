/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class GLXStereoNotifyEventEXT
extends Struct {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;
    public static final int WINDOW;
    public static final int STEREO_TREE;

    public GLXStereoNotifyEventEXT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLXStereoNotifyEventEXT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return GLXStereoNotifyEventEXT.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return GLXStereoNotifyEventEXT.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return GLXStereoNotifyEventEXT.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return GLXStereoNotifyEventEXT.ndisplay(this.address());
    }

    public int extension() {
        return GLXStereoNotifyEventEXT.nextension(this.address());
    }

    public int evtype() {
        return GLXStereoNotifyEventEXT.nevtype(this.address());
    }

    @NativeType(value="GLXDrawable")
    public long window() {
        return GLXStereoNotifyEventEXT.nwindow(this.address());
    }

    @NativeType(value="Bool")
    public boolean stereo_tree() {
        return GLXStereoNotifyEventEXT.nstereo_tree(this.address()) != 0;
    }

    public static GLXStereoNotifyEventEXT create(long l2) {
        return GLXStereoNotifyEventEXT.wrap(GLXStereoNotifyEventEXT.class, l2);
    }

    @Nullable
    public static GLXStereoNotifyEventEXT createSafe(long l2) {
        return l2 == 0L ? null : GLXStereoNotifyEventEXT.wrap(GLXStereoNotifyEventEXT.class, l2);
    }

    public static Buffer create(long l2, int n2) {
        return GLXStereoNotifyEventEXT.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : GLXStereoNotifyEventEXT.wrap(Buffer.class, l2, n2);
    }

    public static int ntype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TYPE);
    }

    public static long nserial(long l2) {
        return MemoryUtil.memGetCLong(l2 + (long)SERIAL);
    }

    public static int nsend_event(long l2) {
        return UNSAFE.getInt(null, l2 + (long)SEND_EVENT);
    }

    public static long ndisplay(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)DISPLAY);
    }

    public static int nextension(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EXTENSION);
    }

    public static int nevtype(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EVTYPE);
    }

    public static long nwindow(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)WINDOW);
    }

    public static int nstereo_tree(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STEREO_TREE);
    }

    static {
        Struct.Layout layout = GLXStereoNotifyEventEXT.__struct(GLXStereoNotifyEventEXT.__member(4), GLXStereoNotifyEventEXT.__member(CLONG_SIZE), GLXStereoNotifyEventEXT.__member(4), GLXStereoNotifyEventEXT.__member(POINTER_SIZE), GLXStereoNotifyEventEXT.__member(4), GLXStereoNotifyEventEXT.__member(4), GLXStereoNotifyEventEXT.__member(POINTER_SIZE), GLXStereoNotifyEventEXT.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
        WINDOW = layout.offsetof(6);
        STEREO_TREE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<GLXStereoNotifyEventEXT, Buffer> {
        private static final GLXStereoNotifyEventEXT ELEMENT_FACTORY = GLXStereoNotifyEventEXT.create(-1L);

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
        protected GLXStereoNotifyEventEXT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return GLXStereoNotifyEventEXT.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return GLXStereoNotifyEventEXT.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return GLXStereoNotifyEventEXT.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return GLXStereoNotifyEventEXT.ndisplay(this.address());
        }

        public int extension() {
            return GLXStereoNotifyEventEXT.nextension(this.address());
        }

        public int evtype() {
            return GLXStereoNotifyEventEXT.nevtype(this.address());
        }

        @NativeType(value="GLXDrawable")
        public long window() {
            return GLXStereoNotifyEventEXT.nwindow(this.address());
        }

        @NativeType(value="Bool")
        public boolean stereo_tree() {
            return GLXStereoNotifyEventEXT.nstereo_tree(this.address()) != 0;
        }
    }
}

