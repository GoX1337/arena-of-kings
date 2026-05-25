/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTEGLImageStorage {
    protected EXTEGLImageStorage() {
        throw new UnsupportedOperationException();
    }

    public static native void nglEGLImageTargetTexStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLeglImageOES") long l2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNTSafe(intBuffer);
        }
        EXTEGLImageStorage.nglEGLImageTargetTexStorageEXT(n2, l2, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static native void nglEGLImageTargetTextureStorageEXT(int var0, long var1, long var3);

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLeglImageOES") long l2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNTSafe(intBuffer);
        }
        EXTEGLImageStorage.nglEGLImageTargetTextureStorageEXT(n2, l2, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glEGLImageTargetTexStorageEXT(@NativeType(value="GLenum") int n2, @NativeType(value="GLeglImageOES") long l2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getICD().glEGLImageTargetTexStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        JNI.callPPV(n2, l2, nArray, l3);
    }

    public static void glEGLImageTargetTextureStorageEXT(@NativeType(value="GLuint") int n2, @NativeType(value="GLeglImageOES") long l2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getICD().glEGLImageTargetTextureStorageEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        JNI.callPPV(n2, l2, nArray, l3);
    }

    static {
        GL.initialize();
    }
}

