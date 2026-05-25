/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.stb;

import javax.annotation.Nullable;
import org.lwjgl.stb.STBIEOFCallbackI;
import org.lwjgl.system.Callback;

public abstract class STBIEOFCallback
extends Callback
implements STBIEOFCallbackI {
    public static STBIEOFCallback create(long l2) {
        STBIEOFCallbackI sTBIEOFCallbackI = (STBIEOFCallbackI)Callback.get(l2);
        return sTBIEOFCallbackI instanceof STBIEOFCallback ? (STBIEOFCallback)sTBIEOFCallbackI : new Container(l2, sTBIEOFCallbackI);
    }

    @Nullable
    public static STBIEOFCallback createSafe(long l2) {
        return l2 == 0L ? null : STBIEOFCallback.create(l2);
    }

    public static STBIEOFCallback create(STBIEOFCallbackI sTBIEOFCallbackI) {
        return sTBIEOFCallbackI instanceof STBIEOFCallback ? (STBIEOFCallback)sTBIEOFCallbackI : new Container(sTBIEOFCallbackI.address(), sTBIEOFCallbackI);
    }

    protected STBIEOFCallback() {
        super(CIF);
    }

    STBIEOFCallback(long l2) {
        super(l2);
    }

    static final class Container
    extends STBIEOFCallback {
        private final STBIEOFCallbackI delegate;

        Container(long l2, STBIEOFCallbackI sTBIEOFCallbackI) {
            super(l2);
            this.delegate = sTBIEOFCallbackI;
        }

        @Override
        public int invoke(long l2) {
            return this.delegate.invoke(l2);
        }
    }
}

