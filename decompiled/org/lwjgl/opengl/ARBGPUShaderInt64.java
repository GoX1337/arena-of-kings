/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBGPUShaderInt64 {
    public static final int GL_INT64_ARB = 5134;
    public static final int GL_UNSIGNED_INT64_ARB = 5135;
    public static final int GL_INT64_VEC2_ARB = 36841;
    public static final int GL_INT64_VEC3_ARB = 36842;
    public static final int GL_INT64_VEC4_ARB = 36843;
    public static final int GL_UNSIGNED_INT64_VEC2_ARB = 36853;
    public static final int GL_UNSIGNED_INT64_VEC3_ARB = 36854;
    public static final int GL_UNSIGNED_INT64_VEC4_ARB = 36855;

    protected ARBGPUShaderInt64() {
        throw new UnsupportedOperationException();
    }

    public static native void glUniform1i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1);

    public static native void nglUniform1i64vARB(int var0, int var1, long var2);

    public static void glUniform1i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform1i64vARB(n2, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform1i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2);

    public static native void nglProgramUniform1i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform1i64vARB(n2, n3, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform2i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3);

    public static native void nglUniform2i64vARB(int var0, int var1, long var2);

    public static void glUniform2i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform2i64vARB(n2, longBuffer.remaining() >> 1, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform2i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4);

    public static native void nglProgramUniform2i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform2i64vARB(n2, n3, longBuffer.remaining() >> 1, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform3i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3, @NativeType(value="GLint64") long var5);

    public static native void nglUniform3i64vARB(int var0, int var1, long var2);

    public static void glUniform3i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform3i64vARB(n2, longBuffer.remaining() / 3, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform3i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4, @NativeType(value="GLint64") long var6);

    public static native void nglProgramUniform3i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform3i64vARB(n2, n3, longBuffer.remaining() / 3, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform4i64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLint64") long var1, @NativeType(value="GLint64") long var3, @NativeType(value="GLint64") long var5, @NativeType(value="GLint64") long var7);

    public static native void nglUniform4i64vARB(int var0, int var1, long var2);

    public static void glUniform4i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform4i64vARB(n2, longBuffer.remaining() >> 2, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform4i64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint64") long var2, @NativeType(value="GLint64") long var4, @NativeType(value="GLint64") long var6, @NativeType(value="GLint64") long var8);

    public static native void nglProgramUniform4i64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform4i64vARB(n2, n3, longBuffer.remaining() >> 2, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform1ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1);

    public static native void nglUniform1ui64vARB(int var0, int var1, long var2);

    public static void glUniform1ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform1ui64vARB(n2, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform1ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2);

    public static native void nglProgramUniform1ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform1ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform1ui64vARB(n2, n3, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform2ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3);

    public static native void nglUniform2ui64vARB(int var0, int var1, long var2);

    public static void glUniform2ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform2ui64vARB(n2, longBuffer.remaining() >> 1, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform2ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4);

    public static native void nglProgramUniform2ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform2ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform2ui64vARB(n2, n3, longBuffer.remaining() >> 1, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform3ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3, @NativeType(value="GLuint64") long var5);

    public static native void nglUniform3ui64vARB(int var0, int var1, long var2);

    public static void glUniform3ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform3ui64vARB(n2, longBuffer.remaining() / 3, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform3ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4, @NativeType(value="GLuint64") long var6);

    public static native void nglProgramUniform3ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform3ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform3ui64vARB(n2, n3, longBuffer.remaining() / 3, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glUniform4ui64ARB(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64") long var1, @NativeType(value="GLuint64") long var3, @NativeType(value="GLuint64") long var5, @NativeType(value="GLuint64") long var7);

    public static native void nglUniform4ui64vARB(int var0, int var1, long var2);

    public static void glUniform4ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglUniform4ui64vARB(n2, longBuffer.remaining() >> 2, MemoryUtil.memAddress(longBuffer));
    }

    public static native void glProgramUniform4ui64ARB(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64") long var2, @NativeType(value="GLuint64") long var4, @NativeType(value="GLuint64") long var6, @NativeType(value="GLuint64") long var8);

    public static native void nglProgramUniform4ui64vARB(int var0, int var1, int var2, long var3);

    public static void glProgramUniform4ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglProgramUniform4ui64vARB(n2, n3, longBuffer.remaining() >> 2, MemoryUtil.memAddress(longBuffer));
    }

    public static native void nglGetUniformi64vARB(int var0, int var1, long var2);

    public static void glGetUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        ARBGPUShaderInt64.nglGetUniformi64vARB(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            ARBGPUShaderInt64.nglGetUniformi64vARB(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetUniformui64vARB(int var0, int var1, long var2);

    public static void glGetUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        ARBGPUShaderInt64.nglGetUniformui64vARB(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            ARBGPUShaderInt64.nglGetUniformui64vARB(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformi64vARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglGetnUniformi64vARB(n2, n3, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetnUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            ARBGPUShaderInt64.nglGetnUniformi64vARB(n2, n3, 1, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetnUniformui64vARB(int var0, int var1, int var2, long var3);

    public static void glGetnUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        ARBGPUShaderInt64.nglGetnUniformui64vARB(n2, n3, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetnUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            ARBGPUShaderInt64.nglGetnUniformui64vARB(n2, n3, 1, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glUniform1i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glUniform1i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length, lArray, l2);
    }

    public static void glProgramUniform1i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform1i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length, lArray, l2);
    }

    public static void glUniform2i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glUniform2i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length >> 1, lArray, l2);
    }

    public static void glProgramUniform2i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform2i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length >> 1, lArray, l2);
    }

    public static void glUniform3i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glUniform3i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length / 3, lArray, l2);
    }

    public static void glProgramUniform3i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform3i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length / 3, lArray, l2);
    }

    public static void glUniform4i64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glUniform4i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length >> 2, lArray, l2);
    }

    public static void glProgramUniform4i64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform4i64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length >> 2, lArray, l2);
    }

    public static void glUniform1ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glUniform1ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length, lArray, l2);
    }

    public static void glProgramUniform1ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform1ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length, lArray, l2);
    }

    public static void glUniform2ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glUniform2ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length >> 1, lArray, l2);
    }

    public static void glProgramUniform2ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform2ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length >> 1, lArray, l2);
    }

    public static void glUniform3ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glUniform3ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length / 3, lArray, l2);
    }

    public static void glProgramUniform3ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform3ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length / 3, lArray, l2);
    }

    public static void glUniform4ui64vARB(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glUniform4ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length >> 2, lArray, l2);
    }

    public static void glProgramUniform4ui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 const *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniform4ui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length >> 2, lArray, l2);
    }

    public static void glGetUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetUniformi64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetUniformui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetnUniformi64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetnUniformi64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length, lArray, l2);
    }

    public static void glGetnUniformui64vARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetnUniformui64vARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length, lArray, l2);
    }

    static {
        GL.initialize();
    }
}

