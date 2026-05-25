/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;

public final class ThreadLocalUtil {
    private static final long JNI_NATIVE_INTERFACE;
    private static final int JNI_NATIVE_INTERFACE_FUNCTION_COUNT;
    private static final long FUNCTION_MISSING_ABORT;
    private static final int CAPABILITIES_OFFSET;

    private ThreadLocalUtil() {
    }

    private static native long getThreadJNIEnv();

    private static native long getFunctionMissingAbort();

    private static native long nsetupEnvData(int var0);

    public static long setupEnvData() {
        return ThreadLocalUtil.nsetupEnvData(JNI_NATIVE_INTERFACE_FUNCTION_COUNT);
    }

    public static void setCapabilities(long l2) {
        long l3 = ThreadLocalUtil.getThreadJNIEnv();
        long l4 = MemoryUtil.memGetAddress(l3);
        if (l2 == 0L) {
            if (l4 != JNI_NATIVE_INTERFACE) {
                MemoryUtil.memPutAddress(l4 + (long)CAPABILITIES_OFFSET, MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE + (long)CAPABILITIES_OFFSET));
            }
        } else {
            if (l4 == JNI_NATIVE_INTERFACE) {
                ThreadLocalUtil.setupEnvData();
                l4 = MemoryUtil.memGetAddress(l3);
            }
            MemoryUtil.memPutAddress(l4 + (long)CAPABILITIES_OFFSET, l2);
        }
    }

    public static void setFunctionMissingAddresses(int n2) {
        long l2 = JNI_NATIVE_INTERFACE + (long)CAPABILITIES_OFFSET;
        if (n2 == 0) {
            long l3 = MemoryUtil.memGetAddress(l2);
            if (l3 != 0L) {
                MemoryUtil.getAllocator().free(l3);
                MemoryUtil.memPutAddress(l2, 0L);
            }
        } else {
            long l4 = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(n2) * (long)Pointer.POINTER_SIZE);
            for (int i2 = 0; i2 < n2; ++i2) {
                MemoryUtil.memPutAddress(l4 + Integer.toUnsignedLong(i2) * (long)Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
            }
            MemoryUtil.memPutAddress(l2, l4);
        }
    }

    public static PointerBuffer setupAddressBuffer(PointerBuffer pointerBuffer) {
        for (int i2 = pointerBuffer.position(); i2 < pointerBuffer.limit(); ++i2) {
            if (pointerBuffer.get(i2) != 0L) continue;
            pointerBuffer.put(i2, FUNCTION_MISSING_ABORT);
        }
        return pointerBuffer;
    }

    public static boolean areCapabilitiesDifferent(PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        for (int i2 = 0; i2 < pointerBuffer.remaining(); ++i2) {
            if (pointerBuffer.get(i2) == pointerBuffer2.get(i2) || pointerBuffer2.get(i2) == 0L) continue;
            return true;
        }
        return false;
    }

    static {
        int n2;
        int n3;
        JNI_NATIVE_INTERFACE = MemoryUtil.memGetAddress(ThreadLocalUtil.getThreadJNIEnv());
        FUNCTION_MISSING_ABORT = ThreadLocalUtil.getFunctionMissingAbort();
        CAPABILITIES_OFFSET = 3 * Pointer.POINTER_SIZE;
        int n4 = JNINativeInterface.GetVersion();
        switch (n4) {
            case 65537: {
                n3 = 12;
                break;
            }
            default: {
                n3 = 4;
            }
        }
        switch (n4) {
            case 65537: {
                n2 = 208;
                break;
            }
            case 65538: {
                n2 = 225;
                break;
            }
            case 65540: {
                n2 = 228;
                break;
            }
            case 65542: 
            case 65544: {
                n2 = 229;
                break;
            }
            case 589824: 
            case 655360: {
                n2 = 230;
                break;
            }
            default: {
                n2 = 230;
                APIUtil.DEBUG_STREAM.println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers.");
            }
        }
        JNI_NATIVE_INTERFACE_FUNCTION_COUNT = n3 + n2;
    }
}

