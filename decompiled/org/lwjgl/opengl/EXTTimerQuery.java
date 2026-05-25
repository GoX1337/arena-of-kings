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

public class EXTTimerQuery {
    public static final int GL_TIME_ELAPSED_EXT = 35007;

    protected EXTTimerQuery() {
        throw new UnsupportedOperationException();
    }

    public static native void nglGetQueryObjecti64vEXT(int var0, int var1, long var2);

    public static void glGetQueryObjecti64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        EXTTimerQuery.nglGetQueryObjecti64vEXT(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetQueryObjecti64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long l2) {
        EXTTimerQuery.nglGetQueryObjecti64vEXT(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjecti64EXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            EXTTimerQuery.nglGetQueryObjecti64vEXT(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetQueryObjectui64vEXT(int var0, int var1, long var2);

    public static void glGetQueryObjectui64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        EXTTimerQuery.nglGetQueryObjectui64vEXT(n2, n3, MemoryUtil.memAddress(longBuffer));
    }

    public static void glGetQueryObjectui64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long l2) {
        EXTTimerQuery.nglGetQueryObjectui64vEXT(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetQueryObjectui64EXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            EXTTimerQuery.nglGetQueryObjectui64vEXT(n2, n3, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glGetQueryObjecti64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetQueryObjecti64vEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    public static void glGetQueryObjectui64vEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetQueryObjectui64vEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        JNI.callPV(n2, n3, lArray, l2);
    }

    static {
        GL.initialize();
    }
}

