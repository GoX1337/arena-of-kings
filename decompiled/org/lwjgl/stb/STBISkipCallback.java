/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import javax.annotation.Nullable;
import org.lwjgl.stb.STBISkipCallbackI;
import org.lwjgl.system.Callback;

public abstract class STBISkipCallback
extends Callback
implements STBISkipCallbackI {
    public static STBISkipCallback create(long l2) {
        STBISkipCallbackI sTBISkipCallbackI = (STBISkipCallbackI)Callback.get(l2);
        return sTBISkipCallbackI instanceof STBISkipCallback ? (STBISkipCallback)sTBISkipCallbackI : new Container(l2, sTBISkipCallbackI);
    }

    @Nullable
    public static STBISkipCallback createSafe(long l2) {
        return l2 == 0L ? null : STBISkipCallback.create(l2);
    }

    public static STBISkipCallback create(STBISkipCallbackI sTBISkipCallbackI) {
        return sTBISkipCallbackI instanceof STBISkipCallback ? (STBISkipCallback)sTBISkipCallbackI : new Container(sTBISkipCallbackI.address(), sTBISkipCallbackI);
    }

    protected STBISkipCallback() {
        super(CIF);
    }

    STBISkipCallback(long l2) {
        super(l2);
    }

    static final class Container
    extends STBISkipCallback {
        private final STBISkipCallbackI delegate;

        Container(long l2, STBISkipCallbackI sTBISkipCallbackI) {
            super(l2);
            this.delegate = sTBISkipCallbackI;
        }

        @Override
        public void invoke(long l2, int n2) {
            this.delegate.invoke(l2, n2);
        }
    }
}

