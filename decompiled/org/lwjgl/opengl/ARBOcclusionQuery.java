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

public class ARBOcclusionQuery {
    public static final int GL_SAMPLES_PASSED_ARB = 35092;
    public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
    public static final int GL_CURRENT_QUERY_ARB = 34917;
    public static final int GL_QUERY_RESULT_ARB = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;

    protected ARBOcclusionQuery() {
        throw new UnsupportedOperationException();
    }

    public static native void nglGenQueriesARB(int var0, long var1);

    public static void glGenQueriesARB(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        ARBOcclusionQuery.nglGenQueriesARB(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGenQueriesARB() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBOcclusionQuery.nglGenQueriesARB(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglDeleteQueriesARB(int var0, long var1);

    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        ARBOcclusionQuery.nglDeleteQueriesARB(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            ARBOcclusionQuery.nglDeleteQueriesARB(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsQueryARB(@NativeType(value="GLuint") int var0);

    public static native void glBeginQueryARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLuint") int var1);

    public static native void glEndQueryARB(@NativeType(value="GLenum") int var0);

    public static native void nglGetQueryivARB(int var0, int var1, long var2);

    public static void glGetQueryivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBOcclusionQuery.nglGetQueryivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryiARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetQueryObjectivARB(int var0, int var1, long var2);

    public static void glGetQueryObjectivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBOcclusionQuery.nglGetQueryObjectivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetQueryObjectivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") long l2) {
        ARBOcclusionQuery.nglGetQueryObjectivARB(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjectiARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryObjectivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetQueryObjectuivARB(int var0, int var1, long var2);

    public static void glGetQueryObjectuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        ARBOcclusionQuery.nglGetQueryObjectuivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void glGetQueryObjectuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") long l2) {
        ARBOcclusionQuery.nglGetQueryObjectuivARB(n2, n3, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetQueryObjectuiARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            ARBOcclusionQuery.nglGetQueryObjectuivARB(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void glGenQueriesARB(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGenQueriesARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glDeleteQueriesARB(@NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glDeleteQueriesARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glGetQueryivARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetQueryivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetQueryObjectivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetQueryObjectivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetQueryObjectuivARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glGetQueryObjectuivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    static {
        GL.initialize();
    }
}

