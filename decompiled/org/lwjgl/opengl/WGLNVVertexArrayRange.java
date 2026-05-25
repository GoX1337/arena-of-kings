/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLNVVertexArrayRange {
    protected WGLNVVertexArrayRange() {
        throw new UnsupportedOperationException();
    }

    public static long nwglAllocateMemoryNV(int n2, float f2, float f3, float f4) {
        long l2 = GL.getCapabilitiesWGL().wglAllocateMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(n2, f2, f3, f4, l2);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer wglAllocateMemoryNV(@NativeType(value="GLsizei") int n2, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        long l2 = WGLNVVertexArrayRange.nwglAllocateMemoryNV(n2, f2, f3, f4);
        return MemoryUtil.memByteBufferSafe(l2, n2);
    }

    public static void nwglFreeMemoryNV(long l2) {
        long l3 = GL.getCapabilitiesWGL().wglFreeMemoryNV;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.callPV(l2, l3);
    }

    public static void wglFreeMemoryNV(@NativeType(value="void *") ByteBuffer byteBuffer) {
        WGLNVVertexArrayRange.nwglFreeMemoryNV(MemoryUtil.memAddress(byteBuffer));
    }
}

