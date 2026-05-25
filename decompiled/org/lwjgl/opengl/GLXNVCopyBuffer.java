/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.NativeType;

public class GLXNVCopyBuffer {
    protected GLXNVCopyBuffer() {
        throw new UnsupportedOperationException();
    }

    public static void glXCopyBufferSubDataNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, @NativeType(value="GLXContext") long l4, @NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l5, @NativeType(value="GLintptr") long l6, @NativeType(value="GLsizeiptr") long l7) {
        long l8 = GL.getCapabilitiesGLXClient().glXCopyBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l8);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
        }
        JNI.callPPPPPPV(l2, l3, l4, n2, n3, l5, l6, l7, l8);
    }

    public static void glXNamedCopyBufferSubDataNV(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, @NativeType(value="GLXContext") long l4, @NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLintptr") long l5, @NativeType(value="GLintptr") long l6, @NativeType(value="GLsizeiptr") long l7) {
        long l8 = GL.getCapabilitiesGLXClient().glXNamedCopyBufferSubDataNV;
        if (Checks.CHECKS) {
            Checks.check(l8);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
        }
        JNI.callPPPPPPV(l2, l3, l4, n2, n3, l5, l6, l7, l8);
    }
}

