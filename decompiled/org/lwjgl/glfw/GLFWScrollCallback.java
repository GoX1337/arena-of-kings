/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWScrollCallback
extends Callback
implements GLFWScrollCallbackI {
    public static GLFWScrollCallback create(long l2) {
        GLFWScrollCallbackI gLFWScrollCallbackI = (GLFWScrollCallbackI)Callback.get(l2);
        return gLFWScrollCallbackI instanceof GLFWScrollCallback ? (GLFWScrollCallback)gLFWScrollCallbackI : new Container(l2, gLFWScrollCallbackI);
    }

    @Nullable
    public static GLFWScrollCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWScrollCallback.create(l2);
    }

    public static GLFWScrollCallback create(GLFWScrollCallbackI gLFWScrollCallbackI) {
        return gLFWScrollCallbackI instanceof GLFWScrollCallback ? (GLFWScrollCallback)gLFWScrollCallbackI : new Container(gLFWScrollCallbackI.address(), gLFWScrollCallbackI);
    }

    public GLFWScrollCallback() {
        super(CIF);
    }

    GLFWScrollCallback(long l2) {
        super(l2);
    }

    public GLFWScrollCallback set(long l2) {
        GLFW.glfwSetScrollCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWScrollCallback {
        private final GLFWScrollCallbackI delegate;

        Container(long l2, GLFWScrollCallbackI gLFWScrollCallbackI) {
            super(l2);
            this.delegate = gLFWScrollCallbackI;
        }

        @Override
        public void invoke(long l2, double d2, double d3) {
            this.delegate.invoke(l2, d2, d3);
        }
    }
}

