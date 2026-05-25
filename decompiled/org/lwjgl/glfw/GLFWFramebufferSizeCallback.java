/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWFramebufferSizeCallback
extends Callback
implements GLFWFramebufferSizeCallbackI {
    public static GLFWFramebufferSizeCallback create(long l2) {
        GLFWFramebufferSizeCallbackI gLFWFramebufferSizeCallbackI = (GLFWFramebufferSizeCallbackI)Callback.get(l2);
        return gLFWFramebufferSizeCallbackI instanceof GLFWFramebufferSizeCallback ? (GLFWFramebufferSizeCallback)gLFWFramebufferSizeCallbackI : new Container(l2, gLFWFramebufferSizeCallbackI);
    }

    @Nullable
    public static GLFWFramebufferSizeCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWFramebufferSizeCallback.create(l2);
    }

    public static GLFWFramebufferSizeCallback create(GLFWFramebufferSizeCallbackI gLFWFramebufferSizeCallbackI) {
        return gLFWFramebufferSizeCallbackI instanceof GLFWFramebufferSizeCallback ? (GLFWFramebufferSizeCallback)gLFWFramebufferSizeCallbackI : new Container(gLFWFramebufferSizeCallbackI.address(), gLFWFramebufferSizeCallbackI);
    }

    public GLFWFramebufferSizeCallback() {
        super(CIF);
    }

    GLFWFramebufferSizeCallback(long l2) {
        super(l2);
    }

    public GLFWFramebufferSizeCallback set(long l2) {
        GLFW.glfwSetFramebufferSizeCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWFramebufferSizeCallback {
        private final GLFWFramebufferSizeCallbackI delegate;

        Container(long l2, GLFWFramebufferSizeCallbackI gLFWFramebufferSizeCallbackI) {
            super(l2);
            this.delegate = gLFWFramebufferSizeCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3) {
            this.delegate.invoke(l2, n2, n3);
        }
    }
}

