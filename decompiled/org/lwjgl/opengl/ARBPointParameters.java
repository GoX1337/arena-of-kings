/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBPointParameters {
    public static final int GL_POINT_SIZE_MIN_ARB = 33062;
    public static final int GL_POINT_SIZE_MAX_ARB = 33063;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE_ARB = 33064;
    public static final int GL_POINT_DISTANCE_ATTENUATION_ARB = 33065;

    protected ARBPointParameters() {
        throw new UnsupportedOperationException();
    }

    public static native void glPointParameterfARB(@NativeType(value="GLenum") int var0, @NativeType(value="GLfloat") float var1);

    public static native void nglPointParameterfvARB(int var0, long var1);

    public static void glPointParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 3);
        }
        ARBPointParameters.nglPointParameterfvARB(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void glPointParameterfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glPointParameterfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 3);
        }
        JNI.callPV(n2, fArray, l2);
    }

    static {
        GL.initialize();
    }
}

