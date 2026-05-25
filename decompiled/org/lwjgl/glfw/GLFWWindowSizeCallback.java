/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowSizeCallback
extends Callback
implements GLFWWindowSizeCallbackI {
    public static GLFWWindowSizeCallback create(long l2) {
        GLFWWindowSizeCallbackI gLFWWindowSizeCallbackI = (GLFWWindowSizeCallbackI)Callback.get(l2);
        return gLFWWindowSizeCallbackI instanceof GLFWWindowSizeCallback ? (GLFWWindowSizeCallback)gLFWWindowSizeCallbackI : new Container(l2, gLFWWindowSizeCallbackI);
    }

    @Nullable
    public static GLFWWindowSizeCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowSizeCallback.create(l2);
    }

    public static GLFWWindowSizeCallback create(GLFWWindowSizeCallbackI gLFWWindowSizeCallbackI) {
        return gLFWWindowSizeCallbackI instanceof GLFWWindowSizeCallback ? (GLFWWindowSizeCallback)gLFWWindowSizeCallbackI : new Container(gLFWWindowSizeCallbackI.address(), gLFWWindowSizeCallbackI);
    }

    protected GLFWWindowSizeCallback() {
        super(CIF);
    }

    GLFWWindowSizeCallback(long l2) {
        super(l2);
    }

    public GLFWWindowSizeCallback set(long l2) {
        GLFW.glfwSetWindowSizeCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowSizeCallback {
        private final GLFWWindowSizeCallbackI delegate;

        Container(long l2, GLFWWindowSizeCallbackI gLFWWindowSizeCallbackI) {
            super(l2);
            this.delegate = gLFWWindowSizeCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3) {
            this.delegate.invoke(l2, n2, n3);
        }
    }
}

