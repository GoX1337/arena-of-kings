/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL46C;
import org.lwjgl.system.NativeType;

public class ARBPolygonOffsetClamp {
    public static final int GL_POLYGON_OFFSET_CLAMP = 36379;

    protected ARBPolygonOffsetClamp() {
        throw new UnsupportedOperationException();
    }

    public static void glPolygonOffsetClamp(@NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLfloat") float f4) {
        GL46C.glPolygonOffsetClamp(f2, f3, f4);
    }

    static {
        GL.initialize();
    }
}

