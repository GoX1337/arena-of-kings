/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTGPUProgramParameters {
    protected EXTGPUProgramParameters() {
        throw new UnsupportedOperationException();
    }

    public static native void nglProgramEnvParameters4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramEnvParameters4fvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTGPUProgramParameters.nglProgramEnvParameters4fvEXT(n2, n3, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglProgramLocalParameters4fvEXT(int var0, int var1, int var2, long var3);

    public static void glProgramLocalParameters4fvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        EXTGPUProgramParameters.nglProgramLocalParameters4fvEXT(n2, n3, floatBuffer.remaining() >> 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glProgramEnvParameters4fvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramEnvParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 2, fArray, l2);
    }

    public static void glProgramLocalParameters4fvEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramLocalParameters4fvEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 2, fArray, l2);
    }

    static {
        GL.initialize();
    }
}

