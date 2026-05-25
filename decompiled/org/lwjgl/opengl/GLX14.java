/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX13;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLX14
extends GLX13 {
    public static final int GLX_SAMPLE_BUFFERS = 100000;
    public static final int GLX_SAMPLES = 100001;

    protected GLX14() {
        throw new UnsupportedOperationException();
    }

    public static long nglXGetProcAddress(long l2) {
        long l3 = GL.getCapabilitiesGLXClient().glXGetProcAddress;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.callPP(l2, l3);
    }

    @NativeType(value="void *")
    public static long glXGetProcAddress(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GLX14.nglXGetProcAddress(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long glXGetProcAddress(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = GLX14.nglXGetProcAddress(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }
}

