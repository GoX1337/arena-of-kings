/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.NativeType;

public class ARBTimerQuery {
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;

    protected ARBTimerQuery() {
        throw new UnsupportedOperationException();
    }

    public static void glQueryCounter(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        GL33C.glQueryCounter(n2, n3);
    }

    public static void nglGetQueryObjecti64v(int n2, int n3, long l2) {
        GL33C.nglGetQueryObjecti64v(n2, n3, l2);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL33C.glGetQueryObjecti64v(n2, n3, longBuffer);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long l2) {
        GL33C.glGetQueryObjecti64v(n2, n3, l2);
    }

    @NativeType(value="void")
    public static long glGetQueryObjecti64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetQueryObjecti64(n2, n3);
    }

    public static void nglGetQueryObjectui64v(int n2, int n3, long l2) {
        GL33C.nglGetQueryObjectui64v(n2, n3, l2);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") LongBuffer longBuffer) {
        GL33C.glGetQueryObjectui64v(n2, n3, longBuffer);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long l2) {
        GL33C.glGetQueryObjectui64v(n2, n3, l2);
    }

    @NativeType(value="void")
    public static long glGetQueryObjectui64(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        return GL33C.glGetQueryObjectui64(n2, n3);
    }

    public static void glGetQueryObjecti64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint64 *") long[] lArray) {
        GL33C.glGetQueryObjecti64v(n2, n3, lArray);
    }

    public static void glGetQueryObjectui64v(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint64 *") long[] lArray) {
        GL33C.glGetQueryObjectui64v(n2, n3, lArray);
    }

    static {
        GL.initialize();
    }
}

