/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWWindowPosCallback
extends Callback
implements GLFWWindowPosCallbackI {
    public static GLFWWindowPosCallback create(long l2) {
        GLFWWindowPosCallbackI gLFWWindowPosCallbackI = (GLFWWindowPosCallbackI)Callback.get(l2);
        return gLFWWindowPosCallbackI instanceof GLFWWindowPosCallback ? (GLFWWindowPosCallback)gLFWWindowPosCallbackI : new Container(l2, gLFWWindowPosCallbackI);
    }

    @Nullable
    public static GLFWWindowPosCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWWindowPosCallback.create(l2);
    }

    public static GLFWWindowPosCallback create(GLFWWindowPosCallbackI gLFWWindowPosCallbackI) {
        return gLFWWindowPosCallbackI instanceof GLFWWindowPosCallback ? (GLFWWindowPosCallback)gLFWWindowPosCallbackI : new Container(gLFWWindowPosCallbackI.address(), gLFWWindowPosCallbackI);
    }

    protected GLFWWindowPosCallback() {
        super(CIF);
    }

    GLFWWindowPosCallback(long l2) {
        super(l2);
    }

    public GLFWWindowPosCallback set(long l2) {
        GLFW.glfwSetWindowPosCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWWindowPosCallback {
        private final GLFWWindowPosCallbackI delegate;

        Container(long l2, GLFWWindowPosCallbackI gLFWWindowPosCallbackI) {
            super(l2);
            this.delegate = gLFWWindowPosCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, int n3) {
            this.delegate.invoke(l2, n2, n3);
        }
    }
}

