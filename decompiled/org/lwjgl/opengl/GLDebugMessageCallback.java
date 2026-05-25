/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import javax.annotation.Nullable;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLDebugMessageCallback
extends Callback
implements GLDebugMessageCallbackI {
    public static GLDebugMessageCallback create(long l2) {
        GLDebugMessageCallbackI gLDebugMessageCallbackI = (GLDebugMessageCallbackI)Callback.get(l2);
        return gLDebugMessageCallbackI instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)gLDebugMessageCallbackI : new Container(l2, gLDebugMessageCallbackI);
    }

    @Nullable
    public static GLDebugMessageCallback createSafe(long l2) {
        return l2 == 0L ? null : GLDebugMessageCallback.create(l2);
    }

    public static GLDebugMessageCallback create(GLDebugMessageCallbackI gLDebugMessageCallbackI) {
        return gLDebugMessageCallbackI instanceof GLDebugMessageCallback ? (GLDebugMessageCallback)gLDebugMessageCallbackI : new Container(gLDebugMessageCallbackI.address(), gLDebugMessageCallbackI);
    }

    protected GLDebugMessageCallback() {
        super(CIF);
    }

    GLDebugMessageCallback(long l2) {
        super(l2);
    }

    public static String getMessage(int n2, long l2) {
        return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(l2, n2));
    }

    static final class Container
    extends GLDebugMessageCallback {
        private final GLDebugMessageCallbackI delegate;

        Container(long l2, GLDebugMessageCallbackI gLDebugMessageCallbackI) {
            super(l2);
            this.delegate = gLDebugMessageCallbackI;
        }

        @Override
        public void invoke(int n2, int n3, int n4, int n5, int n6, long l2, long l3) {
            this.delegate.invoke(n2, n3, n4, n5, n6, l2, l3);
        }
    }
}

