/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowCloseCallback
extends Callback
implements GLFWWindowCloseCallbackI {
    public static GLFWWindowCloseCallback create(long l2) {
        GLFWWindowCloseCallbackI gLFWWindowCloseCallbackI = (GLFWWindowCloseCallbackI)Callback.get(l2);
        return gLFWWindowCloseCallbackI instanceof GLFWWindowCloseCallback ? (GLFWWindowCloseCallback)gLFWWindowCloseCallbackI : new Container(l2, gLFWWindowCloseCallbackI);
    }

    @Nullable
    public static GLFWWindowCloseCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowCloseCallback.create(l2);
    }

    public static GLFWWindowCloseCallback create(GLFWWindowCloseCallbackI gLFWWindowCloseCallbackI) {
        return gLFWWindowCloseCallbackI instanceof GLFWWindowCloseCallback ? (GLFWWindowCloseCallback)gLFWWindowCloseCallbackI : new Container(gLFWWindowCloseCallbackI.address(), gLFWWindowCloseCallbackI);
    }

    public GLFWWindowCloseCallback() {
        super(CIF);
    }

    GLFWWindowCloseCallback(long l2) {
        super(l2);
    }

    public GLFWWindowCloseCallback set(long l2) {
        GLFW.glfwSetWindowCloseCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowCloseCallback {
        private final GLFWWindowCloseCallbackI delegate;

        Container(long l2, GLFWWindowCloseCallbackI gLFWWindowCloseCallbackI) {
            super(l2);
            this.delegate = gLFWWindowCloseCallbackI;
        }

        @Override
        public void invoke(long l2) {
            this.delegate.invoke(l2);
        }
    }
}

