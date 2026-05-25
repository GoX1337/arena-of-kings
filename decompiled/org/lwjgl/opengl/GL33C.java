/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL32C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL33C
extends GL32C {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    protected GL33C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglBindFragDataLocationIndexed(int var0, int var1, int var2, long var3);

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        GL33C.nglBindFragDataLocationIndexed(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            GL33C.nglBindFragDataLocationIndexed(n2, n3, n4, l2);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native int nglGetFragDataIndex(int var0, long var1);

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GL33C.nglGetFragDataIndex(n2, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n4 = GL33C.nglGetFragDataIndex(n2, l2);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nglGenSamplers(int var0, long var1);

    public static void glGenSamplers(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL33C.nglGenSamplers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenSamplers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL33C.nglGenSamplers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglDeleteSamplers(int var0, long var1);

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL33C.nglDeleteSamplers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            GL33C.nglDeleteSamplers(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsSampler(@NativeType(value="GLuint") int var0);

    public static native void glBindSampler(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glSamplerParameteri(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void glSamplerParameterf(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglSamplerParameteriv(int var0, int var1, long var2);

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglSamplerParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglSamplerParameterfv(int var0, int var1, long var2);

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        GL33C.nglSamplerParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglSamplerParameterIiv(int var0, int var1, long var2);

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglSamplerParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglSamplerParameterIuiv(int var0, int var1, long var2);

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglSamplerParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetSamplerParameteriv(int var0, int var1, long var2);

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglGetSamplerParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameteri(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL33C.nglGetSamplerParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetSamplerParameterfv(int var0, int var1, long var2);

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        GL33C.nglGetSamplerParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetSamplerParameterf(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            GL33C.nglGetSamplerParameterfv(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetSamplerParameterIiv(int var0, int var1, long var2);

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglGetSamplerParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameterIi(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL33C.nglGetSamplerParameterIiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetSamplerParameterIuiv(int var0, int var1, long var2);

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglGetSamplerParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetSamplerParameterIui(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL33C.nglGetSamplerParameterIuiv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glQueryCounter(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglGetQueryObjecti64v(int var0, int var1, long var2);

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        GL33C.nglGetQueryObjecti64v(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long l2) {
        GL33C.nglGetQueryObjecti64v(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL33C.nglGetQueryObjecti64v(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetQueryObjectui64v(int var0, int var1, long var2);

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        GL33C.nglGetQueryObjectui64v(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long l2) {
        GL33C.nglGetQueryObjectui64v(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL33C.nglGetQueryObjectui64v(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glVertexAttribDivisor(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexAttribP1ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP2ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP3ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribP4ui(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLboolean") boolean var2, @NativeType(value="GLuint") int var3);

    public static native void nglVertexAttribP1uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglVertexAttribP1uiv(n2, n3, bl2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglVertexAttribP2uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglVertexAttribP2uiv(n2, n3, bl2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglVertexAttribP3uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglVertexAttribP3uiv(n2, n3, bl2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglVertexAttribP4uiv(int var0, int var1, boolean var2, long var3);

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL33C.nglVertexAttribP4uiv(n2, n3, bl2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGenSamplers(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenSamplers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glDeleteSamplers(@NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glDeleteSamplers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glSamplerParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glSamplerParameterfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glSamplerParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glSamplerParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetSamplerParameteriv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetSamplerParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetSamplerParameterfv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetSamplerParameterfv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetSamplerParameterIiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetSamplerParameterIiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetSamplerParameterIuiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetSamplerParameterIuiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetQueryObjecti64v;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetQueryObjectui64v;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glVertexAttribP1uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexAttribP1uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, bl2, nArray, l2);
    }

    public static void glVertexAttribP2uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexAttribP2uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, bl2, nArray, l2);
    }

    public static void glVertexAttribP3uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexAttribP3uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, bl2, nArray, l2);
    }

    public static void glVertexAttribP4uiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glVertexAttribP4uiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, bl2, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

