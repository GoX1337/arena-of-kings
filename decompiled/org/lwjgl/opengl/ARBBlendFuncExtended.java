/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.NativeType;

public class ARBBlendFuncExtended {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;

    protected ARBBlendFuncExtended() {
        throw new UnsupportedOperationException();
    }

    public static void nglBindFragDataLocationIndexed(int n2, int n3, int n4, long l2) {
        GL33C.nglBindFragDataLocationIndexed(n2, n3, n4, l2);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL33C.glBindFragDataLocationIndexed(n2, n3, n4, byteBuffer);
    }

    public static void glBindFragDataLocationIndexed(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLchar const *") CharSequence charSequence) {
        GL33C.glBindFragDataLocationIndexed(n2, n3, n4, charSequence);
    }

    public static int nglGetFragDataIndex(int n2, long l2) {
        return GL33C.nglGetFragDataIndex(n2, l2);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        return GL33C.glGetFragDataIndex(n2, byteBuffer);
    }

    @NativeType(value="GLint")
    public static int glGetFragDataIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        return GL33C.glGetFragDataIndex(n2, charSequence);
    }

    static {
        GL.initialize();
    }
}

