/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMonitorCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWMonitorCallback
extends Callback
implements GLFWMonitorCallbackI {
    public static GLFWMonitorCallback create(long l2) {
        GLFWMonitorCallbackI gLFWMonitorCallbackI = (GLFWMonitorCallbackI)Callback.get(l2);
        return gLFWMonitorCallbackI instanceof GLFWMonitorCallback ? (GLFWMonitorCallback)gLFWMonitorCallbackI : new Container(l2, gLFWMonitorCallbackI);
    }

    @Nullable
    public static GLFWMonitorCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWMonitorCallback.create(l2);
    }

    public static GLFWMonitorCallback create(GLFWMonitorCallbackI gLFWMonitorCallbackI) {
        return gLFWMonitorCallbackI instanceof GLFWMonitorCallback ? (GLFWMonitorCallback)gLFWMonitorCallbackI : new Container(gLFWMonitorCallbackI.address(), gLFWMonitorCallbackI);
    }

    protected GLFWMonitorCallback() {
        super(CIF);
    }

    GLFWMonitorCallback(long l2) {
        super(l2);
    }

    public GLFWMonitorCallback set() {
        GLFW.glfwSetMonitorCallback(this);
        return this;
    }

    static final class Container
    extends GLFWMonitorCallback {
        private final GLFWMonitorCallbackI delegate;

        Container(long l2, GLFWMonitorCallbackI gLFWMonitorCallbackI) {
            super(l2);
            this.delegate = gLFWMonitorCallbackI;
        }

        @Override
        public void invoke(long l2, int n2) {
            this.delegate.invoke(l2, n2);
        }
    }
}

