/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBMatrixPalette {
    public static final int GL_MATRIX_PALETTE_ARB = 34880;
    public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
    public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
    public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
    public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
    public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;

    protected ARBMatrixPalette() {
        throw new UnsupportedOperationException();
    }

    public static native void glCurrentPaletteMatrixARB(@NativeType(value="GLint") int var0);

    public static native void nglMatrixIndexuivARB(int var0, long var1);

    public static void glMatrixIndexuivARB(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        ARBMatrixPalette.nglMatrixIndexuivARB(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglMatrixIndexubvARB(int var0, long var1);

    public static void glMatrixIndexubvARB(@NativeType(value="GLubyte *") ByteBuffer byteBuffer) {
        ARBMatrixPalette.nglMatrixIndexubvARB(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglMatrixIndexusvARB(int var0, long var1);

    public static void glMatrixIndexusvARB(@NativeType(value="GLushort *") ShortBuffer shortBuffer) {
        ARBMatrixPalette.nglMatrixIndexusvARB(shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nglMatrixIndexPointerARB(int var0, int var1, int var2, long var3);

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="void const *") long l2) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(n2, n3, n4, l2);
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(n2, 5121, n3, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(n2, 5123, n3, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glMatrixIndexPointerARB(@NativeType(value="GLint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="void const *") IntBuffer intBuffer) {
        ARBMatrixPalette.nglMatrixIndexPointerARB(n2, 5125, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void glMatrixIndexuivARB(@NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glMatrixIndexuivARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(nArray.length, nArray, l2);
    }

    public static void glMatrixIndexusvARB(@NativeType(value="GLushort *") short[] sArray) {
        long l2 = GL.getICD().glMatrixIndexusvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(sArray.length, sArray, l2);
    }

    static {
        GL.initialize();
    }
}

