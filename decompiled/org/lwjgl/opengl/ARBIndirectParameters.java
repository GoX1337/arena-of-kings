/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBIndirectParameters {
    public static final int GL_PARAMETER_BUFFER_ARB = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;

    protected ARBIndirectParameters() {
        throw new UnsupportedOperationException();
    }

    public static native void nglMultiDrawArraysIndirectCountARB(int var0, long var1, long var3, int var5, int var6);

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? 16 : n4));
        }
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(n2, MemoryUtil.memAddress(byteBuffer), l2, n3, n4);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(n2, l2, l3, n3, n4);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, n3 * (n4 == 0 ? 16 : n4) >> 2);
        }
        ARBIndirectParameters.nglMultiDrawArraysIndirectCountARB(n2, MemoryUtil.memAddress(intBuffer), l2, n3, n4);
    }

    public static native void nglMultiDrawElementsIndirectCountARB(int var0, int var1, long var2, long var4, int var6, int var7);

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n4 * (n5 == 0 ? 20 : n5));
        }
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(n2, n3, MemoryUtil.memAddress(byteBuffer), l2, n4, n5);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLintptr") long l3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(n2, n3, l2, l3, n4, n5);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, n4 * (n5 == 0 ? 20 : n5) >> 2);
        }
        ARBIndirectParameters.nglMultiDrawElementsIndirectCountARB(n2, n3, MemoryUtil.memAddress(intBuffer), l2, n4, n5);
    }

    public static void glMultiDrawArraysIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        long l3 = GL.getICD().glMultiDrawArraysIndirectCountARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(nArray, n3 * (n4 == 0 ? 16 : n4) >> 2);
        }
        JNI.callPPV(n2, nArray, l2, n3, n4, l3);
    }

    public static void glMultiDrawElementsIndirectCountARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        long l3 = GL.getICD().glMultiDrawElementsIndirectCountARB;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(nArray, n4 * (n5 == 0 ? 20 : n5) >> 2);
        }
        JNI.callPPV(n2, n3, nArray, l2, n4, n5, l3);
    }

    static {
        GL.initialize();
    }
}

