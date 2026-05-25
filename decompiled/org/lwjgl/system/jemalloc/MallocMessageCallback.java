/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.jemalloc.MallocMessageCallbackI;

public abstract class MallocMessageCallback
extends Callback
implements MallocMessageCallbackI {
    public static MallocMessageCallback create(long l2) {
        MallocMessageCallbackI mallocMessageCallbackI = (MallocMessageCallbackI)Callback.get(l2);
        return mallocMessageCallbackI instanceof MallocMessageCallback ? (MallocMessageCallback)mallocMessageCallbackI : new Container(l2, mallocMessageCallbackI);
    }

    @Nullable
    public static MallocMessageCallback createSafe(long l2) {
        return l2 == 0L ? null : MallocMessageCallback.create(l2);
    }

    public static MallocMessageCallback create(MallocMessageCallbackI mallocMessageCallbackI) {
        return mallocMessageCallbackI instanceof MallocMessageCallback ? (MallocMessageCallback)mallocMessageCallbackI : new Container(mallocMessageCallbackI.address(), mallocMessageCallbackI);
    }

    protected MallocMessageCallback() {
        super(CIF);
    }

    MallocMessageCallback(long l2) {
        super(l2);
    }

    public static String getMessage(long l2) {
        return MemoryUtil.memASCII(l2);
    }

    static final class Container
    extends MallocMessageCallback {
        private final MallocMessageCallbackI delegate;

        Container(long l2, MallocMessageCallbackI mallocMessageCallbackI) {
            super(l2);
            this.delegate = mallocMessageCallbackI;
        }

        @Override
        public void invoke(long l2, long l3) {
            this.delegate.invoke(l2, l3);
        }
    }
}

