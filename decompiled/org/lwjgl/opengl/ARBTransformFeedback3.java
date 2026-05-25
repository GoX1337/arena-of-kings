/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.NativeType;

public class ARBTransformFeedback3 {
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    protected ARBTransformFeedback3() {
        throw new UnsupportedOperationException();
    }

    public static void glDrawTransformFeedbackStream(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL40C.glDrawTransformFeedbackStream(n2, n3, n4);
    }

    public static void glBeginQueryIndexed(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLuint") int n4) {
        GL40C.glBeginQueryIndexed(n2, n3, n4);
    }

    public static void glEndQueryIndexed(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glEndQueryIndexed(n2, n3);
    }

    public static void nglGetQueryIndexediv(int n2, int n3, int n4, long l2) {
        GL40C.nglGetQueryIndexediv(n2, n3, n4, l2);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        GL40C.glGetQueryIndexediv(n2, n3, n4, intBuffer);
    }

    @NativeType(value="void")
    public static int glGetQueryIndexedi(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4) {
        return GL40C.glGetQueryIndexedi(n2, n3, n4);
    }

    public static void glGetQueryIndexediv(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        GL40C.glGetQueryIndexediv(n2, n3, n4, nArray);
    }

    static {
        GL.initialize();
    }
}

