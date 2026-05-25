/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.NativeType;

public class ARBTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;

    protected ARBTransformFeedback2() {
        throw new UnsupportedOperationException();
    }

    public static void glBindTransformFeedback(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glBindTransformFeedback(n2, n3);
    }

    public static void nglDeleteTransformFeedbacks(int n2, long l2) {
        GL40C.nglDeleteTransformFeedbacks(n2, l2);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") IntBuffer intBuffer) {
        GL40C.glDeleteTransformFeedbacks(intBuffer);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int n2) {
        GL40C.glDeleteTransformFeedbacks(n2);
    }

    public static void nglGenTransformFeedbacks(int n2, long l2) {
        GL40C.nglGenTransformFeedbacks(n2, l2);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") IntBuffer intBuffer) {
        GL40C.glGenTransformFeedbacks(intBuffer);
    }

    @NativeType(value="void")
    public static int glGenTransformFeedbacks() {
        return GL40C.glGenTransformFeedbacks();
    }

    @NativeType(value="GLboolean")
    public static boolean glIsTransformFeedback(@NativeType(value="GLuint") int n2) {
        return GL40C.glIsTransformFeedback(n2);
    }

    public static void glPauseTransformFeedback() {
        GL40C.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        GL40C.glResumeTransformFeedback();
    }

    public static void glDrawTransformFeedback(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        GL40C.glDrawTransformFeedback(n2, n3);
    }

    public static void glDeleteTransformFeedbacks(@NativeType(value="GLuint const *") int[] nArray) {
        GL40C.glDeleteTransformFeedbacks(nArray);
    }

    public static void glGenTransformFeedbacks(@NativeType(value="GLuint *") int[] nArray) {
        GL40C.glGenTransformFeedbacks(nArray);
    }

    static {
        GL.initialize();
    }
}

