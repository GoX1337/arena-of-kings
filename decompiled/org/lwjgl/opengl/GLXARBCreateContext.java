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

public class GLXARBCreateContext {
    public static final int GLX_CONTEXT_MAJOR_VERSION_ARB = 8337;
    public static final int GLX_CONTEXT_MINOR_VERSION_ARB = 8338;
    public static final int GLX_CONTEXT_FLAGS_ARB = 8340;
    public static final int GLX_CONTEXT_DEBUG_BIT_ARB = 1;
    public static final int GLX_CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;

    protected GLXARBCreateContext() {
        throw new UnsupportedOperationException();
    }

    public static long nglXCreateContextAttribsARB(long l2, long l3, long l4, int n2, long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPPP(l2, l3, l4, n2, l5, l6);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextAttribsARB(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="GLXContext") long l4, @NativeType(value="Bool") boolean bl2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return GLXARBCreateContext.nglXCreateContextAttribsARB(l2, l3, l4, bl2 ? 1 : 0, MemoryUtil.memAddressSafe(intBuffer));
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextAttribsARB(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="GLXContext") long l4, @NativeType(value="Bool") boolean bl2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateContextAttribsARB;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPPPP(l2, l3, l4, bl2 ? 1 : 0, nArray, l5);
    }
}

