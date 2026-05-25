/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.NativeType;

public class ARBCLEvent {
    public static final int GL_SYNC_CL_EVENT_ARB = 33344;
    public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;

    protected ARBCLEvent() {
        throw new UnsupportedOperationException();
    }

    public static native long nglCreateSyncFromCLeventARB(long var0, long var2, int var4);

    @NativeType(value="GLsync")
    public static long glCreateSyncFromCLeventARB(@NativeType(value="cl_context") long l2, @NativeType(value="cl_event") long l3, @NativeType(value="GLbitfield") int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return ARBCLEvent.nglCreateSyncFromCLeventARB(l2, l3, n2);
    }

    static {
        GL.initialize();
    }
}

