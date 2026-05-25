/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GLDebugMessageARBCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageARBCallback
extends Callback
implements GLDebugMessageARBCallbackI {
    public static GLDebugMessageARBCallback create(long l2) {
        GLDebugMessageARBCallbackI gLDebugMessageARBCallbackI = (GLDebugMessageARBCallbackI)Callback.get(l2);
        return gLDebugMessageARBCallbackI instanceof GLDebugMessageARBCallback ? (GLDebugMessageARBCallback)gLDebugMessageARBCallbackI : new Container(l2, gLDebugMessageARBCallbackI);
    }

    @Nullable
    public static GLDebugMessageARBCallback createSafe(long l2) {
        return l2 == 0L ? null : GLDebugMessageARBCallback.create(l2);
    }

    public static GLDebugMessageARBCallback create(GLDebugMessageARBCallbackI gLDebugMessageARBCallbackI) {
        return gLDebugMessageARBCallbackI instanceof GLDebugMessageARBCallback ? (GLDebugMessageARBCallback)gLDebugMessageARBCallbackI : new Container(gLDebugMessageARBCallbackI.address(), gLDebugMessageARBCallbackI);
    }

    protected GLDebugMessageARBCallback() {
        super(CIF);
    }

    GLDebugMessageARBCallback(long l2) {
        super(l2);
    }

    public static String getMessage(int n2, long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(l2, n2));
    }

    static final class Container
    extends GLDebugMessageARBCallback {
        private final GLDebugMessageARBCallbackI delegate;

        Container(long l2, GLDebugMessageARBCallbackI gLDebugMessageARBCallbackI) {
            super(l2);
            this.delegate = gLDebugMessageARBCallbackI;
        }

        @Override
        public void invoke(int n2, int n3, int n4, int n5, int n6, long l2, long l3) {
            this.delegate.invoke(n2, n3, n4, n5, n6, l2, l3);
        }
    }
}

