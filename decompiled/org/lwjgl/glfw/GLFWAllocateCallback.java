/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFWAllocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWAllocateCallback
extends Callback
implements GLFWAllocateCallbackI {
    public static GLFWAllocateCallback create(long l2) {
        GLFWAllocateCallbackI gLFWAllocateCallbackI = (GLFWAllocateCallbackI)Callback.get(l2);
        return gLFWAllocateCallbackI instanceof GLFWAllocateCallback ? (GLFWAllocateCallback)gLFWAllocateCallbackI : new Container(l2, gLFWAllocateCallbackI);
    }

    @Nullable
    public static GLFWAllocateCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWAllocateCallback.create(l2);
    }

    public static GLFWAllocateCallback create(GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        return gLFWAllocateCallbackI instanceof GLFWAllocateCallback ? (GLFWAllocateCallback)gLFWAllocateCallbackI : new Container(gLFWAllocateCallbackI.address(), gLFWAllocateCallbackI);
    }

    protected GLFWAllocateCallback() {
        super(CIF);
    }

    GLFWAllocateCallback(long l2) {
        super(l2);
    }

    static final class Container
    extends GLFWAllocateCallback {
        private final GLFWAllocateCallbackI delegate;

        Container(long l2, GLFWAllocateCallbackI gLFWAllocateCallbackI) {
            super(l2);
            this.delegate = gLFWAllocateCallbackI;
        }

        @Override
        public long invoke(long l2, long l3) {
            return this.delegate.invoke(l2, l3);
        }
    }
}

