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

public class CGEventTapInformation
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTTAPID;
    public static final int TAPPOINT;
    public static final int OPTIONS;
    public static final int EVENTSOFINTEREST;
    public static final int TAPPINGPROCESS;
    public static final int PROCESSBEINGTAPPED;
    public static final int ENABLED;
    public static final int MINUSECLATENCY;
    public static final int AVGUSECLATENCY;
    public static final int MAXUSECLATENCY;

    public CGEventTapInformation(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CGEventTapInformation.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int eventTapID() {
        return CGEventTapInformation.neventTapID(this.address());
    }

    @NativeType(value="CGEventTapLocation")
    public int tapPoint() {
        return CGEventTapInformation.ntapPoint(this.address());
    }

    @NativeType(value="CGEventTapOptions")
    public int options() {
        return CGEventTapInformation.noptions(this.address());
    }

    @NativeType(value="CGEventMask")
    public long eventsOfInterest() {
        return CGEventTapInformation.neventsOfInterest(this.address());
    }

    @NativeType(value="pid_t")
    public long tappingProcess() {
        return CGEventTapInformation.ntappingProcess(this.address());
    }

    @NativeType(value="pid_t")
    public long processBeingTapped() {
        return CGEventTapInformation.nprocessBeingTapped(this.address());
    }

    @NativeType(value="bool")
    public boolean enabled() {
        return CGEventTapInformation.nenabled(this.address());
    }

    public float minUsecLatency() {
        return CGEventTapInformation.nminUsecLatency(this.address());
    }

    public float avgUsecLatency() {
        return CGEventTapInformation.navgUsecLatency(this.address());
    }

    public float maxUsecLatency() {
        return CGEventTapInformation.nmaxUsecLatency(this.address());
    }

    public static CGEventTapInformation malloc() {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static CGEventTapInformation calloc() {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static CGEventTapInformation create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return CGEventTapInformation.wrap(CGEventTapInformation.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CGEventTapInformation create(long l2) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, l2);
    }

    @Nullable
    public static CGEventTapInformation createSafe(long l2) {
        return l2 == 0L ? null : CGEventTapInformation.wrap(CGEventTapInformation.class, l2);
    }

    public static Buffer malloc(int n2) {
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(CGEventTapInformation.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = CGEventTapInformation.__create(n2, SIZEOF);
        return CGEventTapInformation.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return CGEventTapInformation.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : CGEventTapInformation.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static CGEventTapInformation mallocStack() {
        return CGEventTapInformation.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation callocStack() {
        return CGEventTapInformation.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation mallocStack(MemoryStack memoryStack) {
        return CGEventTapInformation.malloc(memoryStack);
    }

    @Deprecated
    public static CGEventTapInformation callocStack(MemoryStack memoryStack) {
        return CGEventTapInformation.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return CGEventTapInformation.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return CGEventTapInformation.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return CGEventTapInformation.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return CGEventTapInformation.calloc(n2, memoryStack);
    }

    public static CGEventTapInformation malloc(MemoryStack memoryStack) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static CGEventTapInformation calloc(MemoryStack memoryStack) {
        return CGEventTapInformation.wrap(CGEventTapInformation.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return CGEventTapInformation.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return CGEventTapInformation.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int neventTapID(long l2) {
        return UNSAFE.getInt(null, l2 + (long)EVENTTAPID);
    }

    public static int ntapPoint(long l2) {
        return UNSAFE.getInt(null, l2 + (long)TAPPOINT);
    }

    public static int noptions(long l2) {
        return UNSAFE.getInt(null, l2 + (long)OPTIONS);
    }

    public static long neventsOfInterest(long l2) {
        return UNSAFE.getLong(null, l2 + (long)EVENTSOFINTEREST);
    }

    public static long ntappingProcess(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)TAPPINGPROCESS);
    }

    public static long nprocessBeingTapped(long l2) {
        return MemoryUtil.memGetAddress(l2 + (long)PROCESSBEINGTAPPED);
    }

    public static boolean nenabled(long l2) {
        return UNSAFE.getByte(null, l2 + (long)ENABLED) != 0;
    }

    public static float nminUsecLatency(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)MINUSECLATENCY);
    }

    public static float navgUsecLatency(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)AVGUSECLATENCY);
    }

    public static float nmaxUsecLatency(long l2) {
        return UNSAFE.getFloat(null, l2 + (long)MAXUSECLATENCY);
    }

    static {
        Struct.Layout layout = CGEventTapInformation.__struct(CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(8), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(1), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EVENTTAPID = layout.offsetof(0);
        TAPPOINT = layout.offsetof(1);
        OPTIONS = layout.offsetof(2);
        EVENTSOFINTEREST = layout.offsetof(3);
        TAPPINGPROCESS = layout.offsetof(4);
        PROCESSBEINGTAPPED = layout.offsetof(5);
        ENABLED = layout.offsetof(6);
        MINUSECLATENCY = layout.offsetof(7);
        AVGUSECLATENCY = layout.offsetof(8);
        MAXUSECLATENCY = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<CGEventTapInformation, Buffer>
    implements NativeResource {
        private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);

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
        protected CGEventTapInformation getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int eventTapID() {
            return CGEventTapInformation.neventTapID(this.address());
        }

        @NativeType(value="CGEventTapLocation")
        public int tapPoint() {
            return CGEventTapInformation.ntapPoint(this.address());
        }

        @NativeType(value="CGEventTapOptions")
        public int options() {
            return CGEventTapInformation.noptions(this.address());
        }

        @NativeType(value="CGEventMask")
        public long eventsOfInterest() {
            return CGEventTapInformation.neventsOfInterest(this.address());
        }

        @NativeType(value="pid_t")
        public long tappingProcess() {
            return CGEventTapInformation.ntappingProcess(this.address());
        }

        @NativeType(value="pid_t")
        public long processBeingTapped() {
            return CGEventTapInformation.nprocessBeingTapped(this.address());
        }

        @NativeType(value="bool")
        public boolean enabled() {
            return CGEventTapInformation.nenabled(this.address());
        }

        public float minUsecLatency() {
            return CGEventTapInformation.nminUsecLatency(this.address());
        }

        public float avgUsecLatency() {
            return CGEventTapInformation.navgUsecLatency(this.address());
        }

        public float maxUsecLatency() {
            return CGEventTapInformation.nmaxUsecLatency(this.address());
        }
    }
}

