/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVTransformFeedback {
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
    public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
    public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
    public static final int GL_RASTERIZER_DISCARD_NV = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
    public static final int GL_ACTIVE_VARYINGS_NV = 35969;
    public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
    public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
    public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
    public static final int GL_TEXTURE_COORD_NV = 35961;
    public static final int GL_CLIP_DISTANCE_NV = 35962;
    public static final int GL_VERTEX_ID_NV = 35963;
    public static final int GL_PRIMITIVE_ID_NV = 35964;
    public static final int GL_GENERIC_ATTRIB_NV = 35965;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_LAYER_NV = 36266;

    protected NVTransformFeedback() {
        throw new UnsupportedOperationException();
    }

    public static native void glBeginTransformFeedbackNV(@NativeType(value="GLenum") int var0);

    public static native void glEndTransformFeedbackNV();

    public static native void nglTransformFeedbackAttribsNV(int var0, long var1, int var3);

    public static void glTransformFeedbackAttribsNV(@NativeType(value="GLint const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n2) {
        NVTransformFeedback.nglTransformFeedbackAttribsNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), n2);
    }

    public static native void glBindBufferRangeNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glBindBufferOffsetNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3);

    public static native void glBindBufferBaseNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglTransformFeedbackVaryingsNV(int var0, int var1, long var2, int var4);

    public static void glTransformFeedbackVaryingsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer, @NativeType(value="GLenum") int n3) {
        NVTransformFeedback.nglTransformFeedbackVaryingsNV(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), n3);
    }

    public static native void nglActiveVaryingNV(int var0, long var1);

    public static void glActiveVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        NVTransformFeedback.nglActiveVaryingNV(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glActiveVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            NVTransformFeedback.nglActiveVaryingNV(n2, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native int nglGetVaryingLocationNV(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetVaryingLocationNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return NVTransformFeedback.nglGetVaryingLocationNV(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetVaryingLocationNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = NVTransformFeedback.nglGetVaryingLocationNV(n2, l2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGetActiveVaryingNV(int var0, int var1, int var2, long var3, long var5, long var7, long var9);

    public static void glGetActiveVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLsizei *") IntBuffer intBuffer2, @NativeType(value="GLenum *") IntBuffer intBuffer3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check((Buffer)intBuffer3, 1);
        }
        NVTransformFeedback.nglGetActiveVaryingNV(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(intBuffer3), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetTransformFeedbackVaryingNV(int var0, int var1, long var2);

    public static void glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVTransformFeedback.nglGetTransformFeedbackVaryingNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVTransformFeedback.nglGetTransformFeedbackVaryingNV(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglTransformFeedbackStreamAttribsNV(int var0, long var1, int var3, long var4, int var6);

    public static void glTransformFeedbackStreamAttribsNV(@NativeType(value="GLint const *") IntBuffer intBuffer, @NativeType(value="GLint const *") IntBuffer intBuffer2, @NativeType(value="GLenum") int n2) {
        NVTransformFeedback.nglTransformFeedbackStreamAttribsNV(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), intBuffer2.remaining(), MemoryUtil.memAddress(intBuffer2), n2);
    }

    public static void glTransformFeedbackAttribsNV(@NativeType(value="GLint const *") int[] nArray, @NativeType(value="GLenum") int n2) {
        long l2 = GL.getICD().glTransformFeedbackAttribsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, n2, l2);
    }

    public static void glTransformFeedbackVaryingsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint const *") int[] nArray, @NativeType(value="GLenum") int n3) {
        long l2 = GL.getICD().glTransformFeedbackVaryingsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, n3, l2);
    }

    public static void glGetActiveVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLsizei *") int[] nArray2, @NativeType(value="GLenum *") int[] nArray3, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetActiveVaryingNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(nArray3, 1);
        }
        JNI.callPPPPV(n2, n3, byteBuffer.remaining(), nArray, nArray2, nArray3, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetTransformFeedbackVaryingNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetTransformFeedbackVaryingNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glTransformFeedbackStreamAttribsNV(@NativeType(value="GLint const *") int[] nArray, @NativeType(value="GLint const *") int[] nArray2, @NativeType(value="GLenum") int n2) {
        long l2 = GL.getICD().glTransformFeedbackStreamAttribsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(nArray.length, nArray, nArray2.length, nArray2, n2, l2);
    }

    static {
        GL.initialize();
    }
}

