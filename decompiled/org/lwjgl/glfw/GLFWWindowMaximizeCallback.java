/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowMaximizeCallback
extends Callback
implements GLFWWindowMaximizeCallbackI {
    public static GLFWWindowMaximizeCallback create(long l2) {
        GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI = (GLFWWindowMaximizeCallbackI)Callback.get(l2);
        return gLFWWindowMaximizeCallbackI instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)gLFWWindowMaximizeCallbackI : new Container(l2, gLFWWindowMaximizeCallbackI);
    }

    @Nullable
    public static GLFWWindowMaximizeCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowMaximizeCallback.create(l2);
    }

    public static GLFWWindowMaximizeCallback create(GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI) {
        return gLFWWindowMaximizeCallbackI instanceof GLFWWindowMaximizeCallback ? (GLFWWindowMaximizeCallback)gLFWWindowMaximizeCallbackI : new Container(gLFWWindowMaximizeCallbackI.address(), gLFWWindowMaximizeCallbackI);
    }

    public GLFWWindowMaximizeCallback() {
        super(CIF);
    }

    GLFWWindowMaximizeCallback(long l2) {
        super(l2);
    }

    public GLFWWindowMaximizeCallback set(long l2) {
        GLFW.glfwSetWindowMaximizeCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowMaximizeCallback {
        private final GLFWWindowMaximizeCallbackI delegate;

        Container(long l2, GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI) {
            super(l2);
            this.delegate = gLFWWindowMaximizeCallbackI;
        }

        @Override
        public void invoke(long l2, boolean bl2) {
            this.delegate.invoke(l2, bl2);
        }
    }
}

