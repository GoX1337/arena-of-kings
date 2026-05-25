/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class ARBSampleLocations {
    public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB = 37693;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB = 37694;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB = 37695;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB = 37696;
    public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB = 37698;
    public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB = 37699;

    protected ARBSampleLocations() {
        throw new UnsupportedOperationException();
    }

    public static native void nglFramebufferSampleLocationsfvARB(int var0, int var1, int var2, long var3);

    public static void glFramebufferSampleLocationsfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBSampleLocations.nglFramebufferSampleLocationsfvARB(n2, n3, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglNamedFramebufferSampleLocationsfvARB(int var0, int var1, int var2, long var3);

    public static void glNamedFramebufferSampleLocationsfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        ARBSampleLocations.nglNamedFramebufferSampleLocationsfvARB(n2, n3, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glEvaluateDepthValuesARB();

    public static void glFramebufferSampleLocationsfvARB(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glFramebufferSampleLocationsfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 1, fArray, l2);
    }

    public static void glNamedFramebufferSampleLocationsfvARB(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glNamedFramebufferSampleLocationsfvARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 1, fArray, l2);
    }

    static {
        GL.initialize();
    }
}

