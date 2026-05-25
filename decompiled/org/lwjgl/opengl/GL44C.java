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
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL44C
extends GL43C {
    public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
    public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 33313;
    public static final int GL_TEXTURE_BUFFER_BINDING = 35882;
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
    public static final int GL_CLEAR_TEXTURE = 37733;
    public static final int GL_LOCATION_COMPONENT = 37706;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;
    public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
    public static final int GL_QUERY_BUFFER = 37266;
    public static final int GL_QUERY_BUFFER_BINDING = 37267;
    public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
    public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;

    protected GL44C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglBufferStorage(int var0, long var1, long var3, int var5);

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="GLsizeiptr") long l2, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, l2, 0L, n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ShortBuffer shortBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, Integer.toUnsignedLong(shortBuffer.remaining()) << 1, MemoryUtil.memAddress(shortBuffer), n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, Integer.toUnsignedLong(intBuffer.remaining()) << 2, MemoryUtil.memAddress(intBuffer), n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") FloatBuffer floatBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, Integer.toUnsignedLong(floatBuffer.remaining()) << 2, MemoryUtil.memAddress(floatBuffer), n3);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") DoubleBuffer doubleBuffer, @NativeType(value="GLbitfield") int n3) {
        GL44C.nglBufferStorage(n2, Integer.toUnsignedLong(doubleBuffer.remaining()) << 3, MemoryUtil.memAddress(doubleBuffer), n3);
    }

    public static native void nglClearTexSubImage(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL44C.nglClearTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglClearTexImage(int var0, int var1, int var2, int var3, long var4);

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") DoubleBuffer doubleBuffer) {
        GL44C.nglClearTexImage(n2, n3, n4, n5, MemoryUtil.memAddressSafe(doubleBuffer));
    }

    public static native void nglBindBuffersBase(int var0, int var1, int var2, long var3);

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.nglBindBuffersBase(n2, n3, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglBindBuffersRange(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe(pointerBuffer, Checks.remainingSafe(intBuffer));
            Checks.checkSafe(pointerBuffer2, Checks.remainingSafe(intBuffer));
        }
        GL44C.nglBindBuffersRange(n2, n3, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(pointerBuffer), MemoryUtil.memAddressSafe(pointerBuffer2));
    }

    public static native void nglBindTextures(int var0, int var1, long var2);

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.nglBindTextures(n2, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglBindSamplers(int var0, int var1, long var2);

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.nglBindSamplers(n2, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglBindImageTextures(int var0, int var1, long var2);

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.nglBindImageTextures(n2, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglBindVertexBuffers(int var0, int var1, long var2, long var4, long var6);

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe(pointerBuffer, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer2, Checks.remainingSafe(intBuffer));
        }
        GL44C.nglBindVertexBuffers(n2, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(pointerBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") short[] sArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(sArray.length) << 1, sArray, n3, l2);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(nArray.length) << 2, nArray, n3, l2);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") float[] fArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(fArray.length) << 2, fArray, n3, l2);
    }

    public static void glBufferStorage(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") double[] dArray, @NativeType(value="GLbitfield") int n3) {
        long l2 = GL.getICD().glBufferStorage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, Integer.toUnsignedLong(dArray.length) << 3, dArray, n3, l2);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, sArray, l2);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, nArray, l2);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, fArray, l2);
    }

    public static void glClearTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9, @NativeType(value="GLenum") int n10, @NativeType(value="GLenum") int n11, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glClearTexSubImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, dArray, l2);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray, l2);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glClearTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") double[] dArray) {
        long l2 = GL.getICD().glClearTexImage;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, dArray, l2);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glBindBuffersBase;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, Checks.lengthSafe(nArray), nArray, l2);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        long l2 = GL.getICD().glBindBuffersRange;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(pointerBuffer, Checks.lengthSafe(nArray));
            Checks.checkSafe(pointerBuffer2, Checks.lengthSafe(nArray));
        }
        JNI.callPPPV(n2, n3, Checks.lengthSafe(nArray), nArray, MemoryUtil.memAddressSafe(pointerBuffer), MemoryUtil.memAddressSafe(pointerBuffer2), l2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glBindTextures;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, Checks.lengthSafe(nArray), nArray, l2);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glBindSamplers;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, Checks.lengthSafe(nArray), nArray, l2);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        long l2 = GL.getICD().glBindImageTextures;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, Checks.lengthSafe(nArray), nArray, l2);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") int[] nArray2) {
        long l2 = GL.getICD().glBindVertexBuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(pointerBuffer, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray2, Checks.lengthSafe(nArray));
        }
        JNI.callPPPV(n2, Checks.lengthSafe(nArray), nArray, MemoryUtil.memAddressSafe(pointerBuffer), nArray2, l2);
    }

    static {
        GL.initialize();
    }
}

