/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBRobustness {
    public static final int GL_GUILTY_CONTEXT_RESET_ARB = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 33364;
    public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 33365;
    public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
    public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 33362;
    public static final int GL_NO_RESET_NOTIFICATION_ARB = 33377;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 4;

    protected ARBRobustness() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLenum")
    public static native int glGetGraphicsResetStatusARB();

    public static native void nglGetnMapdvARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        ARBRobustness.nglGetnMapdvARB(n2, n3, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnMapdARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            ARBRobustness.nglGetnMapdvARB(n2, n3, 1, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnMapfvARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        ARBRobustness.nglGetnMapfvARB(n2, n3, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnMapfARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            ARBRobustness.nglGetnMapfvARB(n2, n3, 1, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnMapivARB(int var0, int var1, int var2, long var3);

    public static void glGetnMapivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnMapivARB(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnMapiARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBRobustness.nglGetnMapivARB(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnPixelMapfvARB(int var0, int var1, long var2);

    public static void glGetnPixelMapfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        ARBRobustness.nglGetnPixelMapfvARB(n2, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnPixelMapuivARB(int var0, int var1, long var2);

    public static void glGetnPixelMapuivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnPixelMapuivARB(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglGetnPixelMapusvARB(int var0, int var1, long var2);

    public static void glGetnPixelMapusvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLushort *") ShortBuffer shortBuffer) {
        ARBRobustness.nglGetnPixelMapusvARB(n2, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nglGetnPolygonStippleARB(int var0, long var1);

    public static void glGetnPolygonStippleARB(@NativeType(value="GLsizei") int n2, @NativeType(value="GLubyte *") long l2) {
        ARBRobustness.nglGetnPolygonStippleARB(n2, l2);
    }

    public static void glGetnPolygonStippleARB(@NativeType(value="GLubyte *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnPolygonStippleARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnTexImageARB(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, n6, l2);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") ShortBuffer shortBuffer) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") FloatBuffer floatBuffer) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") DoubleBuffer doubleBuffer) {
        ARBRobustness.nglGetnTexImageARB(n2, n3, n4, n5, doubleBuffer.remaining() << 3, MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nglReadnPixelsARB(int var0, int var1, int var2, int var3, int var4, int var5, int var6, long var7);

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="void *") long l2) {
        ARBRobustness.nglReadnPixelsARB(n2, n3, n4, n5, n6, n7, n8, l2);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglReadnPixelsARB(n2, n3, n4, n5, n6, n7, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") ShortBuffer shortBuffer) {
        ARBRobustness.nglReadnPixelsARB(n2, n3, n4, n5, n6, n7, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") IntBuffer intBuffer) {
        ARBRobustness.nglReadnPixelsARB(n2, n3, n4, n5, n6, n7, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") FloatBuffer floatBuffer) {
        ARBRobustness.nglReadnPixelsARB(n2, n3, n4, n5, n6, n7, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnColorTableARB(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnColorTableARB(n2, n3, n4, n5, l2);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnColorTableARB(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ShortBuffer shortBuffer) {
        ARBRobustness.nglGetnColorTableARB(n2, n3, n4, shortBuffer.remaining() << 1, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnColorTableARB(n2, n3, n4, intBuffer.remaining() << 2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") FloatBuffer floatBuffer) {
        ARBRobustness.nglGetnColorTableARB(n2, n3, n4, floatBuffer.remaining() << 2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetnConvolutionFilterARB(int var0, int var1, int var2, int var3, long var4);

    public static void glGetnConvolutionFilterARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnConvolutionFilterARB(n2, n3, n4, n5, l2);
    }

    public static void glGetnConvolutionFilterARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnConvolutionFilterARB(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnSeparableFilterARB(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetnSeparableFilterARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2, @NativeType(value="GLsizei") int n6, @NativeType(value="void *") long l3, @Nullable @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnSeparableFilterARB(n2, n3, n4, n5, l2, n6, l3, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glGetnSeparableFilterARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="void *") ByteBuffer byteBuffer2, @Nullable @NativeType(value="void *") ByteBuffer byteBuffer3) {
        ARBRobustness.nglGetnSeparableFilterARB(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining(), MemoryUtil.memAddress(byteBuffer2), MemoryUtil.memAddressSafe(byteBuffer3));
    }

    public static native void nglGetnHistogramARB(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnHistogramARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnHistogramARB(n2, bl2, n3, n4, n5, l2);
    }

    public static void glGetnHistogramARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnHistogramARB(n2, bl2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnMinmaxARB(int var0, boolean var1, int var2, int var3, int var4, long var5);

    public static void glGetnMinmaxARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnMinmaxARB(n2, bl2, n3, n4, n5, l2);
    }

    public static void glGetnMinmaxARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLboolean") boolean bl2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        ARBRobustness.nglGetnMinmaxARB(n2, bl2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnCompressedTexImageARB(int var0, int var1, int var2, long var3);

    public static void glGetnCompressedTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void *") long l2) {
        ARBRobustness.nglGetnCompressedTexImageARB(n2, n3, n4, l2);
    }

    public static void glGetnCompressedTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, GL11.glGetTexLevelParameteri(n2, n3, 34464));
        }
        ARBRobustness.nglGetnCompressedTexImageARB(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetnUniformfvARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        ARBRobustness.nglGetnUniformfvARB(n2, n3, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetnUniformfARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            ARBRobustness.nglGetnUniformfvARB(n2, n3, 1, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformivARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnUniformivARB(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformiARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBRobustness.nglGetnUniformivARB(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformuivARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        ARBRobustness.nglGetnUniformuivARB(n2, n3, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetnUniformuiARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBRobustness.nglGetnUniformuivARB(n2, n3, 1, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformdvARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformdvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") DoubleBuffer doubleBuffer) {
        ARBRobustness.nglGetnUniformdvARB(n2, n3, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static double glGetnUniformdARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
            ARBRobustness.nglGetnUniformdvARB(n2, n3, 1, MemoryUtil.memAddress(doubleBuffer));
            double d2 = doubleBuffer.get(0);
            return d2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glGetnMapdvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetnMapdvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, dArray.length, dArray, l2);
    }

    public static void glGetnMapfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnMapfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, fArray, l2);
    }

    public static void glGetnMapivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetnMapivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glGetnPixelMapfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnPixelMapfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length, fArray, l2);
    }

    public static void glGetnPixelMapuivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetnPixelMapuivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glGetnPixelMapusvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLushort *") short[] sArray) {
        long l2 = GL.getICD().glGetnPixelMapusvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, sArray.length, sArray, l2);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray.length << 1, sArray, l2);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray.length << 2, nArray, l2);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray.length << 2, fArray, l2);
    }

    public static void glGetnTexImageARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void *") double[] dArray) {
        long l2 = GL.getICD().glGetnTexImageARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, dArray.length << 3, dArray, l2);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, sArray.length << 1, sArray, l2);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, nArray.length << 2, nArray, l2);
    }

    public static void glReadnPixelsARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glReadnPixelsARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, fArray.length << 2, fArray, l2);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") short[] sArray) {
        long l2 = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, sArray.length << 1, sArray, l2);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") int[] nArray) {
        long l2 = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, nArray.length << 2, nArray, l2);
    }

    public static void glGetnColorTableARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void *") float[] fArray) {
        long l2 = GL.getICD().glGetnColorTableARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, fArray.length << 2, fArray, l2);
    }

    public static void glGetnUniformfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetnUniformfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, fArray, l2);
    }

    public static void glGetnUniformivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetnUniformivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glGetnUniformuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetnUniformuivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, nArray.length, nArray, l2);
    }

    public static void glGetnUniformdvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLdouble *") double[] dArray) {
        long l2 = GL.getICD().glGetnUniformdvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, dArray.length, dArray, l2);
    }

    static {
        GL.initialize();
    }
}

