/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowContentScaleCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowContentScaleCallback
extends Callback
implements GLFWWindowContentScaleCallbackI {
    public static GLFWWindowContentScaleCallback create(long l2) {
        GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI = (GLFWWindowContentScaleCallbackI)Callback.get(l2);
        return gLFWWindowContentScaleCallbackI instanceof GLFWWindowContentScaleCallback ? (GLFWWindowContentScaleCallback)gLFWWindowContentScaleCallbackI : new Container(l2, gLFWWindowContentScaleCallbackI);
    }

    @Nullable
    public static GLFWWindowContentScaleCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowContentScaleCallback.create(l2);
    }

    public static GLFWWindowContentScaleCallback create(GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI) {
        return gLFWWindowContentScaleCallbackI instanceof GLFWWindowContentScaleCallback ? (GLFWWindowContentScaleCallback)gLFWWindowContentScaleCallbackI : new Container(gLFWWindowContentScaleCallbackI.address(), gLFWWindowContentScaleCallbackI);
    }

    protected GLFWWindowContentScaleCallback() {
        super(CIF);
    }

    GLFWWindowContentScaleCallback(long l2) {
        super(l2);
    }

    public GLFWWindowContentScaleCallback set(long l2) {
        GLFW.glfwSetWindowContentScaleCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowContentScaleCallback {
        private final GLFWWindowContentScaleCallbackI delegate;

        Container(long l2, GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI) {
            super(l2);
            this.delegate = gLFWWindowContentScaleCallbackI;
        }

        @Override
        public void invoke(long l2, float f2, float f3) {
            this.delegate.invoke(l2, f2, f3);
        }
    }
}

