/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWDropCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;

public abstract class GLFWDropCallback
extends Callback
implements GLFWDropCallbackI {
    public static GLFWDropCallback create(long l2) {
        GLFWDropCallbackI gLFWDropCallbackI = (GLFWDropCallbackI)Callback.get(l2);
        return gLFWDropCallbackI instanceof GLFWDropCallback ? (GLFWDropCallback)gLFWDropCallbackI : new Container(l2, gLFWDropCallbackI);
    }

    @Nullable
    public static GLFWDropCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWDropCallback.create(l2);
    }

    public static GLFWDropCallback create(GLFWDropCallbackI gLFWDropCallbackI) {
        return gLFWDropCallbackI instanceof GLFWDropCallback ? (GLFWDropCallback)gLFWDropCallbackI : new Container(gLFWDropCallbackI.address(), gLFWDropCallbackI);
    }

    public GLFWDropCallback() {
        super(CIF);
    }

    GLFWDropCallback(long l2) {
        super(l2);
    }

    public static String getName(long l2, int n2) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l2 + (long)(Pointer.POINTER_SIZE * n2)));
    }

    public GLFWDropCallback set(long l2) {
        GLFW.glfwSetDropCallback(l2, this);
        return this;
    }

    static final class Container
    extends GLFWDropCallback {
        private final GLFWDropCallbackI delegate;

        Container(long l2, GLFWDropCallbackI gLFWDropCallbackI) {
            super(l2);
            this.delegate = gLFWDropCallbackI;
        }

        @Override
        public void invoke(long l2, int n2, long l3) {
            this.delegate.invoke(l2, n2, l3);
        }
    }
}

