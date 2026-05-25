/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.system.NativeType;

public class ARBInvalidateSubdata {
    protected ARBInvalidateSubdata() {
        throw new UnsupportedOperationException();
    }

    public static void glInvalidateTexSubImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLint") int n6, @NativeType(value="GLsizei") int n7, @NativeType(value="GLsizei") int n8, @NativeType(value="GLsizei") int n9) {
        GL43C.glInvalidateTexSubImage(n2, n3, n4, n5, n6, n7, n8, n9);
    }

    public static void glInvalidateTexImage(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3) {
        GL43C.glInvalidateTexImage(n2, n3);
    }

    public static void glInvalidateBufferSubData(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3) {
        GL43C.glInvalidateBufferSubData(n2, l2, l3);
    }

    public static void glInvalidateBufferData(@NativeType(value="GLuint") int n2) {
        GL43C.glInvalidateBufferData(n2);
    }

    public static void nglInvalidateFramebuffer(int n2, int n3, long l2) {
        GL43C.nglInvalidateFramebuffer(n2, n3, l2);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL43C.glInvalidateFramebuffer(n2, intBuffer);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int n3) {
        GL43C.glInvalidateFramebuffer(n2, n3);
    }

    public static void nglInvalidateSubFramebuffer(int n2, int n3, long l2, int n4, int n5, int n6, int n7) {
        GL43C.nglInvalidateSubFramebuffer(n2, n3, l2, n4, n5, n6, n7);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL43C.glInvalidateSubFramebuffer(n2, intBuffer, n3, n4, n5, n6);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7) {
        GL43C.glInvalidateSubFramebuffer(n2, n3, n4, n5, n6, n7);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        GL43C.glInvalidateFramebuffer(n2, nArray);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int[] nArray, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL43C.glInvalidateSubFramebuffer(n2, nArray, n3, n4, n5, n6);
    }

    static {
        GL.initialize();
    }
}

