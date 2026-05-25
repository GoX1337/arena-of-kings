/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWJoystickCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWJoystickCallback
extends Callback
implements GLFWJoystickCallbackI {
    public static GLFWJoystickCallback create(long l2) {
        GLFWJoystickCallbackI gLFWJoystickCallbackI = (GLFWJoystickCallbackI)Callback.get(l2);
        return gLFWJoystickCallbackI instanceof GLFWJoystickCallback ? (GLFWJoystickCallback)gLFWJoystickCallbackI : new Container(l2, gLFWJoystickCallbackI);
    }

    @Nullable
    public static GLFWJoystickCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWJoystickCallback.create(l2);
    }

    public static GLFWJoystickCallback create(GLFWJoystickCallbackI gLFWJoystickCallbackI) {
        return gLFWJoystickCallbackI instanceof GLFWJoystickCallback ? (GLFWJoystickCallback)gLFWJoystickCallbackI : new Container(gLFWJoystickCallbackI.address(), gLFWJoystickCallbackI);
    }

    protected GLFWJoystickCallback() {
        super(CIF);
    }

    GLFWJoystickCallback(long l2) {
        super(l2);
    }

    public GLFWJoystickCallback set() {
        GLFW.glfwSetJoystickCallback(this);
        return this;
    }

    static final class Container
    extends GLFWJoystickCallback {
        private final GLFWJoystickCallbackI delegate;

        Container(long l2, GLFWJoystickCallbackI gLFWJoystickCallbackI) {
            super(l2);
            this.delegate = gLFWJoystickCallbackI;
        }

        @Override
        public void invoke(int n2, int n3) {
            this.delegate.invoke(n2, n3);
        }
    }
}

