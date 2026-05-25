/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.stb.STBIWriteCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class STBIWriteCallback
extends Callback
implements STBIWriteCallbackI {
    public static STBIWriteCallback create(long l2) {
        STBIWriteCallbackI sTBIWriteCallbackI = (STBIWriteCallbackI)Callback.get(l2);
        return sTBIWriteCallbackI instanceof STBIWriteCallback ? (STBIWriteCallback)sTBIWriteCallbackI : new Container(l2, sTBIWriteCallbackI);
    }

    @Nullable
    public static STBIWriteCallback createSafe(long l2) {
        return l2 == 0L ? null : STBIWriteCallback.create(l2);
    }

    public static STBIWriteCallback create(STBIWriteCallbackI sTBIWriteCallbackI) {
        return sTBIWriteCallbackI instanceof STBIWriteCallback ? (STBIWriteCallback)sTBIWriteCallbackI : new Container(sTBIWriteCallbackI.address(), sTBIWriteCallbackI);
    }

    protected STBIWriteCallback() {
        super(CIF);
    }

    STBIWriteCallback(long l2) {
        super(l2);
    }

    public static ByteBuffer getData(long l2, int n2) {
        return MemoryUtil.memByteBuffer(l2, n2);
    }

    static final class Container
    extends STBIWriteCallback {
        private final STBIWriteCallbackI delegate;

        Container(long l2, STBIWriteCallbackI sTBIWriteCallbackI) {
            super(l2);
            this.delegate = sTBIWriteCallbackI;
        }

        @Override
        public void invoke(long l2, long l3, int n2) {
            this.delegate.invoke(l2, l3, n2);
        }
    }
}

