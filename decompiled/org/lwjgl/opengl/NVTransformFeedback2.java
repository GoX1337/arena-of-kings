/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;

    protected NVTransformFeedback2() {
        throw new UnsupportedOperationException();
    }

    public static native void glBindTransformFeedbackNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglDeleteTransformFeedbacksNV(int var0, long var1);

    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        NVTransformFeedback2.nglDeleteTransformFeedbacksNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            NVTransformFeedback2.nglDeleteTransformFeedbacksNV(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGenTransformFeedbacksNV(int var0, long var1);

    public static void glGenTransformFeedbacksNV(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVTransformFeedback2.nglGenTransformFeedbacksNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenTransformFeedbacksNV() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVTransformFeedback2.nglGenTransformFeedbacksNV(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsTransformFeedbackNV(@NativeType(value="GLuint") int var0);

    public static native void glPauseTransformFeedbackNV();

    public static native void glResumeTransformFeedbackNV();

    public static native void glDrawTransformFeedbackNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static void glDeleteTransformFeedbacksNV(@NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glDeleteTransformFeedbacksNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glGenTransformFeedbacksNV(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenTransformFeedbacksNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

