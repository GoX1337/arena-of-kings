/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class EXTExternalBuffer {
    protected EXTExternalBuffer() {
        throw new UnsupportedOperationException();
    }

    public static native void nglBufferStorageExternalEXT(int var0, long var1, long var3, long var5, int var7);

    public static void glBufferStorageExternalEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLeglClientBufferEXT") long l4, @NativeType(value="GLbitfield") int n3) {
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        EXTExternalBuffer.nglBufferStorageExternalEXT(n2, l2, l3, l4, n3);
    }

    public static native void nglNamedBufferStorageExternalEXT(int var0, long var1, long var3, long var5, int var7);

    public static void glNamedBufferStorageExternalEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLeglClientBufferEXT") long l4, @NativeType(value="GLbitfield") int n3) {
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        EXTExternalBuffer.nglNamedBufferStorageExternalEXT(n2, l2, l3, l4, n3);
    }

    static {
        GL.initialize();
    }
}

