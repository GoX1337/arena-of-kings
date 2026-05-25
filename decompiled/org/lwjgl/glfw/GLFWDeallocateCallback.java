/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFWDeallocateCallbackI;
import org.lwjgl.system.Callback;

public abstract class GLFWDeallocateCallback
extends Callback
implements GLFWDeallocateCallbackI {
    public static GLFWDeallocateCallback create(long l2) {
        GLFWDeallocateCallbackI gLFWDeallocateCallbackI = (GLFWDeallocateCallbackI)Callback.get(l2);
        return gLFWDeallocateCallbackI instanceof GLFWDeallocateCallback ? (GLFWDeallocateCallback)gLFWDeallocateCallbackI : new Container(l2, gLFWDeallocateCallbackI);
    }

    @Nullable
    public static GLFWDeallocateCallback createSafe(long l2) {
        return l2 == 0L ? null : GLFWDeallocateCallback.create(l2);
    }

    public static GLFWDeallocateCallback create(GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        return gLFWDeallocateCallbackI instanceof GLFWDeallocateCallback ? (GLFWDeallocateCallback)gLFWDeallocateCallbackI : new Container(gLFWDeallocateCallbackI.address(), gLFWDeallocateCallbackI);
    }

    protected GLFWDeallocateCallback() {
        super(CIF);
    }

    GLFWDeallocateCallback(long l2) {
        super(l2);
    }

    static final class Container
    extends GLFWDeallocateCallback {
        private final GLFWDeallocateCallbackI delegate;

        Container(long l2, GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
            super(l2);
            this.delegate = gLFWDeallocateCallbackI;
        }

        @Override
        public void invoke(long l2, long l3) {
            this.delegate.invoke(l2, l3);
        }
    }
}

