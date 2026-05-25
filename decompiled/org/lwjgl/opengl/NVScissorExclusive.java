/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVScissorExclusive {
    public static final int GL_SCISSOR_TEST_EXCLUSIVE_NV = 38229;
    public static final int GL_SCISSOR_BOX_EXCLUSIVE_NV = 38230;

    protected NVScissorExclusive() {
        throw new UnsupportedOperationException();
    }

    public static native void nglScissorExclusiveArrayvNV(int var0, int var1, long var2);

    public static void glScissorExclusiveArrayvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        NVScissorExclusive.nglScissorExclusiveArrayvNV(n2, intBuffer.remaining() >> 2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glScissorExclusiveNV(@NativeType(value="GLint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLsizei") int var2, @NativeType(value="GLsizei") int var3);

    public static void glScissorExclusiveArrayvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glScissorExclusiveArrayvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length >> 2, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

