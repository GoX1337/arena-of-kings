/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.NativeType;

public class ARBDrawIndirect {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;

    protected ARBDrawIndirect() {
        throw new UnsupportedOperationException();
    }

    public static void nglDrawArraysIndirect(int n2, long l2) {
        GL40C.nglDrawArraysIndirect(n2, l2);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL40C.glDrawArraysIndirect(n2, byteBuffer);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2) {
        GL40C.glDrawArraysIndirect(n2, l2);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL40C.glDrawArraysIndirect(n2, intBuffer);
    }

    public static void nglDrawElementsIndirect(int n2, int n3, long l2) {
        GL40C.nglDrawElementsIndirect(n2, n3, l2);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL40C.glDrawElementsIndirect(n2, n3, byteBuffer);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2) {
        GL40C.glDrawElementsIndirect(n2, n3, l2);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer) {
        GL40C.glDrawElementsIndirect(n2, n3, intBuffer);
    }

    public static void glDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray) {
        GL40C.glDrawArraysIndirect(n2, nArray);
    }

    public static void glDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray) {
        GL40C.glDrawElementsIndirect(n2, n3, nArray);
    }

    static {
        GL.initialize();
    }
}

