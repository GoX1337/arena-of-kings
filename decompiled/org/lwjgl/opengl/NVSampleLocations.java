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

public class NVSampleLocations {
    public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_NV = 37693;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_NV = 37694;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_NV = 37695;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_NV = 37696;
    public static final int GL_SAMPLE_LOCATION_NV = 36432;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_NV = 37697;
    public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_NV = 37698;
    public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_NV = 37699;

    protected NVSampleLocations() {
        throw new UnsupportedOperationException();
    }

    public static native void nglFramebufferSampleLocationsfvNV(int var0, int var1, int var2, long var3);

    public static void glFramebufferSampleLocationsfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        NVSampleLocations.nglFramebufferSampleLocationsfvNV(n2, n3, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglNamedFramebufferSampleLocationsfvNV(int var0, int var1, int var2, long var3);

    public static void glNamedFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        NVSampleLocations.nglNamedFramebufferSampleLocationsfvNV(n2, n3, floatBuffer.remaining() >> 1, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glResolveDepthValuesNV();

    public static void glFramebufferSampleLocationsfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 1, fArray, l2);
    }

    public static void glNamedFramebufferSampleLocationsfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glNamedFramebufferSampleLocationsfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length >> 1, fArray, l2);
    }

    static {
        GL.initialize();
    }
}

