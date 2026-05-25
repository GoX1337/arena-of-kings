/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.system.NativeType;

public class ARBCopyBuffer {
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;

    protected ARBCopyBuffer() {
        throw new UnsupportedOperationException();
    }

    public static void glCopyBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizeiptr") long l4) {
        GL31C.glCopyBufferSubData(n2, n3, l2, l3, l4);
    }

    static {
        GL.initialize();
    }
}

