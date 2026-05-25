/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.stb.STBIReadCallbackI;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class STBIReadCallback
extends Callback
implements STBIReadCallbackI {
    public static STBIReadCallback create(long l2) {
        STBIReadCallbackI sTBIReadCallbackI = (STBIReadCallbackI)Callback.get(l2);
        return sTBIReadCallbackI instanceof STBIReadCallback ? (STBIReadCallback)sTBIReadCallbackI : new Container(l2, sTBIReadCallbackI);
    }

    @Nullable
    public static STBIReadCallback createSafe(long l2) {
        return l2 == 0L ? null : STBIReadCallback.create(l2);
    }

    public static STBIReadCallback create(STBIReadCallbackI sTBIReadCallbackI) {
        return sTBIReadCallbackI instanceof STBIReadCallback ? (STBIReadCallback)sTBIReadCallbackI : new Container(sTBIReadCallbackI.address(), sTBIReadCallbackI);
    }

    protected STBIReadCallback() {
        super(CIF);
    }

    STBIReadCallback(long l2) {
        super(l2);
    }

    public static ByteBuffer getData(long l2, int n2) {
        return MemoryUtil.memByteBuffer(l2, n2);
    }

    static final class Container
    extends STBIReadCallback {
        private final STBIReadCallbackI delegate;

        Container(long l2, STBIReadCallbackI sTBIReadCallbackI) {
            super(l2);
            this.delegate = sTBIReadCallbackI;
        }

        @Override
        public int invoke(long l2, long l3, int n2) {
            return this.delegate.invoke(l2, l3, n2);
        }
    }
}

