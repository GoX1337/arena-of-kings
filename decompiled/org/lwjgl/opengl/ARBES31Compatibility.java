/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL45C;
import org.lwjgl.system.NativeType;

public class ARBES31Compatibility {
    protected ARBES31Compatibility() {
        throw new UnsupportedOperationException();
    }

    public static void glMemoryBarrierByRegion(@NativeType(value="GLbitfield") int n2) {
        GL45C.glMemoryBarrierByRegion(n2);
    }

    static {
        GL.initialize();
    }
}

