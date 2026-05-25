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

public class NVShaderBufferLoad {
    public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
    public static final int GL_GPU_ADDRESS_NV = 36660;
    public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;

    protected NVShaderBufferLoad() {
        throw new UnsupportedOperationException();
    }

    public static native void glMakeBufferResidentNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1);

    public static native void glMakeBufferNonResidentNV(@NativeType(value="GLenum") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsBufferResidentNV(@NativeType(value="GLenum") int var0);

    public static native void glMakeNamedBufferResidentNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glMakeNamedBufferNonResidentNV(@NativeType(value="GLuint") int var0);

    @NativeType(value="GLboolean")
    public static native boolean glIsNamedBufferResidentNV(@NativeType(value="GLuint") int var0);

    public static native void nglGetBufferParameterui64vNV(int var0, int var1, long var2);

    public static void glGetBufferParameterui64vNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64EXT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVShaderBufferLoad.nglGetBufferParameterui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetBufferParameterui64NV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVShaderBufferLoad.nglGetBufferParameterui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetNamedBufferParameterui64vNV(int var0, int var1, long var2);

    public static void glGetNamedBufferParameterui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64EXT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetNamedBufferParameterui64NV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetIntegerui64vNV(int var0, long var1);

    public static void glGetIntegerui64vNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint64EXT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVShaderBufferLoad.nglGetIntegerui64vNV(n2, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetIntegerui64NV(@NativeType(value="GLenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVShaderBufferLoad.nglGetIntegerui64vNV(n2, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void glUniformui64NV(@NativeType(value="GLint") int var0, @NativeType(value="GLuint64EXT") long var1);

    public static native void nglUniformui64vNV(int var0, int var1, long var2);

    public static void glUniformui64vNV(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64EXT const *") LongBuffer longBuffer) {
        NVShaderBufferLoad.nglUniformui64vNV(n2, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void nglGetUniformui64vNV(int var0, int var1, long var2);

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64EXT *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        NVShaderBufferLoad.nglGetUniformui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetUniformui64NV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            NVShaderBufferLoad.nglGetUniformui64vNV(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glProgramUniformui64NV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint64EXT") long var2);

    public static native void nglProgramUniformui64vNV(int var0, int var1, int var2, long var3);

    public static void glProgramUniformui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64EXT const *") LongBuffer longBuffer) {
        NVShaderBufferLoad.nglProgramUniformui64vNV(n2, n3, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetBufferParameterui64vNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64EXT *") long[] lArray) {
        long l2 = GL.getICD().glGetBufferParameterui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetNamedBufferParameterui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64EXT *") long[] lArray) {
        long l2 = GL.getICD().glGetNamedBufferParameterui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetIntegerui64vNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint64EXT *") long[] lArray) {
        long l2 = GL.getICD().glGetIntegerui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, lArray, l2);
    }

    public static void glUniformui64vNV(@NativeType(value="GLint") int n2, @NativeType(value="GLuint64EXT const *") long[] lArray) {
        long l2 = GL.getICD().glUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, lArray.length, lArray, l2);
    }

    public static void glGetUniformui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64EXT *") long[] lArray) {
        long l2 = GL.getICD().glGetUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glProgramUniformui64vNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLuint64EXT const *") long[] lArray) {
        long l2 = GL.getICD().glProgramUniformui64vNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, lArray.length, lArray, l2);
    }

    static {
        GL.initialize();
    }
}

