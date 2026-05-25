/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL44C;
import org.lwjgl.system.NativeType;

public class ARBMultiBind {
    protected ARBMultiBind() {
        throw new UnsupportedOperationException();
    }

    public static void nglBindBuffersBase(int n2, int n3, int n4, long l2) {
        GL44C.nglBindBuffersBase(n2, n3, n4, l2);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindBuffersBase(n2, n3, intBuffer);
    }

    public static void nglBindBuffersRange(int n2, int n3, int n4, long l2, long l3, long l4) {
        GL44C.nglBindBuffersRange(n2, n3, n4, l2, l3, l4);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n2, n3, intBuffer, pointerBuffer, pointerBuffer2);
    }

    public static void nglBindTextures(int n2, int n3, long l2) {
        GL44C.nglBindTextures(n2, n3, l2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindTextures(n2, intBuffer);
    }

    public static void nglBindSamplers(int n2, int n3, long l2) {
        GL44C.nglBindSamplers(n2, n3, l2);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindSamplers(n2, intBuffer);
    }

    public static void nglBindImageTextures(int n2, int n3, long l2) {
        GL44C.nglBindImageTextures(n2, n3, l2);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL44C.glBindImageTextures(n2, intBuffer);
    }

    public static void nglBindVertexBuffers(int n2, int n3, long l2, long l3, long l4) {
        GL44C.nglBindVertexBuffers(n2, n3, l2, l3, l4);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") IntBuffer intBuffer2) {
        GL44C.glBindVertexBuffers(n2, intBuffer, pointerBuffer, intBuffer2);
    }

    public static void glBindBuffersBase(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindBuffersBase(n2, n3, nArray);
    }

    public static void glBindBuffersRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizeiptr const *") PointerBuffer pointerBuffer2) {
        GL44C.glBindBuffersRange(n2, n3, nArray, pointerBuffer, pointerBuffer2);
    }

    public static void glBindTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindTextures(n2, nArray);
    }

    public static void glBindSamplers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindSamplers(n2, nArray);
    }

    public static void glBindImageTextures(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray) {
        GL44C.glBindImageTextures(n2, nArray);
    }

    public static void glBindVertexBuffers(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLuint const *") int[] nArray, @Nullable @NativeType(value="GLintptr const *") PointerBuffer pointerBuffer, @Nullable @NativeType(value="GLsizei const *") int[] nArray2) {
        GL44C.glBindVertexBuffers(n2, nArray, pointerBuffer, nArray2);
    }

    static {
        GL.initialize();
    }
}

