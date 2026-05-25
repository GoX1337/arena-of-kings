/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCharCallback
extends Callback
implements GLFWCharCallbackI {
    public static GLFWCharCallback create(long l2) {
        GLFWCharCallbackI gLFWCharCallbackI = (GLFWCharCallbackI)Callback.get(l2);
        return gLFWCharCallbackI instanceof GLFWCharCallback ? (GLFWCharCallback)gLFWCharCallbackI : new Container(l2, gLFWCharCallbackI);
    }

    @Nullable
    public static GLFWCharCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWCharCallback.create(l2);
    }

    public static GLFWCharCallback create(GLFWCharCallbackI gLFWCharCallbackI) {
        return gLFWCharCallbackI instanceof GLFWCharCallback ? (GLFWCharCallback)gLFWCharCallbackI : new Container(gLFWCharCallbackI.address(), gLFWCharCallbackI);
    }

    public GLFWCharCallback() {
        super(CIF);
    }

    GLFWCharCallback(long l2) {
        super(l2);
    }

    public GLFWCharCallback set(long l2) {
        GLFW.glfwSetCharCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWCharCallback {
        private final GLFWCharCallbackI delegate;

        Container(long l2, GLFWCharCallbackI gLFWCharCallbackI) {
            super(l2);
            this.delegate = gLFWCharCallbackI;
        }

        @Override
        public void invoke(long l2, int n2) {
            this.delegate.invoke(l2, n2);
        }
    }
}

