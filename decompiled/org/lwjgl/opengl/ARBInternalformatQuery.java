/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.system.NativeType;

public class ARBInternalformatQuery {
    public static final int GL_NUM_SAMPLE_COUNTS = 37760;

    protected ARBInternalformatQuery() {
        throw new UnsupportedOperationException();
    }

    public static void nglGetInternalformativ(int n2, int n3, int n4, int n5, long l2) {
        GL42C.nglGetInternalformativ(n2, n3, n4, n5, l2);
    }

    public static void glGetInternalformativ(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL42C.glGetInternalformativ(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetInternalformati(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        return GL42C.glGetInternalformati(n2, n3, n4);
    }

    public static void glGetInternalformativ(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL42C.glGetInternalformativ(n2, n3, n4, nArray);
    }

    static {
        GL.initialize();
    }
}

