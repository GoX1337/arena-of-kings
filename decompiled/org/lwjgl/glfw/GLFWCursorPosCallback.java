/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWCursorPosCallback
extends Callback
implements GLFWCursorPosCallbackI {
    public static GLFWCursorPosCallback create(long l2) {
        GLFWCursorPosCallbackI gLFWCursorPosCallbackI = (GLFWCursorPosCallbackI)Callback.get(l2);
        return gLFWCursorPosCallbackI instanceof GLFWCursorPosCallback ? (GLFWCursorPosCallback)gLFWCursorPosCallbackI : new Container(l2, gLFWCursorPosCallbackI);
    }

    @Nullable
    public static GLFWCursorPosCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWCursorPosCallback.create(l2);
    }

    public static GLFWCursorPosCallback create(GLFWCursorPosCallbackI gLFWCursorPosCallbackI) {
        return gLFWCursorPosCallbackI instanceof GLFWCursorPosCallback ? (GLFWCursorPosCallback)gLFWCursorPosCallbackI : new Container(gLFWCursorPosCallbackI.address(), gLFWCursorPosCallbackI);
    }

    public GLFWCursorPosCallback() {
        super(CIF);
    }

    GLFWCursorPosCallback(long l2) {
        super(l2);
    }

    public GLFWCursorPosCallback set(long l2) {
        GLFW.glfwSetCursorPosCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWCursorPosCallback {
        private final GLFWCursorPosCallbackI delegate;

        Container(long l2, GLFWCursorPosCallbackI gLFWCursorPosCallbackI) {
            super(l2);
            this.delegate = gLFWCursorPosCallbackI;
        }

        @Override
        public void invoke(long l2, double d2, double d3) {
            this.delegate.invoke(l2, d2, d3);
        }
    }
}

