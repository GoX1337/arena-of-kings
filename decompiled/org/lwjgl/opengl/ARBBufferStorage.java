/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBBufferStorage {
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;

    protected ARBBufferStorage() {
        throw new UnsupportedOperationException();
    }

    public static void nglBufferStorage(int n2, long l2, long l3, int n3) {
        GL44C.nglBufferStorage(n2, l2, l3, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, l2, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, byteBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, shortBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, intBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, floatBuffer, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, doubleBuffer, n3);
    }

    public static native void nglNamedBufferStorageEXT(int var0, long var1, long var3, int var5);

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, l2, 0L, n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer), n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        ARBBufferStorage.nglNamedBufferStorageEXT(n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer), n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, sArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, nArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, fArray, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        GL44C.glBufferStorage(n2, dArray, n3);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(sArray.length) << 1, sArray, n3, l2);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(nArray.length) << 2, nArray, n3, l2);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(fArray.length) << 2, fArray, n3, l2);
    }

    public static void glNamedBufferStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glNamedBufferStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(dArray.length) << 3, dArray, n3, l2);
    }

    static {
        GL.initialize();
    }
}

