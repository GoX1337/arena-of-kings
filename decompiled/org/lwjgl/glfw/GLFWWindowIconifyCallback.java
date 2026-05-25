/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowIconifyCallback
extends Callback
implements GLFWWindowIconifyCallbackI {
    public static GLFWWindowIconifyCallback create(long l2) {
        GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI = (GLFWWindowIconifyCallbackI)Callback.get(l2);
        return gLFWWindowIconifyCallbackI instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)gLFWWindowIconifyCallbackI : new Container(l2, gLFWWindowIconifyCallbackI);
    }

    @Nullable
    public static GLFWWindowIconifyCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowIconifyCallback.create(l2);
    }

    public static GLFWWindowIconifyCallback create(GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI) {
        return gLFWWindowIconifyCallbackI instanceof GLFWWindowIconifyCallback ? (GLFWWindowIconifyCallback)gLFWWindowIconifyCallbackI : new Container(gLFWWindowIconifyCallbackI.address(), gLFWWindowIconifyCallbackI);
    }

    public GLFWWindowIconifyCallback() {
        super(CIF);
    }

    GLFWWindowIconifyCallback(long l2) {
        super(l2);
    }

    public GLFWWindowIconifyCallback set(long l2) {
        GLFW.glfwSetWindowIconifyCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowIconifyCallback {
        private final GLFWWindowIconifyCallbackI delegate;

        Container(long l2, GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI) {
            super(l2);
            this.delegate = gLFWWindowIconifyCallbackI;
        }

        @Override
        public void invoke(long l2, boolean bl2) {
            this.delegate.invoke(l2, bl2);
        }
    }
}

