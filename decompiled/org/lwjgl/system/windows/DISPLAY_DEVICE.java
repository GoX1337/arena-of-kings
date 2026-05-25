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

public class DISPLAY_DEVICE
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CB;
    public static final int DEVICENAME;
    public static final int DEVICESTRING;
    public static final int STATEFLAGS;
    public static final int DEVICEID;
    public static final int DEVICEKEY;

    public DISPLAY_DEVICE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), DISPLAY_DEVICE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cb() {
        return DISPLAY_DEVICE.ncb(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer DeviceName() {
        return DISPLAY_DEVICE.nDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String DeviceNameString() {
        return DISPLAY_DEVICE.nDeviceNameString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceString() {
        return DISPLAY_DEVICE.nDeviceString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceStringString() {
        return DISPLAY_DEVICE.nDeviceStringString(this.address());
    }

    @NativeType(value="DWORD")
    public int StateFlags() {
        return DISPLAY_DEVICE.nStateFlags(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceID() {
        return DISPLAY_DEVICE.nDeviceID(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceIDString() {
        return DISPLAY_DEVICE.nDeviceIDString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceKey() {
        return DISPLAY_DEVICE.nDeviceKey(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceKeyString() {
        return DISPLAY_DEVICE.nDeviceKeyString(this.address());
    }

    public DISPLAY_DEVICE cb(@NativeType(value="DWORD") int n2) {
        DISPLAY_DEVICE.ncb(this.address(), n2);
        return this;
    }

    public DISPLAY_DEVICE set(DISPLAY_DEVICE dISPLAY_DEVICE) {
        MemoryUtil.memCopy(dISPLAY_DEVICE.address(), this.address(), SIZEOF);
        return this;
    }

    public static DISPLAY_DEVICE malloc() {
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static DISPLAY_DEVICE calloc() {
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static DISPLAY_DEVICE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static DISPLAY_DEVICE create(long l2) {
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, l2);
    }

    @Nullable
    public static DISPLAY_DEVICE createSafe(long l2) {
        return l2 == 0L ? null : DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, l2);
    }

    public static Buffer malloc(int n2) {
        return DISPLAY_DEVICE.wrap(Buffer.class, MemoryUtil.nmemAllocChecked(DISPLAY_DEVICE.__checkMalloc(n2, SIZEOF)), n2);
    }

    public static Buffer calloc(int n2) {
        return DISPLAY_DEVICE.wrap(Buffer.class, MemoryUtil.nmemCallocChecked(n2, SIZEOF), n2);
    }

    public static Buffer create(int n2) {
        ByteBuffer byteBuffer = DISPLAY_DEVICE.__create(n2, SIZEOF);
        return DISPLAY_DEVICE.wrap(Buffer.class, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer);
    }

    public static Buffer create(long l2, int n2) {
        return DISPLAY_DEVICE.wrap(Buffer.class, l2, n2);
    }

    @Nullable
    public static Buffer createSafe(long l2, int n2) {
        return l2 == 0L ? null : DISPLAY_DEVICE.wrap(Buffer.class, l2, n2);
    }

    @Deprecated
    public static DISPLAY_DEVICE mallocStack() {
        return DISPLAY_DEVICE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack() {
        return DISPLAY_DEVICE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE mallocStack(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.malloc(memoryStack);
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n2) {
        return DISPLAY_DEVICE.malloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n2) {
        return DISPLAY_DEVICE.calloc(n2, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n2, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.malloc(n2, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n2, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.calloc(n2, memoryStack);
    }

    public static DISPLAY_DEVICE malloc(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static DISPLAY_DEVICE calloc(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.wrap(DISPLAY_DEVICE.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static Buffer malloc(int n2, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.wrap(Buffer.class, memoryStack.nmalloc(ALIGNOF, n2 * SIZEOF), n2);
    }

    public static Buffer calloc(int n2, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.wrap(Buffer.class, memoryStack.ncalloc(ALIGNOF, n2, SIZEOF), n2);
    }

    public static int ncb(long l2) {
        return UNSAFE.getInt(null, l2 + (long)CB);
    }

    public static ByteBuffer nDeviceName(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DEVICENAME, 64);
    }

    public static String nDeviceNameString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DEVICENAME);
    }

    public static ByteBuffer nDeviceString(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DEVICESTRING, 256);
    }

    public static String nDeviceStringString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DEVICESTRING);
    }

    public static int nStateFlags(long l2) {
        return UNSAFE.getInt(null, l2 + (long)STATEFLAGS);
    }

    public static ByteBuffer nDeviceID(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DEVICEID, 256);
    }

    public static String nDeviceIDString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DEVICEID);
    }

    public static ByteBuffer nDeviceKey(long l2) {
        return MemoryUtil.memByteBuffer(l2 + (long)DEVICEKEY, 256);
    }

    public static String nDeviceKeyString(long l2) {
        return MemoryUtil.memUTF16(l2 + (long)DEVICEKEY);
    }

    public static void ncb(long l2, int n2) {
        UNSAFE.putInt(null, l2 + (long)CB, n2);
    }

    static {
        Struct.Layout layout = DISPLAY_DEVICE.__struct(DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 32), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__array(2, 128));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CB = layout.offsetof(0);
        DEVICENAME = layout.offsetof(1);
        DEVICESTRING = layout.offsetof(2);
        STATEFLAGS = layout.offsetof(3);
        DEVICEID = layout.offsetof(4);
        DEVICEKEY = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<DISPLAY_DEVICE, Buffer>
    implements NativeResource {
        private static final DISPLAY_DEVICE ELEMENT_FACTORY = DISPLAY_DEVICE.create(-1L);

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
        protected DISPLAY_DEVICE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cb() {
            return DISPLAY_DEVICE.ncb(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer DeviceName() {
            return DISPLAY_DEVICE.nDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String DeviceNameString() {
            return DISPLAY_DEVICE.nDeviceNameString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceString() {
            return DISPLAY_DEVICE.nDeviceString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceStringString() {
            return DISPLAY_DEVICE.nDeviceStringString(this.address());
        }

        @NativeType(value="DWORD")
        public int StateFlags() {
            return DISPLAY_DEVICE.nStateFlags(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceID() {
            return DISPLAY_DEVICE.nDeviceID(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceIDString() {
            return DISPLAY_DEVICE.nDeviceIDString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceKey() {
            return DISPLAY_DEVICE.nDeviceKey(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceKeyString() {
            return DISPLAY_DEVICE.nDeviceKeyString(this.address());
        }

        public Buffer cb(@NativeType(value="DWORD") int n2) {
            DISPLAY_DEVICE.ncb(this.address(), n2);
            return this;
        }
    }
}

